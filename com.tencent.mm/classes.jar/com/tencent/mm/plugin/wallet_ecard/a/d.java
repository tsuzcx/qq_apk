package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends w
{
  public dwy VZo;
  public String VZp;
  public String VZq;
  public String VZr;
  private h callback;
  public int hAV;
  private c rr;
  public String wYI;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(71692);
    this.hAV = 0;
    this.wYI = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dwx();
    ((c.a)localObject).otF = new dwy();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dwx)c.b.b(this.rr.otB);
    ((dwx)localObject).YNI = paramString1;
    ((dwx)localObject).YNJ = paramString2;
    this.rr.setIsUserCmd(true);
    ((dwx)localObject).abcL = 0;
    ((dwx)localObject).hUn = paramInt;
    ((dwx)localObject).iaK = 1;
    ((dwx)localObject).abcI = true;
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
    this.hAV = 0;
    this.wYI = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dwx();
    ((c.a)localObject).otF = new dwy();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dwx)c.b.b(this.rr.otB);
    ((dwx)localObject).YNI = paramString1;
    ((dwx)localObject).YNJ = paramString2;
    this.rr.setIsUserCmd(true);
    if (paramBoolean1)
    {
      ((dwx)localObject).abcJ = paramString3;
      if (!paramBoolean2) {
        break label287;
      }
    }
    label287:
    for (((dwx)localObject).abcL = 1;; ((dwx)localObject).abcL = 0)
    {
      ((dwx)localObject).VxX = paramString4;
      ((dwx)localObject).hAk = paramString5;
      ((dwx)localObject).hUn = paramInt1;
      ((dwx)localObject).abcI = false;
      ((dwx)localObject).iaK = paramInt2;
      ((dwx)localObject).abcM = paramString6;
      this.VZp = paramString3;
      this.VZq = paramString4;
      this.VZr = paramString5;
      Log.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[] { paramString3 });
      Log.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s, fromScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(71691);
      return;
      ((dwx)localObject).abcK = paramString3;
      break;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(71694);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71694);
    return i;
  }
  
  public final int getType()
  {
    return 1985;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(262491);
    Log.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.VZo = ((dwy)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.VZo.wuz), this.VZo.wuA });
    if (!Util.isNullOrNil(this.VZo.abcG)) {
      Log.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[] { this.VZo.abcG });
    }
    try
    {
      params = new JSONObject(this.VZo.abcG);
      this.hAV = params.optInt("retcode", 0);
      this.wYI = params.optString("retmsg", "");
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(262491);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.d
 * JD-Core Version:    0.7.0.1
 */