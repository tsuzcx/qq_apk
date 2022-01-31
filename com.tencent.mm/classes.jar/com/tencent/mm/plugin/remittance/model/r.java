package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r
  extends a
{
  public long cNd;
  public String desc;
  public int kNE;
  public String kNF;
  public String kNG;
  public String kNH;
  public String kNI;
  public int kNJ;
  public String qju;
  public String qjv;
  public String qjw;
  
  public r(String paramString)
  {
    AppMethodBeat.i(44762);
    HashMap localHashMap = new HashMap();
    try
    {
      if (!bo.isNullOrNil(paramString)) {
        localHashMap.put("qrcode_url", URLEncoder.encode(paramString, "UTF-8"));
      }
      setRequestData(localHashMap);
      ab.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", new Object[] { paramString });
      AppMethodBeat.o(44762);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
  }
  
  public final int bhH()
  {
    return 1301;
  }
  
  public final int getType()
  {
    return 1301;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(44763);
    this.qju = paramJSONObject.optString("recv_username", "");
    this.kNI = paramJSONObject.optString("recv_realname", "");
    this.qjv = paramJSONObject.optString("recv_nickname", "");
    this.desc = paramJSONObject.optString("desc", "");
    this.cNd = paramJSONObject.optLong("amount", 0L);
    this.kNJ = paramJSONObject.optInt("set_amount", 0);
    this.kNE = paramJSONObject.optInt("currency", 0);
    this.kNF = paramJSONObject.optString("currencyunit", "");
    this.qjw = paramJSONObject.optString("qrcodeid", "");
    this.kNG = paramJSONObject.optString("notice", "");
    this.kNH = paramJSONObject.optString("notice_url", "");
    ab.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s", new Object[] { this.qju, this.qjv, this.desc, Long.valueOf(this.cNd), Integer.valueOf(this.kNJ), this.kNF });
    ab.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[] { this.kNI });
    AppMethodBeat.o(44763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.r
 * JD-Core Version:    0.7.0.1
 */