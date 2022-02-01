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
import com.tencent.mm.ae.a.a;
import com.tencent.mm.cc.a;

public class BubbleLayout
  extends FrameLayout
{
  private Paint JgP;
  private Path JgQ;
  private a JgR;
  private int JgS;
  private int JgT;
  private int JgU;
  private int JgV;
  private int JgW;
  private int JgX;
  private int JgY;
  private int JgZ;
  private b Jha;
  private Region Jhb;
  private int QC;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int mgj;
  private Path vU;
  private int ym;
  private int yn;
  private int yo;
  private int yp;
  
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
    this.Jhb = new Region();
    setLayerType(1, null);
    setWillNotDraw(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.BubbleLayout, paramInt, 0);
    this.JgR = a.acT(paramContext.getInt(3, a.Jhg.value));
    this.JgT = paramContext.getDimensionPixelOffset(5, 0);
    this.JgU = paramContext.getDimensionPixelOffset(6, a.g(getContext(), 17.0F));
    this.JgV = paramContext.getDimensionPixelOffset(4, a.g(getContext(), 17.0F));
    this.QC = paramContext.getDimensionPixelOffset(8, a.g(getContext(), 3.3F));
    this.JgW = paramContext.getDimensionPixelOffset(9, a.g(getContext(), 1.0F));
    this.JgX = paramContext.getDimensionPixelOffset(10, a.g(getContext(), 1.0F));
    this.JgY = paramContext.getDimensionPixelOffset(2, a.g(getContext(), 7.0F));
    this.JgS = paramContext.getDimensionPixelOffset(1, a.g(getContext(), 8.0F));
    this.mgj = paramContext.getColor(7, -7829368);
    this.JgZ = paramContext.getColor(0, -1);
    paramContext.recycle();
    this.mPaint = new Paint(5);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.JgP = new Paint(5);
    this.JgP.setStyle(Paint.Style.FILL);
    this.vU = new Path();
    this.JgQ = new Path();
    fvE();
    AppMethodBeat.o(143546);
  }
  
  private void WJ()
  {
    int j = 0;
    AppMethodBeat.i(143551);
    this.mPaint.setPathEffect(new CornerPathEffect(this.JgY));
    this.mPaint.setShadowLayer(this.QC, this.JgW, this.JgX, this.mgj);
    int k = this.JgS;
    int i;
    if (this.JgR == a.Jhd)
    {
      i = this.JgV;
      this.ym = (i + k);
      k = this.JgS;
      if (this.JgR != a.Jhe) {
        break label361;
      }
      i = this.JgV;
      label100:
      this.yn = (i + k);
      k = this.mWidth;
      int m = this.JgS;
      if (this.JgR != a.Jhf) {
        break label366;
      }
      i = this.JgV;
      label133:
      this.yo = (k - m - i);
      k = this.mHeight;
      m = this.JgS;
      i = j;
      if (this.JgR == a.Jhg) {
        i = this.JgV;
      }
      this.yp = (k - m - i);
      this.mPaint.setColor(this.JgZ);
      this.JgP.setColor(this.JgZ);
      this.vU.reset();
      this.JgQ.reset();
      j = this.JgT;
      i = j;
      if (this.JgV + j > this.yp) {
        i = this.yp - this.JgU;
      }
      if (i <= this.JgS) {
        break label371;
      }
      j = i;
      label257:
      k = this.JgT;
      i = k;
      if (this.JgV + k > this.yo) {
        i = this.yo - this.JgU;
      }
      if (i <= this.JgS) {
        break label379;
      }
      label295:
      switch (1.Jhc[this.JgR.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.vU.close();
      this.JgQ.close();
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
      j = this.JgS;
      break label257;
      label379:
      i = this.JgS;
      break label295;
      this.vU.moveTo(this.ym, j);
      this.JgQ.moveTo(this.ym, j);
      this.JgQ.rLineTo(-this.JgV, this.JgU / 2);
      this.JgQ.rLineTo(this.JgV, this.JgU / 2);
      this.JgQ.lineTo(this.ym, j);
      this.vU.lineTo(this.ym, this.yp);
      this.vU.lineTo(this.yo, this.yp);
      this.vU.lineTo(this.yo, this.yn);
      this.vU.lineTo(this.ym, this.yn);
      continue;
      this.vU.moveTo(i, this.yn);
      this.JgQ.moveTo(i, this.yn);
      this.JgQ.rLineTo(this.JgU / 2, -this.JgV);
      this.JgQ.rLineTo(this.JgU / 2, this.JgV);
      this.JgQ.lineTo(i, this.yn);
      this.vU.lineTo(this.yo, this.yn);
      this.vU.lineTo(this.yo, this.yp);
      this.vU.lineTo(this.ym, this.yp);
      this.vU.lineTo(this.ym, this.yn);
      continue;
      this.vU.moveTo(this.yo, j);
      this.JgQ.moveTo(this.yo, j);
      this.JgQ.rLineTo(this.JgV, this.JgU / 2);
      this.JgQ.rLineTo(-this.JgV, this.JgU / 2);
      this.JgQ.lineTo(this.yo, j);
      this.vU.lineTo(this.yo, this.yp);
      this.vU.lineTo(this.ym, this.yp);
      this.vU.lineTo(this.ym, this.yn);
      this.vU.lineTo(this.yo, this.yn);
      continue;
      this.vU.moveTo(i, this.yp);
      this.JgQ.moveTo(i, this.yp);
      this.JgQ.rLineTo(this.JgU / 2, this.JgV);
      this.JgQ.rLineTo(this.JgU / 2, -this.JgV);
      this.JgQ.lineTo(i, this.yp);
      this.vU.lineTo(this.yo, this.yp);
      this.vU.lineTo(this.yo, this.yn);
      this.vU.lineTo(this.ym, this.yn);
      this.vU.lineTo(this.ym, this.yp);
    }
  }
  
  public final void fvE()
  {
    AppMethodBeat.i(143547);
    int i = this.JgS * 2;
    switch (1.Jhc[this.JgR.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, i, this.JgV + i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, this.JgV + i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(this.JgV + i, i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, this.JgV + i, i);
    }
  }
  
  public int getBubbleColor()
  {
    return this.JgZ;
  }
  
  public int getBubblePadding()
  {
    return this.JgS;
  }
  
  public int getBubbleRadius()
  {
    return this.JgY;
  }
  
  public a getLook()
  {
    return this.JgR;
  }
  
  public int getLookLength()
  {
    return this.JgV;
  }
  
  public int getLookPosition()
  {
    return this.JgT;
  }
  
  public int getLookWidth()
  {
    return this.JgU;
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public Path getPath()
  {
    return this.vU;
  }
  
  public int getShadowColor()
  {
    return this.mgj;
  }
  
  public int getShadowRadius()
  {
    return this.QC;
  }
  
  public int getShadowX()
  {
    return this.JgW;
  }
  
  public int getShadowY()
  {
    return this.JgX;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(143549);
    WJ();
    super.invalidate();
    AppMethodBeat.o(143549);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143552);
    super.onDraw(paramCanvas);
    this.mPaint.setPathEffect(new CornerPathEffect(this.JgY));
    paramCanvas.drawPath(this.vU, this.mPaint);
    this.mPaint.setPathEffect(null);
    paramCanvas.drawPath(this.JgQ, this.JgP);
    AppMethodBeat.o(143552);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(143557);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.JgT = paramParcelable.getInt("mLookPosition");
      this.JgU = paramParcelable.getInt("mLookWidth");
      this.JgV = paramParcelable.getInt("mLookLength");
      this.mgj = paramParcelable.getInt("mShadowColor");
      this.QC = paramParcelable.getInt("mShadowRadius");
      this.JgW = paramParcelable.getInt("mShadowX");
      this.JgX = paramParcelable.getInt("mShadowY");
      this.JgY = paramParcelable.getInt("mBubbleRadius");
      this.mWidth = paramParcelable.getInt("mWidth");
      this.mHeight = paramParcelable.getInt("mHeight");
      this.ym = paramParcelable.getInt("mLeft");
      this.yn = paramParcelable.getInt("mTop");
      this.yo = paramParcelable.getInt("mRight");
      this.yp = paramParcelable.getInt("mBottom");
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
    localBundle.putInt("mLookPosition", this.JgT);
    localBundle.putInt("mLookWidth", this.JgU);
    localBundle.putInt("mLookLength", this.JgV);
    localBundle.putInt("mShadowColor", this.mgj);
    localBundle.putInt("mShadowRadius", this.QC);
    localBundle.putInt("mShadowX", this.JgW);
    localBundle.putInt("mShadowY", this.JgX);
    localBundle.putInt("mBubbleRadius", this.JgY);
    localBundle.putInt("mWidth", this.mWidth);
    localBundle.putInt("mHeight", this.mHeight);
    localBundle.putInt("mLeft", this.ym);
    localBundle.putInt("mTop", this.yn);
    localBundle.putInt("mRight", this.yo);
    localBundle.putInt("mBottom", this.yp);
    AppMethodBeat.o(143556);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143548);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    WJ();
    AppMethodBeat.o(143548);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143553);
    if (paramMotionEvent.getAction() == 0)
    {
      RectF localRectF = new RectF();
      this.vU.computeBounds(localRectF, true);
      this.Jhb.setPath(this.vU, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
      if ((!this.Jhb.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.Jha != null)) {
        this.Jha.fvD();
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143553);
    return bool;
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(143550);
    WJ();
    super.postInvalidate();
    AppMethodBeat.o(143550);
  }
  
  public void setBubbleColor(int paramInt)
  {
    this.JgZ = paramInt;
  }
  
  public void setBubbleRadius(int paramInt)
  {
    this.JgY = paramInt;
  }
  
  public void setLook(a parama)
  {
    AppMethodBeat.i(143554);
    this.JgR = parama;
    fvE();
    AppMethodBeat.o(143554);
  }
  
  public void setLookLength(int paramInt)
  {
    AppMethodBeat.i(143555);
    this.JgV = paramInt;
    fvE();
    AppMethodBeat.o(143555);
  }
  
  public void setLookPosition(int paramInt)
  {
    this.JgT = paramInt;
  }
  
  public void setLookWidth(int paramInt)
  {
    this.JgU = paramInt;
  }
  
  public void setOnClickEdgeListener(b paramb)
  {
    this.Jha = paramb;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.mgj = paramInt;
  }
  
  public void setShadowRadius(int paramInt)
  {
    this.QC = paramInt;
  }
  
  public void setShadowX(int paramInt)
  {
    this.JgW = paramInt;
  }
  
  public void setShadowY(int paramInt)
  {
    this.JgX = paramInt;
  }
  
  public static enum a
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143545);
      Jhd = new a("LEFT", 0, 1);
      Jhe = new a("TOP", 1, 2);
      Jhf = new a("RIGHT", 2, 3);
      Jhg = new a("BOTTOM", 3, 4);
      Jhh = new a[] { Jhd, Jhe, Jhf, Jhg };
      AppMethodBeat.o(143545);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a acT(int paramInt)
    {
      a locala = Jhg;
      switch (paramInt)
      {
      default: 
        return locala;
      case 1: 
        return Jhd;
      case 2: 
        return Jhe;
      case 3: 
        return Jhf;
      }
      return Jhg;
    }
  }
  
  public static abstract interface b
  {
    public abstract void fvD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */