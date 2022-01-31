package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class SDKOAuthOtherUI$5
  implements b
{
  SDKOAuthOtherUI$5(SDKOAuthOtherUI paramSDKOAuthOtherUI, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void kK(int paramInt)
  {
    AppMethodBeat.i(153185);
    ab.i("MicroMsg.SDKOAuthOtherUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      SDKOAuthOtherUI.d(this.vbx).JU(-4);
      AppMethodBeat.o(153185);
      return;
    }
    LinkedList localLinkedList;
    if (this.vbA == 7)
    {
      SDKOAuthOtherUI.a locala = SDKOAuthOtherUI.e(this.vbx);
      localLinkedList = new LinkedList();
      paramInt = 0;
      while (paramInt < locala.vbB.size())
      {
        bgv localbgv = (bgv)locala.vbB.get(paramInt);
        if ((localbgv.xwa == 2) || (localbgv.xwa == 3)) {
          localLinkedList.add(localbgv.scope);
        }
        paramInt += 1;
      }
    }
    while ((this.vbu != -2) && (this.vbv != -2)) {
      if ((this.vbu == 8) && (this.vbv == 8) && (this.vbA == 8))
      {
        SDKOAuthOtherUI.d(this.vbx).JU(-4);
        AppMethodBeat.o(153185);
        return;
        localLinkedList = new LinkedList();
      }
      else
      {
        if (this.vbv == 7) {
          localLinkedList.add("snsapi_friend");
        }
        SDKOAuthOtherUI.f(this.vbx);
        if (this.vbu == 7)
        {
          SDKOAuthOtherUI.d(this.vbx);
          ai.a(SDKOAuthOtherUI.g(this.vbx), localLinkedList);
          if (SDKOAuthOtherUI.h(this.vbx) == -1) {
            ab.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
          }
          if (SDKOAuthOtherUI.i(this.vbx))
          {
            SDKOAuthOtherUI.d(this.vbx);
            ai.a(localLinkedList, SDKOAuthOtherUI.h(this.vbx), SDKOAuthOtherUI.j(this.vbx));
            AppMethodBeat.o(153185);
            return;
          }
          SDKOAuthOtherUI.d(this.vbx).h(localLinkedList, SDKOAuthOtherUI.h(this.vbx));
          AppMethodBeat.o(153185);
          return;
        }
        if (SDKOAuthOtherUI.i(this.vbx))
        {
          SDKOAuthOtherUI.d(this.vbx);
          ai.a(localLinkedList, 0, SDKOAuthOtherUI.j(this.vbx));
          AppMethodBeat.o(153185);
          return;
        }
        SDKOAuthOtherUI.d(this.vbx).aG(localLinkedList);
        AppMethodBeat.o(153185);
        return;
      }
    }
    if (this.vbu != -2)
    {
      if ((this.vbu == 8) && (this.vbA == 8))
      {
        SDKOAuthOtherUI.d(this.vbx).JU(-4);
        AppMethodBeat.o(153185);
        return;
      }
      SDKOAuthOtherUI.f(this.vbx);
      if (this.vbu == 7)
      {
        SDKOAuthOtherUI.d(this.vbx);
        ai.a(SDKOAuthOtherUI.g(this.vbx), localLinkedList);
        if (SDKOAuthOtherUI.h(this.vbx) == -1) {
          ab.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
        }
        if (SDKOAuthOtherUI.i(this.vbx))
        {
          SDKOAuthOtherUI.d(this.vbx);
          ai.a(localLinkedList, SDKOAuthOtherUI.h(this.vbx), SDKOAuthOtherUI.j(this.vbx));
          AppMethodBeat.o(153185);
          return;
        }
        SDKOAuthOtherUI.d(this.vbx).h(localLinkedList, SDKOAuthOtherUI.h(this.vbx));
        AppMethodBeat.o(153185);
        return;
      }
      if (SDKOAuthOtherUI.i(this.vbx))
      {
        SDKOAuthOtherUI.d(this.vbx);
        ai.a(localLinkedList, SDKOAuthOtherUI.h(this.vbx), SDKOAuthOtherUI.j(this.vbx));
        AppMethodBeat.o(153185);
        return;
      }
      SDKOAuthOtherUI.d(this.vbx).aG(localLinkedList);
      AppMethodBeat.o(153185);
      return;
    }
    if (this.vbv != -2)
    {
      if ((this.vbv == 8) && (this.vbA == 8))
      {
        SDKOAuthOtherUI.d(this.vbx).JU(-4);
        AppMethodBeat.o(153185);
        return;
      }
      SDKOAuthOtherUI.f(this.vbx);
      if (this.vbv == 7) {
        localLinkedList.add("snsapi_friend");
      }
      if (SDKOAuthOtherUI.i(this.vbx))
      {
        SDKOAuthOtherUI.d(this.vbx);
        ai.a(localLinkedList, SDKOAuthOtherUI.h(this.vbx), SDKOAuthOtherUI.j(this.vbx));
        AppMethodBeat.o(153185);
        return;
      }
      SDKOAuthOtherUI.d(this.vbx).aG(localLinkedList);
      AppMethodBeat.o(153185);
      return;
    }
    if (this.vbA == 8)
    {
      SDKOAuthOtherUI.d(this.vbx).JU(-4);
      AppMethodBeat.o(153185);
      return;
    }
    SDKOAuthOtherUI.f(this.vbx);
    if (SDKOAuthOtherUI.i(this.vbx))
    {
      SDKOAuthOtherUI.d(this.vbx);
      ai.a(localLinkedList, SDKOAuthOtherUI.h(this.vbx), SDKOAuthOtherUI.j(this.vbx));
      AppMethodBeat.o(153185);
      return;
    }
    SDKOAuthOtherUI.d(this.vbx).aG(localLinkedList);
    AppMethodBeat.o(153185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.5
 * JD-Core Version:    0.7.0.1
 */