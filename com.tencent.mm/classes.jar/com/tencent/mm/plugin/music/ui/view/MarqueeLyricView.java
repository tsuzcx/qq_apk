package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/music/ui/view/MarqueeLyricView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "faceOutTask", "Ljava/lang/Runnable;", "fadeIn", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "fadeOut", "hasStartedFadeIn", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "mDistance", "mDuration", "mMinDuration", "", "mScroller", "Landroid/widget/Scroller;", "mStartX", "mXPaused", "scrollTask", "calculateScrollingLen", "lyricTxt", "", "computeScroll", "", "doFaceIn", "isFocused", "setContent", "lineCnt", "content", "setLyricObj", "startScroll", "stopScroll", "Companion", "plugin-music_release"})
public final class MarqueeLyricView
  extends AppCompatTextView
{
  public static final String TAG = "MicroMsg.MarqueeLyricView";
  public static final MarqueeLyricView.a viE;
  public int Bl;
  public int asf;
  private Scroller mScroller;
  public Animation qzo;
  public b vhk;
  public long viA;
  public Runnable viB;
  private Animation viC;
  public boolean viD;
  public int vix;
  public int viy;
  public Runnable viz;
  
  static
  {
    AppMethodBeat.i(195637);
    viE = new MarqueeLyricView.a((byte)0);
    TAG = "MicroMsg.MarqueeLyricView";
    AppMethodBeat.o(195637);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195636);
    this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
    this.vix = (-getWidth());
    this.viz = ((Runnable)new c(this));
    this.viA = 200L;
    this.viB = ((Runnable)new b(this));
    this.qzo = AnimationUtils.loadAnimation(getContext(), 2130772047);
    this.viC = AnimationUtils.loadAnimation(getContext(), 2130772048);
    setScroller(this.mScroller);
    setHorizontallyScrolling(true);
    AppMethodBeat.o(195636);
  }
  
  public final int anP(String paramString)
  {
    AppMethodBeat.i(195633);
    TextPaint localTextPaint = getPaint();
    Rect localRect = new Rect();
    localTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    if (localRect.width() > 0)
    {
      int i = localRect.width();
      AppMethodBeat.o(195633);
      return i;
    }
    AppMethodBeat.o(195633);
    return 25;
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(195635);
    super.computeScroll();
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), 0);
      invalidate();
    }
    AppMethodBeat.o(195635);
  }
  
  public final boolean isFocused()
  {
    return true;
  }
  
  public final void kt()
  {
    AppMethodBeat.i(195634);
    removeCallbacks(this.viz);
    this.mScroller.startScroll(0, 0, 0, 0, 0);
    AppMethodBeat.o(195634);
  }
  
  public final void setLyricObj(b paramb)
  {
    AppMethodBeat.i(195632);
    k.h(paramb, "lyricObj");
    setText((CharSequence)"");
    this.viD = false;
    removeCallbacks(this.viB);
    kt();
    this.vhk = paramb;
    AppMethodBeat.o(195632);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(195630);
      Animation localAnimation = MarqueeLyricView.e(this.viF);
      k.g(localAnimation, "fadeOut");
      localAnimation.setDuration(MarqueeLyricView.f(this.viF));
      this.viF.startAnimation(MarqueeLyricView.e(this.viF));
      ac.d(MarqueeLyricView.access$getTAG$cp(), "doFaceOut, duration:%s", new Object[] { Long.valueOf(MarqueeLyricView.f(this.viF)) });
      AppMethodBeat.o(195630);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(195631);
      ac.d(MarqueeLyricView.access$getTAG$cp(), "scrollTask, mStartX:%s, mDistance:%s, mDuration:%s", new Object[] { Integer.valueOf(MarqueeLyricView.a(this.viF)), Integer.valueOf(MarqueeLyricView.b(this.viF)), Integer.valueOf(MarqueeLyricView.c(this.viF)) });
      MarqueeLyricView.d(this.viF).startScroll(MarqueeLyricView.a(this.viF), 0, MarqueeLyricView.b(this.viF), 0, MarqueeLyricView.c(this.viF));
      this.viF.invalidate();
      AppMethodBeat.o(195631);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MarqueeLyricView
 * JD-Core Version:    0.7.0.1
 */