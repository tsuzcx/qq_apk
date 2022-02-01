package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/KV18589Report;", "", "()V", "OP_CANCEL", "", "OP_FAV", "OP_SEND_TO_FRIEND", "OP_SNS", "SCENE_CHAT", "SCENE_FAV", "SCENE_MP", "SCENE_SNS", "SHOW_MENU_FROM_JSAPI", "SHOW_MENU_FROM_JSAPI_SHARE", "SHOW_MENU_FROM_LONG_PRESS", "SHOW_MENU_FROM_MORE", "SHOW_MENU_FROM_SHARE", "TAG", "", "reportMenuClick", "", "opType", "from", "scene", "reportShowMenu", "plugin-webview_release"})
public final class a
{
  public static final a Qtn;
  private static final String TAG = "MicroMsg.KV18589Report";
  
  static
  {
    AppMethodBeat.i(82580);
    Qtn = new a();
    TAG = "MicroMsg.KV18589Report";
    AppMethodBeat.o(82580);
  }
  
  public static void aR(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82579);
    h localh;
    switch (paramInt1)
    {
    case 3: 
    default: 
      localh = h.IzE;
      switch (paramInt2)
      {
      case 4: 
      default: 
        paramInt1 = 9;
      }
      break;
    }
    for (;;)
    {
      localh.a(18589, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(82579);
      return;
      localh = h.IzE;
      switch (paramInt2)
      {
      case 4: 
      default: 
        paramInt1 = 7;
      }
      for (;;)
      {
        localh.a(18589, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(82579);
        return;
        paramInt1 = 11;
        continue;
        paramInt1 = 3;
        continue;
        paramInt1 = 23;
        continue;
        paramInt1 = 19;
      }
      localh = h.IzE;
      switch (paramInt2)
      {
      case 2: 
      default: 
        paramInt1 = 8;
      }
      for (;;)
      {
        localh.a(18589, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(82579);
        return;
        paramInt1 = 12;
        continue;
        paramInt1 = 4;
      }
      localh = h.IzE;
      switch (paramInt2)
      {
      case 4: 
      default: 
        paramInt1 = 18;
      }
      for (;;)
      {
        localh.a(18589, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(82579);
        return;
        paramInt1 = 22;
        continue;
        paramInt1 = 17;
        continue;
        paramInt1 = 24;
        continue;
        paramInt1 = 20;
      }
      paramInt1 = 13;
      continue;
      paramInt1 = 5;
      continue;
      paramInt1 = 25;
      continue;
      paramInt1 = 21;
    }
  }
  
  public static void lL(int paramInt1, int paramInt2)
  {
    int i = 2;
    AppMethodBeat.i(82578);
    h localh = h.IzE;
    switch (paramInt1)
    {
    }
    for (i = 6;; i = 10)
    {
      localh.a(18589, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(82578);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.a
 * JD-Core Version:    0.7.0.1
 */