package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ui.al;

public class MMSwitchBtn
  extends View
{
  public boolean ADA;
  private RectF ADB;
  private RectF ADC;
  private int ADE;
  private int ADF;
  private int ADG;
  private String ADH;
  private String ADI;
  private MMSwitchBtn.b ADJ;
  private a ADK;
  private long ADo;
  private int ADp;
  private int ADq;
  private int ADr;
  private boolean ADs;
  private boolean ADt;
  private float ADu;
  private float ADv;
  private int ADw;
  private int ADx;
  private int ADy;
  private int ADz;
  private int edgePadding;
  private Paint kMA;
  private int maxHeight;
  private int maxWidth;
  private int nwj;
  private float sly;
  private float slz;
  
  public MMSwitchBtn(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(112580);
    this.ADs = false;
    this.ADt = false;
    this.ADA = false;
    this.kMA = new Paint(1);
    this.ADB = new RectF();
    this.ADC = new RectF();
    this.ADJ = new MMSwitchBtn.b(this, (byte)0);
    init();
    AppMethodBeat.o(112580);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112579);
    this.ADs = false;
    this.ADt = false;
    this.ADA = false;
    this.kMA = new Paint(1);
    this.ADB = new RectF();
    this.ADC = new RectF();
    this.ADJ = new MMSwitchBtn.b(this, (byte)0);
    init();
    c(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(112579);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112578);
    this.ADs = false;
    this.ADt = false;
    this.ADA = false;
    this.kMA = new Paint(1);
    this.ADB = new RectF();
    this.ADC = new RectF();
    this.ADJ = new MMSwitchBtn.b(this, (byte)0);
    init();
    c(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(112578);
  }
  
  private void c(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(112582);
    this.ADF = paramTypedArray.getColor(0, this.ADy);
    this.ADE = paramTypedArray.getColor(1, this.ADx);
    this.ADG = paramTypedArray.getColor(2, this.ADw);
    this.ADH = paramTypedArray.getString(3);
    this.ADI = paramTypedArray.getString(4);
    paramTypedArray.recycle();
    AppMethodBeat.o(112582);
  }
  
  private void dOI()
  {
    if (this.ADr < this.maxHeight) {
      this.ADC.top = ((this.maxHeight - this.ADr) / 2 + this.edgePadding);
    }
    for (this.ADC.bottom = (this.ADC.top + this.ADr - this.edgePadding * 2); this.ADA; this.ADC.bottom = (this.maxHeight - this.edgePadding))
    {
      this.ADC.left = (this.ADq + this.edgePadding);
      this.ADC.right = (this.maxWidth - this.edgePadding);
      return;
      this.ADC.top = this.edgePadding;
    }
    this.ADC.left = this.edgePadding;
    this.ADC.right = ((int)(this.ADv * 2.0F) + this.edgePadding);
  }
  
  private void dOJ()
  {
    if (this.ADC.left < this.edgePadding) {
      this.ADC.left = this.edgePadding;
    }
    if (this.ADC.left > this.ADq + this.edgePadding) {
      this.ADC.left = (this.ADq + this.edgePadding);
    }
    this.ADC.right = (this.ADC.left + (int)(this.ADv * 2.0F));
  }
  
  private void dOe()
  {
    AppMethodBeat.i(112587);
    if (this.ADC.left > this.ADp)
    {
      rA(true);
      AppMethodBeat.o(112587);
      return;
    }
    rA(false);
    AppMethodBeat.o(112587);
  }
  
  private void gH(boolean paramBoolean)
  {
    AppMethodBeat.i(112586);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(112586);
  }
  
  private void init()
  {
    AppMethodBeat.i(112581);
    this.edgePadding = getResources().getDimensionPixelSize(2131427861);
    this.ADu = getResources().getDimensionPixelSize(2131427868);
    this.ADv = getResources().getDimensionPixelSize(2131427867);
    this.ADw = getResources().getColor(2131690709);
    this.ADx = getResources().getColor(2131690558);
    this.ADy = getResources().getColor(2131690559);
    this.ADz = getResources().getColor(2131689767);
    this.ADF = this.ADy;
    this.ADE = this.ADx;
    this.ADG = this.ADw;
    this.nwj = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(112581);
  }
  
  private void rA(boolean paramBoolean)
  {
    AppMethodBeat.i(112585);
    this.ADs = true;
    this.ADJ.reset();
    if (paramBoolean) {
      this.ADJ.ADL = (this.ADq - this.ADC.left + this.edgePadding);
    }
    for (this.ADJ.direction = 1;; this.ADJ.direction = 0)
    {
      this.ADJ.startX = this.ADC.left;
      this.ADJ.setDuration(80L * this.ADJ.ADL / this.ADq);
      startAnimation(this.ADJ);
      AppMethodBeat.o(112585);
      return;
      this.ADJ.ADL = (this.ADC.left);
    }
  }
  
  public final boolean dOH()
  {
    return this.ADA;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112589);
    int i;
    if (!isEnabled())
    {
      i = this.ADz;
      this.kMA.setAlpha(38);
    }
    for (;;)
    {
      this.kMA.setColor(i);
      paramCanvas.drawRoundRect(this.ADB, this.ADu, this.ADu, this.kMA);
      this.kMA.setColor(this.ADF);
      this.kMA.setAlpha(Math.min(255, (int)((this.ADC.left - this.edgePadding) / this.ADq * 255.0F)));
      paramCanvas.drawRoundRect(this.ADB, this.ADu, this.ADu, this.kMA);
      this.kMA.setColor(this.ADG);
      paramCanvas.drawRoundRect(this.ADC, this.ADv, this.ADv, this.kMA);
      if ((this.ADH != null) && (this.ADI != null))
      {
        Paint localPaint = new Paint();
        localPaint.setTextSize(getResources().getDimension(2131427855));
        localPaint.setTextAlign(Paint.Align.CENTER);
        localPaint.setColor(getResources().getColor(2131690711));
        localPaint.setAntiAlias(true);
        i = Math.min(255, (int)((this.ADC.left - this.edgePadding) / this.ADq * 255.0F));
        Rect localRect = new Rect();
        localPaint.getTextBounds(this.ADH, 0, this.ADH.length(), localRect);
        localPaint.setAlpha(i);
        float f2 = (this.ADB.left + this.ADB.right) / 2.0F;
        float f3 = this.ADv;
        float f4 = al.fromDPToPix(getContext(), 1);
        float f1 = (this.ADB.top + this.ADB.bottom) / 2.0F;
        f1 = localRect.height() / 2.0F + f1 - al.fromDPToPix(getContext(), 1);
        paramCanvas.drawText(this.ADH, f2 - f3 + f4, f1, localPaint);
        f2 = (this.ADB.left + this.ADB.right) / 2.0F;
        f3 = this.ADv;
        f4 = al.fromDPToPix(getContext(), 1);
        localPaint.setAlpha(255 - i);
        paramCanvas.drawText(this.ADI, f2 + f3 - f4, f1, localPaint);
      }
      AppMethodBeat.o(112589);
      return;
      i = this.ADE;
      this.kMA.setAlpha(255);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(112584);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.maxWidth = (paramInt3 - paramInt1);
    this.maxHeight = (paramInt4 - paramInt2);
    this.ADq = (this.maxWidth - (int)(this.ADv * 2.0F) - this.edgePadding * 2);
    this.ADp = (this.ADq / 2);
    this.ADr = getResources().getDimensionPixelSize(2131427866);
    if (this.ADr < this.maxHeight) {
      this.ADB.top = ((this.maxHeight - this.ADr) / 2);
    }
    for (this.ADB.bottom = (this.ADB.top + this.ADr);; this.ADB.bottom = this.maxHeight)
    {
      this.ADB.left = 0.0F;
      this.ADB.right = this.maxWidth;
      dOI();
      this.kMA.setStyle(Paint.Style.FILL);
      this.kMA.setColor(this.ADx);
      AppMethodBeat.o(112584);
      return;
      this.ADB.top = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(112588);
    if (this.ADs)
    {
      AppMethodBeat.o(112588);
      return true;
    }
    if (!isEnabled())
    {
      AppMethodBeat.o(112588);
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (this.ADt) {
        invalidate();
      }
      AppMethodBeat.o(112588);
      return true;
      clearAnimation();
      this.sly = paramMotionEvent.getX();
      this.slz = paramMotionEvent.getY();
      this.ADo = SystemClock.elapsedRealtime();
      this.ADt = false;
      continue;
      float f1;
      float f2;
      if (this.ADt)
      {
        gH(true);
        f1 = paramMotionEvent.getX();
        f2 = this.sly;
        RectF localRectF = this.ADC;
        localRectF.left = (f1 - f2 + localRectF.left);
        dOJ();
      }
      for (;;)
      {
        this.sly = paramMotionEvent.getX();
        this.slz = paramMotionEvent.getY();
        break;
        float f3 = paramMotionEvent.getX() - this.sly;
        f2 = paramMotionEvent.getY() - this.slz;
        int i = j;
        if (Math.abs(f3) >= this.nwj / 10.0F)
        {
          f1 = f2;
          if (f2 == 0.0F) {
            f1 = 1.0F;
          }
          i = j;
          if (Math.abs(f3 / f1) > 3.0F) {
            i = 1;
          }
        }
        if (i != 0)
        {
          this.ADt = true;
          gH(true);
        }
      }
      boolean bool;
      if (SystemClock.elapsedRealtime() - this.ADo < 300L) {
        if (!this.ADA)
        {
          bool = true;
          label308:
          rA(bool);
        }
      }
      for (;;)
      {
        gH(false);
        this.ADt = false;
        break;
        bool = false;
        break label308;
        dOe();
      }
      if (this.ADt) {
        dOe();
      }
      gH(false);
      this.ADt = false;
    }
  }
  
  public void setCheck(boolean paramBoolean)
  {
    AppMethodBeat.i(112583);
    if (this.ADA != paramBoolean)
    {
      clearAnimation();
      this.ADA = paramBoolean;
      dOI();
      this.ADs = false;
      invalidate();
    }
    if (paramBoolean) {}
    for (String str = getContext().getString(2131304212);; str = getContext().getString(2131304223))
    {
      setContentDescription(str);
      AppMethodBeat.o(112583);
      return;
    }
  }
  
  public void setSwitchListener(a parama)
  {
    this.ADK = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onStatusChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn
 * JD-Core Version:    0.7.0.1
 */