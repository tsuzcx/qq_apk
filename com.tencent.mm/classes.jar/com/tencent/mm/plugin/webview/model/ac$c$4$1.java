package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.cg.a;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.sdk.platformtools.y;

final class ac$c$4$1
  implements b
{
  ac$c$4$1(ac.c.4 param4, Bundle paramBundle) {}
  
  public final void hX(int paramInt)
  {
    y.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    a.m(new ac.c.4.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac.c.4.1
 * JD-Core Version:    0.7.0.1
 */