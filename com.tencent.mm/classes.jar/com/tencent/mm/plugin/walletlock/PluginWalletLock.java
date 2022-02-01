package com.tencent.mm.plugin.walletlock;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pk;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.ac;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginWalletLock
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.walletlock.a.a
{
  private com.tencent.mm.plugin.walletlock.c.f PnF;
  private final LinkedList<Activity> PnG;
  private IListener<pk> PnH;
  
  public PluginWalletLock()
  {
    AppMethodBeat.i(129643);
    this.PnF = null;
    this.PnG = new LinkedList();
    this.PnH = new IListener() {};
    AppMethodBeat.o(129643);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(129646);
    if (paramg.aIE())
    {
      Log.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
      h.a(b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.walletlock.c.e()));
      af.a(1, new a((byte)0));
      this.PnH.alive();
    }
    AppMethodBeat.o(129646);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(129645);
    dependsOn(com.tencent.mm.plugin.soter.a.a.class);
    AppMethodBeat.o(129645);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(234363);
    if (paramg.aIE()) {
      paramg.Zw.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(234424);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a))
          {
            paramAnonymousBundle = PluginWalletLock.this.PnG.iterator();
            while (paramAnonymousBundle.hasNext()) {
              ((Activity)paramAnonymousBundle.next()).finish();
            }
            PluginWalletLock.this.PnG.clear();
            PluginWalletLock.this.PnG.add(paramAnonymousActivity);
          }
          AppMethodBeat.o(234424);
        }
        
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(234426);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a)) {
            PluginWalletLock.this.PnG.remove(paramAnonymousActivity);
          }
          AppMethodBeat.o(234426);
        }
      });
    }
    AppMethodBeat.o(234363);
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
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(129648);
    Log.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
    this.PnF = new com.tencent.mm.plugin.walletlock.c.f();
    paramc = this.PnF;
    if (!EventCenter.instance.hadListened(paramc.PqU)) {
      EventCenter.instance.addListener(paramc.PqU);
    }
    if (!EventCenter.instance.hadListened(paramc.PqV)) {
      EventCenter.instance.addListener(paramc.PqV);
    }
    if (!EventCenter.instance.hadListened(paramc.PqX)) {
      EventCenter.instance.addListener(paramc.PqX);
    }
    try
    {
      paramc = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("PatternLockTimeInterval");
      if (!Util.isNullOrNil(paramc))
      {
        int i = Util.getInt(paramc, 0);
        if (i >= 0)
        {
          Log.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[] { Integer.valueOf(i) }));
          com.tencent.mm.plugin.walletlock.gesture.a.a.PpB = i;
          AppMethodBeat.o(129648);
          return;
        }
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletLockInitTask", paramc, "", new Object[0]);
        paramc = null;
      }
      Log.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
      com.tencent.mm.plugin.walletlock.gesture.a.a.PpB = 300;
      AppMethodBeat.o(129648);
      return;
    }
    Log.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
    com.tencent.mm.plugin.walletlock.gesture.a.a.PpB = 300;
    AppMethodBeat.o(129648);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(129649);
    Log.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
    if (this.PnF != null)
    {
      Object localObject = this.PnF;
      if (EventCenter.instance.hadListened(((com.tencent.mm.plugin.walletlock.c.f)localObject).PqU)) {
        EventCenter.instance.removeListener(((com.tencent.mm.plugin.walletlock.c.f)localObject).PqU);
      }
      if (EventCenter.instance.hadListened(((com.tencent.mm.plugin.walletlock.c.f)localObject).PqV)) {
        EventCenter.instance.removeListener(((com.tencent.mm.plugin.walletlock.c.f)localObject).PqV);
      }
      if (EventCenter.instance.hadListened(((com.tencent.mm.plugin.walletlock.c.f)localObject).PqX)) {
        EventCenter.instance.removeListener(((com.tencent.mm.plugin.walletlock.c.f)localObject).PqX);
      }
      localObject = i.Prd;
      if (((i)localObject).Prh != null) {
        ((i)localObject).Prh.clear();
      }
    }
    AppMethodBeat.o(129649);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(129647);
    super.uninstalled();
    this.PnH.dead();
    AppMethodBeat.o(129647);
  }
  
  final class a
    implements ac<czd>
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock
 * JD-Core Version:    0.7.0.1
 */