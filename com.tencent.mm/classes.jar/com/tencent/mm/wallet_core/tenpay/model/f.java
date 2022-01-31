package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends m
{
  protected JSONObject wBo;
  public boolean wBp = false;
  public int wBq = 0;
  public boolean wBr = false;
  
  public f(Map<String, String> paramMap)
  {
    y.i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
    D(paramMap);
  }
  
  public int HH()
  {
    return 1525;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramString, paramJSONObject);
    JSONObject localJSONObject1 = paramJSONObject;
    if (ae.eTK) {}
    try
    {
      localJSONObject1 = new JSONObject("{\"retcode\":268447844,\"retmsg\":\"系统麻烦请稍后再试\",\"can_pay_retry\":1,\"show_retmsg_type\":1}");
      y.i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + paramInt + "errMsg=" + paramString);
      this.wBo = localJSONObject1;
      if (localJSONObject1 != null)
      {
        y.d("MicroMsg.NetSceneDelayQueryOrder", "ret json: %s", new Object[] { localJSONObject1.toString() });
        if (localJSONObject1.optInt("can_pay_retry") != 1) {
          break label119;
        }
      }
      label119:
      for (boolean bool = true;; bool = false)
      {
        this.wBp = bool;
        this.wBq = localJSONObject1.optInt("show_retmsg_type");
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
  
  public final int aEC()
  {
    return 1525;
  }
  
  public final JSONObject cMX()
  {
    return this.wBo;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/payorderquery";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.f
 * JD-Core Version:    0.7.0.1
 */