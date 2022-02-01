package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
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
  public static s e(Context paramContext, List<doh> paramList)
  {
    AppMethodBeat.i(80969);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (doh)paramList.next();
      if ((localObject2 != null) && (a.auK(((doh)localObject2).YVh))) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (Util.isNullOrNil((List)localObject1))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Collections.sort((List)localObject1, new Comparator() {});
    int j = ((doh)((List)localObject1).get(((List)localObject1).size() - 1)).aaVn;
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
      localObject2 = (doh)((Iterator)localObject1).next();
      if ((((doh)localObject2).aaVn > 0) && (((doh)localObject2).aaVn <= paramList.size())) {
        paramList.set(((doh)localObject2).aaVn - 1, localObject2);
      }
    }
    paramContext = new s(paramContext);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (doh)paramList.next();
      if (localObject1 == null)
      {
        paramContext.c(-1, "");
      }
      else
      {
        localObject2 = ((doh)localObject1).hAP + "__" + ((doh)localObject1).ThumbUrl;
        paramContext.c(((doh)localObject1).aaVm, (CharSequence)localObject2);
      }
    }
    AppMethodBeat.o(80969);
    return paramContext;
  }
  
  public static enum a
  {
    private static EnumMap<a, Integer> XhI;
    int code;
    
    static
    {
      AppMethodBeat.i(80968);
      Xhz = new a("HVGAME_MENU_ACTION_DEFAULT", 0, 0);
      XhA = new a("HVGAME_MENU_ACTION_JUMP_H5", 1, 1);
      XhB = new a("HVGAME_MENU_ACTION_EXIT", 2, 2);
      XhC = new a("HVGAME_MENU_ACTION_SHARE_TO_FRIEND", 3, 3);
      XhD = new a("HVGAME_MENU_ACTION_COLLECT", 4, 4);
      XhE = new a("HVGAME_MENU_ACTION_REFRESH", 5, 7);
      XhF = new a("HVGAME_MENU_ACTION_ADD_TO_DESKTOP", 6, 8);
      XhG = new a("HVGAME_MENU_ACTION_COMPLAINT", 7, 9);
      XhH = new a("HVGAME_MENU_ACTION_CUSTOM", 8, 10);
      XhJ = new a[] { Xhz, XhA, XhB, XhC, XhD, XhE, XhF, XhG, XhH };
      XhI = new EnumMap(a.class);
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        XhI.put(locala, Integer.valueOf(locala.code));
      }
      AppMethodBeat.o(80968);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static boolean auK(int paramInt)
    {
      AppMethodBeat.i(80966);
      boolean bool = XhI.containsValue(Integer.valueOf(paramInt));
      AppMethodBeat.o(80966);
      return bool;
    }
    
    public static a auL(int paramInt)
    {
      AppMethodBeat.i(80967);
      Object localObject = XhI.entrySet().iterator();
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
      localObject = Xhz;
      AppMethodBeat.o(80967);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c
 * JD-Core Version:    0.7.0.1
 */