package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenUI
  extends WalletBaseUI
{
  private Button iwY;
  private Bankcard zNT;
  
  public int getLayoutId()
  {
    return 2131496051;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72397);
    setMMTitle(2131766021);
    ((CheckBox)findViewById(2131296518)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72393);
        WalletWXCreditOpenUI.a(WalletWXCreditOpenUI.this).setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(72393);
      }
    });
    findViewById(2131296513).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72394);
        e.b(WalletWXCreditOpenUI.this, WalletWXCreditOpenUI.b(WalletWXCreditOpenUI.this).field_bankcardType, WalletWXCreditOpenUI.b(WalletWXCreditOpenUI.this).field_bankName, true, false);
        AppMethodBeat.o(72394);
      }
    });
    this.iwY = ((Button)findViewById(2131302852));
    this.iwY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72395);
        WalletWXCreditOpenUI.this.next();
        AppMethodBeat.o(72395);
      }
    });
    AppMethodBeat.o(72397);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72396);
    super.onCreate(paramBundle);
    this.zNT = ((Bankcard)getInput().getParcelable("key_bankcard"));
    initView();
    AppMethodBeat.o(72396);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI
 * JD-Core Version:    0.7.0.1
 */