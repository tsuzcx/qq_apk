package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.i;
import com.tencent.mm.plugin.wallet.pay.a.a.j;
import com.tencent.mm.plugin.wallet.pay.a.a.k;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static b a(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    if ((paramAuthen == null) || (paramOrders == null))
    {
      y.i("MicroMsg.CgiManager", "empty authen or orders");
      return null;
    }
    PayInfo localPayInfo = paramAuthen.nqa;
    String str1 = "";
    if (localPayInfo != null)
    {
      y.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.bMX;
    }
    String str2 = str1;
    if (bk.bl(str1))
    {
      str2 = str1;
      if (paramOrders != null)
      {
        y.i("MicroMsg.CgiManager", "get reqKey from orders");
        str2 = paramOrders.bMX;
      }
    }
    if (bk.bl(str2))
    {
      y.i("MicroMsg.CgiManager", "empty reqKey!");
      return new b(paramAuthen, paramOrders, paramBoolean);
    }
    y.i("MicroMsg.CgiManager", "authen reqKey: %s", new Object[] { str2 });
    if ((localPayInfo != null) && (paramOrders != null)) {
      y.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.bMX, paramOrders.bMX });
    }
    y.i("MicroMsg.CgiManager", "authen go new split cgi");
    if (str2.startsWith("sns_aa_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.a.a(paramAuthen, paramOrders, paramBoolean);
    }
    if (str2.startsWith("sns_tf_")) {
      return new j(paramAuthen, paramOrders, paramBoolean);
    }
    if (str2.startsWith("sns_ff_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.a.d(paramAuthen, paramOrders, paramBoolean);
    }
    if (str2.startsWith("ts_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.a.f(paramAuthen, paramOrders, paramBoolean);
    }
    if (str2.startsWith("sns_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.a.h(paramAuthen, paramOrders, paramBoolean);
    }
    if (str2.startsWith("offline_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.a.g(paramAuthen, paramOrders, paramBoolean);
    }
    if (str2.startsWith("up_")) {
      return new k(paramAuthen, paramOrders, paramBoolean);
    }
    return new b(paramAuthen, paramOrders, paramBoolean);
  }
  
  public static com.tencent.mm.plugin.wallet.pay.a.d.e a(com.tencent.mm.plugin.wallet_core.model.p paramp, Orders paramOrders)
  {
    if ((paramp == null) || (paramOrders == null))
    {
      y.e("MicroMsg.CgiManager", "empty verify or orders");
      return null;
    }
    PayInfo localPayInfo = paramp.nqa;
    String str1 = "";
    if (localPayInfo != null)
    {
      y.i("MicroMsg.CgiManager", "get reqKey from payInfo");
      str1 = localPayInfo.bMX;
    }
    String str2 = str1;
    if (bk.bl(str1))
    {
      y.i("MicroMsg.CgiManager", "get reqKey from orders");
      str2 = paramOrders.bMX;
    }
    if (bk.bl(str2))
    {
      y.i("MicroMsg.CgiManager", "empty reqKey!");
      return new com.tencent.mm.plugin.wallet.pay.a.d.e(paramp, paramOrders);
    }
    if (localPayInfo != null) {
      y.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.bMX, paramOrders.bMX });
    }
    y.i("MicroMsg.CgiManager", "verify reqKey: %s", new Object[] { str2 });
    y.i("MicroMsg.CgiManager", "verify go new split cgi");
    if (str2.startsWith("sns_aa_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.d.a(paramp, paramOrders);
    }
    if (str2.startsWith("sns_tf_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.d.g(paramp, paramOrders);
    }
    if (str2.startsWith("sns_ff_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.d.c(paramp, paramOrders);
    }
    if (str2.startsWith("ts_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.d.d(paramp, paramOrders);
    }
    if (str2.startsWith("sns_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.d.f(paramp, paramOrders);
    }
    if (str2.startsWith("up_")) {
      return new com.tencent.mm.plugin.wallet.pay.a.d.h(paramp, paramOrders);
    }
    return new com.tencent.mm.plugin.wallet.pay.a.d.e(paramp, paramOrders);
  }
  
  public static com.tencent.mm.plugin.wallet.pay.a.a.c b(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    com.tencent.mm.plugin.wallet.a.p.bTK();
    boolean bool1;
    boolean bool2;
    if ((com.tencent.mm.plugin.wallet.a.p.bTL().qzj != null) && (paramAuthen.nqa != null) && (!paramBoolean)) {
      if ((paramAuthen.nqa.bUV == 31) || (paramAuthen.nqa.bUV == 32) || (paramAuthen.nqa.bUV == 33) || (paramAuthen.nqa.bUV == 42) || (paramAuthen.nqa.bUV == 37))
      {
        bool1 = false;
        bool2 = true;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) });
      if (bool2)
      {
        return new i(paramAuthen, paramOrders, paramBoolean);
        bool1 = true;
        bool2 = false;
      }
      else
      {
        if (bool1) {
          return new com.tencent.mm.plugin.wallet.pay.a.a.e(paramAuthen, paramOrders, paramBoolean);
        }
        return new com.tencent.mm.plugin.wallet.pay.a.a.c(paramAuthen, paramOrders, paramBoolean);
        bool1 = false;
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a
 * JD-Core Version:    0.7.0.1
 */