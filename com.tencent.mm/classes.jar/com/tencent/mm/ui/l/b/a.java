package com.tencent.mm.ui.l.b;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.l.a.d;
import com.tencent.mm.ui.l.a.e;

public final class a
{
  public static void bnK(String paramString)
  {
    AppMethodBeat.i(234459);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
    {
      h.RTc.aV(new a.1(paramString));
      AppMethodBeat.o(234459);
      return;
    }
    Log.e("MicroMsg.MagicEmojiUtils", "hy: error in magic emoji: %s", new Object[] { paramString });
    AppMethodBeat.o(234459);
  }
  
  public static float cx(float paramFloat)
  {
    AppMethodBeat.i(234458);
    paramFloat = (float)Math.ceil(paramFloat / com.tencent.mm.plugin.appbrand.ac.g.bZk());
    AppMethodBeat.o(234458);
    return paramFloat;
  }
  
  public static void d(ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(234454);
    ((ViewGroup)paramViewGroup.getParent()).setClipToPadding(false);
    ((ViewGroup)paramViewGroup.getParent()).setClipChildren(false);
    while (paramView != paramViewGroup)
    {
      View localView = (View)paramView.getParent();
      paramView = localView;
      if ((localView instanceof ViewGroup))
      {
        ((ViewGroup)localView).setClipChildren(false);
        ((ViewGroup)localView).setClipToPadding(false);
        paramView = localView;
      }
    }
    AppMethodBeat.o(234454);
  }
  
  public static int[] g(com.tencent.mm.ui.l.a.g paramg)
  {
    AppMethodBeat.i(234455);
    if (!h(paramg))
    {
      paramg = new int[2];
      AppMethodBeat.o(234455);
      return paramg;
    }
    paramg = paramg.QlN.QlV.gWE();
    int i = paramg.x;
    int j = paramg.y;
    AppMethodBeat.o(234455);
    return new int[] { i, j };
  }
  
  private static boolean h(com.tencent.mm.ui.l.a.g paramg)
  {
    AppMethodBeat.i(234456);
    if (paramg == null)
    {
      Log.e("MicroMsg.MagicEmojiUtils", "hy: service is prepared");
      AppMethodBeat.o(234456);
      return false;
    }
    if (paramg.QlN == null)
    {
      Log.e("MicroMsg.MagicEmojiUtils", "hy: runtime not prepared");
      AppMethodBeat.o(234456);
      return false;
    }
    if (paramg.QlN.QlV == null)
    {
      Log.e("MicroMsg.MagicEmojiUtils", "hy: magic emoji page not valid");
      AppMethodBeat.o(234456);
      return false;
    }
    AppMethodBeat.o(234456);
    return true;
  }
  
  public static int[] hl(View paramView)
  {
    AppMethodBeat.i(234457);
    int[] arrayOfInt = new int[2];
    if (paramView == null)
    {
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(234457);
      return arrayOfInt;
      paramView.getLocationInWindow(arrayOfInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.b.a
 * JD-Core Version:    0.7.0.1
 */