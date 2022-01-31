package com.tencent.ttpic.model;

import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import java.util.List;

public class FaceItem
{
  public int activateTriggerCount;
  public int activateTriggerTotalCount;
  public int activateTriggerType;
  public boolean alwaysTriggered = true;
  public float blendAlpha;
  public int blendMode;
  public CharmRange charmRange;
  public int countTriggerType;
  public String faceExchangeImage;
  public List<Float> facePoints;
  public int featureStatType;
  public StickerItem.FeatureStatValueRange featureStatValueRange;
  public FaceOffUtil.FEATURE_TYPE featureType;
  public int frameDuration;
  public int frameType;
  public int frames;
  public int grayScale;
  public int height;
  public String id;
  public String irisImage;
  public int personID;
  public int playCount;
  public int preTriggerType;
  public int randomGroupNum;
  public int triggerType = VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value;
  public int width;
  
  public FaceItem() {}
  
  public FaceItem(String paramString, float paramFloat, int paramInt1, int paramInt2, List<Float> paramList)
  {
    this.faceExchangeImage = paramString;
    this.blendAlpha = paramFloat;
    this.grayScale = paramInt1;
    this.featureType = FaceOffUtil.getFeatureType(paramInt2);
    this.facePoints = paramList;
    this.personID = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceItem
 * JD-Core Version:    0.7.0.1
 */