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
import com.tencent.mm.cd.a;

public class BubbleLayout
  extends FrameLayout
{
  private Paint aghh;
  private Path aghi;
  private a aghj;
  private int aghk;
  private int aghl;
  private int aghm;
  private int aghn;
  private int agho;
  private int aghp;
  private int aghq;
  private int aghr;
  private b aghs;
  private Region aght;
  private int ccL;
  private int cey;
  private int cez;
  private Path cja;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int uE;
  private int uF;
  private int ugx;
  
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
    this.aght = new Region();
    setLayerType(1, null);
    setWillNotDraw(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.BubbleLayout, paramInt, 0);
    this.aghj = a.aFg(paramContext.getInt(a.m.BubbleLayout_lookAt, a.aghy.value));
    this.aghl = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_lookPosition, 0);
    this.aghm = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_lookWidth, a.fromDPToPix(getContext(), 17.0F));
    this.aghn = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_lookLength, a.fromDPToPix(getContext(), 17.0F));
    this.ccL = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_shadowRadius, a.fromDPToPix(getContext(), 3.3F));
    this.agho = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_shadowX, a.fromDPToPix(getContext(), 1.0F));
    this.aghp = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_shadowY, a.fromDPToPix(getContext(), 1.0F));
    this.aghq = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_bubbleRadius, a.fromDPToPix(getContext(), 7.0F));
    this.aghk = paramContext.getDimensionPixelOffset(a.m.BubbleLayout_bubblePadding, a.fromDPToPix(getContext(), 8.0F));
    this.ugx = paramContext.getColor(a.m.BubbleLayout_shadowColor, -7829368);
    this.aghr = paramContext.getColor(a.m.BubbleLayout_bubbleColor, -1);
    paramContext.recycle();
    this.mPaint = new Paint(5);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.aghh = new Paint(5);
    this.aghh.setStyle(Paint.Style.FILL);
    this.cja = new Path();
    this.aghi = new Path();
    jIe();
    AppMethodBeat.o(143546);
  }
  
  private void aNi()
  {
    int j = 0;
    AppMethodBeat.i(143551);
    this.mPaint.setPathEffect(new CornerPathEffect(this.aghq));
    this.mPaint.setShadowLayer(this.ccL, this.agho, this.aghp, this.ugx);
    int k = this.aghk;
    int i;
    if (this.aghj == a.aghv)
    {
      i = this.aghn;
      this.uE = (i + k);
      k = this.aghk;
      if (this.aghj != a.aghw) {
        break label361;
      }
      i = this.aghn;
      label100:
      this.cey = (i + k);
      k = this.mWidth;
      int m = this.aghk;
      if (this.aghj != a.aghx) {
        break label366;
      }
      i = this.aghn;
      label133:
      this.uF = (k - m - i);
      k = this.mHeight;
      m = this.aghk;
      i = j;
      if (this.aghj == a.aghy) {
        i = this.aghn;
      }
      this.cez = (k - m - i);
      this.mPaint.setColor(this.aghr);
      this.aghh.setColor(this.aghr);
      this.cja.reset();
      this.aghi.reset();
      j = this.aghl;
      i = j;
      if (this.aghn + j > this.cez) {
        i = this.cez - this.aghm;
      }
      if (i <= this.aghk) {
        break label371;
      }
      j = i;
      label257:
      k = this.aghl;
      i = k;
      if (this.aghn + k > this.uF) {
        i = this.uF - this.aghm;
      }
      if (i <= this.aghk) {
        break label379;
      }
      label295:
      switch (1.aghu[this.aghj.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.cja.close();
      this.aghi.close();
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
      j = this.aghk;
      break label257;
      label379:
      i = this.aghk;
      break label295;
      this.cja.moveTo(this.uE, j);
      this.aghi.moveTo(this.uE, j);
      this.aghi.rLineTo(-this.aghn, this.aghm / 2);
      this.aghi.rLineTo(this.aghn, this.aghm / 2);
      this.aghi.lineTo(this.uE, j);
      this.cja.lineTo(this.uE, this.cez);
      this.cja.lineTo(this.uF, this.cez);
      this.cja.lineTo(this.uF, this.cey);
      this.cja.lineTo(this.uE, this.cey);
      continue;
      this.cja.moveTo(i, this.cey);
      this.aghi.moveTo(i, this.cey);
      this.aghi.rLineTo(this.aghm / 2, -this.aghn);
      this.aghi.rLineTo(this.aghm / 2, this.aghn);
      this.aghi.lineTo(i, this.cey);
      this.cja.lineTo(this.uF, this.cey);
      this.cja.lineTo(this.uF, this.cez);
      this.cja.lineTo(this.uE, this.cez);
      this.cja.lineTo(this.uE, this.cey);
      continue;
      this.cja.moveTo(this.uF, j);
      this.aghi.moveTo(this.uF, j);
      this.aghi.rLineTo(this.aghn, this.aghm / 2);
      this.aghi.rLineTo(-this.aghn, this.aghm / 2);
      this.aghi.lineTo(this.uF, j);
      this.cja.lineTo(this.uF, this.cez);
      this.cja.lineTo(this.uE, this.cez);
      this.cja.lineTo(this.uE, this.cey);
      this.cja.lineTo(this.uF, this.cey);
      continue;
      this.cja.moveTo(i, this.cez);
      this.aghi.moveTo(i, this.cez);
      this.aghi.rLineTo(this.aghm / 2, this.aghn);
      this.aghi.rLineTo(this.aghm / 2, -this.aghn);
      this.aghi.lineTo(i, this.cez);
      this.cja.lineTo(this.uF, this.cez);
      this.cja.lineTo(this.uF, this.cey);
      this.cja.lineTo(this.uE, this.cey);
      this.cja.lineTo(this.uE, this.cez);
    }
  }
  
  public int getBubbleColor()
  {
    return this.aghr;
  }
  
  public int getBubblePadding()
  {
    return this.aghk;
  }
  
  public int getBubbleRadius()
  {
    return this.aghq;
  }
  
  public a getLook()
  {
    return this.aghj;
  }
  
  public int getLookLength()
  {
    return this.aghn;
  }
  
  public int getLookPosition()
  {
    return this.aghl;
  }
  
  public int getLookWidth()
  {
    return this.aghm;
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public Path getPath()
  {
    return this.cja;
  }
  
  public int getShadowColor()
  {
    return this.ugx;
  }
  
  public int getShadowRadius()
  {
    return this.ccL;
  }
  
  public int getShadowX()
  {
    return this.agho;
  }
  
  public int getShadowY()
  {
    return this.aghp;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(143549);
    aNi();
    super.invalidate();
    AppMethodBeat.o(143549);
  }
  
  public final void jIe()
  {
    AppMethodBeat.i(143547);
    int i = this.aghk * 2;
    switch (1.aghu[this.aghj.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, i, this.aghn + i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, this.aghn + i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(this.aghn + i, i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, this.aghn + i, i);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143552);
    super.onDraw(paramCanvas);
    this.mPaint.setPathEffect(new CornerPathEffect(this.aghq));
    paramCanvas.drawPath(this.cja, this.mPaint);
    this.mPaint.setPathEffect(null);
    paramCanvas.drawPath(this.aghi, this.aghh);
    AppMethodBeat.o(143552);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(143557);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.aghl = paramParcelable.getInt("mLookPosition");
      this.aghm = paramParcelable.getInt("mLookWidth");
      this.aghn = paramParcelable.getInt("mLookLength");
      this.ugx = paramParcelable.getInt("mShadowColor");
      this.ccL = paramParcelable.getInt("mShadowRadius");
      this.agho = paramParcelable.getInt("mShadowX");
      this.aghp = paramParcelable.getInt("mShadowY");
      this.aghq = paramParcelable.getInt("mBubbleRadius");
      this.mWidth = paramParcelable.getInt("mWidth");
      this.mHeight = paramParcelable.getInt("mHeight");
      this.uE = paramParcelable.getInt("mLeft");
      this.cey = paramParcelable.getInt("mTop");
      this.uF = paramParcelable.getInt("mRight");
      this.cez = paramParcelable.getInt("mBottom");
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
    localBundle.putInt("mLookPosition", this.aghl);
    localBundle.putInt("mLookWidth", this.aghm);
    localBundle.putInt("mLookLength", this.aghn);
    localBundle.putInt("mShadowColor", this.ugx);
    localBundle.putInt("mShadowRadius", this.ccL);
    localBundle.putInt("mShadowX", this.agho);
    localBundle.putInt("mShadowY", this.aghp);
    localBundle.putInt("mBubbleRadius", this.aghq);
    localBundle.putInt("mWidth", this.mWidth);
    localBundle.putInt("mHeight", this.mHeight);
    localBundle.putInt("mLeft", this.uE);
    localBundle.putInt("mTop", this.cey);
    localBundle.putInt("mRight", this.uF);
    localBundle.putInt("mBottom", this.cez);
    AppMethodBeat.o(143556);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143548);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    aNi();
    AppMethodBeat.o(143548);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143553);
    if (paramMotionEvent.getAction() == 0)
    {
      RectF localRectF = new RectF();
      this.cja.computeBounds(localRectF, true);
      this.aght.setPath(this.cja, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
      if ((!this.aght.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.aghs != null)) {
        this.aghs.jId();
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143553);
    return bool;
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(143550);
    aNi();
    super.postInvalidate();
    AppMethodBeat.o(143550);
  }
  
  public void setBubbleColor(int paramInt)
  {
    this.aghr = paramInt;
  }
  
  public void setBubbleRadius(int paramInt)
  {
    this.aghq = paramInt;
  }
  
  public void setLook(a parama)
  {
    AppMethodBeat.i(143554);
    this.aghj = parama;
    jIe();
    AppMethodBeat.o(143554);
  }
  
  public void setLookLength(int paramInt)
  {
    AppMethodBeat.i(143555);
    this.aghn = paramInt;
    jIe();
    AppMethodBeat.o(143555);
  }
  
  public void setLookPosition(int paramInt)
  {
    this.aghl = paramInt;
  }
  
  public void setLookWidth(int paramInt)
  {
    this.aghm = paramInt;
  }
  
  public void setOnClickEdgeListener(b paramb)
  {
    this.aghs = paramb;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.ugx = paramInt;
  }
  
  public void setShadowRadius(int paramInt)
  {
    this.ccL = paramInt;
  }
  
  public void setShadowX(int paramInt)
  {
    this.agho = paramInt;
  }
  
  public void setShadowY(int paramInt)
  {
    this.aghp = paramInt;
  }
  
  public static enum a
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143545);
      aghv = new a("LEFT", 0, 1);
      aghw = new a("TOP", 1, 2);
      aghx = new a("RIGHT", 2, 3);
      aghy = new a("BOTTOM", 3, 4);
      aghz = new a[] { aghv, aghw, aghx, aghy };
      AppMethodBeat.o(143545);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a aFg(int paramInt)
    {
      a locala = aghy;
      switch (paramInt)
      {
      default: 
        return locala;
      case 1: 
        return aghv;
      case 2: 
        return aghw;
      case 3: 
        return aghx;
      }
      return aghy;
    }
  }
  
  public static abstract interface b
  {
    public abstract void jId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */