package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.protocal.protobuf.dvu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.model.w;
import com.tencent.mm.wallet_core.ui.i;
import org.json.JSONObject;

public final class g
  extends w
{
  public String MyF;
  public int MyG;
  public String MyH;
  public int MyI;
  public RealnameGuideHelper MyJ;
  private String MyK;
  private String MyL;
  private String MyM;
  private String MyN;
  private String MyO;
  private h callback;
  public int hAV;
  private final c rr;
  private String wYI;
  
  public g(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66289);
    this.MyF = "";
    this.hAV = -1;
    this.wYI = "";
    this.MyG = -1;
    this.MyH = "";
    this.MyI = 1;
    c.a locala = new c.a();
    locala.otE = new dvt();
    locala.otF = new dvu();
    locala.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
    locala.funcId = 609;
    locala.otG = 0;
    locala.respCmdId = 0;
    locala.routeInfo = i.bEV(paramString3);
    this.rr = locala.bEF();
    paramString3 = (dvt)c.b.b(this.rr.otB);
    paramString3.abbu = paramInt;
    paramString3.Id = paramString1;
    paramString3.pRM = paramString2;
    paramString3.Zbi = k.iis();
    this.MyI = paramInt;
    AppMethodBeat.o(66289);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(66290);
    this.callback = paramh;
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
    paramArrayOfByte = (dvu)c.c.b(((c)params).otC);
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
      if (paramArrayOfByte.aavo != null)
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.aavo);
        this.MyF = paramArrayOfByte.optString("transaction_id");
        this.hAV = paramArrayOfByte.optInt("retcode");
        this.wYI = paramArrayOfByte.optString("retmsg");
        this.MyG = paramArrayOfByte.optInt("wx_error_type");
        this.MyH = paramArrayOfByte.optString("wx_error_msg");
        Log.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[] { paramArrayOfByte.toString() });
        paramInt1 = paramInt2;
        i = paramInt3;
        params = paramString;
        if (paramArrayOfByte.has("real_name_info"))
        {
          params = paramArrayOfByte.optJSONObject("real_name_info");
          this.MyK = params.optString("guide_flag");
          this.MyL = params.optString("guide_wording");
          this.MyM = params.optString("left_button_wording");
          this.MyN = params.optString("right_button_wording");
          this.MyO = params.optString("upload_credit_url");
          if (!"1".equals(this.MyK))
          {
            paramInt1 = paramInt2;
            i = paramInt3;
            params = paramString;
            if (!"2".equals(this.MyK)) {}
          }
          else
          {
            this.MyJ = new RealnameGuideHelper();
            this.MyJ.a(this.MyK, this.MyL, this.MyM, this.MyN, this.MyO, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.g
 * JD-Core Version:    0.7.0.1
 */