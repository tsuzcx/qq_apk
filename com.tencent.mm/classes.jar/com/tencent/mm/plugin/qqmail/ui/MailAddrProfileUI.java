package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI
  extends MMPreference
{
  private String name;
  private String sOr;
  private f screen;
  private boolean uPG;
  
  public int getResourceId()
  {
    return 2131951689;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123061);
    setMMTitle(2131760357);
    this.screen = getPreferenceScreen();
    ((KeyValuePreference)this.screen.aKk("mail_receiver_info_name")).setSummary(this.name);
    ((KeyValuePreference)this.screen.aKk("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
    Preference localPreference = this.screen.aKk("mail_compose_btn");
    if (!this.uPG) {
      this.screen.d(localPreference);
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
    this.sOr = getIntent().getStringExtra("addr");
    this.uPG = getIntent().getBooleanExtra("can_compose", false);
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
      paramf.putExtra("toList", new String[] { this.name + " " + this.sOr });
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/qqmail/ui/MailAddrProfileUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrProfileUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrProfileUI
 * JD-Core Version:    0.7.0.1
 */