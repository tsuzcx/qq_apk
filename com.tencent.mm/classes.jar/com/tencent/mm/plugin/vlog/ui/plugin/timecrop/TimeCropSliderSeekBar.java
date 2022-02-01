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
import com.tencent.mm.cb.a;

public class TimeCropSliderSeekBar
  extends View
{
  private a GLW;
  private Paint GLX;
  private Paint GLY;
  private int GLZ;
  private int GMa;
  private boolean GMb;
  private View.OnTouchListener aZa;
  private Paint borderPaint;
  private int padding;
  private int rc;
  private float zxA;
  private int zxB;
  private float zxC;
  private int zxD;
  private Paint zxE;
  private float zxF;
  private Paint zxH;
  private int zxI;
  private float zxJ;
  private float zxK;
  private float zxL;
  private int zxM;
  private Rect zxN;
  private Rect zxO;
  private boolean zxP;
  private boolean zxr;
  private boolean zxs;
  private int zxt;
  private int zxu;
  private boolean zxv;
  private boolean zxw;
  private Drawable zxx;
  private Drawable zxy;
  private int zxz;
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190455);
    this.zxr = false;
    this.zxs = false;
    this.zxv = false;
    this.zxw = false;
    this.zxC = -1.0F;
    this.GLZ = 0;
    this.GMa = 0;
    this.zxK = -1.0F;
    this.zxL = -1.0F;
    this.padding = 0;
    this.GMb = true;
    this.zxP = true;
    this.aZa = new View.OnTouchListener()
    {
      boolean GMd = false;
      float GMe;
      float GMf;
      float deo;
      float dep;
      boolean gZT = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(190451);
        if (!TimeCropSliderSeekBar.h(TimeCropSliderSeekBar.this))
        {
          AppMethodBeat.o(190451);
          return false;
        }
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        default: 
          AppMethodBeat.o(190451);
          return false;
        case 2: 
          if (!this.gZT)
          {
            AppMethodBeat.o(190451);
            return false;
          }
          if (this.GMd)
          {
            float f = paramAnonymousMotionEvent.getX() - this.deo;
            if (f > 0.0F)
            {
              f = Math.min(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.GMf + f) - this.GMf, f);
              TimeCropSliderSeekBar.this.b(false, this.GMf + f);
              TimeCropSliderSeekBar.this.b(true, f + this.GMe);
            }
            for (;;)
            {
              TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).fEi();
              AppMethodBeat.o(190451);
              return true;
              f = Math.max(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.GMe + f) - this.GMe, f);
              TimeCropSliderSeekBar.this.b(true, this.GMe + f);
              TimeCropSliderSeekBar.this.b(false, f + this.GMf);
            }
          }
          if (TimeCropSliderSeekBar.j(TimeCropSliderSeekBar.this))
          {
            AppMethodBeat.o(190451);
            return true;
          }
          boolean bool = TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
          bool = TimeCropSliderSeekBar.this.b(bool, paramAnonymousMotionEvent.getX());
          if ((TimeCropSliderSeekBar.k(TimeCropSliderSeekBar.this)) && (bool) && (!TimeCropSliderSeekBar.l(TimeCropSliderSeekBar.this))) {
            TimeCropSliderSeekBar.this.performHapticFeedback(0, 2);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, bool);
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).fEi();
          }
          AppMethodBeat.o(190451);
          return true;
        case 1: 
        case 3: 
          if (!this.gZT)
          {
            AppMethodBeat.o(190451);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null)
          {
            paramAnonymousView = TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
            TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
            paramAnonymousView.ekz();
          }
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true), false);
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, false);
          this.gZT = false;
          this.GMd = false;
          AppMethodBeat.o(190451);
          return true;
        }
        this.deo = paramAnonymousMotionEvent.getX();
        this.dep = paramAnonymousMotionEvent.getY();
        this.GMe = TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().centerX();
        this.GMf = TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().centerX();
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.deo, this.dep))
        {
          this.GMd = true;
          this.gZT = true;
          AppMethodBeat.o(190451);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this), this.deo, this.dep))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true))
          {
            AppMethodBeat.o(190451);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().left);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true, true);
          this.gZT = true;
          AppMethodBeat.o(190451);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this), this.deo, this.dep))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false))
          {
            AppMethodBeat.o(190451);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.c(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().right);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false, true);
          this.gZT = true;
          AppMethodBeat.o(190451);
          return true;
        }
        AppMethodBeat.o(190451);
        return false;
      }
    };
    this.zxz = a.fromDPToPix(getContext(), 8);
    this.zxA = (this.zxz * 0.5F);
    this.zxM = a.fromDPToPix(getContext(), 16);
    this.zxx = new b(a.l(getContext(), 2131691693), a.l(getContext(), 2131691692));
    this.zxy = new b(a.l(getContext(), 2131691693), a.l(getContext(), 2131691692));
    this.zxP = true;
    postInvalidate();
    this.zxB = a.fromDPToPix(getContext(), 2);
    this.zxD = a.aG(getContext(), 2131167091);
    this.zxC = -1.0F;
    this.zxE = new Paint();
    this.zxE.setColor(a.n(getContext(), 2131099844));
    this.zxE.setAlpha(102);
    this.GLX = new Paint();
    this.GLX.setColor(a.n(getContext(), 2131100042));
    this.GLX.setAlpha(102);
    this.GLY = new Paint();
    this.GLY.setColor(a.n(getContext(), 2131099792));
    this.GLY.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(a.n(getContext(), 2131101424));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.rc = gz(getContext());
    this.borderPaint.setStrokeWidth(this.rc);
    this.zxF = (this.rc * 0.5F);
    this.zxH = new Paint();
    this.zxH.setColor(a.n(getContext(), 2131101424));
    this.zxH.setStyle(Paint.Style.STROKE);
    this.zxI = gz(getContext());
    this.zxJ = (this.zxI * 0.5F);
    this.zxH.setStrokeWidth(this.zxI);
    this.zxH.setAlpha(178);
    setOnTouchListener(this.aZa);
    AppMethodBeat.o(190455);
  }
  
  private void fEh()
  {
    AppMethodBeat.i(190466);
    this.zxx.setBounds(this.padding - this.zxz / 2, 0, this.padding + this.zxz / 2, getHeight());
    this.zxy.setBounds(this.padding + this.zxt - this.zxz / 2, 0, this.zxt + this.padding + this.zxz / 2, getHeight());
    AppMethodBeat.o(190466);
  }
  
  private static int gz(Context paramContext)
  {
    AppMethodBeat.i(190456);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(190456);
    return i;
  }
  
  private boolean re(boolean paramBoolean)
  {
    AppMethodBeat.i(190461);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.zxx);
      AppMethodBeat.o(190461);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.zxy);
    AppMethodBeat.o(190461);
    return paramBoolean;
  }
  
  public final void ao(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(190459);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190450);
        if (paramInt1 <= TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this) * 2)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
          AppMethodBeat.o(190450);
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
        AppMethodBeat.o(190450);
      }
    });
    AppMethodBeat.o(190459);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(190462);
    if ((!this.zxr) || (this.zxx == null) || (this.zxy == null) || (this.zxx.getBounds().width() <= 0) || (this.zxy.getBounds().width() <= 0))
    {
      AppMethodBeat.o(190462);
      return false;
    }
    float f1;
    float f2;
    boolean bool;
    label147:
    Rect localRect;
    if (paramBoolean)
    {
      f1 = this.zxy.getBounds().right - this.zxu;
      f2 = this.zxA + f1;
      f1 = Math.max(this.padding, this.zxy.getBounds().right - this.zxt - this.zxA);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label260;
      }
      bool = true;
      if (!paramBoolean) {
        break label266;
      }
      localRect = this.zxx.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.zxA), 0);
      this.zxx.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(190462);
      return bool;
      f1 = this.zxx.getBounds().left + this.zxu - this.zxA;
      f2 = Math.min(getWidth() - this.padding, this.zxx.getBounds().left + this.zxt + this.zxA);
      break;
      label260:
      bool = false;
      break label147;
      label266:
      localRect = this.zxy.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat - this.zxA), 0);
      this.zxy.setBounds(localRect);
    }
  }
  
  public final void ekA()
  {
    this.zxs = true;
  }
  
  public final void ekB()
  {
    this.zxs = false;
  }
  
  public final void fEg()
  {
    AppMethodBeat.i(190465);
    this.zxx = new b(a.l(getContext(), 2131233107), a.l(getContext(), 2131233107));
    this.zxy = new b(a.l(getContext(), 2131233107), a.l(getContext(), 2131233107));
    this.zxP = false;
    this.zxz = a.fromDPToPix(getContext(), 16);
    this.zxA = (this.zxz * 0.5F);
    this.zxM = a.fromDPToPix(getContext(), 8);
    fEh();
    postInvalidate();
    AppMethodBeat.o(190465);
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(190463);
    int i = (int)(this.zxx.getBounds().left + this.zxA);
    AppMethodBeat.o(190463);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(190464);
    int i = (int)(this.zxy.getBounds().right - this.zxA);
    AppMethodBeat.o(190464);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(190457);
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.zxC > 0.0F)
    {
      f1 = getWidth() * this.zxC;
      f2 = this.zxB;
      f3 = this.GLZ;
      f4 = this.zxB;
      j = this.GLZ;
      if (!this.zxP) {
        break label108;
      }
    }
    label108:
    for (int i = getHeight();; i = this.GMa)
    {
      paramCanvas.drawRect(f1 - f2 * 0.5F, f3, f4 * 0.5F + f1, i + j, this.zxE);
      if (this.zxr) {
        break;
      }
      AppMethodBeat.o(190457);
      return;
    }
    i = this.zxx.getBounds().centerX();
    int j = this.zxy.getBounds().centerX();
    if (((re(true)) || (re(false))) && (this.zxP))
    {
      f1 = this.padding;
      paramCanvas.drawRect(this.zxJ + f1, this.zxJ, getWidth() - this.padding - this.zxJ, getBottom() - this.zxJ, this.zxH);
    }
    if (this.zxx.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.GLX);
    }
    if (this.zxy.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.GLX);
    }
    if ((this.GMb) && (this.GMa != 0)) {
      paramCanvas.drawRect(i, this.GLZ - getTop(), j, this.GLZ + this.GMa - getTop(), this.GLY);
    }
    if (this.zxP)
    {
      paramCanvas.drawLine(i, this.zxF, j, this.zxF, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.zxF, j, getHeight() - this.zxF, this.borderPaint);
    }
    this.zxx.draw(paramCanvas);
    this.zxy.draw(paramCanvas);
    AppMethodBeat.o(190457);
  }
  
  public void setContentHeight(int paramInt)
  {
    this.GMa = paramInt;
  }
  
  public void setContentTop(int paramInt)
  {
    this.GLZ = paramInt;
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(190458);
    if (!this.zxr)
    {
      AppMethodBeat.o(190458);
      return;
    }
    this.zxC = paramFloat;
    invalidate();
    AppMethodBeat.o(190458);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.zxw = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(190460);
    this.GLX.setColor(paramInt);
    AppMethodBeat.o(190460);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.GLW = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ekz();
    
    public abstract void fEi();
  }
  
  final class b
    extends Drawable
  {
    boolean isPressed = false;
    private Drawable zxV;
    private Drawable zxW;
    
    public b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.zxV = paramDrawable1;
      this.zxW = paramDrawable2;
      this.isPressed = false;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(190452);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.zxV;; localDrawable = this.zxW)
      {
        if (!getBounds().equals(localDrawable.getBounds())) {
          localDrawable.setBounds(getBounds());
        }
        localDrawable.draw(paramCanvas);
        AppMethodBeat.o(190452);
        return;
      }
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(190453);
      this.zxV.setAlpha(paramInt);
      this.zxW.setAlpha(paramInt);
      AppMethodBeat.o(190453);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(190454);
      this.zxV.setColorFilter(paramColorFilter);
      this.zxW.setColorFilter(paramColorFilter);
      AppMethodBeat.o(190454);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */