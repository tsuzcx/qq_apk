package com.tencent.mm.plugin.recordvideo.model.audio;

import android.net.Uri;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.source.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "getInstance", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "createSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "cacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "userAgent", "", "plugin-recordvideo_release"})
public final class i$a
{
  public static k a(AudioCacheInfo paramAudioCacheInfo, String paramString)
  {
    AppMethodBeat.i(75438);
    kotlin.g.b.p.h(paramAudioCacheInfo, "cacheInfo");
    kotlin.g.b.p.h(paramString, "userAgent");
    if (paramAudioCacheInfo.aXa)
    {
      paramAudioCacheInfo = (k)new com.google.android.exoplayer2.source.h(Uri.parse(s.k(paramAudioCacheInfo.cachePath, false)), (g.a)new r(), (com.google.android.exoplayer2.c.h)new c(), null, null);
      AppMethodBeat.o(75438);
      return paramAudioCacheInfo;
    }
    paramAudioCacheInfo = (k)new com.google.android.exoplayer2.source.h(Uri.parse(paramAudioCacheInfo.musicUrl), (g.a)new com.google.android.exoplayer2.h.p(paramString), (com.google.android.exoplayer2.c.h)new c(), null, null);
    AppMethodBeat.o(75438);
    return paramAudioCacheInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.i.a
 * JD-Core Version:    0.7.0.1
 */