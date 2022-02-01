package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class bd
  implements f
{
  private static ConcurrentHashMap<String, b> DOv;
  private static ConcurrentHashMap<String, WeakReference<b>> DOw;
  
  static
  {
    AppMethodBeat.i(96001);
    DOv = new ConcurrentHashMap();
    DOw = new ConcurrentHashMap();
    AppMethodBeat.o(96001);
  }
  
  public static void aPt(String paramString)
  {
    AppMethodBeat.i(95995);
    if (ac.jPe) {
      Log.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    paramString = (WeakReference)DOw.get(paramString);
    if (paramString != null)
    {
      paramString = (b)paramString.get();
      if (paramString != null)
      {
        paramString.xZv = true;
        AppMethodBeat.o(95995);
        return;
      }
    }
    AppMethodBeat.o(95995);
  }
  
  public static void aPu(String paramString)
  {
    AppMethodBeat.i(95997);
    Log.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[] { paramString });
    if (DOv.containsKey(paramString))
    {
      Log.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[] { paramString });
      paramString = (b)DOv.get(paramString);
      if ((paramString != null) && (paramString.DOy == -1L) && (paramString.startTime != -1L))
      {
        paramString.DOy = 1L;
        paramString.DOB = paramString.iAC;
        paramString.endTime = System.currentTimeMillis();
        paramString.DOA = (paramString.endTime - paramString.startTime);
        paramString = paramString.DOE.values().iterator();
        while (paramString.hasNext()) {
          ((a)paramString.next()).DOy = 1L;
        }
      }
    }
    AppMethodBeat.o(95997);
  }
  
  public static void fF(String paramString, int paramInt)
  {
    AppMethodBeat.i(202794);
    if (ac.jPe) {
      Log.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    Object localObject = (WeakReference)DOw.get(paramString);
    if (localObject != null)
    {
      localObject = (b)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if ((localObject != null) && (((b)localObject).DOy == -1L))
        {
          HashMap localHashMap = ((b)localObject).DOE;
          if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
          {
            paramString = (a)localHashMap.get(paramString);
            if ((paramString != null) && (paramString.DOy == -1L))
            {
              paramString.DOy = 1L;
              paramString.mediaType = paramInt;
              ((b)localObject).DOB += 1;
            }
          }
        }
        AppMethodBeat.o(202794);
        return;
      }
    }
    AppMethodBeat.o(202794);
  }
  
  public final void a(String paramString, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(95998);
    if (!DOv.containsKey(paramString))
    {
      if (ac.jPe) {
        Log.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[] { paramString });
      }
      if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.LoU == 1) && (paramTimeLineObject.ContentObj.LoV != null) && (paramTimeLineObject.ContentObj.LoV.size() > 0))
      {
        b localb = new b();
        localb.iAC = paramTimeLineObject.ContentObj.LoV.size();
        localb.DOB = 0;
        localb.DOC = r.aOw(paramTimeLineObject.Id);
        localb.DOE = new HashMap();
        paramTimeLineObject = paramTimeLineObject.ContentObj.LoV.iterator();
        while (paramTimeLineObject.hasNext())
        {
          cnb localcnb = (cnb)paramTimeLineObject.next();
          a locala = new a();
          locala.mediaId = localcnb.Id;
          locala.DOz = localcnb.MsB;
          String str1 = ar.ki(aj.getAccSnsPath(), localcnb.Id);
          String str2 = r.e(localcnb);
          locala.filePath = (str1 + str2);
          localb.DOD.add(localcnb.Id);
          localb.DOE.put(localcnb.Id, locala);
          DOw.put(localcnb.Id, new WeakReference(localb));
        }
        localb.startTime = System.currentTimeMillis();
        DOv.put(paramString, localb);
        AppMethodBeat.o(95998);
        return;
      }
      if (ac.jPe) {
        Log.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
      }
    }
    AppMethodBeat.o(95998);
  }
  
  public final void aOU(String paramString)
  {
    AppMethodBeat.i(95999);
    if (DOv.containsKey(paramString))
    {
      if (ac.jPe) {
        Log.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[] { paramString });
      }
      paramString = (b)DOv.get(paramString);
      if ((paramString != null) && (paramString.startTime != -1L) && (paramString.DOy == -1L))
      {
        paramString.endTime = System.currentTimeMillis();
        paramString.DOA = (paramString.endTime - paramString.startTime);
        if (paramString.DOB == paramString.iAC)
        {
          paramString.DOy = 1L;
          AppMethodBeat.o(95999);
          return;
        }
        paramString.DOy = 2L;
      }
    }
    AppMethodBeat.o(95999);
  }
  
  public final void fac()
  {
    AppMethodBeat.i(96000);
    com.tencent.f.h.RTc.aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202793);
        label1055:
        label1070:
        label1073:
        label1076:
        for (;;)
        {
          int k;
          Object localObject2;
          StringBuilder localStringBuilder1;
          StringBuilder localStringBuilder2;
          StringBuilder localStringBuilder3;
          int i;
          synchronized (bd.this)
          {
            Iterator localIterator2;
            Object localObject3;
            BitmapFactory.Options localOptions;
            int j;
            try
            {
              Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[] { Integer.valueOf(bd.bly().size()) });
              k = r.eZw();
              Iterator localIterator1 = bd.bly().keySet().iterator();
              if (!localIterator1.hasNext()) {
                break label1055;
              }
              localObject2 = (String)localIterator1.next();
              localObject2 = (bd.b)bd.bly().get(localObject2);
              if ((localObject2 == null) || (!((bd.b)localObject2).xZv)) {
                continue;
              }
              if ((((bd.b)localObject2).DOA == -1L) || (((bd.b)localObject2).DOy == -1L) || (((bd.b)localObject2).startTime == -1L)) {
                continue;
              }
              localStringBuilder1 = new StringBuilder();
              localStringBuilder2 = new StringBuilder();
              localStringBuilder3 = new StringBuilder();
              i = 0;
              localIterator2 = ((bd.b)localObject2).DOD.iterator();
              if (localIterator2.hasNext())
              {
                localObject3 = (String)localIterator2.next();
                localObject3 = (bd.a)((bd.b)localObject2).DOE.get(localObject3);
                if (localObject3 == null) {
                  break label1073;
                }
                localOptions = BitmapUtil.getImageOptions(((bd.a)localObject3).filePath);
                j = 0;
                i = 0;
                if (localOptions != null)
                {
                  j = localOptions.outWidth;
                  i = localOptions.outHeight;
                }
                localStringBuilder1.append(j).append("|");
                localStringBuilder2.append(i).append("|");
                localStringBuilder3.append(0).append("|");
                i = ((bd.a)localObject3).mediaType;
                break label1073;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(11600, new Object[] { Integer.valueOf(((bd.b)localObject2).iAC), Long.valueOf(((bd.b)localObject2).DOy), Long.valueOf(((bd.b)localObject2).DOA), Integer.valueOf(((bd.b)localObject2).DOB), Integer.valueOf(k), Long.valueOf(((bd.b)localObject2).DOC), Long.valueOf(((bd.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
              Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((bd.b)localObject2).iAC), Long.valueOf(((bd.b)localObject2).DOy), Long.valueOf(((bd.b)localObject2).DOA), Integer.valueOf(((bd.b)localObject2).DOB), Integer.valueOf(k), Long.valueOf(((bd.b)localObject2).DOC), Long.valueOf(((bd.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
              continue;
            }
            catch (Throwable localThrowable)
            {
              Log.e("MicroMsg.TimelineSmallPicStat", "reportAll failed, error : %s", new Object[] { localThrowable.getMessage() });
            }
            AppMethodBeat.o(202793);
            return;
            if (((bd.b)localObject2).startTime == -1L) {
              continue;
            }
            ((bd.b)localObject2).endTime = System.currentTimeMillis();
            ((bd.b)localObject2).DOA = (((bd.b)localObject2).endTime - ((bd.b)localObject2).startTime);
            if (((bd.b)localObject2).iAC == ((bd.b)localObject2).DOB)
            {
              ((bd.b)localObject2).DOy = 1L;
              localStringBuilder1 = new StringBuilder();
              localStringBuilder2 = new StringBuilder();
              localStringBuilder3 = new StringBuilder();
              i = 0;
              localIterator2 = ((bd.b)localObject2).DOD.iterator();
              if (localIterator2.hasNext())
              {
                localObject3 = (String)localIterator2.next();
                localObject3 = (bd.a)((bd.b)localObject2).DOE.get(localObject3);
                if (localObject3 == null) {
                  break label1070;
                }
                localOptions = BitmapUtil.getImageOptions(((bd.a)localObject3).filePath);
                j = 0;
                i = 0;
                if (localOptions != null)
                {
                  j = localOptions.outWidth;
                  i = localOptions.outHeight;
                }
                localStringBuilder1.append(j).append("|");
                localStringBuilder2.append(i).append("|");
                localStringBuilder3.append(0).append("|");
                i = ((bd.a)localObject3).mediaType;
                break label1076;
              }
            }
            else
            {
              ((bd.b)localObject2).DOy = 2L;
            }
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(11600, new Object[] { Integer.valueOf(((bd.b)localObject2).iAC), Long.valueOf(((bd.b)localObject2).DOy), Long.valueOf(((bd.b)localObject2).DOA), Integer.valueOf(((bd.b)localObject2).DOB), Integer.valueOf(k), Long.valueOf(((bd.b)localObject2).DOC), Long.valueOf(((bd.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
          Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((bd.b)localObject2).iAC), Long.valueOf(((bd.b)localObject2).DOy), Long.valueOf(((bd.b)localObject2).DOA), Integer.valueOf(((bd.b)localObject2).DOB), Integer.valueOf(k), Long.valueOf(((bd.b)localObject2).DOC), Long.valueOf(((bd.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
          continue;
          bd.bly().clear();
          bd.fbR().clear();
          continue;
          break label1076;
        }
      }
    });
    AppMethodBeat.o(96000);
  }
  
  final class a
  {
    long DOy = -1L;
    cnd DOz;
    String filePath;
    String mediaId;
    int mediaType;
    
    a() {}
  }
  
  final class b
  {
    long DOA;
    int DOB;
    long DOC;
    ArrayList<String> DOD;
    HashMap<String, bd.a> DOE;
    long DOy;
    long endTime;
    int iAC;
    long startTime;
    boolean xZv;
    
    b()
    {
      AppMethodBeat.i(95994);
      this.startTime = -1L;
      this.endTime = -1L;
      this.DOy = -1L;
      this.DOA = -1L;
      this.iAC = 0;
      this.DOB = 0;
      this.DOC = -1L;
      this.DOD = new ArrayList();
      this.xZv = false;
      this.DOE = new HashMap();
      AppMethodBeat.o(95994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bd
 * JD-Core Version:    0.7.0.1
 */