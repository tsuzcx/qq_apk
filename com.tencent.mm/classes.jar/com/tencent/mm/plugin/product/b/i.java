package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends q
  implements m
{
  public LinkedList<ahl> AZv;
  private com.tencent.mm.ak.i callback;
  public String mUrl;
  private d rr;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66897);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bsy();
    ((d.a)localObject).iLO = new bsz();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdiscount";
    ((d.a)localObject).funcId = 579;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bsy)this.rr.iLK.iLR;
    ((bsy)localObject).Lca = paramString1;
    this.mUrl = paramString2;
    ((bsy)localObject).Url = paramString2;
    AppMethodBeat.o(66897);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(66899);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66899);
    return i;
  }
  
  public final int getType()
  {
    return 579;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66898);
    paramArrayOfByte = (bsz)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.KOt == 0))
    {
      Log.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + paramArrayOfByte.LZC);
      try
      {
        params = new JSONObject(paramArrayOfByte.LZC).optJSONArray("discount_list");
        if (params != null)
        {
          this.AZv = new LinkedList();
          int i = params.length();
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            JSONObject localJSONObject = params.getJSONObject(paramInt1);
            ahl localahl = new ahl();
            localahl.Title = localJSONObject.getString("title");
            localahl.KZx = localJSONObject.getInt("fee");
            this.AZv.add(localahl);
            paramInt1 += 1;
          }
        }
        paramInt1 = paramInt3;
      }
      catch (Exception params) {}
    }
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramArrayOfByte.KOt != 0)
      {
        paramInt1 = paramArrayOfByte.KOt;
        params = paramArrayOfByte.KOu;
      }
    }
    Log.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.i
 * JD-Core Version:    0.7.0.1
 */