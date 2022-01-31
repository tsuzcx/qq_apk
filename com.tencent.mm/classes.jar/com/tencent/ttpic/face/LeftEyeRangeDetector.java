package com.tencent.ttpic.face;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class LeftEyeRangeDetector
  implements RangeDetector
{
  private static LeftEyeRangeDetector detector;
  
  static
  {
    AppMethodBeat.i(81892);
    detector = new LeftEyeRangeDetector();
    AppMethodBeat.o(81892);
  }
  
  public static LeftEyeRangeDetector getInstance()
  {
    return detector;
  }
  
  public float detectRange(List<PointF> paramList)
  {
    AppMethodBeat.i(81891);
    if ((paramList == null) || (paramList.size() < 90))
    {
      AppMethodBeat.o(81891);
      return 0.0F;
    }
    float f = AlgoUtils.getDistance((PointF)paramList.get(47), (PointF)paramList.get(48));
    if (f > 0.0F) {}
    for (f = AlgoUtils.getDistance((PointF)paramList.get(47), (PointF)paramList.get(51)) / (f / 3.0F);; f = 5.0F)
    {
      f = Math.min(f / 5.0F, 1.0F);
      AppMethodBeat.o(81891);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.face.LeftEyeRangeDetector
 * JD-Core Version:    0.7.0.1
 */