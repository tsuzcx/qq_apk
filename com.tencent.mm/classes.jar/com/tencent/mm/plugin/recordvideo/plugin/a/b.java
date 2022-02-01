package com.tencent.mm.plugin.recordvideo.plugin.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "trackSelector", "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;", "userAgent", "", "videoTrackSelectionFactory", "Lcom/google/android/exoplayer2/trackselection/AdaptiveTrackSelection$Factory;", "pauseAudio", "", "playAudio", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "resumeAudio", "seekTo", "timeMs", "", "Companion", "plugin-recordvideo_release"})
public final class b
{
  public static final b.a wvu;
  private final String userAgent;
  private final com.google.android.exoplayer2.g.c veC;
  private final com.google.android.exoplayer2.h.l veD;
  private v wvs;
  private final a.a wvt;
  
  static
  {
    AppMethodBeat.i(75760);
    wvu = new b.a((byte)0);
    AppMethodBeat.o(75760);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(75759);
    this.veD = new com.google.android.exoplayer2.h.l();
    this.wvt = new a.a((d)this.veD);
    this.veC = new com.google.android.exoplayer2.g.c((f.a)this.wvt);
    String str = x.i(paramContext, paramContext.getString(2131755822));
    if (str == null) {
      k.fOy();
    }
    this.userAgent = str;
    this.wvs = g.a(paramContext, (h)this.veC);
    paramContext = this.wvs;
    if (paramContext != null)
    {
      paramContext.setRepeatMode(2);
      AppMethodBeat.o(75759);
      return;
    }
    AppMethodBeat.o(75759);
  }
  
  public final v d(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(199335);
    pauseAudio();
    if (paramAudioCacheInfo != null)
    {
      ac.i("MicroMsg.EditMusicController", "play music: " + paramAudioCacheInfo.musicUrl);
      if (((paramAudioCacheInfo.aMR) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.cachePath))) || ((!paramAudioCacheInfo.aMR) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.musicUrl))))
      {
        AppMethodBeat.o(199335);
        return null;
      }
      Object localObject1 = this.wvs;
      if (localObject1 != null) {
        ((v)localObject1).aO(true);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.i.wrV;
      localObject1 = i.a.a(paramAudioCacheInfo, this.userAgent);
      Object localObject2 = this.wvs;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.i)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.dwr().mm(String.valueOf(paramAudioCacheInfo.wri));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dwr();
      int i = paramAudioCacheInfo.dbL;
      localObject2 = AudioCacheInfo.wry;
      if (i == AudioCacheInfo.dvC()) {}
      for (long l = 0L;; l = paramAudioCacheInfo.position + 1)
      {
        ((eq)localObject1).iE(l);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.dwr().iF(paramAudioCacheInfo.wrn);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.dws().jI(1L);
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
        localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.c.dvH();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject1).gS(paramAudioCacheInfo.wri, paramAudioCacheInfo.dbL);
        }
        paramAudioCacheInfo = this.wvs;
        AppMethodBeat.o(199335);
        return paramAudioCacheInfo;
      }
    }
    AppMethodBeat.o(199335);
    return null;
  }
  
  public final void dwl()
  {
    AppMethodBeat.i(199337);
    v localv = this.wvs;
    if (localv != null)
    {
      localv.aO(true);
      AppMethodBeat.o(199337);
      return;
    }
    AppMethodBeat.o(199337);
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(75758);
    ac.i("MicroMsg.EditMusicController", "pause music");
    Object localObject = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    com.tencent.mm.plugin.recordvideo.d.c.dwr().mm("");
    localObject = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    com.tencent.mm.plugin.recordvideo.d.c.dwr().iE(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    com.tencent.mm.plugin.recordvideo.d.c.dwr().iF(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    com.tencent.mm.plugin.recordvideo.d.c.dws().jI(0L);
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.dvH();
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).dvD();
    }
    localObject = this.wvs;
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
    AppMethodBeat.i(199338);
    ac.i("MicroMsg.EditMusicController", "release");
    v localv = this.wvs;
    if (localv != null) {
      localv.stop();
    }
    localv = this.wvs;
    if (localv != null) {
      localv.release();
    }
    this.wvs = null;
    AppMethodBeat.o(199338);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(199336);
    v localv = this.wvs;
    if (localv != null)
    {
      localv.seekTo(paramLong);
      AppMethodBeat.o(199336);
      return;
    }
    AppMethodBeat.o(199336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */