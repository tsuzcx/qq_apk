package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.ui.bd;

public class ImageIndicatorView
  extends View
{
  public int RVj;
  public int RVk;
  private Paint paint;
  private int radius;
  private int sep;
  public int ymh;
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(308455);
    this.paint = new Paint();
    this.RVj = 0;
    this.sep = 0;
    this.radius = 0;
    this.ymh = 0;
    this.RVk = 0;
    init();
    AppMethodBeat.o(308455);
  }
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(308457);
    this.paint = new Paint();
    this.RVj = 0;
    this.sep = 0;
    this.radius = 0;
    this.ymh = 0;
    this.RVk = 0;
    init();
    AppMethodBeat.o(308457);
  }
  
  private void init()
  {
    AppMethodBeat.i(308460);
    this.sep = bd.fromDPToPix(getContext(), 4);
    this.radius = bd.fromDPToPix(getContext(), 2);
    AppMethodBeat.o(308460);
  }
  
  public final void amK(int paramInt)
  {
    this.RVj = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(308470);
    if (this.RVj > 0)
    {
      int j = getMeasuredWidth() / 2;
      int i = j;
      if (this.RVj > 1) {
        i = j - (this.RVj * (this.radius + this.radius) + (this.RVj - 1) * this.sep) / 2;
      }
      j = 0;
      if (j < this.RVj)
      {
        if (j == 0) {
          if (this.ymh != 0) {
            this.paint.setColor(getContext().getResources().getColor(this.ymh));
          }
        }
        for (;;)
        {
          int k = getPaddingBottom();
          int m = getPaddingTop();
          int n = getMeasuredHeight();
          float f = (this.sep + this.radius + this.radius) * j + i;
          int i1 = getPaddingTop();
          paramCanvas.drawCircle(f, (n - (k + m)) / 2 + i1, this.radius, this.paint);
          j += 1;
          break;
          this.paint.setColor(getContext().getResources().getColor(b.c.Orange_100));
          continue;
          if (this.RVk != 0) {
            this.paint.setColor(getContext().getResources().getColor(this.RVk));
          } else {
            this.paint.setColor(getContext().getResources().getColor(b.c.BW_90));
          }
        }
      }
    }
    AppMethodBeat.o(308470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView
 * JD-Core Version:    0.7.0.1
 */