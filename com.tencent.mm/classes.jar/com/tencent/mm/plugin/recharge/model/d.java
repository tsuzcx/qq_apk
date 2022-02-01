package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends q
  implements m
{
  public String Hzd;
  public MallRechargeProduct Hzl;
  public List<MallRechargeProduct> Hzm;
  public String Hzn;
  private i callback;
  public int lvh;
  public String mZK;
  public String nBK;
  public com.tencent.mm.an.d rr;
  
  public d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67104);
    this.Hzl = null;
    this.Hzm = null;
    this.Hzd = null;
    this.nBK = paramString1;
    this.lvh = paramInt;
    this.mZK = paramString5;
    this.Hzn = paramString2;
    paramString5 = new d.a();
    paramString5.lBU = new bwv();
    paramString5.lBV = new bww();
    paramString5.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
    paramString5.funcId = 497;
    paramString5.lBW = 229;
    paramString5.respCmdId = 1000000229;
    this.rr = paramString5.bgN();
    paramString5 = (bwv)d.b.b(this.rr.lBR);
    paramString5.SWQ = paramString1;
    paramString5.SWR = paramString3;
    paramString5.TgA = paramString2;
    paramString5.SWS = paramString4;
    paramString5.HlB = c.gKL().bhd(paramString1);
    Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[] { paramString1, paramString3, paramString2, paramString4 }));
    AppMethodBeat.o(67104);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67106);
    this.callback = parami;
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
    paramArrayOfByte = (bww)d.c.b(((com.tencent.mm.an.d)params).lBS);
    Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + paramArrayOfByte.SWV);
    params = paramArrayOfByte.SWV;
    this.Hzd = "";
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
              break label229;
            }
            this.Hzd += " ";
          }
          for (;;)
          {
            this.Hzd += arrayOfString[1];
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
    if (!Util.isNullOrNil(paramArrayOfByte.TgC)) {}
    try
    {
      params = new JSONObject(paramArrayOfByte.TgC);
      this.Hzm = b.a(this.nBK, params.optJSONArray("product_info"));
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        params = paramArrayOfByte.TgB;
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(params)));
        if (Util.isNullOrNil(params)) {}
      }
    }
    catch (JSONException params)
    {
      try
      {
        this.Hzl = b.l(this.nBK, new JSONObject(params));
        this.Hzl.Hzd = this.Hzd;
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[] { Integer.valueOf(paramArrayOfByte.SWT), paramArrayOfByte.SWU, Integer.valueOf(paramArrayOfByte.SWW), paramArrayOfByte.SWX }));
        paramInt1 = paramInt3;
        if (paramInt3 == 0)
        {
          if (paramArrayOfByte.SWW != 0) {
            paramInt1 = paramArrayOfByte.SWW;
          }
        }
        else
        {
          params = paramString;
          if (Util.isNullOrNil(paramString))
          {
            if (Util.isNullOrNil(paramArrayOfByte.SWX)) {
              break label513;
            }
            params = paramArrayOfByte.SWX;
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
          paramInt1 = paramArrayOfByte.SWT;
          continue;
          label513:
          params = paramArrayOfByte.SWU;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.d
 * JD-Core Version:    0.7.0.1
 */