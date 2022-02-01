package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements k
{
  private f callback;
  public String jDb;
  private com.tencent.mm.al.b rr;
  public ArrayList<MallRechargeProduct> xno;
  public String xnp;
  public String xnq;
  public String xnr;
  public String xns;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67107);
    this.xno = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bfs();
    ((b.a)localObject).hNN = new bft();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
    ((b.a)localObject).funcId = 496;
    ((b.a)localObject).hNO = 228;
    ((b.a)localObject).respCmdId = 1000000228;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bfs)this.rr.hNK.hNQ;
    this.jDb = paramString;
    ((bfs)localObject).Gra = paramString;
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
    ad.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bft)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      paramArrayOfByte = paramq.Gzs;
      ad.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(paramArrayOfByte)));
      if (bt.isNullOrNil(paramArrayOfByte)) {}
    }
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.xno = b.a(this.jDb, paramArrayOfByte.getJSONArray("pay_product_list"));
      if (bt.isNullOrNil(paramq.GBu)) {}
    }
    catch (JSONException paramArrayOfByte)
    {
      try
      {
        paramq = new JSONObject(paramq.GBu);
        this.xnp = paramq.optString("balance_link");
        this.xnr = paramq.optString("recharge_link");
        this.xnq = paramq.optString("balance_wording");
        this.xns = paramq.optString("recharge_wording");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(67108);
        return;
        paramArrayOfByte = paramArrayOfByte;
        ad.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramArrayOfByte, "", new Object[0]);
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramq, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.e
 * JD-Core Version:    0.7.0.1
 */