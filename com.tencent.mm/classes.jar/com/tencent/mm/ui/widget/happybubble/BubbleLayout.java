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
import com.tencent.mm.ah.a.m;
import com.tencent.mm.ci.a;

public class BubbleLayout
  extends FrameLayout
{
  private Paint YoU;
  private Path YoV;
  private a YoW;
  private int YoX;
  private int YoY;
  private int YoZ;
  private int Ypa;
  private int Ypb;
  private int Ypc;
  private int Ypd;
  private int Ype;
  private b Ypf;
  private Region Ypg;
  private int aob;
  private int apP;
  private int apQ;
  private Path auD;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int raH;
  private int tF;
  private int tG;
  
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
    this.Ypg = new Region();
    setLayerType(1, null);
    setWillNotDraw(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.BubbleLayout, paramInt, 0);
    this.YoW = a.ayw(paramContext.getInt(a.m.BubbleLayout_lookAt, a.Ypl.value));
    this.YoY = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_lookPosition, 0);
    this.YoZ = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_lookWidth, a.fromDPToPix(getContext(), 17.0F));
    this.Ypa = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_lookLength, a.fromDPToPix(getContext(), 17.0F));
    this.aob = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_shadowRadius, a.fromDPToPix(getContext(), 3.3F));
    this.Ypb = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_shadowX, a.fromDPToPix(getContext(), 1.0F));
    this.Ypc = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_shadowY, a.fromDPToPix(getContext(), 1.0F));
    this.Ypd = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_bubbleRadius, a.fromDPToPix(getContext(), 7.0F));
    this.YoX = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_bubblePadding, a.fromDPToPix(getContext(), 8.0F));
    this.raH = paramContext.getColor(a.m.BubbleLayout_shadowColor, -7829368);
    this.Ype = paramContext.getColor(a.m.BubbleLayout_bubbleColor, -1);
    paramContext.recycle();
    this.mPaint = new Paint(5);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.YoU = new Paint(5);
    this.YoU.setStyle(Paint.Style.FILL);
    this.auD = new Path();
    this.YoV = new Path();
    icS();
    AppMethodBeat.o(143546);
  }
  
  private void ata()
  {
    int j = 0;
    AppMethodBeat.i(143551);
    this.mPaint.setPathEffect(new CornerPathEffect(this.Ypd));
    this.mPaint.setShadowLayer(this.aob, this.Ypb, this.Ypc, this.raH);
    int k = this.YoX;
    int i;
    if (this.YoW == a.Ypi)
    {
      i = this.Ypa;
      this.tF = (i + k);
      k = this.YoX;
      if (this.YoW != a.Ypj) {
        break label361;
      }
      i = this.Ypa;
      label100:
      this.apP = (i + k);
      k = this.mWidth;
      int m = this.YoX;
      if (this.YoW != a.Ypk) {
        break label366;
      }
      i = this.Ypa;
      label133:
      this.tG = (k - m - i);
      k = this.mHeight;
      m = this.YoX;
      i = j;
      if (this.YoW == a.Ypl) {
        i = this.Ypa;
      }
      this.apQ = (k - m - i);
      this.mPaint.setColor(this.Ype);
      this.YoU.setColor(this.Ype);
      this.auD.reset();
      this.YoV.reset();
      j = this.YoY;
      i = j;
      if (this.Ypa + j > this.apQ) {
        i = this.apQ - this.YoZ;
      }
      if (i <= this.YoX) {
        break label371;
      }
      j = i;
      label257:
      k = this.YoY;
      i = k;
      if (this.Ypa + k > this.tG) {
        i = this.tG - this.YoZ;
      }
      if (i <= this.YoX) {
        break label379;
      }
      label295:
      switch (1.Yph[this.YoW.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.auD.close();
      this.YoV.close();
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
      j = this.YoX;
      break label257;
      label379:
      i = this.YoX;
      break label295;
      this.auD.moveTo(this.tF, j);
      this.YoV.moveTo(this.tF, j);
      this.YoV.rLineTo(-this.Ypa, this.YoZ / 2);
      this.YoV.rLineTo(this.Ypa, this.YoZ / 2);
      this.YoV.lineTo(this.tF, j);
      this.auD.lineTo(this.tF, this.apQ);
      this.auD.lineTo(this.tG, this.apQ);
      this.auD.lineTo(this.tG, this.apP);
      this.auD.lineTo(this.tF, this.apP);
      continue;
      this.auD.moveTo(i, this.apP);
      this.YoV.moveTo(i, this.apP);
      this.YoV.rLineTo(this.YoZ / 2, -this.Ypa);
      this.YoV.rLineTo(this.YoZ / 2, this.Ypa);
      this.YoV.lineTo(i, this.apP);
      this.auD.lineTo(this.tG, this.apP);
      this.auD.lineTo(this.tG, this.apQ);
      this.auD.lineTo(this.tF, this.apQ);
      this.auD.lineTo(this.tF, this.apP);
      continue;
      this.auD.moveTo(this.tG, j);
      this.YoV.moveTo(this.tG, j);
      this.YoV.rLineTo(this.Ypa, this.YoZ / 2);
      this.YoV.rLineTo(-this.Ypa, this.YoZ / 2);
      this.YoV.lineTo(this.tG, j);
      this.auD.lineTo(this.tG, this.apQ);
      this.auD.lineTo(this.tF, this.apQ);
      this.auD.lineTo(this.tF, this.apP);
      this.auD.lineTo(this.tG, this.apP);
      continue;
      this.auD.moveTo(i, this.apQ);
      this.YoV.moveTo(i, this.apQ);
      this.YoV.rLineTo(this.YoZ / 2, this.Ypa);
      this.YoV.rLineTo(this.YoZ / 2, -this.Ypa);
      this.YoV.lineTo(i, this.apQ);
      this.auD.lineTo(this.tG, this.apQ);
      this.auD.lineTo(this.tG, this.apP);
      this.auD.lineTo(this.tF, this.apP);
      this.auD.lineTo(this.tF, this.apQ);
    }
  }
  
  public int getBubbleColor()
  {
    return this.Ype;
  }
  
  public int getBubblePadding()
  {
    return this.YoX;
  }
  
  public int getBubbleRadius()
  {
    return this.Ypd;
  }
  
  public a getLook()
  {
    return this.YoW;
  }
  
  public int getLookLength()
  {
    return this.Ypa;
  }
  
  public int getLookPosition()
  {
    return this.YoY;
  }
  
  public int getLookWidth()
  {
    return this.YoZ;
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public Path getPath()
  {
    return this.auD;
  }
  
  public int getShadowColor()
  {
    return this.raH;
  }
  
  public int getShadowRadius()
  {
    return this.aob;
  }
  
  public int getShadowX()
  {
    return this.Ypb;
  }
  
  public int getShadowY()
  {
    return this.Ypc;
  }
  
  public final void icS()
  {
    AppMethodBeat.i(143547);
    int i = this.YoX * 2;
    switch (1.Yph[this.YoW.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, i, this.Ypa + i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, this.Ypa + i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(this.Ypa + i, i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, this.Ypa + i, i);
    }
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(143549);
    ata();
    super.invalidate();
    AppMethodBeat.o(143549);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143552);
    super.onDraw(paramCanvas);
    this.mPaint.setPathEffect(new CornerPathEffect(this.Ypd));
    paramCanvas.drawPath(this.auD, this.mPaint);
    this.mPaint.setPathEffect(null);
    paramCanvas.drawPath(this.YoV, this.YoU);
    AppMethodBeat.o(143552);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(143557);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.YoY = paramParcelable.getInt("mLookPosition");
      this.YoZ = paramParcelable.getInt("mLookWidth");
      this.Ypa = paramParcelable.getInt("mLookLength");
      this.raH = paramParcelable.getInt("mShadowColor");
      this.aob = paramParcelable.getInt("mShadowRadius");
      this.Ypb = paramParcelable.getInt("mShadowX");
      this.Ypc = paramParcelable.getInt("mShadowY");
      this.Ypd = paramParcelable.getInt("mBubbleRadius");
      this.mWidth = paramParcelable.getInt("mWidth");
      this.mHeight = paramParcelable.getInt("mHeight");
      this.tF = paramParcelable.getInt("mLeft");
      this.apP = paramParcelable.getInt("mTop");
      this.tG = paramParcelable.getInt("mRight");
      this.apQ = paramParcelable.getInt("mBottom");
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
    localBundle.putInt("mLookPosition", this.YoY);
    localBundle.putInt("mLookWidth", this.YoZ);
    localBundle.putInt("mLookLength", this.Ypa);
    localBundle.putInt("mShadowColor", this.raH);
    localBundle.putInt("mShadowRadius", this.aob);
    localBundle.putInt("mShadowX", this.Ypb);
    localBundle.putInt("mShadowY", this.Ypc);
    localBundle.putInt("mBubbleRadius", this.Ypd);
    localBundle.putInt("mWidth", this.mWidth);
    localBundle.putInt("mHeight", this.mHeight);
    localBundle.putInt("mLeft", this.tF);
    localBundle.putInt("mTop", this.apP);
    localBundle.putInt("mRight", this.tG);
    localBundle.putInt("mBottom", this.apQ);
    AppMethodBeat.o(143556);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143548);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    ata();
    AppMethodBeat.o(143548);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143553);
    if (paramMotionEvent.getAction() == 0)
    {
      RectF localRectF = new RectF();
      this.auD.computeBounds(localRectF, true);
      this.Ypg.setPath(this.auD, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
      if ((!this.Ypg.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.Ypf != null)) {
        this.Ypf.icR();
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143553);
    return bool;
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(143550);
    ata();
    super.postInvalidate();
    AppMethodBeat.o(143550);
  }
  
  public void setBubbleColor(int paramInt)
  {
    this.Ype = paramInt;
  }
  
  public void setBubbleRadius(int paramInt)
  {
    this.Ypd = paramInt;
  }
  
  public void setLook(a parama)
  {
    AppMethodBeat.i(143554);
    this.YoW = parama;
    icS();
    AppMethodBeat.o(143554);
  }
  
  public void setLookLength(int paramInt)
  {
    AppMethodBeat.i(143555);
    this.Ypa = paramInt;
    icS();
    AppMethodBeat.o(143555);
  }
  
  public void setLookPosition(int paramInt)
  {
    this.YoY = paramInt;
  }
  
  public void setLookWidth(int paramInt)
  {
    this.YoZ = paramInt;
  }
  
  public void setOnClickEdgeListener(b paramb)
  {
    this.Ypf = paramb;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.raH = paramInt;
  }
  
  public void setShadowRadius(int paramInt)
  {
    this.aob = paramInt;
  }
  
  public void setShadowX(int paramInt)
  {
    this.Ypb = paramInt;
  }
  
  public void setShadowY(int paramInt)
  {
    this.Ypc = paramInt;
  }
  
  public static enum a
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143545);
      Ypi = new a("LEFT", 0, 1);
      Ypj = new a("TOP", 1, 2);
      Ypk = new a("RIGHT", 2, 3);
      Ypl = new a("BOTTOM", 3, 4);
      Ypm = new a[] { Ypi, Ypj, Ypk, Ypl };
      AppMethodBeat.o(143545);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ayw(int paramInt)
    {
      a locala = Ypl;
      switch (paramInt)
      {
      default: 
        return locala;
      case 1: 
        return Ypi;
      case 2: 
        return Ypj;
      case 3: 
        return Ypk;
      }
      return Ypl;
    }
  }
  
  public static abstract interface b
  {
    public abstract void icR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */