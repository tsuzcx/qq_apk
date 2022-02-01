package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
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
  public List<i> AOO;
  public List<d> AOP;
  public String AOQ;
  public int qwe;
  private int yWN;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(66681);
    this.AOO = null;
    this.AOP = null;
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
    Log.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + paramInt + " errMsg: " + paramString);
    this.AOO = new LinkedList();
    try
    {
      this.qwe = paramJSONObject.getInt("TotalNum");
      this.yWN = paramJSONObject.getInt("RecNum");
      this.AOQ = paramJSONObject.optString("Extbuf");
      paramString = paramJSONObject.getJSONArray("UserRollList");
      Object localObject;
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          localObject = new i();
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          ((i)localObject).APa = localJSONObject.optInt("PayType");
          ((i)localObject).AOT = localJSONObject.optString("Transid");
          ((i)localObject).AOU = localJSONObject.optDouble("TotalFee");
          ((i)localObject).AOV = localJSONObject.optString("GoodsName");
          ((i)localObject).CreateTime = localJSONObject.optInt("CreateTime");
          ((i)localObject).AOX = localJSONObject.optInt("ModifyTime");
          ((i)localObject).AOY = localJSONObject.optString("FeeType");
          ((i)localObject).APd = localJSONObject.optString("AppThumbUrl");
          ((i)localObject).AOW = localJSONObject.optString("TradeStateName");
          ((i)localObject).APi = localJSONObject.optString("StatusColor");
          ((i)localObject).APj = localJSONObject.optString("FeeColor");
          ((i)localObject).APk = localJSONObject.optDouble("ActualPayFee");
          ((i)localObject).APl = localJSONObject.optString("BillId");
          this.AOO.add(localObject);
          paramInt += 1;
        }
      }
      this.AOP = new LinkedList();
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
          ((d)localObject).AON = paramJSONObject.optString("feetext");
          this.AOP.add(localObject);
          paramInt += 1;
        }
      }
      AppMethodBeat.o(66682);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + paramString.getLocalizedMessage());
      AppMethodBeat.o(66682);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.e
 * JD-Core Version:    0.7.0.1
 */