package com.tencent.mm.plugin.wallet_payu.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;

public class d
  extends a
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48424);
    ab.d("MicroMsg.PayUShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
    b(paramActivity, PayUMallOrderRecordListUI.class, paramBundle);
    AppMethodBeat.o(48424);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48425);
    if ((paramActivity instanceof PayUMallOrderRecordListUI)) {
      b(paramActivity, PayUMallOrderDetailUI.class, paramBundle);
    }
    AppMethodBeat.o(48425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.d
 * JD-Core Version:    0.7.0.1
 */