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
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "foregroundColor", "isRunningShow", "", "()Z", "setRunningShow", "(Z)V", "mFirst", "mScroller", "Landroid/widget/Scroller;", "mXPaused", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "rndDuration", "getRndDuration", "()I", "setRndDuration", "(I)V", "scrollFirstDelay", "getScrollFirstDelay", "setScrollFirstDelay", "calculateScrollingLen", "computeScroll", "", "fillText", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "hlString", "", "resetScroll", "resumeScroll", "setShow", "isShow", "startOffset", "startScroll", "stopScroll", "Companion", "plugin-recordvideo_release"})
@SuppressLint({"AppCompatCustomView"})
public final class MusicLrcView
  extends TextView
{
  public static final MusicLrcView.a Iau;
  private int Buy;
  private boolean Buz;
  private boolean HWZ;
  private int Ias;
  private int Iat;
  private final int foregroundColor;
  private v kLl;
  private Scroller mScroller;
  
  static
  {
    AppMethodBeat.i(216437);
    Iau = new MusicLrcView.a((byte)0);
    AppMethodBeat.o(216437);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76042);
    this.Ias = 10000;
    this.Buy = (-getWidth());
    this.Buz = true;
    this.foregroundColor = a.w(paramContext, b.b.video_editor_lyric_hint_foreground);
    AppMethodBeat.o(76042);
  }
  
  private void fyA()
  {
    AppMethodBeat.i(76036);
    if (!this.HWZ)
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
    final int j = fyB();
    final int i = j - this.Buy * 3 / 4;
    if (i != 0)
    {
      j = this.Ias * i / j;
      if (this.Buz)
      {
        postDelayed((Runnable)new c(this, i, j), this.Iat);
        AppMethodBeat.o(76036);
        return;
      }
      Scroller localScroller = this.mScroller;
      if (localScroller == null) {
        kotlin.g.b.p.iCn();
      }
      localScroller.startScroll(this.Buy, 0, i, 0, j);
      invalidate();
    }
    AppMethodBeat.o(76036);
  }
  
  private final int fyB()
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
  
  private void fyz()
  {
    AppMethodBeat.i(216434);
    if (this.HWZ)
    {
      this.Buy = getWidth();
      this.Buz = true;
      fyA();
    }
    AppMethodBeat.o(216434);
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
      kotlin.g.b.p.iCn();
    }
    if (localScroller.isFinished())
    {
      this.Buy = (-getWidth());
      this.Buz = false;
      fyA();
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
            ((StringBuilder)localObject1).append(((AudioCacheInfo.c)((Iterator)localObject2).next()).HMb).append("  ");
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
        kotlin.g.b.p.j(localObject2, "sb.toString()");
        if (!n.a((CharSequence)localObject2, (CharSequence)paramString, false)) {
          break label233;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        kotlin.g.b.p.j(localObject1, "sb.toString()");
      }
    }
    label228:
    label233:
    for (paramString = MusicLrcView.a.a((String)localObject1, (CharSequence)paramString, this.foregroundColor);; paramString = (CharSequence)((StringBuilder)localObject1).toString())
    {
      setText(paramString);
      this.Ias = (((AudioCacheInfo.c)j.lq((List)paramArrayList)).HMc - ((AudioCacheInfo.c)j.lo((List)paramArrayList)).fod);
      if (this.Ias == 0) {
        this.Ias = 10000;
      }
      AppMethodBeat.o(76037);
      return;
      i = 0;
      break;
    }
  }
  
  public final v getPlayer()
  {
    return this.kLl;
  }
  
  public final int getRndDuration()
  {
    return this.Ias;
  }
  
  public final int getScrollFirstDelay()
  {
    return this.Iat;
  }
  
  public final void setPlayer(v paramv)
  {
    AppMethodBeat.i(76033);
    if (paramv != null)
    {
      this.kLl = paramv;
      paramv = this.kLl;
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
    this.Ias = paramInt;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.HWZ = paramBoolean;
  }
  
  public final void setScrollFirstDelay(int paramInt)
  {
    this.Iat = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
  public static final class b
    implements q.a
  {
    public final void I(int paramInt) {}
    
    public final void a(e parame) {}
    
    public final void a(r paramr, g paramg) {}
    
    public final void aP(boolean paramBoolean) {}
    
    public final void b(com.google.android.exoplayer2.p paramp) {}
    
    public final void b(w paramw, Object paramObject) {}
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(76031);
      if (paramInt == 3)
      {
        MusicLrcView.a(this.Iav);
        localObject1 = this.Iav.getPlayer();
        if (localObject1 == null) {
          break label118;
        }
      }
      label118:
      for (Object localObject1 = Long.valueOf(((v)localObject1).getDuration());; localObject1 = null)
      {
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        if (((Long)localObject1).longValue() < this.Iav.getRndDuration())
        {
          MusicLrcView localMusicLrcView = this.Iav;
          v localv = this.Iav.getPlayer();
          localObject1 = localObject2;
          if (localv != null) {
            localObject1 = Long.valueOf(localv.getDuration());
          }
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          localMusicLrcView.setRndDuration((int)((Long)localObject1).longValue());
        }
        AppMethodBeat.o(76031);
        return;
      }
    }
    
    public final void rs() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MusicLrcView paramMusicLrcView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76032);
      Scroller localScroller = MusicLrcView.b(this.Iav);
      if (localScroller == null) {
        kotlin.g.b.p.iCn();
      }
      localScroller.startScroll(MusicLrcView.c(this.Iav), 0, i, 0, j);
      this.Iav.invalidate();
      AppMethodBeat.o(76032);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView
 * JD-Core Version:    0.7.0.1
 */