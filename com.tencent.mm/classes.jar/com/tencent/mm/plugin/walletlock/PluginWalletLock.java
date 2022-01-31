package com.tencent.mm.plugin.walletlock;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

public class PluginWalletLock
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.walletlock.a.a
{
  private com.tencent.mm.plugin.walletlock.c.f qPb = null;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      y.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
      com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.walletlock.c.e()));
      u.a(1, new PluginWalletLock.a(this, (byte)0));
    }
  }
  
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.soter.a.a.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.walletlock.a.a.class);
  }
  
  public String name()
  {
    return "plugin-wallet-lock";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    y.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
    this.qPb = new com.tencent.mm.plugin.walletlock.c.f();
    paramc = this.qPb;
    if (!com.tencent.mm.sdk.b.a.udP.e(paramc.qQU)) {
      com.tencent.mm.sdk.b.a.udP.c(paramc.qQU);
    }
    if (!com.tencent.mm.sdk.b.a.udP.e(paramc.qQV)) {
      com.tencent.mm.sdk.b.a.udP.c(paramc.qQV);
    }
    if (!com.tencent.mm.sdk.b.a.udP.e(paramc.qQX)) {
      com.tencent.mm.sdk.b.a.udP.c(paramc.qQX);
    }
    try
    {
      paramc = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("PatternLockTimeInterval");
      if (!bk.bl(paramc))
      {
        int i = bk.getInt(paramc, 0);
        if (i >= 0)
        {
          y.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[] { Integer.valueOf(i) }));
          com.tencent.mm.plugin.walletlock.gesture.a.a.qPz = i;
          ((b)com.tencent.mm.kernel.g.r(b.class)).init();
          return;
        }
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WalletLockInitTask", paramc, "", new Object[0]);
        paramc = null;
        continue;
        y.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
        com.tencent.mm.plugin.walletlock.gesture.a.a.qPz = 300;
        continue;
        y.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
        com.tencent.mm.plugin.walletlock.gesture.a.a.qPz = 300;
      }
    }
  }
  
  public void onAccountRelease()
  {
    y.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
    if (this.qPb != null)
    {
      Object localObject = this.qPb;
      if (com.tencent.mm.sdk.b.a.udP.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).qQU)) {
        com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).qQU);
      }
      if (com.tencent.mm.sdk.b.a.udP.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).qQV)) {
        com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).qQV);
      }
      if (com.tencent.mm.sdk.b.a.udP.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).qQX)) {
        com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).qQX);
      }
      localObject = i.qRd;
      if (((i)localObject).qRh != null) {
        ((i)localObject).qRh.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock
 * JD-Core Version:    0.7.0.1
 */