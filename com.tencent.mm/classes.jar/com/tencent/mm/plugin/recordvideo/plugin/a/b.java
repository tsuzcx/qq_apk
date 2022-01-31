package com.tencent.mm.plugin.recordvideo.plugin.a;

import a.f.b.j;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.i;
import com.tencent.mm.plugin.story.model.audio.i.a;
import com.tencent.mm.sdk.platformtools.ah;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "trackSelector", "Lcom/google/android/exoplayer2/trackselection/DefaultTrackSelector;", "userAgent", "", "videoTrackSelectionFactory", "Lcom/google/android/exoplayer2/trackselection/AdaptiveTrackSelection$Factory;", "pauseAudio", "", "playAudio", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-recordvideo_release"})
public final class b
{
  private final c oYM;
  private final com.google.android.exoplayer2.h.l oYN;
  private v qdF;
  private final a.a qdG;
  private final String userAgent;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(150793);
    this.oYN = new com.google.android.exoplayer2.h.l();
    this.qdG = new a.a((d)this.oYN);
    this.oYM = new c((f.a)this.qdG);
    paramContext = x.i(paramContext, paramContext.getString(2131297005));
    if (paramContext == null) {
      j.ebi();
    }
    this.userAgent = paramContext;
    AppMethodBeat.o(150793);
  }
  
  public final v b(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(150791);
    pauseAudio();
    if (paramAudioCacheInfo != null)
    {
      if (((paramAudioCacheInfo.arq) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.cachePath))) || ((!paramAudioCacheInfo.arq) && (TextUtils.isEmpty((CharSequence)paramAudioCacheInfo.musicUrl))))
      {
        AppMethodBeat.o(150791);
        return null;
      }
      this.qdF = g.a(ah.getContext(), (h)this.oYM);
      Object localObject = this.qdF;
      if (localObject != null) {
        ((v)localObject).setRepeatMode(2);
      }
      localObject = this.qdF;
      if (localObject != null) {
        ((v)localObject).aC(true);
      }
      localObject = i.swW;
      paramAudioCacheInfo = i.a.a(paramAudioCacheInfo, this.userAgent);
      localObject = this.qdF;
      if (localObject != null) {
        ((v)localObject).a(paramAudioCacheInfo);
      }
      paramAudioCacheInfo = this.qdF;
      AppMethodBeat.o(150791);
      return paramAudioCacheInfo;
    }
    AppMethodBeat.o(150791);
    return null;
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(150792);
    v localv = this.qdF;
    if ((localv == null) || (localv.mJ() != 4))
    {
      localv = this.qdF;
      if (localv != null) {
        localv.stop();
      }
      localv = this.qdF;
      if (localv != null) {
        localv.release();
      }
      this.qdF = null;
    }
    AppMethodBeat.o(150792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */