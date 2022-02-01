package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.base.a(1)
public class WalletLqtSimpleCheckPwdUI
  extends WalletBaseUI
{
  private TextView Oug;
  private TextView Ouh;
  private EditHintPasswdView Oui;
  private x Ouj;
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69050);
    super.cleanUiData(paramInt);
    if (this.Oui != null) {
      this.Oui.fuo();
    }
    AppMethodBeat.o(69050);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_check_pwd;
  }
  
  public void initView()
  {
    AppMethodBeat.i(275425);
    this.Oug = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.Ouh = ((TextView)findViewById(a.f.wallet_pwd_content));
    this.Oui = ((EditHintPasswdView)findViewById(a.f.input_et));
    g.N(this.Oug);
    this.Oug.setTextSize(1, 22.0F);
    this.Ouh.setTextSize(1, 17.0F);
    hideKeyboardPushDownBtn();
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Oui);
    this.Oui.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69047);
        Log.i("MicroMsg.WalletLqtSimpleCheckPwdUI", "input isValid: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          WalletLqtSimpleCheckPwdUI.a(WalletLqtSimpleCheckPwdUI.this, new x(WalletLqtSimpleCheckPwdUI.a(WalletLqtSimpleCheckPwdUI.this).getText(), 7, WalletLqtSimpleCheckPwdUI.this.getPayReqKey()));
          WalletLqtSimpleCheckPwdUI.this.doSceneForceProgress(WalletLqtSimpleCheckPwdUI.b(WalletLqtSimpleCheckPwdUI.this));
        }
        AppMethodBeat.o(69047);
      }
    });
    this.Ouh.setText(a.i.wallet_lqt_plan_checkpwd_close_text);
    setEditFocusListener(this.Oui, 0, false);
    showTenpayKB();
    AppMethodBeat.o(275425);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69048);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.c.white));
    overridePendingTransition(a.a.sight_slide_bottom_in, a.a.sight_slide_bottom_out);
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
    initView();
    AppMethodBeat.o(69048);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69049);
    Log.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof x))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.Oui.getText();
        paramq = new Intent();
        paramq.putExtra("lqt_enc_pwd", paramString);
        setResult(-1, paramq);
        finish();
        AppMethodBeat.o(69049);
        return true;
      }
      if (this.Oui != null) {
        this.Oui.fuo();
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