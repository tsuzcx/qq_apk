package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
{
  private static final SparseArray<f> CJU;
  private static volatile f CJV;
  
  static
  {
    AppMethodBeat.i(82017);
    CJU = new SparseArray();
    CJV = null;
    AppMethodBeat.o(82017);
  }
  
  public static f VW(int paramInt)
  {
    AppMethodBeat.i(82015);
    try
    {
      if (CJU.get(paramInt) == null)
      {
        localf = new f(paramInt);
        CJU.put(paramInt, localf);
      }
      f localf = (f)CJU.get(paramInt);
      CJV = localf;
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
    ac.i("MicroMsg.MsgHandlerHolder", "detach");
    int i = 0;
    try
    {
      while (i < CJU.size())
      {
        CJU.valueAt(i);
        CJU.keyAt(i);
        i += 1;
      }
      CJU.clear();
      if (CJV != null) {
        CJV = null;
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
  public static f eFR()
  {
    AppMethodBeat.i(82014);
    if (CJV == null) {
      CJV = new f(0);
    }
    f localf = CJV;
    AppMethodBeat.o(82014);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g
 * JD-Core Version:    0.7.0.1
 */