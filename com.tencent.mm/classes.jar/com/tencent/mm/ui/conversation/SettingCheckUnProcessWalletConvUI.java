package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI
  extends MMActivity
{
  private ListView fry;
  private int[] vQS = new int[2];
  private List<String> vUb;
  private SettingCheckUnProcessWalletConvUI.a vUc;
  
  protected final int getLayoutId()
  {
    return R.i.setting_check_wallet_unprocess_conv_list;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.wallet_conv_list_title);
    setBackBtn(new SettingCheckUnProcessWalletConvUI.1(this));
    this.fry = ((ListView)findViewById(R.h.conv_list));
    this.vUb = getIntent().getStringArrayListExtra("key_conversation_list");
    if ((this.vUb != null) && (this.vUb.size() > 0))
    {
      this.vUc = new SettingCheckUnProcessWalletConvUI.a(this);
      this.fry.setAdapter(this.vUc);
      this.fry.setOnTouchListener(new SettingCheckUnProcessWalletConvUI.2(this));
      this.fry.setOnItemClickListener(new SettingCheckUnProcessWalletConvUI.3(this));
      this.fry.setOnItemLongClickListener(new SettingCheckUnProcessWalletConvUI.4(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI
 * JD-Core Version:    0.7.0.1
 */