package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.u;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static int uHP = 0;
  public static int uHQ = 1;
  public static int uHR = 2;
  
  private static int JG(int paramInt)
  {
    if (paramInt == 0) {
      return uHQ;
    }
    if (paramInt == 1) {
      return uHR;
    }
    return uHP;
  }
  
  public static String a(nn paramnn)
  {
    AppMethodBeat.i(27591);
    if ((paramnn == null) || (paramnn.CLj == null) || (paramnn.CLj.CLm == null))
    {
      AppMethodBeat.o(27591);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramnn = paramnn.CLj.CLm.iterator();
    while (paramnn.hasNext())
    {
      Object localObject = (np)paramnn.next();
      localStringBuilder.append(((np)localObject).id + "#" + ((np)localObject).key + ";");
      if (((np)localObject).CLn != null)
      {
        localObject = ((np)localObject).CLn.iterator();
        while (((Iterator)localObject).hasNext())
        {
          np localnp = (np)((Iterator)localObject).next();
          localStringBuilder.append(localnp.id + "#" + localnp.key + ";");
        }
      }
    }
    localStringBuilder.append("]");
    paramnn = localStringBuilder.toString();
    AppMethodBeat.o(27591);
    return paramnn;
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(169760);
    ad.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4 });
    h.vKh.f(10298, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4, Integer.valueOf(u.getSessionId()), paramString5 });
    AppMethodBeat.o(169760);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27589);
    a(paramString1, paramInt1, JG(paramInt2), 3, paramLong, 0L, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27589);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(169761);
    paramInt2 = JG(paramInt2);
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
    a(paramString1, paramInt1, JG(paramInt2), 2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4, "");
    AppMethodBeat.o(27588);
  }
  
  public static String b(mw parammw)
  {
    AppMethodBeat.i(27590);
    if (parammw == null)
    {
      AppMethodBeat.o(27590);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    parammw = parammw.CKt.iterator();
    while (parammw.hasNext())
    {
      Object localObject = (mv)parammw.next();
      if (((mv)localObject).CKn != null)
      {
        long l = ((mv)localObject).CKn.uKX;
        if (((mv)localObject).CKs == null)
        {
          localStringBuilder.append(l).append(";");
        }
        else if (((mv)localObject).CKs.CIj != null)
        {
          localObject = ((mv)localObject).CKs.CIj.iterator();
          while (((Iterator)localObject).hasNext())
          {
            lr locallr = (lr)((Iterator)localObject).next();
            localStringBuilder.append(l).append("#").append(locallr.CHK).append(";");
          }
        }
      }
    }
    localStringBuilder.append("]");
    parammw = localStringBuilder.toString();
    AppMethodBeat.o(27590);
    return parammw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.a
 * JD-Core Version:    0.7.0.1
 */