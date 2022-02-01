package com.tencent.mm.plugin.vlog.ui.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.plugin.vlog.player.g;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogPreloadManager;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "vLogComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getVLogComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVLogComposition", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "getVLogDataManager", "()Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "getVLogDirector", "()Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "setVLogDirector", "(Lcom/tencent/mm/plugin/vlog/player/VLogDirector;)V", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "getVLogSurface", "()Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "setVLogSurface", "(Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;)V", "clear", "", "loadPlayScript", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "setMaterial", "videoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imageList", "index", "", "setPreviewSize", "width", "", "height", "plugin-vlog_release"})
public final class c
{
  private static com.tencent.mm.plugin.vlog.player.c Cbb;
  private static g Cbc;
  public static final c CdS;
  private static final x Cdv;
  private static final String TAG = "VLogPreloadManager";
  
  static
  {
    AppMethodBeat.i(111160);
    CdS = new c();
    TAG = "VLogPreloadManager";
    Cdv = new x();
    AppMethodBeat.o(111160);
  }
  
  public static x ewG()
  {
    return Cdv;
  }
  
  public static g ewH()
  {
    return Cbc;
  }
  
  public static com.tencent.mm.plugin.vlog.player.c ewI()
  {
    return Cbb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.c
 * JD-Core Version:    0.7.0.1
 */