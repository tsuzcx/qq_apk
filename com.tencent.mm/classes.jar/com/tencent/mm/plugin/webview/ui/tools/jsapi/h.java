package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.mm.plugin.webview.modelcache.q;
import com.tencent.mm.plugin.webview.modelcache.q.a;
import com.tencent.mm.sdk.platformtools.y;

public final class h
{
  private static final SparseArray<g> rAJ = new SparseArray();
  private static volatile g rAK = null;
  
  public static g Db(int paramInt)
  {
    try
    {
      if (rAJ.get(paramInt) == null)
      {
        localg = new g(paramInt);
        rAJ.put(paramInt, localg);
      }
      g localg = (g)rAJ.get(paramInt);
      rAK = localg;
      return localg;
    }
    finally {}
  }
  
  @Deprecated
  public static g cgA()
  {
    if (rAK == null) {
      rAK = new g(0);
    }
    return rAK;
  }
  
  public static void detach()
  {
    y.i("MicroMsg.MsgHandlerHolder", "detach");
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < rAJ.size())
        {
          g localg = (g)rAJ.valueAt(i);
          int j = rAJ.keyAt(i);
          if (localg != null) {
            q.a.ccy().Ch(j);
          }
        }
        else
        {
          rAJ.clear();
          if (rAK != null)
          {
            q.a.ccy().Ch(0);
            rAK = null;
          }
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.h
 * JD-Core Version:    0.7.0.1
 */