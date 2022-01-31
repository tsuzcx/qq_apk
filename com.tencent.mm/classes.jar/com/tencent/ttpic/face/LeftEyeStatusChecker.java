package com.tencent.ttpic.face;

import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;

public class LeftEyeStatusChecker
  implements FaceStatusChecker
{
  private static LeftEyeStatusChecker instance = new LeftEyeStatusChecker();
  
  public static LeftEyeStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    return paramFaceRangeStatus.leftEye;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramFeatureStatValueRange == null)) {}
    while ((paramFaceRangeStatus.leftEye < paramFeatureStatValueRange.min) || (paramFaceRangeStatus.leftEye > paramFeatureStatValueRange.max)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.face.LeftEyeStatusChecker
 * JD-Core Version:    0.7.0.1
 */