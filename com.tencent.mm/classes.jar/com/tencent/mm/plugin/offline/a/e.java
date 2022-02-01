package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.c.w;
import org.json.JSONObject;

public final class e
  extends w
{
  private g callback;
  public int dcG;
  private String nTK;
  private final b rr;
  public String ujI;
  public int ujJ;
  public String ujK;
  public int ujL;
  public RealnameGuideHelper ujM;
  private String ujN;
  private String ujO;
  private String ujP;
  private String ujQ;
  private String ujR;
  
  public e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66289);
    this.ujI = "";
    this.dcG = -1;
    this.nTK = "";
    this.ujJ = -1;
    this.ujK = "";
    this.ujL = 1;
    b.a locala = new b.a();
    locala.gUU = new bue();
    locala.gUV = new buf();
    locala.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
    locala.funcId = 609;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.routeInfo = com.tencent.mm.wallet_core.ui.e.aNn(paramString3);
    this.rr = locala.atI();
    paramString3 = (bue)this.rr.gUS.gUX;
    paramString3.DRz = paramInt;
    paramString3.Id = paramString1;
    paramString3.ijt = paramString2;
    paramString3.CPi = k.ebS();
    this.ujL = paramInt;
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
      ad.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : " + getType() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    }
    paramArrayOfByte = (buf)((b)paramq).gUT.gUX;
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
      if (paramArrayOfByte.DvZ != null)
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.DvZ);
        this.ujI = paramArrayOfByte.optString("transaction_id");
        this.dcG = paramArrayOfByte.optInt("retcode");
        this.nTK = paramArrayOfByte.optString("retmsg");
        this.ujJ = paramArrayOfByte.optInt("wx_error_type");
        this.ujK = paramArrayOfByte.optString("wx_error_msg");
        ad.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[] { paramArrayOfByte.toString() });
        paramInt1 = paramInt2;
        i = paramInt3;
        paramq = paramString;
        if (paramArrayOfByte.has("real_name_info"))
        {
          paramq = paramArrayOfByte.optJSONObject("real_name_info");
          this.ujN = paramq.optString("guide_flag");
          this.ujO = paramq.optString("guide_wording");
          this.ujP = paramq.optString("left_button_wording");
          this.ujQ = paramq.optString("right_button_wording");
          this.ujR = paramq.optString("upload_credit_url");
          if (!"1".equals(this.ujN))
          {
            paramInt1 = paramInt2;
            i = paramInt3;
            paramq = paramString;
            if (!"2".equals(this.ujN)) {}
          }
          else
          {
            this.ujM = new RealnameGuideHelper();
            this.ujM.b(this.ujN, this.ujO, this.ujP, this.ujQ, this.ujR, 0);
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
        ad.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", paramString, "", new Object[0]);
        paramInt1 = 1000;
        i = 2;
        paramq = aj.getContext().getString(2131765224);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, i, paramq, this);
    }
    AppMethodBeat.o(66291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.e
 * JD-Core Version:    0.7.0.1
 */