package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.wl;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.topstory.a.d.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.protocal.protobuf.fob;
import com.tencent.mm.protocal.protobuf.ghu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  implements com.tencent.mm.plugin.topstory.a.d
{
  private fob THY;
  private fob THZ;
  private fob TIa;
  private LinkedList<fob> TIb;
  private d.a TIc;
  private final String TId;
  private final String TIe;
  t TIf;
  private com.tencent.mm.plugin.topstory.a.c.b TIg;
  private com.tencent.mm.am.h maV;
  
  public c()
  {
    AppMethodBeat.i(88420);
    this.TIb = new LinkedList();
    this.TId = ".sysmsg.mmsearch_reddot_new.";
    this.TIe = "sub_reddot";
    this.TIf = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(88417);
        if ((paramAnonymousMap != null) && (paramAnonymousString != null) && (paramAnonymousString.equals("mmsearch_reddot_new"))) {
          c.a(c.this, paramAnonymousMap, "");
        }
        AppMethodBeat.o(88417);
      }
    };
    this.maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(88418);
        if (paramAnonymousp.equals(c.a(c.this)))
        {
          com.tencent.mm.kernel.h.aZW().b(c.a(c.this).getType(), this);
          c.b(c.this);
          paramAnonymousString = (com.tencent.mm.plugin.topstory.a.c.b)paramAnonymousp;
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
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWO, paramAnonymousString.hMQ().aayd);
        com.tencent.mm.kernel.h.baE().ban().iZy();
        new wl().publish();
        AppMethodBeat.o(88418);
      }
    };
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.TIf);
    this.THZ = new fob();
    e(this.THZ);
    fob localfob = this.THZ;
    Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVV, "");
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject == null) {
        break label301;
      }
    }
    try
    {
      if (localObject.length >= 13)
      {
        a(localfob, (String[])localObject);
        this.THY = new fob();
        e(this.THY);
        localfob = this.THY;
        localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXr, "");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = ((String)localObject).split(",");
          if (localObject == null) {
            break label354;
          }
        }
      }
    }
    catch (Exception localException2)
    {
      try
      {
        if (localObject.length >= 13)
        {
          a(localfob, (String[])localObject);
          label220:
          this.TIa = new fob();
          e(this.TIa);
          localfob = this.TIa;
          localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXs, "");
          if (!Util.isNullOrNil((String)localObject))
          {
            localObject = ((String)localObject).split(",");
            if (localObject == null) {
              break label407;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          if (localObject.length >= 13) {
            a(localfob, (String[])localObject);
          }
          for (;;)
          {
            hMd();
            AppMethodBeat.o(88420);
            return;
            label301:
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acVV, "");
            com.tencent.mm.kernel.h.baE().ban().iZy();
            break;
            localException1 = localException1;
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acVV, "");
            com.tencent.mm.kernel.h.baE().ban().iZy();
            break;
            label354:
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acXr, "");
            com.tencent.mm.kernel.h.baE().ban().iZy();
            break label220;
            localException2 = localException2;
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acXr, "");
            com.tencent.mm.kernel.h.baE().ban().iZy();
            break label220;
            label407:
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acXs, "");
            com.tencent.mm.kernel.h.baE().ban().iZy();
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acXs, "");
            com.tencent.mm.kernel.h.baE().ban().iZy();
          }
        }
      }
    }
  }
  
  private void Y(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(271645);
    if ((this.THZ == null) || (Util.isNullOrNil(this.THZ.msgId)))
    {
      AppMethodBeat.o(271645);
      return;
    }
    long l = cn.bDw() / 1000L;
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d, cur %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    if ((paramLong < hMk()) || (paramLong <= 0L) || (l + 3600L < paramLong))
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, getRedDotTimestamp:%s", new Object[] { Long.valueOf(hMk()) });
      AppMethodBeat.o(271645);
      return;
    }
    if ((this.THZ != null) && (paramLong < this.THZ.UGO))
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateRedDotTimestamp invalid, showTime:%s", new Object[] { Long.valueOf(this.THZ.UGO) });
      AppMethodBeat.o(271645);
      return;
    }
    if (paramBoolean) {
      as.a(this.THZ, 106, 1, 0, paramLong, "");
    }
    hLU();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVS, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baE().ban().iZy();
    AppMethodBeat.o(271645);
  }
  
  private int a(fob paramfob, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(271691);
    if (Util.isNullOrNil(paramfob.msgId))
    {
      AppMethodBeat.o(271691);
      return -5;
    }
    if (paramfob.abNX == 1)
    {
      AppMethodBeat.o(271691);
      return -1;
    }
    if (paramfob.WpO > com.tencent.mm.protocal.d.Yxh)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { paramfob.msgId, Integer.valueOf(paramfob.WpO), Integer.valueOf(com.tencent.mm.protocal.d.Yxh) });
      AppMethodBeat.o(271691);
      return -2;
    }
    if (paramfob.ofU != 0L)
    {
      long l1 = paramfob.abNY;
      long l2 = paramfob.ofU;
      if (System.currentTimeMillis() > l1 + l2 * 1000L)
      {
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[] { paramfob.msgId });
        AppMethodBeat.o(271691);
        return -3;
      }
    }
    boolean bool;
    int i;
    if (aj.asY(1) >= paramfob.WoG)
    {
      bool = true;
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramfob.WoG), Integer.valueOf(aj.asY(1)), Long.valueOf(paramfob.UGO), Long.valueOf(hMk()) });
      if (aj.asY(1) < paramfob.WoG) {
        break label289;
      }
      i = 1;
      label244:
      if (110 != paramInt) {
        break label306;
      }
      if ((i == 0) || (this.THZ.UGO <= hMk())) {
        break label294;
      }
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(271691);
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
      AppMethodBeat.o(271691);
      return 0;
      label306:
      paramInt = i;
    }
  }
  
  private int a(fob paramfob1, fob paramfob2, int paramInt)
  {
    AppMethodBeat.i(271703);
    if (paramfob1.priority > paramfob2.priority)
    {
      paramInt = g(paramfob1);
      AppMethodBeat.o(271703);
      return paramInt;
    }
    if (paramfob1.priority < paramfob2.priority)
    {
      paramInt = g(paramfob2);
      AppMethodBeat.o(271703);
      return paramInt;
    }
    if (paramfob1.abNY > paramfob2.abNY)
    {
      paramInt = g(paramfob1);
      AppMethodBeat.o(271703);
      return paramInt;
    }
    if (paramfob1.abNY < paramfob2.abNY)
    {
      paramInt = g(paramfob2);
      AppMethodBeat.o(271703);
      return paramInt;
    }
    AppMethodBeat.o(271703);
    return paramInt;
  }
  
  private void a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(88441);
    if (this.TIb.size() == 0)
    {
      AppMethodBeat.o(88441);
      return;
    }
    if (paramInt <= hMl())
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickCmtRedDot invalid, seq:%s, curSeq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hMl()) });
      AppMethodBeat.o(88441);
      return;
    }
    int i = this.TIb.size();
    Object localObject2 = this.TIb;
    String str = "";
    for (;;)
    {
      try
      {
        if ((this.TIb.size() > 0) && (((fob)this.TIb.getFirst()).oUj <= paramInt))
        {
          str = ((fob)this.TIb.getFirst()).msgId;
          this.TIb.removeFirst();
          continue;
        }
        if (i != this.TIb.size()) {
          hLW();
        }
        if (this.TIc != null)
        {
          if (this.TIb.size() > 0) {
            this.TIc.a(this.TIb.size(), ((fob)this.TIb.getFirst()).msgId, ((fob)this.TIb.getLast()).msgId, ((fob)this.TIb.getFirst()).oUj, ((fob)this.TIb.getLast()).oUj, ((fob)this.TIb.getLast()).extInfo, paramBoolean1);
          }
        }
        else
        {
          if (paramBoolean2)
          {
            localObject2 = new fob();
            ((fob)localObject2).msgId = str;
            ((fob)localObject2).UGO = paramLong;
            ((fob)localObject2).oUj = paramInt;
            as.a((fob)localObject2, 106, 2, i, paramLong, "");
          }
          wq(paramLong);
          aoG(paramInt);
          AppMethodBeat.o(88441);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(88441);
      }
      this.TIc.a(0, "", "", 0, 0, "", paramBoolean1);
    }
  }
  
  private void a(fob paramfob)
  {
    AppMethodBeat.i(271641);
    switch (paramfob.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(271641);
      return;
      Y(paramfob.UGO, false);
      new wl().publish();
      AppMethodBeat.o(271641);
      return;
      t("", "", 0L);
      AppMethodBeat.o(271641);
      return;
      a(paramfob.UGO, true, paramfob.oUj, false);
      new wl().publish();
      AppMethodBeat.o(271641);
      return;
      hLX();
      if (this.TIc != null)
      {
        paramfob = this.TIc;
        System.currentTimeMillis();
        paramfob.hME();
      }
      new wl().publish();
      AppMethodBeat.o(271641);
      return;
      hLY();
      if (this.TIc != null)
      {
        paramfob = this.TIc;
        System.currentTimeMillis();
        paramfob.hMF();
      }
      new wl().publish();
    }
  }
  
  private static void a(fob paramfob, String[] paramArrayOfString)
  {
    AppMethodBeat.i(88435);
    paramfob.msgId = paramArrayOfString[0];
    paramfob.abNX = Integer.valueOf(paramArrayOfString[1]).intValue();
    paramfob.WpO = Integer.valueOf(paramArrayOfString[2]).intValue();
    paramfob.WpP = Integer.valueOf(paramArrayOfString[3]).intValue();
    paramfob.WpN = Integer.valueOf(paramArrayOfString[4]).intValue();
    paramfob.ofU = Long.valueOf(paramArrayOfString[5]).longValue();
    paramfob.WoG = Integer.valueOf(paramArrayOfString[6]).intValue();
    paramfob.abNY = Long.valueOf(paramArrayOfString[7]).longValue();
    paramfob.text = paramArrayOfString[8];
    paramfob.type = Integer.valueOf(paramArrayOfString[9]).intValue();
    paramfob.showFlag = Integer.valueOf(paramArrayOfString[10]).intValue();
    paramfob.UGO = Long.valueOf(paramArrayOfString[11]).longValue();
    paramfob.icon = paramArrayOfString[12];
    if (paramArrayOfString.length > 13) {
      paramfob.oUj = Integer.valueOf(paramArrayOfString[13]).intValue();
    }
    while (paramArrayOfString.length > 14)
    {
      paramfob.extInfo = paramArrayOfString[14];
      AppMethodBeat.o(88435);
      return;
      paramfob.oUj = 0;
      if (paramfob.type == 7) {
        Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "no seq");
      }
    }
    paramfob.extInfo = "";
    AppMethodBeat.o(88435);
  }
  
  private static void aoG(int paramInt)
  {
    AppMethodBeat.i(271649);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateCmtRedDotSeq %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVU, Integer.valueOf(paramInt));
    com.tencent.mm.kernel.h.baE().ban().iZy();
    AppMethodBeat.o(271649);
  }
  
  private static void b(fob paramfob)
  {
    AppMethodBeat.i(271652);
    if (!Util.isNullOrNil(paramfob.extInfo))
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateInitTab %s", new Object[] { paramfob.extInfo });
      try
      {
        if (new JSONObject(paramfob.extInfo).optBoolean("has_wow_contents", true))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acXv, Integer.valueOf(1));
          AppMethodBeat.o(271652);
          return;
        }
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acXv, Integer.valueOf(0));
        AppMethodBeat.o(271652);
        return;
      }
      catch (Exception paramfob) {}
    }
    AppMethodBeat.o(271652);
  }
  
  private void c(fob paramfob)
  {
    AppMethodBeat.i(88429);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "start addCmtRedDot: %s", new Object[] { Integer.valueOf(paramfob.oUj) });
    if (!hMx()) {
      as.a(paramfob, 108, 2, this.TIb.size(), 0L, "");
    }
    if (paramfob.oUj <= hMl())
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid1, %s, %s", new Object[] { Integer.valueOf(paramfob.oUj), Integer.valueOf(hMl()) });
      as.a(paramfob, 103, 2, hMg(), 0L, "");
      as.a(paramfob, 109, 2, hMg(), 0L, "r6|" + paramfob.oUj + "|" + hMl());
      AppMethodBeat.o(88429);
      return;
    }
    label460:
    for (;;)
    {
      synchronized (this.TIb)
      {
        if (!Util.isNullOrNil(this.TIb))
        {
          i = 0;
          if (i >= this.TIb.size()) {
            break label460;
          }
          fob localfob = (fob)this.TIb.get(i);
          if (localfob.msgId.equals(paramfob.msgId))
          {
            Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot invalid3");
            as.a(paramfob, 109, 2, hMg(), 0L, "r11");
            AppMethodBeat.o(88429);
            return;
          }
          if (localfob.oUj > paramfob.oUj) {
            break label460;
          }
          i += 1;
          continue;
          this.TIb.add(i, paramfob);
          if (hMx()) {
            as.a(hMh(), 101, 2, this.TIb.size(), 0L, "");
          }
          Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "addCmtRedDot msgId:%s, showTime:%s", new Object[] { paramfob.msgId, Long.valueOf(paramfob.UGO) });
          hLW();
          if (this.TIc != null) {
            this.TIc.b(this.TIb.size(), ((fob)this.TIb.getFirst()).msgId, ((fob)this.TIb.getLast()).msgId, ((fob)this.TIb.getFirst()).oUj, ((fob)this.TIb.getLast()).oUj, ((fob)this.TIb.getLast()).extInfo);
          }
          new wl().publish();
          AppMethodBeat.o(88429);
          return;
        }
      }
      int i = 0;
    }
  }
  
  private void d(fob paramfob)
  {
    AppMethodBeat.i(271664);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setHomeTabRedDot %s", new Object[] { paramfob.msgId });
    if (!hMx()) {
      as.a(paramfob, 108, 1, 0, 0L, "");
    }
    this.THY = paramfob;
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXr, f(this.THY));
    com.tencent.mm.kernel.h.baE().ban().iZy();
    as.a(paramfob, 101, 3, 0, 0L, "");
    if (this.TIc != null) {
      this.TIc.b(this.THY, 100);
    }
    new wl().publish();
    AppMethodBeat.o(271664);
  }
  
  private static void e(fob paramfob)
  {
    paramfob.icon = "";
    paramfob.msgId = "";
    paramfob.text = "";
  }
  
  private static String f(fob paramfob)
  {
    AppMethodBeat.i(88434);
    paramfob = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramfob.msgId, Integer.valueOf(paramfob.abNX), Integer.valueOf(paramfob.WpO), Integer.valueOf(paramfob.WpP), Integer.valueOf(paramfob.WpN), Long.valueOf(paramfob.ofU), Integer.valueOf(paramfob.WoG), Long.valueOf(paramfob.abNY), paramfob.text, Integer.valueOf(paramfob.type), Integer.valueOf(paramfob.showFlag), Long.valueOf(paramfob.UGO), paramfob.icon, Integer.valueOf(paramfob.oUj), paramfob.extInfo });
    AppMethodBeat.o(88434);
    return paramfob;
  }
  
  private int g(fob paramfob)
  {
    int j = 110;
    int i;
    if (paramfob == this.THY) {
      i = 100;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramfob == this.THZ);
      i = j;
    } while (paramfob != this.TIa);
    return 666;
  }
  
  private void hLU()
  {
    AppMethodBeat.i(271638);
    this.THZ = new fob();
    e(this.THZ);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVV, "");
    com.tencent.mm.kernel.h.baE().ban().iZy();
    if (this.TIc != null)
    {
      d.a locala = this.TIc;
      hMk();
      locala.hMD();
    }
    AppMethodBeat.o(271638);
  }
  
  private void hLW()
  {
    AppMethodBeat.i(88430);
    synchronized (this.TIb)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.TIb.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(f((fob)localIterator.next())).append(";");
      }
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXq, localObject.toString());
    com.tencent.mm.kernel.h.baE().ban().iZy();
    AppMethodBeat.o(88430);
  }
  
  private void hLX()
  {
    AppMethodBeat.i(88432);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
    this.THY = new fob();
    e(this.THY);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXr, "");
    com.tencent.mm.kernel.h.baE().ban().iZy();
    AppMethodBeat.o(88432);
  }
  
  private void hLY()
  {
    AppMethodBeat.i(271677);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
    this.TIa = new fob();
    e(this.TIa);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXs, "");
    com.tencent.mm.kernel.h.baE().ban().iZy();
    AppMethodBeat.o(271677);
  }
  
  private void hMd()
  {
    AppMethodBeat.i(88436);
    Object localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXq, "");
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
            fob localfob = new fob();
            a(localfob, (String[])localObject2);
            this.TIb.addLast(localfob);
          }
          i += 1;
        }
        AppMethodBeat.o(88436);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acXq, "");
        com.tencent.mm.kernel.h.baE().ban().iZy();
      }
    }
    AppMethodBeat.o(88436);
  }
  
  private int hMg()
  {
    AppMethodBeat.i(88438);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCountForReport %s", new Object[] { Integer.valueOf(this.TIb.size()) });
    int i = this.TIb.size();
    AppMethodBeat.o(88438);
    return i;
  }
  
  private static long hMk()
  {
    AppMethodBeat.i(88445);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acVS, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88445);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(88445);
    return l;
  }
  
  private static int hMl()
  {
    AppMethodBeat.i(88446);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acVU, null);
    if (localObject == null)
    {
      AppMethodBeat.o(88446);
      return -1;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(88446);
    return i;
  }
  
  private void t(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(88450);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "setUserIconRedDot %s, extInfo %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgId", paramString1);
      localJSONObject.put("extInfo", paramString2);
      localJSONObject.put("ts", paramLong);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acXt, localJSONObject.toString());
      com.tencent.mm.kernel.h.baE().ban().iZy();
      if ((!Util.isNullOrNil(paramString1)) && (this.TIc != null)) {
        this.TIc.bK(paramString1, paramLong);
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
  
  private static void wq(long paramLong)
  {
    AppMethodBeat.i(271647);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVT, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baE().ban().iZy();
    AppMethodBeat.o(271647);
  }
  
  public final void a(d.a parama)
  {
    this.TIc = parama;
  }
  
  public final int aoH(int paramInt)
  {
    AppMethodBeat.i(271766);
    if (hMf() > 0)
    {
      AppMethodBeat.o(271766);
      return 110;
    }
    boolean bool1 = hLS();
    boolean bool2 = hMm();
    boolean bool3 = hMn();
    if ((bool1) && (bool2) && (bool3))
    {
      int i = Math.max(Math.max(this.THY.priority, this.THZ.priority), this.TIa.priority);
      long l = Math.min(Math.max(this.THY.abNY, this.THZ.abNY), this.TIa.abNY);
      HashSet localHashSet = new HashSet();
      localHashSet.add(Integer.valueOf(this.THY.priority));
      localHashSet.add(Integer.valueOf(this.THZ.priority));
      localHashSet.add(Integer.valueOf(this.TIa.priority));
      if (localHashSet.size() == 1)
      {
        if (this.THY.abNY == l)
        {
          AppMethodBeat.o(271766);
          return 100;
        }
        if (this.THZ.abNY == l)
        {
          AppMethodBeat.o(271766);
          return 110;
        }
        if (this.TIa.abNY == l)
        {
          AppMethodBeat.o(271766);
          return 666;
        }
      }
      if (localHashSet.size() == 2)
      {
        if (this.THY.priority == i)
        {
          if (this.THZ.priority == i)
          {
            if (this.THY.abNY > this.THZ.abNY)
            {
              AppMethodBeat.o(271766);
              return 100;
            }
            AppMethodBeat.o(271766);
            return 110;
          }
          if (this.TIa.priority == i)
          {
            if (this.THY.abNY > this.TIa.abNY)
            {
              AppMethodBeat.o(271766);
              return 100;
            }
            AppMethodBeat.o(271766);
            return 666;
          }
          AppMethodBeat.o(271766);
          return 100;
        }
        if (this.THZ.priority == i)
        {
          if (this.THY.priority == i)
          {
            if (this.THZ.abNY > this.THY.abNY)
            {
              AppMethodBeat.o(271766);
              return 110;
            }
            AppMethodBeat.o(271766);
            return 100;
          }
          if (this.TIa.priority == i)
          {
            if (this.THZ.abNY > this.TIa.abNY)
            {
              AppMethodBeat.o(271766);
              return 110;
            }
            AppMethodBeat.o(271766);
            return 666;
          }
          AppMethodBeat.o(271766);
          return 110;
        }
        if (this.TIa.priority == i)
        {
          if (this.THZ.priority == i)
          {
            if (this.TIa.abNY > this.THZ.abNY)
            {
              AppMethodBeat.o(271766);
              return 666;
            }
            AppMethodBeat.o(271766);
            return 110;
          }
          if (this.THY.priority == i)
          {
            if (this.TIa.abNY > this.THY.abNY)
            {
              AppMethodBeat.o(271766);
              return 666;
            }
            AppMethodBeat.o(271766);
            return 100;
          }
          AppMethodBeat.o(271766);
          return 666;
        }
      }
      if (localHashSet.size() == 3)
      {
        if (this.THZ.priority == i)
        {
          AppMethodBeat.o(271766);
          return 110;
        }
        if (this.THY.priority == i)
        {
          AppMethodBeat.o(271766);
          return 100;
        }
        if (this.TIa.priority == i)
        {
          AppMethodBeat.o(271766);
          return 666;
        }
      }
      AppMethodBeat.o(271766);
      return paramInt;
    }
    if ((bool1) && (bool2))
    {
      paramInt = a(this.THZ, this.THY, paramInt);
      AppMethodBeat.o(271766);
      return paramInt;
    }
    if ((bool1) && (bool3))
    {
      paramInt = a(this.THZ, this.TIa, paramInt);
      AppMethodBeat.o(271766);
      return paramInt;
    }
    if ((bool2) && (bool3))
    {
      paramInt = a(this.THY, this.TIa, paramInt);
      AppMethodBeat.o(271766);
      return paramInt;
    }
    if (bool1)
    {
      AppMethodBeat.o(271766);
      return 110;
    }
    if (bool2)
    {
      AppMethodBeat.o(271766);
      return 100;
    }
    if (bool3)
    {
      AppMethodBeat.o(271766);
      return 666;
    }
    AppMethodBeat.o(271766);
    return paramInt;
  }
  
  public final void b(d.a parama)
  {
    if (this.TIc == parama) {
      this.TIc = null;
    }
  }
  
  public final boolean hLS()
  {
    AppMethodBeat.i(271717);
    int i = a(this.THZ, 110);
    if (i == 0)
    {
      if (hMx())
      {
        AppMethodBeat.o(271717);
        return true;
      }
    }
    else if (i == -3)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHaokanRedDot");
      as.a(this.THZ, 104, 1, 0, 0L, "");
      hLU();
    }
    AppMethodBeat.o(271717);
    return false;
  }
  
  public final boolean hLT()
  {
    AppMethodBeat.i(88422);
    if ((fob)this.TIb.getLast() == null)
    {
      AppMethodBeat.o(88422);
      return false;
    }
    AppMethodBeat.o(88422);
    return true;
  }
  
  public final fob hLV()
  {
    return this.THZ;
  }
  
  public final fob hLZ()
  {
    return this.THY;
  }
  
  public final boolean hMA()
  {
    AppMethodBeat.i(271772);
    long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.acWe, 0L);
    if (this.THY.abNY < l)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHomeFindMoreEntryRedDot already click find more entry");
      AppMethodBeat.o(271772);
      return false;
    }
    AppMethodBeat.o(271772);
    return true;
  }
  
  public final void hMB()
  {
    AppMethodBeat.i(271775);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acWe, Long.valueOf(cn.bDw()));
    AppMethodBeat.o(271775);
  }
  
  public final void hMC()
  {
    AppMethodBeat.i(271779);
    if (hMf() > 0)
    {
      fob localfob = hMh();
      if (localfob != null) {
        as.a(localfob.msgId, localfob.UGO, 2, hMf(), "", localfob.oUj);
      }
      AppMethodBeat.o(271779);
      return;
    }
    if ((hLS()) && (hMm()))
    {
      if (this.THY.priority > this.THZ.priority)
      {
        as.a(this.THY.msgId, this.THY.UGO, 1, 0, "", 0);
        AppMethodBeat.o(271779);
        return;
      }
      if (this.THY.priority < this.THZ.priority)
      {
        as.a(this.THZ.msgId, this.THZ.UGO, 1, 0, "", 0);
        AppMethodBeat.o(271779);
        return;
      }
      if (this.THY.abNY > this.THZ.abNY)
      {
        as.a(this.THY.msgId, this.THY.UGO, 1, 0, "", 0);
        AppMethodBeat.o(271779);
        return;
      }
      if (this.THY.abNY < this.THZ.abNY)
      {
        as.a(this.THZ.msgId, this.THZ.UGO, 1, 0, "", 0);
        AppMethodBeat.o(271779);
        return;
      }
      as.a(this.THZ.msgId, this.THZ.UGO, 1, 0, "", 0);
      AppMethodBeat.o(271779);
      return;
    }
    if (hLS())
    {
      as.a(this.THZ.msgId, this.THZ.UGO, 1, 0, "", 0);
      AppMethodBeat.o(271779);
      return;
    }
    if (hMm()) {
      as.a(this.THY.msgId, this.THY.UGO, 1, 0, "", 0);
    }
    AppMethodBeat.o(271779);
  }
  
  public final String hMa()
  {
    return this.TIa.msgId;
  }
  
  public final void hMb()
  {
    AppMethodBeat.i(271721);
    fob localfob = new fob();
    localfob.msgId = this.TIa.msgId;
    boolean bool = true;
    if (this.TIc != null) {
      bool = this.TIc.aoI(666);
    }
    for (;;)
    {
      if (bool) {
        as.a(localfob, 106, 3, 0, 0L, "");
      }
      hLY();
      AppMethodBeat.o(271721);
      return;
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickVideoTabRedDot redDotListener = null");
    }
  }
  
  public final fob hMc()
  {
    return this.TIa;
  }
  
  public final boolean hMe()
  {
    if (this.THZ != null) {
      return this.THZ.WpP == 1;
    }
    return false;
  }
  
  public final int hMf()
  {
    AppMethodBeat.i(88437);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "getCmtRedDotCount %s", new Object[] { Integer.valueOf(this.TIb.size()) });
    int i = this.TIb.size();
    AppMethodBeat.o(88437);
    return i;
  }
  
  public final fob hMh()
  {
    AppMethodBeat.i(88439);
    synchronized (this.TIb)
    {
      if (Util.isNullOrNil(this.TIb))
      {
        AppMethodBeat.o(88439);
        return null;
      }
      fob localfob = (fob)this.TIb.getLast();
      AppMethodBeat.o(88439);
      return localfob;
    }
  }
  
  public final fob hMi()
  {
    AppMethodBeat.i(88440);
    synchronized (this.TIb)
    {
      if (Util.isNullOrNil(this.TIb))
      {
        AppMethodBeat.o(88440);
        return null;
      }
      fob localfob = (fob)this.TIb.getFirst();
      AppMethodBeat.o(88440);
      return localfob;
    }
  }
  
  public final boolean hMj()
  {
    AppMethodBeat.i(88443);
    if (!Util.isNullOrNil(this.TIb))
    {
      if (((fob)this.TIb.getLast()).WpP == 1)
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
  
  public final boolean hMm()
  {
    AppMethodBeat.i(88447);
    int i = a(this.THY, 100);
    if (i == 0)
    {
      if (hMx())
      {
        AppMethodBeat.o(88447);
        return true;
      }
    }
    else if (i == -3)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearHomeTabRedDot");
      as.a(this.THY, 104, 1, 0, 0L, "");
      hLX();
    }
    AppMethodBeat.o(88447);
    return false;
  }
  
  public final boolean hMn()
  {
    AppMethodBeat.i(271734);
    int i = a(this.TIa, 666);
    if (i == 0)
    {
      if (hMx())
      {
        AppMethodBeat.o(271734);
        return true;
      }
    }
    else if (i == -3)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clearVideoTabRedDot");
      as.a(this.TIa, 104, 1, 0, 0L, "");
      hLY();
    }
    AppMethodBeat.o(271734);
    return false;
  }
  
  public final String hMo()
  {
    AppMethodBeat.i(88448);
    String str = this.THY.msgId;
    AppMethodBeat.o(88448);
    return str;
  }
  
  public final void hMp()
  {
    AppMethodBeat.i(88449);
    fob localfob = new fob();
    localfob.msgId = this.THY.msgId;
    boolean bool = true;
    if (this.TIc != null) {
      bool = this.TIc.aoI(100);
    }
    for (;;)
    {
      if (bool) {
        as.a(localfob, 106, 3, 0, 0L, "");
      }
      hLX();
      AppMethodBeat.o(88449);
      return;
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "clickHomeTabRedDot redDotListener = null");
    }
  }
  
  public final void hMq()
  {
    AppMethodBeat.i(271739);
    if (this.TIc != null)
    {
      d.a locala = this.TIc;
      hMk();
      locala.hME();
    }
    AppMethodBeat.o(271739);
  }
  
  public final void hMr()
  {
    AppMethodBeat.i(271742);
    if (this.TIc != null)
    {
      d.a locala = this.TIc;
      hMk();
      locala.hMF();
    }
    AppMethodBeat.o(271742);
  }
  
  public final void hMs()
  {
    AppMethodBeat.i(271744);
    fob localfob1 = new fob();
    fob localfob2 = this.THZ;
    if (localfob2 != null) {
      localfob1.msgId = localfob2.msgId;
    }
    as.a(localfob1, 106, 1, 0, 0L, "");
    hLU();
    AppMethodBeat.o(271744);
  }
  
  public final String hMt()
  {
    AppMethodBeat.i(88451);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXt, "");
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
  
  public final long hMu()
  {
    AppMethodBeat.i(88452);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXt, "");
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
  
  public final String hMv()
  {
    AppMethodBeat.i(88453);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXt, "");
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
  
  public final void hMw()
  {
    AppMethodBeat.i(88454);
    t("", "", 0L);
    AppMethodBeat.o(88454);
  }
  
  public final boolean hMx()
  {
    AppMethodBeat.i(88455);
    long l = z.bAR();
    if ((0x4000000 & l) == 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      boolean bool3 = com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null));
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
  
  public final boolean hMy()
  {
    AppMethodBeat.i(271768);
    long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.acWe, 0L);
    if (this.THZ.abNY < l)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHaokanFindMoreEntryRedDot already click find more entry");
      AppMethodBeat.o(271768);
      return false;
    }
    AppMethodBeat.o(271768);
    return true;
  }
  
  public final boolean hMz()
  {
    AppMethodBeat.i(271770);
    long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.acWe, 0L);
    if (this.TIa.abNY < l)
    {
      Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "canShowHomeFindMoreEntryRedDot already click find more entry");
      AppMethodBeat.o(271770);
      return false;
    }
    AppMethodBeat.o(271770);
    return true;
  }
  
  public final void k(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(88442);
    a(paramLong, paramBoolean, paramInt, true);
    AppMethodBeat.o(88442);
  }
  
  public final void wp(long paramLong)
  {
    AppMethodBeat.i(271720);
    Log.i("MicroMsg.TopStory.TopStoryRedDotImpl", "updateHaokanRedDotTimestamp %s", new Object[] { Long.valueOf(paramLong) });
    Y(paramLong, true);
    AppMethodBeat.o(271720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.c
 * JD-Core Version:    0.7.0.1
 */