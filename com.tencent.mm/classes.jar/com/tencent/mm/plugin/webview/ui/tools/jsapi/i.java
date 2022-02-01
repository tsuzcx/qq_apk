package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  private static final SparseArray<h> QsV;
  private static volatile h QsW;
  
  static
  {
    AppMethodBeat.i(82017);
    QsV = new SparseArray();
    QsW = null;
    AppMethodBeat.o(82017);
  }
  
  public static h aoU(int paramInt)
  {
    AppMethodBeat.i(82015);
    try
    {
      if (QsV.get(paramInt) == null)
      {
        localh = new h(paramInt);
        QsV.put(paramInt, localh);
      }
      h localh = (h)QsV.get(paramInt);
      QsW = localh;
      return localh;
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
      while (i < QsV.size())
      {
        QsV.valueAt(i);
        QsV.keyAt(i);
        i += 1;
      }
      QsV.clear();
      if (QsW != null) {
        QsW = null;
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
  public static h hbc()
  {
    AppMethodBeat.i(82014);
    if (QsW == null) {
      QsW = new h(0);
    }
    h localh = QsW;
    AppMethodBeat.o(82014);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.i
 * JD-Core Version:    0.7.0.1
 */