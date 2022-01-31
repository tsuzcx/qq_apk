package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class SDKOAuthOtherUI$4
  implements b
{
  SDKOAuthOtherUI$4(SDKOAuthOtherUI paramSDKOAuthOtherUI, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void hX(int paramInt)
  {
    y.i("MicroMsg.SDKOAuthOtherUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthOtherUI.a(this.rlU).Ca(-4);
      return;
    }
    LinkedList localLinkedList;
    if (this.rlX == 7)
    {
      SDKOAuthOtherUI.a locala = SDKOAuthOtherUI.b(this.rlU);
      localLinkedList = new LinkedList();
      paramInt = 0;
      while (paramInt < locala.rlY.size())
      {
        azs localazs = (azs)locala.rlY.get(paramInt);
        if ((localazs.tvP == 2) || (localazs.tvP == 3)) {
          localLinkedList.add(localazs.scope);
        }
        paramInt += 1;
      }
    }
    while ((this.rlR != -2) && (this.rlS != -2)) {
      if ((this.rlR == 8) && (this.rlS == 8) && (this.rlX == 8))
      {
        SDKOAuthOtherUI.a(this.rlU).Ca(-4);
        return;
        localLinkedList = new LinkedList();
      }
      else
      {
        if (this.rlS == 7) {
          localLinkedList.add("snsapi_friend");
        }
        if (this.rlR == 7)
        {
          localLinkedList.add("snsapi_userinfo");
          if (SDKOAuthOtherUI.c(this.rlU) == -1) {
            y.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
          }
          SDKOAuthOtherUI.a(this.rlU).h(localLinkedList, SDKOAuthOtherUI.c(this.rlU));
          return;
        }
        SDKOAuthOtherUI.a(this.rlU).av(localLinkedList);
        return;
      }
    }
    if (this.rlR != -2)
    {
      if ((this.rlR == 8) && (this.rlX == 8))
      {
        SDKOAuthOtherUI.a(this.rlU).Ca(-4);
        return;
      }
      if (this.rlR == 7)
      {
        localLinkedList.add("snsapi_userinfo");
        if (SDKOAuthOtherUI.c(this.rlU) == -1) {
          y.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
        }
        SDKOAuthOtherUI.a(this.rlU).h(localLinkedList, SDKOAuthOtherUI.c(this.rlU));
        return;
      }
      SDKOAuthOtherUI.a(this.rlU).av(localLinkedList);
      return;
    }
    if (this.rlS != -2)
    {
      if ((this.rlS == 8) && (this.rlX == 8))
      {
        SDKOAuthOtherUI.a(this.rlU).Ca(-4);
        return;
      }
      if (this.rlS == 7) {
        localLinkedList.add("snsapi_friend");
      }
      SDKOAuthOtherUI.a(this.rlU).av(localLinkedList);
      return;
    }
    if (this.rlX == 8)
    {
      SDKOAuthOtherUI.a(this.rlU).Ca(-4);
      return;
    }
    SDKOAuthOtherUI.a(this.rlU).av(localLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.4
 * JD-Core Version:    0.7.0.1
 */