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
import com.tencent.mm.cl.a.a;

public class MMProgressWheel
  extends View
{
  private static final String TAG;
  private float LcA;
  private boolean LcB;
  private long LcC;
  private int LcD;
  private int LcE;
  private Paint LcF;
  private Paint LcG;
  private RectF LcH;
  private float LcI;
  private long LcJ;
  private boolean LcK;
  private float LcL;
  private boolean LcM;
  private a LcN;
  private boolean LcO;
  private final int Lcs;
  private final int Lct;
  private final long Lcu;
  private int Lcv;
  private int Lcw;
  private boolean Lcx;
  private double Lcy;
  private double Lcz;
  private int circleRadius;
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
    this.Lcs = 16;
    this.Lct = 270;
    this.Lcu = 200L;
    this.circleRadius = 28;
    this.Lcv = 4;
    this.Lcw = 4;
    this.Lcx = false;
    this.Lcy = 0.0D;
    this.Lcz = 460.0D;
    this.LcA = 0.0F;
    this.LcB = true;
    this.LcC = 0L;
    this.LcD = -1442840576;
    this.LcE = 16777215;
    this.LcF = new Paint();
    this.LcG = new Paint();
    this.LcH = new RectF();
    this.LcI = 230.0F;
    this.LcJ = 0L;
    this.mProgress = 0.0F;
    this.LcL = 0.0F;
    this.LcM = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMProgressWheel);
    paramAttributeSet = getContext().getResources().getDisplayMetrics();
    this.Lcv = ((int)TypedValue.applyDimension(1, this.Lcv, paramAttributeSet));
    this.Lcw = ((int)TypedValue.applyDimension(1, this.Lcw, paramAttributeSet));
    this.circleRadius = ((int)TypedValue.applyDimension(1, this.circleRadius, paramAttributeSet));
    this.circleRadius = ((int)paramContext.getDimension(3, this.circleRadius));
    this.Lcx = paramContext.getBoolean(4, false);
    this.Lcv = ((int)paramContext.getDimension(2, this.Lcv));
    this.Lcw = ((int)paramContext.getDimension(8, this.Lcw));
    this.LcI = (paramContext.getFloat(9, this.LcI / 360.0F) * 360.0F);
    this.Lcz = paramContext.getInt(1, (int)this.Lcz);
    this.LcD = paramContext.getColor(0, this.LcD);
    this.LcE = paramContext.getColor(7, this.LcE);
    this.LcK = paramContext.getBoolean(5, false);
    if (paramContext.getBoolean(6, false))
    {
      this.LcJ = SystemClock.uptimeMillis();
      this.LcM = true;
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
      this.LcO = bool;
      AppMethodBeat.o(159665);
      return;
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
      label433:
      bool = false;
    }
  }
  
  private void fNb()
  {
    AppMethodBeat.i(159668);
    this.LcF.setColor(this.LcD);
    this.LcF.setAntiAlias(true);
    this.LcF.setStyle(Paint.Style.STROKE);
    this.LcF.setStrokeWidth(this.Lcv);
    this.LcG.setColor(this.LcE);
    this.LcG.setAntiAlias(true);
    this.LcG.setStyle(Paint.Style.STROKE);
    this.LcG.setStrokeWidth(this.Lcw);
    AppMethodBeat.o(159668);
  }
  
  private void fNc()
  {
    AppMethodBeat.i(159672);
    if (this.LcN != null) {
      Math.round(this.mProgress * 100.0F / 360.0F);
    }
    AppMethodBeat.o(159672);
  }
  
  public int getBarColor()
  {
    return this.LcD;
  }
  
  public int getBarWidth()
  {
    return this.Lcv;
  }
  
  public int getCircleRadius()
  {
    return this.circleRadius;
  }
  
  public float getProgress()
  {
    if (this.LcM) {
      return -1.0F;
    }
    return this.mProgress / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.LcE;
  }
  
  public int getRimWidth()
  {
    return this.Lcw;
  }
  
  public float getSpinSpeed()
  {
    return this.LcI / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(159670);
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.LcH, 360.0F, 360.0F, false, this.LcG);
    if (!this.LcO)
    {
      AppMethodBeat.o(159670);
      return;
    }
    float f2;
    if (this.LcM)
    {
      long l = SystemClock.uptimeMillis() - this.LcJ;
      f1 = (float)l * this.LcI / 1000.0F;
      boolean bool;
      if (this.LcC >= 200L)
      {
        double d = this.Lcy;
        this.Lcy = (l + d);
        if (this.Lcy > this.Lcz)
        {
          this.Lcy -= this.Lcz;
          this.LcC = 0L;
          if (!this.LcB)
          {
            bool = true;
            this.LcB = bool;
          }
        }
        else
        {
          f2 = (float)Math.cos((this.Lcy / this.Lcz + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
          if (!this.LcB) {
            break label307;
          }
          this.LcA = (f2 * 254.0F);
        }
      }
      for (;;)
      {
        this.mProgress += f1;
        if (this.mProgress > 360.0F) {
          this.mProgress -= 360.0F;
        }
        this.LcJ = SystemClock.uptimeMillis();
        f1 = this.mProgress - 90.0F;
        f2 = 16.0F + this.LcA;
        if (isInEditMode())
        {
          f1 = 0.0F;
          f2 = 135.0F;
        }
        paramCanvas.drawArc(this.LcH, f1, f2, false, this.LcF);
        if (i != 0) {
          invalidate();
        }
        AppMethodBeat.o(159670);
        return;
        bool = false;
        break;
        label307:
        f2 = (1.0F - f2) * 254.0F;
        this.mProgress += this.LcA - f2;
        this.LcA = f2;
        continue;
        this.LcC = (l + this.LcC);
      }
    }
    float f1 = this.mProgress;
    if (this.mProgress != this.LcL)
    {
      this.mProgress = Math.min((float)(SystemClock.uptimeMillis() - this.LcJ) / 1000.0F * this.LcI + this.mProgress, this.LcL);
      this.LcJ = SystemClock.uptimeMillis();
    }
    for (i = j;; i = 0)
    {
      if (f1 != this.mProgress) {
        fNc();
      }
      f2 = 0.0F;
      f1 = this.mProgress;
      if (!this.LcK)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 4.0D)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 2.0D)) * 360.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.LcH, f2 - 90.0F, f1, false, this.LcF);
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159666);
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
    this.LcL = paramParcelable.LcL;
    this.LcM = paramParcelable.LcM;
    this.LcI = paramParcelable.LcI;
    this.Lcv = paramParcelable.Lcv;
    this.LcD = paramParcelable.LcD;
    this.Lcw = paramParcelable.Lcw;
    this.LcE = paramParcelable.LcE;
    this.circleRadius = paramParcelable.circleRadius;
    this.LcK = paramParcelable.LcK;
    this.Lcx = paramParcelable.Lcx;
    this.LcJ = SystemClock.uptimeMillis();
    AppMethodBeat.o(159675);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159674);
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.mProgress = this.mProgress;
    localWheelSavedState.LcL = this.LcL;
    localWheelSavedState.LcM = this.LcM;
    localWheelSavedState.LcI = this.LcI;
    localWheelSavedState.Lcv = this.Lcv;
    localWheelSavedState.LcD = this.LcD;
    localWheelSavedState.Lcw = this.Lcw;
    localWheelSavedState.LcE = this.LcE;
    localWheelSavedState.circleRadius = this.circleRadius;
    localWheelSavedState.LcK = this.LcK;
    localWheelSavedState.Lcx = this.Lcx;
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
    if (!this.Lcx)
    {
      paramInt3 = Math.min(Math.min(paramInt1 - j - k, paramInt2 - i - paramInt4), this.circleRadius * 2 - this.Lcv * 2);
      paramInt1 = j + (paramInt1 - j - k - paramInt3) / 2;
      paramInt2 = paramInt4 + (paramInt2 - paramInt4 - i - paramInt3) / 2;
    }
    for (this.LcH = new RectF(this.Lcv + paramInt1, this.Lcv + paramInt2, paramInt1 + paramInt3 - this.Lcv, paramInt2 + paramInt3 - this.Lcv);; this.LcH = new RectF(j + this.Lcv, paramInt4 + this.Lcv, paramInt1 - k - this.Lcv, paramInt2 - i - this.Lcv))
    {
      fNb();
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
      this.LcJ = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(159671);
  }
  
  public void setBarColor(int paramInt)
  {
    AppMethodBeat.i(159680);
    this.LcD = paramInt;
    fNb();
    if (!this.LcM) {
      invalidate();
    }
    AppMethodBeat.o(159680);
  }
  
  public void setBarWidth(int paramInt)
  {
    AppMethodBeat.i(159679);
    this.Lcv = paramInt;
    if (!this.LcM) {
      invalidate();
    }
    AppMethodBeat.o(159679);
  }
  
  public void setCallback(a parama)
  {
    AppMethodBeat.i(159669);
    this.LcN = parama;
    if (!this.LcM) {
      fNc();
    }
    AppMethodBeat.o(159669);
  }
  
  public void setCircleRadius(int paramInt)
  {
    AppMethodBeat.i(159678);
    this.circleRadius = paramInt;
    if (!this.LcM) {
      invalidate();
    }
    AppMethodBeat.o(159678);
  }
  
  public void setInstantProgress(float paramFloat)
  {
    AppMethodBeat.i(159673);
    if (this.LcM)
    {
      this.mProgress = 0.0F;
      this.LcM = false;
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.LcL) <= 0.0F)
    {
      AppMethodBeat.o(159673);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.LcL = Math.min(f * 360.0F, 360.0F);
    this.mProgress = this.LcL;
    this.LcJ = SystemClock.uptimeMillis();
    invalidate();
    AppMethodBeat.o(159673);
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(159677);
    this.LcK = paramBoolean;
    if (!this.LcM) {
      invalidate();
    }
    AppMethodBeat.o(159677);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(159676);
    if (this.LcM)
    {
      this.mProgress = 0.0F;
      this.LcM = false;
      fNc();
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.LcL) <= 0.0F)
    {
      AppMethodBeat.o(159676);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    if (this.mProgress == this.LcL) {
      this.LcJ = SystemClock.uptimeMillis();
    }
    this.LcL = Math.min(f * 360.0F, 360.0F);
    invalidate();
    AppMethodBeat.o(159676);
  }
  
  public void setRimColor(int paramInt)
  {
    AppMethodBeat.i(159681);
    this.LcE = paramInt;
    fNb();
    if (!this.LcM) {
      invalidate();
    }
    AppMethodBeat.o(159681);
  }
  
  public void setRimWidth(int paramInt)
  {
    AppMethodBeat.i(159682);
    this.Lcw = paramInt;
    if (!this.LcM) {
      invalidate();
    }
    AppMethodBeat.o(159682);
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.LcI = (360.0F * paramFloat);
  }
  
  static class WheelSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR;
    int LcD;
    int LcE;
    float LcI;
    boolean LcK;
    float LcL;
    boolean LcM;
    int Lcv;
    int Lcw;
    boolean Lcx;
    int circleRadius;
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
      this.LcL = paramParcel.readFloat();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.LcM = bool1;
        this.LcI = paramParcel.readFloat();
        this.Lcv = paramParcel.readInt();
        this.LcD = paramParcel.readInt();
        this.Lcw = paramParcel.readInt();
        this.LcE = paramParcel.readInt();
        this.circleRadius = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label129;
        }
        bool1 = true;
        label99:
        this.LcK = bool1;
        if (paramParcel.readByte() == 0) {
          break label134;
        }
      }
      label129:
      label134:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.Lcx = bool1;
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
      paramParcel.writeFloat(this.LcL);
      if (this.LcM)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeFloat(this.LcI);
        paramParcel.writeInt(this.Lcv);
        paramParcel.writeInt(this.LcD);
        paramParcel.writeInt(this.Lcw);
        paramParcel.writeInt(this.LcE);
        paramParcel.writeInt(this.circleRadius);
        if (!this.LcK) {
          break label133;
        }
        paramInt = 1;
        label101:
        paramParcel.writeByte((byte)paramInt);
        if (!this.Lcx) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel
 * JD-Core Version:    0.7.0.1
 */