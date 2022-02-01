package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static int NcC = 0;
  public static int NcD = 1;
  public static int NcE = 2;
  
  public static String a(re paramre)
  {
    AppMethodBeat.i(27591);
    if ((paramre == null) || (paramre.YWc == null) || (paramre.YWc.YWe == null))
    {
      AppMethodBeat.o(27591);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramre = paramre.YWc.YWe.iterator();
    while (paramre.hasNext())
    {
      Object localObject = (rg)paramre.next();
      localStringBuilder.append(((rg)localObject).id + "#" + ((rg)localObject).key + ";");
      if (((rg)localObject).YWf != null)
      {
        localObject = ((rg)localObject).YWf.iterator();
        while (((Iterator)localObject).hasNext())
        {
          rg localrg = (rg)((Iterator)localObject).next();
          localStringBuilder.append(localrg.id + "#" + localrg.key + ";");
        }
      }
    }
    localStringBuilder.append("]");
    paramre = localStringBuilder.toString();
    AppMethodBeat.o(27591);
    return paramre;
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Intent paramIntent)
  {
    AppMethodBeat.i(305798);
    if (paramIntent != null) {}
    for (int i = paramIntent.getIntExtra("Contact_Sub_Scene", 0);; i = 0)
    {
      Log.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, subScene=%d, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s, searchId:%s searchClickId:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf((int)(paramLong1 / 1000L)), Integer.valueOf((int)(paramLong2 / 1000L)), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(0), paramString2, paramString3, paramString4, paramString6, paramString7 });
      long l = System.currentTimeMillis();
      h.OAn.b(10298, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(0), paramString2, paramString3, paramString4, Integer.valueOf(ad.getSessionId()), paramString5, paramString6, paramString7, Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(305798);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Intent paramIntent)
  {
    AppMethodBeat.i(305819);
    a(paramString1, paramInt1, afV(paramInt2), 3, paramLong, 0L, paramInt3, paramInt4, paramInt5, paramString2, paramString3, paramString4, "", paramString5, paramString6, paramIntent);
    AppMethodBeat.o(305819);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2, String paramString3, String paramString4, Intent paramIntent)
  {
    AppMethodBeat.i(305809);
    paramInt2 = afV(paramInt2);
    if (paramString2 != null) {}
    for (;;)
    {
      a(paramString1, paramInt1, paramInt2, 1, paramLong, 0L, paramInt3, 0, 0, "", "", "", paramString2, paramString3, paramString4, paramIntent);
      AppMethodBeat.o(305809);
      return;
      paramString2 = "";
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Intent paramIntent)
  {
    AppMethodBeat.i(305814);
    a(paramString1, paramInt1, afV(paramInt2), 2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5, paramString2, paramString3, paramString4, "", paramString5, paramString6, paramIntent);
    AppMethodBeat.o(305814);
  }
  
  private static int afV(int paramInt)
  {
    if (paramInt == 0) {
      return NcD;
    }
    if (paramInt == 1) {
      return NcE;
    }
    return NcC;
  }
  
  public static String b(py parampy)
  {
    AppMethodBeat.i(27590);
    if (parampy == null)
    {
      AppMethodBeat.o(27590);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    parampy = parampy.YUi.iterator();
    while (parampy.hasNext())
    {
      Object localObject = (px)parampy.next();
      if (((px)localObject).YUc != null)
      {
        long l = ((px)localObject).YUc.Njs;
        if (((px)localObject).YUh == null)
        {
          localStringBuilder.append(l).append(";");
        }
        else if (((px)localObject).YUh.YRm != null)
        {
          localObject = ((px)localObject).YUh.YRm.iterator();
          while (((Iterator)localObject).hasNext())
          {
            od localod = (od)((Iterator)localObject).next();
            localStringBuilder.append(l).append("#").append(localod.YQJ).append(";");
          }
        }
      }
    }
    localStringBuilder.append("]");
    parampy = localStringBuilder.toString();
    AppMethodBeat.o(27590);
    return parampy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.a
 * JD-Core Version:    0.7.0.1
 */