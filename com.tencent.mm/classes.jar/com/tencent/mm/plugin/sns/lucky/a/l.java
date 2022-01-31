package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.buc;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigInteger;

public final class l
  implements bx.a
{
  private static String U(String paramString1, String paramString2, String paramString3)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString3))) {
      return "";
    }
    int j = paramString1.indexOf(paramString2);
    if (j >= 0) {}
    for (int i = paramString1.indexOf(paramString3); (j >= 0) && (i > j); i = -1) {
      return paramString1.substring(j, i + paramString3.length());
    }
    return "";
  }
  
  public final void a(e.a parama)
  {
    if ((parama == null) || (parama.dBs == null) || (parama.dBs.svH == null))
    {
      y.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
      return;
    }
    Object localObject2 = aa.a(parama.dBs.svH);
    y.d("MicroMsg.SimpleExperimentLsn", "recv addMsg " + (String)localObject2);
    parama = U((String)localObject2, "<TimelineObject", "</TimelineObject>");
    if (bk.bl(parama))
    {
      y.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
      return;
    }
    Object localObject1 = U((String)localObject2, "<RecXml", "</RecXml>");
    if (bk.bl((String)localObject1))
    {
      y.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
      return;
    }
    Object localObject3 = U((String)localObject2, "<ADInfo", "</ADInfo>");
    if (bk.bl((String)localObject3))
    {
      y.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
      return;
    }
    localObject2 = e.nn(parama);
    bjk localbjk = new bjk();
    localbjk.tDl = aa.pj((String)localObject3);
    localObject3 = new buc();
    localbjk.tDk = ((buc)localObject3);
    ((buc)localObject3).tKN = aa.pj((String)localObject1);
    localObject1 = new bto();
    ((bto)localObject1).sGd = new BigInteger(((bxk)localObject2).lsK).longValue();
    ((bto)localObject1).mPL = ((bxk)localObject2).mPL;
    ((bto)localObject1).sxM = ((bxk)localObject2).hPY;
    ((bto)localObject1).tJU = aa.I(parama.getBytes());
    ((buc)localObject3).tJi = ((bto)localObject1);
    a.b(localbjk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.l
 * JD-Core Version:    0.7.0.1
 */