package com.tencent.mm.ui.widget.progress;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.k;

public class MMProgressWheel
  extends View
{
  private static final String TAG;
  private final int agkV;
  private final long agkW;
  private int agkX;
  private int agkY;
  private boolean agkZ;
  private double agla;
  private double aglb;
  private float aglc;
  private boolean agld;
  private long agle;
  private int aglf;
  private int aglg;
  private Paint aglh;
  private Paint agli;
  private RectF aglj;
  private float aglk;
  private long agll;
  private boolean aglm;
  private float agln;
  private boolean aglo;
  private a aglp;
  private boolean aglq;
  private final int barLength;
  private int blq;
  private float mProgress;
  
  static
  {
    AppMethodBeat.i(159683);
    TAG = MMProgressWheel.class.getSimpleName();
    AppMethodBeat.o(159683);
  }
  
  public MMProgressWheel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159665);
    this.barLength = 16;
    this.agkV = 270;
    this.agkW = 200L;
    this.blq = 28;
    this.agkX = 4;
    this.agkY = 4;
    this.agkZ = false;
    this.agla = 0.0D;
    this.aglb = 460.0D;
    this.aglc = 0.0F;
    this.agld = true;
    this.agle = 0L;
    this.aglf = -1442840576;
    this.aglg = 16777215;
    this.aglh = new Paint();
    this.agli = new Paint();
    this.aglj = new RectF();
    this.aglk = 230.0F;
    this.agll = 0L;
    this.mProgress = 0.0F;
    this.agln = 0.0F;
    this.aglo = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMProgressWheel);
    paramAttributeSet = getContext().getResources().getDisplayMetrics();
    this.agkX = ((int)TypedValue.applyDimension(1, this.agkX, paramAttributeSet));
    this.agkY = ((int)TypedValue.applyDimension(1, this.agkY, paramAttributeSet));
    this.blq = ((int)TypedValue.applyDimension(1, this.blq, paramAttributeSet));
    this.blq = ((int)paramContext.getDimension(a.k.MMProgressWheel_matProg_circleRadius, this.blq));
    this.agkZ = paramContext.getBoolean(a.k.MMProgressWheel_matProg_fillRadius, false);
    this.agkX = ((int)paramContext.getDimension(a.k.MMProgressWheel_matProg_barWidth, this.agkX));
    this.agkY = ((int)paramContext.getDimension(a.k.MMProgressWheel_matProg_rimWidth, this.agkY));
    this.aglk = (paramContext.getFloat(a.k.MMProgressWheel_matProg_spinSpeed, this.aglk / 360.0F) * 360.0F);
    this.aglb = paramContext.getInt(a.k.MMProgressWheel_matProg_barSpinCycleTime, (int)this.aglb);
    this.aglf = paramContext.getColor(a.k.MMProgressWheel_matProg_barColor, this.aglf);
    this.aglg = paramContext.getColor(a.k.MMProgressWheel_matProg_rimColor, this.aglg);
    this.aglm = paramContext.getBoolean(a.k.MMProgressWheel_matProg_linearProgress, false);
    if (paramContext.getBoolean(a.k.MMProgressWheel_matProg_progressIndeterminate, false))
    {
      this.agll = SystemClock.uptimeMillis();
      this.aglo = true;
      invalidate();
    }
    paramContext.recycle();
    float f;
    if (Build.VERSION.SDK_INT >= 17)
    {
      f = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      if (f == 0.0F) {
        break label449;
      }
    }
    for (;;)
    {
      this.aglq = bool;
      AppMethodBeat.o(159665);
      return;
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
      label449:
      bool = false;
    }
  }
  
  private void jII()
  {
    AppMethodBeat.i(159668);
    this.aglh.setColor(this.aglf);
    this.aglh.setAntiAlias(true);
    this.aglh.setStyle(Paint.Style.STROKE);
    this.aglh.setStrokeWidth(this.agkX);
    this.agli.setColor(this.aglg);
    this.agli.setAntiAlias(true);
    this.agli.setStyle(Paint.Style.STROKE);
    this.agli.setStrokeWidth(this.agkY);
    AppMethodBeat.o(159668);
  }
  
  private void jIJ()
  {
    AppMethodBeat.i(159672);
    if (this.aglp != null) {
      Math.round(this.mProgress * 100.0F / 360.0F);
    }
    AppMethodBeat.o(159672);
  }
  
  public int getBarColor()
  {
    return this.aglf;
  }
  
  public int getBarWidth()
  {
    return this.agkX;
  }
  
  public int getCircleRadius()
  {
    return this.blq;
  }
  
  public float getProgress()
  {
    if (this.aglo) {
      return -1.0F;
    }
    return this.mProgress / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.aglg;
  }
  
  public int getRimWidth()
  {
    return this.agkY;
  }
  
  public float getSpinSpeed()
  {
    return this.aglk / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(159670);
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.aglj, 360.0F, 360.0F, false, this.agli);
    if (!this.aglq)
    {
      AppMethodBeat.o(159670);
      return;
    }
    float f2;
    if (this.aglo)
    {
      long l = SystemClock.uptimeMillis() - this.agll;
      f1 = (float)l * this.aglk / 1000.0F;
      boolean bool;
      if (this.agle >= 200L)
      {
        double d = this.agla;
        this.agla = (l + d);
        if (this.agla > this.aglb)
        {
          this.agla -= this.aglb;
          this.agle = 0L;
          if (!this.agld)
          {
            bool = true;
            this.agld = bool;
          }
        }
        else
        {
          f2 = (float)Math.cos((this.agla / this.aglb + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
          if (!this.agld) {
            break label307;
          }
          this.aglc = (f2 * 254.0F);
        }
      }
      for (;;)
      {
        this.mProgress += f1;
        if (this.mProgress > 360.0F) {
          this.mProgress -= 360.0F;
        }
        this.agll = SystemClock.uptimeMillis();
        f1 = this.mProgress - 90.0F;
        f2 = 16.0F + this.aglc;
        if (isInEditMode())
        {
          f1 = 0.0F;
          f2 = 135.0F;
        }
        paramCanvas.drawArc(this.aglj, f1, f2, false, this.aglh);
        if (i != 0) {
          invalidate();
        }
        AppMethodBeat.o(159670);
        return;
        bool = false;
        break;
        label307:
        f2 = (1.0F - f2) * 254.0F;
        this.mProgress += this.aglc - f2;
        this.aglc = f2;
        continue;
        this.agle = (l + this.agle);
      }
    }
    float f1 = this.mProgress;
    if (this.mProgress != this.agln)
    {
      this.mProgress = Math.min((float)(SystemClock.uptimeMillis() - this.agll) / 1000.0F * this.aglk + this.mProgress, this.agln);
      this.agll = SystemClock.uptimeMillis();
    }
    for (i = j;; i = 0)
    {
      if (f1 != this.mProgress) {
        jIJ();
      }
      f2 = 0.0F;
      f1 = this.mProgress;
      if (!this.aglm)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 4.0D)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 2.0D)) * 360.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.aglj, f2 - 90.0F, f1, false, this.aglh);
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159666);
    super.onMeasure(paramInt1, paramInt2);
    int k = this.blq + getPaddingLeft() + getPaddingRight();
    int i = this.blq + getPaddingTop() + getPaddingBottom();
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
        AppMethodBeat.o(159666);
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
    AppMethodBeat.i(159675);
    if (!(paramParcelable instanceof WheelSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(159675);
      return;
    }
    paramParcelable = (WheelSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.mProgress = paramParcelable.mProgress;
    this.agln = paramParcelable.agln;
    this.aglo = paramParcelable.aglo;
    this.aglk = paramParcelable.aglk;
    this.agkX = paramParcelable.agkX;
    this.aglf = paramParcelable.aglf;
    this.agkY = paramParcelable.agkY;
    this.aglg = paramParcelable.aglg;
    this.blq = paramParcelable.blq;
    this.aglm = paramParcelable.aglm;
    this.agkZ = paramParcelable.agkZ;
    this.agll = SystemClock.uptimeMillis();
    AppMethodBeat.o(159675);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159674);
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.mProgress = this.mProgress;
    localWheelSavedState.agln = this.agln;
    localWheelSavedState.aglo = this.aglo;
    localWheelSavedState.aglk = this.aglk;
    localWheelSavedState.agkX = this.agkX;
    localWheelSavedState.aglf = this.aglf;
    localWheelSavedState.agkY = this.agkY;
    localWheelSavedState.aglg = this.aglg;
    localWheelSavedState.blq = this.blq;
    localWheelSavedState.aglm = this.aglm;
    localWheelSavedState.agkZ = this.agkZ;
    AppMethodBeat.o(159674);
    return localWheelSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159667);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt4 = getPaddingTop();
    int i = getPaddingBottom();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    if (!this.agkZ)
    {
      paramInt3 = Math.min(Math.min(paramInt1 - j - k, paramInt2 - i - paramInt4), this.blq * 2 - this.agkX * 2);
      paramInt1 = j + (paramInt1 - j - k - paramInt3) / 2;
      paramInt2 = paramInt4 + (paramInt2 - paramInt4 - i - paramInt3) / 2;
    }
    for (this.aglj = new RectF(this.agkX + paramInt1, this.agkX + paramInt2, paramInt1 + paramInt3 - this.agkX, paramInt2 + paramInt3 - this.agkX);; this.aglj = new RectF(j + this.agkX, paramInt4 + this.agkX, paramInt1 - k - this.agkX, paramInt2 - i - this.agkX))
    {
      jII();
      invalidate();
      AppMethodBeat.o(159667);
      return;
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(159671);
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      this.agll = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(159671);
  }
  
  public void setBarColor(int paramInt)
  {
    AppMethodBeat.i(159680);
    this.aglf = paramInt;
    jII();
    if (!this.aglo) {
      invalidate();
    }
    AppMethodBeat.o(159680);
  }
  
  public void setBarWidth(int paramInt)
  {
    AppMethodBeat.i(159679);
    this.agkX = paramInt;
    if (!this.aglo) {
      invalidate();
    }
    AppMethodBeat.o(159679);
  }
  
  public void setCallback(a parama)
  {
    AppMethodBeat.i(159669);
    this.aglp = parama;
    if (!this.aglo) {
      jIJ();
    }
    AppMethodBeat.o(159669);
  }
  
  public void setCircleRadius(int paramInt)
  {
    AppMethodBeat.i(159678);
    this.blq = paramInt;
    if (!this.aglo) {
      invalidate();
    }
    AppMethodBeat.o(159678);
  }
  
  public void setInstantProgress(float paramFloat)
  {
    AppMethodBeat.i(159673);
    if (this.aglo)
    {
      this.mProgress = 0.0F;
      this.aglo = false;
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.agln) <= 0.0F)
    {
      AppMethodBeat.o(159673);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.agln = Math.min(f * 360.0F, 360.0F);
    this.mProgress = this.agln;
    this.agll = SystemClock.uptimeMillis();
    invalidate();
    AppMethodBeat.o(159673);
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(159677);
    this.aglm = paramBoolean;
    if (!this.aglo) {
      invalidate();
    }
    AppMethodBeat.o(159677);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(159676);
    if (this.aglo)
    {
      this.mProgress = 0.0F;
      this.aglo = false;
      jIJ();
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.agln) <= 0.0F)
    {
      AppMethodBeat.o(159676);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    if (this.mProgress == this.agln) {
      this.agll = SystemClock.uptimeMillis();
    }
    this.agln = Math.min(f * 360.0F, 360.0F);
    invalidate();
    AppMethodBeat.o(159676);
  }
  
  public void setRimColor(int paramInt)
  {
    AppMethodBeat.i(159681);
    this.aglg = paramInt;
    jII();
    if (!this.aglo) {
      invalidate();
    }
    AppMethodBeat.o(159681);
  }
  
  public void setRimWidth(int paramInt)
  {
    AppMethodBeat.i(159682);
    this.agkY = paramInt;
    if (!this.aglo) {
      invalidate();
    }
    AppMethodBeat.o(159682);
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.aglk = (360.0F * paramFloat);
  }
  
  static class WheelSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR;
    int agkX;
    int agkY;
    boolean agkZ;
    int aglf;
    int aglg;
    float aglk;
    boolean aglm;
    float agln;
    boolean aglo;
    int blq;
    float mProgress;
    
    static
    {
      AppMethodBeat.i(159664);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159664);
    }
    
    private WheelSavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(159662);
      this.mProgress = paramParcel.readFloat();
      this.agln = paramParcel.readFloat();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.aglo = bool1;
        this.aglk = paramParcel.readFloat();
        this.agkX = paramParcel.readInt();
        this.aglf = paramParcel.readInt();
        this.agkY = paramParcel.readInt();
        this.aglg = paramParcel.readInt();
        this.blq = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label129;
        }
        bool1 = true;
        label99:
        this.aglm = bool1;
        if (paramParcel.readByte() == 0) {
          break label134;
        }
      }
      label129:
      label134:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.agkZ = bool1;
        AppMethodBeat.o(159662);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label99;
      }
    }
    
    WheelSavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(159663);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.mProgress);
      paramParcel.writeFloat(this.agln);
      if (this.aglo)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeFloat(this.aglk);
        paramParcel.writeInt(this.agkX);
        paramParcel.writeInt(this.aglf);
        paramParcel.writeInt(this.agkY);
        paramParcel.writeInt(this.aglg);
        paramParcel.writeInt(this.blq);
        if (!this.aglm) {
          break label133;
        }
        paramInt = 1;
        label101:
        paramParcel.writeByte((byte)paramInt);
        if (!this.agkZ) {
          break label138;
        }
      }
      label133:
      label138:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(159663);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label101;
      }
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel
 * JD-Core Version:    0.7.0.1
 */