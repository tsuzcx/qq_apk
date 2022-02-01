package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.a;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
  public static float GW(long paramLong)
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
  
  public static com.tencent.mm.plugin.fav.a.g Po(long paramLong)
  {
    AppMethodBeat.i(30304);
    com.tencent.mm.plugin.fav.a.g localg = ((ag)h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong);
    AppMethodBeat.o(30304);
    return localg;
  }
  
  public static void W(long paramLong, String paramString)
  {
    AppMethodBeat.i(30305);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(30305);
      return;
    }
    hi localhi = new hi();
    localhi.fEb.type = 34;
    localhi.fEb.fyE = paramLong;
    EventCenter.instance.publish(localhi);
    if (localhi.fEb.fyK == null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    if ((localhi.fEb.fyK.syG == null) || (localhi.fEb.fyK.syG.size() <= 1))
    {
      AppMethodBeat.o(30305);
      return;
    }
    if (((anm)localhi.fEb.fyK.syG.get(0)).SyO != null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    Log.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
    if ((!Util.isNullOrNil(paramString)) && (u.agG(paramString))) {
      try
      {
        paramString = u.bBS(paramString);
        a(localhi.fEb.fyK, paramLong, paramString);
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
  
  public static String a(anm paramanm)
  {
    AppMethodBeat.i(30302);
    hi localhi = new hi();
    localhi.fEb.type = 27;
    localhi.fEb.fEd = paramanm;
    EventCenter.instance.publish(localhi);
    paramanm = localhi.fEc.thumbPath;
    AppMethodBeat.o(30302);
    return paramanm;
  }
  
  private static void a(aoc paramaoc, long paramLong, String paramString)
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
    Object localObject2 = paramaoc.syG.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      anm localanm = (anm)((Iterator)localObject2).next();
      if (i == 0)
      {
        localanm.bsU("WeNoteHtmlFile");
        paramString.add(localanm);
        i += 1;
      }
      else
      {
        if (localanm.dataType == 1) {
          localanm.bsU("-1");
        }
        for (;;)
        {
          paramString.add(localanm);
          break;
          localanm.bsU((String)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
    }
    localObject1 = new hi();
    ((hi)localObject1).fEb.type = 33;
    ((hi)localObject1).fEb.fyK = paramaoc;
    ((hi)localObject1).fEb.fyK.syG = paramString;
    ((hi)localObject1).fEb.fyE = paramLong;
    EventCenter.instance.publish((IEvent)localObject1);
    AppMethodBeat.o(30306);
  }
  
  public static String ab(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30300);
    hi localhi = new hi();
    localhi.fEb.type = 21;
    localhi.fEb.context = paramContext;
    localhi.fEb.fEj = paramInt;
    EventCenter.instance.publish(localhi);
    paramContext = localhi.fEc.path;
    AppMethodBeat.o(30300);
    return paramContext;
  }
  
  public static String atK(String paramString)
  {
    AppMethodBeat.i(30301);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + 18 + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(30301);
    return paramString;
  }
  
  public static String b(anm paramanm)
  {
    AppMethodBeat.i(30303);
    hi localhi = new hi();
    localhi.fEb.type = 27;
    localhi.fEb.fEd = paramanm;
    EventCenter.instance.publish(localhi);
    paramanm = localhi.fEc.path;
    AppMethodBeat.o(30303);
    return paramanm;
  }
  
  public static void bt(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(30307);
    if (c.hdm().QGd == null)
    {
      Log.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
      AppMethodBeat.o(30307);
      return;
    }
    aoc localaoc = c.hdm().QGd.QGo;
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    if (localaoc == null)
    {
      Log.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
      AppMethodBeat.o(30307);
      return;
    }
    Object localObject3 = localaoc.syG.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      anm localanm = (anm)((Iterator)localObject3).next();
      if ((!Util.isNullOrNil(localanm.SyO)) && (!localanm.SyO.contains("WeNoteHtmlFile")) && (!localanm.SyO.contains("-1")))
      {
        ((List)localObject1).add(localanm.SyO);
        ((HashMap)localObject2).put(localanm.SyO, localanm);
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
        localaoc.cg((LinkedList)localObject1);
        hdo();
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
      localObject2 = localaoc.syG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (anm)((Iterator)localObject2).next();
        if (((List)localObject1).contains(((anm)localObject3).SyO)) {
          paramArrayList.add(localObject3);
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (anm)paramArrayList.next();
        localaoc.syG.remove(localObject1);
      }
      hdo();
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
  
  private static void hdo()
  {
    AppMethodBeat.i(30308);
    hi localhi = new hi();
    localhi.fEb.type = 30;
    if (c.hdm().QGd != null)
    {
      localhi.fEb.fyK = c.hdm().QGd.QGo;
      EventCenter.instance.publish(localhi);
      c.hdm().QGd.bnO(localhi.fEc.path);
    }
    AppMethodBeat.o(30308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.f
 * JD-Core Version:    0.7.0.1
 */