package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;

public final class d
{
  private static d KyH;
  static CookieInternal.ICookieSyncManagerInternal KyI;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(156725);
    if (KyI != null) {
      KyI.init(paramContext);
    }
    AppMethodBeat.o(156725);
  }
  
  public static d fJc()
  {
    try
    {
      AppMethodBeat.i(156724);
      if (KyH == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        AppMethodBeat.o(156724);
        throw localIllegalStateException;
      }
    }
    finally {}
    d locald = KyH;
    AppMethodBeat.o(156724);
    return locald;
  }
  
  public static d li(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(156723);
      if (KyH == null) {
        KyH = new d(paramContext.getApplicationContext());
      }
      paramContext = KyH;
      AppMethodBeat.o(156723);
      return paramContext;
    }
    finally {}
  }
  
  public static void sync()
  {
    AppMethodBeat.i(156726);
    if (KyI != null) {
      KyI.sync();
    }
    AppMethodBeat.o(156726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.d
 * JD-Core Version:    0.7.0.1
 */