package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends m
{
  public int nTB;
  private int teN;
  public List<i> uoT;
  public List<d> uoU;
  public String uoV;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(66681);
    this.uoT = null;
    this.uoU = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("Limit", "10");
    localHashMap.put("Offset", String.valueOf(paramInt));
    localHashMap.put("Extbuf", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(66681);
  }
  
  public final int getTenpayCgicmd()
  {
    return 105;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(66682);
    ad.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + paramInt + " errMsg: " + paramString);
    this.uoT = new LinkedList();
    try
    {
      this.nTB = paramJSONObject.getInt("TotalNum");
      this.teN = paramJSONObject.getInt("RecNum");
      this.uoV = paramJSONObject.optString("Extbuf");
      paramString = paramJSONObject.getJSONArray("UserRollList");
      Object localObject;
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          localObject = new i();
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          ((i)localObject).upf = localJSONObject.optInt("PayType");
          ((i)localObject).uoY = localJSONObject.optString("Transid");
          ((i)localObject).uoZ = localJSONObject.optDouble("TotalFee");
          ((i)localObject).upa = localJSONObject.optString("GoodsName");
          ((i)localObject).CreateTime = localJSONObject.optInt("CreateTime");
          ((i)localObject).upc = localJSONObject.optInt("ModifyTime");
          ((i)localObject).upd = localJSONObject.optString("FeeType");
          ((i)localObject).upi = localJSONObject.optString("AppThumbUrl");
          ((i)localObject).upb = localJSONObject.optString("TradeStateName");
          ((i)localObject).upn = localJSONObject.optString("StatusColor");
          ((i)localObject).upo = localJSONObject.optString("FeeColor");
          ((i)localObject).upp = localJSONObject.optDouble("ActualPayFee");
          ((i)localObject).upq = localJSONObject.optString("BillId");
          this.uoT.add(localObject);
          paramInt += 1;
        }
      }
      this.uoU = new LinkedList();
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
          ((d)localObject).uoS = paramJSONObject.optString("feetext");
          this.uoU.add(localObject);
          paramInt += 1;
        }
      }
      AppMethodBeat.o(66682);
      return;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + paramString.getLocalizedMessage());
      AppMethodBeat.o(66682);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.e
 * JD-Core Version:    0.7.0.1
 */