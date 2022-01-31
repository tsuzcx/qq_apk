package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.a.ab;
import com.tencent.filter.h;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.face.FaceStatusChecker;
import com.tencent.ttpic.factory.FabbyFilterFactory;
import com.tencent.ttpic.filter.ActFilters;
import com.tencent.ttpic.filter.Audio3DFilter;
import com.tencent.ttpic.filter.CrazyFaceFilters;
import com.tencent.ttpic.filter.CustomVertexFilter;
import com.tencent.ttpic.filter.CustomVideoFilter;
import com.tencent.ttpic.filter.DoodleFilter;
import com.tencent.ttpic.filter.FabbyFilters;
import com.tencent.ttpic.filter.FabbyMvFilter;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.filter.FaceCropFilter;
import com.tencent.ttpic.filter.FaceMoveFilter;
import com.tencent.ttpic.filter.FaceOffByImageFilter;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.FacialFeatureFilter;
import com.tencent.ttpic.filter.FastStickerFilter;
import com.tencent.ttpic.filter.GameFilter;
import com.tencent.ttpic.filter.HeadCropFilter;
import com.tencent.ttpic.filter.LipsCosFilter;
import com.tencent.ttpic.filter.MultiViewerFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.ParticleXFilter;
import com.tencent.ttpic.filter.PhantomFilter;
import com.tencent.ttpic.filter.SimpleEffectVideoFilter;
import com.tencent.ttpic.filter.SnakeFaceFilter;
import com.tencent.ttpic.filter.StaticStickerFilter;
import com.tencent.ttpic.filter.ThreeDimFilter;
import com.tencent.ttpic.filter.TransformFilter;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.filter.VoiceTextFilter;
import com.tencent.ttpic.model.Audio2Text;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.ValueRange;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.particle.ParticleFilter;
import com.tencent.ttpic.particlesystemx.ParticleSystemX;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoFilterUtil
{
  public static final int IMAGE_HEIGHT = 960;
  public static final int IMAGE_WIDTH = 720;
  public static final double SCREEN_RATIO = 0.75D;
  public static final int SHOW_ONCE_TEX_COUNT = 2;
  public static final String SIMPLE_FRAGMENT_SHADER;
  public static final String SIMPLE_VERTEX_SHADER;
  
  static
  {
    AppMethodBeat.i(84037);
    SIMPLE_VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleVertexShader.dat");
    SIMPLE_FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleFragmentShader.dat");
    AppMethodBeat.o(84037);
  }
  
  public static boolean actionTriggered(List<PointF> paramList, List<StickerItem> paramList1, Set<Integer> paramSet)
  {
    AppMethodBeat.i(84026);
    if (paramList == null)
    {
      AppMethodBeat.o(84026);
      return false;
    }
    if ((paramList1 == null) || (paramList1.size() == 0) || (paramSet == null))
    {
      AppMethodBeat.o(84026);
      return true;
    }
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (StickerItem)paramList.next();
      if ((paramList1 != null) && (paramSet.contains(Integer.valueOf(paramList1.triggerType))))
      {
        AppMethodBeat.o(84026);
        return true;
      }
    }
    AppMethodBeat.o(84026);
    return false;
  }
  
  public static boolean canUseBlendMode(VideoFilterBase paramVideoFilterBase)
  {
    AppMethodBeat.i(84025);
    if (paramVideoFilterBase == null)
    {
      AppMethodBeat.o(84025);
      return false;
    }
    if ((paramVideoFilterBase instanceof NormalVideoFilter))
    {
      if ((((NormalVideoFilter)paramVideoFilterBase).canUseBlendMode()) || (VideoModule.es_GL_EXT_shader_framebuffer_fetch))
      {
        AppMethodBeat.o(84025);
        return true;
      }
      AppMethodBeat.o(84025);
      return false;
    }
    if (((paramVideoFilterBase instanceof FaceOffByImageFilter)) || ((paramVideoFilterBase instanceof ThreeDimFilter)) || ((paramVideoFilterBase instanceof ARParticleFilter)) || ((paramVideoFilterBase instanceof HeadCropFilter)))
    {
      AppMethodBeat.o(84025);
      return true;
    }
    if ((paramVideoFilterBase instanceof FaceOffFilter))
    {
      if ((((FaceOffFilter)paramVideoFilterBase).canUseBlendMode()) || (VideoModule.es_GL_EXT_shader_framebuffer_fetch))
      {
        AppMethodBeat.o(84025);
        return true;
      }
      AppMethodBeat.o(84025);
      return false;
    }
    if ((paramVideoFilterBase instanceof VoiceTextFilter))
    {
      AppMethodBeat.o(84025);
      return true;
    }
    if ((paramVideoFilterBase instanceof ParticleFilter))
    {
      AppMethodBeat.o(84025);
      return true;
    }
    AppMethodBeat.o(84025);
    return false;
  }
  
  private static ARParticleFilter createARParticleFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84015);
    ARParticleFilter localARParticleFilter = null;
    if (VideoMaterialUtil.isARMaterial(paramVideoMaterial)) {
      localARParticleFilter = new ARParticleFilter(paramVideoMaterial.getArParticleList(), paramVideoMaterial.getDataPath());
    }
    AppMethodBeat.o(84015);
    return localARParticleFilter;
  }
  
  private static ActFilters createActFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83999);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value)
    {
      localObject1 = localObject2;
      if (paramVideoMaterial.getFaceExpression() != null) {
        localObject1 = new ActFilters(paramVideoMaterial.getFaceExpression(), paramVideoMaterial.getDataPath());
      }
    }
    AppMethodBeat.o(83999);
    return localObject1;
  }
  
  private static Audio3DFilter createAudio3DFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84005);
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getAudio3DParams() != null))
    {
      Audio3DFilter localAudio3DFilter = new Audio3DFilter(paramVideoMaterial.getItemList3D(), paramVideoMaterial.getOrderMode(), paramVideoMaterial.getMaxFaceCount());
      localAudio3DFilter.setGameParams(paramVideoMaterial.getGameParams(), paramVideoMaterial.getDataPath());
      if (paramVideoMaterial.getItemList() != null)
      {
        Iterator localIterator = paramVideoMaterial.getItemList().iterator();
        while (localIterator.hasNext()) {
          localAudio3DFilter.addSticker((StickerItem)localIterator.next(), paramVideoMaterial.getDataPath());
        }
      }
      if (localAudio3DFilter.getStickerListSize() > 0)
      {
        AppMethodBeat.o(84005);
        return localAudio3DFilter;
      }
    }
    AppMethodBeat.o(84005);
    return null;
  }
  
  private static List<ParticleFilter> createBodyParticleFilters(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84034);
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        StickerItem localStickerItem = (StickerItem)localList.get(i);
        if ((localStickerItem.particleConfig != null) && (VideoMaterialUtil.isBodyDetectItem(localStickerItem))) {
          localArrayList.add(new ParticleFilter(paramVideoMaterial.getDataPath() + File.separator + localStickerItem.id, localStickerItem));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(84034);
    return localArrayList;
  }
  
  private static List<NormalVideoFilter> createBodyVideoFilterList(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84003);
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      boolean bool = VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial);
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isBodyDetectItem((StickerItem)localObject)) && (((StickerItem)localObject).particleConfig == null) && ((!bool) || (!VideoMaterialUtil.canStickerItemUseFastRender((StickerItem)localObject))))
        {
          localObject = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    AppMethodBeat.o(84003);
    return localArrayList;
  }
  
  private static CustomVideoFilter createCustomEffectVideoFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84013);
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
    paramVideoMaterial = new CustomVideoFilter((String)localObject1, (String)localObject2, paramVideoMaterial.getResourceList(), getCustomFilterTriggerType(paramVideoMaterial.getItemList()), paramVideoMaterial.getDataPath());
    AppMethodBeat.o(84013);
    return paramVideoMaterial;
  }
  
  private static CustomVertexFilter createCustomVertexFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84014);
    Object localObject2;
    Object localObject1;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value)
    {
      localObject2 = VideoMaterialUtil.loadVertexShader(paramVideoMaterial.getDataPath());
      String str = VideoMaterialUtil.loadFragmentShader(paramVideoMaterial.getDataPath());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = SIMPLE_VERTEX_SHADER;
      }
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = SIMPLE_FRAGMENT_SHADER;
      }
      if (BaseUtils.isEmpty(paramVideoMaterial.getItemList())) {}
    }
    for (paramVideoMaterial = new CustomVertexFilter((String)localObject1, (String)localObject2);; paramVideoMaterial = null)
    {
      AppMethodBeat.o(84014);
      return paramVideoMaterial;
    }
  }
  
  private static CustomVideoFilter createCustomVideoFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject1 = null;
    AppMethodBeat.i(84012);
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value))
    {
      Object localObject2 = VideoMaterialUtil.loadVertexShader(paramVideoMaterial.getDataPath());
      String str = VideoMaterialUtil.loadFragmentShader(paramVideoMaterial.getDataPath());
      if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty(str)))
      {
        AppMethodBeat.o(84012);
        return null;
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = VideoFilterFactory.VERTEX_SHADER_COMMON;
      }
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = VideoFilterFactory.FRAGMENT_SHADER_IMAGE;
      }
      localObject1 = new CustomVideoFilter((String)localObject1, (String)localObject2, paramVideoMaterial.getResourceList(), getCustomFilterTriggerType(paramVideoMaterial.getItemList()), paramVideoMaterial.getDataPath());
    }
    AppMethodBeat.o(84012);
    return localObject1;
  }
  
  private static VideoFilterBase createDoodleFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83996);
    DoodleFilter localDoodleFilter = null;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value) {
      localDoodleFilter = new DoodleFilter();
    }
    AppMethodBeat.o(83996);
    return localDoodleFilter;
  }
  
  private static VideoFilterBase createEffectFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84035);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial != null)
    {
      VideoFilterEffect localVideoFilterEffect = paramVideoMaterial.getVideoFilterEffect();
      localObject1 = localObject2;
      if (localVideoFilterEffect != null) {
        switch (localVideoFilterEffect.type)
        {
        default: 
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(84035);
      return localObject1;
      localObject1 = createSimpleEffectVideoFilter(paramVideoMaterial);
      continue;
      localObject1 = createCustomEffectVideoFilter(paramVideoMaterial);
    }
  }
  
  private static FabbyFilters createFabbyMvFilterList(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84009);
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
    label171:
    label192:
    label380:
    label381:
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
          break label380;
        }
        i = ((GridSettingModel)((Pair)localObject3).second).canvasRectList.size();
      }
      for (;;)
      {
        break label192;
        if (((FabbyMvPart)localObject2).filterType != 2) {
          break label381;
        }
        localFabbyMvFilter.mEffectFilter = new ab();
        localObject3 = BitmapUtils.decodeSampledBitmapFromFile(paramVideoMaterial.getDataPath() + File.separator + ((FabbyMvPart)localObject2).lutFile, 1);
        localFabbyMvFilter.mEffectFilter.addParam(new m.k("inputImageTexture2", (Bitmap)localObject3, 33986, true));
        break label171;
        ((List)localObject1).add(localFabbyMvFilter);
        break;
        localObject1 = new FabbyFilters((List)localObject1, paramVideoMaterial.getDataPath(), paramVideoMaterial.getFabbyParts().getAudioFile());
        AppMethodBeat.o(84009);
        return localObject1;
      }
    }
  }
  
  private static FaceCropFilter createFaceCropFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84016);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial != null)
    {
      localObject1 = localObject2;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) {
        localObject1 = new FaceCropFilter(paramVideoMaterial);
      }
    }
    AppMethodBeat.o(84016);
    return localObject1;
  }
  
  private static List<NormalVideoFilter> createFaceFilterList(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84001);
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      boolean bool = VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial);
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isFaceItem((StickerItem)localObject)) && (((StickerItem)localObject).particleConfig == null) && ((!bool) || (!VideoMaterialUtil.canStickerItemUseFastRender((StickerItem)localObject))))
        {
          localObject = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    AppMethodBeat.o(84001);
    return localArrayList;
  }
  
  private static List<VideoFilterBase> createFaceOffFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84010);
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getFaceOffItemList();
    if (localList == null)
    {
      AppMethodBeat.o(84010);
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
    AppMethodBeat.o(84010);
    return localArrayList;
  }
  
  private static List<ParticleFilter> createFaceParticleFilters(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84032);
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        StickerItem localStickerItem = (StickerItem)localList.get(i);
        if ((localStickerItem.particleConfig != null) && (VideoMaterialUtil.isFaceItem(localStickerItem))) {
          localArrayList.add(new ParticleFilter(paramVideoMaterial.getDataPath() + File.separator + localStickerItem.id, localStickerItem));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(84032);
    return localArrayList;
  }
  
  private static List<FacialFeatureFilter> createFacialFeatureFilters(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83994);
    ArrayList localArrayList1 = new ArrayList();
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getFaceFeatureItemList() == null))
    {
      AppMethodBeat.o(83994);
      return null;
    }
    Iterator localIterator = paramVideoMaterial.getFaceFeatureItemList().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (FaceFeatureItem)localIterator.next();
      if ((((FaceFeatureItem)localObject1).getFaceOffItemList() != null) && (!((FaceFeatureItem)localObject1).getFaceOffItemList().isEmpty()))
      {
        Object localObject2 = ((FaceFeatureItem)localObject1).getStickerItems();
        localObject1 = new FacialFeatureFilter((FaceItem)((FaceFeatureItem)localObject1).getFaceOffItemList().get(0), ((FaceFeatureItem)localObject1).getDistortionItemList(), (FaceFeatureItem)localObject1);
        ArrayList localArrayList2 = new ArrayList();
        if (!BaseUtils.isEmpty((Collection)localObject2))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (StickerItem)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject3 = VideoFilterFactory.createFilter((StickerItem)localObject3, paramVideoMaterial.getDataPath());
              if (localObject3 != null) {
                localArrayList2.add(localObject3);
              }
            }
          }
        }
        ((FacialFeatureFilter)localObject1).setStickerFilters(localArrayList2);
        localArrayList1.add(localObject1);
      }
    }
    AppMethodBeat.o(83994);
    return localArrayList1;
  }
  
  private static FastStickerFilter createFastBodyStickerFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84006);
    if (paramVideoMaterial.getItemList() != null)
    {
      if (!VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial))
      {
        AppMethodBeat.o(84006);
        return null;
      }
      FastStickerFilter localFastStickerFilter = new FastStickerFilter();
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isBodyDetectItem(localStickerItem)) && (VideoMaterialUtil.canStickerItemUseFastBodyRender(localStickerItem))) {
          localFastStickerFilter.addSticker(localStickerItem, paramVideoMaterial.getDataPath());
        }
      }
      if (localFastStickerFilter.getStickerListSize() > 0)
      {
        AppMethodBeat.o(84006);
        return localFastStickerFilter;
      }
    }
    AppMethodBeat.o(84006);
    return null;
  }
  
  private static FastStickerFilter createFastFaceStickerFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84004);
    if (paramVideoMaterial.getItemList() != null)
    {
      if (!VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial))
      {
        AppMethodBeat.o(84004);
        return null;
      }
      FastStickerFilter localFastStickerFilter = new FastStickerFilter();
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isFaceItem(localStickerItem)) && (VideoMaterialUtil.canStickerItemUseFastFaceRender(localStickerItem))) {
          localFastStickerFilter.addSticker(localStickerItem, paramVideoMaterial.getDataPath());
        }
      }
      if (localFastStickerFilter.getStickerListSize() > 0)
      {
        AppMethodBeat.o(84004);
        return localFastStickerFilter;
      }
    }
    AppMethodBeat.o(84004);
    return null;
  }
  
  public static VideoFilterList createFilters(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83992);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(83992);
      return null;
    }
    Object localObject = createCustomVideoFilter(paramVideoMaterial);
    CustomVertexFilter localCustomVertexFilter = createCustomVertexFilter(paramVideoMaterial);
    SnakeFaceFilter localSnakeFaceFilter = createSnakeFaceFilter(paramVideoMaterial);
    List localList1 = createFaceOffFilter(paramVideoMaterial);
    List localList2 = createTransformFilter(paramVideoMaterial);
    VideoFilterBase localVideoFilterBase = createDoodleFilter(paramVideoMaterial);
    List localList10 = createThreeDimFilter(paramVideoMaterial);
    FaceCropFilter localFaceCropFilter = createFaceCropFilter(paramVideoMaterial);
    HeadCropFilter localHeadCropFilter = createHeadCropFilter(paramVideoMaterial);
    List localList11 = createHeadCropFilterList(paramVideoMaterial);
    List localList12 = createFaceFilterList(paramVideoMaterial);
    List localList3 = createGestureVideoFilterList(paramVideoMaterial);
    List localList4 = createBodyVideoFilterList(paramVideoMaterial);
    FabbyFilters localFabbyFilters = createFabbyMvFilterList(paramVideoMaterial);
    LipsCosFilter localLipsCosFilter = createLipsCosFilter(paramVideoMaterial);
    List localList5 = createMultiViewerFilters(paramVideoMaterial);
    List localList6 = createFacialFeatureFilters(paramVideoMaterial);
    GameFilter localGameFilter = createGameFilter(paramVideoMaterial);
    List localList13 = createVoiceTextFilter(paramVideoMaterial);
    List localList7 = createFaceParticleFilters(paramVideoMaterial);
    List localList8 = createGestureParticleFilters(paramVideoMaterial);
    List localList9 = createBodyParticleFilters(paramVideoMaterial);
    PhantomFilter localPhantomFilter = createPhantomFilter(paramVideoMaterial);
    if (localObject != null) {
      ((CustomVideoFilter)localObject).setNormalFilters(localList12);
    }
    VideoFilterList localVideoFilterList = new VideoFilterList();
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.NORMAL.value) {
      localArrayList.addAll(localList12);
    }
    for (;;)
    {
      if (localPhantomFilter != null) {
        localVideoFilterList.setPhantomFilter(localPhantomFilter);
      }
      localArrayList.addAll(localList13);
      localObject = createEffectFilter(paramVideoMaterial);
      if (localObject != null)
      {
        localVideoFilterList.setVideoEffectFilter((VideoFilterBase)localObject);
        localVideoFilterList.setVideoEffectOrder(paramVideoMaterial.getVideoFilterEffect().order);
      }
      if (localLipsCosFilter != null) {
        localVideoFilterList.setLipsCosFilter(localLipsCosFilter);
      }
      localVideoFilterList.setFabbyMvFilters(localFabbyFilters);
      localVideoFilterList.setFilters(localArrayList, localList1, localList2);
      localVideoFilterList.setFastFaceStickerFilter(createFastFaceStickerFilter(paramVideoMaterial));
      localVideoFilterList.setFastBodyStickerFilter(createFastBodyStickerFilter(paramVideoMaterial));
      localVideoFilterList.setFaceParticleFilters(localList7);
      localVideoFilterList.setGestureParticleFilters(localList8);
      localVideoFilterList.setBodyParticleFilters(localList9);
      localVideoFilterList.setAudio3DFilter(createAudio3DFilter(paramVideoMaterial));
      localVideoFilterList.setGestureFilters(localList3);
      localVideoFilterList.setBodyFilters(localList4);
      localVideoFilterList.setGameFilter(localGameFilter);
      localVideoFilterList.setMultiViewerFilters(localList5);
      localVideoFilterList.setNeedDetectGesture(VideoMaterialUtil.isGestureDetectMaterial(paramVideoMaterial));
      localVideoFilterList.setMaterial(paramVideoMaterial);
      localVideoFilterList.setFacialFeatureFilterList(localList6);
      if (paramVideoMaterial.getAudio2Text() != null) {
        localVideoFilterList.setTriggerWords(paramVideoMaterial.getAudio2Text().triggerWords);
      }
      AppMethodBeat.o(83992);
      return localVideoFilterList;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value)
      {
        localArrayList.addAll(localList12);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value)
      {
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        localArrayList.addAll(localList12);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value)
      {
        localArrayList.add(localSnakeFaceFilter);
        localArrayList.addAll(localList12);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value)
      {
        localArrayList.add(localCustomVertexFilter);
        localArrayList.addAll(localList12);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value)
      {
        localArrayList.addAll(localList12);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value)
      {
        localArrayList.addAll(localList12);
      }
      else if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.GAMEPLAY_3D.value))
      {
        localArrayList.addAll(localList12);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value)
      {
        localArrayList.addAll(localList10);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value)
      {
        localArrayList.add(localVideoFilterBase);
      }
      else if (VideoMaterialUtil.isFaceMorphingMaterial(paramVideoMaterial))
      {
        localVideoFilterList.setCrazyFaceFilters(new CrazyFaceFilters(paramVideoMaterial));
        localArrayList.addAll(localList12);
      }
      else if (VideoMaterialUtil.isARMaterial(paramVideoMaterial))
      {
        localVideoFilterList.setARParticleFilter(createARParticleFilter(paramVideoMaterial));
        if (localList12 != null) {
          localArrayList.addAll(localList12);
        }
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value)
      {
        localVideoFilterList.setActFilter(createActFilter(paramVideoMaterial));
        localArrayList.addAll(localList12);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value)
      {
        localArrayList.add(localFaceCropFilter);
        if (localList12 != null)
        {
          localArrayList.addAll(localList12);
          localFaceCropFilter.setNormalFilters(localList12);
        }
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value)
      {
        localVideoFilterList.setHeadCropFilter(localHeadCropFilter);
        localArrayList.add(localHeadCropFilter);
        localArrayList.addAll(localList12);
        localVideoFilterList.setHeadCropItemFilters(localList11);
      }
    }
  }
  
  private static GameFilter createGameFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84008);
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getGameParams() != null))
    {
      GameFilter localGameFilter = new GameFilter(paramVideoMaterial.getItemList3D(), paramVideoMaterial.getOrderMode(), paramVideoMaterial.getMaxFaceCount());
      localGameFilter.setGameParams(paramVideoMaterial.getGameParams(), paramVideoMaterial.getDataPath());
      AppMethodBeat.o(84008);
      return localGameFilter;
    }
    AppMethodBeat.o(84008);
    return null;
  }
  
  private static List<ParticleFilter> createGestureParticleFilters(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84033);
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        StickerItem localStickerItem = (StickerItem)localList.get(i);
        if ((localStickerItem.particleConfig != null) && (VideoMaterialUtil.isGestureItem(localStickerItem))) {
          localArrayList.add(new ParticleFilter(paramVideoMaterial.getDataPath() + File.separator + localStickerItem.id, localStickerItem));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(84033);
    return localArrayList;
  }
  
  private static List<NormalVideoFilter> createGestureVideoFilterList(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84002);
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isGestureItem((StickerItem)localObject)) && (((StickerItem)localObject).particleConfig == null))
        {
          localObject = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    AppMethodBeat.o(84002);
    return localArrayList;
  }
  
  private static HeadCropFilter createHeadCropFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84017);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial != null)
    {
      localObject1 = localObject2;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value) {
        localObject1 = new HeadCropFilter();
      }
    }
    AppMethodBeat.o(84017);
    return localObject1;
  }
  
  private static List<NormalVideoFilter> createHeadCropFilterList(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84000);
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
    AppMethodBeat.o(84000);
    return localArrayList;
  }
  
  private static LipsCosFilter createLipsCosFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84018);
    LipsCosFilter localLipsCosFilter = null;
    if (!TextUtils.isEmpty(paramVideoMaterial.getLipsLutPath()))
    {
      paramVideoMaterial = paramVideoMaterial.getDataPath() + File.separator + paramVideoMaterial.getLipsLutPath();
      if (paramVideoMaterial.startsWith("assets://")) {
        break label87;
      }
    }
    label87:
    for (paramVideoMaterial = BitmapUtils.decodeSampledBitmapFromFile(paramVideoMaterial, 1);; paramVideoMaterial = BitmapUtils.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(paramVideoMaterial), 1))
    {
      localLipsCosFilter = new LipsCosFilter();
      localLipsCosFilter.setTypeAndLut(1, paramVideoMaterial);
      AppMethodBeat.o(84018);
      return localLipsCosFilter;
    }
  }
  
  private static List<MultiViewerFilter> createMultiViewerFilters(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84007);
    ArrayList localArrayList = new ArrayList();
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList().iterator();
    while (paramVideoMaterial.hasNext())
    {
      MultiViewerItem localMultiViewerItem = (MultiViewerItem)paramVideoMaterial.next();
      if ((localMultiViewerItem != null) && (localMultiViewerItem.videoMaterial != null))
      {
        MultiViewerFilter localMultiViewerFilter = new MultiViewerFilter();
        localMultiViewerFilter.setVideoFilterList(createFilters(localMultiViewerItem.videoMaterial));
        localMultiViewerFilter.setActiveParts(localMultiViewerItem.activeParts);
        localMultiViewerFilter.setRenderId(localMultiViewerItem.renderId);
        localMultiViewerFilter.setNeedOriginFrame(localMultiViewerItem.needOriginFrame);
        if (!TextUtils.isEmpty(localMultiViewerItem.videoMaterial.getFilterId())) {
          localMultiViewerFilter.setEffectFilter(FabbyFilterFactory.createFilter(localMultiViewerItem.videoMaterial.getFilterId()));
        }
        localArrayList.add(localMultiViewerFilter);
      }
    }
    AppMethodBeat.o(84007);
    return localArrayList;
  }
  
  private static List<VideoFilterBase> createParticleXFilters(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84031);
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      ParticleSystemX.getInstance().init(VideoGlobalContext.getContext());
      int i = 0;
      while (i < localList.size())
      {
        StickerItem localStickerItem = (StickerItem)localList.get(i);
        if ((localStickerItem.transition != null) && (localStickerItem.wmGroupCopies == null))
        {
          localArrayList.add(new ParticleXFilter(localStickerItem, paramVideoMaterial.getDataPath(), i));
          ParticleSystemX.getInstance().addParticle(localStickerItem.transition);
        }
        i += 1;
      }
      ParticleSystemX.getInstance().registerTemplate();
    }
    AppMethodBeat.o(84031);
    return localArrayList;
  }
  
  private static PhantomFilter createPhantomFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83993);
    Object localObject = null;
    List localList = paramVideoMaterial.getPhantomItemList();
    paramVideoMaterial = localObject;
    if (localList != null)
    {
      paramVideoMaterial = localObject;
      if (localList.size() > 0) {
        paramVideoMaterial = new PhantomFilter(localList);
      }
    }
    AppMethodBeat.o(83993);
    return paramVideoMaterial;
  }
  
  private static VideoFilterBase createSimpleEffectVideoFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83997);
    paramVideoMaterial = new SimpleEffectVideoFilter(paramVideoMaterial.getDataPath());
    AppMethodBeat.o(83997);
    return paramVideoMaterial;
  }
  
  private static SnakeFaceFilter createSnakeFaceFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84011);
    SnakeFaceFilter localSnakeFaceFilter = null;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value) {
      localSnakeFaceFilter = new SnakeFaceFilter();
    }
    AppMethodBeat.o(84011);
    return localSnakeFaceFilter;
  }
  
  private static List<VideoFilterBase> createThreeDimFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83998);
    ArrayList localArrayList = new ArrayList();
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value) && (paramVideoMaterial.getItemList() != null))
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new ThreeDimFilter((StickerItem)localIterator.next(), paramVideoMaterial.getDataPath()));
      }
    }
    AppMethodBeat.o(83998);
    return localArrayList;
  }
  
  private static List<VideoFilterBase> createTransformFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83995);
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getFaceMeshItemList();
    if (!BaseUtils.isEmpty(localList))
    {
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add(new TransformFilter((FaceMeshItem)localList.get(i), paramVideoMaterial.getDataPath()));
        i += 1;
      }
    }
    if (!BaseUtils.isEmpty(paramVideoMaterial.getDistortionItemList())) {
      if (paramVideoMaterial.isUseMesh())
      {
        paramVideoMaterial = new TransformFilter(paramVideoMaterial.getDistortionItemList(), paramVideoMaterial.getItemList());
        paramVideoMaterial.setOptimizeBoundary(true);
        localArrayList.add(paramVideoMaterial);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(83995);
      return localArrayList;
      if (!BaseUtils.isEmpty(paramVideoMaterial.getFaceMoveItemList())) {
        localArrayList.add(new FaceMoveFilter(paramVideoMaterial.getFaceMoveItemList(), paramVideoMaterial.getItemList(), paramVideoMaterial.getFaceMoveTriangles()));
      }
    }
  }
  
  private static List<VideoFilterBase> createVoiceTextFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84030);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = paramVideoMaterial.getItemList();
    paramVideoMaterial = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        StickerItem localStickerItem = (StickerItem)((Iterator)localObject).next();
        if ((localStickerItem.transition != null) && (localStickerItem.wmGroupCopies != null)) {
          if (localStickerItem.zIndex >= 0) {
            paramVideoMaterial.add(localStickerItem);
          } else {
            localArrayList2.add(localStickerItem);
          }
        }
      }
      if (!paramVideoMaterial.isEmpty()) {
        localArrayList1.add(new VoiceTextFilter(((StickerItem)paramVideoMaterial.get(0)).zIndex, paramVideoMaterial));
      }
      if (!localArrayList2.isEmpty()) {
        localArrayList1.add(new VoiceTextFilter(((StickerItem)localArrayList2.get(0)).zIndex, localArrayList2));
      }
    }
    AppMethodBeat.o(84030);
    return localArrayList1;
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
  
  public static List<String> getAllPngFileNames(String paramString)
  {
    AppMethodBeat.i(83991);
    ArrayList localArrayList = new ArrayList();
    if (paramString == null)
    {
      AppMethodBeat.o(83991);
      return localArrayList;
    }
    if (paramString.startsWith("assets://")) {}
    try
    {
      paramString = VideoGlobalContext.getContext().getAssets().list(FileUtils.getRealPath(paramString));
      if (paramString == null)
      {
        AppMethodBeat.o(83991);
        return localArrayList;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.endsWith(".png")) {
          localArrayList.add(localObject);
        }
        i += 1;
        continue;
        paramString = new File(paramString).list(VideoMaterialUtil.mPngFilter);
        if (paramString == null)
        {
          AppMethodBeat.o(83991);
          return localArrayList;
        }
        localArrayList.addAll(Arrays.asList(paramString));
      }
    }
    catch (IOException paramString)
    {
      label142:
      break label142;
    }
    AppMethodBeat.o(83991);
    return localArrayList;
  }
  
  private static PTFaceAttr.PTExpression getCustomFilterTriggerType(List<StickerItem> paramList)
  {
    AppMethodBeat.i(84019);
    if (BaseUtils.isEmpty(paramList))
    {
      paramList = PTFaceAttr.PTExpression.UNKNOW;
      AppMethodBeat.o(84019);
      return paramList;
    }
    int i = PTFaceAttr.PTExpression.UNKNOW.value;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)paramList.next();
      if (localStickerItem.triggerType <= i) {
        break label87;
      }
      i = localStickerItem.triggerType;
    }
    label87:
    for (;;)
    {
      break;
      paramList = VideoMaterialUtil.getTriggerType(i);
      AppMethodBeat.o(84019);
      return paramList;
    }
  }
  
  public static float getFaceStatus(FaceRangeStatus paramFaceRangeStatus, int paramInt, StickerItem.ValueRange paramValueRange)
  {
    AppMethodBeat.i(84028);
    if (paramFaceRangeStatus == null)
    {
      AppMethodBeat.o(84028);
      return -1.0F;
    }
    VideoMaterialUtil.RANGE_TRIGGER_TYPE[] arrayOfRANGE_TRIGGER_TYPE = VideoMaterialUtil.RANGE_TRIGGER_TYPE.values();
    int j = arrayOfRANGE_TRIGGER_TYPE.length;
    int i = 0;
    while (i < j)
    {
      VideoMaterialUtil.RANGE_TRIGGER_TYPE localRANGE_TRIGGER_TYPE = arrayOfRANGE_TRIGGER_TYPE[i];
      if (localRANGE_TRIGGER_TYPE.value == paramInt)
      {
        float f = localRANGE_TRIGGER_TYPE.checker.getLevel(paramFaceRangeStatus, paramValueRange);
        AppMethodBeat.o(84028);
        return f;
      }
      i += 1;
    }
    AppMethodBeat.o(84028);
    return -1.0F;
  }
  
  public static h getSecondLastFrame(h paramh)
  {
    AppMethodBeat.i(84023);
    h localh;
    if (FrameUtil.isValid(paramh))
    {
      localh = paramh;
      if (FrameUtil.isValid(paramh.btf)) {}
    }
    else
    {
      AppMethodBeat.o(84023);
      return null;
    }
    while ((FrameUtil.isValid(localh.btf)) && (FrameUtil.isValid(localh.btf.btf))) {
      localh = localh.btf;
    }
    AppMethodBeat.o(84023);
    return localh;
  }
  
  public static List<VideoFilterBase> getSimpleNormalVideoFilter(List<VideoFilterBase> paramList)
  {
    AppMethodBeat.i(84036);
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      AppMethodBeat.o(84036);
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
    AppMethodBeat.o(84036);
    return localArrayList;
  }
  
  public static boolean isStatusTriggered(FaceRangeStatus paramFaceRangeStatus, int paramInt, StickerItem.ValueRange paramValueRange)
  {
    AppMethodBeat.i(84027);
    if (paramFaceRangeStatus == null)
    {
      AppMethodBeat.o(84027);
      return false;
    }
    VideoMaterialUtil.RANGE_TRIGGER_TYPE[] arrayOfRANGE_TRIGGER_TYPE = VideoMaterialUtil.RANGE_TRIGGER_TYPE.values();
    int j = arrayOfRANGE_TRIGGER_TYPE.length;
    int i = 0;
    while (i < j)
    {
      VideoMaterialUtil.RANGE_TRIGGER_TYPE localRANGE_TRIGGER_TYPE = arrayOfRANGE_TRIGGER_TYPE[i];
      if (localRANGE_TRIGGER_TYPE.value == paramInt)
      {
        boolean bool = localRANGE_TRIGGER_TYPE.checker.isInRange(paramFaceRangeStatus, paramValueRange);
        AppMethodBeat.o(84027);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(84027);
    return false;
  }
  
  public static boolean maybeTransformFilter(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && (((paramVideoFilterBase instanceof TransformFilter)) || ((paramVideoFilterBase instanceof CustomVideoFilter)));
  }
  
  public static boolean needBlendMode(List<VideoFilterBase> paramList)
  {
    AppMethodBeat.i(84024);
    if (paramList == null)
    {
      AppMethodBeat.o(84024);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((VideoFilterBase)paramList.next() instanceof NormalVideoFilter))
      {
        AppMethodBeat.o(84024);
        return true;
      }
    }
    AppMethodBeat.o(84024);
    return false;
  }
  
  public static boolean needCopy(VideoFilterBase paramVideoFilterBase)
  {
    AppMethodBeat.i(83990);
    if (paramVideoFilterBase == null)
    {
      AppMethodBeat.o(83990);
      return false;
    }
    if ((paramVideoFilterBase instanceof NormalVideoFilter))
    {
      boolean bool = ((NormalVideoFilter)paramVideoFilterBase).needCopyTex();
      AppMethodBeat.o(83990);
      return bool;
    }
    if ((paramVideoFilterBase instanceof FaceOffFilter))
    {
      AppMethodBeat.o(83990);
      return true;
    }
    AppMethodBeat.o(83990);
    return false;
  }
  
  public static boolean needDepthBuffer(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && ((paramVideoFilterBase instanceof ThreeDimFilter));
  }
  
  public static boolean needRecordTouchPoint(VideoFilterList paramVideoFilterList)
  {
    AppMethodBeat.i(84029);
    if ((paramVideoFilterList != null) && (VideoMaterialUtil.isARMaterial(paramVideoFilterList.getMaterial())))
    {
      AppMethodBeat.o(84029);
      return true;
    }
    AppMethodBeat.o(84029);
    return false;
  }
  
  public static void setRenderMode(BaseFilter paramBaseFilter, int paramInt)
  {
    AppMethodBeat.i(84021);
    while (paramBaseFilter != null)
    {
      paramBaseFilter.setRenderMode(paramInt);
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
    AppMethodBeat.o(84021);
  }
  
  public static void setRenderMode(VideoFilterBase paramVideoFilterBase, int paramInt)
  {
    AppMethodBeat.i(84022);
    if (paramVideoFilterBase != null) {
      paramVideoFilterBase.setRenderMode(paramInt);
    }
    AppMethodBeat.o(84022);
  }
  
  public static void setRenderMode(List<? extends VideoFilterBase> paramList, int paramInt)
  {
    AppMethodBeat.i(84020);
    if (BaseUtils.isEmpty(paramList))
    {
      AppMethodBeat.o(84020);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((VideoFilterBase)paramList.next()).setRenderMode(paramInt);
    }
    AppMethodBeat.o(84020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFilterUtil
 * JD-Core Version:    0.7.0.1
 */