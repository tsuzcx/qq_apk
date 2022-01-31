package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class SendFeedBackUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SendFeedBackUI$3(SendFeedBackUI paramSendFeedBackUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = SendFeedBackUI.a(this.nSI).getText().toString().trim();
    if (paramMenuItem.length() > 0)
    {
      if (paramMenuItem.startsWith("//traceroute"))
      {
        SendFeedBackUI.a(this.nSI).setText("");
        d.x(this.nSI.mController.uMN, "traceroute", ".ui.NetworkDiagnoseIntroUI");
      }
    }
    else {
      return false;
    }
    paramMenuItem = new j(q.zv(), paramMenuItem + " key " + bs.cwc() + " local key " + bs.cwb() + "NetType:" + aq.getNetTypeString(this.nSI.getApplicationContext()) + " hasNeon: " + n.yX() + " isArmv6: " + n.yZ() + " isArmv7: " + n.yY());
    g.Dk().a(153, this.nSI);
    g.Dk().a(paramMenuItem, 0);
    this.nSI.XM();
    SendFeedBackUI localSendFeedBackUI1 = this.nSI;
    SendFeedBackUI localSendFeedBackUI2 = this.nSI;
    this.nSI.getString(a.i.app_tip);
    SendFeedBackUI.a(localSendFeedBackUI1, h.b(localSendFeedBackUI2, this.nSI.getString(a.i.app_sending), true, new SendFeedBackUI.3.1(this, paramMenuItem)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.3
 * JD-Core Version:    0.7.0.1
 */