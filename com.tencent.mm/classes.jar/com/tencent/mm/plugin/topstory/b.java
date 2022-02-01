package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.topstory.a.e
{
  private com.tencent.mm.al.g gWw;
  public dcv yKY;
  LinkedList<dcv> yKZ;
  e.a yLa;
  p yLb;
  com.tencent.mm.plugin.topstory.a.c.b yLc;
  final String yLd;
  String yLe;
  c<fh> yLf;
  
  public b()
  {
    AppMethodBeat.i(88420);
    this.yKZ = new LinkedList();
    this.yLb = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(88417);
        if ((paramAnonymousMap != null) && (paramAnonymousString != null) && (paramAnonymousString.equals("mmsearch_reddot_new")))
        {
          int i = bt.aGh((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.entry"));
          if (i == 2)
          {
            paramAnonymousString = new dcv();
            b.d(paramAnonymousString);
            ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramAnonymousMap.toString() });
            paramAnonymousString.Eum = bt.aGh((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.clear"));
            paramAnonymousString.AHi = i;
            paramAnonymousString.dvT = bt.u((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
            paramAnonymousString.AHk = bt.aGh((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
            paramAnonymousString.AHj = bt.aGh((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
            paramAnonymousString.huV = bt.aGi((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
            paramAnonymousString.AGn = bt.aGh((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
            paramAnonymousString.type = bt.aGh((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
            paramAnonymousString.text = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_text"));
            paramAnonymousString.dub = ((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon"));
            paramAnonymousString.Eul = bt.aGi((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
            paramAnonymousString.Eun = System.currentTimeMillis();
            paramAnonymousString.htk = bt.aGh((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.seq"));
            paramAnonymousString.extInfo = bt.u((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.ext_info"), new Object[0]);
            if (paramAnonymousString.Eum == 1)
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
                ak.a(paramAnonymousString, 100, i, 0, 0L, "");
                AppMethodBeat.o(88417);
                return;
                b.dNw();
                break;
                paramAnonymousMap.a(paramAnonymousString.Eul, true, paramAnonymousString.htk, false);
                paramAnonymousMap = new rx();
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMap);
                break;
                paramAnonymousMap.G(paramAnonymousString.Eul, false);
                paramAnonymousMap = new rx();
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMap);
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
          ak.a(paramAnonymousString, 109, 0, 0, 0L, "r12|" + paramAnonymousString.type);
        case 9: 
          do
          {
            AppMethodBeat.o(88417);
            return;
          } while (b.this.yLa == null);
          b.this.yLa.asx(paramAnonymousString.extInfo);
          ak.a(paramAnonymousString, 100, 4, 0, 0L, "");
          AppMethodBeat.o(88417);
          return;
        case 8: 
          ak.a(paramAnonymousString, 100, 3, 0, 0L, "");
          b.c(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 7: 
          ak.a(paramAnonymousString, 100, 2, b.this.yKZ.size(), 0L, "");
          b.this.b(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 1: 
          b.f(paramAnonymousString);
        case 2: 
        case 3: 
        case 4: 
          ak.a(paramAnonymousString, 100, 1, 0, 0L, "");
          b.this.a(paramAnonymousString);
          AppMethodBeat.o(88417);
          return;
        case 10: 
          ak.a(paramAnonymousString, 100, 5, 0, 0L, "");
          b.this.x(paramAnonymousString.dvT, paramAnonymousString.extInfo, paramAnonymousString.Eul);
          AppMethodBeat.o(88417);
          return;
        }
        ak.a(paramAnonymousString, 100, 11, 0, 0L, "");
        b.f(paramAnonymousString);
        AppMethodBeat.o(88417);
      }
    };
    this.gWw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(88418);
        if (paramAnonymousn.equals(b.this.yLc))
        {
          com.tencent.mm.kernel.g.aeS().b(b.this.yLc.getType(), this);
          b.this.yLc = null;
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.b)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
            AppMethodBeat.o(88418);
          }
        }
        else
        {
          AppMethodBeat.o(88418);
          return;
        }
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftu, paramAnonymousString.dOd().DLy);
        com.tencent.mm.kernel.g.afB().afk().eKy();
        paramAnonymousString = new rx();
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
        AppMethodBeat.o(88418);
      }
    };
    this.yLd = "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}";
    this.yLe = "";
    this.yLf = new c() {};
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.yLb);
    this.yKY = new dcv();
    d(this.yKY);
    dcv localdcv = this.yKY;
    Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FsL, "");
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
        a(localdcv, (String[])localObject);
      }
      for (;;)
      {
        dNy();
        com.tencent.mm.sdk.b.a.ESL.b(this.yLf);
        AppMethodBeat.o(88420);
        return;
        label182:
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsL, "");
        com.tencent.mm.kernel.g.afB().afk().eKy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsL, "");
        com.tencent.mm.kernel.g.afB().afk().eKy();
      }
    }
  }
  
  private static void a(dcv paramdcv, String[] paramArrayOfString)
  {
    AppMethodBeat.i(88435);
    paramdcv.dvT = paramArrayOfString[0];
    paramdcv.Eum = Integer.valueOf(paramArrayOfString[1]).intValue();
    paramdcv.AHj = Integer.valueOf(paramArrayOfString[2]).intValue();
    paramdcv.AHk = Integer.valueOf(paramArrayOfString[3]).intValue();
    paramdcv.AHi = Integer.valueOf(paramArrayOfString[4]).intValue();
    paramdcv.huV = Long.valueOf(paramArrayOfString[5]).longValue();
    paramdcv.AGn = Integer.valueOf(paramArrayOfString[6]).intValue();
    paramdcv.Eun = Long.valueOf(paramArrayOfString[7]).longValue();
    paramdcv.text = paramArrayOfString[8];
    paramdcv.type = Integer.valueOf(paramArrayOfString[9]).intValue();
    paramdcv.evt = Integer.valueOf(paramArrayOfString[10]).intValue();
    paramdcv.Eul = Long.valueOf(paramArrayOfString[11]).longValue();
    paramdcv.dub = paramArrayOfString[12];
    if (paramArrayOfString.length > 13) {
      paramdcv.htk = Integer.valueOf(paramArrayOfString[13]).intValue();
    }
    while (paramArrayOfString.length > 14)
    {
      paramdcv.extInfo = paramArrayOfString[14];
      AppMethodBeat.o(88435);
      return;
      paramdcv.htk = 0;
      if (paramdcv.type == 7) {
        ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
      }
    }
    paramdcv.extInfo = "";
    AppMethodBeat.o(88435);
  }
  
  public static void c(dcv paramdcv)
  {
    AppMethodBeat.i(88431);
    ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", new Object[] { paramdcv.dvT });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtX, e(paramdcv));
    com.tencent.mm.kernel.g.afB().afk().eKy();
    ak.a(paramdcv, 101, 3, 0, 0L, "");
    AppMethodBeat.o(88431);
  }
  
  private void cNH()
  {
    AppMethodBeat.i(88423);
    this.yKY = new dcv();
    d(this.yKY);
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsL, "");
    com.tencent.mm.kernel.g.afB().afk().eKy();
    if (this.yLa != null)
    {
      e.a locala = this.yLa;
      dNF();
      locala.dNQ();
    }
    AppMethodBeat.o(88423);
  }
  
  static void d(dcv paramdcv)
  {
    paramdcv.dub = "";
    paramdcv.dvT = "";
    paramdcv.text = "";
  }
  
  private int dNB()
  {
    AppMethodBeat.i(88438);
    if (!dNP())
    {
      ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88438);
      return 0;
    }
    ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(this.yKZ.size()) });
    int i = this.yKZ.size();
    AppMethodBeat.o(88438);
    return i;
  }
  
  public static long dNF()
  {
    AppMethodBeat.i(88445);
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FsI, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88445);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(88445);
    return l;
  }
  
  private static int dNG()
  {
    AppMethodBeat.i(88446);
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FsK, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88446);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(88446);
    return i;
  }
  
  private void dNv()
  {
    AppMethodBeat.i(88430);
    synchronized (this.yKZ)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.yKZ.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(e((dcv)localIterator.next())).append(";");
      }
    }
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtW, localObject.toString());
    com.tencent.mm.kernel.g.afB().afk().eKy();
    AppMethodBeat.o(88430);
  }
  
  public static void dNw()
  {
    AppMethodBeat.i(88432);
    ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtX, "");
    com.tencent.mm.kernel.g.afB().afk().eKy();
    AppMethodBeat.o(88432);
  }
  
  private void dNy()
  {
    AppMethodBeat.i(88436);
    Object localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtW, "");
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
            dcv localdcv = new dcv();
            a(localdcv, (String[])localObject2);
            this.yKZ.addLast(localdcv);
          }
          i += 1;
        }
        AppMethodBeat.o(88436);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtW, "");
        com.tencent.mm.kernel.g.afB().afk().eKy();
      }
    }
    AppMethodBeat.o(88436);
  }
  
  public static String e(dcv paramdcv)
  {
    AppMethodBeat.i(88434);
    paramdcv = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramdcv.dvT, Integer.valueOf(paramdcv.Eum), Integer.valueOf(paramdcv.AHj), Integer.valueOf(paramdcv.AHk), Integer.valueOf(paramdcv.AHi), Long.valueOf(paramdcv.huV), Integer.valueOf(paramdcv.AGn), Long.valueOf(paramdcv.Eun), paramdcv.text, Integer.valueOf(paramdcv.type), Integer.valueOf(paramdcv.evt), Long.valueOf(paramdcv.Eul), paramdcv.dub, Integer.valueOf(paramdcv.htk), paramdcv.extInfo });
    AppMethodBeat.o(88434);
    return paramdcv;
  }
  
  public final void G(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(88426);
    if ((this.yKY == null) || (bt.isNullOrNil(this.yKY.dvT)))
    {
      AppMethodBeat.o(88426);
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if ((paramLong < dNF()) || (paramLong <= 0L) || (l + 3600L < paramLong))
    {
      ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", new Object[] { Long.valueOf(dNF()) });
      AppMethodBeat.o(88426);
      return;
    }
    if ((this.yKY != null) && (paramLong < this.yKY.Eul))
    {
      ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", new Object[] { Long.valueOf(this.yKY.Eul) });
      AppMethodBeat.o(88426);
      return;
    }
    if (paramBoolean) {
      ak.a(this.yKY, 106, 1, 0, paramLong, "");
    }
    cNH();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsI, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.afB().afk().eKy();
    AppMethodBeat.o(88426);
  }
  
  public final void Pb(int paramInt)
  {
    AppMethodBeat.i(88424);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88424);
      return;
      dNw();
      AppMethodBeat.o(88424);
      return;
      synchronized (this.yKZ)
      {
        this.yKZ.clear();
        dNv();
        if (this.yLa != null) {
          this.yLa.a(0, "", "", 0, 0, "", true);
        }
        ??? = new rx();
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)???);
        AppMethodBeat.o(88424);
        return;
      }
      cNH();
      ??? = new rx();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(88424);
      return;
      x("", "", 0L);
    }
  }
  
  public final void Pc(int paramInt)
  {
    AppMethodBeat.i(88444);
    dcv localdcv = dNC();
    if (localdcv != null) {
      ak.a(localdcv.dvT, localdcv.Eul, 2, paramInt, "", localdcv.htk);
    }
    AppMethodBeat.o(88444);
  }
  
  public final void a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(88441);
    if (this.yKZ.size() == 0)
    {
      AppMethodBeat.o(88441);
      return;
    }
    if (paramInt <= dNG())
    {
      ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(dNG()) });
      AppMethodBeat.o(88441);
      return;
    }
    int i = this.yKZ.size();
    Object localObject2 = this.yKZ;
    String str = "";
    for (;;)
    {
      try
      {
        if ((this.yKZ.size() > 0) && (((dcv)this.yKZ.getFirst()).htk <= paramInt))
        {
          str = ((dcv)this.yKZ.getFirst()).dvT;
          this.yKZ.removeFirst();
          continue;
        }
        if (i != this.yKZ.size()) {
          dNv();
        }
        if (this.yLa != null)
        {
          if (this.yKZ.size() > 0) {
            this.yLa.a(this.yKZ.size(), ((dcv)this.yKZ.getFirst()).dvT, ((dcv)this.yKZ.getLast()).dvT, ((dcv)this.yKZ.getFirst()).htk, ((dcv)this.yKZ.getLast()).htk, ((dcv)this.yKZ.getLast()).extInfo, paramBoolean1);
          }
        }
        else
        {
          if (paramBoolean2)
          {
            localObject2 = new dcv();
            ((dcv)localObject2).dvT = str;
            ((dcv)localObject2).Eul = paramLong;
            ((dcv)localObject2).htk = paramInt;
            ak.a((dcv)localObject2, 106, 2, i, paramLong, "");
          }
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsJ, Long.valueOf(paramLong));
          com.tencent.mm.kernel.g.afB().afk().eKy();
          ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", new Object[] { Integer.valueOf(paramInt) });
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsK, Integer.valueOf(paramInt));
          com.tencent.mm.kernel.g.afB().afk().eKy();
          AppMethodBeat.o(88441);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(88441);
      }
      this.yLa.a(0, "", "", 0, 0, "", paramBoolean1);
    }
  }
  
  public final void a(e.a parama)
  {
    this.yLa = parama;
  }
  
  public final void a(dcv paramdcv)
  {
    AppMethodBeat.i(88428);
    if (!dNO()) {
      ak.a(paramdcv, 108, 1, 0, 0L, "");
    }
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = paramdcv.Eul;
    if (this.yKY == null) {}
    for (String str = "null";; str = this.yKY.Eul)
    {
      ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot showTime new:%s, cur:%s, curTime:%s", new Object[] { Long.valueOf(l2), str, Long.valueOf(l1) });
      if (paramdcv.Eul > dNF()) {
        break;
      }
      ak.a(paramdcv, 103, 1, 0, 0L, "");
      ak.a(paramdcv, 109, 1, 0, 0L, "r6|" + paramdcv.Eul + "|" + dNF());
      AppMethodBeat.o(88428);
      return;
    }
    if (paramdcv.Eul > 3600L + l1)
    {
      ak.a(paramdcv, 109, 1, 0, 0L, "r10|" + paramdcv.Eul + "|" + l1);
      AppMethodBeat.o(88428);
      return;
    }
    if ((this.yKY != null) && (!bt.isNullOrNil(this.yKY.dvT)) && (this.yKY.Eul > paramdcv.Eul))
    {
      ak.a(paramdcv, 105, 1, 0, 0L, this.yKY.dvT);
      ak.a(paramdcv, 109, 1, 0, 0L, "r9|" + paramdcv.Eul + "|" + dNF());
      AppMethodBeat.o(88428);
      return;
    }
    if ((this.yKY != null) && (!bt.isNullOrNil(this.yKY.dvT))) {
      ak.a(paramdcv, 105, 1, 0, 0L, paramdcv.dvT);
    }
    ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot valid");
    this.yKY = paramdcv;
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsL, e(this.yKY));
    com.tencent.mm.kernel.g.afB().afk().eKy();
    if (dNO()) {
      ak.a(this.yKY, 101, 1, 0, 0L, "");
    }
    if (this.yLa != null) {
      this.yLa.bl(this.yKY.dvT, this.yKY.Eul);
    }
    paramdcv = new rx();
    com.tencent.mm.sdk.b.a.ESL.l(paramdcv);
    AppMethodBeat.o(88428);
  }
  
  public final void b(e.a parama)
  {
    if (this.yLa == parama) {
      this.yLa = null;
    }
  }
  
  public final void b(dcv paramdcv)
  {
    AppMethodBeat.i(88429);
    ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", new Object[] { Integer.valueOf(paramdcv.htk) });
    if (!dNO()) {
      ak.a(paramdcv, 108, 2, this.yKZ.size(), 0L, "");
    }
    if (paramdcv.htk <= dNG())
    {
      ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", new Object[] { Integer.valueOf(paramdcv.htk), Integer.valueOf(dNG()) });
      ak.a(paramdcv, 103, 2, dNB(), 0L, "");
      ak.a(paramdcv, 109, 2, dNB(), 0L, "r6|" + paramdcv.htk + "|" + dNG());
      AppMethodBeat.o(88429);
      return;
    }
    label465:
    for (;;)
    {
      synchronized (this.yKZ)
      {
        if (!bt.gL(this.yKZ))
        {
          i = 0;
          if (i >= this.yKZ.size()) {
            break label465;
          }
          dcv localdcv = (dcv)this.yKZ.get(i);
          if (localdcv.dvT.equals(paramdcv.dvT))
          {
            ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
            ak.a(paramdcv, 109, 2, dNB(), 0L, "r11");
            AppMethodBeat.o(88429);
            return;
          }
          if (localdcv.htk > paramdcv.htk) {
            break label465;
          }
          i += 1;
          continue;
          this.yKZ.add(i, paramdcv);
          if (dNO()) {
            ak.a(dNC(), 101, 2, this.yKZ.size(), 0L, "");
          }
          ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", new Object[] { paramdcv.dvT, Long.valueOf(paramdcv.Eul) });
          dNv();
          if (this.yLa != null) {
            this.yLa.a(this.yKZ.size(), ((dcv)this.yKZ.getFirst()).dvT, ((dcv)this.yKZ.getLast()).dvT, ((dcv)this.yKZ.getFirst()).htk, ((dcv)this.yKZ.getLast()).htk, ((dcv)this.yKZ.getLast()).extInfo);
          }
          paramdcv = new rx();
          com.tencent.mm.sdk.b.a.ESL.l(paramdcv);
          AppMethodBeat.o(88429);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final int dNA()
  {
    AppMethodBeat.i(88437);
    if (!dNP())
    {
      ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(88437);
      return 0;
    }
    ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(this.yKZ.size()) });
    int i = this.yKZ.size();
    AppMethodBeat.o(88437);
    return i;
  }
  
  public final dcv dNC()
  {
    AppMethodBeat.i(88439);
    synchronized (this.yKZ)
    {
      if (bt.gL(this.yKZ))
      {
        AppMethodBeat.o(88439);
        return null;
      }
      dcv localdcv = (dcv)this.yKZ.getLast();
      AppMethodBeat.o(88439);
      return localdcv;
    }
  }
  
  public final dcv dND()
  {
    AppMethodBeat.i(88440);
    synchronized (this.yKZ)
    {
      if (bt.gL(this.yKZ))
      {
        AppMethodBeat.o(88440);
        return null;
      }
      dcv localdcv = (dcv)this.yKZ.getFirst();
      AppMethodBeat.o(88440);
      return localdcv;
    }
  }
  
  public final boolean dNE()
  {
    AppMethodBeat.i(88443);
    if (!bt.gL(this.yKZ))
    {
      if (((dcv)this.yKZ.getLast()).AHk == 1)
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
  
  public final boolean dNH()
  {
    AppMethodBeat.i(88447);
    dcv localdcv = dNx();
    if (!bt.isNullOrNil(localdcv.dvT))
    {
      long l1 = localdcv.Eun;
      long l2 = localdcv.huV;
      if (System.currentTimeMillis() > l1 + l2 * 1000L)
      {
        ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { localdcv.dvT });
        dNw();
        AppMethodBeat.o(88447);
        return false;
      }
      AppMethodBeat.o(88447);
      return true;
    }
    AppMethodBeat.o(88447);
    return false;
  }
  
  public final String dNI()
  {
    AppMethodBeat.i(88448);
    String str = dNx().dvT;
    AppMethodBeat.o(88448);
    return str;
  }
  
  public final void dNJ()
  {
    AppMethodBeat.i(88449);
    dcv localdcv = new dcv();
    localdcv.dvT = dNx().dvT;
    ak.a(localdcv, 106, 3, 0, 0L, "");
    dNw();
    AppMethodBeat.o(88449);
  }
  
  public final String dNK()
  {
    AppMethodBeat.i(88451);
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtY, "");
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
  
  public final long dNL()
  {
    AppMethodBeat.i(88452);
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtY, "");
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
  
  public final String dNM()
  {
    AppMethodBeat.i(88453);
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtY, "");
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
  
  public final void dNN()
  {
    AppMethodBeat.i(88454);
    x("", "", 0L);
    AppMethodBeat.o(88454);
  }
  
  public final boolean dNO()
  {
    AppMethodBeat.i(88455);
    JSONObject localJSONObject = ac.ave("discoverRecommendEntry");
    boolean bool;
    if (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).azb("labs_browse"))
    {
      if (!((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).Dx("labs_browse")) {
        break label98;
      }
      bool = true;
    }
    for (;;)
    {
      ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recommend show %b", new Object[] { Boolean.valueOf(bool) });
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
  
  public final boolean dNP()
  {
    AppMethodBeat.i(88456);
    if (((d.CpK >= 654311424) || (d.CpO)) && (bt.isNullOrNil(this.yLe))) {
      this.yLe = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plq, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.yLe).getJSONArray("tabs");
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
      ad.w("MicroMsg.TopStory.TopStoryRedDotImpl", "parse tabconfig failed: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(88456);
    }
  }
  
  public final boolean dNr()
  {
    AppMethodBeat.i(88421);
    if (!dNP())
    {
      AppMethodBeat.o(88421);
      return false;
    }
    int i;
    if (bt.isNullOrNil(this.yKY.dvT)) {
      i = -5;
    }
    while (i == 0)
    {
      if (!dNO()) {
        break label369;
      }
      AppMethodBeat.o(88421);
      return true;
      if (this.yKY.Eum == 1)
      {
        i = -1;
      }
      else if (this.yKY.AHj > d.CpK)
      {
        ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.yKY.dvT, Integer.valueOf(this.yKY.AHj), Integer.valueOf(d.CpK) });
        i = -2;
      }
      else
      {
        if (this.yKY.huV != 0L)
        {
          long l1 = this.yKY.Eun;
          long l2 = this.yKY.huV;
          if (System.currentTimeMillis() > l1 + l2 * 1000L)
          {
            ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { this.yKY.dvT });
            i = -3;
            continue;
          }
        }
        boolean bool;
        if (aa.Sb(1) >= this.yKY.AGn)
        {
          bool = true;
          label224:
          ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.yKY.AGn), Integer.valueOf(aa.Sb(1)), Long.valueOf(this.yKY.Eul), Long.valueOf(dNF()) });
          if ((aa.Sb(1) < this.yKY.AGn) || (this.yKY.Eul <= dNF())) {
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
      ak.a(this.yKY, 104, 1, 0, 0L, "");
      cNH();
    }
    label369:
    AppMethodBeat.o(88421);
    return false;
  }
  
  public final boolean dNs()
  {
    AppMethodBeat.i(88422);
    if (!dNP())
    {
      AppMethodBeat.o(88422);
      return false;
    }
    if ((dcv)this.yKZ.getLast() == null)
    {
      AppMethodBeat.o(88422);
      return false;
    }
    AppMethodBeat.o(88422);
    return true;
  }
  
  public final dcv dNt()
  {
    return this.yKY;
  }
  
  public final void dNu()
  {
    AppMethodBeat.i(88425);
    if (this.yKY != null) {
      ak.a(this.yKY.dvT, this.yKY.Eul, 1, 0, "", 0);
    }
    AppMethodBeat.o(88425);
  }
  
  public final dcv dNx()
  {
    AppMethodBeat.i(88433);
    dcv localdcv = new dcv();
    d(localdcv);
    Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtX, "");
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
        a(localdcv, (String[])localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(88433);
        return localdcv;
        label74:
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtX, "");
        com.tencent.mm.kernel.g.afB().afk().eKy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtX, "");
        com.tencent.mm.kernel.g.afB().afk().eKy();
      }
    }
  }
  
  public final boolean dNz()
  {
    if (this.yKY != null) {
      return this.yKY.AHk == 1;
    }
    return false;
  }
  
  public final void h(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(88442);
    a(paramLong, paramBoolean, paramInt, true);
    AppMethodBeat.o(88442);
  }
  
  public final void ub(long paramLong)
  {
    AppMethodBeat.i(88427);
    G(paramLong, true);
    AppMethodBeat.o(88427);
  }
  
  public final void x(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(88450);
    ad.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgId", paramString1);
      localJSONObject.put("extInfo", paramString2);
      localJSONObject.put("ts", paramLong);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtY, localJSONObject.toString());
      com.tencent.mm.kernel.g.afB().afk().eKy();
      if ((!bt.isNullOrNil(paramString1)) && (this.yLa != null)) {
        this.yLa.bm(paramString1, paramLong);
      }
      AppMethodBeat.o(88450);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", paramString2, "setUserIconRedDot error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b
 * JD-Core Version:    0.7.0.1
 */