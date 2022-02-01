package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.su;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.topstory.a.e
{
  public dou BIc;
  LinkedList<dou> BId;
  com.tencent.mm.plugin.topstory.a.e.a BIe;
  com.tencent.mm.plugin.messenger.foundation.a.q BIf;
  com.tencent.mm.plugin.topstory.a.c.b BIg;
  final String BIh;
  String BIi;
  c<fm> BIj;
  private f ghB;
  
  public b()
  {
    AppMethodBeat.i(88420);
    this.BId = new LinkedList();
    this.BIf = new com.tencent.mm.plugin.messenger.foundation.a.q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, com.tencent.mm.ak.e.a paramAnonymousa)
      {
        AppMethodBeat.i(88417);
        if ((paramAnonymousMap != null) && (paramAnonymousString != null) && (paramAnonymousString.equals("mmsearch_reddot_new")))
        {
          int i = bu.aSB((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.entry"));
          if (i == 2)
          {
            paramAnonymousString = new dou();
            b.d(paramAnonymousString);
            ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramAnonymousMap.toString() });
            paramAnonymousString.HVG = bu.aSB((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.clear"));
            paramAnonymousString.DUs = i;
            paramAnonymousString.msgId = bu.x((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
            paramAnonymousString.DUu = bu.aSB((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
            paramAnonymousString.DUt = bu.aSB((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
            paramAnonymousString.irN = bu.aSC((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
            paramAnonymousString.DTy = bu.aSB((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
            paramAnonymousString.type = bu.aSB((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
            paramAnonymousString.text = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_text"));
            paramAnonymousString.dEM = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon"));
            paramAnonymousString.HVF = bu.aSC((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
            paramAnonymousString.HVH = System.currentTimeMillis();
            paramAnonymousString.iqb = bu.aSB((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.seq"));
            paramAnonymousString.extInfo = bu.x((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.ext_info"), new Object[0]);
            if (paramAnonymousString.HVG == 1)
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
                b.erU();
                break;
                paramAnonymousMap.a(paramAnonymousString.HVF, true, paramAnonymousString.iqb, false);
                paramAnonymousMap = new su();
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMap);
                break;
                paramAnonymousMap.I(paramAnonymousString.HVF, false);
                paramAnonymousMap = new su();
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMap);
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
          } while (b.this.BIe == null);
          b.this.BIe.aEe(paramAnonymousString.extInfo);
          am.a(paramAnonymousString, 100, 4, 0, 0L, "");
          AppMethodBeat.o(88417);
          return;
        case 8: 
          am.a(paramAnonymousString, 100, 3, 0, 0L, "");
          b.c(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 7: 
          am.a(paramAnonymousString, 100, 2, b.this.BId.size(), 0L, "");
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
          b.this.l(paramAnonymousString.msgId, paramAnonymousString.extInfo, paramAnonymousString.HVF);
          AppMethodBeat.o(88417);
          return;
        }
        am.a(paramAnonymousString, 100, 11, 0, 0L, "");
        b.f(paramAnonymousString);
        AppMethodBeat.o(88417);
      }
    };
    this.ghB = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(88418);
        if (paramAnonymousn.equals(b.this.BIg))
        {
          g.ajj().b(b.this.BIg.getType(), this);
          b.this.BIg = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.b)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
            AppMethodBeat.o(88418);
          }
        }
        else
        {
          AppMethodBeat.o(88418);
          return;
        }
        g.ajR().ajA().set(am.a.IYs, paramAnonymousString.esB().GWB);
        g.ajR().ajA().fuc();
        paramAnonymousString = new su();
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
        AppMethodBeat.o(88418);
      }
    };
    this.BIh = "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}";
    this.BIi = "";
    this.BIj = new b.3(this);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.BIf);
    this.BIc = new dou();
    d(this.BIc);
    dou localdou = this.BIc;
    Object localObject = (String)g.ajR().ajA().get(am.a.IXA, "");
    if (!bu.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label182;
      }
    }
    try
    {
      if (localObject.length >= 13) {
        a(localdou, (String[])localObject);
      }
      for (;;)
      {
        erW();
        com.tencent.mm.sdk.b.a.IvT.b(this.BIj);
        AppMethodBeat.o(88420);
        return;
        label182:
        g.ajR().ajA().set(am.a.IXA, "");
        g.ajR().ajA().fuc();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.ajR().ajA().set(am.a.IXA, "");
        g.ajR().ajA().fuc();
      }
    }
  }
  
  private static void a(dou paramdou, String[] paramArrayOfString)
  {
    AppMethodBeat.i(88435);
    paramdou.msgId = paramArrayOfString[0];
    paramdou.HVG = Integer.valueOf(paramArrayOfString[1]).intValue();
    paramdou.DUt = Integer.valueOf(paramArrayOfString[2]).intValue();
    paramdou.DUu = Integer.valueOf(paramArrayOfString[3]).intValue();
    paramdou.DUs = Integer.valueOf(paramArrayOfString[4]).intValue();
    paramdou.irN = Long.valueOf(paramArrayOfString[5]).longValue();
    paramdou.DTy = Integer.valueOf(paramArrayOfString[6]).intValue();
    paramdou.HVH = Long.valueOf(paramArrayOfString[7]).longValue();
    paramdou.text = paramArrayOfString[8];
    paramdou.type = Integer.valueOf(paramArrayOfString[9]).intValue();
    paramdou.eQZ = Integer.valueOf(paramArrayOfString[10]).intValue();
    paramdou.HVF = Long.valueOf(paramArrayOfString[11]).longValue();
    paramdou.dEM = paramArrayOfString[12];
    if (paramArrayOfString.length > 13) {
      paramdou.iqb = Integer.valueOf(paramArrayOfString[13]).intValue();
    }
    while (paramArrayOfString.length > 14)
    {
      paramdou.extInfo = paramArrayOfString[14];
      AppMethodBeat.o(88435);
      return;
      paramdou.iqb = 0;
      if (paramdou.type == 7) {
        ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
      }
    }
    paramdou.extInfo = "";
    AppMethodBeat.o(88435);
  }
  
  public static void c(dou paramdou)
  {
    AppMethodBeat.i(88431);
    ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", new Object[] { paramdou.msgId });
    g.ajR().ajA().set(am.a.IYV, e(paramdou));
    g.ajR().ajA().fuc();
    am.a(paramdou, 101, 3, 0, 0L, "");
    AppMethodBeat.o(88431);
  }
  
  static void d(dou paramdou)
  {
    paramdou.dEM = "";
    paramdou.msgId = "";
    paramdou.text = "";
  }
  
  private void dnI()
  {
    AppMethodBeat.i(88423);
    this.BIc = new dou();
    d(this.BIc);
    g.ajR().ajA().set(am.a.IXA, "");
    g.ajR().ajA().fuc();
    if (this.BIe != null)
    {
      com.tencent.mm.plugin.topstory.a.e.a locala = this.BIe;
      esd();
      locala.eso();
    }
    AppMethodBeat.o(88423);
  }
  
  public static String e(dou paramdou)
  {
    AppMethodBeat.i(88434);
    paramdou = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramdou.msgId, Integer.valueOf(paramdou.HVG), Integer.valueOf(paramdou.DUt), Integer.valueOf(paramdou.DUu), Integer.valueOf(paramdou.DUs), Long.valueOf(paramdou.irN), Integer.valueOf(paramdou.DTy), Long.valueOf(paramdou.HVH), paramdou.text, Integer.valueOf(paramdou.type), Integer.valueOf(paramdou.eQZ), Long.valueOf(paramdou.HVF), paramdou.dEM, Integer.valueOf(paramdou.iqb), paramdou.extInfo });
    AppMethodBeat.o(88434);
    return paramdou;
  }
  
  private void erT()
  {
    AppMethodBeat.i(88430);
    synchronized (this.BId)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.BId.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(e((dou)localIterator.next())).append(";");
      }
    }
    g.ajR().ajA().set(am.a.IYU, localObject.toString());
    g.ajR().ajA().fuc();
    AppMethodBeat.o(88430);
  }
  
  public static void erU()
  {
    AppMethodBeat.i(88432);
    ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
    g.ajR().ajA().set(am.a.IYV, "");
    g.ajR().ajA().fuc();
    AppMethodBeat.o(88432);
  }
  
  private void erW()
  {
    AppMethodBeat.i(88436);
    Object localObject1 = (String)g.ajR().ajA().get(am.a.IYU, "");
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(";");
      try
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!bu.isNullOrNil((String)localObject2))
          {
            localObject2 = ((String)localObject2).split(",");
            dou localdou = new dou();
            a(localdou, (String[])localObject2);
            this.BId.addLast(localdou);
          }
          i += 1;
        }
        AppMethodBeat.o(88436);
        return;
      }
      catch (Exception localException)
      {
        g.ajR().ajA().set(am.a.IYU, "");
        g.ajR().ajA().fuc();
      }
    }
    AppMethodBeat.o(88436);
  }
  
  private int erZ()
  {
    AppMethodBeat.i(88438);
    if (!esn())
    {
      ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88438);
      return 0;
    }
    ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(this.BId.size()) });
    int i = this.BId.size();
    AppMethodBeat.o(88438);
    return i;
  }
  
  public static long esd()
  {
    AppMethodBeat.i(88445);
    Object localObject = g.ajR().ajA().get(am.a.IXx, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88445);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(88445);
    return l;
  }
  
  private static int ese()
  {
    AppMethodBeat.i(88446);
    Object localObject = g.ajR().ajA().get(am.a.IXz, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88446);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(88446);
    return i;
  }
  
  public final void BA(long paramLong)
  {
    AppMethodBeat.i(88427);
    I(paramLong, true);
    AppMethodBeat.o(88427);
  }
  
  public final void I(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(88426);
    if ((this.BIc == null) || (bu.isNullOrNil(this.BIc.msgId)))
    {
      AppMethodBeat.o(88426);
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if ((paramLong < esd()) || (paramLong <= 0L) || (l + 3600L < paramLong))
    {
      ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", new Object[] { Long.valueOf(esd()) });
      AppMethodBeat.o(88426);
      return;
    }
    if ((this.BIc != null) && (paramLong < this.BIc.HVF))
    {
      ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", new Object[] { Long.valueOf(this.BIc.HVF) });
      AppMethodBeat.o(88426);
      return;
    }
    if (paramBoolean) {
      am.a(this.BIc, 106, 1, 0, paramLong, "");
    }
    dnI();
    g.ajR().ajA().set(am.a.IXx, Long.valueOf(paramLong));
    g.ajR().ajA().fuc();
    AppMethodBeat.o(88426);
  }
  
  public final void Ty(int paramInt)
  {
    AppMethodBeat.i(88424);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88424);
      return;
      erU();
      AppMethodBeat.o(88424);
      return;
      synchronized (this.BId)
      {
        this.BId.clear();
        erT();
        if (this.BIe != null) {
          this.BIe.a(0, "", "", 0, 0, "", true);
        }
        ??? = new su();
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)???);
        AppMethodBeat.o(88424);
        return;
      }
      dnI();
      ??? = new su();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(88424);
      return;
      l("", "", 0L);
    }
  }
  
  public final void Tz(int paramInt)
  {
    AppMethodBeat.i(88444);
    dou localdou = esa();
    if (localdou != null) {
      am.a(localdou.msgId, localdou.HVF, 2, paramInt, "", localdou.iqb);
    }
    AppMethodBeat.o(88444);
  }
  
  public final void a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(88441);
    if (this.BId.size() == 0)
    {
      AppMethodBeat.o(88441);
      return;
    }
    if (paramInt <= ese())
    {
      ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ese()) });
      AppMethodBeat.o(88441);
      return;
    }
    int i = this.BId.size();
    Object localObject2 = this.BId;
    String str = "";
    for (;;)
    {
      try
      {
        if ((this.BId.size() > 0) && (((dou)this.BId.getFirst()).iqb <= paramInt))
        {
          str = ((dou)this.BId.getFirst()).msgId;
          this.BId.removeFirst();
          continue;
        }
        if (i != this.BId.size()) {
          erT();
        }
        if (this.BIe != null)
        {
          if (this.BId.size() > 0) {
            this.BIe.a(this.BId.size(), ((dou)this.BId.getFirst()).msgId, ((dou)this.BId.getLast()).msgId, ((dou)this.BId.getFirst()).iqb, ((dou)this.BId.getLast()).iqb, ((dou)this.BId.getLast()).extInfo, paramBoolean1);
          }
        }
        else
        {
          if (paramBoolean2)
          {
            localObject2 = new dou();
            ((dou)localObject2).msgId = str;
            ((dou)localObject2).HVF = paramLong;
            ((dou)localObject2).iqb = paramInt;
            am.a((dou)localObject2, 106, 2, i, paramLong, "");
          }
          g.ajR().ajA().set(am.a.IXy, Long.valueOf(paramLong));
          g.ajR().ajA().fuc();
          ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", new Object[] { Integer.valueOf(paramInt) });
          g.ajR().ajA().set(am.a.IXz, Integer.valueOf(paramInt));
          g.ajR().ajA().fuc();
          AppMethodBeat.o(88441);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(88441);
      }
      this.BIe.a(0, "", "", 0, 0, "", paramBoolean1);
    }
  }
  
  public final void a(com.tencent.mm.plugin.topstory.a.e.a parama)
  {
    this.BIe = parama;
  }
  
  public final void a(dou paramdou)
  {
    AppMethodBeat.i(88428);
    if (!esm()) {
      am.a(paramdou, 108, 1, 0, 0L, "");
    }
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = paramdou.HVF;
    if (this.BIc == null) {}
    for (String str = "null";; str = this.BIc.HVF)
    {
      ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot showTime new:%s, cur:%s, curTime:%s", new Object[] { Long.valueOf(l2), str, Long.valueOf(l1) });
      if (paramdou.HVF > esd()) {
        break;
      }
      am.a(paramdou, 103, 1, 0, 0L, "");
      am.a(paramdou, 109, 1, 0, 0L, "r6|" + paramdou.HVF + "|" + esd());
      AppMethodBeat.o(88428);
      return;
    }
    if (paramdou.HVF > 3600L + l1)
    {
      am.a(paramdou, 109, 1, 0, 0L, "r10|" + paramdou.HVF + "|" + l1);
      AppMethodBeat.o(88428);
      return;
    }
    if ((this.BIc != null) && (!bu.isNullOrNil(this.BIc.msgId)) && (this.BIc.HVF > paramdou.HVF))
    {
      am.a(paramdou, 105, 1, 0, 0L, this.BIc.msgId);
      am.a(paramdou, 109, 1, 0, 0L, "r9|" + paramdou.HVF + "|" + esd());
      AppMethodBeat.o(88428);
      return;
    }
    if ((this.BIc != null) && (!bu.isNullOrNil(this.BIc.msgId))) {
      am.a(paramdou, 105, 1, 0, 0L, paramdou.msgId);
    }
    ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot valid");
    this.BIc = paramdou;
    g.ajR().ajA().set(am.a.IXA, e(this.BIc));
    g.ajR().ajA().fuc();
    if (esm()) {
      am.a(this.BIc, 101, 1, 0, 0L, "");
    }
    if (this.BIe != null) {
      this.BIe.br(this.BIc.msgId, this.BIc.HVF);
    }
    paramdou = new su();
    com.tencent.mm.sdk.b.a.IvT.l(paramdou);
    AppMethodBeat.o(88428);
  }
  
  public final void b(com.tencent.mm.plugin.topstory.a.e.a parama)
  {
    if (this.BIe == parama) {
      this.BIe = null;
    }
  }
  
  public final void b(dou paramdou)
  {
    AppMethodBeat.i(88429);
    ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", new Object[] { Integer.valueOf(paramdou.iqb) });
    if (!esm()) {
      am.a(paramdou, 108, 2, this.BId.size(), 0L, "");
    }
    if (paramdou.iqb <= ese())
    {
      ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", new Object[] { Integer.valueOf(paramdou.iqb), Integer.valueOf(ese()) });
      am.a(paramdou, 103, 2, erZ(), 0L, "");
      am.a(paramdou, 109, 2, erZ(), 0L, "r6|" + paramdou.iqb + "|" + ese());
      AppMethodBeat.o(88429);
      return;
    }
    label465:
    for (;;)
    {
      synchronized (this.BId)
      {
        if (!bu.ht(this.BId))
        {
          i = 0;
          if (i >= this.BId.size()) {
            break label465;
          }
          dou localdou = (dou)this.BId.get(i);
          if (localdou.msgId.equals(paramdou.msgId))
          {
            ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
            am.a(paramdou, 109, 2, erZ(), 0L, "r11");
            AppMethodBeat.o(88429);
            return;
          }
          if (localdou.iqb > paramdou.iqb) {
            break label465;
          }
          i += 1;
          continue;
          this.BId.add(i, paramdou);
          if (esm()) {
            am.a(esa(), 101, 2, this.BId.size(), 0L, "");
          }
          ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", new Object[] { paramdou.msgId, Long.valueOf(paramdou.HVF) });
          erT();
          if (this.BIe != null) {
            this.BIe.a(this.BId.size(), ((dou)this.BId.getFirst()).msgId, ((dou)this.BId.getLast()).msgId, ((dou)this.BId.getFirst()).iqb, ((dou)this.BId.getLast()).iqb, ((dou)this.BId.getLast()).extInfo);
          }
          paramdou = new su();
          com.tencent.mm.sdk.b.a.IvT.l(paramdou);
          AppMethodBeat.o(88429);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final boolean erP()
  {
    AppMethodBeat.i(88421);
    if (!esn())
    {
      AppMethodBeat.o(88421);
      return false;
    }
    int i;
    if (bu.isNullOrNil(this.BIc.msgId)) {
      i = -5;
    }
    while (i == 0)
    {
      if (!esm()) {
        break label369;
      }
      AppMethodBeat.o(88421);
      return true;
      if (this.BIc.HVG == 1)
      {
        i = -1;
      }
      else if (this.BIc.DUt > d.FFH)
      {
        ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.BIc.msgId, Integer.valueOf(this.BIc.DUt), Integer.valueOf(d.FFH) });
        i = -2;
      }
      else
      {
        if (this.BIc.irN != 0L)
        {
          long l1 = this.BIc.HVH;
          long l2 = this.BIc.irN;
          if (System.currentTimeMillis() > l1 + l2 * 1000L)
          {
            ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { this.BIc.msgId });
            i = -3;
            continue;
          }
        }
        boolean bool;
        if (ad.WL(1) >= this.BIc.DTy)
        {
          bool = true;
          label224:
          ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BIc.DTy), Integer.valueOf(ad.WL(1)), Long.valueOf(this.BIc.HVF), Long.valueOf(esd()) });
          if ((ad.WL(1) < this.BIc.DTy) || (this.BIc.HVF <= esd())) {
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
      am.a(this.BIc, 104, 1, 0, 0L, "");
      dnI();
    }
    label369:
    AppMethodBeat.o(88421);
    return false;
  }
  
  public final boolean erQ()
  {
    AppMethodBeat.i(88422);
    if (!esn())
    {
      AppMethodBeat.o(88422);
      return false;
    }
    if ((dou)this.BId.getLast() == null)
    {
      AppMethodBeat.o(88422);
      return false;
    }
    AppMethodBeat.o(88422);
    return true;
  }
  
  public final dou erR()
  {
    return this.BIc;
  }
  
  public final void erS()
  {
    AppMethodBeat.i(88425);
    if (this.BIc != null) {
      am.a(this.BIc.msgId, this.BIc.HVF, 1, 0, "", 0);
    }
    AppMethodBeat.o(88425);
  }
  
  public final dou erV()
  {
    AppMethodBeat.i(88433);
    dou localdou = new dou();
    d(localdou);
    Object localObject = (String)g.ajR().ajA().get(am.a.IYV, "");
    if (!bu.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label74;
      }
    }
    try
    {
      if (localObject.length >= 13) {
        a(localdou, (String[])localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(88433);
        return localdou;
        label74:
        g.ajR().ajA().set(am.a.IYV, "");
        g.ajR().ajA().fuc();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.ajR().ajA().set(am.a.IYV, "");
        g.ajR().ajA().fuc();
      }
    }
  }
  
  public final boolean erX()
  {
    if (this.BIc != null) {
      return this.BIc.DUu == 1;
    }
    return false;
  }
  
  public final int erY()
  {
    AppMethodBeat.i(88437);
    if (!esn())
    {
      ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88437);
      return 0;
    }
    ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(this.BId.size()) });
    int i = this.BId.size();
    AppMethodBeat.o(88437);
    return i;
  }
  
  public final dou esa()
  {
    AppMethodBeat.i(88439);
    synchronized (this.BId)
    {
      if (bu.ht(this.BId))
      {
        AppMethodBeat.o(88439);
        return null;
      }
      dou localdou = (dou)this.BId.getLast();
      AppMethodBeat.o(88439);
      return localdou;
    }
  }
  
  public final dou esb()
  {
    AppMethodBeat.i(88440);
    synchronized (this.BId)
    {
      if (bu.ht(this.BId))
      {
        AppMethodBeat.o(88440);
        return null;
      }
      dou localdou = (dou)this.BId.getFirst();
      AppMethodBeat.o(88440);
      return localdou;
    }
  }
  
  public final boolean esc()
  {
    AppMethodBeat.i(88443);
    if (!bu.ht(this.BId))
    {
      if (((dou)this.BId.getLast()).DUu == 1)
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
  
  public final boolean esf()
  {
    AppMethodBeat.i(88447);
    dou localdou = erV();
    if (!bu.isNullOrNil(localdou.msgId))
    {
      long l1 = localdou.HVH;
      long l2 = localdou.irN;
      if (System.currentTimeMillis() > l1 + l2 * 1000L)
      {
        ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { localdou.msgId });
        erU();
        AppMethodBeat.o(88447);
        return false;
      }
      AppMethodBeat.o(88447);
      return true;
    }
    AppMethodBeat.o(88447);
    return false;
  }
  
  public final String esg()
  {
    AppMethodBeat.i(88448);
    String str = erV().msgId;
    AppMethodBeat.o(88448);
    return str;
  }
  
  public final void esh()
  {
    AppMethodBeat.i(88449);
    dou localdou = new dou();
    localdou.msgId = erV().msgId;
    am.a(localdou, 106, 3, 0, 0L, "");
    erU();
    AppMethodBeat.o(88449);
  }
  
  public final String esi()
  {
    AppMethodBeat.i(88451);
    String str = (String)g.ajR().ajA().get(am.a.IYW, "");
    if (bu.isNullOrNil(str))
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
  
  public final long esj()
  {
    AppMethodBeat.i(88452);
    String str = (String)g.ajR().ajA().get(am.a.IYW, "");
    if (bu.isNullOrNil(str))
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
  
  public final String esk()
  {
    AppMethodBeat.i(88453);
    String str = (String)g.ajR().ajA().get(am.a.IYW, "");
    if (bu.isNullOrNil(str))
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
  
  public final void esl()
  {
    AppMethodBeat.i(88454);
    l("", "", 0L);
    AppMethodBeat.o(88454);
  }
  
  public final boolean esm()
  {
    AppMethodBeat.i(88455);
    JSONObject localJSONObject = af.aHj("discoverRecommendEntry");
    boolean bool;
    if (((com.tencent.mm.plugin.welab.a.a.a)g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).aLo("labs_browse"))
    {
      if (!((com.tencent.mm.plugin.welab.a.a.a)g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).Ln("labs_browse")) {
        break label98;
      }
      bool = true;
    }
    for (;;)
    {
      ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recommend show %b", new Object[] { Boolean.valueOf(bool) });
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
  
  public final boolean esn()
  {
    AppMethodBeat.i(88456);
    if (((d.FFH >= 654311424) || (d.FFL)) && (bu.isNullOrNil(this.BIi))) {
      this.BIi = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzA, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.BIi).getJSONArray("tabs");
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
      ae.w("MicroMsg.TopStory.TopStoryRedDotImpl", "parse tabconfig failed: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(88456);
    }
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
    ae.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgId", paramString1);
      localJSONObject.put("extInfo", paramString2);
      localJSONObject.put("ts", paramLong);
      g.ajR().ajA().set(am.a.IYW, localJSONObject.toString());
      g.ajR().ajA().fuc();
      if ((!bu.isNullOrNil(paramString1)) && (this.BIe != null)) {
        this.BIe.bs(paramString1, paramLong);
      }
      AppMethodBeat.o(88450);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", paramString2, "setUserIconRedDot error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b
 * JD-Core Version:    0.7.0.1
 */