package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class ah$c$4$1
  implements b
{
  ah$c$4$1(ah.c.4 param4, Bundle paramBundle) {}
  
  public final void kK(int paramInt)
  {
    AppMethodBeat.i(6665);
    ab.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    al.d(new ah.c.4.1.1(this, paramInt));
    AppMethodBeat.o(6665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah.c.4.1
 * JD-Core Version:    0.7.0.1
 */