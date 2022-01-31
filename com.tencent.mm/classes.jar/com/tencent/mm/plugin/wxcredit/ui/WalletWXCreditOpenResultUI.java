package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class WalletWXCreditOpenResultUI
  extends WalletBaseUI
{
  private CheckBox rRS;
  
  private void XX()
  {
    cNk().m(new Object[] { Boolean.valueOf(this.rRS.isChecked()) });
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_wxcredit_open_result_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_wxcredit_open_result_title);
    TextView localTextView = (TextView)findViewById(a.f.wallet_wxcredit_open_tips);
    this.rRS = ((CheckBox)findViewById(a.f.attention_cb));
    Bankcard localBankcard = (Bankcard)this.BX.getParcelable("key_bankcard");
    if (localBankcard != null)
    {
      this.rRS.setText(getString(a.i.wallet_wxcredit_open_result_wait_attention, new Object[] { localBankcard.field_bankName }));
      localTextView.setText(a.i.wallet_wxcredit_open_result_wait_tips);
    }
    ((Button)findViewById(a.f.next_btn)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        WalletWXCreditOpenResultUI.a(WalletWXCreditOpenResultUI.this);
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().o(196658, Boolean.valueOf(true));
    o.bVs().qzk = bk.UX();
    initView();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      XX();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI
 * JD-Core Version:    0.7.0.1
 */