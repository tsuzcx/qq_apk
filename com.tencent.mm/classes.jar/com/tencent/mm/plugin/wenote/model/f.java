package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.a;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  public static String a(arf paramarf)
  {
    AppMethodBeat.i(30302);
    ht localht = new ht();
    localht.hIR.type = 27;
    localht.hIR.hIT = paramarf;
    localht.publish();
    paramarf = localht.hIS.thumbPath;
    AppMethodBeat.o(30302);
    return paramarf;
  }
  
  private static void a(arv paramarv, long paramLong, String paramString)
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
    Object localObject2 = paramarv.vEn.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      arf localarf = (arf)((Iterator)localObject2).next();
      if (i == 0)
      {
        localarf.bsL("WeNoteHtmlFile");
        paramString.add(localarf);
        i += 1;
      }
      else
      {
        if (localarf.dataType == 1) {
          localarf.bsL("-1");
        }
        for (;;)
        {
          paramString.add(localarf);
          break;
          localarf.bsL((String)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
    }
    localObject1 = new ht();
    ((ht)localObject1).hIR.type = 33;
    ((ht)localObject1).hIR.hDt = paramarv;
    ((ht)localObject1).hIR.hDt.vEn = paramString;
    ((ht)localObject1).hIR.hDn = paramLong;
    ((ht)localObject1).publish();
    AppMethodBeat.o(30306);
  }
  
  public static String aj(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(30300);
    ht localht = new ht();
    localht.hIR.type = 21;
    localht.hIR.context = paramContext;
    localht.hIR.hIZ = paramInt;
    localht.publish();
    paramContext = localht.hIS.path;
    AppMethodBeat.o(30300);
    return paramContext;
  }
  
  public static void al(long paramLong, String paramString)
  {
    AppMethodBeat.i(30305);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(30305);
      return;
    }
    ht localht = new ht();
    localht.hIR.type = 34;
    localht.hIR.hDn = paramLong;
    localht.publish();
    if (localht.hIR.hDt == null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    if ((localht.hIR.hDt.vEn == null) || (localht.hIR.hDt.vEn.size() <= 1))
    {
      AppMethodBeat.o(30305);
      return;
    }
    if (((arf)localht.hIR.hDt.vEn.get(0)).ZzG != null)
    {
      AppMethodBeat.o(30305);
      return;
    }
    Log.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
    if ((!Util.isNullOrNil(paramString)) && (com.tencent.mm.vfs.y.ZC(paramString))) {
      try
      {
        paramString = com.tencent.mm.vfs.y.bEn(paramString);
        a(localht.hIR.hDt, paramLong, paramString);
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
  
  public static String anz(String paramString)
  {
    AppMethodBeat.i(30301);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + 18 + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(30301);
    return paramString;
  }
  
  public static String b(arf paramarf)
  {
    AppMethodBeat.i(30303);
    ht localht = new ht();
    localht.hIR.type = 27;
    localht.hIR.hIT = paramarf;
    localht.publish();
    paramarf = localht.hIS.path;
    AppMethodBeat.o(30303);
    return paramarf;
  }
  
  public static void bU(ArrayList<String> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(30307);
    if (c.iDT().XzB == null)
    {
      Log.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
      AppMethodBeat.o(30307);
      return;
    }
    arv localarv = c.iDT().XzB.XzM;
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    if (localarv == null)
    {
      Log.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
      AppMethodBeat.o(30307);
      return;
    }
    Object localObject3 = localarv.vEn.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      arf localarf = (arf)((Iterator)localObject3).next();
      if ((!Util.isNullOrNil(localarf.ZzG)) && (!localarf.ZzG.contains("WeNoteHtmlFile")) && (!localarf.ZzG.contains("-1")))
      {
        ((List)localObject1).add(localarf.ZzG);
        ((HashMap)localObject2).put(localarf.ZzG, localarf);
      }
    }
    if ((paramArrayList.size() == ((List)localObject1).size()) && (((List)localObject1).containsAll(paramArrayList)) && (paramArrayList.containsAll((Collection)localObject1)))
    {
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label476;
      }
      if (((String)((List)localObject1).get(i)).trim().equals(((String)paramArrayList.get(i)).trim())) {}
    }
    label476:
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
            ((LinkedList)localObject1).add((arf)((HashMap)localObject2).get(paramArrayList.get(i)));
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
        localarv.cs((LinkedList)localObject1);
        iDV();
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
      localObject2 = localarv.vEn.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (arf)((Iterator)localObject2).next();
        if (((List)localObject1).contains(((arf)localObject3).ZzG)) {
          paramArrayList.add(localObject3);
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (arf)paramArrayList.next();
        localarv.vEn.remove(localObject1);
      }
      iDV();
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
  
  private static void iDV()
  {
    AppMethodBeat.i(30308);
    ht localht = new ht();
    localht.hIR.type = 30;
    if (c.iDT().XzB != null)
    {
      localht.hIR.hDt = c.iDT().XzB.XzM;
      localht.publish();
      c.iDT().XzB.bnC(localht.hIS.path);
    }
    AppMethodBeat.o(30308);
  }
  
  public static float jh(long paramLong)
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
  
  public static com.tencent.mm.plugin.fav.a.g to(long paramLong)
  {
    AppMethodBeat.i(30304);
    com.tencent.mm.plugin.fav.a.g localg = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(paramLong);
    AppMethodBeat.o(30304);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.f
 * JD-Core Version:    0.7.0.1
 */