package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;

public final class d
{
  private static d aieo;
  CookieInternal.ICookieSyncManagerInternal aiep;
  
  public static d kfq()
  {
    try
    {
      AppMethodBeat.i(156724);
      if (aieo == null) {
        aieo = new d();
      }
      d locald = aieo;
      AppMethodBeat.o(156724);
      return locald;
    }
    finally {}
  }
  
  @Deprecated
  public final void init(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(212390);
      if ((this.aiep != null) && (paramContext != null)) {
        this.aiep.init(paramContext.getApplicationContext());
      }
      AppMethodBeat.o(212390);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.d
 * JD-Core Version:    0.7.0.1
 */