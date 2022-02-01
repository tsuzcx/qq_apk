package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.wallet_core.c.w;
import org.json.JSONObject;

public final class e
  extends w
{
  private g callback;
  public int dae;
  private String oxf;
  private final b rr;
  public String vsE;
  public int vsF;
  public String vsG;
  public int vsH;
  public RealnameGuideHelper vsI;
  private String vsJ;
  private String vsK;
  private String vsL;
  private String vsM;
  private String vsN;
  
  public e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66289);
    this.vsE = "";
    this.dae = -1;
    this.oxf = "";
    this.vsF = -1;
    this.vsG = "";
    this.vsH = 1;
    b.a locala = new b.a();
    locala.hvt = new byv();
    locala.hvu = new byw();
    locala.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
    locala.funcId = 609;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.routeInfo = com.tencent.mm.wallet_core.ui.e.aSQ(paramString3);
    this.rr = locala.aAz();
    paramString3 = (byv)this.rr.hvr.hvw;
    paramString3.FnR = paramInt;
    paramString3.Id = paramString1;
    paramString3.iJA = paramString2;
    paramString3.EhT = k.ero();
    this.vsH = paramInt;
    AppMethodBeat.o(66289);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(66290);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66290);
    return i;
  }
  
  public final int getType()
  {
    return 609;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66291);
    if (paramInt2 != 0) {
      ac.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : " + getType() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    }
    paramArrayOfByte = (byw)((b)paramq).hvs.hvw;
    paramInt1 = paramInt2;
    i = paramInt3;
    paramq = paramString;
    if (paramInt2 == 0)
    {
      paramInt1 = paramInt2;
      i = paramInt3;
      paramq = paramString;
      if (paramInt3 == 0)
      {
        paramInt1 = paramInt2;
        i = paramInt3;
        paramq = paramString;
      }
    }
    try
    {
      if (paramArrayOfByte.ERu != null)
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.ERu);
        this.vsE = paramArrayOfByte.optString("transaction_id");
        this.dae = paramArrayOfByte.optInt("retcode");
        this.oxf = paramArrayOfByte.optString("retmsg");
        this.vsF = paramArrayOfByte.optInt("wx_error_type");
        this.vsG = paramArrayOfByte.optString("wx_error_msg");
        ac.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[] { paramArrayOfByte.toString() });
        paramInt1 = paramInt2;
        i = paramInt3;
        paramq = paramString;
        if (paramArrayOfByte.has("real_name_info"))
        {
          paramq = paramArrayOfByte.optJSONObject("real_name_info");
          this.vsJ = paramq.optString("guide_flag");
          this.vsK = paramq.optString("guide_wording");
          this.vsL = paramq.optString("left_button_wording");
          this.vsM = paramq.optString("right_button_wording");
          this.vsN = paramq.optString("upload_credit_url");
          if (!"1".equals(this.vsJ))
          {
            paramInt1 = paramInt2;
            i = paramInt3;
            paramq = paramString;
            if (!"2".equals(this.vsJ)) {}
          }
          else
          {
            this.vsI = new RealnameGuideHelper();
            this.vsI.b(this.vsJ, this.vsK, this.vsL, this.vsM, this.vsN, 0);
            paramq = paramString;
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
        ac.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", paramString, "", new Object[0]);
        paramInt1 = 1000;
        i = 2;
        paramq = ai.getContext().getString(2131765224);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, i, paramq, this);
    }
    AppMethodBeat.o(66291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.e
 * JD-Core Version:    0.7.0.1
 */