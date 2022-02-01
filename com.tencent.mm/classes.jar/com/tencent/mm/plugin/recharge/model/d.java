package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  private g callback;
  public int hph;
  public String iOg;
  public com.tencent.mm.ak.b rr;
  public MallRechargeProduct wfD;
  public List<MallRechargeProduct> wfE;
  public String wfF;
  public String wfu;
  public String wfv;
  
  public d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67104);
    this.wfD = null;
    this.wfE = null;
    this.wfv = null;
    this.wfu = paramString1;
    this.hph = paramInt;
    this.iOg = paramString5;
    this.wfF = paramString2;
    paramString5 = new b.a();
    paramString5.hvt = new ays();
    paramString5.hvu = new ayt();
    paramString5.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
    paramString5.funcId = 497;
    paramString5.reqCmdId = 229;
    paramString5.respCmdId = 1000000229;
    this.rr = paramString5.aAz();
    paramString5 = (ays)this.rr.hvr.hvw;
    paramString5.EIj = paramString1;
    paramString5.EIk = paramString3;
    paramString5.EPZ = paramString2;
    paramString5.EIl = paramString4;
    paramString5.Ewu = c.esN().azr(paramString1);
    ac.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[] { paramString1, paramString3, paramString2, paramString4 }));
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
    ac.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + paramInt3 + ", errMsg " + paramString);
    paramArrayOfByte = (ayt)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    ac.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + paramArrayOfByte.EIo);
    paramq = paramArrayOfByte.EIo;
    this.wfv = "";
    if (!bs.isNullOrNil(paramq))
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
            this.wfv += " ";
          }
          for (;;)
          {
            this.wfv += arrayOfString[1];
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
    if (!bs.isNullOrNil(paramArrayOfByte.EQb)) {}
    try
    {
      paramq = new JSONObject(paramArrayOfByte.EQb);
      this.wfE = b.a(this.wfu, paramq.optJSONArray("product_info"));
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramq = paramArrayOfByte.EQa;
        ac.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(paramq)));
        if (bs.isNullOrNil(paramq)) {}
      }
    }
    catch (JSONException paramq)
    {
      try
      {
        this.wfD = b.j(this.wfu, new JSONObject(paramq));
        this.wfD.wfv = this.wfv;
        ac.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[] { Integer.valueOf(paramArrayOfByte.EIm), paramArrayOfByte.EIn, Integer.valueOf(paramArrayOfByte.EIp), paramArrayOfByte.EIq }));
        paramInt1 = paramInt3;
        if (paramInt3 == 0)
        {
          if (paramArrayOfByte.EIp != 0) {
            paramInt1 = paramArrayOfByte.EIp;
          }
        }
        else
        {
          paramq = paramString;
          if (bs.isNullOrNil(paramString))
          {
            if (bs.isNullOrNil(paramArrayOfByte.EIq)) {
              break label513;
            }
            paramq = paramArrayOfByte.EIq;
          }
          this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
          AppMethodBeat.o(67105);
          return;
          paramq = paramq;
          ac.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
        }
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
          continue;
          paramInt1 = paramArrayOfByte.EIm;
          continue;
          label513:
          paramq = paramArrayOfByte.EIn;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.d
 * JD-Core Version:    0.7.0.1
 */