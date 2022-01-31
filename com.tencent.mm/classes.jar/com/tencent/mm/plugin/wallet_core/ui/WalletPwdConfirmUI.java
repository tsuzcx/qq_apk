package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@com.tencent.mm.ui.base.a(19)
public class WalletPwdConfirmUI
  extends WalletBaseUI
{
  private com.tencent.mm.sdk.b.c dZC;
  private TextView iJG;
  private TextView ksU;
  private PayInfo mPayInfo;
  protected EditHintPasswdView nID;
  private TextView ust;
  private boolean usu;
  private ap usv;
  
  public WalletPwdConfirmUI()
  {
    AppMethodBeat.i(47545);
    this.usu = false;
    this.usv = new ap(new WalletPwdConfirmUI.5(this), false);
    this.dZC = new WalletPwdConfirmUI.6(this);
    AppMethodBeat.o(47545);
  }
  
  private void cVR()
  {
    AppMethodBeat.i(47550);
    Bundle localBundle = getInput();
    localBundle.putBoolean("intent_bind_end", true);
    com.tencent.mm.wallet_core.a.j(this, localBundle);
    AppMethodBeat.o(47550);
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971252;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47547);
    this.iJG = ((TextView)findViewById(2131825031));
    this.ksU = ((TextView)findViewById(2131829086));
    if ((getProcess() != null) && ("ModifyPwdProcess".equals(getProcess().bzC()))) {
      this.iJG.setText(2131305305);
    }
    this.ksU.setText(2131305651);
    this.ust = ((TextView)findViewById(2131829399));
    if (!bo.aa(getTips(0))) {
      this.ust.setText(2131305656);
    }
    for (;;)
    {
      this.ust.setVisibility(0);
      this.ust.setOnClickListener(new WalletPwdConfirmUI.2(this));
      this.ust.setEnabled(false);
      this.ust.setClickable(false);
      this.nID = ((EditHintPasswdView)findViewById(2131825034));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.nID);
      this.nID.setEditTextMaxLength(6);
      this.nID.setOnInputValidListener(new WalletPwdConfirmUI.3(this));
      findViewById(2131826700).setVisibility(8);
      setEditFocusListener(this.nID, 0, false);
      setTenpayKBStateListener(new WalletPwdConfirmUI.4(this, (ScrollView)findViewById(2131820898)));
      AppMethodBeat.o(47547);
      return;
      this.ust.setText(2131296964);
    }
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47546);
    super.onCreate(paramBundle);
    hideTitleView();
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    initView();
    d.a(this, getInput(), 6);
    findViewById(2131829085).setOnClickListener(new WalletPwdConfirmUI.1(this));
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131690316));
      if (Build.VERSION.SDK_INT >= 23) {
        paramBundle.getDecorView().setSystemUiVisibility(8192);
      }
    }
    getContentView().setFitsSystemWindows(true);
    AppMethodBeat.o(47546);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(47549);
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.dZC);
    AppMethodBeat.o(47549);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47548);
    this.nID.requestFocus();
    super.onResume();
    com.tencent.mm.sdk.b.a.ymk.c(this.dZC);
    AppMethodBeat.o(47548);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47551);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      getInput().putString("key_pwd1", this.nID.getText());
      if ((paramm instanceof ab)) {
        if (!this.usu) {
          cVR();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(47551);
        return true;
        if ((com.tencent.mm.wallet_core.a.aM(this) != null) && (com.tencent.mm.wallet_core.a.aM(this).c(this, null)))
        {
          if (this.mPayInfo != null) {}
          for (paramString = this.mPayInfo.cnI;; paramString = "")
          {
            doSceneForceProgress(new ab(paramString, 22));
            paramString = new vn();
            if (com.tencent.mm.sdk.b.a.ymk.aq(paramString.getClass()))
            {
              this.usu = true;
              com.tencent.mm.sdk.b.a.ymk.l(paramString);
            }
            this.usv.ag(10000L, 10000L);
            break;
          }
        }
        com.tencent.mm.wallet_core.a.j(this, getInput());
      }
    }
    AppMethodBeat.o(47551);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI
 * JD-Core Version:    0.7.0.1
 */