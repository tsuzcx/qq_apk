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
  private final int JkV;
  private final int JkW;
  private final long JkX;
  private int JkY;
  private int JkZ;
  private boolean Jla;
  private double Jlb;
  private double Jlc;
  private float Jld;
  private boolean Jle;
  private long Jlf;
  private int Jlg;
  private int Jlh;
  private Paint Jli;
  private Paint Jlj;
  private RectF Jlk;
  private float Jll;
  private long Jlm;
  private boolean Jln;
  private float Jlo;
  private boolean Jlp;
  private a Jlq;
  private boolean Jlr;
  private float aaZ;
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
    this.JkV = 16;
    this.JkW = 270;
    this.JkX = 200L;
    this.circleRadius = 28;
    this.JkY = 4;
    this.JkZ = 4;
    this.Jla = false;
    this.Jlb = 0.0D;
    this.Jlc = 460.0D;
    this.Jld = 0.0F;
    this.Jle = true;
    this.Jlf = 0L;
    this.Jlg = -1442840576;
    this.Jlh = 16777215;
    this.Jli = new Paint();
    this.Jlj = new Paint();
    this.Jlk = new RectF();
    this.Jll = 230.0F;
    this.Jlm = 0L;
    this.aaZ = 0.0F;
    this.Jlo = 0.0F;
    this.Jlp = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMProgressWheel);
    paramAttributeSet = getContext().getResources().getDisplayMetrics();
    this.JkY = ((int)TypedValue.applyDimension(1, this.JkY, paramAttributeSet));
    this.JkZ = ((int)TypedValue.applyDimension(1, this.JkZ, paramAttributeSet));
    this.circleRadius = ((int)TypedValue.applyDimension(1, this.circleRadius, paramAttributeSet));
    this.circleRadius = ((int)paramContext.getDimension(3, this.circleRadius));
    this.Jla = paramContext.getBoolean(4, false);
    this.JkY = ((int)paramContext.getDimension(2, this.JkY));
    this.JkZ = ((int)paramContext.getDimension(8, this.JkZ));
    this.Jll = (paramContext.getFloat(9, this.Jll / 360.0F) * 360.0F);
    this.Jlc = paramContext.getInt(1, (int)this.Jlc);
    this.Jlg = paramContext.getColor(0, this.Jlg);
    this.Jlh = paramContext.getColor(7, this.Jlh);
    this.Jln = paramContext.getBoolean(5, false);
    if (paramContext.getBoolean(6, false))
    {
      this.Jlm = SystemClock.uptimeMillis();
      this.Jlp = true;
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
      this.Jlr = bool;
      AppMethodBeat.o(159665);
      return;
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
      label433:
      bool = false;
    }
  }
  
  private void fwn()
  {
    AppMethodBeat.i(159668);
    this.Jli.setColor(this.Jlg);
    this.Jli.setAntiAlias(true);
    this.Jli.setStyle(Paint.Style.STROKE);
    this.Jli.setStrokeWidth(this.JkY);
    this.Jlj.setColor(this.Jlh);
    this.Jlj.setAntiAlias(true);
    this.Jlj.setStyle(Paint.Style.STROKE);
    this.Jlj.setStrokeWidth(this.JkZ);
    AppMethodBeat.o(159668);
  }
  
  private void fwo()
  {
    AppMethodBeat.i(159672);
    if (this.Jlq != null) {
      Math.round(this.aaZ * 100.0F / 360.0F);
    }
    AppMethodBeat.o(159672);
  }
  
  public int getBarColor()
  {
    return this.Jlg;
  }
  
  public int getBarWidth()
  {
    return this.JkY;
  }
  
  public int getCircleRadius()
  {
    return this.circleRadius;
  }
  
  public float getProgress()
  {
    if (this.Jlp) {
      return -1.0F;
    }
    return this.aaZ / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.Jlh;
  }
  
  public int getRimWidth()
  {
    return this.JkZ;
  }
  
  public float getSpinSpeed()
  {
    return this.Jll / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(159670);
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.Jlk, 360.0F, 360.0F, false, this.Jlj);
    if (!this.Jlr)
    {
      AppMethodBeat.o(159670);
      return;
    }
    float f2;
    if (this.Jlp)
    {
      long l = SystemClock.uptimeMillis() - this.Jlm;
      f1 = (float)l * this.Jll / 1000.0F;
      boolean bool;
      if (this.Jlf >= 200L)
      {
        double d = this.Jlb;
        this.Jlb = (l + d);
        if (this.Jlb > this.Jlc)
        {
          this.Jlb -= this.Jlc;
          this.Jlf = 0L;
          if (!this.Jle)
          {
            bool = true;
            this.Jle = bool;
          }
        }
        else
        {
          f2 = (float)Math.cos((this.Jlb / this.Jlc + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
          if (!this.Jle) {
            break label307;
          }
          this.Jld = (f2 * 254.0F);
        }
      }
      for (;;)
      {
        this.aaZ += f1;
        if (this.aaZ > 360.0F) {
          this.aaZ -= 360.0F;
        }
        this.Jlm = SystemClock.uptimeMillis();
        f1 = this.aaZ - 90.0F;
        f2 = 16.0F + this.Jld;
        if (isInEditMode())
        {
          f1 = 0.0F;
          f2 = 135.0F;
        }
        paramCanvas.drawArc(this.Jlk, f1, f2, false, this.Jli);
        if (i != 0) {
          invalidate();
        }
        AppMethodBeat.o(159670);
        return;
        bool = false;
        break;
        label307:
        f2 = (1.0F - f2) * 254.0F;
        this.aaZ += this.Jld - f2;
        this.Jld = f2;
        continue;
        this.Jlf = (l + this.Jlf);
      }
    }
    float f1 = this.aaZ;
    if (this.aaZ != this.Jlo)
    {
      this.aaZ = Math.min((float)(SystemClock.uptimeMillis() - this.Jlm) / 1000.0F * this.Jll + this.aaZ, this.Jlo);
      this.Jlm = SystemClock.uptimeMillis();
    }
    for (i = j;; i = 0)
    {
      if (f1 != this.aaZ) {
        fwo();
      }
      f2 = 0.0F;
      f1 = this.aaZ;
      if (!this.Jln)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.aaZ / 360.0F, 4.0D)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.aaZ / 360.0F, 2.0D)) * 360.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.Jlk, f2 - 90.0F, f1, false, this.Jli);
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
    this.aaZ = paramParcelable.aaZ;
    this.Jlo = paramParcelable.Jlo;
    this.Jlp = paramParcelable.Jlp;
    this.Jll = paramParcelable.Jll;
    this.JkY = paramParcelable.JkY;
    this.Jlg = paramParcelable.Jlg;
    this.JkZ = paramParcelable.JkZ;
    this.Jlh = paramParcelable.Jlh;
    this.circleRadius = paramParcelable.circleRadius;
    this.Jln = paramParcelable.Jln;
    this.Jla = paramParcelable.Jla;
    this.Jlm = SystemClock.uptimeMillis();
    AppMethodBeat.o(159675);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159674);
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.aaZ = this.aaZ;
    localWheelSavedState.Jlo = this.Jlo;
    localWheelSavedState.Jlp = this.Jlp;
    localWheelSavedState.Jll = this.Jll;
    localWheelSavedState.JkY = this.JkY;
    localWheelSavedState.Jlg = this.Jlg;
    localWheelSavedState.JkZ = this.JkZ;
    localWheelSavedState.Jlh = this.Jlh;
    localWheelSavedState.circleRadius = this.circleRadius;
    localWheelSavedState.Jln = this.Jln;
    localWheelSavedState.Jla = this.Jla;
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
    if (!this.Jla)
    {
      paramInt3 = Math.min(Math.min(paramInt1 - j - k, paramInt2 - i - paramInt4), this.circleRadius * 2 - this.JkY * 2);
      paramInt1 = j + (paramInt1 - j - k - paramInt3) / 2;
      paramInt2 = paramInt4 + (paramInt2 - paramInt4 - i - paramInt3) / 2;
    }
    for (this.Jlk = new RectF(this.JkY + paramInt1, this.JkY + paramInt2, paramInt1 + paramInt3 - this.JkY, paramInt2 + paramInt3 - this.JkY);; this.Jlk = new RectF(j + this.JkY, paramInt4 + this.JkY, paramInt1 - k - this.JkY, paramInt2 - i - this.JkY))
    {
      fwn();
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
      this.Jlm = SystemClock.uptimeMillis();
    }
    AppMethodBeat.o(159671);
  }
  
  public void setBarColor(int paramInt)
  {
    AppMethodBeat.i(159680);
    this.Jlg = paramInt;
    fwn();
    if (!this.Jlp) {
      invalidate();
    }
    AppMethodBeat.o(159680);
  }
  
  public void setBarWidth(int paramInt)
  {
    AppMethodBeat.i(159679);
    this.JkY = paramInt;
    if (!this.Jlp) {
      invalidate();
    }
    AppMethodBeat.o(159679);
  }
  
  public void setCallback(a parama)
  {
    AppMethodBeat.i(159669);
    this.Jlq = parama;
    if (!this.Jlp) {
      fwo();
    }
    AppMethodBeat.o(159669);
  }
  
  public void setCircleRadius(int paramInt)
  {
    AppMethodBeat.i(159678);
    this.circleRadius = paramInt;
    if (!this.Jlp) {
      invalidate();
    }
    AppMethodBeat.o(159678);
  }
  
  public void setInstantProgress(float paramFloat)
  {
    AppMethodBeat.i(159673);
    if (this.Jlp)
    {
      this.aaZ = 0.0F;
      this.Jlp = false;
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.Jlo) <= 0.0F)
    {
      AppMethodBeat.o(159673);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.Jlo = Math.min(f * 360.0F, 360.0F);
    this.aaZ = this.Jlo;
    this.Jlm = SystemClock.uptimeMillis();
    invalidate();
    AppMethodBeat.o(159673);
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(159677);
    this.Jln = paramBoolean;
    if (!this.Jlp) {
      invalidate();
    }
    AppMethodBeat.o(159677);
  }
  
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(159676);
    if (this.Jlp)
    {
      this.aaZ = 0.0F;
      this.Jlp = false;
      fwo();
    }
    float f;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    while (Math.abs(f - this.Jlo) <= 0.0F)
    {
      AppMethodBeat.o(159676);
      return;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    if (this.aaZ == this.Jlo) {
      this.Jlm = SystemClock.uptimeMillis();
    }
    this.Jlo = Math.min(f * 360.0F, 360.0F);
    invalidate();
    AppMethodBeat.o(159676);
  }
  
  public void setRimColor(int paramInt)
  {
    AppMethodBeat.i(159681);
    this.Jlh = paramInt;
    fwn();
    if (!this.Jlp) {
      invalidate();
    }
    AppMethodBeat.o(159681);
  }
  
  public void setRimWidth(int paramInt)
  {
    AppMethodBeat.i(159682);
    this.JkZ = paramInt;
    if (!this.Jlp) {
      invalidate();
    }
    AppMethodBeat.o(159682);
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.Jll = (360.0F * paramFloat);
  }
  
  static class WheelSavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR;
    int JkY;
    int JkZ;
    boolean Jla;
    int Jlg;
    int Jlh;
    float Jll;
    boolean Jln;
    float Jlo;
    boolean Jlp;
    float aaZ;
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
      this.aaZ = paramParcel.readFloat();
      this.Jlo = paramParcel.readFloat();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.Jlp = bool1;
        this.Jll = paramParcel.readFloat();
        this.JkY = paramParcel.readInt();
        this.Jlg = paramParcel.readInt();
        this.JkZ = paramParcel.readInt();
        this.Jlh = paramParcel.readInt();
        this.circleRadius = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label129;
        }
        bool1 = true;
        label99:
        this.Jln = bool1;
        if (paramParcel.readByte() == 0) {
          break label134;
        }
      }
      label129:
      label134:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.Jla = bool1;
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
      paramParcel.writeFloat(this.aaZ);
      paramParcel.writeFloat(this.Jlo);
      if (this.Jlp)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeFloat(this.Jll);
        paramParcel.writeInt(this.JkY);
        paramParcel.writeInt(this.Jlg);
        paramParcel.writeInt(this.JkZ);
        paramParcel.writeInt(this.Jlh);
        paramParcel.writeInt(this.circleRadius);
        if (!this.Jln) {
          break label133;
        }
        paramInt = 1;
        label101:
        paramParcel.writeByte((byte)paramInt);
        if (!this.Jla) {
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