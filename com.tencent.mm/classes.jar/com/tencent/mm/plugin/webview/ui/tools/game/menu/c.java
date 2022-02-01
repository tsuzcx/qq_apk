package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
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
  public static o c(Context paramContext, List<cxc> paramList)
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
      localObject2 = (cxc)paramList.next();
      if ((localObject2 != null) && (a.aoP(((cxc)localObject2).RXp))) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (Util.isNullOrNil((List)localObject1))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Collections.sort((List)localObject1, new Comparator() {});
    int j = ((cxc)((List)localObject1).get(((List)localObject1).size() - 1)).TFG;
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
      localObject2 = (cxc)((Iterator)localObject1).next();
      if ((((cxc)localObject2).TFG > 0) && (((cxc)localObject2).TFG <= paramList.size())) {
        paramList.set(((cxc)localObject2).TFG - 1, localObject2);
      }
    }
    paramContext = new o(paramContext);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (cxc)paramList.next();
      if (localObject1 == null)
      {
        paramContext.d(-1, "");
      }
      else
      {
        localObject2 = ((cxc)localObject1).fwr + "__" + ((cxc)localObject1).ThumbUrl;
        paramContext.d(((cxc)localObject1).TFF, (CharSequence)localObject2);
      }
    }
    AppMethodBeat.o(80969);
    return paramContext;
  }
  
  public static enum a
  {
    private static EnumMap<a, Integer> Qpu;
    int code;
    
    static
    {
      AppMethodBeat.i(80968);
      Qpl = new a("HVGAME_MENU_ACTION_DEFAULT", 0, 0);
      Qpm = new a("HVGAME_MENU_ACTION_JUMP_H5", 1, 1);
      Qpn = new a("HVGAME_MENU_ACTION_EXIT", 2, 2);
      Qpo = new a("HVGAME_MENU_ACTION_SHARE_TO_FRIEND", 3, 3);
      Qpp = new a("HVGAME_MENU_ACTION_COLLECT", 4, 4);
      Qpq = new a("HVGAME_MENU_ACTION_REFRESH", 5, 7);
      Qpr = new a("HVGAME_MENU_ACTION_ADD_TO_DESKTOP", 6, 8);
      Qps = new a("HVGAME_MENU_ACTION_COMPLAINT", 7, 9);
      Qpt = new a("HVGAME_MENU_ACTION_CUSTOM", 8, 10);
      Qpv = new a[] { Qpl, Qpm, Qpn, Qpo, Qpp, Qpq, Qpr, Qps, Qpt };
      Qpu = new EnumMap(a.class);
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        Qpu.put(locala, Integer.valueOf(locala.code));
      }
      AppMethodBeat.o(80968);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static boolean aoP(int paramInt)
    {
      AppMethodBeat.i(80966);
      boolean bool = Qpu.containsValue(Integer.valueOf(paramInt));
      AppMethodBeat.o(80966);
      return bool;
    }
    
    public static a aoQ(int paramInt)
    {
      AppMethodBeat.i(80967);
      Object localObject = Qpu.entrySet().iterator();
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
      localObject = Qpl;
      AppMethodBeat.o(80967);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c
 * JD-Core Version:    0.7.0.1
 */