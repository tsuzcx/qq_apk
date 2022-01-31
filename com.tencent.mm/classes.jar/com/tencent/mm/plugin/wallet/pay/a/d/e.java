package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.plugin.wallet_core.e.b;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.tenpay.model.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class e
  extends k
{
  private int nzY = -1;
  public Orders qmc = null;
  protected p qmr;
  
  public e(p paramp, Orders paramOrders)
  {
    this.qmc = paramOrders;
    this.qmr = paramp;
    List localList = paramOrders.qwN;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).bMY;
    }
    if (paramp.nqa == null)
    {
      y.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
      return;
    }
    this.nzY = paramp.nqa.bUV;
    int i = paramp.nqa.bUR;
    a(paramOrders.bMX, (String)localObject, paramp.nqa.bUV, i, paramp.mOb, paramp.mOc);
    paramOrders = new HashMap();
    localObject = new HashMap();
    paramOrders.put("flag", paramp.flag);
    paramOrders.put("passwd", paramp.feN);
    boolean bool;
    if (!bk.bl(paramp.feN))
    {
      bool = true;
      y.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      a(paramp.nqa, paramOrders, (Map)localObject, bool);
      paramOrders.put("verify_type", paramp.bUy);
      if (paramp.bUy != 0) {
        break label399;
      }
      paramOrders.put("verify_code", paramp.qyu);
    }
    for (;;)
    {
      paramOrders.put("token", paramp.token);
      paramOrders.put("bank_type", paramp.mOb);
      paramOrders.put("bind_serial", paramp.mOc);
      paramOrders.put("arrive_type", paramp.qsQ);
      paramOrders.put("default_favorcomposedid", paramp.qsT);
      paramOrders.put("favorcomposedid", paramp.qsU);
      P(paramOrders);
      if (v.cMA())
      {
        ((Map)localObject).put("uuid_for_bindcard", v.cMC());
        ((Map)localObject).put("bindcard_scene", v.cMB());
      }
      D(paramOrders);
      aC((Map)localObject);
      return;
      bool = false;
      break;
      label399:
      paramOrders.put("cre_tail", paramp.qyw);
      paramOrders.put("cre_type", paramp.qyx);
    }
  }
  
  public int HH()
  {
    if (this.nzY == 11) {
      return 1607;
    }
    if (this.nzY == 21) {
      return 1606;
    }
    return 462;
  }
  
  protected void P(Map<String, String> paramMap) {}
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramString, paramJSONObject);
    if (paramInt != 0) {
      return;
    }
    paramString = paramJSONObject.optString("bind_serial");
    y.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:" + paramString);
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      this.qno = true;
      this.qmc = Orders.a(paramJSONObject, this.qmc);
    }
    for (;;)
    {
      y.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.nzY);
      if (this.nzY != 39) {
        break;
      }
      y.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
      b.aw(paramJSONObject);
      return;
      this.qno = false;
    }
    y.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
  }
  
  public int aEC()
  {
    return 1;
  }
  
  public final boolean bTR()
  {
    return (this.nzY == 11) || (this.nzY == 21);
  }
  
  public String getUri()
  {
    if (this.nzY == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveverify";
    }
    if (this.nzY == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchverify";
    }
    return "/cgi-bin/mmpay-bin/tenpay/verify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.e
 * JD-Core Version:    0.7.0.1
 */