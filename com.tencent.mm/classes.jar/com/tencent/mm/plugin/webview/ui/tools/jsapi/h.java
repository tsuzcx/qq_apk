package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
{
  private static final SparseArray<g> vrL;
  private static volatile g vrM;
  
  static
  {
    AppMethodBeat.i(9809);
    vrL = new SparseArray();
    vrM = null;
    AppMethodBeat.o(9809);
  }
  
  public static g KW(int paramInt)
  {
    AppMethodBeat.i(9807);
    try
    {
      if (vrL.get(paramInt) == null)
      {
        localg = new g(paramInt);
        vrL.put(paramInt, localg);
      }
      g localg = (g)vrL.get(paramInt);
      vrM = localg;
      return localg;
    }
    finally
    {
      AppMethodBeat.o(9807);
    }
  }
  
  public static void detach()
  {
    AppMethodBeat.i(9808);
    ab.i("MicroMsg.MsgHandlerHolder", "detach");
    int i = 0;
    try
    {
      while (i < vrL.size())
      {
        vrL.valueAt(i);
        vrL.keyAt(i);
        i += 1;
      }
      vrL.clear();
      if (vrM != null) {
        vrM = null;
      }
      AppMethodBeat.o(9808);
      return;
    }
    finally
    {
      AppMethodBeat.o(9808);
    }
  }
  
  @Deprecated
  public static g dgP()
  {
    AppMethodBeat.i(9806);
    if (vrM == null) {
      vrM = new g(0);
    }
    g localg = vrM;
    AppMethodBeat.o(9806);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.h
 * JD-Core Version:    0.7.0.1
 */