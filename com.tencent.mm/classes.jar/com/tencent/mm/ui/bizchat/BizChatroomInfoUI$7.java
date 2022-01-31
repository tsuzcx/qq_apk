package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import com.tencent.mm.ai.a.h;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.z;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class BizChatroomInfoUI$7
  implements ContactListExpandPreference.a
{
  BizChatroomInfoUI$7(BizChatroomInfoUI paramBizChatroomInfoUI) {}
  
  public final void gh(int paramInt)
  {
    BizChatroomInfoUI.a(this.vfX, paramInt);
  }
  
  public final void gi(int paramInt)
  {
    boolean bool = true;
    j localj = this.vfX.GG(paramInt);
    if ((localj == null) || (bk.bl(localj.field_profileUrl)))
    {
      if (localj == null) {}
      for (;;)
      {
        y.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
        return;
        bool = false;
      }
    }
    y.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { localj.field_profileUrl });
    z.MG();
    h.a(localj.field_userId, localj.field_brandUserName, this.vfX);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", localj.field_profileUrl);
    localIntent.putExtra("useJs", true);
    d.b(this.vfX.mController.uMN, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  public final void gj(int paramInt)
  {
    BizChatroomInfoUI.c(this.vfX);
  }
  
  public final void xy()
  {
    if (BizChatroomInfoUI.b(this.vfX) != null) {
      BizChatroomInfoUI.b(this.vfX).cmP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.7
 * JD-Core Version:    0.7.0.1
 */