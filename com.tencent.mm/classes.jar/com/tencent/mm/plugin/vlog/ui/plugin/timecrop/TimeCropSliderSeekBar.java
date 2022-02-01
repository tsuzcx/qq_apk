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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.w.a.b;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.plugin.w.a.d;
import com.tencent.mm.plugin.w.a.g;

public class TimeCropSliderSeekBar
  extends View
{
  private Drawable KYA;
  private Drawable KYB;
  private int KYC;
  private float KYD;
  private int KYE;
  private float KYF;
  private int KYG;
  private Paint KYH;
  private float KYI;
  private Paint KYK;
  private int KYL;
  private float KYM;
  private float KYN;
  private float KYO;
  private int KYP;
  private Rect KYQ;
  private Rect KYR;
  private boolean KYS;
  private boolean KYu;
  boolean KYv;
  private int KYw;
  private int KYx;
  private boolean KYy;
  private boolean KYz;
  private a Umw;
  private Paint Umx;
  private int Umy;
  private boolean Umz;
  private int borderWidth;
  private int contentHeight;
  private View.OnTouchListener onTouchListener;
  private int padding;
  private Paint uMn;
  private Paint yxg;
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimeCropSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(282985);
    this.KYu = false;
    this.KYv = false;
    this.KYy = false;
    this.KYz = false;
    this.KYF = -1.0F;
    this.Umy = 0;
    this.contentHeight = 0;
    this.KYN = -1.0F;
    this.KYO = -1.0F;
    this.padding = 0;
    this.Umz = true;
    this.KYS = true;
    this.onTouchListener = new View.OnTouchListener()
    {
      boolean UmB = false;
      float UmC;
      float UmD;
      float fif;
      float fig;
      boolean mkg = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(282984);
        if (!TimeCropSliderSeekBar.h(TimeCropSliderSeekBar.this))
        {
          AppMethodBeat.o(282984);
          return false;
        }
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        default: 
          AppMethodBeat.o(282984);
          return false;
        case 2: 
          if (!this.mkg)
          {
            AppMethodBeat.o(282984);
            return false;
          }
          if (this.UmB)
          {
            float f = paramAnonymousMotionEvent.getX() - this.fif;
            if (f > 0.0F)
            {
              f = Math.min(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.UmD + f) - this.UmD, f);
              TimeCropSliderSeekBar.this.b(false, this.UmD + f);
              TimeCropSliderSeekBar.this.b(true, f + this.UmC);
            }
            for (;;)
            {
              TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).hTX();
              AppMethodBeat.o(282984);
              return true;
              f = Math.max(TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.UmC + f) - this.UmC, f);
              TimeCropSliderSeekBar.this.b(true, this.UmC + f);
              TimeCropSliderSeekBar.this.b(false, f + this.UmD);
            }
          }
          if (TimeCropSliderSeekBar.j(TimeCropSliderSeekBar.this))
          {
            AppMethodBeat.o(282984);
            return true;
          }
          boolean bool = TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
          bool = TimeCropSliderSeekBar.this.b(bool, paramAnonymousMotionEvent.getX());
          if ((TimeCropSliderSeekBar.k(TimeCropSliderSeekBar.this)) && (bool) && (!TimeCropSliderSeekBar.l(TimeCropSliderSeekBar.this))) {
            TimeCropSliderSeekBar.this.performHapticFeedback(0, 2);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, bool);
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this).hTX();
          }
          AppMethodBeat.o(282984);
          return true;
        case 1: 
        case 3: 
          if (!this.mkg)
          {
            AppMethodBeat.o(282984);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null)
          {
            paramAnonymousView = TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
            TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true);
            paramAnonymousView.hTW();
          }
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true), false);
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, false);
          this.mkg = false;
          this.UmB = false;
          AppMethodBeat.o(282984);
          return true;
        }
        this.fif = paramAnonymousMotionEvent.getX();
        this.fig = paramAnonymousMotionEvent.getY();
        this.UmC = TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().centerX();
        this.UmD = TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().centerX();
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, this.fif, this.fig))
        {
          this.UmB = true;
          this.mkg = true;
          AppMethodBeat.o(282984);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this), this.fif, this.fig))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true))
          {
            AppMethodBeat.o(282984);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.b(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.f(TimeCropSliderSeekBar.this).getBounds().left);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, true, true);
          this.mkg = true;
          AppMethodBeat.o(282984);
          return true;
        }
        if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this), this.fif, this.fig))
        {
          if (TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false))
          {
            AppMethodBeat.o(282984);
            return false;
          }
          if (TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this) != null) {
            TimeCropSliderSeekBar.i(TimeCropSliderSeekBar.this);
          }
          TimeCropSliderSeekBar.c(TimeCropSliderSeekBar.this, TimeCropSliderSeekBar.g(TimeCropSliderSeekBar.this).getBounds().right);
          TimeCropSliderSeekBar.a(TimeCropSliderSeekBar.this, false, true);
          this.mkg = true;
          AppMethodBeat.o(282984);
          return true;
        }
        AppMethodBeat.o(282984);
        return false;
      }
    };
    this.KYC = a.fromDPToPix(getContext(), 8);
    this.KYD = (this.KYC * 0.5F);
    this.KYP = a.fromDPToPix(getContext(), 16);
    this.KYA = new b(a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.KYB = new b(a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.KYS = true;
    postInvalidate();
    this.KYE = a.fromDPToPix(getContext(), 2);
    this.KYG = a.br(getContext(), a.c.video_segment_seekbar_recycler_view_height);
    this.KYF = -1.0F;
    this.KYH = new Paint();
    this.KYH.setColor(a.w(getContext(), a.b.White));
    this.KYH.setAlpha(102);
    this.yxg = new Paint();
    this.yxg.setColor(a.w(getContext(), a.b.black));
    this.yxg.setAlpha(102);
    this.Umx = new Paint();
    this.Umx.setColor(a.w(getContext(), a.b.Orange));
    this.Umx.setAlpha(102);
    this.uMn = new Paint();
    this.uMn.setColor(a.w(getContext(), a.b.white));
    this.uMn.setStyle(Paint.Style.STROKE);
    this.borderWidth = iS(getContext());
    this.uMn.setStrokeWidth(this.borderWidth);
    this.KYI = (this.borderWidth * 0.5F);
    this.KYK = new Paint();
    this.KYK.setColor(a.w(getContext(), a.b.white));
    this.KYK.setStyle(Paint.Style.STROKE);
    this.KYL = iS(getContext());
    this.KYM = (this.KYL * 0.5F);
    this.KYK.setStrokeWidth(this.KYL);
    this.KYK.setAlpha(178);
    setOnTouchListener(this.onTouchListener);
    AppMethodBeat.o(282985);
  }
  
  private void hTV()
  {
    AppMethodBeat.i(283006);
    this.KYA.setBounds(this.padding - this.KYC / 2, 0, this.padding + this.KYC / 2, getHeight());
    this.KYB.setBounds(this.padding + this.KYw - this.KYC / 2, 0, this.KYw + this.padding + this.KYC / 2, getHeight());
    AppMethodBeat.o(283006);
  }
  
  private static int iS(Context paramContext)
  {
    AppMethodBeat.i(282992);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(282992);
    return i;
  }
  
  private boolean yw(boolean paramBoolean)
  {
    AppMethodBeat.i(282997);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.KYA);
      AppMethodBeat.o(282997);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.KYB);
    AppMethodBeat.o(282997);
    return paramBoolean;
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(283179);
    if ((!this.KYu) || (this.KYA == null) || (this.KYB == null) || (this.KYA.getBounds().width() <= 0) || (this.KYB.getBounds().width() <= 0))
    {
      AppMethodBeat.o(283179);
      return false;
    }
    float f1;
    float f2;
    boolean bool;
    label147:
    Rect localRect;
    if (paramBoolean)
    {
      f1 = this.KYB.getBounds().right - this.KYx;
      f2 = this.KYD + f1;
      f1 = Math.max(this.padding, this.KYB.getBounds().right - this.KYw - this.KYD);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label260;
      }
      bool = true;
      if (!paramBoolean) {
        break label266;
      }
      localRect = this.KYA.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.KYD), 0);
      this.KYA.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(283179);
      return bool;
      f1 = this.KYA.getBounds().left + this.KYx - this.KYD;
      f2 = Math.min(getWidth() - this.padding, this.KYA.getBounds().left + this.KYw + this.KYD);
      break;
      label260:
      bool = false;
      break label147;
      label266:
      localRect = this.KYB.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat - this.KYD), 0);
      this.KYB.setBounds(localRect);
    }
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(283186);
    int i = (int)(this.KYA.getBounds().left + this.KYD);
    AppMethodBeat.o(283186);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(283191);
    int i = (int)(this.KYB.getBounds().right - this.KYD);
    AppMethodBeat.o(283191);
    return i;
  }
  
  public final void hTU()
  {
    AppMethodBeat.i(283202);
    this.KYA = new b(a.m(getContext(), a.d.icon_filled_clip_border), a.m(getContext(), a.d.icon_filled_clip_border));
    this.KYB = new b(a.m(getContext(), a.d.icon_filled_clip_border), a.m(getContext(), a.d.icon_filled_clip_border));
    this.KYS = false;
    this.KYC = a.fromDPToPix(getContext(), 16);
    this.KYD = (this.KYC * 0.5F);
    this.KYP = a.fromDPToPix(getContext(), 8);
    hTV();
    postInvalidate();
    AppMethodBeat.o(283202);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(283144);
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.KYF > 0.0F)
    {
      f1 = getWidth() * this.KYF;
      f2 = this.KYE;
      f3 = this.Umy;
      f4 = this.KYE;
      j = this.Umy;
      if (!this.KYS) {
        break label108;
      }
    }
    label108:
    for (int i = getHeight();; i = this.contentHeight)
    {
      paramCanvas.drawRect(f1 - f2 * 0.5F, f3, f4 * 0.5F + f1, i + j, this.KYH);
      if (this.KYu) {
        break;
      }
      AppMethodBeat.o(283144);
      return;
    }
    i = this.KYA.getBounds().centerX();
    int j = this.KYB.getBounds().centerX();
    if (((yw(true)) || (yw(false))) && (this.KYS))
    {
      f1 = this.padding;
      paramCanvas.drawRect(this.KYM + f1, this.KYM, getWidth() - this.padding - this.KYM, getBottom() - this.KYM, this.KYK);
    }
    if (this.KYA.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.yxg);
    }
    if (this.KYB.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.yxg);
    }
    if ((this.Umz) && (this.contentHeight != 0)) {
      paramCanvas.drawRect(i, this.Umy - getTop(), j, this.Umy + this.contentHeight - getTop(), this.Umx);
    }
    if (this.KYS)
    {
      paramCanvas.drawLine(i, this.KYI, j, this.KYI, this.uMn);
      paramCanvas.drawLine(i, getHeight() - this.KYI, j, getHeight() - this.KYI, this.uMn);
    }
    this.KYA.draw(paramCanvas);
    this.KYB.draw(paramCanvas);
    AppMethodBeat.o(283144);
  }
  
  public void setContentHeight(int paramInt)
  {
    this.contentHeight = paramInt;
  }
  
  public void setContentTop(int paramInt)
  {
    this.Umy = paramInt;
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(283150);
    if (!this.KYu)
    {
      AppMethodBeat.o(283150);
      return;
    }
    this.KYF = paramFloat;
    invalidate();
    AppMethodBeat.o(283150);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.KYz = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(283165);
    this.yxg.setColor(paramInt);
    AppMethodBeat.o(283165);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.Umw = parama;
  }
  
  public static abstract interface a
  {
    public abstract void hTW();
    
    public abstract void hTX();
  }
  
  final class b
    extends Drawable
  {
    private Drawable KYY;
    private Drawable KYZ;
    boolean isPressed = false;
    
    public b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.KYY = paramDrawable1;
      this.KYZ = paramDrawable2;
      this.isPressed = false;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(282979);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.KYY;; localDrawable = this.KYZ)
      {
        if (!getBounds().equals(localDrawable.getBounds())) {
          localDrawable.setBounds(getBounds());
        }
        localDrawable.draw(paramCanvas);
        AppMethodBeat.o(282979);
        return;
      }
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(282987);
      this.KYY.setAlpha(paramInt);
      this.KYZ.setAlpha(paramInt);
      AppMethodBeat.o(282987);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(282993);
      this.KYY.setColorFilter(paramColorFilter);
      this.KYZ.setColorFilter(paramColorFilter);
      AppMethodBeat.o(282993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */