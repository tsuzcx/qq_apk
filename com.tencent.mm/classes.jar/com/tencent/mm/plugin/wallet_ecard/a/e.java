package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends q
  implements m
{
  public cvn IpW;
  private i callback;
  public int dDN;
  public String qwn;
  private d rr;
  public String token;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(71695);
    this.dDN = 0;
    this.qwn = "";
    this.token = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cvm();
    ((d.a)localObject).iLO = new cvn();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/openecardauth";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cvm)this.rr.iLK.iLR;
    ((cvm)localObject).KPu = paramString1;
    ((cvm)localObject).MAN = paramString2;
    ((cvm)localObject).dUS = paramInt;
    ((cvm)localObject).token = paramString3;
    this.token = null;
    Log.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Boolean.valueOf(Util.isNullOrNil(paramString2)) });
    Log.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71695);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71697);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71697);
    return i;
  }
  
  public final int getType()
  {
    return 1958;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71696);
    Log.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.IpW = ((cvn)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", new Object[] { Integer.valueOf(this.IpW.pTZ), this.IpW.pUa, Boolean.valueOf(this.IpW.MAQ) });
    if (!Util.isNullOrNil(this.IpW.MAO)) {
      Log.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", new Object[] { this.IpW.MAO });
    }
    try
    {
      params = new JSONObject(this.IpW.MAO);
      this.dDN = params.optInt("retcode", 0);
      this.qwn = params.optString("retmsg", "");
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(71696);
      return;
    }
    catch (JSONException params)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", params, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.e
 * JD-Core Version:    0.7.0.1
 */