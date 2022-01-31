package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class aw
  implements f
{
  private static HashMap<String, aw.b> riL;
  private static HashMap<String, WeakReference<aw.b>> riM;
  
  static
  {
    AppMethodBeat.i(36681);
    riL = new HashMap();
    riM = new HashMap();
    AppMethodBeat.o(36681);
  }
  
  public static void aaH(String paramString)
  {
    AppMethodBeat.i(36675);
    if (ae.glk) {
      ab.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    paramString = (WeakReference)riM.get(paramString);
    if (paramString != null)
    {
      paramString = (aw.b)paramString.get();
      if (paramString != null)
      {
        paramString.nEw = true;
        AppMethodBeat.o(36675);
        return;
      }
    }
    AppMethodBeat.o(36675);
  }
  
  public static void aaI(String paramString)
  {
    AppMethodBeat.i(36676);
    if (ae.glk) {
      ab.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    Object localObject = (WeakReference)riM.get(paramString);
    if (localObject != null)
    {
      localObject = (aw.b)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if ((localObject != null) && (((aw.b)localObject).riN == -1L))
        {
          HashMap localHashMap = ((aw.b)localObject).riR;
          if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
          {
            paramString = (a)localHashMap.get(paramString);
            if ((paramString != null) && (paramString.riN == -1L))
            {
              paramString.riN = 1L;
              ((aw.b)localObject).riQ += 1;
            }
          }
        }
        AppMethodBeat.o(36676);
        return;
      }
    }
    AppMethodBeat.o(36676);
  }
  
  public static void aaJ(String paramString)
  {
    AppMethodBeat.i(36677);
    ab.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[] { paramString });
    if (riL.containsKey(paramString))
    {
      ab.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[] { paramString });
      paramString = (aw.b)riL.get(paramString);
      if ((paramString != null) && (paramString.riN == -1L) && (paramString.startTime != -1L))
      {
        paramString.riN = 1L;
        paramString.riQ = paramString.fjZ;
        paramString.endTime = System.currentTimeMillis();
        paramString.riP = (paramString.endTime - paramString.startTime);
        paramString = paramString.riR.values().iterator();
        while (paramString.hasNext()) {
          ((a)paramString.next()).riN = 1L;
        }
      }
    }
    AppMethodBeat.o(36677);
  }
  
  public final void a(String paramString, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(36678);
    if (!riL.containsKey(paramString))
    {
      if (ae.glk) {
        ab.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[] { paramString });
      }
      if ((paramTimeLineObject != null) && (paramTimeLineObject.xTS != null) && (paramTimeLineObject.xTS.wNZ == 1) && (paramTimeLineObject.xTS.wOa != null) && (paramTimeLineObject.xTS.wOa.size() > 0))
      {
        aw.b localb = new aw.b(this);
        localb.fjZ = paramTimeLineObject.xTS.wOa.size();
        localb.riQ = 0;
        localb.riR = new HashMap();
        paramTimeLineObject = paramTimeLineObject.xTS.wOa.iterator();
        while (paramTimeLineObject.hasNext())
        {
          bcs localbcs = (bcs)paramTimeLineObject.next();
          a locala = new a();
          locala.cBO = localbcs.Id;
          localb.riR.put(localbcs.Id, locala);
          riM.put(localbcs.Id, new WeakReference(localb));
        }
        localb.startTime = System.currentTimeMillis();
        riL.put(paramString, localb);
        AppMethodBeat.o(36678);
        return;
      }
      if (ae.glk) {
        ab.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
      }
    }
    AppMethodBeat.o(36678);
  }
  
  public final void aai(String paramString)
  {
    AppMethodBeat.i(36679);
    if (riL.containsKey(paramString))
    {
      if (ae.glk) {
        ab.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[] { paramString });
      }
      paramString = (aw.b)riL.get(paramString);
      if ((paramString != null) && (paramString.startTime != -1L) && (paramString.riN == -1L))
      {
        paramString.endTime = System.currentTimeMillis();
        paramString.riP = (paramString.endTime - paramString.startTime);
        if (paramString.riQ == paramString.fjZ)
        {
          paramString.riN = 1L;
          AppMethodBeat.o(36679);
          return;
        }
        paramString.riN = 2L;
      }
    }
    AppMethodBeat.o(36679);
  }
  
  public final void cov()
  {
    AppMethodBeat.i(36680);
    ab.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[] { Integer.valueOf(riL.size()) });
    int i = i.cnS();
    Iterator localIterator = riL.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aw.b)riL.get(localObject);
      if ((localObject != null) && (((aw.b)localObject).nEw))
      {
        if ((((aw.b)localObject).riP == -1L) || (((aw.b)localObject).riN == -1L) || (((aw.b)localObject).startTime == -1L))
        {
          if (((aw.b)localObject).startTime == -1L) {
            continue;
          }
          ((aw.b)localObject).endTime = System.currentTimeMillis();
          ((aw.b)localObject).riP = (((aw.b)localObject).endTime - ((aw.b)localObject).startTime);
          if (((aw.b)localObject).fjZ != ((aw.b)localObject).riQ) {
            break label286;
          }
        }
        label286:
        for (((aw.b)localObject).riN = 1L;; ((aw.b)localObject).riN = 2L)
        {
          ab.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d", new Object[] { Integer.valueOf(((aw.b)localObject).fjZ), Long.valueOf(((aw.b)localObject).riN), Long.valueOf(((aw.b)localObject).riP), Integer.valueOf(((aw.b)localObject).riQ), Integer.valueOf(i) });
          h.qsU.e(11600, new Object[] { Integer.valueOf(((aw.b)localObject).fjZ), Long.valueOf(((aw.b)localObject).riN), Long.valueOf(((aw.b)localObject).riP), Integer.valueOf(((aw.b)localObject).riQ), Integer.valueOf(i) });
          break;
        }
      }
    }
    riL.clear();
    riM.clear();
    AppMethodBeat.o(36680);
  }
  
  final class a
  {
    String cBO;
    long riN = -1L;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw
 * JD-Core Version:    0.7.0.1
 */