package com.tencent.mm.plugin.recordvideo.background.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixFactory;", "", "()V", "PHOTO2VIDEO_MIXER", "", "TAG", "", "VIDEO_MIXER", "VLOG_MIXER", "mixerManagerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "Lkotlin/collections/HashMap;", "getMixer", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "register", "", "key", "instanceManager", "plugin-recordvideo_release"})
public final class d
{
  private static final HashMap<Integer, a> vfK;
  public static final d vfL;
  
  static
  {
    AppMethodBeat.i(75324);
    vfL = new d();
    vfK = new HashMap();
    AppMethodBeat.o(75324);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(75322);
    k.h(parama, "instanceManager");
    ((Map)vfK).put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(75322);
  }
  
  public static c b(com.tencent.mm.plugin.recordvideo.background.d paramd, aer paramaer)
  {
    AppMethodBeat.i(75323);
    k.h(paramd, "editorData");
    k.h(paramaer, "extraConfig");
    a locala = (a)vfK.get(Integer.valueOf(paramaer.DeW));
    ad.i("MicroMsg.VideoMixFactory", "getMixer extraConfig.mixerType:" + paramaer.DeW + " mixInstanceManager:" + locala);
    if (locala != null)
    {
      paramd = locala.a(paramd, paramaer);
      AppMethodBeat.o(75323);
      return paramd;
    }
    AppMethodBeat.o(75323);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.d
 * JD-Core Version:    0.7.0.1
 */