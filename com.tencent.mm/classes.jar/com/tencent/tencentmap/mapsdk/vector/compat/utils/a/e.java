package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
  extends TextView
{
  private int a = 0;
  private int b = 0;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(217570);
    paramCanvas.translate(this.b / 2, this.a / 2);
    super.draw(paramCanvas);
    AppMethodBeat.o(217570);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217569);
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    int i = Math.max(paramInt1, paramInt2);
    if (paramInt1 > paramInt2) {
      this.a = (paramInt1 - paramInt2);
    }
    for (this.b = 0;; this.b = (paramInt2 - paramInt1))
    {
      setMeasuredDimension(i, i);
      AppMethodBeat.o(217569);
      return;
      this.a = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.a.e
 * JD-Core Version:    0.7.0.1
 */