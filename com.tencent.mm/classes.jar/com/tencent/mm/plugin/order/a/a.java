package com.tencent.mm.plugin.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI;
import com.tencent.mm.plugin.order.ui.MallOrderProductListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e;

public class a
  extends e
{
  public e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66631);
    Log.d("MicroMsg.ShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
    b(paramActivity, MallOrderRecordListUI.class, paramBundle);
    AppMethodBeat.o(66631);
    return this;
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(66632);
    if ((paramActivity instanceof MallOrderRecordListUI))
    {
      b(paramActivity, MallOrderTransactionInfoUI.class, paramBundle);
      AppMethodBeat.o(66632);
      return;
    }
    if ((paramActivity instanceof MallOrderDetailInfoUI))
    {
      paramInt = paramBundle.getInt("key_enter_id");
      if (paramInt == 0)
      {
        b(paramActivity, MallOrderProductListUI.class, paramBundle);
        AppMethodBeat.o(66632);
        return;
      }
      if (paramInt == 1) {
        b(paramActivity, MallOrderTransactionInfoUI.class, paramBundle);
      }
      AppMethodBeat.o(66632);
      return;
    }
    if (((paramActivity instanceof MallOrderProductListUI)) || ((paramActivity instanceof MallOrderTransactionInfoUI))) {
      Z(paramActivity);
    }
    AppMethodBeat.o(66632);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66633);
    super.co(paramActivity);
    AppMethodBeat.o(66633);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "ShowOrdersInfoProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66634);
    Z(paramActivity);
    AppMethodBeat.o(66634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.a
 * JD-Core Version:    0.7.0.1
 */