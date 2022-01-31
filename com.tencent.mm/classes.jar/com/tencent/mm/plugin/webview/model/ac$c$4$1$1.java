package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class ac$c$4$1$1
  implements Runnable
{
  ac$c$4$1$1(ac.c.4.1 param1, int paramInt) {}
  
  public final void run()
  {
    if (this.pGH == 1)
    {
      this.rfM.rfL.rfE.goBack();
      return;
    }
    Object localObject = this.rfM.rfL.rfI;
    Bundle localBundle = this.rfM.rfK;
    ac.d locald = this.rfM.rfL.rfE;
    d locald1 = this.rfM.rfL.rfi;
    ac.b localb = this.rfM.rfL.rfD;
    int i = this.rfM.rfL.rfJ;
    y.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic");
    if (((Bundle)localObject).getBoolean("is_call_server_when_confirm"))
    {
      ac.c.a(locald1, ((Bundle)localObject).getString("oauth_url"), 1, (ArrayList)localBundle.getSerializable("key_scope"), localb, true, i);
      return;
    }
    localObject = ((Bundle)localObject).getString("redirect_url");
    locald.Se((String)localObject);
    y.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic redirectUrl: %s", new Object[] { localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac.c.4.1.1
 * JD-Core Version:    0.7.0.1
 */