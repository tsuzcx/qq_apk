package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.a.x;
import com.tencent.filter.h;
import com.tencent.filter.m.k;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.face.FaceStatusChecker;
import com.tencent.ttpic.factory.FabbyFilterFactory;
import com.tencent.ttpic.filter.ActFilters;
import com.tencent.ttpic.filter.CrazyFaceFilters;
import com.tencent.ttpic.filter.CustomVertexFilter;
import com.tencent.ttpic.filter.CustomVideoFilter;
import com.tencent.ttpic.filter.DoodleFilter;
import com.tencent.ttpic.filter.FabbyFilters;
import com.tencent.ttpic.filter.FabbyMvFilter;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.filter.FaceCopyFilter;
import com.tencent.ttpic.filter.FaceCropFilter;
import com.tencent.ttpic.filter.FaceMoveFilter;
import com.tencent.ttpic.filter.FaceOffByImageFilter;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.FastStickerFilter;
import com.tencent.ttpic.filter.GameFilter;
import com.tencent.ttpic.filter.HeadCropFilter;
import com.tencent.ttpic.filter.LipsCosFilter;
import com.tencent.ttpic.filter.MultiViewerFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.SimpleEffectVideoFilter;
import com.tencent.ttpic.filter.SnakeFaceFilter;
import com.tencent.ttpic.filter.StaticStickerFilter;
import com.tencent.ttpic.filter.SwitchFaceFilter;
import com.tencent.ttpic.filter.ThreeDimFilter;
import com.tencent.ttpic.filter.TransformFilter;
import com.tencent.ttpic.filter.TransformFilterNew;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoFilterUtil
{
  public static final float[] EMPTY_POSITIONS = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  public static final float[] EMPTY_POSITIONS_TRIANGLES = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  public static final int IMAGE_HEIGHT = 960;
  public static final int IMAGE_WIDTH = 720;
  public static final float[] ORIGIN_POSITION_COORDS = { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F };
  public static final float[] ORIGIN_TEX_COORDS = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  public static final float[] ORIGIN_TEX_COORDS_REVERSE = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final float[] ORIGIN_TEX_COORDS_TRIANGLES = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final double SCREEN_RATIO = 0.75D;
  public static final int SHOW_ONCE_TEX_COUNT = 2;
  public static final String SIMPLE_FRAGMENT_SHADER;
  public static final String SIMPLE_VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleVertexShader.dat");
  
  static
  {
    SIMPLE_FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleFragmentShader.dat");
  }
  
  public static boolean actionTriggered(List<PointF> paramList, List<StickerItem> paramList1, Set<Integer> paramSet)
  {
    if (paramList == null) {
      return false;
    }
    if ((paramList1 == null) || (paramList1.size() == 0) || (paramSet == null)) {
      return true;
    }
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (StickerItem)paramList.next();
      if ((paramList1 != null) && (paramSet.contains(Integer.valueOf(paramList1.triggerType)))) {
        return true;
      }
    }
    return false;
  }
  
  public static void addTransformFilter(List<VideoFilterBase> paramList1, List<VideoFilterBase> paramList2)
  {
    paramList2.addAll(paramList1);
  }
  
  public static boolean canUseBlendMode(VideoFilterBase paramVideoFilterBase)
  {
    if (paramVideoFilterBase == null) {}
    do
    {
      do
      {
        return false;
        if (!(paramVideoFilterBase instanceof NormalVideoFilter)) {
          break;
        }
      } while ((!((NormalVideoFilter)paramVideoFilterBase).canUseBlendMode()) && (!VideoModule.es_GL_EXT_shader_framebuffer_fetch));
      return true;
      if (((paramVideoFilterBase instanceof FaceOffByImageFilter)) || ((paramVideoFilterBase instanceof ThreeDimFilter)) || ((paramVideoFilterBase instanceof ARParticleFilter)) || ((paramVideoFilterBase instanceof HeadCropFilter))) {
        return true;
      }
    } while ((!(paramVideoFilterBase instanceof FaceOffFilter)) || ((!((FaceOffFilter)paramVideoFilterBase).canUseBlendMode()) && (!VideoModule.es_GL_EXT_shader_framebuffer_fetch)));
    return true;
  }
  
  private static ARParticleFilter createARParticleFilter(VideoMaterial paramVideoMaterial)
  {
    ARParticleFilter localARParticleFilter = null;
    if (VideoMaterialUtil.isARMaterial(paramVideoMaterial)) {
      localARParticleFilter = new ARParticleFilter(paramVideoMaterial.getArParticleList(), paramVideoMaterial.getDataPath());
    }
    return localARParticleFilter;
  }
  
  private static ActFilters createActFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value)
    {
      localObject1 = localObject2;
      if (paramVideoMaterial.getFaceExpression() != null) {
        localObject1 = new ActFilters(paramVideoMaterial.getFaceExpression(), paramVideoMaterial.getDataPath());
      }
    }
    return localObject1;
  }
  
  private static CustomVideoFilter createCustomEffectVideoFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject2 = VideoMaterialUtil.loadVideoCustomEffectFilterVertexShader(paramVideoMaterial.getDataPath());
    String str = VideoMaterialUtil.loadVideoCustomEffectFilterFragmentShader(paramVideoMaterial.getDataPath());
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = VideoFilterFactory.VERTEX_SHADER_COMMON;
    }
    localObject2 = str;
    if (TextUtils.isEmpty(str)) {
      localObject2 = VideoFilterFactory.FRAGMENT_SHADER_IMAGE;
    }
    return new CustomVideoFilter((String)localObject1, (String)localObject2, paramVideoMaterial.getResourceList(), getCustomFilterTriggerType(paramVideoMaterial.getItemList()), paramVideoMaterial.getDataPath());
  }
  
  private static CustomVertexFilter createCustomVertexFilter(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value)
    {
      Object localObject2 = VideoMaterialUtil.loadVertexShader(paramVideoMaterial.getDataPath());
      String str = VideoMaterialUtil.loadFragmentShader(paramVideoMaterial.getDataPath());
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = SIMPLE_VERTEX_SHADER;
      }
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = SIMPLE_FRAGMENT_SHADER;
      }
      if (!VideoUtil.isEmpty(paramVideoMaterial.getItemList())) {
        return new CustomVertexFilter((String)localObject1, (String)localObject2);
      }
    }
    return null;
  }
  
  private static CustomVideoFilter createCustomVideoFilter(VideoMaterial paramVideoMaterial)
  {
    String str;
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value))
    {
      localObject2 = VideoMaterialUtil.loadVertexShader(paramVideoMaterial.getDataPath());
      str = VideoMaterialUtil.loadFragmentShader(paramVideoMaterial.getDataPath());
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty(str))) {}
    }
    else
    {
      return null;
    }
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = VideoFilterFactory.VERTEX_SHADER_COMMON;
    }
    Object localObject2 = str;
    if (TextUtils.isEmpty(str)) {
      localObject2 = VideoFilterFactory.FRAGMENT_SHADER_IMAGE;
    }
    return new CustomVideoFilter((String)localObject1, (String)localObject2, paramVideoMaterial.getResourceList(), getCustomFilterTriggerType(paramVideoMaterial.getItemList()), paramVideoMaterial.getDataPath());
  }
  
  private static VideoFilterBase createDoodleFilter(VideoMaterial paramVideoMaterial)
  {
    DoodleFilter localDoodleFilter = null;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value) {
      localDoodleFilter = new DoodleFilter();
    }
    return localDoodleFilter;
  }
  
  private static VideoFilterBase createEffectFilter(VideoMaterial paramVideoMaterial)
  {
    VideoFilterEffect localVideoFilterEffect;
    if (paramVideoMaterial != null)
    {
      localVideoFilterEffect = paramVideoMaterial.getVideoFilterEffect();
      if (localVideoFilterEffect == null) {}
    }
    switch (localVideoFilterEffect.type)
    {
    default: 
      return null;
    case 1: 
      return createSimpleEffectVideoFilter(paramVideoMaterial);
    }
    return createCustomEffectVideoFilter(paramVideoMaterial);
  }
  
  private static FabbyFilters createFabbyMvFilterList(VideoMaterial paramVideoMaterial)
  {
    Object localObject1 = null;
    Object localObject2;
    FabbyMvFilter localFabbyMvFilter;
    if (paramVideoMaterial.getFabbyParts() != null)
    {
      localObject1 = new ArrayList();
      Iterator localIterator = paramVideoMaterial.getFabbyParts().getParts().iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (FabbyMvPart)localIterator.next();
        localFabbyMvFilter = new FabbyMvFilter();
        if (((FabbyMvPart)localObject2).bgItem != null) {
          localFabbyMvFilter.bgFilter = ((StaticStickerFilter)VideoFilterFactory.createFilter(((FabbyMvPart)localObject2).bgItem, paramVideoMaterial.getDataPath()));
        }
        if (((FabbyMvPart)localObject2).fgItem != null) {
          localFabbyMvFilter.fgFilter = ((StaticStickerFilter)VideoFilterFactory.createFilter(((FabbyMvPart)localObject2).fgItem, paramVideoMaterial.getDataPath()));
        }
        if (((FabbyMvPart)localObject2).coverItem != null) {
          localFabbyMvFilter.coverFilter = ((StaticStickerFilter)VideoFilterFactory.createFilter(((FabbyMvPart)localObject2).coverItem, paramVideoMaterial.getDataPath()));
        }
        if (((FabbyMvPart)localObject2).filterType == 1) {
          localFabbyMvFilter.mEffectFilter = FabbyFilterFactory.createFilter(((FabbyMvPart)localObject2).filterId);
        }
      }
    }
    label165:
    label186:
    label368:
    label369:
    for (;;)
    {
      localFabbyMvFilter.mvPart = ((FabbyMvPart)localObject2);
      localObject2 = ((FabbyMvPart)localObject2).gridSettingMap.iterator();
      int i = 0;
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Pair)((Iterator)localObject2).next();
        if (((GridSettingModel)((Pair)localObject3).second).canvasRectList.size() <= i) {
          break label368;
        }
        i = ((GridSettingModel)((Pair)localObject3).second).canvasRectList.size();
      }
      for (;;)
      {
        break label186;
        if (((FabbyMvPart)localObject2).filterType != 2) {
          break label369;
        }
        localFabbyMvFilter.mEffectFilter = new x();
        localObject3 = VideoBitmapUtil.decodeSampledBitmapFromFile(paramVideoMaterial.getDataPath() + File.separator + ((FabbyMvPart)localObject2).lutFile, 1);
        localFabbyMvFilter.mEffectFilter.addParam(new m.k("inputImageTexture2", (Bitmap)localObject3, 33986, true));
        break label165;
        ((List)localObject1).add(localFabbyMvFilter);
        break;
        localObject1 = new FabbyFilters((List)localObject1, paramVideoMaterial.getDataPath(), paramVideoMaterial.getFabbyParts().getAudioFile());
        return localObject1;
      }
    }
  }
  
  private static VideoFilterBase createFaceCopyFilter(VideoMaterial paramVideoMaterial)
  {
    FaceCopyFilter localFaceCopyFilter = null;
    if (VideoMaterialUtil.isFaceCopyMaterial(paramVideoMaterial)) {
      localFaceCopyFilter = new FaceCopyFilter();
    }
    return localFaceCopyFilter;
  }
  
  private static FaceCropFilter createFaceCropFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial != null)
    {
      localObject1 = localObject2;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) {
        localObject1 = new FaceCropFilter(paramVideoMaterial);
      }
    }
    return localObject1;
  }
  
  private static List<VideoFilterBase> createFaceOffFilter(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getFaceOffItemList();
    if (localList == null) {
      return localArrayList;
    }
    int i = 0;
    if (i < localList.size())
    {
      Object localObject1 = (FaceItem)localList.get(i);
      if (paramVideoMaterial.getFaceoffType() == VideoMaterialUtil.FACE_OFF_TYPE.BY_IMAGE.value) {}
      FaceOffFilter localFaceOffFilter;
      for (localObject1 = new FaceOffByImageFilter((FaceItem)localObject1);; localObject1 = localFaceOffFilter)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        localFaceOffFilter = new FaceOffFilter((FaceItem)localObject1, paramVideoMaterial.getDataPath());
        Object localObject2 = VideoMaterialUtil.loadVertexShader(paramVideoMaterial.getDataPath());
        String str = VideoMaterialUtil.loadFragmentShader(paramVideoMaterial.getDataPath());
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty(str)))
        {
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = FaceOffFilter.VERTEX_SHADER;
          }
          localObject2 = str;
          if (TextUtils.isEmpty(str)) {
            localObject2 = FaceOffFilter.FRAGMENT_SHADER;
          }
          localFaceOffFilter.updateFilterShader((String)localObject1, (String)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private static VideoFilterBase createFaceSwitchFilter(VideoMaterial paramVideoMaterial)
  {
    SwitchFaceFilter localSwitchFaceFilter = null;
    if (VideoMaterialUtil.isFaceSwitchMaterial(paramVideoMaterial)) {
      localSwitchFaceFilter = new SwitchFaceFilter();
    }
    return localSwitchFaceFilter;
  }
  
  private static FastStickerFilter createFastStickerFilter(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial.getItemList() != null)
    {
      if (!VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial)) {
        return null;
      }
      FastStickerFilter localFastStickerFilter = new FastStickerFilter();
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if ((!VideoMaterialUtil.isGestureItem(localStickerItem)) && (VideoMaterialUtil.canStickerItemUseFastRender(localStickerItem))) {
          localFastStickerFilter.addSticker(localStickerItem, paramVideoMaterial.getDataPath());
        }
      }
      if (localFastStickerFilter.getStickerListSize() > 0) {
        return localFastStickerFilter;
      }
    }
    return null;
  }
  
  public static VideoFilterList createFilters(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return null;
    }
    Object localObject = createCustomVideoFilter(paramVideoMaterial);
    CustomVertexFilter localCustomVertexFilter = createCustomVertexFilter(paramVideoMaterial);
    SnakeFaceFilter localSnakeFaceFilter = createSnakeFaceFilter(paramVideoMaterial);
    List localList2 = createFaceOffFilter(paramVideoMaterial);
    List localList3 = createTransformFilter(paramVideoMaterial);
    VideoFilterBase localVideoFilterBase1 = createFaceSwitchFilter(paramVideoMaterial);
    VideoFilterBase localVideoFilterBase2 = createFaceCopyFilter(paramVideoMaterial);
    VideoFilterBase localVideoFilterBase3 = createDoodleFilter(paramVideoMaterial);
    List localList4 = createThreeDimFilter(paramVideoMaterial);
    FaceCropFilter localFaceCropFilter = createFaceCropFilter(paramVideoMaterial);
    HeadCropFilter localHeadCropFilter = createHeadCropFilter(paramVideoMaterial);
    List localList5 = createHeadCropFilterList(paramVideoMaterial);
    List localList6 = createNormalVideoFilterList(paramVideoMaterial);
    List localList7 = createGestureVideoFilterList(paramVideoMaterial);
    FabbyFilters localFabbyFilters = createFabbyMvFilterList(paramVideoMaterial);
    LipsCosFilter localLipsCosFilter = createLipsCosFilter(paramVideoMaterial);
    List localList1 = createMultiViewerFilters(paramVideoMaterial);
    GameFilter localGameFilter = createGameFilter(paramVideoMaterial);
    if (localObject != null) {
      ((CustomVideoFilter)localObject).setNormalFilters(localList6);
    }
    VideoFilterList localVideoFilterList = new VideoFilterList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.NORMAL.value)
    {
      if (localList2 != null) {
        localArrayList1.addAll(localList2);
      }
      localArrayList1.addAll(localList6);
      if (localList7 != null) {
        localArrayList2.addAll(localList7);
      }
      localObject = createEffectFilter(paramVideoMaterial);
      if (localObject != null)
      {
        localVideoFilterList.setVideoEffectFilter((VideoFilterBase)localObject);
        localVideoFilterList.setVideoEffectOrder(paramVideoMaterial.getVideoFilterEffect().order);
      }
      localVideoFilterList.setFabbyMvFilters(localFabbyFilters);
      localVideoFilterList.setFilters(localArrayList1);
      localVideoFilterList.setFastStickerFilter(createFastStickerFilter(paramVideoMaterial));
      localVideoFilterList.setGestureFilters(localArrayList2);
      localVideoFilterList.setGameFilter(localGameFilter);
      localVideoFilterList.setMultiViewerFilters(localList1);
      if ((localArrayList2.isEmpty()) && (!needDetectGesture(paramVideoMaterial))) {
        break label1286;
      }
    }
    label1286:
    for (boolean bool = true;; bool = false)
    {
      localVideoFilterList.setNeedDetectGesture(bool);
      localVideoFilterList.setMaterial(paramVideoMaterial);
      return localVideoFilterList;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value)
      {
        localArrayList1.addAll(localList6);
        if (localList7 != null) {
          localArrayList2.addAll(localList7);
        }
        if (localObject == null) {
          break;
        }
        localArrayList1.add(localObject);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value)
      {
        if (localObject != null) {
          localArrayList1.add(localObject);
        }
        localArrayList1.addAll(localList6);
        if (localList7 == null) {
          break;
        }
        localArrayList2.addAll(localList7);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value)
      {
        localArrayList1.add(localSnakeFaceFilter);
        localArrayList1.addAll(localList6);
        if (localList7 == null) {
          break;
        }
        localArrayList2.addAll(localList7);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value)
      {
        localArrayList1.add(localCustomVertexFilter);
        localArrayList1.addAll(localList6);
        if (localList7 == null) {
          break;
        }
        localArrayList2.addAll(localList7);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value)
      {
        if (localList2 != null) {
          localArrayList1.addAll(localList2);
        }
        localArrayList1.addAll(localList6);
        if (localList7 != null) {
          localArrayList2.addAll(localList7);
        }
        if (localLipsCosFilter == null) {
          break;
        }
        localVideoFilterList.setLipsCosFilter(localLipsCosFilter);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value)
      {
        if (paramVideoMaterial.getOrderMode() <= 1)
        {
          if (localList3 != null) {
            addTransformFilter(localList3, localArrayList1);
          }
          localArrayList1.addAll(localList6);
          if (localList7 == null) {
            break;
          }
          localArrayList2.addAll(localList7);
          break;
        }
        if (paramVideoMaterial.getOrderMode() != 2) {
          break;
        }
        localArrayList1.addAll(localList6);
        if (localList7 != null) {
          localArrayList2.addAll(localList7);
        }
        if (localList3 == null) {
          break;
        }
        addTransformFilter(localList3, localArrayList1);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value)
      {
        if (paramVideoMaterial.getOrderMode() <= 1)
        {
          if (localList2 != null) {
            localArrayList1.addAll(localList2);
          }
          if (localList3 != null) {
            addTransformFilter(localList3, localArrayList1);
          }
          localArrayList1.addAll(localList6);
          if (localList7 == null) {
            break;
          }
          localArrayList2.addAll(localList7);
          break;
        }
        if (paramVideoMaterial.getOrderMode() != 2) {
          break;
        }
        localArrayList1.addAll(localList6);
        if (localList7 != null) {
          localArrayList2.addAll(localList7);
        }
        if (localList2 != null) {
          localArrayList1.addAll(localList2);
        }
        if (localList3 == null) {
          break;
        }
        addTransformFilter(localList3, localArrayList1);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value)
      {
        localArrayList1.addAll(localList4);
        break;
      }
      if (VideoMaterialUtil.isFaceCopyMaterial(paramVideoMaterial))
      {
        localArrayList1.add(localVideoFilterBase2);
        break;
      }
      if (VideoMaterialUtil.isFaceSwitchMaterial(paramVideoMaterial))
      {
        localArrayList1.add(localVideoFilterBase1);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value)
      {
        localArrayList1.add(localVideoFilterBase3);
        break;
      }
      if (VideoMaterialUtil.isFaceMorphingMaterial(paramVideoMaterial))
      {
        localVideoFilterList.setCrazyFaceFilters(new CrazyFaceFilters(paramVideoMaterial));
        localArrayList1.addAll(localList6);
        if (localList7 == null) {
          break;
        }
        localArrayList2.addAll(localList7);
        break;
      }
      if (VideoMaterialUtil.isARMaterial(paramVideoMaterial))
      {
        localVideoFilterList.setARParticleFilter(createARParticleFilter(paramVideoMaterial));
        if (localList6 != null) {
          localArrayList1.addAll(localList6);
        }
        if (localList7 == null) {
          break;
        }
        localArrayList2.addAll(localList7);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value)
      {
        localVideoFilterList.setActFilter(createActFilter(paramVideoMaterial));
        if (localList2 != null) {
          localArrayList1.addAll(localList2);
        }
        if (localList3 != null) {
          addTransformFilter(localList3, localArrayList1);
        }
        localArrayList1.addAll(localList6);
        if (localList7 == null) {
          break;
        }
        localArrayList2.addAll(localList7);
        break;
      }
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value)
      {
        if (localList2 != null) {
          localArrayList1.addAll(localList2);
        }
        if (localList3 != null) {
          localArrayList1.addAll(localList3);
        }
        localArrayList1.add(localFaceCropFilter);
        if (localList6 != null)
        {
          localArrayList1.addAll(localList6);
          localFaceCropFilter.setNormalFilters(localList6);
        }
        if (localList7 == null) {
          break;
        }
        localArrayList2.addAll(localList7);
        break;
      }
      if (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value) {
        break;
      }
      localVideoFilterList.setHeadCropFilter(localHeadCropFilter);
      localArrayList1.add(localHeadCropFilter);
      if (localList2 != null) {
        localArrayList1.addAll(localList2);
      }
      if (localList3 != null) {
        addTransformFilter(localList3, localArrayList1);
      }
      localArrayList1.addAll(localList6);
      localArrayList2.addAll(localList7);
      localVideoFilterList.setHeadCropItemFilters(localList5);
      break;
    }
  }
  
  private static GameFilter createGameFilter(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getGameParams() != null))
    {
      GameFilter localGameFilter = new GameFilter(paramVideoMaterial.getItemList3D(), paramVideoMaterial.getOrderMode(), paramVideoMaterial.getMaxFaceCount());
      localGameFilter.setGameParams(paramVideoMaterial.getGameParams(), paramVideoMaterial.getDataPath());
      return localGameFilter;
    }
    return null;
  }
  
  private static List<NormalVideoFilter> createGestureVideoFilterList(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if (VideoMaterialUtil.isGestureItem((StickerItem)localObject))
        {
          localObject = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static HeadCropFilter createHeadCropFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial != null)
    {
      localObject1 = localObject2;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value) {
        localObject1 = new HeadCropFilter();
      }
    }
    return localObject1;
  }
  
  private static List<VideoFilterBase> createHeadCropFilterList(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getHeadCropItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getHeadCropItemList().iterator();
      while (localIterator.hasNext())
      {
        NormalVideoFilter localNormalVideoFilter = VideoFilterFactory.createFilter((StickerItem)localIterator.next(), paramVideoMaterial.getDataPath());
        if (localNormalVideoFilter != null) {
          localArrayList.add(localNormalVideoFilter);
        }
      }
    }
    return localArrayList;
  }
  
  private static LipsCosFilter createLipsCosFilter(VideoMaterial paramVideoMaterial)
  {
    LipsCosFilter localLipsCosFilter = null;
    if (!TextUtils.isEmpty(paramVideoMaterial.getLipsLutPath()))
    {
      paramVideoMaterial = VideoBitmapUtil.decodeSampledBitmapFromFile(paramVideoMaterial.getDataPath() + File.separator + paramVideoMaterial.getLipsLutPath(), 1);
      localLipsCosFilter = new LipsCosFilter();
      localLipsCosFilter.setTypeAndLut(1, paramVideoMaterial);
    }
    return localLipsCosFilter;
  }
  
  private static List<MultiViewerFilter> createMultiViewerFilters(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList();
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext())
      {
        MultiViewerItem localMultiViewerItem = (MultiViewerItem)paramVideoMaterial.next();
        if (localMultiViewerItem.videoMaterial != null)
        {
          MultiViewerFilter localMultiViewerFilter = new MultiViewerFilter();
          localMultiViewerFilter.setVideoFilterList(createFilters(localMultiViewerItem.videoMaterial));
          localMultiViewerFilter.setActiveParts(localMultiViewerItem.activeParts);
          localMultiViewerFilter.setRenderId(localMultiViewerItem.renderId);
          if (!TextUtils.isEmpty(localMultiViewerItem.videoMaterial.getFilterId())) {
            localMultiViewerFilter.setEffectFilter(FabbyFilterFactory.createFilter(localMultiViewerItem.videoMaterial.getFilterId()));
          }
          localArrayList.add(localMultiViewerFilter);
        }
      }
    }
    return localArrayList;
  }
  
  private static List<NormalVideoFilter> createNormalVideoFilterList(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      boolean bool = VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial);
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if ((!VideoMaterialUtil.isGestureItem((StickerItem)localObject)) && ((!bool) || (!VideoMaterialUtil.canStickerItemUseFastRender((StickerItem)localObject))))
        {
          localObject = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static VideoFilterBase createSimpleEffectVideoFilter(VideoMaterial paramVideoMaterial)
  {
    return new SimpleEffectVideoFilter(paramVideoMaterial.getDataPath());
  }
  
  private static SnakeFaceFilter createSnakeFaceFilter(VideoMaterial paramVideoMaterial)
  {
    SnakeFaceFilter localSnakeFaceFilter = null;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value) {
      localSnakeFaceFilter = new SnakeFaceFilter();
    }
    return localSnakeFaceFilter;
  }
  
  private static List<VideoFilterBase> createThreeDimFilter(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value) && (paramVideoMaterial.getItemList() != null))
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new ThreeDimFilter((StickerItem)localIterator.next(), paramVideoMaterial.getDataPath()));
      }
    }
    return localArrayList;
  }
  
  private static List<VideoFilterBase> createTransformFilter(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value))
    {
      List localList = paramVideoMaterial.getFaceMeshItemList();
      if (!VideoUtil.isEmpty(localList))
      {
        int i = 0;
        while (i < localList.size())
        {
          localArrayList.add(new TransformFilterNew((FaceMeshItem)localList.get(i), paramVideoMaterial.getDataPath()));
          i += 1;
        }
      }
      if (VideoUtil.isEmpty(paramVideoMaterial.getDistortionItemList())) {
        break label173;
      }
      if (paramVideoMaterial.isUseMesh()) {
        localArrayList.add(new TransformFilter(paramVideoMaterial.getDistortionItemList(), paramVideoMaterial.getItemList()));
      }
    }
    label173:
    while (VideoUtil.isEmpty(paramVideoMaterial.getFaceMoveItemList())) {
      return localArrayList;
    }
    localArrayList.add(new FaceMoveFilter(paramVideoMaterial.getFaceMoveItemList(), paramVideoMaterial.getItemList(), paramVideoMaterial.getFaceMoveTriangles()));
    return localArrayList;
  }
  
  public static int get4DirectionAngle(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble > 3.141592653589793D) {
      d = paramDouble - 6.283185307179586D;
    }
    if ((d >= -0.7853981633974483D) && (d <= 0.7853981633974483D)) {
      return 0;
    }
    if ((d >= 0.7853981633974483D) && (d <= 2.356194490192345D)) {
      return 90;
    }
    if ((d >= -2.356194490192345D) && (d <= -0.7853981633974483D)) {
      return 270;
    }
    return 180;
  }
  
  public static double get8DirectionAngle(double paramDouble)
  {
    if ((paramDouble >= -0.3926990816987241D) && (paramDouble <= 0.3926990816987241D)) {
      return 0.0D;
    }
    if ((paramDouble >= 0.3926990816987241D) && (paramDouble <= 1.178097245096172D)) {
      return 0.7853981633974483D;
    }
    if ((paramDouble >= 1.178097245096172D) && (paramDouble <= 1.963495408493621D)) {
      return 1.570796326794897D;
    }
    if ((paramDouble >= 1.963495408493621D) && (paramDouble <= 2.748893571891069D)) {
      return 2.356194490192345D;
    }
    if ((paramDouble >= -1.178097245096172D) && (paramDouble <= -0.3926990816987241D)) {
      return -0.7853981633974483D;
    }
    if ((paramDouble >= -1.963495408493621D) && (paramDouble <= -1.178097245096172D)) {
      return -1.570796326794897D;
    }
    if ((paramDouble >= -2.748893571891069D) && (paramDouble <= -1.963495408493621D)) {
      return -2.356194490192345D;
    }
    return -3.141592653589793D;
  }
  
  private static VideoMaterialUtil.TRIGGER_TYPE getCustomFilterTriggerType(List<StickerItem> paramList)
  {
    if (VideoUtil.isEmpty(paramList)) {
      return VideoMaterialUtil.TRIGGER_TYPE.UNKNOW;
    }
    int i = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW.value;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)paramList.next();
      if (localStickerItem.triggerType <= i) {
        break label65;
      }
      i = localStickerItem.triggerType;
    }
    label65:
    for (;;)
    {
      break;
      return VideoMaterialUtil.getTriggerType(i);
    }
  }
  
  public static float getFaceStatus(FaceRangeStatus paramFaceRangeStatus, int paramInt, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    if (paramFaceRangeStatus == null) {}
    for (;;)
    {
      return -1.0F;
      VideoMaterialUtil.RANGE_TRIGGER_TYPE[] arrayOfRANGE_TRIGGER_TYPE = VideoMaterialUtil.RANGE_TRIGGER_TYPE.values();
      int j = arrayOfRANGE_TRIGGER_TYPE.length;
      int i = 0;
      while (i < j)
      {
        VideoMaterialUtil.RANGE_TRIGGER_TYPE localRANGE_TRIGGER_TYPE = arrayOfRANGE_TRIGGER_TYPE[i];
        if (localRANGE_TRIGGER_TYPE.value == paramInt) {
          return localRANGE_TRIGGER_TYPE.checker.getLevel(paramFaceRangeStatus, paramFeatureStatValueRange);
        }
        i += 1;
      }
    }
  }
  
  public static h getSecondLastFrame(h paramh)
  {
    h localh;
    if (FrameUtil.isValid(paramh))
    {
      localh = paramh;
      if (FrameUtil.isValid(paramh.bcD)) {}
    }
    else
    {
      paramh = null;
      return paramh;
    }
    for (;;)
    {
      paramh = localh;
      if (!FrameUtil.isValid(localh.bcD)) {
        break;
      }
      paramh = localh;
      if (!FrameUtil.isValid(localh.bcD.bcD)) {
        break;
      }
      localh = localh.bcD;
    }
  }
  
  public static List<VideoFilterBase> getSimpleNormalVideoFilter(List<VideoFilterBase> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if (canUseBlendMode(localVideoFilterBase)) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    return localArrayList;
  }
  
  public static boolean isStatusTriggered(FaceRangeStatus paramFaceRangeStatus, int paramInt, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    if (paramFaceRangeStatus == null) {}
    for (;;)
    {
      return false;
      VideoMaterialUtil.RANGE_TRIGGER_TYPE[] arrayOfRANGE_TRIGGER_TYPE = VideoMaterialUtil.RANGE_TRIGGER_TYPE.values();
      int j = arrayOfRANGE_TRIGGER_TYPE.length;
      int i = 0;
      while (i < j)
      {
        VideoMaterialUtil.RANGE_TRIGGER_TYPE localRANGE_TRIGGER_TYPE = arrayOfRANGE_TRIGGER_TYPE[i];
        if (localRANGE_TRIGGER_TYPE.value == paramInt) {
          return localRANGE_TRIGGER_TYPE.checker.isInRange(paramFaceRangeStatus, paramFeatureStatValueRange);
        }
        i += 1;
      }
    }
  }
  
  public static boolean maybeTransformFilter(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && (((paramVideoFilterBase instanceof TransformFilter)) || ((paramVideoFilterBase instanceof CustomVideoFilter)));
  }
  
  public static boolean needBlendMode(List<VideoFilterBase> paramList)
  {
    if (paramList == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((VideoFilterBase)paramList.next() instanceof NormalVideoFilter)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean needDepthBuffer(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && ((paramVideoFilterBase instanceof ThreeDimFilter));
  }
  
  private static boolean needDetectGesture(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      Object localObject2 = paramVideoMaterial.getItemList();
      Object localObject1 = paramVideoMaterial.getItemList3D();
      Object localObject3 = paramVideoMaterial.getHeadCropItemList();
      paramVideoMaterial = paramVideoMaterial.getFaceOffItemList();
      ArrayList localArrayList = new ArrayList();
      if (localObject2 != null) {
        localArrayList.addAll((Collection)localObject2);
      }
      if (localObject3 != null) {
        localArrayList.addAll((Collection)localObject3);
      }
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StickerItem)((Iterator)localObject2).next();
        if (((StickerItem)localObject3).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) {
          return true;
        }
        if (VideoMaterialUtil.isGestureTriggerItem((StickerItem)localObject3)) {
          return true;
        }
      }
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject2 = (FaceItem)paramVideoMaterial.next();
          if ((localObject2 != null) && (200 <= ((FaceItem)localObject2).triggerType) && (((FaceItem)localObject2).triggerType <= 211)) {
            return true;
          }
        }
      }
      if (localObject1 != null)
      {
        paramVideoMaterial = ((List)localObject1).iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject1 = (StickerItem3D)paramVideoMaterial.next();
          if (((StickerItem3D)localObject1).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) {
            return true;
          }
          if (VideoMaterialUtil.isGestureTriggerItem((StickerItem)localObject1)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean needRecordTouchPoint(VideoFilterList paramVideoFilterList)
  {
    return (paramVideoFilterList != null) && (paramVideoFilterList.getMaterial() != null) && (((paramVideoFilterList.getMaterial().getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value) && (VideoPreviewFaceOutlineDetector.getInstance().getFaceCount() > 0)) || (VideoMaterialUtil.isARMaterial(paramVideoFilterList.getMaterial())));
  }
  
  public static void setBlendMode(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      return;
    }
    GLES20.glDisable(3042);
  }
  
  public static void setRenderMode(BaseFilter paramBaseFilter, int paramInt)
  {
    while (paramBaseFilter != null)
    {
      paramBaseFilter.setRenderMode(paramInt);
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
  }
  
  public static void setRenderMode(VideoFilterBase paramVideoFilterBase, int paramInt)
  {
    if (paramVideoFilterBase != null) {
      paramVideoFilterBase.setRenderMode(paramInt);
    }
  }
  
  public static void setRenderMode(List<VideoFilterBase> paramList, int paramInt)
  {
    if (VideoUtil.isEmpty(paramList)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoFilterBase)paramList.next()).setRenderMode(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFilterUtil
 * JD-Core Version:    0.7.0.1
 */