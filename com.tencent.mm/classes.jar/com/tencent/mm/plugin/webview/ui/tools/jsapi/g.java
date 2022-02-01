package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
{
  private static final SparseArray<f> EFL;
  private static volatile f EFM;
  
  static
  {
    AppMethodBeat.i(82017);
    EFL = new SparseArray();
    EFM = null;
    AppMethodBeat.o(82017);
  }
  
  public static f Yt(int paramInt)
  {
    AppMethodBeat.i(82015);
    try
    {
      if (EFL.get(paramInt) == null)
      {
        localf = new f(paramInt);
        EFL.put(paramInt, localf);
      }
      f localf = (f)EFL.get(paramInt);
      EFM = localf;
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
    ae.i("MicroMsg.MsgHandlerHolder", "detach");
    int i = 0;
    try
    {
      while (i < EFL.size())
      {
        EFL.valueAt(i);
        EFL.keyAt(i);
        i += 1;
      }
      EFL.clear();
      if (EFM != null) {
        EFM = null;
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
  public static f eYA()
  {
    AppMethodBeat.i(82014);
    if (EFM == null) {
      EFM = new f(0);
    }
    f localf = EFM;
    AppMethodBeat.o(82014);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g
 * JD-Core Version:    0.7.0.1
 */