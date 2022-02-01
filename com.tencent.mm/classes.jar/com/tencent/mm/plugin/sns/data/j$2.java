package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.pluginsdk.model.app.am;

final class j$2
  implements Runnable
{
  j$2(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(210254);
    com.tencent.mm.pluginsdk.model.app.h.a(this.val$context, this.val$intent, this.joE, new am()
    {
      public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(210253);
        if (paramAnonymousBoolean1) {
          h.a(j.2.this.iaf, j.2.this.val$appId, 1, 2, j.2.this.xNk, j.2.this.xNl, j.2.this.CqH);
        }
        if (!paramAnonymousBoolean1) {
          al.gh(j.2.this.val$context);
        }
        AppMethodBeat.o(210253);
      }
    });
    AppMethodBeat.o(210254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.j.2
 * JD-Core Version:    0.7.0.1
 */