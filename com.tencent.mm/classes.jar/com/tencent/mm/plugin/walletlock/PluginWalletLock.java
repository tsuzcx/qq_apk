package com.tencent.mm.plugin.walletlock;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginWalletLock
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.walletlock.a.a
{
  private com.tencent.mm.plugin.walletlock.c.f Duc;
  private final LinkedList<Activity> Dud;
  private com.tencent.mm.sdk.b.c<nu> Due;
  
  public PluginWalletLock()
  {
    AppMethodBeat.i(129643);
    this.Duc = null;
    this.Dud = new LinkedList();
    this.Due = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(129643);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(129646);
    if (paramg.akw())
    {
      ad.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
      com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.walletlock.c.e()));
      aa.a(1, new a((byte)0));
      this.Due.alive();
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
    AppMethodBeat.i(218738);
    if (paramg.akw()) {
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.z.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(218736);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a))
          {
            paramAnonymousBundle = PluginWalletLock.this.Dud.iterator();
            while (paramAnonymousBundle.hasNext()) {
              ((Activity)paramAnonymousBundle.next()).finish();
            }
            PluginWalletLock.this.Dud.clear();
            PluginWalletLock.this.Dud.add(paramAnonymousActivity);
          }
          AppMethodBeat.o(218736);
        }
        
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(218737);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a)) {
            PluginWalletLock.this.Dud.remove(paramAnonymousActivity);
          }
          AppMethodBeat.o(218737);
        }
      });
    }
    AppMethodBeat.o(218738);
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
    ad.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
    this.Duc = new com.tencent.mm.plugin.walletlock.c.f();
    paramc = this.Duc;
    if (!com.tencent.mm.sdk.b.a.IbL.e(paramc.DvV)) {
      com.tencent.mm.sdk.b.a.IbL.c(paramc.DvV);
    }
    if (!com.tencent.mm.sdk.b.a.IbL.e(paramc.DvW)) {
      com.tencent.mm.sdk.b.a.IbL.c(paramc.DvW);
    }
    if (!com.tencent.mm.sdk.b.a.IbL.e(paramc.DvY)) {
      com.tencent.mm.sdk.b.a.IbL.c(paramc.DvY);
    }
    try
    {
      paramc = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("PatternLockTimeInterval");
      if (!bt.isNullOrNil(paramc))
      {
        int i = bt.getInt(paramc, 0);
        if (i >= 0)
        {
          ad.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[] { Integer.valueOf(i) }));
          com.tencent.mm.plugin.walletlock.gesture.a.a.DuC = i;
          AppMethodBeat.o(129648);
          return;
        }
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WalletLockInitTask", paramc, "", new Object[0]);
        paramc = null;
      }
      ad.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
      com.tencent.mm.plugin.walletlock.gesture.a.a.DuC = 300;
      AppMethodBeat.o(129648);
      return;
    }
    ad.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
    com.tencent.mm.plugin.walletlock.gesture.a.a.DuC = 300;
    AppMethodBeat.o(129648);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(129649);
    ad.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
    if (this.Duc != null)
    {
      Object localObject = this.Duc;
      if (com.tencent.mm.sdk.b.a.IbL.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).DvV)) {
        com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).DvV);
      }
      if (com.tencent.mm.sdk.b.a.IbL.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).DvW)) {
        com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).DvW);
      }
      if (com.tencent.mm.sdk.b.a.IbL.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).DvY)) {
        com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).DvY);
      }
      localObject = i.Dwe;
      if (((i)localObject).Dwi != null) {
        ((i)localObject).Dwi.clear();
      }
    }
    AppMethodBeat.o(129649);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(129647);
    super.uninstalled();
    this.Due.dead();
    AppMethodBeat.o(129647);
  }
  
  final class a
    implements x<caq>
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock
 * JD-Core Version:    0.7.0.1
 */