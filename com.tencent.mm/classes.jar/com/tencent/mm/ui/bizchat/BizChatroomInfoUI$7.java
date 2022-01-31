package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.h;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.z;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class BizChatroomInfoUI$7
  implements ContactListExpandPreference.a
{
  BizChatroomInfoUI$7(BizChatroomInfoUI paramBizChatroomInfoUI) {}
  
  public final void JR()
  {
    AppMethodBeat.i(30205);
    if (BizChatroomInfoUI.b(this.zuv) != null) {
      BizChatroomInfoUI.b(this.zuv).dnF();
    }
    AppMethodBeat.o(30205);
  }
  
  public final void iw(int paramInt)
  {
    AppMethodBeat.i(30203);
    BizChatroomInfoUI.a(this.zuv, paramInt);
    AppMethodBeat.o(30203);
  }
  
  public final void ix(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(30204);
    j localj = this.zuv.Pa(paramInt);
    if ((localj == null) || (bo.isNullOrNil(localj.field_profileUrl)))
    {
      if (localj == null) {}
      for (;;)
      {
        ab.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(30204);
        return;
        bool = false;
      }
    }
    ab.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { localj.field_profileUrl });
    z.afq();
    h.a(localj.field_userId, localj.field_brandUserName, this.zuv);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", localj.field_profileUrl);
    localIntent.putExtra("useJs", true);
    d.b(this.zuv.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(30204);
  }
  
  public final void iy(int paramInt)
  {
    AppMethodBeat.i(30206);
    BizChatroomInfoUI.c(this.zuv);
    AppMethodBeat.o(30206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.7
 * JD-Core Version:    0.7.0.1
 */