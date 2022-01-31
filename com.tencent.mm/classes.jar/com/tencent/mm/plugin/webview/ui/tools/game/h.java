package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
{
  public static String cGT;
  public static int cNH;
  public static String vny;
  
  public h(Intent paramIntent)
  {
    AppMethodBeat.i(8780);
    if (paramIntent == null)
    {
      AppMethodBeat.o(8780);
      return;
    }
    cGT = bo.nullAsNil(paramIntent.getStringExtra("KPublisherId"));
    vny = bo.nullAsNil(paramIntent.getStringExtra("geta8key_username"));
    cNH = bo.g(Integer.valueOf(paramIntent.getIntExtra("geta8key_scene", 0)));
    AppMethodBeat.o(8780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.h
 * JD-Core Version:    0.7.0.1
 */