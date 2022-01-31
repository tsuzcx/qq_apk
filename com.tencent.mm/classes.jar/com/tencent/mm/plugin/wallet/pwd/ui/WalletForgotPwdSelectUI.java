package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletForgotPwdSelectUI
  extends WalletBaseUI
{
  private View qoH;
  private View qoI;
  
  private void bUw()
  {
    y.i("MicroMsg.WalletForgotPwdSelectUI", "goToBankcard");
    this.BX.putBoolean("key_select_bank_card", true);
    cNj().a(this, 0, this.BX);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_forgot_pwd_select_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.WalletForgotPwdSelectUI", "onActivityResult, requestCode: %s, resultCode: %s, data: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    int i = paramIntent.getIntExtra("err_code", 0);
    int j = paramIntent.getIntExtra("scene", 0);
    int k = paramIntent.getIntExtra("countFace", 0);
    long l = paramIntent.getLongExtra("totalTime", 0L);
    int m = paramIntent.getIntExtra("err_type", 6);
    y.i("MicroMsg.WalletForgotPwdSelectUI", "errCode： " + i);
    y.i("MicroMsg.WalletForgotPwdSelectUI", "scene： " + j);
    y.i("MicroMsg.WalletForgotPwdSelectUI", "countFace： " + k);
    y.i("MicroMsg.WalletForgotPwdSelectUI", "totalTime： " + l);
    y.i("MicroMsg.WalletForgotPwdSelectUI", "errorType： " + m);
    if (paramInt1 == 233)
    {
      if (paramInt2 != -1) {
        break label384;
      }
      y.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_OK");
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("token");
        if ((cNj() != null) && (!bk.bl(paramIntent)))
        {
          h.nFQ.f(15774, new Object[] { Integer.valueOf(cNj().kke.getInt("key_forgot_scene", 1)), Integer.valueOf(4) });
          h.nFQ.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i) });
        }
        this.BX.putString("key_face_action_result_token", paramIntent);
        this.BX.putBoolean("key_is_set_pwd_after_face_action", true);
        cNj().a(this, 0, this.BX);
        finish();
      }
    }
    return;
    label384:
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      paramIntent = paramIntent.getExtras().getString("click_other_verify_btn");
      if ((bk.bl(paramIntent)) || (!paramIntent.equalsIgnoreCase("yes"))) {
        break label695;
      }
    }
    label695:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      y.i("MicroMsg.WalletForgotPwdSelectUI", "isClickOtherVerify: %s", new Object[] { paramIntent });
      if (paramInt1 != 0)
      {
        y.i("MicroMsg.WalletForgotPwdSelectUI", "check face failed, click other verify");
        if (cNj() != null)
        {
          h.nFQ.f(15774, new Object[] { Integer.valueOf(cNj().kke.getInt("key_forgot_scene", 1)), Integer.valueOf(5) });
          h.nFQ.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(i) });
        }
        bUw();
      }
      if (paramInt2 != 0) {
        break;
      }
      y.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_CANCELED");
      if (cNj() == null) {
        break;
      }
      h.nFQ.f(15774, new Object[] { Integer.valueOf(cNj().kke.getInt("key_forgot_scene", 1)), Integer.valueOf(6) });
      h.nFQ.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ta(Color.parseColor("#FFFFFF"));
    czo();
    FP(8);
    this.qoH = findViewById(a.f.face_check_entry);
    this.qoI = findViewById(a.f.bankcard_entry);
    this.qoH.setOnClickListener(new WalletForgotPwdSelectUI.1(this));
    this.qoI.setOnClickListener(new WalletForgotPwdSelectUI.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI
 * JD-Core Version:    0.7.0.1
 */