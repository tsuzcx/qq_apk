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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/music/ui/view/MarqueeLyricView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "faceOutTask", "Ljava/lang/Runnable;", "fadeIn", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "fadeOut", "hasStartedFadeIn", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "mDistance", "mDuration", "mMinDuration", "", "mScroller", "Landroid/widget/Scroller;", "mStartX", "mXPaused", "scrollTask", "calculateScrollingLen", "lyricTxt", "", "computeScroll", "", "doFaceIn", "isFocused", "setContent", "lineCnt", "content", "setLyricObj", "startScroll", "stopScroll", "Companion", "plugin-music_release"})
public final class MarqueeLyricView
  extends AppCompatTextView
{
  public static final String TAG = "MicroMsg.MarqueeLyricView";
  public static final MarqueeLyricView.a wnX;
  public int Dd;
  public int atW;
  public int mDistance;
  private Scroller mScroller;
  public Animation rjd;
  public b wmF;
  public int wnR;
  public Runnable wnS;
  public long wnT;
  public Runnable wnU;
  private Animation wnV;
  public boolean wnW;
  
  static
  {
    AppMethodBeat.i(192505);
    wnX = new MarqueeLyricView.a((byte)0);
    TAG = "MicroMsg.MarqueeLyricView";
    AppMethodBeat.o(192505);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192504);
    this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
    this.wnR = (-getWidth());
    this.wnS = ((Runnable)new c(this));
    this.wnT = 200L;
    this.wnU = ((Runnable)new b(this));
    this.rjd = AnimationUtils.loadAnimation(getContext(), 2130772047);
    this.wnV = AnimationUtils.loadAnimation(getContext(), 2130772048);
    setScroller(this.mScroller);
    setHorizontallyScrolling(true);
    AppMethodBeat.o(192504);
  }
  
  public final int asO(String paramString)
  {
    AppMethodBeat.i(192501);
    TextPaint localTextPaint = getPaint();
    Rect localRect = new Rect();
    localTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    if (localRect.width() > 0)
    {
      int i = localRect.width();
      AppMethodBeat.o(192501);
      return i;
    }
    AppMethodBeat.o(192501);
    return 25;
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(192503);
    super.computeScroll();
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), 0);
      invalidate();
    }
    AppMethodBeat.o(192503);
  }
  
  public final boolean isFocused()
  {
    return true;
  }
  
  public final void kJ()
  {
    AppMethodBeat.i(192502);
    removeCallbacks(this.wnS);
    this.mScroller.startScroll(0, 0, 0, 0, 0);
    AppMethodBeat.o(192502);
  }
  
  public final void setLyricObj(b paramb)
  {
    AppMethodBeat.i(192500);
    p.h(paramb, "lyricObj");
    setText((CharSequence)"");
    this.wnW = false;
    removeCallbacks(this.wnU);
    kJ();
    this.wmF = paramb;
    AppMethodBeat.o(192500);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(192498);
      Animation localAnimation = MarqueeLyricView.e(this.wnY);
      p.g(localAnimation, "fadeOut");
      localAnimation.setDuration(MarqueeLyricView.f(this.wnY));
      this.wnY.startAnimation(MarqueeLyricView.e(this.wnY));
      ad.d(MarqueeLyricView.access$getTAG$cp(), "doFaceOut, duration:%s", new Object[] { Long.valueOf(MarqueeLyricView.f(this.wnY)) });
      AppMethodBeat.o(192498);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(192499);
      ad.d(MarqueeLyricView.access$getTAG$cp(), "scrollTask, mStartX:%s, mDistance:%s, mDuration:%s", new Object[] { Integer.valueOf(MarqueeLyricView.a(this.wnY)), Integer.valueOf(MarqueeLyricView.b(this.wnY)), Integer.valueOf(MarqueeLyricView.c(this.wnY)) });
      MarqueeLyricView.d(this.wnY).startScroll(MarqueeLyricView.a(this.wnY), 0, MarqueeLyricView.b(this.wnY), 0, MarqueeLyricView.c(this.wnY));
      this.wnY.invalidate();
      AppMethodBeat.o(192499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MarqueeLyricView
 * JD-Core Version:    0.7.0.1
 */