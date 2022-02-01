package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class be
  implements f
{
  private static ConcurrentHashMap<String, b> QyS;
  private static ConcurrentHashMap<String, WeakReference<b>> QyT;
  
  static
  {
    AppMethodBeat.i(96001);
    QyS = new ConcurrentHashMap();
    QyT = new ConcurrentHashMap();
    AppMethodBeat.o(96001);
  }
  
  private static b aYI(String paramString)
  {
    AppMethodBeat.i(309383);
    paramString = (WeakReference)QyT.get(paramString);
    if (paramString != null)
    {
      paramString = (b)paramString.get();
      if (paramString != null)
      {
        AppMethodBeat.o(309383);
        return paramString;
      }
    }
    AppMethodBeat.o(309383);
    return null;
  }
  
  public static void aYJ(String paramString)
  {
    AppMethodBeat.i(95995);
    if (z.pCO) {
      Log.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    paramString = aYI(paramString);
    if (paramString != null) {
      paramString.IYt = true;
    }
    AppMethodBeat.o(95995);
  }
  
  public static void aYK(String paramString)
  {
    AppMethodBeat.i(95997);
    Log.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[] { paramString });
    if (QyS.containsKey(paramString))
    {
      Log.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[] { paramString });
      paramString = (b)QyS.get(paramString);
      if ((paramString != null) && (paramString.QyV == -1L) && (paramString.startTime != -1L))
      {
        paramString.QyV = 1L;
        paramString.QyY = paramString.nVc;
        paramString.endTime = System.currentTimeMillis();
        paramString.QyX = (paramString.endTime - paramString.startTime);
        paramString = paramString.Qzb.values().iterator();
        while (paramString.hasNext()) {
          ((a)paramString.next()).QyV = 1L;
        }
      }
    }
    AppMethodBeat.o(95997);
  }
  
  public static void hb(String paramString, int paramInt)
  {
    AppMethodBeat.i(309380);
    paramString = aYI(paramString);
    if (paramString != null) {
      paramString.nAz = paramInt;
    }
    AppMethodBeat.o(309380);
  }
  
  public static void hc(String paramString, int paramInt)
  {
    AppMethodBeat.i(309387);
    if (z.pCO) {
      Log.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    Object localObject = (WeakReference)QyT.get(paramString);
    if (localObject != null)
    {
      localObject = (b)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if ((localObject != null) && (((b)localObject).QyV == -1L))
        {
          HashMap localHashMap = ((b)localObject).Qzb;
          if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
          {
            paramString = (a)localHashMap.get(paramString);
            if ((paramString != null) && (paramString.QyV == -1L))
            {
              paramString.QyV = 1L;
              paramString.mediaType = paramInt;
              ((b)localObject).QyY += 1;
            }
          }
        }
        AppMethodBeat.o(309387);
        return;
      }
    }
    AppMethodBeat.o(309387);
  }
  
  public final void a(String paramString, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(95998);
    if (!QyS.containsKey(paramString))
    {
      if (z.pCO) {
        Log.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[] { paramString });
      }
      if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Zpq == 1) && (paramTimeLineObject.ContentObj.Zpr != null) && (paramTimeLineObject.ContentObj.Zpr.size() > 0))
      {
        b localb = new b();
        localb.nVc = paramTimeLineObject.ContentObj.Zpr.size();
        localb.QyY = 0;
        localb.QyZ = t.aXD(paramTimeLineObject.Id);
        localb.Qzb = new HashMap();
        paramTimeLineObject = paramTimeLineObject.ContentObj.Zpr.iterator();
        while (paramTimeLineObject.hasNext())
        {
          dmz localdmz = (dmz)paramTimeLineObject.next();
          a locala = new a();
          locala.mediaId = localdmz.Id;
          locala.QyW = localdmz.aaTn;
          String str1 = as.mg(al.getAccSnsPath(), localdmz.Id);
          String str2 = t.d(localdmz);
          locala.filePath = (str1 + str2);
          localb.Qza.add(localdmz.Id);
          localb.Qzb.put(localdmz.Id, locala);
          QyT.put(localdmz.Id, new WeakReference(localb));
        }
        localb.startTime = System.currentTimeMillis();
        QyS.put(paramString, localb);
        AppMethodBeat.o(95998);
        return;
      }
      if (z.pCO) {
        Log.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
      }
    }
    AppMethodBeat.o(95998);
  }
  
  public final void aYc(String paramString)
  {
    AppMethodBeat.i(95999);
    if (QyS.containsKey(paramString))
    {
      if (z.pCO) {
        Log.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[] { paramString });
      }
      paramString = (b)QyS.get(paramString);
      if ((paramString != null) && (paramString.startTime != -1L) && (paramString.QyV == -1L))
      {
        paramString.endTime = System.currentTimeMillis();
        paramString.QyX = (paramString.endTime - paramString.startTime);
        if (paramString.QyY == paramString.nVc)
        {
          paramString.QyV = 1L;
          AppMethodBeat.o(95999);
          return;
        }
        paramString.QyV = 2L;
      }
    }
    AppMethodBeat.o(95999);
  }
  
  public final void hfI()
  {
    AppMethodBeat.i(96000);
    com.tencent.threadpool.h.ahAA.bn(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309505);
        label180:
        do
        {
          int m;
          Object localObject3;
          StringBuilder localStringBuilder1;
          StringBuilder localStringBuilder2;
          StringBuilder localStringBuilder3;
          int j;
          int i;
          Iterator localIterator2;
          Object localObject4;
          BitmapFactory.Options localOptions;
          int k;
          float f;
          synchronized (be.this)
          {
            Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[] { Integer.valueOf(be.bTA().size()) });
            m = t.heQ();
            Iterator localIterator1 = be.bTA().keySet().iterator();
            for (;;)
            {
              if (localIterator1.hasNext())
              {
                localObject3 = (String)localIterator1.next();
                localObject3 = (be.b)be.bTA().get(localObject3);
                if ((localObject3 != null) && (((be.b)localObject3).IYt)) {
                  if ((((be.b)localObject3).QyX != -1L) && (((be.b)localObject3).QyV != -1L) && (((be.b)localObject3).startTime != -1L))
                  {
                    localStringBuilder1 = new StringBuilder();
                    localStringBuilder2 = new StringBuilder();
                    localStringBuilder3 = new StringBuilder();
                    j = 0;
                    i = 0;
                    localIterator2 = ((be.b)localObject3).Qza.iterator();
                    if (localIterator2.hasNext())
                    {
                      localObject4 = (String)localIterator2.next();
                      localObject4 = (be.a)((be.b)localObject3).Qzb.get(localObject4);
                      if (localObject4 == null) {
                        break label1228;
                      }
                      localOptions = BitmapUtil.getImageOptions(((be.a)localObject4).filePath);
                      k = 0;
                      i = 0;
                      if (localOptions != null)
                      {
                        k = localOptions.outWidth;
                        i = localOptions.outHeight;
                      }
                      localStringBuilder1.append(k).append("|");
                      localStringBuilder2.append(i).append("|");
                      localStringBuilder3.append(0).append("|");
                      k = ((be.a)localObject4).mediaType;
                      i = k;
                      if (((be.a)localObject4).QyW == null) {
                        break label1228;
                      }
                      f = j;
                      j = (int)(((be.a)localObject4).QyW.aaUd + f);
                      i = k;
                      break label1228;
                    }
                    com.tencent.mm.plugin.report.service.h.OAn.b(11600, new Object[] { Integer.valueOf(((be.b)localObject3).nVc), Long.valueOf(((be.b)localObject3).QyV), Long.valueOf(((be.b)localObject3).QyX), Integer.valueOf(((be.b)localObject3).QyY), Integer.valueOf(m), Long.valueOf(((be.b)localObject3).QyZ), Long.valueOf(((be.b)localObject3).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(((be.b)localObject3).nAz) });
                    Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s,download_len:%d,scene:%d", new Object[] { Integer.valueOf(((be.b)localObject3).nVc), Long.valueOf(((be.b)localObject3).QyV), Long.valueOf(((be.b)localObject3).QyX), Integer.valueOf(((be.b)localObject3).QyY), Integer.valueOf(m), Long.valueOf(((be.b)localObject3).QyZ), Long.valueOf(((be.b)localObject3).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(((be.b)localObject3).nAz) });
                  }
                }
              }
            }
          }
          try
          {
            Log.e("MicroMsg.TimelineSmallPicStat", "reportAll failed, error : %s", new Object[] { localObject1.getMessage() });
            return;
          }
          finally
          {
            AppMethodBeat.o(309505);
          }
        } while (((be.b)localObject3).startTime == -1L);
        label641:
        ((be.b)localObject3).endTime = System.currentTimeMillis();
        ((be.b)localObject3).QyX = (((be.b)localObject3).endTime - ((be.b)localObject3).startTime);
        if (((be.b)localObject3).nVc == ((be.b)localObject3).QyY)
        {
          ((be.b)localObject3).QyV = 1L;
          label705:
          localStringBuilder1 = new StringBuilder();
          localStringBuilder2 = new StringBuilder();
          localStringBuilder3 = new StringBuilder();
          j = 0;
          i = 0;
          localIterator2 = ((be.b)localObject3).Qza.iterator();
        }
        label1225:
        label1228:
        label1231:
        for (;;)
        {
          if (localIterator2.hasNext())
          {
            localObject4 = (String)localIterator2.next();
            localObject4 = (be.a)((be.b)localObject3).Qzb.get(localObject4);
            if (localObject4 == null) {
              break label1225;
            }
            localOptions = BitmapUtil.getImageOptions(((be.a)localObject4).filePath);
            k = 0;
            i = 0;
            if (localOptions != null)
            {
              k = localOptions.outWidth;
              i = localOptions.outHeight;
            }
            localStringBuilder1.append(k).append("|");
            localStringBuilder2.append(i).append("|");
            localStringBuilder3.append(0).append("|");
            k = ((be.a)localObject4).mediaType;
            i = k;
            if (((be.a)localObject4).QyW == null) {
              break label1225;
            }
            f = j;
            j = (int)(((be.a)localObject4).QyW.aaUd + f);
            i = k;
            break label1231;
            ((be.b)localObject3).QyV = 2L;
            break label705;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(11600, new Object[] { Integer.valueOf(((be.b)localObject3).nVc), Long.valueOf(((be.b)localObject3).QyV), Long.valueOf(((be.b)localObject3).QyX), Integer.valueOf(((be.b)localObject3).QyY), Integer.valueOf(m), Long.valueOf(((be.b)localObject3).QyZ), Long.valueOf(((be.b)localObject3).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(((be.b)localObject3).nAz) });
          Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s,download_len:%d,scene:%d", new Object[] { Integer.valueOf(((be.b)localObject3).nVc), Long.valueOf(((be.b)localObject3).QyV), Long.valueOf(((be.b)localObject3).QyX), Integer.valueOf(((be.b)localObject3).QyY), Integer.valueOf(m), Long.valueOf(((be.b)localObject3).QyZ), Long.valueOf(((be.b)localObject3).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(((be.b)localObject3).nAz) });
          break;
          be.bTA().clear();
          be.hhB().clear();
          break label641;
          break label1231;
          break label180;
        }
      }
    });
    AppMethodBeat.o(96000);
  }
  
  final class a
  {
    long QyV = -1L;
    dnb QyW;
    String filePath;
    String mediaId;
    int mediaType;
    
    a() {}
  }
  
  final class b
  {
    boolean IYt;
    long QyV;
    long QyX;
    int QyY;
    long QyZ;
    ArrayList<String> Qza;
    HashMap<String, be.a> Qzb;
    long endTime;
    long nAz;
    int nVc;
    long startTime;
    
    b()
    {
      AppMethodBeat.i(95994);
      this.startTime = -1L;
      this.endTime = -1L;
      this.QyV = -1L;
      this.QyX = -1L;
      this.nVc = 0;
      this.QyY = 0;
      this.QyZ = -1L;
      this.nAz = 0L;
      this.Qza = new ArrayList();
      this.IYt = false;
      this.Qzb = new HashMap();
      AppMethodBeat.o(95994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.be
 * JD-Core Version:    0.7.0.1
 */