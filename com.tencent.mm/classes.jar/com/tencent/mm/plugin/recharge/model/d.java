package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  private f callback;
  public int hKr;
  public String jFZ;
  public String jki;
  public com.tencent.mm.ak.b rr;
  public String xDa;
  public MallRechargeProduct xDi;
  public List<MallRechargeProduct> xDj;
  public String xDk;
  
  public d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67104);
    this.xDi = null;
    this.xDj = null;
    this.xDa = null;
    this.jFZ = paramString1;
    this.hKr = paramInt;
    this.jki = paramString5;
    this.xDk = paramString2;
    paramString5 = new b.a();
    paramString5.hQF = new bdm();
    paramString5.hQG = new bdn();
    paramString5.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
    paramString5.funcId = 497;
    paramString5.hQH = 229;
    paramString5.respCmdId = 1000000229;
    this.rr = paramString5.aDS();
    paramString5 = (bdm)this.rr.hQD.hQJ;
    paramString5.GKy = paramString1;
    paramString5.GKz = paramString3;
    paramString5.GSQ = paramString2;
    paramString5.GKA = paramString4;
    paramString5.xrf = c.eKB().aFV(paramString1);
    ae.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[] { paramString1, paramString3, paramString2, paramString4 }));
    AppMethodBeat.o(67104);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67106);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67106);
    return i;
  }
  
  public final int getType()
  {
    return 497;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67105);
    ae.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + paramInt3 + ", errMsg " + paramString);
    paramArrayOfByte = (bdn)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    ae.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + paramArrayOfByte.GKD);
    paramq = paramArrayOfByte.GKD;
    this.xDa = "";
    if (!bu.isNullOrNil(paramq))
    {
      paramq = paramq.split("&");
      if ((paramq != null) && (paramq.length > 0))
      {
        paramInt1 = 1;
        int i = 0;
        if (i < paramq.length)
        {
          String[] arrayOfString = paramq[i].split("=");
          int j = paramInt1;
          if (arrayOfString.length == 2)
          {
            if (paramInt1 != 0) {
              break label229;
            }
            this.xDa += " ";
          }
          for (;;)
          {
            this.xDa += arrayOfString[1];
            j = paramInt1;
            i += 1;
            paramInt1 = j;
            break;
            label229:
            paramInt1 = 0;
          }
        }
      }
    }
    if (!bu.isNullOrNil(paramArrayOfByte.GSS)) {}
    try
    {
      paramq = new JSONObject(paramArrayOfByte.GSS);
      this.xDj = b.a(this.jFZ, paramq.optJSONArray("product_info"));
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramq = paramArrayOfByte.GSR;
        ae.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(paramq)));
        if (bu.isNullOrNil(paramq)) {}
      }
    }
    catch (JSONException paramq)
    {
      try
      {
        this.xDi = b.k(this.jFZ, new JSONObject(paramq));
        this.xDi.xDa = this.xDa;
        ae.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[] { Integer.valueOf(paramArrayOfByte.GKB), paramArrayOfByte.GKC, Integer.valueOf(paramArrayOfByte.GKE), paramArrayOfByte.GKF }));
        paramInt1 = paramInt3;
        if (paramInt3 == 0)
        {
          if (paramArrayOfByte.GKE != 0) {
            paramInt1 = paramArrayOfByte.GKE;
          }
        }
        else
        {
          paramq = paramString;
          if (bu.isNullOrNil(paramString))
          {
            if (bu.isNullOrNil(paramArrayOfByte.GKF)) {
              break label513;
            }
            paramq = paramArrayOfByte.GKF;
          }
          this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
          AppMethodBeat.o(67105);
          return;
          paramq = paramq;
          ae.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
        }
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
          continue;
          paramInt1 = paramArrayOfByte.GKB;
          continue;
          label513:
          paramq = paramArrayOfByte.GKC;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.d
 * JD-Core Version:    0.7.0.1
 */