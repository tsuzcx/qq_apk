package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bat;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public int iHq = 0;
  public String iHr = "";
  public bau qKw;
  public String token = null;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bat();
    ((b.a)localObject).ecI = new bau();
    ((b.a)localObject).ecG = 1958;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecardauth";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bat)this.dmK.ecE.ecN;
    ((bat)localObject).sAT = paramString1;
    ((bat)localObject).twI = paramString2;
    ((bat)localObject).bUx = paramInt;
    ((bat)localObject).token = paramString3;
    this.token = null;
    y.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Boolean.valueOf(bk.bl(paramString2)) });
    y.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qKw = ((bau)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", new Object[] { Integer.valueOf(this.qKw.ino), this.qKw.inp, Boolean.valueOf(this.qKw.twK) });
    if (!bk.bl(this.qKw.twJ)) {
      y.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", new Object[] { this.qKw.twJ });
    }
    try
    {
      paramq = new JSONObject(this.qKw.twJ);
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
        y.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", paramq, "", new Object[0]);
      }
    }
  }
  
  public final int getType()
  {
    return 1958;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.e
 * JD-Core Version:    0.7.0.1
 */