package com.tencent.mm.plugin.recordvideo.plugin.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "trackSelector", "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;", "userAgent", "", "videoTrackSelectionFactory", "Lcom/google/android/exoplayer2/trackselection/AdaptiveTrackSelection$Factory;", "pauseAudio", "", "playAudio", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "resumeAudio", "seekTo", "timeMs", "", "Companion", "plugin-recordvideo_release"})
public final class b
{
  public static final a vmL;
  private v rdN;
  private final com.google.android.exoplayer2.h.l rdP;
  private final com.google.android.exoplayer2.g.c tVT;
  private final String userAgent;
  private final a.a vmK;
  
  static
  {
    AppMethodBeat.i(75760);
    vmL = new a((byte)0);
    AppMethodBeat.o(75760);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(75759);
    this.rdP = new com.google.android.exoplayer2.h.l();
    this.vmK = new a.a((d)this.rdP);
    this.tVT = new com.google.android.exoplayer2.g.c((f.a)this.vmK);
    String str = x.i(paramContext, paramContext.getString(2131755822));
    if (str == null) {
      k.fvU();
    }
    this.userAgent = str;
    this.rdN = g.a(paramContext, (h)this.tVT);
    paramContext = this.rdN;
    if (paramContext != null)
    {
      paramContext.setRepeatMode(2);
      AppMethodBeat.o(75759);
      return;
    }
    AppMethodBeat.o(75759);
  }
  
  public final v e(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(204216);
    pauseAudio();
    if (paramAudioCacheInfo != null)
    {
      ad.i("MicroMsg.EditMusicController", "play music: " + paramAudioCacheInfo.musicUrl);
      if (((paramAudioCacheInfo.aMb) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.cachePath))) || ((!paramAudioCacheInfo.aMb) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.musicUrl))))
      {
        AppMethodBeat.o(204216);
        return null;
      }
      Object localObject1 = this.rdN;
      if (localObject1 != null) {
        ((v)localObject1).aO(true);
      }
      localObject1 = i.vjj;
      localObject1 = i.a.a(paramAudioCacheInfo, this.userAgent);
      Object localObject2 = this.rdN;
      if (localObject2 != null) {
        ((v)localObject2).a((j)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.diy().jw(String.valueOf(paramAudioCacheInfo.viz));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diy();
      int i = paramAudioCacheInfo.dep;
      localObject2 = AudioCacheInfo.viM;
      if (i == AudioCacheInfo.dhR()) {}
      for (long l = 0L;; l = paramAudioCacheInfo.position + 1)
      {
        ((dc)localObject1).fr(l);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.diy().fs(paramAudioCacheInfo.viE);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.diz().gv(1L);
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.dhW();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject1).ld(paramAudioCacheInfo.viz, paramAudioCacheInfo.dep);
        }
        paramAudioCacheInfo = this.rdN;
        AppMethodBeat.o(204216);
        return paramAudioCacheInfo;
      }
    }
    AppMethodBeat.o(204216);
    return null;
  }
  
  public final void fYo()
  {
    AppMethodBeat.i(204218);
    v localv = this.rdN;
    if (localv != null)
    {
      localv.aO(true);
      AppMethodBeat.o(204218);
      return;
    }
    AppMethodBeat.o(204218);
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(75758);
    ad.i("MicroMsg.EditMusicController", "pause music");
    Object localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diy().jw("");
    localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diy().fr(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diy().fs(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diz().gv(0L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.dhW();
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).dhS();
    }
    localObject = this.rdN;
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
    AppMethodBeat.i(204219);
    ad.i("MicroMsg.EditMusicController", "release");
    v localv = this.rdN;
    if (localv != null) {
      localv.stop();
    }
    localv = this.rdN;
    if (localv != null) {
      localv.release();
    }
    this.rdN = null;
    AppMethodBeat.o(204219);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(204217);
    v localv = this.rdN;
    if (localv != null)
    {
      localv.seekTo(paramLong);
      AppMethodBeat.o(204217);
      return;
    }
    AppMethodBeat.o(204217);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */