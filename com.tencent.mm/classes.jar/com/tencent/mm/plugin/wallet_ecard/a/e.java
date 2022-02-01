package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzu;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements k
{
  public bzv BOM;
  private g callback;
  public int dae;
  public String oxf;
  private b rr;
  public String token;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(71695);
    this.dae = 0;
    this.oxf = "";
    this.token = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bzu();
    ((b.a)localObject).hvu = new bzv();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecardauth";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bzu)this.rr.hvr.hvw;
    ((bzu)localObject).DXS = paramString1;
    ((bzu)localObject).FoE = paramString2;
    ((bzu)localObject).dql = paramInt;
    ((bzu)localObject).token = paramString3;
    this.token = null;
    ac.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Boolean.valueOf(bs.isNullOrNil(paramString2)) });
    ac.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71695);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(71697);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.BOM = ((bzv)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", new Object[] { Integer.valueOf(this.BOM.nWx), this.BOM.nWy, Boolean.valueOf(this.BOM.FoG) });
    if (!bs.isNullOrNil(this.BOM.FoF)) {
      ac.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", new Object[] { this.BOM.FoF });
    }
    try
    {
      paramq = new JSONObject(this.BOM.FoF);
      this.dae = paramq.optInt("retcode", 0);
      this.oxf = paramq.optString("retmsg", "");
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
        ac.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.e
 * JD-Core Version:    0.7.0.1
 */