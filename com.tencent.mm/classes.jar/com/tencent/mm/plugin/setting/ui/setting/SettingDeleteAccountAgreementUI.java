package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountAgreementUI
  extends MMActivity
{
  protected final int getLayoutId()
  {
    return a.g.setting_delete_account_agreement_ui;
  }
  
  protected final void initView()
  {
    TextView localTextView = (TextView)findViewById(a.f.next_btn);
    localTextView.setOnClickListener(new SettingDeleteAccountAgreementUI.1(this));
    CheckedTextView localCheckedTextView = (CheckedTextView)findViewById(a.f.agreement_cb);
    localCheckedTextView.setOnClickListener(new SettingDeleteAccountAgreementUI.2(this, localTextView, localCheckedTextView));
    localTextView.setEnabled(localCheckedTextView.isChecked());
    setBackBtn(new SettingDeleteAccountAgreementUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.setting_del_account_title);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI
 * JD-Core Version:    0.7.0.1
 */