package com.tencent.mm.plugin.walletlock;

import android.app.Activity;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.LinkedList;

public class PluginWalletLock
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.walletlock.a.a
{
  private com.tencent.mm.plugin.walletlock.c.f BTI;
  private final LinkedList<Activity> BTJ;
  private com.tencent.mm.sdk.b.c<nm> BTK;
  
  public PluginWalletLock()
  {
    AppMethodBeat.i(129643);
    this.BTI = null;
    this.BTJ = new LinkedList();
    this.BTK = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(129643);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(129646);
    if (paramg.ahL())
    {
      ac.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
      com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.walletlock.c.e()));
      y.a(1, new a((byte)0));
      this.BTK.alive();
    }
    AppMethodBeat.o(129646);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(129645);
    dependsOn(com.tencent.mm.plugin.soter.a.a.class);
    AppMethodBeat.o(129645);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(204928);
    if (paramg.ahL()) {
      paramg.ca.registerActivityLifecycleCallbacks(new PluginWalletLock.2(this));
    }
    AppMethodBeat.o(204928);
  }
  
  public void installed()
  {
    AppMethodBeat.i(129644);
    alias(com.tencent.mm.plugin.walletlock.a.a.class);
    AppMethodBeat.o(129644);
  }
  
  public String name()
  {
    return "plugin-wallet-lock";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(129648);
    ac.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
    this.BTI = new com.tencent.mm.plugin.walletlock.c.f();
    paramc = this.BTI;
    if (!com.tencent.mm.sdk.b.a.GpY.e(paramc.BVB)) {
      com.tencent.mm.sdk.b.a.GpY.c(paramc.BVB);
    }
    if (!com.tencent.mm.sdk.b.a.GpY.e(paramc.BVC)) {
      com.tencent.mm.sdk.b.a.GpY.c(paramc.BVC);
    }
    if (!com.tencent.mm.sdk.b.a.GpY.e(paramc.BVE)) {
      com.tencent.mm.sdk.b.a.GpY.c(paramc.BVE);
    }
    try
    {
      paramc = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("PatternLockTimeInterval");
      if (!bs.isNullOrNil(paramc))
      {
        int i = bs.getInt(paramc, 0);
        if (i >= 0)
        {
          ac.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[] { Integer.valueOf(i) }));
          com.tencent.mm.plugin.walletlock.gesture.a.a.BUi = i;
          AppMethodBeat.o(129648);
          return;
        }
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WalletLockInitTask", paramc, "", new Object[0]);
        paramc = null;
      }
      ac.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
      com.tencent.mm.plugin.walletlock.gesture.a.a.BUi = 300;
      AppMethodBeat.o(129648);
      return;
    }
    ac.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
    com.tencent.mm.plugin.walletlock.gesture.a.a.BUi = 300;
    AppMethodBeat.o(129648);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(129649);
    ac.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
    if (this.BTI != null)
    {
      Object localObject = this.BTI;
      if (com.tencent.mm.sdk.b.a.GpY.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).BVB)) {
        com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).BVB);
      }
      if (com.tencent.mm.sdk.b.a.GpY.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).BVC)) {
        com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).BVC);
      }
      if (com.tencent.mm.sdk.b.a.GpY.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).BVE)) {
        com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).BVE);
      }
      localObject = i.BVK;
      if (((i)localObject).BVO != null) {
        ((i)localObject).BVO.clear();
      }
    }
    AppMethodBeat.o(129649);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(129647);
    super.uninstalled();
    this.BTK.dead();
    AppMethodBeat.o(129647);
  }
  
  final class a
    implements v<bwa>
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock
 * JD-Core Version:    0.7.0.1
 */