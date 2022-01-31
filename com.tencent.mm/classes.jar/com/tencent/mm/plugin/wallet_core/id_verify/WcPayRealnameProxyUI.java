package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.id_verify.model.b;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.af;
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
    AppMethodBeat.i(142409);
    super.onCreate(paramBundle);
    af.o(this, getResources().getColor(2131690605));
    ab.i("MicroMsg.WcPayRealnameProxyUI", "do get wording");
    paramBundle = new b();
    addSceneEndListener(1666);
    doSceneProgress(paramBundle);
    AppMethodBeat.o(142409);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(142410);
    removeSceneEndListener(1666);
    paramString = (b)paramm;
    if (paramString.uea == null)
    {
      com.tencent.mm.wallet_core.a.b(getContext(), getInput(), 0);
      AppMethodBeat.o(142410);
      return false;
    }
    try
    {
      paramm = new String(paramString.uea.toByteArray(), org.apache.commons.a.a.ISO_8859_1);
      Bundle localBundle = new Bundle();
      localBundle.putString("realname_verify_process_get_wording_cache", paramm);
      localBundle.putAll(getInput());
      if (paramString.uea.xeZ) {
        localBundle.putInt("real_name_verify_mode", 4);
      }
      com.tencent.mm.wallet_core.a.j(getContext(), localBundle);
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WcPayRealnameProxyUI", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(142410);
    return false;
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