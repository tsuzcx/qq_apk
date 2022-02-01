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

public final class u
  extends a
{
  public String IlR;
  public String IlS;
  public String IlT;
  public String IlU;
  public String desc;
  public long gbJ;
  public String mKL;
  public String mKM;
  public int tVA;
  public int tVx;
  public String tVy;
  public String tVz;
  
  public u(String paramString)
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
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
  }
  
  public final int cOe()
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
    this.IlR = paramJSONObject.optString("recv_username", "");
    this.tVz = paramJSONObject.optString("recv_realname", "");
    this.IlS = paramJSONObject.optString("recv_nickname", "");
    this.desc = paramJSONObject.optString("desc", "");
    this.gbJ = paramJSONObject.optLong("amount", 0L);
    this.tVA = paramJSONObject.optInt("set_amount", 0);
    this.tVx = paramJSONObject.optInt("currency", 0);
    this.tVy = paramJSONObject.optString("currencyunit", "");
    this.IlT = paramJSONObject.optString("qrcodeid", "");
    this.mKL = paramJSONObject.optString("notice", "");
    this.mKM = paramJSONObject.optString("notice_url", "");
    this.IlU = paramJSONObject.optString("recv_headimgurl", "");
    Log.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s recv_headimgurl: %s", new Object[] { this.IlR, this.IlS, this.desc, Long.valueOf(this.gbJ), Integer.valueOf(this.tVA), this.tVy, this.IlU });
    Log.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[] { this.tVz });
    AppMethodBeat.o(67876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.u
 * JD-Core Version:    0.7.0.1
 */