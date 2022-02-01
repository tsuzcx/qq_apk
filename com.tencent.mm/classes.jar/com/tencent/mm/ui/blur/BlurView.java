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
import com.tencent.mm.ah.a.m;

public class BlurView
  extends FrameLayout
{
  private static final String TAG;
  public float Rx;
  c aecY;
  private int aecZ;
  private final Path aeda;
  private final RectF aedb;
  private float[] aedc;
  public boolean aedd;
  
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
    this.aecY = joc();
    this.Rx = 0.0F;
    this.aeda = new Path();
    this.aedb = new RectF();
    this.aedd = false;
    init(null, 0);
    AppMethodBeat.o(142721);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142722);
    this.aecY = joc();
    this.Rx = 0.0F;
    this.aeda = new Path();
    this.aedb = new RectF();
    this.aedd = false;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(142722);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142723);
    this.aecY = joc();
    this.Rx = 0.0F;
    this.aeda = new Path();
    this.aedb = new RectF();
    this.aedd = false;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(142723);
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142724);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.m.BlurView, paramInt, 0);
    this.aecZ = paramAttributeSet.getColor(a.m.BlurView_blurOverlayColor, 0);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    AppMethodBeat.o(142724);
  }
  
  private c joc()
  {
    AppMethodBeat.i(142740);
    c local2 = new c()
    {
      public final void LN(boolean paramAnonymousBoolean) {}
      
      public final void LO(boolean paramAnonymousBoolean) {}
      
      public final void U(Drawable paramAnonymousDrawable) {}
      
      public final void a(b paramAnonymousb) {}
      
      public final void aBx(int paramAnonymousInt) {}
      
      public final void destroy() {}
      
      public final void ea(float paramAnonymousFloat) {}
      
      public final void jnV() {}
      
      public final void jnW() {}
      
      public final void jnX() {}
      
      public final void jnY() {}
      
      public final void x(Canvas paramAnonymousCanvas) {}
    };
    AppMethodBeat.o(142740);
    return local2;
  }
  
  private void setBlurController(c paramc)
  {
    AppMethodBeat.i(142731);
    this.aecY.destroy();
    this.aecY = paramc;
    AppMethodBeat.o(142731);
  }
  
  public final BlurView LP(boolean paramBoolean)
  {
    AppMethodBeat.i(142726);
    post(new BlurView.1(this, paramBoolean));
    AppMethodBeat.o(142726);
    return this;
  }
  
  public final BlurView V(Drawable paramDrawable)
  {
    AppMethodBeat.i(142737);
    this.aecY.U(paramDrawable);
    AppMethodBeat.o(142737);
    return this;
  }
  
  public final BlurView aBy(int paramInt)
  {
    AppMethodBeat.i(142732);
    if (paramInt != this.aecZ)
    {
      this.aecZ = paramInt;
      invalidate();
    }
    AppMethodBeat.o(142732);
    return this;
  }
  
  public final BlurView aBz(int paramInt)
  {
    AppMethodBeat.i(142738);
    this.aecY.aBx(paramInt);
    AppMethodBeat.o(142738);
    return this;
  }
  
  public final BlurView ad(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142734);
    paramViewGroup = new a(this, paramViewGroup);
    setBlurController(paramViewGroup);
    if (!isHardwareAccelerated()) {
      paramViewGroup.LO(false);
    }
    AppMethodBeat.o(142734);
    return this;
  }
  
  public final BlurView b(b paramb)
  {
    AppMethodBeat.i(142736);
    this.aecY.a(paramb);
    AppMethodBeat.o(142736);
    return this;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142728);
    super.dispatchDraw(paramCanvas);
    this.aecY.jnV();
    AppMethodBeat.o(142728);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142725);
    if (this.Rx != 0.0F)
    {
      this.aeda.reset();
      if (!this.aedd) {
        break label183;
      }
    }
    label183:
    for (this.aedc = new float[] { this.Rx, this.Rx, this.Rx, this.Rx, this.Rx, this.Rx, this.Rx, this.Rx };; this.aedc = new float[] { this.Rx, this.Rx, this.Rx, this.Rx, 0.0F, 0.0F, 0.0F, 0.0F })
    {
      this.aedb.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.aeda.addRoundRect(this.aedb, this.aedc, Path.Direction.CCW);
      paramCanvas.clipPath(this.aeda);
      if (!paramCanvas.isHardwareAccelerated()) {
        break;
      }
      this.aecY.x(paramCanvas);
      if (this.aecZ != 0) {
        paramCanvas.drawColor(this.aecZ);
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
  
  public final BlurView eb(float paramFloat)
  {
    AppMethodBeat.i(142735);
    this.aecY.ea(paramFloat);
    AppMethodBeat.o(142735);
    return this;
  }
  
  public c getBlurController()
  {
    return this.aecY;
  }
  
  public final BlurView joa()
  {
    AppMethodBeat.i(142733);
    this.aecY.jnX();
    AppMethodBeat.o(142733);
    return this;
  }
  
  public final BlurView job()
  {
    AppMethodBeat.i(142739);
    this.aecY.jnY();
    AppMethodBeat.o(142739);
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(142730);
    super.onAttachedToWindow();
    if (isHardwareAccelerated()) {
      this.aecY.LO(true);
    }
    AppMethodBeat.o(142730);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142729);
    super.onDetachedFromWindow();
    this.aecY.LO(false);
    AppMethodBeat.o(142729);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142727);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.aecY.jnW();
    AppMethodBeat.o(142727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.blur.BlurView
 * JD-Core Version:    0.7.0.1
 */