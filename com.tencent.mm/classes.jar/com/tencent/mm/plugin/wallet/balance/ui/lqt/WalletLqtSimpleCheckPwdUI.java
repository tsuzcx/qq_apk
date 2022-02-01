package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(1)
public class WalletLqtSimpleCheckPwdUI
  extends WalletBaseUI
{
  private w HCq;
  private EditHintPasswdView ykY;
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69050);
    super.cleanUiData(paramInt);
    if (this.ykY != null) {
      this.ykY.eIj();
    }
    AppMethodBeat.o(69050);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496959;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69048);
    super.onCreate(paramBundle);
    if (z.aUo()) {}
    for (paramBundle = getString(2131767650);; paramBundle = getString(2131767648))
    {
      setMMTitle(paramBundle);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69046);
          WalletLqtSimpleCheckPwdUI.this.finish();
          AppMethodBeat.o(69046);
          return false;
        }
      });
      ((TextView)findViewById(2131302684)).setText(2131767646);
      this.ykY = ((EditHintPasswdView)findViewById(2131302674));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.ykY);
      this.ykY.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(69047);
          if (paramAnonymousBoolean)
          {
            WalletLqtSimpleCheckPwdUI.a(WalletLqtSimpleCheckPwdUI.this, new w(WalletLqtSimpleCheckPwdUI.a(WalletLqtSimpleCheckPwdUI.this).getText(), 7, WalletLqtSimpleCheckPwdUI.this.getPayReqKey()));
            WalletLqtSimpleCheckPwdUI.this.doSceneForceProgress(WalletLqtSimpleCheckPwdUI.b(WalletLqtSimpleCheckPwdUI.this));
          }
          AppMethodBeat.o(69047);
        }
      });
      setEditFocusListener(this.ykY, 0, false);
      AppMethodBeat.o(69048);
      return;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69049);
    Log.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof w))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.ykY.getText();
        paramq = new Intent();
        paramq.putExtra("lqt_enc_pwd", paramString);
        setResult(-1, paramq);
        finish();
        AppMethodBeat.o(69049);
        return true;
      }
      if (this.ykY != null) {
        this.ykY.eIj();
      }
    }
    AppMethodBeat.o(69049);
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