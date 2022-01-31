package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import android.net.Uri;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.p;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager;", "getInstance", "()Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager;", "createSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "cacheInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "userAgent", "", "plugin-story_release"})
public final class i$a
{
  public static i a(AudioCacheInfo paramAudioCacheInfo, String paramString)
  {
    AppMethodBeat.i(109198);
    j.q(paramAudioCacheInfo, "cacheInfo");
    j.q(paramString, "userAgent");
    if (paramAudioCacheInfo.arq)
    {
      paramAudioCacheInfo = (i)new g(Uri.parse(paramAudioCacheInfo.cachePath), (g.a)new r(), (h)new c(), null, null);
      AppMethodBeat.o(109198);
      return paramAudioCacheInfo;
    }
    paramAudioCacheInfo = (i)new g(Uri.parse(paramAudioCacheInfo.musicUrl), (g.a)new p(paramString), (h)new c(), null, null);
    AppMethodBeat.o(109198);
    return paramAudioCacheInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.i.a
 * JD-Core Version:    0.7.0.1
 */