package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceResendMsgUI
  extends WalletBaseUI
{
  protected void f(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68276);
    paramString1 = new z(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    paramString1.setProcessName("RemittanceProcess");
    doSceneProgress(paramString1);
    AppMethodBeat.o(68276);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68275);
    super.onCreate(paramBundle);
    getContentView().setVisibility(8);
    setTitleVisibility(8);
    paramBundle = getIntent().getStringExtra("transaction_id");
    String str1 = getIntent().getStringExtra("transfer_id");
    String str2 = getIntent().getStringExtra("receiver_name");
    int i = getIntent().getIntExtra("resend_msg_from_flag", 1);
    int j = getIntent().getIntExtra("invalid_time", 0);
    if (!Util.isNullOrNil(str2))
    {
      f(paramBundle, str1, str2, j, i);
      AppMethodBeat.o(68275);
      return;
    }
    Log.i("MicroMsg.RemittanceResendMsgUI", "onCreate() receiverName == null");
    AppMethodBeat.o(68275);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68277);
    Log.i("MicroMsg.RemittanceResendMsgUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    if ((paramq instanceof z))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        t.a(getContext().getResources().getString(2131761619), getContext(), 0, null);
        finish();
        EventCenter.instance.publish(new ro());
        AppMethodBeat.o(68277);
        return true;
      }
      h.a(this, paramString, "", getContext().getString(2131755874), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(213842);
          Log.i("MicroMsg.RemittanceResendMsgUI", "click AlertDialog");
          RemittanceResendMsgUI.this.finish();
          AppMethodBeat.o(213842);
        }
      });
      AppMethodBeat.o(68277);
      return true;
    }
    AppMethodBeat.o(68277);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI
 * JD-Core Version:    0.7.0.1
 */