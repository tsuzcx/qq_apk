package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletCheckIdentityUI
  extends WalletBaseUI
{
  private WalletFormView tZx;
  private WalletFormView unh;
  private String vHZ;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971268;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48683);
    setMMTitle(2131305000);
    this.unh = ((WalletFormView)findViewById(2131829013));
    a.e(this, this.unh);
    this.tZx = ((WalletFormView)findViewById(2131829052));
    a.c(this.tZx);
    setEditFocusListener(this.tZx, 1, false);
    String str = getInput().getString("key_pre_name");
    this.vHZ = getInput().getString("key_pre_indentity");
    if (!bo.isNullOrNil(str))
    {
      this.unh.getPrefilledTv().setText(str);
      this.unh.setHint(getString(2131304989));
    }
    if (!bo.isNullOrNil(this.vHZ))
    {
      this.tZx.setMaxInputLength(4);
      this.tZx.getPrefilledTv().setText(this.vHZ);
      this.tZx.setHint(getString(2131304943));
    }
    findViewById(2131822914).setOnClickListener(new WalletCheckIdentityUI.1(this));
    AppMethodBeat.o(48683);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48682);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(48682);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI
 * JD-Core Version:    0.7.0.1
 */