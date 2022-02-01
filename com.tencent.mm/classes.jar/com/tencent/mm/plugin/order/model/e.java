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
  public int par;
  private int vpI;
  public List<i> wDj;
  public List<d> wDk;
  public String wDl;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(66681);
    this.wDj = null;
    this.wDk = null;
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
    this.wDj = new LinkedList();
    try
    {
      this.par = paramJSONObject.getInt("TotalNum");
      this.vpI = paramJSONObject.getInt("RecNum");
      this.wDl = paramJSONObject.optString("Extbuf");
      paramString = paramJSONObject.getJSONArray("UserRollList");
      Object localObject;
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          localObject = new i();
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          ((i)localObject).wDv = localJSONObject.optInt("PayType");
          ((i)localObject).wDo = localJSONObject.optString("Transid");
          ((i)localObject).wDp = localJSONObject.optDouble("TotalFee");
          ((i)localObject).wDq = localJSONObject.optString("GoodsName");
          ((i)localObject).CreateTime = localJSONObject.optInt("CreateTime");
          ((i)localObject).wDs = localJSONObject.optInt("ModifyTime");
          ((i)localObject).wDt = localJSONObject.optString("FeeType");
          ((i)localObject).wDy = localJSONObject.optString("AppThumbUrl");
          ((i)localObject).wDr = localJSONObject.optString("TradeStateName");
          ((i)localObject).wDD = localJSONObject.optString("StatusColor");
          ((i)localObject).wDE = localJSONObject.optString("FeeColor");
          ((i)localObject).wDF = localJSONObject.optDouble("ActualPayFee");
          ((i)localObject).wDG = localJSONObject.optString("BillId");
          this.wDj.add(localObject);
          paramInt += 1;
        }
      }
      this.wDk = new LinkedList();
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
          ((d)localObject).wDi = paramJSONObject.optString("feetext");
          this.wDk.add(localObject);
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