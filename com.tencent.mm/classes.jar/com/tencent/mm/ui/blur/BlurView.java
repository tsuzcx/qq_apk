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
  c HIK;
  private int HIL;
  private final Path HIM;
  private final RectF HIN;
  private float[] HIO;
  public boolean HIP;
  public float Iv;
  
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
    this.HIK = fjV();
    this.Iv = 0.0F;
    this.HIM = new Path();
    this.HIN = new RectF();
    this.HIP = false;
    init(null, 0);
    AppMethodBeat.o(142721);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142722);
    this.HIK = fjV();
    this.Iv = 0.0F;
    this.HIM = new Path();
    this.HIN = new RectF();
    this.HIP = false;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(142722);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142723);
    this.HIK = fjV();
    this.Iv = 0.0F;
    this.HIM = new Path();
    this.HIN = new RectF();
    this.HIP = false;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(142723);
  }
  
  private c fjV()
  {
    AppMethodBeat.i(142740);
    c local2 = new c()
    {
      public final void E(Drawable paramAnonymousDrawable) {}
      
      public final void a(b paramAnonymousb) {}
      
      public final void aat(int paramAnonymousInt) {}
      
      public final void bP(float paramAnonymousFloat) {}
      
      public final void destroy() {}
      
      public final void fjO() {}
      
      public final void fjP() {}
      
      public final void fjQ() {}
      
      public final void fjR() {}
      
      public final void q(Canvas paramAnonymousCanvas) {}
      
      public final void xa(boolean paramAnonymousBoolean) {}
      
      public final void xb(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(142740);
    return local2;
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142724);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.BlurView, paramInt, 0);
    this.HIL = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    AppMethodBeat.o(142724);
  }
  
  private void setBlurController(c paramc)
  {
    AppMethodBeat.i(142731);
    this.HIK.destroy();
    this.HIK = paramc;
    AppMethodBeat.o(142731);
  }
  
  public final BlurView F(Drawable paramDrawable)
  {
    AppMethodBeat.i(142737);
    this.HIK.E(paramDrawable);
    AppMethodBeat.o(142737);
    return this;
  }
  
  public final BlurView aau(int paramInt)
  {
    AppMethodBeat.i(142732);
    if (paramInt != this.HIL)
    {
      this.HIL = paramInt;
      invalidate();
    }
    AppMethodBeat.o(142732);
    return this;
  }
  
  public final BlurView aav(int paramInt)
  {
    AppMethodBeat.i(142738);
    this.HIK.aat(paramInt);
    AppMethodBeat.o(142738);
    return this;
  }
  
  public final BlurView b(b paramb)
  {
    AppMethodBeat.i(142736);
    this.HIK.a(paramb);
    AppMethodBeat.o(142736);
    return this;
  }
  
  public final BlurView bQ(float paramFloat)
  {
    this.Iv = paramFloat;
    return this;
  }
  
  public final BlurView bR(float paramFloat)
  {
    AppMethodBeat.i(142735);
    this.HIK.bP(paramFloat);
    AppMethodBeat.o(142735);
    return this;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142728);
    super.dispatchDraw(paramCanvas);
    this.HIK.fjO();
    AppMethodBeat.o(142728);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142725);
    if (this.Iv != 0.0F)
    {
      this.HIM.reset();
      if (!this.HIP) {
        break label183;
      }
    }
    label183:
    for (this.HIO = new float[] { this.Iv, this.Iv, this.Iv, this.Iv, this.Iv, this.Iv, this.Iv, this.Iv };; this.HIO = new float[] { this.Iv, this.Iv, this.Iv, this.Iv, 0.0F, 0.0F, 0.0F, 0.0F })
    {
      this.HIN.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.HIM.addRoundRect(this.HIN, this.HIO, Path.Direction.CCW);
      paramCanvas.clipPath(this.HIM);
      if (!paramCanvas.isHardwareAccelerated()) {
        break;
      }
      this.HIK.q(paramCanvas);
      if (this.HIL != 0) {
        paramCanvas.drawColor(this.HIL);
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
  
  public final BlurView fjT()
  {
    AppMethodBeat.i(142733);
    this.HIK.fjQ();
    AppMethodBeat.o(142733);
    return this;
  }
  
  public final BlurView fjU()
  {
    AppMethodBeat.i(142739);
    this.HIK.fjR();
    AppMethodBeat.o(142739);
    return this;
  }
  
  public c getBlurController()
  {
    return this.HIK;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(142730);
    super.onAttachedToWindow();
    if (isHardwareAccelerated()) {
      this.HIK.xb(true);
    }
    AppMethodBeat.o(142730);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142729);
    super.onDetachedFromWindow();
    this.HIK.xb(false);
    AppMethodBeat.o(142729);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142727);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.HIK.fjP();
    AppMethodBeat.o(142727);
  }
  
  public final BlurView x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142734);
    paramViewGroup = new a(this, paramViewGroup);
    setBlurController(paramViewGroup);
    if (!isHardwareAccelerated()) {
      paramViewGroup.xb(false);
    }
    AppMethodBeat.o(142734);
    return this;
  }
  
  public final BlurView xc(boolean paramBoolean)
  {
    AppMethodBeat.i(142726);
    post(new BlurView.1(this, paramBoolean));
    AppMethodBeat.o(142726);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.blur.BlurView
 * JD-Core Version:    0.7.0.1
 */