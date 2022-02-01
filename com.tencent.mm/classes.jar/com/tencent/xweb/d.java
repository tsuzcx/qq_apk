package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;

public final class d
{
  private static d Mpd;
  static CookieInternal.ICookieSyncManagerInternal Mpe;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(156725);
    if (Mpe != null) {
      Mpe.init(paramContext);
    }
    AppMethodBeat.o(156725);
  }
  
  public static d gay()
  {
    try
    {
      AppMethodBeat.i(156724);
      if (Mpd == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        AppMethodBeat.o(156724);
        throw localIllegalStateException;
      }
    }
    finally {}
    d locald = Mpd;
    AppMethodBeat.o(156724);
    return locald;
  }
  
  public static d lv(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(156723);
      if (Mpd == null) {
        Mpd = new d(paramContext.getApplicationContext());
      }
      paramContext = Mpd;
      AppMethodBeat.o(156723);
      return paramContext;
    }
    finally {}
  }
  
  public static void sync()
  {
    AppMethodBeat.i(156726);
    if (Mpe != null) {
      Mpe.sync();
    }
    AppMethodBeat.o(156726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.d
 * JD-Core Version:    0.7.0.1
 */