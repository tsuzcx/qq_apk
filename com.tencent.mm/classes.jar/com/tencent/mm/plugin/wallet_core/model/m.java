package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class m
{
  public int BwS;
  public String jXd;
  public boolean oym;
  public int retCode;
  
  public static m a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(70299);
    m localm = new m();
    localm.oym = paramBoolean;
    localm.retCode = paramInt1;
    localm.BwS = paramInt2;
    localm.jXd = paramString;
    AppMethodBeat.o(70299);
    return localm;
  }
  
  public static m ix(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70300);
    m localm = a(false, paramInt1, paramInt2, "");
    AppMethodBeat.o(70300);
    return localm;
  }
  
  public final void B(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(70301);
    if (this.oym) {
      if (!(paramContext instanceof WalletBaseUI)) {
        break label113;
      }
    }
    label113:
    for (boolean bool = com.tencent.mm.wallet_core.d.h.a((WalletBaseUI)paramContext, null, 1000, this.retCode, this.jXd);; bool = false)
    {
      if ((!bool) && (!bs.isNullOrNil(this.jXd)))
      {
        if (paramBoolean)
        {
          Toast.makeText(paramContext, this.jXd, 1).show();
          AppMethodBeat.o(70301);
          return;
        }
        com.tencent.mm.ui.base.h.c(paramContext, this.jXd, "", false);
      }
      AppMethodBeat.o(70301);
      return;
      com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(2131765420), "", false);
      AppMethodBeat.o(70301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.m
 * JD-Core Version:    0.7.0.1
 */