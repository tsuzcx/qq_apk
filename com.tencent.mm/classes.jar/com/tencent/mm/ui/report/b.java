package com.tencent.mm.ui.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.b.a.fs;
import com.tencent.mm.f.b.a.ft;
import com.tencent.mm.f.b.a.fu;
import com.tencent.mm.live.b.v;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.r;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/report/RoomLiveReporter;", "", "()V", "reportedLiveId", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "reportedSessionLiveId", "clearLivedIdSet", "", "clearSessionLiveIdSet", "getLiveIdFormList", "", "tipsBarList", "", "Lcom/tencent/mm/live/model/storage/LiveTipsBar;", "reportGroupLiveSessionClick", "chatName", "reportGroupLiveSessionExpose", "con", "Lcom/tencent/mm/storage/Conversation;", "liveId", "reportGroupLiveShareCardExpose", "reportGroupLiveShareClick", "reportGroupLiveTipsBarUserAction", "liveCnt", "actionToLiveId", "action", "actionTs", "app_release"})
public final class b
{
  private static final HashSet<Long> XLM;
  private static final HashSet<Long> XLN;
  public static final b XLO;
  
  static
  {
    AppMethodBeat.i(269945);
    XLO = new b();
    XLM = new HashSet();
    XLN = new HashSet();
    AppMethodBeat.o(269945);
  }
  
  public static void N(String paramString, List<? extends com.tencent.mm.live.b.c.b> paramList)
  {
    AppMethodBeat.i(269944);
    p.k(paramString, "chatName");
    p.k(paramList, "tipsBarList");
    int i;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    Object localObject;
    while (i != 0)
    {
      localObject = new StringBuilder();
      paramList = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          ((StringBuilder)localObject).append(((com.tencent.mm.live.b.c.b)paramList.next()).field_liveId).append(";");
          continue;
          i = 0;
          break;
        }
      }
      paramList = ((StringBuilder)localObject).toString();
      localObject = new fs();
      ((fs)localObject).vf(paramString);
      ((fs)localObject).oH(2L);
      ((fs)localObject).oI(System.currentTimeMillis());
      paramString = r.VYx;
      if (!r.hHp()) {
        break label172;
      }
    }
    label172:
    for (long l = 1L;; l = 2L)
    {
      ((fs)localObject).oG(l);
      ((fs)localObject).vg(paramList);
      ((fs)localObject).bpa();
      AppMethodBeat.o(269944);
      return;
    }
  }
  
  public static void a(String paramString1, long paramLong1, String paramString2, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(269938);
    p.k(paramString1, "chatName");
    p.k(paramString2, "actionToLiveId");
    fu localfu = new fu();
    localfu.vj(paramString1);
    localfu.oM(paramLong1);
    localfu.vk(paramString2);
    localfu.oN(paramLong2);
    localfu.oO(paramLong3);
    paramString1 = r.VYx;
    if (r.hHn()) {}
    for (int i = 1;; i = 2)
    {
      localfu.mz(i);
      localfu.bpa();
      AppMethodBeat.o(269938);
      return;
    }
  }
  
  public static void cr(String paramString, long paramLong)
  {
    long l = 1L;
    AppMethodBeat.i(269939);
    p.k(paramString, "chatName");
    ft localft;
    if (!XLM.contains(Long.valueOf(paramLong)))
    {
      XLM.add(Long.valueOf(paramLong));
      localft = new ft();
      localft.vh(paramString);
      localft.oK(1L);
      localft.oL(System.currentTimeMillis());
      localft.vi(String.valueOf(paramLong));
      paramString = r.VYx;
      if (!r.hHo()) {
        break label110;
      }
    }
    label110:
    for (paramLong = l;; paramLong = 2L)
    {
      localft.oJ(paramLong);
      localft.bpa();
      AppMethodBeat.o(269939);
      return;
    }
  }
  
  public static void cs(String paramString, long paramLong)
  {
    long l = 2L;
    AppMethodBeat.i(269940);
    p.k(paramString, "chatName");
    ft localft = new ft();
    localft.vh(paramString);
    localft.oK(2L);
    localft.oL(System.currentTimeMillis());
    localft.vi(String.valueOf(paramLong));
    paramString = r.VYx;
    paramLong = l;
    if (r.hHo()) {
      paramLong = 1L;
    }
    localft.oJ(paramLong);
    localft.bpa();
    AppMethodBeat.o(269940);
  }
  
  public static void hXK()
  {
    AppMethodBeat.i(269941);
    XLM.clear();
    AppMethodBeat.o(269941);
  }
  
  public static void hXL()
  {
    AppMethodBeat.i(269943);
    XLN.clear();
    AppMethodBeat.o(269943);
  }
  
  public static void n(az paramaz)
  {
    AppMethodBeat.i(269942);
    p.k(paramaz, "con");
    Object localObject = k.b.OQ(Util.processXml(paramaz.getContent()));
    if (localObject == null)
    {
      AppMethodBeat.o(269942);
      return;
    }
    long l2;
    if ((((k.b)localObject).type == 60) && (paramaz.apA() == 0))
    {
      localObject = (v)((k.b)localObject).ar(v.class);
      if (localObject == null)
      {
        AppMethodBeat.o(269942);
        return;
      }
      l2 = Long.parseLong(((v)localObject).kwM);
      localObject = paramaz.getUsername();
      p.j(localObject, "chatName");
      XLN.add(Long.valueOf(l2));
      paramaz = new fs();
      paramaz.vf((String)localObject);
      paramaz.oI(System.currentTimeMillis());
      localObject = r.VYx;
      if (!r.hHp()) {
        break label176;
      }
    }
    label176:
    for (long l1 = 1L;; l1 = 2L)
    {
      paramaz.oG(l1);
      paramaz.oH(1L);
      paramaz.vg(String.valueOf(l2));
      paramaz.bpa();
      AppMethodBeat.o(269942);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.report.b
 * JD-Core Version:    0.7.0.1
 */