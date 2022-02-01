package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.sdk.platformtools.bu;
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
  public static l c(Context paramContext, List<bzp> paramList)
  {
    AppMethodBeat.i(80969);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (bzp)paramList.next();
      if ((localObject2 != null) && (a.Yo(((bzp)localObject2).GbY))) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (bu.ht((List)localObject1))
    {
      AppMethodBeat.o(80969);
      return null;
    }
    Collections.sort((List)localObject1, new Comparator() {});
    int j = ((bzp)((List)localObject1).get(((List)localObject1).size() - 1)).HnA;
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
      localObject2 = (bzp)((Iterator)localObject1).next();
      if ((((bzp)localObject2).HnA > 0) && (((bzp)localObject2).HnA <= paramList.size())) {
        paramList.set(((bzp)localObject2).HnA - 1, localObject2);
      }
    }
    paramContext = new l(paramContext);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (bzp)paramList.next();
      if (localObject1 == null)
      {
        paramContext.d(-1, "");
      }
      else
      {
        localObject2 = ((bzp)localObject1).Title + "__" + ((bzp)localObject1).ThumbUrl;
        paramContext.d(((bzp)localObject1).Hnz, (CharSequence)localObject2);
      }
    }
    AppMethodBeat.o(80969);
    return paramContext;
  }
  
  public static enum a
  {
    private static EnumMap<a, Integer> ECt;
    int code;
    
    static
    {
      AppMethodBeat.i(80968);
      ECk = new a("HVGAME_MENU_ACTION_DEFAULT", 0, 0);
      ECl = new a("HVGAME_MENU_ACTION_JUMP_H5", 1, 1);
      ECm = new a("HVGAME_MENU_ACTION_EXIT", 2, 2);
      ECn = new a("HVGAME_MENU_ACTION_SHARE_TO_FRIEND", 3, 3);
      ECo = new a("HVGAME_MENU_ACTION_COLLECT", 4, 4);
      ECp = new a("HVGAME_MENU_ACTION_REFRESH", 5, 7);
      ECq = new a("HVGAME_MENU_ACTION_ADD_TO_DESKTOP", 6, 8);
      ECr = new a("HVGAME_MENU_ACTION_COMPLAINT", 7, 9);
      ECs = new a("HVGAME_MENU_ACTION_CUSTOM", 8, 10);
      ECu = new a[] { ECk, ECl, ECm, ECn, ECo, ECp, ECq, ECr, ECs };
      ECt = new EnumMap(a.class);
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        ECt.put(locala, Integer.valueOf(locala.code));
      }
      AppMethodBeat.o(80968);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static boolean Yo(int paramInt)
    {
      AppMethodBeat.i(80966);
      boolean bool = ECt.containsValue(Integer.valueOf(paramInt));
      AppMethodBeat.o(80966);
      return bool;
    }
    
    public static a Yp(int paramInt)
    {
      AppMethodBeat.i(80967);
      Object localObject = ECt.entrySet().iterator();
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
      localObject = ECk;
      AppMethodBeat.o(80967);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c
 * JD-Core Version:    0.7.0.1
 */