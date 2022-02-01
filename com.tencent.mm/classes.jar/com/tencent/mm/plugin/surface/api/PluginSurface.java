package com.tencent.mm.plugin.surface.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.surface.a.b.a;
import com.tencent.mm.plugin.surface.core.e;
import com.tencent.mm.pluginsdk.cmd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/api/PluginSurface;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "installed", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginSurface
  extends f
  implements c
{
  public final void configure(g paramg)
  {
    AppMethodBeat.i(265162);
    s.u(paramg, "profile");
    AppMethodBeat.o(265162);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(265170);
    s.u(paramg, "profile");
    b.a locala = com.tencent.mm.plugin.surface.a.b.SKI;
    com.tencent.mm.pluginsdk.cmd.b.a((a)new com.tencent.mm.plugin.surface.a.b(), new String[] { "//surface" });
    if (paramg.bbA())
    {
      paramg = e.SKg;
      e.hBK();
    }
    AppMethodBeat.o(265170);
  }
  
  public final void installed() {}
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(265181);
    s.u(paramc, "upgrade");
    paramc = e.SKg;
    e.init();
    AppMethodBeat.o(265181);
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.api.PluginSurface
 * JD-Core Version:    0.7.0.1
 */