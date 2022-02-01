package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.a;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static void D(long paramLong, String paramString)
  {
    AppMethodBeat.i(30305);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(30305);
      return;
    }
    gt localgt = new gt();
    localgt.dhx.type = 34;
    localgt.dhx.dcg = paramLong;
    a.GpY.l(localgt);
    if (localgt.dhx.dcm == null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    if ((localgt.dhx.dcm.nxC == null) || (localgt.dhx.dcm.nxC.size() <= 1))
    {
      AppMethodBeat.o(30305);
      return;
    }
    if (((agx)localgt.dhx.dcm.nxC.get(0)).EAh != null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    ac.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
    if ((!bs.isNullOrNil(paramString)) && (i.eA(paramString))) {
      try
      {
        paramString = i.aSr(paramString);
        a(localgt.dhx.dcm, paramLong, paramString);
        AppMethodBeat.o(30305);
        return;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(30305);
  }
  
  public static String R(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30300);
    gt localgt = new gt();
    localgt.dhx.type = 21;
    localgt.dhx.context = paramContext;
    localgt.dhx.dhF = paramInt;
    a.GpY.l(localgt);
    paramContext = localgt.dhy.path;
    AppMethodBeat.o(30300);
    return paramContext;
  }
  
  public static String Xn(String paramString)
  {
    AppMethodBeat.i(30301);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + 18 + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(30301);
    return paramString;
  }
  
  public static String a(agx paramagx)
  {
    AppMethodBeat.i(30302);
    gt localgt = new gt();
    localgt.dhx.type = 27;
    localgt.dhx.dhz = paramagx;
    a.GpY.l(localgt);
    paramagx = localgt.dhy.thumbPath;
    AppMethodBeat.o(30302);
    return paramagx;
  }
  
  private static void a(ahn paramahn, long paramLong, String paramString)
  {
    AppMethodBeat.i(30306);
    Object localObject1 = new ArrayList();
    if ((bs.isNullOrNil(paramString)) || (paramString.length() == 0))
    {
      AppMethodBeat.o(30306);
      return;
    }
    paramString = Pattern.compile("<object[^>]*>", 2).matcher(paramString);
    if (paramString.find())
    {
      localObject2 = paramString.group();
      int k = ((String)localObject2).indexOf("WeNote_");
      if (k != -1)
      {
        i = ((String)localObject2).indexOf("\"", k + 1);
        if (i != -1)
        {
          j = ((String)localObject2).indexOf(" ", k + 1);
          if (j != -1)
          {
            if (i < j) {}
            for (;;)
            {
              ((ArrayList)localObject1).add(((String)localObject2).substring(k, i));
              break;
              i = j;
            }
          }
        }
      }
    }
    paramString = new LinkedList();
    Object localObject2 = paramahn.nxC.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      agx localagx = (agx)((Iterator)localObject2).next();
      if (i == 0)
      {
        localagx.aIZ("WeNoteHtmlFile");
        paramString.add(localagx);
        i += 1;
      }
      else
      {
        if (localagx.dataType == 1) {
          localagx.aIZ("-1");
        }
        for (;;)
        {
          paramString.add(localagx);
          break;
          localagx.aIZ((String)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
    }
    localObject1 = new gt();
    ((gt)localObject1).dhx.type = 33;
    ((gt)localObject1).dhx.dcm = paramahn;
    ((gt)localObject1).dhx.dcm.nxC = paramString;
    ((gt)localObject1).dhx.dcg = paramLong;
    a.GpY.l((b)localObject1);
    AppMethodBeat.o(30306);
  }
  
  public static void aO(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(30307);
    if (c.eHP().CUG == null)
    {
      ac.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
      AppMethodBeat.o(30307);
      return;
    }
    ahn localahn = c.eHP().CUG.CUR;
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    if (localahn == null)
    {
      ac.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
      AppMethodBeat.o(30307);
      return;
    }
    Object localObject3 = localahn.nxC.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      agx localagx = (agx)((Iterator)localObject3).next();
      if ((!bs.isNullOrNil(localagx.EAh)) && (!localagx.EAh.contains("WeNoteHtmlFile")) && (!localagx.EAh.contains("-1")))
      {
        ((List)localObject1).add(localagx.EAh);
        ((HashMap)localObject2).put(localagx.EAh, localagx);
      }
    }
    if ((paramArrayList.size() == ((List)localObject1).size()) && (((List)localObject1).containsAll(paramArrayList)) && (paramArrayList.containsAll((Collection)localObject1)))
    {
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label473;
      }
      if (((String)((List)localObject1).get(i)).trim().equals(((String)paramArrayList.get(i)).trim())) {}
    }
    label473:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new LinkedList();
        i = j;
        for (;;)
        {
          if (i < paramArrayList.size())
          {
            ((LinkedList)localObject1).add(((HashMap)localObject2).get(paramArrayList.get(i)));
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
        localahn.bk((LinkedList)localObject1);
        eHR();
        ((HashMap)localObject2).clear();
      }
      AppMethodBeat.o(30307);
      return;
      ((List)localObject1).removeAll(paramArrayList);
      if (((List)localObject1).size() == 0)
      {
        AppMethodBeat.o(30307);
        return;
      }
      paramArrayList = new ArrayList();
      localObject2 = localahn.nxC.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (agx)((Iterator)localObject2).next();
        if (((List)localObject1).contains(((agx)localObject3).EAh)) {
          paramArrayList.add(localObject3);
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (agx)paramArrayList.next();
        localahn.nxC.remove(localObject1);
      }
      eHR();
      AppMethodBeat.o(30307);
      return;
    }
  }
  
  public static String aX(float paramFloat)
  {
    AppMethodBeat.i(30298);
    if (paramFloat < 1024.0F)
    {
      str = String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(30298);
      return str;
    }
    if (paramFloat < 1048576.0F)
    {
      str = String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
      AppMethodBeat.o(30298);
      return str;
    }
    if (paramFloat < 1.073742E+009F)
    {
      str = String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
      AppMethodBeat.o(30298);
      return str;
    }
    String str = String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
    AppMethodBeat.o(30298);
    return str;
  }
  
  public static String b(agx paramagx)
  {
    AppMethodBeat.i(30303);
    gt localgt = new gt();
    localgt.dhx.type = 27;
    localgt.dhx.dhz = paramagx;
    a.GpY.l(localgt);
    paramagx = localgt.dhy.path;
    AppMethodBeat.o(30303);
    return paramagx;
  }
  
  private static void eHR()
  {
    AppMethodBeat.i(30308);
    gt localgt = new gt();
    localgt.dhx.type = 30;
    if (c.eHP().CUG != null)
    {
      localgt.dhx.dcm = c.eHP().CUG.CUR;
      a.GpY.l(localgt);
      c.eHP().CUG.aEC(localgt.dhy.path);
    }
    AppMethodBeat.o(30308);
  }
  
  public static float qw(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(30299);
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      f1 = Math.round(f1);
      AppMethodBeat.o(30299);
      return f1;
      f1 = f2;
    }
  }
  
  public static com.tencent.mm.plugin.fav.a.g ws(long paramLong)
  {
    AppMethodBeat.i(30304);
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong);
    AppMethodBeat.o(30304);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.f
 * JD-Core Version:    0.7.0.1
 */