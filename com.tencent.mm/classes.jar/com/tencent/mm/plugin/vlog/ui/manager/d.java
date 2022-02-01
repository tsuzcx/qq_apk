package com.tencent.mm.plugin.vlog.ui.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.plugin.vlog.player.i;
import com.tencent.mm.protocal.protobuf.aoa;
import d.g.a.b;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogPreloadManager;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "vLogComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getVLogComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVLogComposition", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "getVLogDataManager", "()Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "getVLogDirector", "()Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "setVLogDirector", "(Lcom/tencent/mm/plugin/vlog/player/VLogDirector;)V", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "getVLogSurface", "()Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "setVLogSurface", "(Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;)V", "clear", "", "loadPlayScript", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "setMaterial", "videoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imageList", "index", "", "setPreviewSize", "width", "", "height", "plugin-vlog_release"})
public final class d
{
  private static com.tencent.mm.plugin.vlog.player.h Lti;
  private static i Ltj;
  private static final z Ltl;
  private static v Ltq;
  private static final String TAG = "VLogPreloadManager";
  public static final d zcE;
  
  static
  {
    AppMethodBeat.i(111160);
    zcE = new d();
    TAG = "VLogPreloadManager";
    Ltl = new z();
    AppMethodBeat.o(111160);
  }
  
  public static z fZa()
  {
    return Ltl;
  }
  
  public static i fZb()
  {
    return Ltj;
  }
  
  public static com.tencent.mm.plugin.vlog.player.h fZc()
  {
    return Lti;
  }
  
  public static v fZd()
  {
    return Ltq;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void setPreviewSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111157);
    com.tencent.d.f.h.fmz();
    Ltl.setPreviewSize(paramInt1, paramInt2);
    AppMethodBeat.o(111157);
  }
  
  public static void w(b<? super aoa, y> paramb)
  {
    AppMethodBeat.i(111158);
    z.a(Ltl, (b)new a(paramb));
    AppMethodBeat.o(111158);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<aoa, y>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.d
 * JD-Core Version:    0.7.0.1
 */