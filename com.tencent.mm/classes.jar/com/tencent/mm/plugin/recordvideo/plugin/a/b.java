package com.tencent.mm.plugin.recordvideo.plugin.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "trackSelector", "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;", "userAgent", "", "videoTrackSelectionFactory", "Lcom/google/android/exoplayer2/trackselection/AdaptiveTrackSelection$Factory;", "pauseAudio", "", "playAudio", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "resumeAudio", "seekTo", "timeMs", "", "Companion", "plugin-recordvideo_release"})
public final class b
{
  public static final b.a xTl;
  private final String userAgent;
  private final com.google.android.exoplayer2.g.c wzC;
  private final com.google.android.exoplayer2.h.l wzD;
  private v xTj;
  private final a.a xTk;
  
  static
  {
    AppMethodBeat.i(75760);
    xTl = new b.a((byte)0);
    AppMethodBeat.o(75760);
  }
  
  public b(final Context paramContext)
  {
    AppMethodBeat.i(75759);
    this.wzD = new com.google.android.exoplayer2.h.l();
    this.xTk = new a.a((d)this.wzD);
    this.wzC = new com.google.android.exoplayer2.g.c((f.a)this.xTk);
    String str = x.h(paramContext, paramContext.getString(2131755822));
    if (str == null) {
      p.gkB();
    }
    this.userAgent = str;
    com.tencent.e.h.MqF.aQ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206636);
        b.a(this.xTm, g.a(paramContext, (com.google.android.exoplayer2.g.h)b.b(this.xTm)));
        v localv = b.a(this.xTm);
        if (localv != null)
        {
          localv.setRepeatMode(2);
          AppMethodBeat.o(206636);
          return;
        }
        AppMethodBeat.o(206636);
      }
    });
    AppMethodBeat.o(75759);
  }
  
  public final v d(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(206637);
    pauseAudio();
    if (paramAudioCacheInfo != null)
    {
      ae.i("MicroMsg.EditMusicController", "play music: " + paramAudioCacheInfo.musicUrl);
      if (((paramAudioCacheInfo.aXj) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.cachePath))) || ((!paramAudioCacheInfo.aXj) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.musicUrl))))
      {
        AppMethodBeat.o(206637);
        return null;
      }
      Object localObject1 = this.xTj;
      if (localObject1 != null) {
        ((v)localObject1).aP(true);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.i.xPI;
      localObject1 = i.a.a(paramAudioCacheInfo, this.userAgent);
      Object localObject2 = this.xTj;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.i)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.dKc().oU(String.valueOf(paramAudioCacheInfo.xOV));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dKc();
      int i = paramAudioCacheInfo.doj;
      localObject2 = AudioCacheInfo.xPl;
      if (i == AudioCacheInfo.dJp()) {}
      for (long l = 0L;; l = paramAudioCacheInfo.position + 1)
      {
        ((fr)localObject1).kB(l);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.dKc().kC(paramAudioCacheInfo.xPa);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.dKd().lF(1L);
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.xPA;
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.dJw();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject1).hl(paramAudioCacheInfo.xOV, paramAudioCacheInfo.doj);
        }
        paramAudioCacheInfo = this.xTj;
        AppMethodBeat.o(206637);
        return paramAudioCacheInfo;
      }
    }
    AppMethodBeat.o(206637);
    return null;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(206639);
    v localv = this.xTj;
    if (localv != null)
    {
      localv.aP(true);
      AppMethodBeat.o(206639);
      return;
    }
    AppMethodBeat.o(206639);
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(75758);
    ae.i("MicroMsg.EditMusicController", "pause music");
    Object localObject = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    com.tencent.mm.plugin.recordvideo.d.c.dKc().oU("");
    localObject = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    com.tencent.mm.plugin.recordvideo.d.c.dKc().kB(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    com.tencent.mm.plugin.recordvideo.d.c.dKc().kC(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    com.tencent.mm.plugin.recordvideo.d.c.dKd().lF(0L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.xPA;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.dJw();
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).dJr();
    }
    localObject = this.xTj;
    if (localObject != null)
    {
      ((v)localObject).aP(false);
      AppMethodBeat.o(75758);
      return;
    }
    AppMethodBeat.o(75758);
  }
  
  public final void release()
  {
    AppMethodBeat.i(206640);
    ae.i("MicroMsg.EditMusicController", "release");
    v localv = this.xTj;
    if (localv != null) {
      localv.stop();
    }
    localv = this.xTj;
    if (localv != null) {
      localv.release();
    }
    this.xTj = null;
    AppMethodBeat.o(206640);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(206638);
    v localv = this.xTj;
    if (localv != null)
    {
      localv.seekTo(paramLong);
      AppMethodBeat.o(206638);
      return;
    }
    AppMethodBeat.o(206638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */