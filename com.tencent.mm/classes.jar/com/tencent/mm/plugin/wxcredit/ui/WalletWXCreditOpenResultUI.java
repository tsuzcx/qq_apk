package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class WalletWXCreditOpenResultUI
  extends WalletBaseUI
{
  private CheckBox XIF;
  
  private void bYw()
  {
    AppMethodBeat.i(72390);
    getNetController().t(new Object[] { Boolean.valueOf(this.XIF.isChecked()) });
    AppMethodBeat.o(72390);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_wxcredit_open_result_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72389);
    setMMTitle(a.i.wallet_wxcredit_open_result_title);
    TextView localTextView = (TextView)findViewById(a.f.wallet_wxcredit_open_tips);
    this.XIF = ((CheckBox)findViewById(a.f.attention_cb));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    if (localBankcard != null)
    {
      this.XIF.setText(getString(a.i.wallet_wxcredit_open_result_wait_attention, new Object[] { localBankcard.field_bankName }));
      localTextView.setText(a.i.wallet_wxcredit_open_result_wait_tips);
    }
    ((Button)findViewById(a.f.next_btn)).setOnClickListener(new WalletWXCreditOpenResultUI.1(this));
    AppMethodBeat.o(72389);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72388);
    super.onCreate(paramBundle);
    h.baF();
    h.baE().ban().B(196658, Boolean.TRUE);
    u.iiC().VKk = Util.nowSecond();
    initView();
    AppMethodBeat.o(72388);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(72391);
    if (paramInt == 4)
    {
      bYw();
      AppMethodBeat.o(72391);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(72391);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI
 * JD-Core Version:    0.7.0.1
 */