package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.st;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.topstory.a.e
{
  public dnx BqD;
  LinkedList<dnx> BqE;
  com.tencent.mm.plugin.topstory.a.e.a BqF;
  com.tencent.mm.plugin.messenger.foundation.a.q BqG;
  com.tencent.mm.plugin.topstory.a.c.b BqH;
  final String BqI;
  String BqJ;
  c<fl> BqK;
  private f hPn;
  
  public b()
  {
    AppMethodBeat.i(88420);
    this.BqE = new LinkedList();
    this.BqG = new com.tencent.mm.plugin.messenger.foundation.a.q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, com.tencent.mm.al.e.a paramAnonymousa)
      {
        AppMethodBeat.i(88417);
        if ((paramAnonymousMap != null) && (paramAnonymousString != null) && (paramAnonymousString.equals("mmsearch_reddot_new")))
        {
          int i = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.entry"));
          if (i == 2)
          {
            paramAnonymousString = new dnx();
            b.d(paramAnonymousString);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramAnonymousMap.toString() });
            paramAnonymousString.HBT = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.clear"));
            paramAnonymousString.DCv = i;
            paramAnonymousString.msgId = bt.x((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
            paramAnonymousString.DCx = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
            paramAnonymousString.DCw = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
            paramAnonymousString.ioS = bt.aRf((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
            paramAnonymousString.DBB = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
            paramAnonymousString.type = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
            paramAnonymousString.text = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_text"));
            paramAnonymousString.dDH = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon"));
            paramAnonymousString.HBS = bt.aRf((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
            paramAnonymousString.HBU = System.currentTimeMillis();
            paramAnonymousString.inh = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.seq"));
            paramAnonymousString.extInfo = bt.x((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.ext_info"), new Object[0]);
            if (paramAnonymousString.HBT == 1)
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
                am.a(paramAnonymousString, 100, i, 0, 0L, "");
                AppMethodBeat.o(88417);
                return;
                b.eon();
                break;
                paramAnonymousMap.a(paramAnonymousString.HBS, true, paramAnonymousString.inh, false);
                paramAnonymousMap = new st();
                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMap);
                break;
                paramAnonymousMap.G(paramAnonymousString.HBS, false);
                paramAnonymousMap = new st();
                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMap);
                break;
                paramAnonymousMap.l("", "", 0L);
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
          am.a(paramAnonymousString, 109, 0, 0, 0L, "r12|" + paramAnonymousString.type);
        case 9: 
          do
          {
            AppMethodBeat.o(88417);
            return;
          } while (b.this.BqF == null);
          b.this.BqF.aCL(paramAnonymousString.extInfo);
          am.a(paramAnonymousString, 100, 4, 0, 0L, "");
          AppMethodBeat.o(88417);
          return;
        case 8: 
          am.a(paramAnonymousString, 100, 3, 0, 0L, "");
          b.c(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 7: 
          am.a(paramAnonymousString, 100, 2, b.this.BqE.size(), 0L, "");
          b.this.b(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 1: 
          b.f(paramAnonymousString);
        case 2: 
        case 3: 
        case 4: 
          am.a(paramAnonymousString, 100, 1, 0, 0L, "");
          b.this.a(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 10: 
          am.a(paramAnonymousString, 100, 5, 0, 0L, "");
          b.this.l(paramAnonymousString.msgId, paramAnonymousString.extInfo, paramAnonymousString.HBS);
          AppMethodBeat.o(88417);
          return;
        }
        am.a(paramAnonymousString, 100, 11, 0, 0L, "");
        b.f(paramAnonymousString);
        AppMethodBeat.o(88417);
      }
    };
    this.hPn = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(88418);
        if (paramAnonymousn.equals(b.this.BqH))
        {
          g.aiU().b(b.this.BqH.getType(), this);
          b.this.BqH = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.b)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
            AppMethodBeat.o(88418);
          }
        }
        else
        {
          AppMethodBeat.o(88418);
          return;
        }
        g.ajC().ajl().set(al.a.IDS, paramAnonymousString.eoU().GDb);
        g.ajC().ajl().fqc();
        paramAnonymousString = new st();
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
        AppMethodBeat.o(88418);
      }
    };
    this.BqI = "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}";
    this.BqJ = "";
    this.BqK = new c() {};
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.BqG);
    this.BqD = new dnx();
    d(this.BqD);
    dnx localdnx = this.BqD;
    Object localObject = (String)g.ajC().ajl().get(al.a.IDa, "");
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label182;
      }
    }
    try
    {
      if (localObject.length >= 13) {
        a(localdnx, (String[])localObject);
      }
      for (;;)
      {
        eop();
        com.tencent.mm.sdk.b.a.IbL.b(this.BqK);
        AppMethodBeat.o(88420);
        return;
        label182:
        g.ajC().ajl().set(al.a.IDa, "");
        g.ajC().ajl().fqc();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.ajC().ajl().set(al.a.IDa, "");
        g.ajC().ajl().fqc();
      }
    }
  }
  
  private static void a(dnx paramdnx, String[] paramArrayOfString)
  {
    AppMethodBeat.i(88435);
    paramdnx.msgId = paramArrayOfString[0];
    paramdnx.HBT = Integer.valueOf(paramArrayOfString[1]).intValue();
    paramdnx.DCw = Integer.valueOf(paramArrayOfString[2]).intValue();
    paramdnx.DCx = Integer.valueOf(paramArrayOfString[3]).intValue();
    paramdnx.DCv = Integer.valueOf(paramArrayOfString[4]).intValue();
    paramdnx.ioS = Long.valueOf(paramArrayOfString[5]).longValue();
    paramdnx.DBB = Integer.valueOf(paramArrayOfString[6]).intValue();
    paramdnx.HBU = Long.valueOf(paramArrayOfString[7]).longValue();
    paramdnx.text = paramArrayOfString[8];
    paramdnx.type = Integer.valueOf(paramArrayOfString[9]).intValue();
    paramdnx.ePo = Integer.valueOf(paramArrayOfString[10]).intValue();
    paramdnx.HBS = Long.valueOf(paramArrayOfString[11]).longValue();
    paramdnx.dDH = paramArrayOfString[12];
    if (paramArrayOfString.length > 13) {
      paramdnx.inh = Integer.valueOf(paramArrayOfString[13]).intValue();
    }
    while (paramArrayOfString.length > 14)
    {
      paramdnx.extInfo = paramArrayOfString[14];
      AppMethodBeat.o(88435);
      return;
      paramdnx.inh = 0;
      if (paramdnx.type == 7) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
      }
    }
    paramdnx.extInfo = "";
    AppMethodBeat.o(88435);
  }
  
  public static void c(dnx paramdnx)
  {
    AppMethodBeat.i(88431);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", new Object[] { paramdnx.msgId });
    g.ajC().ajl().set(al.a.IEv, e(paramdnx));
    g.ajC().ajl().fqc();
    am.a(paramdnx, 101, 3, 0, 0L, "");
    AppMethodBeat.o(88431);
  }
  
  static void d(dnx paramdnx)
  {
    paramdnx.dDH = "";
    paramdnx.msgId = "";
    paramdnx.text = "";
  }
  
  private void dkI()
  {
    AppMethodBeat.i(88423);
    this.BqD = new dnx();
    d(this.BqD);
    g.ajC().ajl().set(al.a.IDa, "");
    g.ajC().ajl().fqc();
    if (this.BqF != null)
    {
      com.tencent.mm.plugin.topstory.a.e.a locala = this.BqF;
      eow();
      locala.eoH();
    }
    AppMethodBeat.o(88423);
  }
  
  public static String e(dnx paramdnx)
  {
    AppMethodBeat.i(88434);
    paramdnx = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramdnx.msgId, Integer.valueOf(paramdnx.HBT), Integer.valueOf(paramdnx.DCw), Integer.valueOf(paramdnx.DCx), Integer.valueOf(paramdnx.DCv), Long.valueOf(paramdnx.ioS), Integer.valueOf(paramdnx.DBB), Long.valueOf(paramdnx.HBU), paramdnx.text, Integer.valueOf(paramdnx.type), Integer.valueOf(paramdnx.ePo), Long.valueOf(paramdnx.HBS), paramdnx.dDH, Integer.valueOf(paramdnx.inh), paramdnx.extInfo });
    AppMethodBeat.o(88434);
    return paramdnx;
  }
  
  private void eom()
  {
    AppMethodBeat.i(88430);
    synchronized (this.BqE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.BqE.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(e((dnx)localIterator.next())).append(";");
      }
    }
    g.ajC().ajl().set(al.a.IEu, localObject.toString());
    g.ajC().ajl().fqc();
    AppMethodBeat.o(88430);
  }
  
  public static void eon()
  {
    AppMethodBeat.i(88432);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
    g.ajC().ajl().set(al.a.IEv, "");
    g.ajC().ajl().fqc();
    AppMethodBeat.o(88432);
  }
  
  private void eop()
  {
    AppMethodBeat.i(88436);
    Object localObject1 = (String)g.ajC().ajl().get(al.a.IEu, "");
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(";");
      try
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!bt.isNullOrNil((String)localObject2))
          {
            localObject2 = ((String)localObject2).split(",");
            dnx localdnx = new dnx();
            a(localdnx, (String[])localObject2);
            this.BqE.addLast(localdnx);
          }
          i += 1;
        }
        AppMethodBeat.o(88436);
        return;
      }
      catch (Exception localException)
      {
        g.ajC().ajl().set(al.a.IEu, "");
        g.ajC().ajl().fqc();
      }
    }
    AppMethodBeat.o(88436);
  }
  
  private int eos()
  {
    AppMethodBeat.i(88438);
    if (!eoG())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88438);
      return 0;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(this.BqE.size()) });
    int i = this.BqE.size();
    AppMethodBeat.o(88438);
    return i;
  }
  
  public static long eow()
  {
    AppMethodBeat.i(88445);
    Object localObject = g.ajC().ajl().get(al.a.ICX, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88445);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(88445);
    return l;
  }
  
  private static int eox()
  {
    AppMethodBeat.i(88446);
    Object localObject = g.ajC().ajl().get(al.a.ICZ, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88446);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(88446);
    return i;
  }
  
  public final void Bc(long paramLong)
  {
    AppMethodBeat.i(88427);
    G(paramLong, true);
    AppMethodBeat.o(88427);
  }
  
  public final void G(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(88426);
    if ((this.BqD == null) || (bt.isNullOrNil(this.BqD.msgId)))
    {
      AppMethodBeat.o(88426);
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if ((paramLong < eow()) || (paramLong <= 0L) || (l + 3600L < paramLong))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", new Object[] { Long.valueOf(eow()) });
      AppMethodBeat.o(88426);
      return;
    }
    if ((this.BqD != null) && (paramLong < this.BqD.HBS))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", new Object[] { Long.valueOf(this.BqD.HBS) });
      AppMethodBeat.o(88426);
      return;
    }
    if (paramBoolean) {
      am.a(this.BqD, 106, 1, 0, paramLong, "");
    }
    dkI();
    g.ajC().ajl().set(al.a.ICX, Long.valueOf(paramLong));
    g.ajC().ajl().fqc();
    AppMethodBeat.o(88426);
  }
  
  public final void SR(int paramInt)
  {
    AppMethodBeat.i(88424);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88424);
      return;
      eon();
      AppMethodBeat.o(88424);
      return;
      synchronized (this.BqE)
      {
        this.BqE.clear();
        eom();
        if (this.BqF != null) {
          this.BqF.a(0, "", "", 0, 0, "", true);
        }
        ??? = new st();
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)???);
        AppMethodBeat.o(88424);
        return;
      }
      dkI();
      ??? = new st();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(88424);
      return;
      l("", "", 0L);
    }
  }
  
  public final void SS(int paramInt)
  {
    AppMethodBeat.i(88444);
    dnx localdnx = eot();
    if (localdnx != null) {
      am.a(localdnx.msgId, localdnx.HBS, 2, paramInt, "", localdnx.inh);
    }
    AppMethodBeat.o(88444);
  }
  
  public final void a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(88441);
    if (this.BqE.size() == 0)
    {
      AppMethodBeat.o(88441);
      return;
    }
    if (paramInt <= eox())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(eox()) });
      AppMethodBeat.o(88441);
      return;
    }
    int i = this.BqE.size();
    Object localObject2 = this.BqE;
    String str = "";
    for (;;)
    {
      try
      {
        if ((this.BqE.size() > 0) && (((dnx)this.BqE.getFirst()).inh <= paramInt))
        {
          str = ((dnx)this.BqE.getFirst()).msgId;
          this.BqE.removeFirst();
          continue;
        }
        if (i != this.BqE.size()) {
          eom();
        }
        if (this.BqF != null)
        {
          if (this.BqE.size() > 0) {
            this.BqF.a(this.BqE.size(), ((dnx)this.BqE.getFirst()).msgId, ((dnx)this.BqE.getLast()).msgId, ((dnx)this.BqE.getFirst()).inh, ((dnx)this.BqE.getLast()).inh, ((dnx)this.BqE.getLast()).extInfo, paramBoolean1);
          }
        }
        else
        {
          if (paramBoolean2)
          {
            localObject2 = new dnx();
            ((dnx)localObject2).msgId = str;
            ((dnx)localObject2).HBS = paramLong;
            ((dnx)localObject2).inh = paramInt;
            am.a((dnx)localObject2, 106, 2, i, paramLong, "");
          }
          g.ajC().ajl().set(al.a.ICY, Long.valueOf(paramLong));
          g.ajC().ajl().fqc();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", new Object[] { Integer.valueOf(paramInt) });
          g.ajC().ajl().set(al.a.ICZ, Integer.valueOf(paramInt));
          g.ajC().ajl().fqc();
          AppMethodBeat.o(88441);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(88441);
      }
      this.BqF.a(0, "", "", 0, 0, "", paramBoolean1);
    }
  }
  
  public final void a(com.tencent.mm.plugin.topstory.a.e.a parama)
  {
    this.BqF = parama;
  }
  
  public final void a(dnx paramdnx)
  {
    AppMethodBeat.i(88428);
    if (!eoF()) {
      am.a(paramdnx, 108, 1, 0, 0L, "");
    }
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = paramdnx.HBS;
    if (this.BqD == null) {}
    for (String str = "null";; str = this.BqD.HBS)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot showTime new:%s, cur:%s, curTime:%s", new Object[] { Long.valueOf(l2), str, Long.valueOf(l1) });
      if (paramdnx.HBS > eow()) {
        break;
      }
      am.a(paramdnx, 103, 1, 0, 0L, "");
      am.a(paramdnx, 109, 1, 0, 0L, "r6|" + paramdnx.HBS + "|" + eow());
      AppMethodBeat.o(88428);
      return;
    }
    if (paramdnx.HBS > 3600L + l1)
    {
      am.a(paramdnx, 109, 1, 0, 0L, "r10|" + paramdnx.HBS + "|" + l1);
      AppMethodBeat.o(88428);
      return;
    }
    if ((this.BqD != null) && (!bt.isNullOrNil(this.BqD.msgId)) && (this.BqD.HBS > paramdnx.HBS))
    {
      am.a(paramdnx, 105, 1, 0, 0L, this.BqD.msgId);
      am.a(paramdnx, 109, 1, 0, 0L, "r9|" + paramdnx.HBS + "|" + eow());
      AppMethodBeat.o(88428);
      return;
    }
    if ((this.BqD != null) && (!bt.isNullOrNil(this.BqD.msgId))) {
      am.a(paramdnx, 105, 1, 0, 0L, paramdnx.msgId);
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot valid");
    this.BqD = paramdnx;
    g.ajC().ajl().set(al.a.IDa, e(this.BqD));
    g.ajC().ajl().fqc();
    if (eoF()) {
      am.a(this.BqD, 101, 1, 0, 0L, "");
    }
    if (this.BqF != null) {
      this.BqF.bq(this.BqD.msgId, this.BqD.HBS);
    }
    paramdnx = new st();
    com.tencent.mm.sdk.b.a.IbL.l(paramdnx);
    AppMethodBeat.o(88428);
  }
  
  public final void b(com.tencent.mm.plugin.topstory.a.e.a parama)
  {
    if (this.BqF == parama) {
      this.BqF = null;
    }
  }
  
  public final void b(dnx paramdnx)
  {
    AppMethodBeat.i(88429);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", new Object[] { Integer.valueOf(paramdnx.inh) });
    if (!eoF()) {
      am.a(paramdnx, 108, 2, this.BqE.size(), 0L, "");
    }
    if (paramdnx.inh <= eox())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", new Object[] { Integer.valueOf(paramdnx.inh), Integer.valueOf(eox()) });
      am.a(paramdnx, 103, 2, eos(), 0L, "");
      am.a(paramdnx, 109, 2, eos(), 0L, "r6|" + paramdnx.inh + "|" + eox());
      AppMethodBeat.o(88429);
      return;
    }
    label465:
    for (;;)
    {
      synchronized (this.BqE)
      {
        if (!bt.hj(this.BqE))
        {
          i = 0;
          if (i >= this.BqE.size()) {
            break label465;
          }
          dnx localdnx = (dnx)this.BqE.get(i);
          if (localdnx.msgId.equals(paramdnx.msgId))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
            am.a(paramdnx, 109, 2, eos(), 0L, "r11");
            AppMethodBeat.o(88429);
            return;
          }
          if (localdnx.inh > paramdnx.inh) {
            break label465;
          }
          i += 1;
          continue;
          this.BqE.add(i, paramdnx);
          if (eoF()) {
            am.a(eot(), 101, 2, this.BqE.size(), 0L, "");
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", new Object[] { paramdnx.msgId, Long.valueOf(paramdnx.HBS) });
          eom();
          if (this.BqF != null) {
            this.BqF.a(this.BqE.size(), ((dnx)this.BqE.getFirst()).msgId, ((dnx)this.BqE.getLast()).msgId, ((dnx)this.BqE.getFirst()).inh, ((dnx)this.BqE.getLast()).inh, ((dnx)this.BqE.getLast()).extInfo);
          }
          paramdnx = new st();
          com.tencent.mm.sdk.b.a.IbL.l(paramdnx);
          AppMethodBeat.o(88429);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final void eoA()
  {
    AppMethodBeat.i(88449);
    dnx localdnx = new dnx();
    localdnx.msgId = eoo().msgId;
    am.a(localdnx, 106, 3, 0, 0L, "");
    eon();
    AppMethodBeat.o(88449);
  }
  
  public final String eoB()
  {
    AppMethodBeat.i(88451);
    String str = (String)g.ajC().ajl().get(al.a.IEw, "");
    if (bt.isNullOrNil(str))
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
  
  public final long eoC()
  {
    AppMethodBeat.i(88452);
    String str = (String)g.ajC().ajl().get(al.a.IEw, "");
    if (bt.isNullOrNil(str))
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
  
  public final String eoD()
  {
    AppMethodBeat.i(88453);
    String str = (String)g.ajC().ajl().get(al.a.IEw, "");
    if (bt.isNullOrNil(str))
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
  
  public final void eoE()
  {
    AppMethodBeat.i(88454);
    l("", "", 0L);
    AppMethodBeat.o(88454);
  }
  
  public final boolean eoF()
  {
    AppMethodBeat.i(88455);
    JSONObject localJSONObject = af.aFP("discoverRecommendEntry");
    boolean bool;
    if (((com.tencent.mm.plugin.welab.a.a.a)g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).aJS("labs_browse"))
    {
      if (!((com.tencent.mm.plugin.welab.a.a.a)g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).KN("labs_browse")) {
        break label98;
      }
      bool = true;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recommend show %b", new Object[] { Boolean.valueOf(bool) });
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
  
  public final boolean eoG()
  {
    AppMethodBeat.i(88456);
    if (((d.Fnj >= 654311424) || (d.Fnn)) && (bt.isNullOrNil(this.BqJ))) {
      this.BqJ = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsL, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.BqJ).getJSONArray("tabs");
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
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryRedDotImpl", "parse tabconfig failed: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(88456);
    }
  }
  
  public final boolean eoi()
  {
    AppMethodBeat.i(88421);
    if (!eoG())
    {
      AppMethodBeat.o(88421);
      return false;
    }
    int i;
    if (bt.isNullOrNil(this.BqD.msgId)) {
      i = -5;
    }
    while (i == 0)
    {
      if (!eoF()) {
        break label369;
      }
      AppMethodBeat.o(88421);
      return true;
      if (this.BqD.HBT == 1)
      {
        i = -1;
      }
      else if (this.BqD.DCw > d.Fnj)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.BqD.msgId, Integer.valueOf(this.BqD.DCw), Integer.valueOf(d.Fnj) });
        i = -2;
      }
      else
      {
        if (this.BqD.ioS != 0L)
        {
          long l1 = this.BqD.HBU;
          long l2 = this.BqD.ioS;
          if (System.currentTimeMillis() > l1 + l2 * 1000L)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { this.BqD.msgId });
            i = -3;
            continue;
          }
        }
        boolean bool;
        if (com.tencent.mm.plugin.websearch.api.ad.We(1) >= this.BqD.DBB)
        {
          bool = true;
          label224:
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BqD.DBB), Integer.valueOf(com.tencent.mm.plugin.websearch.api.ad.We(1)), Long.valueOf(this.BqD.HBS), Long.valueOf(eow()) });
          if ((com.tencent.mm.plugin.websearch.api.ad.We(1) < this.BqD.DBB) || (this.BqD.HBS <= eow())) {
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
      am.a(this.BqD, 104, 1, 0, 0L, "");
      dkI();
    }
    label369:
    AppMethodBeat.o(88421);
    return false;
  }
  
  public final boolean eoj()
  {
    AppMethodBeat.i(88422);
    if (!eoG())
    {
      AppMethodBeat.o(88422);
      return false;
    }
    if ((dnx)this.BqE.getLast() == null)
    {
      AppMethodBeat.o(88422);
      return false;
    }
    AppMethodBeat.o(88422);
    return true;
  }
  
  public final dnx eok()
  {
    return this.BqD;
  }
  
  public final void eol()
  {
    AppMethodBeat.i(88425);
    if (this.BqD != null) {
      am.a(this.BqD.msgId, this.BqD.HBS, 1, 0, "", 0);
    }
    AppMethodBeat.o(88425);
  }
  
  public final dnx eoo()
  {
    AppMethodBeat.i(88433);
    dnx localdnx = new dnx();
    d(localdnx);
    Object localObject = (String)g.ajC().ajl().get(al.a.IEv, "");
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label74;
      }
    }
    try
    {
      if (localObject.length >= 13) {
        a(localdnx, (String[])localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(88433);
        return localdnx;
        label74:
        g.ajC().ajl().set(al.a.IEv, "");
        g.ajC().ajl().fqc();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.ajC().ajl().set(al.a.IEv, "");
        g.ajC().ajl().fqc();
      }
    }
  }
  
  public final boolean eoq()
  {
    if (this.BqD != null) {
      return this.BqD.DCx == 1;
    }
    return false;
  }
  
  public final int eor()
  {
    AppMethodBeat.i(88437);
    if (!eoG())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88437);
      return 0;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(this.BqE.size()) });
    int i = this.BqE.size();
    AppMethodBeat.o(88437);
    return i;
  }
  
  public final dnx eot()
  {
    AppMethodBeat.i(88439);
    synchronized (this.BqE)
    {
      if (bt.hj(this.BqE))
      {
        AppMethodBeat.o(88439);
        return null;
      }
      dnx localdnx = (dnx)this.BqE.getLast();
      AppMethodBeat.o(88439);
      return localdnx;
    }
  }
  
  public final dnx eou()
  {
    AppMethodBeat.i(88440);
    synchronized (this.BqE)
    {
      if (bt.hj(this.BqE))
      {
        AppMethodBeat.o(88440);
        return null;
      }
      dnx localdnx = (dnx)this.BqE.getFirst();
      AppMethodBeat.o(88440);
      return localdnx;
    }
  }
  
  public final boolean eov()
  {
    AppMethodBeat.i(88443);
    if (!bt.hj(this.BqE))
    {
      if (((dnx)this.BqE.getLast()).DCx == 1)
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
  
  public final boolean eoy()
  {
    AppMethodBeat.i(88447);
    dnx localdnx = eoo();
    if (!bt.isNullOrNil(localdnx.msgId))
    {
      long l1 = localdnx.HBU;
      long l2 = localdnx.ioS;
      if (System.currentTimeMillis() > l1 + l2 * 1000L)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { localdnx.msgId });
        eon();
        AppMethodBeat.o(88447);
        return false;
      }
      AppMethodBeat.o(88447);
      return true;
    }
    AppMethodBeat.o(88447);
    return false;
  }
  
  public final String eoz()
  {
    AppMethodBeat.i(88448);
    String str = eoo().msgId;
    AppMethodBeat.o(88448);
    return str;
  }
  
  public final void h(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(88442);
    a(paramLong, paramBoolean, paramInt, true);
    AppMethodBeat.o(88442);
  }
  
  public final void l(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(88450);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgId", paramString1);
      localJSONObject.put("extInfo", paramString2);
      localJSONObject.put("ts", paramLong);
      g.ajC().ajl().set(al.a.IEw, localJSONObject.toString());
      g.ajC().ajl().fqc();
      if ((!bt.isNullOrNil(paramString1)) && (this.BqF != null)) {
        this.BqF.br(paramString1, paramLong);
      }
      AppMethodBeat.o(88450);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", paramString2, "setUserIconRedDot error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b
 * JD-Core Version:    0.7.0.1
 */