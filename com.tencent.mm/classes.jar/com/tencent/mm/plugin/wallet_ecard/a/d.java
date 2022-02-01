package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  public bzx BOI;
  public String BOJ;
  public String BOK;
  public String BOL;
  private g callback;
  public int dae;
  public String oxf;
  private b rr;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(71692);
    this.dae = 0;
    this.oxf = "";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bzw();
    ((b.a)localObject).hvu = new bzx();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bzw)this.rr.hvr.hvw;
    ((bzw)localObject).DXS = paramString1;
    ((bzw)localObject).DXT = paramString2;
    this.rr.setIsUserCmd(true);
    ((bzw)localObject).FoK = 0;
    ((bzw)localObject).dql = paramInt;
    ((bzw)localObject).dvQ = 1;
    ((bzw)localObject).FoH = true;
    ac.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71692);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean, int paramInt2, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramBoolean, false, paramInt2, paramString6);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString6)
  {
    AppMethodBeat.i(71691);
    this.dae = 0;
    this.oxf = "";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bzw();
    ((b.a)localObject).hvu = new bzx();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bzw)this.rr.hvr.hvw;
    ((bzw)localObject).DXS = paramString1;
    ((bzw)localObject).DXT = paramString2;
    this.rr.setIsUserCmd(true);
    if (paramBoolean1)
    {
      ((bzw)localObject).FoI = paramString3;
      if (!paramBoolean2) {
        break label287;
      }
    }
    label287:
    for (((bzw)localObject).FoK = 1;; ((bzw)localObject).FoK = 0)
    {
      ((bzw)localObject).BoQ = paramString4;
      ((bzw)localObject).cZz = paramString5;
      ((bzw)localObject).dql = paramInt1;
      ((bzw)localObject).FoH = false;
      ((bzw)localObject).dvQ = paramInt2;
      ((bzw)localObject).FoL = paramString6;
      this.BOJ = paramString3;
      this.BOK = paramString4;
      this.BOL = paramString5;
      ac.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[] { paramString3 });
      ac.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s, fromScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(71691);
      return;
      ((bzw)localObject).FoJ = paramString3;
      break;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71694);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.BOI = ((bzx)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.BOI.nWx), this.BOI.nWy });
    if (!bs.isNullOrNil(this.BOI.FoF)) {
      ac.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[] { this.BOI.FoF });
    }
    try
    {
      paramq = new JSONObject(this.BOI.FoF);
      this.dae = paramq.optInt("retcode", 0);
      this.oxf = paramq.optString("retmsg", "");
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
        ac.printErrStackTrace("MicroMsg.NetSceneOpenECard", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.d
 * JD-Core Version:    0.7.0.1
 */