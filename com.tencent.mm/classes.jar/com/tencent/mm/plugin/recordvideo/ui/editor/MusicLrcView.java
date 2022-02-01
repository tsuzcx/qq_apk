package com.tencent.mm.plugin.recordvideo.ui.editor;

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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "foregroundColor", "isRunningShow", "", "()Z", "setRunningShow", "(Z)V", "mFirst", "mScroller", "Landroid/widget/Scroller;", "mXPaused", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "rndDuration", "getRndDuration", "()I", "setRndDuration", "(I)V", "scrollFirstDelay", "getScrollFirstDelay", "setScrollFirstDelay", "calculateScrollingLen", "computeScroll", "", "fillText", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "hlString", "", "resetScroll", "resumeScroll", "setShow", "isShow", "startOffset", "startScroll", "stopScroll", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicLrcView
  extends TextView
{
  public static final MusicLrcView.a NWU;
  private int Hbj;
  private boolean Hbk;
  private boolean NTJ;
  private int NWV;
  private int NWW;
  private final int deT;
  private Scroller mScroller;
  private v nno;
  
  static
  {
    AppMethodBeat.i(279983);
    NWU = new MusicLrcView.a((byte)0);
    AppMethodBeat.o(279983);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(279973);
    AppMethodBeat.o(279973);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76042);
    this.NWV = 10000;
    this.Hbj = (-getWidth());
    this.Hbk = true;
    this.deT = a.w(paramContext, b.b.video_editor_lyric_hint_foreground);
    AppMethodBeat.o(76042);
  }
  
  private static final void a(MusicLrcView paramMusicLrcView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(279978);
    s.u(paramMusicLrcView, "this$0");
    Scroller localScroller = paramMusicLrcView.mScroller;
    s.checkNotNull(localScroller);
    localScroller.startScroll(paramMusicLrcView.Hbj, 0, paramInt1, 0, paramInt2);
    paramMusicLrcView.invalidate();
    AppMethodBeat.o(279978);
  }
  
  private void gKk()
  {
    AppMethodBeat.i(279945);
    if (this.NTJ)
    {
      this.Hbj = getWidth();
      this.Hbk = true;
      gKl();
    }
    AppMethodBeat.o(279945);
  }
  
  private void gKl()
  {
    AppMethodBeat.i(76036);
    if (!this.NTJ)
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
    int j = gKm();
    int i = j - this.Hbj * 3 / 4;
    if (i != 0)
    {
      j = this.NWV * i / j;
      if (this.Hbk)
      {
        postDelayed(new MusicLrcView..ExternalSyntheticLambda0(this, i, j), this.NWW);
        AppMethodBeat.o(76036);
        return;
      }
      Scroller localScroller = this.mScroller;
      s.checkNotNull(localScroller);
      localScroller.startScroll(this.Hbj, 0, i, 0, j);
      invalidate();
    }
    AppMethodBeat.o(76036);
  }
  
  private final int gKm()
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
    s.checkNotNull(localScroller);
    if (localScroller.isFinished())
    {
      this.Hbj = (-getWidth());
      this.Hbk = false;
      gKl();
    }
    AppMethodBeat.o(76041);
  }
  
  public final v getPlayer()
  {
    return this.nno;
  }
  
  public final int getRndDuration()
  {
    return this.NWV;
  }
  
  public final int getScrollFirstDelay()
  {
    return this.NWW;
  }
  
  public final void h(ArrayList<AudioCacheInfo.c> paramArrayList, String paramString)
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
            ((StringBuilder)localObject1).append(((AudioCacheInfo.c)((Iterator)localObject2).next()).NIZ).append("  ");
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
        s.s(localObject2, "sb.toString()");
        if (!n.a((CharSequence)localObject2, (CharSequence)paramString, false)) {
          break label233;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        s.s(localObject1, "sb.toString()");
      }
    }
    label228:
    label233:
    for (paramString = MusicLrcView.a.a((String)localObject1, (CharSequence)paramString, this.deT);; paramString = (CharSequence)((StringBuilder)localObject1).toString())
    {
      setText(paramString);
      this.NWV = (((AudioCacheInfo.c)kotlin.a.p.oM((List)paramArrayList)).NJa - ((AudioCacheInfo.c)kotlin.a.p.oK((List)paramArrayList)).startTime);
      if (this.NWV == 0) {
        this.NWV = 10000;
      }
      AppMethodBeat.o(76037);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setPlayer(v paramv)
  {
    AppMethodBeat.i(76033);
    if (paramv != null)
    {
      this.nno = paramv;
      paramv = this.nno;
      if (paramv != null) {
        paramv.a((q.a)new b(this));
      }
    }
    AppMethodBeat.o(76033);
  }
  
  public final void setRndDuration(int paramInt)
  {
    this.NWV = paramInt;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.NTJ = paramBoolean;
  }
  
  public final void setScrollFirstDelay(int paramInt)
  {
    this.NWW = paramInt;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements q.a
  {
    b(MusicLrcView paramMusicLrcView) {}
    
    public final void onLoadingChanged(boolean paramBoolean) {}
    
    public final void onPlaybackParametersChanged(com.google.android.exoplayer2.p paramp) {}
    
    public final void onPlayerError(e parame) {}
    
    public final void onPlayerStateChanged(boolean paramBoolean, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(76031);
      MusicLrcView localMusicLrcView;
      if (paramInt == 3)
      {
        MusicLrcView.a(this.NWX);
        localObject1 = this.NWX.getPlayer();
        if (localObject1 != null) {
          break label95;
        }
        localObject1 = null;
        s.checkNotNull(localObject1);
        if (((Long)localObject1).longValue() < this.NWX.getRndDuration())
        {
          localMusicLrcView = this.NWX;
          localObject1 = this.NWX.getPlayer();
          if (localObject1 != null) {
            break label106;
          }
        }
      }
      label95:
      label106:
      for (Object localObject1 = localObject2;; localObject1 = Long.valueOf(((v)localObject1).getDuration()))
      {
        s.checkNotNull(localObject1);
        localMusicLrcView.setRndDuration((int)((Long)localObject1).longValue());
        AppMethodBeat.o(76031);
        return;
        localObject1 = Long.valueOf(((v)localObject1).getDuration());
        break;
      }
    }
    
    public final void onPositionDiscontinuity() {}
    
    public final void onRepeatModeChanged(int paramInt) {}
    
    public final void onTimelineChanged(w paramw, Object paramObject) {}
    
    public final void onTracksChanged(r paramr, g paramg) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView
 * JD-Core Version:    0.7.0.1
 */