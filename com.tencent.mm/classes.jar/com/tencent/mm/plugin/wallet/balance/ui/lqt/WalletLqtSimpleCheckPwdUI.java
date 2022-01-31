package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(1)
public class WalletLqtSimpleCheckPwdUI
  extends WalletBaseUI
{
  private EditHintPasswdView nID;
  private u tSm;
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(45713);
    super.cleanUiData(paramInt);
    if (this.nID != null) {
      this.nID.cfK();
    }
    AppMethodBeat.o(45713);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971203;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45711);
    super.onCreate(paramBundle);
    if (r.ZB()) {}
    for (paramBundle = getString(2131305015);; paramBundle = getString(2131305013))
    {
      setMMTitle(paramBundle);
      setBackBtn(new WalletLqtSimpleCheckPwdUI.1(this));
      ((TextView)findViewById(2131828908)).setText(2131305011);
      this.nID = ((EditHintPasswdView)findViewById(2131825034));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.nID);
      this.nID.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(45710);
          if (paramAnonymousBoolean)
          {
            WalletLqtSimpleCheckPwdUI.a(WalletLqtSimpleCheckPwdUI.this, new u(WalletLqtSimpleCheckPwdUI.a(WalletLqtSimpleCheckPwdUI.this).getText(), 7, WalletLqtSimpleCheckPwdUI.this.getPayReqKey()));
            WalletLqtSimpleCheckPwdUI.this.doSceneForceProgress(WalletLqtSimpleCheckPwdUI.b(WalletLqtSimpleCheckPwdUI.this));
          }
          AppMethodBeat.o(45710);
        }
      });
      setEditFocusListener(this.nID, 0, false);
      AppMethodBeat.o(45711);
      return;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45712);
    ab.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof u))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.nID.getText();
        paramm = new Intent();
        paramm.putExtra("lqt_enc_pwd", paramString);
        setResult(-1, paramm);
        finish();
        AppMethodBeat.o(45712);
        return true;
      }
      if (this.nID != null) {
        this.nID.cfK();
      }
    }
    AppMethodBeat.o(45712);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSimpleCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */