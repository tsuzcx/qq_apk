package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.c.m;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  public boolean Bov;
  private long Bsp;
  public bcx Bsq;
  private com.tencent.mm.ak.g callback;
  public m jumpRemind;
  private b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(70140);
    this.Bsp = 10L;
    this.Bov = false;
    ac.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call: %s", new Object[] { paramString });
    b.a locala = new b.a();
    bcw localbcw = new bcw();
    localbcw.EhT = com.tencent.mm.plugin.wallet_core.model.k.ero();
    localbcw.session_id = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.eQw()) {
      localbcw.EnH = com.tencent.mm.pluginsdk.wallet.e.eQx();
    }
    locala.hvt = localbcw;
    locala.hvu = new bcx();
    locala.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
    locala.funcId = getType();
    this.rr = locala.aAz();
    this.rr.setIsUserCmd(true);
    AppMethodBeat.o(70140);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(70141);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bcx)((b)paramq).hvs.hvw;
      this.Bsq = paramq;
      if (paramq.ESY <= 0L) {
        l = this.Bsp;
      }
    }
    for (;;)
    {
      this.Bov = paramq.Bov;
      ac.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[] { Boolean.valueOf(this.Bov) });
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.put("bindcardTitle", paramq.ESR);
        paramArrayOfByte.put("bindcardSubTitle", paramq.ESS);
        paramArrayOfByte.put("bindIdTitle", paramq.EST);
        paramArrayOfByte.put("bindIdSubTitle", paramq.ESU);
        paramArrayOfByte.put("extral_wording", paramq.ESV);
        paramArrayOfByte.put("question_answer_switch", paramq.ESW);
        paramArrayOfByte.put("question_answer_url", paramq.ESX);
        paramArrayOfByte.put("cache_time", l);
        paramArrayOfByte.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        paramArrayOfByte.put("isShowBindCard", paramq.ESZ);
        paramArrayOfByte.put("isShowBindCardVerify", paramq.ETb);
        paramArrayOfByte.put("isShowBindId", paramq.ETa);
        paramArrayOfByte.put("bindCardVerifyTitle", paramq.ETc);
        paramArrayOfByte.put("bindCardVerifySubtitle", paramq.ETd);
        paramArrayOfByte.put("bindCardVerifyAlertViewRightBtnTxt", paramq.ETe);
        paramArrayOfByte.put("bindCardVerifyAlertViewContent", paramq.ETf);
        paramArrayOfByte.put("isShowBindCardVerifyAlertView", paramq.ETg);
        if ((paramq.ETh != null) && (paramq.ETh.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = paramq.ETh.iterator();
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
              l = paramq.ESY;
              break;
            }
          }
          paramArrayOfByte.put("cache_header_titles", localStringBuffer.toString());
        }
        paramArrayOfByte.put("isShowCapitalSecurity", paramq.ETj);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIz, paramArrayOfByte.toString());
        this.jumpRemind = m.a(paramq.ETi);
      }
      catch (JSONException paramq)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", paramq, "", new Object[0]);
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