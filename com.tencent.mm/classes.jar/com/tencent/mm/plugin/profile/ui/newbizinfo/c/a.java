package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static int HfT = 0;
  public static int HfU = 1;
  public static int HfV = 2;
  
  public static String a(pu parampu)
  {
    AppMethodBeat.i(27591);
    if ((parampu == null) || (parampu.RYd == null) || (parampu.RYd.RYf == null))
    {
      AppMethodBeat.o(27591);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    parampu = parampu.RYd.RYf.iterator();
    while (parampu.hasNext())
    {
      Object localObject = (pw)parampu.next();
      localStringBuilder.append(((pw)localObject).id + "#" + ((pw)localObject).key + ";");
      if (((pw)localObject).RYg != null)
      {
        localObject = ((pw)localObject).RYg.iterator();
        while (((Iterator)localObject).hasNext())
        {
          pw localpw = (pw)((Iterator)localObject).next();
          localStringBuilder.append(localpw.id + "#" + localpw.key + ";");
        }
      }
    }
    localStringBuilder.append("]");
    parampu = localStringBuilder.toString();
    AppMethodBeat.o(27591);
    return parampu;
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(169760);
    Log.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4 });
    h.IzE.a(10298, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4, Integer.valueOf(ab.getSessionId()), paramString5 });
    AppMethodBeat.o(169760);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27589);
    a(paramString1, paramInt1, abI(paramInt2), 3, paramLong, 0L, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27589);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(169761);
    paramInt2 = abI(paramInt2);
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
    a(paramString1, paramInt1, abI(paramInt2), 2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27588);
  }
  
  private static int abI(int paramInt)
  {
    if (paramInt == 0) {
      return HfU;
    }
    if (paramInt == 1) {
      return HfV;
    }
    return HfT;
  }
  
  public static String c(op paramop)
  {
    AppMethodBeat.i(27590);
    if (paramop == null)
    {
      AppMethodBeat.o(27590);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramop = paramop.RWC.iterator();
    while (paramop.hasNext())
    {
      Object localObject = (oo)paramop.next();
      if (((oo)localObject).RWw != null)
      {
        long l = ((oo)localObject).RWw.HlE;
        if (((oo)localObject).RWB == null)
        {
          localStringBuilder.append(l).append(";");
        }
        else if (((oo)localObject).RWB.RTM != null)
        {
          localObject = ((oo)localObject).RWB.RTM.iterator();
          while (((Iterator)localObject).hasNext())
          {
            my localmy = (my)((Iterator)localObject).next();
            localStringBuilder.append(l).append("#").append(localmy.RTj).append(";");
          }
        }
      }
    }
    localStringBuilder.append("]");
    paramop = localStringBuilder.toString();
    AppMethodBeat.o(27590);
    return paramop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.a
 * JD-Core Version:    0.7.0.1
 */