package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.uc;
import com.tencent.mm.plugin.remittance.model.ai;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceResendMsgUI
  extends WalletBaseUI
{
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
      paramBundle = new ai(paramBundle, str1, str2, j, i);
      paramBundle.setProcessName("RemittanceProcess");
      doSceneProgress(paramBundle);
      AppMethodBeat.o(68275);
      return;
    }
    Log.i("MicroMsg.RemittanceResendMsgUI", "onCreate() receiverName == null");
    AppMethodBeat.o(68275);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(68277);
    Log.i("MicroMsg.RemittanceResendMsgUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramp.getType());
    if ((paramp instanceof ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        z.a(null, getContext().getResources().getString(a.i.has_send), getContext(), 0, null);
        finish();
        new uc().publish();
        AppMethodBeat.o(68277);
        return true;
      }
      k.a(this, paramString, "", getContext().getString(a.i.app_i_known), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(288976);
          Log.i("MicroMsg.RemittanceResendMsgUI", "click AlertDialog");
          RemittanceResendMsgUI.this.finish();
          AppMethodBeat.o(288976);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI
 * JD-Core Version:    0.7.0.1
 */