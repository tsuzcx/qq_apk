package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class RemittanceResendMsgUI
  extends WalletBaseUI
{
  protected void f(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(45111);
    paramString1 = new y(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    paramString1.setProcessName("RemittanceProcess");
    doSceneProgress(paramString1);
    AppMethodBeat.o(45111);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45110);
    super.onCreate(paramBundle);
    getContentView().setVisibility(8);
    setTitleVisibility(8);
    paramBundle = getIntent().getStringExtra("transaction_id");
    String str1 = getIntent().getStringExtra("transfer_id");
    String str2 = getIntent().getStringExtra("receiver_name");
    int i = getIntent().getIntExtra("resend_msg_from_flag", 1);
    int j = getIntent().getIntExtra("invalid_time", 0);
    if (!bo.isNullOrNil(str2))
    {
      f(paramBundle, str1, str2, j, i);
      AppMethodBeat.o(45110);
      return;
    }
    ab.i("MicroMsg.RemittanceResendMsgUI", "onCreate() receiverName == null");
    AppMethodBeat.o(45110);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45112);
    ab.i("MicroMsg.RemittanceResendMsgUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramm.getType());
    if ((paramm instanceof y))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        s.a(getContext().getResources().getString(2131300637), getContext());
        finish();
        com.tencent.mm.sdk.b.a.ymk.l(new oj());
        AppMethodBeat.o(45112);
        return true;
      }
      h.bO(this, paramString);
      finish();
      AppMethodBeat.o(45112);
      return true;
    }
    AppMethodBeat.o(45112);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI
 * JD-Core Version:    0.7.0.1
 */