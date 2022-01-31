package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p.a;
import java.util.Iterator;
import java.util.List;

final class MailAddrListUI$1
  extends p.a
{
  MailAddrListUI$1(MailAddrListUI paramMailAddrListUI) {}
  
  public final void onComplete()
  {
    if (MailAddrListUI.a(this.nia) != null) {
      MailAddrListUI.a(this.nia).dismiss();
    }
    MailAddrListUI.a(this.nia, MailAddrListUI.b(this.nia).Li(null));
    if (MailAddrListUI.c(this.nia).size() == 0)
    {
      MailAddrListUI.d(this.nia).setText(b.j.settings_recommend_no_mail_contact);
      MailAddrListUI.d(this.nia).setVisibility(0);
    }
    Object localObject1 = this.nia.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
    if (localObject1 == null) {
      localObject1 = new String[] { "" };
    }
    for (;;)
    {
      int k = localObject1.length;
      int i = 0;
      Object localObject2;
      Object localObject3;
      if (i < k)
      {
        localObject2 = com.tencent.mm.plugin.qqmail.b.p.Lj(localObject1[i]);
        if (localObject2 != null)
        {
          localObject3 = MailAddrListUI.c(this.nia).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            o localo = (o)((Iterator)localObject3).next();
            if (localo.lCF.equalsIgnoreCase(((o)localObject2).lCF)) {
              MailAddrListUI.e(this.nia).c(localo);
            }
          }
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          MailAddrListUI.e(this.nia).c((o)localObject2);
        }
        i += 1;
        break;
        localObject2 = this.nia;
        localObject3 = new StringBuilder().append(this.nia.getString(b.j.plugin_qqmail_addrlist_title));
        if (MailAddrListUI.e(this.nia).bug() > 0) {}
        for (localObject1 = "(" + MailAddrListUI.e(this.nia).bug() + ")";; localObject1 = "")
        {
          ((MailAddrListUI)localObject2).setMMTitle((String)localObject1);
          MailAddrListUI.e(this.nia).notifyDataSetChanged();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.1
 * JD-Core Version:    0.7.0.1
 */