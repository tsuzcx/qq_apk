package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.c.m;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  public m jumpRemind;
  private b rr;
  public boolean zWb;
  private long zZV;
  public azf zZW;
  
  public e(String paramString)
  {
    AppMethodBeat.i(70140);
    this.zZV = 10L;
    this.zWb = false;
    ad.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call: %s", new Object[] { paramString });
    b.a locala = new b.a();
    aze localaze = new aze();
    localaze.CPi = com.tencent.mm.plugin.wallet_core.model.k.ebS();
    localaze.session_id = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.eBc()) {
      localaze.CUX = com.tencent.mm.pluginsdk.wallet.e.eBd();
    }
    locala.gUU = localaze;
    locala.gUV = new azf();
    locala.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
    locala.funcId = getType();
    this.rr = locala.atI();
    this.rr.setIsUserCmd(true);
    AppMethodBeat.o(70140);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
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
    ad.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (azf)((b)paramq).gUT.gUX;
      this.zZW = paramq;
      if (paramq.DxC <= 0L) {
        l = this.zZV;
      }
    }
    for (;;)
    {
      this.zWb = paramq.zWb;
      ad.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[] { Boolean.valueOf(this.zWb) });
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.put("bindcardTitle", paramq.Dxv);
        paramArrayOfByte.put("bindcardSubTitle", paramq.Dxw);
        paramArrayOfByte.put("bindIdTitle", paramq.Dxx);
        paramArrayOfByte.put("bindIdSubTitle", paramq.Dxy);
        paramArrayOfByte.put("extral_wording", paramq.Dxz);
        paramArrayOfByte.put("question_answer_switch", paramq.DxA);
        paramArrayOfByte.put("question_answer_url", paramq.DxB);
        paramArrayOfByte.put("cache_time", l);
        paramArrayOfByte.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        paramArrayOfByte.put("isShowBindCard", paramq.DxD);
        paramArrayOfByte.put("isShowBindCardVerify", paramq.DxF);
        paramArrayOfByte.put("isShowBindId", paramq.DxE);
        paramArrayOfByte.put("bindCardVerifyTitle", paramq.DxG);
        paramArrayOfByte.put("bindCardVerifySubtitle", paramq.DxH);
        paramArrayOfByte.put("bindCardVerifyAlertViewRightBtnTxt", paramq.DxI);
        paramArrayOfByte.put("bindCardVerifyAlertViewContent", paramq.DxJ);
        paramArrayOfByte.put("isShowBindCardVerifyAlertView", paramq.DxK);
        if ((paramq.DxL != null) && (paramq.DxL.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = paramq.DxL.iterator();
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
              l = paramq.DxC;
              break;
            }
          }
          paramArrayOfByte.put("cache_header_titles", localStringBuffer.toString());
        }
        paramArrayOfByte.put("isShowCapitalSecurity", paramq.DxN);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FkK, paramArrayOfByte.toString());
        this.jumpRemind = m.a(paramq.DxM);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.e
 * JD-Core Version:    0.7.0.1
 */