package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.m;

public class MMPinProgressBtn
  extends CompoundButton
{
  private Paint Jn;
  private RectF afF = new RectF();
  private int style;
  private Runnable wjA = new MMPinProgressBtn.1(this);
  private int wjw;
  private Paint wjx;
  private int wjy;
  private final float wjz = 4.0F;
  private int xL;
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet, 0);
  }
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.wjw = 100;
    this.xL = 0;
    Resources localResources = getResources();
    int m = localResources.getColor(a.d.pin_progress_default_circle_color);
    int k = localResources.getColor(a.d.pin_progress_default_progress_color);
    int i = k;
    int j = m;
    if (paramAttributeSet != null) {}
    try
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MMPinProgressBtn, paramInt, 0);
      if (paramAttributeSet == null) {
        break label256;
      }
    }
    finally
    {
      try
      {
        this.wjw = paramAttributeSet.getInteger(a.m.MMPinProgressBtn_max, this.wjw);
        this.xL = paramAttributeSet.getInteger(a.m.MMPinProgressBtn_progress, this.xL);
        paramInt = paramAttributeSet.getColor(a.m.MMPinProgressBtn_circleColor, m);
        k = paramAttributeSet.getColor(a.m.MMPinProgressBtn_progressColor, k);
        this.style = paramAttributeSet.getInteger(a.m.MMPinProgressBtn_style, 0);
        this.wjy = paramAttributeSet.getDimensionPixelSize(a.m.MMPinProgressBtn_innerSize, localResources.getDimensionPixelSize(a.e.pin_progress_inner_size));
        i = k;
        j = paramInt;
        if (paramAttributeSet != null)
        {
          paramAttributeSet.recycle();
          j = paramInt;
          i = k;
        }
        this.Jn = new Paint();
        this.Jn.setColor(j);
        this.Jn.setStyle(Paint.Style.STROKE);
        this.Jn.setStrokeWidth(4.0F);
        this.Jn.setAntiAlias(true);
        this.wjx = new Paint();
        this.wjx.setColor(i);
        this.wjx.setAntiAlias(true);
        setClickable(false);
        return;
      }
      finally {}
      paramContext = finally;
      paramAttributeSet = null;
    }
    paramAttributeSet.recycle();
    label256:
    throw paramContext;
  }
  
  public final void cJO()
  {
    removeCallbacks(this.wjA);
    post(this.wjA);
  }
  
  public int getMax()
  {
    return this.wjw;
  }
  
  public int getProgress()
  {
    return this.xL;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.afF.set(2.0F, 2.0F, this.wjy - 2.0F, this.wjy - 2.0F);
    this.afF.offset((getWidth() - this.wjy) / 2, (getHeight() - this.wjy) / 2);
    paramCanvas.drawArc(this.afF, 0.0F, 360.0F, true, this.Jn);
    switch (this.style)
    {
    default: 
      return;
    case 0: 
      this.afF.set(8.0F, 8.0F, this.wjy - 8.0F, this.wjy - 8.0F);
      this.afF.offset((getWidth() - this.wjy) / 2, (getHeight() - this.wjy) / 2);
      paramCanvas.drawArc(this.afF, -90.0F, 360.0F * (this.xL * 1.0F / this.wjw), true, this.wjx);
      return;
    }
    this.afF.set(2.0F, 2.0F, this.wjy - 2.0F, this.wjy - 2.0F);
    this.afF.offset((getWidth() - this.wjy) / 2, (getHeight() - this.wjy) / 2);
    paramCanvas.drawArc(this.afF, 270.0F, this.xL * 1.0F / this.wjw * 360.0F - 360.0F, true, this.wjx);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(resolveSize(this.wjy, paramInt1), resolveSize(this.wjy, paramInt2));
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof MMPinProgressBtn.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (MMPinProgressBtn.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.wjw = MMPinProgressBtn.SavedState.a(paramParcelable);
    this.xL = MMPinProgressBtn.SavedState.b(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Object localObject = super.onSaveInstanceState();
    if (isSaveEnabled())
    {
      localObject = new MMPinProgressBtn.SavedState((Parcelable)localObject);
      MMPinProgressBtn.SavedState.a((MMPinProgressBtn.SavedState)localObject, this.wjw);
      MMPinProgressBtn.SavedState.b((MMPinProgressBtn.SavedState)localObject, this.xL);
      return localObject;
    }
    return localObject;
  }
  
  public void setMax(int paramInt)
  {
    this.wjw = Math.max(0, paramInt);
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    this.xL = Math.max(0, paramInt);
    this.xL = Math.min(paramInt, this.wjw);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMPinProgressBtn
 * JD-Core Version:    0.7.0.1
 */