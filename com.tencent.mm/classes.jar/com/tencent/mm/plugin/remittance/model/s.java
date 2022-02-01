package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends a
{
  public long dPq;
  public String desc;
  public String iWA;
  public String iWB;
  public int phn;
  public String pho;
  public String php;
  public int phq;
  public String ynZ;
  public String yoa;
  public String yob;
  public String yoc;
  
  public s(String paramString)
  {
    AppMethodBeat.i(67875);
    HashMap localHashMap = new HashMap();
    try
    {
      if (!bu.isNullOrNil(paramString)) {
        localHashMap.put("qrcode_url", URLEncoder.encode(paramString, "UTF-8"));
      }
      setRequestData(localHashMap);
      ae.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", new Object[] { paramString });
      AppMethodBeat.o(67875);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
  }
  
  public final int cbK()
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
    this.ynZ = paramJSONObject.optString("recv_username", "");
    this.php = paramJSONObject.optString("recv_realname", "");
    this.yoa = paramJSONObject.optString("recv_nickname", "");
    this.desc = paramJSONObject.optString("desc", "");
    this.dPq = paramJSONObject.optLong("amount", 0L);
    this.phq = paramJSONObject.optInt("set_amount", 0);
    this.phn = paramJSONObject.optInt("currency", 0);
    this.pho = paramJSONObject.optString("currencyunit", "");
    this.yob = paramJSONObject.optString("qrcodeid", "");
    this.iWA = paramJSONObject.optString("notice", "");
    this.iWB = paramJSONObject.optString("notice_url", "");
    this.yoc = paramJSONObject.optString("recv_headimgurl", "");
    ae.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s recv_headimgurl: %s", new Object[] { this.ynZ, this.yoa, this.desc, Long.valueOf(this.dPq), Integer.valueOf(this.phq), this.pho, this.yoc });
    ae.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[] { this.php });
    AppMethodBeat.o(67876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.s
 * JD-Core Version:    0.7.0.1
 */