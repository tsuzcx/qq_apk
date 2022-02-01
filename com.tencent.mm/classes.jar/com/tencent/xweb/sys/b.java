package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;

public final class b
  implements CookieInternal.ICookieSyncManagerInternal
{
  CookieSyncManager IQS;
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(153655);
    this.IQS = CookieSyncManager.createInstance(paramContext);
    AppMethodBeat.o(153655);
  }
  
  public final void sync()
  {
    AppMethodBeat.i(153656);
    if (this.IQS != null) {
      this.IQS.sync();
    }
    AppMethodBeat.o(153656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.b
 * JD-Core Version:    0.7.0.1
 */