package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  private g callback;
  public int gOH;
  public String ioa;
  public com.tencent.mm.al.b rr;
  public String uWF;
  public String uWG;
  public MallRechargeProduct uWO;
  public List<MallRechargeProduct> uWP;
  public String uWQ;
  
  public d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67104);
    this.uWO = null;
    this.uWP = null;
    this.uWG = null;
    this.uWF = paramString1;
    this.gOH = paramInt;
    this.ioa = paramString5;
    this.uWQ = paramString2;
    paramString5 = new b.a();
    paramString5.gUU = new avm();
    paramString5.gUV = new avn();
    paramString5.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
    paramString5.funcId = 497;
    paramString5.reqCmdId = 229;
    paramString5.respCmdId = 1000000229;
    this.rr = paramString5.atI();
    paramString5 = (avm)this.rr.gUS.gUX;
    paramString5.Dnj = paramString1;
    paramString5.Dnk = paramString3;
    paramString5.DuQ = paramString2;
    paramString5.Dnl = paramString4;
    paramString5.Ddo = c.eds().atZ(paramString1);
    ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[] { paramString1, paramString3, paramString2, paramString4 }));
    AppMethodBeat.o(67104);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67106);
    this.callback = paramg;
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
    ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + paramInt3 + ", errMsg " + paramString);
    paramArrayOfByte = (avn)((com.tencent.mm.al.b)paramq).gUT.gUX;
    ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + paramArrayOfByte.Dno);
    paramq = paramArrayOfByte.Dno;
    this.uWG = "";
    if (!bt.isNullOrNil(paramq))
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
            this.uWG += " ";
          }
          for (;;)
          {
            this.uWG += arrayOfString[1];
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
    if (!bt.isNullOrNil(paramArrayOfByte.DuS)) {}
    try
    {
      paramq = new JSONObject(paramArrayOfByte.DuS);
      this.uWP = b.a(this.uWF, paramq.optJSONArray("product_info"));
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramq = paramArrayOfByte.DuR;
        ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(paramq)));
        if (bt.isNullOrNil(paramq)) {}
      }
    }
    catch (JSONException paramq)
    {
      try
      {
        this.uWO = b.j(this.uWF, new JSONObject(paramq));
        this.uWO.uWG = this.uWG;
        ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[] { Integer.valueOf(paramArrayOfByte.Dnm), paramArrayOfByte.Dnn, Integer.valueOf(paramArrayOfByte.Dnp), paramArrayOfByte.Dnq }));
        paramInt1 = paramInt3;
        if (paramInt3 == 0)
        {
          if (paramArrayOfByte.Dnp != 0) {
            paramInt1 = paramArrayOfByte.Dnp;
          }
        }
        else
        {
          paramq = paramString;
          if (bt.isNullOrNil(paramString))
          {
            if (bt.isNullOrNil(paramArrayOfByte.Dnq)) {
              break label513;
            }
            paramq = paramArrayOfByte.Dnq;
          }
          this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
          AppMethodBeat.o(67105);
          return;
          paramq = paramq;
          ad.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
        }
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
          continue;
          paramInt1 = paramArrayOfByte.Dnm;
          continue;
          label513:
          paramq = paramArrayOfByte.Dnn;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.d
 * JD-Core Version:    0.7.0.1
 */