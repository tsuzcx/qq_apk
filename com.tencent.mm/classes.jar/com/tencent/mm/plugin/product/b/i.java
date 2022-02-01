package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bhb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends n
  implements k
{
  private f callback;
  public String mUrl;
  private b rr;
  public LinkedList<aff> xbT;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66897);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bha();
    ((b.a)localObject).hQG = new bhb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdiscount";
    ((b.a)localObject).funcId = 579;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bha)this.rr.hQD.hQJ;
    ((bha)localObject).Ghx = paramString1;
    this.mUrl = paramString2;
    ((bha)localObject).Url = paramString2;
    AppMethodBeat.o(66897);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(66899);
    this.callback = paramf;
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
    paramArrayOfByte = (bhb)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.FUL == 0))
    {
      ae.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + paramArrayOfByte.GVj);
      try
      {
        paramq = new JSONObject(paramArrayOfByte.GVj).optJSONArray("discount_list");
        if (paramq != null)
        {
          this.xbT = new LinkedList();
          int i = paramq.length();
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            JSONObject localJSONObject = paramq.getJSONObject(paramInt1);
            aff localaff = new aff();
            localaff.Title = localJSONObject.getString("title");
            localaff.Gfg = localJSONObject.getInt("fee");
            this.xbT.add(localaff);
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
      if (paramArrayOfByte.FUL != 0)
      {
        paramInt1 = paramArrayOfByte.FUL;
        paramq = paramArrayOfByte.FUM;
      }
    }
    ae.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.i
 * JD-Core Version:    0.7.0.1
 */