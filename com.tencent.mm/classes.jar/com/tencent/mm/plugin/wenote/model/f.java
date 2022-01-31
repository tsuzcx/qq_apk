package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
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
  public static String L(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(26607);
    gi localgi = new gi();
    localgi.cuX.type = 21;
    localgi.cuX.context = paramContext;
    localgi.cuX.cvf = paramInt;
    a.ymk.l(localgi);
    paramContext = localgi.cuY.path;
    AppMethodBeat.o(26607);
    return paramContext;
  }
  
  private static void a(acq paramacq, long paramLong, String paramString)
  {
    AppMethodBeat.i(26613);
    Object localObject1 = new ArrayList();
    if ((bo.isNullOrNil(paramString)) || (paramString.length() == 0))
    {
      AppMethodBeat.o(26613);
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
    Object localObject2 = paramacq.wVc.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      aca localaca = (aca)((Iterator)localObject2).next();
      if (i == 0)
      {
        localaca.anN("WeNoteHtmlFile");
        paramString.add(localaca);
        i += 1;
      }
      else
      {
        if (localaca.dataType == 1) {
          localaca.anN("-1");
        }
        for (;;)
        {
          paramString.add(localaca);
          break;
          localaca.anN((String)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
    }
    localObject1 = new gi();
    ((gi)localObject1).cuX.type = 33;
    ((gi)localObject1).cuX.cpT = paramacq;
    ((gi)localObject1).cuX.cpT.wVc = paramString;
    ((gi)localObject1).cuX.cpM = paramLong;
    a.ymk.l((b)localObject1);
    AppMethodBeat.o(26613);
  }
  
  public static String aJ(float paramFloat)
  {
    AppMethodBeat.i(26605);
    if (paramFloat < 1024.0F)
    {
      str = String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(26605);
      return str;
    }
    if (paramFloat < 1048576.0F)
    {
      str = String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
      AppMethodBeat.o(26605);
      return str;
    }
    if (paramFloat < 1.073742E+009F)
    {
      str = String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
      AppMethodBeat.o(26605);
      return str;
    }
    String str = String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
    AppMethodBeat.o(26605);
    return str;
  }
  
  public static void ae(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(26614);
    if (c.dhH().vvQ == null)
    {
      ab.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
      AppMethodBeat.o(26614);
      return;
    }
    acq localacq = c.dhH().vvQ.vwc;
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    if (localacq == null)
    {
      ab.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
      AppMethodBeat.o(26614);
      return;
    }
    Object localObject3 = localacq.wVc.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      aca localaca = (aca)((Iterator)localObject3).next();
      if ((!bo.isNullOrNil(localaca.wTE)) && (!localaca.wTE.contains("WeNoteHtmlFile")) && (!localaca.wTE.contains("-1")))
      {
        ((List)localObject1).add(localaca.wTE);
        ((HashMap)localObject2).put(localaca.wTE, localaca);
      }
    }
    if ((paramArrayList.size() == ((List)localObject1).size()) && (((List)localObject1).containsAll(paramArrayList)) && (paramArrayList.containsAll((Collection)localObject1)))
    {
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label471;
      }
      if (((String)((List)localObject1).get(i)).trim().equals(((String)paramArrayList.get(i)).trim())) {}
    }
    label471:
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
        localacq.aJ((LinkedList)localObject1);
        dhJ();
        ((HashMap)localObject2).clear();
      }
      AppMethodBeat.o(26614);
      return;
      ((List)localObject1).removeAll(paramArrayList);
      if (((List)localObject1).size() == 0)
      {
        AppMethodBeat.o(26614);
        return;
      }
      paramArrayList = new ArrayList();
      localObject2 = localacq.wVc.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (aca)((Iterator)localObject2).next();
        if (((List)localObject1).contains(((aca)localObject3).wTE)) {
          paramArrayList.add(localObject3);
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (aca)paramArrayList.next();
        localacq.wVc.remove(localObject1);
      }
      dhJ();
      AppMethodBeat.o(26614);
      return;
    }
  }
  
  public static String ajF(String paramString)
  {
    AppMethodBeat.i(26608);
    paramString = com.tencent.mm.a.g.w((paramString + 18 + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(26608);
    return paramString;
  }
  
  public static String c(aca paramaca)
  {
    AppMethodBeat.i(26609);
    gi localgi = new gi();
    localgi.cuX.type = 27;
    localgi.cuX.cuZ = paramaca;
    a.ymk.l(localgi);
    paramaca = localgi.cuY.thumbPath;
    AppMethodBeat.o(26609);
    return paramaca;
  }
  
  private static void dhJ()
  {
    AppMethodBeat.i(26615);
    gi localgi = new gi();
    localgi.cuX.type = 30;
    if (c.dhH().vvQ != null)
    {
      localgi.cuX.cpT = c.dhH().vvQ.vwc;
      a.ymk.l(localgi);
      c.dhH().vvQ.ajD(localgi.cuY.path);
    }
    AppMethodBeat.o(26615);
  }
  
  public static float hi(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(26606);
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      f1 = Math.round(f1);
      AppMethodBeat.o(26606);
      return f1;
      f1 = f2;
    }
  }
  
  public static com.tencent.mm.plugin.fav.a.g kY(long paramLong)
  {
    AppMethodBeat.i(26611);
    com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong);
    AppMethodBeat.o(26611);
    return localg;
  }
  
  public static String o(aca paramaca)
  {
    AppMethodBeat.i(26610);
    gi localgi = new gi();
    localgi.cuX.type = 27;
    localgi.cuX.cuZ = paramaca;
    a.ymk.l(localgi);
    paramaca = localgi.cuY.path;
    AppMethodBeat.o(26610);
    return paramaca;
  }
  
  public static void z(long paramLong, String paramString)
  {
    AppMethodBeat.i(26612);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(26612);
      return;
    }
    gi localgi = new gi();
    localgi.cuX.type = 34;
    localgi.cuX.cpM = paramLong;
    a.ymk.l(localgi);
    if (localgi.cuX.cpT == null)
    {
      AppMethodBeat.o(26612);
      return;
    }
    if ((localgi.cuX.cpT.wVc == null) || (localgi.cuX.cpT.wVc.size() <= 1))
    {
      AppMethodBeat.o(26612);
      return;
    }
    if (((aca)localgi.cuX.cpT.wVc.get(0)).wTE != null)
    {
      AppMethodBeat.o(26612);
      return;
    }
    ab.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
    if ((!bo.isNullOrNil(paramString)) && (e.cN(paramString))) {
      try
      {
        paramString = e.cS(paramString);
        a(localgi.cuX.cpT, paramLong, paramString);
        AppMethodBeat.o(26612);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(26612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.f
 * JD-Core Version:    0.7.0.1
 */