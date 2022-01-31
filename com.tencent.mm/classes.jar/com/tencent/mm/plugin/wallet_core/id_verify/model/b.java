package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.asl;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.i.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  public com.tencent.mm.wallet_core.c.i lQQ;
  public boolean qqA = false;
  private long qsg = 10L;
  
  public b()
  {
    y.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call");
    b.a locala = new b.a();
    ajq localajq = new ajq();
    localajq.sHl = com.tencent.mm.plugin.wallet_core.model.i.bVj();
    if (!com.tencent.mm.pluginsdk.wallet.f.cow()) {
      localajq.sLl = com.tencent.mm.pluginsdk.wallet.f.cox();
    }
    locala.ecH = localajq;
    locala.ecI = new ajr();
    locala.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
    locala.ecG = 1666;
    this.dmK = locala.Kt();
    this.dmK.ecZ = true;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ajr)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      if (paramq.tgo <= 0L)
      {
        l = this.qsg;
        this.qqA = paramq.qqA;
        y.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[] { Boolean.valueOf(this.qqA) });
        paramArrayOfByte = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte.put("bindcardTitle", paramq.tgh);
        paramArrayOfByte.put("bindcardSubTitle", paramq.tgi);
        paramArrayOfByte.put("bindIdTitle", paramq.tgj);
        paramArrayOfByte.put("bindIdSubTitle", paramq.tgk);
        paramArrayOfByte.put("extral_wording", paramq.tgl);
        paramArrayOfByte.put("question_answer_switch", paramq.tgm);
        paramArrayOfByte.put("question_answer_url", paramq.tgn);
        paramArrayOfByte.put("cache_time", l);
        paramArrayOfByte.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        paramArrayOfByte.put("isShowBindCard", paramq.tgp);
        paramArrayOfByte.put("isShowBindCardVerify", paramq.tgr);
        paramArrayOfByte.put("isShowBindId", paramq.tgq);
        paramArrayOfByte.put("bindCardVerifyTitle", paramq.tgs);
        paramArrayOfByte.put("bindCardVerifySubtitle", paramq.tgt);
        paramArrayOfByte.put("bindCardVerifyAlertViewRightBtnTxt", paramq.tgu);
        paramArrayOfByte.put("bindCardVerifyAlertViewContent", paramq.tgv);
        paramArrayOfByte.put("isShowBindCardVerifyAlertView", paramq.tgw);
        if ((paramq.tgx != null) && (paramq.tgx.size() > 0))
        {
          localObject = new StringBuffer();
          Iterator localIterator = paramq.tgx.iterator();
          paramInt1 = 0;
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (paramInt1 != 0) {
              ((StringBuffer)localObject).append("\n");
            }
            ((StringBuffer)localObject).append(str);
            paramInt1 = 1;
            continue;
            l = paramq.tgo;
            break;
          }
          paramArrayOfByte.put("cache_header_titles", ((StringBuffer)localObject).toString());
        }
        g.DQ();
        g.DP().Dz().c(ac.a.uso, paramArrayOfByte.toString());
        g.DQ();
        g.DP().Dz().mC(true);
        localObject = paramq.tgy;
        if (localObject != null) {
          continue;
        }
        paramq = null;
        this.lQQ = paramq;
      }
      catch (JSONException paramq)
      {
        Object localObject;
        y.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", paramq, "", new Object[0]);
        continue;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      paramArrayOfByte = new com.tencent.mm.wallet_core.c.i();
      paramArrayOfByte.tol = ((asl)localObject).tol;
      paramArrayOfByte.qho = ((asl)localObject).qho;
      paramArrayOfByte.bQZ = ((asl)localObject).bQZ;
      paramArrayOfByte.lRE = ((asl)localObject).lRE;
      paramArrayOfByte.lRF = ((asl)localObject).lRF;
      paramArrayOfByte.title = ((asl)localObject).title;
      paramArrayOfByte.wAl = new i.a();
      paramq = paramArrayOfByte;
      if (((asl)localObject).tom != null)
      {
        paramArrayOfByte.wAl.type = ((asl)localObject).tom.type;
        paramArrayOfByte.wAl.bOL = ((asl)localObject).tom.bOL;
        paramArrayOfByte.wAl.tDL = ((asl)localObject).tom.tDL;
        paramArrayOfByte.wAl.path = ((asl)localObject).tom.path;
        paramArrayOfByte.wAl.tDM = ((asl)localObject).tom.tDM;
        paramq = paramArrayOfByte;
      }
    }
  }
  
  public final int getType()
  {
    return 1666;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.b
 * JD-Core Version:    0.7.0.1
 */