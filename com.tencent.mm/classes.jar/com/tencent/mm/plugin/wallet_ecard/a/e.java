package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends p
  implements m
{
  public dww VZs;
  private h callback;
  public int hAV;
  private c rr;
  public String token;
  public String wYI;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(71695);
    this.hAV = 0;
    this.wYI = "";
    this.token = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dwv();
    ((c.a)localObject).otF = new dww();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/openecardauth";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dwv)c.b.b(this.rr.otB);
    ((dwv)localObject).YNI = paramString1;
    ((dwv)localObject).abcF = paramString2;
    ((dwv)localObject).hUn = paramInt;
    ((dwv)localObject).token = paramString3;
    this.token = null;
    Log.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Boolean.valueOf(Util.isNullOrNil(paramString2)) });
    Log.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71695);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(71697);
    this.callback = paramh;
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
    this.VZs = ((dww)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", new Object[] { Integer.valueOf(this.VZs.wuz), this.VZs.wuA, Boolean.valueOf(this.VZs.abcH) });
    if (!Util.isNullOrNil(this.VZs.abcG)) {
      Log.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", new Object[] { this.VZs.abcG });
    }
    try
    {
      params = new JSONObject(this.VZs.abcG);
      this.hAV = params.optInt("retcode", 0);
      this.wYI = params.optString("retmsg", "");
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