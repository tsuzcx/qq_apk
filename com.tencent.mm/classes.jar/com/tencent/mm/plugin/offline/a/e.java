package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.protocal.protobuf.ddw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.w;
import org.json.JSONObject;

public final class e
  extends w
{
  private String GCA;
  private String GCB;
  private String GCC;
  private String GCD;
  public String GCu;
  public int GCv;
  public String GCw;
  public int GCx;
  public RealnameGuideHelper GCy;
  private String GCz;
  private i callback;
  public int fwx;
  private final d rr;
  private String tVo;
  
  public e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66289);
    this.GCu = "";
    this.fwx = -1;
    this.tVo = "";
    this.GCv = -1;
    this.GCw = "";
    this.GCx = 1;
    d.a locala = new d.a();
    locala.lBU = new ddv();
    locala.lBV = new ddw();
    locala.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
    locala.funcId = 609;
    locala.lBW = 0;
    locala.respCmdId = 0;
    locala.routeInfo = com.tencent.mm.wallet_core.ui.g.bCx(paramString3);
    this.rr = locala.bgN();
    paramString3 = (ddv)d.b.b(this.rr.lBR);
    paramString3.TLv = paramInt;
    paramString3.Id = paramString1;
    paramString3.mVf = paramString2;
    paramString3.Sdp = k.gJe();
    this.GCx = paramInt;
    AppMethodBeat.o(66289);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(66290);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66290);
    return i;
  }
  
  public final int getType()
  {
    return 609;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66291);
    if (paramInt2 != 0) {
      Log.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : " + getType() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    }
    paramArrayOfByte = (ddw)d.c.b(((d)params).lBS);
    paramInt1 = paramInt2;
    i = paramInt3;
    params = paramString;
    if (paramInt2 == 0)
    {
      paramInt1 = paramInt2;
      i = paramInt3;
      params = paramString;
      if (paramInt3 == 0)
      {
        paramInt1 = paramInt2;
        i = paramInt3;
        params = paramString;
      }
    }
    try
    {
      if (paramArrayOfByte.ThY != null)
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.ThY);
        this.GCu = paramArrayOfByte.optString("transaction_id");
        this.fwx = paramArrayOfByte.optInt("retcode");
        this.tVo = paramArrayOfByte.optString("retmsg");
        this.GCv = paramArrayOfByte.optInt("wx_error_type");
        this.GCw = paramArrayOfByte.optString("wx_error_msg");
        Log.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[] { paramArrayOfByte.toString() });
        paramInt1 = paramInt2;
        i = paramInt3;
        params = paramString;
        if (paramArrayOfByte.has("real_name_info"))
        {
          params = paramArrayOfByte.optJSONObject("real_name_info");
          this.GCz = params.optString("guide_flag");
          this.GCA = params.optString("guide_wording");
          this.GCB = params.optString("left_button_wording");
          this.GCC = params.optString("right_button_wording");
          this.GCD = params.optString("upload_credit_url");
          if (!"1".equals(this.GCz))
          {
            paramInt1 = paramInt2;
            i = paramInt3;
            params = paramString;
            if (!"2".equals(this.GCz)) {}
          }
          else
          {
            this.GCy = new RealnameGuideHelper();
            this.GCy.a(this.GCz, this.GCA, this.GCB, this.GCC, this.GCD, 0);
            params = paramString;
            i = paramInt3;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", paramString, "", new Object[0]);
        paramInt1 = 1000;
        i = 2;
        params = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, i, params, this);
    }
    AppMethodBeat.o(66291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.e
 * JD-Core Version:    0.7.0.1
 */