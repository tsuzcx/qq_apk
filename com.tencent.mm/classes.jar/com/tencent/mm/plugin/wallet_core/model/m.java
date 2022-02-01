package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class m
{
  public int OQb;
  public int retCode;
  public String tVH;
  public boolean tWy;
  
  public static m a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(70299);
    m localm = new m();
    localm.tWy = paramBoolean;
    localm.retCode = paramInt1;
    localm.OQb = paramInt2;
    localm.tVH = paramString;
    AppMethodBeat.o(70299);
    return localm;
  }
  
  public static m lk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70300);
    m localm = a(false, paramInt1, paramInt2, "");
    AppMethodBeat.o(70300);
    return localm;
  }
  
  public final void L(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(70301);
    if (this.tWy) {
      if (!(paramContext instanceof WalletBaseUI)) {
        break label114;
      }
    }
    label114:
    for (boolean bool = com.tencent.mm.wallet_core.d.h.a((WalletBaseUI)paramContext, null, 1000, this.retCode, this.tVH);; bool = false)
    {
      if ((!bool) && (!Util.isNullOrNil(this.tVH)))
      {
        if (paramBoolean)
        {
          Toast.makeText(paramContext, this.tVH, 1).show();
          AppMethodBeat.o(70301);
          return;
        }
        com.tencent.mm.ui.base.h.c(paramContext, this.tVH, "", false);
      }
      AppMethodBeat.o(70301);
      return;
      com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(a.i.wallet_lqt_network_error), "", false);
      AppMethodBeat.o(70301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.m
 * JD-Core Version:    0.7.0.1
 */