package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
{
  private static final SparseArray<f> BrO;
  private static volatile f BrP;
  
  static
  {
    AppMethodBeat.i(82017);
    BrO = new SparseArray();
    BrP = null;
    AppMethodBeat.o(82017);
  }
  
  public static f TO(int paramInt)
  {
    AppMethodBeat.i(82015);
    try
    {
      if (BrO.get(paramInt) == null)
      {
        localf = new f(paramInt);
        BrO.put(paramInt, localf);
      }
      f localf = (f)BrO.get(paramInt);
      BrP = localf;
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
      while (i < BrO.size())
      {
        BrO.valueAt(i);
        BrO.keyAt(i);
        i += 1;
      }
      BrO.clear();
      if (BrP != null) {
        BrP = null;
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
  public static f eqx()
  {
    AppMethodBeat.i(82014);
    if (BrP == null) {
      BrP = new f(0);
    }
    f localf = BrP;
    AppMethodBeat.o(82014);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g
 * JD-Core Version:    0.7.0.1
 */