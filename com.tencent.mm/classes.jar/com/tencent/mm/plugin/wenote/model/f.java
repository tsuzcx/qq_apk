package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.a;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
  public static void J(long paramLong, String paramString)
  {
    AppMethodBeat.i(30305);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(30305);
      return;
    }
    gx localgx = new gx();
    localgx.dub.type = 34;
    localgx.dub.doH = paramLong;
    a.IvT.l(localgx);
    if (localgx.dub.doN == null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    if ((localgx.dub.doN.oeJ == null) || (localgx.dub.doN.oeJ.size() <= 1))
    {
      AppMethodBeat.o(30305);
      return;
    }
    if (((ajx)localgx.dub.doN.oeJ.get(0)).GAC != null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    ae.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
    if ((!bu.isNullOrNil(paramString)) && (o.fB(paramString))) {
      try
      {
        paramString = o.aZT(paramString);
        a(localgx.dub.doN, paramLong, paramString);
        AppMethodBeat.o(30305);
        return;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(30305);
  }
  
  public static String R(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30300);
    gx localgx = new gx();
    localgx.dub.type = 21;
    localgx.dub.context = paramContext;
    localgx.dub.duj = paramInt;
    a.IvT.l(localgx);
    paramContext = localgx.duc.path;
    AppMethodBeat.o(30300);
    return paramContext;
  }
  
  public static String a(ajx paramajx)
  {
    AppMethodBeat.i(30302);
    gx localgx = new gx();
    localgx.dub.type = 27;
    localgx.dub.dud = paramajx;
    a.IvT.l(localgx);
    paramajx = localgx.duc.thumbPath;
    AppMethodBeat.o(30302);
    return paramajx;
  }
  
  private static void a(akn paramakn, long paramLong, String paramString)
  {
    AppMethodBeat.i(30306);
    Object localObject1 = new ArrayList();
    if ((bu.isNullOrNil(paramString)) || (paramString.length() == 0))
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
    Object localObject2 = paramakn.oeJ.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      ajx localajx = (ajx)((Iterator)localObject2).next();
      if (i == 0)
      {
        localajx.aPZ("WeNoteHtmlFile");
        paramString.add(localajx);
        i += 1;
      }
      else
      {
        if (localajx.dataType == 1) {
          localajx.aPZ("-1");
        }
        for (;;)
        {
          paramString.add(localajx);
          break;
          localajx.aPZ((String)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
    }
    localObject1 = new gx();
    ((gx)localObject1).dub.type = 33;
    ((gx)localObject1).dub.doN = paramakn;
    ((gx)localObject1).dub.doN.oeJ = paramString;
    ((gx)localObject1).dub.doH = paramLong;
    a.IvT.l((b)localObject1);
    AppMethodBeat.o(30306);
  }
  
  public static void aM(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(30307);
    if (c.fau().EQZ == null)
    {
      ae.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
      AppMethodBeat.o(30307);
      return;
    }
    akn localakn = c.fau().EQZ.ERk;
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    if (localakn == null)
    {
      ae.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
      AppMethodBeat.o(30307);
      return;
    }
    Object localObject3 = localakn.oeJ.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ajx localajx = (ajx)((Iterator)localObject3).next();
      if ((!bu.isNullOrNil(localajx.GAC)) && (!localajx.GAC.contains("WeNoteHtmlFile")) && (!localajx.GAC.contains("-1")))
      {
        ((List)localObject1).add(localajx.GAC);
        ((HashMap)localObject2).put(localajx.GAC, localajx);
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
        localakn.bm((LinkedList)localObject1);
        faw();
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
      localObject2 = localakn.oeJ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ajx)((Iterator)localObject2).next();
        if (((List)localObject1).contains(((ajx)localObject3).GAC)) {
          paramArrayList.add(localObject3);
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (ajx)paramArrayList.next();
        localakn.oeJ.remove(localObject1);
      }
      faw();
      AppMethodBeat.o(30307);
      return;
    }
  }
  
  public static String abL(String paramString)
  {
    AppMethodBeat.i(30301);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + 18 + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(30301);
    return paramString;
  }
  
  public static String b(ajx paramajx)
  {
    AppMethodBeat.i(30303);
    gx localgx = new gx();
    localgx.dub.type = 27;
    localgx.dub.dud = paramajx;
    a.IvT.l(localgx);
    paramajx = localgx.duc.path;
    AppMethodBeat.o(30303);
    return paramajx;
  }
  
  public static String ba(float paramFloat)
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
  
  private static void faw()
  {
    AppMethodBeat.i(30308);
    gx localgx = new gx();
    localgx.dub.type = 30;
    if (c.fau().EQZ != null)
    {
      localgx.dub.doN = c.fau().EQZ.ERk;
      a.IvT.l(localgx);
      c.fau().EQZ.aLy(localgx.duc.path);
    }
    AppMethodBeat.o(30308);
  }
  
  public static float sI(long paramLong)
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
  
  public static com.tencent.mm.plugin.fav.a.g zd(long paramLong)
  {
    AppMethodBeat.i(30304);
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong);
    AppMethodBeat.o(30304);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.f
 * JD-Core Version:    0.7.0.1
 */