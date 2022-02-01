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
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ui.aq;

public class MMSwitchBtn
  extends View
{
  private float ARU;
  private float ARV;
  private long Lob;
  private int Loc;
  private int Lod;
  private int Loe;
  private boolean Lof;
  private boolean Log;
  private float Loh;
  private float Loi;
  private int Loj;
  private int Lok;
  private int Lol;
  private int Lom;
  public boolean Lon;
  private RectF Loo;
  private RectF Lop;
  private int Loq;
  private int Lor;
  private int Los;
  private String Lot;
  private String Lou;
  private b Lov;
  private a Low;
  private int edgePadding;
  private int maxHeight;
  private int maxWidth;
  private Paint pgf;
  private int rW;
  
  public MMSwitchBtn(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159271);
    this.Lof = false;
    this.Log = false;
    this.Lon = false;
    this.pgf = new Paint(1);
    this.Loo = new RectF();
    this.Lop = new RectF();
    this.Lov = new b((byte)0);
    init();
    AppMethodBeat.o(159271);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159270);
    this.Lof = false;
    this.Log = false;
    this.Lon = false;
    this.pgf = new Paint(1);
    this.Loo = new RectF();
    this.Lop = new RectF();
    this.Lov = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(159270);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159269);
    this.Lof = false;
    this.Log = false;
    this.Lon = false;
    this.pgf = new Paint(1);
    this.Loo = new RectF();
    this.Lop = new RectF();
    this.Lov = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(159269);
  }
  
  private void d(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(159273);
    this.Lor = paramTypedArray.getColor(2, this.Lol);
    this.Loq = paramTypedArray.getColor(0, this.Lok);
    this.Los = paramTypedArray.getColor(4, this.Loj);
    this.Lot = paramTypedArray.getString(3);
    this.Lou = paramTypedArray.getString(1);
    paramTypedArray.recycle();
    AppMethodBeat.o(159273);
  }
  
  private void fPQ()
  {
    if (this.Loe < this.maxHeight) {
      this.Lop.top = ((this.maxHeight - this.Loe) / 2 + this.edgePadding);
    }
    for (this.Lop.bottom = (this.Lop.top + this.Loe - this.edgePadding * 2); this.Lon; this.Lop.bottom = (this.maxHeight - this.edgePadding))
    {
      this.Lop.left = (this.Lod + this.edgePadding);
      this.Lop.right = (this.maxWidth - this.edgePadding);
      return;
      this.Lop.top = this.edgePadding;
    }
    this.Lop.left = this.edgePadding;
    this.Lop.right = ((int)(this.Loi * 2.0F) + this.edgePadding);
  }
  
  private void fPR()
  {
    if (this.Lop.left < this.edgePadding) {
      this.Lop.left = this.edgePadding;
    }
    if (this.Lop.left > this.Lod + this.edgePadding) {
      this.Lop.left = (this.Lod + this.edgePadding);
    }
    this.Lop.right = (this.Lop.left + (int)(this.Loi * 2.0F));
  }
  
  private void fPg()
  {
    AppMethodBeat.i(159278);
    if (this.Lop.left > this.Loc)
    {
      yX(true);
      AppMethodBeat.o(159278);
      return;
    }
    yX(false);
    AppMethodBeat.o(159278);
  }
  
  private void init()
  {
    AppMethodBeat.i(159272);
    this.edgePadding = getResources().getDimensionPixelSize(2131165575);
    this.Loh = getResources().getDimensionPixelSize(2131165582);
    this.Loi = getResources().getDimensionPixelSize(2131165581);
    this.Loj = getResources().getColor(2131099828);
    this.Lok = getResources().getColor(2131101001);
    this.Lol = getResources().getColor(2131101002);
    this.Lom = getResources().getColor(2131100022);
    this.Lor = this.Lol;
    this.Loq = this.Lok;
    this.Los = this.Loj;
    this.rW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(159272);
  }
  
  private void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(159277);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(159277);
  }
  
  private void yX(boolean paramBoolean)
  {
    AppMethodBeat.i(159276);
    this.Lof = true;
    this.Lov.reset();
    if (paramBoolean) {
      this.Lov.Lox = (this.Lod - this.Lop.left + this.edgePadding);
    }
    for (this.Lov.direction = 1;; this.Lov.direction = 0)
    {
      this.Lov.mc = this.Lop.left;
      this.Lov.setDuration(80L * this.Lov.Lox / this.Lod);
      startAnimation(this.Lov);
      AppMethodBeat.o(159276);
      return;
      this.Lov.Lox = (this.Lop.left);
    }
  }
  
  public final boolean fPP()
  {
    return this.Lon;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159280);
    int i;
    if (!isEnabled())
    {
      i = this.Lom;
      this.pgf.setAlpha(38);
    }
    for (;;)
    {
      this.pgf.setColor(i);
      paramCanvas.drawRoundRect(this.Loo, this.Loh, this.Loh, this.pgf);
      this.pgf.setColor(this.Lor);
      this.pgf.setAlpha(Math.min(255, (int)((this.Lop.left - this.edgePadding) / this.Lod * 255.0F)));
      paramCanvas.drawRoundRect(this.Loo, this.Loh, this.Loh, this.pgf);
      this.pgf.setColor(this.Los);
      paramCanvas.drawRoundRect(this.Lop, this.Loi, this.Loi, this.pgf);
      if ((this.Lot != null) && (this.Lou != null))
      {
        Paint localPaint = new Paint();
        localPaint.setTextSize(getResources().getDimension(2131165569));
        localPaint.setTextAlign(Paint.Align.CENTER);
        localPaint.setColor(getResources().getColor(2131101182));
        localPaint.setAntiAlias(true);
        i = Math.min(255, (int)((this.Lop.left - this.edgePadding) / this.Lod * 255.0F));
        Rect localRect = new Rect();
        localPaint.getTextBounds(this.Lot, 0, this.Lot.length(), localRect);
        localPaint.setAlpha(i);
        float f2 = (this.Loo.left + this.Loo.right) / 2.0F;
        float f3 = this.Loi;
        float f4 = aq.fromDPToPix(getContext(), 1);
        float f1 = (this.Loo.top + this.Loo.bottom) / 2.0F;
        f1 = localRect.height() / 2.0F + f1 - aq.fromDPToPix(getContext(), 1);
        paramCanvas.drawText(this.Lot, f2 - f3 + f4, f1, localPaint);
        f2 = (this.Loo.left + this.Loo.right) / 2.0F;
        f3 = this.Loi;
        f4 = aq.fromDPToPix(getContext(), 1);
        localPaint.setAlpha(255 - i);
        paramCanvas.drawText(this.Lou, f2 + f3 - f4, f1, localPaint);
      }
      AppMethodBeat.o(159280);
      return;
      i = this.Loq;
      this.pgf.setAlpha(255);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159275);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.maxWidth = (paramInt3 - paramInt1);
    this.maxHeight = (paramInt4 - paramInt2);
    this.Lod = (this.maxWidth - (int)(this.Loi * 2.0F) - this.edgePadding * 2);
    this.Loc = (this.Lod / 2);
    this.Loe = getResources().getDimensionPixelSize(2131165580);
    if (this.Loe < this.maxHeight) {
      this.Loo.top = ((this.maxHeight - this.Loe) / 2);
    }
    for (this.Loo.bottom = (this.Loo.top + this.Loe);; this.Loo.bottom = this.maxHeight)
    {
      this.Loo.left = 0.0F;
      this.Loo.right = this.maxWidth;
      fPQ();
      this.pgf.setStyle(Paint.Style.FILL);
      this.pgf.setColor(this.Lok);
      AppMethodBeat.o(159275);
      return;
      this.Loo.top = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(159279);
    if (this.Lof)
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
      if (this.Log) {
        invalidate();
      }
      AppMethodBeat.o(159279);
      return true;
      clearAnimation();
      this.ARU = paramMotionEvent.getX();
      this.ARV = paramMotionEvent.getY();
      this.Lob = SystemClock.elapsedRealtime();
      this.Log = false;
      continue;
      float f1;
      float f2;
      if (this.Log)
      {
        ks(true);
        f1 = paramMotionEvent.getX();
        f2 = this.ARU;
        RectF localRectF = this.Lop;
        localRectF.left = (f1 - f2 + localRectF.left);
        fPR();
      }
      for (;;)
      {
        this.ARU = paramMotionEvent.getX();
        this.ARV = paramMotionEvent.getY();
        break;
        float f3 = paramMotionEvent.getX() - this.ARU;
        f2 = paramMotionEvent.getY() - this.ARV;
        int i = j;
        if (Math.abs(f3) >= this.rW / 10.0F)
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
          this.Log = true;
          ks(true);
        }
      }
      boolean bool;
      if (SystemClock.elapsedRealtime() - this.Lob < 300L) {
        if (!this.Lon)
        {
          bool = true;
          label308:
          yX(bool);
        }
      }
      for (;;)
      {
        ks(false);
        this.Log = false;
        break;
        bool = false;
        break label308;
        fPg();
      }
      if (this.Log) {
        fPg();
      }
      ks(false);
      this.Log = false;
    }
  }
  
  public void setCheck(boolean paramBoolean)
  {
    AppMethodBeat.i(159274);
    if (this.Lon != paramBoolean)
    {
      clearAnimation();
      this.Lon = paramBoolean;
      fPQ();
      this.Lof = false;
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
    this.Low = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onStatusChange(boolean paramBoolean);
  }
  
  final class b
    extends Animation
  {
    long Lox;
    int direction;
    float mc;
    
    private b()
    {
      AppMethodBeat.i(159267);
      this.direction = 0;
      this.mc = 0.0F;
      this.Lox = 0L;
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
      for (MMSwitchBtn.d(MMSwitchBtn.this).left = (this.mc - (float)this.Lox * paramFloat);; MMSwitchBtn.d(MMSwitchBtn.this).left = (this.mc + (float)this.Lox * paramFloat))
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