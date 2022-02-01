package com.tencent.xweb.pinus;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.pinus.sdk.CookieManager;

public final class c
  implements CookieInternal.ICookieSyncManagerInternal
{
  private CookieManager aikq;
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(213321);
    this.aikq = CookieManager.getInstance();
    AppMethodBeat.o(213321);
  }
  
  public final void sync()
  {
    AppMethodBeat.i(213328);
    if (this.aikq != null) {
      this.aikq.flush();
    }
    AppMethodBeat.o(213328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.c
 * JD-Core Version:    0.7.0.1
 */