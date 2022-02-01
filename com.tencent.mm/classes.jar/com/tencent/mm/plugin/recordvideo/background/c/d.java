package com.tencent.mm.plugin.recordvideo.background.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixFactory;", "", "()V", "PHOTO2VIDEO_MIXER", "", "TAG", "", "VIDEO_MIXER", "VLOG_MIXER", "mixerManagerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "Lkotlin/collections/HashMap;", "getMixer", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "register", "", "key", "instanceManager", "plugin-recordvideo_release"})
public final class d
{
  private static final HashMap<Integer, a> xwm;
  public static final d xwn;
  
  static
  {
    AppMethodBeat.i(75324);
    xwn = new d();
    xwm = new HashMap();
    AppMethodBeat.o(75324);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(75322);
    p.h(parama, "instanceManager");
    ((Map)xwm).put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(75322);
  }
  
  public static c b(com.tencent.mm.plugin.recordvideo.background.c paramc, aif paramaif)
  {
    AppMethodBeat.i(75323);
    p.h(paramc, "editorData");
    p.h(paramaif, "extraConfig");
    a locala = (a)xwm.get(Integer.valueOf(paramaif.GfJ));
    ad.i("MicroMsg.VideoMixFactory", "getMixer extraConfig.mixerType:" + paramaif.GfJ + " mixInstanceManager:" + locala);
    if (locala != null)
    {
      paramc = locala.a(paramc, paramaif);
      AppMethodBeat.o(75323);
      return paramc;
    }
    AppMethodBeat.o(75323);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.d
 * JD-Core Version:    0.7.0.1
 */