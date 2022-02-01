package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class TimeCropSliderSeekBar
  extends View
{
  private a CiV;
  private Paint CiW;
  private Paint CiX;
  private int CiY;
  private int CiZ;
  private boolean Cja;
  private Paint borderPaint;
  private int borderWidth;
  private int padding;
  private View.OnTouchListener tOH;
  private boolean weA;
  private Drawable weB;
  private Drawable weC;
  private int weD;
  private float weE;
  private int weF;
  private float weG;
  private int weH;
  private Paint weI;
  private float weJ;
  private Paint weL;
  private int weM;
  private float weN;
  private float weO;
  private float weP;
  private int weQ;
  private Rect weR;
  private Rect weS;
  private boolean weT;
  private boolean wev;
  private boolean wew;
  private int wex;
  private int wey;
  private boolean wez;
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(191119);
    this.wev = false;
    this.wew = false;
    this.wez = false;
    this.weA = false;
    this.weG = -1.0F;
    this.CiY = 0;
    this.CiZ = 0;
    this.weO = -1.0F;
    this.weP = -1.0F;
    this.padding = 0;
    this.Cja = true;
    this.weT = true;
    this.tOH = new View.OnTouchListener()
    {
      boolean Cjc = false;
      float Cjd;
      float Cje;
      float cNQ;
      float cNR;
      boolean gpa = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(191115);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (!TimeCropSliderSeekBar.h(TimeCropSliderSeekBar.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(191115);
          return false;
        }
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(191115);
          return false;
        case 2: 
          if (!this.gpa)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(191115);
            return false;
          }
          if (this.Cjc)
          {
            float f = paramAnonymousMotionEvent.getX() - this.cNQ;
            if (f > 0.0F)
            {
              f = Math.min(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.Cje + f) - this.Cje, f);
              TimeCropSliderSeekBar.this.b(false, this.Cje + f);
              TimeCropSliderSeekBar.this.b(true, f + this.Cjd);
            }
            for (;;)
            {
              TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).exw();
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(191115);
              return true;
              f = Math.max(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.Cjd + f) - this.Cjd, f);
              TimeCropSliderSeekBar.this.b(true, this.Cjd + f);
              TimeCropSliderSeekBar.this.b(false, f + this.Cje);
            }
          }
          if (TimeCropSliderSeekBar.j(TimeCropSliderSeekBar.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(191115);
            return true;
          }
          boolean bool = TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
          bool = TimeCropSliderSeekBar.this.b(bool, paramAnonymousMotionEvent.getX());
          if ((TimeCropSliderSeekBar.k(TimeCropSliderSeekBar.this)) && (bool) && (!TimeCropSliderSeekBar.l(TimeCropSliderSeekBar.this))) {
            TimeCropSliderSeekBar.this.performHapticFeedback(0, 2);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, bool);
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).exw();
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(191115);
          return true;
        case 1: 
        case 3: 
          if (!this.gpa)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(191115);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null)
          {
            paramAnonymousView = TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
            TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
            paramAnonymousView.dqI();
          }
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true), false);
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, false);
          this.gpa = false;
          this.Cjc = false;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(191115);
          return true;
        }
        this.cNQ = paramAnonymousMotionEvent.getX();
        this.cNR = paramAnonymousMotionEvent.getY();
        this.Cjd = TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().centerX();
        this.Cje = TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().centerX();
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.cNQ, this.cNR))
        {
          this.Cjc = true;
          this.gpa = true;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(191115);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this), this.cNQ, this.cNR))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(191115);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().left);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true, true);
          this.gpa = true;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(191115);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this), this.cNQ, this.cNR))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(191115);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.c(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().right);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false, true);
          this.gpa = true;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(191115);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(191115);
        return false;
      }
    };
    this.weD = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.weE = (this.weD * 0.5F);
    this.weQ = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    this.weB = new b(com.tencent.mm.cb.a.l(getContext(), 2131691359), com.tencent.mm.cb.a.l(getContext(), 2131691358));
    this.weC = new b(com.tencent.mm.cb.a.l(getContext(), 2131691359), com.tencent.mm.cb.a.l(getContext(), 2131691358));
    this.weT = true;
    postInvalidate();
    this.weF = com.tencent.mm.cb.a.fromDPToPix(getContext(), 2);
    this.weH = com.tencent.mm.cb.a.ax(getContext(), 2131166956);
    this.weG = -1.0F;
    this.weI = new Paint();
    this.weI.setColor(com.tencent.mm.cb.a.n(getContext(), 2131099828));
    this.weI.setAlpha(102);
    this.CiW = new Paint();
    this.CiW.setColor(com.tencent.mm.cb.a.n(getContext(), 2131100017));
    this.CiW.setAlpha(102);
    this.CiX = new Paint();
    this.CiX.setColor(com.tencent.mm.cb.a.n(getContext(), 2131099777));
    this.CiX.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(com.tencent.mm.cb.a.n(getContext(), 2131101179));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderWidth = fU(getContext());
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.weJ = (this.borderWidth * 0.5F);
    this.weL = new Paint();
    this.weL.setColor(com.tencent.mm.cb.a.n(getContext(), 2131101179));
    this.weL.setStyle(Paint.Style.STROKE);
    this.weM = fU(getContext());
    this.weN = (this.weM * 0.5F);
    this.weL.setStrokeWidth(this.weM);
    this.weL.setAlpha(178);
    setOnTouchListener(this.tOH);
    AppMethodBeat.o(191119);
  }
  
  private void exv()
  {
    AppMethodBeat.i(191130);
    this.weB.setBounds(this.padding - this.weD / 2, 0, this.padding + this.weD / 2, getHeight());
    this.weC.setBounds(this.padding + this.wex - this.weD / 2, 0, this.wex + this.padding + this.weD / 2, getHeight());
    AppMethodBeat.o(191130);
  }
  
  private static int fU(Context paramContext)
  {
    AppMethodBeat.i(191120);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(191120);
    return i;
  }
  
  private boolean oB(boolean paramBoolean)
  {
    AppMethodBeat.i(191125);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.weB);
      AppMethodBeat.o(191125);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.weC);
    AppMethodBeat.o(191125);
    return paramBoolean;
  }
  
  public final void aj(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(191123);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191114);
        if (paramInt1 <= TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this) * 2)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
          AppMethodBeat.o(191114);
          throw localIllegalStateException;
        }
        TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this);
        TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, paramInt3);
        TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, Math.min(paramInt1, TimeCropSliderSeekBar.this.getWidth() - paramInt3 * 2));
        TimeCropSliderSeekBar.c(TimeCropSliderSeekBar.this, Math.max(paramInt2, TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this) * 2));
        TimeCropSliderSeekBar.c(TimeCropSliderSeekBar.this);
        if ((TimeCropSliderSeekBar.d(TimeCropSliderSeekBar.this) == null) && (TimeCropSliderSeekBar.e(TimeCropSliderSeekBar.this) == null))
        {
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, new Rect(TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().left, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().top, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().right, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().bottom));
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, new Rect(TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().left, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().top, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().right, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().bottom));
        }
        TimeCropSliderSeekBar.this.invalidate();
        AppMethodBeat.o(191114);
      }
    });
    AppMethodBeat.o(191123);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(191126);
    if ((!this.wev) || (this.weB == null) || (this.weC == null) || (this.weB.getBounds().width() <= 0) || (this.weC.getBounds().width() <= 0))
    {
      AppMethodBeat.o(191126);
      return false;
    }
    float f1;
    float f2;
    boolean bool;
    label147:
    Rect localRect;
    if (paramBoolean)
    {
      f1 = this.weC.getBounds().right - this.wey;
      f2 = this.weE + f1;
      f1 = Math.max(this.padding, this.weC.getBounds().right - this.wex - this.weE);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label260;
      }
      bool = true;
      if (!paramBoolean) {
        break label266;
      }
      localRect = this.weB.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.weE), 0);
      this.weB.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(191126);
      return bool;
      f1 = this.weB.getBounds().left + this.wey - this.weE;
      f2 = Math.min(getWidth() - this.padding, this.weB.getBounds().left + this.wex + this.weE);
      break;
      label260:
      bool = false;
      break label147;
      label266:
      localRect = this.weC.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat - this.weE), 0);
      this.weC.setBounds(localRect);
    }
  }
  
  public final void dqJ()
  {
    this.wew = true;
  }
  
  public final void dqK()
  {
    this.wew = false;
  }
  
  public final void exu()
  {
    AppMethodBeat.i(191129);
    this.weB = new b(com.tencent.mm.cb.a.l(getContext(), 2131235058), com.tencent.mm.cb.a.l(getContext(), 2131235058));
    this.weC = new b(com.tencent.mm.cb.a.l(getContext(), 2131235058), com.tencent.mm.cb.a.l(getContext(), 2131235058));
    this.weT = false;
    this.weD = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    this.weE = (this.weD * 0.5F);
    this.weQ = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    exv();
    postInvalidate();
    AppMethodBeat.o(191129);
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(191127);
    int i = (int)(this.weB.getBounds().left + this.weE);
    AppMethodBeat.o(191127);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(191128);
    int i = (int)(this.weC.getBounds().right - this.weE);
    AppMethodBeat.o(191128);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(191121);
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.weG > 0.0F)
    {
      f1 = getWidth() * this.weG;
      f2 = this.weF;
      f3 = this.CiY;
      f4 = this.weF;
      j = this.CiY;
      if (!this.weT) {
        break label108;
      }
    }
    label108:
    for (int i = getHeight();; i = this.CiZ)
    {
      paramCanvas.drawRect(f1 - f2 * 0.5F, f3, f4 * 0.5F + f1, i + j, this.weI);
      if (this.wev) {
        break;
      }
      AppMethodBeat.o(191121);
      return;
    }
    i = this.weB.getBounds().centerX();
    int j = this.weC.getBounds().centerX();
    if (((oB(true)) || (oB(false))) && (this.weT))
    {
      f1 = this.padding;
      paramCanvas.drawRect(this.weN + f1, this.weN, getWidth() - this.padding - this.weN, getBottom() - this.weN, this.weL);
    }
    if (this.weB.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.CiW);
    }
    if (this.weC.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.CiW);
    }
    if ((this.Cja) && (this.CiZ != 0)) {
      paramCanvas.drawRect(i, this.CiY - getTop(), j, this.CiY + this.CiZ - getTop(), this.CiX);
    }
    if (this.weT)
    {
      paramCanvas.drawLine(i, this.weJ, j, this.weJ, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.weJ, j, getHeight() - this.weJ, this.borderPaint);
    }
    this.weB.draw(paramCanvas);
    this.weC.draw(paramCanvas);
    AppMethodBeat.o(191121);
  }
  
  public void setContentHeight(int paramInt)
  {
    this.CiZ = paramInt;
  }
  
  public void setContentTop(int paramInt)
  {
    this.CiY = paramInt;
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(191122);
    if (!this.wev)
    {
      AppMethodBeat.o(191122);
      return;
    }
    this.weG = paramFloat;
    invalidate();
    AppMethodBeat.o(191122);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.weA = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(191124);
    this.CiW.setColor(paramInt);
    AppMethodBeat.o(191124);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.CiV = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dqI();
    
    public abstract void exw();
  }
  
  final class b
    extends Drawable
  {
    boolean isPressed = false;
    private Drawable wfc;
    private Drawable wfd;
    
    public b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.wfc = paramDrawable1;
      this.wfd = paramDrawable2;
      this.isPressed = false;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(191116);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.wfc;; localDrawable = this.wfd)
      {
        if (!getBounds().equals(localDrawable.getBounds())) {
          localDrawable.setBounds(getBounds());
        }
        localDrawable.draw(paramCanvas);
        AppMethodBeat.o(191116);
        return;
      }
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(191117);
      this.wfc.setAlpha(paramInt);
      this.wfd.setAlpha(paramInt);
      AppMethodBeat.o(191117);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(191118);
      this.wfc.setColorFilter(paramColorFilter);
      this.wfd.setColorFilter(paramColorFilter);
      AppMethodBeat.o(191118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */