package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aq;

public class ImageIndicatorView
  extends View
{
  public int ABt;
  private int kSh;
  private Paint paint;
  private int radius;
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198590);
    this.paint = new Paint();
    this.ABt = 0;
    this.kSh = 0;
    this.radius = 0;
    init();
    AppMethodBeat.o(198590);
  }
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198591);
    this.paint = new Paint();
    this.ABt = 0;
    this.kSh = 0;
    this.radius = 0;
    init();
    AppMethodBeat.o(198591);
  }
  
  private void init()
  {
    AppMethodBeat.i(198592);
    this.kSh = aq.fromDPToPix(getContext(), 4);
    this.radius = aq.fromDPToPix(getContext(), 2);
    AppMethodBeat.o(198592);
  }
  
  public final void RK(int paramInt)
  {
    this.ABt = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(198593);
    if (this.ABt > 0)
    {
      int j = getMeasuredWidth() / 2;
      int i = j;
      if (this.ABt > 1) {
        i = j - (this.ABt * (this.radius + this.radius) + (this.ABt - 1) * this.kSh) / 2;
      }
      j = 0;
      if (j < this.ABt)
      {
        if (j == 0) {
          this.paint.setColor(getContext().getResources().getColor(2131099778));
        }
        for (;;)
        {
          paramCanvas.drawCircle((this.kSh + this.radius + this.radius) * j + i, getMeasuredHeight() / 2, this.radius, this.paint);
          j += 1;
          break;
          this.paint.setColor(getContext().getResources().getColor(2131099678));
        }
      }
    }
    AppMethodBeat.o(198593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView
 * JD-Core Version:    0.7.0.1
 */