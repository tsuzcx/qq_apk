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

public final class v
  extends a
{
  public String Oji;
  public String Ojj;
  public String Ojk;
  public String Ojl;
  public String desc;
  public long ihV;
  public String pHt;
  public String pHu;
  public int wYR;
  public String wYS;
  public String wYT;
  public int wYU;
  
  public v(String paramString)
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
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
  }
  
  public final int drJ()
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
    this.Oji = paramJSONObject.optString("recv_username", "");
    this.wYT = paramJSONObject.optString("recv_realname", "");
    this.Ojj = paramJSONObject.optString("recv_nickname", "");
    this.desc = paramJSONObject.optString("desc", "");
    this.ihV = paramJSONObject.optLong("amount", 0L);
    this.wYU = paramJSONObject.optInt("set_amount", 0);
    this.wYR = paramJSONObject.optInt("currency", 0);
    this.wYS = paramJSONObject.optString("currencyunit", "");
    this.Ojk = paramJSONObject.optString("qrcodeid", "");
    this.pHt = paramJSONObject.optString("notice", "");
    this.pHu = paramJSONObject.optString("notice_url", "");
    this.Ojl = paramJSONObject.optString("recv_headimgurl", "");
    Log.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s recv_headimgurl: %s", new Object[] { this.Oji, this.Ojj, this.desc, Long.valueOf(this.ihV), Integer.valueOf(this.wYU), this.wYS, this.Ojl });
    Log.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[] { this.wYT });
    AppMethodBeat.o(67876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.v
 * JD-Core Version:    0.7.0.1
 */