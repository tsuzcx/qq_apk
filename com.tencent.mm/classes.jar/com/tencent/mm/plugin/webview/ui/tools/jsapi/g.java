package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
{
  private static final SparseArray<f> Jvo;
  private static volatile f Jvp;
  
  static
  {
    AppMethodBeat.i(82017);
    Jvo = new SparseArray();
    Jvp = null;
    AppMethodBeat.o(82017);
  }
  
  public static f ahd(int paramInt)
  {
    AppMethodBeat.i(82015);
    try
    {
      if (Jvo.get(paramInt) == null)
      {
        localf = new f(paramInt);
        Jvo.put(paramInt, localf);
      }
      f localf = (f)Jvo.get(paramInt);
      Jvp = localf;
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
    Log.i("MicroMsg.MsgHandlerHolder", "detach");
    int i = 0;
    try
    {
      while (i < Jvo.size())
      {
        Jvo.valueAt(i);
        Jvo.keyAt(i);
        i += 1;
      }
      Jvo.clear();
      if (Jvp != null) {
        Jvp = null;
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
  public static f ghF()
  {
    AppMethodBeat.i(82014);
    if (Jvp == null) {
      Jvp = new f(0);
    }
    f localf = Jvp;
    AppMethodBeat.o(82014);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g
 * JD-Core Version:    0.7.0.1
 */