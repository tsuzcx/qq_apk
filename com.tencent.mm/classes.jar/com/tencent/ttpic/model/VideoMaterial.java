package com.tencent.ttpic.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VideoMaterial
{
  private String adAppLink;
  private String adIcon;
  private String adLink;
  private List<String> arParticleList;
  private int arParticleType;
  private Audio2Text audio2Text;
  private GameParams audio3DParams;
  private double blendAlpha;
  private int blendMode;
  private int categoryFlag;
  private String dataPath;
  private int detectorFlag;
  private List<DistortionItem> distortionItemList;
  private int environment;
  private FabbyParts fabbyParts;
  private FaceCropItem faceCropItem;
  private int faceDetectType;
  private String faceExchangeImage;
  private FaceExpression faceExpression;
  private List<FaceFeatureItem> faceFeatureItemList;
  private FaceImageLayer faceImageLayer;
  private List<FaceMeshItem> faceMeshItemList;
  private List<FaceMoveItem> faceMoveItemList;
  private int[] faceMoveTriangles;
  private List<FaceItem> faceOffItemList;
  private List<Float> facePoints;
  private int faceSwapType;
  private int faceValueDetectType;
  private int faceoffType;
  private int featureType;
  private double filterBlurStrength;
  private String filterId;
  private boolean flattenEar;
  private boolean flattenNose;
  private float fov;
  private GameParams gameParams;
  private int grayScale;
  private int handBoostEnable;
  private boolean hasAudio;
  private List<StickerItem> headCropItemList;
  private String id;
  private String imageFacePointsFileName;
  private List<StickerItem> itemList;
  private List<StickerItem3D> itemList3D;
  private String lipsLutPath;
  private int maxFaceCount;
  private int minAppVersion;
  private List<MultiViewerItem> multiViewerItemList;
  private boolean needBodyInfo;
  private boolean needFaceInfo;
  private int orderMode;
  private List<PhantomItem> phantomItemList;
  private int randomGroupCount;
  private boolean resetWhenStartRecord;
  private List<String> resourceList;
  private int segmentFeather;
  private boolean segmentRequired;
  private float[] segmentStrokeColor;
  private double segmentStrokeGap;
  private double segmentStrokeWidth;
  private int shaderType;
  private float splitScreen;
  private boolean supportLandscape;
  private boolean supportPause;
  private String tipsIcon;
  private String tipsText;
  private int triggerType;
  private boolean useMesh;
  private VideoFilterEffect videoFilterEffect;
  private int voicekind;
  private String weiboTag;
  
  public VideoMaterial()
  {
    AppMethodBeat.i(83580);
    this.useMesh = false;
    this.segmentRequired = false;
    this.needFaceInfo = true;
    this.needBodyInfo = false;
    this.multiViewerItemList = new ArrayList();
    AppMethodBeat.o(83580);
  }
  
  private boolean hasCustomVideoFilter()
  {
    return (this.shaderType == 1) || (this.shaderType == 2);
  }
  
  public String getAdAppLink()
  {
    return this.adAppLink;
  }
  
  public String getAdIcon()
  {
    return this.adIcon;
  }
  
  public String getAdLink()
  {
    return this.adLink;
  }
  
  public List<String> getArParticleList()
  {
    return this.arParticleList;
  }
  
  public int getArParticleType()
  {
    return this.arParticleType;
  }
  
  public Audio2Text getAudio2Text()
  {
    return this.audio2Text;
  }
  
  public GameParams getAudio3DParams()
  {
    return this.audio3DParams;
  }
  
  public double getBlendAlpha()
  {
    return this.blendAlpha;
  }
  
  public int getBlendMode()
  {
    return this.blendMode;
  }
  
  public int getCategoryFlag()
  {
    return this.categoryFlag;
  }
  
  public String getDataPath()
  {
    return this.dataPath;
  }
  
  public int getDetectorFlag()
  {
    return this.detectorFlag;
  }
  
  public List<DistortionItem> getDistortionItemList()
  {
    return this.distortionItemList;
  }
  
  public int getEnvironment()
  {
    return this.environment;
  }
  
  public FabbyParts getFabbyParts()
  {
    return this.fabbyParts;
  }
  
  public FaceCropItem getFaceCropItem()
  {
    return this.faceCropItem;
  }
  
  public int getFaceDetectType()
  {
    return this.faceDetectType;
  }
  
  public String getFaceExchangeImage()
  {
    return this.faceExchangeImage;
  }
  
  public FaceExpression getFaceExpression()
  {
    return this.faceExpression;
  }
  
  public List<FaceFeatureItem> getFaceFeatureItemList()
  {
    return this.faceFeatureItemList;
  }
  
  public FaceImageLayer getFaceImageLayer()
  {
    return this.faceImageLayer;
  }
  
  public List<FaceMeshItem> getFaceMeshItemList()
  {
    return this.faceMeshItemList;
  }
  
  public List<FaceMoveItem> getFaceMoveItemList()
  {
    return this.faceMoveItemList;
  }
  
  public int[] getFaceMoveTriangles()
  {
    return this.faceMoveTriangles;
  }
  
  public List<FaceItem> getFaceOffItemList()
  {
    return this.faceOffItemList;
  }
  
  public List<Float> getFacePoints()
  {
    return this.facePoints;
  }
  
  public int getFaceSwapType()
  {
    return this.faceSwapType;
  }
  
  public int getFaceValueDetectType()
  {
    return this.faceValueDetectType;
  }
  
  public int getFaceoffType()
  {
    return this.faceoffType;
  }
  
  public int getFeatureType()
  {
    return this.featureType;
  }
  
  public double getFilterBlurStrength()
  {
    return this.filterBlurStrength;
  }
  
  public String getFilterId()
  {
    return this.filterId;
  }
  
  public float getFov()
  {
    return this.fov;
  }
  
  public GameParams getGameParams()
  {
    return this.gameParams;
  }
  
  public int getGrayScale()
  {
    return this.grayScale;
  }
  
  public int getHandBoostEnable()
  {
    return this.handBoostEnable;
  }
  
  public List<StickerItem> getHeadCropItemList()
  {
    return this.headCropItemList;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getImageFacePointsFileName()
  {
    return this.imageFacePointsFileName;
  }
  
  public List<StickerItem> getItemList()
  {
    return this.itemList;
  }
  
  public List<StickerItem3D> getItemList3D()
  {
    return this.itemList3D;
  }
  
  public String getLipsLutPath()
  {
    return this.lipsLutPath;
  }
  
  public int getMaxFaceCount()
  {
    return this.maxFaceCount;
  }
  
  public int getMinAppVersion()
  {
    return this.minAppVersion;
  }
  
  public List<MultiViewerItem> getMultiViewerItemList()
  {
    return this.multiViewerItemList;
  }
  
  public int getOrderMode()
  {
    return this.orderMode;
  }
  
  public List<PhantomItem> getPhantomItemList()
  {
    return this.phantomItemList;
  }
  
  public int getRandomGroupCount()
  {
    return this.randomGroupCount;
  }
  
  public List<String> getResourceList()
  {
    return this.resourceList;
  }
  
  public int getSegmentFeather()
  {
    return this.segmentFeather;
  }
  
  public float[] getSegmentStrokeColor()
  {
    return this.segmentStrokeColor;
  }
  
  public double getSegmentStrokeGap()
  {
    return this.segmentStrokeGap;
  }
  
  public double getSegmentStrokeWidth()
  {
    return this.segmentStrokeWidth;
  }
  
  public int getShaderType()
  {
    return this.shaderType;
  }
  
  public float getSplitScreen()
  {
    return this.splitScreen;
  }
  
  public String getTipsIcon()
  {
    return this.tipsIcon;
  }
  
  public String getTipsText()
  {
    return this.tipsText;
  }
  
  public int getTriggerType()
  {
    return this.triggerType;
  }
  
  public VideoFilterEffect getVideoFilterEffect()
  {
    return this.videoFilterEffect;
  }
  
  public int getVoicekind()
  {
    return this.voicekind;
  }
  
  public String getWeiboTag()
  {
    return this.weiboTag;
  }
  
  public boolean hasAd()
  {
    AppMethodBeat.i(83583);
    if ((!TextUtils.isEmpty(this.adIcon)) || (!TextUtils.isEmpty(this.adLink)) || (!TextUtils.isEmpty(this.adAppLink)))
    {
      AppMethodBeat.o(83583);
      return true;
    }
    AppMethodBeat.o(83583);
    return false;
  }
  
  public boolean isDBTriggered()
  {
    AppMethodBeat.i(83585);
    if (this.itemList == null)
    {
      AppMethodBeat.o(83585);
      return false;
    }
    if (hasCustomVideoFilter())
    {
      AppMethodBeat.o(83585);
      return true;
    }
    Iterator localIterator = this.itemList.iterator();
    while (localIterator.hasNext()) {
      if (((StickerItem)localIterator.next()).isDBTriggered())
      {
        AppMethodBeat.o(83585);
        return true;
      }
    }
    AppMethodBeat.o(83585);
    return false;
  }
  
  public boolean isFlattenEar()
  {
    return this.flattenEar;
  }
  
  public boolean isFlattenNose()
  {
    return this.flattenNose;
  }
  
  public boolean isHasAudio()
  {
    AppMethodBeat.i(83581);
    Iterator localIterator = this.multiViewerItemList.iterator();
    if (localIterator.hasNext())
    {
      MultiViewerItem localMultiViewerItem = (MultiViewerItem)localIterator.next();
      if ((this.hasAudio) || (localMultiViewerItem.videoMaterial.hasAudio)) {}
      for (bool = true;; bool = false)
      {
        this.hasAudio = bool;
        break;
      }
    }
    boolean bool = this.hasAudio;
    AppMethodBeat.o(83581);
    return bool;
  }
  
  public boolean isResetWhenStartRecord()
  {
    return this.resetWhenStartRecord;
  }
  
  public boolean isSegmentRequired()
  {
    return this.segmentRequired;
  }
  
  public boolean isSupportLandscape()
  {
    return this.supportLandscape;
  }
  
  public boolean isSupportPause()
  {
    return this.supportPause;
  }
  
  public boolean isUseMesh()
  {
    return this.useMesh;
  }
  
  public boolean needBodyInfo()
  {
    return this.needBodyInfo;
  }
  
  public boolean needFaceInfo()
  {
    return this.needFaceInfo;
  }
  
  public void setAdAppLink(String paramString)
  {
    this.adAppLink = paramString;
  }
  
  public void setAdIcon(String paramString)
  {
    this.adIcon = paramString;
  }
  
  public void setAdLink(String paramString)
  {
    this.adLink = paramString;
  }
  
  public void setArParticleList(List<String> paramList)
  {
    this.arParticleList = paramList;
  }
  
  public void setArParticleType(int paramInt)
  {
    this.arParticleType = paramInt;
  }
  
  public void setAudio2Text(Audio2Text paramAudio2Text)
  {
    this.audio2Text = paramAudio2Text;
  }
  
  public void setAudio3DParams(GameParams paramGameParams)
  {
    this.audio3DParams = paramGameParams;
  }
  
  public void setBlendAlpha(double paramDouble)
  {
    this.blendAlpha = paramDouble;
  }
  
  public void setBlendMode(int paramInt)
  {
    this.blendMode = paramInt;
  }
  
  public void setCategoryFlag(int paramInt)
  {
    this.categoryFlag = paramInt;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setDetectorFlag(int paramInt)
  {
    this.detectorFlag = paramInt;
  }
  
  public void setDistortionItemList(List<DistortionItem> paramList)
  {
    this.distortionItemList = paramList;
  }
  
  public void setEnvironment(int paramInt)
  {
    this.environment = paramInt;
  }
  
  public void setFabbyParts(FabbyParts paramFabbyParts)
  {
    this.fabbyParts = paramFabbyParts;
  }
  
  public void setFaceCropItem(FaceCropItem paramFaceCropItem)
  {
    this.faceCropItem = paramFaceCropItem;
  }
  
  public void setFaceDetectType(int paramInt)
  {
    this.faceDetectType = paramInt;
  }
  
  public void setFaceExchangeImage(String paramString)
  {
    this.faceExchangeImage = paramString;
  }
  
  public void setFaceExpression(FaceExpression paramFaceExpression)
  {
    this.faceExpression = paramFaceExpression;
  }
  
  public void setFaceFeatureItemList(List<FaceFeatureItem> paramList)
  {
    this.faceFeatureItemList = paramList;
  }
  
  public void setFaceImageLayer(FaceImageLayer paramFaceImageLayer)
  {
    this.faceImageLayer = paramFaceImageLayer;
  }
  
  public void setFaceMeshItemList(List<FaceMeshItem> paramList)
  {
    this.faceMeshItemList = paramList;
  }
  
  public void setFaceMoveItemList(List<FaceMoveItem> paramList)
  {
    this.faceMoveItemList = paramList;
  }
  
  public void setFaceMoveTriangles(int[] paramArrayOfInt)
  {
    this.faceMoveTriangles = paramArrayOfInt;
  }
  
  public void setFaceOffItemList(List<FaceItem> paramList)
  {
    this.faceOffItemList = paramList;
  }
  
  public void setFacePoints(List<Float> paramList)
  {
    this.facePoints = paramList;
  }
  
  public void setFaceSwapType(int paramInt)
  {
    this.faceSwapType = paramInt;
  }
  
  public void setFaceValueDetectType(int paramInt)
  {
    this.faceValueDetectType = paramInt;
  }
  
  public void setFaceoffType(int paramInt)
  {
    this.faceoffType = paramInt;
  }
  
  public void setFeatureType(int paramInt)
  {
    this.featureType = paramInt;
  }
  
  public void setFilterBlurStrength(double paramDouble)
  {
    this.filterBlurStrength = paramDouble;
  }
  
  public void setFilterId(String paramString)
  {
    this.filterId = paramString;
  }
  
  public void setFlattenEar(boolean paramBoolean)
  {
    this.flattenEar = paramBoolean;
  }
  
  public void setFlattenNose(boolean paramBoolean)
  {
    this.flattenNose = paramBoolean;
  }
  
  public void setFov(float paramFloat)
  {
    this.fov = paramFloat;
  }
  
  public void setGameParams(GameParams paramGameParams)
  {
    this.gameParams = paramGameParams;
  }
  
  public void setGrayScale(int paramInt)
  {
    this.grayScale = paramInt;
  }
  
  public void setHandBoostEnable(int paramInt)
  {
    this.handBoostEnable = paramInt;
  }
  
  public void setHasAudio(boolean paramBoolean)
  {
    this.hasAudio = paramBoolean;
  }
  
  public void setHeadCropItemList(List<StickerItem> paramList)
  {
    this.headCropItemList = paramList;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setImageFacePointsFileName(String paramString)
  {
    this.imageFacePointsFileName = paramString;
  }
  
  public void setItemList(List<StickerItem> paramList)
  {
    this.itemList = paramList;
  }
  
  public void setItemList3D(List<StickerItem3D> paramList)
  {
    this.itemList3D = paramList;
  }
  
  public void setLipsLutPath(String paramString)
  {
    this.lipsLutPath = paramString;
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    AppMethodBeat.i(83582);
    this.maxFaceCount = Math.max(1, paramInt);
    AppMethodBeat.o(83582);
  }
  
  public void setMinAppVersion(int paramInt)
  {
    this.minAppVersion = paramInt;
  }
  
  public void setMultiViewerItemList(List<MultiViewerItem> paramList)
  {
    this.multiViewerItemList = paramList;
  }
  
  public void setNeedBodyInfo(boolean paramBoolean)
  {
    this.needBodyInfo = paramBoolean;
  }
  
  public void setNeedFaceInfo(boolean paramBoolean)
  {
    this.needFaceInfo = paramBoolean;
  }
  
  public void setOrderMode(int paramInt)
  {
    this.orderMode = paramInt;
  }
  
  public void setPhantomItemList(List<PhantomItem> paramList)
  {
    this.phantomItemList = paramList;
  }
  
  public void setRandomGroupCount(int paramInt)
  {
    this.randomGroupCount = paramInt;
  }
  
  public void setResetWhenStartRecord(boolean paramBoolean)
  {
    this.resetWhenStartRecord = paramBoolean;
  }
  
  public void setResourceList(List<String> paramList)
  {
    this.resourceList = paramList;
  }
  
  public void setSegmentFeather(int paramInt)
  {
    this.segmentFeather = paramInt;
  }
  
  public void setSegmentRequired(boolean paramBoolean)
  {
    this.segmentRequired = paramBoolean;
  }
  
  public void setSegmentStrokeColor(float[] paramArrayOfFloat)
  {
    this.segmentStrokeColor = paramArrayOfFloat;
  }
  
  public void setSegmentStrokeGap(double paramDouble)
  {
    this.segmentStrokeGap = paramDouble;
  }
  
  public void setSegmentStrokeWidth(double paramDouble)
  {
    this.segmentStrokeWidth = paramDouble;
  }
  
  public void setShaderType(int paramInt)
  {
    this.shaderType = paramInt;
  }
  
  public void setSplitScreen(float paramFloat)
  {
    this.splitScreen = paramFloat;
  }
  
  public void setSupportLandscape(boolean paramBoolean)
  {
    this.supportLandscape = paramBoolean;
  }
  
  public void setSupportPause(boolean paramBoolean)
  {
    this.supportPause = paramBoolean;
  }
  
  public void setTipsIcon(String paramString)
  {
    this.tipsIcon = paramString;
  }
  
  public void setTipsText(String paramString)
  {
    this.tipsText = paramString;
  }
  
  public void setTriggerType(int paramInt)
  {
    if ((paramInt > this.triggerType) && (paramInt < 100)) {
      this.triggerType = paramInt;
    }
  }
  
  public void setUseMesh(boolean paramBoolean)
  {
    this.useMesh = paramBoolean;
  }
  
  public void setVideoFilterEffect(VideoFilterEffect paramVideoFilterEffect)
  {
    this.videoFilterEffect = paramVideoFilterEffect;
  }
  
  public void setVoicekind(int paramInt)
  {
    this.voicekind = paramInt;
  }
  
  public void setWeiboTag(String paramString)
  {
    this.weiboTag = paramString;
  }
  
  public String toString()
  {
    AppMethodBeat.i(83584);
    String str = "VideoMaterial{dataPath='" + this.dataPath + '\'' + ", hasAudio=" + this.hasAudio + ", minAppVersion=" + this.minAppVersion + ", shaderType=" + this.shaderType + ", faceoffType=" + this.faceoffType + ", maxFaceCount=" + this.maxFaceCount + ", voicekind=" + this.voicekind + ", environment=" + this.environment + ", resourceList=" + this.resourceList + ", itemList=" + this.itemList + ", itemList3D=" + this.itemList3D + ", faceOffItemList=" + this.faceOffItemList + ", headCropItemList=" + this.headCropItemList + ", distortionItemList=" + this.distortionItemList + ", faceMeshItemList=" + this.faceMeshItemList + ", faceMoveItemList=" + this.faceMoveItemList + ", multiViewerItemList=" + this.multiViewerItemList + ", facePoints=" + this.facePoints + ", triggerType=" + this.triggerType + ", faceExchangeImage='" + this.faceExchangeImage + '\'' + ", imageFacePointsFileName='" + this.imageFacePointsFileName + '\'' + ", blendAlpha=" + this.blendAlpha + ", grayScale=" + this.grayScale + ", orderMode=" + this.orderMode + ", blendMode=" + this.blendMode + ", featureType=" + this.featureType + ", id='" + this.id + '\'' + ", supportLandscape=" + this.supportLandscape + ", randomGroupCount=" + this.randomGroupCount + ", faceMoveTriangles=" + Arrays.toString(this.faceMoveTriangles) + ", filterId='" + this.filterId + '\'' + ", filterBlurStrength='" + this.filterBlurStrength + '\'' + ", videoFilterEffect=" + this.videoFilterEffect + ", faceSwapType=" + this.faceSwapType + ", arParticleType=" + this.arParticleType + ", arParticleList=" + this.arParticleList + ", faceDetectType=" + this.faceDetectType + ", faceExpression=" + this.faceExpression + ", faceImageLayer=" + this.faceImageLayer + ", tipsText='" + this.tipsText + '\'' + ", tipsIcon='" + this.tipsIcon + '\'' + ", faceCropItem=" + this.faceCropItem + ", faceValueDetectType=" + this.faceValueDetectType + ", adIcon='" + this.adIcon + '\'' + ", adLink='" + this.adLink + '\'' + ", adAppLink='" + this.adAppLink + '\'' + ", weiboTag='" + this.weiboTag + '\'' + ", lipsLutPath='" + this.lipsLutPath + '\'' + ", useMesh=" + this.useMesh + ", detectorFlag=" + this.detectorFlag + ", segmentRequired=" + this.segmentRequired + ", segmentStrokeWidth=" + this.segmentStrokeWidth + ", segmentStrokeGap=" + this.segmentStrokeGap + ", segmentStrokeColor=" + Arrays.toString(this.segmentStrokeColor) + ", segmentFeather=" + this.segmentFeather + ", fabbyParts=" + this.fabbyParts + ", categoryFlag=" + this.categoryFlag + ", needFaceInfo=" + this.needFaceInfo + ", fov=" + this.fov + ", gameParams=" + this.gameParams + ", auido2Text=" + this.audio2Text + ", audio3DParams=" + this.audio3DParams + '}';
    AppMethodBeat.o(83584);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.model.VideoMaterial
 * JD-Core Version:    0.7.0.1
 */