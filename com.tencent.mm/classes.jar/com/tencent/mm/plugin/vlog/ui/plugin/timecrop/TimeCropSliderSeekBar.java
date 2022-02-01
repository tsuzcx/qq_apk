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
  private boolean BRA;
  private a BRv;
  private Paint BRw;
  private Paint BRx;
  private int BRy;
  private int BRz;
  private Paint borderPaint;
  private int borderWidth;
  private int padding;
  private View.OnTouchListener tDQ;
  private float vSA;
  private int vSB;
  private float vSC;
  private int vSD;
  private Paint vSE;
  private float vSF;
  private Paint vSH;
  private int vSI;
  private float vSJ;
  private float vSK;
  private float vSL;
  private int vSM;
  private Rect vSN;
  private Rect vSO;
  private boolean vSP;
  private boolean vSr;
  private boolean vSs;
  private int vSt;
  private int vSu;
  private boolean vSv;
  private boolean vSw;
  private Drawable vSx;
  private Drawable vSy;
  private int vSz;
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195662);
    this.vSr = false;
    this.vSs = false;
    this.vSv = false;
    this.vSw = false;
    this.vSC = -1.0F;
    this.BRy = 0;
    this.BRz = 0;
    this.vSK = -1.0F;
    this.vSL = -1.0F;
    this.padding = 0;
    this.BRA = true;
    this.vSP = true;
    this.tDQ = new View.OnTouchListener()
    {
      boolean BRC = false;
      float BRD;
      float BRE;
      float cNg;
      float cNh;
      boolean gmE = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(195658);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (!TimeCropSliderSeekBar.h(TimeCropSliderSeekBar.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(195658);
          return false;
        }
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(195658);
          return false;
        case 2: 
          if (!this.gmE)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(195658);
            return false;
          }
          if (this.BRC)
          {
            float f = paramAnonymousMotionEvent.getX() - this.cNg;
            if (f > 0.0F)
            {
              f = Math.min(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.BRE + f) - this.BRE, f);
              TimeCropSliderSeekBar.this.b(false, this.BRE + f);
              TimeCropSliderSeekBar.this.b(true, f + this.BRD);
            }
            for (;;)
            {
              TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).etP();
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(195658);
              return true;
              f = Math.max(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.BRD + f) - this.BRD, f);
              TimeCropSliderSeekBar.this.b(true, this.BRD + f);
              TimeCropSliderSeekBar.this.b(false, f + this.BRE);
            }
          }
          if (TimeCropSliderSeekBar.j(TimeCropSliderSeekBar.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(195658);
            return true;
          }
          boolean bool = TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
          bool = TimeCropSliderSeekBar.this.b(bool, paramAnonymousMotionEvent.getX());
          if ((TimeCropSliderSeekBar.k(TimeCropSliderSeekBar.this)) && (bool) && (!TimeCropSliderSeekBar.l(TimeCropSliderSeekBar.this))) {
            TimeCropSliderSeekBar.this.performHapticFeedback(0, 2);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, bool);
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).etP();
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(195658);
          return true;
        case 1: 
        case 3: 
          if (!this.gmE)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(195658);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null)
          {
            paramAnonymousView = TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
            TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
            paramAnonymousView.dnK();
          }
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true), false);
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, false);
          this.gmE = false;
          this.BRC = false;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(195658);
          return true;
        }
        this.cNg = paramAnonymousMotionEvent.getX();
        this.cNh = paramAnonymousMotionEvent.getY();
        this.BRD = TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().centerX();
        this.BRE = TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().centerX();
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.cNg, this.cNh))
        {
          this.BRC = true;
          this.gmE = true;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(195658);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this), this.cNg, this.cNh))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(195658);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().left);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true, true);
          this.gmE = true;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(195658);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this), this.cNg, this.cNh))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(195658);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.c(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().right);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false, true);
          this.gmE = true;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(195658);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(195658);
        return false;
      }
    };
    this.vSz = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    this.vSA = (this.vSz * 0.5F);
    this.vSM = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
    this.vSx = new b(com.tencent.mm.cc.a.l(getContext(), 2131691359), com.tencent.mm.cc.a.l(getContext(), 2131691358));
    this.vSy = new b(com.tencent.mm.cc.a.l(getContext(), 2131691359), com.tencent.mm.cc.a.l(getContext(), 2131691358));
    this.vSP = true;
    postInvalidate();
    this.vSB = com.tencent.mm.cc.a.fromDPToPix(getContext(), 2);
    this.vSD = com.tencent.mm.cc.a.ax(getContext(), 2131166956);
    this.vSC = -1.0F;
    this.vSE = new Paint();
    this.vSE.setColor(com.tencent.mm.cc.a.n(getContext(), 2131099828));
    this.vSE.setAlpha(102);
    this.BRw = new Paint();
    this.BRw.setColor(com.tencent.mm.cc.a.n(getContext(), 2131100017));
    this.BRw.setAlpha(102);
    this.BRx = new Paint();
    this.BRx.setColor(com.tencent.mm.cc.a.n(getContext(), 2131099777));
    this.BRx.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(com.tencent.mm.cc.a.n(getContext(), 2131101179));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderWidth = fO(getContext());
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.vSF = (this.borderWidth * 0.5F);
    this.vSH = new Paint();
    this.vSH.setColor(com.tencent.mm.cc.a.n(getContext(), 2131101179));
    this.vSH.setStyle(Paint.Style.STROKE);
    this.vSI = fO(getContext());
    this.vSJ = (this.vSI * 0.5F);
    this.vSH.setStrokeWidth(this.vSI);
    this.vSH.setAlpha(178);
    setOnTouchListener(this.tDQ);
    AppMethodBeat.o(195662);
  }
  
  private void etO()
  {
    AppMethodBeat.i(195673);
    this.vSx.setBounds(this.padding - this.vSz / 2, 0, this.padding + this.vSz / 2, getHeight());
    this.vSy.setBounds(this.padding + this.vSt - this.vSz / 2, 0, this.vSt + this.padding + this.vSz / 2, getHeight());
    AppMethodBeat.o(195673);
  }
  
  private static int fO(Context paramContext)
  {
    AppMethodBeat.i(195663);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(195663);
    return i;
  }
  
  private boolean ow(boolean paramBoolean)
  {
    AppMethodBeat.i(195668);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.vSx);
      AppMethodBeat.o(195668);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.vSy);
    AppMethodBeat.o(195668);
    return paramBoolean;
  }
  
  public final void aj(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(195666);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195657);
        if (paramInt1 <= TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this) * 2)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
          AppMethodBeat.o(195657);
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
        AppMethodBeat.o(195657);
      }
    });
    AppMethodBeat.o(195666);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(195669);
    if ((!this.vSr) || (this.vSx == null) || (this.vSy == null) || (this.vSx.getBounds().width() <= 0) || (this.vSy.getBounds().width() <= 0))
    {
      AppMethodBeat.o(195669);
      return false;
    }
    float f1;
    float f2;
    boolean bool;
    label147:
    Rect localRect;
    if (paramBoolean)
    {
      f1 = this.vSy.getBounds().right - this.vSu;
      f2 = this.vSA + f1;
      f1 = Math.max(this.padding, this.vSy.getBounds().right - this.vSt - this.vSA);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label260;
      }
      bool = true;
      if (!paramBoolean) {
        break label266;
      }
      localRect = this.vSx.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.vSA), 0);
      this.vSx.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(195669);
      return bool;
      f1 = this.vSx.getBounds().left + this.vSu - this.vSA;
      f2 = Math.min(getWidth() - this.padding, this.vSx.getBounds().left + this.vSt + this.vSA);
      break;
      label260:
      bool = false;
      break label147;
      label266:
      localRect = this.vSy.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat - this.vSA), 0);
      this.vSy.setBounds(localRect);
    }
  }
  
  public final void dnL()
  {
    this.vSs = true;
  }
  
  public final void dnM()
  {
    this.vSs = false;
  }
  
  public final void etN()
  {
    AppMethodBeat.i(195672);
    this.vSx = new b(com.tencent.mm.cc.a.l(getContext(), 2131235058), com.tencent.mm.cc.a.l(getContext(), 2131235058));
    this.vSy = new b(com.tencent.mm.cc.a.l(getContext(), 2131235058), com.tencent.mm.cc.a.l(getContext(), 2131235058));
    this.vSP = false;
    this.vSz = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
    this.vSA = (this.vSz * 0.5F);
    this.vSM = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    etO();
    postInvalidate();
    AppMethodBeat.o(195672);
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(195670);
    int i = (int)(this.vSx.getBounds().left + this.vSA);
    AppMethodBeat.o(195670);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(195671);
    int i = (int)(this.vSy.getBounds().right - this.vSA);
    AppMethodBeat.o(195671);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(195664);
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.vSC > 0.0F)
    {
      f1 = getWidth() * this.vSC;
      f2 = this.vSB;
      f3 = this.BRy;
      f4 = this.vSB;
      j = this.BRy;
      if (!this.vSP) {
        break label108;
      }
    }
    label108:
    for (int i = getHeight();; i = this.BRz)
    {
      paramCanvas.drawRect(f1 - f2 * 0.5F, f3, f4 * 0.5F + f1, i + j, this.vSE);
      if (this.vSr) {
        break;
      }
      AppMethodBeat.o(195664);
      return;
    }
    i = this.vSx.getBounds().centerX();
    int j = this.vSy.getBounds().centerX();
    if (((ow(true)) || (ow(false))) && (this.vSP))
    {
      f1 = this.padding;
      paramCanvas.drawRect(this.vSJ + f1, this.vSJ, getWidth() - this.padding - this.vSJ, getBottom() - this.vSJ, this.vSH);
    }
    if (this.vSx.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.BRw);
    }
    if (this.vSy.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.BRw);
    }
    if ((this.BRA) && (this.BRz != 0)) {
      paramCanvas.drawRect(i, this.BRy - getTop(), j, this.BRy + this.BRz - getTop(), this.BRx);
    }
    if (this.vSP)
    {
      paramCanvas.drawLine(i, this.vSF, j, this.vSF, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.vSF, j, getHeight() - this.vSF, this.borderPaint);
    }
    this.vSx.draw(paramCanvas);
    this.vSy.draw(paramCanvas);
    AppMethodBeat.o(195664);
  }
  
  public void setContentHeight(int paramInt)
  {
    this.BRz = paramInt;
  }
  
  public void setContentTop(int paramInt)
  {
    this.BRy = paramInt;
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(195665);
    if (!this.vSr)
    {
      AppMethodBeat.o(195665);
      return;
    }
    this.vSC = paramFloat;
    invalidate();
    AppMethodBeat.o(195665);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.vSw = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(195667);
    this.BRw.setColor(paramInt);
    AppMethodBeat.o(195667);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.BRv = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dnK();
    
    public abstract void etP();
  }
  
  final class b
    extends Drawable
  {
    boolean isPressed = false;
    private Drawable vSY;
    private Drawable vSZ;
    
    public b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.vSY = paramDrawable1;
      this.vSZ = paramDrawable2;
      this.isPressed = false;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(195659);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.vSY;; localDrawable = this.vSZ)
      {
        if (!getBounds().equals(localDrawable.getBounds())) {
          localDrawable.setBounds(getBounds());
        }
        localDrawable.draw(paramCanvas);
        AppMethodBeat.o(195659);
        return;
      }
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(195660);
      this.vSY.setAlpha(paramInt);
      this.vSZ.setAlpha(paramInt);
      AppMethodBeat.o(195660);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(195661);
      this.vSY.setColorFilter(paramColorFilter);
      this.vSZ.setColorFilter(paramColorFilter);
      AppMethodBeat.o(195661);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */