package com.tencent.mm.plugin.walletlock;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginWalletLock
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.walletlock.a.a
{
  private com.tencent.mm.plugin.walletlock.c.f ABn;
  private final LinkedList<Activity> ABo;
  private com.tencent.mm.sdk.b.c<nd> ABp;
  
  public PluginWalletLock()
  {
    AppMethodBeat.i(129643);
    this.ABn = null;
    this.ABo = new LinkedList();
    this.ABp = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(129643);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(129646);
    if (paramg.agu())
    {
      ad.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
      com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.walletlock.c.e()));
      y.a(1, new a((byte)0));
      this.ABp.alive();
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
    AppMethodBeat.i(190576);
    if (paramg.agu()) {
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.aa.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(190574);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a))
          {
            paramAnonymousBundle = PluginWalletLock.this.ABo.iterator();
            while (paramAnonymousBundle.hasNext()) {
              ((Activity)paramAnonymousBundle.next()).finish();
            }
            PluginWalletLock.this.ABo.clear();
            PluginWalletLock.this.ABo.add(paramAnonymousActivity);
          }
          AppMethodBeat.o(190574);
        }
        
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(190575);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a)) {
            PluginWalletLock.this.ABo.remove(paramAnonymousActivity);
          }
          AppMethodBeat.o(190575);
        }
      });
    }
    AppMethodBeat.o(190576);
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
    this.ABn = new com.tencent.mm.plugin.walletlock.c.f();
    paramc = this.ABn;
    if (!com.tencent.mm.sdk.b.a.ESL.e(paramc.ADg)) {
      com.tencent.mm.sdk.b.a.ESL.c(paramc.ADg);
    }
    if (!com.tencent.mm.sdk.b.a.ESL.e(paramc.ADh)) {
      com.tencent.mm.sdk.b.a.ESL.c(paramc.ADh);
    }
    if (!com.tencent.mm.sdk.b.a.ESL.e(paramc.ADj)) {
      com.tencent.mm.sdk.b.a.ESL.c(paramc.ADj);
    }
    try
    {
      paramc = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("PatternLockTimeInterval");
      if (!bt.isNullOrNil(paramc))
      {
        int i = bt.getInt(paramc, 0);
        if (i >= 0)
        {
          ad.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[] { Integer.valueOf(i) }));
          com.tencent.mm.plugin.walletlock.gesture.a.a.ABN = i;
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
      com.tencent.mm.plugin.walletlock.gesture.a.a.ABN = 300;
      AppMethodBeat.o(129648);
      return;
    }
    ad.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
    com.tencent.mm.plugin.walletlock.gesture.a.a.ABN = 300;
    AppMethodBeat.o(129648);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(129649);
    ad.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
    if (this.ABn != null)
    {
      Object localObject = this.ABn;
      if (com.tencent.mm.sdk.b.a.ESL.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).ADg)) {
        com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).ADg);
      }
      if (com.tencent.mm.sdk.b.a.ESL.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).ADh)) {
        com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).ADh);
      }
      if (com.tencent.mm.sdk.b.a.ESL.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).ADj)) {
        com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).ADj);
      }
      localObject = i.ADp;
      if (((i)localObject).ADt != null) {
        ((i)localObject).ADt.clear();
      }
    }
    AppMethodBeat.o(129649);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(129647);
    super.uninstalled();
    this.ABp.dead();
    AppMethodBeat.o(129647);
  }
  
  final class a
    implements v<brj>
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock
 * JD-Core Version:    0.7.0.1
 */