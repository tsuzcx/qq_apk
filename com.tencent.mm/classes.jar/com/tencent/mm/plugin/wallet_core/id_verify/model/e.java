package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.c.m;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  public boolean COK;
  private long CSE;
  public bhd CSF;
  private f callback;
  public m jumpRemind;
  private com.tencent.mm.al.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(70140);
    this.CSE = 10L;
    this.COK = false;
    ad.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call: %s", new Object[] { paramString });
    b.a locala = new b.a();
    bhc localbhc = new bhc();
    localbhc.FPa = com.tencent.mm.plugin.wallet_core.model.k.eFo();
    localbhc.session_id = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.ffA()) {
      localbhc.FUQ = com.tencent.mm.pluginsdk.wallet.e.ffB();
    }
    locala.hNM = localbhc;
    locala.hNN = new bhd();
    locala.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
    locala.funcId = getType();
    this.rr = locala.aDC();
    this.rr.setIsUserCmd(true);
    AppMethodBeat.o(70140);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(70141);
    this.callback = paramf;
    com.tencent.mm.plugin.u.a.b.dyr();
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
    ad.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bhd)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      this.CSF = paramq;
      if (paramq.GCr <= 0L) {
        l = this.CSE;
      }
    }
    for (;;)
    {
      this.COK = paramq.COK;
      ad.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[] { Boolean.valueOf(this.COK) });
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.put("bindcardTitle", paramq.GCk);
        paramArrayOfByte.put("bindcardSubTitle", paramq.GCl);
        paramArrayOfByte.put("bindIdTitle", paramq.GCm);
        paramArrayOfByte.put("bindIdSubTitle", paramq.GCn);
        paramArrayOfByte.put("extral_wording", paramq.GCo);
        paramArrayOfByte.put("question_answer_switch", paramq.GCp);
        paramArrayOfByte.put("question_answer_url", paramq.GCq);
        paramArrayOfByte.put("cache_time", l);
        paramArrayOfByte.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        paramArrayOfByte.put("isShowBindCard", paramq.GCs);
        paramArrayOfByte.put("isShowBindCardVerify", paramq.GCu);
        paramArrayOfByte.put("isShowBindId", paramq.GCt);
        paramArrayOfByte.put("bindCardVerifyTitle", paramq.GCv);
        paramArrayOfByte.put("bindCardVerifySubtitle", paramq.GCw);
        paramArrayOfByte.put("bindCardVerifyAlertViewRightBtnTxt", paramq.GCx);
        paramArrayOfByte.put("bindCardVerifyAlertViewContent", paramq.GCy);
        paramArrayOfByte.put("isShowBindCardVerifyAlertView", paramq.GCz);
        if ((paramq.GCA != null) && (paramq.GCA.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = paramq.GCA.iterator();
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
              l = paramq.GCr;
              break;
            }
          }
          paramArrayOfByte.put("cache_header_titles", localStringBuffer.toString());
        }
        paramArrayOfByte.put("isShowCapitalSecurity", paramq.GCC);
        g.ajD();
        g.ajC().ajl().set(al.a.IuR, paramArrayOfByte.toString());
        this.jumpRemind = m.a(paramq.GCB);
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", paramq, "", new Object[0]);
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(70142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.e
 * JD-Core Version:    0.7.0.1
 */