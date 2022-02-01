package com.tencent.mm.plugin.vlog.ui.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.k;
import com.tencent.mm.plugin.recordvideo.model.audio.k.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "", "()V", "downloadManager", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "loadMusic", "", "path", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "packageAudioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "Companion", "plugin-vlog_release"})
public final class b
{
  private static String NtX;
  public static final a NtY;
  private k NtW;
  
  static
  {
    AppMethodBeat.i(111154);
    NtY = new a((byte)0);
    StringBuilder localStringBuilder = new StringBuilder();
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    NtX = localf.getAccPath() + "vlog/coming/";
    AppMethodBeat.o(111154);
  }
  
  public b()
  {
    AppMethodBeat.i(111153);
    k.a locala = k.HMx;
    this.NtW = k.fwB();
    AppMethodBeat.o(111153);
  }
  
  private static AudioCacheInfo bfI(String paramString)
  {
    AppMethodBeat.i(111152);
    AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
    localAudioCacheInfo.musicUrl = paramString;
    localAudioCacheInfo.HLC = paramString.hashCode();
    localAudioCacheInfo.cachePath = (NtX + paramString.hashCode() + '_' + cm.bfD() + ".a");
    AppMethodBeat.o(111152);
    return localAudioCacheInfo;
  }
  
  public final void c(String paramString, m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(111151);
    p.k(paramString, "path");
    p.k(paramm, "callback");
    this.NtW.a(bfI(paramString), paramm);
    AppMethodBeat.o(111151);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager$Companion;", "", "()V", "AAC_PATH", "", "getAAC_PATH", "()Ljava/lang/String;", "setAAC_PATH", "(Ljava/lang/String;)V", "getAudioCachePath", "path", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.b
 * JD-Core Version:    0.7.0.1
 */