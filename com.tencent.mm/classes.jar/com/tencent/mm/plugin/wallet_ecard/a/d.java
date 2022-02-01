package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.dez;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends q
  implements m
{
  public dez PiA;
  public String PiB;
  public String PiC;
  public String PiD;
  private i callback;
  public int fwx;
  private com.tencent.mm.an.d rr;
  public String tVo;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(71692);
    this.fwx = 0;
    this.tVo = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dey();
    ((d.a)localObject).lBV = new dez();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dey)d.b.b(this.rr.lBR);
    ((dey)localObject).RQs = paramString1;
    ((dey)localObject).RQt = paramString2;
    this.rr.setIsUserCmd(true);
    ((dey)localObject).TMC = 0;
    ((dey)localObject).fOu = paramInt;
    ((dey)localObject).fUN = 1;
    ((dey)localObject).TMz = true;
    Log.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71692);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean, int paramInt2, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramBoolean, false, paramInt2, paramString6);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString6)
  {
    AppMethodBeat.i(71691);
    this.fwx = 0;
    this.tVo = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dey();
    ((d.a)localObject).lBV = new dez();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dey)d.b.b(this.rr.lBR);
    ((dey)localObject).RQs = paramString1;
    ((dey)localObject).RQt = paramString2;
    this.rr.setIsUserCmd(true);
    if (paramBoolean1)
    {
      ((dey)localObject).TMA = paramString3;
      if (!paramBoolean2) {
        break label287;
      }
    }
    label287:
    for (((dey)localObject).TMC = 1;; ((dey)localObject).TMC = 0)
    {
      ((dey)localObject).OIl = paramString4;
      ((dey)localObject).fvP = paramString5;
      ((dey)localObject).fOu = paramInt1;
      ((dey)localObject).TMz = false;
      ((dey)localObject).fUN = paramInt2;
      ((dey)localObject).TMD = paramString6;
      this.PiB = paramString3;
      this.PiC = paramString4;
      this.PiD = paramString5;
      Log.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[] { paramString3 });
      Log.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s, fromScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(71691);
      return;
      ((dey)localObject).TMB = paramString3;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71694);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71694);
    return i;
  }
  
  public final int getType()
  {
    return 1985;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71693);
    Log.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.PiA = ((dez)d.c.b(((com.tencent.mm.an.d)params).lBS));
    Log.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.PiA.tqa), this.PiA.tqb });
    if (!Util.isNullOrNil(this.PiA.TMx)) {
      Log.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[] { this.PiA.TMx });
    }
    try
    {
      params = new JSONObject(this.PiA.TMx);
      this.fwx = params.optInt("retcode", 0);
      this.tVo = params.optString("retmsg", "");
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(71693);
      return;
    }
    catch (JSONException params)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneOpenECard", params, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.d
 * JD-Core Version:    0.7.0.1
 */