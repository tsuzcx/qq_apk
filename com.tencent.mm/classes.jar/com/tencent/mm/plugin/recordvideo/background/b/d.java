package com.tencent.mm.plugin.recordvideo.background.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixFactory;", "", "()V", "PHOTO2VIDEO_MIXER", "", "TAG", "", "VIDEO_MIXER", "VLOG_MIXER", "mixerManagerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "Lkotlin/collections/HashMap;", "getMixer", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "register", "", "key", "instanceManager", "plugin-recordvideo_release"})
public final class d
{
  private static final HashMap<Integer, a> wow;
  public static final d wox;
  
  static
  {
    AppMethodBeat.i(75324);
    wox = new d();
    wow = new HashMap();
    AppMethodBeat.o(75324);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(75322);
    k.h(parama, "instanceManager");
    ((Map)wow).put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(75322);
  }
  
  public static c b(e parame, afq paramafq)
  {
    AppMethodBeat.i(75323);
    k.h(parame, "editorData");
    k.h(paramafq, "extraConfig");
    a locala = (a)wow.get(Integer.valueOf(paramafq.Eyc));
    ac.i("MicroMsg.VideoMixFactory", "getMixer extraConfig.mixerType:" + paramafq.Eyc + " mixInstanceManager:" + locala);
    if (locala != null)
    {
      parame = locala.a(parame, paramafq);
      AppMethodBeat.o(75323);
      return parame;
    }
    AppMethodBeat.o(75323);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.d
 * JD-Core Version:    0.7.0.1
 */