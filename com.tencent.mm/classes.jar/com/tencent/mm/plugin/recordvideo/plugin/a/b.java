package com.tencent.mm.plugin.recordvideo.plugin.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "trackSelector", "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;", "userAgent", "", "videoTrackSelectionFactory", "Lcom/google/android/exoplayer2/trackselection/AdaptiveTrackSelection$Factory;", "pauseAudio", "", "playAudio", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "resetAudio", "resumeAudio", "seekTo", "timeMs", "", "Companion", "plugin-recordvideo_release"})
public final class b
{
  public static final b.a BTK;
  private final com.google.android.exoplayer2.g.c Ajk;
  private final com.google.android.exoplayer2.h.l Ajl;
  private v BTI;
  private final a.a BTJ;
  private final String userAgent;
  
  static
  {
    AppMethodBeat.i(75760);
    BTK = new b.a((byte)0);
    AppMethodBeat.o(75760);
  }
  
  public b(final Context paramContext)
  {
    AppMethodBeat.i(75759);
    this.Ajl = new com.google.android.exoplayer2.h.l();
    this.BTJ = new a.a((d)this.Ajl);
    this.Ajk = new com.google.android.exoplayer2.g.c((f.a)this.BTJ);
    String str = x.h(paramContext, paramContext.getString(2131755908));
    if (str == null) {
      p.hyc();
    }
    this.userAgent = str;
    com.tencent.f.h.RTc.aZ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237401);
        b.a(this.BTL, g.a(paramContext, (com.google.android.exoplayer2.g.h)b.b(this.BTL)));
        v localv = b.a(this.BTL);
        if (localv != null)
        {
          localv.setRepeatMode(2);
          AppMethodBeat.o(237401);
          return;
        }
        AppMethodBeat.o(237401);
      }
    });
    AppMethodBeat.o(75759);
  }
  
  public final v d(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(237402);
    pauseAudio();
    if (paramAudioCacheInfo != null)
    {
      Log.i("MicroMsg.EditMusicController", "play music: " + paramAudioCacheInfo.musicUrl);
      if (((paramAudioCacheInfo.aXa) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.cachePath))) || ((!paramAudioCacheInfo.aXa) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.musicUrl))))
      {
        AppMethodBeat.o(237402);
        return null;
      }
      Object localObject1 = this.BTI;
      if (localObject1 != null) {
        ((v)localObject1).aO(true);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.i.BPL;
      localObject1 = i.a.a(paramAudioCacheInfo, this.userAgent);
      Object localObject2 = this.BTI;
      if (localObject2 != null) {
        ((v)localObject2).a((k)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.eKX().wD(String.valueOf(paramAudioCacheInfo.BOX));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.eKX();
      int i = paramAudioCacheInfo.source;
      localObject2 = AudioCacheInfo.BPo;
      if (i == AudioCacheInfo.eKc()) {}
      for (long l = 0L;; l = paramAudioCacheInfo.position + 1)
      {
        ((jf)localObject1).rD(l);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().rE(paramAudioCacheInfo.BPd);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKY().sH(1L);
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.eKi();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject1).hV(paramAudioCacheInfo.BOX, paramAudioCacheInfo.source);
        }
        paramAudioCacheInfo = this.BTI;
        AppMethodBeat.o(237402);
        return paramAudioCacheInfo;
      }
    }
    AppMethodBeat.o(237402);
    return null;
  }
  
  public final void eKQ()
  {
    AppMethodBeat.i(237404);
    v localv = this.BTI;
    if (localv != null)
    {
      localv.a(null);
      AppMethodBeat.o(237404);
      return;
    }
    AppMethodBeat.o(237404);
  }
  
  public final void eKR()
  {
    AppMethodBeat.i(237405);
    v localv = this.BTI;
    if (localv != null)
    {
      localv.aO(true);
      AppMethodBeat.o(237405);
      return;
    }
    AppMethodBeat.o(237405);
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(75758);
    Log.i("MicroMsg.EditMusicController", "pause music");
    Object localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.eKX().wD("");
    localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.eKX().rD(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.eKX().rE(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.eKY().sH(0L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.eKi();
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).eKd();
    }
    localObject = this.BTI;
    if (localObject != null)
    {
      ((v)localObject).aO(false);
      AppMethodBeat.o(75758);
      return;
    }
    AppMethodBeat.o(75758);
  }
  
  public final void release()
  {
    AppMethodBeat.i(237406);
    Log.i("MicroMsg.EditMusicController", "release");
    v localv = this.BTI;
    if (localv != null) {
      localv.stop();
    }
    localv = this.BTI;
    if (localv != null) {
      localv.release();
    }
    this.BTI = null;
    AppMethodBeat.o(237406);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(237403);
    v localv = this.BTI;
    if (localv != null)
    {
      localv.seekTo(paramLong);
      AppMethodBeat.o(237403);
      return;
    }
    AppMethodBeat.o(237403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */