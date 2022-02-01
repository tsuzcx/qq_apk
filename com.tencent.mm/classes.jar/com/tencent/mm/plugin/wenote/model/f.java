package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.a;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static void I(long paramLong, String paramString)
  {
    AppMethodBeat.i(30305);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(30305);
      return;
    }
    gw localgw = new gw();
    localgw.dsV.type = 34;
    localgw.dsV.dnC = paramLong;
    a.IbL.l(localgw);
    if (localgw.dsV.dnI == null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    if ((localgw.dsV.dnI.nZa == null) || (localgw.dsV.dnI.nZa.size() <= 1))
    {
      AppMethodBeat.o(30305);
      return;
    }
    if (((ajn)localgw.dsV.dnI.nZa.get(0)).GhT != null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    ad.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
    if ((!bt.isNullOrNil(paramString)) && (i.fv(paramString))) {
      try
      {
        paramString = i.aYq(paramString);
        a(localgw.dsV.dnI, paramLong, paramString);
        AppMethodBeat.o(30305);
        return;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(30305);
  }
  
  public static String R(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30300);
    gw localgw = new gw();
    localgw.dsV.type = 21;
    localgw.dsV.context = paramContext;
    localgw.dsV.dtd = paramInt;
    a.IbL.l(localgw);
    paramContext = localgw.dsW.path;
    AppMethodBeat.o(30300);
    return paramContext;
  }
  
  public static String a(ajn paramajn)
  {
    AppMethodBeat.i(30302);
    gw localgw = new gw();
    localgw.dsV.type = 27;
    localgw.dsV.dsX = paramajn;
    a.IbL.l(localgw);
    paramajn = localgw.dsW.thumbPath;
    AppMethodBeat.o(30302);
    return paramajn;
  }
  
  private static void a(akd paramakd, long paramLong, String paramString)
  {
    AppMethodBeat.i(30306);
    Object localObject1 = new ArrayList();
    if ((bt.isNullOrNil(paramString)) || (paramString.length() == 0))
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
    Object localObject2 = paramakd.nZa.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      ajn localajn = (ajn)((Iterator)localObject2).next();
      if (i == 0)
      {
        localajn.aOC("WeNoteHtmlFile");
        paramString.add(localajn);
        i += 1;
      }
      else
      {
        if (localajn.dataType == 1) {
          localajn.aOC("-1");
        }
        for (;;)
        {
          paramString.add(localajn);
          break;
          localajn.aOC((String)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
    }
    localObject1 = new gw();
    ((gw)localObject1).dsV.type = 33;
    ((gw)localObject1).dsV.dnI = paramakd;
    ((gw)localObject1).dsV.dnI.nZa = paramString;
    ((gw)localObject1).dsV.dnC = paramLong;
    a.IbL.l((b)localObject1);
    AppMethodBeat.o(30306);
  }
  
  public static void aL(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(30307);
    if (c.eWI().EyD == null)
    {
      ad.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
      AppMethodBeat.o(30307);
      return;
    }
    akd localakd = c.eWI().EyD.EyO;
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    if (localakd == null)
    {
      ad.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
      AppMethodBeat.o(30307);
      return;
    }
    Object localObject3 = localakd.nZa.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ajn localajn = (ajn)((Iterator)localObject3).next();
      if ((!bt.isNullOrNil(localajn.GhT)) && (!localajn.GhT.contains("WeNoteHtmlFile")) && (!localajn.GhT.contains("-1")))
      {
        ((List)localObject1).add(localajn.GhT);
        ((HashMap)localObject2).put(localajn.GhT, localajn);
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
        localakd.bl((LinkedList)localObject1);
        eWK();
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
      localObject2 = localakd.nZa.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ajn)((Iterator)localObject2).next();
        if (((List)localObject1).contains(((ajn)localObject3).GhT)) {
          paramArrayList.add(localObject3);
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (ajn)paramArrayList.next();
        localakd.nZa.remove(localObject1);
      }
      eWK();
      AppMethodBeat.o(30307);
      return;
    }
  }
  
  public static String aaU(String paramString)
  {
    AppMethodBeat.i(30301);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + 18 + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(30301);
    return paramString;
  }
  
  public static String b(ajn paramajn)
  {
    AppMethodBeat.i(30303);
    gw localgw = new gw();
    localgw.dsV.type = 27;
    localgw.dsV.dsX = paramajn;
    a.IbL.l(localgw);
    paramajn = localgw.dsW.path;
    AppMethodBeat.o(30303);
    return paramajn;
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
  
  private static void eWK()
  {
    AppMethodBeat.i(30308);
    gw localgw = new gw();
    localgw.dsV.type = 30;
    if (c.eWI().EyD != null)
    {
      localgw.dsV.dnI = c.eWI().EyD.EyO;
      a.IbL.l(localgw);
      c.eWI().EyD.aKc(localgw.dsW.path);
    }
    AppMethodBeat.o(30308);
  }
  
  public static float sv(long paramLong)
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
  
  public static com.tencent.mm.plugin.fav.a.g yE(long paramLong)
  {
    AppMethodBeat.i(30304);
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong);
    AppMethodBeat.o(30304);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.f
 * JD-Core Version:    0.7.0.1
 */