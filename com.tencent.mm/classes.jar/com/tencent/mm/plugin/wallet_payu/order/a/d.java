package com.tencent.mm.plugin.wallet_payu.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;

public class d
  extends a
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.PayUShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
    b(paramActivity, PayUMallOrderRecordListUI.class, paramBundle);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof PayUMallOrderRecordListUI)) {
      b(paramActivity, PayUMallOrderDetailUI.class, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.d
 * JD-Core Version:    0.7.0.1
 */