package com.tencent.mm.ui.widget.progress;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.a;

public class MMProgressWheel
  extends View
{
  private static final String TAG;
  private final int AJI;
  private final int AJJ;
  private final long AJK;
  private int AJL;
  private int AJM;
  private boolean AJN;
  private double AJO;
  private double AJP;
  private float AJQ;
  private boolean AJR;
  private long AJS;
  private int AJT;
  private int AJU;
  private Paint AJV;
  private Paint AJW;
  private RectF AJX;
  private float AJY;
  private long AJZ;
  private boolean AKa;
  private float AKb;
  private boolean AKc;
  private MMProgressWheel.a AKd;
  private boolean AKe;
  private float Tb;
  private int circleRadius;
  
  static
  {
    AppMethodBeat.i(112958);
    TAG = MMProgressWheel.class.getSimpleName();
    AppMethodBeat.o(112958);
  }
  
  public MMProgressWheel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112940);
    this.AJI = 16;
    this.AJJ = 270;
    this.AJK = 200L;
    this.circleRadius = 28;
    this.AJL = 4;
    this.AJM = 4;
    this.AJN = false;
    this.AJO = 0.0D;
    this.AJP = 460.0D;
    this.AJQ = 0.0F;
    this.AJR = true;
    this.AJS = 0L;
    this.AJT = -1442840576;
    this.AJU = 16777215;
    this.AJV = new Paint();
    this.AJW = new Paint();
    this.AJX = new RectF();
    this.AJY = 230.0F;
    this.AJZ = 0L;
    this.Tb = 0.0F;
    this.AKb = 0.0F;
    this.AKc = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMProgressWheel);
    paramAttributeSet = getContext().getResources().getDisplayMetrics();
    this.AJL = ((int)TypedValue.applyDimension(1, this.AJL, paramAttributeSet));
    this.AJM = ((int)TypedValue.applyDimension(1, this.AJM, paramAttributeSet));
    this.circleRadius = ((int)TypedValue.applyDimension(1, this.circleRadius, paramAttributeSet));
    this.circleRadius = ((int)paramContext.getDimension(6, this.circleRadius));
    this.AJN = paramContext.getBoolean(7, false);
    this.AJL = ((int)paramContext.getDimension(8, this.AJL));
    this.AJM = ((int)paramContext.getDimension(3, this.AJM));
    this.AJY = (paramContext.getFloat(4, this.AJY / 360.0F) * 360.0F);
    this.AJP = paramContext.getInt(5, (int)this.AJP);
    this.AJT = paramContext.getColor(1, this.AJT);
    this.AJU = paramContext.getColor(2, this.AJU);
    this.AKa = paramContext.getBoolean(9, false);
    if (paramContext.getBoolean(0, false))
    {
      this.AJZ = SystemClock.uptimeMillis();
      this.AKc = true;
      invalidate();
    }
    paramContext.recycle();
    float f;
    if (Build.VERSION.SDK_INT >= 17)
    {
      f = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      if (f == 0.0F) {
        break label433;
      }
    }
    for (;;)
    {
      this.AKe = bool;
      AppMethodBeat.o(112940);
      return;
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
      label433:
      bool = false;
    }
  }
  
  private void dPy()
  {
    AppMethodBeat.i(112943);
    this.AJV.setColor(this.AJT);
    this.AJV.setAntiAlias(true);
    this.AJV.setStyle(Paint.Style.STROKE);
    this.AJV.setStrokeWidth(this.AJL);
    this.AJW.setColor(this.AJU);
    this.AJW.setAntiAlias(true);
    this.AJW.setStyle(Paint.Style.STROKE);
    this.AJW.setStrokeWidth(this.AJM);
    AppMethodBeat.o(112943);
  }
  
  private void dPz()
  {
    AppMethodBeat.i(112947);
    if (this.AKd != null) {
      Math.round(this.Tb * 100.0F / 360.0F);
    }
    AppMethodBeat.o(112947);
  }
  
  public int getBarColor()
  {
    return this.AJT;
  }
  
  public int getBarWidth()
  {
    return this.AJL;
  }
  
  public int getCircleRadius()
  {
    return this.circleRadius;
  }
  
  public float getProgress()
  {
    if (this.AKc) {
      return -1.0F;
    }
    return this.Tb / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.AJU;
  }
  
  public int getRimWidth()
  {
    return this.AJM;
  }
  
  public float getSpinSpeed()
  {
    return this.AJY / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(112945);
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.AJX, 360.0F, 360.0F, false, this.AJW);
    if (!this.AKe)
    {
      AppMethodBeat.o(112945);
      return;
    }
    float f2;
    if (this.AKc)
    {
      long l = SystemClock.uptimeMillis() - this.AJZ;
      f1 = (float)l * this.AJY / 1000.0F;
      boolean bool;
      if (this.AJS >= 200L)
      {
        double d = this.AJO;
        this.AJO = (l + d);
        if (this.AJO > this.AJP)
        {
          this.AJO -= this.AJP;
          this.AJS = 0L;
          if (!this.AJR)
          {
            bool = true;
            this.AJR = bool;
          }
        }
        else
        {
          f2 = (float)Math.cos((this.AJO / this.AJP + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
          if (!this.AJR) {
            break label307;
          }
          this.AJQ = (f2 * 254.0F);
        }
      }
      for (;;)
      {
        this.Tb += f1;
        if (this.Tb > 360.0F) {
          this.Tb -= 360.0F;
        }
        this.AJZ = SystemClock.uptimeMillis();
        f1 = this.Tb - 90.0F;
        f2 = 16.0F + this.AJQ;
        if (isInEditMode())
        {
          f1 = 0.0F;
          f2 = 135.0F;
        }
        paramCanvas.drawArc(this.AJX, f1, f2, false, this.AJV);
        if (i != 0) {
          invalidate();
        }
        AppMethodBeat.o(112945);
        return;
        bool = false;
        break;
        label307:
        f2 = (1.0F - f2) * 254.0F;
        this.Tb += this.AJQ - f2;
        this.AJQ = f2;
        continue;
        this.AJS = (l + this.AJS);
      }
    }
    float f1 = this.Tb;
    if (this.Tb != this.AKb)
    {
      this.Tb = Math.min((float)(SystemClock.uptimeMillis() - this.AJZ) / 1000.0F * this.AJY + this.Tb, this.AKb);
      this.AJZ = SystemClock.uptimeMillis();
    }
    for (i = j;; i = 0)
    {
      if (f1 != this.Tb) {
        dPz();
      }
      f2 = 0.0F;
      f1 = this.Tb;
      if (!this.AKa)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.Tb / 360.0F, 4.0D)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.Tb / 360.0F, 2.0D)) * 360.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.AJX, f2 - 90.0F, f1, false, this.AJV);
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112941);
    super.onMeasure(paramInt1, paramInt2);
    int k = this.circleRadius + getPaddingLeft() + getPaddingRight();
    int i = this.circleRadius + getPaddingTop() + getPaddingBottom();
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (n != 1073741824)
    {
      paramInt1 = k;
      if (n != -2147483648) {}
    }
    for (paramInt1 = Math.min(k, m);; paramInt1 = m)
    {
      if ((i1 == 1073741824) || (n == 1073741824)) {
        paramInt2 = j;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt1, paramInt2);
        AppMethodBeat.o(112941);
        return;
        paramInt2 = i;
        if (i1 == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(112950);
    if (!(paramParcelable instanceof MMProgressWheel.WheelSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(112950);
      return;
    }
    paramParcelable = (MMProgressWheel.WheelSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Tb = paramParcelable.Tb;
    this.AKb = paramParcelable.AKb;
    this.AKc = paramParcelable.AKc;
    this.AJY = paramParcelable.AJY;
    this.AJL = paramParcelable.AJL;
    this.AJT = paramParcelable.AJT;
    this.AJM = paramParcelable.AJM;
    this.AJU = paramParcelable.AJU;
    this.circleRadius = paramParcelable.circleRadius;
    this.AKa = paramParcelable.AKa;
    this.AJN = paramParcelable.AJN;
    this.AJZ = SystemClock.uptimeMillis();
    AppMethodBeat.o(112950);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(112949);
    MMProgressWheel.WheelSavedState localWheelSavedState = new MMProgressWheel.WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.Tb = this.Tb;
    localWheelSavedState.AKb = this.AKb;
    localWheelSavedState.AKc = this.AKc;
    localWheelSavedState.AJY = this.AJY;
    localWheelSavedState.AJL = this.AJL;
    localWheelSavedState.AJT = this.AJT;
    localWheelSavedState.AJM = this.AJM;
    localWheelSavedState.AJU = this.AJU;
    localWheelSavedState.circleRadius = this.circleRadius;
    localWheelSavedState.AKa = this.AKa;
    localWheelSavedState.AJN = this.AJN;
    AppMethodBeat.o(112949);
    return localWheelSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(112942);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt4 = getPaddingTop();
    int i = getPaddingBottom();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    if (!this.AJN)
    {
      paramInt3 = Math.min(Math.min(paramInt1 - j - k, paramInt2 - i - paramInt4), this.circleRadius * 2 - this.AJL * 2);
      paramInt1 = j + (paramInt1 - j - k - paramInt3) / 2;
      paramInt2 = paramInt4 + (paramInt2 - paramInt4 - i - paramInt3) / 2;
    }
    for (this.AJX = new RectF(this.AJL + paramInt1, this.AJL + paramInt2, paramInt1 + paramInt3 - this.AJL, paramInt2 + paramInt3 - this.AJL);; this.AJX = new RectF(j + this.AJL, paramInt4 + this.AJL, paramInt1 - k - this.AJL, paramInt2 - i - this.AJL))
    {
      dPy();
      invalidate();
      AppMethodBeat.o(112942);
      return;
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(112946);
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      this.AJZ = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(112946);
  }
  
  public void setBarColor(int paramInt)
  {
    AppMethodBeat.i(112955);
    this.AJT = paramInt;
    dPy();
    if (!this.AKc) {
      invalidate();
    }
    AppMethodBeat.o(112955);
  }
  
  public void setBarWidth(int paramInt)
  {
    AppMethodBeat.i(112954);
    this.AJL = paramInt;
    if (!this.AKc) {
      invalidate();
    }
    AppMethodBeat.o(112954);
  }
  
  public void setCallback(MMProgressWheel.a parama)
  {
    AppMethodBeat.i(112944);
    this.AKd = parama;
    if (!this.AKc) {
      dPz();
    }
    AppMethodBeat.o(112944);
  }
  
  public void setCircleRadius(int paramInt)
  {
    AppMethodBeat.i(112953);
    this.circleRadius = paramInt;
    if (!this.AKc) {
      invalidate();
    }
    AppMethodBeat.o(112953);
  }
  
  public void setInstantProgress(float paramFloat)
  {
    AppMethodBeat.i(112948);
    if (this.AKc)
    {
      this.Tb = 0.0F;
      this.AKc = false;
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.AKb) <= 0.0F)
    {
      AppMethodBeat.o(112948);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.AKb = Math.min(f * 360.0F, 360.0F);
    this.Tb = this.AKb;
    this.AJZ = SystemClock.uptimeMillis();
    invalidate();
    AppMethodBeat.o(112948);
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(112952);
    this.AKa = paramBoolean;
    if (!this.AKc) {
      invalidate();
    }
    AppMethodBeat.o(112952);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(112951);
    if (this.AKc)
    {
      this.Tb = 0.0F;
      this.AKc = false;
      dPz();
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.AKb) <= 0.0F)
    {
      AppMethodBeat.o(112951);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    if (this.Tb == this.AKb) {
      this.AJZ = SystemClock.uptimeMillis();
    }
    this.AKb = Math.min(f * 360.0F, 360.0F);
    invalidate();
    AppMethodBeat.o(112951);
  }
  
  public void setRimColor(int paramInt)
  {
    AppMethodBeat.i(112956);
    this.AJU = paramInt;
    dPy();
    if (!this.AKc) {
      invalidate();
    }
    AppMethodBeat.o(112956);
  }
  
  public void setRimWidth(int paramInt)
  {
    AppMethodBeat.i(112957);
    this.AJM = paramInt;
    if (!this.AKc) {
      invalidate();
    }
    AppMethodBeat.o(112957);
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.AJY = (360.0F * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel
 * JD-Core Version:    0.7.0.1
 */