package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.topstory.a.e
{
  private f fur;
  public cku teB;
  LinkedList<cku> teC;
  e.a teD;
  o teE;
  com.tencent.mm.plugin.topstory.a.c.b teF;
  final String teG;
  String teH;
  c<fb> teI;
  
  public b()
  {
    AppMethodBeat.i(65457);
    this.teC = new LinkedList();
    this.teE = new b.1(this);
    this.fur = new b.2(this);
    this.teG = "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}";
    this.teH = "";
    this.teI = new b.3(this);
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.teE);
    this.teB = new cku();
    c(this.teB);
    cku localcku = this.teB;
    Object localObject = (String)g.RL().Ru().get(ac.a.yJC, "");
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label182;
      }
    }
    try
    {
      if (localObject.length >= 13) {
        a(localcku, (String[])localObject);
      }
      for (;;)
      {
        cIc();
        com.tencent.mm.sdk.b.a.ymk.b(this.teI);
        AppMethodBeat.o(65457);
        return;
        label182:
        g.RL().Ru().set(ac.a.yJC, "");
        g.RL().Ru().dww();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.RL().Ru().set(ac.a.yJC, "");
        g.RL().Ru().dww();
      }
    }
  }
  
  private static void a(cku paramcku, String[] paramArrayOfString)
  {
    AppMethodBeat.i(65470);
    paramcku.cDC = paramArrayOfString[0];
    paramcku.xUI = Integer.valueOf(paramArrayOfString[1]).intValue();
    paramcku.uKe = Integer.valueOf(paramArrayOfString[2]).intValue();
    paramcku.uKf = Integer.valueOf(paramArrayOfString[3]).intValue();
    paramcku.uKd = Integer.valueOf(paramArrayOfString[4]).intValue();
    paramcku.fSm = Long.valueOf(paramArrayOfString[5]).longValue();
    paramcku.uJc = Integer.valueOf(paramArrayOfString[6]).intValue();
    paramcku.xUJ = Long.valueOf(paramArrayOfString[7]).longValue();
    paramcku.text = paramArrayOfString[8];
    paramcku.type = Integer.valueOf(paramArrayOfString[9]).intValue();
    paramcku.dqG = Integer.valueOf(paramArrayOfString[10]).intValue();
    paramcku.xUH = Long.valueOf(paramArrayOfString[11]).longValue();
    paramcku.cDz = paramArrayOfString[12];
    if (paramArrayOfString.length > 13) {
      paramcku.fQD = Integer.valueOf(paramArrayOfString[13]).intValue();
    }
    while (paramArrayOfString.length > 14)
    {
      paramcku.extInfo = paramArrayOfString[14];
      AppMethodBeat.o(65470);
      return;
      paramcku.fQD = 0;
      if (paramcku.type == 7) {
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
      }
    }
    paramcku.extInfo = "";
    AppMethodBeat.o(65470);
  }
  
  public static void aed(String paramString)
  {
    AppMethodBeat.i(65468);
    ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", new Object[] { paramString });
    g.RL().Ru().set(ac.a.yKL, paramString);
    g.RL().Ru().dww();
    AppMethodBeat.o(65468);
  }
  
  private void bOQ()
  {
    AppMethodBeat.i(65460);
    this.teB = new cku();
    c(this.teB);
    g.RL().Ru().set(ac.a.yJC, "");
    g.RL().Ru().dww();
    if (this.teD != null)
    {
      e.a locala = this.teD;
      cIj();
      locala.cIu();
    }
    AppMethodBeat.o(65460);
  }
  
  static void c(cku paramcku)
  {
    paramcku.cDz = "";
    paramcku.cDC = "";
    paramcku.text = "";
  }
  
  private void cIb()
  {
    AppMethodBeat.i(65467);
    synchronized (this.teC)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.teC.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(d((cku)localIterator.next())).append(";");
      }
    }
    g.RL().Ru().set(ac.a.yKK, localObject.toString());
    g.RL().Ru().dww();
    AppMethodBeat.o(65467);
  }
  
  private void cIc()
  {
    AppMethodBeat.i(65471);
    Object localObject1 = (String)g.RL().Ru().get(ac.a.yKK, "");
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(";");
      try
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!bo.isNullOrNil((String)localObject2))
          {
            localObject2 = ((String)localObject2).split(",");
            cku localcku = new cku();
            a(localcku, (String[])localObject2);
            this.teC.addLast(localcku);
          }
          i += 1;
        }
        AppMethodBeat.o(65471);
        return;
      }
      catch (Exception localException)
      {
        g.RL().Ru().set(ac.a.yKK, "");
        g.RL().Ru().dww();
      }
    }
    AppMethodBeat.o(65471);
  }
  
  private int cIf()
  {
    AppMethodBeat.i(65473);
    if (!cIt())
    {
      ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(65473);
      return 0;
    }
    ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(this.teC.size()) });
    int i = this.teC.size();
    AppMethodBeat.o(65473);
    return i;
  }
  
  public static long cIj()
  {
    AppMethodBeat.i(65480);
    Object localObject = g.RL().Ru().get(ac.a.yJz, null);
    if (localObject == null)
    {
      AppMethodBeat.o(65480);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(65480);
    return l;
  }
  
  private static int cIk()
  {
    AppMethodBeat.i(65481);
    Object localObject = g.RL().Ru().get(ac.a.yJB, null);
    if (localObject == null)
    {
      AppMethodBeat.o(65481);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(65481);
    return i;
  }
  
  public static String d(cku paramcku)
  {
    AppMethodBeat.i(65469);
    paramcku = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramcku.cDC, Integer.valueOf(paramcku.xUI), Integer.valueOf(paramcku.uKe), Integer.valueOf(paramcku.uKf), Integer.valueOf(paramcku.uKd), Long.valueOf(paramcku.fSm), Integer.valueOf(paramcku.uJc), Long.valueOf(paramcku.xUJ), paramcku.text, Integer.valueOf(paramcku.type), Integer.valueOf(paramcku.dqG), Long.valueOf(paramcku.xUH), paramcku.cDz, Integer.valueOf(paramcku.fQD), paramcku.extInfo });
    AppMethodBeat.o(65469);
    return paramcku;
  }
  
  public final void B(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65463);
    if ((this.teB == null) || (bo.isNullOrNil(this.teB.cDC)))
    {
      AppMethodBeat.o(65463);
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if ((paramLong < cIj()) || (paramLong <= 0L) || (l + 3600L < paramLong))
    {
      ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", new Object[] { Long.valueOf(cIj()) });
      AppMethodBeat.o(65463);
      return;
    }
    if ((this.teB != null) && (paramLong < this.teB.xUH))
    {
      ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", new Object[] { Long.valueOf(this.teB.xUH) });
      AppMethodBeat.o(65463);
      return;
    }
    if (paramBoolean) {
      an.a(this.teB, 106, 1, 0, paramLong, "");
    }
    bOQ();
    g.RL().Ru().set(ac.a.yJz, Long.valueOf(paramLong));
    g.RL().Ru().dww();
    AppMethodBeat.o(65463);
  }
  
  public final void Gu(int paramInt)
  {
    AppMethodBeat.i(65461);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65461);
      return;
      aed("");
      AppMethodBeat.o(65461);
      return;
      synchronized (this.teC)
      {
        this.teC.clear();
        cIb();
        if (this.teD != null) {
          this.teD.a(0, "", "", 0, 0, "", true);
        }
        ??? = new qf();
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)???);
        AppMethodBeat.o(65461);
        return;
      }
      bOQ();
      ??? = new qf();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(65461);
      return;
      o("", "", 0L);
    }
  }
  
  public final void Gv(int paramInt)
  {
    AppMethodBeat.i(65479);
    cku localcku = cIg();
    if (localcku != null) {
      an.a(localcku.cDC, localcku.xUH, 2, paramInt, "", localcku.fQD);
    }
    AppMethodBeat.o(65479);
  }
  
  public final void a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(65476);
    if (this.teC.size() == 0)
    {
      AppMethodBeat.o(65476);
      return;
    }
    if (paramInt <= cIk())
    {
      ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(cIk()) });
      AppMethodBeat.o(65476);
      return;
    }
    int i = this.teC.size();
    Object localObject2 = this.teC;
    String str = "";
    for (;;)
    {
      try
      {
        if ((this.teC.size() > 0) && (((cku)this.teC.getFirst()).fQD <= paramInt))
        {
          str = ((cku)this.teC.getFirst()).cDC;
          this.teC.removeFirst();
          continue;
        }
        if (i != this.teC.size()) {
          cIb();
        }
        if (this.teD != null)
        {
          if (this.teC.size() > 0) {
            this.teD.a(this.teC.size(), ((cku)this.teC.getFirst()).cDC, ((cku)this.teC.getLast()).cDC, ((cku)this.teC.getFirst()).fQD, ((cku)this.teC.getLast()).fQD, ((cku)this.teC.getLast()).extInfo, paramBoolean1);
          }
        }
        else
        {
          if (paramBoolean2)
          {
            localObject2 = new cku();
            ((cku)localObject2).cDC = str;
            ((cku)localObject2).xUH = paramLong;
            ((cku)localObject2).fQD = paramInt;
            an.a((cku)localObject2, 106, 2, i, paramLong, "");
          }
          g.RL().Ru().set(ac.a.yJA, Long.valueOf(paramLong));
          g.RL().Ru().dww();
          ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", new Object[] { Integer.valueOf(paramInt) });
          g.RL().Ru().set(ac.a.yJB, Integer.valueOf(paramInt));
          g.RL().Ru().dww();
          AppMethodBeat.o(65476);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(65476);
      }
      this.teD.a(0, "", "", 0, 0, "", paramBoolean1);
    }
  }
  
  public final void a(e.a parama)
  {
    this.teD = parama;
  }
  
  public final void a(cku paramcku)
  {
    AppMethodBeat.i(65465);
    if (!cIs()) {
      an.a(paramcku, 108, 1, 0, 0L, "");
    }
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = paramcku.xUH;
    if (this.teB == null) {}
    for (String str = "null";; str = this.teB.xUH)
    {
      ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot showTime new:%s, cur:%s, curTime:%s", new Object[] { Long.valueOf(l2), str, Long.valueOf(l1) });
      if (paramcku.xUH > cIj()) {
        break;
      }
      an.a(paramcku, 103, 1, 0, 0L, "");
      an.a(paramcku, 109, 1, 0, 0L, "r6|" + paramcku.xUH + "|" + cIj());
      AppMethodBeat.o(65465);
      return;
    }
    if (paramcku.xUH > 3600L + l1)
    {
      an.a(paramcku, 109, 1, 0, 0L, "r10|" + paramcku.xUH + "|" + l1);
      AppMethodBeat.o(65465);
      return;
    }
    if ((this.teB != null) && (!bo.isNullOrNil(this.teB.cDC)) && (this.teB.xUH > paramcku.xUH))
    {
      an.a(paramcku, 105, 1, 0, 0L, this.teB.cDC);
      an.a(paramcku, 109, 1, 0, 0L, "r9|" + paramcku.xUH + "|" + cIj());
      AppMethodBeat.o(65465);
      return;
    }
    if ((this.teB != null) && (!bo.isNullOrNil(this.teB.cDC))) {
      an.a(paramcku, 105, 1, 0, 0L, paramcku.cDC);
    }
    ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setTopStoryRedDot valid");
    this.teB = paramcku;
    g.RL().Ru().set(ac.a.yJC, d(this.teB));
    g.RL().Ru().dww();
    if (cIs()) {
      an.a(this.teB, 101, 1, 0, 0L, "");
    }
    if (this.teD != null) {
      this.teD.aI(this.teB.cDC, this.teB.xUH);
    }
    paramcku = new qf();
    com.tencent.mm.sdk.b.a.ymk.l(paramcku);
    AppMethodBeat.o(65465);
  }
  
  public final void b(e.a parama)
  {
    if (this.teD == parama) {
      this.teD = null;
    }
  }
  
  public final void b(cku paramcku)
  {
    AppMethodBeat.i(65466);
    ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", new Object[] { Integer.valueOf(paramcku.fQD) });
    if (!cIs()) {
      an.a(paramcku, 108, 2, this.teC.size(), 0L, "");
    }
    if (paramcku.fQD <= cIk())
    {
      ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", new Object[] { Integer.valueOf(paramcku.fQD), Integer.valueOf(cIk()) });
      an.a(paramcku, 103, 2, cIf(), 0L, "");
      an.a(paramcku, 109, 2, cIf(), 0L, "r6|" + paramcku.fQD + "|" + cIk());
      AppMethodBeat.o(65466);
      return;
    }
    label465:
    for (;;)
    {
      synchronized (this.teC)
      {
        if (!bo.es(this.teC))
        {
          i = 0;
          if (i >= this.teC.size()) {
            break label465;
          }
          cku localcku = (cku)this.teC.get(i);
          if (localcku.cDC.equals(paramcku.cDC))
          {
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
            an.a(paramcku, 109, 2, cIf(), 0L, "r11");
            AppMethodBeat.o(65466);
            return;
          }
          if (localcku.fQD > paramcku.fQD) {
            break label465;
          }
          i += 1;
          continue;
          this.teC.add(i, paramcku);
          if (cIs()) {
            an.a(cIg(), 101, 2, this.teC.size(), 0L, "");
          }
          ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", new Object[] { paramcku.cDC, Long.valueOf(paramcku.xUH) });
          cIb();
          if (this.teD != null) {
            this.teD.a(this.teC.size(), ((cku)this.teC.getFirst()).cDC, ((cku)this.teC.getLast()).cDC, ((cku)this.teC.getFirst()).fQD, ((cku)this.teC.getLast()).fQD, ((cku)this.teC.getLast()).extInfo);
          }
          paramcku = new qf();
          com.tencent.mm.sdk.b.a.ymk.l(paramcku);
          AppMethodBeat.o(65466);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final boolean cHX()
  {
    AppMethodBeat.i(65458);
    if (!cIt())
    {
      AppMethodBeat.o(65458);
      return false;
    }
    int i;
    if (bo.isNullOrNil(this.teB.cDC)) {
      i = -5;
    }
    while (i == 0)
    {
      if (!cIs()) {
        break label369;
      }
      AppMethodBeat.o(65458);
      return true;
      if (this.teB.xUI == 1)
      {
        i = -1;
      }
      else if (this.teB.uKe > d.whH)
      {
        ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.teB.cDC, Integer.valueOf(this.teB.uKe), Integer.valueOf(d.whH) });
        i = -2;
      }
      else
      {
        if (this.teB.fSm != 0L)
        {
          long l1 = this.teB.xUJ;
          long l2 = this.teB.fSm;
          if (System.currentTimeMillis() > l1 + l2 * 1000L)
          {
            ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { this.teB.cDC });
            i = -3;
            continue;
          }
        }
        boolean bool;
        if (aa.Jf(1) >= this.teB.uJc)
        {
          bool = true;
          label224:
          ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.teB.uJc), Integer.valueOf(aa.Jf(1)), Long.valueOf(this.teB.xUH), Long.valueOf(cIj()) });
          if ((aa.Jf(1) < this.teB.uJc) || (this.teB.xUH <= cIj())) {
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
      an.a(this.teB, 104, 1, 0, 0L, "");
      bOQ();
    }
    label369:
    AppMethodBeat.o(65458);
    return false;
  }
  
  public final boolean cHY()
  {
    AppMethodBeat.i(65459);
    if (!cIt())
    {
      AppMethodBeat.o(65459);
      return false;
    }
    if ((cku)this.teC.getLast() == null)
    {
      AppMethodBeat.o(65459);
      return false;
    }
    AppMethodBeat.o(65459);
    return true;
  }
  
  public final cku cHZ()
  {
    return this.teB;
  }
  
  public final void cIa()
  {
    AppMethodBeat.i(65462);
    if (this.teB != null) {
      an.a(this.teB.cDC, this.teB.xUH, 1, 0, "", 0);
    }
    AppMethodBeat.o(65462);
  }
  
  public final boolean cId()
  {
    if (this.teB != null) {
      return this.teB.uKf == 1;
    }
    return false;
  }
  
  public final int cIe()
  {
    AppMethodBeat.i(65472);
    if (!cIt())
    {
      ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(65472);
      return 0;
    }
    ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(this.teC.size()) });
    int i = this.teC.size();
    AppMethodBeat.o(65472);
    return i;
  }
  
  public final cku cIg()
  {
    AppMethodBeat.i(65474);
    synchronized (this.teC)
    {
      if (bo.es(this.teC))
      {
        AppMethodBeat.o(65474);
        return null;
      }
      cku localcku = (cku)this.teC.getLast();
      AppMethodBeat.o(65474);
      return localcku;
    }
  }
  
  public final cku cIh()
  {
    AppMethodBeat.i(65475);
    synchronized (this.teC)
    {
      if (bo.es(this.teC))
      {
        AppMethodBeat.o(65475);
        return null;
      }
      cku localcku = (cku)this.teC.getFirst();
      AppMethodBeat.o(65475);
      return localcku;
    }
  }
  
  public final boolean cIi()
  {
    AppMethodBeat.i(65478);
    if (!bo.es(this.teC))
    {
      if (((cku)this.teC.getLast()).uKf == 1)
      {
        AppMethodBeat.o(65478);
        return true;
      }
      AppMethodBeat.o(65478);
      return false;
    }
    AppMethodBeat.o(65478);
    return false;
  }
  
  public final boolean cIl()
  {
    AppMethodBeat.i(65482);
    if (!bo.isNullOrNil((String)g.RL().Ru().get(ac.a.yKL, "")))
    {
      AppMethodBeat.o(65482);
      return true;
    }
    AppMethodBeat.o(65482);
    return false;
  }
  
  public final String cIm()
  {
    AppMethodBeat.i(65483);
    String str = (String)g.RL().Ru().get(ac.a.yKL, "");
    AppMethodBeat.o(65483);
    return str;
  }
  
  public final void cIn()
  {
    AppMethodBeat.i(65484);
    cku localcku = new cku();
    localcku.cDC = cIm();
    an.a(localcku, 106, 3, 0, 0L, "");
    aed("");
    AppMethodBeat.o(65484);
  }
  
  public final String cIo()
  {
    AppMethodBeat.i(65486);
    String str = (String)g.RL().Ru().get(ac.a.yKM, "");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(65486);
      return "";
    }
    try
    {
      str = new JSONObject(str).optString("msgId", "");
      AppMethodBeat.o(65486);
      return str;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(65486);
    }
    return "";
  }
  
  public final long cIp()
  {
    AppMethodBeat.i(65487);
    String str = (String)g.RL().Ru().get(ac.a.yKM, "");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(65487);
      return 0L;
    }
    try
    {
      int i = new JSONObject(str).optInt("ts", 0);
      long l = i;
      AppMethodBeat.o(65487);
      return l;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(65487);
    }
    return 0L;
  }
  
  public final String cIq()
  {
    AppMethodBeat.i(65488);
    String str = (String)g.RL().Ru().get(ac.a.yKM, "");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(65488);
      return "";
    }
    try
    {
      str = new JSONObject(str).optString("extInfo");
      AppMethodBeat.o(65488);
      return str;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(65488);
    }
    return "";
  }
  
  public final void cIr()
  {
    AppMethodBeat.i(65489);
    o("", "", 0L);
    AppMethodBeat.o(65489);
  }
  
  public final boolean cIs()
  {
    AppMethodBeat.i(65490);
    JSONObject localJSONObject = ac.agv("discoverRecommendEntry");
    boolean bool;
    if (((com.tencent.mm.plugin.welab.a.a.a)g.E(com.tencent.mm.plugin.welab.a.a.a.class)).ajx("labs_browse"))
    {
      if (!((com.tencent.mm.plugin.welab.a.a.a)g.E(com.tencent.mm.plugin.welab.a.a.a.class)).yi("labs_browse")) {
        break label98;
      }
      bool = true;
    }
    for (;;)
    {
      ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recommend show %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(65490);
      return bool;
      if (localJSONObject.optInt("entrySwitch") == 1) {
        bool = true;
      } else {
        label98:
        bool = false;
      }
    }
  }
  
  public final boolean cIt()
  {
    AppMethodBeat.i(65491);
    if (((d.whH >= 654311424) || (d.whL)) && (bo.isNullOrNil(this.teH))) {
      this.teH = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTR, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.teH).getJSONArray("tabs");
      int i = 0;
      while (i < localJSONArray.length())
      {
        int j = localJSONArray.getJSONObject(i).getInt("category");
        if (j == 110)
        {
          AppMethodBeat.o(65491);
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.TopStory.TopStoryRedDotImpl", "parse tabconfig failed: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(65491);
    }
  }
  
  public final void h(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(65477);
    a(paramLong, paramBoolean, paramInt, true);
    AppMethodBeat.o(65477);
  }
  
  public final void na(long paramLong)
  {
    AppMethodBeat.i(65464);
    B(paramLong, true);
    AppMethodBeat.o(65464);
  }
  
  public final void o(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(65485);
    ab.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgId", paramString1);
      localJSONObject.put("extInfo", paramString2);
      localJSONObject.put("ts", paramLong);
      g.RL().Ru().set(ac.a.yKM, localJSONObject.toString());
      g.RL().Ru().dww();
      if ((!bo.isNullOrNil(paramString1)) && (this.teD != null)) {
        this.teD.aJ(paramString1, paramLong);
      }
      AppMethodBeat.o(65485);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", paramString2, "setUserIconRedDot error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b
 * JD-Core Version:    0.7.0.1
 */