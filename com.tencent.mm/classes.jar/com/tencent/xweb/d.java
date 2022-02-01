package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;

public final class d
{
  private static d IMo;
  static CookieInternal.ICookieSyncManagerInternal IMp;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(156725);
    if (IMp != null) {
      IMp.init(paramContext);
    }
    AppMethodBeat.o(156725);
  }
  
  public static d fqE()
  {
    try
    {
      AppMethodBeat.i(156724);
      if (IMo == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        AppMethodBeat.o(156724);
        throw localIllegalStateException;
      }
    }
    finally {}
    d locald = IMo;
    AppMethodBeat.o(156724);
    return locald;
  }
  
  public static d kU(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(156723);
      if (IMo == null) {
        IMo = new d(paramContext.getApplicationContext());
      }
      paramContext = IMo;
      AppMethodBeat.o(156723);
      return paramContext;
    }
    finally {}
  }
  
  public static void sync()
  {
    AppMethodBeat.i(156726);
    if (IMp != null) {
      IMp.sync();
    }
    AppMethodBeat.o(156726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.d
 * JD-Core Version:    0.7.0.1
 */