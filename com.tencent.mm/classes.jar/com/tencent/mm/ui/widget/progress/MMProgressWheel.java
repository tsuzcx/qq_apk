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
import com.tencent.mm.cm.a.a;

public class MMProgressWheel
  extends View
{
  private static final String TAG;
  private final long HKA;
  private int HKB;
  private int HKC;
  private boolean HKD;
  private double HKE;
  private double HKF;
  private float HKG;
  private boolean HKH;
  private long HKI;
  private int HKJ;
  private int HKK;
  private Paint HKL;
  private Paint HKM;
  private RectF HKN;
  private float HKO;
  private long HKP;
  private boolean HKQ;
  private float HKR;
  private boolean HKS;
  private a HKT;
  private boolean HKU;
  private final int HKy;
  private final int HKz;
  private float aae;
  private int circleRadius;
  
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
    this.HKy = 16;
    this.HKz = 270;
    this.HKA = 200L;
    this.circleRadius = 28;
    this.HKB = 4;
    this.HKC = 4;
    this.HKD = false;
    this.HKE = 0.0D;
    this.HKF = 460.0D;
    this.HKG = 0.0F;
    this.HKH = true;
    this.HKI = 0L;
    this.HKJ = -1442840576;
    this.HKK = 16777215;
    this.HKL = new Paint();
    this.HKM = new Paint();
    this.HKN = new RectF();
    this.HKO = 230.0F;
    this.HKP = 0L;
    this.aae = 0.0F;
    this.HKR = 0.0F;
    this.HKS = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMProgressWheel);
    paramAttributeSet = getContext().getResources().getDisplayMetrics();
    this.HKB = ((int)TypedValue.applyDimension(1, this.HKB, paramAttributeSet));
    this.HKC = ((int)TypedValue.applyDimension(1, this.HKC, paramAttributeSet));
    this.circleRadius = ((int)TypedValue.applyDimension(1, this.circleRadius, paramAttributeSet));
    this.circleRadius = ((int)paramContext.getDimension(3, this.circleRadius));
    this.HKD = paramContext.getBoolean(4, false);
    this.HKB = ((int)paramContext.getDimension(2, this.HKB));
    this.HKC = ((int)paramContext.getDimension(8, this.HKC));
    this.HKO = (paramContext.getFloat(9, this.HKO / 360.0F) * 360.0F);
    this.HKF = paramContext.getInt(1, (int)this.HKF);
    this.HKJ = paramContext.getColor(0, this.HKJ);
    this.HKK = paramContext.getColor(7, this.HKK);
    this.HKQ = paramContext.getBoolean(5, false);
    if (paramContext.getBoolean(6, false))
    {
      this.HKP = SystemClock.uptimeMillis();
      this.HKS = true;
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
      this.HKU = bool;
      AppMethodBeat.o(159665);
      return;
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
      label433:
      bool = false;
    }
  }
  
  private void fgn()
  {
    AppMethodBeat.i(159668);
    this.HKL.setColor(this.HKJ);
    this.HKL.setAntiAlias(true);
    this.HKL.setStyle(Paint.Style.STROKE);
    this.HKL.setStrokeWidth(this.HKB);
    this.HKM.setColor(this.HKK);
    this.HKM.setAntiAlias(true);
    this.HKM.setStyle(Paint.Style.STROKE);
    this.HKM.setStrokeWidth(this.HKC);
    AppMethodBeat.o(159668);
  }
  
  private void fgo()
  {
    AppMethodBeat.i(159672);
    if (this.HKT != null) {
      Math.round(this.aae * 100.0F / 360.0F);
    }
    AppMethodBeat.o(159672);
  }
  
  public int getBarColor()
  {
    return this.HKJ;
  }
  
  public int getBarWidth()
  {
    return this.HKB;
  }
  
  public int getCircleRadius()
  {
    return this.circleRadius;
  }
  
  public float getProgress()
  {
    if (this.HKS) {
      return -1.0F;
    }
    return this.aae / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.HKK;
  }
  
  public int getRimWidth()
  {
    return this.HKC;
  }
  
  public float getSpinSpeed()
  {
    return this.HKO / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(159670);
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.HKN, 360.0F, 360.0F, false, this.HKM);
    if (!this.HKU)
    {
      AppMethodBeat.o(159670);
      return;
    }
    float f2;
    if (this.HKS)
    {
      long l = SystemClock.uptimeMillis() - this.HKP;
      f1 = (float)l * this.HKO / 1000.0F;
      boolean bool;
      if (this.HKI >= 200L)
      {
        double d = this.HKE;
        this.HKE = (l + d);
        if (this.HKE > this.HKF)
        {
          this.HKE -= this.HKF;
          this.HKI = 0L;
          if (!this.HKH)
          {
            bool = true;
            this.HKH = bool;
          }
        }
        else
        {
          f2 = (float)Math.cos((this.HKE / this.HKF + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
          if (!this.HKH) {
            break label307;
          }
          this.HKG = (f2 * 254.0F);
        }
      }
      for (;;)
      {
        this.aae += f1;
        if (this.aae > 360.0F) {
          this.aae -= 360.0F;
        }
        this.HKP = SystemClock.uptimeMillis();
        f1 = this.aae - 90.0F;
        f2 = 16.0F + this.HKG;
        if (isInEditMode())
        {
          f1 = 0.0F;
          f2 = 135.0F;
        }
        paramCanvas.drawArc(this.HKN, f1, f2, false, this.HKL);
        if (i != 0) {
          invalidate();
        }
        AppMethodBeat.o(159670);
        return;
        bool = false;
        break;
        label307:
        f2 = (1.0F - f2) * 254.0F;
        this.aae += this.HKG - f2;
        this.HKG = f2;
        continue;
        this.HKI = (l + this.HKI);
      }
    }
    float f1 = this.aae;
    if (this.aae != this.HKR)
    {
      this.aae = Math.min((float)(SystemClock.uptimeMillis() - this.HKP) / 1000.0F * this.HKO + this.aae, this.HKR);
      this.HKP = SystemClock.uptimeMillis();
    }
    for (i = j;; i = 0)
    {
      if (f1 != this.aae) {
        fgo();
      }
      f2 = 0.0F;
      f1 = this.aae;
      if (!this.HKQ)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.aae / 360.0F, 4.0D)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.aae / 360.0F, 2.0D)) * 360.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.HKN, f2 - 90.0F, f1, false, this.HKL);
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
    this.aae = paramParcelable.aae;
    this.HKR = paramParcelable.HKR;
    this.HKS = paramParcelable.HKS;
    this.HKO = paramParcelable.HKO;
    this.HKB = paramParcelable.HKB;
    this.HKJ = paramParcelable.HKJ;
    this.HKC = paramParcelable.HKC;
    this.HKK = paramParcelable.HKK;
    this.circleRadius = paramParcelable.circleRadius;
    this.HKQ = paramParcelable.HKQ;
    this.HKD = paramParcelable.HKD;
    this.HKP = SystemClock.uptimeMillis();
    AppMethodBeat.o(159675);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159674);
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.aae = this.aae;
    localWheelSavedState.HKR = this.HKR;
    localWheelSavedState.HKS = this.HKS;
    localWheelSavedState.HKO = this.HKO;
    localWheelSavedState.HKB = this.HKB;
    localWheelSavedState.HKJ = this.HKJ;
    localWheelSavedState.HKC = this.HKC;
    localWheelSavedState.HKK = this.HKK;
    localWheelSavedState.circleRadius = this.circleRadius;
    localWheelSavedState.HKQ = this.HKQ;
    localWheelSavedState.HKD = this.HKD;
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
    if (!this.HKD)
    {
      paramInt3 = Math.min(Math.min(paramInt1 - j - k, paramInt2 - i - paramInt4), this.circleRadius * 2 - this.HKB * 2);
      paramInt1 = j + (paramInt1 - j - k - paramInt3) / 2;
      paramInt2 = paramInt4 + (paramInt2 - paramInt4 - i - paramInt3) / 2;
    }
    for (this.HKN = new RectF(this.HKB + paramInt1, this.HKB + paramInt2, paramInt1 + paramInt3 - this.HKB, paramInt2 + paramInt3 - this.HKB);; this.HKN = new RectF(j + this.HKB, paramInt4 + this.HKB, paramInt1 - k - this.HKB, paramInt2 - i - this.HKB))
    {
      fgn();
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
      this.HKP = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(159671);
  }
  
  public void setBarColor(int paramInt)
  {
    AppMethodBeat.i(159680);
    this.HKJ = paramInt;
    fgn();
    if (!this.HKS) {
      invalidate();
    }
    AppMethodBeat.o(159680);
  }
  
  public void setBarWidth(int paramInt)
  {
    AppMethodBeat.i(159679);
    this.HKB = paramInt;
    if (!this.HKS) {
      invalidate();
    }
    AppMethodBeat.o(159679);
  }
  
  public void setCallback(a parama)
  {
    AppMethodBeat.i(159669);
    this.HKT = parama;
    if (!this.HKS) {
      fgo();
    }
    AppMethodBeat.o(159669);
  }
  
  public void setCircleRadius(int paramInt)
  {
    AppMethodBeat.i(159678);
    this.circleRadius = paramInt;
    if (!this.HKS) {
      invalidate();
    }
    AppMethodBeat.o(159678);
  }
  
  public void setInstantProgress(float paramFloat)
  {
    AppMethodBeat.i(159673);
    if (this.HKS)
    {
      this.aae = 0.0F;
      this.HKS = false;
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.HKR) <= 0.0F)
    {
      AppMethodBeat.o(159673);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.HKR = Math.min(f * 360.0F, 360.0F);
    this.aae = this.HKR;
    this.HKP = SystemClock.uptimeMillis();
    invalidate();
    AppMethodBeat.o(159673);
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(159677);
    this.HKQ = paramBoolean;
    if (!this.HKS) {
      invalidate();
    }
    AppMethodBeat.o(159677);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(159676);
    if (this.HKS)
    {
      this.aae = 0.0F;
      this.HKS = false;
      fgo();
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.HKR) <= 0.0F)
    {
      AppMethodBeat.o(159676);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    if (this.aae == this.HKR) {
      this.HKP = SystemClock.uptimeMillis();
    }
    this.HKR = Math.min(f * 360.0F, 360.0F);
    invalidate();
    AppMethodBeat.o(159676);
  }
  
  public void setRimColor(int paramInt)
  {
    AppMethodBeat.i(159681);
    this.HKK = paramInt;
    fgn();
    if (!this.HKS) {
      invalidate();
    }
    AppMethodBeat.o(159681);
  }
  
  public void setRimWidth(int paramInt)
  {
    AppMethodBeat.i(159682);
    this.HKC = paramInt;
    if (!this.HKS) {
      invalidate();
    }
    AppMethodBeat.o(159682);
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.HKO = (360.0F * paramFloat);
  }
  
  static class WheelSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR;
    int HKB;
    int HKC;
    boolean HKD;
    int HKJ;
    int HKK;
    float HKO;
    boolean HKQ;
    float HKR;
    boolean HKS;
    float aae;
    int circleRadius;
    
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
      this.aae = paramParcel.readFloat();
      this.HKR = paramParcel.readFloat();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.HKS = bool1;
        this.HKO = paramParcel.readFloat();
        this.HKB = paramParcel.readInt();
        this.HKJ = paramParcel.readInt();
        this.HKC = paramParcel.readInt();
        this.HKK = paramParcel.readInt();
        this.circleRadius = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label129;
        }
        bool1 = true;
        label99:
        this.HKQ = bool1;
        if (paramParcel.readByte() == 0) {
          break label134;
        }
      }
      label129:
      label134:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.HKD = bool1;
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
      paramParcel.writeFloat(this.aae);
      paramParcel.writeFloat(this.HKR);
      if (this.HKS)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeFloat(this.HKO);
        paramParcel.writeInt(this.HKB);
        paramParcel.writeInt(this.HKJ);
        paramParcel.writeInt(this.HKC);
        paramParcel.writeInt(this.HKK);
        paramParcel.writeInt(this.circleRadius);
        if (!this.HKQ) {
          break label133;
        }
        paramInt = 1;
        label101:
        paramParcel.writeByte((byte)paramInt);
        if (!this.HKD) {
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