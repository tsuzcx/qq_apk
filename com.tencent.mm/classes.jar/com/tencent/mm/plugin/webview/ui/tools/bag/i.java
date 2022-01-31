package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;

public final class i
{
  static void a(g paramg, Point paramPoint, float paramFloat, e parame)
  {
    au.G(ae.getContext(), R.l.webview_minimize_sound_path);
    paramg.a(new i.1(parame, paramg, paramPoint, paramFloat));
  }
  
  public static void a(g paramg, Point paramPoint, e parame)
  {
    a(paramg, paramPoint, -1.0F, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.i
 * JD-Core Version:    0.7.0.1
 */