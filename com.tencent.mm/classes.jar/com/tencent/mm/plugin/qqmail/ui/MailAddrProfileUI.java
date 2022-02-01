package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.e.j;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI
  extends MMPreference
{
  private String KbS;
  private boolean Noh;
  private String name;
  private f screen;
  
  public int getResourceId()
  {
    return e.j.mail_receiver_info;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123061);
    setMMTitle(e.i.invite_friend_title);
    this.screen = getPreferenceScreen();
    ((KeyValuePreference)this.screen.bAi("mail_receiver_info_name")).aS(this.name);
    ((KeyValuePreference)this.screen.bAi("mail_receiver_info_addr")).aS(getIntent().getStringExtra("addr"));
    Preference localPreference = this.screen.bAi("mail_compose_btn");
    if (!this.Noh) {
      this.screen.e(localPreference);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123059);
        MailAddrProfileUI.this.hideVKB();
        MailAddrProfileUI.this.finish();
        AppMethodBeat.o(123059);
        return true;
      }
    });
    AppMethodBeat.o(123061);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123060);
    super.onCreate(paramBundle);
    this.name = getIntent().getStringExtra("name");
    this.KbS = getIntent().getStringExtra("addr");
    this.Noh = getIntent().getBooleanExtra("can_compose", false);
    initView();
    AppMethodBeat.o(123060);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(123062);
    if (paramPreference.mKey.equals("mail_compose_btn"))
    {
      paramf = new Intent(this, ComposeUI.class);
      paramf.putExtra("composeType", 4);
      paramf.putExtra("toList", new String[] { this.name + " " + this.KbS });
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/qqmail/ui/MailAddrProfileUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrProfileUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
    }
    AppMethodBeat.o(123062);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrProfileUI
 * JD-Core Version:    0.7.0.1
 */