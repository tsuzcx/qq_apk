package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class SDKOAuthFriendUI$6
  implements b
{
  SDKOAuthFriendUI$6(SDKOAuthFriendUI paramSDKOAuthFriendUI, int paramInt) {}
  
  public final void kK(int paramInt)
  {
    AppMethodBeat.i(153178);
    ab.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (this.vbv == 7))
    {
      SDKOAuthFriendUI.e(this.vbr);
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add("snsapi_friend");
      if (SDKOAuthFriendUI.h(this.vbr))
      {
        SDKOAuthFriendUI.d(this.vbr);
        ai.a(localLinkedList, 0, SDKOAuthFriendUI.i(this.vbr));
        AppMethodBeat.o(153178);
        return;
      }
      SDKOAuthFriendUI.d(this.vbr).aG(localLinkedList);
      AppMethodBeat.o(153178);
      return;
    }
    SDKOAuthFriendUI.d(this.vbr).JU(-4);
    AppMethodBeat.o(153178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.6
 * JD-Core Version:    0.7.0.1
 */