package com.tencent.ttpic.face;

import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;

public class RightEyeStatusChecker
  implements FaceStatusChecker
{
  private static RightEyeStatusChecker instance = new RightEyeStatusChecker();
  
  public static RightEyeStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    return paramFaceRangeStatus.rightEye;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramFeatureStatValueRange == null)) {}
    while ((paramFaceRangeStatus.rightEye < paramFeatureStatValueRange.min) || (paramFaceRangeStatus.rightEye > paramFeatureStatValueRange.max)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.face.RightEyeStatusChecker
 * JD-Core Version:    0.7.0.1
 */