package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r
  extends m
{
  public String HPV;
  public String HPW;
  public BindCardOrder HPX;
  public String resultMsg;
  
  public r(BindCardOrder paramBindCardOrder, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69928);
    this.HPX = paramBindCardOrder;
    paramBindCardOrder = new HashMap();
    paramBindCardOrder.put("activity_id", paramString1);
    paramBindCardOrder.put("award_id", paramString2);
    paramBindCardOrder.put("send_record_id", paramString3);
    paramBindCardOrder.put("user_record_id", paramString4);
    paramBindCardOrder.put("activity_mch_id", String.valueOf(paramLong1));
    paramBindCardOrder.put("activity_type", String.valueOf(paramLong2));
    paramBindCardOrder.put("bank_type", String.valueOf(paramString5));
    paramBindCardOrder.put("bank_serial", String.valueOf(paramString6));
    paramBindCardOrder.put("bindbankscene", String.valueOf(paramInt1));
    paramBindCardOrder.put("realname_scene", String.valueOf(paramInt2));
    setRequestData(paramBindCardOrder);
    AppMethodBeat.o(69928);
  }
  
  public final int getFuncId()
  {
    return 1786;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1786;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/sendbindcardaward";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69929);
    if ((paramJSONObject != null) && (paramInt == 0))
    {
      this.HPV = paramJSONObject.optString("result_code");
      this.resultMsg = paramJSONObject.optString("result_msg");
      this.HPW = paramJSONObject.optString("alert_wording");
    }
    AppMethodBeat.o(69929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */