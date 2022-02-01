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
  private e<?> LbA;
  private boolean LbB;
  private boolean Lbv;
  public com.tencent.mm.ui.widget.picker.d.c Lbz;
  private Paint bWm;
  String content;
  private int fq;
  private Handler handler;
  private int iKA;
  private int iKB;
  private final int iKC;
  private GestureDetector iKD;
  private boolean iKF;
  public boolean iKG;
  public ScheduledExecutorService iKH;
  public ScheduledFuture<?> iKI;
  private Paint iKJ;
  private int iKL;
  private float iKM;
  private int iKN;
  private float iKO;
  private float iKP;
  private float iKQ;
  private int iKR;
  private int iKS;
  private int iKT;
  private int iKU;
  private int iKV;
  private int iKW;
  private float iKX;
  private int iKY;
  private int iKZ;
  public boolean isd;
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
    AppMethodBeat.i(192743);
    this.iKA = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.iKC = 2;
    this.content = "";
    this.iKF = false;
    this.iKG = true;
    this.iKH = Executors.newSingleThreadScheduledExecutor();
    this.iKU = 5;
    this.fq = 0;
    this.iKX = 0.0F;
    this.startTime = 0L;
    this.Kk = 17;
    this.iKZ = 0;
    this.rect = new Rect();
    this.mContext = paramContext;
    this.textSize = getResources().getDimensionPixelSize(2131166686);
    this.iKL = getResources().getDimensionPixelSize(2131166685);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WheelView, 0, 0);
      this.Kk = paramAttributeSet.getInt(1, 17);
      this.iKN = paramAttributeSet.getColor(0, -2763307);
      paramAttributeSet.recycle();
    }
    this.handler = new com.tencent.mm.ui.widget.picker.e.b(this);
    this.iKD = new GestureDetector(paramContext, new com.tencent.mm.ui.widget.picker.d.b(this));
    this.iKD.setIsLongpressEnabled(false);
    this.isd = true;
    this.iKQ = 0.0F;
    this.iKR = -1;
    this.bWm = new Paint();
    this.bWm.setColor(this.textColor);
    this.bWm.setAntiAlias(true);
    this.bWm.setTextSize(this.textSize);
    this.iKJ = new Paint();
    this.iKJ.setColor(this.iKN);
    this.iKJ.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(192743);
  }
  
  private void aPP()
  {
    AppMethodBeat.i(192744);
    if (this.LbA == null)
    {
      AppMethodBeat.o(192744);
      return;
    }
    this.iKM = (this.iKA + getPaddingBottom() + getPaddingTop());
    this.iKV = ((int)(this.iKM * this.iKU));
    this.iKW = View.MeasureSpec.getSize(this.iKY);
    this.iKO = ((this.iKV - this.iKM) / 2.0F);
    this.iKP = ((this.iKV + this.iKM) / 2.0F);
    if (this.iKR == -1) {
      if (!this.isd) {
        break label141;
      }
    }
    label141:
    for (this.iKR = ((this.LbA.getItemsCount() + 1) / 2);; this.iKR = 0)
    {
      this.iKT = this.iKR;
      AppMethodBeat.o(192744);
      return;
    }
  }
  
  private void aPR()
  {
    AppMethodBeat.i(192755);
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
      if (localRect.width() >= aPS()) {
        j = k - 1;
      } else if (localRect.width() < aPS()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.bWm.measureText(this.content + "...") <= aPS()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(192755);
  }
  
  private int aPS()
  {
    AppMethodBeat.i(192756);
    int i = this.iKW;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(192756);
    return i - j - k;
  }
  
  private void aPT()
  {
    AppMethodBeat.i(192757);
    int i = this.textSize;
    this.bWm.setTextSize(i);
    while ((i > this.iKL) && (!aPU()))
    {
      i -= 1;
      this.bWm.setTextSize(i);
    }
    AppMethodBeat.o(192757);
  }
  
  private boolean aPU()
  {
    AppMethodBeat.i(192758);
    if (this.bWm.measureText(this.content) <= this.iKW - getPaddingLeft() - getPaddingRight())
    {
      AppMethodBeat.o(192758);
      return true;
    }
    AppMethodBeat.o(192758);
    return false;
  }
  
  private static String cc(Object paramObject)
  {
    AppMethodBeat.i(192754);
    if (paramObject == null)
    {
      AppMethodBeat.o(192754);
      return "";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(192754);
    return paramObject;
  }
  
  private String qN(int paramInt)
  {
    AppMethodBeat.i(192752);
    int i = paramInt;
    if (this.isd) {
      i = qO(paramInt);
    }
    String str = this.LbA.qL(i);
    AppMethodBeat.o(192752);
    return str;
  }
  
  private int qO(int paramInt)
  {
    AppMethodBeat.i(192753);
    int i;
    if (paramInt < 0) {
      i = qO(this.LbA.getItemsCount() + paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(192753);
      return i;
      i = paramInt;
      if (paramInt > this.LbA.getItemsCount() - 1) {
        i = qO(paramInt - this.LbA.getItemsCount());
      }
    }
  }
  
  public final void a(WheelView.a parama)
  {
    AppMethodBeat.i(192745);
    aPQ();
    if ((parama == WheelView.a.LbE) || (parama == WheelView.a.LbF))
    {
      this.fq = ((int)((this.iKQ % this.iKM + this.iKM) % this.iKM));
      if (this.fq <= this.iKM / 2.0F) {
        break label117;
      }
    }
    label117:
    for (this.fq = ((int)(this.iKM - this.fq));; this.fq = (-this.fq))
    {
      this.iKI = this.iKH.scheduleWithFixedDelay(new com.tencent.mm.ui.widget.picker.e.c(this, this.fq), 0L, 10L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(192745);
      return;
    }
  }
  
  public final void aPQ()
  {
    AppMethodBeat.i(192746);
    if ((this.iKI != null) && (!this.iKI.isCancelled()))
    {
      this.iKI.cancel(true);
      this.iKI = null;
    }
    AppMethodBeat.o(192746);
  }
  
  public final WheelView afF(int paramInt)
  {
    AppMethodBeat.i(192764);
    this.iKA = paramInt;
    invalidate();
    AppMethodBeat.o(192764);
    return this;
  }
  
  public final WheelView afG(int paramInt)
  {
    AppMethodBeat.i(192765);
    this.textColor = paramInt;
    this.bWm.setColor(this.textColor);
    this.iKB = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(192765);
    return this;
  }
  
  public final void fMQ()
  {
    AppMethodBeat.i(192750);
    String str = cc(qN(getCurrentItem()));
    if (!TextUtils.isEmpty(str)) {
      setContentDescription(str);
    }
    AppMethodBeat.o(192750);
  }
  
  public final e getAdapter()
  {
    return this.LbA;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(192749);
    if (this.LbA == null)
    {
      AppMethodBeat.o(192749);
      return 0;
    }
    if ((this.Lbv) && (this.iKS == 0))
    {
      AppMethodBeat.o(192749);
      return -1;
    }
    if ((this.isd) && ((this.iKS < 0) || (this.iKS >= this.LbA.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.iKS) - this.LbA.getItemsCount()), this.LbA.getItemsCount() - 1));
      AppMethodBeat.o(192749);
      return i;
    }
    int i = Math.max(0, Math.min(this.iKS, this.LbA.getItemsCount() - 1));
    AppMethodBeat.o(192749);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.iKR;
  }
  
  public float getItemHeight()
  {
    return this.iKM;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(192761);
    if (this.LbA != null)
    {
      int i = this.LbA.getItemsCount();
      AppMethodBeat.o(192761);
      return i;
    }
    AppMethodBeat.o(192761);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.iKQ;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192751);
    super.onDraw(paramCanvas);
    if (this.LbA == null)
    {
      AppMethodBeat.o(192751);
      return;
    }
    this.iKR = Math.min(Math.max(0, this.iKR), this.LbA.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.iKU];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.iKQ / this.iKM);
    label1070:
    label1073:
    for (;;)
    {
      try
      {
        j = this.iKR;
        this.iKT = (i % this.LbA.getItemsCount() + j);
        if (!this.isd)
        {
          if (this.iKT < 0) {
            this.iKT = 0;
          }
          if (this.iKT > this.LbA.getItemsCount() - 1) {
            this.iKT = (this.LbA.getItemsCount() - 1);
          }
          f1 = this.iKQ;
          f2 = this.iKM;
          i = 0;
          if (i >= this.iKU) {
            continue;
          }
          j = this.iKT - (this.iKU / 2 - i);
          if (i != 0) {
            break label1073;
          }
          localObject2 = qN(j - 1);
          if (i != this.iKU - 1) {
            break label1070;
          }
          localObject1 = qN(j + 1);
          arrayOfObject[i] = qN(j);
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
        if (this.iKT < 0) {
          this.iKT = (this.LbA.getItemsCount() + this.iKT);
        }
        if (this.iKT <= this.LbA.getItemsCount() - 1) {
          continue;
        }
        this.iKT -= this.LbA.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.iKO, this.iKW, this.iKO, this.iKJ);
        paramCanvas.drawLine(0.0F, this.iKP, this.iKW, this.iKP, this.iKJ);
        int j = 0;
        if (j < this.iKU + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.iKM * j - f1 % f2 + this.iKM / 2.0F - this.iKM;
            if ((this.iKG) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(cc(localObject3))) || ((this.Lbv) && (localObject3.equals(this.mContext.getString(2131766375))))) {
              continue;
            }
            this.content = (cc(localObject3) + this.label);
            this.bWm.getTextBounds(this.content, 0, this.content.length(), this.rect);
          }
          int k;
          switch (this.Kk)
          {
          default: 
            float f4 = this.iKV / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.iKB);
            if (k < this.iKB * 0.14F)
            {
              i = (int)(this.iKB * 0.14F);
              this.bWm.setAlpha(i);
              if ((f3 >= this.iKO) && (f3 <= this.iKP)) {
                this.iKS = (this.iKT - (this.iKU / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.iKV))
              {
                localObject3 = this.content;
                f4 = this.iKZ;
                Paint.FontMetricsInt localFontMetricsInt = this.bWm.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.bWm);
              }
              j += 1;
              this.bWm.setTextSize(this.textSize);
              continue;
              if (j == this.iKU + 2 - 1)
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
            if ((this.iKF) || (this.label == null) || (this.label.equals("")) || (!this.iKG))
            {
              if (this.iKW < this.rect.width())
              {
                aPT();
                if (!aPU()) {
                  aPR();
                }
                this.bWm.getTextBounds(this.content, 0, this.content.length(), this.rect);
                this.iKZ = ((int)((this.iKW - this.rect.width()) * 0.5D));
                continue;
              }
              this.iKZ = ((int)((this.iKW - this.rect.width()) * 0.5D));
              continue;
            }
            this.iKZ = ((int)((this.iKW - this.rect.width()) * 0.25D));
            break;
          case 3: 
            this.iKZ = 0;
            break;
          case 5: 
            this.iKZ = (this.iKW - this.rect.width());
            continue;
            i = k;
            if (k <= this.iKB) {
              continue;
            }
            i = this.iKB;
            break;
          }
        }
        AppMethodBeat.o(192751);
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192759);
    this.iKY = paramInt1;
    aPP();
    setMeasuredDimension(this.iKW, this.iKV);
    AppMethodBeat.o(192759);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192760);
    GestureDetector localGestureDetector = this.iKD;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/ui/widget/picker/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/ui/widget/picker/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1 = -this.iKR;
    float f2 = this.iKM;
    float f3 = this.LbA.getItemsCount() - 1 - this.iKR;
    float f4 = this.iKM;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label424;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(WheelView.a.LbF);
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
        AppMethodBeat.o(192760);
        return true;
        this.startTime = System.currentTimeMillis();
        aPQ();
        this.iKX = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.iKX - paramMotionEvent.getRawY();
        this.iKX = paramMotionEvent.getRawY();
        this.iKQ += f5;
        if (this.isd) {
          break;
        }
        if (((this.iKQ - this.iKM * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.iKQ + this.iKM * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.iKQ -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.iKV / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.iKM / 2.0F);; i = (int)(i - this.iKM / 2.0F))
    {
      if (this.iKM != 0.0F)
      {
        this.fq = ((int)((int)(i / this.iKM) * this.iKM));
        a(WheelView.a.LbD);
      }
      label424:
      i = 0;
      break;
    }
  }
  
  public final void setAdapter(e<?> parame)
  {
    AppMethodBeat.i(192748);
    this.LbA = parame;
    aPP();
    invalidate();
    AppMethodBeat.o(192748);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(192747);
    this.iKS = paramInt;
    this.iKR = paramInt;
    this.iKQ = 0.0F;
    fMQ();
    invalidate();
    AppMethodBeat.o(192747);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.isd = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(192762);
    if (paramInt != 0)
    {
      this.iKN = paramInt;
      this.iKJ.setColor(this.iKN);
    }
    AppMethodBeat.o(192762);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(192763);
    this.iKJ.setStrokeWidth(paramFloat);
    AppMethodBeat.o(192763);
  }
  
  public void setGravity(int paramInt)
  {
    this.Kk = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.iKF = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setLongTermMonthDay(boolean paramBoolean)
  {
    this.LbB = paramBoolean;
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.Lbv = paramBoolean;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.ui.widget.picker.d.c paramc)
  {
    this.Lbz = paramc;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.iKQ = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.WheelView
 * JD-Core Version:    0.7.0.1
 */