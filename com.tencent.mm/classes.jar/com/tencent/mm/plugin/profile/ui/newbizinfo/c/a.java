package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static int BlI = 0;
  public static int BlJ = 1;
  public static int BlK = 2;
  
  private static int Vc(int paramInt)
  {
    if (paramInt == 0) {
      return BlJ;
    }
    if (paramInt == 1) {
      return BlK;
    }
    return BlI;
  }
  
  public static String a(py parampy)
  {
    AppMethodBeat.i(27591);
    if ((parampy == null) || (parampy.KWP == null) || (parampy.KWP.KWS == null))
    {
      AppMethodBeat.o(27591);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    parampy = parampy.KWP.KWS.iterator();
    while (parampy.hasNext())
    {
      Object localObject = (qa)parampy.next();
      localStringBuilder.append(((qa)localObject).id + "#" + ((qa)localObject).key + ";");
      if (((qa)localObject).KWT != null)
      {
        localObject = ((qa)localObject).KWT.iterator();
        while (((Iterator)localObject).hasNext())
        {
          qa localqa = (qa)((Iterator)localObject).next();
          localStringBuilder.append(localqa.id + "#" + localqa.key + ";");
        }
      }
    }
    localStringBuilder.append("]");
    parampy = localStringBuilder.toString();
    AppMethodBeat.o(27591);
    return parampy;
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(169760);
    Log.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4 });
    h.CyF.a(10298, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4, Integer.valueOf(ab.getSessionId()), paramString5 });
    AppMethodBeat.o(169760);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27589);
    a(paramString1, paramInt1, Vc(paramInt2), 3, paramLong, 0L, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27589);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(169761);
    paramInt2 = Vc(paramInt2);
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
    a(paramString1, paramInt1, Vc(paramInt2), 2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27588);
  }
  
  public static String c(ov paramov)
  {
    AppMethodBeat.i(27590);
    if (paramov == null)
    {
      AppMethodBeat.o(27590);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramov = paramov.KVw.iterator();
    while (paramov.hasNext())
    {
      Object localObject = (ou)paramov.next();
      if (((ou)localObject).KVq != null)
      {
        long l = ((ou)localObject).KVq.Brl;
        if (((ou)localObject).KVv == null)
        {
          localStringBuilder.append(l).append(";");
        }
        else if (((ou)localObject).KVv.KSK != null)
        {
          localObject = ((ou)localObject).KVv.KSK.iterator();
          while (((Iterator)localObject).hasNext())
          {
            nh localnh = (nh)((Iterator)localObject).next();
            localStringBuilder.append(l).append("#").append(localnh.KSi).append(";");
          }
        }
      }
    }
    localStringBuilder.append("]");
    paramov = localStringBuilder.toString();
    AppMethodBeat.o(27590);
    return paramov;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.a
 * JD-Core Version:    0.7.0.1
 */