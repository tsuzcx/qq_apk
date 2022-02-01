package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.sdk.platformtools.ad;
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
  public LinkedList<aew> wMf;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66897);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bgk();
    ((b.a)localObject).hNN = new bgl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdiscount";
    ((b.a)localObject).funcId = 579;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bgk)this.rr.hNK.hNQ;
    ((bgk)localObject).FOY = paramString1;
    this.mUrl = paramString2;
    ((bgk)localObject).Url = paramString2;
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
    paramArrayOfByte = (bgl)((b)paramq).hNL.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.FCq == 0))
    {
      ad.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + paramArrayOfByte.GBJ);
      try
      {
        paramq = new JSONObject(paramArrayOfByte.GBJ).optJSONArray("discount_list");
        if (paramq != null)
        {
          this.wMf = new LinkedList();
          int i = paramq.length();
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            JSONObject localJSONObject = paramq.getJSONObject(paramInt1);
            aew localaew = new aew();
            localaew.Title = localJSONObject.getString("title");
            localaew.FMH = localJSONObject.getInt("fee");
            this.wMf.add(localaew);
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
      if (paramArrayOfByte.FCq != 0)
      {
        paramInt1 = paramArrayOfByte.FCq;
        paramq = paramArrayOfByte.FCr;
      }
    }
    ad.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.i
 * JD-Core Version:    0.7.0.1
 */