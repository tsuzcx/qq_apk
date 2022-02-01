package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;

final class k$2
  implements Runnable
{
  k$2(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(202590);
    Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(this.dlJ);
    h.a(this.val$context, localIntent, this.kNB, this.val$showType, new al()
    {
      public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(202589);
        Log.i("SnsAdUtil", "onLaunchApp=" + paramAnonymousBoolean1 + ", launchCancel=" + paramAnonymousBoolean2);
        if ((paramAnonymousBoolean1) && (k.2.this.val$showType != 2)) {
          i.a(k.2.this.jrJ, k.2.this.val$appId, 1, 2, k.2.this.Dty, k.2.this.Dtz, k.2.this.DEf);
        }
        if (!paramAnonymousBoolean1) {
          ap.hb(k.2.this.val$context);
        }
        AppMethodBeat.o(202589);
      }
    }, null);
    AppMethodBeat.o(202590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.k.2
 * JD-Core Version:    0.7.0.1
 */