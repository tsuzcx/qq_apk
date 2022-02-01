package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.at;

public class ImageIndicatorView
  extends View
{
  public int FdA;
  private int maZ;
  private Paint paint;
  private int radius;
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203980);
    this.paint = new Paint();
    this.FdA = 0;
    this.maZ = 0;
    this.radius = 0;
    init();
    AppMethodBeat.o(203980);
  }
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203981);
    this.paint = new Paint();
    this.FdA = 0;
    this.maZ = 0;
    this.radius = 0;
    init();
    AppMethodBeat.o(203981);
  }
  
  private void init()
  {
    AppMethodBeat.i(203982);
    this.maZ = at.fromDPToPix(getContext(), 4);
    this.radius = at.fromDPToPix(getContext(), 2);
    AppMethodBeat.o(203982);
  }
  
  public final void aan(int paramInt)
  {
    this.FdA = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(203983);
    if (this.FdA > 0)
    {
      int j = getMeasuredWidth() / 2;
      int i = j;
      if (this.FdA > 1) {
        i = j - (this.FdA * (this.radius + this.radius) + (this.FdA - 1) * this.maZ) / 2;
      }
      j = 0;
      if (j < this.FdA)
      {
        if (j == 0) {
          this.paint.setColor(getContext().getResources().getColor(2131099793));
        }
        for (;;)
        {
          int k = getPaddingBottom();
          int m = getPaddingTop();
          int n = getMeasuredHeight();
          float f = (this.maZ + this.radius + this.radius) * j + i;
          int i1 = getPaddingTop();
          paramCanvas.drawCircle(f, (n - (k + m)) / 2 + i1, this.radius, this.paint);
          j += 1;
          break;
          this.paint.setColor(getContext().getResources().getColor(2131099687));
        }
      }
    }
    AppMethodBeat.o(203983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView
 * JD-Core Version:    0.7.0.1
 */