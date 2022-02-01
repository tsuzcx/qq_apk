package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  private f callback;
  public int hHz;
  public String jDb;
  public String jhp;
  public com.tencent.mm.al.b rr;
  public String xnd;
  public MallRechargeProduct xnl;
  public List<MallRechargeProduct> xnm;
  public String xnn;
  
  public d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67104);
    this.xnl = null;
    this.xnm = null;
    this.xnd = null;
    this.jDb = paramString1;
    this.hHz = paramInt;
    this.jhp = paramString5;
    this.xnn = paramString2;
    paramString5 = new b.a();
    paramString5.hNM = new bcw();
    paramString5.hNN = new bcx();
    paramString5.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
    paramString5.funcId = 497;
    paramString5.hNO = 229;
    paramString5.respCmdId = 1000000229;
    this.rr = paramString5.aDC();
    paramString5 = (bcw)this.rr.hNK.hNQ;
    paramString5.Gra = paramString1;
    paramString5.Grb = paramString3;
    paramString5.Gzq = paramString2;
    paramString5.Grc = paramString4;
    paramString5.xbo = c.eGT().aEB(paramString1);
    ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[] { paramString1, paramString3, paramString2, paramString4 }));
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
    ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + paramInt3 + ", errMsg " + paramString);
    paramArrayOfByte = (bcx)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + paramArrayOfByte.Grf);
    paramq = paramArrayOfByte.Grf;
    this.xnd = "";
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
            this.xnd += " ";
          }
          for (;;)
          {
            this.xnd += arrayOfString[1];
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
    if (!bt.isNullOrNil(paramArrayOfByte.Gzs)) {}
    try
    {
      paramq = new JSONObject(paramArrayOfByte.Gzs);
      this.xnm = b.a(this.jDb, paramq.optJSONArray("product_info"));
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramq = paramArrayOfByte.Gzr;
        ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(paramq)));
        if (bt.isNullOrNil(paramq)) {}
      }
    }
    catch (JSONException paramq)
    {
      try
      {
        this.xnl = b.k(this.jDb, new JSONObject(paramq));
        this.xnl.xnd = this.xnd;
        ad.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[] { Integer.valueOf(paramArrayOfByte.Grd), paramArrayOfByte.Gre, Integer.valueOf(paramArrayOfByte.Grg), paramArrayOfByte.Grh }));
        paramInt1 = paramInt3;
        if (paramInt3 == 0)
        {
          if (paramArrayOfByte.Grg != 0) {
            paramInt1 = paramArrayOfByte.Grg;
          }
        }
        else
        {
          paramq = paramString;
          if (bt.isNullOrNil(paramString))
          {
            if (bt.isNullOrNil(paramArrayOfByte.Grh)) {
              break label513;
            }
            paramq = paramArrayOfByte.Grh;
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
          paramInt1 = paramArrayOfByte.Grd;
          continue;
          label513:
          paramq = paramArrayOfByte.Gre;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.d
 * JD-Core Version:    0.7.0.1
 */