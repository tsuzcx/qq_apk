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
  public long dEb;
  public String desc;
  public String iau;
  public String iav;
  public int nTT;
  public String nTU;
  public String nTV;
  public int nTW;
  public String vAv;
  public String vAw;
  public String vAx;
  public String vAy;
  
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
  
  public final String bOB()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
  }
  
  public final int bOC()
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
    this.vAv = paramJSONObject.optString("recv_username", "");
    this.nTV = paramJSONObject.optString("recv_realname", "");
    this.vAw = paramJSONObject.optString("recv_nickname", "");
    this.desc = paramJSONObject.optString("desc", "");
    this.dEb = paramJSONObject.optLong("amount", 0L);
    this.nTW = paramJSONObject.optInt("set_amount", 0);
    this.nTT = paramJSONObject.optInt("currency", 0);
    this.nTU = paramJSONObject.optString("currencyunit", "");
    this.vAx = paramJSONObject.optString("qrcodeid", "");
    this.iau = paramJSONObject.optString("notice", "");
    this.iav = paramJSONObject.optString("notice_url", "");
    this.vAy = paramJSONObject.optString("recv_headimgurl", "");
    ad.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s recv_headimgurl: %s", new Object[] { this.vAv, this.vAw, this.desc, Long.valueOf(this.dEb), Integer.valueOf(this.nTW), this.nTU, this.vAy });
    ad.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[] { this.nTV });
    AppMethodBeat.o(67876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.s
 * JD-Core Version:    0.7.0.1
 */