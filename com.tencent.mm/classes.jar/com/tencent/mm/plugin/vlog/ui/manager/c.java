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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "", "()V", "downloadManager", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "loadMusic", "", "path", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "packageAudioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "Companion", "plugin-vlog_release"})
public final class c
{
  private static String zcC;
  public static final a zcD;
  private i zcB;
  
  static
  {
    AppMethodBeat.i(111154);
    zcD = new a((byte)0);
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    zcC = locale.getAccPath() + "vlog/coming/";
    AppMethodBeat.o(111154);
  }
  
  public c()
  {
    AppMethodBeat.i(111153);
    i.a locala = i.vjj;
    this.zcB = i.dhZ();
    AppMethodBeat.o(111153);
  }
  
  private static AudioCacheInfo asY(String paramString)
  {
    AppMethodBeat.i(111152);
    AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
    localAudioCacheInfo.musicUrl = paramString;
    localAudioCacheInfo.viz = paramString.hashCode();
    localAudioCacheInfo.cachePath = (zcC + paramString.hashCode() + '_' + ce.asR() + ".a");
    AppMethodBeat.o(111152);
    return localAudioCacheInfo;
  }
  
  public final void b(String paramString, m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(111151);
    k.h(paramString, "path");
    k.h(paramm, "callback");
    this.zcB.a(asY(paramString), paramm);
    AppMethodBeat.o(111151);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager$Companion;", "", "()V", "AAC_PATH", "", "getAAC_PATH", "()Ljava/lang/String;", "setAAC_PATH", "(Ljava/lang/String;)V", "getAudioCachePath", "path", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.c
 * JD-Core Version:    0.7.0.1
 */