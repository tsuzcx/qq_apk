package com.tencent.mm.plugin.recordvideo.model.audio;

import android.net.Uri;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.p;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.source.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "getInstance", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "createSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "cacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "userAgent", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k$a
{
  public static k a(AudioCacheInfo paramAudioCacheInfo, String paramString)
  {
    AppMethodBeat.i(75438);
    s.u(paramAudioCacheInfo, "cacheInfo");
    s.u(paramString, "userAgent");
    if (paramAudioCacheInfo.cached)
    {
      paramAudioCacheInfo = (k)new com.google.android.exoplayer2.source.h(Uri.parse(y.n(paramAudioCacheInfo.cachePath, false)), (g.a)new r(), (com.google.android.exoplayer2.c.h)new c(), null, null);
      AppMethodBeat.o(75438);
      return paramAudioCacheInfo;
    }
    paramAudioCacheInfo = (k)new com.google.android.exoplayer2.source.h(Uri.parse(paramAudioCacheInfo.musicUrl), (g.a)new p(paramString), (com.google.android.exoplayer2.c.h)new c(), null, null);
    AppMethodBeat.o(75438);
    return paramAudioCacheInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.k.a
 * JD-Core Version:    0.7.0.1
 */