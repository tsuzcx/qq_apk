package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.a;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
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
  public static void F(long paramLong, String paramString)
  {
    AppMethodBeat.i(30305);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(30305);
      return;
    }
    gs localgs = new gs();
    localgs.dkc.type = 34;
    localgs.dkc.deL = paramLong;
    a.ESL.l(localgs);
    if (localgs.dkc.deS == null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    if ((localgs.dkc.deS.mVb == null) || (localgs.dkc.deS.mVb.size() <= 1))
    {
      AppMethodBeat.o(30305);
      return;
    }
    if (((afy)localgs.dkc.deS.mVb.get(0)).Dhb != null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    ad.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
    if ((!bt.isNullOrNil(paramString)) && (i.eK(paramString))) {
      try
      {
        paramString = i.aMP(paramString);
        a(localgs.dkc.deS, paramLong, paramString);
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
  
  public static String N(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30300);
    gs localgs = new gs();
    localgs.dkc.type = 21;
    localgs.dkc.context = paramContext;
    localgs.dkc.dkk = paramInt;
    a.ESL.l(localgs);
    paramContext = localgs.dkd.path;
    AppMethodBeat.o(30300);
    return paramContext;
  }
  
  public static String Tb(String paramString)
  {
    AppMethodBeat.i(30301);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + 18 + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(30301);
    return paramString;
  }
  
  public static String a(afy paramafy)
  {
    AppMethodBeat.i(30302);
    gs localgs = new gs();
    localgs.dkc.type = 27;
    localgs.dkc.dke = paramafy;
    a.ESL.l(localgs);
    paramafy = localgs.dkd.thumbPath;
    AppMethodBeat.o(30302);
    return paramafy;
  }
  
  private static void a(ago paramago, long paramLong, String paramString)
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
    Object localObject2 = paramago.mVb.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      afy localafy = (afy)((Iterator)localObject2).next();
      if (i == 0)
      {
        localafy.aDI("WeNoteHtmlFile");
        paramString.add(localafy);
        i += 1;
      }
      else
      {
        if (localafy.dataType == 1) {
          localafy.aDI("-1");
        }
        for (;;)
        {
          paramString.add(localafy);
          break;
          localafy.aDI((String)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
    }
    localObject1 = new gs();
    ((gs)localObject1).dkc.type = 33;
    ((gs)localObject1).dkc.deS = paramago;
    ((gs)localObject1).dkc.deS.mVb = paramString;
    ((gs)localObject1).dkc.deL = paramLong;
    a.ESL.l((b)localObject1);
    AppMethodBeat.o(30306);
  }
  
  public static void aC(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(30307);
    if (c.esw().BCA == null)
    {
      ad.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
      AppMethodBeat.o(30307);
      return;
    }
    ago localago = c.esw().BCA.BCL;
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    if (localago == null)
    {
      ad.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
      AppMethodBeat.o(30307);
      return;
    }
    Object localObject3 = localago.mVb.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      afy localafy = (afy)((Iterator)localObject3).next();
      if ((!bt.isNullOrNil(localafy.Dhb)) && (!localafy.Dhb.contains("WeNoteHtmlFile")) && (!localafy.Dhb.contains("-1")))
      {
        ((List)localObject1).add(localafy.Dhb);
        ((HashMap)localObject2).put(localafy.Dhb, localafy);
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
        localago.bd((LinkedList)localObject1);
        esy();
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
      localObject2 = localago.mVb.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (afy)((Iterator)localObject2).next();
        if (((List)localObject1).contains(((afy)localObject3).Dhb)) {
          paramArrayList.add(localObject3);
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (afy)paramArrayList.next();
        localago.mVb.remove(localObject1);
      }
      esy();
      AppMethodBeat.o(30307);
      return;
    }
  }
  
  public static String aS(float paramFloat)
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
  
  public static String b(afy paramafy)
  {
    AppMethodBeat.i(30303);
    gs localgs = new gs();
    localgs.dkc.type = 27;
    localgs.dkc.dke = paramafy;
    a.ESL.l(localgs);
    paramafy = localgs.dkd.path;
    AppMethodBeat.o(30303);
    return paramafy;
  }
  
  private static void esy()
  {
    AppMethodBeat.i(30308);
    gs localgs = new gs();
    localgs.dkc.type = 30;
    if (c.esw().BCA != null)
    {
      localgs.dkc.deS = c.esw().BCA.BCL;
      a.ESL.l(localgs);
      c.esw().BCA.azl(localgs.dkd.path);
    }
    AppMethodBeat.o(30308);
  }
  
  public static float mI(long paramLong)
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
  
  public static com.tencent.mm.plugin.fav.a.g rP(long paramLong)
  {
    AppMethodBeat.i(30304);
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong);
    AppMethodBeat.o(30304);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.f
 * JD-Core Version:    0.7.0.1
 */