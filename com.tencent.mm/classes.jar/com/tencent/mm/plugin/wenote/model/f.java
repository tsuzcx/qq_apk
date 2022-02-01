package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.a;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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
  public static float AO(long paramLong)
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
  
  public static com.tencent.mm.plugin.fav.a.g HT(long paramLong)
  {
    AppMethodBeat.i(30304);
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong);
    AppMethodBeat.o(30304);
    return localg;
  }
  
  public static void O(long paramLong, String paramString)
  {
    AppMethodBeat.i(30305);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(30305);
      return;
    }
    hb localhb = new hb();
    localhb.dLm.type = 34;
    localhb.dLm.dFW = paramLong;
    EventCenter.instance.publish(localhb);
    if (localhb.dLm.dGb == null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    if ((localhb.dLm.dGb.ppH == null) || (localhb.dLm.dGb.ppH.size() <= 1))
    {
      AppMethodBeat.o(30305);
      return;
    }
    if (((aml)localhb.dLm.dGb.ppH.get(0)).Lwp != null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    Log.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
    if ((!Util.isNullOrNil(paramString)) && (s.YS(paramString))) {
      try
      {
        paramString = s.boY(paramString);
        a(localhb.dLm.dGb, paramLong, paramString);
        AppMethodBeat.o(30305);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(30305);
  }
  
  public static String W(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30300);
    hb localhb = new hb();
    localhb.dLm.type = 21;
    localhb.dLm.context = paramContext;
    localhb.dLm.dLu = paramInt;
    EventCenter.instance.publish(localhb);
    paramContext = localhb.dLn.path;
    AppMethodBeat.o(30300);
    return paramContext;
  }
  
  public static String a(aml paramaml)
  {
    AppMethodBeat.i(30302);
    hb localhb = new hb();
    localhb.dLm.type = 27;
    localhb.dLm.dLo = paramaml;
    EventCenter.instance.publish(localhb);
    paramaml = localhb.dLn.thumbPath;
    AppMethodBeat.o(30302);
    return paramaml;
  }
  
  private static void a(anb paramanb, long paramLong, String paramString)
  {
    AppMethodBeat.i(30306);
    Object localObject1 = new ArrayList();
    if ((Util.isNullOrNil(paramString)) || (paramString.length() == 0))
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
    Object localObject2 = paramanb.ppH.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      aml localaml = (aml)((Iterator)localObject2).next();
      if (i == 0)
      {
        localaml.bgC("WeNoteHtmlFile");
        paramString.add(localaml);
        i += 1;
      }
      else
      {
        if (localaml.dataType == 1) {
          localaml.bgC("-1");
        }
        for (;;)
        {
          paramString.add(localaml);
          break;
          localaml.bgC((String)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
    }
    localObject1 = new hb();
    ((hb)localObject1).dLm.type = 33;
    ((hb)localObject1).dLm.dGb = paramanb;
    ((hb)localObject1).dLm.dGb.ppH = paramString;
    ((hb)localObject1).dLm.dFW = paramLong;
    EventCenter.instance.publish((IEvent)localObject1);
    AppMethodBeat.o(30306);
  }
  
  public static String alR(String paramString)
  {
    AppMethodBeat.i(30301);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + 18 + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(30301);
    return paramString;
  }
  
  public static String b(aml paramaml)
  {
    AppMethodBeat.i(30303);
    hb localhb = new hb();
    localhb.dLm.type = 27;
    localhb.dLm.dLo = paramaml;
    EventCenter.instance.publish(localhb);
    paramaml = localhb.dLn.path;
    AppMethodBeat.o(30303);
    return paramaml;
  }
  
  public static void be(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(30307);
    if (c.gjz().JGL == null)
    {
      Log.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
      AppMethodBeat.o(30307);
      return;
    }
    anb localanb = c.gjz().JGL.JGW;
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    if (localanb == null)
    {
      Log.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
      AppMethodBeat.o(30307);
      return;
    }
    Object localObject3 = localanb.ppH.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      aml localaml = (aml)((Iterator)localObject3).next();
      if ((!Util.isNullOrNil(localaml.Lwp)) && (!localaml.Lwp.contains("WeNoteHtmlFile")) && (!localaml.Lwp.contains("-1")))
      {
        ((List)localObject1).add(localaml.Lwp);
        ((HashMap)localObject2).put(localaml.Lwp, localaml);
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
        localanb.bH((LinkedList)localObject1);
        gjB();
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
      localObject2 = localanb.ppH.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (aml)((Iterator)localObject2).next();
        if (((List)localObject1).contains(((aml)localObject3).Lwp)) {
          paramArrayList.add(localObject3);
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (aml)paramArrayList.next();
        localanb.ppH.remove(localObject1);
      }
      gjB();
      AppMethodBeat.o(30307);
      return;
    }
  }
  
  public static String getLengthStr(float paramFloat)
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
  
  private static void gjB()
  {
    AppMethodBeat.i(30308);
    hb localhb = new hb();
    localhb.dLm.type = 30;
    if (c.gjz().JGL != null)
    {
      localhb.dLm.dGb = c.gjz().JGL.JGW;
      EventCenter.instance.publish(localhb);
      c.gjz().JGL.bbO(localhb.dLn.path);
    }
    AppMethodBeat.o(30308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.f
 * JD-Core Version:    0.7.0.1
 */