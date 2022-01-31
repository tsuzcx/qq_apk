package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.pluginsdk.model.app.g;

final class n$4
  implements Runnable
{
  n$4(n paramn) {}
  
  public final void run()
  {
    Intent localIntent = this.oGd.context.getPackageManager().getLaunchIntentForPackage(n.b(this.oGd).Bo);
    g.a(this.oGd.context, localIntent, g.n(this.oGd.context, n.b(this.oGd).bOL), new n.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.4
 * JD-Core Version:    0.7.0.1
 */