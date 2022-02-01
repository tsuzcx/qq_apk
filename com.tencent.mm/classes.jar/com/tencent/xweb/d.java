package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;

public final class d
{
  private static d MLZ;
  static CookieInternal.ICookieSyncManagerInternal MMa;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(156725);
    if (MMa != null) {
      MMa.init(paramContext);
    }
    AppMethodBeat.o(156725);
  }
  
  public static d gfa()
  {
    try
    {
      AppMethodBeat.i(156724);
      if (MLZ == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        AppMethodBeat.o(156724);
        throw localIllegalStateException;
      }
    }
    finally {}
    d locald = MLZ;
    AppMethodBeat.o(156724);
    return locald;
  }
  
  public static d lB(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(156723);
      if (MLZ == null) {
        MLZ = new d(paramContext.getApplicationContext());
      }
      paramContext = MLZ;
      AppMethodBeat.o(156723);
      return paramContext;
    }
    finally {}
  }
  
  public static void sync()
  {
    AppMethodBeat.i(156726);
    if (MMa != null) {
      MMa.sync();
    }
    AppMethodBeat.o(156726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.d
 * JD-Core Version:    0.7.0.1
 */