package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static l c(Context paramContext, List<bpp> paramList)
  {
    AppMethodBeat.i(80969);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (bpp)paramList.next();
      if ((localObject2 != null) && (a.TJ(((bpp)localObject2).CKO))) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (bt.gL((List)localObject1))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Collections.sort((List)localObject1, new Comparator() {});
    int j = ((bpp)((List)localObject1).get(((List)localObject1).size() - 1)).DOa;
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
      localObject2 = (bpp)((Iterator)localObject1).next();
      if ((((bpp)localObject2).DOa > 0) && (((bpp)localObject2).DOa <= paramList.size())) {
        paramList.set(((bpp)localObject2).DOa - 1, localObject2);
      }
    }
    paramContext = new l(paramContext);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (bpp)paramList.next();
      if (localObject1 == null)
      {
        paramContext.c(-1, "");
      }
      else
      {
        localObject2 = ((bpp)localObject1).Title + "__" + ((bpp)localObject1).ThumbUrl;
        paramContext.c(((bpp)localObject1).DNZ, (CharSequence)localObject2);
      }
    }
    AppMethodBeat.o(80969);
    return paramContext;
  }
  
  public static enum a
  {
    private static EnumMap<a, Integer> Bow;
    int code;
    
    static
    {
      AppMethodBeat.i(80968);
      Bon = new a("HVGAME_MENU_ACTION_DEFAULT", 0, 0);
      Boo = new a("HVGAME_MENU_ACTION_JUMP_H5", 1, 1);
      Bop = new a("HVGAME_MENU_ACTION_EXIT", 2, 2);
      Boq = new a("HVGAME_MENU_ACTION_SHARE_TO_FRIEND", 3, 3);
      Bor = new a("HVGAME_MENU_ACTION_COLLECT", 4, 4);
      Bos = new a("HVGAME_MENU_ACTION_REFRESH", 5, 7);
      Bot = new a("HVGAME_MENU_ACTION_ADD_TO_DESKTOP", 6, 8);
      Bou = new a("HVGAME_MENU_ACTION_COMPLAINT", 7, 9);
      Bov = new a("HVGAME_MENU_ACTION_CUSTOM", 8, 10);
      Box = new a[] { Bon, Boo, Bop, Boq, Bor, Bos, Bot, Bou, Bov };
      Bow = new EnumMap(a.class);
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        Bow.put(locala, Integer.valueOf(locala.code));
      }
      AppMethodBeat.o(80968);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static boolean TJ(int paramInt)
    {
      AppMethodBeat.i(80966);
      boolean bool = Bow.containsValue(Integer.valueOf(paramInt));
      AppMethodBeat.o(80966);
      return bool;
    }
    
    public static a TK(int paramInt)
    {
      AppMethodBeat.i(80967);
      Object localObject = Bow.entrySet().iterator();
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
      localObject = Bon;
      AppMethodBeat.o(80967);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c
 * JD-Core Version:    0.7.0.1
 */