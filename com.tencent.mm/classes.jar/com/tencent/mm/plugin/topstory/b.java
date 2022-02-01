package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.uv;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ess;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements e
{
  private final String MVA;
  private final String MVB;
  com.tencent.mm.plugin.messenger.foundation.a.t MVC;
  private com.tencent.mm.plugin.topstory.a.c.b MVD;
  private ess MVw;
  private ess MVx;
  private LinkedList<ess> MVy;
  private e.a MVz;
  private i jxB;
  
  public b()
  {
    AppMethodBeat.i(88420);
    this.MVy = new LinkedList();
    this.MVA = ".sysmsg.mmsearch_reddot_new.";
    this.MVB = "sub_reddot";
    this.MVC = new com.tencent.mm.plugin.messenger.foundation.a.t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(88417);
        if ((paramAnonymousMap != null) && (paramAnonymousString != null) && (paramAnonymousString.equals("mmsearch_reddot_new"))) {
          b.a(b.this, paramAnonymousMap, "");
        }
        AppMethodBeat.o(88417);
      }
    };
    this.jxB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(88418);
        if (paramAnonymousq.equals(b.a(b.this)))
        {
          h.aGY().b(b.a(b.this).getType(), this);
          b.b(b.this);
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.b)paramAnonymousq;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
            AppMethodBeat.o(88418);
          }
        }
        else
        {
          AppMethodBeat.o(88418);
          return;
        }
        h.aHG().aHp().set(ar.a.Vvf, paramAnonymousString.gpU().Tkw);
        h.aHG().aHp().hxT();
        paramAnonymousString = new uv();
        EventCenter.instance.publish(paramAnonymousString);
        AppMethodBeat.o(88418);
      }
    };
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.MVC);
    this.MVx = new ess();
    e(this.MVx);
    ess localess = this.MVx;
    Object localObject = (String)h.aHG().aHp().get(ar.a.Vum, "");
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label230;
      }
    }
    try
    {
      if (localObject.length >= 13)
      {
        a(localess, (String[])localObject);
        this.MVw = new ess();
        e(this.MVw);
        localess = this.MVw;
        localObject = (String)h.aHG().aHp().get(ar.a.VvI, "");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = ((String)localObject).split(",");
          if (localObject == null) {
            break label283;
          }
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        if (localObject.length >= 13) {
          a(localess, (String[])localObject);
        }
        for (;;)
        {
          gpn();
          AppMethodBeat.o(88420);
          return;
          label230:
          h.aHG().aHp().set(ar.a.Vum, "");
          h.aHG().aHp().hxT();
          break;
          localException1 = localException1;
          h.aHG().aHp().set(ar.a.Vum, "");
          h.aHG().aHp().hxT();
          break;
          label283:
          h.aHG().aHp().set(ar.a.VvI, "");
          h.aHG().aHp().hxT();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          h.aHG().aHp().set(ar.a.VvI, "");
          h.aHG().aHp().hxT();
        }
      }
    }
  }
  
  private void N(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(262025);
    if ((this.MVx == null) || (Util.isNullOrNil(this.MVx.msgId)))
    {
      AppMethodBeat.o(262025);
      return;
    }
    long l = cm.bfE() / 1000L;
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if ((paramLong < gpu()) || (paramLong <= 0L) || (l + 3600L < paramLong))
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", new Object[] { Long.valueOf(gpu()) });
      AppMethodBeat.o(262025);
      return;
    }
    if ((this.MVx != null) && (paramLong < this.MVx.Uuu))
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", new Object[] { Long.valueOf(this.MVx.Uuu) });
      AppMethodBeat.o(262025);
      return;
    }
    if (paramBoolean) {
      ar.a(this.MVx, 106, 1, 0, paramLong, "");
    }
    gpi();
    h.aHG().aHp().set(ar.a.Vuj, Long.valueOf(paramLong));
    h.aHG().aHp().hxT();
    AppMethodBeat.o(262025);
  }
  
  private static void Se(long paramLong)
  {
    AppMethodBeat.i(262028);
    h.aHG().aHp().set(ar.a.Vuk, Long.valueOf(paramLong));
    h.aHG().aHp().hxT();
    AppMethodBeat.o(262028);
  }
  
  private int a(ess paramess, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(262045);
    if (Util.isNullOrNil(paramess.msgId))
    {
      AppMethodBeat.o(262045);
      return -5;
    }
    if (paramess.Uuv == 1)
    {
      AppMethodBeat.o(262045);
      return -1;
    }
    if (paramess.PzG > d.RAD)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { paramess.msgId, Integer.valueOf(paramess.PzG), Integer.valueOf(d.RAD) });
      AppMethodBeat.o(262045);
      return -2;
    }
    if (paramess.mcX != 0L)
    {
      long l1 = paramess.Uuw;
      long l2 = paramess.mcX;
      if (System.currentTimeMillis() > l1 + l2 * 1000L)
      {
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { paramess.msgId });
        AppMethodBeat.o(262045);
        return -3;
      }
    }
    boolean bool;
    int i;
    if (ai.anh(1) >= paramess.Pyz)
    {
      bool = true;
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramess.Pyz), Integer.valueOf(ai.anh(1)), Long.valueOf(paramess.Uuu), Long.valueOf(gpu()) });
      if (ai.anh(1) < paramess.Pyz) {
        break label289;
      }
      i = 1;
      label244:
      if (110 != paramInt) {
        break label306;
      }
      if ((i == 0) || (this.MVx.Uuu <= gpu())) {
        break label294;
      }
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(262045);
        return -4;
        bool = false;
        break;
        label289:
        i = 0;
        break label244;
        label294:
        paramInt = 0;
        continue;
      }
      AppMethodBeat.o(262045);
      return 0;
      label306:
      paramInt = i;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(88441);
    if (this.MVy.size() == 0)
    {
      AppMethodBeat.o(88441);
      return;
    }
    if (paramInt <= gpv())
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gpv()) });
      AppMethodBeat.o(88441);
      return;
    }
    int i = this.MVy.size();
    Object localObject2 = this.MVy;
    String str = "";
    for (;;)
    {
      try
      {
        if ((this.MVy.size() > 0) && (((ess)this.MVy.getFirst()).mbp <= paramInt))
        {
          str = ((ess)this.MVy.getFirst()).msgId;
          this.MVy.removeFirst();
          continue;
        }
        if (i != this.MVy.size()) {
          gpk();
        }
        if (this.MVz != null)
        {
          if (this.MVy.size() > 0) {
            this.MVz.a(this.MVy.size(), ((ess)this.MVy.getFirst()).msgId, ((ess)this.MVy.getLast()).msgId, ((ess)this.MVy.getFirst()).mbp, ((ess)this.MVy.getLast()).mbp, ((ess)this.MVy.getLast()).extInfo, paramBoolean1);
          }
        }
        else
        {
          if (paramBoolean2)
          {
            localObject2 = new ess();
            ((ess)localObject2).msgId = str;
            ((ess)localObject2).Uuu = paramLong;
            ((ess)localObject2).mbp = paramInt;
            ar.a((ess)localObject2, 106, 2, i, paramLong, "");
          }
          Se(paramLong);
          ajs(paramInt);
          AppMethodBeat.o(88441);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(88441);
      }
      this.MVz.a(0, "", "", 0, 0, "", paramBoolean1);
    }
  }
  
  private void a(ess paramess)
  {
    AppMethodBeat.i(262021);
    switch (paramess.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(262021);
      return;
      N(paramess.Uuu, false);
      paramess = new uv();
      EventCenter.instance.publish(paramess);
      AppMethodBeat.o(262021);
      return;
      r("", "", 0L);
      AppMethodBeat.o(262021);
      return;
      a(paramess.Uuu, true, paramess.mbp, false);
      paramess = new uv();
      EventCenter.instance.publish(paramess);
      AppMethodBeat.o(262021);
      return;
      gpl();
      paramess = new uv();
      EventCenter.instance.publish(paramess);
    }
  }
  
  private static void a(ess paramess, String[] paramArrayOfString)
  {
    AppMethodBeat.i(88435);
    paramess.msgId = paramArrayOfString[0];
    paramess.Uuv = Integer.valueOf(paramArrayOfString[1]).intValue();
    paramess.PzG = Integer.valueOf(paramArrayOfString[2]).intValue();
    paramess.PzH = Integer.valueOf(paramArrayOfString[3]).intValue();
    paramess.PzF = Integer.valueOf(paramArrayOfString[4]).intValue();
    paramess.mcX = Long.valueOf(paramArrayOfString[5]).longValue();
    paramess.Pyz = Integer.valueOf(paramArrayOfString[6]).intValue();
    paramess.Uuw = Long.valueOf(paramArrayOfString[7]).longValue();
    paramess.text = paramArrayOfString[8];
    paramess.type = Integer.valueOf(paramArrayOfString[9]).intValue();
    paramess.showFlag = Integer.valueOf(paramArrayOfString[10]).intValue();
    paramess.Uuu = Long.valueOf(paramArrayOfString[11]).longValue();
    paramess.icon = paramArrayOfString[12];
    if (paramArrayOfString.length > 13) {
      paramess.mbp = Integer.valueOf(paramArrayOfString[13]).intValue();
    }
    while (paramArrayOfString.length > 14)
    {
      paramess.extInfo = paramArrayOfString[14];
      AppMethodBeat.o(88435);
      return;
      paramess.mbp = 0;
      if (paramess.type == 7) {
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
      }
    }
    paramess.extInfo = "";
    AppMethodBeat.o(88435);
  }
  
  private static void ajs(int paramInt)
  {
    AppMethodBeat.i(262029);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", new Object[] { Integer.valueOf(paramInt) });
    h.aHG().aHp().set(ar.a.Vul, Integer.valueOf(paramInt));
    h.aHG().aHp().hxT();
    AppMethodBeat.o(262029);
  }
  
  private static void b(ess paramess)
  {
    AppMethodBeat.i(262030);
    if (!Util.isNullOrNil(paramess.extInfo))
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateInitTab %s", new Object[] { paramess.extInfo });
      try
      {
        if (new JSONObject(paramess.extInfo).optBoolean("has_wow_contents", true))
        {
          h.aHG().aHp().set(ar.a.VvL, Integer.valueOf(1));
          AppMethodBeat.o(262030);
          return;
        }
        h.aHG().aHp().set(ar.a.VvL, Integer.valueOf(0));
        AppMethodBeat.o(262030);
        return;
      }
      catch (Exception paramess) {}
    }
    AppMethodBeat.o(262030);
  }
  
  private void c(ess paramess)
  {
    AppMethodBeat.i(88429);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", new Object[] { Integer.valueOf(paramess.mbp) });
    if (!gpE()) {
      ar.a(paramess, 108, 2, this.MVy.size(), 0L, "");
    }
    if (paramess.mbp <= gpv())
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", new Object[] { Integer.valueOf(paramess.mbp), Integer.valueOf(gpv()) });
      ar.a(paramess, 103, 2, gpq(), 0L, "");
      ar.a(paramess, 109, 2, gpq(), 0L, "r6|" + paramess.mbp + "|" + gpv());
      AppMethodBeat.o(88429);
      return;
    }
    label465:
    for (;;)
    {
      synchronized (this.MVy)
      {
        if (!Util.isNullOrNil(this.MVy))
        {
          i = 0;
          if (i >= this.MVy.size()) {
            break label465;
          }
          ess localess = (ess)this.MVy.get(i);
          if (localess.msgId.equals(paramess.msgId))
          {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
            ar.a(paramess, 109, 2, gpq(), 0L, "r11");
            AppMethodBeat.o(88429);
            return;
          }
          if (localess.mbp > paramess.mbp) {
            break label465;
          }
          i += 1;
          continue;
          this.MVy.add(i, paramess);
          if (gpE()) {
            ar.a(gpr(), 101, 2, this.MVy.size(), 0L, "");
          }
          Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", new Object[] { paramess.msgId, Long.valueOf(paramess.Uuu) });
          gpk();
          if (this.MVz != null) {
            this.MVz.a(this.MVy.size(), ((ess)this.MVy.getFirst()).msgId, ((ess)this.MVy.getLast()).msgId, ((ess)this.MVy.getFirst()).mbp, ((ess)this.MVy.getLast()).mbp, ((ess)this.MVy.getLast()).extInfo);
          }
          paramess = new uv();
          EventCenter.instance.publish(paramess);
          AppMethodBeat.o(88429);
          return;
        }
      }
      int i = 0;
    }
  }
  
  private void d(ess paramess)
  {
    AppMethodBeat.i(262036);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", new Object[] { paramess.msgId });
    if (!gpE()) {
      ar.a(paramess, 108, 1, 0, 0L, "");
    }
    this.MVw = paramess;
    h.aHG().aHp().set(ar.a.VvI, f(this.MVw));
    h.aHG().aHp().hxT();
    ar.a(paramess, 101, 3, 0, 0L, "");
    if (this.MVz != null) {
      this.MVz.b(this.MVw, 100);
    }
    paramess = new uv();
    EventCenter.instance.publish(paramess);
    AppMethodBeat.o(262036);
  }
  
  private static void e(ess paramess)
  {
    paramess.icon = "";
    paramess.msgId = "";
    paramess.text = "";
  }
  
  private static String f(ess paramess)
  {
    AppMethodBeat.i(88434);
    paramess = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramess.msgId, Integer.valueOf(paramess.Uuv), Integer.valueOf(paramess.PzG), Integer.valueOf(paramess.PzH), Integer.valueOf(paramess.PzF), Long.valueOf(paramess.mcX), Integer.valueOf(paramess.Pyz), Long.valueOf(paramess.Uuw), paramess.text, Integer.valueOf(paramess.type), Integer.valueOf(paramess.showFlag), Long.valueOf(paramess.Uuu), paramess.icon, Integer.valueOf(paramess.mbp), paramess.extInfo });
    AppMethodBeat.o(88434);
    return paramess;
  }
  
  private void gpi()
  {
    AppMethodBeat.i(262018);
    this.MVx = new ess();
    e(this.MVx);
    h.aHG().aHp().set(ar.a.Vum, "");
    h.aHG().aHp().hxT();
    if (this.MVz != null)
    {
      e.a locala = this.MVz;
      gpu();
      locala.gpJ();
    }
    AppMethodBeat.o(262018);
  }
  
  private void gpk()
  {
    AppMethodBeat.i(88430);
    synchronized (this.MVy)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.MVy.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(f((ess)localIterator.next())).append(";");
      }
    }
    h.aHG().aHp().set(ar.a.VvH, localObject.toString());
    h.aHG().aHp().hxT();
    AppMethodBeat.o(88430);
  }
  
  private void gpl()
  {
    AppMethodBeat.i(88432);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
    this.MVw = new ess();
    e(this.MVw);
    h.aHG().aHp().set(ar.a.VvI, "");
    h.aHG().aHp().hxT();
    AppMethodBeat.o(88432);
  }
  
  private void gpn()
  {
    AppMethodBeat.i(88436);
    Object localObject1 = (String)h.aHG().aHp().get(ar.a.VvH, "");
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(";");
      try
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject2 = ((String)localObject2).split(",");
            ess localess = new ess();
            a(localess, (String[])localObject2);
            this.MVy.addLast(localess);
          }
          i += 1;
        }
        AppMethodBeat.o(88436);
        return;
      }
      catch (Exception localException)
      {
        h.aHG().aHp().set(ar.a.VvH, "");
        h.aHG().aHp().hxT();
      }
    }
    AppMethodBeat.o(88436);
  }
  
  private int gpq()
  {
    AppMethodBeat.i(88438);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(this.MVy.size()) });
    int i = this.MVy.size();
    AppMethodBeat.o(88438);
    return i;
  }
  
  private static long gpu()
  {
    AppMethodBeat.i(88445);
    Object localObject = h.aHG().aHp().get(ar.a.Vuj, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88445);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(88445);
    return l;
  }
  
  private static int gpv()
  {
    AppMethodBeat.i(88446);
    Object localObject = h.aHG().aHp().get(ar.a.Vul, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88446);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(88446);
    return i;
  }
  
  private void r(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(88450);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgId", paramString1);
      localJSONObject.put("extInfo", paramString2);
      localJSONObject.put("ts", paramLong);
      h.aHG().aHp().set(ar.a.VvJ, localJSONObject.toString());
      h.aHG().aHp().hxT();
      if ((!Util.isNullOrNil(paramString1)) && (this.MVz != null)) {
        this.MVz.by(paramString1, paramLong);
      }
      AppMethodBeat.o(88450);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryRedDotImpl", paramString2, "setUserIconRedDot error", new Object[0]);
      }
    }
  }
  
  public final void Sd(long paramLong)
  {
    AppMethodBeat.i(262027);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateHaokanRedDotTimestamp %s", new Object[] { Long.valueOf(paramLong) });
    N(paramLong, true);
    AppMethodBeat.o(262027);
  }
  
  public final void a(e.a parama)
  {
    this.MVz = parama;
  }
  
  public final int ajt(int paramInt)
  {
    AppMethodBeat.i(262071);
    if (gpp() > 0)
    {
      AppMethodBeat.o(262071);
      return 110;
    }
    if ((gpg()) && (gpw()))
    {
      if (this.MVw.priority > this.MVx.priority)
      {
        AppMethodBeat.o(262071);
        return 100;
      }
      if (this.MVw.priority < this.MVx.priority)
      {
        AppMethodBeat.o(262071);
        return 110;
      }
      if (this.MVw.Uuw > this.MVx.Uuw)
      {
        AppMethodBeat.o(262071);
        return 100;
      }
      if (this.MVw.Uuw < this.MVx.Uuw)
      {
        AppMethodBeat.o(262071);
        return 110;
      }
      AppMethodBeat.o(262071);
      return paramInt;
    }
    if (gpg())
    {
      AppMethodBeat.o(262071);
      return 110;
    }
    if (gpw())
    {
      AppMethodBeat.o(262071);
      return 100;
    }
    AppMethodBeat.o(262071);
    return paramInt;
  }
  
  public final void b(e.a parama)
  {
    if (this.MVz == parama) {
      this.MVz = null;
    }
  }
  
  public final String gpA()
  {
    AppMethodBeat.i(88451);
    String str = (String)h.aHG().aHp().get(ar.a.VvJ, "");
    if (Util.isNullOrNil(str))
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
  
  public final long gpB()
  {
    AppMethodBeat.i(88452);
    String str = (String)h.aHG().aHp().get(ar.a.VvJ, "");
    if (Util.isNullOrNil(str))
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
  
  public final String gpC()
  {
    AppMethodBeat.i(88453);
    String str = (String)h.aHG().aHp().get(ar.a.VvJ, "");
    if (Util.isNullOrNil(str))
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
  
  public final void gpD()
  {
    AppMethodBeat.i(88454);
    r("", "", 0L);
    AppMethodBeat.o(88454);
  }
  
  public final boolean gpE()
  {
    AppMethodBeat.i(88455);
    long l = z.bde();
    if ((0x4000000 & l) == 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      boolean bool3 = com.tencent.mm.az.b.WF((String)h.aHG().aHp().b(274436, null));
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "isShowRecEntry %s %s %s %s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool1) || (bool2) || (bool3)) {
        break;
      }
      AppMethodBeat.o(88455);
      return true;
    }
    AppMethodBeat.o(88455);
    return false;
  }
  
  public final boolean gpF()
  {
    AppMethodBeat.i(262073);
    long l = h.aHG().aHp().a(ar.a.Vuv, 0L);
    if (this.MVx.Uuw < l)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHaokanFindMoreEntryRedDot already click find more entry");
      AppMethodBeat.o(262073);
      return false;
    }
    AppMethodBeat.o(262073);
    return true;
  }
  
  public final boolean gpG()
  {
    AppMethodBeat.i(262074);
    long l = h.aHG().aHp().a(ar.a.Vuv, 0L);
    if (this.MVw.Uuw < l)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHomeFindMoreEntryRedDot already click find more entry");
      AppMethodBeat.o(262074);
      return false;
    }
    AppMethodBeat.o(262074);
    return true;
  }
  
  public final void gpH()
  {
    AppMethodBeat.i(262075);
    h.aHG().aHp().set(ar.a.Vuv, Long.valueOf(cm.bfE()));
    AppMethodBeat.o(262075);
  }
  
  public final void gpI()
  {
    AppMethodBeat.i(262078);
    if (gpp() > 0)
    {
      ess localess = gpr();
      if (localess != null) {
        ar.a(localess.msgId, localess.Uuu, 2, gpp(), "", localess.mbp);
      }
      AppMethodBeat.o(262078);
      return;
    }
    if ((gpg()) && (gpw()))
    {
      if (this.MVw.priority > this.MVx.priority)
      {
        ar.a(this.MVw.msgId, this.MVw.Uuu, 1, 0, "", 0);
        AppMethodBeat.o(262078);
        return;
      }
      if (this.MVw.priority < this.MVx.priority)
      {
        ar.a(this.MVx.msgId, this.MVx.Uuu, 1, 0, "", 0);
        AppMethodBeat.o(262078);
        return;
      }
      if (this.MVw.Uuw > this.MVx.Uuw)
      {
        ar.a(this.MVw.msgId, this.MVw.Uuu, 1, 0, "", 0);
        AppMethodBeat.o(262078);
        return;
      }
      if (this.MVw.Uuw < this.MVx.Uuw)
      {
        ar.a(this.MVx.msgId, this.MVx.Uuu, 1, 0, "", 0);
        AppMethodBeat.o(262078);
        return;
      }
      ar.a(this.MVx.msgId, this.MVx.Uuu, 1, 0, "", 0);
      AppMethodBeat.o(262078);
      return;
    }
    if (gpg())
    {
      ar.a(this.MVx.msgId, this.MVx.Uuu, 1, 0, "", 0);
      AppMethodBeat.o(262078);
      return;
    }
    if (gpw()) {
      ar.a(this.MVw.msgId, this.MVw.Uuu, 1, 0, "", 0);
    }
    AppMethodBeat.o(262078);
  }
  
  public final boolean gpg()
  {
    AppMethodBeat.i(262013);
    int i = a(this.MVx, 110);
    if (i == 0)
    {
      if (gpE())
      {
        AppMethodBeat.o(262013);
        return true;
      }
    }
    else if (i == -3)
    {
      ar.a(this.MVx, 104, 1, 0, 0L, "");
      gpi();
    }
    AppMethodBeat.o(262013);
    return false;
  }
  
  public final boolean gph()
  {
    AppMethodBeat.i(88422);
    if ((ess)this.MVy.getLast() == null)
    {
      AppMethodBeat.o(88422);
      return false;
    }
    AppMethodBeat.o(88422);
    return true;
  }
  
  public final ess gpj()
  {
    return this.MVx;
  }
  
  public final ess gpm()
  {
    return this.MVw;
  }
  
  public final boolean gpo()
  {
    if (this.MVx != null) {
      return this.MVx.PzH == 1;
    }
    return false;
  }
  
  public final int gpp()
  {
    AppMethodBeat.i(88437);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(this.MVy.size()) });
    int i = this.MVy.size();
    AppMethodBeat.o(88437);
    return i;
  }
  
  public final ess gpr()
  {
    AppMethodBeat.i(88439);
    synchronized (this.MVy)
    {
      if (Util.isNullOrNil(this.MVy))
      {
        AppMethodBeat.o(88439);
        return null;
      }
      ess localess = (ess)this.MVy.getLast();
      AppMethodBeat.o(88439);
      return localess;
    }
  }
  
  public final ess gps()
  {
    AppMethodBeat.i(88440);
    synchronized (this.MVy)
    {
      if (Util.isNullOrNil(this.MVy))
      {
        AppMethodBeat.o(88440);
        return null;
      }
      ess localess = (ess)this.MVy.getFirst();
      AppMethodBeat.o(88440);
      return localess;
    }
  }
  
  public final boolean gpt()
  {
    AppMethodBeat.i(88443);
    if (!Util.isNullOrNil(this.MVy))
    {
      if (((ess)this.MVy.getLast()).PzH == 1)
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
  
  public final boolean gpw()
  {
    AppMethodBeat.i(88447);
    int i = a(this.MVw, 100);
    if (i == 0)
    {
      if (gpE())
      {
        AppMethodBeat.o(88447);
        return true;
      }
    }
    else if (i == -3)
    {
      ar.a(this.MVw, 104, 1, 0, 0L, "");
      gpl();
    }
    AppMethodBeat.o(88447);
    return false;
  }
  
  public final String gpx()
  {
    AppMethodBeat.i(88448);
    String str = this.MVw.msgId;
    AppMethodBeat.o(88448);
    return str;
  }
  
  public final void gpy()
  {
    AppMethodBeat.i(88449);
    ess localess = new ess();
    localess.msgId = this.MVw.msgId;
    ar.a(localess, 106, 3, 0, 0L, "");
    gpl();
    AppMethodBeat.o(88449);
  }
  
  public final void gpz()
  {
    AppMethodBeat.i(262059);
    ess localess1 = new ess();
    ess localess2 = this.MVx;
    if (localess2 != null) {
      localess1.msgId = localess2.msgId;
    }
    ar.a(localess1, 106, 1, 0, 0L, "");
    gpi();
    AppMethodBeat.o(262059);
  }
  
  public final void j(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(88442);
    a(paramLong, paramBoolean, paramInt, true);
    AppMethodBeat.o(88442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b
 * JD-Core Version:    0.7.0.1
 */