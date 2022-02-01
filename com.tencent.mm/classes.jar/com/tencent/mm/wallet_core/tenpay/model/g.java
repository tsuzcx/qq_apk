package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends p
{
  protected JSONObject agUb;
  public boolean agUc;
  public int agUd;
  public boolean agUe;
  
  public g(Map<String, String> paramMap)
  {
    AppMethodBeat.i(72891);
    this.agUc = false;
    this.agUd = 0;
    this.agUe = false;
    Log.i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
    setRequestData(paramMap);
    AppMethodBeat.o(72891);
  }
  
  public final void ax(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(72892);
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHashMap.put("is_last_query", i);
      localHashMap.put("curr_query_count", String.valueOf(paramInt));
      addRequestData(localHashMap);
      AppMethodBeat.o(72892);
      return;
    }
  }
  
  public int getFuncId()
  {
    return 1525;
  }
  
  public int getTenpayCgicmd()
  {
    return 1525;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/payorderquery";
  }
  
  public final JSONObject jPh()
  {
    return this.agUb;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72893);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    JSONObject localJSONObject1 = paramJSONObject;
    if (z.pDm) {}
    try
    {
      localJSONObject1 = new JSONObject("{\"retcode\":268447844,\"retmsg\":\"系统麻烦请稍后再试\",\"can_pay_retry\":1,\"show_retmsg_type\":1}");
      Log.i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + paramInt + "errMsg=" + paramString);
      this.agUb = localJSONObject1;
      if (localJSONObject1 != null)
      {
        Log.d("MicroMsg.NetSceneDelayQueryOrder", "ret json: %s", new Object[] { localJSONObject1.toString() });
        if (localJSONObject1.optInt("can_pay_retry") != 1) {
          break label129;
        }
      }
      label129:
      for (boolean bool = true;; bool = false)
      {
        this.agUc = bool;
        this.agUd = localJSONObject1.optInt("show_retmsg_type");
        AppMethodBeat.o(72893);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject2 = paramJSONObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.g
 * JD-Core Version:    0.7.0.1
 */