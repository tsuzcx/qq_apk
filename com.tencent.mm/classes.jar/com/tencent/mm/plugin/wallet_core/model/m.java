package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class m
{
  public int VFV;
  public int retCode;
  public boolean wZR;
  public String wZb;
  
  public static m a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(70299);
    m localm = new m();
    localm.wZR = paramBoolean;
    localm.retCode = paramInt1;
    localm.VFV = paramInt2;
    localm.wZb = paramString;
    AppMethodBeat.o(70299);
    return localm;
  }
  
  public static m mV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70300);
    m localm = a(false, paramInt1, paramInt2, "");
    AppMethodBeat.o(70300);
    return localm;
  }
  
  public final void U(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(70301);
    if (this.wZR) {
      if (!(paramContext instanceof WalletBaseUI)) {
        break label114;
      }
    }
    label114:
    for (boolean bool = h.a((WalletBaseUI)paramContext, null, 1000, this.retCode, this.wZb);; bool = false)
    {
      if ((!bool) && (!Util.isNullOrNil(this.wZb)))
      {
        if (paramBoolean)
        {
          Toast.makeText(paramContext, this.wZb, 1).show();
          AppMethodBeat.o(70301);
          return;
        }
        k.c(paramContext, this.wZb, "", false);
      }
      AppMethodBeat.o(70301);
      return;
      k.c(paramContext, paramContext.getString(a.i.wallet_lqt_network_error), "", false);
      AppMethodBeat.o(70301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.m
 * JD-Core Version:    0.7.0.1
 */