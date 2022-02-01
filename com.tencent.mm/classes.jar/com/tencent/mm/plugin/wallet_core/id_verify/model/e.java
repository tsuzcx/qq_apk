package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.t.a.a;
import com.tencent.mm.plugin.t.a.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.protocal.protobuf.btr;
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
  public boolean HPI;
  private long HTD;
  public btr HTE;
  private i callback;
  public com.tencent.mm.wallet_core.c.m jumpRemind;
  private d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(70140);
    this.HTD = 10L;
    this.HPI = false;
    Log.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call: %s", new Object[] { paramString });
    d.a locala = new d.a();
    btq localbtq = new btq();
    localbtq.Lcc = k.fQy();
    localbtq.session_id = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.gsQ()) {
      localbtq.LhT = com.tencent.mm.pluginsdk.wallet.e.gsR();
    }
    locala.iLN = localbtq;
    locala.iLO = new btr();
    locala.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
    locala.funcId = getType();
    this.rr = locala.aXF();
    this.rr.setIsUserCmd(true);
    AppMethodBeat.o(70140);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(70141);
    this.callback = parami;
    c.eBv().sC(false);
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
      params = (btr)((d)params).iLL.iLR;
      this.HTE = params;
      if (params.Mam <= 0L) {
        l = this.HTD;
      }
    }
    for (;;)
    {
      this.HPI = params.HPI;
      Log.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[] { Boolean.valueOf(this.HPI) });
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.put("bindcardTitle", params.Maf);
        paramArrayOfByte.put("bindcardSubTitle", params.Mag);
        paramArrayOfByte.put("bindIdTitle", params.Mah);
        paramArrayOfByte.put("bindIdSubTitle", params.Mai);
        paramArrayOfByte.put("extral_wording", params.Maj);
        paramArrayOfByte.put("question_answer_switch", params.Mak);
        paramArrayOfByte.put("question_answer_url", params.Mal);
        paramArrayOfByte.put("cache_time", l);
        paramArrayOfByte.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        paramArrayOfByte.put("isShowBindCard", params.Man);
        paramArrayOfByte.put("isShowBindCardVerify", params.Map);
        paramArrayOfByte.put("isShowBindId", params.Mao);
        paramArrayOfByte.put("bindCardVerifyTitle", params.Maq);
        paramArrayOfByte.put("bindCardVerifySubtitle", params.Mar);
        paramArrayOfByte.put("bindCardVerifyAlertViewRightBtnTxt", params.Mas);
        paramArrayOfByte.put("bindCardVerifyAlertViewContent", params.Mat);
        paramArrayOfByte.put("isShowBindCardVerifyAlertView", params.Mau);
        if ((params.Mav != null) && (params.Mav.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = params.Mav.iterator();
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
              l = params.Mam;
              break;
            }
          }
          paramArrayOfByte.put("cache_header_titles", localStringBuffer.toString());
        }
        paramArrayOfByte.put("isShowCapitalSecurity", params.Max);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXq, paramArrayOfByte.toString());
        this.jumpRemind = com.tencent.mm.wallet_core.c.m.a(params.Maw);
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