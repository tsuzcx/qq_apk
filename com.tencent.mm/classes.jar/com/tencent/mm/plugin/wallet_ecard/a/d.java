package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends q
  implements m
{
  public cvp IpS;
  public String IpT;
  public String IpU;
  public String IpV;
  private i callback;
  public int dDN;
  public String qwn;
  private com.tencent.mm.ak.d rr;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(71692);
    this.dDN = 0;
    this.qwn = "";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cvo();
    ((d.a)localObject).iLO = new cvp();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cvo)this.rr.iLK.iLR;
    ((cvo)localObject).KPu = paramString1;
    ((cvo)localObject).KPv = paramString2;
    this.rr.setIsUserCmd(true);
    ((cvo)localObject).MAU = 0;
    ((cvo)localObject).dUS = paramInt;
    ((cvo)localObject).eaQ = 1;
    ((cvo)localObject).MAR = true;
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
    this.dDN = 0;
    this.qwn = "";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cvo();
    ((d.a)localObject).iLO = new cvp();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cvo)this.rr.iLK.iLR;
    ((cvo)localObject).KPu = paramString1;
    ((cvo)localObject).KPv = paramString2;
    this.rr.setIsUserCmd(true);
    if (paramBoolean1)
    {
      ((cvo)localObject).MAS = paramString3;
      if (!paramBoolean2) {
        break label287;
      }
    }
    label287:
    for (((cvo)localObject).MAU = 1;; ((cvo)localObject).MAU = 0)
    {
      ((cvo)localObject).HQc = paramString4;
      ((cvo)localObject).dDj = paramString5;
      ((cvo)localObject).dUS = paramInt1;
      ((cvo)localObject).MAR = false;
      ((cvo)localObject).eaQ = paramInt2;
      ((cvo)localObject).MAV = paramString6;
      this.IpT = paramString3;
      this.IpU = paramString4;
      this.IpV = paramString5;
      Log.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[] { paramString3 });
      Log.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s, fromScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(71691);
      return;
      ((cvo)localObject).MAT = paramString3;
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
    this.IpS = ((cvp)((com.tencent.mm.ak.d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.IpS.pTZ), this.IpS.pUa });
    if (!Util.isNullOrNil(this.IpS.MAO)) {
      Log.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[] { this.IpS.MAO });
    }
    try
    {
      params = new JSONObject(this.IpS.MAO);
      this.dDN = params.optInt("retcode", 0);
      this.qwn = params.optString("retmsg", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.d
 * JD-Core Version:    0.7.0.1
 */