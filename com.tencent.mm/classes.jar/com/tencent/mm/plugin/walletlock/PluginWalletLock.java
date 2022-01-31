package com.tencent.mm.plugin.walletlock;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;

public class PluginWalletLock
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.walletlock.a.a
{
  private com.tencent.mm.plugin.walletlock.c.f uEi = null;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(51442);
    if (paramg.SD())
    {
      ab.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
      com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.walletlock.c.e()));
      v.a(1, new PluginWalletLock.a(this, (byte)0));
    }
    AppMethodBeat.o(51442);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(51441);
    dependsOn(com.tencent.mm.plugin.soter.a.a.class);
    AppMethodBeat.o(51441);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(51440);
    alias(com.tencent.mm.plugin.walletlock.a.a.class);
    AppMethodBeat.o(51440);
  }
  
  public String name()
  {
    return "plugin-wallet-lock";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(51443);
    ab.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
    this.uEi = new com.tencent.mm.plugin.walletlock.c.f();
    paramc = this.uEi;
    if (!com.tencent.mm.sdk.b.a.ymk.e(paramc.uGc)) {
      com.tencent.mm.sdk.b.a.ymk.c(paramc.uGc);
    }
    if (!com.tencent.mm.sdk.b.a.ymk.e(paramc.uGd)) {
      com.tencent.mm.sdk.b.a.ymk.c(paramc.uGd);
    }
    if (!com.tencent.mm.sdk.b.a.ymk.e(paramc.uGf)) {
      com.tencent.mm.sdk.b.a.ymk.c(paramc.uGf);
    }
    try
    {
      paramc = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("PatternLockTimeInterval");
      if (!bo.isNullOrNil(paramc))
      {
        int i = bo.getInt(paramc, 0);
        if (i >= 0)
        {
          ab.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[] { Integer.valueOf(i) }));
          com.tencent.mm.plugin.walletlock.gesture.a.a.uEH = i;
          ((b)com.tencent.mm.kernel.g.E(b.class)).init();
          AppMethodBeat.o(51443);
          return;
        }
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletLockInitTask", paramc, "", new Object[0]);
        paramc = null;
        continue;
        ab.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
        com.tencent.mm.plugin.walletlock.gesture.a.a.uEH = 300;
        continue;
        ab.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
        com.tencent.mm.plugin.walletlock.gesture.a.a.uEH = 300;
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(51444);
    ab.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
    if (this.uEi != null)
    {
      Object localObject = this.uEi;
      if (com.tencent.mm.sdk.b.a.ymk.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).uGc)) {
        com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).uGc);
      }
      if (com.tencent.mm.sdk.b.a.ymk.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).uGd)) {
        com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).uGd);
      }
      if (com.tencent.mm.sdk.b.a.ymk.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).uGf)) {
        com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).uGf);
      }
      localObject = i.uGl;
      if (((i)localObject).uGp != null) {
        ((i)localObject).uGp.clear();
      }
    }
    AppMethodBeat.o(51444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock
 * JD-Core Version:    0.7.0.1
 */