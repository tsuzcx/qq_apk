package com.tencent.mm.plugin.offline;

import android.content.Context;
import com.tencent.mm.h.a.tz;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public final class m
  implements s.a
{
  c lRT = new m.1(this);
  
  public m()
  {
    a.udP.c(this.lRT);
    k.bpX();
    k.bpY().a(this);
  }
  
  private static void ay(int paramInt, String paramString)
  {
    tz localtz = new tz();
    localtz.cen.cep = paramInt;
    localtz.cen.action = 4;
    localtz.cen.content = paramString;
    a.udP.m(localtz);
  }
  
  public final boolean a(s.c paramc)
  {
    if (paramc.mLF == 6)
    {
      paramc = (s.f)paramc;
      if ((paramc.mLN.qwN != null) && (paramc.mLN.qwN.size() > 0))
      {
        paramc = (Orders.Commodity)paramc.mLN.qwN.get(0);
        ay(0, ae.getContext().getString(a.i.wallet_wear_pay_result_info, new Object[] { e.d(paramc.iHP, paramc.mOZ) }));
      }
    }
    do
    {
      return false;
      ay(9, ae.getContext().getString(a.i.wallet_wear_pay_error));
      return false;
      if (paramc.mLF == 8)
      {
        ay(6, ae.getContext().getString(a.i.wallet_wear_pay_error));
        return false;
      }
      if (paramc.mLF == 5)
      {
        ay(7, bk.aM(((s.e)paramc).mLJ, ""));
        return false;
      }
    } while (paramc.mLF != 4);
    ay(8, ae.getContext().getString(a.i.wallet_wear_pay_freeze_error));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.m
 * JD-Core Version:    0.7.0.1
 */