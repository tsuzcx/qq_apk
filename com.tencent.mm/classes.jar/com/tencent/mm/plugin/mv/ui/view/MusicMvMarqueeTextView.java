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
import com.tencent.mm.cd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "effect", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "getEffect", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "setEffect", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;)V", "needScroll", "", "paint", "Landroid/graphics/Paint;", "scroller", "Landroid/widget/Scroller;", "scrolling", "spaceWidth", "", "textContent", "", "textHeight", "textWidth", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "checkLayout", "", "checkScroll", "computeScroll", "getLeftFadingEdgeStrength", "getRightFadingEdgeStrength", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setContent", "content", "textSize", "textColor", "setShadow", "setText", "text", "setTextBold", "bold", "setTextColor", "setTextSize", "Companion", "NoEffect", "ScrollEffect", "ScrollReverseEffect", "ScrollToNextEffect", "ViewProvider", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvMarqueeTextView
  extends View
{
  public static final MusicMvMarqueeTextView.a MiN;
  public String MiO;
  private float MiP;
  private float MiQ;
  private final Scroller MiR;
  private boolean MiS;
  private final d MiT;
  private b MiU;
  private float dsJ;
  public final Paint paint;
  private boolean scrolling;
  
  static
  {
    AppMethodBeat.i(287214);
    MiN = new MusicMvMarqueeTextView.a((byte)0);
    AppMethodBeat.o(287214);
  }
  
  public MusicMvMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(287200);
    AppMethodBeat.o(287200);
  }
  
  public MusicMvMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(287191);
    this.paint = new Paint(1);
    this.MiO = "";
    this.MiR = new Scroller(paramContext, (Interpolator)new LinearInterpolator());
    this.scrolling = true;
    this.MiT = ((d)new e(this));
    this.MiU = ((b)new c(this.MiT));
    this.MiQ = (a.fromDPToPix(paramContext, 8) * 4.0F);
    AppMethodBeat.o(287191);
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(287282);
    if (this.MiR.computeScrollOffset())
    {
      scrollTo(this.MiR.getCurrX(), this.MiR.getCurrY());
      postInvalidate();
    }
    AppMethodBeat.o(287282);
  }
  
  public final b getEffect()
  {
    return this.MiU;
  }
  
  protected final float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(287273);
    if ((!this.MiS) || (this.MiU.grG()))
    {
      AppMethodBeat.o(287273);
      return 0.0F;
    }
    AppMethodBeat.o(287273);
    return 1.0F;
  }
  
  protected final float getRightFadingEdgeStrength()
  {
    AppMethodBeat.i(287278);
    if ((!this.MiS) || (this.MiU.aau()))
    {
      AppMethodBeat.o(287278);
      return 0.0F;
    }
    AppMethodBeat.o(287278);
    return 1.0F;
  }
  
  public final d getViewProvider()
  {
    return this.MiT;
  }
  
  public final void grE()
  {
    int j = 1;
    AppMethodBeat.i(287244);
    float f1 = this.paint.measureText(this.MiO);
    float f2 = this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top;
    if (this.dsJ == f1)
    {
      i = 1;
      if (i != 0) {
        if (this.MiP != f2) {
          break label98;
        }
      }
    }
    label98:
    for (int i = j;; i = 0)
    {
      if (i == 0)
      {
        this.dsJ = f1;
        this.MiP = f2;
        requestLayout();
      }
      AppMethodBeat.o(287244);
      return;
      i = 0;
      break;
    }
  }
  
  public final void grF()
  {
    AppMethodBeat.i(287252);
    if (getWidth() >= this.dsJ)
    {
      this.MiS = false;
      this.MiU.stop();
      scrollTo(0, 0);
      AppMethodBeat.o(287252);
      return;
    }
    this.MiS = true;
    if (this.scrolling) {
      this.MiU.start();
    }
    AppMethodBeat.o(287252);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(287288);
    s.u(paramCanvas, "canvas");
    int i = paramCanvas.save();
    paramCanvas.translate(0.0F, getPaddingTop() - this.paint.getFontMetrics().top);
    paramCanvas.drawText(this.MiO, 0.0F, 0.0F, this.paint);
    if (this.MiS)
    {
      paramCanvas.translate(this.dsJ + this.MiQ, 0.0F);
      paramCanvas.drawText(this.MiO, 0.0F, 0.0F, this.paint);
    }
    paramCanvas.restoreToCount(i);
    if (this.MiS) {
      this.MiU.onDraw();
    }
    AppMethodBeat.o(287288);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287257);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = (int)this.MiP;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    paramInt1 = paramInt2;
    if (m == -2147483648)
    {
      paramInt1 = paramInt2;
      if (paramInt2 >= this.dsJ) {
        paramInt1 = (int)this.dsJ;
      }
    }
    setMeasuredDimension(paramInt1, i + j + k);
    AppMethodBeat.o(287257);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(287266);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    grF();
    AppMethodBeat.o(287266);
  }
  
  public final void setEffect(b paramb)
  {
    AppMethodBeat.i(287223);
    s.u(paramb, "<set-?>");
    this.MiU = paramb;
    AppMethodBeat.o(287223);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(287225);
    if (!s.p(this.MiO, paramString))
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.MiO = str;
      grE();
      this.MiU.stop();
      scrollTo(0, 0);
      grF();
    }
    AppMethodBeat.o(287225);
  }
  
  public final void setTextBold(boolean paramBoolean)
  {
    AppMethodBeat.i(287237);
    this.paint.setFakeBoldText(paramBoolean);
    AppMethodBeat.o(287237);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(287233);
    if (this.paint.getColor() != paramInt)
    {
      this.paint.setColor(paramInt);
      invalidate();
    }
    AppMethodBeat.o(287233);
  }
  
  public final void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(287229);
    if (this.paint.getTextSize() == paramFloat) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.paint.setTextSize(paramFloat);
        grE();
        grF();
      }
      AppMethodBeat.o(287229);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract boolean aau();
    
    public abstract boolean grG();
    
    public abstract void onDraw();
    
    public abstract void start();
    
    public abstract void stop();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollToNextEffect;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;)V", "scrollInterval", "", "getScrollInterval", "()J", "setScrollInterval", "(J)V", "scrollSpeed", "", "getScrollSpeed", "()F", "setScrollSpeed", "(F)V", "startScrollTask", "Ljava/lang/Runnable;", "state", "", "getState", "()I", "setState", "(I)V", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements MusicMvMarqueeTextView.b
  {
    public static final MusicMvMarqueeTextView.c.a MiV;
    private final MusicMvMarqueeTextView.d MiT;
    private float MiW;
    private long MiX;
    private final Runnable MiY;
    private int state;
    
    static
    {
      AppMethodBeat.i(286834);
      MiV = new MusicMvMarqueeTextView.c.a((byte)0);
      AppMethodBeat.o(286834);
    }
    
    public c(MusicMvMarqueeTextView.d paramd)
    {
      AppMethodBeat.i(286824);
      this.MiT = paramd;
      this.MiW = 200.0F;
      this.MiX = 5000L;
      this.MiY = new MusicMvMarqueeTextView.c..ExternalSyntheticLambda0(this);
      AppMethodBeat.o(286824);
    }
    
    private static final void a(c paramc)
    {
      AppMethodBeat.i(286830);
      s.u(paramc, "this$0");
      paramc.state = 2;
      float f = paramc.MiT.grH();
      f = paramc.MiT.grI() + f;
      int i = (int)(f / paramc.MiW * 1000.0F);
      paramc.MiT.grJ().startScroll(0, 0, (int)f, 0, i);
      paramc.MiT.getView().postInvalidate();
      AppMethodBeat.o(286830);
    }
    
    public final boolean aau()
    {
      return false;
    }
    
    public final boolean grG()
    {
      AppMethodBeat.i(286849);
      if (this.MiT.getView().getScrollX() == 0)
      {
        AppMethodBeat.o(286849);
        return true;
      }
      AppMethodBeat.o(286849);
      return false;
    }
    
    public final void onDraw()
    {
      AppMethodBeat.i(286880);
      if (this.MiT.grJ().isFinished())
      {
        this.MiT.getView().scrollTo(0, 0);
        if (this.state == 2)
        {
          this.state = 1;
          this.MiT.getView().removeCallbacks(this.MiY);
          this.MiT.getView().postDelayed(this.MiY, this.MiX);
        }
      }
      AppMethodBeat.o(286880);
    }
    
    public final void start()
    {
      AppMethodBeat.i(286866);
      if (this.state == 0)
      {
        this.state = 1;
        this.MiT.getView().removeCallbacks(this.MiY);
        this.MiT.getView().postDelayed(this.MiY, this.MiX);
      }
      AppMethodBeat.o(286866);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(286872);
      this.state = 0;
      this.MiT.getView().removeCallbacks(this.MiY);
      this.MiT.grJ().forceFinished(true);
      this.MiT.getView().scrollTo(0, 0);
      AppMethodBeat.o(286872);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "", "getContentWidth", "", "getScroller", "Landroid/widget/Scroller;", "getSpaceWidth", "getView", "Landroid/view/View;", "getWidth", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract View getView();
    
    public abstract float grH();
    
    public abstract float grI();
    
    public abstract Scroller grJ();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$viewProvider$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "getContentWidth", "", "getScroller", "Landroid/widget/Scroller;", "getSpaceWidth", "getView", "Landroid/view/View;", "getWidth", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MusicMvMarqueeTextView.d
  {
    e(MusicMvMarqueeTextView paramMusicMvMarqueeTextView) {}
    
    public final View getView()
    {
      return (View)this.MiZ;
    }
    
    public final float grH()
    {
      AppMethodBeat.i(286850);
      float f = MusicMvMarqueeTextView.a(this.MiZ);
      AppMethodBeat.o(286850);
      return f;
    }
    
    public final float grI()
    {
      AppMethodBeat.i(286856);
      float f = MusicMvMarqueeTextView.b(this.MiZ);
      AppMethodBeat.o(286856);
      return f;
    }
    
    public final Scroller grJ()
    {
      AppMethodBeat.i(286864);
      Scroller localScroller = MusicMvMarqueeTextView.c(this.MiZ);
      AppMethodBeat.o(286864);
      return localScroller;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView
 * JD-Core Version:    0.7.0.1
 */