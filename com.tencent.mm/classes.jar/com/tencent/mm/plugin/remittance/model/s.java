package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends a
{
  public long dOa;
  public String desc;
  public String iTH;
  public String iTI;
  public int paJ;
  public String paK;
  public String paL;
  public int paM;
  public String xYh;
  public String xYi;
  public String xYj;
  public String xYk;
  
  public s(String paramString)
  {
    AppMethodBeat.i(67875);
    HashMap localHashMap = new HashMap();
    try
    {
      if (!bt.isNullOrNil(paramString)) {
        localHashMap.put("qrcode_url", URLEncoder.encode(paramString, "UTF-8"));
      }
      setRequestData(localHashMap);
      ad.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", new Object[] { paramString });
      AppMethodBeat.o(67875);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String cau()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
  }
  
  public final int cav()
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
    this.xYh = paramJSONObject.optString("recv_username", "");
    this.paL = paramJSONObject.optString("recv_realname", "");
    this.xYi = paramJSONObject.optString("recv_nickname", "");
    this.desc = paramJSONObject.optString("desc", "");
    this.dOa = paramJSONObject.optLong("amount", 0L);
    this.paM = paramJSONObject.optInt("set_amount", 0);
    this.paJ = paramJSONObject.optInt("currency", 0);
    this.paK = paramJSONObject.optString("currencyunit", "");
    this.xYj = paramJSONObject.optString("qrcodeid", "");
    this.iTH = paramJSONObject.optString("notice", "");
    this.iTI = paramJSONObject.optString("notice_url", "");
    this.xYk = paramJSONObject.optString("recv_headimgurl", "");
    ad.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s recv_headimgurl: %s", new Object[] { this.xYh, this.xYi, this.desc, Long.valueOf(this.dOa), Integer.valueOf(this.paM), this.paK, this.xYk });
    ad.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[] { this.paL });
    AppMethodBeat.o(67876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.s
 * JD-Core Version:    0.7.0.1
 */