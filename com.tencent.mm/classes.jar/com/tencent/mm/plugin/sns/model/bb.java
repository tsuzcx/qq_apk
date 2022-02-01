package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class bb
  implements f
{
  private static ConcurrentHashMap<String, b> zEs;
  private static ConcurrentHashMap<String, WeakReference<b>> zEt;
  
  static
  {
    AppMethodBeat.i(96001);
    zEs = new ConcurrentHashMap();
    zEt = new ConcurrentHashMap();
    AppMethodBeat.o(96001);
  }
  
  public static void aAx(String paramString)
  {
    AppMethodBeat.i(95995);
    if (ac.iSj) {
      ae.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    paramString = (WeakReference)zEt.get(paramString);
    if (paramString != null)
    {
      paramString = (b)paramString.get();
      if (paramString != null)
      {
        paramString.uHj = true;
        AppMethodBeat.o(95995);
        return;
      }
    }
    AppMethodBeat.o(95995);
  }
  
  public static void aAy(String paramString)
  {
    AppMethodBeat.i(95997);
    ae.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[] { paramString });
    if (zEs.containsKey(paramString))
    {
      ae.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[] { paramString });
      paramString = (b)zEs.get(paramString);
      if ((paramString != null) && (paramString.zEv == -1L) && (paramString.startTime != -1L))
      {
        paramString.zEv = 1L;
        paramString.zEy = paramString.hGu;
        paramString.endTime = System.currentTimeMillis();
        paramString.zEx = (paramString.endTime - paramString.startTime);
        paramString = paramString.zEB.values().iterator();
        while (paramString.hasNext()) {
          ((a)paramString.next()).zEv = 1L;
        }
      }
    }
    AppMethodBeat.o(95997);
  }
  
  public static void fh(String paramString, int paramInt)
  {
    AppMethodBeat.i(219361);
    if (ac.iSj) {
      ae.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    Object localObject = (WeakReference)zEt.get(paramString);
    if (localObject != null)
    {
      localObject = (b)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if ((localObject != null) && (((b)localObject).zEv == -1L))
        {
          HashMap localHashMap = ((b)localObject).zEB;
          if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
          {
            paramString = (a)localHashMap.get(paramString);
            if ((paramString != null) && (paramString.zEv == -1L))
            {
              paramString.zEv = 1L;
              paramString.mediaType = paramInt;
              ((b)localObject).zEy += 1;
            }
          }
        }
        AppMethodBeat.o(219361);
        return;
      }
    }
    AppMethodBeat.o(219361);
  }
  
  public final void a(String paramString, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(95998);
    if (!zEs.containsKey(paramString))
    {
      if (ac.iSj) {
        ae.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[] { paramString });
      }
      if ((paramTimeLineObject != null) && (paramTimeLineObject.HUG != null) && (paramTimeLineObject.HUG.Gtw == 1) && (paramTimeLineObject.HUG.Gtx != null) && (paramTimeLineObject.HUG.Gtx.size() > 0))
      {
        b localb = new b();
        localb.hGu = paramTimeLineObject.HUG.Gtx.size();
        localb.zEy = 0;
        localb.zEz = r.azz(paramTimeLineObject.Id);
        localb.zEB = new HashMap();
        paramTimeLineObject = paramTimeLineObject.HUG.Gtx.iterator();
        while (paramTimeLineObject.hasNext())
        {
          bzh localbzh = (bzh)paramTimeLineObject.next();
          a locala = new a();
          locala.mediaId = localbzh.Id;
          locala.zEw = localbzh.Hmm;
          String str1 = ap.jv(ah.getAccSnsPath(), localbzh.Id);
          String str2 = r.d(localbzh);
          locala.filePath = (str1 + str2);
          localb.zEA.add(localbzh.Id);
          localb.zEB.put(localbzh.Id, locala);
          zEt.put(localbzh.Id, new WeakReference(localb));
        }
        localb.startTime = System.currentTimeMillis();
        zEs.put(paramString, localb);
        AppMethodBeat.o(95998);
        return;
      }
      if (ac.iSj) {
        ae.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
      }
    }
    AppMethodBeat.o(95998);
  }
  
  public final void azY(String paramString)
  {
    AppMethodBeat.i(95999);
    if (zEs.containsKey(paramString))
    {
      if (ac.iSj) {
        ae.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[] { paramString });
      }
      paramString = (b)zEs.get(paramString);
      if ((paramString != null) && (paramString.startTime != -1L) && (paramString.zEv == -1L))
      {
        paramString.endTime = System.currentTimeMillis();
        paramString.zEx = (paramString.endTime - paramString.startTime);
        if (paramString.zEy == paramString.hGu)
        {
          paramString.zEv = 1L;
          AppMethodBeat.o(95999);
          return;
        }
        paramString.zEv = 2L;
      }
    }
    AppMethodBeat.o(95999);
  }
  
  public final void bxS()
  {
    AppMethodBeat.i(96000);
    com.tencent.e.h.MqF.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219360);
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
          synchronized (bb.this)
          {
            Iterator localIterator2;
            Object localObject3;
            BitmapFactory.Options localOptions;
            int j;
            try
            {
              ae.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[] { Integer.valueOf(bb.aQT().size()) });
              k = r.dWo();
              Iterator localIterator1 = bb.aQT().keySet().iterator();
              if (!localIterator1.hasNext()) {
                break label1055;
              }
              localObject2 = (String)localIterator1.next();
              localObject2 = (bb.b)bb.aQT().get(localObject2);
              if ((localObject2 == null) || (!((bb.b)localObject2).uHj)) {
                continue;
              }
              if ((((bb.b)localObject2).zEx == -1L) || (((bb.b)localObject2).zEv == -1L) || (((bb.b)localObject2).startTime == -1L)) {
                continue;
              }
              localStringBuilder1 = new StringBuilder();
              localStringBuilder2 = new StringBuilder();
              localStringBuilder3 = new StringBuilder();
              i = 0;
              localIterator2 = ((bb.b)localObject2).zEA.iterator();
              if (localIterator2.hasNext())
              {
                localObject3 = (String)localIterator2.next();
                localObject3 = (bb.a)((bb.b)localObject2).zEB.get(localObject3);
                if (localObject3 == null) {
                  break label1073;
                }
                localOptions = com.tencent.mm.sdk.platformtools.h.aRz(((bb.a)localObject3).filePath);
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
                i = ((bb.a)localObject3).mediaType;
                break label1073;
              }
              g.yxI.f(11600, new Object[] { Integer.valueOf(((bb.b)localObject2).hGu), Long.valueOf(((bb.b)localObject2).zEv), Long.valueOf(((bb.b)localObject2).zEx), Integer.valueOf(((bb.b)localObject2).zEy), Integer.valueOf(k), Long.valueOf(((bb.b)localObject2).zEz), Long.valueOf(((bb.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
              ae.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((bb.b)localObject2).hGu), Long.valueOf(((bb.b)localObject2).zEv), Long.valueOf(((bb.b)localObject2).zEx), Integer.valueOf(((bb.b)localObject2).zEy), Integer.valueOf(k), Long.valueOf(((bb.b)localObject2).zEz), Long.valueOf(((bb.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
              continue;
            }
            catch (Throwable localThrowable)
            {
              ae.e("MicroMsg.TimelineSmallPicStat", "reportAll failed, error : %s", new Object[] { localThrowable.getMessage() });
            }
            AppMethodBeat.o(219360);
            return;
            if (((bb.b)localObject2).startTime == -1L) {
              continue;
            }
            ((bb.b)localObject2).endTime = System.currentTimeMillis();
            ((bb.b)localObject2).zEx = (((bb.b)localObject2).endTime - ((bb.b)localObject2).startTime);
            if (((bb.b)localObject2).hGu == ((bb.b)localObject2).zEy)
            {
              ((bb.b)localObject2).zEv = 1L;
              localStringBuilder1 = new StringBuilder();
              localStringBuilder2 = new StringBuilder();
              localStringBuilder3 = new StringBuilder();
              i = 0;
              localIterator2 = ((bb.b)localObject2).zEA.iterator();
              if (localIterator2.hasNext())
              {
                localObject3 = (String)localIterator2.next();
                localObject3 = (bb.a)((bb.b)localObject2).zEB.get(localObject3);
                if (localObject3 == null) {
                  break label1070;
                }
                localOptions = com.tencent.mm.sdk.platformtools.h.aRz(((bb.a)localObject3).filePath);
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
                i = ((bb.a)localObject3).mediaType;
                break label1076;
              }
            }
            else
            {
              ((bb.b)localObject2).zEv = 2L;
            }
          }
          g.yxI.f(11600, new Object[] { Integer.valueOf(((bb.b)localObject2).hGu), Long.valueOf(((bb.b)localObject2).zEv), Long.valueOf(((bb.b)localObject2).zEx), Integer.valueOf(((bb.b)localObject2).zEy), Integer.valueOf(k), Long.valueOf(((bb.b)localObject2).zEz), Long.valueOf(((bb.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
          ae.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((bb.b)localObject2).hGu), Long.valueOf(((bb.b)localObject2).zEv), Long.valueOf(((bb.b)localObject2).zEx), Integer.valueOf(((bb.b)localObject2).zEy), Integer.valueOf(k), Long.valueOf(((bb.b)localObject2).zEz), Long.valueOf(((bb.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
          continue;
          bb.aQT().clear();
          bb.dYD().clear();
          continue;
          break label1076;
        }
      }
    });
    AppMethodBeat.o(96000);
  }
  
  final class a
  {
    String filePath;
    String mediaId;
    int mediaType;
    long zEv = -1L;
    bzj zEw;
    
    a() {}
  }
  
  final class b
  {
    long endTime;
    int hGu;
    long startTime;
    boolean uHj;
    ArrayList<String> zEA;
    HashMap<String, bb.a> zEB;
    long zEv;
    long zEx;
    int zEy;
    long zEz;
    
    b()
    {
      AppMethodBeat.i(95994);
      this.startTime = -1L;
      this.endTime = -1L;
      this.zEv = -1L;
      this.zEx = -1L;
      this.hGu = 0;
      this.zEy = 0;
      this.zEz = -1L;
      this.zEA = new ArrayList();
      this.uHj = false;
      this.zEB = new HashMap();
      AppMethodBeat.o(95994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bb
 * JD-Core Version:    0.7.0.1
 */