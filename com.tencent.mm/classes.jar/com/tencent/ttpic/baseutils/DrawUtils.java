package com.tencent.ttpic.baseutils;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DrawUtils
{
  private static final String TAG;
  public static Paint sPaint;
  
  static
  {
    AppMethodBeat.i(49670);
    TAG = DrawUtils.class.getSimpleName();
    sPaint = new Paint();
    AppMethodBeat.o(49670);
  }
  
  public static Paint createRGBPaint(int paramInt)
  {
    AppMethodBeat.i(49669);
    Paint localPaint = new Paint();
    localPaint.setColorFilter(new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, Color.red(paramInt), 0.0F, 0.0F, 0.0F, 0.0F, Color.green(paramInt), 0.0F, 0.0F, 0.0F, 0.0F, Color.blue(paramInt), 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
    AppMethodBeat.o(49669);
    return localPaint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.DrawUtils
 * JD-Core Version:    0.7.0.1
 */