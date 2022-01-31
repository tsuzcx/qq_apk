package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.ai.m
  implements com.tencent.mm.network.k
{
  private f callback;
  public com.tencent.mm.wallet_core.c.k jumpRemind;
  private com.tencent.mm.ai.b rr;
  public boolean ubw;
  private long udZ;
  public aoy uea;
  
  public b()
  {
    AppMethodBeat.i(46636);
    this.udZ = 10L;
    this.ubw = false;
    ab.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call");
    b.a locala = new b.a();
    aox localaox = new aox();
    localaox.wDH = com.tencent.mm.plugin.wallet_core.model.m.cTC();
    if (!com.tencent.mm.pluginsdk.wallet.g.dpN()) {
      localaox.wIZ = com.tencent.mm.pluginsdk.wallet.g.dpO();
    }
    locala.fsX = localaox;
    locala.fsY = new aoy();
    locala.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
    locala.funcId = getType();
    this.rr = locala.ado();
    this.rr.setIsUserCmd(true);
    AppMethodBeat.o(46636);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(46637);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46637);
    return i;
  }
  
  public final int getType()
  {
    return 1666;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46638);
    ab.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aoy)((com.tencent.mm.ai.b)paramq).fsW.fta;
      this.uea = paramq;
      if (paramq.xeN <= 0L) {
        l = this.udZ;
      }
    }
    for (;;)
    {
      this.ubw = paramq.ubw;
      ab.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[] { Boolean.valueOf(this.ubw) });
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.put("bindcardTitle", paramq.xeG);
        paramArrayOfByte.put("bindcardSubTitle", paramq.xeH);
        paramArrayOfByte.put("bindIdTitle", paramq.xeI);
        paramArrayOfByte.put("bindIdSubTitle", paramq.xeJ);
        paramArrayOfByte.put("extral_wording", paramq.xeK);
        paramArrayOfByte.put("question_answer_switch", paramq.xeL);
        paramArrayOfByte.put("question_answer_url", paramq.xeM);
        paramArrayOfByte.put("cache_time", l);
        paramArrayOfByte.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        paramArrayOfByte.put("isShowBindCard", paramq.xeO);
        paramArrayOfByte.put("isShowBindCardVerify", paramq.xeQ);
        paramArrayOfByte.put("isShowBindId", paramq.xeP);
        paramArrayOfByte.put("bindCardVerifyTitle", paramq.xeR);
        paramArrayOfByte.put("bindCardVerifySubtitle", paramq.xeS);
        paramArrayOfByte.put("bindCardVerifyAlertViewRightBtnTxt", paramq.xeT);
        paramArrayOfByte.put("bindCardVerifyAlertViewContent", paramq.xeU);
        paramArrayOfByte.put("isShowBindCardVerifyAlertView", paramq.xeV);
        if ((paramq.xeW != null) && (paramq.xeW.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = paramq.xeW.iterator();
          paramInt1 = 0;
          for (;;)
          {
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (paramInt1 != 0) {
                localStringBuffer.append("\n");
              }
              localStringBuffer.append(str);
              paramInt1 = 1;
              continue;
              l = paramq.xeN;
              break;
            }
          }
          paramArrayOfByte.put("cache_header_titles", localStringBuffer.toString());
        }
        paramArrayOfByte.put("isShowCapitalSecurity", paramq.xeY);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCo, paramArrayOfByte.toString());
        this.jumpRemind = com.tencent.mm.wallet_core.c.k.a(paramq.xeX);
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", paramq, "", new Object[0]);
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(46638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.b
 * JD-Core Version:    0.7.0.1
 */