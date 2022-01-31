package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends m
  implements k
{
  private f callback;
  public int cnK;
  public String kNv;
  private b rr;
  public String token;
  public bhu uzp;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(48062);
    this.cnK = 0;
    this.kNv = "";
    this.token = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bht();
    ((b.a)localObject).fsY = new bhu();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecardauth";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bht)this.rr.fsV.fta;
    ((bht)localObject).wvn = paramString1;
    ((bht)localObject).xwL = paramString2;
    ((bht)localObject).cCc = paramInt;
    ((bht)localObject).token = paramString3;
    this.token = null;
    ab.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Boolean.valueOf(bo.isNullOrNil(paramString2)) });
    ab.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(48062);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(48064);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48064);
    return i;
  }
  
  public final int getType()
  {
    return 1958;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(48063);
    ab.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.uzp = ((bhu)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", new Object[] { Integer.valueOf(this.uzp.koj), this.uzp.kok, Boolean.valueOf(this.uzp.xwN) });
    if (!bo.isNullOrNil(this.uzp.xwM)) {
      ab.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", new Object[] { this.uzp.xwM });
    }
    try
    {
      paramq = new JSONObject(this.uzp.xwM);
      this.cnK = paramq.optInt("retcode", 0);
      this.kNv = paramq.optString("retmsg", "");
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(48063);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.e
 * JD-Core Version:    0.7.0.1
 */