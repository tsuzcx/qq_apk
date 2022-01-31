package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends m
  implements k
{
  private f callback;
  public String mUrl;
  public LinkedList<ym> puu;
  private b rr;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43991);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aoh();
    ((b.a)localObject).fsY = new aoi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdiscount";
    ((b.a)localObject).funcId = 579;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (aoh)this.rr.fsV.fta;
    ((aoh)localObject).wDF = paramString1;
    this.mUrl = paramString2;
    ((aoh)localObject).Url = paramString2;
    AppMethodBeat.o(43991);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43993);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43993);
    return i;
  }
  
  public final int getType()
  {
    return 579;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43992);
    paramArrayOfByte = (aoi)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.wuD == 0))
    {
      ab.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + paramArrayOfByte.xeg);
      try
      {
        paramq = new JSONObject(paramArrayOfByte.xeg).optJSONArray("discount_list");
        if (paramq != null)
        {
          this.puu = new LinkedList();
          int i = paramq.length();
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            JSONObject localJSONObject = paramq.getJSONObject(paramInt1);
            ym localym = new ym();
            localym.Title = localJSONObject.getString("title");
            localym.wCm = localJSONObject.getInt("fee");
            this.puu.add(localym);
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
      if (paramArrayOfByte.wuD != 0)
      {
        paramInt1 = paramArrayOfByte.wuD;
        paramq = paramArrayOfByte.wuE;
      }
    }
    ab.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(43992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.i
 * JD-Core Version:    0.7.0.1
 */