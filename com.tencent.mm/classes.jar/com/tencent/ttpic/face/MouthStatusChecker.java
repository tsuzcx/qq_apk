package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class MouthStatusChecker
  implements FaceStatusChecker
{
  private static MouthStatusChecker instance;
  
  static
  {
    AppMethodBeat.i(81899);
    instance = new MouthStatusChecker();
    AppMethodBeat.o(81899);
  }
  
  public static MouthStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return paramFaceRangeStatus.mouth;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramValueRange == null)) {}
    while ((paramFaceRangeStatus.mouth < paramValueRange.min) || (paramFaceRangeStatus.mouth > paramValueRange.max)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.face.MouthStatusChecker
 * JD-Core Version:    0.7.0.1
 */