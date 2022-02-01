package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$a$g$1
  implements Runnable
{
  q$a$g$1(q.a.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(96537);
    if (q.e(this.ynU.ynN.ynC) == null)
    {
      q.a(this.ynU.ynN.ynC, new q.b(this.ynU.ynN.ynC, (byte)0));
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
      localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
      localIntentFilter.addDataScheme("package");
      this.ynU.ynN.ynC.context.registerReceiver(q.e(this.ynU.ynN.ynC), localIntentFilter);
    }
    AppMethodBeat.o(96537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.a.g.1
 * JD-Core Version:    0.7.0.1
 */