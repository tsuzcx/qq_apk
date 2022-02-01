package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
{
  private static final SparseArray<j> Xln;
  private static volatile j Xlo;
  
  static
  {
    AppMethodBeat.i(82017);
    Xln = new SparseArray();
    Xlo = null;
    AppMethodBeat.o(82017);
  }
  
  public static j auP(int paramInt)
  {
    AppMethodBeat.i(82015);
    try
    {
      if (Xln.get(paramInt) == null)
      {
        localj = new j(paramInt);
        Xln.put(paramInt, localj);
      }
      j localj = (j)Xln.get(paramInt);
      Xlo = localj;
      return localj;
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
      while (i < Xln.size())
      {
        Xln.valueAt(i);
        Xln.keyAt(i);
        i += 1;
      }
      Xln.clear();
      if (Xlo != null) {
        Xlo = null;
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
  public static j iBr()
  {
    AppMethodBeat.i(82014);
    if (Xlo == null) {
      Xlo = new j(0);
    }
    j localj = Xlo;
    AppMethodBeat.o(82014);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.k
 * JD-Core Version:    0.7.0.1
 */