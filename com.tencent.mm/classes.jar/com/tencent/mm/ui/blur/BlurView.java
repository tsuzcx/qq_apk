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
  c JwB;
  private int JwC;
  private final Path JwD;
  private final RectF JwE;
  private float[] JwF;
  public boolean JwG;
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
    this.JwB = fAk();
    this.Kn = 0.0F;
    this.JwD = new Path();
    this.JwE = new RectF();
    this.JwG = false;
    init(null, 0);
    AppMethodBeat.o(142721);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142722);
    this.JwB = fAk();
    this.Kn = 0.0F;
    this.JwD = new Path();
    this.JwE = new RectF();
    this.JwG = false;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(142722);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142723);
    this.JwB = fAk();
    this.Kn = 0.0F;
    this.JwD = new Path();
    this.JwE = new RectF();
    this.JwG = false;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(142723);
  }
  
  private c fAk()
  {
    AppMethodBeat.i(142740);
    c local2 = new c()
    {
      public final void E(Drawable paramAnonymousDrawable) {}
      
      public final void a(b paramAnonymousb) {}
      
      public final void acD(int paramAnonymousInt) {}
      
      public final void bU(float paramAnonymousFloat) {}
      
      public final void destroy() {}
      
      public final void fAd() {}
      
      public final void fAe() {}
      
      public final void fAf() {}
      
      public final void fAg() {}
      
      public final void p(Canvas paramAnonymousCanvas) {}
      
      public final void xL(boolean paramAnonymousBoolean) {}
      
      public final void xM(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(142740);
    return local2;
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142724);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.BlurView, paramInt, 0);
    this.JwC = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    AppMethodBeat.o(142724);
  }
  
  private void setBlurController(c paramc)
  {
    AppMethodBeat.i(142731);
    this.JwB.destroy();
    this.JwB = paramc;
    AppMethodBeat.o(142731);
  }
  
  public final BlurView B(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142734);
    paramViewGroup = new a(this, paramViewGroup);
    setBlurController(paramViewGroup);
    if (!isHardwareAccelerated()) {
      paramViewGroup.xM(false);
    }
    AppMethodBeat.o(142734);
    return this;
  }
  
  public final BlurView F(Drawable paramDrawable)
  {
    AppMethodBeat.i(142737);
    this.JwB.E(paramDrawable);
    AppMethodBeat.o(142737);
    return this;
  }
  
  public final BlurView acE(int paramInt)
  {
    AppMethodBeat.i(142732);
    if (paramInt != this.JwC)
    {
      this.JwC = paramInt;
      invalidate();
    }
    AppMethodBeat.o(142732);
    return this;
  }
  
  public final BlurView acF(int paramInt)
  {
    AppMethodBeat.i(142738);
    this.JwB.acD(paramInt);
    AppMethodBeat.o(142738);
    return this;
  }
  
  public final BlurView b(b paramb)
  {
    AppMethodBeat.i(142736);
    this.JwB.a(paramb);
    AppMethodBeat.o(142736);
    return this;
  }
  
  public final BlurView bV(float paramFloat)
  {
    this.Kn = paramFloat;
    return this;
  }
  
  public final BlurView bW(float paramFloat)
  {
    AppMethodBeat.i(142735);
    this.JwB.bU(paramFloat);
    AppMethodBeat.o(142735);
    return this;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142728);
    super.dispatchDraw(paramCanvas);
    this.JwB.fAd();
    AppMethodBeat.o(142728);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142725);
    if (this.Kn != 0.0F)
    {
      this.JwD.reset();
      if (!this.JwG) {
        break label183;
      }
    }
    label183:
    for (this.JwF = new float[] { this.Kn, this.Kn, this.Kn, this.Kn, this.Kn, this.Kn, this.Kn, this.Kn };; this.JwF = new float[] { this.Kn, this.Kn, this.Kn, this.Kn, 0.0F, 0.0F, 0.0F, 0.0F })
    {
      this.JwE.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.JwD.addRoundRect(this.JwE, this.JwF, Path.Direction.CCW);
      paramCanvas.clipPath(this.JwD);
      if (!paramCanvas.isHardwareAccelerated()) {
        break;
      }
      this.JwB.p(paramCanvas);
      if (this.JwC != 0) {
        paramCanvas.drawColor(this.JwC);
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
  
  public final BlurView fAi()
  {
    AppMethodBeat.i(142733);
    this.JwB.fAf();
    AppMethodBeat.o(142733);
    return this;
  }
  
  public final BlurView fAj()
  {
    AppMethodBeat.i(142739);
    this.JwB.fAg();
    AppMethodBeat.o(142739);
    return this;
  }
  
  public c getBlurController()
  {
    return this.JwB;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(142730);
    super.onAttachedToWindow();
    if (isHardwareAccelerated()) {
      this.JwB.xM(true);
    }
    AppMethodBeat.o(142730);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142729);
    super.onDetachedFromWindow();
    this.JwB.xM(false);
    AppMethodBeat.o(142729);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142727);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.JwB.fAe();
    AppMethodBeat.o(142727);
  }
  
  public final BlurView xN(final boolean paramBoolean)
  {
    AppMethodBeat.i(142726);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142720);
        BlurView.this.JwB.xL(paramBoolean);
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