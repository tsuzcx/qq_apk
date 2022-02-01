package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.caa;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends q
  implements m
{
  public ArrayList<MallRechargeProduct> Hzo;
  public String Hzp;
  public String Hzq;
  public String Hzr;
  public String Hzs;
  private i callback;
  public String nBK;
  private d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67107);
    this.Hzo = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new caa();
    ((d.a)localObject).lBV = new cab();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
    ((d.a)localObject).funcId = 496;
    ((d.a)localObject).lBW = 228;
    ((d.a)localObject).respCmdId = 1000000228;
    this.rr = ((d.a)localObject).bgN();
    localObject = (caa)d.b.b(this.rr.lBR);
    this.nBK = paramString;
    ((caa)localObject).SWQ = paramString;
    AppMethodBeat.o(67107);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67109);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67109);
    return i;
  }
  
  public final int getType()
  {
    return 496;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67108);
    Log.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cab)d.c.b(((d)params).lBS);
      paramArrayOfByte = params.TgC;
      Log.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(paramArrayOfByte)));
      if (Util.isNullOrNil(paramArrayOfByte)) {}
    }
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.Hzo = b.a(this.nBK, paramArrayOfByte.getJSONArray("pay_product_list"));
      if (Util.isNullOrNil(params.TiG)) {}
    }
    catch (JSONException paramArrayOfByte)
    {
      try
      {
        params = new JSONObject(params.TiG);
        this.Hzp = params.optString("balance_link");
        this.Hzr = params.optString("recharge_link");
        this.Hzq = params.optString("balance_wording");
        this.Hzs = params.optString("recharge_wording");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(67108);
        return;
        paramArrayOfByte = paramArrayOfByte;
        Log.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramArrayOfByte, "", new Object[0]);
      }
      catch (JSONException params)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", params, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.e
 * JD-Core Version:    0.7.0.1
 */