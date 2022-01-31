package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class SDKOAuthFriendUI$5
  implements b
{
  SDKOAuthFriendUI$5(SDKOAuthFriendUI paramSDKOAuthFriendUI, int paramInt1, int paramInt2) {}
  
  public final void kK(int paramInt)
  {
    AppMethodBeat.i(7494);
    ab.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthFriendUI.d(this.vbr).JU(-4);
      AppMethodBeat.o(7494);
      return;
    }
    if ((this.vbu == 8) && (this.vbv == 8))
    {
      SDKOAuthFriendUI.d(this.vbr).JU(-4);
      AppMethodBeat.o(7494);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (this.vbv == 7) {
      localLinkedList.add("snsapi_friend");
    }
    SDKOAuthFriendUI.e(this.vbr);
    if (this.vbu == 7)
    {
      SDKOAuthFriendUI.d(this.vbr);
      ai.a(SDKOAuthFriendUI.f(this.vbr), localLinkedList);
      if (SDKOAuthFriendUI.g(this.vbr) == -1) {
        ab.e("MicroMsg.SDKOAuthFriendUI", "btnCallback: do not get avatarId from pageone");
      }
      if (SDKOAuthFriendUI.h(this.vbr))
      {
        SDKOAuthFriendUI.d(this.vbr);
        ai.a(localLinkedList, SDKOAuthFriendUI.g(this.vbr), SDKOAuthFriendUI.i(this.vbr));
        AppMethodBeat.o(7494);
        return;
      }
      SDKOAuthFriendUI.d(this.vbr).h(localLinkedList, SDKOAuthFriendUI.g(this.vbr));
      AppMethodBeat.o(7494);
      return;
    }
    if (SDKOAuthFriendUI.h(this.vbr))
    {
      SDKOAuthFriendUI.d(this.vbr);
      ai.a(localLinkedList, 0, SDKOAuthFriendUI.i(this.vbr));
      AppMethodBeat.o(7494);
      return;
    }
    SDKOAuthFriendUI.d(this.vbr).aG(localLinkedList);
    AppMethodBeat.o(7494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.5
 * JD-Core Version:    0.7.0.1
 */