package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class SDKOAuthUI$4
  implements b
{
  SDKOAuthUI$4(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void hX(int paramInt)
  {
    y.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthUI.a(this.rmk, -4);
      this.rmk.finish();
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("snsapi_userinfo");
    SDKOAuthUI.i(this.rmk).h(localLinkedList, SDKOAuthUI.b.a(SDKOAuthUI.d(this.rmk)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.4
 * JD-Core Version:    0.7.0.1
 */