package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public static l c(Context paramContext, List<bug> paramList)
  {
    AppMethodBeat.i(80969);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (bug)paramList.next();
      if ((localObject2 != null) && (a.VR(((bug)localObject2).Edq))) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (bs.gY((List)localObject1))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Collections.sort((List)localObject1, new Comparator() {});
    int j = ((bug)((List)localObject1).get(((List)localObject1).size() - 1)).Fkr;
    paramList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      paramList.add(null);
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bug)((Iterator)localObject1).next();
      if ((((bug)localObject2).Fkr > 0) && (((bug)localObject2).Fkr <= paramList.size())) {
        paramList.set(((bug)localObject2).Fkr - 1, localObject2);
      }
    }
    paramContext = new l(paramContext);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (bug)paramList.next();
      if (localObject1 == null)
      {
        paramContext.c(-1, "");
      }
      else
      {
        localObject2 = ((bug)localObject1).Title + "__" + ((bug)localObject1).ThumbUrl;
        paramContext.c(((bug)localObject1).Fkq, (CharSequence)localObject2);
      }
    }
    AppMethodBeat.o(80969);
    return paramContext;
  }
  
  public static enum a
  {
    private static EnumMap<a, Integer> CGD;
    int code;
    
    static
    {
      AppMethodBeat.i(80968);
      CGu = new a("HVGAME_MENU_ACTION_DEFAULT", 0, 0);
      CGv = new a("HVGAME_MENU_ACTION_JUMP_H5", 1, 1);
      CGw = new a("HVGAME_MENU_ACTION_EXIT", 2, 2);
      CGx = new a("HVGAME_MENU_ACTION_SHARE_TO_FRIEND", 3, 3);
      CGy = new a("HVGAME_MENU_ACTION_COLLECT", 4, 4);
      CGz = new a("HVGAME_MENU_ACTION_REFRESH", 5, 7);
      CGA = new a("HVGAME_MENU_ACTION_ADD_TO_DESKTOP", 6, 8);
      CGB = new a("HVGAME_MENU_ACTION_COMPLAINT", 7, 9);
      CGC = new a("HVGAME_MENU_ACTION_CUSTOM", 8, 10);
      CGE = new a[] { CGu, CGv, CGw, CGx, CGy, CGz, CGA, CGB, CGC };
      CGD = new EnumMap(a.class);
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        CGD.put(locala, Integer.valueOf(locala.code));
      }
      AppMethodBeat.o(80968);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static boolean VR(int paramInt)
    {
      AppMethodBeat.i(80966);
      boolean bool = CGD.containsValue(Integer.valueOf(paramInt));
      AppMethodBeat.o(80966);
      return bool;
    }
    
    public static a VS(int paramInt)
    {
      AppMethodBeat.i(80967);
      Object localObject = CGD.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((Integer)localEntry.getValue()).intValue() == paramInt)
        {
          localObject = (a)localEntry.getKey();
          AppMethodBeat.o(80967);
          return localObject;
        }
      }
      localObject = CGu;
      AppMethodBeat.o(80967);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c
 * JD-Core Version:    0.7.0.1
 */