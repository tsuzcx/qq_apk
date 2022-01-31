package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI
  extends MMPreference
{
  private String nZR;
  private String name;
  private boolean pNu;
  private f screen;
  
  public int getResourceId()
  {
    return 2131165247;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68335);
    setMMTitle(2131300756);
    this.screen = getPreferenceScreen();
    ((KeyValuePreference)this.screen.atx("mail_receiver_info_name")).setSummary(this.name);
    ((KeyValuePreference)this.screen.atx("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
    Preference localPreference = this.screen.atx("mail_compose_btn");
    if (!this.pNu) {
      this.screen.d(localPreference);
    }
    setBackBtn(new MailAddrProfileUI.1(this));
    AppMethodBeat.o(68335);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68334);
    super.onCreate(paramBundle);
    this.name = getIntent().getStringExtra("name");
    this.nZR = getIntent().getStringExtra("addr");
    this.pNu = getIntent().getBooleanExtra("can_compose", false);
    initView();
    AppMethodBeat.o(68334);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(68336);
    if (paramPreference.mKey.equals("mail_compose_btn"))
    {
      paramf = new Intent(this, ComposeUI.class);
      paramf.putExtra("composeType", 4);
      paramf.putExtra("toList", new String[] { this.name + " " + this.nZR });
      startActivity(paramf);
      finish();
    }
    AppMethodBeat.o(68336);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrProfileUI
 * JD-Core Version:    0.7.0.1
 */