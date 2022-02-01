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
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.i;
import com.tencent.mm.cr.a.k;
import com.tencent.mm.ui.aw;

public class MMSwitchBtn
  extends View
{
  private RectF DAS;
  private float Grh;
  private float Gri;
  private long YbN;
  private int YbO;
  private int YbP;
  private int YbQ;
  private boolean YbR;
  private boolean YbS;
  private float YbT;
  private float YbU;
  private int YbV;
  private int YbW;
  private int YbX;
  private int YbY;
  public boolean YbZ;
  private RectF Yca;
  private int Ycb;
  private int Ycc;
  private int Ycd;
  private String Yce;
  private String Ycf;
  private b Ycg;
  private a Ych;
  private int bvH;
  private int edgePadding;
  private int maxHeight;
  private int maxWidth;
  private Paint tUe;
  
  public MMSwitchBtn(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159271);
    this.YbR = false;
    this.YbS = false;
    this.YbZ = false;
    this.tUe = new Paint(1);
    this.DAS = new RectF();
    this.Yca = new RectF();
    this.Ycg = new b((byte)0);
    init();
    AppMethodBeat.o(159271);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159270);
    this.YbR = false;
    this.YbS = false;
    this.YbZ = false;
    this.tUe = new Paint(1);
    this.DAS = new RectF();
    this.Yca = new RectF();
    this.Ycg = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMSwitchBtn));
    AppMethodBeat.o(159270);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159269);
    this.YbR = false;
    this.YbS = false;
    this.YbZ = false;
    this.tUe = new Paint(1);
    this.DAS = new RectF();
    this.Yca = new RectF();
    this.Ycg = new b((byte)0);
    init();
    d(paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMSwitchBtn));
    AppMethodBeat.o(159269);
  }
  
  private void Hn(boolean paramBoolean)
  {
    AppMethodBeat.i(159276);
    this.YbR = true;
    this.Ycg.reset();
    if (paramBoolean) {
      this.Ycg.Yci = (this.YbP - this.Yca.left + this.edgePadding);
    }
    for (this.Ycg.direction = 1;; this.Ycg.direction = 0)
    {
      this.Ycg.aBO = this.Yca.left;
      this.Ycg.setDuration(80L * this.Ycg.Yci / this.YbP);
      startAnimation(this.Ycg);
      AppMethodBeat.o(159276);
      return;
      this.Ycg.Yci = (this.Yca.left);
    }
  }
  
  private void d(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(159273);
    this.Ycc = paramTypedArray.getColor(a.k.MMSwitchBtn_on_color, this.YbX);
    this.Ycb = paramTypedArray.getColor(a.k.MMSwitchBtn_off_color, this.YbW);
    this.Ycd = paramTypedArray.getColor(a.k.MMSwitchBtn_slide_color, this.YbV);
    this.Yce = paramTypedArray.getString(a.k.MMSwitchBtn_on_text);
    this.Ycf = paramTypedArray.getString(a.k.MMSwitchBtn_off_text);
    paramTypedArray.recycle();
    AppMethodBeat.o(159273);
  }
  
  private void hYL()
  {
    AppMethodBeat.i(159278);
    if (this.Yca.left > this.YbO)
    {
      Hn(true);
      AppMethodBeat.o(159278);
      return;
    }
    Hn(false);
    AppMethodBeat.o(159278);
  }
  
  private void hZJ()
  {
    if (this.YbQ < this.maxHeight) {
      this.Yca.top = ((this.maxHeight - this.YbQ) / 2 + this.edgePadding);
    }
    for (this.Yca.bottom = (this.Yca.top + this.YbQ - this.edgePadding * 2); this.YbZ; this.Yca.bottom = (this.maxHeight - this.edgePadding))
    {
      this.Yca.left = (this.YbP + this.edgePadding);
      this.Yca.right = (this.maxWidth - this.edgePadding);
      return;
      this.Yca.top = this.edgePadding;
    }
    this.Yca.left = this.edgePadding;
    this.Yca.right = ((int)(this.YbU * 2.0F) + this.edgePadding);
  }
  
  private void hZK()
  {
    if (this.Yca.left < this.edgePadding) {
      this.Yca.left = this.edgePadding;
    }
    if (this.Yca.left > this.YbP + this.edgePadding) {
      this.Yca.left = (this.YbP + this.edgePadding);
    }
    this.Yca.right = (this.Yca.left + (int)(this.YbU * 2.0F));
  }
  
  private void init()
  {
    AppMethodBeat.i(159272);
    this.edgePadding = getResources().getDimensionPixelSize(a.d.SmallestPadding);
    this.YbT = getResources().getDimensionPixelSize(a.d.SwitchBtnRadiusOut);
    this.YbU = getResources().getDimensionPixelSize(a.d.SwitchBtnRadiusIn);
    this.YbV = getResources().getColor(a.c.White);
    this.YbW = getResources().getColor(a.c.switch_btn_off_color);
    this.YbX = getResources().getColor(a.c.switch_btn_on_color);
    this.YbY = getResources().getColor(a.c.black_text_color_disabled);
    this.Ycc = this.YbX;
    this.Ycb = this.YbW;
    this.Ycd = this.YbV;
    this.bvH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(159272);
  }
  
  private void mF(boolean paramBoolean)
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
    return this.YbZ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159280);
    int i;
    if (!isEnabled())
    {
      i = this.YbY;
      this.tUe.setAlpha(38);
    }
    for (;;)
    {
      this.tUe.setColor(i);
      paramCanvas.drawRoundRect(this.DAS, this.YbT, this.YbT, this.tUe);
      this.tUe.setColor(this.Ycc);
      this.tUe.setAlpha(Math.min(255, (int)((this.Yca.left - this.edgePadding) / this.YbP * 255.0F)));
      paramCanvas.drawRoundRect(this.DAS, this.YbT, this.YbT, this.tUe);
      this.tUe.setColor(this.Ycd);
      paramCanvas.drawRoundRect(this.Yca, this.YbU, this.YbU, this.tUe);
      if ((this.Yce != null) && (this.Ycf != null))
      {
        Paint localPaint = new Paint();
        localPaint.setTextSize(getResources().getDimension(a.d.SmallTextSize));
        localPaint.setTextAlign(Paint.Align.CENTER);
        localPaint.setColor(getResources().getColor(a.c.white_text_color));
        localPaint.setAntiAlias(true);
        i = Math.min(255, (int)((this.Yca.left - this.edgePadding) / this.YbP * 255.0F));
        Rect localRect = new Rect();
        localPaint.getTextBounds(this.Yce, 0, this.Yce.length(), localRect);
        localPaint.setAlpha(i);
        float f2 = (this.DAS.left + this.DAS.right) / 2.0F;
        float f3 = this.YbU;
        float f4 = aw.fromDPToPix(getContext(), 1);
        float f1 = (this.DAS.top + this.DAS.bottom) / 2.0F;
        f1 = localRect.height() / 2.0F + f1 - aw.fromDPToPix(getContext(), 1);
        paramCanvas.drawText(this.Yce, f2 - f3 + f4, f1, localPaint);
        f2 = (this.DAS.left + this.DAS.right) / 2.0F;
        f3 = this.YbU;
        f4 = aw.fromDPToPix(getContext(), 1);
        localPaint.setAlpha(255 - i);
        paramCanvas.drawText(this.Ycf, f2 + f3 - f4, f1, localPaint);
      }
      AppMethodBeat.o(159280);
      return;
      i = this.Ycb;
      this.tUe.setAlpha(255);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159275);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.maxWidth = (paramInt3 - paramInt1);
    this.maxHeight = (paramInt4 - paramInt2);
    this.YbP = (this.maxWidth - (int)(this.YbU * 2.0F) - this.edgePadding * 2);
    this.YbO = (this.YbP / 2);
    this.YbQ = getResources().getDimensionPixelSize(a.d.SwitchBtnHeight);
    if (this.YbQ < this.maxHeight) {
      this.DAS.top = ((this.maxHeight - this.YbQ) / 2);
    }
    for (this.DAS.bottom = (this.DAS.top + this.YbQ);; this.DAS.bottom = this.maxHeight)
    {
      this.DAS.left = 0.0F;
      this.DAS.right = this.maxWidth;
      hZJ();
      this.tUe.setStyle(Paint.Style.FILL);
      this.tUe.setColor(this.YbW);
      AppMethodBeat.o(159275);
      return;
      this.DAS.top = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(159279);
    if (this.YbR)
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
      if (this.YbS) {
        invalidate();
      }
      AppMethodBeat.o(159279);
      return true;
      clearAnimation();
      this.Grh = paramMotionEvent.getX();
      this.Gri = paramMotionEvent.getY();
      this.YbN = SystemClock.elapsedRealtime();
      this.YbS = false;
      continue;
      float f1;
      float f2;
      if (this.YbS)
      {
        mF(true);
        f1 = paramMotionEvent.getX();
        f2 = this.Grh;
        RectF localRectF = this.Yca;
        localRectF.left = (f1 - f2 + localRectF.left);
        hZK();
      }
      for (;;)
      {
        this.Grh = paramMotionEvent.getX();
        this.Gri = paramMotionEvent.getY();
        break;
        float f3 = paramMotionEvent.getX() - this.Grh;
        f2 = paramMotionEvent.getY() - this.Gri;
        int i = j;
        if (Math.abs(f3) >= this.bvH / 10.0F)
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
          this.YbS = true;
          mF(true);
        }
      }
      boolean bool;
      if (SystemClock.elapsedRealtime() - this.YbN < 300L) {
        if (!this.YbZ)
        {
          bool = true;
          label308:
          Hn(bool);
        }
      }
      for (;;)
      {
        mF(false);
        this.YbS = false;
        break;
        bool = false;
        break label308;
        hYL();
      }
      if (this.YbS) {
        hYL();
      }
      mF(false);
      this.YbS = false;
    }
  }
  
  public void setCheck(boolean paramBoolean)
  {
    AppMethodBeat.i(159274);
    if (this.YbZ != paramBoolean)
    {
      clearAnimation();
      this.YbZ = paramBoolean;
      hZJ();
      this.YbR = false;
      invalidate();
    }
    if (paramBoolean) {}
    for (String str = getContext().getString(a.i.switch_check_desc);; str = getContext().getString(a.i.switch_uncheck_desc))
    {
      setContentDescription(str);
      AppMethodBeat.o(159274);
      return;
    }
  }
  
  public void setSwitchListener(a parama)
  {
    this.Ych = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onStatusChange(boolean paramBoolean);
  }
  
  final class b
    extends Animation
  {
    long Yci;
    float aBO;
    int direction;
    
    private b()
    {
      AppMethodBeat.i(159267);
      this.direction = 0;
      this.aBO = 0.0F;
      this.Yci = 0L;
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
      for (MMSwitchBtn.d(MMSwitchBtn.this).left = (this.aBO - (float)this.Yci * paramFloat);; MMSwitchBtn.d(MMSwitchBtn.this).left = (this.aBO + (float)this.Yci * paramFloat))
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