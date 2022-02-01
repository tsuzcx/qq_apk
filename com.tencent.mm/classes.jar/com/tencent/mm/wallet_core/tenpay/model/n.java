package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class n
  extends p
  implements j
{
  private static int Lzk = 0;
  public String CLa;
  public int CYt = 0;
  protected Map<String, String> Lzi = new HashMap();
  public int Lzj = 0;
  private boolean Lzl = false;
  public int Lzm = 0;
  public int Lzn = 0;
  public String Lzo = null;
  public JSONObject Lzp = null;
  private boolean Lzq = false;
  public int Lzr = -1;
  protected int dMF;
  public RealnameGuideHelper wya;
  private String wyb;
  private String wyc;
  private String wyd;
  private String wye;
  private String wyf;
  
  protected final void a(Orders paramOrders, Authen paramAuthen)
  {
    List localList = paramOrders.CYk;
    String str = null;
    if (localList.size() > 0) {
      str = ((Orders.Commodity)localList.get(0)).dlv;
    }
    b(paramOrders.dlu, str, paramAuthen.xnF.dCC, paramAuthen.xnF.channel, paramAuthen.dkR, paramAuthen.wBI);
  }
  
  protected final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    Lzk += 1;
    this.Lzi.put("req_key", paramString1);
    this.Lzi.put("transaction_id", paramString2);
    this.Lzi.put("pay_scene", String.valueOf(paramInt1));
    this.Lzi.put("bank_type", paramString3);
    this.Lzi.put("channel", String.valueOf(paramInt2));
    this.Lzi.put("bind_serial", paramString4);
  }
  
  public boolean canRetry()
  {
    return false;
  }
  
  public boolean eDw()
  {
    return false;
  }
  
  public final Map<String, String> fRS()
  {
    return this.Lzi;
  }
  
  public final boolean fRT()
  {
    return this.Lzj == 1;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (!this.Lzl)
    {
      this.Lzn = paramInt;
      this.Lzo = paramString;
      this.Lzp = paramJSONObject;
      this.Lzl = true;
      if (paramJSONObject != null) {
        this.Lzj = paramJSONObject.optInt("query_order_flag", 0);
      }
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("real_name_info")))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      this.wyb = ((JSONObject)localObject).optString("guide_flag");
      this.wyc = ((JSONObject)localObject).optString("guide_wording");
      this.wyd = ((JSONObject)localObject).optString("left_button_wording");
      this.wye = ((JSONObject)localObject).optString("right_button_wording");
      this.wyf = ((JSONObject)localObject).optString("upload_credit_url");
    }
    for (int i = 1;; i = 0)
    {
      JSONObject localJSONObject = null;
      int j = i;
      localObject = localJSONObject;
      if (paramJSONObject != null)
      {
        j = i;
        localObject = localJSONObject;
        if (paramJSONObject.has("set_pwd_info"))
        {
          localJSONObject = paramJSONObject.optJSONObject("set_pwd_info");
          localObject = new SetPwdInfo();
          ((SetPwdInfo)localObject).vqB = localJSONObject.optString("guide_wording");
          ((SetPwdInfo)localObject).kzK = localJSONObject.optString("left_button_wording");
          ((SetPwdInfo)localObject).kzL = localJSONObject.optString("right_button_wording");
          ((SetPwdInfo)localObject).CTN = localJSONObject.optInt("send_pwd_msg");
          j = 1;
        }
      }
      if ((j != 0) && (("1".equals(this.wyb)) || ("2".equals(this.wyb)) || (localObject != null)))
      {
        this.wya = new RealnameGuideHelper();
        this.wya.a(this.wyb, (SetPwdInfo)localObject, this.wyc, this.wyd, this.wye, this.wyf, this.dMF);
      }
      this.CLa = paramJSONObject.optString("forget_pwd_url", "");
      this.Lzr = paramJSONObject.optInt("is_clear_failure", -1);
      ad.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", new Object[] { this.CLa });
      this.Lzq = true;
      super.onGYNetEnd(paramInt, paramString, paramJSONObject);
      return;
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    ad.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[] { Integer.valueOf(parame.errCode), parame.errMsg });
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((!this.Lzq) && (!this.Lzl))
    {
      this.Lzm = parame.errType;
      this.Lzn = parame.errCode;
      this.Lzo = parame.errMsg;
      if (paramJSONObject != null)
      {
        this.Lzj = paramJSONObject.optInt("query_order_flag", 0);
        this.Lzp = paramJSONObject;
      }
      this.Lzl = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.n
 * JD-Core Version:    0.7.0.1
 */