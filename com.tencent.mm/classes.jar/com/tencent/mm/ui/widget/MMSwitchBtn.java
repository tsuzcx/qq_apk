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
import com.tencent.mm.cl.a.a;
import com.tencent.mm.ui.ao;

public class MMSwitchBtn
  extends View
{
  private int JaA;
  private int JaB;
  private int JaC;
  private int JaD;
  public boolean JaE;
  private RectF JaF;
  private RectF JaG;
  private int JaH;
  private int JaI;
  private int JaJ;
  private String JaK;
  private String JaL;
  private b JaM;
  private a JaN;
  private long Jas;
  private int Jat;
  private int Jau;
  private int Jav;
  private boolean Jaw;
  private boolean Jax;
  private float Jay;
  private float Jaz;
  private int edgePadding;
  private int maxHeight;
  private int maxWidth;
  private Paint owg;
  private int qc;
  private float ziA;
  private float ziz;
  
  public MMSwitchBtn(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159271);
    this.Jaw = false;
    this.Jax = false;
    this.JaE = false;
    this.owg = new Paint(1);
    this.JaF = new RectF();
    this.JaG = new RectF();
    this.JaM = new b((byte)0);
    init();
    AppMethodBeat.o(159271);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159270);
    this.Jaw = false;
    this.Jax = false;
    this.JaE = false;
    this.owg = new Paint(1);
    this.JaF = new RectF();
    this.JaG = new RectF();
    this.JaM = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(159270);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159269);
    this.Jaw = false;
    this.Jax = false;
    this.JaE = false;
    this.owg = new Paint(1);
    this.JaF = new RectF();
    this.JaG = new RectF();
    this.JaM = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(159269);
  }
  
  private void d(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(159273);
    this.JaI = paramTypedArray.getColor(2, this.JaC);
    this.JaH = paramTypedArray.getColor(0, this.JaB);
    this.JaJ = paramTypedArray.getColor(4, this.JaA);
    this.JaK = paramTypedArray.getString(3);
    this.JaL = paramTypedArray.getString(1);
    paramTypedArray.recycle();
    AppMethodBeat.o(159273);
  }
  
  private void fuJ()
  {
    if (this.Jav < this.maxHeight) {
      this.JaG.top = ((this.maxHeight - this.Jav) / 2 + this.edgePadding);
    }
    for (this.JaG.bottom = (this.JaG.top + this.Jav - this.edgePadding * 2); this.JaE; this.JaG.bottom = (this.maxHeight - this.edgePadding))
    {
      this.JaG.left = (this.Jau + this.edgePadding);
      this.JaG.right = (this.maxWidth - this.edgePadding);
      return;
      this.JaG.top = this.edgePadding;
    }
    this.JaG.left = this.edgePadding;
    this.JaG.right = ((int)(this.Jaz * 2.0F) + this.edgePadding);
  }
  
  private void fuK()
  {
    if (this.JaG.left < this.edgePadding) {
      this.JaG.left = this.edgePadding;
    }
    if (this.JaG.left > this.Jau + this.edgePadding) {
      this.JaG.left = (this.Jau + this.edgePadding);
    }
    this.JaG.right = (this.JaG.left + (int)(this.Jaz * 2.0F));
  }
  
  private void fua()
  {
    AppMethodBeat.i(159278);
    if (this.JaG.left > this.Jat)
    {
      xV(true);
      AppMethodBeat.o(159278);
      return;
    }
    xV(false);
    AppMethodBeat.o(159278);
  }
  
  private void init()
  {
    AppMethodBeat.i(159272);
    this.edgePadding = getResources().getDimensionPixelSize(2131165575);
    this.Jay = getResources().getDimensionPixelSize(2131165582);
    this.Jaz = getResources().getDimensionPixelSize(2131165581);
    this.JaA = getResources().getColor(2131099828);
    this.JaB = getResources().getColor(2131101001);
    this.JaC = getResources().getColor(2131101002);
    this.JaD = getResources().getColor(2131100022);
    this.JaI = this.JaC;
    this.JaH = this.JaB;
    this.JaJ = this.JaA;
    this.qc = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(159272);
  }
  
  private void ki(boolean paramBoolean)
  {
    AppMethodBeat.i(159277);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(159277);
  }
  
  private void xV(boolean paramBoolean)
  {
    AppMethodBeat.i(159276);
    this.Jaw = true;
    this.JaM.reset();
    if (paramBoolean) {
      this.JaM.JaO = (this.Jau - this.JaG.left + this.edgePadding);
    }
    for (this.JaM.direction = 1;; this.JaM.direction = 0)
    {
      this.JaM.km = this.JaG.left;
      this.JaM.setDuration(80L * this.JaM.JaO / this.Jau);
      startAnimation(this.JaM);
      AppMethodBeat.o(159276);
      return;
      this.JaM.JaO = (this.JaG.left);
    }
  }
  
  public final boolean fuI()
  {
    return this.JaE;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159280);
    int i;
    if (!isEnabled())
    {
      i = this.JaD;
      this.owg.setAlpha(38);
    }
    for (;;)
    {
      this.owg.setColor(i);
      paramCanvas.drawRoundRect(this.JaF, this.Jay, this.Jay, this.owg);
      this.owg.setColor(this.JaI);
      this.owg.setAlpha(Math.min(255, (int)((this.JaG.left - this.edgePadding) / this.Jau * 255.0F)));
      paramCanvas.drawRoundRect(this.JaF, this.Jay, this.Jay, this.owg);
      this.owg.setColor(this.JaJ);
      paramCanvas.drawRoundRect(this.JaG, this.Jaz, this.Jaz, this.owg);
      if ((this.JaK != null) && (this.JaL != null))
      {
        Paint localPaint = new Paint();
        localPaint.setTextSize(getResources().getDimension(2131165569));
        localPaint.setTextAlign(Paint.Align.CENTER);
        localPaint.setColor(getResources().getColor(2131101182));
        localPaint.setAntiAlias(true);
        i = Math.min(255, (int)((this.JaG.left - this.edgePadding) / this.Jau * 255.0F));
        Rect localRect = new Rect();
        localPaint.getTextBounds(this.JaK, 0, this.JaK.length(), localRect);
        localPaint.setAlpha(i);
        float f2 = (this.JaF.left + this.JaF.right) / 2.0F;
        float f3 = this.Jaz;
        float f4 = ao.fromDPToPix(getContext(), 1);
        float f1 = (this.JaF.top + this.JaF.bottom) / 2.0F;
        f1 = localRect.height() / 2.0F + f1 - ao.fromDPToPix(getContext(), 1);
        paramCanvas.drawText(this.JaK, f2 - f3 + f4, f1, localPaint);
        f2 = (this.JaF.left + this.JaF.right) / 2.0F;
        f3 = this.Jaz;
        f4 = ao.fromDPToPix(getContext(), 1);
        localPaint.setAlpha(255 - i);
        paramCanvas.drawText(this.JaL, f2 + f3 - f4, f1, localPaint);
      }
      AppMethodBeat.o(159280);
      return;
      i = this.JaH;
      this.owg.setAlpha(255);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159275);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.maxWidth = (paramInt3 - paramInt1);
    this.maxHeight = (paramInt4 - paramInt2);
    this.Jau = (this.maxWidth - (int)(this.Jaz * 2.0F) - this.edgePadding * 2);
    this.Jat = (this.Jau / 2);
    this.Jav = getResources().getDimensionPixelSize(2131165580);
    if (this.Jav < this.maxHeight) {
      this.JaF.top = ((this.maxHeight - this.Jav) / 2);
    }
    for (this.JaF.bottom = (this.JaF.top + this.Jav);; this.JaF.bottom = this.maxHeight)
    {
      this.JaF.left = 0.0F;
      this.JaF.right = this.maxWidth;
      fuJ();
      this.owg.setStyle(Paint.Style.FILL);
      this.owg.setColor(this.JaB);
      AppMethodBeat.o(159275);
      return;
      this.JaF.top = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(159279);
    if (this.Jaw)
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
      if (this.Jax) {
        invalidate();
      }
      AppMethodBeat.o(159279);
      return true;
      clearAnimation();
      this.ziz = paramMotionEvent.getX();
      this.ziA = paramMotionEvent.getY();
      this.Jas = SystemClock.elapsedRealtime();
      this.Jax = false;
      continue;
      float f1;
      float f2;
      if (this.Jax)
      {
        ki(true);
        f1 = paramMotionEvent.getX();
        f2 = this.ziz;
        RectF localRectF = this.JaG;
        localRectF.left = (f1 - f2 + localRectF.left);
        fuK();
      }
      for (;;)
      {
        this.ziz = paramMotionEvent.getX();
        this.ziA = paramMotionEvent.getY();
        break;
        float f3 = paramMotionEvent.getX() - this.ziz;
        f2 = paramMotionEvent.getY() - this.ziA;
        int i = j;
        if (Math.abs(f3) >= this.qc / 10.0F)
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
          this.Jax = true;
          ki(true);
        }
      }
      boolean bool;
      if (SystemClock.elapsedRealtime() - this.Jas < 300L) {
        if (!this.JaE)
        {
          bool = true;
          label308:
          xV(bool);
        }
      }
      for (;;)
      {
        ki(false);
        this.Jax = false;
        break;
        bool = false;
        break label308;
        fua();
      }
      if (this.Jax) {
        fua();
      }
      ki(false);
      this.Jax = false;
    }
  }
  
  public void setCheck(boolean paramBoolean)
  {
    AppMethodBeat.i(159274);
    if (this.JaE != paramBoolean)
    {
      clearAnimation();
      this.JaE = paramBoolean;
      fuJ();
      this.Jaw = false;
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
    this.JaN = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onStatusChange(boolean paramBoolean);
  }
  
  final class b
    extends Animation
  {
    long JaO;
    int direction;
    float km;
    
    private b()
    {
      AppMethodBeat.i(159267);
      this.direction = 0;
      this.km = 0.0F;
      this.JaO = 0L;
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
      for (MMSwitchBtn.d(MMSwitchBtn.this).left = (this.km - (float)this.JaO * paramFloat);; MMSwitchBtn.d(MMSwitchBtn.this).left = (this.km + (float)this.JaO * paramFloat))
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