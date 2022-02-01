package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.ceh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.wallet_core.c.w;
import org.json.JSONObject;

public final class e
  extends w
{
  private com.tencent.mm.ak.f callback;
  public int dmy;
  private String phe;
  private final b rr;
  public String wNH;
  public int wNI;
  public String wNJ;
  public int wNK;
  public RealnameGuideHelper wNL;
  private String wNM;
  private String wNN;
  private String wNO;
  private String wNP;
  private String wNQ;
  
  public e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66289);
    this.wNH = "";
    this.dmy = -1;
    this.phe = "";
    this.wNI = -1;
    this.wNJ = "";
    this.wNK = 1;
    b.a locala = new b.a();
    locala.hQF = new ceg();
    locala.hQG = new ceh();
    locala.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
    locala.funcId = 609;
    locala.hQH = 0;
    locala.respCmdId = 0;
    locala.routeInfo = com.tencent.mm.wallet_core.ui.f.bas(paramString3);
    this.rr = locala.aDS();
    paramString3 = (ceg)this.rr.hQD.hQJ;
    paramString3.Hra = paramInt;
    paramString3.Id = paramString1;
    paramString3.jfC = paramString2;
    paramString3.Ghz = k.eIV();
    this.wNK = paramInt;
    AppMethodBeat.o(66289);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(66290);
    this.callback = paramf;
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
      ae.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : " + getType() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    }
    paramArrayOfByte = (ceh)((b)paramq).hQE.hQJ;
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
      if (paramArrayOfByte.GUm != null)
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.GUm);
        this.wNH = paramArrayOfByte.optString("transaction_id");
        this.dmy = paramArrayOfByte.optInt("retcode");
        this.phe = paramArrayOfByte.optString("retmsg");
        this.wNI = paramArrayOfByte.optInt("wx_error_type");
        this.wNJ = paramArrayOfByte.optString("wx_error_msg");
        ae.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[] { paramArrayOfByte.toString() });
        paramInt1 = paramInt2;
        i = paramInt3;
        paramq = paramString;
        if (paramArrayOfByte.has("real_name_info"))
        {
          paramq = paramArrayOfByte.optJSONObject("real_name_info");
          this.wNM = paramq.optString("guide_flag");
          this.wNN = paramq.optString("guide_wording");
          this.wNO = paramq.optString("left_button_wording");
          this.wNP = paramq.optString("right_button_wording");
          this.wNQ = paramq.optString("upload_credit_url");
          if (!"1".equals(this.wNM))
          {
            paramInt1 = paramInt2;
            i = paramInt3;
            paramq = paramString;
            if (!"2".equals(this.wNM)) {}
          }
          else
          {
            this.wNL = new RealnameGuideHelper();
            this.wNL.b(this.wNM, this.wNN, this.wNO, this.wNP, this.wNQ, 0);
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
        ae.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", paramString, "", new Object[0]);
        paramInt1 = 1000;
        i = 2;
        paramq = ak.getContext().getString(2131765224);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, i, paramq, this);
    }
    AppMethodBeat.o(66291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.e
 * JD-Core Version:    0.7.0.1
 */