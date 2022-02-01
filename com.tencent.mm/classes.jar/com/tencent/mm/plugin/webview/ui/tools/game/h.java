package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
{
  public static String JrK;
  public static String eam;
  public static int ehX;
  
  public h(Intent paramIntent)
  {
    AppMethodBeat.i(80955);
    if (paramIntent == null)
    {
      AppMethodBeat.o(80955);
      return;
    }
    eam = Util.nullAsNil(paramIntent.getStringExtra("KPublisherId"));
    JrK = Util.nullAsNil(paramIntent.getStringExtra("geta8key_username"));
    ehX = Util.nullAsNil(Integer.valueOf(paramIntent.getIntExtra("geta8key_scene", 0)));
    AppMethodBeat.o(80955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.h
 * JD-Core Version:    0.7.0.1
 */