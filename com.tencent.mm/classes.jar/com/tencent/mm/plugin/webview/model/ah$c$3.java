package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class ah$c$3
  implements b
{
  ah$c$3(ah.d paramd, String paramString1, int paramInt, String paramString2) {}
  
  public final void kK(int paramInt)
  {
    AppMethodBeat.i(6663);
    ab.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    al.d(new ah.c.3.1(this, paramInt));
    AppMethodBeat.o(6663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah.c.3
 * JD-Core Version:    0.7.0.1
 */