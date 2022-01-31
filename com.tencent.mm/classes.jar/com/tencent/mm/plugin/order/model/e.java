package com.tencent.mm.plugin.order.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends j
{
  public int iHi;
  private int lQT;
  public List<i> mPD = null;
  public List<d> mPE = null;
  public String mPF;
  
  public e(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Limit", "10");
    localHashMap.put("Offset", String.valueOf(paramInt));
    localHashMap.put("Extbuf", paramString);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    int i = 0;
    y.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + paramInt + " errMsg: " + paramString);
    this.mPD = new LinkedList();
    try
    {
      this.iHi = paramJSONObject.getInt("TotalNum");
      this.lQT = paramJSONObject.getInt("RecNum");
      this.mPF = paramJSONObject.optString("Extbuf");
      paramString = paramJSONObject.getJSONArray("UserRollList");
      Object localObject;
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          localObject = new i();
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          ((i)localObject).mPQ = localJSONObject.optInt("PayType");
          ((i)localObject).mPI = localJSONObject.optString("Transid");
          ((i)localObject).mPJ = localJSONObject.optDouble("TotalFee");
          ((i)localObject).mPK = localJSONObject.optString("GoodsName");
          ((i)localObject).mPL = localJSONObject.optInt("CreateTime");
          ((i)localObject).mPN = localJSONObject.optInt("ModifyTime");
          ((i)localObject).mPO = localJSONObject.optString("FeeType");
          ((i)localObject).mPT = localJSONObject.optString("AppThumbUrl");
          ((i)localObject).mPM = localJSONObject.optString("TradeStateName");
          ((i)localObject).mPY = localJSONObject.optString("StatusColor");
          ((i)localObject).mPZ = localJSONObject.optString("FeeColor");
          ((i)localObject).mQa = localJSONObject.optDouble("ActualPayFee");
          ((i)localObject).mQb = localJSONObject.optString("BillId");
          this.mPD.add(localObject);
          paramInt += 1;
        }
      }
      this.mPE = new LinkedList();
      paramString = paramJSONObject.optJSONArray("month_info");
      if (paramString != null)
      {
        paramInt = i;
        while (paramInt < paramString.length())
        {
          paramJSONObject = paramString.getJSONObject(paramInt);
          localObject = new d();
          ((d)localObject).year = paramJSONObject.optInt("year");
          ((d)localObject).month = paramJSONObject.optInt("month");
          ((d)localObject).mPC = paramJSONObject.optString("feetext");
          this.mPE.add(localObject);
          paramInt += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + paramString.getLocalizedMessage());
    }
  }
  
  public final int aEC()
  {
    return 105;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.e
 * JD-Core Version:    0.7.0.1
 */