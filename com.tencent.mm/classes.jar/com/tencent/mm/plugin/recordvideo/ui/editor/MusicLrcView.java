package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "foregroundColor", "isRunningShow", "", "()Z", "setRunningShow", "(Z)V", "mFirst", "mScroller", "Landroid/widget/Scroller;", "mXPaused", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "rndDuration", "getRndDuration", "()I", "setRndDuration", "(I)V", "scrollFirstDelay", "getScrollFirstDelay", "setScrollFirstDelay", "calculateScrollingLen", "computeScroll", "", "fillText", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "hlString", "", "resetScroll", "resumeScroll", "setShow", "isShow", "startOffset", "startScroll", "stopScroll", "Companion", "plugin-recordvideo_release"})
@SuppressLint({"AppCompatCustomView"})
public final class MusicLrcView
  extends TextView
{
  public static final MusicLrcView.a Cee;
  private boolean Cak;
  private int Cec;
  private int Ced;
  private final int foregroundColor;
  private v hWJ;
  private Scroller mScroller;
  private int wDQ;
  private boolean wDR;
  
  static
  {
    AppMethodBeat.i(237742);
    Cee = new MusicLrcView.a((byte)0);
    AppMethodBeat.o(237742);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76042);
    this.Cec = 10000;
    this.wDQ = (-getWidth());
    this.wDR = true;
    this.foregroundColor = a.n(paramContext, 2131101305);
    AppMethodBeat.o(76042);
  }
  
  private void eMf()
  {
    AppMethodBeat.i(237740);
    if (this.Cak)
    {
      this.wDQ = getWidth();
      this.wDR = true;
      eMg();
    }
    AppMethodBeat.o(237740);
  }
  
  private void eMg()
  {
    AppMethodBeat.i(76036);
    if (!this.Cak)
    {
      AppMethodBeat.o(76036);
      return;
    }
    setHorizontallyScrolling(true);
    if (this.mScroller == null)
    {
      this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
      setScroller(this.mScroller);
    }
    final int j = eMh();
    final int i = j - this.wDQ * 3 / 4;
    if (i != 0)
    {
      j = this.Cec * i / j;
      if (this.wDR)
      {
        postDelayed((Runnable)new c(this, i, j), this.Ced);
        AppMethodBeat.o(76036);
        return;
      }
      Scroller localScroller = this.mScroller;
      if (localScroller == null) {
        kotlin.g.b.p.hyc();
      }
      localScroller.startScroll(this.wDQ, 0, i, 0, j);
      invalidate();
    }
    AppMethodBeat.o(76036);
  }
  
  private final int eMh()
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
      kotlin.g.b.p.hyc();
    }
    if (localScroller.isFinished())
    {
      this.wDQ = (-getWidth());
      this.wDR = false;
      eMg();
    }
    AppMethodBeat.o(76041);
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
            ((StringBuilder)localObject1).append(((AudioCacheInfo.c)((Iterator)localObject2).next()).BPp).append("  ");
            continue;
            i = 0;
            break;
          }
        }
        if (paramString == null) {
          break label233;
        }
        if (((CharSequence)paramString).length() <= 0) {
          break label228;
        }
        i = 1;
        if (i == 0) {
          break label233;
        }
        localObject2 = ((StringBuilder)localObject1).toString();
        kotlin.g.b.p.g(localObject2, "sb.toString()");
        if (!n.a((CharSequence)localObject2, (CharSequence)paramString, false)) {
          break label233;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        kotlin.g.b.p.g(localObject1, "sb.toString()");
      }
    }
    label228:
    label233:
    for (paramString = MusicLrcView.a.a((String)localObject1, (CharSequence)paramString, this.foregroundColor);; paramString = (CharSequence)((StringBuilder)localObject1).toString())
    {
      setText(paramString);
      this.Cec = (((AudioCacheInfo.c)j.ku((List)paramArrayList)).BPq - ((AudioCacheInfo.c)j.ks((List)paramArrayList)).dvv);
      if (this.Cec == 0) {
        this.Cec = 10000;
      }
      AppMethodBeat.o(76037);
      return;
      i = 0;
      break;
    }
  }
  
  public final v getPlayer()
  {
    return this.hWJ;
  }
  
  public final int getRndDuration()
  {
    return this.Cec;
  }
  
  public final int getScrollFirstDelay()
  {
    return this.Ced;
  }
  
  public final void setPlayer(v paramv)
  {
    AppMethodBeat.i(76033);
    if (paramv != null)
    {
      this.hWJ = paramv;
      paramv = this.hWJ;
      if (paramv != null)
      {
        paramv.a((q.a)new b(this));
        AppMethodBeat.o(76033);
        return;
      }
    }
    AppMethodBeat.o(76033);
  }
  
  public final void setRndDuration(int paramInt)
  {
    this.Cec = paramInt;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.Cak = paramBoolean;
  }
  
  public final void setScrollFirstDelay(int paramInt)
  {
    this.Ced = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
  public static final class b
    implements q.a
  {
    public final void a(e parame) {}
    
    public final void aA(int paramInt) {}
    
    public final void aR(boolean paramBoolean) {}
    
    public final void b(com.google.android.exoplayer2.p paramp) {}
    
    public final void c(boolean paramBoolean, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(76031);
      if (paramInt == 3)
      {
        MusicLrcView.a(this.Cef);
        localObject1 = this.Cef.getPlayer();
        if (localObject1 == null) {
          break label118;
        }
      }
      label118:
      for (Object localObject1 = Long.valueOf(((v)localObject1).getDuration());; localObject1 = null)
      {
        if (localObject1 == null) {
          kotlin.g.b.p.hyc();
        }
        if (((Long)localObject1).longValue() < this.Cef.getRndDuration())
        {
          MusicLrcView localMusicLrcView = this.Cef;
          v localv = this.Cef.getPlayer();
          localObject1 = localObject2;
          if (localv != null) {
            localObject1 = Long.valueOf(localv.getDuration());
          }
          if (localObject1 == null) {
            kotlin.g.b.p.hyc();
          }
          localMusicLrcView.setRndDuration((int)((Long)localObject1).longValue());
        }
        AppMethodBeat.o(76031);
        return;
      }
    }
    
    public final void tA() {}
    
    public final void ty() {}
    
    public final void tz() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MusicLrcView paramMusicLrcView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76032);
      Scroller localScroller = MusicLrcView.b(this.Cef);
      if (localScroller == null) {
        kotlin.g.b.p.hyc();
      }
      localScroller.startScroll(MusicLrcView.c(this.Cef), 0, i, 0, j);
      this.Cef.invalidate();
      AppMethodBeat.o(76032);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView
 * JD-Core Version:    0.7.0.1
 */