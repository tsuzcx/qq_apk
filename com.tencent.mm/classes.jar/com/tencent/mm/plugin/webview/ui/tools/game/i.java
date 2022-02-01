package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
{
  public static String Boj;
  public static int dEF;
  public static String dxF;
  
  public i(Intent paramIntent)
  {
    AppMethodBeat.i(80955);
    if (paramIntent == null)
    {
      AppMethodBeat.o(80955);
      return;
    }
    dxF = bt.nullAsNil(paramIntent.getStringExtra("KPublisherId"));
    Boj = bt.nullAsNil(paramIntent.getStringExtra("geta8key_username"));
    dEF = bt.l(Integer.valueOf(paramIntent.getIntExtra("geta8key_scene", 0)));
    AppMethodBeat.o(80955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.i
 * JD-Core Version:    0.7.0.1
 */