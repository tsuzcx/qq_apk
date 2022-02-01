package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
{
  private static final SparseArray<f> EnH;
  private static volatile f EnI;
  
  static
  {
    AppMethodBeat.i(82017);
    EnH = new SparseArray();
    EnI = null;
    AppMethodBeat.o(82017);
  }
  
  public static f XN(int paramInt)
  {
    AppMethodBeat.i(82015);
    try
    {
      if (EnH.get(paramInt) == null)
      {
        localf = new f(paramInt);
        EnH.put(paramInt, localf);
      }
      f localf = (f)EnH.get(paramInt);
      EnI = localf;
      return localf;
    }
    finally
    {
      AppMethodBeat.o(82015);
    }
  }
  
  public static void detach()
  {
    AppMethodBeat.i(82016);
    ad.i("MicroMsg.MsgHandlerHolder", "detach");
    int i = 0;
    try
    {
      while (i < EnH.size())
      {
        EnH.valueAt(i);
        EnH.keyAt(i);
        i += 1;
      }
      EnH.clear();
      if (EnI != null) {
        EnI = null;
      }
      AppMethodBeat.o(82016);
      return;
    }
    finally
    {
      AppMethodBeat.o(82016);
    }
  }
  
  @Deprecated
  public static f eUN()
  {
    AppMethodBeat.i(82014);
    if (EnI == null) {
      EnI = new f(0);
    }
    f localf = EnI;
    AppMethodBeat.o(82014);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g
 * JD-Core Version:    0.7.0.1
 */