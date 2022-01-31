package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class RightEyeStatusChecker
  implements FaceStatusChecker
{
  private static RightEyeStatusChecker instance;
  
  static
  {
    AppMethodBeat.i(81905);
    instance = new RightEyeStatusChecker();
    AppMethodBeat.o(81905);
  }
  
  public static RightEyeStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return paramFaceRangeStatus.rightEye;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramValueRange == null)) {}
    while ((paramFaceRangeStatus.rightEye < paramValueRange.min) || (paramFaceRangeStatus.rightEye > paramValueRange.max)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.face.RightEyeStatusChecker
 * JD-Core Version:    0.7.0.1
 */