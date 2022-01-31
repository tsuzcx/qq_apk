package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class FabbyFaceActionCounter
  extends FaceActionCounter
{
  public Map<Integer, PointF> scaleMap;
  
  public FabbyFaceActionCounter(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
    AppMethodBeat.i(83481);
    this.scaleMap = new HashMap();
    AppMethodBeat.o(83481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.FabbyFaceActionCounter
 * JD-Core Version:    0.7.0.1
 */