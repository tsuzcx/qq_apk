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
import com.tencent.mm.cr.a.k;

public class MMProgressWheel
  extends View
{
  private static final String TAG;
  private int Fj;
  private final int YsG;
  private final long YsH;
  private int YsI;
  private int YsJ;
  private boolean YsK;
  private double YsL;
  private double YsM;
  private float YsN;
  private boolean YsO;
  private long YsP;
  private int YsQ;
  private int YsR;
  private Paint YsS;
  private Paint YsT;
  private RectF YsU;
  private float YsV;
  private long YsW;
  private boolean YsX;
  private float YsY;
  private boolean YsZ;
  private a Yta;
  private boolean Ytb;
  private final int barLength;
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
    this.YsG = 270;
    this.YsH = 200L;
    this.Fj = 28;
    this.YsI = 4;
    this.YsJ = 4;
    this.YsK = false;
    this.YsL = 0.0D;
    this.YsM = 460.0D;
    this.YsN = 0.0F;
    this.YsO = true;
    this.YsP = 0L;
    this.YsQ = -1442840576;
    this.YsR = 16777215;
    this.YsS = new Paint();
    this.YsT = new Paint();
    this.YsU = new RectF();
    this.YsV = 230.0F;
    this.YsW = 0L;
    this.mProgress = 0.0F;
    this.YsY = 0.0F;
    this.YsZ = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMProgressWheel);
    paramAttributeSet = getContext().getResources().getDisplayMetrics();
    this.YsI = ((int)TypedValue.applyDimension(1, this.YsI, paramAttributeSet));
    this.YsJ = ((int)TypedValue.applyDimension(1, this.YsJ, paramAttributeSet));
    this.Fj = ((int)TypedValue.applyDimension(1, this.Fj, paramAttributeSet));
    this.Fj = ((int)paramContext.getDimension(a.k.MMProgressWheel_matProg_circleRadius, this.Fj));
    this.YsK = paramContext.getBoolean(a.k.MMProgressWheel_matProg_fillRadius, false);
    this.YsI = ((int)paramContext.getDimension(a.k.MMProgressWheel_matProg_barWidth, this.YsI));
    this.YsJ = ((int)paramContext.getDimension(a.k.MMProgressWheel_matProg_rimWidth, this.YsJ));
    this.YsV = (paramContext.getFloat(a.k.MMProgressWheel_matProg_spinSpeed, this.YsV / 360.0F) * 360.0F);
    this.YsM = paramContext.getInt(a.k.MMProgressWheel_matProg_barSpinCycleTime, (int)this.YsM);
    this.YsQ = paramContext.getColor(a.k.MMProgressWheel_matProg_barColor, this.YsQ);
    this.YsR = paramContext.getColor(a.k.MMProgressWheel_matProg_rimColor, this.YsR);
    this.YsX = paramContext.getBoolean(a.k.MMProgressWheel_matProg_linearProgress, false);
    if (paramContext.getBoolean(a.k.MMProgressWheel_matProg_progressIndeterminate, false))
    {
      this.YsW = SystemClock.uptimeMillis();
      this.YsZ = true;
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
      this.Ytb = bool;
      AppMethodBeat.o(159665);
      return;
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
      label449:
      bool = false;
    }
  }
  
  private void idA()
  {
    AppMethodBeat.i(159668);
    this.YsS.setColor(this.YsQ);
    this.YsS.setAntiAlias(true);
    this.YsS.setStyle(Paint.Style.STROKE);
    this.YsS.setStrokeWidth(this.YsI);
    this.YsT.setColor(this.YsR);
    this.YsT.setAntiAlias(true);
    this.YsT.setStyle(Paint.Style.STROKE);
    this.YsT.setStrokeWidth(this.YsJ);
    AppMethodBeat.o(159668);
  }
  
  private void idB()
  {
    AppMethodBeat.i(159672);
    if (this.Yta != null) {
      Math.round(this.mProgress * 100.0F / 360.0F);
    }
    AppMethodBeat.o(159672);
  }
  
  public int getBarColor()
  {
    return this.YsQ;
  }
  
  public int getBarWidth()
  {
    return this.YsI;
  }
  
  public int getCircleRadius()
  {
    return this.Fj;
  }
  
  public float getProgress()
  {
    if (this.YsZ) {
      return -1.0F;
    }
    return this.mProgress / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.YsR;
  }
  
  public int getRimWidth()
  {
    return this.YsJ;
  }
  
  public float getSpinSpeed()
  {
    return this.YsV / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(159670);
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.YsU, 360.0F, 360.0F, false, this.YsT);
    if (!this.Ytb)
    {
      AppMethodBeat.o(159670);
      return;
    }
    float f2;
    if (this.YsZ)
    {
      long l = SystemClock.uptimeMillis() - this.YsW;
      f1 = (float)l * this.YsV / 1000.0F;
      boolean bool;
      if (this.YsP >= 200L)
      {
        double d = this.YsL;
        this.YsL = (l + d);
        if (this.YsL > this.YsM)
        {
          this.YsL -= this.YsM;
          this.YsP = 0L;
          if (!this.YsO)
          {
            bool = true;
            this.YsO = bool;
          }
        }
        else
        {
          f2 = (float)Math.cos((this.YsL / this.YsM + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
          if (!this.YsO) {
            break label307;
          }
          this.YsN = (f2 * 254.0F);
        }
      }
      for (;;)
      {
        this.mProgress += f1;
        if (this.mProgress > 360.0F) {
          this.mProgress -= 360.0F;
        }
        this.YsW = SystemClock.uptimeMillis();
        f1 = this.mProgress - 90.0F;
        f2 = 16.0F + this.YsN;
        if (isInEditMode())
        {
          f1 = 0.0F;
          f2 = 135.0F;
        }
        paramCanvas.drawArc(this.YsU, f1, f2, false, this.YsS);
        if (i != 0) {
          invalidate();
        }
        AppMethodBeat.o(159670);
        return;
        bool = false;
        break;
        label307:
        f2 = (1.0F - f2) * 254.0F;
        this.mProgress += this.YsN - f2;
        this.YsN = f2;
        continue;
        this.YsP = (l + this.YsP);
      }
    }
    float f1 = this.mProgress;
    if (this.mProgress != this.YsY)
    {
      this.mProgress = Math.min((float)(SystemClock.uptimeMillis() - this.YsW) / 1000.0F * this.YsV + this.mProgress, this.YsY);
      this.YsW = SystemClock.uptimeMillis();
    }
    for (i = j;; i = 0)
    {
      if (f1 != this.mProgress) {
        idB();
      }
      f2 = 0.0F;
      f1 = this.mProgress;
      if (!this.YsX)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 4.0D)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 2.0D)) * 360.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.YsU, f2 - 90.0F, f1, false, this.YsS);
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159666);
    super.onMeasure(paramInt1, paramInt2);
    int k = this.Fj + getPaddingLeft() + getPaddingRight();
    int i = this.Fj + getPaddingTop() + getPaddingBottom();
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
    this.YsY = paramParcelable.YsY;
    this.YsZ = paramParcelable.YsZ;
    this.YsV = paramParcelable.YsV;
    this.YsI = paramParcelable.YsI;
    this.YsQ = paramParcelable.YsQ;
    this.YsJ = paramParcelable.YsJ;
    this.YsR = paramParcelable.YsR;
    this.Fj = paramParcelable.Fj;
    this.YsX = paramParcelable.YsX;
    this.YsK = paramParcelable.YsK;
    this.YsW = SystemClock.uptimeMillis();
    AppMethodBeat.o(159675);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159674);
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.mProgress = this.mProgress;
    localWheelSavedState.YsY = this.YsY;
    localWheelSavedState.YsZ = this.YsZ;
    localWheelSavedState.YsV = this.YsV;
    localWheelSavedState.YsI = this.YsI;
    localWheelSavedState.YsQ = this.YsQ;
    localWheelSavedState.YsJ = this.YsJ;
    localWheelSavedState.YsR = this.YsR;
    localWheelSavedState.Fj = this.Fj;
    localWheelSavedState.YsX = this.YsX;
    localWheelSavedState.YsK = this.YsK;
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
    if (!this.YsK)
    {
      paramInt3 = Math.min(Math.min(paramInt1 - j - k, paramInt2 - i - paramInt4), this.Fj * 2 - this.YsI * 2);
      paramInt1 = j + (paramInt1 - j - k - paramInt3) / 2;
      paramInt2 = paramInt4 + (paramInt2 - paramInt4 - i - paramInt3) / 2;
    }
    for (this.YsU = new RectF(this.YsI + paramInt1, this.YsI + paramInt2, paramInt1 + paramInt3 - this.YsI, paramInt2 + paramInt3 - this.YsI);; this.YsU = new RectF(j + this.YsI, paramInt4 + this.YsI, paramInt1 - k - this.YsI, paramInt2 - i - this.YsI))
    {
      idA();
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
      this.YsW = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(159671);
  }
  
  public void setBarColor(int paramInt)
  {
    AppMethodBeat.i(159680);
    this.YsQ = paramInt;
    idA();
    if (!this.YsZ) {
      invalidate();
    }
    AppMethodBeat.o(159680);
  }
  
  public void setBarWidth(int paramInt)
  {
    AppMethodBeat.i(159679);
    this.YsI = paramInt;
    if (!this.YsZ) {
      invalidate();
    }
    AppMethodBeat.o(159679);
  }
  
  public void setCallback(a parama)
  {
    AppMethodBeat.i(159669);
    this.Yta = parama;
    if (!this.YsZ) {
      idB();
    }
    AppMethodBeat.o(159669);
  }
  
  public void setCircleRadius(int paramInt)
  {
    AppMethodBeat.i(159678);
    this.Fj = paramInt;
    if (!this.YsZ) {
      invalidate();
    }
    AppMethodBeat.o(159678);
  }
  
  public void setInstantProgress(float paramFloat)
  {
    AppMethodBeat.i(159673);
    if (this.YsZ)
    {
      this.mProgress = 0.0F;
      this.YsZ = false;
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.YsY) <= 0.0F)
    {
      AppMethodBeat.o(159673);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.YsY = Math.min(f * 360.0F, 360.0F);
    this.mProgress = this.YsY;
    this.YsW = SystemClock.uptimeMillis();
    invalidate();
    AppMethodBeat.o(159673);
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(159677);
    this.YsX = paramBoolean;
    if (!this.YsZ) {
      invalidate();
    }
    AppMethodBeat.o(159677);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(159676);
    if (this.YsZ)
    {
      this.mProgress = 0.0F;
      this.YsZ = false;
      idB();
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.YsY) <= 0.0F)
    {
      AppMethodBeat.o(159676);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    if (this.mProgress == this.YsY) {
      this.YsW = SystemClock.uptimeMillis();
    }
    this.YsY = Math.min(f * 360.0F, 360.0F);
    invalidate();
    AppMethodBeat.o(159676);
  }
  
  public void setRimColor(int paramInt)
  {
    AppMethodBeat.i(159681);
    this.YsR = paramInt;
    idA();
    if (!this.YsZ) {
      invalidate();
    }
    AppMethodBeat.o(159681);
  }
  
  public void setRimWidth(int paramInt)
  {
    AppMethodBeat.i(159682);
    this.YsJ = paramInt;
    if (!this.YsZ) {
      invalidate();
    }
    AppMethodBeat.o(159682);
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.YsV = (360.0F * paramFloat);
  }
  
  static class WheelSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR;
    int Fj;
    int YsI;
    int YsJ;
    boolean YsK;
    int YsQ;
    int YsR;
    float YsV;
    boolean YsX;
    float YsY;
    boolean YsZ;
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
      this.YsY = paramParcel.readFloat();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.YsZ = bool1;
        this.YsV = paramParcel.readFloat();
        this.YsI = paramParcel.readInt();
        this.YsQ = paramParcel.readInt();
        this.YsJ = paramParcel.readInt();
        this.YsR = paramParcel.readInt();
        this.Fj = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label129;
        }
        bool1 = true;
        label99:
        this.YsX = bool1;
        if (paramParcel.readByte() == 0) {
          break label134;
        }
      }
      label129:
      label134:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.YsK = bool1;
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
      paramParcel.writeFloat(this.YsY);
      if (this.YsZ)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeFloat(this.YsV);
        paramParcel.writeInt(this.YsI);
        paramParcel.writeInt(this.YsQ);
        paramParcel.writeInt(this.YsJ);
        paramParcel.writeInt(this.YsR);
        paramParcel.writeInt(this.Fj);
        if (!this.YsX) {
          break label133;
        }
        paramInt = 1;
        label101:
        paramParcel.writeByte((byte)paramInt);
        if (!this.YsK) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel
 * JD-Core Version:    0.7.0.1
 */