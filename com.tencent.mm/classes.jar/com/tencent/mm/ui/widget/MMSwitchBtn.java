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
import com.tencent.mm.ui.at;

public class MMSwitchBtn
  extends View
{
  private float FcB;
  private float FcC;
  private int QDA;
  private int QDB;
  private String QDC;
  private String QDD;
  private b QDE;
  private a QDF;
  private long QDk;
  private int QDl;
  private int QDm;
  private int QDn;
  private boolean QDo;
  private boolean QDp;
  private float QDq;
  private float QDr;
  private int QDs;
  private int QDt;
  private int QDu;
  private int QDv;
  public boolean QDw;
  private RectF QDx;
  private RectF QDy;
  private int QDz;
  private int edgePadding;
  private int maxHeight;
  private int maxWidth;
  private Paint qvj;
  private int rZ;
  
  public MMSwitchBtn(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159271);
    this.QDo = false;
    this.QDp = false;
    this.QDw = false;
    this.qvj = new Paint(1);
    this.QDx = new RectF();
    this.QDy = new RectF();
    this.QDE = new b((byte)0);
    init();
    AppMethodBeat.o(159271);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159270);
    this.QDo = false;
    this.QDp = false;
    this.QDw = false;
    this.qvj = new Paint(1);
    this.QDx = new RectF();
    this.QDy = new RectF();
    this.QDE = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(159270);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159269);
    this.QDo = false;
    this.QDp = false;
    this.QDw = false;
    this.qvj = new Paint(1);
    this.QDx = new RectF();
    this.QDy = new RectF();
    this.QDE = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMSwitchBtn));
    AppMethodBeat.o(159269);
  }
  
  private void CT(boolean paramBoolean)
  {
    AppMethodBeat.i(159276);
    this.QDo = true;
    this.QDE.reset();
    if (paramBoolean) {
      this.QDE.QDG = (this.QDm - this.QDy.left + this.edgePadding);
    }
    for (this.QDE.direction = 1;; this.QDE.direction = 0)
    {
      this.QDE.me = this.QDy.left;
      this.QDE.setDuration(80L * this.QDE.QDG / this.QDm);
      startAnimation(this.QDE);
      AppMethodBeat.o(159276);
      return;
      this.QDE.QDG = (this.QDy.left);
    }
  }
  
  private void d(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(159273);
    this.QDA = paramTypedArray.getColor(2, this.QDu);
    this.QDz = paramTypedArray.getColor(0, this.QDt);
    this.QDB = paramTypedArray.getColor(4, this.QDs);
    this.QDC = paramTypedArray.getString(3);
    this.QDD = paramTypedArray.getString(1);
    paramTypedArray.recycle();
    AppMethodBeat.o(159273);
  }
  
  private void gYS()
  {
    if (this.QDn < this.maxHeight) {
      this.QDy.top = ((this.maxHeight - this.QDn) / 2 + this.edgePadding);
    }
    for (this.QDy.bottom = (this.QDy.top + this.QDn - this.edgePadding * 2); this.QDw; this.QDy.bottom = (this.maxHeight - this.edgePadding))
    {
      this.QDy.left = (this.QDm + this.edgePadding);
      this.QDy.right = (this.maxWidth - this.edgePadding);
      return;
      this.QDy.top = this.edgePadding;
    }
    this.QDy.left = this.edgePadding;
    this.QDy.right = ((int)(this.QDr * 2.0F) + this.edgePadding);
  }
  
  private void gYT()
  {
    if (this.QDy.left < this.edgePadding) {
      this.QDy.left = this.edgePadding;
    }
    if (this.QDy.left > this.QDm + this.edgePadding) {
      this.QDy.left = (this.QDm + this.edgePadding);
    }
    this.QDy.right = (this.QDy.left + (int)(this.QDr * 2.0F));
  }
  
  private void gYa()
  {
    AppMethodBeat.i(159278);
    if (this.QDy.left > this.QDl)
    {
      CT(true);
      AppMethodBeat.o(159278);
      return;
    }
    CT(false);
    AppMethodBeat.o(159278);
  }
  
  private void init()
  {
    AppMethodBeat.i(159272);
    this.edgePadding = getResources().getDimensionPixelSize(2131165593);
    this.QDq = getResources().getDimensionPixelSize(2131165600);
    this.QDr = getResources().getDimensionPixelSize(2131165599);
    this.QDs = getResources().getColor(2131099844);
    this.QDt = getResources().getColor(2131101231);
    this.QDu = getResources().getColor(2131101232);
    this.QDv = getResources().getColor(2131100048);
    this.QDA = this.QDu;
    this.QDz = this.QDt;
    this.QDB = this.QDs;
    this.rZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(159272);
  }
  
  private void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(159277);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(159277);
  }
  
  public final boolean isCheck()
  {
    return this.QDw;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159280);
    int i;
    if (!isEnabled())
    {
      i = this.QDv;
      this.qvj.setAlpha(38);
    }
    for (;;)
    {
      this.qvj.setColor(i);
      paramCanvas.drawRoundRect(this.QDx, this.QDq, this.QDq, this.qvj);
      this.qvj.setColor(this.QDA);
      this.qvj.setAlpha(Math.min(255, (int)((this.QDy.left - this.edgePadding) / this.QDm * 255.0F)));
      paramCanvas.drawRoundRect(this.QDx, this.QDq, this.QDq, this.qvj);
      this.qvj.setColor(this.QDB);
      paramCanvas.drawRoundRect(this.QDy, this.QDr, this.QDr, this.qvj);
      if ((this.QDC != null) && (this.QDD != null))
      {
        Paint localPaint = new Paint();
        localPaint.setTextSize(getResources().getDimension(2131165587));
        localPaint.setTextAlign(Paint.Align.CENTER);
        localPaint.setColor(getResources().getColor(2131101427));
        localPaint.setAntiAlias(true);
        i = Math.min(255, (int)((this.QDy.left - this.edgePadding) / this.QDm * 255.0F));
        Rect localRect = new Rect();
        localPaint.getTextBounds(this.QDC, 0, this.QDC.length(), localRect);
        localPaint.setAlpha(i);
        float f2 = (this.QDx.left + this.QDx.right) / 2.0F;
        float f3 = this.QDr;
        float f4 = at.fromDPToPix(getContext(), 1);
        float f1 = (this.QDx.top + this.QDx.bottom) / 2.0F;
        f1 = localRect.height() / 2.0F + f1 - at.fromDPToPix(getContext(), 1);
        paramCanvas.drawText(this.QDC, f2 - f3 + f4, f1, localPaint);
        f2 = (this.QDx.left + this.QDx.right) / 2.0F;
        f3 = this.QDr;
        f4 = at.fromDPToPix(getContext(), 1);
        localPaint.setAlpha(255 - i);
        paramCanvas.drawText(this.QDD, f2 + f3 - f4, f1, localPaint);
      }
      AppMethodBeat.o(159280);
      return;
      i = this.QDz;
      this.qvj.setAlpha(255);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159275);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.maxWidth = (paramInt3 - paramInt1);
    this.maxHeight = (paramInt4 - paramInt2);
    this.QDm = (this.maxWidth - (int)(this.QDr * 2.0F) - this.edgePadding * 2);
    this.QDl = (this.QDm / 2);
    this.QDn = getResources().getDimensionPixelSize(2131165598);
    if (this.QDn < this.maxHeight) {
      this.QDx.top = ((this.maxHeight - this.QDn) / 2);
    }
    for (this.QDx.bottom = (this.QDx.top + this.QDn);; this.QDx.bottom = this.maxHeight)
    {
      this.QDx.left = 0.0F;
      this.QDx.right = this.maxWidth;
      gYS();
      this.qvj.setStyle(Paint.Style.FILL);
      this.qvj.setColor(this.QDt);
      AppMethodBeat.o(159275);
      return;
      this.QDx.top = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(159279);
    if (this.QDo)
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
      if (this.QDp) {
        invalidate();
      }
      AppMethodBeat.o(159279);
      return true;
      clearAnimation();
      this.FcB = paramMotionEvent.getX();
      this.FcC = paramMotionEvent.getY();
      this.QDk = SystemClock.elapsedRealtime();
      this.QDp = false;
      continue;
      float f1;
      float f2;
      if (this.QDp)
      {
        lu(true);
        f1 = paramMotionEvent.getX();
        f2 = this.FcB;
        RectF localRectF = this.QDy;
        localRectF.left = (f1 - f2 + localRectF.left);
        gYT();
      }
      for (;;)
      {
        this.FcB = paramMotionEvent.getX();
        this.FcC = paramMotionEvent.getY();
        break;
        float f3 = paramMotionEvent.getX() - this.FcB;
        f2 = paramMotionEvent.getY() - this.FcC;
        int i = j;
        if (Math.abs(f3) >= this.rZ / 10.0F)
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
          this.QDp = true;
          lu(true);
        }
      }
      boolean bool;
      if (SystemClock.elapsedRealtime() - this.QDk < 300L) {
        if (!this.QDw)
        {
          bool = true;
          label308:
          CT(bool);
        }
      }
      for (;;)
      {
        lu(false);
        this.QDp = false;
        break;
        bool = false;
        break label308;
        gYa();
      }
      if (this.QDp) {
        gYa();
      }
      lu(false);
      this.QDp = false;
    }
  }
  
  public void setCheck(boolean paramBoolean)
  {
    AppMethodBeat.i(159274);
    if (this.QDw != paramBoolean)
    {
      clearAnimation();
      this.QDw = paramBoolean;
      gYS();
      this.QDo = false;
      invalidate();
    }
    if (paramBoolean) {}
    for (String str = getContext().getString(2131766589);; str = getContext().getString(2131766600))
    {
      setContentDescription(str);
      AppMethodBeat.o(159274);
      return;
    }
  }
  
  public void setSwitchListener(a parama)
  {
    this.QDF = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onStatusChange(boolean paramBoolean);
  }
  
  final class b
    extends Animation
  {
    long QDG;
    int direction;
    float me;
    
    private b()
    {
      AppMethodBeat.i(159267);
      this.direction = 0;
      this.me = 0.0F;
      this.QDG = 0L;
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
      for (MMSwitchBtn.d(MMSwitchBtn.this).left = (this.me - (float)this.QDG * paramFloat);; MMSwitchBtn.d(MMSwitchBtn.this).left = (this.me + (float)this.QDG * paramFloat))
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