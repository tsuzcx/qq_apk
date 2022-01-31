package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.c.agz;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends m
  implements k
{
  public int dWX;
  public com.tencent.mm.ah.b dmK;
  private f dmL;
  public String fjn;
  public MallRechargeProduct npH = null;
  public List<MallRechargeProduct> npI = null;
  public String npJ;
  public String npy;
  public String npz = null;
  
  public d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.npy = paramString1;
    this.dWX = paramInt;
    this.fjn = paramString5;
    this.npJ = paramString2;
    paramString5 = new b.a();
    paramString5.ecH = new agz();
    paramString5.ecI = new aha();
    paramString5.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
    paramString5.ecG = 497;
    paramString5.ecJ = 229;
    paramString5.ecK = 1000000229;
    this.dmK = paramString5.Kt();
    paramString5 = (agz)this.dmK.ecE.ecN;
    paramString5.sYz = paramString1;
    paramString5.sYA = paramString3;
    paramString5.tev = paramString2;
    paramString5.sYB = paramString4;
    paramString5.sRr = c.bWg().Qw(paramString1);
    y.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[] { paramString1, paramString3, paramString2, paramString4 }));
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + paramInt3 + ", errMsg " + paramString);
    paramArrayOfByte = (aha)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    y.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + paramArrayOfByte.sYE);
    paramq = paramArrayOfByte.sYE;
    this.npz = "";
    if (!bk.bl(paramq))
    {
      paramq = paramq.split("&");
      if ((paramq != null) && (paramq.length > 0))
      {
        paramInt1 = 1;
        int i = 0;
        if (i < paramq.length)
        {
          String[] arrayOfString = paramq[i].split("=");
          int j = paramInt1;
          if (arrayOfString.length == 2)
          {
            if (paramInt1 != 0) {
              break label224;
            }
            this.npz += " ";
          }
          for (;;)
          {
            this.npz += arrayOfString[1];
            j = paramInt1;
            i += 1;
            paramInt1 = j;
            break;
            label224:
            paramInt1 = 0;
          }
        }
      }
    }
    if (!bk.bl(paramArrayOfByte.tey)) {}
    try
    {
      paramq = new JSONObject(paramArrayOfByte.tey);
      this.npI = b.a(this.npy, paramq.optJSONArray("product_info"));
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramq = paramArrayOfByte.tew;
        y.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product " + paramq);
        if (bk.bl(paramq)) {}
      }
    }
    catch (JSONException paramq)
    {
      try
      {
        this.npH = b.d(this.npy, new JSONObject(paramq));
        this.npH.npz = this.npz;
        y.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[] { Integer.valueOf(paramArrayOfByte.sYC), paramArrayOfByte.sYD, Integer.valueOf(paramArrayOfByte.sYF), paramArrayOfByte.sYG }));
        paramInt1 = paramInt3;
        if (paramInt3 == 0)
        {
          if (paramArrayOfByte.sYF != 0) {
            paramInt1 = paramArrayOfByte.sYF;
          }
        }
        else
        {
          paramq = paramString;
          if (bk.bl(paramString))
          {
            if (bk.bl(paramArrayOfByte.sYG)) {
              break label510;
            }
            paramq = paramArrayOfByte.sYG;
          }
          this.dmL.onSceneEnd(paramInt2, paramInt1, paramq, this);
          return;
          paramq = paramq;
          y.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
        }
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", paramq, "", new Object[0]);
          continue;
          paramInt1 = paramArrayOfByte.sYC;
          continue;
          label510:
          paramq = paramArrayOfByte.sYD;
        }
      }
    }
  }
  
  public final int getType()
  {
    return 497;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.d
 * JD-Core Version:    0.7.0.1
 */