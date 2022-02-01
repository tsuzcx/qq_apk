package com.tencent.mm.plugin.recordvideo.background.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixFactory;", "", "()V", "PHOTO2VIDEO_MIXER", "", "TAG", "", "VIDEO_MIXER", "VLOG_MIXER", "mixerManagerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "Lkotlin/collections/HashMap;", "getMixer", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "register", "", "key", "instanceManager", "plugin-recordvideo_release"})
public final class d
{
  private static final HashMap<Integer, a> BMp;
  public static final d BMq;
  
  static
  {
    AppMethodBeat.i(75324);
    BMq = new d();
    BMp = new HashMap();
    AppMethodBeat.o(75324);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(75322);
    p.h(parama, "instanceManager");
    ((Map)BMp).put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(75322);
  }
  
  public static c b(com.tencent.mm.plugin.recordvideo.background.c paramc, ald paramald)
  {
    AppMethodBeat.i(75323);
    p.h(paramc, "editorData");
    p.h(paramald, "extraConfig");
    a locala = (a)BMp.get(Integer.valueOf(paramald.Luf));
    Log.i("MicroMsg.VideoMixFactory", "getMixer extraConfig.mixerType:" + paramald.Luf + " mixInstanceManager:" + locala);
    if (locala != null)
    {
      paramc = locala.a(paramc, paramald);
      AppMethodBeat.o(75323);
      return paramc;
    }
    AppMethodBeat.o(75323);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.d
 * JD-Core Version:    0.7.0.1
 */