package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
{
  public static String ECg;
  public static String dIz;
  public static int dPU;
  
  public h(Intent paramIntent)
  {
    AppMethodBeat.i(80955);
    if (paramIntent == null)
    {
      AppMethodBeat.o(80955);
      return;
    }
    dIz = bu.nullAsNil(paramIntent.getStringExtra("KPublisherId"));
    ECg = bu.nullAsNil(paramIntent.getStringExtra("geta8key_username"));
    dPU = bu.o(Integer.valueOf(paramIntent.getIntExtra("geta8key_scene", 0)));
    AppMethodBeat.o(80955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.h
 * JD-Core Version:    0.7.0.1
 */