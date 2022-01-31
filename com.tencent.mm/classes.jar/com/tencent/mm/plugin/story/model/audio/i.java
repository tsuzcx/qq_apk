package com.tencent.mm.plugin.story.model.audio;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager;", "", "()V", "TAG", "", "audioTaskMap", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/story/model/audio/AudioDownloadTask;", "", "cacheAudio", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "cancelAll", "cancelCache", "Companion", "plugin-story_release"})
public final class i
{
  private static final i swV;
  public static final i.a swW;
  private final String TAG;
  private final Map<Integer, b> swU;
  
  static
  {
    AppMethodBeat.i(109204);
    swW = new i.a((byte)0);
    swV = new i();
    AppMethodBeat.o(109204);
  }
  
  public i()
  {
    AppMethodBeat.i(109203);
    this.TAG = "MicroMsg.StoryAudioManager";
    this.swU = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(109203);
  }
  
  public final void a(AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(109200);
    j.q(paramAudioCacheInfo, "info");
    ab.i(this.TAG, "cache audio " + paramAudioCacheInfo.swp);
    b localb = (b)this.swU.get(Integer.valueOf(paramAudioCacheInfo.swp));
    if (localb == null)
    {
      if (!e.cN(paramAudioCacheInfo.cachePath))
      {
        localb = new b(paramAudioCacheInfo);
        localb.a((m)new i.b(this, paramAudioCacheInfo, paramm));
        localb.start();
        paramm = this.swU;
        j.p(paramm, "audioTaskMap");
        paramm.put(Integer.valueOf(paramAudioCacheInfo.swp), localb);
        AppMethodBeat.o(109200);
        return;
      }
      paramm.h(Boolean.TRUE, paramAudioCacheInfo.cachePath);
      AppMethodBeat.o(109200);
      return;
    }
    localb.a(paramm);
    AppMethodBeat.o(109200);
  }
  
  public final void cancelAll()
  {
    AppMethodBeat.i(109202);
    synchronized ((Iterable)this.swU.values())
    {
      Iterator localIterator = ???.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).cancel();
      }
    }
    y localy = y.BMg;
    this.swU.clear();
    AppMethodBeat.o(109202);
  }
  
  public final void cancelCache(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(109201);
    if (paramAudioCacheInfo != null)
    {
      paramAudioCacheInfo = (b)this.swU.remove(Integer.valueOf(paramAudioCacheInfo.swp));
      if (paramAudioCacheInfo != null)
      {
        paramAudioCacheInfo.cancel();
        AppMethodBeat.o(109201);
        return;
      }
    }
    AppMethodBeat.o(109201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.i
 * JD-Core Version:    0.7.0.1
 */