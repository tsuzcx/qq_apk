package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends q
  implements m
{
  public LinkedList<ahw> GTt;
  private com.tencent.mm.an.i callback;
  public String mUrl;
  private d rr;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66897);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new caq();
    ((d.a)localObject).lBV = new car();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdiscount";
    ((d.a)localObject).funcId = 579;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (caq)d.b.b(this.rr.lBR);
    ((caq)localObject).Sdn = paramString1;
    this.mUrl = paramString2;
    ((caq)localObject).Url = paramString2;
    AppMethodBeat.o(66897);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
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
    paramArrayOfByte = (car)d.c.b(((d)params).lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.RPr == 0))
    {
      Log.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + paramArrayOfByte.TiV);
      try
      {
        params = new JSONObject(paramArrayOfByte.TiV).optJSONArray("discount_list");
        if (params != null)
        {
          this.GTt = new LinkedList();
          int i = params.length();
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            JSONObject localJSONObject = params.getJSONObject(paramInt1);
            ahw localahw = new ahw();
            localahw.fwr = localJSONObject.getString("title");
            localahw.SaG = localJSONObject.getInt("fee");
            this.GTt.add(localahw);
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
      if (paramArrayOfByte.RPr != 0)
      {
        paramInt1 = paramArrayOfByte.RPr;
        params = paramArrayOfByte.RPs;
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