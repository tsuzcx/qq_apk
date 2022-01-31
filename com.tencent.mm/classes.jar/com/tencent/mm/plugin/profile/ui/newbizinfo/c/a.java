package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.s;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static int pFB = 0;
  public static int pFC = 1;
  public static int pFD = 2;
  
  private static int BR(int paramInt)
  {
    if (paramInt == 0) {
      return pFC;
    }
    if (paramInt == 1) {
      return pFD;
    }
    return pFB;
  }
  
  public static String a(lt paramlt)
  {
    AppMethodBeat.i(153604);
    if ((paramlt == null) || (paramlt.wAm == null) || (paramlt.wAm.wAp == null))
    {
      AppMethodBeat.o(153604);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramlt = paramlt.wAm.wAp.iterator();
    while (paramlt.hasNext())
    {
      Object localObject = (lv)paramlt.next();
      localStringBuilder.append(((lv)localObject).id + "#" + ((lv)localObject).key + ";");
      if (((lv)localObject).wAq != null)
      {
        localObject = ((lv)localObject).wAq.iterator();
        while (((Iterator)localObject).hasNext())
        {
          lv locallv = (lv)((Iterator)localObject).next();
          localStringBuilder.append(locallv.id + "#" + locallv.key + ";");
        }
      }
    }
    localStringBuilder.append("]");
    paramlt = localStringBuilder.toString();
    AppMethodBeat.o(153604);
    return paramlt;
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23949);
    ab.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4 });
    h.qsU.e(10298, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4, Integer.valueOf(s.getSessionId()) });
    AppMethodBeat.o(23949);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(23950);
    a(paramString, paramInt1, BR(paramInt2), 1, paramLong, 0L, paramInt3, 0, 0, 0, "", "", "");
    AppMethodBeat.o(23950);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23952);
    a(paramString1, paramInt1, BR(paramInt2), 3, paramLong, 0L, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4);
    AppMethodBeat.o(23952);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23951);
    a(paramString1, paramInt1, BR(paramInt2), 2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4);
    AppMethodBeat.o(23951);
  }
  
  public static String b(lg paramlg)
  {
    AppMethodBeat.i(153603);
    if (paramlg == null)
    {
      AppMethodBeat.o(153603);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramlg = paramlg.wzA.iterator();
    while (paramlg.hasNext())
    {
      Object localObject = (lf)paramlg.next();
      if (((lf)localObject).wzu != null)
      {
        long l = ((lf)localObject).wzu.pIE;
        if (((lf)localObject).wzz == null)
        {
          localStringBuilder.append(l).append(";");
        }
        else if (((lf)localObject).wzz.wxG != null)
        {
          localObject = ((lf)localObject).wzz.wxG.iterator();
          while (((Iterator)localObject).hasNext())
          {
            kf localkf = (kf)((Iterator)localObject).next();
            localStringBuilder.append(l).append("#").append(localkf.wxh).append(";");
          }
        }
      }
    }
    localStringBuilder.append("]");
    paramlg = localStringBuilder.toString();
    AppMethodBeat.o(153603);
    return paramlg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.a
 * JD-Core Version:    0.7.0.1
 */