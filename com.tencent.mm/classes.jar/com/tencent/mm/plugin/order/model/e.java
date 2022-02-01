package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
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
  public int pgV;
  private int vBN;
  public List<i> wSU;
  public List<d> wSV;
  public String wSW;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(66681);
    this.wSU = null;
    this.wSV = null;
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
    ae.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + paramInt + " errMsg: " + paramString);
    this.wSU = new LinkedList();
    try
    {
      this.pgV = paramJSONObject.getInt("TotalNum");
      this.vBN = paramJSONObject.getInt("RecNum");
      this.wSW = paramJSONObject.optString("Extbuf");
      paramString = paramJSONObject.getJSONArray("UserRollList");
      Object localObject;
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          localObject = new i();
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          ((i)localObject).wTg = localJSONObject.optInt("PayType");
          ((i)localObject).wSZ = localJSONObject.optString("Transid");
          ((i)localObject).wTa = localJSONObject.optDouble("TotalFee");
          ((i)localObject).wTb = localJSONObject.optString("GoodsName");
          ((i)localObject).CreateTime = localJSONObject.optInt("CreateTime");
          ((i)localObject).wTd = localJSONObject.optInt("ModifyTime");
          ((i)localObject).wTe = localJSONObject.optString("FeeType");
          ((i)localObject).wTj = localJSONObject.optString("AppThumbUrl");
          ((i)localObject).wTc = localJSONObject.optString("TradeStateName");
          ((i)localObject).wTo = localJSONObject.optString("StatusColor");
          ((i)localObject).wTp = localJSONObject.optString("FeeColor");
          ((i)localObject).wTq = localJSONObject.optDouble("ActualPayFee");
          ((i)localObject).wTr = localJSONObject.optString("BillId");
          this.wSU.add(localObject);
          paramInt += 1;
        }
      }
      this.wSV = new LinkedList();
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
          ((d)localObject).wST = paramJSONObject.optString("feetext");
          this.wSV.add(localObject);
          paramInt += 1;
        }
      }
      AppMethodBeat.o(66682);
      return;
    }
    catch (JSONException paramString)
    {
      ae.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + paramString.getLocalizedMessage());
      AppMethodBeat.o(66682);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.e
 * JD-Core Version:    0.7.0.1
 */