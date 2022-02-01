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
  c JRr;
  private int JRs;
  private final Path JRt;
  private final RectF JRu;
  private float[] JRv;
  public boolean JRw;
  public float Kn;
  
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
    this.JRr = fEm();
    this.Kn = 0.0F;
    this.JRt = new Path();
    this.JRu = new RectF();
    this.JRw = false;
    init(null, 0);
    AppMethodBeat.o(142721);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142722);
    this.JRr = fEm();
    this.Kn = 0.0F;
    this.JRt = new Path();
    this.JRu = new RectF();
    this.JRw = false;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(142722);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142723);
    this.JRr = fEm();
    this.Kn = 0.0F;
    this.JRt = new Path();
    this.JRu = new RectF();
    this.JRw = false;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(142723);
  }
  
  private c fEm()
  {
    AppMethodBeat.i(142740);
    c local2 = new c()
    {
      public final void F(Drawable paramAnonymousDrawable) {}
      
      public final void a(b paramAnonymousb) {}
      
      public final void adl(int paramAnonymousInt) {}
      
      public final void bS(float paramAnonymousFloat) {}
      
      public final void destroy() {}
      
      public final void fEf() {}
      
      public final void fEg() {}
      
      public final void fEh() {}
      
      public final void fEi() {}
      
      public final void p(Canvas paramAnonymousCanvas) {}
      
      public final void xS(boolean paramAnonymousBoolean) {}
      
      public final void xT(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(142740);
    return local2;
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142724);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.BlurView, paramInt, 0);
    this.JRs = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    AppMethodBeat.o(142724);
  }
  
  private void setBlurController(c paramc)
  {
    AppMethodBeat.i(142731);
    this.JRr.destroy();
    this.JRr = paramc;
    AppMethodBeat.o(142731);
  }
  
  public final BlurView B(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142734);
    paramViewGroup = new a(this, paramViewGroup);
    setBlurController(paramViewGroup);
    if (!isHardwareAccelerated()) {
      paramViewGroup.xT(false);
    }
    AppMethodBeat.o(142734);
    return this;
  }
  
  public final BlurView G(Drawable paramDrawable)
  {
    AppMethodBeat.i(142737);
    this.JRr.F(paramDrawable);
    AppMethodBeat.o(142737);
    return this;
  }
  
  public final BlurView adm(int paramInt)
  {
    AppMethodBeat.i(142732);
    if (paramInt != this.JRs)
    {
      this.JRs = paramInt;
      invalidate();
    }
    AppMethodBeat.o(142732);
    return this;
  }
  
  public final BlurView adn(int paramInt)
  {
    AppMethodBeat.i(142738);
    this.JRr.adl(paramInt);
    AppMethodBeat.o(142738);
    return this;
  }
  
  public final BlurView b(b paramb)
  {
    AppMethodBeat.i(142736);
    this.JRr.a(paramb);
    AppMethodBeat.o(142736);
    return this;
  }
  
  public final BlurView bT(float paramFloat)
  {
    this.Kn = paramFloat;
    return this;
  }
  
  public final BlurView bU(float paramFloat)
  {
    AppMethodBeat.i(142735);
    this.JRr.bS(paramFloat);
    AppMethodBeat.o(142735);
    return this;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142728);
    super.dispatchDraw(paramCanvas);
    this.JRr.fEf();
    AppMethodBeat.o(142728);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142725);
    if (this.Kn != 0.0F)
    {
      this.JRt.reset();
      if (!this.JRw) {
        break label183;
      }
    }
    label183:
    for (this.JRv = new float[] { this.Kn, this.Kn, this.Kn, this.Kn, this.Kn, this.Kn, this.Kn, this.Kn };; this.JRv = new float[] { this.Kn, this.Kn, this.Kn, this.Kn, 0.0F, 0.0F, 0.0F, 0.0F })
    {
      this.JRu.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.JRt.addRoundRect(this.JRu, this.JRv, Path.Direction.CCW);
      paramCanvas.clipPath(this.JRt);
      if (!paramCanvas.isHardwareAccelerated()) {
        break;
      }
      this.JRr.p(paramCanvas);
      if (this.JRs != 0) {
        paramCanvas.drawColor(this.JRs);
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
  
  public final BlurView fEk()
  {
    AppMethodBeat.i(142733);
    this.JRr.fEh();
    AppMethodBeat.o(142733);
    return this;
  }
  
  public final BlurView fEl()
  {
    AppMethodBeat.i(142739);
    this.JRr.fEi();
    AppMethodBeat.o(142739);
    return this;
  }
  
  public c getBlurController()
  {
    return this.JRr;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(142730);
    super.onAttachedToWindow();
    if (isHardwareAccelerated()) {
      this.JRr.xT(true);
    }
    AppMethodBeat.o(142730);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142729);
    super.onDetachedFromWindow();
    this.JRr.xT(false);
    AppMethodBeat.o(142729);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142727);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.JRr.fEg();
    AppMethodBeat.o(142727);
  }
  
  public final BlurView xU(final boolean paramBoolean)
  {
    AppMethodBeat.i(142726);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142720);
        BlurView.this.JRr.xS(paramBoolean);
        AppMethodBeat.o(142720);
      }
    });
    AppMethodBeat.o(142726);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.blur.BlurView
 * JD-Core Version:    0.7.0.1
 */