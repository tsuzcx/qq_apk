package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public enum c$a
{
  private static EnumMap<a, Integer> vnM;
  int code;
  
  static
  {
    AppMethodBeat.i(8815);
    vnD = new a("HVGAME_MENU_ACTION_DEFAULT", 0, 0);
    vnE = new a("HVGAME_MENU_ACTION_JUMP_H5", 1, 1);
    vnF = new a("HVGAME_MENU_ACTION_EXIT", 2, 2);
    vnG = new a("HVGAME_MENU_ACTION_SHARE_TO_FRIEND", 3, 3);
    vnH = new a("HVGAME_MENU_ACTION_COLLECT", 4, 4);
    vnI = new a("HVGAME_MENU_ACTION_REFRESH", 5, 7);
    vnJ = new a("HVGAME_MENU_ACTION_ADD_TO_DESKTOP", 6, 8);
    vnK = new a("HVGAME_MENU_ACTION_COMPLAINT", 7, 9);
    vnL = new a("HVGAME_MENU_ACTION_CUSTOM", 8, 10);
    vnN = new a[] { vnD, vnE, vnF, vnG, vnH, vnI, vnJ, vnK, vnL };
    vnM = new EnumMap(a.class);
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      vnM.put(locala, Integer.valueOf(locala.code));
    }
    AppMethodBeat.o(8815);
  }
  
  private c$a(int paramInt)
  {
    this.code = paramInt;
  }
  
  public static boolean KO(int paramInt)
  {
    AppMethodBeat.i(8813);
    boolean bool = vnM.containsValue(Integer.valueOf(paramInt));
    AppMethodBeat.o(8813);
    return bool;
  }
  
  public static a KP(int paramInt)
  {
    AppMethodBeat.i(8814);
    Object localObject = vnM.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt)
      {
        localObject = (a)localEntry.getKey();
        AppMethodBeat.o(8814);
        return localObject;
      }
    }
    localObject = vnD;
    AppMethodBeat.o(8814);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a
 * JD-Core Version:    0.7.0.1
 */