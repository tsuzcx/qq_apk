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
  private int KtO;
  public List<i> MES;
  public List<d> MET;
  public String MEU;
  public int wYz;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(66681);
    this.MES = null;
    this.MET = null;
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
    this.MES = new LinkedList();
    try
    {
      this.wYz = paramJSONObject.getInt("TotalNum");
      this.KtO = paramJSONObject.getInt("RecNum");
      this.MEU = paramJSONObject.optString("Extbuf");
      paramString = paramJSONObject.getJSONArray("UserRollList");
      Object localObject;
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          localObject = new i();
          JSONObject localJSONObject = paramString.getJSONObject(paramInt);
          ((i)localObject).MFe = localJSONObject.optInt("PayType");
          ((i)localObject).MEX = localJSONObject.optString("Transid");
          ((i)localObject).MEY = localJSONObject.optDouble("TotalFee");
          ((i)localObject).MEZ = localJSONObject.optString("GoodsName");
          ((i)localObject).CreateTime = localJSONObject.optInt("CreateTime");
          ((i)localObject).MFb = localJSONObject.optInt("ModifyTime");
          ((i)localObject).MFc = localJSONObject.optString("FeeType");
          ((i)localObject).MFh = localJSONObject.optString("AppThumbUrl");
          ((i)localObject).MFa = localJSONObject.optString("TradeStateName");
          ((i)localObject).MFm = localJSONObject.optString("StatusColor");
          ((i)localObject).MFn = localJSONObject.optString("FeeColor");
          ((i)localObject).MFo = localJSONObject.optDouble("ActualPayFee");
          ((i)localObject).MFp = localJSONObject.optString("BillId");
          this.MES.add(localObject);
          paramInt += 1;
        }
      }
      this.MET = new LinkedList();
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
          ((d)localObject).MER = paramJSONObject.optString("feetext");
          this.MET.add(localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.e
 * JD-Core Version:    0.7.0.1
 */