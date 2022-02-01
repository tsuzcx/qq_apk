package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_core.id_verify.model.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class WcPayRealnameProxyUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70067);
    super.onCreate(paramBundle);
    ar.r(this, getResources().getColor(a.c.transparent));
    Log.i("MicroMsg.WcPayRealnameProxyUI", "do get wording");
    paramBundle = new e(getInput().getString("key_realname_sessionid"));
    addSceneEndListener(1666);
    doSceneProgress(paramBundle);
    AppMethodBeat.o(70067);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70068);
    removeSceneEndListener(1666);
    paramString = (e)paramq;
    if (paramString.OLL == null)
    {
      com.tencent.mm.wallet_core.a.b(getContext(), getInput(), 0);
      AppMethodBeat.o(70068);
      return false;
    }
    try
    {
      paramq = new String(paramString.OLL.toByteArray(), org.apache.commons.a.a.ISO_8859_1);
      Bundle localBundle = new Bundle();
      localBundle.putString("realname_verify_process_get_wording_cache", paramq);
      localBundle.putAll(getInput());
      localBundle.putInt("real_name_verify_mode", 4);
      localBundle.putBoolean("realname_verify_process_show_bindcard_page", paramString.OLL.TjS);
      getInput().putBoolean("realname_verify_process_verify_sms_without_bindcard", paramString.OLL.TjU);
      com.tencent.mm.wallet_core.a.l(getContext(), localBundle);
      AppMethodBeat.o(70068);
      return false;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WcPayRealnameProxyUI", paramString, "", new Object[0]);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameProxyUI
 * JD-Core Version:    0.7.0.1
 */