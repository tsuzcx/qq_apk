package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends m
  implements k
{
  private f callback;
  public int cnK;
  public String kNv;
  private b rr;
  public bhw uzl;
  public String uzm;
  public String uzn;
  public String uzo;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(48059);
    this.cnK = 0;
    this.kNv = "";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bhv();
    ((b.a)localObject).fsY = new bhw();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bhv)this.rr.fsV.fta;
    ((bhv)localObject).wvn = paramString1;
    ((bhv)localObject).wvo = paramString2;
    this.rr.setIsUserCmd(true);
    ((bhv)localObject).xwR = 0;
    ((bhv)localObject).cCc = paramInt;
    ((bhv)localObject).cHp = 1;
    ((bhv)localObject).xwO = true;
    ab.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(48059);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean, int paramInt2, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramBoolean, false, paramInt2, paramString6);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString6)
  {
    AppMethodBeat.i(48058);
    this.cnK = 0;
    this.kNv = "";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bhv();
    ((b.a)localObject).fsY = new bhw();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bhv)this.rr.fsV.fta;
    ((bhv)localObject).wvn = paramString1;
    ((bhv)localObject).wvo = paramString2;
    this.rr.setIsUserCmd(true);
    if (paramBoolean1)
    {
      ((bhv)localObject).xwP = paramString3;
      if (!paramBoolean2) {
        break label287;
      }
    }
    label287:
    for (((bhv)localObject).xwR = 1;; ((bhv)localObject).xwR = 0)
    {
      ((bhv)localObject).ubQ = paramString4;
      ((bhv)localObject).poq = paramString5;
      ((bhv)localObject).cCc = paramInt1;
      ((bhv)localObject).xwO = false;
      ((bhv)localObject).cHp = paramInt2;
      ((bhv)localObject).xwS = paramString6;
      this.uzm = paramString3;
      this.uzn = paramString4;
      this.uzo = paramString5;
      ab.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[] { paramString3 });
      ab.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s, fromScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(48058);
      return;
      ((bhv)localObject).xwQ = paramString3;
      break;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(48061);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48061);
    return i;
  }
  
  public final int getType()
  {
    return 1985;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(48060);
    ab.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.uzl = ((bhw)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.uzl.koj), this.uzl.kok });
    if (!bo.isNullOrNil(this.uzl.xwM)) {
      ab.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[] { this.uzl.xwM });
    }
    try
    {
      paramq = new JSONObject(this.uzl.xwM);
      this.cnK = paramq.optInt("retcode", 0);
      this.kNv = paramq.optString("retmsg", "");
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(48060);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneOpenECard", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.d
 * JD-Core Version:    0.7.0.1
 */