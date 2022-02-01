package com.tencent.mm.plugin.vlog.ui.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "", "()V", "downloadManager", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "loadMusic", "", "path", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "packageAudioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "Companion", "plugin-vlog_release"})
public final class b
{
  private static String CdQ;
  public static final a CdR;
  private i CdP;
  
  static
  {
    AppMethodBeat.i(111154);
    CdR = new a((byte)0);
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    CdQ = locale.getAccPath() + "vlog/coming/";
    AppMethodBeat.o(111154);
  }
  
  public b()
  {
    AppMethodBeat.i(111153);
    i.a locala = i.xPI;
    this.CdP = i.dJz();
    AppMethodBeat.o(111153);
  }
  
  private static AudioCacheInfo aEN(String paramString)
  {
    AppMethodBeat.i(111152);
    AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
    localAudioCacheInfo.musicUrl = paramString;
    localAudioCacheInfo.xOV = paramString.hashCode();
    localAudioCacheInfo.cachePath = (CdQ + paramString.hashCode() + '_' + ch.aDb() + ".a");
    AppMethodBeat.o(111152);
    return localAudioCacheInfo;
  }
  
  public final void b(String paramString, m<? super Boolean, ? super String, z> paramm)
  {
    AppMethodBeat.i(111151);
    p.h(paramString, "path");
    p.h(paramm, "callback");
    this.CdP.a(aEN(paramString), paramm);
    AppMethodBeat.o(111151);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager$Companion;", "", "()V", "AAC_PATH", "", "getAAC_PATH", "()Ljava/lang/String;", "setAAC_PATH", "(Ljava/lang/String;)V", "getAudioCachePath", "path", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.b
 * JD-Core Version:    0.7.0.1
 */