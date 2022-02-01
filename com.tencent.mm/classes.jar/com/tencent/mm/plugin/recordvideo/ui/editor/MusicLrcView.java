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
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.c;
import d.a.j;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRunningShow", "", "()Z", "setRunningShow", "(Z)V", "mFirst", "mScroller", "Landroid/widget/Scroller;", "mXPaused", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "rndDuration", "getRndDuration", "()I", "setRndDuration", "(I)V", "scrollFirstDelay", "getScrollFirstDelay", "setScrollFirstDelay", "calculateScrollingLen", "computeScroll", "", "fillText", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "hlString", "", "resumeScroll", "setShow", "isShow", "spanForQuery", "", "source", "startScroll", "stopScroll", "plugin-recordvideo_release"})
@SuppressLint({"AppCompatCustomView"})
public final class MusicLrcView
  extends TextView
{
  private v gHz;
  private Scroller mScroller;
  private int vix;
  private boolean wAd;
  private int wCh;
  private boolean wCi;
  private int wCj;
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76042);
    this.wCh = 10000;
    this.vix = (-getWidth());
    this.wCi = true;
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
  
  private void dwP()
  {
    AppMethodBeat.i(76036);
    if (!this.wAd)
    {
      AppMethodBeat.o(76036);
      return;
    }
    this.vix = (-getWidth());
    setHorizontallyScrolling(true);
    if (this.mScroller == null)
    {
      this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
      setScroller(this.mScroller);
    }
    final int j = dwQ();
    final int i = j - this.vix * 3 / 4;
    if (i != 0)
    {
      j = this.wCh * i / j;
      if (this.wCi)
      {
        postDelayed((Runnable)new b(this, i, j), this.wCj);
        AppMethodBeat.o(76036);
        return;
      }
      Scroller localScroller = this.mScroller;
      if (localScroller == null) {
        k.fOy();
      }
      localScroller.startScroll(this.vix, 0, i, 0, j);
      invalidate();
    }
    AppMethodBeat.o(76036);
  }
  
  private final int dwQ()
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
  
  public final void cZO()
  {
    AppMethodBeat.i(76035);
    if (this.wAd)
    {
      this.vix = getWidth();
      this.wCi = true;
      dwP();
    }
    AppMethodBeat.o(76035);
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
      k.fOy();
    }
    if (localScroller.isFinished())
    {
      this.vix = (-getWidth());
      this.wCi = false;
      dwP();
    }
    AppMethodBeat.o(76041);
  }
  
  public final void e(ArrayList<AudioCacheInfo.c> paramArrayList, String paramString)
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
            ((StringBuilder)localObject1).append(((AudioCacheInfo.c)((Iterator)localObject2).next()).wrz).append("  ");
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
        k.g(localObject2, "sb.toString()");
        if (!n.a((CharSequence)localObject2, (CharSequence)paramString, false)) {
          break label230;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        k.g(localObject1, "sb.toString()");
      }
    }
    label225:
    label230:
    for (paramString = a((String)localObject1, (CharSequence)paramString);; paramString = (CharSequence)((StringBuilder)localObject1).toString())
    {
      setText(paramString);
      this.wCh = (((AudioCacheInfo.c)j.iQ((List)paramArrayList)).wrA - ((AudioCacheInfo.c)j.iO((List)paramArrayList)).cSh);
      if (this.wCh == 0) {
        this.wCh = 10000;
      }
      AppMethodBeat.o(76037);
      return;
      i = 0;
      break;
    }
  }
  
  public final v getPlayer()
  {
    return this.gHz;
  }
  
  public final int getRndDuration()
  {
    return this.wCh;
  }
  
  public final int getScrollFirstDelay()
  {
    return this.wCj;
  }
  
  public final void setPlayer(v paramv)
  {
    AppMethodBeat.i(76033);
    if (paramv != null)
    {
      this.gHz = paramv;
      paramv = this.gHz;
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
    this.wCh = paramInt;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.wAd = paramBoolean;
  }
  
  public final void setScrollFirstDelay(int paramInt)
  {
    this.wCj = paramInt;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(76034);
    this.wAd = paramBoolean;
    if (!this.wAd)
    {
      if (this.mScroller != null)
      {
        Scroller localScroller = this.mScroller;
        if (localScroller == null) {
          k.fOy();
        }
        localScroller.startScroll(0, 0, 0, 0, 0);
      }
      AppMethodBeat.o(76034);
      return;
    }
    cZO();
    AppMethodBeat.o(76034);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
  public static final class a
    implements q.a
  {
    public final void a(e parame) {}
    
    public final void aA(int paramInt) {}
    
    public final void aR(boolean paramBoolean) {}
    
    public final void b(p paramp) {}
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(76031);
      if (paramInt == 3)
      {
        this.wCk.cZO();
        localObject1 = this.wCk.getPlayer();
        if (localObject1 == null) {
          break label118;
        }
      }
      label118:
      for (Object localObject1 = Long.valueOf(((v)localObject1).getDuration());; localObject1 = null)
      {
        if (localObject1 == null) {
          k.fOy();
        }
        if (((Long)localObject1).longValue() < this.wCk.getRndDuration())
        {
          MusicLrcView localMusicLrcView = this.wCk;
          v localv = this.wCk.getPlayer();
          localObject1 = localObject2;
          if (localv != null) {
            localObject1 = Long.valueOf(localv.getDuration());
          }
          if (localObject1 == null) {
            k.fOy();
          }
          localMusicLrcView.setRndDuration((int)((Long)localObject1).longValue());
        }
        AppMethodBeat.o(76031);
        return;
      }
    }
    
    public final void rU() {}
    
    public final void rV() {}
    
    public final void rW() {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MusicLrcView paramMusicLrcView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76032);
      Scroller localScroller = MusicLrcView.a(this.wCk);
      if (localScroller == null) {
        k.fOy();
      }
      localScroller.startScroll(MusicLrcView.b(this.wCk), 0, i, 0, j);
      this.wCk.invalidate();
      AppMethodBeat.o(76032);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView
 * JD-Core Version:    0.7.0.1
 */