package com.tencent.mm.plugin.taskbar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.Long;Ljava.lang.Integer;>;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "", "", "intervalSec", "onBatchLiveStatusCallback"})
final class d$f
  implements aj.a
{
  d$f(d paramd, HashMap paramHashMap1, HashMap paramHashMap2) {}
  
  public final void e(Map<Long, Integer> paramMap, int paramInt)
  {
    AppMethodBeat.i(238449);
    if (paramInt > 0)
    {
      Log.i("MicroMsg.TaskBarViewPresenter", "new interval:".concat(String.valueOf(paramInt)));
      d.a(this.FUO, paramInt);
    }
    p.g(paramMap, "map");
    Iterator localIterator = paramMap.entrySet().iterator();
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      paramMap = (Integer)((Map.Entry)localObject1).getValue();
      if ((paramMap != null) && (paramMap.intValue() == 2))
      {
        paramMap = (aws)this.FUR.get(((Map.Entry)localObject1).getKey());
        if (paramMap != null)
        {
          localObject2 = paramMap.tuO;
          if (localObject2 != null)
          {
            localObject2 = ((FinderObject)localObject2).liveInfo;
            if (localObject2 != null) {
              ((awe)localObject2).liveStatus = 2;
            }
          }
        }
        Object localObject2 = (MultiTaskInfo)this.FUS.get(((Map.Entry)localObject1).getKey());
        if (localObject2 != null)
        {
          localObject1 = new StringBuilder("live end: ");
          p.g(localObject2, "taskInfo");
          Log.i("MicroMsg.TaskBarViewPresenter", ((MultiTaskInfo)localObject2).erh().nickname);
          if (paramMap != null)
          {
            localObject1 = paramMap.toByteArray();
            paramMap = (Map<Long, Integer>)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramMap = ((MultiTaskInfo)localObject2).field_data;
          }
          ((MultiTaskInfo)localObject2).field_data = paramMap;
          ((com.tencent.mm.plugin.taskbar.d)g.ah(com.tencent.mm.plugin.taskbar.d.class)).removeTaskInfo(((MultiTaskInfo)localObject2).field_id, true, 2);
          paramInt = 1;
        }
      }
    }
    if (paramInt != 0)
    {
      paramMap = d.a(this.FUO);
      if (paramMap != null)
      {
        paramMap.fuO();
        AppMethodBeat.o(238449);
        return;
      }
    }
    AppMethodBeat.o(238449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.d.f
 * JD-Core Version:    0.7.0.1
 */