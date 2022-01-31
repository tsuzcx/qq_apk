package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ah$c$4
  implements n.a
{
  ah$c$4(Context paramContext, String paramString, ah.d paramd, int paramInt1, Bundle paramBundle, d paramd1, ah.b paramb, int paramInt2) {}
  
  public final void h(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(6666);
    ab.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      this.uVR.goBack();
      AppMethodBeat.o(6666);
      return;
    case 1: 
      c.a(this.val$context, com.tencent.mm.model.gdpr.a.foA, this.uVS, new ah.c.4.1(this, paramBundle));
      AppMethodBeat.o(6666);
      return;
    }
    ah.c.b(this.uVV, paramBundle, this.uVR, this.uVj, this.uVQ, this.uVW);
    com.tencent.mm.plugin.webview.f.a locala = com.tencent.mm.plugin.webview.f.a.vtM;
    if (this.uVS == null) {}
    for (paramBundle = "";; paramBundle = this.uVS)
    {
      locala.a(paramBundle, ah.c.awG(), 0, 1, 0, 1, this.val$errCode);
      com.tencent.mm.plugin.webview.f.a.vtM.ap(2, (int)(System.currentTimeMillis() - ah.c.access$200()), this.val$errCode);
      AppMethodBeat.o(6666);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah.c.4
 * JD-Core Version:    0.7.0.1
 */