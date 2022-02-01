package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.topstory.a.e
{
  private com.tencent.mm.ak.g hwV;
  public dii zYR;
  LinkedList<dii> zYS;
  e.a zYT;
  p zYU;
  com.tencent.mm.plugin.topstory.a.c.b zYV;
  final String zYW;
  String zYX;
  c<fi> zYY;
  
  public b()
  {
    AppMethodBeat.i(88420);
    this.zYS = new LinkedList();
    this.zYU = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(88417);
        if ((paramAnonymousMap != null) && (paramAnonymousString != null) && (paramAnonymousString.equals("mmsearch_reddot_new")))
        {
          int i = bs.aLy((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.entry"));
          if (i == 2)
          {
            paramAnonymousString = new dii();
            b.d(paramAnonymousString);
            ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramAnonymousMap.toString() });
            paramAnonymousString.FRn = bs.aLy((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.clear"));
            paramAnonymousString.BZz = i;
            paramAnonymousString.dtG = bs.u((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
            paramAnonymousString.BZB = bs.aLy((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
            paramAnonymousString.BZA = bs.aLy((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
            paramAnonymousString.hVx = bs.aLz((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
            paramAnonymousString.BYF = bs.aLy((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
            paramAnonymousString.type = bs.aLy((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
            paramAnonymousString.text = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_text"));
            paramAnonymousString.drM = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon"));
            paramAnonymousString.FRm = bs.aLz((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
            paramAnonymousString.FRo = System.currentTimeMillis();
            paramAnonymousString.hTM = bs.aLy((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.seq"));
            paramAnonymousString.extInfo = bs.u((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.ext_info"), new Object[0]);
            if (paramAnonymousString.FRn == 1)
            {
              paramAnonymousMap = b.this;
              switch (paramAnonymousString.type)
              {
              case 5: 
              case 6: 
              case 9: 
              default: 
                switch (paramAnonymousString.type)
                {
                default: 
                  i = 1;
                }
                break;
              }
              for (;;)
              {
                ai.a(paramAnonymousString, 100, i, 0, 0L, "");
                AppMethodBeat.o(88417);
                return;
                b.ebW();
                break;
                paramAnonymousMap.a(paramAnonymousString.FRm, true, paramAnonymousString.hTM, false);
                paramAnonymousMap = new sg();
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMap);
                break;
                paramAnonymousMap.G(paramAnonymousString.FRm, false);
                paramAnonymousMap = new sg();
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMap);
                break;
                paramAnonymousMap.x("", "", 0L);
                break;
                i = 2;
                continue;
                i = 3;
                continue;
                i = 4;
              }
            }
          }
        }
        switch (paramAnonymousString.type)
        {
        case 5: 
        case 6: 
        default: 
          ai.a(paramAnonymousString, 109, 0, 0, 0L, "r12|" + paramAnonymousString.type);
        case 9: 
          do
          {
            AppMethodBeat.o(88417);
            return;
          } while (b.this.zYT == null);
          b.this.zYT.axG(paramAnonymousString.extInfo);
          ai.a(paramAnonymousString, 100, 4, 0, 0L, "");
          AppMethodBeat.o(88417);
          return;
        case 8: 
          ai.a(paramAnonymousString, 100, 3, 0, 0L, "");
          b.c(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 7: 
          ai.a(paramAnonymousString, 100, 2, b.this.zYS.size(), 0L, "");
          b.this.b(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 1: 
          b.f(paramAnonymousString);
        case 2: 
        case 3: 
        case 4: 
          ai.a(paramAnonymousString, 100, 1, 0, 0L, "");
          b.this.a(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 10: 
          ai.a(paramAnonymousString, 100, 5, 0, 0L, "");
          b.this.x(paramAnonymousString.dtG, paramAnonymousString.extInfo, paramAnonymousString.FRm);
          AppMethodBeat.o(88417);
          return;
        }
        ai.a(paramAnonymousString, 100, 11, 0, 0L, "");
        b.f(paramAnonymousString);
        AppMethodBeat.o(88417);
      }
    };
    this.hwV = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(88418);
        if (paramAnonymousn.equals(b.this.zYV))
        {
          com.tencent.mm.kernel.g.agi().b(b.this.zYV.getType(), this);
          b.this.zYV = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.b)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
            AppMethodBeat.o(88418);
          }
        }
        else
        {
          AppMethodBeat.o(88418);
          return;
        }
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRo, paramAnonymousString.ecD().FhN);
        com.tencent.mm.kernel.g.agR().agA().faa();
        paramAnonymousString = new sg();
        com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
        AppMethodBeat.o(88418);
      }
    };
    this.zYW = "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}";
    this.zYX = "";
    this.zYY = new c() {};
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.zYU);
    this.zYR = new dii();
    d(this.zYR);
    dii localdii = this.zYR;
    Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQD, "");
    if (!bs.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label182;
      }
    }
    try
    {
      if (localObject.length >= 13) {
        a(localdii, (String[])localObject);
      }
      for (;;)
      {
        ebY();
        com.tencent.mm.sdk.b.a.GpY.b(this.zYY);
        AppMethodBeat.o(88420);
        return;
        label182:
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQD, "");
        com.tencent.mm.kernel.g.agR().agA().faa();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQD, "");
        com.tencent.mm.kernel.g.agR().agA().faa();
      }
    }
  }
  
  private static void a(dii paramdii, String[] paramArrayOfString)
  {
    AppMethodBeat.i(88435);
    paramdii.dtG = paramArrayOfString[0];
    paramdii.FRn = Integer.valueOf(paramArrayOfString[1]).intValue();
    paramdii.BZA = Integer.valueOf(paramArrayOfString[2]).intValue();
    paramdii.BZB = Integer.valueOf(paramArrayOfString[3]).intValue();
    paramdii.BZz = Integer.valueOf(paramArrayOfString[4]).intValue();
    paramdii.hVx = Long.valueOf(paramArrayOfString[5]).longValue();
    paramdii.BYF = Integer.valueOf(paramArrayOfString[6]).intValue();
    paramdii.FRo = Long.valueOf(paramArrayOfString[7]).longValue();
    paramdii.text = paramArrayOfString[8];
    paramdii.type = Integer.valueOf(paramArrayOfString[9]).intValue();
    paramdii.exP = Integer.valueOf(paramArrayOfString[10]).intValue();
    paramdii.FRm = Long.valueOf(paramArrayOfString[11]).longValue();
    paramdii.drM = paramArrayOfString[12];
    if (paramArrayOfString.length > 13) {
      paramdii.hTM = Integer.valueOf(paramArrayOfString[13]).intValue();
    }
    while (paramArrayOfString.length > 14)
    {
      paramdii.extInfo = paramArrayOfString[14];
      AppMethodBeat.o(88435);
      return;
      paramdii.hTM = 0;
      if (paramdii.type == 7) {
        ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
      }
    }
    paramdii.extInfo = "";
    AppMethodBeat.o(88435);
  }
  
  public static void c(dii paramdii)
  {
    AppMethodBeat.i(88431);
    ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", new Object[] { paramdii.dtG });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRR, e(paramdii));
    com.tencent.mm.kernel.g.agR().agA().faa();
    ai.a(paramdii, 101, 3, 0, 0L, "");
    AppMethodBeat.o(88431);
  }
  
  static void d(dii paramdii)
  {
    paramdii.drM = "";
    paramdii.dtG = "";
    paramdii.text = "";
  }
  
  private void dbo()
  {
    AppMethodBeat.i(88423);
    this.zYR = new dii();
    d(this.zYR);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQD, "");
    com.tencent.mm.kernel.g.agR().agA().faa();
    if (this.zYT != null)
    {
      e.a locala = this.zYT;
      ecf();
      locala.ecq();
    }
    AppMethodBeat.o(88423);
  }
  
  public static String e(dii paramdii)
  {
    AppMethodBeat.i(88434);
    paramdii = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramdii.dtG, Integer.valueOf(paramdii.FRn), Integer.valueOf(paramdii.BZA), Integer.valueOf(paramdii.BZB), Integer.valueOf(paramdii.BZz), Long.valueOf(paramdii.hVx), Integer.valueOf(paramdii.BYF), Long.valueOf(paramdii.FRo), paramdii.text, Integer.valueOf(paramdii.type), Integer.valueOf(paramdii.exP), Long.valueOf(paramdii.FRm), paramdii.drM, Integer.valueOf(paramdii.hTM), paramdii.extInfo });
    AppMethodBeat.o(88434);
    return paramdii;
  }
  
  private void ebV()
  {
    AppMethodBeat.i(88430);
    synchronized (this.zYS)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.zYS.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(e((dii)localIterator.next())).append(";");
      }
    }
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRQ, localObject.toString());
    com.tencent.mm.kernel.g.agR().agA().faa();
    AppMethodBeat.o(88430);
  }
  
  public static void ebW()
  {
    AppMethodBeat.i(88432);
    ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRR, "");
    com.tencent.mm.kernel.g.agR().agA().faa();
    AppMethodBeat.o(88432);
  }
  
  private void ebY()
  {
    AppMethodBeat.i(88436);
    Object localObject1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRQ, "");
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(";");
      try
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!bs.isNullOrNil((String)localObject2))
          {
            localObject2 = ((String)localObject2).split(",");
            dii localdii = new dii();
            a(localdii, (String[])localObject2);
            this.zYS.addLast(localdii);
          }
          i += 1;
        }
        AppMethodBeat.o(88436);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRQ, "");
        com.tencent.mm.kernel.g.agR().agA().faa();
      }
    }
    AppMethodBeat.o(88436);
  }
  
  private int ecb()
  {
    AppMethodBeat.i(88438);
    if (!ecp())
    {
      ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88438);
      return 0;
    }
    ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(this.zYS.size()) });
    int i = this.zYS.size();
    AppMethodBeat.o(88438);
    return i;
  }
  
  public static long ecf()
  {
    AppMethodBeat.i(88445);
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQA, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88445);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(88445);
    return l;
  }
  
  private static int ecg()
  {
    AppMethodBeat.i(88446);
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQC, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88446);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(88446);
    return i;
  }
  
  public final void G(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(88426);
    if ((this.zYR == null) || (bs.isNullOrNil(this.zYR.dtG)))
    {
      AppMethodBeat.o(88426);
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if ((paramLong < ecf()) || (paramLong <= 0L) || (l + 3600L < paramLong))
    {
      ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", new Object[] { Long.valueOf(ecf()) });
      AppMethodBeat.o(88426);
      return;
    }
    if ((this.zYR != null) && (paramLong < this.zYR.FRm))
    {
      ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", new Object[] { Long.valueOf(this.zYR.FRm) });
      AppMethodBeat.o(88426);
      return;
    }
    if (paramBoolean) {
      ai.a(this.zYR, 106, 1, 0, paramLong, "");
    }
    dbo();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQA, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.agR().agA().faa();
    AppMethodBeat.o(88426);
  }
  
  public final void Rh(int paramInt)
  {
    AppMethodBeat.i(88424);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88424);
      return;
      ebW();
      AppMethodBeat.o(88424);
      return;
      synchronized (this.zYS)
      {
        this.zYS.clear();
        ebV();
        if (this.zYT != null) {
          this.zYT.a(0, "", "", 0, 0, "", true);
        }
        ??? = new sg();
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)???);
        AppMethodBeat.o(88424);
        return;
      }
      dbo();
      ??? = new sg();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(88424);
      return;
      x("", "", 0L);
    }
  }
  
  public final void Ri(int paramInt)
  {
    AppMethodBeat.i(88444);
    dii localdii = ecc();
    if (localdii != null) {
      ai.a(localdii.dtG, localdii.FRm, 2, paramInt, "", localdii.hTM);
    }
    AppMethodBeat.o(88444);
  }
  
  public final void a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(88441);
    if (this.zYS.size() == 0)
    {
      AppMethodBeat.o(88441);
      return;
    }
    if (paramInt <= ecg())
    {
      ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ecg()) });
      AppMethodBeat.o(88441);
      return;
    }
    int i = this.zYS.size();
    Object localObject2 = this.zYS;
    String str = "";
    for (;;)
    {
      try
      {
        if ((this.zYS.size() > 0) && (((dii)this.zYS.getFirst()).hTM <= paramInt))
        {
          str = ((dii)this.zYS.getFirst()).dtG;
          this.zYS.removeFirst();
          continue;
        }
        if (i != this.zYS.size()) {
          ebV();
        }
        if (this.zYT != null)
        {
          if (this.zYS.size() > 0) {
            this.zYT.a(this.zYS.size(), ((dii)this.zYS.getFirst()).dtG, ((dii)this.zYS.getLast()).dtG, ((dii)this.zYS.getFirst()).hTM, ((dii)this.zYS.getLast()).hTM, ((dii)this.zYS.getLast()).extInfo, paramBoolean1);
          }
        }
        else
        {
          if (paramBoolean2)
          {
            localObject2 = new dii();
            ((dii)localObject2).dtG = str;
            ((dii)localObject2).FRm = paramLong;
            ((dii)localObject2).hTM = paramInt;
            ai.a((dii)localObject2, 106, 2, i, paramLong, "");
          }
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQB, Long.valueOf(paramLong));
          com.tencent.mm.kernel.g.agR().agA().faa();
          ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", new Object[] { Integer.valueOf(paramInt) });
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQC, Integer.valueOf(paramInt));
          com.tencent.mm.kernel.g.agR().agA().faa();
          AppMethodBeat.o(88441);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(88441);
      }
      this.zYT.a(0, "", "", 0, 0, "", paramBoolean1);
    }
  }
  
  public final void a(e.a parama)
  {
    this.zYT = parama;
  }
  
  public final void a(dii paramdii)
  {
    AppMethodBeat.i(88428);
    if (!eco()) {
      ai.a(paramdii, 108, 1, 0, 0L, "");
    }
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = paramdii.FRm;
    if (this.zYR == null) {}
    for (String str = "null";; str = this.zYR.FRm)
    {
      ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot showTime new:%s, cur:%s, curTime:%s", new Object[] { Long.valueOf(l2), str, Long.valueOf(l1) });
      if (paramdii.FRm > ecf()) {
        break;
      }
      ai.a(paramdii, 103, 1, 0, 0L, "");
      ai.a(paramdii, 109, 1, 0, 0L, "r6|" + paramdii.FRm + "|" + ecf());
      AppMethodBeat.o(88428);
      return;
    }
    if (paramdii.FRm > 3600L + l1)
    {
      ai.a(paramdii, 109, 1, 0, 0L, "r10|" + paramdii.FRm + "|" + l1);
      AppMethodBeat.o(88428);
      return;
    }
    if ((this.zYR != null) && (!bs.isNullOrNil(this.zYR.dtG)) && (this.zYR.FRm > paramdii.FRm))
    {
      ai.a(paramdii, 105, 1, 0, 0L, this.zYR.dtG);
      ai.a(paramdii, 109, 1, 0, 0L, "r9|" + paramdii.FRm + "|" + ecf());
      AppMethodBeat.o(88428);
      return;
    }
    if ((this.zYR != null) && (!bs.isNullOrNil(this.zYR.dtG))) {
      ai.a(paramdii, 105, 1, 0, 0L, paramdii.dtG);
    }
    ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot valid");
    this.zYR = paramdii;
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQD, e(this.zYR));
    com.tencent.mm.kernel.g.agR().agA().faa();
    if (eco()) {
      ai.a(this.zYR, 101, 1, 0, 0L, "");
    }
    if (this.zYT != null) {
      this.zYT.bn(this.zYR.dtG, this.zYR.FRm);
    }
    paramdii = new sg();
    com.tencent.mm.sdk.b.a.GpY.l(paramdii);
    AppMethodBeat.o(88428);
  }
  
  public final void b(e.a parama)
  {
    if (this.zYT == parama) {
      this.zYT = null;
    }
  }
  
  public final void b(dii paramdii)
  {
    AppMethodBeat.i(88429);
    ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", new Object[] { Integer.valueOf(paramdii.hTM) });
    if (!eco()) {
      ai.a(paramdii, 108, 2, this.zYS.size(), 0L, "");
    }
    if (paramdii.hTM <= ecg())
    {
      ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", new Object[] { Integer.valueOf(paramdii.hTM), Integer.valueOf(ecg()) });
      ai.a(paramdii, 103, 2, ecb(), 0L, "");
      ai.a(paramdii, 109, 2, ecb(), 0L, "r6|" + paramdii.hTM + "|" + ecg());
      AppMethodBeat.o(88429);
      return;
    }
    label465:
    for (;;)
    {
      synchronized (this.zYS)
      {
        if (!bs.gY(this.zYS))
        {
          i = 0;
          if (i >= this.zYS.size()) {
            break label465;
          }
          dii localdii = (dii)this.zYS.get(i);
          if (localdii.dtG.equals(paramdii.dtG))
          {
            ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
            ai.a(paramdii, 109, 2, ecb(), 0L, "r11");
            AppMethodBeat.o(88429);
            return;
          }
          if (localdii.hTM > paramdii.hTM) {
            break label465;
          }
          i += 1;
          continue;
          this.zYS.add(i, paramdii);
          if (eco()) {
            ai.a(ecc(), 101, 2, this.zYS.size(), 0L, "");
          }
          ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", new Object[] { paramdii.dtG, Long.valueOf(paramdii.FRm) });
          ebV();
          if (this.zYT != null) {
            this.zYT.a(this.zYS.size(), ((dii)this.zYS.getFirst()).dtG, ((dii)this.zYS.getLast()).dtG, ((dii)this.zYS.getFirst()).hTM, ((dii)this.zYS.getLast()).hTM, ((dii)this.zYS.getLast()).extInfo);
          }
          paramdii = new sg();
          com.tencent.mm.sdk.b.a.GpY.l(paramdii);
          AppMethodBeat.o(88429);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final boolean ebR()
  {
    AppMethodBeat.i(88421);
    if (!ecp())
    {
      AppMethodBeat.o(88421);
      return false;
    }
    int i;
    if (bs.isNullOrNil(this.zYR.dtG)) {
      i = -5;
    }
    while (i == 0)
    {
      if (!eco()) {
        break label369;
      }
      AppMethodBeat.o(88421);
      return true;
      if (this.zYR.FRn == 1)
      {
        i = -1;
      }
      else if (this.zYR.BZA > d.DIc)
      {
        ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.zYR.dtG, Integer.valueOf(this.zYR.BZA), Integer.valueOf(d.DIc) });
        i = -2;
      }
      else
      {
        if (this.zYR.hVx != 0L)
        {
          long l1 = this.zYR.FRo;
          long l2 = this.zYR.hVx;
          if (System.currentTimeMillis() > l1 + l2 * 1000L)
          {
            ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { this.zYR.dtG });
            i = -3;
            continue;
          }
        }
        boolean bool;
        if (z.Ul(1) >= this.zYR.BYF)
        {
          bool = true;
          label224:
          ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.zYR.BYF), Integer.valueOf(z.Ul(1)), Long.valueOf(this.zYR.FRm), Long.valueOf(ecf()) });
          if ((z.Ul(1) < this.zYR.BYF) || (this.zYR.FRm <= ecf())) {
            break label335;
          }
        }
        label335:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label340;
          }
          i = -4;
          break;
          bool = false;
          break label224;
        }
        label340:
        i = 0;
      }
    }
    if (i == -3)
    {
      ai.a(this.zYR, 104, 1, 0, 0L, "");
      dbo();
    }
    label369:
    AppMethodBeat.o(88421);
    return false;
  }
  
  public final boolean ebS()
  {
    AppMethodBeat.i(88422);
    if (!ecp())
    {
      AppMethodBeat.o(88422);
      return false;
    }
    if ((dii)this.zYS.getLast() == null)
    {
      AppMethodBeat.o(88422);
      return false;
    }
    AppMethodBeat.o(88422);
    return true;
  }
  
  public final dii ebT()
  {
    return this.zYR;
  }
  
  public final void ebU()
  {
    AppMethodBeat.i(88425);
    if (this.zYR != null) {
      ai.a(this.zYR.dtG, this.zYR.FRm, 1, 0, "", 0);
    }
    AppMethodBeat.o(88425);
  }
  
  public final dii ebX()
  {
    AppMethodBeat.i(88433);
    dii localdii = new dii();
    d(localdii);
    Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRR, "");
    if (!bs.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label74;
      }
    }
    try
    {
      if (localObject.length >= 13) {
        a(localdii, (String[])localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(88433);
        return localdii;
        label74:
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRR, "");
        com.tencent.mm.kernel.g.agR().agA().faa();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRR, "");
        com.tencent.mm.kernel.g.agR().agA().faa();
      }
    }
  }
  
  public final boolean ebZ()
  {
    if (this.zYR != null) {
      return this.zYR.BZB == 1;
    }
    return false;
  }
  
  public final int eca()
  {
    AppMethodBeat.i(88437);
    if (!ecp())
    {
      ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88437);
      return 0;
    }
    ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(this.zYS.size()) });
    int i = this.zYS.size();
    AppMethodBeat.o(88437);
    return i;
  }
  
  public final dii ecc()
  {
    AppMethodBeat.i(88439);
    synchronized (this.zYS)
    {
      if (bs.gY(this.zYS))
      {
        AppMethodBeat.o(88439);
        return null;
      }
      dii localdii = (dii)this.zYS.getLast();
      AppMethodBeat.o(88439);
      return localdii;
    }
  }
  
  public final dii ecd()
  {
    AppMethodBeat.i(88440);
    synchronized (this.zYS)
    {
      if (bs.gY(this.zYS))
      {
        AppMethodBeat.o(88440);
        return null;
      }
      dii localdii = (dii)this.zYS.getFirst();
      AppMethodBeat.o(88440);
      return localdii;
    }
  }
  
  public final boolean ece()
  {
    AppMethodBeat.i(88443);
    if (!bs.gY(this.zYS))
    {
      if (((dii)this.zYS.getLast()).BZB == 1)
      {
        AppMethodBeat.o(88443);
        return true;
      }
      AppMethodBeat.o(88443);
      return false;
    }
    AppMethodBeat.o(88443);
    return false;
  }
  
  public final boolean ech()
  {
    AppMethodBeat.i(88447);
    dii localdii = ebX();
    if (!bs.isNullOrNil(localdii.dtG))
    {
      long l1 = localdii.FRo;
      long l2 = localdii.hVx;
      if (System.currentTimeMillis() > l1 + l2 * 1000L)
      {
        ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { localdii.dtG });
        ebW();
        AppMethodBeat.o(88447);
        return false;
      }
      AppMethodBeat.o(88447);
      return true;
    }
    AppMethodBeat.o(88447);
    return false;
  }
  
  public final String eci()
  {
    AppMethodBeat.i(88448);
    String str = ebX().dtG;
    AppMethodBeat.o(88448);
    return str;
  }
  
  public final void ecj()
  {
    AppMethodBeat.i(88449);
    dii localdii = new dii();
    localdii.dtG = ebX().dtG;
    ai.a(localdii, 106, 3, 0, 0L, "");
    ebW();
    AppMethodBeat.o(88449);
  }
  
  public final String eck()
  {
    AppMethodBeat.i(88451);
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRS, "");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(88451);
      return "";
    }
    try
    {
      str = new JSONObject(str).optString("msgId", "");
      AppMethodBeat.o(88451);
      return str;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(88451);
    }
    return "";
  }
  
  public final long ecl()
  {
    AppMethodBeat.i(88452);
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRS, "");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(88452);
      return 0L;
    }
    try
    {
      int i = new JSONObject(str).optInt("ts", 0);
      long l = i;
      AppMethodBeat.o(88452);
      return l;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(88452);
    }
    return 0L;
  }
  
  public final String ecm()
  {
    AppMethodBeat.i(88453);
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRS, "");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(88453);
      return "";
    }
    try
    {
      str = new JSONObject(str).optString("extInfo");
      AppMethodBeat.o(88453);
      return str;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(88453);
    }
    return "";
  }
  
  public final void ecn()
  {
    AppMethodBeat.i(88454);
    x("", "", 0L);
    AppMethodBeat.o(88454);
  }
  
  public final boolean eco()
  {
    AppMethodBeat.i(88455);
    JSONObject localJSONObject = ab.aAv("discoverRecommendEntry");
    boolean bool;
    if (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).aEs("labs_browse"))
    {
      if (!((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).HA("labs_browse")) {
        break label98;
      }
      bool = true;
    }
    for (;;)
    {
      ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recommend show %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(88455);
      return bool;
      if (localJSONObject.optInt("entrySwitch") == 1) {
        bool = true;
      } else {
        label98:
        bool = false;
      }
    }
  }
  
  public final boolean ecp()
  {
    AppMethodBeat.i(88456);
    if (((d.DIc >= 654311424) || (d.DIg)) && (bs.isNullOrNil(this.zYX))) {
      this.zYX = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOM, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.zYX).getJSONArray("tabs");
      int i = 0;
      while (i < localJSONArray.length())
      {
        int j = localJSONArray.getJSONObject(i).getInt("category");
        if (j == 110)
        {
          AppMethodBeat.o(88456);
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.TopStory.TopStoryRedDotImpl", "parse tabconfig failed: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(88456);
    }
  }
  
  public final void h(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(88442);
    a(paramLong, paramBoolean, paramInt, true);
    AppMethodBeat.o(88442);
  }
  
  public final void x(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(88450);
    ac.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgId", paramString1);
      localJSONObject.put("extInfo", paramString2);
      localJSONObject.put("ts", paramLong);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRS, localJSONObject.toString());
      com.tencent.mm.kernel.g.agR().agA().faa();
      if ((!bs.isNullOrNil(paramString1)) && (this.zYT != null)) {
        this.zYT.bo(paramString1, paramLong);
      }
      AppMethodBeat.o(88450);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", paramString2, "setUserIconRedDot error", new Object[0]);
      }
    }
  }
  
  public final void yE(long paramLong)
  {
    AppMethodBeat.i(88427);
    G(paramLong, true);
    AppMethodBeat.o(88427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b
 * JD-Core Version:    0.7.0.1
 */