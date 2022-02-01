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
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.widget.picker.a.e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView
  extends View
{
  private int Ku;
  private boolean QTL;
  public com.tencent.mm.ui.widget.picker.d.c QTP;
  public ScheduledFuture<?> QTQ;
  private e<?> QTR;
  private boolean QTS;
  private Paint cgU;
  String content;
  private int fs;
  private Handler handler;
  private int jKA;
  private int jKB;
  private int jKC;
  private int jKD;
  private float jKE;
  private int jKF;
  private int jKG;
  public ScheduledExecutorService jKb;
  private int jKh;
  private int jKi;
  private final int jKj;
  private GestureDetector jKk;
  private boolean jKm;
  public boolean jKn;
  private Paint jKq;
  private int jKs;
  private float jKt;
  private int jKu;
  private float jKv;
  private float jKw;
  private float jKx;
  private int jKy;
  private int jKz;
  public boolean jqj;
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
    AppMethodBeat.i(198474);
    this.jKh = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.jKj = 2;
    this.content = "";
    this.jKm = false;
    this.jKn = true;
    this.jKb = Executors.newSingleThreadScheduledExecutor();
    this.jKB = 5;
    this.fs = 0;
    this.jKE = 0.0F;
    this.startTime = 0L;
    this.Ku = 17;
    this.jKG = 0;
    this.rect = new Rect();
    this.mContext = paramContext;
    this.textSize = getResources().getDimensionPixelSize(2131166806);
    this.jKs = getResources().getDimensionPixelSize(2131166805);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WheelView, 0, 0);
      this.Ku = paramAttributeSet.getInt(1, 17);
      this.jKu = paramAttributeSet.getColor(0, -2763307);
      paramAttributeSet.recycle();
    }
    this.handler = new com.tencent.mm.ui.widget.picker.e.b(this);
    this.jKk = new GestureDetector(paramContext, new com.tencent.mm.ui.widget.picker.d.b(this));
    this.jKk.setIsLongpressEnabled(false);
    this.jqj = true;
    this.jKx = 0.0F;
    this.jKy = -1;
    this.cgU = new Paint();
    this.cgU.setColor(this.textColor);
    this.cgU.setAntiAlias(true);
    this.cgU.setTextSize(this.textSize);
    this.jKq = new Paint();
    this.jKq.setColor(this.jKu);
    this.jKq.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(198474);
  }
  
  private void bkT()
  {
    AppMethodBeat.i(198475);
    if (this.QTR == null)
    {
      AppMethodBeat.o(198475);
      return;
    }
    this.jKt = (this.jKh + getPaddingBottom() + getPaddingTop());
    this.jKC = ((int)(this.jKt * this.jKB));
    this.jKD = View.MeasureSpec.getSize(this.jKF);
    this.jKv = ((this.jKC - this.jKt) / 2.0F);
    this.jKw = ((this.jKC + this.jKt) / 2.0F);
    if (this.jKy == -1) {
      if (!this.jqj) {
        break label141;
      }
    }
    label141:
    for (this.jKy = ((this.QTR.getItemsCount() + 1) / 2);; this.jKy = 0)
    {
      this.jKA = this.jKy;
      AppMethodBeat.o(198475);
      return;
    }
  }
  
  private void bkV()
  {
    AppMethodBeat.i(198486);
    Rect localRect = new Rect();
    this.cgU.getTextBounds(this.content, 0, this.content.length(), localRect);
    localRect = new Rect();
    this.cgU.getTextBounds(this.content, 0, 0, localRect);
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
      this.cgU.getTextBounds(this.content, 0, k, localRect);
      if (localRect.width() >= bkW()) {
        j = k - 1;
      } else if (localRect.width() < bkW()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.cgU.measureText(this.content + "...") <= bkW()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(198486);
  }
  
  private int bkW()
  {
    AppMethodBeat.i(198487);
    int i = this.jKD;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(198487);
    return i - j - k;
  }
  
  private void bkX()
  {
    AppMethodBeat.i(198488);
    int i = this.textSize;
    this.cgU.setTextSize(i);
    while ((i > this.jKs) && (!bkY()))
    {
      i -= 1;
      this.cgU.setTextSize(i);
    }
    AppMethodBeat.o(198488);
  }
  
  private boolean bkY()
  {
    AppMethodBeat.i(198489);
    if (this.cgU.measureText(this.content) <= this.jKD - getPaddingLeft() - getPaddingRight())
    {
      AppMethodBeat.o(198489);
      return true;
    }
    AppMethodBeat.o(198489);
    return false;
  }
  
  private static String cl(Object paramObject)
  {
    AppMethodBeat.i(198485);
    if (paramObject == null)
    {
      AppMethodBeat.o(198485);
      return "";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(198485);
    return paramObject;
  }
  
  private String uI(int paramInt)
  {
    AppMethodBeat.i(198483);
    int i = paramInt;
    if (this.jqj) {
      i = uJ(paramInt);
    }
    String str = this.QTR.uG(i);
    AppMethodBeat.o(198483);
    return str;
  }
  
  private int uJ(int paramInt)
  {
    AppMethodBeat.i(198484);
    int i;
    if (paramInt < 0) {
      i = uJ(this.QTR.getItemsCount() + paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(198484);
      return i;
      i = paramInt;
      if (paramInt > this.QTR.getItemsCount() - 1) {
        i = uJ(paramInt - this.QTR.getItemsCount());
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(198476);
    bkU();
    if ((parama == a.QTV) || (parama == a.QTW))
    {
      this.fs = ((int)((this.jKx % this.jKt + this.jKt) % this.jKt));
      if (this.fs <= this.jKt / 2.0F) {
        break label117;
      }
    }
    label117:
    for (this.fs = ((int)(this.jKt - this.fs));; this.fs = (-this.fs))
    {
      this.QTQ = this.jKb.scheduleWithFixedDelay(new com.tencent.mm.ui.widget.picker.e.c(this, this.fs), 0L, 10L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(198476);
      return;
    }
  }
  
  public final WheelView apr(int paramInt)
  {
    AppMethodBeat.i(198495);
    this.jKh = paramInt;
    invalidate();
    AppMethodBeat.o(198495);
    return this;
  }
  
  public final WheelView aps(int paramInt)
  {
    AppMethodBeat.i(198496);
    this.textColor = paramInt;
    this.cgU.setColor(this.textColor);
    this.jKi = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(198496);
    return this;
  }
  
  public final void bkU()
  {
    AppMethodBeat.i(198477);
    if ((this.QTQ != null) && (!this.QTQ.isCancelled()))
    {
      this.QTQ.cancel(true);
      this.QTQ = null;
    }
    AppMethodBeat.o(198477);
  }
  
  public final e getAdapter()
  {
    return this.QTR;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(198480);
    if (this.QTR == null)
    {
      AppMethodBeat.o(198480);
      return 0;
    }
    if ((this.QTL) && (this.jKz == 0))
    {
      AppMethodBeat.o(198480);
      return -1;
    }
    if ((this.jqj) && ((this.jKz < 0) || (this.jKz >= this.QTR.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.jKz) - this.QTR.getItemsCount()), this.QTR.getItemsCount() - 1));
      AppMethodBeat.o(198480);
      return i;
    }
    int i = Math.max(0, Math.min(this.jKz, this.QTR.getItemsCount() - 1));
    AppMethodBeat.o(198480);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.jKy;
  }
  
  public float getItemHeight()
  {
    return this.jKt;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(198492);
    if (this.QTR != null)
    {
      int i = this.QTR.getItemsCount();
      AppMethodBeat.o(198492);
      return i;
    }
    AppMethodBeat.o(198492);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.jKx;
  }
  
  public final void hcn()
  {
    AppMethodBeat.i(198481);
    String str = cl(uI(getCurrentItem()));
    if (!TextUtils.isEmpty(str)) {
      setContentDescription(str);
    }
    AppMethodBeat.o(198481);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(198482);
    super.onDraw(paramCanvas);
    if (this.QTR == null)
    {
      AppMethodBeat.o(198482);
      return;
    }
    this.jKy = Math.min(Math.max(0, this.jKy), this.QTR.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.jKB];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.jKx / this.jKt);
    label1070:
    label1073:
    for (;;)
    {
      try
      {
        j = this.jKy;
        this.jKA = (i % this.QTR.getItemsCount() + j);
        if (!this.jqj)
        {
          if (this.jKA < 0) {
            this.jKA = 0;
          }
          if (this.jKA > this.QTR.getItemsCount() - 1) {
            this.jKA = (this.QTR.getItemsCount() - 1);
          }
          f1 = this.jKx;
          f2 = this.jKt;
          i = 0;
          if (i >= this.jKB) {
            continue;
          }
          j = this.jKA - (this.jKB / 2 - i);
          if (i != 0) {
            break label1073;
          }
          localObject2 = uI(j - 1);
          if (i != this.jKB - 1) {
            break label1070;
          }
          localObject1 = uI(j + 1);
          arrayOfObject[i] = uI(j);
          i += 1;
          continue;
        }
      }
      catch (ArithmeticException localArithmeticException)
      {
        float f1;
        float f2;
        as.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配", new Object[0]);
        continue;
        if (this.jKA < 0) {
          this.jKA = (this.QTR.getItemsCount() + this.jKA);
        }
        if (this.jKA <= this.QTR.getItemsCount() - 1) {
          continue;
        }
        this.jKA -= this.QTR.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.jKv, this.jKD, this.jKv, this.jKq);
        paramCanvas.drawLine(0.0F, this.jKw, this.jKD, this.jKw, this.jKq);
        int j = 0;
        if (j < this.jKB + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.jKt * j - f1 % f2 + this.jKt / 2.0F - this.jKt;
            if ((this.jKn) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(cl(localObject3))) || ((this.QTL) && (localObject3.equals(this.mContext.getString(2131763917))))) {
              continue;
            }
            this.content = (cl(localObject3) + this.label);
            this.cgU.getTextBounds(this.content, 0, this.content.length(), this.rect);
          }
          int k;
          switch (this.Ku)
          {
          default: 
            float f4 = this.jKC / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.jKi);
            if (k < this.jKi * 0.14F)
            {
              i = (int)(this.jKi * 0.14F);
              this.cgU.setAlpha(i);
              if ((f3 >= this.jKv) && (f3 <= this.jKw)) {
                this.jKz = (this.jKA - (this.jKB / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.jKC))
              {
                localObject3 = this.content;
                f4 = this.jKG;
                Paint.FontMetricsInt localFontMetricsInt = this.cgU.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.cgU);
              }
              j += 1;
              this.cgU.setTextSize(this.textSize);
              continue;
              if (j == this.jKB + 2 - 1)
              {
                localObject3 = localObject1;
                continue;
              }
              localObject3 = arrayOfObject[(j - 1)];
              continue;
              this.content = cl(localObject3);
            }
            break;
          case 17: 
            if ((this.jKm) || (this.label == null) || (this.label.equals("")) || (!this.jKn))
            {
              if (this.jKD < this.rect.width())
              {
                bkX();
                if (!bkY()) {
                  bkV();
                }
                this.cgU.getTextBounds(this.content, 0, this.content.length(), this.rect);
                this.jKG = ((int)((this.jKD - this.rect.width()) * 0.5D));
                continue;
              }
              this.jKG = ((int)((this.jKD - this.rect.width()) * 0.5D));
              continue;
            }
            this.jKG = ((int)((this.jKD - this.rect.width()) * 0.25D));
            break;
          case 3: 
            this.jKG = 0;
            break;
          case 5: 
            this.jKG = (this.jKD - this.rect.width());
            continue;
            i = k;
            if (k <= this.jKi) {
              continue;
            }
            i = this.jKi;
            break;
          }
        }
        AppMethodBeat.o(198482);
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198490);
    this.jKF = paramInt1;
    bkT();
    setMeasuredDimension(this.jKD, this.jKC);
    AppMethodBeat.o(198490);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198491);
    GestureDetector localGestureDetector = this.jKk;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/ui/widget/picker/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/widget/picker/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1 = -this.jKy;
    float f2 = this.jKt;
    float f3 = this.QTR.getItemsCount() - 1 - this.jKy;
    float f4 = this.jKt;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label424;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(a.QTW);
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
        AppMethodBeat.o(198491);
        return true;
        this.startTime = System.currentTimeMillis();
        bkU();
        this.jKE = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.jKE - paramMotionEvent.getRawY();
        this.jKE = paramMotionEvent.getRawY();
        this.jKx += f5;
        if (this.jqj) {
          break;
        }
        if (((this.jKx - this.jKt * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.jKx + this.jKt * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.jKx -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.jKC / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.jKt / 2.0F);; i = (int)(i - this.jKt / 2.0F))
    {
      if (this.jKt != 0.0F)
      {
        this.fs = ((int)((int)(i / this.jKt) * this.jKt));
        a(a.QTU);
      }
      label424:
      i = 0;
      break;
    }
  }
  
  public final void setAdapter(e<?> parame)
  {
    AppMethodBeat.i(198479);
    this.QTR = parame;
    bkT();
    invalidate();
    AppMethodBeat.o(198479);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(198478);
    this.jKz = paramInt;
    this.jKy = paramInt;
    this.jKx = 0.0F;
    hcn();
    invalidate();
    AppMethodBeat.o(198478);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.jqj = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(198493);
    if (paramInt != 0)
    {
      this.jKu = paramInt;
      this.jKq.setColor(this.jKu);
    }
    AppMethodBeat.o(198493);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(198494);
    this.jKq.setStrokeWidth(paramFloat);
    AppMethodBeat.o(198494);
  }
  
  public void setGravity(int paramInt)
  {
    this.Ku = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.jKm = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setLongTermMonthDay(boolean paramBoolean)
  {
    this.QTS = paramBoolean;
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.QTL = paramBoolean;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.ui.widget.picker.d.c paramc)
  {
    this.QTP = paramc;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.jKx = paramFloat;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(198470);
      QTU = new a("CLICK", 0);
      QTV = new a("FLING", 1);
      QTW = new a("DAGGLE", 2);
      QTX = new a[] { QTU, QTV, QTW };
      AppMethodBeat.o(198470);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.WheelView
 * JD-Core Version:    0.7.0.1
 */