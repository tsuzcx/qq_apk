package com.tencent.mm.plugin.vlog.ui.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "", "()V", "downloadManager", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "loadMusic", "", "path", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "packageAudioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "Companion", "plugin-vlog_release"})
public final class b
{
  private static String GGg;
  public static final a GGh;
  private i GGf;
  
  static
  {
    AppMethodBeat.i(111154);
    GGh = new a((byte)0);
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    GGg = locale.getAccPath() + "vlog/coming/";
    AppMethodBeat.o(111154);
  }
  
  public b()
  {
    AppMethodBeat.i(111153);
    i.a locala = i.BPL;
    this.GGf = i.eKl();
    AppMethodBeat.o(111153);
  }
  
  private static AudioCacheInfo aUj(String paramString)
  {
    AppMethodBeat.i(111152);
    AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
    localAudioCacheInfo.musicUrl = paramString;
    localAudioCacheInfo.BOX = paramString.hashCode();
    localAudioCacheInfo.cachePath = (GGg + paramString.hashCode() + '_' + cl.aWz() + ".a");
    AppMethodBeat.o(111152);
    return localAudioCacheInfo;
  }
  
  public final void d(String paramString, m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(111151);
    p.h(paramString, "path");
    p.h(paramm, "callback");
    this.GGf.a(aUj(paramString), paramm);
    AppMethodBeat.o(111151);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager$Companion;", "", "()V", "AAC_PATH", "", "getAAC_PATH", "()Ljava/lang/String;", "setAAC_PATH", "(Ljava/lang/String;)V", "getAudioCachePath", "path", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.b
 * JD-Core Version:    0.7.0.1
 */