package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class ay
  implements e
{
  private static HashMap<String, b> wKy;
  private static HashMap<String, WeakReference<b>> wKz;
  
  static
  {
    AppMethodBeat.i(96001);
    wKy = new HashMap();
    wKz = new HashMap();
    AppMethodBeat.o(96001);
  }
  
  public static void aoP(String paramString)
  {
    AppMethodBeat.i(95995);
    if (ab.hWe) {
      ad.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    paramString = (WeakReference)wKz.get(paramString);
    if (paramString != null)
    {
      paramString = (b)paramString.get();
      if (paramString != null)
      {
        paramString.soF = true;
        AppMethodBeat.o(95995);
        return;
      }
    }
    AppMethodBeat.o(95995);
  }
  
  public static void aoQ(String paramString)
  {
    AppMethodBeat.i(95997);
    ad.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[] { paramString });
    if (wKy.containsKey(paramString))
    {
      ad.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[] { paramString });
      paramString = (b)wKy.get(paramString);
      if ((paramString != null) && (paramString.wKA == -1L) && (paramString.startTime != -1L))
      {
        paramString.wKA = 1L;
        paramString.wKE = paramString.gKT;
        paramString.endTime = System.currentTimeMillis();
        paramString.wKD = (paramString.endTime - paramString.startTime);
        paramString = paramString.wKH.values().iterator();
        while (paramString.hasNext()) {
          ((a)paramString.next()).wKA = 1L;
        }
      }
    }
    AppMethodBeat.o(95997);
  }
  
  public static void ey(String paramString, int paramInt)
  {
    AppMethodBeat.i(187333);
    if (ab.hWe) {
      ad.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    Object localObject = (WeakReference)wKz.get(paramString);
    if (localObject != null)
    {
      localObject = (b)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if ((localObject != null) && (((b)localObject).wKA == -1L))
        {
          HashMap localHashMap = ((b)localObject).wKH;
          if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
          {
            paramString = (a)localHashMap.get(paramString);
            if ((paramString != null) && (paramString.wKA == -1L))
            {
              paramString.wKA = 1L;
              paramString.mediaType = paramInt;
              ((b)localObject).wKE += 1;
            }
          }
        }
        AppMethodBeat.o(187333);
        return;
      }
    }
    AppMethodBeat.o(187333);
  }
  
  public final void a(String paramString, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(95998);
    if (!wKy.containsKey(paramString))
    {
      if (ab.hWe) {
        ad.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[] { paramString });
      }
      if ((paramTimeLineObject != null) && (paramTimeLineObject.Etm != null) && (paramTimeLineObject.Etm.DaB == 1) && (paramTimeLineObject.Etm.DaC != null) && (paramTimeLineObject.Etm.DaC.size() > 0))
      {
        b localb = new b();
        localb.gKT = paramTimeLineObject.Etm.DaC.size();
        localb.wKE = 0;
        localb.wKF = q.anR(paramTimeLineObject.Id);
        localb.wKH = new HashMap();
        paramTimeLineObject = paramTimeLineObject.Etm.DaC.iterator();
        while (paramTimeLineObject.hasNext())
        {
          bpi localbpi = (bpi)paramTimeLineObject.next();
          a locala = new a();
          locala.mediaId = localbpi.Id;
          locala.wKB = localbpi.DMT;
          String str1 = an.iF(af.getAccSnsPath(), localbpi.Id);
          String str2 = q.d(localbpi);
          locala.filePath = (str1 + str2);
          localb.wKG.add(localbpi.Id);
          localb.wKH.put(localbpi.Id, locala);
          wKz.put(localbpi.Id, new WeakReference(localb));
        }
        localb.startTime = System.currentTimeMillis();
        wKy.put(paramString, localb);
        AppMethodBeat.o(95998);
        return;
      }
      if (ab.hWe) {
        ad.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
      }
    }
    AppMethodBeat.o(95998);
  }
  
  public final void aoq(String paramString)
  {
    AppMethodBeat.i(95999);
    if (wKy.containsKey(paramString))
    {
      if (ab.hWe) {
        ad.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[] { paramString });
      }
      paramString = (b)wKy.get(paramString);
      if ((paramString != null) && (paramString.startTime != -1L) && (paramString.wKA == -1L))
      {
        paramString.endTime = System.currentTimeMillis();
        paramString.wKD = (paramString.endTime - paramString.startTime);
        if (paramString.wKE == paramString.gKT)
        {
          paramString.wKA = 1L;
          AppMethodBeat.o(95999);
          return;
        }
        paramString.wKA = 2L;
      }
    }
    AppMethodBeat.o(95999);
  }
  
  public final void dsJ()
  {
    AppMethodBeat.i(96000);
    ad.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[] { Integer.valueOf(wKy.size()) });
    int m = q.dsc();
    Iterator localIterator1 = wKy.keySet().iterator();
    Object localObject1;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    StringBuilder localStringBuilder3;
    Iterator localIterator2;
    int i;
    label169:
    Object localObject2;
    BitmapFactory.Options localOptions;
    int k;
    int j;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localObject1 = (String)localIterator1.next();
        localObject1 = (b)wKy.get(localObject1);
        if ((localObject1 != null) && (((b)localObject1).soF)) {
          if ((((b)localObject1).wKD != -1L) && (((b)localObject1).wKA != -1L) && (((b)localObject1).startTime != -1L))
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder2 = new StringBuilder();
            localStringBuilder3 = new StringBuilder();
            localIterator2 = ((b)localObject1).wKG.iterator();
            i = 0;
            if (localIterator2.hasNext())
            {
              localObject2 = (String)localIterator2.next();
              localObject2 = (a)((b)localObject1).wKH.get(localObject2);
              if (localObject2 == null) {
                break label1061;
              }
              localOptions = f.aFf(((a)localObject2).filePath);
              k = 0;
              j = 0;
              i = 0;
              if (localOptions != null)
              {
                k = localOptions.outWidth;
                j = localOptions.outHeight;
                i = (int)i.aMN(((a)localObject2).filePath);
              }
              localStringBuilder1.append(k).append("|");
              localStringBuilder2.append(j).append("|");
              localStringBuilder3.append(i).append("|");
              i = ((a)localObject2).mediaType;
            }
          }
        }
      }
    }
    label646:
    label790:
    label1058:
    label1061:
    for (;;)
    {
      break label169;
      h.vKh.f(11600, new Object[] { Integer.valueOf(((b)localObject1).gKT), Long.valueOf(((b)localObject1).wKA), Long.valueOf(((b)localObject1).wKD), Integer.valueOf(((b)localObject1).wKE), Integer.valueOf(m), Long.valueOf(((b)localObject1).wKF), Long.valueOf(((b)localObject1).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
      ad.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((b)localObject1).gKT), Long.valueOf(((b)localObject1).wKA), Long.valueOf(((b)localObject1).wKD), Integer.valueOf(((b)localObject1).wKE), Integer.valueOf(m), Long.valueOf(((b)localObject1).wKF), Long.valueOf(((b)localObject1).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
      break;
      if (((b)localObject1).startTime == -1L) {
        break;
      }
      ((b)localObject1).endTime = System.currentTimeMillis();
      ((b)localObject1).wKD = (((b)localObject1).endTime - ((b)localObject1).startTime);
      if (((b)localObject1).gKT == ((b)localObject1).wKE)
      {
        ((b)localObject1).wKA = 1L;
        label607:
        localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder3 = new StringBuilder();
        localIterator2 = ((b)localObject1).wKG.iterator();
        i = 0;
        if (!localIterator2.hasNext()) {
          break label790;
        }
        localObject2 = (String)localIterator2.next();
        localObject2 = (a)((b)localObject1).wKH.get(localObject2);
        if (localObject2 == null) {
          break label1058;
        }
        localOptions = f.aFf(((a)localObject2).filePath);
        k = 0;
        j = 0;
        i = 0;
        if (localOptions != null)
        {
          k = localOptions.outWidth;
          j = localOptions.outHeight;
          i = (int)i.aMN(((a)localObject2).filePath);
        }
        localStringBuilder1.append(k).append("|");
        localStringBuilder2.append(j).append("|");
        localStringBuilder3.append(i).append("|");
        i = ((a)localObject2).mediaType;
      }
      for (;;)
      {
        break label646;
        ((b)localObject1).wKA = 2L;
        break label607;
        h.vKh.f(11600, new Object[] { Integer.valueOf(((b)localObject1).gKT), Long.valueOf(((b)localObject1).wKA), Long.valueOf(((b)localObject1).wKD), Integer.valueOf(((b)localObject1).wKE), Integer.valueOf(m), Long.valueOf(((b)localObject1).wKF), Long.valueOf(((b)localObject1).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
        ad.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((b)localObject1).gKT), Long.valueOf(((b)localObject1).wKA), Long.valueOf(((b)localObject1).wKD), Integer.valueOf(((b)localObject1).wKE), Integer.valueOf(m), Long.valueOf(((b)localObject1).wKF), Long.valueOf(((b)localObject1).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
        break;
        wKy.clear();
        wKz.clear();
        AppMethodBeat.o(96000);
        return;
      }
    }
  }
  
  final class a
  {
    String filePath;
    String mediaId;
    int mediaType;
    long wKA = -1L;
    bpk wKB;
    
    a() {}
  }
  
  final class b
  {
    long endTime;
    int gKT;
    boolean soF;
    long startTime;
    long wKA;
    long wKD;
    int wKE;
    long wKF;
    ArrayList<String> wKG;
    HashMap<String, ay.a> wKH;
    
    b()
    {
      AppMethodBeat.i(95994);
      this.startTime = -1L;
      this.endTime = -1L;
      this.wKA = -1L;
      this.wKD = -1L;
      this.gKT = 0;
      this.wKE = 0;
      this.wKF = -1L;
      this.wKG = new ArrayList();
      this.soF = false;
      this.wKH = new HashMap();
      AppMethodBeat.o(95994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ay
 * JD-Core Version:    0.7.0.1
 */