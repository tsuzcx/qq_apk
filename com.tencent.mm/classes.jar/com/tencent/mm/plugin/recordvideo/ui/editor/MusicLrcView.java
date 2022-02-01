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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRunningShow", "", "()Z", "setRunningShow", "(Z)V", "mFirst", "mScroller", "Landroid/widget/Scroller;", "mXPaused", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "rndDuration", "getRndDuration", "()I", "setRndDuration", "(I)V", "scrollFirstDelay", "getScrollFirstDelay", "setScrollFirstDelay", "calculateScrollingLen", "computeScroll", "", "fillText", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$MusicLrcBean;", "Lkotlin/collections/ArrayList;", "hlString", "", "resumeScroll", "setShow", "isShow", "spanForQuery", "", "source", "startScroll", "stopScroll", "plugin-recordvideo_release"})
@SuppressLint({"AppCompatCustomView"})
public final class MusicLrcView
  extends TextView
{
  private Scroller mScroller;
  private boolean vqe;
  private v vqg;
  private int vsg;
  private int vsh;
  private boolean vsi;
  private int vsj;
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76042);
    this.vsg = 10000;
    this.vsh = (-getWidth());
    this.vsi = true;
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
  
  private void diT()
  {
    AppMethodBeat.i(76036);
    if (!this.vqe)
    {
      AppMethodBeat.o(76036);
      return;
    }
    this.vsh = (-getWidth());
    setHorizontallyScrolling(true);
    if (this.mScroller == null)
    {
      this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
      setScroller(this.mScroller);
    }
    final int j = diU();
    final int i = j - this.vsh * 3 / 4;
    if (i != 0)
    {
      j = this.vsg * i / j;
      if (this.vsi)
      {
        postDelayed((Runnable)new b(this, i, j), this.vsj);
        AppMethodBeat.o(76036);
        return;
      }
      Scroller localScroller = this.mScroller;
      if (localScroller == null) {
        k.fvU();
      }
      localScroller.startScroll(this.vsh, 0, i, 0, j);
      invalidate();
    }
    AppMethodBeat.o(76036);
  }
  
  private final int diU()
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
  
  public final void cMi()
  {
    AppMethodBeat.i(76035);
    if (this.vqe)
    {
      this.vsh = getWidth();
      this.vsi = true;
      diT();
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
      k.fvU();
    }
    if (localScroller.isFinished())
    {
      this.vsh = (-getWidth());
      this.vsi = false;
      diT();
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
            ((StringBuilder)localObject1).append(((AudioCacheInfo.c)((Iterator)localObject2).next()).viN).append("  ");
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
      this.vsg = (((AudioCacheInfo.c)j.iA((List)paramArrayList)).viO - ((AudioCacheInfo.c)j.iy((List)paramArrayList)).cUL);
      if (this.vsg == 0) {
        this.vsg = 10000;
      }
      AppMethodBeat.o(76037);
      return;
      i = 0;
      break;
    }
  }
  
  public final v getPlayer()
  {
    return this.vqg;
  }
  
  public final int getRndDuration()
  {
    return this.vsg;
  }
  
  public final int getScrollFirstDelay()
  {
    return this.vsj;
  }
  
  public final void setPlayer(v paramv)
  {
    AppMethodBeat.i(76033);
    if (paramv != null)
    {
      this.vqg = paramv;
      paramv = this.vqg;
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
    this.vsg = paramInt;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.vqe = paramBoolean;
  }
  
  public final void setScrollFirstDelay(int paramInt)
  {
    this.vsj = paramInt;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(76034);
    this.vqe = paramBoolean;
    if (!this.vqe)
    {
      if (this.mScroller != null)
      {
        Scroller localScroller = this.mScroller;
        if (localScroller == null) {
          k.fvU();
        }
        localScroller.startScroll(0, 0, 0, 0, 0);
      }
      AppMethodBeat.o(76034);
      return;
    }
    cMi();
    AppMethodBeat.o(76034);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/ui/editor/MusicLrcView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
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
        this.vsk.cMi();
        localObject1 = this.vsk.getPlayer();
        if (localObject1 == null) {
          break label118;
        }
      }
      label118:
      for (Object localObject1 = Long.valueOf(((v)localObject1).getDuration());; localObject1 = null)
      {
        if (localObject1 == null) {
          k.fvU();
        }
        if (((Long)localObject1).longValue() < this.vsk.getRndDuration())
        {
          MusicLrcView localMusicLrcView = this.vsk;
          v localv = this.vsk.getPlayer();
          localObject1 = localObject2;
          if (localv != null) {
            localObject1 = Long.valueOf(localv.getDuration());
          }
          if (localObject1 == null) {
            k.fvU();
          }
          localMusicLrcView.setRndDuration((int)((Long)localObject1).longValue());
        }
        AppMethodBeat.o(76031);
        return;
      }
    }
    
    public final void rJ() {}
    
    public final void rK() {}
    
    public final void rL() {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MusicLrcView paramMusicLrcView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76032);
      Scroller localScroller = MusicLrcView.a(this.vsk);
      if (localScroller == null) {
        k.fvU();
      }
      localScroller.startScroll(MusicLrcView.b(this.vsk), 0, i, 0, j);
      this.vsk.invalidate();
      AppMethodBeat.o(76032);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView
 * JD-Core Version:    0.7.0.1
 */