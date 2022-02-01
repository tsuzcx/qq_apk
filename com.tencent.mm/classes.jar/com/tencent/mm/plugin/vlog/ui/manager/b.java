package com.tencent.mm.plugin.vlog.ui.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "", "()V", "downloadManager", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "loadMusic", "", "path", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "packageAudioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "Companion", "plugin-vlog_release"})
public final class b
{
  private static String AsE;
  public static final a AsF;
  private i AsD;
  
  static
  {
    AppMethodBeat.i(111154);
    AsF = new a((byte)0);
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    AsE = locale.getAccPath() + "vlog/coming/";
    AppMethodBeat.o(111154);
  }
  
  public b()
  {
    AppMethodBeat.i(111153);
    i.a locala = i.wrV;
    this.AsD = i.dvK();
    AppMethodBeat.o(111153);
  }
  
  private static AudioCacheInfo ayo(String paramString)
  {
    AppMethodBeat.i(111152);
    AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
    localAudioCacheInfo.musicUrl = paramString;
    localAudioCacheInfo.wri = paramString.hashCode();
    localAudioCacheInfo.cachePath = (AsE + paramString.hashCode() + '_' + ce.azI() + ".a");
    AppMethodBeat.o(111152);
    return localAudioCacheInfo;
  }
  
  public final void b(String paramString, m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(111151);
    k.h(paramString, "path");
    k.h(paramm, "callback");
    this.AsD.a(ayo(paramString), paramm);
    AppMethodBeat.o(111151);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager$Companion;", "", "()V", "AAC_PATH", "", "getAAC_PATH", "()Ljava/lang/String;", "setAAC_PATH", "(Ljava/lang/String;)V", "getAudioCachePath", "path", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.b
 * JD-Core Version:    0.7.0.1
 */