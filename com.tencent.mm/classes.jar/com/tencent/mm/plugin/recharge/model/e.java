package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends p
  implements m
{
  public ArrayList<MallRechargeProduct> NwR;
  public String NwS;
  public String NwT;
  public String NwU;
  public String NwV;
  private h callback;
  public String qBb;
  private c rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67107);
    this.NwR = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cpj();
    ((c.a)localObject).otF = new cpk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
    ((c.a)localObject).funcId = 496;
    ((c.a)localObject).otG = 228;
    ((c.a)localObject).respCmdId = 1000000228;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cpj)c.b.b(this.rr.otB);
    this.qBb = paramString;
    ((cpj)localObject).aaiH = paramString;
    AppMethodBeat.o(67107);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67109);
    this.callback = paramh;
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
      params = (cpk)c.c.b(((c)params).otC);
      paramArrayOfByte = params.aatS;
      Log.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(paramArrayOfByte)));
      if (Util.isNullOrNil(paramArrayOfByte)) {}
    }
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.NwR = b.a(this.qBb, paramArrayOfByte.getJSONArray("pay_product_list"));
      if (Util.isNullOrNil(params.aawe)) {}
    }
    catch (JSONException paramArrayOfByte)
    {
      try
      {
        params = new JSONObject(params.aawe);
        this.NwS = params.optString("balance_link");
        this.NwU = params.optString("recharge_link");
        this.NwT = params.optString("balance_wording");
        this.NwV = params.optString("recharge_wording");
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