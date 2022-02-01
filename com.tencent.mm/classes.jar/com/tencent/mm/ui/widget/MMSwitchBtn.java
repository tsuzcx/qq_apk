package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.k;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.bd;

public class MMSwitchBtn
  extends View
  implements View.OnClickListener
{
  private RectF JtS;
  private float Mlj;
  private float Mlk;
  private long afTH;
  private int afTI;
  private int afTJ;
  private int afTK;
  private boolean afTL;
  private boolean afTM;
  private float afTN;
  private float afTO;
  private int afTP;
  private int afTQ;
  private int afTR;
  private int afTS;
  public boolean afTT;
  private RectF afTU;
  private int afTV;
  private int afTW;
  private int afTX;
  private String afTY;
  private String afTZ;
  private b afUa;
  private a afUb;
  private int doK;
  private int edgePadding;
  private int maxHeight;
  private int maxWidth;
  private Paint wXu;
  
  public MMSwitchBtn(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159271);
    this.afTL = false;
    this.afTM = false;
    this.afTT = false;
    this.wXu = new Paint(1);
    this.JtS = new RectF();
    this.afTU = new RectF();
    this.afUa = new b((byte)0);
    init();
    AppMethodBeat.o(159271);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159270);
    this.afTL = false;
    this.afTM = false;
    this.afTT = false;
    this.wXu = new Paint(1);
    this.JtS = new RectF();
    this.afTU = new RectF();
    this.afUa = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMSwitchBtn));
    AppMethodBeat.o(159270);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159269);
    this.afTL = false;
    this.afTM = false;
    this.afTT = false;
    this.wXu = new Paint(1);
    this.JtS = new RectF();
    this.afTU = new RectF();
    this.afUa = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMSwitchBtn));
    AppMethodBeat.o(159269);
  }
  
  private void Nj(boolean paramBoolean)
  {
    AppMethodBeat.i(159276);
    this.afTL = true;
    this.afUa.reset();
    if (paramBoolean) {
      this.afUa.afUc = (this.afTJ - this.afTU.left + this.edgePadding);
    }
    for (this.afUa.direction = 1;; this.afUa.direction = 0)
    {
      this.afUa.cxD = this.afTU.left;
      this.afUa.setDuration(80L * this.afUa.afUc / this.afTJ);
      startAnimation(this.afUa);
      AppMethodBeat.o(159276);
      return;
      this.afUa.afUc = (this.afTU.left);
    }
  }
  
  private void d(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(159273);
    this.afTW = paramTypedArray.getColor(a.k.MMSwitchBtn_on_color, this.afTR);
    this.afTV = paramTypedArray.getColor(a.k.MMSwitchBtn_off_color, this.afTQ);
    this.afTX = paramTypedArray.getColor(a.k.MMSwitchBtn_slide_color, this.afTP);
    this.afTY = paramTypedArray.getString(a.k.MMSwitchBtn_on_text);
    this.afTZ = paramTypedArray.getString(a.k.MMSwitchBtn_off_text);
    paramTypedArray.recycle();
    AppMethodBeat.o(159273);
  }
  
  private void init()
  {
    AppMethodBeat.i(159272);
    this.edgePadding = getResources().getDimensionPixelSize(a.d.SmallestPadding);
    this.afTN = getResources().getDimensionPixelSize(a.d.SwitchBtnRadiusOut);
    this.afTO = getResources().getDimensionPixelSize(a.d.SwitchBtnRadiusIn);
    this.afTP = getResources().getColor(a.c.White);
    this.afTQ = getResources().getColor(a.c.switch_btn_off_color);
    this.afTR = getResources().getColor(a.c.switch_btn_on_color);
    this.afTS = getResources().getColor(a.c.black_text_color_disabled);
    this.afTW = this.afTR;
    this.afTV = this.afTQ;
    this.afTX = this.afTP;
    this.doK = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setOnClickListener(this);
    AppMethodBeat.o(159272);
  }
  
  private void jDu()
  {
    AppMethodBeat.i(159278);
    if (this.afTU.left > this.afTI)
    {
      Nj(true);
      AppMethodBeat.o(159278);
      return;
    }
    Nj(false);
    AppMethodBeat.o(159278);
  }
  
  private void jEQ()
  {
    if (this.afTK < this.maxHeight) {
      this.afTU.top = ((this.maxHeight - this.afTK) / 2 + this.edgePadding);
    }
    for (this.afTU.bottom = (this.afTU.top + this.afTK - this.edgePadding * 2); this.afTT; this.afTU.bottom = (this.maxHeight - this.edgePadding))
    {
      this.afTU.left = (this.afTJ + this.edgePadding);
      this.afTU.right = (this.maxWidth - this.edgePadding);
      return;
      this.afTU.top = this.edgePadding;
    }
    this.afTU.left = this.edgePadding;
    this.afTU.right = ((int)(this.afTO * 2.0F) + this.edgePadding);
  }
  
  private void jER()
  {
    if (this.afTU.left < this.edgePadding) {
      this.afTU.left = this.edgePadding;
    }
    if (this.afTU.left > this.afTJ + this.edgePadding) {
      this.afTU.left = (this.afTJ + this.edgePadding);
    }
    this.afTU.right = (this.afTU.left + (int)(this.afTO * 2.0F));
  }
  
  private void oc(boolean paramBoolean)
  {
    AppMethodBeat.i(159277);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(159277);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(251591);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/widget/MMSwitchBtn", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!this.afTT) {}
    for (boolean bool = true;; bool = false)
    {
      Nj(bool);
      oc(false);
      this.afTM = false;
      a.a(this, "com/tencent/mm/ui/widget/MMSwitchBtn", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251591);
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159280);
    int i;
    if (!isEnabled())
    {
      i = this.afTS;
      this.wXu.setAlpha(38);
    }
    for (;;)
    {
      this.wXu.setColor(i);
      paramCanvas.drawRoundRect(this.JtS, this.afTN, this.afTN, this.wXu);
      this.wXu.setColor(this.afTW);
      this.wXu.setAlpha(Math.min(255, (int)((this.afTU.left - this.edgePadding) / this.afTJ * 255.0F)));
      paramCanvas.drawRoundRect(this.JtS, this.afTN, this.afTN, this.wXu);
      this.wXu.setColor(this.afTX);
      paramCanvas.drawRoundRect(this.afTU, this.afTO, this.afTO, this.wXu);
      if ((this.afTY != null) && (this.afTZ != null))
      {
        Paint localPaint = new Paint();
        localPaint.setTextSize(getResources().getDimension(a.d.SmallTextSize));
        localPaint.setTextAlign(Paint.Align.CENTER);
        localPaint.setColor(getResources().getColor(a.c.white_text_color));
        localPaint.setAntiAlias(true);
        i = Math.min(255, (int)((this.afTU.left - this.edgePadding) / this.afTJ * 255.0F));
        Rect localRect = new Rect();
        localPaint.getTextBounds(this.afTY, 0, this.afTY.length(), localRect);
        localPaint.setAlpha(i);
        float f2 = (this.JtS.left + this.JtS.right) / 2.0F;
        float f3 = this.afTO;
        float f4 = bd.fromDPToPix(getContext(), 1);
        float f1 = (this.JtS.top + this.JtS.bottom) / 2.0F;
        f1 = localRect.height() / 2.0F + f1 - bd.fromDPToPix(getContext(), 1);
        paramCanvas.drawText(this.afTY, f2 - f3 + f4, f1, localPaint);
        f2 = (this.JtS.left + this.JtS.right) / 2.0F;
        f3 = this.afTO;
        f4 = bd.fromDPToPix(getContext(), 1);
        localPaint.setAlpha(255 - i);
        paramCanvas.drawText(this.afTZ, f2 + f3 - f4, f1, localPaint);
      }
      AppMethodBeat.o(159280);
      return;
      i = this.afTV;
      this.wXu.setAlpha(255);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159275);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.maxWidth = (paramInt3 - paramInt1);
    this.maxHeight = (paramInt4 - paramInt2);
    this.afTJ = (this.maxWidth - (int)(this.afTO * 2.0F) - this.edgePadding * 2);
    this.afTI = (this.afTJ / 2);
    this.afTK = getResources().getDimensionPixelSize(a.d.SwitchBtnHeight);
    if (this.afTK < this.maxHeight) {
      this.JtS.top = ((this.maxHeight - this.afTK) / 2);
    }
    for (this.JtS.bottom = (this.JtS.top + this.afTK);; this.JtS.bottom = this.maxHeight)
    {
      this.JtS.left = 0.0F;
      this.JtS.right = this.maxWidth;
      jEQ();
      this.wXu.setStyle(Paint.Style.FILL);
      this.wXu.setColor(this.afTQ);
      AppMethodBeat.o(159275);
      return;
      this.JtS.top = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(159279);
    if (this.afTL)
    {
      AppMethodBeat.o(159279);
      return true;
    }
    if (!isEnabled())
    {
      AppMethodBeat.o(159279);
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (this.afTM) {
        invalidate();
      }
      AppMethodBeat.o(159279);
      return true;
      clearAnimation();
      this.Mlj = paramMotionEvent.getX();
      this.Mlk = paramMotionEvent.getY();
      this.afTH = SystemClock.elapsedRealtime();
      this.afTM = false;
      continue;
      float f1;
      float f2;
      if (this.afTM)
      {
        oc(true);
        f1 = paramMotionEvent.getX();
        f2 = this.Mlj;
        RectF localRectF = this.afTU;
        localRectF.left = (f1 - f2 + localRectF.left);
        jER();
      }
      for (;;)
      {
        this.Mlj = paramMotionEvent.getX();
        this.Mlk = paramMotionEvent.getY();
        break;
        float f3 = paramMotionEvent.getX() - this.Mlj;
        f2 = paramMotionEvent.getY() - this.Mlk;
        int i = j;
        if (Math.abs(f3) >= this.doK / 10.0F)
        {
          f1 = f2;
          if (f2 == 0.0F) {
            f1 = 1.0F;
          }
          i = j;
          if (Math.abs(f3 / f1) > 3.0F) {
            i = 1;
          }
        }
        if (i != 0)
        {
          this.afTM = true;
          oc(true);
        }
      }
      boolean bool;
      if (SystemClock.elapsedRealtime() - this.afTH < 300L) {
        if (!this.afTT)
        {
          bool = true;
          label308:
          Nj(bool);
        }
      }
      for (;;)
      {
        oc(false);
        this.afTM = false;
        break;
        bool = false;
        break label308;
        jDu();
      }
      if (this.afTM) {
        jDu();
      }
      oc(false);
      this.afTM = false;
    }
  }
  
  public void setCheck(boolean paramBoolean)
  {
    AppMethodBeat.i(159274);
    if (this.afTT != paramBoolean)
    {
      clearAnimation();
      this.afTT = paramBoolean;
      jEQ();
      this.afTL = false;
      invalidate();
    }
    AppMethodBeat.o(159274);
  }
  
  public void setSwitchListener(a parama)
  {
    this.afUb = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onStatusChange(boolean paramBoolean);
  }
  
  final class b
    extends Animation
  {
    long afUc;
    float cxD;
    int direction;
    
    private b()
    {
      AppMethodBeat.i(159267);
      this.direction = 0;
      this.cxD = 0.0F;
      this.afUc = 0L;
      setInterpolator(new AccelerateDecelerateInterpolator());
      setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          boolean bool2 = true;
          AppMethodBeat.i(159266);
          boolean bool3 = MMSwitchBtn.a(MMSwitchBtn.this);
          if (MMSwitchBtn.b.this.direction == 1)
          {
            bool1 = true;
            if (bool3 != bool1)
            {
              paramAnonymousAnimation = MMSwitchBtn.this;
              if (MMSwitchBtn.b.this.direction != 1) {
                break label106;
              }
            }
          }
          label106:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            MMSwitchBtn.a(paramAnonymousAnimation, bool1);
            MMSwitchBtn.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(159265);
                if (MMSwitchBtn.b(MMSwitchBtn.this) != null) {
                  MMSwitchBtn.b(MMSwitchBtn.this).onStatusChange(MMSwitchBtn.a(MMSwitchBtn.this));
                }
                AppMethodBeat.o(159265);
              }
            });
            MMSwitchBtn.c(MMSwitchBtn.this);
            AppMethodBeat.o(159266);
            return;
            bool1 = false;
            break;
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      AppMethodBeat.o(159267);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(159268);
      if (this.direction == 0) {}
      for (MMSwitchBtn.d(MMSwitchBtn.this).left = (this.cxD - (float)this.afUc * paramFloat);; MMSwitchBtn.d(MMSwitchBtn.this).left = (this.cxD + (float)this.afUc * paramFloat))
      {
        MMSwitchBtn.e(MMSwitchBtn.this);
        MMSwitchBtn.this.invalidate();
        AppMethodBeat.o(159268);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn
 * JD-Core Version:    0.7.0.1
 */