package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
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
  public static m c(Context paramContext, List<coq> paramList)
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
      localObject2 = (coq)paramList.next();
      if ((localObject2 != null) && (a.agY(((coq)localObject2).KWb))) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (Util.isNullOrNil((List)localObject1))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Collections.sort((List)localObject1, new Comparator() {});
    int j = ((coq)((List)localObject1).get(((List)localObject1).size() - 1)).MuP;
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
      localObject2 = (coq)((Iterator)localObject1).next();
      if ((((coq)localObject2).MuP > 0) && (((coq)localObject2).MuP <= paramList.size())) {
        paramList.set(((coq)localObject2).MuP - 1, localObject2);
      }
    }
    paramContext = new m(paramContext);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (coq)paramList.next();
      if (localObject1 == null)
      {
        paramContext.d(-1, "");
      }
      else
      {
        localObject2 = ((coq)localObject1).Title + "__" + ((coq)localObject1).ThumbUrl;
        paramContext.d(((coq)localObject1).MuO, (CharSequence)localObject2);
      }
    }
    AppMethodBeat.o(80969);
    return paramContext;
  }
  
  public static enum a
  {
    private static EnumMap<a, Integer> JrX;
    int code;
    
    static
    {
      AppMethodBeat.i(80968);
      JrO = new a("HVGAME_MENU_ACTION_DEFAULT", 0, 0);
      JrP = new a("HVGAME_MENU_ACTION_JUMP_H5", 1, 1);
      JrQ = new a("HVGAME_MENU_ACTION_EXIT", 2, 2);
      JrR = new a("HVGAME_MENU_ACTION_SHARE_TO_FRIEND", 3, 3);
      JrS = new a("HVGAME_MENU_ACTION_COLLECT", 4, 4);
      JrT = new a("HVGAME_MENU_ACTION_REFRESH", 5, 7);
      JrU = new a("HVGAME_MENU_ACTION_ADD_TO_DESKTOP", 6, 8);
      JrV = new a("HVGAME_MENU_ACTION_COMPLAINT", 7, 9);
      JrW = new a("HVGAME_MENU_ACTION_CUSTOM", 8, 10);
      JrY = new a[] { JrO, JrP, JrQ, JrR, JrS, JrT, JrU, JrV, JrW };
      JrX = new EnumMap(a.class);
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        JrX.put(locala, Integer.valueOf(locala.code));
      }
      AppMethodBeat.o(80968);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static boolean agY(int paramInt)
    {
      AppMethodBeat.i(80966);
      boolean bool = JrX.containsValue(Integer.valueOf(paramInt));
      AppMethodBeat.o(80966);
      return bool;
    }
    
    public static a agZ(int paramInt)
    {
      AppMethodBeat.i(80967);
      Object localObject = JrX.entrySet().iterator();
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
      localObject = JrO;
      AppMethodBeat.o(80967);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c
 * JD-Core Version:    0.7.0.1
 */