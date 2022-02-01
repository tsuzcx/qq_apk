package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends p
  implements m
{
  public LinkedList<akn> MQX;
  private com.tencent.mm.am.h callback;
  public String mUrl;
  private c rr;
  
  public h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66897);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cpz();
    ((c.a)localObject).otF = new cqa();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdiscount";
    ((c.a)localObject).funcId = 579;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cpz)c.b.b(this.rr.otB);
    ((cpz)localObject).Zbg = paramString1;
    this.mUrl = paramString2;
    ((cpz)localObject).Url = paramString2;
    AppMethodBeat.o(66897);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(66899);
    this.callback = paramh;
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
    paramArrayOfByte = (cqa)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.YME == 0))
    {
      Log.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + paramArrayOfByte.aawv);
      try
      {
        params = new JSONObject(paramArrayOfByte.aawv).optJSONArray("discount_list");
        if (params != null)
        {
          this.MQX = new LinkedList();
          int i = params.length();
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            JSONObject localJSONObject = params.getJSONObject(paramInt1);
            akn localakn = new akn();
            localakn.hAP = localJSONObject.getString("title");
            localakn.YYF = localJSONObject.getInt("fee");
            this.MQX.add(localakn);
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
      if (paramArrayOfByte.YME != 0)
      {
        paramInt1 = paramArrayOfByte.YME;
        params = paramArrayOfByte.YMF;
      }
    }
    Log.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.h
 * JD-Core Version:    0.7.0.1
 */