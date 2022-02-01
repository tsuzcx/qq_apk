package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class az
  implements e
{
  private static HashMap<String, b> xXe;
  private static HashMap<String, WeakReference<b>> xXf;
  
  static
  {
    AppMethodBeat.i(96001);
    xXe = new HashMap();
    xXf = new HashMap();
    AppMethodBeat.o(96001);
  }
  
  public static void aub(String paramString)
  {
    AppMethodBeat.i(95995);
    if (ab.iwi) {
      ac.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    paramString = (WeakReference)xXf.get(paramString);
    if (paramString != null)
    {
      paramString = (b)paramString.get();
      if (paramString != null)
      {
        paramString.twy = true;
        AppMethodBeat.o(95995);
        return;
      }
    }
    AppMethodBeat.o(95995);
  }
  
  public static void auc(String paramString)
  {
    AppMethodBeat.i(95997);
    ac.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[] { paramString });
    if (xXe.containsKey(paramString))
    {
      ac.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[] { paramString });
      paramString = (b)xXe.get(paramString);
      if ((paramString != null) && (paramString.xXg == -1L) && (paramString.startTime != -1L))
      {
        paramString.xXg = 1L;
        paramString.xXk = paramString.hlt;
        paramString.endTime = System.currentTimeMillis();
        paramString.xXj = (paramString.endTime - paramString.startTime);
        paramString = paramString.xXn.values().iterator();
        while (paramString.hasNext()) {
          ((a)paramString.next()).xXg = 1L;
        }
      }
    }
    AppMethodBeat.o(95997);
  }
  
  public static void eG(String paramString, int paramInt)
  {
    AppMethodBeat.i(200129);
    if (ab.iwi) {
      ac.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    Object localObject = (WeakReference)xXf.get(paramString);
    if (localObject != null)
    {
      localObject = (b)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if ((localObject != null) && (((b)localObject).xXg == -1L))
        {
          HashMap localHashMap = ((b)localObject).xXn;
          if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
          {
            paramString = (a)localHashMap.get(paramString);
            if ((paramString != null) && (paramString.xXg == -1L))
            {
              paramString.xXg = 1L;
              paramString.mediaType = paramInt;
              ((b)localObject).xXk += 1;
            }
          }
        }
        AppMethodBeat.o(200129);
        return;
      }
    }
    AppMethodBeat.o(200129);
  }
  
  public final void a(String paramString, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(95998);
    if (!xXe.containsKey(paramString))
    {
      if (ab.iwi) {
        ac.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[] { paramString });
      }
      if ((paramTimeLineObject != null) && (paramTimeLineObject.FQo != null) && (paramTimeLineObject.FQo.Ety == 1) && (paramTimeLineObject.FQo.Etz != null) && (paramTimeLineObject.FQo.Etz.size() > 0))
      {
        b localb = new b();
        localb.hlt = paramTimeLineObject.FQo.Etz.size();
        localb.xXk = 0;
        localb.xXl = q.atd(paramTimeLineObject.Id);
        localb.xXn = new HashMap();
        paramTimeLineObject = paramTimeLineObject.FQo.Etz.iterator();
        while (paramTimeLineObject.hasNext())
        {
          btz localbtz = (btz)paramTimeLineObject.next();
          a locala = new a();
          locala.mediaId = localbtz.Id;
          locala.xXh = localbtz.Fjk;
          String str1 = an.jc(af.getAccSnsPath(), localbtz.Id);
          String str2 = q.d(localbtz);
          locala.filePath = (str1 + str2);
          localb.xXm.add(localbtz.Id);
          localb.xXn.put(localbtz.Id, locala);
          xXf.put(localbtz.Id, new WeakReference(localb));
        }
        localb.startTime = System.currentTimeMillis();
        xXe.put(paramString, localb);
        AppMethodBeat.o(95998);
        return;
      }
      if (ab.iwi) {
        ac.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
      }
    }
    AppMethodBeat.o(95998);
  }
  
  public final void atC(String paramString)
  {
    AppMethodBeat.i(95999);
    if (xXe.containsKey(paramString))
    {
      if (ab.iwi) {
        ac.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[] { paramString });
      }
      paramString = (b)xXe.get(paramString);
      if ((paramString != null) && (paramString.startTime != -1L) && (paramString.xXg == -1L))
      {
        paramString.endTime = System.currentTimeMillis();
        paramString.xXj = (paramString.endTime - paramString.startTime);
        if (paramString.xXk == paramString.hlt)
        {
          paramString.xXg = 1L;
          AppMethodBeat.o(95999);
          return;
        }
        paramString.xXg = 2L;
      }
    }
    AppMethodBeat.o(95999);
  }
  
  public final void dHh()
  {
    AppMethodBeat.i(96000);
    ac.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[] { Integer.valueOf(xXe.size()) });
    int k = q.dGB();
    Iterator localIterator1 = xXe.keySet().iterator();
    Object localObject1;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    StringBuilder localStringBuilder3;
    Iterator localIterator2;
    int i;
    label168:
    Object localObject2;
    BitmapFactory.Options localOptions;
    int j;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localObject1 = (String)localIterator1.next();
        localObject1 = (b)xXe.get(localObject1);
        if ((localObject1 != null) && (((b)localObject1).twy)) {
          if ((((b)localObject1).xXj != -1L) && (((b)localObject1).xXg != -1L) && (((b)localObject1).startTime != -1L))
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder2 = new StringBuilder();
            localStringBuilder3 = new StringBuilder();
            localIterator2 = ((b)localObject1).xXm.iterator();
            i = 0;
            if (localIterator2.hasNext())
            {
              localObject2 = (String)localIterator2.next();
              localObject2 = (a)((b)localObject1).xXn.get(localObject2);
              if (localObject2 == null) {
                break label1032;
              }
              localOptions = f.aKw(((a)localObject2).filePath);
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
              i = ((a)localObject2).mediaType;
            }
          }
        }
      }
    }
    label1029:
    label1032:
    for (;;)
    {
      break label168;
      h.wUl.f(11600, new Object[] { Integer.valueOf(((b)localObject1).hlt), Long.valueOf(((b)localObject1).xXg), Long.valueOf(((b)localObject1).xXj), Integer.valueOf(((b)localObject1).xXk), Integer.valueOf(k), Long.valueOf(((b)localObject1).xXl), Long.valueOf(((b)localObject1).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
      ac.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((b)localObject1).hlt), Long.valueOf(((b)localObject1).xXg), Long.valueOf(((b)localObject1).xXj), Integer.valueOf(((b)localObject1).xXk), Integer.valueOf(k), Long.valueOf(((b)localObject1).xXl), Long.valueOf(((b)localObject1).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
      break;
      if (((b)localObject1).startTime == -1L) {
        break;
      }
      ((b)localObject1).endTime = System.currentTimeMillis();
      ((b)localObject1).xXj = (((b)localObject1).endTime - ((b)localObject1).startTime);
      if (((b)localObject1).hlt == ((b)localObject1).xXk)
      {
        ((b)localObject1).xXg = 1L;
        label592:
        localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder3 = new StringBuilder();
        localIterator2 = ((b)localObject1).xXm.iterator();
        i = 0;
        label631:
        if (!localIterator2.hasNext()) {
          break label763;
        }
        localObject2 = (String)localIterator2.next();
        localObject2 = (a)((b)localObject1).xXn.get(localObject2);
        if (localObject2 == null) {
          break label1029;
        }
        localOptions = f.aKw(((a)localObject2).filePath);
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
        i = ((a)localObject2).mediaType;
      }
      for (;;)
      {
        break label631;
        ((b)localObject1).xXg = 2L;
        break label592;
        label763:
        h.wUl.f(11600, new Object[] { Integer.valueOf(((b)localObject1).hlt), Long.valueOf(((b)localObject1).xXg), Long.valueOf(((b)localObject1).xXj), Integer.valueOf(((b)localObject1).xXk), Integer.valueOf(k), Long.valueOf(((b)localObject1).xXl), Long.valueOf(((b)localObject1).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
        ac.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((b)localObject1).hlt), Long.valueOf(((b)localObject1).xXg), Long.valueOf(((b)localObject1).xXj), Integer.valueOf(((b)localObject1).xXk), Integer.valueOf(k), Long.valueOf(((b)localObject1).xXl), Long.valueOf(((b)localObject1).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
        break;
        xXe.clear();
        xXf.clear();
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
    long xXg = -1L;
    bub xXh;
    
    a() {}
  }
  
  final class b
  {
    long endTime;
    int hlt;
    long startTime;
    boolean twy;
    long xXg;
    long xXj;
    int xXk;
    long xXl;
    ArrayList<String> xXm;
    HashMap<String, az.a> xXn;
    
    b()
    {
      AppMethodBeat.i(95994);
      this.startTime = -1L;
      this.endTime = -1L;
      this.xXg = -1L;
      this.xXj = -1L;
      this.hlt = 0;
      this.xXk = 0;
      this.xXl = -1L;
      this.xXm = new ArrayList();
      this.twy = false;
      this.xXn = new HashMap();
      AppMethodBeat.o(95994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.az
 * JD-Core Version:    0.7.0.1
 */