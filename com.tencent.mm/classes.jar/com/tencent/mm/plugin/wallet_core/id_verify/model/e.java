package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.ad.a.a;
import com.tencent.mm.plugin.ad.a.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends q
  implements com.tencent.mm.network.m
{
  public boolean OHR;
  private long OLK;
  public cbj OLL;
  private i callback;
  public com.tencent.mm.wallet_core.c.m jumpRemind;
  private d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(70140);
    this.OLK = 10L;
    this.OHR = false;
    Log.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call: %s", new Object[] { paramString });
    d.a locala = new d.a();
    cbi localcbi = new cbi();
    localcbi.Sdp = k.gJe();
    localcbi.session_id = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.hod()) {
      localcbi.Sjh = com.tencent.mm.pluginsdk.wallet.e.hoe();
    }
    locala.lBU = localcbi;
    locala.lBV = new cbj();
    locala.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
    locala.funcId = getType();
    this.rr = locala.bgN();
    this.rr.setIsUserCmd(true);
    AppMethodBeat.o(70140);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(70141);
    this.callback = parami;
    c.fnc().vR(false);
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(70141);
    return i;
  }
  
  public final int getType()
  {
    return 1666;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70142);
    Log.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cbj)d.c.b(((d)params).lBS);
      this.OLL = params;
      if (params.TjF <= 0L) {
        l = this.OLK;
      }
    }
    for (;;)
    {
      this.OHR = params.OHR;
      Log.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[] { Boolean.valueOf(this.OHR) });
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.put("bindcardTitle", params.Tjy);
        paramArrayOfByte.put("bindcardSubTitle", params.Tjz);
        paramArrayOfByte.put("bindIdTitle", params.TjA);
        paramArrayOfByte.put("bindIdSubTitle", params.TjB);
        paramArrayOfByte.put("extral_wording", params.TjC);
        paramArrayOfByte.put("question_answer_switch", params.TjD);
        paramArrayOfByte.put("question_answer_url", params.TjE);
        paramArrayOfByte.put("cache_time", l);
        paramArrayOfByte.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        paramArrayOfByte.put("isShowBindCard", params.TjG);
        paramArrayOfByte.put("isShowBindCardVerify", params.TjI);
        paramArrayOfByte.put("isShowBindId", params.TjH);
        paramArrayOfByte.put("bindCardVerifyTitle", params.TjJ);
        paramArrayOfByte.put("bindCardVerifySubtitle", params.TjK);
        paramArrayOfByte.put("bindCardVerifyAlertViewRightBtnTxt", params.TjL);
        paramArrayOfByte.put("bindCardVerifyAlertViewContent", params.TjM);
        paramArrayOfByte.put("isShowBindCardVerifyAlertView", params.TjN);
        if ((params.TjO != null) && (params.TjO.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = params.TjO.iterator();
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
              l = params.TjF;
              break;
            }
          }
          paramArrayOfByte.put("cache_header_titles", localStringBuffer.toString());
        }
        paramArrayOfByte.put("isShowCapitalSecurity", params.TjQ);
        h.aHH();
        h.aHG().aHp().set(ar.a.Vlq, paramArrayOfByte.toString());
        this.jumpRemind = com.tencent.mm.wallet_core.c.m.a(params.TjP);
      }
      catch (JSONException params)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", params, "", new Object[0]);
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(70142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.e
 * JD-Core Version:    0.7.0.1
 */