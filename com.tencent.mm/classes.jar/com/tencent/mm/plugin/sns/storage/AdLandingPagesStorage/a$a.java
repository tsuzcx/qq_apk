package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.ConcurrentHashMap;

final class a$a
  extends BroadcastReceiver
{
  private a$a(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(36928);
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
      {
        paramContext = paramIntent.getData().getSchemeSpecificPart();
        if ((!bo.isNullOrNil(paramContext)) && (this.rrw.rrs.containsKey(paramContext))) {
          ((a.c)this.rrw.rrs.remove(paramContext)).ZX(paramContext);
        }
        AppMethodBeat.o(36928);
        return;
      }
      if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
      {
        paramContext = paramIntent.getData().getSchemeSpecificPart();
        if ((!bo.isNullOrNil(paramContext)) && (this.rrw.rrs.containsKey(paramContext))) {
          ((a.c)this.rrw.rrs.remove(paramContext)).ZY(paramContext);
        }
      }
    }
    AppMethodBeat.o(36928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a
 * JD-Core Version:    0.7.0.1
 */