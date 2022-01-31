package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import java.io.Serializable;

final class n$b
  extends BroadcastReceiver
  implements Serializable
{
  private n$b(n paramn) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!"android.intent.action.PACKAGE_ADDED".equals(paramContext)) {
        break label62;
      }
      paramContext = paramIntent.getData().getSchemeSpecificPart();
      if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(n.b(this.oGd).Bo))) {
        this.oGd.oFZ.Ff(3);
      }
    }
    label62:
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.PACKAGE_REMOVED".equals(paramContext));
      paramContext = paramIntent.getData().getSchemeSpecificPart();
    } while ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals(n.b(this.oGd).Bo)));
    this.oGd.oFZ.Ff(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.b
 * JD-Core Version:    0.7.0.1
 */