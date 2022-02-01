package com.tencent.mm.plugin.vlog.ui.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.player.d;
import com.tencent.mm.protocal.protobuf.are;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogPreloadManager;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "vLogComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getVLogComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVLogComposition", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "getVLogDataManager", "()Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "getVLogDirector", "()Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "setVLogDirector", "(Lcom/tencent/mm/plugin/vlog/player/VLogDirector;)V", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "getVLogSurface", "()Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "setVLogSurface", "(Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;)V", "clear", "", "loadPlayScript", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "setMaterial", "videoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imageList", "index", "", "setPreviewSize", "width", "", "height", "plugin-vlog_release"})
public final class c
{
  private static d ArL;
  private static com.tencent.mm.plugin.vlog.player.h ArM;
  private static r AsG;
  public static final c AsH;
  private static final v Asj;
  private static final String TAG = "VLogPreloadManager";
  
  static
  {
    AppMethodBeat.i(111160);
    AsH = new c();
    TAG = "VLogPreloadManager";
    Asj = new v();
    AppMethodBeat.o(111160);
  }
  
  public static void E(b<? super are, y> paramb)
  {
    AppMethodBeat.i(111158);
    v.a(Asj, (b)new c.a(paramb));
    AppMethodBeat.o(111158);
  }
  
  public static v ega()
  {
    return Asj;
  }
  
  public static com.tencent.mm.plugin.vlog.player.h egb()
  {
    return ArM;
  }
  
  public static d egc()
  {
    return ArL;
  }
  
  public static r egd()
  {
    return AsG;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void setPreviewSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111157);
    com.tencent.d.f.h.fCP();
    Asj.setPreviewSize(paramInt1, paramInt2);
    AppMethodBeat.o(111157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.c
 * JD-Core Version:    0.7.0.1
 */