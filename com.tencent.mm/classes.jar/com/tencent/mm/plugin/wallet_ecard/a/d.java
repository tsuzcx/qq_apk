package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  public cfi DGG;
  public String DGH;
  public String DGI;
  public String DGJ;
  private f callback;
  public int dmy;
  public String phe;
  private b rr;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(71692);
    this.dmy = 0;
    this.phe = "";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cfh();
    ((b.a)localObject).hQG = new cfi();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cfh)this.rr.hQD.hQJ;
    ((cfh)localObject).FVJ = paramString1;
    ((cfh)localObject).FVK = paramString2;
    this.rr.setIsUserCmd(true);
    ((cfh)localObject).HrX = 0;
    ((cfh)localObject).dDd = paramInt;
    ((cfh)localObject).dJd = 1;
    ((cfh)localObject).HrU = true;
    ae.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71692);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean, int paramInt2, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramBoolean, false, paramInt2, paramString6);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString6)
  {
    AppMethodBeat.i(71691);
    this.dmy = 0;
    this.phe = "";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cfh();
    ((b.a)localObject).hQG = new cfi();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cfh)this.rr.hQD.hQJ;
    ((cfh)localObject).FVJ = paramString1;
    ((cfh)localObject).FVK = paramString2;
    this.rr.setIsUserCmd(true);
    if (paramBoolean1)
    {
      ((cfh)localObject).HrV = paramString3;
      if (!paramBoolean2) {
        break label287;
      }
    }
    label287:
    for (((cfh)localObject).HrX = 1;; ((cfh)localObject).HrX = 0)
    {
      ((cfh)localObject).DgJ = paramString4;
      ((cfh)localObject).dlT = paramString5;
      ((cfh)localObject).dDd = paramInt1;
      ((cfh)localObject).HrU = false;
      ((cfh)localObject).dJd = paramInt2;
      ((cfh)localObject).HrY = paramString6;
      this.DGH = paramString3;
      this.DGI = paramString4;
      this.DGJ = paramString5;
      ae.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[] { paramString3 });
      ae.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s, fromScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(71691);
      return;
      ((cfh)localObject).HrW = paramString3;
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
    ae.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.DGG = ((cfi)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.DGG.oGt), this.DGG.oGu });
    if (!bu.isNullOrNil(this.DGG.HrS)) {
      ae.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[] { this.DGG.HrS });
    }
    try
    {
      paramq = new JSONObject(this.DGG.HrS);
      this.dmy = paramq.optInt("retcode", 0);
      this.phe = paramq.optString("retmsg", "");
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
        ae.printErrStackTrace("MicroMsg.NetSceneOpenECard", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.d
 * JD-Core Version:    0.7.0.1
 */