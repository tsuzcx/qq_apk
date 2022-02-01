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
  public int ASU;
  private int kVQ;
  private Paint paint;
  private int radius;
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220137);
    this.paint = new Paint();
    this.ASU = 0;
    this.kVQ = 0;
    this.radius = 0;
    init();
    AppMethodBeat.o(220137);
  }
  
  public ImageIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220138);
    this.paint = new Paint();
    this.ASU = 0;
    this.kVQ = 0;
    this.radius = 0;
    init();
    AppMethodBeat.o(220138);
  }
  
  private void init()
  {
    AppMethodBeat.i(220139);
    this.kVQ = aq.fromDPToPix(getContext(), 4);
    this.radius = aq.fromDPToPix(getContext(), 2);
    AppMethodBeat.o(220139);
  }
  
  public final void Sr(int paramInt)
  {
    this.ASU = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(220140);
    if (this.ASU > 0)
    {
      int j = getMeasuredWidth() / 2;
      int i = j;
      if (this.ASU > 1) {
        i = j - (this.ASU * (this.radius + this.radius) + (this.ASU - 1) * this.kVQ) / 2;
      }
      j = 0;
      if (j < this.ASU)
      {
        if (j == 0) {
          this.paint.setColor(getContext().getResources().getColor(2131099778));
        }
        for (;;)
        {
          paramCanvas.drawCircle((this.kVQ + this.radius + this.radius) * j + i, getMeasuredHeight() / 2, this.radius, this.paint);
          j += 1;
          break;
          this.paint.setColor(getContext().getResources().getColor(2131099678));
        }
      }
    }
    AppMethodBeat.o(220140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView
 * JD-Core Version:    0.7.0.1
 */