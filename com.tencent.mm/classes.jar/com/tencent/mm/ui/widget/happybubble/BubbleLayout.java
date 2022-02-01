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
import com.tencent.mm.cb.a;

public class BubbleLayout
  extends FrameLayout
{
  private int Al;
  private int Am;
  private int An;
  private int Ao;
  private Paint QQj;
  private Path QQk;
  private a QQl;
  private int QQm;
  private int QQn;
  private int QQo;
  private int QQp;
  private int QQq;
  private int QQr;
  private int QQs;
  private int QQt;
  private b QQu;
  private Region QQv;
  private int SE;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int nYW;
  private Path xT;
  
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
    this.QQv = new Region();
    setLayerType(1, null);
    setWillNotDraw(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.BubbleLayout, paramInt, 0);
    this.QQl = a.apg(paramContext.getInt(3, a.QQA.value));
    this.QQn = paramContext.getDimensionPixelOffset(5, 0);
    this.QQo = paramContext.getDimensionPixelOffset(6, a.fromDPToPix(getContext(), 17.0F));
    this.QQp = paramContext.getDimensionPixelOffset(4, a.fromDPToPix(getContext(), 17.0F));
    this.SE = paramContext.getDimensionPixelOffset(8, a.fromDPToPix(getContext(), 3.3F));
    this.QQq = paramContext.getDimensionPixelOffset(9, a.fromDPToPix(getContext(), 1.0F));
    this.QQr = paramContext.getDimensionPixelOffset(10, a.fromDPToPix(getContext(), 1.0F));
    this.QQs = paramContext.getDimensionPixelOffset(2, a.fromDPToPix(getContext(), 7.0F));
    this.QQm = paramContext.getDimensionPixelOffset(1, a.fromDPToPix(getContext(), 8.0F));
    this.nYW = paramContext.getColor(7, -7829368);
    this.QQt = paramContext.getColor(0, -1);
    paramContext.recycle();
    this.mPaint = new Paint(5);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.QQj = new Paint(5);
    this.QQj.setStyle(Paint.Style.FILL);
    this.xT = new Path();
    this.QQk = new Path();
    hbL();
    AppMethodBeat.o(143546);
  }
  
  private void amZ()
  {
    int j = 0;
    AppMethodBeat.i(143551);
    this.mPaint.setPathEffect(new CornerPathEffect(this.QQs));
    this.mPaint.setShadowLayer(this.SE, this.QQq, this.QQr, this.nYW);
    int k = this.QQm;
    int i;
    if (this.QQl == a.QQx)
    {
      i = this.QQp;
      this.Al = (i + k);
      k = this.QQm;
      if (this.QQl != a.QQy) {
        break label361;
      }
      i = this.QQp;
      label100:
      this.Am = (i + k);
      k = this.mWidth;
      int m = this.QQm;
      if (this.QQl != a.QQz) {
        break label366;
      }
      i = this.QQp;
      label133:
      this.An = (k - m - i);
      k = this.mHeight;
      m = this.QQm;
      i = j;
      if (this.QQl == a.QQA) {
        i = this.QQp;
      }
      this.Ao = (k - m - i);
      this.mPaint.setColor(this.QQt);
      this.QQj.setColor(this.QQt);
      this.xT.reset();
      this.QQk.reset();
      j = this.QQn;
      i = j;
      if (this.QQp + j > this.Ao) {
        i = this.Ao - this.QQo;
      }
      if (i <= this.QQm) {
        break label371;
      }
      j = i;
      label257:
      k = this.QQn;
      i = k;
      if (this.QQp + k > this.An) {
        i = this.An - this.QQo;
      }
      if (i <= this.QQm) {
        break label379;
      }
      label295:
      switch (1.QQw[this.QQl.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.xT.close();
      this.QQk.close();
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
      j = this.QQm;
      break label257;
      label379:
      i = this.QQm;
      break label295;
      this.xT.moveTo(this.Al, j);
      this.QQk.moveTo(this.Al, j);
      this.QQk.rLineTo(-this.QQp, this.QQo / 2);
      this.QQk.rLineTo(this.QQp, this.QQo / 2);
      this.QQk.lineTo(this.Al, j);
      this.xT.lineTo(this.Al, this.Ao);
      this.xT.lineTo(this.An, this.Ao);
      this.xT.lineTo(this.An, this.Am);
      this.xT.lineTo(this.Al, this.Am);
      continue;
      this.xT.moveTo(i, this.Am);
      this.QQk.moveTo(i, this.Am);
      this.QQk.rLineTo(this.QQo / 2, -this.QQp);
      this.QQk.rLineTo(this.QQo / 2, this.QQp);
      this.QQk.lineTo(i, this.Am);
      this.xT.lineTo(this.An, this.Am);
      this.xT.lineTo(this.An, this.Ao);
      this.xT.lineTo(this.Al, this.Ao);
      this.xT.lineTo(this.Al, this.Am);
      continue;
      this.xT.moveTo(this.An, j);
      this.QQk.moveTo(this.An, j);
      this.QQk.rLineTo(this.QQp, this.QQo / 2);
      this.QQk.rLineTo(-this.QQp, this.QQo / 2);
      this.QQk.lineTo(this.An, j);
      this.xT.lineTo(this.An, this.Ao);
      this.xT.lineTo(this.Al, this.Ao);
      this.xT.lineTo(this.Al, this.Am);
      this.xT.lineTo(this.An, this.Am);
      continue;
      this.xT.moveTo(i, this.Ao);
      this.QQk.moveTo(i, this.Ao);
      this.QQk.rLineTo(this.QQo / 2, this.QQp);
      this.QQk.rLineTo(this.QQo / 2, -this.QQp);
      this.QQk.lineTo(i, this.Ao);
      this.xT.lineTo(this.An, this.Ao);
      this.xT.lineTo(this.An, this.Am);
      this.xT.lineTo(this.Al, this.Am);
      this.xT.lineTo(this.Al, this.Ao);
    }
  }
  
  public int getBubbleColor()
  {
    return this.QQt;
  }
  
  public int getBubblePadding()
  {
    return this.QQm;
  }
  
  public int getBubbleRadius()
  {
    return this.QQs;
  }
  
  public a getLook()
  {
    return this.QQl;
  }
  
  public int getLookLength()
  {
    return this.QQp;
  }
  
  public int getLookPosition()
  {
    return this.QQn;
  }
  
  public int getLookWidth()
  {
    return this.QQo;
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public Path getPath()
  {
    return this.xT;
  }
  
  public int getShadowColor()
  {
    return this.nYW;
  }
  
  public int getShadowRadius()
  {
    return this.SE;
  }
  
  public int getShadowX()
  {
    return this.QQq;
  }
  
  public int getShadowY()
  {
    return this.QQr;
  }
  
  public final void hbL()
  {
    AppMethodBeat.i(143547);
    int i = this.QQm * 2;
    switch (1.QQw[this.QQl.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, i, this.QQp + i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, this.QQp + i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(this.QQp + i, i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, this.QQp + i, i);
    }
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(143549);
    amZ();
    super.invalidate();
    AppMethodBeat.o(143549);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143552);
    super.onDraw(paramCanvas);
    this.mPaint.setPathEffect(new CornerPathEffect(this.QQs));
    paramCanvas.drawPath(this.xT, this.mPaint);
    this.mPaint.setPathEffect(null);
    paramCanvas.drawPath(this.QQk, this.QQj);
    AppMethodBeat.o(143552);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(143557);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.QQn = paramParcelable.getInt("mLookPosition");
      this.QQo = paramParcelable.getInt("mLookWidth");
      this.QQp = paramParcelable.getInt("mLookLength");
      this.nYW = paramParcelable.getInt("mShadowColor");
      this.SE = paramParcelable.getInt("mShadowRadius");
      this.QQq = paramParcelable.getInt("mShadowX");
      this.QQr = paramParcelable.getInt("mShadowY");
      this.QQs = paramParcelable.getInt("mBubbleRadius");
      this.mWidth = paramParcelable.getInt("mWidth");
      this.mHeight = paramParcelable.getInt("mHeight");
      this.Al = paramParcelable.getInt("mLeft");
      this.Am = paramParcelable.getInt("mTop");
      this.An = paramParcelable.getInt("mRight");
      this.Ao = paramParcelable.getInt("mBottom");
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
    localBundle.putInt("mLookPosition", this.QQn);
    localBundle.putInt("mLookWidth", this.QQo);
    localBundle.putInt("mLookLength", this.QQp);
    localBundle.putInt("mShadowColor", this.nYW);
    localBundle.putInt("mShadowRadius", this.SE);
    localBundle.putInt("mShadowX", this.QQq);
    localBundle.putInt("mShadowY", this.QQr);
    localBundle.putInt("mBubbleRadius", this.QQs);
    localBundle.putInt("mWidth", this.mWidth);
    localBundle.putInt("mHeight", this.mHeight);
    localBundle.putInt("mLeft", this.Al);
    localBundle.putInt("mTop", this.Am);
    localBundle.putInt("mRight", this.An);
    localBundle.putInt("mBottom", this.Ao);
    AppMethodBeat.o(143556);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143548);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    amZ();
    AppMethodBeat.o(143548);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143553);
    if (paramMotionEvent.getAction() == 0)
    {
      RectF localRectF = new RectF();
      this.xT.computeBounds(localRectF, true);
      this.QQv.setPath(this.xT, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
      if ((!this.QQv.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.QQu != null)) {
        this.QQu.hbK();
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143553);
    return bool;
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(143550);
    amZ();
    super.postInvalidate();
    AppMethodBeat.o(143550);
  }
  
  public void setBubbleColor(int paramInt)
  {
    this.QQt = paramInt;
  }
  
  public void setBubbleRadius(int paramInt)
  {
    this.QQs = paramInt;
  }
  
  public void setLook(a parama)
  {
    AppMethodBeat.i(143554);
    this.QQl = parama;
    hbL();
    AppMethodBeat.o(143554);
  }
  
  public void setLookLength(int paramInt)
  {
    AppMethodBeat.i(143555);
    this.QQp = paramInt;
    hbL();
    AppMethodBeat.o(143555);
  }
  
  public void setLookPosition(int paramInt)
  {
    this.QQn = paramInt;
  }
  
  public void setLookWidth(int paramInt)
  {
    this.QQo = paramInt;
  }
  
  public void setOnClickEdgeListener(b paramb)
  {
    this.QQu = paramb;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.nYW = paramInt;
  }
  
  public void setShadowRadius(int paramInt)
  {
    this.SE = paramInt;
  }
  
  public void setShadowX(int paramInt)
  {
    this.QQq = paramInt;
  }
  
  public void setShadowY(int paramInt)
  {
    this.QQr = paramInt;
  }
  
  public static enum a
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143545);
      QQx = new a("LEFT", 0, 1);
      QQy = new a("TOP", 1, 2);
      QQz = new a("RIGHT", 2, 3);
      QQA = new a("BOTTOM", 3, 4);
      QQB = new a[] { QQx, QQy, QQz, QQA };
      AppMethodBeat.o(143545);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a apg(int paramInt)
    {
      a locala = QQA;
      switch (paramInt)
      {
      default: 
        return locala;
      case 1: 
        return QQx;
      case 2: 
        return QQy;
      case 3: 
        return QQz;
      }
      return QQA;
    }
  }
  
  public static abstract interface b
  {
    public abstract void hbK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */