package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.f;
import org.json.JSONObject;

public final class e
  extends w
{
  public String AJn;
  public int AJo;
  public String AJp;
  public int AJq;
  public RealnameGuideHelper AJr;
  private String AJs;
  private String AJt;
  private String AJu;
  private String AJv;
  private String AJw;
  private i callback;
  public int dDN;
  private String qwn;
  private final d rr;
  
  public e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66289);
    this.AJn = "";
    this.dDN = -1;
    this.qwn = "";
    this.AJo = -1;
    this.AJp = "";
    this.AJq = 1;
    d.a locala = new d.a();
    locala.iLN = new cun();
    locala.iLO = new cuo();
    locala.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
    locala.funcId = 609;
    locala.iLP = 0;
    locala.respCmdId = 0;
    locala.routeInfo = f.bpA(paramString3);
    this.rr = locala.aXF();
    paramString3 = (cun)this.rr.iLK.iLR;
    paramString3.MzP = paramInt;
    paramString3.Id = paramString1;
    paramString3.kdF = paramString2;
    paramString3.Lcc = k.fQy();
    this.AJq = paramInt;
    AppMethodBeat.o(66289);
  }
  
  public final int doScene(g paramg, i parami)
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
    paramArrayOfByte = (cuo)((d)params).iLL.iLR;
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
      if (paramArrayOfByte.LYE != null)
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.LYE);
        this.AJn = paramArrayOfByte.optString("transaction_id");
        this.dDN = paramArrayOfByte.optInt("retcode");
        this.qwn = paramArrayOfByte.optString("retmsg");
        this.AJo = paramArrayOfByte.optInt("wx_error_type");
        this.AJp = paramArrayOfByte.optString("wx_error_msg");
        Log.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[] { paramArrayOfByte.toString() });
        paramInt1 = paramInt2;
        i = paramInt3;
        params = paramString;
        if (paramArrayOfByte.has("real_name_info"))
        {
          params = paramArrayOfByte.optJSONObject("real_name_info");
          this.AJs = params.optString("guide_flag");
          this.AJt = params.optString("guide_wording");
          this.AJu = params.optString("left_button_wording");
          this.AJv = params.optString("right_button_wording");
          this.AJw = params.optString("upload_credit_url");
          if (!"1".equals(this.AJs))
          {
            paramInt1 = paramInt2;
            i = paramInt3;
            params = paramString;
            if (!"2".equals(this.AJs)) {}
          }
          else
          {
            this.AJr = new RealnameGuideHelper();
            this.AJr.b(this.AJs, this.AJt, this.AJu, this.AJv, this.AJw, 0);
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
        params = MMApplicationContext.getContext().getString(2131767667);
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