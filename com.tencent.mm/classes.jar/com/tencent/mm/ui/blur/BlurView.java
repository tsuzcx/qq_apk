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
  c WvH;
  private int WvI;
  private final Path WvJ;
  private final RectF WvK;
  private float[] WvL;
  public boolean WvM;
  public float zj;
  
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
    this.WvH = hLB();
    this.zj = 0.0F;
    this.WvJ = new Path();
    this.WvK = new RectF();
    this.WvM = false;
    init(null, 0);
    AppMethodBeat.o(142721);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142722);
    this.WvH = hLB();
    this.zj = 0.0F;
    this.WvJ = new Path();
    this.WvK = new RectF();
    this.WvM = false;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(142722);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142723);
    this.WvH = hLB();
    this.zj = 0.0F;
    this.WvJ = new Path();
    this.WvK = new RectF();
    this.WvM = false;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(142723);
  }
  
  private c hLB()
  {
    AppMethodBeat.i(142740);
    c local2 = new c()
    {
      public final void C(Canvas paramAnonymousCanvas) {}
      
      public final void Gb(boolean paramAnonymousBoolean) {}
      
      public final void Gc(boolean paramAnonymousBoolean) {}
      
      public final void K(Drawable paramAnonymousDrawable) {}
      
      public final void a(b paramAnonymousb) {}
      
      public final void auV(int paramAnonymousInt) {}
      
      public final void cM(float paramAnonymousFloat) {}
      
      public final void destroy() {}
      
      public final void hLt() {}
      
      public final void hLu() {}
      
      public final void hLv() {}
      
      public final void hLw() {}
    };
    AppMethodBeat.o(142740);
    return local2;
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142724);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.m.BlurView, paramInt, 0);
    this.WvI = paramAttributeSet.getColor(a.m.BlurView_blurOverlayColor, 0);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    AppMethodBeat.o(142724);
  }
  
  private void setBlurController(c paramc)
  {
    AppMethodBeat.i(142731);
    this.WvH.destroy();
    this.WvH = paramc;
    AppMethodBeat.o(142731);
  }
  
  public final BlurView Gd(final boolean paramBoolean)
  {
    AppMethodBeat.i(142726);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142720);
        BlurView.this.WvH.Gb(paramBoolean);
        AppMethodBeat.o(142720);
      }
    });
    AppMethodBeat.o(142726);
    return this;
  }
  
  public final BlurView L(Drawable paramDrawable)
  {
    AppMethodBeat.i(142737);
    this.WvH.K(paramDrawable);
    AppMethodBeat.o(142737);
    return this;
  }
  
  public final BlurView T(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142734);
    paramViewGroup = new a(this, paramViewGroup);
    setBlurController(paramViewGroup);
    if (!isHardwareAccelerated()) {
      paramViewGroup.Gc(false);
    }
    AppMethodBeat.o(142734);
    return this;
  }
  
  public final BlurView auW(int paramInt)
  {
    AppMethodBeat.i(142732);
    if (paramInt != this.WvI)
    {
      this.WvI = paramInt;
      invalidate();
    }
    AppMethodBeat.o(142732);
    return this;
  }
  
  public final BlurView auX(int paramInt)
  {
    AppMethodBeat.i(142738);
    this.WvH.auV(paramInt);
    AppMethodBeat.o(142738);
    return this;
  }
  
  public final BlurView b(b paramb)
  {
    AppMethodBeat.i(142736);
    this.WvH.a(paramb);
    AppMethodBeat.o(142736);
    return this;
  }
  
  public final BlurView cN(float paramFloat)
  {
    this.zj = paramFloat;
    return this;
  }
  
  public final BlurView cO(float paramFloat)
  {
    AppMethodBeat.i(142735);
    this.WvH.cM(paramFloat);
    AppMethodBeat.o(142735);
    return this;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142728);
    super.dispatchDraw(paramCanvas);
    this.WvH.hLt();
    AppMethodBeat.o(142728);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142725);
    if (this.zj != 0.0F)
    {
      this.WvJ.reset();
      if (!this.WvM) {
        break label183;
      }
    }
    label183:
    for (this.WvL = new float[] { this.zj, this.zj, this.zj, this.zj, this.zj, this.zj, this.zj, this.zj };; this.WvL = new float[] { this.zj, this.zj, this.zj, this.zj, 0.0F, 0.0F, 0.0F, 0.0F })
    {
      this.WvK.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.WvJ.addRoundRect(this.WvK, this.WvL, Path.Direction.CCW);
      paramCanvas.clipPath(this.WvJ);
      if (!paramCanvas.isHardwareAccelerated()) {
        break;
      }
      this.WvH.C(paramCanvas);
      if (this.WvI != 0) {
        paramCanvas.drawColor(this.WvI);
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
  
  public c getBlurController()
  {
    return this.WvH;
  }
  
  public final BlurView hLA()
  {
    AppMethodBeat.i(142739);
    this.WvH.hLw();
    AppMethodBeat.o(142739);
    return this;
  }
  
  public final BlurView hLy()
  {
    this.WvM = true;
    return this;
  }
  
  public final BlurView hLz()
  {
    AppMethodBeat.i(142733);
    this.WvH.hLv();
    AppMethodBeat.o(142733);
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(142730);
    super.onAttachedToWindow();
    if (isHardwareAccelerated()) {
      this.WvH.Gc(true);
    }
    AppMethodBeat.o(142730);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142729);
    super.onDetachedFromWindow();
    this.WvH.Gc(false);
    AppMethodBeat.o(142729);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142727);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.WvH.hLu();
    AppMethodBeat.o(142727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.blur.BlurView
 * JD-Core Version:    0.7.0.1
 */