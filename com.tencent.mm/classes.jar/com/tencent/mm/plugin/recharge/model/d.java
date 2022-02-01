package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends q
  implements m
{
  public String BCZ;
  public MallRechargeProduct BDh;
  public List<MallRechargeProduct> BDi;
  public String BDj;
  private i callback;
  public int iFf;
  public String kHR;
  public String kik;
  public com.tencent.mm.ak.d rr;
  
  public d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(67104);
    this.BDh = null;
    this.BDi = null;
    this.BCZ = null;
    this.kHR = paramString1;
    this.iFf = paramInt;
    this.kik = paramString5;
    this.BDj = paramString2;
    paramString5 = new d.a();
    paramString5.iLN = new bpa();
    paramString5.iLO = new bpb();
    paramString5.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
    paramString5.funcId = 497;
    paramString5.iLP = 229;
    paramString5.respCmdId = 1000000229;
    this.rr = paramString5.aXF();
    paramString5 = (bpa)this.rr.iLK.iLR;
    paramString5.LOs = paramString1;
    paramString5.LOt = paramString3;
    paramString5.LXc = paramString2;
    paramString5.LOu = paramString4;
    paramString5.Bri = c.fSg().aVu(paramString1);
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
    paramArrayOfByte = (bpb)((com.tencent.mm.ak.d)params).iLL.iLR;
    Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + paramArrayOfByte.LOx);
    params = paramArrayOfByte.LOx;
    this.BCZ = "";
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
            this.BCZ += " ";
          }
          for (;;)
          {
            this.BCZ += arrayOfString[1];
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
    if (!Util.isNullOrNil(paramArrayOfByte.LXe)) {}
    try
    {
      params = new JSONObject(paramArrayOfByte.LXe);
      this.BDi = b.a(this.kHR, params.optJSONArray("product_info"));
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        params = paramArrayOfByte.LXd;
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(params)));
        if (Util.isNullOrNil(params)) {}
      }
    }
    catch (JSONException params)
    {
      try
      {
        this.BDh = b.n(this.kHR, new JSONObject(params));
        this.BDh.BCZ = this.BCZ;
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[] { Integer.valueOf(paramArrayOfByte.LOv), paramArrayOfByte.LOw, Integer.valueOf(paramArrayOfByte.LOy), paramArrayOfByte.LOz }));
        paramInt1 = paramInt3;
        if (paramInt3 == 0)
        {
          if (paramArrayOfByte.LOy != 0) {
            paramInt1 = paramArrayOfByte.LOy;
          }
        }
        else
        {
          params = paramString;
          if (Util.isNullOrNil(paramString))
          {
            if (Util.isNullOrNil(paramArrayOfByte.LOz)) {
              break label513;
            }
            params = paramArrayOfByte.LOz;
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
          paramInt1 = paramArrayOfByte.LOv;
          continue;
          label513:
          params = paramArrayOfByte.LOw;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.d
 * JD-Core Version:    0.7.0.1
 */