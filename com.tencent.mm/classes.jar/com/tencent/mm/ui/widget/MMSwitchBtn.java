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
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.ui.ao;

public class MMSwitchBtn
  extends View
{
  private boolean HAa;
  private float HAb;
  private float HAc;
  private int HAd;
  private int HAe;
  private int HAf;
  private int HAg;
  public boolean HAh;
  private RectF HAi;
  private RectF HAj;
  private int HAk;
  private int HAl;
  private int HAm;
  private String HAn;
  private String HAo;
  private b HAp;
  private a HAq;
  private long HzV;
  private int HzW;
  private int HzX;
  private int HzY;
  private boolean HzZ;
  private int edgePadding;
  private int maxHeight;
  private int maxWidth;
  private Paint nSL;
  private int pd;
  private float xVD;
  private float xVE;
  
  public MMSwitchBtn(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159271);
    this.HzZ = false;
    this.HAa = false;
    this.HAh = false;
    this.nSL = new Paint(1);
    this.HAi = new RectF();
    this.HAj = new RectF();
    this.HAp = new b((byte)0);
    init();
    AppMethodBeat.o(159271);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159270);
    this.HzZ = false;
    this.HAa = false;
    this.HAh = false;
    this.nSL = new Paint(1);
    this.HAi = new RectF();
    this.HAj = new RectF();
    this.HAp = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(159270);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159269);
    this.HzZ = false;
    this.HAa = false;
    this.HAh = false;
    this.nSL = new Paint(1);
    this.HAi = new RectF();
    this.HAj = new RectF();
    this.HAp = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(159269);
  }
  
  private void d(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(159273);
    this.HAl = paramTypedArray.getColor(2, this.HAf);
    this.HAk = paramTypedArray.getColor(0, this.HAe);
    this.HAm = paramTypedArray.getColor(4, this.HAd);
    this.HAn = paramTypedArray.getString(3);
    this.HAo = paramTypedArray.getString(1);
    paramTypedArray.recycle();
    AppMethodBeat.o(159273);
  }
  
  private void feO()
  {
    if (this.HzY < this.maxHeight) {
      this.HAj.top = ((this.maxHeight - this.HzY) / 2 + this.edgePadding);
    }
    for (this.HAj.bottom = (this.HAj.top + this.HzY - this.edgePadding * 2); this.HAh; this.HAj.bottom = (this.maxHeight - this.edgePadding))
    {
      this.HAj.left = (this.HzX + this.edgePadding);
      this.HAj.right = (this.maxWidth - this.edgePadding);
      return;
      this.HAj.top = this.edgePadding;
    }
    this.HAj.left = this.edgePadding;
    this.HAj.right = ((int)(this.HAc * 2.0F) + this.edgePadding);
  }
  
  private void feP()
  {
    if (this.HAj.left < this.edgePadding) {
      this.HAj.left = this.edgePadding;
    }
    if (this.HAj.left > this.HzX + this.edgePadding) {
      this.HAj.left = (this.HzX + this.edgePadding);
    }
    this.HAj.right = (this.HAj.left + (int)(this.HAc * 2.0F));
  }
  
  private void fef()
  {
    AppMethodBeat.i(159278);
    if (this.HAj.left > this.HzW)
    {
      wO(true);
      AppMethodBeat.o(159278);
      return;
    }
    wO(false);
    AppMethodBeat.o(159278);
  }
  
  private void init()
  {
    AppMethodBeat.i(159272);
    this.edgePadding = getResources().getDimensionPixelSize(2131165575);
    this.HAb = getResources().getDimensionPixelSize(2131165582);
    this.HAc = getResources().getDimensionPixelSize(2131165581);
    this.HAd = getResources().getColor(2131099828);
    this.HAe = getResources().getColor(2131101001);
    this.HAf = getResources().getColor(2131101002);
    this.HAg = getResources().getColor(2131100022);
    this.HAl = this.HAf;
    this.HAk = this.HAe;
    this.HAm = this.HAd;
    this.pd = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(159272);
  }
  
  private void jF(boolean paramBoolean)
  {
    AppMethodBeat.i(159277);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(159277);
  }
  
  private void wO(boolean paramBoolean)
  {
    AppMethodBeat.i(159276);
    this.HzZ = true;
    this.HAp.reset();
    if (paramBoolean) {
      this.HAp.HAr = (this.HzX - this.HAj.left + this.edgePadding);
    }
    for (this.HAp.direction = 1;; this.HAp.direction = 0)
    {
      this.HAp.jn = this.HAj.left;
      this.HAp.setDuration(80L * this.HAp.HAr / this.HzX);
      startAnimation(this.HAp);
      AppMethodBeat.o(159276);
      return;
      this.HAp.HAr = (this.HAj.left);
    }
  }
  
  public final boolean feN()
  {
    return this.HAh;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159280);
    int i;
    if (!isEnabled())
    {
      i = this.HAg;
      this.nSL.setAlpha(38);
    }
    for (;;)
    {
      this.nSL.setColor(i);
      paramCanvas.drawRoundRect(this.HAi, this.HAb, this.HAb, this.nSL);
      this.nSL.setColor(this.HAl);
      this.nSL.setAlpha(Math.min(255, (int)((this.HAj.left - this.edgePadding) / this.HzX * 255.0F)));
      paramCanvas.drawRoundRect(this.HAi, this.HAb, this.HAb, this.nSL);
      this.nSL.setColor(this.HAm);
      paramCanvas.drawRoundRect(this.HAj, this.HAc, this.HAc, this.nSL);
      if ((this.HAn != null) && (this.HAo != null))
      {
        Paint localPaint = new Paint();
        localPaint.setTextSize(getResources().getDimension(2131165569));
        localPaint.setTextAlign(Paint.Align.CENTER);
        localPaint.setColor(getResources().getColor(2131101182));
        localPaint.setAntiAlias(true);
        i = Math.min(255, (int)((this.HAj.left - this.edgePadding) / this.HzX * 255.0F));
        Rect localRect = new Rect();
        localPaint.getTextBounds(this.HAn, 0, this.HAn.length(), localRect);
        localPaint.setAlpha(i);
        float f2 = (this.HAi.left + this.HAi.right) / 2.0F;
        float f3 = this.HAc;
        float f4 = ao.fromDPToPix(getContext(), 1);
        float f1 = (this.HAi.top + this.HAi.bottom) / 2.0F;
        f1 = localRect.height() / 2.0F + f1 - ao.fromDPToPix(getContext(), 1);
        paramCanvas.drawText(this.HAn, f2 - f3 + f4, f1, localPaint);
        f2 = (this.HAi.left + this.HAi.right) / 2.0F;
        f3 = this.HAc;
        f4 = ao.fromDPToPix(getContext(), 1);
        localPaint.setAlpha(255 - i);
        paramCanvas.drawText(this.HAo, f2 + f3 - f4, f1, localPaint);
      }
      AppMethodBeat.o(159280);
      return;
      i = this.HAk;
      this.nSL.setAlpha(255);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159275);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.maxWidth = (paramInt3 - paramInt1);
    this.maxHeight = (paramInt4 - paramInt2);
    this.HzX = (this.maxWidth - (int)(this.HAc * 2.0F) - this.edgePadding * 2);
    this.HzW = (this.HzX / 2);
    this.HzY = getResources().getDimensionPixelSize(2131165580);
    if (this.HzY < this.maxHeight) {
      this.HAi.top = ((this.maxHeight - this.HzY) / 2);
    }
    for (this.HAi.bottom = (this.HAi.top + this.HzY);; this.HAi.bottom = this.maxHeight)
    {
      this.HAi.left = 0.0F;
      this.HAi.right = this.maxWidth;
      feO();
      this.nSL.setStyle(Paint.Style.FILL);
      this.nSL.setColor(this.HAe);
      AppMethodBeat.o(159275);
      return;
      this.HAi.top = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(159279);
    if (this.HzZ)
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
      if (this.HAa) {
        invalidate();
      }
      AppMethodBeat.o(159279);
      return true;
      clearAnimation();
      this.xVD = paramMotionEvent.getX();
      this.xVE = paramMotionEvent.getY();
      this.HzV = SystemClock.elapsedRealtime();
      this.HAa = false;
      continue;
      float f1;
      float f2;
      if (this.HAa)
      {
        jF(true);
        f1 = paramMotionEvent.getX();
        f2 = this.xVD;
        RectF localRectF = this.HAj;
        localRectF.left = (f1 - f2 + localRectF.left);
        feP();
      }
      for (;;)
      {
        this.xVD = paramMotionEvent.getX();
        this.xVE = paramMotionEvent.getY();
        break;
        float f3 = paramMotionEvent.getX() - this.xVD;
        f2 = paramMotionEvent.getY() - this.xVE;
        int i = j;
        if (Math.abs(f3) >= this.pd / 10.0F)
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
          this.HAa = true;
          jF(true);
        }
      }
      boolean bool;
      if (SystemClock.elapsedRealtime() - this.HzV < 300L) {
        if (!this.HAh)
        {
          bool = true;
          label308:
          wO(bool);
        }
      }
      for (;;)
      {
        jF(false);
        this.HAa = false;
        break;
        bool = false;
        break label308;
        fef();
      }
      if (this.HAa) {
        fef();
      }
      jF(false);
      this.HAa = false;
    }
  }
  
  public void setCheck(boolean paramBoolean)
  {
    AppMethodBeat.i(159274);
    if (this.HAh != paramBoolean)
    {
      clearAnimation();
      this.HAh = paramBoolean;
      feO();
      this.HzZ = false;
      invalidate();
    }
    if (paramBoolean) {}
    for (String str = getContext().getString(2131764330);; str = getContext().getString(2131764341))
    {
      setContentDescription(str);
      AppMethodBeat.o(159274);
      return;
    }
  }
  
  public void setSwitchListener(a parama)
  {
    this.HAq = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onStatusChange(boolean paramBoolean);
  }
  
  final class b
    extends Animation
  {
    long HAr;
    int direction;
    float jn;
    
    private b()
    {
      AppMethodBeat.i(159267);
      this.direction = 0;
      this.jn = 0.0F;
      this.HAr = 0L;
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
      for (MMSwitchBtn.d(MMSwitchBtn.this).left = (this.jn - (float)this.HAr * paramFloat);; MMSwitchBtn.d(MMSwitchBtn.this).left = (this.jn + (float)this.HAr * paramFloat))
      {
        MMSwitchBtn.e(MMSwitchBtn.this);
        MMSwitchBtn.this.invalidate();
        AppMethodBeat.o(159268);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn
 * JD-Core Version:    0.7.0.1
 */