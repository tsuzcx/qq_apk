package com.tencent.mm.plugin.qqmail.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.tools.n.b;
import java.util.List;

final class MailAddrListUI$2
  implements n.b
{
  MailAddrListUI$2(MailAddrListUI paramMailAddrListUI) {}
  
  public final void Wl() {}
  
  public final void Wm() {}
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  public final boolean pB(String paramString)
  {
    return false;
  }
  
  public final void pC(String paramString)
  {
    paramString = bk.aM(paramString, "");
    MailAddrListUI.a(this.nia, MailAddrListUI.b(this.nia).Li(paramString.toLowerCase().trim()));
    if (paramString.length() > 0)
    {
      MailAddrListUI.e(this.nia).nic = true;
      MailAddrListUI.e(this.nia).nib = false;
      if (MailAddrListUI.c(this.nia).size() != 0) {
        break label120;
      }
      this.nia.enableOptionMenu(false);
      MailAddrListUI.f(this.nia).setVisibility(0);
    }
    for (;;)
    {
      MailAddrListUI.e(this.nia).notifyDataSetChanged();
      return;
      MailAddrListUI.e(this.nia).nic = false;
      break;
      label120:
      this.nia.enableOptionMenu(true);
      MailAddrListUI.f(this.nia).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.2
 * JD-Core Version:    0.7.0.1
 */