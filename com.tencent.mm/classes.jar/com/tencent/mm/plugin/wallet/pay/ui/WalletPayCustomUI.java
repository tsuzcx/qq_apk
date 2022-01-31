package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletPayCustomUI
  extends WalletBaseUI
{
  private int fzn = 0;
  private bya lkj;
  private String mTitle = "";
  protected n qmR;
  private String qmS = "";
  private boolean qmT = false;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletPayCustomUI", "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof w))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (w)paramm;
        paramm = new Intent();
        paramm.putExtra("INTENT_RESULT_TOKEN", paramString.qrc);
        setResult(-1, paramm);
      }
      finish();
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(8);
    this.qmS = getIntent().getStringExtra("INTENT_PAYFEE");
    this.mTitle = getIntent().getStringExtra("INTENT_TITLE");
    boolean bool;
    if (getIntent().getIntExtra("INTENT_CAN_TOUCH", 0) == 1) {
      bool = true;
    }
    for (;;)
    {
      this.qmT = bool;
      paramBundle = getIntent().getByteArrayExtra("INTENT_TOKENMESS");
      this.lkj = new bya();
      try
      {
        this.lkj.aH(paramBundle);
        y.i("MicroMsg.WalletPayCustomUI", "mTokeMess packageex:%s busi_id:%s sign:%s can_use_touch %s mPayFee %s mTitle %s", new Object[] { this.lkj.tNW, this.lkj.taA, this.lkj.sign, Boolean.valueOf(this.qmT), this.qmS, this.mTitle });
        this.qmR = n.a(this, this.mTitle, this.qmS, "", this.qmT, new WalletPayCustomUI.1(this), new WalletPayCustomUI.2(this), new WalletPayCustomUI.3(this));
        return;
        bool = false;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.WalletPayCustomUI", paramBundle, "", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI
 * JD-Core Version:    0.7.0.1
 */