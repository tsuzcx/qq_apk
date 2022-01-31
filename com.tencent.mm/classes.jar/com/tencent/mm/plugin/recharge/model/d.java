package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends m
  implements k
{
  private f callback;
  public int fnf;
  public String gAF;
  public String pUM;
  public String pUN;
  public MallRechargeProduct pUV;
  public List<MallRechargeProduct> pUW;
  public String pUX;
  public com.tencent.mm.ai.b rr;
  
  public d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(44196);
    this.pUV = null;
    this.pUW = null;
    this.pUN = null;
    this.pUM = paramString1;
    this.fnf = paramInt;
    this.gAF = paramString5;
    this.pUX = paramString2;
    paramString5 = new b.a();
    paramString5.fsX = new alu();
    paramString5.fsY = new alv();
    paramString5.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
    paramString5.funcId = 497;
    paramString5.reqCmdId = 229;
    paramString5.respCmdId = 1000000229;
    this.rr = paramString5.ado();
    paramString5 = (alu)this.rr.fsV.fta;
    paramString5.wWF = paramString1;
    paramString5.wWG = paramString3;
    paramString5.xcu = paramString2;
    paramString5.wWH = paramString4;
    paramString5.wQf = c.cUX().afq(paramString1);
    ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[] { paramString1, paramString3, paramString2, paramString4 }));
    AppMethodBeat.o(44196);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44198);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44198);
    return i;
  }
  
  public final int getType()
  {
    return 497;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44197);
    ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + paramInt3 + ", errMsg " + paramString);
    paramArrayOfByte = (alv)((com.tencent.mm.ai.b)paramq).fsW.fta;
    ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + paramArrayOfByte.wWK);
    paramq = paramArrayOfByte.wWK;
    this.pUN = "";
    if (!bo.isNullOrNil(paramq))
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
            this.pUN += " ";
          }
          for (;;)
          {
            this.pUN += arrayOfString[1];
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
    if (!bo.isNullOrNil(paramArrayOfByte.xcw)) {}
    try
    {
      paramq = new JSONObject(paramArrayOfByte.xcw);
      this.pUW = b.a(this.pUM, paramq.optJSONArray("product_info"));
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramq = paramArrayOfByte.xcv;
        ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(paramq)));
        if (bo.isNullOrNil(paramq)) {}
      }
    }
    catch (JSONException paramq)
    {
      try
      {
        this.pUV = b.f(this.pUM, new JSONObject(paramq));
        this.pUV.pUN = this.pUN;
        ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[] { Integer.valueOf(paramArrayOfByte.wWI), paramArrayOfByte.wWJ, Integer.valueOf(paramArrayOfByte.wWL), paramArrayOfByte.wWM }));
        paramInt1 = paramInt3;
        if (paramInt3 == 0)
        {
          if (paramArrayOfByte.wWL != 0) {
            paramInt1 = paramArrayOfByte.wWL;
          }
        }
        else
        {
          paramq = paramString;
          if (bo.isNullOrNil(paramString))
          {
            if (bo.isNullOrNil(paramArrayOfByte.wWM)) {
              break label513;
            }
            paramq = paramArrayOfByte.wWM;
          }
          this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
          AppMethodBeat.o(44197);
          return;
          paramq = paramq;
          ab.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
        }
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
          continue;
          paramInt1 = paramArrayOfByte.wWI;
          continue;
          label513:
          paramq = paramArrayOfByte.wWJ;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.d
 * JD-Core Version:    0.7.0.1
 */