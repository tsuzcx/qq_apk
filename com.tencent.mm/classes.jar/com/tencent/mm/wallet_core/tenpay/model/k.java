package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.c.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class k
  extends m
  implements g
{
  private static int wBw = 0;
  protected int ccY;
  public RealnameGuideHelper mKP;
  private String mKQ;
  private String mKR;
  private String mKS;
  private String mKT;
  private String mKU;
  public String qoo;
  public int qwW = 0;
  public String wBA = null;
  public JSONObject wBB = null;
  private boolean wBC = false;
  protected Map<String, String> wBu = new HashMap();
  public int wBv = 0;
  private boolean wBx = false;
  public int wBy = 0;
  public int wBz = 0;
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (!this.wBx)
    {
      this.wBz = paramInt;
      this.wBA = paramString;
      this.wBB = paramJSONObject;
      this.wBx = true;
      if (paramJSONObject != null) {
        this.wBv = paramJSONObject.optInt("query_order_flag", 0);
      }
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("real_name_info")))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      this.mKQ = ((JSONObject)localObject).optString("guide_flag");
      this.mKR = ((JSONObject)localObject).optString("guide_wording");
      this.mKS = ((JSONObject)localObject).optString("left_button_wording");
      this.mKT = ((JSONObject)localObject).optString("right_button_wording");
      this.mKU = ((JSONObject)localObject).optString("upload_credit_url");
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
          ((SetPwdInfo)localObject).lRD = localJSONObject.optString("guide_wording");
          ((SetPwdInfo)localObject).lRE = localJSONObject.optString("left_button_wording");
          ((SetPwdInfo)localObject).lRF = localJSONObject.optString("right_button_wording");
          ((SetPwdInfo)localObject).qsG = localJSONObject.optInt("send_pwd_msg");
          j = 1;
        }
      }
      if ((j != 0) && (("1".equals(this.mKQ)) || ("2".equals(this.mKQ)) || (localObject != null)))
      {
        this.mKP = new RealnameGuideHelper();
        this.mKP.a(this.mKQ, (SetPwdInfo)localObject, this.mKR, this.mKS, this.mKT, this.mKU, this.ccY);
      }
      this.qoo = paramJSONObject.optString("forget_pwd_url", "");
      y.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", new Object[] { this.qoo });
      this.wBC = true;
      super.a(paramInt, paramString, paramJSONObject);
      return;
    }
  }
  
  public final void a(c paramc, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[] { Integer.valueOf(paramc.errCode), paramc.aox });
    super.a(paramc, paramJSONObject);
    if ((!this.wBC) && (!this.wBx))
    {
      this.wBy = paramc.errType;
      this.wBz = paramc.errCode;
      this.wBA = paramc.aox;
      if (paramJSONObject != null)
      {
        this.wBv = paramJSONObject.optInt("query_order_flag", 0);
        this.wBB = paramJSONObject;
      }
      this.wBx = true;
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    wBw += 1;
    this.wBu.put("req_key", paramString1);
    this.wBu.put("transaction_id", paramString2);
    this.wBu.put("pay_scene", String.valueOf(paramInt1));
    this.wBu.put("bank_type", paramString3);
    this.wBu.put("channel", String.valueOf(paramInt2));
    this.wBu.put("bind_serial", paramString4);
  }
  
  public boolean bTR()
  {
    return false;
  }
  
  public final boolean cMP()
  {
    return false;
  }
  
  public final Map<String, String> cMZ()
  {
    return this.wBu;
  }
  
  public final boolean cNa()
  {
    return this.wBv == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.k
 * JD-Core Version:    0.7.0.1
 */