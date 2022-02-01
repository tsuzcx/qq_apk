package com.tencent.mm.plugin.recordvideo.background.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixFactory;", "", "()V", "PHOTO2VIDEO_MIXER", "", "TAG", "", "VIDEO_MIXER", "VLOG_MIXER", "mixerManagerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "Lkotlin/collections/HashMap;", "getMixer", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "register", "", "key", "instanceManager", "plugin-recordvideo_release"})
public final class d
{
  private static final HashMap<Integer, a> xMj;
  public static final d xMk;
  
  static
  {
    AppMethodBeat.i(75324);
    xMk = new d();
    xMj = new HashMap();
    AppMethodBeat.o(75324);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(75322);
    p.h(parama, "instanceManager");
    ((Map)xMj).put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(75322);
  }
  
  public static c b(com.tencent.mm.plugin.recordvideo.background.c paramc, aip paramaip)
  {
    AppMethodBeat.i(75323);
    p.h(paramc, "editorData");
    p.h(paramaip, "extraConfig");
    a locala = (a)xMj.get(Integer.valueOf(paramaip.Gyr));
    ae.i("MicroMsg.VideoMixFactory", "getMixer extraConfig.mixerType:" + paramaip.Gyr + " mixInstanceManager:" + locala);
    if (locala != null)
    {
      paramc = locala.a(paramc, paramaip);
      AppMethodBeat.o(75323);
      return paramc;
    }
    AppMethodBeat.o(75323);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.d
 * JD-Core Version:    0.7.0.1
 */