package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends a
{
  public long dBN;
  public String desc;
  public String iAx;
  public String iAy;
  public int oxo;
  public String oxp;
  public String oxq;
  public int oxr;
  public String wKA;
  public String wKB;
  public String wKC;
  public String wKD;
  
  public s(String paramString)
  {
    AppMethodBeat.i(67875);
    HashMap localHashMap = new HashMap();
    try
    {
      if (!bs.isNullOrNil(paramString)) {
        localHashMap.put("qrcode_url", URLEncoder.encode(paramString, "UTF-8"));
      }
      setRequestData(localHashMap);
      ac.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", new Object[] { paramString });
      AppMethodBeat.o(67875);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String bVR()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
  }
  
  public final int bVS()
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
    this.wKA = paramJSONObject.optString("recv_username", "");
    this.oxq = paramJSONObject.optString("recv_realname", "");
    this.wKB = paramJSONObject.optString("recv_nickname", "");
    this.desc = paramJSONObject.optString("desc", "");
    this.dBN = paramJSONObject.optLong("amount", 0L);
    this.oxr = paramJSONObject.optInt("set_amount", 0);
    this.oxo = paramJSONObject.optInt("currency", 0);
    this.oxp = paramJSONObject.optString("currencyunit", "");
    this.wKC = paramJSONObject.optString("qrcodeid", "");
    this.iAx = paramJSONObject.optString("notice", "");
    this.iAy = paramJSONObject.optString("notice_url", "");
    this.wKD = paramJSONObject.optString("recv_headimgurl", "");
    ac.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s recv_headimgurl: %s", new Object[] { this.wKA, this.wKB, this.desc, Long.valueOf(this.dBN), Integer.valueOf(this.oxr), this.oxp, this.wKD });
    ac.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[] { this.oxq });
    AppMethodBeat.o(67876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.s
 * JD-Core Version:    0.7.0.1
 */