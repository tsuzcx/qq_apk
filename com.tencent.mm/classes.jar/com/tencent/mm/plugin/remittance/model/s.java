package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends a
{
  public String CoP;
  public String CoQ;
  public String CoR;
  public String CoS;
  public String desc;
  public long eht;
  public String jTx;
  public String jTy;
  public int qww;
  public String qwx;
  public String qwy;
  public int qwz;
  
  public s(String paramString)
  {
    AppMethodBeat.i(67875);
    HashMap localHashMap = new HashMap();
    try
    {
      if (!Util.isNullOrNil(paramString)) {
        localHashMap.put("qrcode_url", URLEncoder.encode(paramString, "UTF-8"));
      }
      setRequestData(localHashMap);
      Log.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", new Object[] { paramString });
      AppMethodBeat.o(67875);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String czD()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
  }
  
  public final int czE()
  {
    return 1301;
  }
  
  public final int getType()
  {
    return 1301;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67876);
    this.CoP = paramJSONObject.optString("recv_username", "");
    this.qwy = paramJSONObject.optString("recv_realname", "");
    this.CoQ = paramJSONObject.optString("recv_nickname", "");
    this.desc = paramJSONObject.optString("desc", "");
    this.eht = paramJSONObject.optLong("amount", 0L);
    this.qwz = paramJSONObject.optInt("set_amount", 0);
    this.qww = paramJSONObject.optInt("currency", 0);
    this.qwx = paramJSONObject.optString("currencyunit", "");
    this.CoR = paramJSONObject.optString("qrcodeid", "");
    this.jTx = paramJSONObject.optString("notice", "");
    this.jTy = paramJSONObject.optString("notice_url", "");
    this.CoS = paramJSONObject.optString("recv_headimgurl", "");
    Log.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s recv_headimgurl: %s", new Object[] { this.CoP, this.CoQ, this.desc, Long.valueOf(this.eht), Integer.valueOf(this.qwz), this.qwx, this.CoS });
    Log.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[] { this.qwy });
    AppMethodBeat.o(67876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.s
 * JD-Core Version:    0.7.0.1
 */