package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
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
  public int owW;
  private int unc;
  public List<i> vxP;
  public List<d> vxQ;
  public String vxR;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(66681);
    this.vxP = null;
    this.vxQ = null;
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
    ac.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + paramInt + " errMsg: " + paramString);
    this.vxP = new LinkedList();
    try
    {
      this.owW = paramJSONObject.getInt("TotalNum");
      this.unc = paramJSONObject.getInt("RecNum");
      this.vxR = paramJSONObject.optString("Extbuf");
      paramString = paramJSONObject.getJSONArray("UserRollList");
      Object localObject;
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          localObject = new i();
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          ((i)localObject).vyb = localJSONObject.optInt("PayType");
          ((i)localObject).vxU = localJSONObject.optString("Transid");
          ((i)localObject).vxV = localJSONObject.optDouble("TotalFee");
          ((i)localObject).vxW = localJSONObject.optString("GoodsName");
          ((i)localObject).CreateTime = localJSONObject.optInt("CreateTime");
          ((i)localObject).vxY = localJSONObject.optInt("ModifyTime");
          ((i)localObject).vxZ = localJSONObject.optString("FeeType");
          ((i)localObject).vye = localJSONObject.optString("AppThumbUrl");
          ((i)localObject).vxX = localJSONObject.optString("TradeStateName");
          ((i)localObject).vyj = localJSONObject.optString("StatusColor");
          ((i)localObject).vyk = localJSONObject.optString("FeeColor");
          ((i)localObject).vyl = localJSONObject.optDouble("ActualPayFee");
          ((i)localObject).vym = localJSONObject.optString("BillId");
          this.vxP.add(localObject);
          paramInt += 1;
        }
      }
      this.vxQ = new LinkedList();
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
          ((d)localObject).vxO = paramJSONObject.optString("feetext");
          this.vxQ.add(localObject);
          paramInt += 1;
        }
      }
      AppMethodBeat.o(66682);
      return;
    }
    catch (JSONException paramString)
    {
      ac.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + paramString.getLocalizedMessage());
      AppMethodBeat.o(66682);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.e
 * JD-Core Version:    0.7.0.1
 */