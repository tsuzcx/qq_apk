package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aio;
import com.tencent.mm.protocal.c.aip;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public ArrayList<MallRechargeProduct> npK = null;
  public String npL;
  public String npM;
  public String npN;
  public String npO;
  public String npy;
  
  public e(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aio();
    ((b.a)localObject).ecI = new aip();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
    ((b.a)localObject).ecG = 496;
    ((b.a)localObject).ecJ = 228;
    ((b.a)localObject).ecK = 1000000228;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aio)this.dmK.ecE.ecN;
    this.npy = paramString;
    ((aio)localObject).sYz = paramString;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aip)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      paramArrayOfByte = paramq.tey;
      y.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList " + paramArrayOfByte);
      if (bk.bl(paramArrayOfByte)) {}
    }
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.npK = b.a(this.npy, paramArrayOfByte.getJSONArray("pay_product_list"));
      if (bk.bl(paramq.tfH)) {}
    }
    catch (JSONException paramArrayOfByte)
    {
      try
      {
        paramq = new JSONObject(paramq.tfH);
        this.npL = paramq.optString("balance_link");
        this.npN = paramq.optString("recharge_link");
        this.npM = paramq.optString("balance_wording");
        this.npO = paramq.optString("recharge_wording");
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        paramArrayOfByte = paramArrayOfByte;
        y.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramArrayOfByte, "", new Object[0]);
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", paramq, "", new Object[0]);
        }
      }
    }
  }
  
  public final int getType()
  {
    return 496;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.e
 * JD-Core Version:    0.7.0.1
 */