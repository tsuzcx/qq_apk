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
  private f screen;
  private String tWE;
  private boolean vYw;
  
  public int getResourceId()
  {
    return 2131951689;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123061);
    setMMTitle(2131760357);
    this.screen = getPreferenceScreen();
    ((KeyValuePreference)this.screen.aPN("mail_receiver_info_name")).setSummary(this.name);
    ((KeyValuePreference)this.screen.aPN("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
    Preference localPreference = this.screen.aPN("mail_compose_btn");
    if (!this.vYw) {
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
    this.tWE = getIntent().getStringExtra("addr");
    this.vYw = getIntent().getBooleanExtra("can_compose", false);
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
      paramf.putExtra("toList", new String[] { this.name + " " + this.tWE });
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/qqmail/ui/MailAddrProfileUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrProfileUI
 * JD-Core Version:    0.7.0.1
 */