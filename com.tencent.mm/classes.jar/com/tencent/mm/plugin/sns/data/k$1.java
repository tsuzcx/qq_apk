package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;

final class k$1
  implements Runnable
{
  k$1(Context paramContext, Intent paramIntent, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(202588);
    h.a(this.val$context, this.val$intent, this.kNB, this.val$showType, new al()
    {
      public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(202587);
        Log.i("SnsAdUtil", "appPageUrl!=null, onLaunchApp=" + paramAnonymousBoolean1 + ", launchCancel=" + paramAnonymousBoolean2);
        if ((paramAnonymousBoolean1) && (k.1.this.val$showType != 2)) {
          i.a(k.1.this.jrJ, k.1.this.val$appId, 1, 2, k.1.this.Dty, k.1.this.Dtz, k.1.this.DEf);
        }
        if (!paramAnonymousBoolean1) {
          ap.hb(k.1.this.val$context);
        }
        AppMethodBeat.o(202587);
      }
    }, null);
    AppMethodBeat.o(202588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.k.1
 * JD-Core Version:    0.7.0.1
 */