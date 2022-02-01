package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  public ceo Dpa;
  public String Dpb;
  public String Dpc;
  public String Dpd;
  private f callback;
  public int dlw;
  public String paA;
  private b rr;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(71692);
    this.dlw = 0;
    this.paA = "";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cen();
    ((b.a)localObject).hNN = new ceo();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cen)this.rr.hNK.hNQ;
    ((cen)localObject).FDo = paramString1;
    ((cen)localObject).FDp = paramString2;
    this.rr.setIsUserCmd(true);
    ((cen)localObject).GYw = 0;
    ((cen)localObject).dBY = paramInt;
    ((cen)localObject).dHZ = 1;
    ((cen)localObject).GYt = true;
    ad.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71692);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean, int paramInt2, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramBoolean, false, paramInt2, paramString6);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString6)
  {
    AppMethodBeat.i(71691);
    this.dlw = 0;
    this.paA = "";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cen();
    ((b.a)localObject).hNN = new ceo();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cen)this.rr.hNK.hNQ;
    ((cen)localObject).FDo = paramString1;
    ((cen)localObject).FDp = paramString2;
    this.rr.setIsUserCmd(true);
    if (paramBoolean1)
    {
      ((cen)localObject).GYu = paramString3;
      if (!paramBoolean2) {
        break label287;
      }
    }
    label287:
    for (((cen)localObject).GYw = 1;; ((cen)localObject).GYw = 0)
    {
      ((cen)localObject).CPf = paramString4;
      ((cen)localObject).dkR = paramString5;
      ((cen)localObject).dBY = paramInt1;
      ((cen)localObject).GYt = false;
      ((cen)localObject).dHZ = paramInt2;
      ((cen)localObject).GYx = paramString6;
      this.Dpb = paramString3;
      this.Dpc = paramString4;
      this.Dpd = paramString5;
      ad.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[] { paramString3 });
      ad.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s, fromScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(71691);
      return;
      ((cen)localObject).GYv = paramString3;
      break;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71694);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71694);
    return i;
  }
  
  public final int getType()
  {
    return 1985;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71693);
    ad.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Dpa = ((ceo)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.Dpa.ozR), this.Dpa.ozS });
    if (!bt.isNullOrNil(this.Dpa.GYr)) {
      ad.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[] { this.Dpa.GYr });
    }
    try
    {
      paramq = new JSONObject(this.Dpa.GYr);
      this.dlw = paramq.optInt("retcode", 0);
      this.paA = paramq.optString("retmsg", "");
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(71693);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneOpenECard", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.d
 * JD-Core Version:    0.7.0.1
 */