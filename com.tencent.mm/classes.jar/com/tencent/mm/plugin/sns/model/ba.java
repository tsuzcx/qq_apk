package com.tencent.mm.plugin.sns.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class ba
  implements e
{
  private static ConcurrentHashMap<String, b> OdF;
  private static ConcurrentHashMap<String, WeakReference<b>> OdG;
  
  static
  {
    AppMethodBeat.i(96001);
    OdF = new ConcurrentHashMap();
    OdG = new ConcurrentHashMap();
    AppMethodBeat.o(96001);
  }
  
  public static void azg(String paramString)
  {
    AppMethodBeat.i(95995);
    if (ac.iPp) {
      ad.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    paramString = (WeakReference)OdG.get(paramString);
    if (paramString != null)
    {
      paramString = (b)paramString.get();
      if (paramString != null)
      {
        paramString.uvK = true;
        AppMethodBeat.o(95995);
        return;
      }
    }
    AppMethodBeat.o(95995);
  }
  
  public static void azh(String paramString)
  {
    AppMethodBeat.i(95997);
    ad.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[] { paramString });
    if (OdF.containsKey(paramString))
    {
      ad.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[] { paramString });
      paramString = (b)OdF.get(paramString);
      if ((paramString != null) && (paramString.znf == -1L) && (paramString.startTime != -1L))
      {
        paramString.znf = 1L;
        paramString.znj = paramString.hDC;
        paramString.endTime = System.currentTimeMillis();
        paramString.zni = (paramString.endTime - paramString.startTime);
        paramString = paramString.znm.values().iterator();
        while (paramString.hasNext()) {
          ((a)paramString.next()).znf = 1L;
        }
      }
    }
    AppMethodBeat.o(95997);
  }
  
  public static void eY(String paramString, int paramInt)
  {
    AppMethodBeat.i(197867);
    if (ac.iPp) {
      ad.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[] { paramString });
    }
    Object localObject = (WeakReference)OdG.get(paramString);
    if (localObject != null)
    {
      localObject = (b)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if ((localObject != null) && (((b)localObject).znf == -1L))
        {
          HashMap localHashMap = ((b)localObject).znm;
          if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
          {
            paramString = (a)localHashMap.get(paramString);
            if ((paramString != null) && (paramString.znf == -1L))
            {
              paramString.znf = 1L;
              paramString.mediaType = paramInt;
              ((b)localObject).znj += 1;
            }
          }
        }
        AppMethodBeat.o(197867);
        return;
      }
    }
    AppMethodBeat.o(197867);
  }
  
  public final void a(String paramString, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(95998);
    if (!OdF.containsKey(paramString))
    {
      if (ac.iPp) {
        ad.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[] { paramString });
      }
      if ((paramTimeLineObject != null) && (paramTimeLineObject.HAT != null) && (paramTimeLineObject.HAT.GaP == 1) && (paramTimeLineObject.HAT.GaQ != null) && (paramTimeLineObject.HAT.GaQ.size() > 0))
      {
        b localb = new b();
        localb.hDC = paramTimeLineObject.HAT.GaQ.size();
        localb.znj = 0;
        localb.znk = q.ayi(paramTimeLineObject.Id);
        localb.znm = new HashMap();
        paramTimeLineObject = paramTimeLineObject.HAT.GaQ.iterator();
        while (paramTimeLineObject.hasNext())
        {
          byn localbyn = (byn)paramTimeLineObject.next();
          a locala = new a();
          locala.mediaId = localbyn.Id;
          locala.zng = localbyn.GSL;
          String str1 = ao.jo(ag.getAccSnsPath(), localbyn.Id);
          String str2 = q.d(localbyn);
          locala.filePath = (str1 + str2);
          localb.znl.add(localbyn.Id);
          localb.znm.put(localbyn.Id, locala);
          OdG.put(localbyn.Id, new WeakReference(localb));
        }
        localb.startTime = System.currentTimeMillis();
        OdF.put(paramString, localb);
        AppMethodBeat.o(95998);
        return;
      }
      if (ac.iPp) {
        ad.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
      }
    }
    AppMethodBeat.o(95998);
  }
  
  public final void ayH(String paramString)
  {
    AppMethodBeat.i(95999);
    if (OdF.containsKey(paramString))
    {
      if (ac.iPp) {
        ad.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[] { paramString });
      }
      paramString = (b)OdF.get(paramString);
      if ((paramString != null) && (paramString.startTime != -1L) && (paramString.znf == -1L))
      {
        paramString.endTime = System.currentTimeMillis();
        paramString.zni = (paramString.endTime - paramString.startTime);
        if (paramString.znj == paramString.hDC)
        {
          paramString.znf = 1L;
          AppMethodBeat.o(95999);
          return;
        }
        paramString.znf = 2L;
      }
    }
    AppMethodBeat.o(95999);
  }
  
  public final void bwZ()
  {
    AppMethodBeat.i(96000);
    h.LTJ.aS(new ba.1(this));
    AppMethodBeat.o(96000);
  }
  
  final class a
  {
    String filePath;
    String mediaId;
    int mediaType;
    long znf = -1L;
    byp zng;
    
    a() {}
  }
  
  final class b
  {
    long endTime;
    int hDC;
    long startTime;
    boolean uvK;
    long znf;
    long zni;
    int znj;
    long znk;
    ArrayList<String> znl;
    HashMap<String, ba.a> znm;
    
    b()
    {
      AppMethodBeat.i(95994);
      this.startTime = -1L;
      this.endTime = -1L;
      this.znf = -1L;
      this.zni = -1L;
      this.hDC = 0;
      this.znj = 0;
      this.znk = -1L;
      this.znl = new ArrayList();
      this.uvK = false;
      this.znm = new HashMap();
      AppMethodBeat.o(95994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ba
 * JD-Core Version:    0.7.0.1
 */