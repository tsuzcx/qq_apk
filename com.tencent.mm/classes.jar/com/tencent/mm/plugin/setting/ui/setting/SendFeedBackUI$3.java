package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.base.h;

final class SendFeedBackUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SendFeedBackUI$3(SendFeedBackUI paramSendFeedBackUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127046);
    paramMenuItem = SendFeedBackUI.a(this.qGG).getText().toString().trim();
    if (paramMenuItem.length() > 0)
    {
      if (paramMenuItem.startsWith("//traceroute"))
      {
        SendFeedBackUI.a(this.qGG).setText("");
        d.H(this.qGG.getContext(), "traceroute", ".ui.NetworkDiagnoseIntroUI");
        AppMethodBeat.o(127046);
        return false;
      }
      paramMenuItem = new j(q.LO(), paramMenuItem + " key " + bs.dyO() + " local key " + bs.dyN() + "NetType:" + at.getNetTypeString(this.qGG.getApplicationContext()) + " hasNeon: " + n.Lu() + " isArmv6: " + n.Lw() + " isArmv7: " + n.Lv());
      g.Rc().a(153, this.qGG);
      g.Rc().a(paramMenuItem, 0);
      this.qGG.hideVKB();
      SendFeedBackUI localSendFeedBackUI1 = this.qGG;
      SendFeedBackUI localSendFeedBackUI2 = this.qGG;
      this.qGG.getString(2131297087);
      SendFeedBackUI.a(localSendFeedBackUI1, h.b(localSendFeedBackUI2, this.qGG.getString(2131297069), true, new SendFeedBackUI.3.1(this, paramMenuItem)));
    }
    AppMethodBeat.o(127046);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.3
 * JD-Core Version:    0.7.0.1
 */