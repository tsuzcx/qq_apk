package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.c;
import d.a.j;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRunningShow", "", "()Z", "setRunningShow", "(Z)V", "mFirst", "mScroller", "Landroid/widget/Scroller;", "mXPaused", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "rndDuration", "getRndDuration", "()I", "setRndDuration", "(I)V", "scrollFirstDelay", "getScrollFirstDelay", "setScrollFirstDelay", "calculateScrollingLen", "computeScroll", "", "fillText", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "hlString", "", "resumeScroll", "setShow", "isShow", "spanForQuery", "", "source", "startScroll", "stopScroll", "plugin-recordvideo_release"})
@SuppressLint({"AppCompatCustomView"})
public final class MusicLrcView
  extends TextView
{
  private v hdX;
  private Scroller mScroller;
  private int wDA;
  private boolean xZl;
  private int yda;
  private boolean ydb;
  private int ydc;
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76042);
    this.yda = 10000;
    this.wDA = (-getWidth());
    this.ydb = true;
    AppMethodBeat.o(76042);
  }
  
  private final CharSequence a(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(76039);
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString);
    int k = paramCharSequence.length();
    int j;
    for (int i = 0;; i = j)
    {
      int m = n.a((CharSequence)paramString, paramCharSequence.toString(), i, false);
      j = i;
      if (m != -1)
      {
        j = i + (m + k);
        if (!isSelected()) {
          break label112;
        }
      }
      label112:
      for (i = -16777216;; i = -1)
      {
        localSpannableString.setSpan(new ForegroundColorSpan(i), m, m + k, 33);
        if (m != -1) {
          break;
        }
        paramString = (CharSequence)localSpannableString;
        AppMethodBeat.o(76039);
        return paramString;
      }
    }
  }
  
  private void dLf()
  {
    AppMethodBeat.i(76036);
    if (!this.xZl)
    {
      AppMethodBeat.o(76036);
      return;
    }
    this.wDA = (-getWidth());
    setHorizontallyScrolling(true);
    if (this.mScroller == null)
    {
      this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
      setScroller(this.mScroller);
    }
    final int j = dLg();
    final int i = j - this.wDA * 3 / 4;
    if (i != 0)
    {
      j = this.yda * i / j;
      if (this.ydb)
      {
        postDelayed((Runnable)new b(this, i, j), this.ydc);
        AppMethodBeat.o(76036);
        return;
      }
      Scroller localScroller = this.mScroller;
      if (localScroller == null) {
        d.g.b.p.gkB();
      }
      localScroller.startScroll(this.wDA, 0, i, 0, j);
      invalidate();
    }
    AppMethodBeat.o(76036);
  }
  
  private final int dLg()
  {
    AppMethodBeat.i(76040);
    TextPaint localTextPaint = getPaint();
    Rect localRect = new Rect();
    String str = getText().toString();
    localTextPaint.getTextBounds(str, 0, str.length(), localRect);
    if (localRect.width() > 0)
    {
      i = localRect.width();
      AppMethodBeat.o(76040);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(76040);
    return i;
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(76041);
    super.computeScroll();
    if (this.mScroller == null)
    {
      AppMethodBeat.o(76041);
      return;
    }
    Scroller localScroller = this.mScroller;
    if (localScroller == null) {
      d.g.b.p.gkB();
    }
    if (localScroller.isFinished())
    {
      this.wDA = (-getWidth());
      this.ydb = false;
      dLf();
    }
    AppMethodBeat.o(76041);
  }
  
  public final void dma()
  {
    AppMethodBeat.i(76035);
    if (this.xZl)
    {
      this.wDA = getWidth();
      this.ydb = true;
      dLf();
    }
    AppMethodBeat.o(76035);
  }
  
  public final void f(ArrayList<AudioCacheInfo.c> paramArrayList, String paramString)
  {
    AppMethodBeat.i(76037);
    int i;
    Object localObject1;
    if (paramArrayList != null)
    {
      if (!((Collection)paramArrayList).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        localObject1 = new StringBuilder();
        Object localObject2 = ((Iterable)paramArrayList).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            ((StringBuilder)localObject1).append(((AudioCacheInfo.c)((Iterator)localObject2).next()).xPm).append("  ");
            continue;
            i = 0;
            break;
          }
        }
        if (paramString == null) {
          break label230;
        }
        if (((CharSequence)paramString).length() <= 0) {
          break label225;
        }
        i = 1;
        if (i == 0) {
          break label230;
        }
        localObject2 = ((StringBuilder)localObject1).toString();
        d.g.b.p.g(localObject2, "sb.toString()");
        if (!n.a((CharSequence)localObject2, (CharSequence)paramString, false)) {
          break label230;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        d.g.b.p.g(localObject1, "sb.toString()");
      }
    }
    label225:
    label230:
    for (paramString = a((String)localObject1, (CharSequence)paramString);; paramString = (CharSequence)((StringBuilder)localObject1).toString())
    {
      setText(paramString);
      this.yda = (((AudioCacheInfo.c)j.jn((List)paramArrayList)).xPn - ((AudioCacheInfo.c)j.jl((List)paramArrayList)).dez);
      if (this.yda == 0) {
        this.yda = 10000;
      }
      AppMethodBeat.o(76037);
      return;
      i = 0;
      break;
    }
  }
  
  public final v getPlayer()
  {
    return this.hdX;
  }
  
  public final int getRndDuration()
  {
    return this.yda;
  }
  
  public final int getScrollFirstDelay()
  {
    return this.ydc;
  }
  
  public final void setPlayer(v paramv)
  {
    AppMethodBeat.i(76033);
    if (paramv != null)
    {
      this.hdX = paramv;
      paramv = this.hdX;
      if (paramv != null)
      {
        paramv.a((q.a)new a(this));
        AppMethodBeat.o(76033);
        return;
      }
    }
    AppMethodBeat.o(76033);
  }
  
  public final void setRndDuration(int paramInt)
  {
    this.yda = paramInt;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.xZl = paramBoolean;
  }
  
  public final void setScrollFirstDelay(int paramInt)
  {
    this.ydc = paramInt;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(76034);
    this.xZl = paramBoolean;
    if (!this.xZl)
    {
      if (this.mScroller != null)
      {
        Scroller localScroller = this.mScroller;
        if (localScroller == null) {
          d.g.b.p.gkB();
        }
        localScroller.startScroll(0, 0, 0, 0, 0);
      }
      AppMethodBeat.o(76034);
      return;
    }
    dma();
    AppMethodBeat.o(76034);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
  public static final class a
    implements q.a
  {
    public final void a(e parame) {}
    
    public final void aA(int paramInt) {}
    
    public final void aS(boolean paramBoolean) {}
    
    public final void b(com.google.android.exoplayer2.p paramp) {}
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(76031);
      if (paramInt == 3)
      {
        this.ydd.dma();
        localObject1 = this.ydd.getPlayer();
        if (localObject1 == null) {
          break label118;
        }
      }
      label118:
      for (Object localObject1 = Long.valueOf(((v)localObject1).getDuration());; localObject1 = null)
      {
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        if (((Long)localObject1).longValue() < this.ydd.getRndDuration())
        {
          MusicLrcView localMusicLrcView = this.ydd;
          v localv = this.ydd.getPlayer();
          localObject1 = localObject2;
          if (localv != null) {
            localObject1 = Long.valueOf(localv.getDuration());
          }
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          localMusicLrcView.setRndDuration((int)((Long)localObject1).longValue());
        }
        AppMethodBeat.o(76031);
        return;
      }
    }
    
    public final void tt() {}
    
    public final void tu() {}
    
    public final void tv() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MusicLrcView paramMusicLrcView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76032);
      Scroller localScroller = MusicLrcView.a(this.ydd);
      if (localScroller == null) {
        d.g.b.p.gkB();
      }
      localScroller.startScroll(MusicLrcView.b(this.ydd), 0, i, 0, j);
      this.ydd.invalidate();
      AppMethodBeat.o(76032);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView
 * JD-Core Version:    0.7.0.1
 */