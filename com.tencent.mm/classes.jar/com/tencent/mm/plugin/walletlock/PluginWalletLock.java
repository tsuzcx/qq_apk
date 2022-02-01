package com.tencent.mm.plugin.walletlock;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.on;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.protocal.protobuf.cqm;
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
  private com.tencent.mm.plugin.walletlock.c.f IuW;
  private final LinkedList<Activity> IuX;
  private IListener<on> IuY;
  
  public PluginWalletLock()
  {
    AppMethodBeat.i(129643);
    this.IuW = null;
    this.IuX = new LinkedList();
    this.IuY = new IListener() {};
    AppMethodBeat.o(129643);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(129646);
    if (paramg.aBb())
    {
      Log.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
      com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.walletlock.c.e()));
      ab.a(1, new a((byte)0));
      this.IuY.alive();
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
    AppMethodBeat.i(187541);
    if (paramg.aBb()) {
      paramg.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(187539);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a))
          {
            paramAnonymousBundle = PluginWalletLock.this.IuX.iterator();
            while (paramAnonymousBundle.hasNext()) {
              ((Activity)paramAnonymousBundle.next()).finish();
            }
            PluginWalletLock.this.IuX.clear();
            PluginWalletLock.this.IuX.add(paramAnonymousActivity);
          }
          AppMethodBeat.o(187539);
        }
        
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(187540);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a)) {
            PluginWalletLock.this.IuX.remove(paramAnonymousActivity);
          }
          AppMethodBeat.o(187540);
        }
      });
    }
    AppMethodBeat.o(187541);
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
    Log.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
    this.IuW = new com.tencent.mm.plugin.walletlock.c.f();
    paramc = this.IuW;
    if (!EventCenter.instance.hadListened(paramc.IwP)) {
      EventCenter.instance.addListener(paramc.IwP);
    }
    if (!EventCenter.instance.hadListened(paramc.IwQ)) {
      EventCenter.instance.addListener(paramc.IwQ);
    }
    if (!EventCenter.instance.hadListened(paramc.IwS)) {
      EventCenter.instance.addListener(paramc.IwS);
    }
    try
    {
      paramc = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PatternLockTimeInterval");
      if (!Util.isNullOrNil(paramc))
      {
        int i = Util.getInt(paramc, 0);
        if (i >= 0)
        {
          Log.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[] { Integer.valueOf(i) }));
          com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw = i;
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
      com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw = 300;
      AppMethodBeat.o(129648);
      return;
    }
    Log.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
    com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw = 300;
    AppMethodBeat.o(129648);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(129649);
    Log.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
    if (this.IuW != null)
    {
      Object localObject = this.IuW;
      if (EventCenter.instance.hadListened(((com.tencent.mm.plugin.walletlock.c.f)localObject).IwP)) {
        EventCenter.instance.removeListener(((com.tencent.mm.plugin.walletlock.c.f)localObject).IwP);
      }
      if (EventCenter.instance.hadListened(((com.tencent.mm.plugin.walletlock.c.f)localObject).IwQ)) {
        EventCenter.instance.removeListener(((com.tencent.mm.plugin.walletlock.c.f)localObject).IwQ);
      }
      if (EventCenter.instance.hadListened(((com.tencent.mm.plugin.walletlock.c.f)localObject).IwS)) {
        EventCenter.instance.removeListener(((com.tencent.mm.plugin.walletlock.c.f)localObject).IwS);
      }
      localObject = i.IwY;
      if (((i)localObject).Ixc != null) {
        ((i)localObject).Ixc.clear();
      }
    }
    AppMethodBeat.o(129649);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(129647);
    super.uninstalled();
    this.IuY.dead();
    AppMethodBeat.o(129647);
  }
  
  final class a
    implements y<cqm>
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock
 * JD-Core Version:    0.7.0.1
 */