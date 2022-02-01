package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  public ArrayList<MallRechargeProduct> wfG;
  public String wfH;
  public String wfI;
  public String wfJ;
  public String wfK;
  public String wfu;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67107);
    this.wfG = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bbo();
    ((b.a)localObject).hvu = new bbp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
    ((b.a)localObject).funcId = 496;
    ((b.a)localObject).reqCmdId = 228;
    ((b.a)localObject).respCmdId = 1000000228;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bbo)this.rr.hvr.hvw;
    this.wfu = paramString;
    ((bbo)localObject).EIj = paramString;
    AppMethodBeat.o(67107);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(67109);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bbp)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      paramArrayOfByte = paramq.EQb;
      ac.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(paramArrayOfByte)));
      if (bs.isNullOrNil(paramArrayOfByte)) {}
    }
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.wfG = b.a(this.wfu, paramArrayOfByte.getJSONArray("pay_product_list"));
      if (bs.isNullOrNil(paramq.ESc)) {}
    }
    catch (JSONException paramArrayOfByte)
    {
      try
      {
        paramq = new JSONObject(paramq.ESc);
        this.wfH = paramq.optString("balance_link");
        this.wfJ = paramq.optString("recharge_link");
        this.wfI = paramq.optString("balance_wording");
        this.wfK = paramq.optString("recharge_wording");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(67108);
        return;
        paramArrayOfByte = paramArrayOfByte;
        ac.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramArrayOfByte, "", new Object[0]);
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramq, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.e
 * JD-Core Version:    0.7.0.1
 */