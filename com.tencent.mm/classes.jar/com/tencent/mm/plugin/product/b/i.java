package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends n
  implements k
{
  private g callback;
  public String mUrl;
  private b rr;
  public LinkedList<acv> vEZ;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66897);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bcg();
    ((b.a)localObject).hvu = new bch();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdiscount";
    ((b.a)localObject).funcId = 579;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bcg)this.rr.hvr.hvw;
    ((bcg)localObject).EhR = paramString1;
    this.mUrl = paramString2;
    ((bcg)localObject).Url = paramString2;
    AppMethodBeat.o(66897);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(66899);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66899);
    return i;
  }
  
  public final int getType()
  {
    return 579;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66898);
    paramArrayOfByte = (bch)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.DWU == 0))
    {
      ac.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + paramArrayOfByte.ESr);
      try
      {
        paramq = new JSONObject(paramArrayOfByte.ESr).optJSONArray("discount_list");
        if (paramq != null)
        {
          this.vEZ = new LinkedList();
          int i = paramq.length();
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            JSONObject localJSONObject = paramq.getJSONObject(paramInt1);
            acv localacv = new acv();
            localacv.Title = localJSONObject.getString("title");
            localacv.Egi = localJSONObject.getInt("fee");
            this.vEZ.add(localacv);
            paramInt1 += 1;
          }
        }
        paramInt1 = paramInt3;
      }
      catch (Exception paramq) {}
    }
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.DWU != 0)
      {
        paramInt1 = paramArrayOfByte.DWU;
        paramq = paramArrayOfByte.DWV;
      }
    }
    ac.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.i
 * JD-Core Version:    0.7.0.1
 */