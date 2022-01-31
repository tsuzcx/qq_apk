package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends m
  implements k
{
  private f callback;
  public String pUM;
  public ArrayList<MallRechargeProduct> pUY;
  public String pUZ;
  public String pVa;
  public String pVb;
  public String pVc;
  private com.tencent.mm.ai.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(44199);
    this.pUY = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new anr();
    ((b.a)localObject).fsY = new ans();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
    ((b.a)localObject).funcId = 496;
    ((b.a)localObject).reqCmdId = 228;
    ((b.a)localObject).respCmdId = 1000000228;
    this.rr = ((b.a)localObject).ado();
    localObject = (anr)this.rr.fsV.fta;
    this.pUM = paramString;
    ((anr)localObject).wWF = paramString;
    AppMethodBeat.o(44199);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(44201);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44201);
    return i;
  }
  
  public final int getType()
  {
    return 496;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44200);
    ab.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ans)((com.tencent.mm.ai.b)paramq).fsW.fta;
      paramArrayOfByte = paramq.xcw;
      ab.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(paramArrayOfByte)));
      if (bo.isNullOrNil(paramArrayOfByte)) {}
    }
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.pUY = b.a(this.pUM, paramArrayOfByte.getJSONArray("pay_product_list"));
      if (bo.isNullOrNil(paramq.xdV)) {}
    }
    catch (JSONException paramArrayOfByte)
    {
      try
      {
        paramq = new JSONObject(paramq.xdV);
        this.pUZ = paramq.optString("balance_link");
        this.pVb = paramq.optString("recharge_link");
        this.pVa = paramq.optString("balance_wording");
        this.pVc = paramq.optString("recharge_wording");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(44200);
        return;
        paramArrayOfByte = paramArrayOfByte;
        ab.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramArrayOfByte, "", new Object[0]);
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramq, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.e
 * JD-Core Version:    0.7.0.1
 */