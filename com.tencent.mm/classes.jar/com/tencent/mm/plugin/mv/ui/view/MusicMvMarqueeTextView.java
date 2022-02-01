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
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "effect", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "getEffect", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "setEffect", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;)V", "needScroll", "", "paint", "Landroid/graphics/Paint;", "scroller", "Landroid/widget/Scroller;", "scrolling", "spaceWidth", "", "textContent", "", "textHeight", "textWidth", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "checkScroll", "", "computeScroll", "getLeftFadingEdgeStrength", "getRightFadingEdgeStrength", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setContent", "content", "textSize", "textColor", "setText", "text", "setTextBold", "bold", "setTextColor", "setTextSize", "Companion", "NoEffect", "ScrollEffect", "ScrollReverseEffect", "ScrollToNextEffect", "ViewProvider", "plugin-mv_release"})
public final class MusicMvMarqueeTextView
  extends View
{
  public static final MusicMvMarqueeTextView.a Ayv;
  private String Ayp;
  private float Ayq;
  private float Ayr;
  private final Scroller Ays;
  private final e Ayt;
  private b Ayu;
  private float jq;
  private boolean ons;
  private final Paint paint;
  private boolean scrolling;
  
  static
  {
    AppMethodBeat.i(257610);
    Ayv = new MusicMvMarqueeTextView.a((byte)0);
    AppMethodBeat.o(257610);
  }
  
  public MusicMvMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public MusicMvMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(257609);
    this.paint = new Paint(1);
    this.Ayp = "";
    this.Ays = new Scroller(paramContext, (Interpolator)new LinearInterpolator());
    this.scrolling = true;
    this.Ayt = ((e)new f(this));
    this.Ayu = ((b)new d(this.Ayt));
    this.Ayr = (a.fromDPToPix(paramContext, 8) * 4.0F);
    AppMethodBeat.o(257609);
  }
  
  private final void ewu()
  {
    AppMethodBeat.i(257602);
    if (getWidth() >= this.jq)
    {
      this.ons = false;
      this.Ayu.stop();
      scrollTo(0, 0);
      AppMethodBeat.o(257602);
      return;
    }
    this.ons = true;
    if (this.scrolling) {
      this.Ayu.start();
    }
    AppMethodBeat.o(257602);
  }
  
  public final void b(String paramString, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(257601);
    this.paint.setTextSize(paramFloat);
    this.paint.setColor(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.Ayp = str;
    this.jq = this.paint.measureText(this.Ayp);
    this.Ayq = (this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top);
    ewu();
    AppMethodBeat.o(257601);
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(257607);
    if (this.Ays.computeScrollOffset())
    {
      scrollTo(this.Ays.getCurrX(), this.Ays.getCurrY());
      postInvalidate();
    }
    AppMethodBeat.o(257607);
  }
  
  public final b getEffect()
  {
    return this.Ayu;
  }
  
  protected final float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(257605);
    if ((!this.ons) || (this.Ayu.ewv()))
    {
      AppMethodBeat.o(257605);
      return 0.0F;
    }
    AppMethodBeat.o(257605);
    return 1.0F;
  }
  
  protected final float getRightFadingEdgeStrength()
  {
    AppMethodBeat.i(257606);
    if ((!this.ons) || (this.Ayu.eww()))
    {
      AppMethodBeat.o(257606);
      return 0.0F;
    }
    AppMethodBeat.o(257606);
    return 1.0F;
  }
  
  public final e getViewProvider()
  {
    return this.Ayt;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(257608);
    p.h(paramCanvas, "canvas");
    int i = paramCanvas.save();
    paramCanvas.translate(0.0F, getPaddingTop() - this.paint.getFontMetrics().top);
    paramCanvas.drawText(this.Ayp, 0.0F, 0.0F, this.paint);
    if (this.ons)
    {
      paramCanvas.translate(this.jq + this.Ayr, 0.0F);
      paramCanvas.drawText(this.Ayp, 0.0F, 0.0F, this.paint);
    }
    paramCanvas.restoreToCount(i);
    if (this.ons) {
      this.Ayu.onDraw();
    }
    AppMethodBeat.o(257608);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257603);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = (int)this.Ayq;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    paramInt1 = paramInt2;
    if (m == -2147483648)
    {
      paramInt1 = paramInt2;
      if (paramInt2 >= this.jq) {
        paramInt1 = (int)this.jq;
      }
    }
    setMeasuredDimension(paramInt1, i + j + k);
    AppMethodBeat.o(257603);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(257604);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ewu();
    AppMethodBeat.o(257604);
  }
  
  public final void setEffect(b paramb)
  {
    AppMethodBeat.i(257596);
    p.h(paramb, "<set-?>");
    this.Ayu = paramb;
    AppMethodBeat.o(257596);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(257597);
    if ((p.j(this.Ayp, paramString) ^ true))
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.Ayp = str;
      this.jq = this.paint.measureText(this.Ayp);
      this.Ayq = (this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top);
      this.Ayu.stop();
      scrollTo(0, 0);
      ewu();
    }
    AppMethodBeat.o(257597);
  }
  
  public final void setTextBold(boolean paramBoolean)
  {
    AppMethodBeat.i(257600);
    this.paint.setFakeBoldText(paramBoolean);
    AppMethodBeat.o(257600);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(257599);
    if (this.paint.getColor() != paramInt)
    {
      this.paint.setColor(paramInt);
      invalidate();
    }
    AppMethodBeat.o(257599);
  }
  
  public final void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(257598);
    if (this.paint.getTextSize() != paramFloat)
    {
      this.paint.setTextSize(paramFloat);
      this.jq = this.paint.measureText(this.Ayp);
      this.Ayq = (this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top);
      ewu();
    }
    AppMethodBeat.o(257598);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract boolean ewv();
    
    public abstract boolean eww();
    
    public abstract void onDraw();
    
    public abstract void start();
    
    public abstract void stop();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollReverseEffect;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;)V", "reverseTask", "Ljava/lang/Runnable;", "scrollInterval", "", "getScrollInterval", "()J", "setScrollInterval", "(J)V", "scrollSpeed", "", "getScrollSpeed", "()F", "setScrollSpeed", "(F)V", "scrollTask", "state", "", "getState", "()I", "setState", "(I)V", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "Companion", "plugin-mv_release"})
  public static final class c
    implements MusicMvMarqueeTextView.b
  {
    public static final MusicMvMarqueeTextView.c.a Ayz;
    private final Runnable Aoa;
    final MusicMvMarqueeTextView.e Ayt;
    float Ayw;
    private long Ayx;
    private final Runnable Ayy;
    int state;
    
    static
    {
      AppMethodBeat.i(257584);
      Ayz = new MusicMvMarqueeTextView.c.a((byte)0);
      AppMethodBeat.o(257584);
    }
    
    public c(MusicMvMarqueeTextView.e parame)
    {
      AppMethodBeat.i(257583);
      this.Ayt = parame;
      this.Ayw = 200.0F;
      this.Ayx = 2000L;
      this.state = 3;
      this.Aoa = ((Runnable)new c(this));
      this.Ayy = ((Runnable)new b(this));
      AppMethodBeat.o(257583);
    }
    
    public final boolean ewv()
    {
      AppMethodBeat.i(257578);
      if (this.Ayt.ewz().getCurrX() == 0)
      {
        AppMethodBeat.o(257578);
        return true;
      }
      AppMethodBeat.o(257578);
      return false;
    }
    
    public final boolean eww()
    {
      AppMethodBeat.i(257579);
      if (this.Ayt.ewz().getCurrX() == (int)(this.Ayt.ewx() - this.Ayt.getWidth()))
      {
        AppMethodBeat.o(257579);
        return true;
      }
      AppMethodBeat.o(257579);
      return false;
    }
    
    public final void onDraw()
    {
      AppMethodBeat.i(257582);
      if (this.Ayt.ewz().isFinished())
      {
        if (this.state == 2)
        {
          this.Ayt.getView().removeCallbacks(this.Ayy);
          this.Ayt.getView().postDelayed(this.Ayy, this.Ayx);
          this.state = 1;
          AppMethodBeat.o(257582);
          return;
        }
        if (this.state == 3)
        {
          this.Ayt.getView().removeCallbacks(this.Aoa);
          this.Ayt.getView().postDelayed(this.Aoa, this.Ayx);
          this.state = 1;
        }
      }
      AppMethodBeat.o(257582);
    }
    
    public final void start()
    {
      AppMethodBeat.i(257580);
      if (this.state != 0)
      {
        AppMethodBeat.o(257580);
        return;
      }
      this.Ayt.getView().removeCallbacks(this.Aoa);
      this.Ayt.getView().postDelayed(this.Aoa, this.Ayx);
      this.state = 1;
      AppMethodBeat.o(257580);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(257581);
      this.state = 0;
      this.Ayt.getView().removeCallbacks(this.Aoa);
      this.Ayt.getView().removeCallbacks(this.Ayy);
      AppMethodBeat.o(257581);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MusicMvMarqueeTextView.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(257576);
        this.AyA.state = 3;
        float f = this.AyA.Ayt.ewx() - this.AyA.Ayt.getWidth();
        int i = (int)(f / this.AyA.Ayw * 1000.0F);
        this.AyA.Ayt.ewz().startScroll((int)f, 0, -(int)f, 0, i);
        this.AyA.Ayt.getView().postInvalidate();
        AppMethodBeat.o(257576);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(MusicMvMarqueeTextView.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(257577);
        this.AyA.state = 2;
        float f = this.AyA.Ayt.ewx() - this.AyA.Ayt.getWidth();
        int i = (int)(f / this.AyA.Ayw * 1000.0F);
        this.AyA.Ayt.ewz().startScroll(0, 0, (int)f, 0, i);
        this.AyA.Ayt.getView().postInvalidate();
        AppMethodBeat.o(257577);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollToNextEffect;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;)V", "scrollInterval", "", "getScrollInterval", "()J", "setScrollInterval", "(J)V", "scrollSpeed", "", "getScrollSpeed", "()F", "setScrollSpeed", "(F)V", "startScrollTask", "Ljava/lang/Runnable;", "state", "", "getState", "()I", "setState", "(I)V", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "Companion", "plugin-mv_release"})
  public static final class d
    implements MusicMvMarqueeTextView.b
  {
    public static final MusicMvMarqueeTextView.d.a AyC;
    private final Runnable AyB;
    final MusicMvMarqueeTextView.e Ayt;
    float Ayw;
    private long Ayx;
    int state;
    
    static
    {
      AppMethodBeat.i(257591);
      AyC = new MusicMvMarqueeTextView.d.a((byte)0);
      AppMethodBeat.o(257591);
    }
    
    public d(MusicMvMarqueeTextView.e parame)
    {
      AppMethodBeat.i(257590);
      this.Ayt = parame;
      this.Ayw = 200.0F;
      this.Ayx = 5000L;
      this.AyB = ((Runnable)new b(this));
      AppMethodBeat.o(257590);
    }
    
    public final boolean ewv()
    {
      AppMethodBeat.i(257586);
      if (this.Ayt.getView().getScrollX() == 0)
      {
        AppMethodBeat.o(257586);
        return true;
      }
      AppMethodBeat.o(257586);
      return false;
    }
    
    public final boolean eww()
    {
      return false;
    }
    
    public final void onDraw()
    {
      AppMethodBeat.i(257589);
      if (this.Ayt.ewz().isFinished())
      {
        this.Ayt.getView().scrollTo(0, 0);
        if (this.state == 2)
        {
          this.state = 1;
          this.Ayt.getView().removeCallbacks(this.AyB);
          this.Ayt.getView().postDelayed(this.AyB, this.Ayx);
        }
      }
      AppMethodBeat.o(257589);
    }
    
    public final void start()
    {
      AppMethodBeat.i(257587);
      if (this.state == 0)
      {
        this.state = 1;
        this.Ayt.getView().removeCallbacks(this.AyB);
        this.Ayt.getView().postDelayed(this.AyB, this.Ayx);
      }
      AppMethodBeat.o(257587);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(257588);
      this.state = 0;
      this.Ayt.getView().removeCallbacks(this.AyB);
      this.Ayt.ewz().forceFinished(true);
      this.Ayt.getView().scrollTo(0, 0);
      AppMethodBeat.o(257588);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MusicMvMarqueeTextView.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(257585);
        this.AyD.state = 2;
        float f = this.AyD.Ayt.ewx();
        f = this.AyD.Ayt.ewy() + f;
        int i = (int)(f / this.AyD.Ayw * 1000.0F);
        this.AyD.Ayt.ewz().startScroll(0, 0, (int)f, 0, i);
        this.AyD.Ayt.getView().postInvalidate();
        AppMethodBeat.o(257585);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "", "getContentWidth", "", "getScroller", "Landroid/widget/Scroller;", "getSpaceWidth", "getView", "Landroid/view/View;", "getWidth", "plugin-mv_release"})
  public static abstract interface e
  {
    public abstract float ewx();
    
    public abstract float ewy();
    
    public abstract Scroller ewz();
    
    public abstract View getView();
    
    public abstract float getWidth();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$viewProvider$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "getContentWidth", "", "getScroller", "Landroid/widget/Scroller;", "getSpaceWidth", "getView", "Landroid/view/View;", "getWidth", "plugin-mv_release"})
  public static final class f
    implements MusicMvMarqueeTextView.e
  {
    public final float ewx()
    {
      AppMethodBeat.i(257593);
      float f = MusicMvMarqueeTextView.a(this.AyE);
      AppMethodBeat.o(257593);
      return f;
    }
    
    public final float ewy()
    {
      AppMethodBeat.i(257594);
      float f = MusicMvMarqueeTextView.b(this.AyE);
      AppMethodBeat.o(257594);
      return f;
    }
    
    public final Scroller ewz()
    {
      AppMethodBeat.i(257595);
      Scroller localScroller = MusicMvMarqueeTextView.c(this.AyE);
      AppMethodBeat.o(257595);
      return localScroller;
    }
    
    public final View getView()
    {
      return (View)this.AyE;
    }
    
    public final float getWidth()
    {
      AppMethodBeat.i(257592);
      float f = this.AyE.getWidth();
      AppMethodBeat.o(257592);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView
 * JD-Core Version:    0.7.0.1
 */