package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;

public final class d
{
  private static d ZZF;
  static CookieInternal.ICookieSyncManagerInternal ZZG;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(156725);
    if (ZZG != null) {
      ZZG.init(paramContext);
    }
    AppMethodBeat.o(156725);
  }
  
  public static d ivZ()
  {
    try
    {
      AppMethodBeat.i(156724);
      if (ZZF == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        AppMethodBeat.o(156724);
        throw localIllegalStateException;
      }
    }
    finally {}
    d locald = ZZF;
    AppMethodBeat.o(156724);
    return locald;
  }
  
  public static d my(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(156723);
      if (ZZF == null) {
        ZZF = new d(paramContext.getApplicationContext());
      }
      paramContext = ZZF;
      AppMethodBeat.o(156723);
      return paramContext;
    }
    finally {}
  }
  
  public static void sync()
  {
    AppMethodBeat.i(156726);
    if (ZZG != null) {
      ZZG.sync();
    }
    AppMethodBeat.o(156726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.d
 * JD-Core Version:    0.7.0.1
 */