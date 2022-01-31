package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$a$g$1
  implements Runnable
{
  m$a$g$1(m.a.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(37129);
    if (m.e(this.rwa.rvU.rvI) == null)
    {
      m.a(this.rwa.rvU.rvI, new m.b(this.rwa.rvU.rvI, (byte)0));
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
      localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
      localIntentFilter.addDataScheme("package");
      this.rwa.rvU.rvI.context.registerReceiver(m.e(this.rwa.rvU.rvI), localIntentFilter);
    }
    AppMethodBeat.o(37129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.g.1
 * JD-Core Version:    0.7.0.1
 */