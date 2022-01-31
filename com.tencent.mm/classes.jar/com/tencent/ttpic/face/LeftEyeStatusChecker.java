package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class LeftEyeStatusChecker
  implements FaceStatusChecker
{
  private static LeftEyeStatusChecker instance;
  
  static
  {
    AppMethodBeat.i(81893);
    instance = new LeftEyeStatusChecker();
    AppMethodBeat.o(81893);
  }
  
  public static LeftEyeStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return paramFaceRangeStatus.leftEye;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramValueRange == null)) {}
    while ((paramFaceRangeStatus.leftEye < paramValueRange.min) || (paramFaceRangeStatus.leftEye > paramValueRange.max)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.face.LeftEyeStatusChecker
 * JD-Core Version:    0.7.0.1
 */