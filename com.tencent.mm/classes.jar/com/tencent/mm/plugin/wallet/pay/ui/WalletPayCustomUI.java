package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wallet_core.ui.s.b;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletPayCustomUI
  extends WalletBaseUI
{
  private esi DKb;
  protected s Oyr;
  private String Oys = "";
  private boolean Oyt = false;
  private int mScene = 0;
  private String mTitle = "";
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69364);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.Oys = getIntent().getStringExtra("INTENT_PAYFEE");
    this.mTitle = getIntent().getStringExtra("INTENT_TITLE");
    boolean bool;
    if (getIntent().getIntExtra("INTENT_CAN_TOUCH", 0) == 1) {
      bool = true;
    }
    for (;;)
    {
      this.Oyt = bool;
      paramBundle = getIntent().getByteArrayExtra("INTENT_TOKENMESS");
      this.DKb = new esi();
      try
      {
        this.DKb.parseFrom(paramBundle);
        Log.i("MicroMsg.WalletPayCustomUI", "mTokeMess packageex:%s busi_id:%s sign:%s can_use_touch %s mPayFee %s mTitle %s", new Object[] { this.DKb.Uuc, this.DKb.TaX, this.DKb.sign, Boolean.valueOf(this.Oyt), this.Oys, this.mTitle });
        this.Oyr = s.a(this, this.mTitle, this.Oys, "", this.Oyt, new s.b()new DialogInterface.OnCancelListener
        {
          public final void g(String paramAnonymousString1, boolean paramAnonymousBoolean, String paramAnonymousString2)
          {
            AppMethodBeat.i(69361);
            int j = WalletPayCustomUI.a(WalletPayCustomUI.this).Uud;
            String str1 = WalletPayCustomUI.a(WalletPayCustomUI.this).Uuc;
            String str2 = WalletPayCustomUI.a(WalletPayCustomUI.this).sign;
            String str3 = WalletPayCustomUI.a(WalletPayCustomUI.this).tyH;
            String str4 = WalletPayCustomUI.a(WalletPayCustomUI.this).TaX;
            if (paramAnonymousBoolean) {}
            for (int i = 1;; i = 0)
            {
              paramAnonymousString1 = new ac(paramAnonymousString1, j, str1, str2, str3, str4, i, paramAnonymousString2, "");
              WalletPayCustomUI.this.doSceneProgress(paramAnonymousString1, true);
              AppMethodBeat.o(69361);
              return;
            }
          }
        }, new DialogInterface.OnCancelListener()new s.a
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(69362);
            WalletPayCustomUI.this.finish();
            AppMethodBeat.o(69362);
          }
        }, new s.a()
        {
          public final void fli()
          {
            AppMethodBeat.i(69363);
            WalletPayCustomUI.this.finish();
            AppMethodBeat.o(69363);
          }
        });
        AppMethodBeat.o(69364);
        return;
        bool = false;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WalletPayCustomUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69367);
    super.onDestroy();
    AppMethodBeat.o(69367);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69366);
    super.onPause();
    AppMethodBeat.o(69366);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69365);
    super.onResume();
    AppMethodBeat.o(69365);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69368);
    Log.i("MicroMsg.WalletPayCustomUI", "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramq instanceof ac))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ac)paramq;
        paramq = new Intent();
        paramq.putExtra("INTENT_RESULT_TOKEN", paramString.OIv);
        paramq.putExtras(getIntent());
        setResult(-1, paramq);
      }
      finish();
    }
    AppMethodBeat.o(69368);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI
 * JD-Core Version:    0.7.0.1
 */