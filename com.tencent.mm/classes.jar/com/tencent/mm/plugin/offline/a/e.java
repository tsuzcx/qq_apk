package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.c.w;
import org.json.JSONObject;

public final class e
  extends w
{
  private f callback;
  public int dlw;
  private String paA;
  private final b rr;
  public String wxW;
  public int wxX;
  public String wxY;
  public int wxZ;
  public RealnameGuideHelper wya;
  private String wyb;
  private String wyc;
  private String wyd;
  private String wye;
  private String wyf;
  
  public e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66289);
    this.wxW = "";
    this.dlw = -1;
    this.paA = "";
    this.wxX = -1;
    this.wxY = "";
    this.wxZ = 1;
    b.a locala = new b.a();
    locala.hNM = new cdm();
    locala.hNN = new cdn();
    locala.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
    locala.funcId = 609;
    locala.hNO = 0;
    locala.respCmdId = 0;
    locala.routeInfo = com.tencent.mm.wallet_core.ui.e.aYP(paramString3);
    this.rr = locala.aDC();
    paramString3 = (cdm)this.rr.hNK.hNQ;
    paramString3.GXA = paramInt;
    paramString3.Id = paramString1;
    paramString3.jcJ = paramString2;
    paramString3.FPa = k.eFo();
    this.wxZ = paramInt;
    AppMethodBeat.o(66289);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
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
      ad.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : " + getType() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    }
    paramArrayOfByte = (cdn)((b)paramq).hNL.hNQ;
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
      if (paramArrayOfByte.GAM != null)
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.GAM);
        this.wxW = paramArrayOfByte.optString("transaction_id");
        this.dlw = paramArrayOfByte.optInt("retcode");
        this.paA = paramArrayOfByte.optString("retmsg");
        this.wxX = paramArrayOfByte.optInt("wx_error_type");
        this.wxY = paramArrayOfByte.optString("wx_error_msg");
        ad.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[] { paramArrayOfByte.toString() });
        paramInt1 = paramInt2;
        i = paramInt3;
        paramq = paramString;
        if (paramArrayOfByte.has("real_name_info"))
        {
          paramq = paramArrayOfByte.optJSONObject("real_name_info");
          this.wyb = paramq.optString("guide_flag");
          this.wyc = paramq.optString("guide_wording");
          this.wyd = paramq.optString("left_button_wording");
          this.wye = paramq.optString("right_button_wording");
          this.wyf = paramq.optString("upload_credit_url");
          if (!"1".equals(this.wyb))
          {
            paramInt1 = paramInt2;
            i = paramInt3;
            paramq = paramString;
            if (!"2".equals(this.wyb)) {}
          }
          else
          {
            this.wya = new RealnameGuideHelper();
            this.wya.b(this.wyb, this.wyc, this.wyd, this.wye, this.wyf, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.e
 * JD-Core Version:    0.7.0.1
 */