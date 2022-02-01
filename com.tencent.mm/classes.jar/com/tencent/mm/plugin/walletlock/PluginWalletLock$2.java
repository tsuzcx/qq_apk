package com.tencent.mm.plugin.walletlock;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

final class PluginWalletLock$2
  extends com.tencent.mm.plugin.appbrand.z.a
{
  PluginWalletLock$2(PluginWalletLock paramPluginWalletLock) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(204926);
    if ((paramActivity instanceof com.tencent.mm.plugin.walletlock.ui.a))
    {
      paramBundle = PluginWalletLock.access$100(this.BTL).iterator();
      while (paramBundle.hasNext()) {
        ((Activity)paramBundle.next()).finish();
      }
      PluginWalletLock.access$100(this.BTL).clear();
      PluginWalletLock.access$100(this.BTL).add(paramActivity);
    }
    AppMethodBeat.o(204926);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(204927);
    if ((paramActivity instanceof com.tencent.mm.plugin.walletlock.ui.a)) {
      PluginWalletLock.access$100(this.BTL).remove(paramActivity);
    }
    AppMethodBeat.o(204927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.PluginWalletLock.2
 * JD-Core Version:    0.7.0.1
 */