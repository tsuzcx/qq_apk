package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends p
  implements m
{
  public String NwI;
  public MallRechargeProduct NwO;
  public List<MallRechargeProduct> NwP;
  public String NwQ;
  private h callback;
  public int omE;
  public String pWt;
  public String qBb;
  public com.tencent.mm.am.c rr;
  
  public d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67104);
    this.NwO = null;
    this.NwP = null;
    this.NwI = null;
    this.qBb = paramString1;
    this.omE = paramInt;
    this.pWt = paramString5;
    this.NwQ = paramString2;
    paramString5 = new c.a();
    paramString5.otE = new cly();
    paramString5.otF = new clz();
    paramString5.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
    paramString5.funcId = 497;
    paramString5.otG = 229;
    paramString5.respCmdId = 1000000229;
    this.rr = paramString5.bEF();
    paramString5 = (cly)c.b.b(this.rr.otB);
    paramString5.aaiH = paramString1;
    paramString5.aaiI = paramString3;
    paramString5.aatQ = paramString2;
    paramString5.aaiJ = paramString4;
    paramString5.Njp = com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().bgN(paramString1);
    Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[] { paramString1, paramString3, paramString2, paramString4 }));
    AppMethodBeat.o(67104);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67106);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67106);
    return i;
  }
  
  public final int getType()
  {
    return 497;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67105);
    Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + paramInt3 + ", errMsg " + paramString);
    paramArrayOfByte = (clz)c.c.b(((com.tencent.mm.am.c)params).otC);
    Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + paramArrayOfByte.aaiM);
    params = paramArrayOfByte.aaiM;
    this.NwI = "";
    if (!Util.isNullOrNil(params))
    {
      params = params.split("&");
      if ((params != null) && (params.length > 0))
      {
        paramInt1 = 1;
        int i = 0;
        if (i < params.length)
        {
          String[] arrayOfString = params[i].split("=");
          int j = paramInt1;
          if (arrayOfString.length == 2)
          {
            if (paramInt1 != 0) {
              break label226;
            }
            this.NwI += " ";
          }
          for (;;)
          {
            this.NwI += arrayOfString[1];
            j = paramInt1;
            i += 1;
            paramInt1 = j;
            break;
            label226:
            paramInt1 = 0;
          }
        }
      }
    }
    if (!Util.isNullOrNil(paramArrayOfByte.aatS)) {}
    try
    {
      params = new JSONObject(paramArrayOfByte.aatS);
      this.NwP = b.a(this.qBb, params.optJSONArray("product_info"));
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        params = paramArrayOfByte.aatR;
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(params)));
        if (Util.isNullOrNil(params)) {}
      }
    }
    catch (JSONException params)
    {
      try
      {
        this.NwO = b.p(this.qBb, new JSONObject(params));
        this.NwO.NwI = this.NwI;
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[] { Integer.valueOf(paramArrayOfByte.aaiK), paramArrayOfByte.aaiL, Integer.valueOf(paramArrayOfByte.aaiN), paramArrayOfByte.aaiO }));
        paramInt1 = paramInt3;
        if (paramInt3 == 0)
        {
          if (paramArrayOfByte.aaiN != 0) {
            paramInt1 = paramArrayOfByte.aaiN;
          }
        }
        else
        {
          params = paramString;
          if (Util.isNullOrNil(paramString))
          {
            if (Util.isNullOrNil(paramArrayOfByte.aaiO)) {
              break label510;
            }
            params = paramArrayOfByte.aaiO;
          }
          this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
          AppMethodBeat.o(67105);
          return;
          params = params;
          Log.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", params, "", new Object[0]);
        }
      }
      catch (JSONException params)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", params, "", new Object[0]);
          continue;
          paramInt1 = paramArrayOfByte.aaiK;
          continue;
          label510:
          params = paramArrayOfByte.aaiL;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.d
 * JD-Core Version:    0.7.0.1
 */