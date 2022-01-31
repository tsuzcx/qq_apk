package com.tencent.ttpic.model;

import android.text.TextUtils;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import java.util.Arrays;
import java.util.List;

public class VideoMaterial
{
  private String adAppLink;
  private String adIcon;
  private String adLink;
  private List<String> arParticleList;
  private int arParticleType;
  private double blendAlpha;
  private int blendMode;
  private int categoryFlag;
  private String dataPath;
  private int detectorFlag;
  private List<DistortionItem> distortionItemList;
  private FabbyParts fabbyParts;
  private FaceCropItem faceCropItem;
  private int faceDetectType;
  private String faceExchangeImage;
  private FaceExpression faceExpression;
  private VideoMaterial.FaceImageLayer faceImageLayer;
  private List<FaceMeshItem> faceMeshItemList;
  private List<FaceMoveItem> faceMoveItemList;
  private int[] faceMoveTriangles;
  private List<FaceItem> faceOffItemList;
  private List<Float> facePoints;
  private int faceSwapType;
  private int faceValueDetectType;
  private int faceoffType;
  private int featureType;
  private String filterId;
  private boolean flattenEar;
  private boolean flattenNose;
  private float fov;
  private GameParams gameParams;
  private int grayScale;
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
  private boolean needFaceInfo = true;
  private int orderMode;
  private int randomGroupCount;
  private List<String> resourceList;
  private int segmentFeather;
  private boolean segmentRequired = false;
  private float[] segmentStrokeColor;
  private double segmentStrokeGap;
  private double segmentStrokeWidth;
  private int shaderType;
  private boolean supportLandscape;
  private String tipsIcon;
  private String tipsText;
  private int triggerType;
  private boolean useMesh = false;
  private VideoFilterEffect videoFilterEffect;
  private String weiboTag;
  
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
  
  public VideoMaterial.FaceImageLayer getFaceImageLayer()
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
  
  public String getWeiboTag()
  {
    return this.weiboTag;
  }
  
  public boolean hasAd()
  {
    return (!TextUtils.isEmpty(this.adIcon)) || (!TextUtils.isEmpty(this.adLink)) || (!TextUtils.isEmpty(this.adAppLink));
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
    return this.hasAudio;
  }
  
  public boolean isSegmentRequired()
  {
    return this.segmentRequired;
  }
  
  public boolean isSupportLandscape()
  {
    return this.supportLandscape;
  }
  
  public boolean isUseMesh()
  {
    return this.useMesh;
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
  
  public void setFaceImageLayer(VideoMaterial.FaceImageLayer paramFaceImageLayer)
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
    this.maxFaceCount = Math.max(1, paramInt);
  }
  
  public void setMinAppVersion(int paramInt)
  {
    this.minAppVersion = paramInt;
  }
  
  public void setMultiViewerItemList(List<MultiViewerItem> paramList)
  {
    this.multiViewerItemList = paramList;
  }
  
  public void setNeedFaceInfo(boolean paramBoolean)
  {
    this.needFaceInfo = paramBoolean;
  }
  
  public void setOrderMode(int paramInt)
  {
    this.orderMode = paramInt;
  }
  
  public void setRandomGroupCount(int paramInt)
  {
    this.randomGroupCount = paramInt;
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
  
  public void setSupportLandscape(boolean paramBoolean)
  {
    this.supportLandscape = paramBoolean;
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
  
  public void setWeiboTag(String paramString)
  {
    this.weiboTag = paramString;
  }
  
  public String toString()
  {
    return "VideoMaterial{dataPath='" + this.dataPath + '\'' + ", hasAudio=" + this.hasAudio + ", minAppVersion=" + this.minAppVersion + ", shaderType=" + this.shaderType + ", faceoffType=" + this.faceoffType + ", maxFaceCount=" + this.maxFaceCount + ", resourceList=" + this.resourceList + ", itemList=" + this.itemList + ", itemList3D=" + this.itemList3D + ", faceOffItemList=" + this.faceOffItemList + ", headCropItemList=" + this.headCropItemList + ", distortionItemList=" + this.distortionItemList + ", faceMeshItemList=" + this.faceMeshItemList + ", faceMoveItemList=" + this.faceMoveItemList + ", multiViewerItemList=" + this.multiViewerItemList + ", facePoints=" + this.facePoints + ", triggerType=" + this.triggerType + ", faceExchangeImage='" + this.faceExchangeImage + '\'' + ", imageFacePointsFileName='" + this.imageFacePointsFileName + '\'' + ", blendAlpha=" + this.blendAlpha + ", grayScale=" + this.grayScale + ", orderMode=" + this.orderMode + ", blendMode=" + this.blendMode + ", featureType=" + this.featureType + ", id='" + this.id + '\'' + ", supportLandscape=" + this.supportLandscape + ", randomGroupCount=" + this.randomGroupCount + ", faceMoveTriangles=" + Arrays.toString(this.faceMoveTriangles) + ", filterId='" + this.filterId + '\'' + ", videoFilterEffect=" + this.videoFilterEffect + ", faceSwapType=" + this.faceSwapType + ", arParticleType=" + this.arParticleType + ", arParticleList=" + this.arParticleList + ", faceDetectType=" + this.faceDetectType + ", faceExpression=" + this.faceExpression + ", faceImageLayer=" + this.faceImageLayer + ", tipsText='" + this.tipsText + '\'' + ", tipsIcon='" + this.tipsIcon + '\'' + ", faceCropItem=" + this.faceCropItem + ", faceValueDetectType=" + this.faceValueDetectType + ", adIcon='" + this.adIcon + '\'' + ", adLink='" + this.adLink + '\'' + ", adAppLink='" + this.adAppLink + '\'' + ", weiboTag='" + this.weiboTag + '\'' + ", lipsLutPath='" + this.lipsLutPath + '\'' + ", useMesh=" + this.useMesh + ", detectorFlag=" + this.detectorFlag + ", segmentRequired=" + this.segmentRequired + ", segmentStrokeWidth=" + this.segmentStrokeWidth + ", segmentStrokeGap=" + this.segmentStrokeGap + ", segmentStrokeColor=" + Arrays.toString(this.segmentStrokeColor) + ", segmentFeather=" + this.segmentFeather + ", fabbyParts=" + this.fabbyParts + ", categoryFlag=" + this.categoryFlag + ", needFaceInfo=" + this.needFaceInfo + ", fov=" + this.fov + ", gameParams=" + this.gameParams + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.model.VideoMaterial
 * JD-Core Version:    0.7.0.1
 */