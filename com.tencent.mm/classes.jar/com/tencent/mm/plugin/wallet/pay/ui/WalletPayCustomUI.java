package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletPayCustomUI
  extends WalletBaseUI
{
  private int mScene = 0;
  private String mTitle = "";
  private ckm nHF;
  protected p tWi;
  private String tWj = "";
  private boolean tWk = false;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46012);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.tWj = getIntent().getStringExtra("INTENT_PAYFEE");
    this.mTitle = getIntent().getStringExtra("INTENT_TITLE");
    boolean bool;
    if (getIntent().getIntExtra("INTENT_CAN_TOUCH", 0) == 1) {
      bool = true;
    }
    for (;;)
    {
      this.tWk = bool;
      paramBundle = getIntent().getByteArrayExtra("INTENT_TOKENMESS");
      this.nHF = new ckm();
      try
      {
        this.nHF.parseFrom(paramBundle);
        ab.i("MicroMsg.WalletPayCustomUI", "mTokeMess packageex:%s busi_id:%s sign:%s can_use_touch %s mPayFee %s mTitle %s", new Object[] { this.nHF.xUr, this.nHF.wYQ, this.nHF.sign, Boolean.valueOf(this.tWk), this.tWj, this.mTitle });
        this.tWi = p.a(this, this.mTitle, this.tWj, "", this.tWk, new WalletPayCustomUI.1(this), new WalletPayCustomUI.2(this), new WalletPayCustomUI.3(this));
        AppMethodBeat.o(46012);
        return;
        bool = false;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WalletPayCustomUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46015);
    super.onDestroy();
    AppMethodBeat.o(46015);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(46014);
    super.onPause();
    AppMethodBeat.o(46014);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46013);
    super.onResume();
    AppMethodBeat.o(46013);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46016);
    ab.i("MicroMsg.WalletPayCustomUI", "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof z))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (z)paramm;
        paramm = new Intent();
        paramm.putExtra("INTENT_RESULT_TOKEN", paramString.ubZ);
        paramm.putExtras(getIntent());
        setResult(-1, paramm);
      }
      finish();
    }
    AppMethodBeat.o(46016);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI
 * JD-Core Version:    0.7.0.1
 */