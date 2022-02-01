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
  private int Af;
  private int Ag;
  private int Ah;
  private int Ai;
  private Paint LuB;
  private Path LuC;
  private a LuD;
  private int LuE;
  private int LuF;
  private int LuG;
  private int LuH;
  private int LuI;
  private int LuJ;
  private int LuK;
  private int LuL;
  private b LuM;
  private Region LuN;
  private int Sr;
  private int mHeight;
  private int mLO;
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
    this.LuN = new Region();
    setLayerType(1, null);
    setWillNotDraw(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.BubbleLayout, paramInt, 0);
    this.LuD = a.agd(paramContext.getInt(3, a.LuS.value));
    this.LuF = paramContext.getDimensionPixelOffset(5, 0);
    this.LuG = paramContext.getDimensionPixelOffset(6, a.h(getContext(), 17.0F));
    this.LuH = paramContext.getDimensionPixelOffset(4, a.h(getContext(), 17.0F));
    this.Sr = paramContext.getDimensionPixelOffset(8, a.h(getContext(), 3.3F));
    this.LuI = paramContext.getDimensionPixelOffset(9, a.h(getContext(), 1.0F));
    this.LuJ = paramContext.getDimensionPixelOffset(10, a.h(getContext(), 1.0F));
    this.LuK = paramContext.getDimensionPixelOffset(2, a.h(getContext(), 7.0F));
    this.LuE = paramContext.getDimensionPixelOffset(1, a.h(getContext(), 8.0F));
    this.mLO = paramContext.getColor(7, -7829368);
    this.LuL = paramContext.getColor(0, -1);
    paramContext.recycle();
    this.mPaint = new Paint(5);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.LuB = new Paint(5);
    this.LuB.setStyle(Paint.Style.FILL);
    this.xN = new Path();
    this.LuC = new Path();
    fQM();
    AppMethodBeat.o(143546);
  }
  
  private void Zm()
  {
    int j = 0;
    AppMethodBeat.i(143551);
    this.mPaint.setPathEffect(new CornerPathEffect(this.LuK));
    this.mPaint.setShadowLayer(this.Sr, this.LuI, this.LuJ, this.mLO);
    int k = this.LuE;
    int i;
    if (this.LuD == a.LuP)
    {
      i = this.LuH;
      this.Af = (i + k);
      k = this.LuE;
      if (this.LuD != a.LuQ) {
        break label361;
      }
      i = this.LuH;
      label100:
      this.Ag = (i + k);
      k = this.mWidth;
      int m = this.LuE;
      if (this.LuD != a.LuR) {
        break label366;
      }
      i = this.LuH;
      label133:
      this.Ah = (k - m - i);
      k = this.mHeight;
      m = this.LuE;
      i = j;
      if (this.LuD == a.LuS) {
        i = this.LuH;
      }
      this.Ai = (k - m - i);
      this.mPaint.setColor(this.LuL);
      this.LuB.setColor(this.LuL);
      this.xN.reset();
      this.LuC.reset();
      j = this.LuF;
      i = j;
      if (this.LuH + j > this.Ai) {
        i = this.Ai - this.LuG;
      }
      if (i <= this.LuE) {
        break label371;
      }
      j = i;
      label257:
      k = this.LuF;
      i = k;
      if (this.LuH + k > this.Ah) {
        i = this.Ah - this.LuG;
      }
      if (i <= this.LuE) {
        break label379;
      }
      label295:
      switch (1.LuO[this.LuD.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.xN.close();
      this.LuC.close();
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
      j = this.LuE;
      break label257;
      label379:
      i = this.LuE;
      break label295;
      this.xN.moveTo(this.Af, j);
      this.LuC.moveTo(this.Af, j);
      this.LuC.rLineTo(-this.LuH, this.LuG / 2);
      this.LuC.rLineTo(this.LuH, this.LuG / 2);
      this.LuC.lineTo(this.Af, j);
      this.xN.lineTo(this.Af, this.Ai);
      this.xN.lineTo(this.Ah, this.Ai);
      this.xN.lineTo(this.Ah, this.Ag);
      this.xN.lineTo(this.Af, this.Ag);
      continue;
      this.xN.moveTo(i, this.Ag);
      this.LuC.moveTo(i, this.Ag);
      this.LuC.rLineTo(this.LuG / 2, -this.LuH);
      this.LuC.rLineTo(this.LuG / 2, this.LuH);
      this.LuC.lineTo(i, this.Ag);
      this.xN.lineTo(this.Ah, this.Ag);
      this.xN.lineTo(this.Ah, this.Ai);
      this.xN.lineTo(this.Af, this.Ai);
      this.xN.lineTo(this.Af, this.Ag);
      continue;
      this.xN.moveTo(this.Ah, j);
      this.LuC.moveTo(this.Ah, j);
      this.LuC.rLineTo(this.LuH, this.LuG / 2);
      this.LuC.rLineTo(-this.LuH, this.LuG / 2);
      this.LuC.lineTo(this.Ah, j);
      this.xN.lineTo(this.Ah, this.Ai);
      this.xN.lineTo(this.Af, this.Ai);
      this.xN.lineTo(this.Af, this.Ag);
      this.xN.lineTo(this.Ah, this.Ag);
      continue;
      this.xN.moveTo(i, this.Ai);
      this.LuC.moveTo(i, this.Ai);
      this.LuC.rLineTo(this.LuG / 2, this.LuH);
      this.LuC.rLineTo(this.LuG / 2, -this.LuH);
      this.LuC.lineTo(i, this.Ai);
      this.xN.lineTo(this.Ah, this.Ai);
      this.xN.lineTo(this.Ah, this.Ag);
      this.xN.lineTo(this.Af, this.Ag);
      this.xN.lineTo(this.Af, this.Ai);
    }
  }
  
  public final void fQM()
  {
    AppMethodBeat.i(143547);
    int i = this.LuE * 2;
    switch (1.LuO[this.LuD.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, i, this.LuH + i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, this.LuH + i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(this.LuH + i, i, i, i);
      AppMethodBeat.o(143547);
      return;
      setPadding(i, i, this.LuH + i, i);
    }
  }
  
  public int getBubbleColor()
  {
    return this.LuL;
  }
  
  public int getBubblePadding()
  {
    return this.LuE;
  }
  
  public int getBubbleRadius()
  {
    return this.LuK;
  }
  
  public a getLook()
  {
    return this.LuD;
  }
  
  public int getLookLength()
  {
    return this.LuH;
  }
  
  public int getLookPosition()
  {
    return this.LuF;
  }
  
  public int getLookWidth()
  {
    return this.LuG;
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
    return this.mLO;
  }
  
  public int getShadowRadius()
  {
    return this.Sr;
  }
  
  public int getShadowX()
  {
    return this.LuI;
  }
  
  public int getShadowY()
  {
    return this.LuJ;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(143549);
    Zm();
    super.invalidate();
    AppMethodBeat.o(143549);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143552);
    super.onDraw(paramCanvas);
    this.mPaint.setPathEffect(new CornerPathEffect(this.LuK));
    paramCanvas.drawPath(this.xN, this.mPaint);
    this.mPaint.setPathEffect(null);
    paramCanvas.drawPath(this.LuC, this.LuB);
    AppMethodBeat.o(143552);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(143557);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.LuF = paramParcelable.getInt("mLookPosition");
      this.LuG = paramParcelable.getInt("mLookWidth");
      this.LuH = paramParcelable.getInt("mLookLength");
      this.mLO = paramParcelable.getInt("mShadowColor");
      this.Sr = paramParcelable.getInt("mShadowRadius");
      this.LuI = paramParcelable.getInt("mShadowX");
      this.LuJ = paramParcelable.getInt("mShadowY");
      this.LuK = paramParcelable.getInt("mBubbleRadius");
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
    localBundle.putInt("mLookPosition", this.LuF);
    localBundle.putInt("mLookWidth", this.LuG);
    localBundle.putInt("mLookLength", this.LuH);
    localBundle.putInt("mShadowColor", this.mLO);
    localBundle.putInt("mShadowRadius", this.Sr);
    localBundle.putInt("mShadowX", this.LuI);
    localBundle.putInt("mShadowY", this.LuJ);
    localBundle.putInt("mBubbleRadius", this.LuK);
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
    Zm();
    AppMethodBeat.o(143548);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143553);
    if (paramMotionEvent.getAction() == 0)
    {
      RectF localRectF = new RectF();
      this.xN.computeBounds(localRectF, true);
      this.LuN.setPath(this.xN, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
      if ((!this.LuN.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.LuM != null)) {
        this.LuM.fQL();
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143553);
    return bool;
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(143550);
    Zm();
    super.postInvalidate();
    AppMethodBeat.o(143550);
  }
  
  public void setBubbleColor(int paramInt)
  {
    this.LuL = paramInt;
  }
  
  public void setBubbleRadius(int paramInt)
  {
    this.LuK = paramInt;
  }
  
  public void setLook(a parama)
  {
    AppMethodBeat.i(143554);
    this.LuD = parama;
    fQM();
    AppMethodBeat.o(143554);
  }
  
  public void setLookLength(int paramInt)
  {
    AppMethodBeat.i(143555);
    this.LuH = paramInt;
    fQM();
    AppMethodBeat.o(143555);
  }
  
  public void setLookPosition(int paramInt)
  {
    this.LuF = paramInt;
  }
  
  public void setLookWidth(int paramInt)
  {
    this.LuG = paramInt;
  }
  
  public void setOnClickEdgeListener(b paramb)
  {
    this.LuM = paramb;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.mLO = paramInt;
  }
  
  public void setShadowRadius(int paramInt)
  {
    this.Sr = paramInt;
  }
  
  public void setShadowX(int paramInt)
  {
    this.LuI = paramInt;
  }
  
  public void setShadowY(int paramInt)
  {
    this.LuJ = paramInt;
  }
  
  public static enum a
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143545);
      LuP = new a("LEFT", 0, 1);
      LuQ = new a("TOP", 1, 2);
      LuR = new a("RIGHT", 2, 3);
      LuS = new a("BOTTOM", 3, 4);
      LuT = new a[] { LuP, LuQ, LuR, LuS };
      AppMethodBeat.o(143545);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a agd(int paramInt)
    {
      a locala = LuS;
      switch (paramInt)
      {
      default: 
        return locala;
      case 1: 
        return LuP;
      case 2: 
        return LuQ;
      case 3: 
        return LuR;
      }
      return LuS;
    }
  }
  
  public static abstract interface b
  {
    public abstract void fQL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */