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
  private final int LyT;
  private final int LyU;
  private final long LyV;
  private int LyW;
  private int LyX;
  private boolean LyY;
  private double LyZ;
  private double Lza;
  private float Lzb;
  private boolean Lzc;
  private long Lzd;
  private int Lze;
  private int Lzf;
  private Paint Lzg;
  private Paint Lzh;
  private RectF Lzi;
  private float Lzj;
  private long Lzk;
  private boolean Lzl;
  private float Lzm;
  private boolean Lzn;
  private a Lzo;
  private boolean Lzp;
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
    this.LyT = 16;
    this.LyU = 270;
    this.LyV = 200L;
    this.circleRadius = 28;
    this.LyW = 4;
    this.LyX = 4;
    this.LyY = false;
    this.LyZ = 0.0D;
    this.Lza = 460.0D;
    this.Lzb = 0.0F;
    this.Lzc = true;
    this.Lzd = 0L;
    this.Lze = -1442840576;
    this.Lzf = 16777215;
    this.Lzg = new Paint();
    this.Lzh = new Paint();
    this.Lzi = new RectF();
    this.Lzj = 230.0F;
    this.Lzk = 0L;
    this.mProgress = 0.0F;
    this.Lzm = 0.0F;
    this.Lzn = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMProgressWheel);
    paramAttributeSet = getContext().getResources().getDisplayMetrics();
    this.LyW = ((int)TypedValue.applyDimension(1, this.LyW, paramAttributeSet));
    this.LyX = ((int)TypedValue.applyDimension(1, this.LyX, paramAttributeSet));
    this.circleRadius = ((int)TypedValue.applyDimension(1, this.circleRadius, paramAttributeSet));
    this.circleRadius = ((int)paramContext.getDimension(3, this.circleRadius));
    this.LyY = paramContext.getBoolean(4, false);
    this.LyW = ((int)paramContext.getDimension(2, this.LyW));
    this.LyX = ((int)paramContext.getDimension(8, this.LyX));
    this.Lzj = (paramContext.getFloat(9, this.Lzj / 360.0F) * 360.0F);
    this.Lza = paramContext.getInt(1, (int)this.Lza);
    this.Lze = paramContext.getColor(0, this.Lze);
    this.Lzf = paramContext.getColor(7, this.Lzf);
    this.Lzl = paramContext.getBoolean(5, false);
    if (paramContext.getBoolean(6, false))
    {
      this.Lzk = SystemClock.uptimeMillis();
      this.Lzn = true;
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
      this.Lzp = bool;
      AppMethodBeat.o(159665);
      return;
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
      label433:
      bool = false;
    }
  }
  
  private void fRw()
  {
    AppMethodBeat.i(159668);
    this.Lzg.setColor(this.Lze);
    this.Lzg.setAntiAlias(true);
    this.Lzg.setStyle(Paint.Style.STROKE);
    this.Lzg.setStrokeWidth(this.LyW);
    this.Lzh.setColor(this.Lzf);
    this.Lzh.setAntiAlias(true);
    this.Lzh.setStyle(Paint.Style.STROKE);
    this.Lzh.setStrokeWidth(this.LyX);
    AppMethodBeat.o(159668);
  }
  
  private void fRx()
  {
    AppMethodBeat.i(159672);
    if (this.Lzo != null) {
      Math.round(this.mProgress * 100.0F / 360.0F);
    }
    AppMethodBeat.o(159672);
  }
  
  public int getBarColor()
  {
    return this.Lze;
  }
  
  public int getBarWidth()
  {
    return this.LyW;
  }
  
  public int getCircleRadius()
  {
    return this.circleRadius;
  }
  
  public float getProgress()
  {
    if (this.Lzn) {
      return -1.0F;
    }
    return this.mProgress / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.Lzf;
  }
  
  public int getRimWidth()
  {
    return this.LyX;
  }
  
  public float getSpinSpeed()
  {
    return this.Lzj / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(159670);
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.Lzi, 360.0F, 360.0F, false, this.Lzh);
    if (!this.Lzp)
    {
      AppMethodBeat.o(159670);
      return;
    }
    float f2;
    if (this.Lzn)
    {
      long l = SystemClock.uptimeMillis() - this.Lzk;
      f1 = (float)l * this.Lzj / 1000.0F;
      boolean bool;
      if (this.Lzd >= 200L)
      {
        double d = this.LyZ;
        this.LyZ = (l + d);
        if (this.LyZ > this.Lza)
        {
          this.LyZ -= this.Lza;
          this.Lzd = 0L;
          if (!this.Lzc)
          {
            bool = true;
            this.Lzc = bool;
          }
        }
        else
        {
          f2 = (float)Math.cos((this.LyZ / this.Lza + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
          if (!this.Lzc) {
            break label307;
          }
          this.Lzb = (f2 * 254.0F);
        }
      }
      for (;;)
      {
        this.mProgress += f1;
        if (this.mProgress > 360.0F) {
          this.mProgress -= 360.0F;
        }
        this.Lzk = SystemClock.uptimeMillis();
        f1 = this.mProgress - 90.0F;
        f2 = 16.0F + this.Lzb;
        if (isInEditMode())
        {
          f1 = 0.0F;
          f2 = 135.0F;
        }
        paramCanvas.drawArc(this.Lzi, f1, f2, false, this.Lzg);
        if (i != 0) {
          invalidate();
        }
        AppMethodBeat.o(159670);
        return;
        bool = false;
        break;
        label307:
        f2 = (1.0F - f2) * 254.0F;
        this.mProgress += this.Lzb - f2;
        this.Lzb = f2;
        continue;
        this.Lzd = (l + this.Lzd);
      }
    }
    float f1 = this.mProgress;
    if (this.mProgress != this.Lzm)
    {
      this.mProgress = Math.min((float)(SystemClock.uptimeMillis() - this.Lzk) / 1000.0F * this.Lzj + this.mProgress, this.Lzm);
      this.Lzk = SystemClock.uptimeMillis();
    }
    for (i = j;; i = 0)
    {
      if (f1 != this.mProgress) {
        fRx();
      }
      f2 = 0.0F;
      f1 = this.mProgress;
      if (!this.Lzl)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 4.0D)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 2.0D)) * 360.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.Lzi, f2 - 90.0F, f1, false, this.Lzg);
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
    this.Lzm = paramParcelable.Lzm;
    this.Lzn = paramParcelable.Lzn;
    this.Lzj = paramParcelable.Lzj;
    this.LyW = paramParcelable.LyW;
    this.Lze = paramParcelable.Lze;
    this.LyX = paramParcelable.LyX;
    this.Lzf = paramParcelable.Lzf;
    this.circleRadius = paramParcelable.circleRadius;
    this.Lzl = paramParcelable.Lzl;
    this.LyY = paramParcelable.LyY;
    this.Lzk = SystemClock.uptimeMillis();
    AppMethodBeat.o(159675);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159674);
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.mProgress = this.mProgress;
    localWheelSavedState.Lzm = this.Lzm;
    localWheelSavedState.Lzn = this.Lzn;
    localWheelSavedState.Lzj = this.Lzj;
    localWheelSavedState.LyW = this.LyW;
    localWheelSavedState.Lze = this.Lze;
    localWheelSavedState.LyX = this.LyX;
    localWheelSavedState.Lzf = this.Lzf;
    localWheelSavedState.circleRadius = this.circleRadius;
    localWheelSavedState.Lzl = this.Lzl;
    localWheelSavedState.LyY = this.LyY;
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
    if (!this.LyY)
    {
      paramInt3 = Math.min(Math.min(paramInt1 - j - k, paramInt2 - i - paramInt4), this.circleRadius * 2 - this.LyW * 2);
      paramInt1 = j + (paramInt1 - j - k - paramInt3) / 2;
      paramInt2 = paramInt4 + (paramInt2 - paramInt4 - i - paramInt3) / 2;
    }
    for (this.Lzi = new RectF(this.LyW + paramInt1, this.LyW + paramInt2, paramInt1 + paramInt3 - this.LyW, paramInt2 + paramInt3 - this.LyW);; this.Lzi = new RectF(j + this.LyW, paramInt4 + this.LyW, paramInt1 - k - this.LyW, paramInt2 - i - this.LyW))
    {
      fRw();
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
      this.Lzk = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(159671);
  }
  
  public void setBarColor(int paramInt)
  {
    AppMethodBeat.i(159680);
    this.Lze = paramInt;
    fRw();
    if (!this.Lzn) {
      invalidate();
    }
    AppMethodBeat.o(159680);
  }
  
  public void setBarWidth(int paramInt)
  {
    AppMethodBeat.i(159679);
    this.LyW = paramInt;
    if (!this.Lzn) {
      invalidate();
    }
    AppMethodBeat.o(159679);
  }
  
  public void setCallback(a parama)
  {
    AppMethodBeat.i(159669);
    this.Lzo = parama;
    if (!this.Lzn) {
      fRx();
    }
    AppMethodBeat.o(159669);
  }
  
  public void setCircleRadius(int paramInt)
  {
    AppMethodBeat.i(159678);
    this.circleRadius = paramInt;
    if (!this.Lzn) {
      invalidate();
    }
    AppMethodBeat.o(159678);
  }
  
  public void setInstantProgress(float paramFloat)
  {
    AppMethodBeat.i(159673);
    if (this.Lzn)
    {
      this.mProgress = 0.0F;
      this.Lzn = false;
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.Lzm) <= 0.0F)
    {
      AppMethodBeat.o(159673);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.Lzm = Math.min(f * 360.0F, 360.0F);
    this.mProgress = this.Lzm;
    this.Lzk = SystemClock.uptimeMillis();
    invalidate();
    AppMethodBeat.o(159673);
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(159677);
    this.Lzl = paramBoolean;
    if (!this.Lzn) {
      invalidate();
    }
    AppMethodBeat.o(159677);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(159676);
    if (this.Lzn)
    {
      this.mProgress = 0.0F;
      this.Lzn = false;
      fRx();
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.Lzm) <= 0.0F)
    {
      AppMethodBeat.o(159676);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    if (this.mProgress == this.Lzm) {
      this.Lzk = SystemClock.uptimeMillis();
    }
    this.Lzm = Math.min(f * 360.0F, 360.0F);
    invalidate();
    AppMethodBeat.o(159676);
  }
  
  public void setRimColor(int paramInt)
  {
    AppMethodBeat.i(159681);
    this.Lzf = paramInt;
    fRw();
    if (!this.Lzn) {
      invalidate();
    }
    AppMethodBeat.o(159681);
  }
  
  public void setRimWidth(int paramInt)
  {
    AppMethodBeat.i(159682);
    this.LyX = paramInt;
    if (!this.Lzn) {
      invalidate();
    }
    AppMethodBeat.o(159682);
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.Lzj = (360.0F * paramFloat);
  }
  
  static class WheelSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR;
    int LyW;
    int LyX;
    boolean LyY;
    int Lze;
    int Lzf;
    float Lzj;
    boolean Lzl;
    float Lzm;
    boolean Lzn;
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
      this.Lzm = paramParcel.readFloat();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.Lzn = bool1;
        this.Lzj = paramParcel.readFloat();
        this.LyW = paramParcel.readInt();
        this.Lze = paramParcel.readInt();
        this.LyX = paramParcel.readInt();
        this.Lzf = paramParcel.readInt();
        this.circleRadius = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label129;
        }
        bool1 = true;
        label99:
        this.Lzl = bool1;
        if (paramParcel.readByte() == 0) {
          break label134;
        }
      }
      label129:
      label134:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.LyY = bool1;
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
      paramParcel.writeFloat(this.Lzm);
      if (this.Lzn)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeFloat(this.Lzj);
        paramParcel.writeInt(this.LyW);
        paramParcel.writeInt(this.Lze);
        paramParcel.writeInt(this.LyX);
        paramParcel.writeInt(this.Lzf);
        paramParcel.writeInt(this.circleRadius);
        if (!this.Lzl) {
          break label133;
        }
        paramInt = 1;
        label101:
        paramParcel.writeByte((byte)paramInt);
        if (!this.LyY) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel
 * JD-Core Version:    0.7.0.1
 */