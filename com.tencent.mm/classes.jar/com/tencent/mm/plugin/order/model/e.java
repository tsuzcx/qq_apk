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
  private int EAR;
  public List<i> GIc;
  public List<d> GId;
  public String GIe;
  public int tVd;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(66681);
    this.GIc = null;
    this.GId = null;
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
    this.GIc = new LinkedList();
    try
    {
      this.tVd = paramJSONObject.getInt("TotalNum");
      this.EAR = paramJSONObject.getInt("RecNum");
      this.GIe = paramJSONObject.optString("Extbuf");
      paramString = paramJSONObject.getJSONArray("UserRollList");
      Object localObject;
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          localObject = new i();
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          ((i)localObject).GIo = localJSONObject.optInt("PayType");
          ((i)localObject).GIh = localJSONObject.optString("Transid");
          ((i)localObject).GIi = localJSONObject.optDouble("TotalFee");
          ((i)localObject).GIj = localJSONObject.optString("GoodsName");
          ((i)localObject).CreateTime = localJSONObject.optInt("CreateTime");
          ((i)localObject).GIl = localJSONObject.optInt("ModifyTime");
          ((i)localObject).GIm = localJSONObject.optString("FeeType");
          ((i)localObject).GIr = localJSONObject.optString("AppThumbUrl");
          ((i)localObject).GIk = localJSONObject.optString("TradeStateName");
          ((i)localObject).GIw = localJSONObject.optString("StatusColor");
          ((i)localObject).GIx = localJSONObject.optString("FeeColor");
          ((i)localObject).GIy = localJSONObject.optDouble("ActualPayFee");
          ((i)localObject).GIz = localJSONObject.optString("BillId");
          this.GIc.add(localObject);
          paramInt += 1;
        }
      }
      this.GId = new LinkedList();
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
          ((d)localObject).GIb = paramJSONObject.optString("feetext");
          this.GId.add(localObject);
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