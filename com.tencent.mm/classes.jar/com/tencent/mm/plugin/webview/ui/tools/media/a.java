package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/KV18589Report;", "", "()V", "OP_CANCEL", "", "OP_FAV", "OP_SEND_TO_FRIEND", "SCENE_CHAT", "SCENE_FAV", "SCENE_MP", "SHOW_MENU_FROM_JSAPI", "SHOW_MENU_FROM_LONG_PRESS", "SHOW_MENU_FROM_MORE", "TAG", "", "reportMenuClick", "", "opType", "from", "scene", "reportShowMenu", "plugin-webview_release"})
public final class a
{
  public static final a Bsg;
  private static final String TAG = "MicroMsg.KV18589Report";
  
  static
  {
    AppMethodBeat.i(82580);
    Bsg = new a();
    TAG = "MicroMsg.KV18589Report";
    AppMethodBeat.o(82580);
  }
  
  public static void aB(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82579);
    h localh;
    switch (paramInt1)
    {
    default: 
      localh = h.vKh;
      switch (paramInt2)
      {
      default: 
        paramInt1 = 9;
      }
      break;
    }
    for (;;)
    {
      localh.f(18589, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(82579);
      return;
      localh = h.vKh;
      switch (paramInt2)
      {
      default: 
        paramInt1 = 7;
      }
      for (;;)
      {
        localh.f(18589, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(82579);
        return;
        paramInt1 = 11;
        continue;
        paramInt1 = 3;
      }
      localh = h.vKh;
      switch (paramInt2)
      {
      default: 
        paramInt1 = 8;
      }
      for (;;)
      {
        localh.f(18589, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(82579);
        return;
        paramInt1 = 12;
        continue;
        paramInt1 = 4;
      }
      paramInt1 = 13;
      continue;
      paramInt1 = 5;
    }
  }
  
  public static void iF(int paramInt1, int paramInt2)
  {
    int i = 2;
    AppMethodBeat.i(82578);
    h localh = h.vKh;
    switch (paramInt1)
    {
    }
    for (i = 6;; i = 10)
    {
      localh.f(18589, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(82578);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.a
 * JD-Core Version:    0.7.0.1
 */