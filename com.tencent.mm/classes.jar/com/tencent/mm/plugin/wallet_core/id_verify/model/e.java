package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.ae.a.a;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends p
  implements com.tencent.mm.network.m
{
  private long CACHE_TIME;
  public cqs VBw;
  public boolean VxE;
  private com.tencent.mm.am.h callback;
  public com.tencent.mm.wallet_core.model.m jumpRemind;
  private com.tencent.mm.am.c rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(70140);
    this.CACHE_TIME = 10L;
    this.VxE = false;
    Log.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call: %s", new Object[] { paramString });
    c.a locala = new c.a();
    cqr localcqr = new cqr();
    localcqr.Zbi = k.iis();
    localcqr.session_id = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.iOV()) {
      localcqr.Zhn = com.tencent.mm.pluginsdk.wallet.e.iOW();
    }
    locala.otE = localcqr;
    locala.otF = new cqs();
    locala.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
    locala.funcId = getType();
    this.rr = locala.bEF();
    this.rr.setIsUserCmd(true);
    AppMethodBeat.o(70140);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(70141);
    this.callback = paramh;
    com.tencent.mm.plugin.ae.a.c.gxP().An(false);
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
      params = (cqs)c.c.b(((com.tencent.mm.am.c)params).otC);
      this.VBw = params;
      if (params.aaxi <= 0L) {
        l = this.CACHE_TIME;
      }
    }
    for (;;)
    {
      this.VxE = params.VxE;
      Log.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[] { Boolean.valueOf(this.VxE) });
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.put("bindcardTitle", params.aaxb);
        paramArrayOfByte.put("bindcardSubTitle", params.aaxc);
        paramArrayOfByte.put("bindIdTitle", params.aaxd);
        paramArrayOfByte.put("bindIdSubTitle", params.aaxe);
        paramArrayOfByte.put("extral_wording", params.aaxf);
        paramArrayOfByte.put("question_answer_switch", params.aaxg);
        paramArrayOfByte.put("question_answer_url", params.aaxh);
        paramArrayOfByte.put("cache_time", l);
        paramArrayOfByte.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        paramArrayOfByte.put("isShowBindCard", params.aaxj);
        paramArrayOfByte.put("isShowBindCardVerify", params.aaxl);
        paramArrayOfByte.put("isShowBindId", params.aaxk);
        paramArrayOfByte.put("bindCardVerifyTitle", params.aaxm);
        paramArrayOfByte.put("bindCardVerifySubtitle", params.aaxn);
        paramArrayOfByte.put("bindCardVerifyAlertViewRightBtnTxt", params.aaxo);
        paramArrayOfByte.put("bindCardVerifyAlertViewContent", params.aaxp);
        paramArrayOfByte.put("isShowBindCardVerifyAlertView", params.aaxq);
        if ((params.aaxr != null) && (params.aaxr.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = params.aaxr.iterator();
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
              l = params.aaxi;
              break;
            }
          }
          paramArrayOfByte.put("cache_header_titles", localStringBuffer.toString());
        }
        paramArrayOfByte.put("isShowCapitalSecurity", params.aaxt);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acMK, paramArrayOfByte.toString());
        this.jumpRemind = com.tencent.mm.wallet_core.model.m.a(params.aaxs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.e
 * JD-Core Version:    0.7.0.1
 */