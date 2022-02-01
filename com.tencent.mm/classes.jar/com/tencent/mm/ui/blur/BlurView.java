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
import com.tencent.mm.af.a.a;

public class BlurView
  extends FrameLayout
{
  private static final String TAG;
  c GiV;
  private int GiW;
  private final Path GiX;
  private final RectF GiY;
  private float[] GiZ;
  public boolean Gja;
  public float Hx;
  
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
    this.GiV = eUi();
    this.Hx = 0.0F;
    this.GiX = new Path();
    this.GiY = new RectF();
    this.Gja = false;
    init(null, 0);
    AppMethodBeat.o(142721);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142722);
    this.GiV = eUi();
    this.Hx = 0.0F;
    this.GiX = new Path();
    this.GiY = new RectF();
    this.Gja = false;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(142722);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142723);
    this.GiV = eUi();
    this.Hx = 0.0F;
    this.GiX = new Path();
    this.GiY = new RectF();
    this.Gja = false;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(142723);
  }
  
  private c eUi()
  {
    AppMethodBeat.i(142740);
    c local2 = new c()
    {
      public final void F(Drawable paramAnonymousDrawable) {}
      
      public final void Yi(int paramAnonymousInt) {}
      
      public final void a(b paramAnonymousb) {}
      
      public final void bH(float paramAnonymousFloat) {}
      
      public final void destroy() {}
      
      public final void eUb() {}
      
      public final void eUc() {}
      
      public final void eUd() {}
      
      public final void eUe() {}
      
      public final void q(Canvas paramAnonymousCanvas) {}
      
      public final void vW(boolean paramAnonymousBoolean) {}
      
      public final void vX(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(142740);
    return local2;
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142724);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.BlurView, paramInt, 0);
    this.GiW = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    AppMethodBeat.o(142724);
  }
  
  private void setBlurController(c paramc)
  {
    AppMethodBeat.i(142731);
    this.GiV.destroy();
    this.GiV = paramc;
    AppMethodBeat.o(142731);
  }
  
  public final BlurView G(Drawable paramDrawable)
  {
    AppMethodBeat.i(142737);
    this.GiV.F(paramDrawable);
    AppMethodBeat.o(142737);
    return this;
  }
  
  public final BlurView Yj(int paramInt)
  {
    AppMethodBeat.i(142732);
    if (paramInt != this.GiW)
    {
      this.GiW = paramInt;
      invalidate();
    }
    AppMethodBeat.o(142732);
    return this;
  }
  
  public final BlurView Yk(int paramInt)
  {
    AppMethodBeat.i(142738);
    this.GiV.Yi(paramInt);
    AppMethodBeat.o(142738);
    return this;
  }
  
  public final BlurView b(b paramb)
  {
    AppMethodBeat.i(142736);
    this.GiV.a(paramb);
    AppMethodBeat.o(142736);
    return this;
  }
  
  public final BlurView bI(float paramFloat)
  {
    this.Hx = paramFloat;
    return this;
  }
  
  public final BlurView bJ(float paramFloat)
  {
    AppMethodBeat.i(142735);
    this.GiV.bH(paramFloat);
    AppMethodBeat.o(142735);
    return this;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142728);
    super.dispatchDraw(paramCanvas);
    this.GiV.eUb();
    AppMethodBeat.o(142728);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142725);
    if (this.Hx != 0.0F)
    {
      this.GiX.reset();
      if (!this.Gja) {
        break label183;
      }
    }
    label183:
    for (this.GiZ = new float[] { this.Hx, this.Hx, this.Hx, this.Hx, this.Hx, this.Hx, this.Hx, this.Hx };; this.GiZ = new float[] { this.Hx, this.Hx, this.Hx, this.Hx, 0.0F, 0.0F, 0.0F, 0.0F })
    {
      this.GiY.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.GiX.addRoundRect(this.GiY, this.GiZ, Path.Direction.CCW);
      paramCanvas.clipPath(this.GiX);
      if (!paramCanvas.isHardwareAccelerated()) {
        break;
      }
      this.GiV.q(paramCanvas);
      if (this.GiW != 0) {
        paramCanvas.drawColor(this.GiW);
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
  
  public final BlurView eUg()
  {
    AppMethodBeat.i(142733);
    this.GiV.eUd();
    AppMethodBeat.o(142733);
    return this;
  }
  
  public final BlurView eUh()
  {
    AppMethodBeat.i(142739);
    this.GiV.eUe();
    AppMethodBeat.o(142739);
    return this;
  }
  
  public c getBlurController()
  {
    return this.GiV;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(142730);
    super.onAttachedToWindow();
    if (isHardwareAccelerated()) {
      this.GiV.vX(true);
    }
    AppMethodBeat.o(142730);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142729);
    super.onDetachedFromWindow();
    this.GiV.vX(false);
    AppMethodBeat.o(142729);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142727);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.GiV.eUc();
    AppMethodBeat.o(142727);
  }
  
  public final BlurView vY(final boolean paramBoolean)
  {
    AppMethodBeat.i(142726);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142720);
        BlurView.this.GiV.vW(paramBoolean);
        AppMethodBeat.o(142720);
      }
    });
    AppMethodBeat.o(142726);
    return this;
  }
  
  public final BlurView w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142734);
    paramViewGroup = new a(this, paramViewGroup);
    setBlurController(paramViewGroup);
    if (!isHardwareAccelerated()) {
      paramViewGroup.vX(false);
    }
    AppMethodBeat.o(142734);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.blur.BlurView
 * JD-Core Version:    0.7.0.1
 */