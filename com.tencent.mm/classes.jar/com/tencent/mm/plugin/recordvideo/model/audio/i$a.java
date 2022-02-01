package com.tencent.mm.plugin.recordvideo.model.audio;

import android.net.Uri;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "getInstance", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "createSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "cacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "userAgent", "", "plugin-recordvideo_release"})
public final class i$a
{
  public static i a(AudioCacheInfo paramAudioCacheInfo, String paramString)
  {
    AppMethodBeat.i(75438);
    d.g.b.p.h(paramAudioCacheInfo, "cacheInfo");
    d.g.b.p.h(paramString, "userAgent");
    if (paramAudioCacheInfo.aXj)
    {
      paramAudioCacheInfo = (i)new g(Uri.parse(paramAudioCacheInfo.cachePath), (g.a)new r(), (h)new c(), null, null);
      AppMethodBeat.o(75438);
      return paramAudioCacheInfo;
    }
    paramAudioCacheInfo = (i)new g(Uri.parse(paramAudioCacheInfo.musicUrl), (g.a)new com.google.android.exoplayer2.h.p(paramString), (h)new c(), null, null);
    AppMethodBeat.o(75438);
    return paramAudioCacheInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.i.a
 * JD-Core Version:    0.7.0.1
 */