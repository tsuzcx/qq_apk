package com.tencent.mm.ui.blur;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;

public class BlurView
  extends FrameLayout
{
  private static final String TAG;
  public float Kx;
  public boolean PcA;
  c Pcv;
  private int Pcw;
  private final Path Pcx;
  private final RectF Pcy;
  private float[] Pcz;
  
  static
  {
    AppMethodBeat.i(142741);
    TAG = BlurView.class.getSimpleName();
    AppMethodBeat.o(142741);
  }
  
  public BlurView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142721);
    this.Pcv = gMu();
    this.Kx = 0.0F;
    this.Pcx = new Path();
    this.Pcy = new RectF();
    this.PcA = false;
    init(null, 0);
    AppMethodBeat.o(142721);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142722);
    this.Pcv = gMu();
    this.Kx = 0.0F;
    this.Pcx = new Path();
    this.Pcy = new RectF();
    this.PcA = false;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(142722);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142723);
    this.Pcv = gMu();
    this.Kx = 0.0F;
    this.Pcx = new Path();
    this.Pcy = new RectF();
    this.PcA = false;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(142723);
  }
  
  private c gMu()
  {
    AppMethodBeat.i(142740);
    c local2 = new c()
    {
      public final void BH(boolean paramAnonymousBoolean) {}
      
      public final void BI(boolean paramAnonymousBoolean) {}
      
      public final void E(Drawable paramAnonymousDrawable) {}
      
      public final void a(b paramAnonymousb) {}
      
      public final void alV(int paramAnonymousInt) {}
      
      public final void cu(float paramAnonymousFloat) {}
      
      public final void destroy() {}
      
      public final void gMm() {}
      
      public final void gMn() {}
      
      public final void gMo() {}
      
      public final void gMp() {}
      
      public final void z(Canvas paramAnonymousCanvas) {}
    };
    AppMethodBeat.o(142740);
    return local2;
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142724);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.BlurView, paramInt, 0);
    this.Pcw = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    AppMethodBeat.o(142724);
  }
  
  private void setBlurController(c paramc)
  {
    AppMethodBeat.i(142731);
    this.Pcv.destroy();
    this.Pcv = paramc;
    AppMethodBeat.o(142731);
  }
  
  public final BlurView BJ(final boolean paramBoolean)
  {
    AppMethodBeat.i(142726);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142720);
        BlurView.this.Pcv.BH(paramBoolean);
        AppMethodBeat.o(142720);
      }
    });
    AppMethodBeat.o(142726);
    return this;
  }
  
  public final BlurView F(Drawable paramDrawable)
  {
    AppMethodBeat.i(142737);
    this.Pcv.E(paramDrawable);
    AppMethodBeat.o(142737);
    return this;
  }
  
  public final BlurView L(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142734);
    paramViewGroup = new a(this, paramViewGroup);
    setBlurController(paramViewGroup);
    if (!isHardwareAccelerated()) {
      paramViewGroup.BI(false);
    }
    AppMethodBeat.o(142734);
    return this;
  }
  
  public final BlurView alW(int paramInt)
  {
    AppMethodBeat.i(142732);
    if (paramInt != this.Pcw)
    {
      this.Pcw = paramInt;
      invalidate();
    }
    AppMethodBeat.o(142732);
    return this;
  }
  
  public final BlurView alX(int paramInt)
  {
    AppMethodBeat.i(142738);
    this.Pcv.alV(paramInt);
    AppMethodBeat.o(142738);
    return this;
  }
  
  public final BlurView b(b paramb)
  {
    AppMethodBeat.i(142736);
    this.Pcv.a(paramb);
    AppMethodBeat.o(142736);
    return this;
  }
  
  public final BlurView cv(float paramFloat)
  {
    this.Kx = paramFloat;
    return this;
  }
  
  public final BlurView cw(float paramFloat)
  {
    AppMethodBeat.i(142735);
    this.Pcv.cu(paramFloat);
    AppMethodBeat.o(142735);
    return this;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142728);
    super.dispatchDraw(paramCanvas);
    this.Pcv.gMm();
    AppMethodBeat.o(142728);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142725);
    if (this.Kx != 0.0F)
    {
      this.Pcx.reset();
      if (!this.PcA) {
        break label183;
      }
    }
    label183:
    for (this.Pcz = new float[] { this.Kx, this.Kx, this.Kx, this.Kx, this.Kx, this.Kx, this.Kx, this.Kx };; this.Pcz = new float[] { this.Kx, this.Kx, this.Kx, this.Kx, 0.0F, 0.0F, 0.0F, 0.0F })
    {
      this.Pcy.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.Pcx.addRoundRect(this.Pcy, this.Pcz, Path.Direction.CCW);
      paramCanvas.clipPath(this.Pcx);
      if (!paramCanvas.isHardwareAccelerated()) {
        break;
      }
      this.Pcv.z(paramCanvas);
      if (this.Pcw != 0) {
        paramCanvas.drawColor(this.Pcw);
      }
      super.draw(paramCanvas);
      AppMethodBeat.o(142725);
      return;
    }
    if (!isHardwareAccelerated()) {
      super.draw(paramCanvas);
    }
    AppMethodBeat.o(142725);
  }
  
  public final BlurView gMr()
  {
    this.PcA = true;
    return this;
  }
  
  public final BlurView gMs()
  {
    AppMethodBeat.i(142733);
    this.Pcv.gMo();
    AppMethodBeat.o(142733);
    return this;
  }
  
  public final BlurView gMt()
  {
    AppMethodBeat.i(142739);
    this.Pcv.gMp();
    AppMethodBeat.o(142739);
    return this;
  }
  
  public c getBlurController()
  {
    return this.Pcv;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(142730);
    super.onAttachedToWindow();
    if (isHardwareAccelerated()) {
      this.Pcv.BI(true);
    }
    AppMethodBeat.o(142730);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142729);
    super.onDetachedFromWindow();
    this.Pcv.BI(false);
    AppMethodBeat.o(142729);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142727);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.Pcv.gMn();
    AppMethodBeat.o(142727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.blur.BlurView
 * JD-Core Version:    0.7.0.1
 */