package com.tencent.mm.plugin.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginSoter
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.soter.a.a
{
  private static com.tencent.mm.plugin.soter.d.c snD;
  private static com.tencent.mm.plugin.soter.d.b snE;
  private com.tencent.mm.vending.b.b gTl;
  private com.tencent.mm.plugin.soter.d.f snB = null;
  private boolean snC = false;
  
  static
  {
    AppMethodBeat.i(59296);
    snD = new com.tencent.mm.plugin.soter.d.c();
    snE = new com.tencent.mm.plugin.soter.d.b();
    AppMethodBeat.o(59296);
  }
  
  private void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(59292);
    if (paramc == null)
    {
      ab.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
      AppMethodBeat.o(59292);
      return;
    }
    if (com.tencent.mm.sdk.b.a.ymk.e(paramc))
    {
      ab.w("MicroMsg.PluginSoter", "hy: already has listener");
      AppMethodBeat.o(59292);
      return;
    }
    com.tencent.mm.sdk.b.a.ymk.c(paramc);
    AppMethodBeat.o(59292);
  }
  
  private void safeRemoveListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(59293);
    if (paramc == null)
    {
      ab.w("MicroMsg.PluginSoter", "alvinluo listener is null");
      AppMethodBeat.o(59293);
      return;
    }
    com.tencent.mm.sdk.b.a.ymk.d(paramc);
    AppMethodBeat.o(59293);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(59290);
    if (paramg.SD())
    {
      ab.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[] { paramg.mProcessName });
      this.snC = true;
      ab.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
      this.snB = new com.tencent.mm.plugin.soter.d.f();
      safeAddListener(this.snB);
    }
    AppMethodBeat.o(59290);
  }
  
  public String name()
  {
    return "plugin-soter";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(59294);
    ab.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[] { Boolean.valueOf(this.snC) });
    if (this.snC)
    {
      m.cyd();
      d.ysm.r(new PluginSoter.1(this), 1500L);
      this.gTl = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new PluginSoter.2(this));
    }
    if (!com.tencent.mm.sdk.b.a.ymk.e(snD)) {
      com.tencent.mm.sdk.b.a.ymk.c(snD);
    }
    if (!com.tencent.mm.sdk.b.a.ymk.e(snE)) {
      com.tencent.mm.sdk.b.a.ymk.c(snE);
    }
    AppMethodBeat.o(59294);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(59295);
    ab.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    if (this.snC) {
      this.gTl.dead();
    }
    AppMethodBeat.o(59295);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(59291);
    super.uninstalled();
    safeRemoveListener(this.snB);
    AppMethodBeat.o(59291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter
 * JD-Core Version:    0.7.0.1
 */