package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.w.a.b;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.plugin.w.a.d;
import com.tencent.mm.plugin.w.a.g;

public class TimeCropSliderSeekBar
  extends View
{
  private boolean FcL;
  private boolean FcM;
  private int FcN;
  private int FcO;
  private boolean FcP;
  private boolean FcQ;
  private Drawable FcR;
  private Drawable FcS;
  private int FcT;
  private float FcU;
  private int FcV;
  private float FcW;
  private int FcX;
  private Paint FcY;
  private float FcZ;
  private Paint Fdb;
  private int Fdc;
  private float Fdd;
  private float Fde;
  private float Fdf;
  private int Fdg;
  private Rect Fdh;
  private Rect Fdi;
  private boolean Fdj;
  private a NzB;
  private Paint NzC;
  private Paint NzD;
  private int NzE;
  private boolean NzF;
  private View.OnTouchListener aIw;
  private Paint borderPaint;
  private int borderWidth;
  private int contentHeight;
  private int padding;
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248117);
    this.FcL = false;
    this.FcM = false;
    this.FcP = false;
    this.FcQ = false;
    this.FcW = -1.0F;
    this.NzE = 0;
    this.contentHeight = 0;
    this.Fde = -1.0F;
    this.Fdf = -1.0F;
    this.padding = 0;
    this.NzF = true;
    this.Fdj = true;
    this.aIw = new View.OnTouchListener()
    {
      boolean NzH = false;
      float NzI;
      float NzJ;
      float dit;
      float diu;
      boolean jKU = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(234714);
        if (!TimeCropSliderSeekBar.h(TimeCropSliderSeekBar.this))
        {
          AppMethodBeat.o(234714);
          return false;
        }
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        default: 
          AppMethodBeat.o(234714);
          return false;
        case 2: 
          if (!this.jKU)
          {
            AppMethodBeat.o(234714);
            return false;
          }
          if (this.NzH)
          {
            float f = paramAnonymousMotionEvent.getX() - this.dit;
            if (f > 0.0F)
            {
              f = Math.min(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.NzJ + f) - this.NzJ, f);
              TimeCropSliderSeekBar.this.b(false, this.NzJ + f);
              TimeCropSliderSeekBar.this.b(true, f + this.NzI);
            }
            for (;;)
            {
              TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).gwh();
              AppMethodBeat.o(234714);
              return true;
              f = Math.max(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.NzI + f) - this.NzI, f);
              TimeCropSliderSeekBar.this.b(true, this.NzI + f);
              TimeCropSliderSeekBar.this.b(false, f + this.NzJ);
            }
          }
          if (TimeCropSliderSeekBar.j(TimeCropSliderSeekBar.this))
          {
            AppMethodBeat.o(234714);
            return true;
          }
          boolean bool = TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
          bool = TimeCropSliderSeekBar.this.b(bool, paramAnonymousMotionEvent.getX());
          if ((TimeCropSliderSeekBar.k(TimeCropSliderSeekBar.this)) && (bool) && (!TimeCropSliderSeekBar.l(TimeCropSliderSeekBar.this))) {
            TimeCropSliderSeekBar.this.performHapticFeedback(0, 2);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, bool);
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).gwh();
          }
          AppMethodBeat.o(234714);
          return true;
        case 1: 
        case 3: 
          if (!this.jKU)
          {
            AppMethodBeat.o(234714);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null)
          {
            paramAnonymousView = TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
            TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
            paramAnonymousView.eUh();
          }
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true), false);
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, false);
          this.jKU = false;
          this.NzH = false;
          AppMethodBeat.o(234714);
          return true;
        }
        this.dit = paramAnonymousMotionEvent.getX();
        this.diu = paramAnonymousMotionEvent.getY();
        this.NzI = TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().centerX();
        this.NzJ = TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().centerX();
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.dit, this.diu))
        {
          this.NzH = true;
          this.jKU = true;
          AppMethodBeat.o(234714);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this), this.dit, this.diu))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true))
          {
            AppMethodBeat.o(234714);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().left);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true, true);
          this.jKU = true;
          AppMethodBeat.o(234714);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this), this.dit, this.diu))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false))
          {
            AppMethodBeat.o(234714);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.c(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().right);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false, true);
          this.jKU = true;
          AppMethodBeat.o(234714);
          return true;
        }
        AppMethodBeat.o(234714);
        return false;
      }
    };
    this.FcT = a.fromDPToPix(getContext(), 8);
    this.FcU = (this.FcT * 0.5F);
    this.Fdg = a.fromDPToPix(getContext(), 16);
    this.FcR = new TimeCropSliderSeekBar.b(this, a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.FcS = new TimeCropSliderSeekBar.b(this, a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.Fdj = true;
    postInvalidate();
    this.FcV = a.fromDPToPix(getContext(), 2);
    this.FcX = a.aY(getContext(), a.c.video_segment_seekbar_recycler_view_height);
    this.FcW = -1.0F;
    this.FcY = new Paint();
    this.FcY.setColor(a.w(getContext(), a.b.White));
    this.FcY.setAlpha(102);
    this.NzC = new Paint();
    this.NzC.setColor(a.w(getContext(), a.b.black));
    this.NzC.setAlpha(102);
    this.NzD = new Paint();
    this.NzD.setColor(a.w(getContext(), a.b.Orange));
    this.NzD.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(a.w(getContext(), a.b.white));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderWidth = hx(getContext());
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.FcZ = (this.borderWidth * 0.5F);
    this.Fdb = new Paint();
    this.Fdb.setColor(a.w(getContext(), a.b.white));
    this.Fdb.setStyle(Paint.Style.STROKE);
    this.Fdc = hx(getContext());
    this.Fdd = (this.Fdc * 0.5F);
    this.Fdb.setStrokeWidth(this.Fdc);
    this.Fdb.setAlpha(178);
    setOnTouchListener(this.aIw);
    AppMethodBeat.o(248117);
  }
  
  private void gwg()
  {
    AppMethodBeat.i(248139);
    this.FcR.setBounds(this.padding - this.FcT / 2, 0, this.padding + this.FcT / 2, getHeight());
    this.FcS.setBounds(this.padding + this.FcN - this.FcT / 2, 0, this.FcN + this.padding + this.FcT / 2, getHeight());
    AppMethodBeat.o(248139);
  }
  
  private static int hx(Context paramContext)
  {
    AppMethodBeat.i(248119);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(248119);
    return i;
  }
  
  private boolean ui(boolean paramBoolean)
  {
    AppMethodBeat.i(248130);
    if (paramBoolean)
    {
      paramBoolean = TimeCropSliderSeekBar.b.a((TimeCropSliderSeekBar.b)this.FcR);
      AppMethodBeat.o(248130);
      return paramBoolean;
    }
    paramBoolean = TimeCropSliderSeekBar.b.a((TimeCropSliderSeekBar.b)this.FcS);
    AppMethodBeat.o(248130);
    return paramBoolean;
  }
  
  public final void at(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(248124);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(228020);
        if (paramInt1 <= TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this) * 2)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
          AppMethodBeat.o(228020);
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
        AppMethodBeat.o(228020);
      }
    });
    AppMethodBeat.o(248124);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(248133);
    if ((!this.FcL) || (this.FcR == null) || (this.FcS == null) || (this.FcR.getBounds().width() <= 0) || (this.FcS.getBounds().width() <= 0))
    {
      AppMethodBeat.o(248133);
      return false;
    }
    float f1;
    float f2;
    boolean bool;
    label147:
    Rect localRect;
    if (paramBoolean)
    {
      f1 = this.FcS.getBounds().right - this.FcO;
      f2 = this.FcU + f1;
      f1 = Math.max(this.padding, this.FcS.getBounds().right - this.FcN - this.FcU);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label260;
      }
      bool = true;
      if (!paramBoolean) {
        break label266;
      }
      localRect = this.FcR.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.FcU), 0);
      this.FcR.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(248133);
      return bool;
      f1 = this.FcR.getBounds().left + this.FcO - this.FcU;
      f2 = Math.min(getWidth() - this.padding, this.FcR.getBounds().left + this.FcN + this.FcU);
      break;
      label260:
      bool = false;
      break label147;
      label266:
      localRect = this.FcS.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat - this.FcU), 0);
      this.FcS.setBounds(localRect);
    }
  }
  
  public final void eUi()
  {
    this.FcM = true;
  }
  
  public final void eUj()
  {
    this.FcM = false;
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(248136);
    int i = (int)(this.FcR.getBounds().left + this.FcU);
    AppMethodBeat.o(248136);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(248137);
    int i = (int)(this.FcS.getBounds().right - this.FcU);
    AppMethodBeat.o(248137);
    return i;
  }
  
  public final void gwf()
  {
    AppMethodBeat.i(248138);
    this.FcR = new TimeCropSliderSeekBar.b(this, a.m(getContext(), a.d.icon_filled_clip_border), a.m(getContext(), a.d.icon_filled_clip_border));
    this.FcS = new TimeCropSliderSeekBar.b(this, a.m(getContext(), a.d.icon_filled_clip_border), a.m(getContext(), a.d.icon_filled_clip_border));
    this.Fdj = false;
    this.FcT = a.fromDPToPix(getContext(), 16);
    this.FcU = (this.FcT * 0.5F);
    this.Fdg = a.fromDPToPix(getContext(), 8);
    gwg();
    postInvalidate();
    AppMethodBeat.o(248138);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(248122);
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.FcW > 0.0F)
    {
      f1 = getWidth() * this.FcW;
      f2 = this.FcV;
      f3 = this.NzE;
      f4 = this.FcV;
      j = this.NzE;
      if (!this.Fdj) {
        break label108;
      }
    }
    label108:
    for (int i = getHeight();; i = this.contentHeight)
    {
      paramCanvas.drawRect(f1 - f2 * 0.5F, f3, f4 * 0.5F + f1, i + j, this.FcY);
      if (this.FcL) {
        break;
      }
      AppMethodBeat.o(248122);
      return;
    }
    i = this.FcR.getBounds().centerX();
    int j = this.FcS.getBounds().centerX();
    if (((ui(true)) || (ui(false))) && (this.Fdj))
    {
      f1 = this.padding;
      paramCanvas.drawRect(this.Fdd + f1, this.Fdd, getWidth() - this.padding - this.Fdd, getBottom() - this.Fdd, this.Fdb);
    }
    if (this.FcR.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.NzC);
    }
    if (this.FcS.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.NzC);
    }
    if ((this.NzF) && (this.contentHeight != 0)) {
      paramCanvas.drawRect(i, this.NzE - getTop(), j, this.NzE + this.contentHeight - getTop(), this.NzD);
    }
    if (this.Fdj)
    {
      paramCanvas.drawLine(i, this.FcZ, j, this.FcZ, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.FcZ, j, getHeight() - this.FcZ, this.borderPaint);
    }
    this.FcR.draw(paramCanvas);
    this.FcS.draw(paramCanvas);
    AppMethodBeat.o(248122);
  }
  
  public void setContentHeight(int paramInt)
  {
    this.contentHeight = paramInt;
  }
  
  public void setContentTop(int paramInt)
  {
    this.NzE = paramInt;
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(248123);
    if (!this.FcL)
    {
      AppMethodBeat.o(248123);
      return;
    }
    this.FcW = paramFloat;
    invalidate();
    AppMethodBeat.o(248123);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.FcQ = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(248128);
    this.NzC.setColor(paramInt);
    AppMethodBeat.o(248128);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.NzB = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eUh();
    
    public abstract void gwh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */