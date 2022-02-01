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
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/music/ui/view/MarqueeLyricView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "faceOutTask", "Ljava/lang/Runnable;", "fadeIn", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "fadeOut", "hasStartedFadeIn", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "mDistance", "mDuration", "mMinDuration", "", "mScroller", "Landroid/widget/Scroller;", "mStartX", "mXPaused", "scrollTask", "calculateScrollingLen", "lyricTxt", "", "computeScroll", "", "doFaceIn", "isFocused", "setContent", "lineCnt", "content", "setLyricObj", "startScroll", "stopScroll", "Companion", "plugin-music_release"})
public final class MarqueeLyricView
  extends AppCompatTextView
{
  public static final String TAG = "MicroMsg.MarqueeLyricView";
  public static final MarqueeLyricView.a wDG;
  public int Dd;
  public int atW;
  public int mDistance;
  private Scroller mScroller;
  public Animation rrh;
  public b wCo;
  public int wDA;
  public Runnable wDB;
  public long wDC;
  public Runnable wDD;
  private Animation wDE;
  public boolean wDF;
  
  static
  {
    AppMethodBeat.i(220664);
    wDG = new MarqueeLyricView.a((byte)0);
    TAG = "MicroMsg.MarqueeLyricView";
    AppMethodBeat.o(220664);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220663);
    this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
    this.wDA = (-getWidth());
    this.wDB = ((Runnable)new c(this));
    this.wDC = 200L;
    this.wDD = ((Runnable)new b(this));
    this.rrh = AnimationUtils.loadAnimation(getContext(), 2130772047);
    this.wDE = AnimationUtils.loadAnimation(getContext(), 2130772048);
    setScroller(this.mScroller);
    setHorizontallyScrolling(true);
    AppMethodBeat.o(220663);
  }
  
  public final int aub(String paramString)
  {
    AppMethodBeat.i(220660);
    TextPaint localTextPaint = getPaint();
    Rect localRect = new Rect();
    localTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    if (localRect.width() > 0)
    {
      int i = localRect.width();
      AppMethodBeat.o(220660);
      return i;
    }
    AppMethodBeat.o(220660);
    return 25;
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(220662);
    super.computeScroll();
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), 0);
      invalidate();
    }
    AppMethodBeat.o(220662);
  }
  
  public final boolean isFocused()
  {
    return true;
  }
  
  public final void kJ()
  {
    AppMethodBeat.i(220661);
    removeCallbacks(this.wDB);
    this.mScroller.startScroll(0, 0, 0, 0, 0);
    AppMethodBeat.o(220661);
  }
  
  public final void setLyricObj(b paramb)
  {
    AppMethodBeat.i(220659);
    p.h(paramb, "lyricObj");
    setText((CharSequence)"");
    this.wDF = false;
    removeCallbacks(this.wDD);
    kJ();
    this.wCo = paramb;
    AppMethodBeat.o(220659);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(220657);
      Animation localAnimation = MarqueeLyricView.e(this.wDH);
      p.g(localAnimation, "fadeOut");
      localAnimation.setDuration(MarqueeLyricView.f(this.wDH));
      this.wDH.startAnimation(MarqueeLyricView.e(this.wDH));
      ae.d(MarqueeLyricView.access$getTAG$cp(), "doFaceOut, duration:%s", new Object[] { Long.valueOf(MarqueeLyricView.f(this.wDH)) });
      AppMethodBeat.o(220657);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(220658);
      ae.d(MarqueeLyricView.access$getTAG$cp(), "scrollTask, mStartX:%s, mDistance:%s, mDuration:%s", new Object[] { Integer.valueOf(MarqueeLyricView.a(this.wDH)), Integer.valueOf(MarqueeLyricView.b(this.wDH)), Integer.valueOf(MarqueeLyricView.c(this.wDH)) });
      MarqueeLyricView.d(this.wDH).startScroll(MarqueeLyricView.a(this.wDH), 0, MarqueeLyricView.b(this.wDH), 0, MarqueeLyricView.c(this.wDH));
      this.wDH.invalidate();
      AppMethodBeat.o(220658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MarqueeLyricView
 * JD-Core Version:    0.7.0.1
 */