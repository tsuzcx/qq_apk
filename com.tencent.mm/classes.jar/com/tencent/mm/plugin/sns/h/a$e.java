package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.bt.a;
import com.tencent.mm.plugin.findersdk.a.bt.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/keywords/SnsKeywordMatcher$loadFinderKeywords$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService$GetKeyWordsDataCallback;", "onDone", "", "dataList", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService$TriggerInfo;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$e
  implements bt.a
{
  public final void onDone(List<bt.b> paramList)
  {
    AppMethodBeat.i(306439);
    s.u(paramList, "dataList");
    if (Util.isNullOrNil(paramList))
    {
      Log.e("MicroMsg.SnsKeywordMatcher", "loadFinderKeywords callback no data.");
      AppMethodBeat.o(306439);
      return;
    }
    long l3 = System.currentTimeMillis() / 1000L;
    Iterator localIterator = ((Iterable)paramList).iterator();
    long l1 = l3;
    long l2 = l3;
    while (localIterator.hasNext())
    {
      bt.b localb = (bt.b)localIterator.next();
      if (l3 < localb.Hcz)
      {
        if (l2 >= localb.Hcz) {
          break label308;
        }
        l2 = localb.Hcz;
      }
      else
      {
        if (l3 >= localb.endTime) {
          break label308;
        }
        a.hfg().put(localb.oQy, localb);
        if (l1 >= localb.endTime) {
          break label308;
        }
        l1 = localb.endTime;
      }
    }
    label308:
    for (;;)
    {
      break;
      Log.i("MicroMsg.SnsKeywordMatcher", "loadFinderKeywords done. dataList size:" + paramList.size() + ", keywordsHashMap size:" + a.hfg().size() + ", minStartTime:" + l2 + ", minEndTime:" + l1);
      if ((a.hfg() != null) && (a.hfg().size() > 0))
      {
        paramList = a.QoW;
        a.hfh();
      }
      if (l2 <= l3) {}
      for (;;)
      {
        if (l1 > l3)
        {
          paramList = a.QoW;
          a.c(1000L * (l1 - l3), (kotlin.g.a.a)a.Qpj);
        }
        AppMethodBeat.o(306439);
        return;
        if (l1 <= l3) {
          l1 = l2;
        } else {
          l1 = Math.min(l2, l1);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final a Qpj;
    
    static
    {
      AppMethodBeat.i(306459);
      Qpj = new a();
      AppMethodBeat.o(306459);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.a.e
 * JD-Core Version:    0.7.0.1
 */