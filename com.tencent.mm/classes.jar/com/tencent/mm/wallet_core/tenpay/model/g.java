package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends p
{
  protected JSONObject JGa;
  public boolean JGb;
  public int JGc;
  public boolean JGd;
  
  public g(Map<String, String> paramMap)
  {
    AppMethodBeat.i(72891);
    this.JGb = false;
    this.JGc = 0;
    this.JGd = false;
    ac.i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
    setRequestData(paramMap);
    AppMethodBeat.o(72891);
  }
  
  public final void Z(boolean paramBoolean, int paramInt)
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
  
  public final JSONObject fAH()
  {
    return this.JGa;
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
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72893);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    JSONObject localJSONObject1 = paramJSONObject;
    if (ab.iwG) {}
    try
    {
      localJSONObject1 = new JSONObject("{\"retcode\":268447844,\"retmsg\":\"系统麻烦请稍后再试\",\"can_pay_retry\":1,\"show_retmsg_type\":1}");
      ac.i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + paramInt + "errMsg=" + paramString);
      this.JGa = localJSONObject1;
      if (localJSONObject1 != null)
      {
        ac.d("MicroMsg.NetSceneDelayQueryOrder", "ret json: %s", new Object[] { localJSONObject1.toString() });
        if (localJSONObject1.optInt("can_pay_retry") != 1) {
          break label129;
        }
      }
      label129:
      for (boolean bool = true;; bool = false)
      {
        this.JGb = bool;
        this.JGc = localJSONObject1.optInt("show_retmsg_type");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.g
 * JD-Core Version:    0.7.0.1
 */