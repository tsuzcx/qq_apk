package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class WalletWXCreditOpenResultUI
  extends WalletBaseUI
{
  private CheckBox vII;
  
  private void arG()
  {
    AppMethodBeat.i(48747);
    getNetController().p(new Object[] { Boolean.valueOf(this.vII.isChecked()) });
    AppMethodBeat.o(48747);
  }
  
  public int getLayoutId()
  {
    return 2130971273;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48746);
    setMMTitle(2131305795);
    TextView localTextView = (TextView)findViewById(2131829434);
    this.vII = ((CheckBox)findViewById(2131829435));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    if (localBankcard != null)
    {
      this.vII.setText(getString(2131305797, new Object[] { localBankcard.field_bankName }));
      localTextView.setText(2131305798);
    }
    ((Button)findViewById(2131822914)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48744);
        WalletWXCreditOpenResultUI.a(WalletWXCreditOpenResultUI.this);
        AppMethodBeat.o(48744);
      }
    });
    AppMethodBeat.o(48746);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48745);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RL().Ru().set(196658, Boolean.TRUE);
    t.cTN().ulU = bo.aox();
    initView();
    AppMethodBeat.o(48745);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(48748);
    if (paramInt == 4)
    {
      arG();
      AppMethodBeat.o(48748);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(48748);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI
 * JD-Core Version:    0.7.0.1
 */