package com.tencent.mm.plugin.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI;
import com.tencent.mm.plugin.order.ui.MallOrderProductListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;

public class a
  extends c
{
  public c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43723);
    ab.d("MicroMsg.ShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
    b(paramActivity, MallOrderRecordListUI.class, paramBundle);
    AppMethodBeat.o(43723);
    return this;
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(43724);
    if ((paramActivity instanceof MallOrderRecordListUI))
    {
      b(paramActivity, MallOrderTransactionInfoUI.class, paramBundle);
      AppMethodBeat.o(43724);
      return;
    }
    if ((paramActivity instanceof MallOrderDetailInfoUI))
    {
      paramInt = paramBundle.getInt("key_enter_id");
      if (paramInt == 0)
      {
        b(paramActivity, MallOrderProductListUI.class, paramBundle);
        AppMethodBeat.o(43724);
        return;
      }
      if (paramInt == 1) {
        b(paramActivity, MallOrderTransactionInfoUI.class, paramBundle);
      }
      AppMethodBeat.o(43724);
      return;
    }
    if (((paramActivity instanceof MallOrderProductListUI)) || ((paramActivity instanceof MallOrderTransactionInfoUI))) {
      B(paramActivity);
    }
    AppMethodBeat.o(43724);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43725);
    super.aO(paramActivity);
    AppMethodBeat.o(43725);
  }
  
  public final String bzC()
  {
    return "ShowOrdersInfoProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(43726);
    B(paramActivity);
    AppMethodBeat.o(43726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.a
 * JD-Core Version:    0.7.0.1
 */