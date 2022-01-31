package com.tencent.mm.plugin.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI;
import com.tencent.mm.plugin.order.ui.MallOrderProductListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;

public class a
  extends c
{
  public c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.ShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
    b(paramActivity, MallOrderRecordListUI.class, paramBundle);
    return this;
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof MallOrderRecordListUI)) {
      b(paramActivity, MallOrderTransactionInfoUI.class, paramBundle);
    }
    do
    {
      do
      {
        return;
        if (!(paramActivity instanceof MallOrderDetailInfoUI)) {
          break;
        }
        paramInt = paramBundle.getInt("key_enter_id");
        if (paramInt == 0)
        {
          b(paramActivity, MallOrderProductListUI.class, paramBundle);
          return;
        }
      } while (paramInt != 1);
      b(paramActivity, MallOrderTransactionInfoUI.class, paramBundle);
      return;
    } while ((!(paramActivity instanceof MallOrderProductListUI)) && (!(paramActivity instanceof MallOrderTransactionInfoUI)));
    E(paramActivity);
  }
  
  public final String aTh()
  {
    return "ShowOrdersInfoProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    E(paramActivity);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    super.ak(paramActivity);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.a
 * JD-Core Version:    0.7.0.1
 */