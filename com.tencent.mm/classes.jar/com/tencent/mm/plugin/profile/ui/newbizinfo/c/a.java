package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static int vQG = 0;
  public static int vQH = 1;
  public static int vQI = 2;
  
  private static int LF(int paramInt)
  {
    if (paramInt == 0) {
      return vQH;
    }
    if (paramInt == 1) {
      return vQI;
    }
    return vQG;
  }
  
  public static String a(nu paramnu)
  {
    AppMethodBeat.i(27591);
    if ((paramnu == null) || (paramnu.EdL == null) || (paramnu.EdL.EdO == null))
    {
      AppMethodBeat.o(27591);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramnu = paramnu.EdL.EdO.iterator();
    while (paramnu.hasNext())
    {
      Object localObject = (nw)paramnu.next();
      localStringBuilder.append(((nw)localObject).id + "#" + ((nw)localObject).key + ";");
      if (((nw)localObject).EdP != null)
      {
        localObject = ((nw)localObject).EdP.iterator();
        while (((Iterator)localObject).hasNext())
        {
          nw localnw = (nw)((Iterator)localObject).next();
          localStringBuilder.append(localnw.id + "#" + localnw.key + ";");
        }
      }
    }
    localStringBuilder.append("]");
    paramnu = localStringBuilder.toString();
    AppMethodBeat.o(27591);
    return paramnu;
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(169760);
    ac.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4 });
    h.wUl.f(10298, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4, Integer.valueOf(v.getSessionId()), paramString5 });
    AppMethodBeat.o(169760);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27589);
    a(paramString1, paramInt1, LF(paramInt2), 3, paramLong, 0L, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27589);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(169761);
    paramInt2 = LF(paramInt2);
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
    a(paramString1, paramInt1, LF(paramInt2), 2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27588);
  }
  
  public static String b(nd paramnd)
  {
    AppMethodBeat.i(27590);
    if (paramnd == null)
    {
      AppMethodBeat.o(27590);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramnd = paramnd.EcV.iterator();
    while (paramnd.hasNext())
    {
      Object localObject = (nc)paramnd.next();
      if (((nc)localObject).EcP != null)
      {
        long l = ((nc)localObject).EcP.vTO;
        if (((nc)localObject).EcU == null)
        {
          localStringBuilder.append(l).append(";");
        }
        else if (((nc)localObject).EcU.EaL != null)
        {
          localObject = ((nc)localObject).EcU.EaL.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ly locally = (ly)((Iterator)localObject).next();
            localStringBuilder.append(l).append("#").append(locally.Eam).append(";");
          }
        }
      }
    }
    localStringBuilder.append("]");
    paramnd = localStringBuilder.toString();
    AppMethodBeat.o(27590);
    return paramnd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.a
 * JD-Core Version:    0.7.0.1
 */