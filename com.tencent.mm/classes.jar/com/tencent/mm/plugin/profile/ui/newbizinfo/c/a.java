package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.ob;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static int xnH = 0;
  public static int xnI = 1;
  public static int xnJ = 2;
  
  private static int NN(int paramInt)
  {
    if (paramInt == 0) {
      return xnI;
    }
    if (paramInt == 1) {
      return xnJ;
    }
    return xnH;
  }
  
  public static String a(pb parampb)
  {
    AppMethodBeat.i(27591);
    if ((parampb == null) || (parampb.GcJ == null) || (parampb.GcJ.GcM == null))
    {
      AppMethodBeat.o(27591);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    parampb = parampb.GcJ.GcM.iterator();
    while (parampb.hasNext())
    {
      Object localObject = (pd)parampb.next();
      localStringBuilder.append(((pd)localObject).id + "#" + ((pd)localObject).key + ";");
      if (((pd)localObject).GcN != null)
      {
        localObject = ((pd)localObject).GcN.iterator();
        while (((Iterator)localObject).hasNext())
        {
          pd localpd = (pd)((Iterator)localObject).next();
          localStringBuilder.append(localpd.id + "#" + localpd.key + ";");
        }
      }
    }
    localStringBuilder.append("]");
    parampb = localStringBuilder.toString();
    AppMethodBeat.o(27591);
    return parampb;
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(169760);
    ae.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4 });
    g.yxI.f(10298, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4, Integer.valueOf(y.getSessionId()), paramString5 });
    AppMethodBeat.o(169760);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27589);
    a(paramString1, paramInt1, NN(paramInt2), 3, paramLong, 0L, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27589);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(169761);
    paramInt2 = NN(paramInt2);
    if (paramString2 != null) {}
    for (;;)
    {
      a(paramString1, paramInt1, paramInt2, 1, paramLong, 0L, paramInt3, 0, 0, 0, "", "", "", paramString2);
      AppMethodBeat.o(169761);
      return;
      paramString2 = "";
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27588);
    a(paramString1, paramInt1, NN(paramInt2), 2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27588);
  }
  
  public static String b(ob paramob)
  {
    AppMethodBeat.i(27590);
    if (paramob == null)
    {
      AppMethodBeat.o(27590);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramob = paramob.Gby.iterator();
    while (paramob.hasNext())
    {
      Object localObject = (oa)paramob.next();
      if (((oa)localObject).Gbs != null)
      {
        long l = ((oa)localObject).Gbs.xri;
        if (((oa)localObject).Gbx == null)
        {
          localStringBuilder.append(l).append(";");
        }
        else if (((oa)localObject).Gbx.FYQ != null)
        {
          localObject = ((oa)localObject).Gbx.FYQ.iterator();
          while (((Iterator)localObject).hasNext())
          {
            mp localmp = (mp)((Iterator)localObject).next();
            localStringBuilder.append(l).append("#").append(localmp.FYr).append(";");
          }
        }
      }
    }
    localStringBuilder.append("]");
    paramob = localStringBuilder.toString();
    AppMethodBeat.o(27590);
    return paramob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.a
 * JD-Core Version:    0.7.0.1
 */