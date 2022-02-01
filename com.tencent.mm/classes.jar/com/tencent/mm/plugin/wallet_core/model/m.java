package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class m
{
  public int Aey;
  public String jwH;
  public boolean nUR;
  public int retCode;
  
  public static m a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(70299);
    m localm = new m();
    localm.nUR = paramBoolean;
    localm.retCode = paramInt1;
    localm.Aey = paramInt2;
    localm.jwH = paramString;
    AppMethodBeat.o(70299);
    return localm;
  }
  
  public static m ii(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70300);
    m localm = a(false, paramInt1, paramInt2, "");
    AppMethodBeat.o(70300);
    return localm;
  }
  
  public final void A(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(70301);
    if (this.nUR) {
      if (!(paramContext instanceof WalletBaseUI)) {
        break label113;
      }
    }
    label113:
    for (boolean bool = com.tencent.mm.wallet_core.d.h.a((WalletBaseUI)paramContext, null, 1000, this.retCode, this.jwH);; bool = false)
    {
      if ((!bool) && (!bt.isNullOrNil(this.jwH)))
      {
        if (paramBoolean)
        {
          Toast.makeText(paramContext, this.jwH, 1).show();
          AppMethodBeat.o(70301);
          return;
        }
        com.tencent.mm.ui.base.h.c(paramContext, this.jwH, "", false);
      }
      AppMethodBeat.o(70301);
      return;
      com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(2131765420), "", false);
      AppMethodBeat.o(70301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.m
 * JD-Core Version:    0.7.0.1
 */