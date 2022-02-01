package com.tencent.mm.plugin.ringtone.j;

import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.g.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/service/ExoRingtonePlayer;", "Lcom/tencent/mm/plugin/ringtone/service/RingtonePlayer;", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "soundInfo", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;", "isOutCall", "", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;Z)V", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "currentVolume", "", "mPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "renderersFactory", "Lcom/google/android/exoplayer2/DefaultRenderersFactory;", "getRenderersFactory", "()Lcom/google/android/exoplayer2/DefaultRenderersFactory;", "setRenderersFactory", "(Lcom/google/android/exoplayer2/DefaultRenderersFactory;)V", "trackSelector", "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;", "videoTrackSelectionFactory", "Lcom/google/android/exoplayer2/trackselection/AdaptiveTrackSelection$Factory;", "adjustVolume", "", "left", "right", "getCurrentPosition", "", "getStreamType", "", "isPlaying", "pause", "play", "prepare", "seekStartMs", "release", "seek", "timeMs", "setMute", "mute", "setOnErrorListener", "listener", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "error", "stopAsync", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  private final c LLe;
  private final l LLf;
  com.google.android.exoplayer2.d ODR;
  private final com.google.android.exoplayer2.g.a.a ODS;
  private float ODT;
  private v ODU;
  
  public a(com.tencent.mm.plugin.thumbplayer.a.b paramb, final b.b paramb1, boolean paramBoolean)
  {
    super(paramb, paramb1, paramBoolean);
    AppMethodBeat.i(272866);
    this.ODR = new com.google.android.exoplayer2.d(MMApplicationContext.getContext(), '\000');
    this.LLf = new l();
    this.ODS = new com.google.android.exoplayer2.g.a.a((com.google.android.exoplayer2.h.d)this.LLf);
    this.LLe = new c((f.a)this.ODS);
    this.ODT = 1.0F;
    com.tencent.mm.ae.d.e("MicroMsg.RingtonePlayer", (kotlin.g.a.a)new u(paramb1) {});
    AppMethodBeat.o(272866);
  }
  
  public final void aC(kotlin.g.a.b<? super Exception, ah> paramb)
  {
    AppMethodBeat.i(272948);
    s.u(paramb, "listener");
    v localv = this.ODU;
    if (localv != null) {
      localv.a((q.a)new g(paramb));
    }
    AppMethodBeat.o(272948);
  }
  
  public final void da(final float paramFloat)
  {
    AppMethodBeat.i(272912);
    com.tencent.mm.ae.d.e("MicroMsg.RingtonePlayer", (kotlin.g.a.a)new a(this, paramFloat));
    AppMethodBeat.o(272912);
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(272941);
    v localv = this.ODU;
    if (localv == null)
    {
      AppMethodBeat.o(272941);
      return 0L;
    }
    long l = localv.getCurrentPosition();
    AppMethodBeat.o(272941);
    return l;
  }
  
  public final int getStreamType()
  {
    AppMethodBeat.i(272935);
    int i = gOK().streamType;
    AppMethodBeat.o(272935);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(272927);
    v localv = this.ODU;
    if ((localv != null) && (localv.QC() == 3))
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
      localv = this.ODU;
      if ((localv == null) || (localv.QD() != true)) {
        break label63;
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label68;
      }
      AppMethodBeat.o(272927);
      return true;
      i = 0;
      break;
    }
    label68:
    AppMethodBeat.o(272927);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(272908);
    com.tencent.mm.ae.d.e("MicroMsg.RingtonePlayer", (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(272908);
  }
  
  public final void play()
  {
    AppMethodBeat.i(272902);
    com.tencent.mm.ae.d.e("MicroMsg.RingtonePlayer", (kotlin.g.a.a)new c(this));
    AppMethodBeat.o(272902);
  }
  
  public final void release()
  {
    AppMethodBeat.i(272957);
    com.tencent.mm.ae.d.e("MicroMsg.RingtonePlayer", (kotlin.g.a.a)new e(this));
    AppMethodBeat.o(272957);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(272918);
    com.tencent.mm.ae.d.e("MicroMsg.RingtonePlayer", (kotlin.g.a.a)new f(paramBoolean, this));
    AppMethodBeat.o(272918);
  }
  
  public final void stopAsync()
  {
    AppMethodBeat.i(272953);
    com.tencent.mm.ae.d.e("MicroMsg.RingtonePlayer", (kotlin.g.a.a)new h(this));
    AppMethodBeat.o(272953);
  }
  
  public final void tL(final long paramLong)
  {
    AppMethodBeat.i(272897);
    com.tencent.mm.ae.d.e("MicroMsg.RingtonePlayer", (kotlin.g.a.a)new d(this, paramLong));
    AppMethodBeat.o(272897);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(a parama, float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(a parama, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(boolean paramBoolean, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/service/ExoRingtonePlayer$setOnErrorListener$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "error", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements q.a
  {
    g(kotlin.g.a.b<? super Exception, ah> paramb) {}
    
    public final void onLoadingChanged(boolean paramBoolean) {}
    
    public final void onPlaybackParametersChanged(p paramp) {}
    
    public final void onPlayerError(e parame)
    {
      boolean bool2 = true;
      Object localObject2 = null;
      AppMethodBeat.i(272903);
      StringBuilder localStringBuilder = new StringBuilder("onExoPlayError, error type:");
      if (parame == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(", message:");
        if (parame != null) {
          break label157;
        }
      }
      label157:
      for (Object localObject1 = null;; localObject1 = parame.getLocalizedMessage())
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(", rendererException:");
        if (parame != null) {
          break label166;
        }
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(", sourceException:");
        if (parame != null) {
          break label197;
        }
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(", unexpectedException:");
        if (parame != null) {
          break label227;
        }
        localObject1 = localObject2;
        Log.e("MicroMsg.RingtonePlayer", localObject1);
        this.ODX.invoke(parame);
        AppMethodBeat.o(272903);
        return;
        localObject1 = Integer.valueOf(parame.type);
        break;
      }
      label166:
      if (parame.type == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool1);
        localObject1 = (Exception)parame.getCause();
        break;
      }
      label197:
      if (parame.type == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool1);
        localObject1 = (IOException)parame.getCause();
        break;
      }
      label227:
      if (parame.type == 2) {}
      for (bool1 = bool2;; bool1 = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool1);
        localObject1 = (RuntimeException)parame.getCause();
        break;
      }
    }
    
    public final void onPlayerStateChanged(boolean paramBoolean, int paramInt) {}
    
    public final void onPositionDiscontinuity() {}
    
    public final void onRepeatModeChanged(int paramInt) {}
    
    public final void onTimelineChanged(w paramw, Object paramObject) {}
    
    public final void onTracksChanged(r paramr, g paramg) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.j.a
 * JD-Core Version:    0.7.0.1
 */