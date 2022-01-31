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
import com.tencent.mm.ad.a.a;

public class BlurView
  extends FrameLayout
{
  private static final String TAG;
  public float kq;
  c zuP;
  private int zuQ;
  private final Path zuR;
  private final RectF zuS;
  private float[] zuT;
  public boolean zuU;
  
  static
  {
    AppMethodBeat.i(155376);
    TAG = BlurView.class.getSimpleName();
    AppMethodBeat.o(155376);
  }
  
  public BlurView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(155356);
    this.zuP = dFp();
    this.kq = 0.0F;
    this.zuR = new Path();
    this.zuS = new RectF();
    this.zuU = false;
    init(null, 0);
    AppMethodBeat.o(155356);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(155357);
    this.zuP = dFp();
    this.kq = 0.0F;
    this.zuR = new Path();
    this.zuS = new RectF();
    this.zuU = false;
    init(paramAttributeSet, 0);
    AppMethodBeat.o(155357);
  }
  
  public BlurView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(155358);
    this.zuP = dFp();
    this.kq = 0.0F;
    this.zuR = new Path();
    this.zuS = new RectF();
    this.zuU = false;
    init(paramAttributeSet, paramInt);
    AppMethodBeat.o(155358);
  }
  
  private c dFp()
  {
    AppMethodBeat.i(155375);
    BlurView.2 local2 = new BlurView.2(this);
    AppMethodBeat.o(155375);
    return local2;
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(155359);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.BlurView, paramInt, 0);
    this.zuQ = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    AppMethodBeat.o(155359);
  }
  
  private void setBlurController(c paramc)
  {
    AppMethodBeat.i(155366);
    this.zuP.destroy();
    this.zuP = paramc;
    AppMethodBeat.o(155366);
  }
  
  public final BlurView Pd(int paramInt)
  {
    AppMethodBeat.i(155367);
    if (paramInt != this.zuQ)
    {
      this.zuQ = paramInt;
      invalidate();
    }
    AppMethodBeat.o(155367);
    return this;
  }
  
  public final BlurView Pe(int paramInt)
  {
    AppMethodBeat.i(155373);
    this.zuP.Pc(paramInt);
    AppMethodBeat.o(155373);
    return this;
  }
  
  public final BlurView b(b paramb)
  {
    AppMethodBeat.i(155371);
    this.zuP.a(paramb);
    AppMethodBeat.o(155371);
    return this;
  }
  
  public final BlurView bw(float paramFloat)
  {
    this.kq = paramFloat;
    return this;
  }
  
  public final BlurView bx(float paramFloat)
  {
    AppMethodBeat.i(155370);
    this.zuP.bv(paramFloat);
    AppMethodBeat.o(155370);
    return this;
  }
  
  public final BlurView dFn()
  {
    AppMethodBeat.i(155368);
    this.zuP.dFk();
    AppMethodBeat.o(155368);
    return this;
  }
  
  public final BlurView dFo()
  {
    AppMethodBeat.i(155374);
    this.zuP.dFl();
    AppMethodBeat.o(155374);
    return this;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(155363);
    super.dispatchDraw(paramCanvas);
    this.zuP.dFi();
    AppMethodBeat.o(155363);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(155360);
    if (this.kq != 0.0F)
    {
      this.zuR.reset();
      if (!this.zuU) {
        break label183;
      }
    }
    label183:
    for (this.zuT = new float[] { this.kq, this.kq, this.kq, this.kq, this.kq, this.kq, this.kq, this.kq };; this.zuT = new float[] { this.kq, this.kq, this.kq, this.kq, 0.0F, 0.0F, 0.0F, 0.0F })
    {
      this.zuS.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.zuR.addRoundRect(this.zuS, this.zuT, Path.Direction.CCW);
      paramCanvas.clipPath(this.zuR);
      if (!paramCanvas.isHardwareAccelerated()) {
        break;
      }
      this.zuP.n(paramCanvas);
      if (this.zuQ != 0) {
        paramCanvas.drawColor(this.zuQ);
      }
      super.draw(paramCanvas);
      AppMethodBeat.o(155360);
      return;
    }
    if (!isHardwareAccelerated()) {
      super.draw(paramCanvas);
    }
    AppMethodBeat.o(155360);
  }
  
  public c getBlurController()
  {
    return this.zuP;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(155365);
    super.onAttachedToWindow();
    if (isHardwareAccelerated()) {
      this.zuP.qP(true);
    }
    AppMethodBeat.o(155365);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(155364);
    super.onDetachedFromWindow();
    this.zuP.qP(false);
    AppMethodBeat.o(155364);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(155362);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.zuP.dFj();
    AppMethodBeat.o(155362);
  }
  
  public final BlurView qQ(boolean paramBoolean)
  {
    AppMethodBeat.i(155361);
    post(new BlurView.1(this, paramBoolean));
    AppMethodBeat.o(155361);
    return this;
  }
  
  public final BlurView t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(155369);
    paramViewGroup = new a(this, paramViewGroup);
    setBlurController(paramViewGroup);
    if (!isHardwareAccelerated()) {
      paramViewGroup.qP(false);
    }
    AppMethodBeat.o(155369);
    return this;
  }
  
  public final BlurView x(Drawable paramDrawable)
  {
    AppMethodBeat.i(155372);
    this.zuP.w(paramDrawable);
    AppMethodBeat.o(155372);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.blur.BlurView
 * JD-Core Version:    0.7.0.1
 */