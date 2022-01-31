package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public g()
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new alq();
    ((b.a)localObject).ecI = new alr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((b.a)localObject).ecG = 1191;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (alq)this.dmK.ecE.ecN;
    ((alq)localObject).source = 2;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("invoice_info.title");
    localLinkedList.add("invoice_info.tax_number");
    localLinkedList.add("invoice_info.bank_number");
    localLinkedList.add("invoice_info.bank_name");
    localLinkedList.add("invoice_info.type");
    localLinkedList.add("invoice_info.email");
    localLinkedList.add("invoice_info.company_address");
    localLinkedList.add("invoice_info.company_address_detail");
    localLinkedList.add("invoice_info.company_address_postcode");
    localLinkedList.add("invoice_info.phone");
    ((alq)localObject).thF = localLinkedList;
    ((alq)localObject).thE = false;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      y.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
      paramq = (alr)((b)paramq).ecF.ecN;
      if (paramq.thG == null) {}
    }
    try
    {
      boolean bool = new JSONObject(paramq.thG).getBoolean("has_invoice_info");
      y.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is .." + bool);
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uvy, Boolean.valueOf(bool));
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        y.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
      }
    }
  }
  
  public final int getType()
  {
    return 1191;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.g
 * JD-Core Version:    0.7.0.1
 */