package com.tencent.mm.plugin.soter;

import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.y;

public class PluginSoter
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.soter.a.a
{
  private static com.tencent.mm.plugin.soter.d.c prE = new com.tencent.mm.plugin.soter.d.c();
  private static com.tencent.mm.plugin.soter.d.b prF = new com.tencent.mm.plugin.soter.d.b();
  private com.tencent.mm.plugin.soter.d.f prC = null;
  private boolean prD = false;
  
  private void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    if (paramc == null)
    {
      y.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
      return;
    }
    if (com.tencent.mm.sdk.b.a.udP.e(paramc))
    {
      y.w("MicroMsg.PluginSoter", "hy: already has listener");
      return;
    }
    com.tencent.mm.sdk.b.a.udP.c(paramc);
  }
  
  private void safeRemoveListener(com.tencent.mm.sdk.b.c paramc)
  {
    if (paramc == null)
    {
      y.w("MicroMsg.PluginSoter", "alvinluo listener is null");
      return;
    }
    com.tencent.mm.sdk.b.a.udP.d(paramc);
  }
  
  public void execute(g paramg)
  {
    if (paramg.Ex())
    {
      y.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[] { paramg.dIA });
      this.prD = true;
      y.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
      this.prC = new com.tencent.mm.plugin.soter.d.f();
      safeAddListener(this.prC);
    }
  }
  
  public String name()
  {
    return "plugin-soter";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    y.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[] { Boolean.valueOf(this.prD) });
    if (this.prD)
    {
      m.bKS();
      com.tencent.mm.plugin.soter.e.b.a(false, false, null);
    }
    if (!com.tencent.mm.sdk.b.a.udP.e(prE)) {
      com.tencent.mm.sdk.b.a.udP.c(prE);
    }
    if (!com.tencent.mm.sdk.b.a.udP.e(prF)) {
      com.tencent.mm.sdk.b.a.udP.c(prF);
    }
  }
  
  public void onAccountRelease()
  {
    y.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
  }
  
  public void uninstalled()
  {
    super.uninstalled();
    safeRemoveListener(this.prC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter
 * JD-Core Version:    0.7.0.1
 */