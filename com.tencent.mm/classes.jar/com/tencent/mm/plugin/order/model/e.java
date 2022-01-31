package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
  public int kNn;
  private int ooI;
  public List<i> ppT;
  public List<d> ppU;
  public String ppV;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(43773);
    this.ppT = null;
    this.ppU = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("Limit", "10");
    localHashMap.put("Offset", String.valueOf(paramInt));
    localHashMap.put("Extbuf", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(43773);
  }
  
  public final int getTenpayCgicmd()
  {
    return 105;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(43774);
    ab.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + paramInt + " errMsg: " + paramString);
    this.ppT = new LinkedList();
    try
    {
      this.kNn = paramJSONObject.getInt("TotalNum");
      this.ooI = paramJSONObject.getInt("RecNum");
      this.ppV = paramJSONObject.optString("Extbuf");
      paramString = paramJSONObject.getJSONArray("UserRollList");
      Object localObject;
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          localObject = new i();
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          ((i)localObject).pqf = localJSONObject.optInt("PayType");
          ((i)localObject).ppY = localJSONObject.optString("Transid");
          ((i)localObject).ppZ = localJSONObject.optDouble("TotalFee");
          ((i)localObject).pqa = localJSONObject.optString("GoodsName");
          ((i)localObject).CreateTime = localJSONObject.optInt("CreateTime");
          ((i)localObject).pqc = localJSONObject.optInt("ModifyTime");
          ((i)localObject).pqd = localJSONObject.optString("FeeType");
          ((i)localObject).pqi = localJSONObject.optString("AppThumbUrl");
          ((i)localObject).pqb = localJSONObject.optString("TradeStateName");
          ((i)localObject).pqn = localJSONObject.optString("StatusColor");
          ((i)localObject).pqo = localJSONObject.optString("FeeColor");
          ((i)localObject).pqp = localJSONObject.optDouble("ActualPayFee");
          ((i)localObject).pqq = localJSONObject.optString("BillId");
          this.ppT.add(localObject);
          paramInt += 1;
        }
      }
      this.ppU = new LinkedList();
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
          ((d)localObject).ppS = paramJSONObject.optString("feetext");
          this.ppU.add(localObject);
          paramInt += 1;
        }
      }
      AppMethodBeat.o(43774);
      return;
    }
    catch (JSONException paramString)
    {
      ab.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + paramString.getLocalizedMessage());
      AppMethodBeat.o(43774);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.e
 * JD-Core Version:    0.7.0.1
 */