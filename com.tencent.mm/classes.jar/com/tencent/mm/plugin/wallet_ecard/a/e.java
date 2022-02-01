package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cff;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements k
{
  public cfg DGK;
  private f callback;
  public int dmy;
  public String phe;
  private b rr;
  public String token;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(71695);
    this.dmy = 0;
    this.phe = "";
    this.token = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cff();
    ((b.a)localObject).hQG = new cfg();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecardauth";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cff)this.rr.hQD.hQJ;
    ((cff)localObject).FVJ = paramString1;
    ((cff)localObject).HrR = paramString2;
    ((cff)localObject).dDd = paramInt;
    ((cff)localObject).token = paramString3;
    this.token = null;
    ae.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Boolean.valueOf(bu.isNullOrNil(paramString2)) });
    ae.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71695);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(71697);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71697);
    return i;
  }
  
  public final int getType()
  {
    return 1958;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71696);
    ae.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.DGK = ((cfg)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", new Object[] { Integer.valueOf(this.DGK.oGt), this.DGK.oGu, Boolean.valueOf(this.DGK.HrT) });
    if (!bu.isNullOrNil(this.DGK.HrS)) {
      ae.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", new Object[] { this.DGK.HrS });
    }
    try
    {
      paramq = new JSONObject(this.DGK.HrS);
      this.dmy = paramq.optInt("retcode", 0);
      this.phe = paramq.optString("retmsg", "");
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(71696);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.e
 * JD-Core Version:    0.7.0.1
 */