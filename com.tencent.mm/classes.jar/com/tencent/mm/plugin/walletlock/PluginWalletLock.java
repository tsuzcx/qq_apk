package com.tencent.mm.plugin.walletlock;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qx;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.ac;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.model.d;
import com.tencent.mm.protocal.protobuf.dqk;
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
  private com.tencent.mm.plugin.walletlock.model.e Wee;
  private final LinkedList<Activity> Wef;
  private IListener<qx> Weg;
  
  public PluginWalletLock()
  {
    AppMethodBeat.i(129643);
    this.Wee = null;
    this.Wef = new LinkedList();
    this.Weg = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(129643);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(129646);
    if (paramg.bbA())
    {
      Log.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
      com.tencent.mm.kernel.h.a(b.class, new com.tencent.mm.kernel.c.e(new d()));
      af.a(1, new a((byte)0));
      this.Weg.alive();
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
    AppMethodBeat.i(266845);
    if (paramg.bbA()) {
      paramg.bGP.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.af.a()
      {
        public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(266817);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a))
          {
            paramAnonymousBundle = PluginWalletLock.this.Wef.iterator();
            while (paramAnonymousBundle.hasNext()) {
              ((Activity)paramAnonymousBundle.next()).finish();
            }
            PluginWalletLock.this.Wef.clear();
            PluginWalletLock.this.Wef.add(paramAnonymousActivity);
          }
          AppMethodBeat.o(266817);
        }
        
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(266821);
          if ((paramAnonymousActivity instanceof com.tencent.mm.plugin.walletlock.ui.a)) {
            PluginWalletLock.this.Wef.remove(paramAnonymousActivity);
          }
          AppMethodBeat.o(266821);
        }
      });
    }
    AppMethodBeat.o(266845);
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
    this.Wee = new com.tencent.mm.plugin.walletlock.model.e();
    paramc = this.Wee;
    if (!EventCenter.instance.hadListened(paramc.WhH)) {
      paramc.WhH.alive();
    }
    if (!EventCenter.instance.hadListened(paramc.WhI)) {
      paramc.WhI.alive();
    }
    if (!EventCenter.instance.hadListened(paramc.WhK)) {
      paramc.WhK.alive();
    }
    try
    {
      paramc = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("PatternLockTimeInterval");
      if (!Util.isNullOrNil(paramc))
      {
        int i = Util.getInt(paramc, 0);
        if (i >= 0)
        {
          Log.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[] { Integer.valueOf(i) }));
          com.tencent.mm.plugin.walletlock.gesture.a.b.Wgm = i;
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
      com.tencent.mm.plugin.walletlock.gesture.a.b.Wgm = 300;
      AppMethodBeat.o(129648);
      return;
    }
    Log.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
    com.tencent.mm.plugin.walletlock.gesture.a.b.Wgm = 300;
    AppMethodBeat.o(129648);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(129649);
    Log.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
    if (this.Wee != null)
    {
      Object localObject = this.Wee;
      if (EventCenter.instance.hadListened(((com.tencent.mm.plugin.walletlock.model.e)localObject).WhH)) {
        ((com.tencent.mm.plugin.walletlock.model.e)localObject).WhH.dead();
      }
      if (EventCenter.instance.hadListened(((com.tencent.mm.plugin.walletlock.model.e)localObject).WhI)) {
        ((com.tencent.mm.plugin.walletlock.model.e)localObject).WhI.dead();
      }
      if (EventCenter.instance.hadListened(((com.tencent.mm.plugin.walletlock.model.e)localObject).WhK)) {
        ((com.tencent.mm.plugin.walletlock.model.e)localObject).WhK.dead();
      }
      localObject = com.tencent.mm.plugin.walletlock.model.h.WhQ;
      if (((com.tencent.mm.plugin.walletlock.model.h)localObject).WhU != null) {
        ((com.tencent.mm.plugin.walletlock.model.h)localObject).WhU.clear();
      }
    }
    AppMethodBeat.o(129649);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(129647);
    super.uninstalled();
    this.Weg.dead();
    AppMethodBeat.o(129647);
  }
  
  final class a
    implements ac<dqk>
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock
 * JD-Core Version:    0.7.0.1
 */