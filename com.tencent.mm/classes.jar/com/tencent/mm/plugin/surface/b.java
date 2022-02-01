package com.tencent.mm.plugin.surface;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.surface.core.e;
import com.tencent.mm.plugin.surface.core.g;
import com.tencent.mm.plugin.surface.core.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/SurfaceManager;", "", "()V", "service", "Lcom/tencent/mm/plugin/surface/core/SurfaceService;", "getService", "()Lcom/tencent/mm/plugin/surface/core/SurfaceService;", "service$delegate", "Lkotlin/Lazy;", "cleanup", "", "dispatch", "appId", "", "event", "data", "dispatch$plugin_surface_app_release", "onDataChanged", "root", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "onDataChanged$plugin_surface_app_release", "register", "config", "Lcom/tencent/mm/plugin/surface/core/SurfaceConfig;", "repaint", "width", "", "height", "repaint$plugin_surface_app_release", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b SJM;
  private static final kotlin.j xIN;
  
  static
  {
    AppMethodBeat.i(265004);
    SJM = new b();
    xIN = k.cm((a)a.SJN);
    AppMethodBeat.o(265004);
  }
  
  public static void a(String paramString, g paramg)
  {
    AppMethodBeat.i(264997);
    s.u(paramString, "appId");
    s.u(paramg, "config");
    com.tencent.mm.plugin.surface.core.j localj = hBD();
    s.u(paramString, "appId");
    s.u(paramg, "config");
    if (localj.lZR.containsKey(paramString)) {
      Log.e("MicroMsg.SurfaceApp.SurfaceService", "jsapis for " + paramString + " is registered");
    }
    for (;;)
    {
      paramg = i.SKz;
      i.check();
      e.SKg.bcU(paramString);
      AppMethodBeat.o(264997);
      return;
      ((Map)localj.lZR).put(paramString, paramg);
    }
  }
  
  public static com.tencent.mm.plugin.surface.core.j hBD()
  {
    AppMethodBeat.i(264993);
    com.tencent.mm.plugin.surface.core.j localj = (com.tencent.mm.plugin.surface.core.j)xIN.getValue();
    AppMethodBeat.o(264993);
    return localj;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/surface/core/SurfaceService;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<com.tencent.mm.plugin.surface.core.j>
  {
    public static final a SJN;
    
    static
    {
      AppMethodBeat.i(264994);
      SJN = new a();
      AppMethodBeat.o(264994);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b
 * JD-Core Version:    0.7.0.1
 */