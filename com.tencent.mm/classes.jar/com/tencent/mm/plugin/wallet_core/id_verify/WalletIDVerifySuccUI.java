package com.tencent.mm.plugin.wallet_core.id_verify;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletIDVerifySuccUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70039);
    super.onCreate(paramBundle);
    AppMethodBeat.o(70039);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletIDVerifySuccUI
 * JD-Core Version:    0.7.0.1
 */