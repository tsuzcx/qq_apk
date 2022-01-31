package com.tencent.mm.plugin.topstory;

import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.pa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.topstory.a.e
{
  private f eeo = new b.2(this);
  private byd pCR;
  o pCS = new b.1(this);
  com.tencent.mm.plugin.topstory.a.c.a pCT;
  
  public b()
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.pCS);
    this.pCR = new byd();
    b(this.pCR);
    byd localbyd = this.pCR;
    Object localObject = (String)g.DP().Dz().get(ac.a.uyS, "");
    if (!bk.bl((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject != null) {}
      try
      {
        if (localObject.length == 13)
        {
          localbyd.bVP = localObject[0];
          localbyd.tOi = Integer.valueOf(localObject[1]).intValue();
          localbyd.qUT = Integer.valueOf(localObject[2]).intValue();
          localbyd.qUU = Integer.valueOf(localObject[3]).intValue();
          localbyd.qUS = Integer.valueOf(localObject[4]).intValue();
          localbyd.eCv = Long.valueOf(localObject[5]).longValue();
          localbyd.qTU = Integer.valueOf(localObject[6]).intValue();
          localbyd.tOj = Long.valueOf(localObject[7]).longValue();
          localbyd.text = localObject[8];
          localbyd.type = Integer.valueOf(localObject[9]).intValue();
          localbyd.cCu = Integer.valueOf(localObject[10]).intValue();
          localbyd.tOh = Long.valueOf(localObject[11]).longValue();
          localbyd.bVO = localObject[12];
          return;
        }
        g.DP().Dz().c(ac.a.uyS, "");
        return;
      }
      catch (Exception localException)
      {
        g.DP().Dz().c(ac.a.uyS, "");
      }
    }
  }
  
  static void b(byd parambyd)
  {
    parambyd.bVO = "";
    parambyd.bVP = "";
    parambyd.text = "";
  }
  
  private void bMW()
  {
    this.pCR = new byd();
    b(this.pCR);
    g.DP().Dz().c(ac.a.uyS, "");
  }
  
  private void bMZ()
  {
    z localz = g.DP().Dz();
    ac.a locala = ac.a.uyS;
    byd localbyd = this.pCR;
    localz.c(locala, String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { localbyd.bVP, Integer.valueOf(localbyd.tOi), Integer.valueOf(localbyd.qUT), Integer.valueOf(localbyd.qUU), Integer.valueOf(localbyd.qUS), Long.valueOf(localbyd.eCv), Integer.valueOf(localbyd.qTU), Long.valueOf(localbyd.tOj), localbyd.text, Integer.valueOf(localbyd.type), Integer.valueOf(localbyd.cCu), Long.valueOf(localbyd.tOh), localbyd.bVO }));
  }
  
  private int bNa()
  {
    int j = 0;
    int i = 1;
    if (bk.bl(this.pCR.bVP)) {
      j = -5;
    }
    label272:
    label275:
    for (;;)
    {
      return j;
      if (this.pCR.tOi == 1) {
        return -1;
      }
      if (this.pCR.qUT > d.spa)
      {
        y.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.pCR.bVP, Integer.valueOf(this.pCR.qUT), Integer.valueOf(d.spa) });
        return -2;
      }
      long l1 = this.pCR.tOj;
      long l2 = this.pCR.eCv;
      if (System.currentTimeMillis() > l1 + l2 * 1000L)
      {
        y.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { this.pCR.bVP });
        return -3;
      }
      boolean bool;
      if (aa.Bs(1) >= this.pCR.qTU)
      {
        bool = true;
        y.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.pCR.qTU), Integer.valueOf(aa.Bs(1)), Long.valueOf(this.pCR.tOh), Long.valueOf(bNb()) });
        if ((aa.Bs(1) < this.pCR.qTU) || (this.pCR.tOh <= bNb())) {
          break label272;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label275;
        }
        return -4;
        bool = false;
        break;
        i = 0;
      }
    }
  }
  
  private static long bNb()
  {
    Object localObject = g.DP().Dz().get(ac.a.uyR, null);
    if (localObject == null) {
      return 0L;
    }
    return ((Long)localObject).longValue();
  }
  
  public final void a(byd parambyd)
  {
    if ((this.pCR != null) && (!bk.bl(this.pCR.bVP)) && (this.pCR.cCu != 1)) {
      switch (bNa())
      {
      }
    }
    for (;;)
    {
      this.pCR = parambyd;
      bMZ();
      ao.aU(10, this.pCR.bVP);
      if (this.pCR.qUS != 3) {
        break;
      }
      Object localObject = ac.Ru("discoverRecommendEntry").optString("wording");
      parambyd = new byb();
      parambyd.tNY = UUID.randomUUID().toString();
      parambyd.scene = 0;
      parambyd.fTF = "";
      parambyd.bGm = ((String)localObject);
      localObject = aa.Bm(0);
      parambyd.bIB = ((String)localObject);
      parambyd.bVp = ((String)localObject);
      localObject = new rb();
      ((rb)localObject).key = "redPointMsgId";
      ((rb)localObject).sOJ = this.pCR.bVP;
      parambyd.qTG.add(localObject);
      localObject = new rb();
      ((rb)localObject).key = "netType";
      ((rb)localObject).sOJ = aa.boM();
      parambyd.qTG.add(localObject);
      localObject = new rb();
      ((rb)localObject).key = "time_zone_min";
      ((rb)localObject).sOJ = String.valueOf(-TimeZone.getDefault().getRawOffset() / 1000 / 60);
      parambyd.qTG.add(localObject);
      this.pCT = new com.tencent.mm.plugin.topstory.a.c.a(parambyd);
      g.Dk().a(this.pCT.getType(), this.eeo);
      g.Dk().a(this.pCT, 0);
      return;
      ao.aU(15, this.pCR.bVP);
      continue;
      ao.aU(13, this.pCR.bVP);
    }
    parambyd = new pa();
    com.tencent.mm.sdk.b.a.udP.m(parambyd);
  }
  
  public final boolean bMU()
  {
    int i = bNa();
    JSONObject localJSONObject;
    boolean bool;
    if (i == 0)
    {
      localJSONObject = ac.Ru("discoverRecommendEntry");
      if (((com.tencent.mm.plugin.welab.a.a.a)g.r(com.tencent.mm.plugin.welab.a.a.a.class)).Ul("labs_browse"))
      {
        if (!((com.tencent.mm.plugin.welab.a.a.a)g.r(com.tencent.mm.plugin.welab.a.a.a.class)).Uj("labs_browse")) {
          break label122;
        }
        bool = true;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recommend show %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        return true;
        if (localJSONObject.optInt("entrySwitch") != 1) {
          break label122;
        }
        bool = true;
        continue;
        if (i == -3)
        {
          ao.aU(14, this.pCR.bVP);
          bMW();
        }
      }
      return false;
      label122:
      bool = false;
    }
  }
  
  public final void bMV()
  {
    if (bMU())
    {
      y.i("MicroMsg.TopStory.TopStoryRedDotImpl", "click red dot, report and clear red dot");
      ao.aU(12, this.pCR.bVP);
      bMW();
    }
  }
  
  public final byd bMX()
  {
    return this.pCR;
  }
  
  public final void bMY()
  {
    if (this.pCR.cCu != 1)
    {
      this.pCR.cCu = 1;
      ao.aU(11, this.pCR.bVP);
      bMZ();
    }
  }
  
  public final void gG(long paramLong)
  {
    y.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d", new Object[] { Long.valueOf(paramLong) });
    g.DP().Dz().c(ac.a.uyR, Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b
 * JD-Core Version:    0.7.0.1
 */