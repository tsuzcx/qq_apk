package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.cg.a;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.sdk.platformtools.y;

public final class ac$c$3
  implements b
{
  public ac$c$3(ac.d paramd, String paramString) {}
  
  public final void hX(int paramInt)
  {
    y.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    a.m(new ac.c.3.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac.c.3
 * JD-Core Version:    0.7.0.1
 */