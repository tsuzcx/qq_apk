package com.tencent.mm.ui.widget.happybubble;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.a;
import com.tencent.mm.cd.a;

public class BubbleLayout
  extends FrameLayout
{
  private int HGA;
  private int HGB;
  private int HGC;
  private b HGD;
  private Region HGE;
  private Paint HGs;
  private Path HGt;
  private a HGu;
  private int HGv;
  private int HGw;
  private int HGx;
  private int HGy;
  private int HGz;
  private int PH;
  private int lEp;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private Path uW;
  private int xo;
  private int xp;
  private int xq;
  private int xr;
  
  public BubbleLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BubbleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BubbleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143546);
    this.HGE = new Region();
    setLayerType(1, null);
    setWillNotDraw(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.BubbleLayout, paramInt, 0);
    this.HGu = a.aaI(paramContext.getInt(3, a.HGJ.value));
    this.HGw = paramContext.getDimensionPixelOffset(5, 0);
    this.HGx = paramContext.getDimensionPixelOffset(6, a.g(getContext(), 17.0F));
    this.HGy = paramContext.getDimensionPixelOffset(4, a.g(getContext(), 17.0F));
    this.PH = paramContext.getDimensionPixelOffset(8, a.g(getContext(), 3.3F));
    this.HGz = paramContext.getDimensionPixelOffset(9, a.g(getContext(), 1.0F));
    this.HGA = paramContext.getDimensionPixelOffset(10, a.g(getContext(), 1.0F));
    this.HGB = paramContext.getDimensionPixelOffset(2, a.g(getContext(), 7.0F));
    this.HGv = paramContext.getDimensionPixelOffset(1, a.g(getContext(), 8.0F));
    this.lEp = paramContext.getColor(7, -7829368);
    this.HGC = paramContext.getColor(0, -1);
    paramContext.recycle();
    this.mPaint = new Paint(5);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.HGs = new Paint(5);
    this.HGs.setStyle(Paint.Style.FILL);
    this.uW = new Path();
    this.HGt = new Path();
    ffF();
    AppMethodBeat.o(143546);
  }
  
  private void VL()
  {
    int j = 0;
    AppMethodBeat.i(143551);
    this.mPaint.setPathEffect(new CornerPathEffect(this.HGB));
    this.mPaint.setShadowLayer(this.PH, this.HGz, this.HGA, this.lEp);
    int k = this.HGv;
    int i;
    if (this.HGu == a.HGG)
    {
      i = this.HGy;
      this.xo = (i + k);
      k = this.HGv;
      if (this.HGu != a.HGH) {
        break label361;
      }
      i = this.HGy;
      label100:
      this.xp = (i + k);
      k = this.mWidth;
      int m = this.HGv;
      if (this.HGu != a.HGI) {
        break label366;
      }
      i = this.HGy;
      label133:
      this.xq = (k - m - i);
      k = this.mHeight;
      m = this.HGv;
      i = j;
      if (this.HGu == a.HGJ) {
        i = this.HGy;
      }
      this.xr = (k - m - i);
      this.mPaint.setColor(this.HGC);
      this.HGs.setColor(this.HGC);
      this.uW.reset();
      this.HGt.reset();
      j = this.HGw;
      i = j;
      if (this.HGy + j > this.xr) {
        i = this.xr - this.HGx;
      }
      if (i <= this.HGv) {
        break label371;
      }
      j = i;
      label257:
      k = this.HGw;
      i = k;
      if (this.HGy + k > this.xq) {
        i = this.xq - this.HGx;
      }
      if (i <= this.HGv) {
        break label379;
      }
      label295:
      switch (1.HGF[this.HGu.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.uW.close();
      this.HGt.close();
      AppMethodBeat.o(143551);
      return;
      i = 0;
      break;
      label361:
      i = 0;
      break label100;
      label366:
      i = 0;
      break label133;
      label371:
      j = this.HGv;
      break label257;
      label379:
      i = this.HGv;
      break label295;
      this.uW.moveTo(this.xo, j);
      this.HGt.moveTo(this.xo, j);
      this.HGt.rLineTo(-this.HGy, this.HGx / 2);
      this.HGt.rLineTo(this.HGy, this.HGx / 2);
      this.HGt.lineTo(this.xo, j);
      this.uW.lineTo(this.xo, this.xr);
      this.uW.lineTo(this.xq, this.xr);
      this.uW.lineTo(this.xq, this.xp);
      this.uW.lineTo(this.xo, this.xp);
      continue;
      this.uW.moveTo(i, this.xp);
      this.HGt.moveTo(i, this.xp);
      this.HGt.rLineTo(this.HGx / 2, -this.HGy);
      this.HGt.rLineTo(this.HGx / 2, this.HGy);
      this.HGt.lineTo(i, this.xp);
      this.uW.lineTo(this.xq, this.xp);
      this.uW.lineTo(this.xq, this.xr);
      this.uW.lineTo(this.xo, this.xr);
      this.uW.lineTo(this.xo, this.xp);
      continue;
      this.uW.moveTo(this.xq, j);
      this.HGt.moveTo(this.xq, j);
      this.HGt.rLineTo(this.HGy, this.HGx / 2);
      this.HGt.rLineTo(-this.HGy, this.HGx / 2);
      this.HGt.lineTo(this.xq, j);
      this.uW.lineTo(this.xq, this.xr);
      this.uW.lineTo(this.xo, this.xr);
      this.uW.lineTo(this.xo, this.xp);
      this.uW.lineTo(this.xq, this.xp);
      continue;
      this.uW.moveTo(i, this.xr);
      this.HGt.moveTo(i, this.xr);
      this.HGt.rLineTo(this.HGx / 2, this.HGy);
      this.HGt.rLineTo(this.HGx / 2, -this.HGy);
      this.HGt.lineTo(i, this.xr);
      this.uW.lineTo(this.xq, this.xr);
      this.uW.lineTo(this.xq, this.xp);
      this.uW.lineTo(this.xo, this.xp);
      this.uW.lineTo(this.xo, this.xr);
    }
  }
  
  public final void ffF()
  {
    AppMethodBeat.i(143547);
    int i = this.HGv * 2;
    switch (1.HGF[this.HGu.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, i, this.HGy + i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, this.HGy + i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(this.HGy + i, i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, this.HGy + i, i);
    }
  }
  
  public int getBubbleColor()
  {
    return this.HGC;
  }
  
  public int getBubblePadding()
  {
    return this.HGv;
  }
  
  public int getBubbleRadius()
  {
    return this.HGB;
  }
  
  public a getLook()
  {
    return this.HGu;
  }
  
  public int getLookLength()
  {
    return this.HGy;
  }
  
  public int getLookPosition()
  {
    return this.HGw;
  }
  
  public int getLookWidth()
  {
    return this.HGx;
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public Path getPath()
  {
    return this.uW;
  }
  
  public int getShadowColor()
  {
    return this.lEp;
  }
  
  public int getShadowRadius()
  {
    return this.PH;
  }
  
  public int getShadowX()
  {
    return this.HGz;
  }
  
  public int getShadowY()
  {
    return this.HGA;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(143549);
    VL();
    super.invalidate();
    AppMethodBeat.o(143549);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143552);
    super.onDraw(paramCanvas);
    this.mPaint.setPathEffect(new CornerPathEffect(this.HGB));
    paramCanvas.drawPath(this.uW, this.mPaint);
    this.mPaint.setPathEffect(null);
    paramCanvas.drawPath(this.HGt, this.HGs);
    AppMethodBeat.o(143552);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(143557);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.HGw = paramParcelable.getInt("mLookPosition");
      this.HGx = paramParcelable.getInt("mLookWidth");
      this.HGy = paramParcelable.getInt("mLookLength");
      this.lEp = paramParcelable.getInt("mShadowColor");
      this.PH = paramParcelable.getInt("mShadowRadius");
      this.HGz = paramParcelable.getInt("mShadowX");
      this.HGA = paramParcelable.getInt("mShadowY");
      this.HGB = paramParcelable.getInt("mBubbleRadius");
      this.mWidth = paramParcelable.getInt("mWidth");
      this.mHeight = paramParcelable.getInt("mHeight");
      this.xo = paramParcelable.getInt("mLeft");
      this.xp = paramParcelable.getInt("mTop");
      this.xq = paramParcelable.getInt("mRight");
      this.xr = paramParcelable.getInt("mBottom");
      super.onRestoreInstanceState(paramParcelable.getParcelable("instanceState"));
      AppMethodBeat.o(143557);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(143557);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(143556);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instanceState", super.onSaveInstanceState());
    localBundle.putInt("mLookPosition", this.HGw);
    localBundle.putInt("mLookWidth", this.HGx);
    localBundle.putInt("mLookLength", this.HGy);
    localBundle.putInt("mShadowColor", this.lEp);
    localBundle.putInt("mShadowRadius", this.PH);
    localBundle.putInt("mShadowX", this.HGz);
    localBundle.putInt("mShadowY", this.HGA);
    localBundle.putInt("mBubbleRadius", this.HGB);
    localBundle.putInt("mWidth", this.mWidth);
    localBundle.putInt("mHeight", this.mHeight);
    localBundle.putInt("mLeft", this.xo);
    localBundle.putInt("mTop", this.xp);
    localBundle.putInt("mRight", this.xq);
    localBundle.putInt("mBottom", this.xr);
    AppMethodBeat.o(143556);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143548);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    VL();
    AppMethodBeat.o(143548);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143553);
    if (paramMotionEvent.getAction() == 0)
    {
      RectF localRectF = new RectF();
      this.uW.computeBounds(localRectF, true);
      this.HGE.setPath(this.uW, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
      if ((!this.HGE.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.HGD != null)) {
        this.HGD.ffE();
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143553);
    return bool;
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(143550);
    VL();
    super.postInvalidate();
    AppMethodBeat.o(143550);
  }
  
  public void setBubbleColor(int paramInt)
  {
    this.HGC = paramInt;
  }
  
  public void setBubbleRadius(int paramInt)
  {
    this.HGB = paramInt;
  }
  
  public void setLook(a parama)
  {
    AppMethodBeat.i(143554);
    this.HGu = parama;
    ffF();
    AppMethodBeat.o(143554);
  }
  
  public void setLookLength(int paramInt)
  {
    AppMethodBeat.i(143555);
    this.HGy = paramInt;
    ffF();
    AppMethodBeat.o(143555);
  }
  
  public void setLookPosition(int paramInt)
  {
    this.HGw = paramInt;
  }
  
  public void setLookWidth(int paramInt)
  {
    this.HGx = paramInt;
  }
  
  public void setOnClickEdgeListener(b paramb)
  {
    this.HGD = paramb;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.lEp = paramInt;
  }
  
  public void setShadowRadius(int paramInt)
  {
    this.PH = paramInt;
  }
  
  public void setShadowX(int paramInt)
  {
    this.HGz = paramInt;
  }
  
  public void setShadowY(int paramInt)
  {
    this.HGA = paramInt;
  }
  
  public static enum a
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143545);
      HGG = new a("LEFT", 0, 1);
      HGH = new a("TOP", 1, 2);
      HGI = new a("RIGHT", 2, 3);
      HGJ = new a("BOTTOM", 3, 4);
      HGK = new a[] { HGG, HGH, HGI, HGJ };
      AppMethodBeat.o(143545);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a aaI(int paramInt)
    {
      a locala = HGJ;
      switch (paramInt)
      {
      default: 
        return locala;
      case 1: 
        return HGG;
      case 2: 
        return HGH;
      case 3: 
        return HGI;
      }
      return HGJ;
    }
  }
  
  public static abstract interface b
  {
    public abstract void ffE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */