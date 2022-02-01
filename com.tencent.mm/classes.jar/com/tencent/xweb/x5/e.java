package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;

public final class e
  implements CookieInternal.ICookieSyncManagerInternal
{
  CookieSyncManager KEp;
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(153841);
    this.KEp = CookieSyncManager.createInstance(paramContext);
    AppMethodBeat.o(153841);
  }
  
  public final void sync()
  {
    AppMethodBeat.i(153842);
    if (this.KEp != null) {
      this.KEp.sync();
    }
    AppMethodBeat.o(153842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.e
 * JD-Core Version:    0.7.0.1
 */