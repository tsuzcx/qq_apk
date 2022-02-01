package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.u.a.c;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.m;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  public boolean Dgp;
  private long Dkk;
  public bht Dkl;
  private f callback;
  public m jumpRemind;
  private b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(70140);
    this.Dkk = 10L;
    this.Dgp = false;
    ae.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call: %s", new Object[] { paramString });
    b.a locala = new b.a();
    bhs localbhs = new bhs();
    localbhs.Ghz = com.tencent.mm.plugin.wallet_core.model.k.eIV();
    localbhs.session_id = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.fjq()) {
      localbhs.Gnp = com.tencent.mm.pluginsdk.wallet.e.fjr();
    }
    locala.hQF = localbhs;
    locala.hQG = new bht();
    locala.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
    locala.funcId = getType();
    this.rr = locala.aDS();
    this.rr.setIsUserCmd(true);
    AppMethodBeat.o(70140);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(70141);
    this.callback = paramf;
    c.dBH();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(70141);
    return i;
  }
  
  public final int getType()
  {
    return 1666;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70142);
    ae.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bht)((b)paramq).hQE.hQJ;
      this.Dkl = paramq;
      if (paramq.GVR <= 0L) {
        l = this.Dkk;
      }
    }
    for (;;)
    {
      this.Dgp = paramq.Dgp;
      ae.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[] { Boolean.valueOf(this.Dgp) });
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.put("bindcardTitle", paramq.GVK);
        paramArrayOfByte.put("bindcardSubTitle", paramq.GVL);
        paramArrayOfByte.put("bindIdTitle", paramq.GVM);
        paramArrayOfByte.put("bindIdSubTitle", paramq.GVN);
        paramArrayOfByte.put("extral_wording", paramq.GVO);
        paramArrayOfByte.put("question_answer_switch", paramq.GVP);
        paramArrayOfByte.put("question_answer_url", paramq.GVQ);
        paramArrayOfByte.put("cache_time", l);
        paramArrayOfByte.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        paramArrayOfByte.put("isShowBindCard", paramq.GVS);
        paramArrayOfByte.put("isShowBindCardVerify", paramq.GVU);
        paramArrayOfByte.put("isShowBindId", paramq.GVT);
        paramArrayOfByte.put("bindCardVerifyTitle", paramq.GVV);
        paramArrayOfByte.put("bindCardVerifySubtitle", paramq.GVW);
        paramArrayOfByte.put("bindCardVerifyAlertViewRightBtnTxt", paramq.GVX);
        paramArrayOfByte.put("bindCardVerifyAlertViewContent", paramq.GVY);
        paramArrayOfByte.put("isShowBindCardVerifyAlertView", paramq.GVZ);
        if ((paramq.GWa != null) && (paramq.GWa.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = paramq.GWa.iterator();
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
              l = paramq.GVR;
              break;
            }
          }
          paramArrayOfByte.put("cache_header_titles", localStringBuffer.toString());
        }
        paramArrayOfByte.put("isShowCapitalSecurity", paramq.GWc);
        g.ajS();
        g.ajR().ajA().set(am.a.IPp, paramArrayOfByte.toString());
        this.jumpRemind = m.a(paramq.GWb);
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", paramq, "", new Object[0]);
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(70142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.e
 * JD-Core Version:    0.7.0.1
 */