package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
{
  public static String Xhu;
  public static String iag;
  public static int iiA;
  
  public i(Intent paramIntent)
  {
    AppMethodBeat.i(80955);
    if (paramIntent == null)
    {
      AppMethodBeat.o(80955);
      return;
    }
    iag = Util.nullAsNil(paramIntent.getStringExtra("KPublisherId"));
    Xhu = Util.nullAsNil(paramIntent.getStringExtra("geta8key_username"));
    iiA = Util.nullAsNil(Integer.valueOf(paramIntent.getIntExtra("geta8key_scene", 0)));
    AppMethodBeat.o(80955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.i
 * JD-Core Version:    0.7.0.1
 */