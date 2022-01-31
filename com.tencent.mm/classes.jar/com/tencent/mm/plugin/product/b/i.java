package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajc;
import com.tencent.mm.protocal.c.ajd;
import com.tencent.mm.protocal.c.tz;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public LinkedList<tz> mSn;
  public String mUrl;
  
  public i(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ajc();
    ((b.a)localObject).ecI = new ajd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdiscount";
    ((b.a)localObject).ecG = 579;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ajc)this.dmK.ecE.ecN;
    ((ajc)localObject).sHh = paramString1;
    this.mUrl = paramString2;
    ((ajc)localObject).kSC = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (ajd)((b)paramq).ecF.ecN;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.sHi == 0))
    {
      y.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + paramArrayOfByte.tfO);
      try
      {
        paramq = new JSONObject(paramArrayOfByte.tfO).optJSONArray("discount_list");
        if (paramq != null)
        {
          this.mSn = new LinkedList();
          int i = paramq.length();
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            JSONObject localJSONObject = paramq.getJSONObject(paramInt1);
            tz localtz = new tz();
            localtz.bGw = localJSONObject.getString("title");
            localtz.sFS = localJSONObject.getInt("fee");
            this.mSn.add(localtz);
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
      if (paramArrayOfByte.sHi != 0)
      {
        paramInt1 = paramArrayOfByte.sHi;
        paramq = paramArrayOfByte.sHj;
      }
    }
    y.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.dmL.onSceneEnd(paramInt2, paramInt1, paramq, this);
  }
  
  public final int getType()
  {
    return 579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.i
 * JD-Core Version:    0.7.0.1
 */