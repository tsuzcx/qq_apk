package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.azv;
import com.tencent.mm.protocal.c.azw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;
import org.json.JSONObject;

public final class e
  extends s
{
  private final b dmK;
  private f dmL;
  public int iHq = -1;
  private String iHr = "";
  public String mKL = "";
  public int mKM = -1;
  public String mKN = "";
  public int mKO = 1;
  public RealnameGuideHelper mKP;
  private String mKQ;
  private String mKR;
  private String mKS;
  private String mKT;
  private String mKU;
  
  public e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    b.a locala = new b.a();
    locala.ecH = new azv();
    locala.ecI = new azw();
    locala.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
    locala.ecG = 609;
    locala.ecJ = 0;
    locala.ecK = 0;
    locala.ecM = com.tencent.mm.wallet_core.ui.e.afr(paramString3);
    this.dmK = locala.Kt();
    paramString3 = (azv)this.dmK.ecE.ecN;
    paramString3.tvS = paramInt;
    paramString3.lsK = paramString1;
    paramString3.feN = paramString2;
    paramString3.sHl = i.bVj();
    this.mKO = paramInt;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    if (paramInt1 != 0) {
      y.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : 609, errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    }
    Object localObject = (azw)((b)paramq).ecF.ecN;
    i = paramInt1;
    j = paramInt2;
    paramq = paramString;
    if (paramInt1 == 0)
    {
      i = paramInt1;
      j = paramInt2;
      paramq = paramString;
      if (paramInt2 == 0)
      {
        i = paramInt1;
        j = paramInt2;
        paramq = paramString;
      }
    }
    try
    {
      if (((azw)localObject).tfg != null)
      {
        localObject = new JSONObject(((azw)localObject).tfg);
        this.mKL = ((JSONObject)localObject).optString("transaction_id");
        this.iHq = ((JSONObject)localObject).optInt("retcode");
        this.iHr = ((JSONObject)localObject).optString("retmsg");
        this.mKM = ((JSONObject)localObject).optInt("wx_error_type");
        this.mKN = ((JSONObject)localObject).optString("wx_error_msg");
        y.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[] { ((JSONObject)localObject).toString() });
        i = paramInt1;
        j = paramInt2;
        paramq = paramString;
        if (((JSONObject)localObject).has("real_name_info"))
        {
          paramq = ((JSONObject)localObject).optJSONObject("real_name_info");
          this.mKQ = paramq.optString("guide_flag");
          this.mKR = paramq.optString("guide_wording");
          this.mKS = paramq.optString("left_button_wording");
          this.mKT = paramq.optString("right_button_wording");
          this.mKU = paramq.optString("upload_credit_url");
          if (!"1".equals(this.mKQ))
          {
            i = paramInt1;
            j = paramInt2;
            paramq = paramString;
            if (!"2".equals(this.mKQ)) {}
          }
          else
          {
            this.mKP = new RealnameGuideHelper();
            this.mKP.a(this.mKQ, this.mKR, this.mKS, this.mKT, this.mKU, 0);
            paramq = paramString;
            j = paramInt2;
            i = paramInt1;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", paramString, "", new Object[0]);
        i = 1000;
        j = 2;
        paramq = ae.getContext().getString(a.i.wallet_data_err);
      }
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(i, j, paramq, this);
    }
  }
  
  public final int getType()
  {
    return 609;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.e
 * JD-Core Version:    0.7.0.1
 */