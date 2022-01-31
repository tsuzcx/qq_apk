package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.a;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public static String B(Context paramContext, int paramInt)
  {
    gf localgf = new gf();
    localgf.bNF.type = 21;
    localgf.bNF.context = paramContext;
    localgf.bNF.bNN = paramInt;
    a.udP.m(localgf);
    return localgf.bNG.path;
  }
  
  public static String Ur(String paramString)
  {
    return com.tencent.mm.a.g.o((paramString + 18 + System.currentTimeMillis()).getBytes());
  }
  
  public static void Y(ArrayList<String> paramArrayList)
  {
    int j = 0;
    if (c.chu().rFh == null) {
      y.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
    }
    label434:
    label437:
    for (;;)
    {
      return;
      yj localyj = c.chu().rFh.rFt;
      Object localObject1 = new ArrayList();
      Object localObject2 = new HashMap();
      if (localyj == null)
      {
        y.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
        return;
      }
      Object localObject3 = localyj.sXc.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        xv localxv = (xv)((Iterator)localObject3).next();
        if ((!bk.bl(localxv.sVI)) && (!localxv.sVI.contains("WeNoteHtmlFile")) && (!localxv.sVI.contains("-1")))
        {
          ((List)localObject1).add(localxv.sVI);
          ((HashMap)localObject2).put(localxv.sVI, localxv);
        }
      }
      if ((paramArrayList.size() == ((List)localObject1).size()) && (((List)localObject1).containsAll(paramArrayList)) && (paramArrayList.containsAll((Collection)localObject1)))
      {
        i = 0;
        if (i >= ((List)localObject1).size()) {
          break label434;
        }
        if (((String)((List)localObject1).get(i)).trim().equals(((String)paramArrayList.get(i)).trim())) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label437;
        }
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
        localyj.az((LinkedList)localObject1);
        chw();
        ((HashMap)localObject2).clear();
        return;
        ((List)localObject1).removeAll(paramArrayList);
        if (((List)localObject1).size() == 0) {
          break;
        }
        paramArrayList = new ArrayList();
        localObject2 = localyj.sXc.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (xv)((Iterator)localObject2).next();
          if (((List)localObject1).contains(((xv)localObject3).sVI)) {
            paramArrayList.add(localObject3);
          }
        }
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (xv)paramArrayList.next();
          localyj.sXc.remove(localObject1);
        }
        chw();
        return;
      }
    }
  }
  
  public static String ar(float paramFloat)
  {
    if (paramFloat < 1024.0F) {
      return String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
    }
    if (paramFloat < 1048576.0F) {
      return String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
    }
    if (paramFloat < 1.073742E+009F) {
      return String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
    }
    return String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
  }
  
  public static String c(xv paramxv)
  {
    gf localgf = new gf();
    localgf.bNF.type = 27;
    localgf.bNF.bNH = paramxv;
    a.udP.m(localgf);
    return localgf.bNG.thumbPath;
  }
  
  private static void chw()
  {
    gf localgf = new gf();
    localgf.bNF.type = 30;
    if (c.chu().rFh != null)
    {
      localgf.bNF.bIy = c.chu().rFh.rFt;
      a.udP.m(localgf);
      c.chu().rFh.Up(localgf.bNG.path);
    }
  }
  
  public static float ck(long paramLong)
  {
    float f1 = 1.0F;
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      return Math.round(f1);
      f1 = f2;
    }
  }
  
  public static com.tencent.mm.plugin.fav.a.g fu(long paramLong)
  {
    return ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramLong);
  }
  
  public static String o(xv paramxv)
  {
    gf localgf = new gf();
    localgf.bNF.type = 27;
    localgf.bNF.bNH = paramxv;
    a.udP.m(localgf);
    return localgf.bNG.path;
  }
  
  public static void y(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {}
    do
    {
      do
      {
        return;
        localObject1 = new gf();
        ((gf)localObject1).bNF.type = 34;
        ((gf)localObject1).bNF.bIr = paramLong;
        a.udP.m((b)localObject1);
      } while ((((gf)localObject1).bNF.bIy == null) || (((gf)localObject1).bNF.bIy.sXc == null) || (((gf)localObject1).bNF.bIy.sXc.size() <= 1) || (((xv)((gf)localObject1).bNF.bIy.sXc.get(0)).sVI != null));
      y.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
    } while ((bk.bl(paramString)) || (!e.bK(paramString)));
    for (;;)
    {
      try
      {
        localObject2 = e.bP(paramString);
        paramString = ((gf)localObject1).bNF.bIy;
        localObject1 = new ArrayList();
        if ((bk.bl((String)localObject2)) || (((String)localObject2).length() == 0)) {
          break;
        }
        localObject2 = Pattern.compile("<object[^>]*>", 2).matcher((CharSequence)localObject2);
        if (!((Matcher)localObject2).find()) {
          break label306;
        }
        localObject3 = ((Matcher)localObject2).group();
        int k = ((String)localObject3).indexOf("WeNote_");
        if (k == -1) {
          break label306;
        }
        i = ((String)localObject3).indexOf("\"", k + 1);
        if (i == -1) {
          break label306;
        }
        j = ((String)localObject3).indexOf(" ", k + 1);
        if (j == -1) {
          break label306;
        }
        if (i < j) {
          ((ArrayList)localObject1).add(((String)localObject3).substring(k, i));
        } else {
          i = j;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[] { paramString.getMessage() });
        return;
      }
    }
    label306:
    Object localObject2 = new LinkedList();
    Object localObject3 = paramString.sXc.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      xv localxv = (xv)((Iterator)localObject3).next();
      if (i == 0)
      {
        localxv.XR("WeNoteHtmlFile");
        ((LinkedList)localObject2).add(localxv);
        i += 1;
      }
      else
      {
        if (localxv.aYU == 1) {
          localxv.XR("-1");
        }
        for (;;)
        {
          ((LinkedList)localObject2).add(localxv);
          break;
          localxv.XR((String)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
    }
    Object localObject1 = new gf();
    ((gf)localObject1).bNF.type = 33;
    ((gf)localObject1).bNF.bIy = paramString;
    ((gf)localObject1).bNF.bIy.sXc = ((LinkedList)localObject2);
    ((gf)localObject1).bNF.bIr = paramLong;
    a.udP.m((b)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.f
 * JD-Core Version:    0.7.0.1
 */