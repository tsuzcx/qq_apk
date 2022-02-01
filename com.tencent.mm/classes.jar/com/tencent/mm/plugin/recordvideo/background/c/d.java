package com.tencent.mm.plugin.recordvideo.background.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixFactory;", "", "()V", "PHOTO2VIDEO_MIXER", "", "TAG", "", "VIDEO_MIXER", "VLOG_MIXER", "mixerManagerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "Lkotlin/collections/HashMap;", "getMixer", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "register", "", "key", "instanceManager", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d NFT;
  private static final HashMap<Integer, a> NFU;
  
  static
  {
    AppMethodBeat.i(75324);
    NFT = new d();
    NFU = new HashMap();
    AppMethodBeat.o(75324);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(75322);
    s.u(parama, "instanceManager");
    ((Map)NFU).put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(75322);
  }
  
  public static c b(com.tencent.mm.plugin.recordvideo.background.c paramc, apw paramapw)
  {
    AppMethodBeat.i(75323);
    s.u(paramc, "editorData");
    s.u(paramapw, "extraConfig");
    a locala = (a)NFU.get(Integer.valueOf(paramapw.Zxm));
    Log.i("MicroMsg.VideoMixFactory", "getMixer extraConfig.mixerType:" + paramapw.Zxm + " mixInstanceManager:" + locala);
    if (locala != null)
    {
      paramc = locala.a(paramc, paramapw);
      AppMethodBeat.o(75323);
      return paramc;
    }
    AppMethodBeat.o(75323);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.d
 * JD-Core Version:    0.7.0.1
 */