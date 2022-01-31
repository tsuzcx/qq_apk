package com.tencent.mm.plugin.sport.ui;

import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.storage.bd;
import java.util.List;

final class SportBlackListUI$2
  implements ContactListExpandPreference.a
{
  SportBlackListUI$2(SportBlackListUI paramSportBlackListUI) {}
  
  public final void gh(int paramInt)
  {
    String str = SportBlackListUI.a(this.ptR).Ed(paramInt);
    SportBlackListUI.b(this.ptR).remove(str);
    SportBlackListUI.a(this.ptR).s(null, SportBlackListUI.b(this.ptR));
    SportBlackListUI.a(this.ptR).refresh();
    au.Hx();
    s.h(c.Fw().abl(str));
    com.tencent.mm.plugin.sport.b.d.jdMethod_if(40);
  }
  
  public final void gi(int paramInt)
  {
    String str = SportBlackListUI.a(this.ptR).Ed(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", str);
    com.tencent.mm.br.d.b(this.ptR, "profile", ".ui.ContactInfoUI", localIntent);
  }
  
  public final void gj(int paramInt)
  {
    SportBlackListUI.c(this.ptR);
  }
  
  public final void xy()
  {
    SportBlackListUI.a(this.ptR).cmP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportBlackListUI.2
 * JD-Core Version:    0.7.0.1
 */