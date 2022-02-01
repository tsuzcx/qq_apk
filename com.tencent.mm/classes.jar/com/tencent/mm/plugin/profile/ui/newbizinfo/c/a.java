package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static int wXQ = 0;
  public static int wXR = 1;
  public static int wXS = 2;
  
  private static int Nh(int paramInt)
  {
    if (paramInt == 0) {
      return wXR;
    }
    if (paramInt == 1) {
      return wXS;
    }
    return wXQ;
  }
  
  public static String a(oz paramoz)
  {
    AppMethodBeat.i(27591);
    if ((paramoz == null) || (paramoz.FKk == null) || (paramoz.FKk.FKn == null))
    {
      AppMethodBeat.o(27591);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramoz = paramoz.FKk.FKn.iterator();
    while (paramoz.hasNext())
    {
      Object localObject = (pb)paramoz.next();
      localStringBuilder.append(((pb)localObject).id + "#" + ((pb)localObject).key + ";");
      if (((pb)localObject).FKo != null)
      {
        localObject = ((pb)localObject).FKo.iterator();
        while (((Iterator)localObject).hasNext())
        {
          pb localpb = (pb)((Iterator)localObject).next();
          localStringBuilder.append(localpb.id + "#" + localpb.key + ";");
        }
      }
    }
    localStringBuilder.append("]");
    paramoz = localStringBuilder.toString();
    AppMethodBeat.o(27591);
    return paramoz;
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(169760);
    ad.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4 });
    g.yhR.f(10298, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4, Integer.valueOf(y.getSessionId()), paramString5 });
    AppMethodBeat.o(169760);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27589);
    a(paramString1, paramInt1, Nh(paramInt2), 3, paramLong, 0L, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27589);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(169761);
    paramInt2 = Nh(paramInt2);
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
    a(paramString1, paramInt1, Nh(paramInt2), 2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27588);
  }
  
  public static String b(nz paramnz)
  {
    AppMethodBeat.i(27590);
    if (paramnz == null)
    {
      AppMethodBeat.o(27590);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramnz = paramnz.FIZ.iterator();
    while (paramnz.hasNext())
    {
      Object localObject = (ny)paramnz.next();
      if (((ny)localObject).FIT != null)
      {
        long l = ((ny)localObject).FIT.xbr;
        if (((ny)localObject).FIY == null)
        {
          localStringBuilder.append(l).append(";");
        }
        else if (((ny)localObject).FIY.FGu != null)
        {
          localObject = ((ny)localObject).FIY.FGu.iterator();
          while (((Iterator)localObject).hasNext())
          {
            mn localmn = (mn)((Iterator)localObject).next();
            localStringBuilder.append(l).append("#").append(localmn.FFV).append(";");
          }
        }
      }
    }
    localStringBuilder.append("]");
    paramnz = localStringBuilder.toString();
    AppMethodBeat.o(27590);
    return paramnz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.a
 * JD-Core Version:    0.7.0.1
 */