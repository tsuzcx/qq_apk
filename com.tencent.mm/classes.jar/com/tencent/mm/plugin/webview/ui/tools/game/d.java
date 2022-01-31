package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;

public final class d
{
  public static String bYM;
  public static int cfb;
  public static String rwF;
  
  public d(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    bYM = bk.pm(paramIntent.getStringExtra("KPublisherId"));
    rwF = bk.pm(paramIntent.getStringExtra("geta8key_username"));
    cfb = bk.g(Integer.valueOf(paramIntent.getIntExtra("geta8key_scene", 0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.d
 * JD-Core Version:    0.7.0.1
 */