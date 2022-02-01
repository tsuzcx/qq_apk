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
import com.tencent.mm.cc.a;

public class BubbleLayout
  extends FrameLayout
{
  private int Af;
  private int Ag;
  private int Ah;
  private int Ai;
  private Paint KYd;
  private Path KYe;
  private a KYf;
  private int KYg;
  private int KYh;
  private int KYi;
  private int KYj;
  private int KYk;
  private int KYl;
  private int KYm;
  private int KYn;
  private b KYo;
  private Region KYp;
  private int Sr;
  private int mGK;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private Path xN;
  
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
    this.KYp = new Region();
    setLayerType(1, null);
    setWillNotDraw(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.BubbleLayout, paramInt, 0);
    this.KYf = a.afu(paramContext.getInt(3, a.KYu.value));
    this.KYh = paramContext.getDimensionPixelOffset(5, 0);
    this.KYi = paramContext.getDimensionPixelOffset(6, a.g(getContext(), 17.0F));
    this.KYj = paramContext.getDimensionPixelOffset(4, a.g(getContext(), 17.0F));
    this.Sr = paramContext.getDimensionPixelOffset(8, a.g(getContext(), 3.3F));
    this.KYk = paramContext.getDimensionPixelOffset(9, a.g(getContext(), 1.0F));
    this.KYl = paramContext.getDimensionPixelOffset(10, a.g(getContext(), 1.0F));
    this.KYm = paramContext.getDimensionPixelOffset(2, a.g(getContext(), 7.0F));
    this.KYg = paramContext.getDimensionPixelOffset(1, a.g(getContext(), 8.0F));
    this.mGK = paramContext.getColor(7, -7829368);
    this.KYn = paramContext.getColor(0, -1);
    paramContext.recycle();
    this.mPaint = new Paint(5);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.KYd = new Paint(5);
    this.KYd.setStyle(Paint.Style.FILL);
    this.xN = new Path();
    this.KYe = new Path();
    fMs();
    AppMethodBeat.o(143546);
  }
  
  private void Zd()
  {
    int j = 0;
    AppMethodBeat.i(143551);
    this.mPaint.setPathEffect(new CornerPathEffect(this.KYm));
    this.mPaint.setShadowLayer(this.Sr, this.KYk, this.KYl, this.mGK);
    int k = this.KYg;
    int i;
    if (this.KYf == a.KYr)
    {
      i = this.KYj;
      this.Af = (i + k);
      k = this.KYg;
      if (this.KYf != a.KYs) {
        break label361;
      }
      i = this.KYj;
      label100:
      this.Ag = (i + k);
      k = this.mWidth;
      int m = this.KYg;
      if (this.KYf != a.KYt) {
        break label366;
      }
      i = this.KYj;
      label133:
      this.Ah = (k - m - i);
      k = this.mHeight;
      m = this.KYg;
      i = j;
      if (this.KYf == a.KYu) {
        i = this.KYj;
      }
      this.Ai = (k - m - i);
      this.mPaint.setColor(this.KYn);
      this.KYd.setColor(this.KYn);
      this.xN.reset();
      this.KYe.reset();
      j = this.KYh;
      i = j;
      if (this.KYj + j > this.Ai) {
        i = this.Ai - this.KYi;
      }
      if (i <= this.KYg) {
        break label371;
      }
      j = i;
      label257:
      k = this.KYh;
      i = k;
      if (this.KYj + k > this.Ah) {
        i = this.Ah - this.KYi;
      }
      if (i <= this.KYg) {
        break label379;
      }
      label295:
      switch (1.KYq[this.KYf.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.xN.close();
      this.KYe.close();
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
      j = this.KYg;
      break label257;
      label379:
      i = this.KYg;
      break label295;
      this.xN.moveTo(this.Af, j);
      this.KYe.moveTo(this.Af, j);
      this.KYe.rLineTo(-this.KYj, this.KYi / 2);
      this.KYe.rLineTo(this.KYj, this.KYi / 2);
      this.KYe.lineTo(this.Af, j);
      this.xN.lineTo(this.Af, this.Ai);
      this.xN.lineTo(this.Ah, this.Ai);
      this.xN.lineTo(this.Ah, this.Ag);
      this.xN.lineTo(this.Af, this.Ag);
      continue;
      this.xN.moveTo(i, this.Ag);
      this.KYe.moveTo(i, this.Ag);
      this.KYe.rLineTo(this.KYi / 2, -this.KYj);
      this.KYe.rLineTo(this.KYi / 2, this.KYj);
      this.KYe.lineTo(i, this.Ag);
      this.xN.lineTo(this.Ah, this.Ag);
      this.xN.lineTo(this.Ah, this.Ai);
      this.xN.lineTo(this.Af, this.Ai);
      this.xN.lineTo(this.Af, this.Ag);
      continue;
      this.xN.moveTo(this.Ah, j);
      this.KYe.moveTo(this.Ah, j);
      this.KYe.rLineTo(this.KYj, this.KYi / 2);
      this.KYe.rLineTo(-this.KYj, this.KYi / 2);
      this.KYe.lineTo(this.Ah, j);
      this.xN.lineTo(this.Ah, this.Ai);
      this.xN.lineTo(this.Af, this.Ai);
      this.xN.lineTo(this.Af, this.Ag);
      this.xN.lineTo(this.Ah, this.Ag);
      continue;
      this.xN.moveTo(i, this.Ai);
      this.KYe.moveTo(i, this.Ai);
      this.KYe.rLineTo(this.KYi / 2, this.KYj);
      this.KYe.rLineTo(this.KYi / 2, -this.KYj);
      this.KYe.lineTo(i, this.Ai);
      this.xN.lineTo(this.Ah, this.Ai);
      this.xN.lineTo(this.Ah, this.Ag);
      this.xN.lineTo(this.Af, this.Ag);
      this.xN.lineTo(this.Af, this.Ai);
    }
  }
  
  public final void fMs()
  {
    AppMethodBeat.i(143547);
    int i = this.KYg * 2;
    switch (1.KYq[this.KYf.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, i, this.KYj + i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, this.KYj + i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(this.KYj + i, i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, this.KYj + i, i);
    }
  }
  
  public int getBubbleColor()
  {
    return this.KYn;
  }
  
  public int getBubblePadding()
  {
    return this.KYg;
  }
  
  public int getBubbleRadius()
  {
    return this.KYm;
  }
  
  public a getLook()
  {
    return this.KYf;
  }
  
  public int getLookLength()
  {
    return this.KYj;
  }
  
  public int getLookPosition()
  {
    return this.KYh;
  }
  
  public int getLookWidth()
  {
    return this.KYi;
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public Path getPath()
  {
    return this.xN;
  }
  
  public int getShadowColor()
  {
    return this.mGK;
  }
  
  public int getShadowRadius()
  {
    return this.Sr;
  }
  
  public int getShadowX()
  {
    return this.KYk;
  }
  
  public int getShadowY()
  {
    return this.KYl;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(143549);
    Zd();
    super.invalidate();
    AppMethodBeat.o(143549);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143552);
    super.onDraw(paramCanvas);
    this.mPaint.setPathEffect(new CornerPathEffect(this.KYm));
    paramCanvas.drawPath(this.xN, this.mPaint);
    this.mPaint.setPathEffect(null);
    paramCanvas.drawPath(this.KYe, this.KYd);
    AppMethodBeat.o(143552);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(143557);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.KYh = paramParcelable.getInt("mLookPosition");
      this.KYi = paramParcelable.getInt("mLookWidth");
      this.KYj = paramParcelable.getInt("mLookLength");
      this.mGK = paramParcelable.getInt("mShadowColor");
      this.Sr = paramParcelable.getInt("mShadowRadius");
      this.KYk = paramParcelable.getInt("mShadowX");
      this.KYl = paramParcelable.getInt("mShadowY");
      this.KYm = paramParcelable.getInt("mBubbleRadius");
      this.mWidth = paramParcelable.getInt("mWidth");
      this.mHeight = paramParcelable.getInt("mHeight");
      this.Af = paramParcelable.getInt("mLeft");
      this.Ag = paramParcelable.getInt("mTop");
      this.Ah = paramParcelable.getInt("mRight");
      this.Ai = paramParcelable.getInt("mBottom");
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
    localBundle.putInt("mLookPosition", this.KYh);
    localBundle.putInt("mLookWidth", this.KYi);
    localBundle.putInt("mLookLength", this.KYj);
    localBundle.putInt("mShadowColor", this.mGK);
    localBundle.putInt("mShadowRadius", this.Sr);
    localBundle.putInt("mShadowX", this.KYk);
    localBundle.putInt("mShadowY", this.KYl);
    localBundle.putInt("mBubbleRadius", this.KYm);
    localBundle.putInt("mWidth", this.mWidth);
    localBundle.putInt("mHeight", this.mHeight);
    localBundle.putInt("mLeft", this.Af);
    localBundle.putInt("mTop", this.Ag);
    localBundle.putInt("mRight", this.Ah);
    localBundle.putInt("mBottom", this.Ai);
    AppMethodBeat.o(143556);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143548);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    Zd();
    AppMethodBeat.o(143548);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143553);
    if (paramMotionEvent.getAction() == 0)
    {
      RectF localRectF = new RectF();
      this.xN.computeBounds(localRectF, true);
      this.KYp.setPath(this.xN, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
      if ((!this.KYp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.KYo != null)) {
        this.KYo.fMr();
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143553);
    return bool;
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(143550);
    Zd();
    super.postInvalidate();
    AppMethodBeat.o(143550);
  }
  
  public void setBubbleColor(int paramInt)
  {
    this.KYn = paramInt;
  }
  
  public void setBubbleRadius(int paramInt)
  {
    this.KYm = paramInt;
  }
  
  public void setLook(a parama)
  {
    AppMethodBeat.i(143554);
    this.KYf = parama;
    fMs();
    AppMethodBeat.o(143554);
  }
  
  public void setLookLength(int paramInt)
  {
    AppMethodBeat.i(143555);
    this.KYj = paramInt;
    fMs();
    AppMethodBeat.o(143555);
  }
  
  public void setLookPosition(int paramInt)
  {
    this.KYh = paramInt;
  }
  
  public void setLookWidth(int paramInt)
  {
    this.KYi = paramInt;
  }
  
  public void setOnClickEdgeListener(b paramb)
  {
    this.KYo = paramb;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.mGK = paramInt;
  }
  
  public void setShadowRadius(int paramInt)
  {
    this.Sr = paramInt;
  }
  
  public void setShadowX(int paramInt)
  {
    this.KYk = paramInt;
  }
  
  public void setShadowY(int paramInt)
  {
    this.KYl = paramInt;
  }
  
  public static enum a
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143545);
      KYr = new a("LEFT", 0, 1);
      KYs = new a("TOP", 1, 2);
      KYt = new a("RIGHT", 2, 3);
      KYu = new a("BOTTOM", 3, 4);
      KYv = new a[] { KYr, KYs, KYt, KYu };
      AppMethodBeat.o(143545);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a afu(int paramInt)
    {
      a locala = KYu;
      switch (paramInt)
      {
      default: 
        return locala;
      case 1: 
        return KYr;
      case 2: 
        return KYs;
      case 3: 
        return KYt;
      }
      return KYu;
    }
  }
  
  public static abstract interface b
  {
    public abstract void fMr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */