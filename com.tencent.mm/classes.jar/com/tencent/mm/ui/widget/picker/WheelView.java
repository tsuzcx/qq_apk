package com.tencent.mm.ui.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.a.a;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.widget.picker.a.e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView
  extends View
{
  private int Is;
  private boolean JjY;
  public com.tencent.mm.ui.widget.picker.d.c Jkc;
  private e<?> Jkd;
  private boolean Jke;
  private int MW;
  private Paint bLZ;
  String content;
  public boolean hYH;
  private Handler handler;
  private GestureDetector irA;
  private boolean irC;
  public boolean irD;
  public ScheduledExecutorService irE;
  public ScheduledFuture<?> irF;
  private Paint irG;
  private int irI;
  private float irJ;
  private int irK;
  private float irL;
  private float irM;
  private float irN;
  private int irO;
  private int irP;
  private int irQ;
  private int irR;
  private int irS;
  private int irT;
  private float irU;
  private int irV;
  private int irW;
  private int irx;
  private int iry;
  private final int irz;
  private String label;
  private Context mContext;
  private Rect rect;
  private long startTime;
  private int textColor;
  private int textSize;
  
  public WheelView(Context paramContext)
  {
    this(paramContext, null);
    this.mContext = paramContext;
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199797);
    this.irx = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.irz = 2;
    this.content = "";
    this.irC = false;
    this.irD = true;
    this.irE = Executors.newSingleThreadScheduledExecutor();
    this.irR = 5;
    this.MW = 0;
    this.irU = 0.0F;
    this.startTime = 0L;
    this.Is = 17;
    this.irW = 0;
    this.rect = new Rect();
    this.mContext = paramContext;
    this.textSize = getResources().getDimensionPixelSize(2131166686);
    this.irI = getResources().getDimensionPixelSize(2131166685);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WheelView, 0, 0);
      this.Is = paramAttributeSet.getInt(1, 17);
      this.irK = paramAttributeSet.getColor(0, -2763307);
      paramAttributeSet.recycle();
    }
    this.handler = new com.tencent.mm.ui.widget.picker.e.b(this);
    this.irA = new GestureDetector(paramContext, new com.tencent.mm.ui.widget.picker.d.b(this));
    this.irA.setIsLongpressEnabled(false);
    this.hYH = true;
    this.irN = 0.0F;
    this.irO = -1;
    this.bLZ = new Paint();
    this.bLZ.setColor(this.textColor);
    this.bLZ.setAntiAlias(true);
    this.bLZ.setTextSize(this.textSize);
    this.irG = new Paint();
    this.irG.setColor(this.irK);
    this.irG.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(199797);
  }
  
  private void aME()
  {
    AppMethodBeat.i(199798);
    if (this.Jkd == null)
    {
      AppMethodBeat.o(199798);
      return;
    }
    this.irJ = (this.irx + getPaddingBottom() + getPaddingTop());
    this.irS = ((int)(this.irJ * this.irR));
    this.irT = View.MeasureSpec.getSize(this.irV);
    this.irL = ((this.irS - this.irJ) / 2.0F);
    this.irM = ((this.irS + this.irJ) / 2.0F);
    if (this.irO == -1) {
      if (!this.hYH) {
        break label141;
      }
    }
    label141:
    for (this.irO = ((this.Jkd.getItemsCount() + 1) / 2);; this.irO = 0)
    {
      this.irQ = this.irO;
      AppMethodBeat.o(199798);
      return;
    }
  }
  
  private void aMG()
  {
    AppMethodBeat.i(199809);
    Rect localRect = new Rect();
    this.bLZ.getTextBounds(this.content, 0, this.content.length(), localRect);
    localRect = new Rect();
    this.bLZ.getTextBounds(this.content, 0, 0, localRect);
    int j = this.content.length();
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j - i <= 1) {
        break;
      }
      localRect = new Rect();
      k = (j - i >> 1) + i;
      this.bLZ.getTextBounds(this.content, 0, k, localRect);
      if (localRect.width() >= aMH()) {
        j = k - 1;
      } else if (localRect.width() < aMH()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.bLZ.measureText(this.content + "...") <= aMH()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(199809);
  }
  
  private int aMH()
  {
    AppMethodBeat.i(199810);
    int i = this.irT;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(199810);
    return i - j - k;
  }
  
  private void aMI()
  {
    AppMethodBeat.i(199811);
    int i = this.textSize;
    this.bLZ.setTextSize(i);
    while ((i > this.irI) && (!aMJ()))
    {
      i -= 1;
      this.bLZ.setTextSize(i);
    }
    AppMethodBeat.o(199811);
  }
  
  private boolean aMJ()
  {
    AppMethodBeat.i(199812);
    if (this.bLZ.measureText(this.content) <= this.irT - getPaddingLeft() - getPaddingRight())
    {
      AppMethodBeat.o(199812);
      return true;
    }
    AppMethodBeat.o(199812);
    return false;
  }
  
  private static String bZ(Object paramObject)
  {
    AppMethodBeat.i(199808);
    if (paramObject == null)
    {
      AppMethodBeat.o(199808);
      return "";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(199808);
    return paramObject;
  }
  
  private String qn(int paramInt)
  {
    AppMethodBeat.i(199806);
    int i = paramInt;
    if (this.hYH) {
      i = qo(paramInt);
    }
    String str = this.Jkd.qk(i);
    AppMethodBeat.o(199806);
    return str;
  }
  
  private int qo(int paramInt)
  {
    AppMethodBeat.i(199807);
    int i;
    if (paramInt < 0) {
      i = qo(this.Jkd.getItemsCount() + paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(199807);
      return i;
      i = paramInt;
      if (paramInt > this.Jkd.getItemsCount() - 1) {
        i = qo(paramInt - this.Jkd.getItemsCount());
      }
    }
  }
  
  public final void a(WheelView.a parama)
  {
    AppMethodBeat.i(199799);
    aMF();
    if ((parama == WheelView.a.Jkh) || (parama == WheelView.a.Jki))
    {
      this.MW = ((int)((this.irN % this.irJ + this.irJ) % this.irJ));
      if (this.MW <= this.irJ / 2.0F) {
        break label117;
      }
    }
    label117:
    for (this.MW = ((int)(this.irJ - this.MW));; this.MW = (-this.MW))
    {
      this.irF = this.irE.scheduleWithFixedDelay(new com.tencent.mm.ui.widget.picker.e.c(this, this.MW), 0L, 10L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(199799);
      return;
    }
  }
  
  public final void aMF()
  {
    AppMethodBeat.i(199800);
    if ((this.irF != null) && (!this.irF.isCancelled()))
    {
      this.irF.cancel(true);
      this.irF = null;
    }
    AppMethodBeat.o(199800);
  }
  
  public final WheelView adf(int paramInt)
  {
    AppMethodBeat.i(199818);
    this.irx = paramInt;
    invalidate();
    AppMethodBeat.o(199818);
    return this;
  }
  
  public final WheelView adg(int paramInt)
  {
    AppMethodBeat.i(199819);
    this.textColor = paramInt;
    this.bLZ.setColor(this.textColor);
    this.iry = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(199819);
    return this;
  }
  
  public final void fwc()
  {
    AppMethodBeat.i(199804);
    String str = bZ(qn(getCurrentItem()));
    if (!TextUtils.isEmpty(str)) {
      setContentDescription(str);
    }
    AppMethodBeat.o(199804);
  }
  
  public final e getAdapter()
  {
    return this.Jkd;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(199803);
    if (this.Jkd == null)
    {
      AppMethodBeat.o(199803);
      return 0;
    }
    if ((this.JjY) && (this.irP == 0))
    {
      AppMethodBeat.o(199803);
      return -1;
    }
    if ((this.hYH) && ((this.irP < 0) || (this.irP >= this.Jkd.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.irP) - this.Jkd.getItemsCount()), this.Jkd.getItemsCount() - 1));
      AppMethodBeat.o(199803);
      return i;
    }
    int i = Math.max(0, Math.min(this.irP, this.Jkd.getItemsCount() - 1));
    AppMethodBeat.o(199803);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.irO;
  }
  
  public float getItemHeight()
  {
    return this.irJ;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(199815);
    if (this.Jkd != null)
    {
      int i = this.Jkd.getItemsCount();
      AppMethodBeat.o(199815);
      return i;
    }
    AppMethodBeat.o(199815);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.irN;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(199805);
    super.onDraw(paramCanvas);
    if (this.Jkd == null)
    {
      AppMethodBeat.o(199805);
      return;
    }
    this.irO = Math.min(Math.max(0, this.irO), this.Jkd.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.irR];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.irN / this.irJ);
    label1070:
    label1073:
    for (;;)
    {
      try
      {
        j = this.irO;
        this.irQ = (i % this.Jkd.getItemsCount() + j);
        if (!this.hYH)
        {
          if (this.irQ < 0) {
            this.irQ = 0;
          }
          if (this.irQ > this.Jkd.getItemsCount() - 1) {
            this.irQ = (this.Jkd.getItemsCount() - 1);
          }
          f1 = this.irN;
          f2 = this.irJ;
          i = 0;
          if (i >= this.irR) {
            continue;
          }
          j = this.irQ - (this.irR / 2 - i);
          if (i != 0) {
            break label1073;
          }
          localObject2 = qn(j - 1);
          if (i != this.irR - 1) {
            break label1070;
          }
          localObject1 = qn(j + 1);
          arrayOfObject[i] = qn(j);
          i += 1;
          continue;
        }
      }
      catch (ArithmeticException localArithmeticException)
      {
        float f1;
        float f2;
        an.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配", new Object[0]);
        continue;
        if (this.irQ < 0) {
          this.irQ = (this.Jkd.getItemsCount() + this.irQ);
        }
        if (this.irQ <= this.Jkd.getItemsCount() - 1) {
          continue;
        }
        this.irQ -= this.Jkd.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.irL, this.irT, this.irL, this.irG);
        paramCanvas.drawLine(0.0F, this.irM, this.irT, this.irM, this.irG);
        int j = 0;
        if (j < this.irR + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.irJ * j - f1 % f2 + this.irJ / 2.0F - this.irJ;
            if ((this.irD) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(bZ(localObject3))) || ((this.JjY) && (localObject3.equals(this.mContext.getString(2131766375))))) {
              continue;
            }
            this.content = (bZ(localObject3) + this.label);
            this.bLZ.getTextBounds(this.content, 0, this.content.length(), this.rect);
          }
          int k;
          switch (this.Is)
          {
          default: 
            float f4 = this.irS / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.iry);
            if (k < this.iry * 0.14F)
            {
              i = (int)(this.iry * 0.14F);
              this.bLZ.setAlpha(i);
              if ((f3 >= this.irL) && (f3 <= this.irM)) {
                this.irP = (this.irQ - (this.irR / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.irS))
              {
                localObject3 = this.content;
                f4 = this.irW;
                Paint.FontMetricsInt localFontMetricsInt = this.bLZ.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.bLZ);
              }
              j += 1;
              this.bLZ.setTextSize(this.textSize);
              continue;
              if (j == this.irR + 2 - 1)
              {
                localObject3 = localObject1;
                continue;
              }
              localObject3 = arrayOfObject[(j - 1)];
              continue;
              this.content = bZ(localObject3);
            }
            break;
          case 17: 
            if ((this.irC) || (this.label == null) || (this.label.equals("")) || (!this.irD))
            {
              if (this.irT < this.rect.width())
              {
                aMI();
                if (!aMJ()) {
                  aMG();
                }
                this.bLZ.getTextBounds(this.content, 0, this.content.length(), this.rect);
                this.irW = ((int)((this.irT - this.rect.width()) * 0.5D));
                continue;
              }
              this.irW = ((int)((this.irT - this.rect.width()) * 0.5D));
              continue;
            }
            this.irW = ((int)((this.irT - this.rect.width()) * 0.25D));
            break;
          case 3: 
            this.irW = 0;
            break;
          case 5: 
            this.irW = (this.irT - this.rect.width());
            continue;
            i = k;
            if (k <= this.iry) {
              continue;
            }
            i = this.iry;
            break;
          }
        }
        AppMethodBeat.o(199805);
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199813);
    this.irV = paramInt1;
    aME();
    setMeasuredDimension(this.irT, this.irS);
    AppMethodBeat.o(199813);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199814);
    boolean bool = this.irA.onTouchEvent(paramMotionEvent);
    float f1 = -this.irO;
    float f2 = this.irJ;
    float f3 = this.Jkd.getItemsCount() - 1 - this.irO;
    float f4 = this.irJ;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label348;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(WheelView.a.Jki);
        i = 0;
      }
      break;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((i == 0) && (paramMotionEvent.getAction() != 0)) {
          invalidate();
        }
        AppMethodBeat.o(199814);
        return true;
        this.startTime = System.currentTimeMillis();
        aMF();
        this.irU = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.irU - paramMotionEvent.getRawY();
        this.irU = paramMotionEvent.getRawY();
        this.irN += f5;
        if (this.hYH) {
          break;
        }
        if (((this.irN - this.irJ * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.irN + this.irJ * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.irN -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.irS / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.irJ / 2.0F);; i = (int)(i - this.irJ / 2.0F))
    {
      if (this.irJ != 0.0F)
      {
        this.MW = ((int)((int)(i / this.irJ) * this.irJ));
        a(WheelView.a.Jkg);
      }
      label348:
      i = 0;
      break;
    }
  }
  
  public final void setAdapter(e<?> parame)
  {
    AppMethodBeat.i(199802);
    this.Jkd = parame;
    aME();
    invalidate();
    AppMethodBeat.o(199802);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(199801);
    this.irP = paramInt;
    this.irO = paramInt;
    this.irN = 0.0F;
    fwc();
    invalidate();
    AppMethodBeat.o(199801);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.hYH = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(199816);
    if (paramInt != 0)
    {
      this.irK = paramInt;
      this.irG.setColor(this.irK);
    }
    AppMethodBeat.o(199816);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(199817);
    this.irG.setStrokeWidth(paramFloat);
    AppMethodBeat.o(199817);
  }
  
  public void setGravity(int paramInt)
  {
    this.Is = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.irC = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setLongTermMonthDay(boolean paramBoolean)
  {
    this.Jke = paramBoolean;
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.JjY = paramBoolean;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.ui.widget.picker.d.c paramc)
  {
    this.Jkc = paramc;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.irN = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.WheelView
 * JD-Core Version:    0.7.0.1
 */