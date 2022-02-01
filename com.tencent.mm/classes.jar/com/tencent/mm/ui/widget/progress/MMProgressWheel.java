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
import com.tencent.mm.ck.a.a;

public class MMProgressWheel
  extends View
{
  private static final String TAG;
  private final int QUJ;
  private final int QUK;
  private final long QUL;
  private int QUM;
  private int QUN;
  private boolean QUO;
  private double QUP;
  private double QUQ;
  private float QUR;
  private boolean QUS;
  private long QUT;
  private int QUU;
  private int QUV;
  private Paint QUW;
  private Paint QUX;
  private RectF QUY;
  private float QUZ;
  private long QVa;
  private boolean QVb;
  private float QVc;
  private boolean QVd;
  private a QVe;
  private boolean QVf;
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
    this.QUJ = 16;
    this.QUK = 270;
    this.QUL = 200L;
    this.circleRadius = 28;
    this.QUM = 4;
    this.QUN = 4;
    this.QUO = false;
    this.QUP = 0.0D;
    this.QUQ = 460.0D;
    this.QUR = 0.0F;
    this.QUS = true;
    this.QUT = 0L;
    this.QUU = -1442840576;
    this.QUV = 16777215;
    this.QUW = new Paint();
    this.QUX = new Paint();
    this.QUY = new RectF();
    this.QUZ = 230.0F;
    this.QVa = 0L;
    this.mProgress = 0.0F;
    this.QVc = 0.0F;
    this.QVd = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMProgressWheel);
    paramAttributeSet = getContext().getResources().getDisplayMetrics();
    this.QUM = ((int)TypedValue.applyDimension(1, this.QUM, paramAttributeSet));
    this.QUN = ((int)TypedValue.applyDimension(1, this.QUN, paramAttributeSet));
    this.circleRadius = ((int)TypedValue.applyDimension(1, this.circleRadius, paramAttributeSet));
    this.circleRadius = ((int)paramContext.getDimension(3, this.circleRadius));
    this.QUO = paramContext.getBoolean(4, false);
    this.QUM = ((int)paramContext.getDimension(2, this.QUM));
    this.QUN = ((int)paramContext.getDimension(8, this.QUN));
    this.QUZ = (paramContext.getFloat(9, this.QUZ / 360.0F) * 360.0F);
    this.QUQ = paramContext.getInt(1, (int)this.QUQ);
    this.QUU = paramContext.getColor(0, this.QUU);
    this.QUV = paramContext.getColor(7, this.QUV);
    this.QVb = paramContext.getBoolean(5, false);
    if (paramContext.getBoolean(6, false))
    {
      this.QVa = SystemClock.uptimeMillis();
      this.QVd = true;
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
      this.QVf = bool;
      AppMethodBeat.o(159665);
      return;
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
      label433:
      bool = false;
    }
  }
  
  private void hcy()
  {
    AppMethodBeat.i(159668);
    this.QUW.setColor(this.QUU);
    this.QUW.setAntiAlias(true);
    this.QUW.setStyle(Paint.Style.STROKE);
    this.QUW.setStrokeWidth(this.QUM);
    this.QUX.setColor(this.QUV);
    this.QUX.setAntiAlias(true);
    this.QUX.setStyle(Paint.Style.STROKE);
    this.QUX.setStrokeWidth(this.QUN);
    AppMethodBeat.o(159668);
  }
  
  private void hcz()
  {
    AppMethodBeat.i(159672);
    if (this.QVe != null) {
      Math.round(this.mProgress * 100.0F / 360.0F);
    }
    AppMethodBeat.o(159672);
  }
  
  public int getBarColor()
  {
    return this.QUU;
  }
  
  public int getBarWidth()
  {
    return this.QUM;
  }
  
  public int getCircleRadius()
  {
    return this.circleRadius;
  }
  
  public float getProgress()
  {
    if (this.QVd) {
      return -1.0F;
    }
    return this.mProgress / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.QUV;
  }
  
  public int getRimWidth()
  {
    return this.QUN;
  }
  
  public float getSpinSpeed()
  {
    return this.QUZ / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(159670);
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.QUY, 360.0F, 360.0F, false, this.QUX);
    if (!this.QVf)
    {
      AppMethodBeat.o(159670);
      return;
    }
    float f2;
    if (this.QVd)
    {
      long l = SystemClock.uptimeMillis() - this.QVa;
      f1 = (float)l * this.QUZ / 1000.0F;
      boolean bool;
      if (this.QUT >= 200L)
      {
        double d = this.QUP;
        this.QUP = (l + d);
        if (this.QUP > this.QUQ)
        {
          this.QUP -= this.QUQ;
          this.QUT = 0L;
          if (!this.QUS)
          {
            bool = true;
            this.QUS = bool;
          }
        }
        else
        {
          f2 = (float)Math.cos((this.QUP / this.QUQ + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
          if (!this.QUS) {
            break label307;
          }
          this.QUR = (f2 * 254.0F);
        }
      }
      for (;;)
      {
        this.mProgress += f1;
        if (this.mProgress > 360.0F) {
          this.mProgress -= 360.0F;
        }
        this.QVa = SystemClock.uptimeMillis();
        f1 = this.mProgress - 90.0F;
        f2 = 16.0F + this.QUR;
        if (isInEditMode())
        {
          f1 = 0.0F;
          f2 = 135.0F;
        }
        paramCanvas.drawArc(this.QUY, f1, f2, false, this.QUW);
        if (i != 0) {
          invalidate();
        }
        AppMethodBeat.o(159670);
        return;
        bool = false;
        break;
        label307:
        f2 = (1.0F - f2) * 254.0F;
        this.mProgress += this.QUR - f2;
        this.QUR = f2;
        continue;
        this.QUT = (l + this.QUT);
      }
    }
    float f1 = this.mProgress;
    if (this.mProgress != this.QVc)
    {
      this.mProgress = Math.min((float)(SystemClock.uptimeMillis() - this.QVa) / 1000.0F * this.QUZ + this.mProgress, this.QVc);
      this.QVa = SystemClock.uptimeMillis();
    }
    for (i = j;; i = 0)
    {
      if (f1 != this.mProgress) {
        hcz();
      }
      f2 = 0.0F;
      f1 = this.mProgress;
      if (!this.QVb)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 4.0D)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 2.0D)) * 360.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.QUY, f2 - 90.0F, f1, false, this.QUW);
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
    this.QVc = paramParcelable.QVc;
    this.QVd = paramParcelable.QVd;
    this.QUZ = paramParcelable.QUZ;
    this.QUM = paramParcelable.QUM;
    this.QUU = paramParcelable.QUU;
    this.QUN = paramParcelable.QUN;
    this.QUV = paramParcelable.QUV;
    this.circleRadius = paramParcelable.circleRadius;
    this.QVb = paramParcelable.QVb;
    this.QUO = paramParcelable.QUO;
    this.QVa = SystemClock.uptimeMillis();
    AppMethodBeat.o(159675);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159674);
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.mProgress = this.mProgress;
    localWheelSavedState.QVc = this.QVc;
    localWheelSavedState.QVd = this.QVd;
    localWheelSavedState.QUZ = this.QUZ;
    localWheelSavedState.QUM = this.QUM;
    localWheelSavedState.QUU = this.QUU;
    localWheelSavedState.QUN = this.QUN;
    localWheelSavedState.QUV = this.QUV;
    localWheelSavedState.circleRadius = this.circleRadius;
    localWheelSavedState.QVb = this.QVb;
    localWheelSavedState.QUO = this.QUO;
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
    if (!this.QUO)
    {
      paramInt3 = Math.min(Math.min(paramInt1 - j - k, paramInt2 - i - paramInt4), this.circleRadius * 2 - this.QUM * 2);
      paramInt1 = j + (paramInt1 - j - k - paramInt3) / 2;
      paramInt2 = paramInt4 + (paramInt2 - paramInt4 - i - paramInt3) / 2;
    }
    for (this.QUY = new RectF(this.QUM + paramInt1, this.QUM + paramInt2, paramInt1 + paramInt3 - this.QUM, paramInt2 + paramInt3 - this.QUM);; this.QUY = new RectF(j + this.QUM, paramInt4 + this.QUM, paramInt1 - k - this.QUM, paramInt2 - i - this.QUM))
    {
      hcy();
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
      this.QVa = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(159671);
  }
  
  public void setBarColor(int paramInt)
  {
    AppMethodBeat.i(159680);
    this.QUU = paramInt;
    hcy();
    if (!this.QVd) {
      invalidate();
    }
    AppMethodBeat.o(159680);
  }
  
  public void setBarWidth(int paramInt)
  {
    AppMethodBeat.i(159679);
    this.QUM = paramInt;
    if (!this.QVd) {
      invalidate();
    }
    AppMethodBeat.o(159679);
  }
  
  public void setCallback(a parama)
  {
    AppMethodBeat.i(159669);
    this.QVe = parama;
    if (!this.QVd) {
      hcz();
    }
    AppMethodBeat.o(159669);
  }
  
  public void setCircleRadius(int paramInt)
  {
    AppMethodBeat.i(159678);
    this.circleRadius = paramInt;
    if (!this.QVd) {
      invalidate();
    }
    AppMethodBeat.o(159678);
  }
  
  public void setInstantProgress(float paramFloat)
  {
    AppMethodBeat.i(159673);
    if (this.QVd)
    {
      this.mProgress = 0.0F;
      this.QVd = false;
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.QVc) <= 0.0F)
    {
      AppMethodBeat.o(159673);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.QVc = Math.min(f * 360.0F, 360.0F);
    this.mProgress = this.QVc;
    this.QVa = SystemClock.uptimeMillis();
    invalidate();
    AppMethodBeat.o(159673);
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(159677);
    this.QVb = paramBoolean;
    if (!this.QVd) {
      invalidate();
    }
    AppMethodBeat.o(159677);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(159676);
    if (this.QVd)
    {
      this.mProgress = 0.0F;
      this.QVd = false;
      hcz();
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.QVc) <= 0.0F)
    {
      AppMethodBeat.o(159676);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    if (this.mProgress == this.QVc) {
      this.QVa = SystemClock.uptimeMillis();
    }
    this.QVc = Math.min(f * 360.0F, 360.0F);
    invalidate();
    AppMethodBeat.o(159676);
  }
  
  public void setRimColor(int paramInt)
  {
    AppMethodBeat.i(159681);
    this.QUV = paramInt;
    hcy();
    if (!this.QVd) {
      invalidate();
    }
    AppMethodBeat.o(159681);
  }
  
  public void setRimWidth(int paramInt)
  {
    AppMethodBeat.i(159682);
    this.QUN = paramInt;
    if (!this.QVd) {
      invalidate();
    }
    AppMethodBeat.o(159682);
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.QUZ = (360.0F * paramFloat);
  }
  
  static class WheelSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR;
    int QUM;
    int QUN;
    boolean QUO;
    int QUU;
    int QUV;
    float QUZ;
    boolean QVb;
    float QVc;
    boolean QVd;
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
      this.QVc = paramParcel.readFloat();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.QVd = bool1;
        this.QUZ = paramParcel.readFloat();
        this.QUM = paramParcel.readInt();
        this.QUU = paramParcel.readInt();
        this.QUN = paramParcel.readInt();
        this.QUV = paramParcel.readInt();
        this.circleRadius = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label129;
        }
        bool1 = true;
        label99:
        this.QVb = bool1;
        if (paramParcel.readByte() == 0) {
          break label134;
        }
      }
      label129:
      label134:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.QUO = bool1;
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
      paramParcel.writeFloat(this.QVc);
      if (this.QVd)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeFloat(this.QUZ);
        paramParcel.writeInt(this.QUM);
        paramParcel.writeInt(this.QUU);
        paramParcel.writeInt(this.QUN);
        paramParcel.writeInt(this.QUV);
        paramParcel.writeInt(this.circleRadius);
        if (!this.QVb) {
          break label133;
        }
        paramInt = 1;
        label101:
        paramParcel.writeByte((byte)paramInt);
        if (!this.QUO) {
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