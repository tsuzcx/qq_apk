package com.tencent.mm.ui.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.mmdata.rpt.hn;
import com.tencent.mm.autogen.mmdata.rpt.ho;
import com.tencent.mm.autogen.mmdata.rpt.hp;
import com.tencent.mm.live.model.c.b;
import com.tencent.mm.live.model.v;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.ui.t;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/report/RoomLiveReporter;", "", "()V", "reportedLiveId", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "reportedSessionLiveId", "clearLivedIdSet", "", "clearSessionLiveIdSet", "getLiveIdFormList", "", "tipsBarList", "", "Lcom/tencent/mm/live/model/storage/LiveTipsBar;", "reportGroupLiveSessionClick", "chatName", "isMute", "", "reportGroupLiveSessionExpose", "con", "Lcom/tencent/mm/storage/Conversation;", "mute", "liveId", "reportGroupLiveShareCardExpose", "reportGroupLiveShareClick", "reportGroupLiveTipsBarUserAction", "liveCnt", "actionToLiveId", "action", "actionTs", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d afBU;
  private static final HashSet<Long> afBV;
  private static final HashSet<Long> afBW;
  
  static
  {
    AppMethodBeat.i(249562);
    afBU = new d();
    afBV = new HashSet();
    afBW = new HashSet();
    AppMethodBeat.o(249562);
  }
  
  public static void a(String paramString1, long paramLong1, String paramString2, long paramLong2, long paramLong3)
  {
    int i = 1;
    AppMethodBeat.i(249530);
    s.u(paramString1, "chatName");
    s.u(paramString2, "actionToLiveId");
    hp localhp = new hp();
    localhp.imN = localhp.F("ChatName", paramString1, true);
    localhp.iOL = paramLong1;
    localhp.iOM = localhp.F("ActionToLiveId", paramString2, true);
    localhp.ikE = paramLong2;
    localhp.iOI = paramLong3;
    paramString1 = t.adCS;
    if (t.jjy()) {}
    for (;;)
    {
      localhp.iON = i;
      localhp.bMH();
      AppMethodBeat.o(249530);
      return;
      i = 2;
    }
  }
  
  public static void b(bb parambb, int paramInt)
  {
    AppMethodBeat.i(249549);
    s.u(parambb, "con");
    Object localObject = k.b.Hf(Util.processXml(parambb.field_content));
    if (localObject == null)
    {
      AppMethodBeat.o(249549);
      return;
    }
    long l2;
    if ((((k.b)localObject).type == 60) && (parambb.field_isSend == 0))
    {
      localObject = (v)((k.b)localObject).aK(v.class);
      if (localObject == null)
      {
        AppMethodBeat.o(249549);
        return;
      }
      l2 = Long.parseLong(((v)localObject).liveId);
      localObject = parambb.field_username;
      s.s(localObject, "chatName");
      afBW.add(Long.valueOf(l2));
      parambb = new hn();
      parambb.rB((String)localObject);
      parambb.iOI = System.currentTimeMillis();
      localObject = t.adCS;
      if (!t.jjA()) {
        break label183;
      }
    }
    label183:
    for (long l1 = 3L;; l1 = 2L)
    {
      parambb.iOH = l1;
      parambb.ikE = 1L;
      parambb.rC(String.valueOf(l2));
      parambb.iOK = paramInt;
      parambb.bMH();
      AppMethodBeat.o(249549);
      return;
    }
  }
  
  public static void cD(String paramString, long paramLong)
  {
    long l = 1L;
    AppMethodBeat.i(249534);
    s.u(paramString, "chatName");
    ho localho;
    if (!afBV.contains(Long.valueOf(paramLong)))
    {
      afBV.add(Long.valueOf(paramLong));
      localho = new ho();
      localho.rD(paramString);
      localho.ikE = 1L;
      localho.iOI = System.currentTimeMillis();
      localho.rE(String.valueOf(paramLong));
      paramString = t.adCS;
      if (!t.jjz()) {
        break label107;
      }
    }
    label107:
    for (paramLong = l;; paramLong = 2L)
    {
      localho.iOH = paramLong;
      localho.bMH();
      AppMethodBeat.o(249534);
      return;
    }
  }
  
  public static void cE(String paramString, long paramLong)
  {
    long l = 2L;
    AppMethodBeat.i(249537);
    s.u(paramString, "chatName");
    ho localho = new ho();
    localho.rD(paramString);
    localho.ikE = 2L;
    localho.iOI = System.currentTimeMillis();
    localho.rE(String.valueOf(paramLong));
    paramString = t.adCS;
    paramLong = l;
    if (t.jjz()) {
      paramLong = 1L;
    }
    localho.iOH = paramLong;
    localho.bMH();
    AppMethodBeat.o(249537);
  }
  
  public static void g(String paramString, List<? extends b> paramList, int paramInt)
  {
    AppMethodBeat.i(249557);
    s.u(paramString, "chatName");
    s.u(paramList, "tipsBarList");
    int i;
    if (((Collection)paramList).isEmpty()) {
      i = 1;
    }
    Object localObject1;
    Object localObject2;
    while (i == 0)
    {
      localObject1 = new StringBuilder();
      localObject2 = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          ((StringBuilder)localObject1).append(((b)((Iterator)localObject2).next()).field_liveId).append(";");
          continue;
          i = 0;
          break;
        }
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new hn();
      ((hn)localObject2).rB(paramString);
      ((hn)localObject2).ikE = 2L;
      ((hn)localObject2).iOI = System.currentTimeMillis();
      t localt = t.adCS;
      if (!t.jjA()) {
        break label207;
      }
    }
    label207:
    for (long l = 3L;; l = 2L)
    {
      ((hn)localObject2).iOH = l;
      ((hn)localObject2).rC((String)localObject1);
      ((hn)localObject2).iOK = paramInt;
      ((hn)localObject2).bMH();
      a(paramString, paramList.size(), "", 6L, System.currentTimeMillis());
      AppMethodBeat.o(249557);
      return;
    }
  }
  
  public static void jCr()
  {
    AppMethodBeat.i(249544);
    afBV.clear();
    AppMethodBeat.o(249544);
  }
  
  public static void jCs()
  {
    AppMethodBeat.i(249553);
    afBW.clear();
    AppMethodBeat.o(249553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.report.d
 * JD-Core Version:    0.7.0.1
 */