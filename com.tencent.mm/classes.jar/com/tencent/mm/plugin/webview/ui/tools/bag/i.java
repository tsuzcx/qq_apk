package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;

public final class i
{
  static void a(g paramg, Point paramPoint, float paramFloat, e parame)
  {
    AppMethodBeat.i(8178);
    ay.ax(ah.getContext(), 2131306257);
    paramg.a(new i.1(parame, paramg, paramPoint, paramFloat));
    AppMethodBeat.o(8178);
  }
  
  public static void a(g paramg, Point paramPoint, e parame)
  {
    AppMethodBeat.i(8177);
    a(paramg, paramPoint, -1.0F, parame);
    AppMethodBeat.o(8177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.i
 * JD-Core Version:    0.7.0.1
 */