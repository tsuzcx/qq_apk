package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r
  extends a
{
  public long ceq;
  public String desc;
  public int iHA;
  public String iHB;
  public String iHC;
  public String iHD;
  public String iHE;
  public int iHF;
  public String nyu;
  public String nyv;
  public String nyw;
  
  public r(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      if (!bk.bl(paramString)) {
        localHashMap.put("qrcode_url", URLEncoder.encode(paramString, "UTF-8"));
      }
      D(localHashMap);
      y.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", new Object[] { paramString });
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.nyu = paramJSONObject.optString("recv_username", "");
    this.iHE = paramJSONObject.optString("recv_realname", "");
    this.nyv = paramJSONObject.optString("recv_nickname", "");
    this.desc = paramJSONObject.optString("desc", "");
    this.ceq = paramJSONObject.optLong("amount", 0L);
    this.iHF = paramJSONObject.optInt("set_amount", 0);
    this.iHA = paramJSONObject.optInt("currency", 0);
    this.iHB = paramJSONObject.optString("currencyunit", "");
    this.nyw = paramJSONObject.optString("qrcodeid", "");
    this.iHC = paramJSONObject.optString("notice", "");
    this.iHD = paramJSONObject.optString("notice_url", "");
    y.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s", new Object[] { this.nyu, this.nyv, this.desc, Long.valueOf(this.ceq), Integer.valueOf(this.iHF), this.iHB });
    y.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[] { this.iHE });
  }
  
  public final int aEA()
  {
    return 1301;
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
  }
  
  public final int getType()
  {
    return 1301;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.r
 * JD-Core Version:    0.7.0.1
 */