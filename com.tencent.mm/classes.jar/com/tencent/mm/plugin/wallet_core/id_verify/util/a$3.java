package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class a$3
  implements DialogInterface.OnClickListener
{
  a$3(Bundle paramBundle, int paramInt, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
    y.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
    Bundle localBundle = this.gBV;
    if (this.gBV == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", this.qsC);
    localBundle.putBoolean("key_from_set_pwd", true);
    com.tencent.mm.wallet_core.a.a(this.eRW, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle);
    e.a(19, bk.UX(), this.qsC);
    paramDialogInterface.dismiss();
    if (this.qsF) {
      this.eRW.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.3
 * JD-Core Version:    0.7.0.1
 */