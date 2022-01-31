package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import java.io.Serializable;

final class m$b
  extends BroadcastReceiver
  implements Serializable
{
  private m$b(m paramm) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(37143);
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
      {
        paramContext = paramIntent.getData().getSchemeSpecificPart();
        if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(m.b(this.rvI).Ca))) {
          this.rvI.rvD.sendMessage(3);
        }
        AppMethodBeat.o(37143);
        return;
      }
      if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
      {
        paramContext = paramIntent.getData().getSchemeSpecificPart();
        if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(m.b(this.rvI).Ca))) {
          this.rvI.rvD.sendMessage(4);
        }
      }
    }
    AppMethodBeat.o(37143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.b
 * JD-Core Version:    0.7.0.1
 */