package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class n
  extends View
{
  private Paint borderPaint;
  private int borderWidth;
  private View.OnTouchListener ncf;
  private n.a oLC;
  private boolean oLD;
  boolean oLE;
  private int oLF;
  private int oLG;
  private Drawable oLH;
  private Drawable oLI;
  private int oLJ;
  private float oLK;
  private int oLL;
  private float oLM;
  private int oLN;
  private Paint oLO;
  private float oLP;
  private Paint oLQ;
  private Paint oLR;
  private int oLS;
  private float oLT;
  private float oLU;
  private float oLV;
  private int oLW;
  private Rect oLX;
  private Rect oLY;
  private int padding;
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(55016);
    this.oLD = false;
    this.oLE = false;
    this.oLM = -1.0F;
    this.oLU = -1.0F;
    this.oLV = -1.0F;
    this.padding = 0;
    this.ncf = new n.2(this);
    this.oLJ = a.fromDPToPix(getContext(), 8);
    this.oLK = (this.oLJ * 0.5F);
    this.oLW = a.fromDPToPix(getContext(), 8);
    this.oLH = new n.b(this, a.k(getContext(), 2131232154), a.k(getContext(), 2131232153));
    this.oLI = new n.b(this, a.k(getContext(), 2131232154), a.k(getContext(), 2131232153));
    this.oLL = a.fromDPToPix(getContext(), 1);
    this.oLN = a.ao(getContext(), 2131428781);
    this.oLM = -1.0F;
    this.oLO = new Paint();
    this.oLO.setColor(a.m(getContext(), 2131690709));
    this.oLO.setAlpha(102);
    this.oLQ = new Paint();
    this.oLQ.setColor(a.m(getContext(), 2131689763));
    this.oLQ.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(a.m(getContext(), 2131690709));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderWidth = ez(getContext());
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.oLP = (this.borderWidth * 0.5F);
    this.oLR = new Paint();
    this.oLR.setColor(a.m(getContext(), 2131690709));
    this.oLR.setStyle(Paint.Style.STROKE);
    this.oLS = ez(getContext());
    this.oLT = (this.oLS * 0.5F);
    this.oLR.setStrokeWidth(this.oLS);
    this.oLR.setAlpha(178);
    setOnTouchListener(this.ncf);
    AppMethodBeat.o(55016);
  }
  
  private static int ez(Context paramContext)
  {
    AppMethodBeat.i(55017);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(55017);
    return i;
  }
  
  private boolean jr(boolean paramBoolean)
  {
    AppMethodBeat.i(55020);
    if (paramBoolean)
    {
      paramBoolean = n.b.a((n.b)this.oLH);
      AppMethodBeat.o(55020);
      return paramBoolean;
    }
    paramBoolean = n.b.a((n.b)this.oLI);
    AppMethodBeat.o(55020);
    return paramBoolean;
  }
  
  public final int getLeftSliderBound()
  {
    AppMethodBeat.i(55021);
    int i = this.oLH.getBounds().left;
    AppMethodBeat.o(55021);
    return i;
  }
  
  public final int getRightSliderBound()
  {
    AppMethodBeat.i(55022);
    int i = this.oLI.getBounds().right;
    AppMethodBeat.o(55022);
    return i;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55018);
    if (this.oLM > 0.0F)
    {
      float f = getWidth() * this.oLM;
      paramCanvas.drawRect(f - this.oLL * 0.5F, 0.0F, this.oLL * 0.5F + f, this.oLN, this.oLO);
    }
    if (!this.oLD)
    {
      AppMethodBeat.o(55018);
      return;
    }
    int i = this.oLH.getBounds().centerX();
    int j = this.oLI.getBounds().centerX();
    if ((jr(true)) || (jr(false))) {
      paramCanvas.drawRect(this.padding + this.oLT, this.oLT, getWidth() - this.padding - this.oLT, getBottom() - this.oLT, this.oLR);
    }
    if (this.oLH.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.oLQ);
    }
    if (this.oLI.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.oLQ);
    }
    paramCanvas.drawLine(i, this.oLP, j, this.oLP, this.borderPaint);
    paramCanvas.drawLine(i, getHeight() - this.oLP, j, getHeight() - this.oLP, this.borderPaint);
    this.oLH.draw(paramCanvas);
    this.oLI.draw(paramCanvas);
    AppMethodBeat.o(55018);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(140576);
    if ((this.oLX != null) && (this.oLY != null))
    {
      Rect localRect1 = new Rect(this.oLX.left, this.oLX.top, this.oLX.right, this.oLX.bottom);
      Rect localRect2 = new Rect(this.oLY.left, this.oLY.top, this.oLY.right, this.oLY.bottom);
      this.oLH.setBounds(localRect1);
      this.oLI.setBounds(localRect2);
      this.oLM = 0.0F;
      postInvalidate();
    }
    AppMethodBeat.o(140576);
  }
  
  public final void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(55019);
    if (!this.oLD)
    {
      AppMethodBeat.o(55019);
      return;
    }
    this.oLM = paramFloat;
    invalidate();
    AppMethodBeat.o(55019);
  }
  
  public final void setOnSliderTouchListener(n.a parama)
  {
    this.oLC = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.n
 * JD-Core Version:    0.7.0.1
 */