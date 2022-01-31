package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.k;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI
  extends MMPreference
{
  private f dnn;
  private String lCF;
  private String name;
  private boolean nih;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if (paramPreference.mKey.equals("mail_compose_btn"))
    {
      paramf = new Intent(this, ComposeUI.class);
      paramf.putExtra("composeType", 4);
      paramf.putExtra("toList", new String[] { this.name + " " + this.lCF });
      startActivity(paramf);
      finish();
    }
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(b.j.invite_friend_title);
    this.dnn = this.vdd;
    ((KeyValuePreference)this.dnn.add("mail_receiver_info_name")).setSummary(this.name);
    ((KeyValuePreference)this.dnn.add("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
    Preference localPreference = this.dnn.add("mail_compose_btn");
    if (!this.nih) {
      this.dnn.c(localPreference);
    }
    setBackBtn(new MailAddrProfileUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.name = getIntent().getStringExtra("name");
    this.lCF = getIntent().getStringExtra("addr");
    this.nih = getIntent().getBooleanExtra("can_compose", false);
    initView();
  }
  
  public final int xj()
  {
    return b.k.mail_receiver_info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrProfileUI
 * JD-Core Version:    0.7.0.1
 */