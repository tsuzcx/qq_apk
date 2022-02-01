package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
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

public final class bc
  implements f
{
  private static ConcurrentHashMap<String, b> KbC;
  private static ConcurrentHashMap<String, WeakReference<b>> KbD;
  
  static
  {
    AppMethodBeat.i(96001);
    KbC = new ConcurrentHashMap();
    KbD = new ConcurrentHashMap();
    AppMethodBeat.o(96001);
  }
  
  public static void bap(String paramString)
  {
    AppMethodBeat.i(95995);
    if (ac.mGo) {
      Log.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    paramString = (WeakReference)KbD.get(paramString);
    if (paramString != null)
    {
      paramString = (b)paramString.get();
      if (paramString != null)
      {
        paramString.Dec = true;
        AppMethodBeat.o(95995);
        return;
      }
    }
    AppMethodBeat.o(95995);
  }
  
  public static void baq(String paramString)
  {
    AppMethodBeat.i(95997);
    Log.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[] { paramString });
    if (KbC.containsKey(paramString))
    {
      Log.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[] { paramString });
      paramString = (b)KbC.get(paramString);
      if ((paramString != null) && (paramString.KbF == -1L) && (paramString.startTime != -1L))
      {
        paramString.KbF = 1L;
        paramString.KbI = paramString.lqa;
        paramString.endTime = System.currentTimeMillis();
        paramString.KbH = (paramString.endTime - paramString.startTime);
        paramString = paramString.KbL.values().iterator();
        while (paramString.hasNext()) {
          ((a)paramString.next()).KbF = 1L;
        }
      }
    }
    AppMethodBeat.o(95997);
  }
  
  public static void gi(String paramString, int paramInt)
  {
    AppMethodBeat.i(199890);
    if (ac.mGo) {
      Log.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    Object localObject = (WeakReference)KbD.get(paramString);
    if (localObject != null)
    {
      localObject = (b)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if ((localObject != null) && (((b)localObject).KbF == -1L))
        {
          HashMap localHashMap = ((b)localObject).KbL;
          if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
          {
            paramString = (a)localHashMap.get(paramString);
            if ((paramString != null) && (paramString.KbF == -1L))
            {
              paramString.KbF = 1L;
              paramString.mediaType = paramInt;
              ((b)localObject).KbI += 1;
            }
          }
        }
        AppMethodBeat.o(199890);
        return;
      }
    }
    AppMethodBeat.o(199890);
  }
  
  public final void a(String paramString, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(95998);
    if (!KbC.containsKey(paramString))
    {
      if (ac.mGo) {
        Log.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[] { paramString });
      }
      if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Sqq == 1) && (paramTimeLineObject.ContentObj.Sqr != null) && (paramTimeLineObject.ContentObj.Sqr.size() > 0))
      {
        b localb = new b();
        localb.lqa = paramTimeLineObject.ContentObj.Sqr.size();
        localb.KbI = 0;
        localb.KbJ = t.aZs(paramTimeLineObject.Id);
        localb.KbL = new HashMap();
        paramTimeLineObject = paramTimeLineObject.ContentObj.Sqr.iterator();
        while (paramTimeLineObject.hasNext())
        {
          cvt localcvt = (cvt)paramTimeLineObject.next();
          a locala = new a();
          locala.mediaId = localcvt.Id;
          locala.KbG = localcvt.TDH;
          String str1 = aq.kD(aj.getAccSnsPath(), localcvt.Id);
          String str2 = t.d(localcvt);
          locala.filePath = (str1 + str2);
          localb.KbK.add(localcvt.Id);
          localb.KbL.put(localcvt.Id, locala);
          KbD.put(localcvt.Id, new WeakReference(localb));
        }
        localb.startTime = System.currentTimeMillis();
        KbC.put(paramString, localb);
        AppMethodBeat.o(95998);
        return;
      }
      if (ac.mGo) {
        Log.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
      }
    }
    AppMethodBeat.o(95998);
  }
  
  public final void aZP(String paramString)
  {
    AppMethodBeat.i(95999);
    if (KbC.containsKey(paramString))
    {
      if (ac.mGo) {
        Log.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[] { paramString });
      }
      paramString = (b)KbC.get(paramString);
      if ((paramString != null) && (paramString.startTime != -1L) && (paramString.KbF == -1L))
      {
        paramString.endTime = System.currentTimeMillis();
        paramString.KbH = (paramString.endTime - paramString.startTime);
        if (paramString.KbI == paramString.lqa)
        {
          paramString.KbF = 1L;
          AppMethodBeat.o(95999);
          return;
        }
        paramString.KbF = 2L;
      }
    }
    AppMethodBeat.o(95999);
  }
  
  public final void fNV()
  {
    AppMethodBeat.i(96000);
    com.tencent.e.h.ZvG.bf(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269002);
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
          synchronized (bc.this)
          {
            Iterator localIterator2;
            Object localObject3;
            BitmapFactory.Options localOptions;
            int j;
            try
            {
              Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[] { Integer.valueOf(bc.bvo().size()) });
              k = t.fNo();
              Iterator localIterator1 = bc.bvo().keySet().iterator();
              if (!localIterator1.hasNext()) {
                break label1055;
              }
              localObject2 = (String)localIterator1.next();
              localObject2 = (bc.b)bc.bvo().get(localObject2);
              if ((localObject2 == null) || (!((bc.b)localObject2).Dec)) {
                continue;
              }
              if ((((bc.b)localObject2).KbH == -1L) || (((bc.b)localObject2).KbF == -1L) || (((bc.b)localObject2).startTime == -1L)) {
                continue;
              }
              localStringBuilder1 = new StringBuilder();
              localStringBuilder2 = new StringBuilder();
              localStringBuilder3 = new StringBuilder();
              i = 0;
              localIterator2 = ((bc.b)localObject2).KbK.iterator();
              if (localIterator2.hasNext())
              {
                localObject3 = (String)localIterator2.next();
                localObject3 = (bc.a)((bc.b)localObject2).KbL.get(localObject3);
                if (localObject3 == null) {
                  break label1073;
                }
                localOptions = BitmapUtil.getImageOptions(((bc.a)localObject3).filePath);
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
                i = ((bc.a)localObject3).mediaType;
                break label1073;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(11600, new Object[] { Integer.valueOf(((bc.b)localObject2).lqa), Long.valueOf(((bc.b)localObject2).KbF), Long.valueOf(((bc.b)localObject2).KbH), Integer.valueOf(((bc.b)localObject2).KbI), Integer.valueOf(k), Long.valueOf(((bc.b)localObject2).KbJ), Long.valueOf(((bc.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
              Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((bc.b)localObject2).lqa), Long.valueOf(((bc.b)localObject2).KbF), Long.valueOf(((bc.b)localObject2).KbH), Integer.valueOf(((bc.b)localObject2).KbI), Integer.valueOf(k), Long.valueOf(((bc.b)localObject2).KbJ), Long.valueOf(((bc.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
              continue;
            }
            catch (Throwable localThrowable)
            {
              Log.e("MicroMsg.TimelineSmallPicStat", "reportAll failed, error : %s", new Object[] { localThrowable.getMessage() });
            }
            AppMethodBeat.o(269002);
            return;
            if (((bc.b)localObject2).startTime == -1L) {
              continue;
            }
            ((bc.b)localObject2).endTime = System.currentTimeMillis();
            ((bc.b)localObject2).KbH = (((bc.b)localObject2).endTime - ((bc.b)localObject2).startTime);
            if (((bc.b)localObject2).lqa == ((bc.b)localObject2).KbI)
            {
              ((bc.b)localObject2).KbF = 1L;
              localStringBuilder1 = new StringBuilder();
              localStringBuilder2 = new StringBuilder();
              localStringBuilder3 = new StringBuilder();
              i = 0;
              localIterator2 = ((bc.b)localObject2).KbK.iterator();
              if (localIterator2.hasNext())
              {
                localObject3 = (String)localIterator2.next();
                localObject3 = (bc.a)((bc.b)localObject2).KbL.get(localObject3);
                if (localObject3 == null) {
                  break label1070;
                }
                localOptions = BitmapUtil.getImageOptions(((bc.a)localObject3).filePath);
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
                i = ((bc.a)localObject3).mediaType;
                break label1076;
              }
            }
            else
            {
              ((bc.b)localObject2).KbF = 2L;
            }
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(11600, new Object[] { Integer.valueOf(((bc.b)localObject2).lqa), Long.valueOf(((bc.b)localObject2).KbF), Long.valueOf(((bc.b)localObject2).KbH), Integer.valueOf(((bc.b)localObject2).KbI), Integer.valueOf(k), Long.valueOf(((bc.b)localObject2).KbJ), Long.valueOf(((bc.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
          Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((bc.b)localObject2).lqa), Long.valueOf(((bc.b)localObject2).KbF), Long.valueOf(((bc.b)localObject2).KbH), Integer.valueOf(((bc.b)localObject2).KbI), Integer.valueOf(k), Long.valueOf(((bc.b)localObject2).KbJ), Long.valueOf(((bc.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
          continue;
          bc.bvo().clear();
          bc.fPJ().clear();
          continue;
          break label1076;
        }
      }
    });
    AppMethodBeat.o(96000);
  }
  
  final class a
  {
    long KbF = -1L;
    cvv KbG;
    String filePath;
    String mediaId;
    int mediaType;
    
    a() {}
  }
  
  final class b
  {
    boolean Dec;
    long KbF;
    long KbH;
    int KbI;
    long KbJ;
    ArrayList<String> KbK;
    HashMap<String, bc.a> KbL;
    long endTime;
    int lqa;
    long startTime;
    
    b()
    {
      AppMethodBeat.i(95994);
      this.startTime = -1L;
      this.endTime = -1L;
      this.KbF = -1L;
      this.KbH = -1L;
      this.lqa = 0;
      this.KbI = 0;
      this.KbJ = -1L;
      this.KbK = new ArrayList();
      this.Dec = false;
      this.KbL = new HashMap();
      AppMethodBeat.o(95994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bc
 * JD-Core Version:    0.7.0.1
 */