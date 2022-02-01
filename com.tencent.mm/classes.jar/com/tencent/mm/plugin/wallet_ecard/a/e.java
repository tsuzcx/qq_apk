package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements k
{
  public cem Dpe;
  private f callback;
  public int dlw;
  public String paA;
  private b rr;
  public String token;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(71695);
    this.dlw = 0;
    this.paA = "";
    this.token = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cel();
    ((b.a)localObject).hNN = new cem();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecardauth";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cel)this.rr.hNK.hNQ;
    ((cel)localObject).FDo = paramString1;
    ((cel)localObject).GYq = paramString2;
    ((cel)localObject).dBY = paramInt;
    ((cel)localObject).token = paramString3;
    this.token = null;
    ad.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Boolean.valueOf(bt.isNullOrNil(paramString2)) });
    ad.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
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
    ad.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Dpe = ((cem)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", new Object[] { Integer.valueOf(this.Dpe.ozR), this.Dpe.ozS, Boolean.valueOf(this.Dpe.GYs) });
    if (!bt.isNullOrNil(this.Dpe.GYr)) {
      ad.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", new Object[] { this.Dpe.GYr });
    }
    try
    {
      paramq = new JSONObject(this.Dpe.GYr);
      this.dlw = paramq.optInt("retcode", 0);
      this.paA = paramq.optString("retmsg", "");
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
        ad.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.e
 * JD-Core Version:    0.7.0.1
 */