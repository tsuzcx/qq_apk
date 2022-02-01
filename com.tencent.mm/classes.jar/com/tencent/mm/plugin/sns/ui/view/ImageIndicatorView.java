package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.ui.aw;

public class ImageIndicatorView
  extends View
{
  public int Lsg;
  int Lsh;
  private int oYQ;
  private Paint paint;
  private int radius;
  int vag;
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(245621);
    this.paint = new Paint();
    this.Lsg = 0;
    this.oYQ = 0;
    this.radius = 0;
    this.vag = 0;
    this.Lsh = 0;
    init();
    AppMethodBeat.o(245621);
  }
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(245622);
    this.paint = new Paint();
    this.Lsg = 0;
    this.oYQ = 0;
    this.radius = 0;
    this.vag = 0;
    this.Lsh = 0;
    init();
    AppMethodBeat.o(245622);
  }
  
  private void init()
  {
    AppMethodBeat.i(245623);
    this.oYQ = aw.fromDPToPix(getContext(), 4);
    this.radius = aw.fromDPToPix(getContext(), 2);
    AppMethodBeat.o(245623);
  }
  
  public final void ahH(int paramInt)
  {
    this.Lsg = paramInt;
  }
  
  public final void kg(int paramInt1, int paramInt2)
  {
    this.Lsh = paramInt2;
    this.vag = paramInt1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(245624);
    if (this.Lsg > 0)
    {
      int j = getMeasuredWidth() / 2;
      int i = j;
      if (this.Lsg > 1) {
        i = j - (this.Lsg * (this.radius + this.radius) + (this.Lsg - 1) * this.oYQ) / 2;
      }
      j = 0;
      if (j < this.Lsg)
      {
        if (j == 0) {
          if (this.vag != 0) {
            this.paint.setColor(getContext().getResources().getColor(this.vag));
          }
        }
        for (;;)
        {
          int k = getPaddingBottom();
          int m = getPaddingTop();
          int n = getMeasuredHeight();
          float f = (this.oYQ + this.radius + this.radius) * j + i;
          int i1 = getPaddingTop();
          paramCanvas.drawCircle(f, (n - (k + m)) / 2 + i1, this.radius, this.paint);
          j += 1;
          break;
          this.paint.setColor(getContext().getResources().getColor(i.c.Orange_100));
          continue;
          if (this.Lsh != 0) {
            this.paint.setColor(getContext().getResources().getColor(this.Lsh));
          } else {
            this.paint.setColor(getContext().getResources().getColor(i.c.BW_90));
          }
        }
      }
    }
    AppMethodBeat.o(245624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView
 * JD-Core Version:    0.7.0.1
 */