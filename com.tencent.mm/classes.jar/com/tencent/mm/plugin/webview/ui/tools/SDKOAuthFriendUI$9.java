package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class SDKOAuthFriendUI$9
  implements b
{
  SDKOAuthFriendUI$9(SDKOAuthFriendUI paramSDKOAuthFriendUI, int paramInt) {}
  
  public final void hX(int paramInt)
  {
    y.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (this.rlS == 7))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add("snsapi_friend");
      SDKOAuthFriendUI.a(this.rlO).av(localLinkedList);
      return;
    }
    SDKOAuthFriendUI.a(this.rlO).Ca(-4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.9
 * JD-Core Version:    0.7.0.1
 */