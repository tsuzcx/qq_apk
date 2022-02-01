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
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "trackSelector", "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;", "userAgent", "", "videoTrackSelectionFactory", "Lcom/google/android/exoplayer2/trackselection/AdaptiveTrackSelection$Factory;", "pauseAudio", "", "playAudio", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "resumeAudio", "seekTo", "timeMs", "", "Companion", "plugin-recordvideo_release"})
public final class b
{
  public static final b.a xDq;
  private final String userAgent;
  private final com.google.android.exoplayer2.g.c wjX;
  private final com.google.android.exoplayer2.h.l wjY;
  private v xDo;
  private final a.a xDp;
  
  static
  {
    AppMethodBeat.i(75760);
    xDq = new b.a((byte)0);
    AppMethodBeat.o(75760);
  }
  
  public b(final Context paramContext)
  {
    AppMethodBeat.i(75759);
    this.wjY = new com.google.android.exoplayer2.h.l();
    this.xDp = new a.a((d)this.wjY);
    this.wjX = new com.google.android.exoplayer2.g.c((f.a)this.xDp);
    String str = x.h(paramContext, paramContext.getString(2131755822));
    if (str == null) {
      p.gfZ();
    }
    this.userAgent = str;
    com.tencent.e.h.LTJ.aT((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200375);
        b.a(this.xDr, g.a(paramContext, (com.google.android.exoplayer2.g.h)b.b(this.xDr)));
        v localv = b.a(this.xDr);
        if (localv != null)
        {
          localv.setRepeatMode(2);
          AppMethodBeat.o(200375);
          return;
        }
        AppMethodBeat.o(200375);
      }
    });
    AppMethodBeat.o(75759);
  }
  
  public final v d(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(200376);
    pauseAudio();
    if (paramAudioCacheInfo != null)
    {
      ad.i("MicroMsg.EditMusicController", "play music: " + paramAudioCacheInfo.musicUrl);
      if (((paramAudioCacheInfo.aXj) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.cachePath))) || ((!paramAudioCacheInfo.aXj) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.musicUrl))))
      {
        AppMethodBeat.o(200376);
        return null;
      }
      Object localObject1 = this.xDo;
      if (localObject1 != null) {
        ((v)localObject1).aP(true);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.i.xzM;
      localObject1 = i.a.a(paramAudioCacheInfo, this.userAgent);
      Object localObject2 = this.xDo;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.i)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.dGL().oz(String.valueOf(paramAudioCacheInfo.xyZ));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dGL();
      int i = paramAudioCacheInfo.dnh;
      localObject2 = AudioCacheInfo.xzp;
      if (i == AudioCacheInfo.dFY()) {}
      for (long l = 0L;; l = paramAudioCacheInfo.position + 1)
      {
        ((fp)localObject1).kq(l);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.dGL().kr(paramAudioCacheInfo.xze);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.dGM().lu(1L);
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.dGf();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject1).hj(paramAudioCacheInfo.xyZ, paramAudioCacheInfo.dnh);
        }
        paramAudioCacheInfo = this.xDo;
        AppMethodBeat.o(200376);
        return paramAudioCacheInfo;
      }
    }
    AppMethodBeat.o(200376);
    return null;
  }
  
  public final void dGF()
  {
    AppMethodBeat.i(200378);
    v localv = this.xDo;
    if (localv != null)
    {
      localv.aP(true);
      AppMethodBeat.o(200378);
      return;
    }
    AppMethodBeat.o(200378);
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(75758);
    ad.i("MicroMsg.EditMusicController", "pause music");
    Object localObject = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    com.tencent.mm.plugin.recordvideo.d.c.dGL().oz("");
    localObject = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    com.tencent.mm.plugin.recordvideo.d.c.dGL().kq(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    com.tencent.mm.plugin.recordvideo.d.c.dGL().kr(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    com.tencent.mm.plugin.recordvideo.d.c.dGM().lu(0L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.dGf();
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).dGa();
    }
    localObject = this.xDo;
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
    AppMethodBeat.i(200379);
    ad.i("MicroMsg.EditMusicController", "release");
    v localv = this.xDo;
    if (localv != null) {
      localv.stop();
    }
    localv = this.xDo;
    if (localv != null) {
      localv.release();
    }
    this.xDo = null;
    AppMethodBeat.o(200379);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(200377);
    v localv = this.xDo;
    if (localv != null)
    {
      localv.seekTo(paramLong);
      AppMethodBeat.o(200377);
      return;
    }
    AppMethodBeat.o(200377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */