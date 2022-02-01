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
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.picker.a.e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView
  extends View
{
  private int Kk;
  private boolean LxW;
  public com.tencent.mm.ui.widget.picker.d.c Lya;
  private e<?> Lyb;
  private boolean Lyc;
  private Paint bWm;
  String content;
  private int fq;
  private Handler handler;
  public ScheduledExecutorService iNA;
  public ScheduledFuture<?> iNB;
  private Paint iNC;
  private int iNE;
  private float iNF;
  private int iNG;
  private float iNH;
  private float iNI;
  private float iNJ;
  private int iNK;
  private int iNL;
  private int iNM;
  private int iNN;
  private int iNO;
  private int iNP;
  private float iNQ;
  private int iNR;
  private int iNS;
  private int iNt;
  private int iNu;
  private final int iNv;
  private GestureDetector iNw;
  private boolean iNy;
  public boolean iNz;
  public boolean iuX;
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
    AppMethodBeat.i(200516);
    this.iNt = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.iNv = 2;
    this.content = "";
    this.iNy = false;
    this.iNz = true;
    this.iNA = Executors.newSingleThreadScheduledExecutor();
    this.iNN = 5;
    this.fq = 0;
    this.iNQ = 0.0F;
    this.startTime = 0L;
    this.Kk = 17;
    this.iNS = 0;
    this.rect = new Rect();
    this.mContext = paramContext;
    this.textSize = getResources().getDimensionPixelSize(2131166686);
    this.iNE = getResources().getDimensionPixelSize(2131166685);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WheelView, 0, 0);
      this.Kk = paramAttributeSet.getInt(1, 17);
      this.iNG = paramAttributeSet.getColor(0, -2763307);
      paramAttributeSet.recycle();
    }
    this.handler = new com.tencent.mm.ui.widget.picker.e.b(this);
    this.iNw = new GestureDetector(paramContext, new com.tencent.mm.ui.widget.picker.d.b(this));
    this.iNw.setIsLongpressEnabled(false);
    this.iuX = true;
    this.iNJ = 0.0F;
    this.iNK = -1;
    this.bWm = new Paint();
    this.bWm.setColor(this.textColor);
    this.bWm.setAntiAlias(true);
    this.bWm.setTextSize(this.textSize);
    this.iNC = new Paint();
    this.iNC.setColor(this.iNG);
    this.iNC.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(200516);
  }
  
  private void aQo()
  {
    AppMethodBeat.i(200517);
    if (this.Lyb == null)
    {
      AppMethodBeat.o(200517);
      return;
    }
    this.iNF = (this.iNt + getPaddingBottom() + getPaddingTop());
    this.iNO = ((int)(this.iNF * this.iNN));
    this.iNP = View.MeasureSpec.getSize(this.iNR);
    this.iNH = ((this.iNO - this.iNF) / 2.0F);
    this.iNI = ((this.iNO + this.iNF) / 2.0F);
    if (this.iNK == -1) {
      if (!this.iuX) {
        break label141;
      }
    }
    label141:
    for (this.iNK = ((this.Lyb.getItemsCount() + 1) / 2);; this.iNK = 0)
    {
      this.iNM = this.iNK;
      AppMethodBeat.o(200517);
      return;
    }
  }
  
  private void aQq()
  {
    AppMethodBeat.i(200528);
    Rect localRect = new Rect();
    this.bWm.getTextBounds(this.content, 0, this.content.length(), localRect);
    localRect = new Rect();
    this.bWm.getTextBounds(this.content, 0, 0, localRect);
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
      this.bWm.getTextBounds(this.content, 0, k, localRect);
      if (localRect.width() >= aQr()) {
        j = k - 1;
      } else if (localRect.width() < aQr()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.bWm.measureText(this.content + "...") <= aQr()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(200528);
  }
  
  private int aQr()
  {
    AppMethodBeat.i(200529);
    int i = this.iNP;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(200529);
    return i - j - k;
  }
  
  private void aQs()
  {
    AppMethodBeat.i(200530);
    int i = this.textSize;
    this.bWm.setTextSize(i);
    while ((i > this.iNE) && (!aQt()))
    {
      i -= 1;
      this.bWm.setTextSize(i);
    }
    AppMethodBeat.o(200530);
  }
  
  private boolean aQt()
  {
    AppMethodBeat.i(200531);
    if (this.bWm.measureText(this.content) <= this.iNP - getPaddingLeft() - getPaddingRight())
    {
      AppMethodBeat.o(200531);
      return true;
    }
    AppMethodBeat.o(200531);
    return false;
  }
  
  private static String cc(Object paramObject)
  {
    AppMethodBeat.i(200527);
    if (paramObject == null)
    {
      AppMethodBeat.o(200527);
      return "";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(200527);
    return paramObject;
  }
  
  private String qQ(int paramInt)
  {
    AppMethodBeat.i(200525);
    int i = paramInt;
    if (this.iuX) {
      i = qR(paramInt);
    }
    String str = this.Lyb.qO(i);
    AppMethodBeat.o(200525);
    return str;
  }
  
  private int qR(int paramInt)
  {
    AppMethodBeat.i(200526);
    int i;
    if (paramInt < 0) {
      i = qR(this.Lyb.getItemsCount() + paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(200526);
      return i;
      i = paramInt;
      if (paramInt > this.Lyb.getItemsCount() - 1) {
        i = qR(paramInt - this.Lyb.getItemsCount());
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(200518);
    aQp();
    if ((parama == a.Lyf) || (parama == a.Lyg))
    {
      this.fq = ((int)((this.iNJ % this.iNF + this.iNF) % this.iNF));
      if (this.fq <= this.iNF / 2.0F) {
        break label117;
      }
    }
    label117:
    for (this.fq = ((int)(this.iNF - this.fq));; this.fq = (-this.fq))
    {
      this.iNB = this.iNA.scheduleWithFixedDelay(new com.tencent.mm.ui.widget.picker.e.c(this, this.fq), 0L, 10L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(200518);
      return;
    }
  }
  
  public final void aQp()
  {
    AppMethodBeat.i(200519);
    if ((this.iNB != null) && (!this.iNB.isCancelled()))
    {
      this.iNB.cancel(true);
      this.iNB = null;
    }
    AppMethodBeat.o(200519);
  }
  
  public final WheelView ago(int paramInt)
  {
    AppMethodBeat.i(200537);
    this.iNt = paramInt;
    invalidate();
    AppMethodBeat.o(200537);
    return this;
  }
  
  public final WheelView agp(int paramInt)
  {
    AppMethodBeat.i(200538);
    this.textColor = paramInt;
    this.bWm.setColor(this.textColor);
    this.iNu = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(200538);
    return this;
  }
  
  public final void fRl()
  {
    AppMethodBeat.i(200523);
    String str = cc(qQ(getCurrentItem()));
    if (!TextUtils.isEmpty(str)) {
      setContentDescription(str);
    }
    AppMethodBeat.o(200523);
  }
  
  public final e getAdapter()
  {
    return this.Lyb;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(200522);
    if (this.Lyb == null)
    {
      AppMethodBeat.o(200522);
      return 0;
    }
    if ((this.LxW) && (this.iNL == 0))
    {
      AppMethodBeat.o(200522);
      return -1;
    }
    if ((this.iuX) && ((this.iNL < 0) || (this.iNL >= this.Lyb.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.iNL) - this.Lyb.getItemsCount()), this.Lyb.getItemsCount() - 1));
      AppMethodBeat.o(200522);
      return i;
    }
    int i = Math.max(0, Math.min(this.iNL, this.Lyb.getItemsCount() - 1));
    AppMethodBeat.o(200522);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.iNK;
  }
  
  public float getItemHeight()
  {
    return this.iNF;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(200534);
    if (this.Lyb != null)
    {
      int i = this.Lyb.getItemsCount();
      AppMethodBeat.o(200534);
      return i;
    }
    AppMethodBeat.o(200534);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.iNJ;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200524);
    super.onDraw(paramCanvas);
    if (this.Lyb == null)
    {
      AppMethodBeat.o(200524);
      return;
    }
    this.iNK = Math.min(Math.max(0, this.iNK), this.Lyb.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.iNN];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.iNJ / this.iNF);
    label1070:
    label1073:
    for (;;)
    {
      try
      {
        j = this.iNK;
        this.iNM = (i % this.Lyb.getItemsCount() + j);
        if (!this.iuX)
        {
          if (this.iNM < 0) {
            this.iNM = 0;
          }
          if (this.iNM > this.Lyb.getItemsCount() - 1) {
            this.iNM = (this.Lyb.getItemsCount() - 1);
          }
          f1 = this.iNJ;
          f2 = this.iNF;
          i = 0;
          if (i >= this.iNN) {
            continue;
          }
          j = this.iNM - (this.iNN / 2 - i);
          if (i != 0) {
            break label1073;
          }
          localObject2 = qQ(j - 1);
          if (i != this.iNN - 1) {
            break label1070;
          }
          localObject1 = qQ(j + 1);
          arrayOfObject[i] = qQ(j);
          i += 1;
          continue;
        }
      }
      catch (ArithmeticException localArithmeticException)
      {
        float f1;
        float f2;
        ap.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配", new Object[0]);
        continue;
        if (this.iNM < 0) {
          this.iNM = (this.Lyb.getItemsCount() + this.iNM);
        }
        if (this.iNM <= this.Lyb.getItemsCount() - 1) {
          continue;
        }
        this.iNM -= this.Lyb.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.iNH, this.iNP, this.iNH, this.iNC);
        paramCanvas.drawLine(0.0F, this.iNI, this.iNP, this.iNI, this.iNC);
        int j = 0;
        if (j < this.iNN + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.iNF * j - f1 % f2 + this.iNF / 2.0F - this.iNF;
            if ((this.iNz) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(cc(localObject3))) || ((this.LxW) && (localObject3.equals(this.mContext.getString(2131766375))))) {
              continue;
            }
            this.content = (cc(localObject3) + this.label);
            this.bWm.getTextBounds(this.content, 0, this.content.length(), this.rect);
          }
          int k;
          switch (this.Kk)
          {
          default: 
            float f4 = this.iNO / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.iNu);
            if (k < this.iNu * 0.14F)
            {
              i = (int)(this.iNu * 0.14F);
              this.bWm.setAlpha(i);
              if ((f3 >= this.iNH) && (f3 <= this.iNI)) {
                this.iNL = (this.iNM - (this.iNN / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.iNO))
              {
                localObject3 = this.content;
                f4 = this.iNS;
                Paint.FontMetricsInt localFontMetricsInt = this.bWm.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.bWm);
              }
              j += 1;
              this.bWm.setTextSize(this.textSize);
              continue;
              if (j == this.iNN + 2 - 1)
              {
                localObject3 = localObject1;
                continue;
              }
              localObject3 = arrayOfObject[(j - 1)];
              continue;
              this.content = cc(localObject3);
            }
            break;
          case 17: 
            if ((this.iNy) || (this.label == null) || (this.label.equals("")) || (!this.iNz))
            {
              if (this.iNP < this.rect.width())
              {
                aQs();
                if (!aQt()) {
                  aQq();
                }
                this.bWm.getTextBounds(this.content, 0, this.content.length(), this.rect);
                this.iNS = ((int)((this.iNP - this.rect.width()) * 0.5D));
                continue;
              }
              this.iNS = ((int)((this.iNP - this.rect.width()) * 0.5D));
              continue;
            }
            this.iNS = ((int)((this.iNP - this.rect.width()) * 0.25D));
            break;
          case 3: 
            this.iNS = 0;
            break;
          case 5: 
            this.iNS = (this.iNP - this.rect.width());
            continue;
            i = k;
            if (k <= this.iNu) {
              continue;
            }
            i = this.iNu;
            break;
          }
        }
        AppMethodBeat.o(200524);
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200532);
    this.iNR = paramInt1;
    aQo();
    setMeasuredDimension(this.iNP, this.iNO);
    AppMethodBeat.o(200532);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200533);
    GestureDetector localGestureDetector = this.iNw;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/ui/widget/picker/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/ui/widget/picker/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1 = -this.iNK;
    float f2 = this.iNF;
    float f3 = this.Lyb.getItemsCount() - 1 - this.iNK;
    float f4 = this.iNF;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label424;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(a.Lyg);
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
        AppMethodBeat.o(200533);
        return true;
        this.startTime = System.currentTimeMillis();
        aQp();
        this.iNQ = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.iNQ - paramMotionEvent.getRawY();
        this.iNQ = paramMotionEvent.getRawY();
        this.iNJ += f5;
        if (this.iuX) {
          break;
        }
        if (((this.iNJ - this.iNF * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.iNJ + this.iNF * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.iNJ -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.iNO / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.iNF / 2.0F);; i = (int)(i - this.iNF / 2.0F))
    {
      if (this.iNF != 0.0F)
      {
        this.fq = ((int)((int)(i / this.iNF) * this.iNF));
        a(a.Lye);
      }
      label424:
      i = 0;
      break;
    }
  }
  
  public final void setAdapter(e<?> parame)
  {
    AppMethodBeat.i(200521);
    this.Lyb = parame;
    aQo();
    invalidate();
    AppMethodBeat.o(200521);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(200520);
    this.iNL = paramInt;
    this.iNK = paramInt;
    this.iNJ = 0.0F;
    fRl();
    invalidate();
    AppMethodBeat.o(200520);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.iuX = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(200535);
    if (paramInt != 0)
    {
      this.iNG = paramInt;
      this.iNC.setColor(this.iNG);
    }
    AppMethodBeat.o(200535);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(200536);
    this.iNC.setStrokeWidth(paramFloat);
    AppMethodBeat.o(200536);
  }
  
  public void setGravity(int paramInt)
  {
    this.Kk = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.iNy = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setLongTermMonthDay(boolean paramBoolean)
  {
    this.Lyc = paramBoolean;
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.LxW = paramBoolean;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.ui.widget.picker.d.c paramc)
  {
    this.Lya = paramc;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.iNJ = paramFloat;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(200512);
      Lye = new a("CLICK", 0);
      Lyf = new a("FLING", 1);
      Lyg = new a("DAGGLE", 2);
      Lyh = new a[] { Lye, Lyf, Lyg };
      AppMethodBeat.o(200512);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.WheelView
 * JD-Core Version:    0.7.0.1
 */