package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends p
{
  protected JSONObject AXL;
  public boolean AXM;
  public int AXN;
  public boolean AXO;
  
  public g(Map<String, String> paramMap)
  {
    AppMethodBeat.i(49173);
    this.AXM = false;
    this.AXN = 0;
    this.AXO = false;
    ab.i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
    setRequestData(paramMap);
    AppMethodBeat.o(49173);
  }
  
  public final void L(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(49174);
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHashMap.put("is_last_query", i);
      localHashMap.put("curr_query_count", String.valueOf(paramInt));
      addRequestData(localHashMap);
      AppMethodBeat.o(49174);
      return;
    }
  }
  
  public final JSONObject dSK()
  {
    return this.AXL;
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
    AppMethodBeat.i(49175);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    JSONObject localJSONObject1 = paramJSONObject;
    if (ae.glF) {}
    try
    {
      localJSONObject1 = new JSONObject("{\"retcode\":268447844,\"retmsg\":\"系统麻烦请稍后再试\",\"can_pay_retry\":1,\"show_retmsg_type\":1}");
      ab.i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + paramInt + "errMsg=" + paramString);
      this.AXL = localJSONObject1;
      if (localJSONObject1 != null)
      {
        ab.d("MicroMsg.NetSceneDelayQueryOrder", "ret json: %s", new Object[] { localJSONObject1.toString() });
        if (localJSONObject1.optInt("can_pay_retry") != 1) {
          break label129;
        }
      }
      label129:
      for (boolean bool = true;; bool = false)
      {
        this.AXM = bool;
        this.AXN = localJSONObject1.optInt("show_retmsg_type");
        AppMethodBeat.o(49175);
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