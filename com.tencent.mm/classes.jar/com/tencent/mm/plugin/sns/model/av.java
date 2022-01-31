package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class av
  implements f
{
  private static HashMap<String, av.b> otT = new HashMap();
  private static HashMap<String, WeakReference<av.b>> otU = new HashMap();
  
  public static void NN(String paramString)
  {
    if (ae.eTp) {
      y.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    paramString = (WeakReference)otU.get(paramString);
    if (paramString != null)
    {
      paramString = (av.b)paramString.get();
      if (paramString != null) {
        paramString.lgB = true;
      }
    }
  }
  
  public static void NO(String paramString)
  {
    if (ae.eTp) {
      y.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    Object localObject = (WeakReference)otU.get(paramString);
    if (localObject != null)
    {
      localObject = (av.b)((WeakReference)localObject).get();
      if ((localObject != null) && (localObject != null) && (((av.b)localObject).otV == -1L))
      {
        HashMap localHashMap = ((av.b)localObject).otZ;
        if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
        {
          paramString = (av.a)localHashMap.get(paramString);
          if ((paramString != null) && (paramString.otV == -1L))
          {
            paramString.otV = 1L;
            ((av.b)localObject).otY += 1;
          }
        }
      }
    }
  }
  
  public static void NP(String paramString)
  {
    y.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[] { paramString });
    if (otT.containsKey(paramString))
    {
      y.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[] { paramString });
      paramString = (av.b)otT.get(paramString);
      if ((paramString != null) && (paramString.otV == -1L) && (paramString.startTime != -1L))
      {
        paramString.otV = 1L;
        paramString.otY = paramString.dTT;
        paramString.endTime = System.currentTimeMillis();
        paramString.otX = (paramString.endTime - paramString.startTime);
        paramString = paramString.otZ.values().iterator();
        while (paramString.hasNext()) {
          ((av.a)paramString.next()).otV = 1L;
        }
      }
    }
  }
  
  public final void Nq(String paramString)
  {
    if (otT.containsKey(paramString))
    {
      if (ae.eTp) {
        y.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[] { paramString });
      }
      paramString = (av.b)otT.get(paramString);
      if ((paramString != null) && (paramString.startTime != -1L) && (paramString.otV == -1L))
      {
        paramString.endTime = System.currentTimeMillis();
        paramString.otX = (paramString.endTime - paramString.startTime);
        if (paramString.otY != paramString.dTT) {
          break label105;
        }
        paramString.otV = 1L;
      }
    }
    return;
    label105:
    paramString.otV = 2L;
  }
  
  public final void a(String paramString, bxk parambxk)
  {
    if (!otT.containsKey(paramString))
    {
      if (ae.eTp) {
        y.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[] { paramString });
      }
      if ((parambxk == null) || (parambxk.tNr == null) || (parambxk.tNr.sPI != 1) || (parambxk.tNr.sPJ == null) || (parambxk.tNr.sPJ.size() <= 0)) {
        break label221;
      }
      localb = new av.b(this);
      localb.dTT = parambxk.tNr.sPJ.size();
      localb.otY = 0;
      localb.otZ = new HashMap();
      parambxk = parambxk.tNr.sPJ.iterator();
      while (parambxk.hasNext())
      {
        localawd = (awd)parambxk.next();
        locala = new av.a(this);
        locala.bUi = localawd.lsK;
        localb.otZ.put(localawd.lsK, locala);
        otU.put(localawd.lsK, new WeakReference(localb));
      }
      localb.startTime = System.currentTimeMillis();
      otT.put(paramString, localb);
    }
    label221:
    while (!ae.eTp)
    {
      av.b localb;
      awd localawd;
      av.a locala;
      return;
    }
    y.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
  }
  
  public final void bCT()
  {
    y.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[] { Integer.valueOf(otT.size()) });
    int i = i.bCs();
    Iterator localIterator = otT.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (av.b)otT.get(localObject);
      if ((localObject != null) && (((av.b)localObject).lgB))
      {
        if ((((av.b)localObject).otX == -1L) || (((av.b)localObject).otV == -1L) || (((av.b)localObject).startTime == -1L))
        {
          if (((av.b)localObject).startTime == -1L) {
            continue;
          }
          ((av.b)localObject).endTime = System.currentTimeMillis();
          ((av.b)localObject).otX = (((av.b)localObject).endTime - ((av.b)localObject).startTime);
          if (((av.b)localObject).dTT != ((av.b)localObject).otY) {
            break label281;
          }
        }
        label281:
        for (((av.b)localObject).otV = 1L;; ((av.b)localObject).otV = 2L)
        {
          y.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d", new Object[] { Integer.valueOf(((av.b)localObject).dTT), Long.valueOf(((av.b)localObject).otV), Long.valueOf(((av.b)localObject).otX), Integer.valueOf(((av.b)localObject).otY), Integer.valueOf(i) });
          h.nFQ.f(11600, new Object[] { Integer.valueOf(((av.b)localObject).dTT), Long.valueOf(((av.b)localObject).otV), Long.valueOf(((av.b)localObject).otX), Integer.valueOf(((av.b)localObject).otY), Integer.valueOf(i) });
          break;
        }
      }
    }
    otT.clear();
    otU.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.av
 * JD-Core Version:    0.7.0.1
 */