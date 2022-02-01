package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements k
{
  private f callback;
  public String jFZ;
  private com.tencent.mm.ak.b rr;
  public ArrayList<MallRechargeProduct> xDl;
  public String xDm;
  public String xDn;
  public String xDo;
  public String xDp;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67107);
    this.xDl = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bgi();
    ((b.a)localObject).hQG = new bgj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
    ((b.a)localObject).funcId = 496;
    ((b.a)localObject).hQH = 228;
    ((b.a)localObject).respCmdId = 1000000228;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bgi)this.rr.hQD.hQJ;
    this.jFZ = paramString;
    ((bgi)localObject).GKy = paramString;
    AppMethodBeat.o(67107);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(67109);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67109);
    return i;
  }
  
  public final int getType()
  {
    return 496;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67108);
    ae.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bgj)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      paramArrayOfByte = paramq.GSS;
      ae.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(paramArrayOfByte)));
      if (bu.isNullOrNil(paramArrayOfByte)) {}
    }
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.xDl = b.a(this.jFZ, paramArrayOfByte.getJSONArray("pay_product_list"));
      if (bu.isNullOrNil(paramq.GUU)) {}
    }
    catch (JSONException paramArrayOfByte)
    {
      try
      {
        paramq = new JSONObject(paramq.GUU);
        this.xDm = paramq.optString("balance_link");
        this.xDo = paramq.optString("recharge_link");
        this.xDn = paramq.optString("balance_wording");
        this.xDp = paramq.optString("recharge_wording");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(67108);
        return;
        paramArrayOfByte = paramArrayOfByte;
        ae.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramArrayOfByte, "", new Object[0]);
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramq, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.e
 * JD-Core Version:    0.7.0.1
 */