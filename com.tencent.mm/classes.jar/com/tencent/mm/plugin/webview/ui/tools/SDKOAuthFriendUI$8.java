package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class SDKOAuthFriendUI$8
  implements b
{
  SDKOAuthFriendUI$8(SDKOAuthFriendUI paramSDKOAuthFriendUI, int paramInt1, int paramInt2) {}
  
  public final void hX(int paramInt)
  {
    y.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthFriendUI.a(this.rlO).Ca(-4);
      return;
    }
    if ((this.rlR == 8) && (this.rlS == 8))
    {
      SDKOAuthFriendUI.a(this.rlO).Ca(-4);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (this.rlS == 7) {
      localLinkedList.add("snsapi_friend");
    }
    if (this.rlR == 7)
    {
      localLinkedList.add("snsapi_userinfo");
      if (SDKOAuthFriendUI.b(this.rlO) == -1) {
        y.e("MicroMsg.SDKOAuthFriendUI", "btnCallback: do not get avatarId from pageone");
      }
      SDKOAuthFriendUI.a(this.rlO).h(localLinkedList, SDKOAuthFriendUI.b(this.rlO));
      return;
    }
    SDKOAuthFriendUI.a(this.rlO).av(localLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.8
 * JD-Core Version:    0.7.0.1
 */