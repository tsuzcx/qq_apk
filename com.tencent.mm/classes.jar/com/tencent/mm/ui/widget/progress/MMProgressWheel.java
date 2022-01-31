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
import com.tencent.mm.ci.a.k;

public class MMProgressWheel
  extends View
{
  private static final String TAG = MMProgressWheel.class.getSimpleName();
  private float St = 0.0F;
  private final int barLength = 16;
  private boolean wpA;
  private float wpB = 0.0F;
  private boolean wpC = false;
  private MMProgressWheel.a wpD;
  private boolean wpE;
  private final int wpi = 270;
  private final long wpj = 200L;
  private int wpk = 28;
  private int wpl = 4;
  private int wpm = 4;
  private boolean wpn = false;
  private double wpo = 0.0D;
  private double wpp = 460.0D;
  private float wpq = 0.0F;
  private boolean wpr = true;
  private long wps = 0L;
  private int wpt = -1442840576;
  private int wpu = 16777215;
  private Paint wpv = new Paint();
  private Paint wpw = new Paint();
  private RectF wpx = new RectF();
  private float wpy = 230.0F;
  private long wpz = 0L;
  
  public MMProgressWheel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMProgressWheel);
    paramAttributeSet = getContext().getResources().getDisplayMetrics();
    this.wpl = ((int)TypedValue.applyDimension(1, this.wpl, paramAttributeSet));
    this.wpm = ((int)TypedValue.applyDimension(1, this.wpm, paramAttributeSet));
    this.wpk = ((int)TypedValue.applyDimension(1, this.wpk, paramAttributeSet));
    this.wpk = ((int)paramContext.getDimension(a.k.MMProgressWheel_matProg_circleRadius, this.wpk));
    this.wpn = paramContext.getBoolean(a.k.MMProgressWheel_matProg_fillRadius, false);
    this.wpl = ((int)paramContext.getDimension(a.k.MMProgressWheel_matProg_barWidth, this.wpl));
    this.wpm = ((int)paramContext.getDimension(a.k.MMProgressWheel_matProg_rimWidth, this.wpm));
    this.wpy = (paramContext.getFloat(a.k.MMProgressWheel_matProg_spinSpeed, this.wpy / 360.0F) * 360.0F);
    this.wpp = paramContext.getInt(a.k.MMProgressWheel_matProg_barSpinCycleTime, (int)this.wpp);
    this.wpt = paramContext.getColor(a.k.MMProgressWheel_matProg_barColor, this.wpt);
    this.wpu = paramContext.getColor(a.k.MMProgressWheel_matProg_rimColor, this.wpu);
    this.wpA = paramContext.getBoolean(a.k.MMProgressWheel_matProg_linearProgress, false);
    if (paramContext.getBoolean(a.k.MMProgressWheel_matProg_progressIndeterminate, false))
    {
      this.wpz = SystemClock.uptimeMillis();
      this.wpC = true;
      invalidate();
    }
    paramContext.recycle();
    float f;
    if (Build.VERSION.SDK_INT >= 17)
    {
      f = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      if (f == 0.0F) {
        break label439;
      }
    }
    for (;;)
    {
      this.wpE = bool;
      return;
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
      label439:
      bool = false;
    }
  }
  
  private void cKt()
  {
    this.wpv.setColor(this.wpt);
    this.wpv.setAntiAlias(true);
    this.wpv.setStyle(Paint.Style.STROKE);
    this.wpv.setStrokeWidth(this.wpl);
    this.wpw.setColor(this.wpu);
    this.wpw.setAntiAlias(true);
    this.wpw.setStyle(Paint.Style.STROKE);
    this.wpw.setStrokeWidth(this.wpm);
  }
  
  private void cKu()
  {
    if (this.wpD != null) {
      Math.round(this.St * 100.0F / 360.0F);
    }
  }
  
  public int getBarColor()
  {
    return this.wpt;
  }
  
  public int getBarWidth()
  {
    return this.wpl;
  }
  
  public int getCircleRadius()
  {
    return this.wpk;
  }
  
  public float getProgress()
  {
    if (this.wpC) {
      return -1.0F;
    }
    return this.St / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.wpu;
  }
  
  public int getRimWidth()
  {
    return this.wpm;
  }
  
  public float getSpinSpeed()
  {
    return this.wpy / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.wpx, 360.0F, 360.0F, false, this.wpw);
    if (!this.wpE) {
      return;
    }
    float f2;
    if (this.wpC)
    {
      long l = SystemClock.uptimeMillis() - this.wpz;
      f1 = (float)l * this.wpy / 1000.0F;
      boolean bool;
      if (this.wps >= 200L)
      {
        double d = this.wpo;
        this.wpo = (l + d);
        if (this.wpo > this.wpp)
        {
          this.wpo -= this.wpp;
          this.wps = 0L;
          if (!this.wpr)
          {
            bool = true;
            this.wpr = bool;
          }
        }
        else
        {
          f2 = (float)Math.cos((this.wpo / this.wpp + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
          if (!this.wpr) {
            break label289;
          }
          this.wpq = (f2 * 254.0F);
        }
      }
      for (;;)
      {
        this.St += f1;
        if (this.St > 360.0F) {
          this.St -= 360.0F;
        }
        this.wpz = SystemClock.uptimeMillis();
        f1 = this.St - 90.0F;
        f2 = 16.0F + this.wpq;
        if (isInEditMode())
        {
          f1 = 0.0F;
          f2 = 135.0F;
        }
        paramCanvas.drawArc(this.wpx, f1, f2, false, this.wpv);
        label273:
        if (i == 0) {
          break label513;
        }
        invalidate();
        return;
        bool = false;
        break;
        label289:
        f2 = (1.0F - f2) * 254.0F;
        this.St += this.wpq - f2;
        this.wpq = f2;
        continue;
        this.wps = (l + this.wps);
      }
    }
    float f1 = this.St;
    if (this.St != this.wpB)
    {
      this.St = Math.min((float)(SystemClock.uptimeMillis() - this.wpz) / 1000.0F * this.wpy + this.St, this.wpB);
      this.wpz = SystemClock.uptimeMillis();
    }
    for (i = j;; i = 0)
    {
      if (f1 != this.St) {
        cKu();
      }
      f1 = this.St;
      if (!this.wpA)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.St / 360.0F, 4.0D));
        f1 = (float)(1.0D - Math.pow(1.0F - this.St / 360.0F, 2.0D)) * 360.0F;
      }
      for (f2 *= 360.0F;; f2 = 0.0F)
      {
        if (isInEditMode()) {
          f1 = 360.0F;
        }
        for (;;)
        {
          paramCanvas.drawArc(this.wpx, f2 - 90.0F, f1, false, this.wpv);
          break label273;
          label513:
          break;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int k = this.wpk + getPaddingLeft() + getPaddingRight();
    int i = this.wpk + getPaddingTop() + getPaddingBottom();
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
    if (!(paramParcelable instanceof MMProgressWheel.WheelSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (MMProgressWheel.WheelSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.St = paramParcelable.St;
    this.wpB = paramParcelable.wpB;
    this.wpC = paramParcelable.wpC;
    this.wpy = paramParcelable.wpy;
    this.wpl = paramParcelable.wpl;
    this.wpt = paramParcelable.wpt;
    this.wpm = paramParcelable.wpm;
    this.wpu = paramParcelable.wpu;
    this.wpk = paramParcelable.wpk;
    this.wpA = paramParcelable.wpA;
    this.wpn = paramParcelable.wpn;
    this.wpz = SystemClock.uptimeMillis();
  }
  
  public Parcelable onSaveInstanceState()
  {
    MMProgressWheel.WheelSavedState localWheelSavedState = new MMProgressWheel.WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.St = this.St;
    localWheelSavedState.wpB = this.wpB;
    localWheelSavedState.wpC = this.wpC;
    localWheelSavedState.wpy = this.wpy;
    localWheelSavedState.wpl = this.wpl;
    localWheelSavedState.wpt = this.wpt;
    localWheelSavedState.wpm = this.wpm;
    localWheelSavedState.wpu = this.wpu;
    localWheelSavedState.wpk = this.wpk;
    localWheelSavedState.wpA = this.wpA;
    localWheelSavedState.wpn = this.wpn;
    return localWheelSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt4 = getPaddingTop();
    int i = getPaddingBottom();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    if (!this.wpn)
    {
      paramInt3 = Math.min(Math.min(paramInt1 - j - k, paramInt2 - i - paramInt4), this.wpk * 2 - this.wpl * 2);
      paramInt1 = j + (paramInt1 - j - k - paramInt3) / 2;
      paramInt2 = paramInt4 + (paramInt2 - paramInt4 - i - paramInt3) / 2;
    }
    for (this.wpx = new RectF(this.wpl + paramInt1, this.wpl + paramInt2, paramInt1 + paramInt3 - this.wpl, paramInt2 + paramInt3 - this.wpl);; this.wpx = new RectF(j + this.wpl, paramInt4 + this.wpl, paramInt1 - k - this.wpl, paramInt2 - i - this.wpl))
    {
      cKt();
      invalidate();
      return;
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      this.wpz = SystemClock.uptimeMillis();
    }
  }
  
  public void setBarColor(int paramInt)
  {
    this.wpt = paramInt;
    cKt();
    if (!this.wpC) {
      invalidate();
    }
  }
  
  public void setBarWidth(int paramInt)
  {
    this.wpl = paramInt;
    if (!this.wpC) {
      invalidate();
    }
  }
  
  public void setCallback(MMProgressWheel.a parama)
  {
    this.wpD = parama;
    if (!this.wpC) {
      cKu();
    }
  }
  
  public void setCircleRadius(int paramInt)
  {
    this.wpk = paramInt;
    if (!this.wpC) {
      invalidate();
    }
  }
  
  public void setInstantProgress(float paramFloat)
  {
    if (this.wpC)
    {
      this.St = 0.0F;
      this.wpC = false;
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.wpB) <= 0.0F)
    {
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.wpB = Math.min(f * 360.0F, 360.0F);
    this.St = this.wpB;
    this.wpz = SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    this.wpA = paramBoolean;
    if (!this.wpC) {
      invalidate();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.wpC)
    {
      this.St = 0.0F;
      this.wpC = false;
      cKu();
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.wpB) <= 0.0F)
    {
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    if (this.St == this.wpB) {
      this.wpz = SystemClock.uptimeMillis();
    }
    this.wpB = Math.min(f * 360.0F, 360.0F);
    invalidate();
  }
  
  public void setRimColor(int paramInt)
  {
    this.wpu = paramInt;
    cKt();
    if (!this.wpC) {
      invalidate();
    }
  }
  
  public void setRimWidth(int paramInt)
  {
    this.wpm = paramInt;
    if (!this.wpC) {
      invalidate();
    }
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.wpy = (360.0F * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel
 * JD-Core Version:    0.7.0.1
 */