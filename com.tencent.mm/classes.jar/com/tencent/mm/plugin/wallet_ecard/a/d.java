package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public int iHq = 0;
  public String iHr = "";
  public baw qKs;
  public String qKt;
  public String qKu;
  public String qKv;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bav();
    ((b.a)localObject).ecI = new baw();
    ((b.a)localObject).ecG = 1985;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bav)this.dmK.ecE.ecN;
    ((bav)localObject).sAT = paramString1;
    ((bav)localObject).sAU = paramString2;
    this.dmK.ecZ = true;
    ((bav)localObject).twO = 0;
    ((bav)localObject).bUx = paramInt;
    ((bav)localObject).twL = true;
    y.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramBoolean, false);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bav();
    ((b.a)localObject).ecI = new baw();
    ((b.a)localObject).ecG = 1985;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bav)this.dmK.ecE.ecN;
    ((bav)localObject).sAT = paramString1;
    ((bav)localObject).sAU = paramString2;
    this.dmK.ecZ = true;
    if (paramBoolean1)
    {
      ((bav)localObject).twM = paramString3;
      if (!paramBoolean2) {
        break label247;
      }
    }
    label247:
    for (((bav)localObject).twO = 1;; ((bav)localObject).twO = 0)
    {
      ((bav)localObject).qqU = paramString4;
      ((bav)localObject).mOb = paramString5;
      ((bav)localObject).bUx = paramInt;
      ((bav)localObject).twL = false;
      this.qKt = paramString3;
      this.qKu = paramString4;
      this.qKv = paramString5;
      y.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[] { paramString3 });
      y.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString4, paramString5 });
      return;
      ((bav)localObject).twN = paramString3;
      break;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qKs = ((baw)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.qKs.ino), this.qKs.inp });
    if (!bk.bl(this.qKs.twJ)) {
      y.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[] { this.qKs.twJ });
    }
    try
    {
      paramq = new JSONObject(this.qKs.twJ);
      this.iHq = paramq.optInt("retcode", 0);
      this.iHr = paramq.optString("retmsg", "");
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneOpenECard", paramq, "", new Object[0]);
      }
    }
  }
  
  public final int getType()
  {
    return 1985;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.d
 * JD-Core Version:    0.7.0.1
 */