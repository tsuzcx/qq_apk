package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "effect", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "getEffect", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "setEffect", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;)V", "needScroll", "", "paint", "Landroid/graphics/Paint;", "scroller", "Landroid/widget/Scroller;", "scrolling", "spaceWidth", "", "textContent", "", "textHeight", "textWidth", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "checkLayout", "", "checkScroll", "computeScroll", "getLeftFadingEdgeStrength", "getRightFadingEdgeStrength", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setContent", "content", "textSize", "textColor", "setShadow", "setText", "text", "setTextBold", "bold", "setTextColor", "setTextSize", "Companion", "NoEffect", "ScrollEffect", "ScrollReverseEffect", "ScrollToNextEffect", "ViewProvider", "plugin-mv_release"})
public final class MusicMvMarqueeTextView
  extends View
{
  public static final MusicMvMarqueeTextView.a Gpf;
  public String GoY;
  private float GoZ;
  private float Gpa;
  private final Scroller Gpb;
  private boolean Gpc;
  private final d Gpd;
  private b Gpe;
  private float bzI;
  public final Paint paint;
  private boolean scrolling;
  
  static
  {
    AppMethodBeat.i(241598);
    Gpf = new MusicMvMarqueeTextView.a((byte)0);
    AppMethodBeat.o(241598);
  }
  
  public MusicMvMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public MusicMvMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(241595);
    this.paint = new Paint(1);
    this.GoY = "";
    this.Gpb = new Scroller(paramContext, (Interpolator)new LinearInterpolator());
    this.scrolling = true;
    this.Gpd = ((d)new e(this));
    this.Gpe = ((b)new c(this.Gpd));
    this.Gpa = (a.fromDPToPix(paramContext, 8) * 4.0F);
    AppMethodBeat.o(241595);
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(241593);
    if (this.Gpb.computeScrollOffset())
    {
      scrollTo(this.Gpb.getCurrX(), this.Gpb.getCurrY());
      postInvalidate();
    }
    AppMethodBeat.o(241593);
  }
  
  public final void fhN()
  {
    AppMethodBeat.i(241584);
    float f1 = this.paint.measureText(this.GoY);
    float f2 = this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top;
    if ((this.bzI != f1) || (this.GoZ != f2))
    {
      this.bzI = f1;
      this.GoZ = f2;
      requestLayout();
    }
    AppMethodBeat.o(241584);
  }
  
  public final void fhO()
  {
    AppMethodBeat.i(241586);
    if (getWidth() >= this.bzI)
    {
      this.Gpc = false;
      this.Gpe.stop();
      scrollTo(0, 0);
      AppMethodBeat.o(241586);
      return;
    }
    this.Gpc = true;
    if (this.scrolling) {
      this.Gpe.start();
    }
    AppMethodBeat.o(241586);
  }
  
  public final b getEffect()
  {
    return this.Gpe;
  }
  
  protected final float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(241592);
    if ((!this.Gpc) || (this.Gpe.fhP()))
    {
      AppMethodBeat.o(241592);
      return 0.0F;
    }
    AppMethodBeat.o(241592);
    return 1.0F;
  }
  
  protected final float getRightFadingEdgeStrength()
  {
    if (!this.Gpc) {
      return 0.0F;
    }
    return 1.0F;
  }
  
  public final d getViewProvider()
  {
    return this.Gpd;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(241594);
    p.k(paramCanvas, "canvas");
    int i = paramCanvas.save();
    paramCanvas.translate(0.0F, getPaddingTop() - this.paint.getFontMetrics().top);
    paramCanvas.drawText(this.GoY, 0.0F, 0.0F, this.paint);
    if (this.Gpc)
    {
      paramCanvas.translate(this.bzI + this.Gpa, 0.0F);
      paramCanvas.drawText(this.GoY, 0.0F, 0.0F, this.paint);
    }
    paramCanvas.restoreToCount(i);
    if (this.Gpc) {
      this.Gpe.onDraw();
    }
    AppMethodBeat.o(241594);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241588);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = (int)this.GoZ;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    paramInt1 = paramInt2;
    if (m == -2147483648)
    {
      paramInt1 = paramInt2;
      if (paramInt2 >= this.bzI) {
        paramInt1 = (int)this.bzI;
      }
    }
    setMeasuredDimension(paramInt1, i + j + k);
    AppMethodBeat.o(241588);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241591);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    fhO();
    AppMethodBeat.o(241591);
  }
  
  public final void setEffect(b paramb)
  {
    AppMethodBeat.i(241571);
    p.k(paramb, "<set-?>");
    this.Gpe = paramb;
    AppMethodBeat.o(241571);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(241574);
    if ((p.h(this.GoY, paramString) ^ true))
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.GoY = str;
      fhN();
      this.Gpe.stop();
      scrollTo(0, 0);
      fhO();
    }
    AppMethodBeat.o(241574);
  }
  
  public final void setTextBold(boolean paramBoolean)
  {
    AppMethodBeat.i(241581);
    this.paint.setFakeBoldText(paramBoolean);
    AppMethodBeat.o(241581);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(241578);
    if (this.paint.getColor() != paramInt)
    {
      this.paint.setColor(paramInt);
      invalidate();
    }
    AppMethodBeat.o(241578);
  }
  
  public final void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(241576);
    if (this.paint.getTextSize() != paramFloat)
    {
      this.paint.setTextSize(paramFloat);
      fhN();
      fhO();
    }
    AppMethodBeat.o(241576);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract boolean fhP();
    
    public abstract void onDraw();
    
    public abstract void start();
    
    public abstract void stop();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollToNextEffect;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;)V", "scrollInterval", "", "getScrollInterval", "()J", "setScrollInterval", "(J)V", "scrollSpeed", "", "getScrollSpeed", "()F", "setScrollSpeed", "(F)V", "startScrollTask", "Ljava/lang/Runnable;", "state", "", "getState", "()I", "setState", "(I)V", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "Companion", "plugin-mv_release"})
  public static final class c
    implements MusicMvMarqueeTextView.b
  {
    public static final MusicMvMarqueeTextView.c.a Gpj;
    final MusicMvMarqueeTextView.d Gpd;
    float Gpg;
    private long Gph;
    private final Runnable Gpi;
    int state;
    
    static
    {
      AppMethodBeat.i(233694);
      Gpj = new MusicMvMarqueeTextView.c.a((byte)0);
      AppMethodBeat.o(233694);
    }
    
    public c(MusicMvMarqueeTextView.d paramd)
    {
      AppMethodBeat.i(233693);
      this.Gpd = paramd;
      this.Gpg = 200.0F;
      this.Gph = 5000L;
      this.Gpi = ((Runnable)new b(this));
      AppMethodBeat.o(233693);
    }
    
    public final boolean fhP()
    {
      AppMethodBeat.i(233683);
      if (this.Gpd.getView().getScrollX() == 0)
      {
        AppMethodBeat.o(233683);
        return true;
      }
      AppMethodBeat.o(233683);
      return false;
    }
    
    public final void onDraw()
    {
      AppMethodBeat.i(233690);
      if (this.Gpd.fhS().isFinished())
      {
        this.Gpd.getView().scrollTo(0, 0);
        if (this.state == 2)
        {
          this.state = 1;
          this.Gpd.getView().removeCallbacks(this.Gpi);
          this.Gpd.getView().postDelayed(this.Gpi, this.Gph);
        }
      }
      AppMethodBeat.o(233690);
    }
    
    public final void start()
    {
      AppMethodBeat.i(233686);
      if (this.state == 0)
      {
        this.state = 1;
        this.Gpd.getView().removeCallbacks(this.Gpi);
        this.Gpd.getView().postDelayed(this.Gpi, this.Gph);
      }
      AppMethodBeat.o(233686);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(233689);
      this.state = 0;
      this.Gpd.getView().removeCallbacks(this.Gpi);
      this.Gpd.fhS().forceFinished(true);
      this.Gpd.getView().scrollTo(0, 0);
      AppMethodBeat.o(233689);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MusicMvMarqueeTextView.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(230742);
        this.Gpk.state = 2;
        float f = this.Gpk.Gpd.fhQ();
        f = this.Gpk.Gpd.fhR() + f;
        int i = (int)(f / this.Gpk.Gpg * 1000.0F);
        this.Gpk.Gpd.fhS().startScroll(0, 0, (int)f, 0, i);
        this.Gpk.Gpd.getView().postInvalidate();
        AppMethodBeat.o(230742);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "", "getContentWidth", "", "getScroller", "Landroid/widget/Scroller;", "getSpaceWidth", "getView", "Landroid/view/View;", "getWidth", "plugin-mv_release"})
  public static abstract interface d
  {
    public abstract float fhQ();
    
    public abstract float fhR();
    
    public abstract Scroller fhS();
    
    public abstract View getView();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$viewProvider$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "getContentWidth", "", "getScroller", "Landroid/widget/Scroller;", "getSpaceWidth", "getView", "Landroid/view/View;", "getWidth", "plugin-mv_release"})
  public static final class e
    implements MusicMvMarqueeTextView.d
  {
    public final float fhQ()
    {
      AppMethodBeat.i(225342);
      float f = MusicMvMarqueeTextView.a(this.Gpl);
      AppMethodBeat.o(225342);
      return f;
    }
    
    public final float fhR()
    {
      AppMethodBeat.i(225343);
      float f = MusicMvMarqueeTextView.b(this.Gpl);
      AppMethodBeat.o(225343);
      return f;
    }
    
    public final Scroller fhS()
    {
      AppMethodBeat.i(225344);
      Scroller localScroller = MusicMvMarqueeTextView.c(this.Gpl);
      AppMethodBeat.o(225344);
      return localScroller;
    }
    
    public final View getView()
    {
      return (View)this.Gpl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView
 * JD-Core Version:    0.7.0.1
 */