package com.tencent.mm.plugin.walletlock;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginWalletLock
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.walletlock.a.a
{
  private com.tencent.mm.plugin.walletlock.c.f DLH;
  private final LinkedList<Activity> DLI;
  private com.tencent.mm.sdk.b.c<nv> DLJ;
  
  public PluginWalletLock()
  {
    AppMethodBeat.i(129643);
    this.DLH = null;
    this.DLI = new LinkedList();
    this.DLJ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(129643);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(129646);
    if (paramg.akL())
    {
      ae.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
      com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.walletlock.c.e()));
      ab.a(1, new a((byte)0));
      this.DLJ.alive();
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
    AppMethodBeat.i(209723);
    if (paramg.akL()) {
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.y.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(209721);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a))
          {
            paramAnonymousBundle = PluginWalletLock.this.DLI.iterator();
            while (paramAnonymousBundle.hasNext()) {
              ((Activity)paramAnonymousBundle.next()).finish();
            }
            PluginWalletLock.this.DLI.clear();
            PluginWalletLock.this.DLI.add(paramAnonymousActivity);
          }
          AppMethodBeat.o(209721);
        }
        
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(209722);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a)) {
            PluginWalletLock.this.DLI.remove(paramAnonymousActivity);
          }
          AppMethodBeat.o(209722);
        }
      });
    }
    AppMethodBeat.o(209723);
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
    ae.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
    this.DLH = new com.tencent.mm.plugin.walletlock.c.f();
    paramc = this.DLH;
    if (!com.tencent.mm.sdk.b.a.IvT.e(paramc.DNA)) {
      com.tencent.mm.sdk.b.a.IvT.c(paramc.DNA);
    }
    if (!com.tencent.mm.sdk.b.a.IvT.e(paramc.DNB)) {
      com.tencent.mm.sdk.b.a.IvT.c(paramc.DNB);
    }
    if (!com.tencent.mm.sdk.b.a.IvT.e(paramc.DND)) {
      com.tencent.mm.sdk.b.a.IvT.c(paramc.DND);
    }
    try
    {
      paramc = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("PatternLockTimeInterval");
      if (!bu.isNullOrNil(paramc))
      {
        int i = bu.getInt(paramc, 0);
        if (i >= 0)
        {
          ae.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[] { Integer.valueOf(i) }));
          com.tencent.mm.plugin.walletlock.gesture.a.a.DMh = i;
          AppMethodBeat.o(129648);
          return;
        }
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WalletLockInitTask", paramc, "", new Object[0]);
        paramc = null;
      }
      ae.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
      com.tencent.mm.plugin.walletlock.gesture.a.a.DMh = 300;
      AppMethodBeat.o(129648);
      return;
    }
    ae.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
    com.tencent.mm.plugin.walletlock.gesture.a.a.DMh = 300;
    AppMethodBeat.o(129648);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(129649);
    ae.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
    if (this.DLH != null)
    {
      Object localObject = this.DLH;
      if (com.tencent.mm.sdk.b.a.IvT.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).DNA)) {
        com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).DNA);
      }
      if (com.tencent.mm.sdk.b.a.IvT.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).DNB)) {
        com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).DNB);
      }
      if (com.tencent.mm.sdk.b.a.IvT.e(((com.tencent.mm.plugin.walletlock.c.f)localObject).DND)) {
        com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.walletlock.c.f)localObject).DND);
      }
      localObject = i.DNJ;
      if (((i)localObject).DNN != null) {
        ((i)localObject).DNN.clear();
      }
    }
    AppMethodBeat.o(129649);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(129647);
    super.uninstalled();
    this.DLJ.dead();
    AppMethodBeat.o(129647);
  }
  
  final class a
    implements y<cbk>
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock
 * JD-Core Version:    0.7.0.1
 */