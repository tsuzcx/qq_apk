package com.tencent.mm.plugin.vlog.ui.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.k;
import com.tencent.mm.plugin.recordvideo.model.audio.k.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "", "()V", "downloadManager", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "loadMusic", "", "path", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "packageAudioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "release", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a Uhn;
  private static String Uhp;
  private k Uho;
  
  static
  {
    AppMethodBeat.i(111154);
    Uhn = new a((byte)0);
    Uhp = s.X(h.baE().mCJ, "vlog/coming/");
    AppMethodBeat.o(111154);
  }
  
  public b()
  {
    AppMethodBeat.i(111153);
    k.a locala = k.NJr;
    this.Uho = k.gIk();
    AppMethodBeat.o(111153);
  }
  
  private static AudioCacheInfo bfo(String paramString)
  {
    AppMethodBeat.i(111152);
    AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
    localAudioCacheInfo.musicUrl = paramString;
    localAudioCacheInfo.NID = paramString.hashCode();
    localAudioCacheInfo.cachePath = (Uhp + paramString.hashCode() + '_' + cn.bDv() + ".a");
    AppMethodBeat.o(111152);
    return localAudioCacheInfo;
  }
  
  public final void g(String paramString, m<? super Boolean, ? super String, ah> paramm)
  {
    AppMethodBeat.i(111151);
    s.u(paramString, "path");
    s.u(paramm, "callback");
    this.Uho.a(bfo(paramString), paramm);
    AppMethodBeat.o(111151);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager$Companion;", "", "()V", "AAC_PATH", "", "getAAC_PATH", "()Ljava/lang/String;", "setAAC_PATH", "(Ljava/lang/String;)V", "getAudioCachePath", "path", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.b
 * JD-Core Version:    0.7.0.1
 */