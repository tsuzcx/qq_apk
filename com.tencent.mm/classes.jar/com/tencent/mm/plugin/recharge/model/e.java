package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends q
  implements m
{
  public ArrayList<MallRechargeProduct> BDk;
  public String BDl;
  public String BDm;
  public String BDn;
  public String BDo;
  private i callback;
  public String kHR;
  private d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67107);
    this.BDk = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bse();
    ((d.a)localObject).iLO = new bsf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
    ((d.a)localObject).funcId = 496;
    ((d.a)localObject).iLP = 228;
    ((d.a)localObject).respCmdId = 1000000228;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bse)this.rr.iLK.iLR;
    this.kHR = paramString;
    ((bse)localObject).LOs = paramString;
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
      params = (bsf)((d)params).iLL.iLR;
      paramArrayOfByte = params.LXe;
      Log.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(paramArrayOfByte)));
      if (Util.isNullOrNil(paramArrayOfByte)) {}
    }
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.BDk = b.a(this.kHR, paramArrayOfByte.getJSONArray("pay_product_list"));
      if (Util.isNullOrNil(params.LZm)) {}
    }
    catch (JSONException paramArrayOfByte)
    {
      try
      {
        params = new JSONObject(params.LZm);
        this.BDl = params.optString("balance_link");
        this.BDn = params.optString("recharge_link");
        this.BDm = params.optString("balance_wording");
        this.BDo = params.optString("recharge_wording");
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