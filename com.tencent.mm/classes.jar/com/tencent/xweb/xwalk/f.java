package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import org.xwalk.core.XWalkCookieManager;

public final class f
  implements CookieInternal.ICookieSyncManagerInternal
{
  XWalkCookieManager MwE;
  
  public f()
  {
    AppMethodBeat.i(154262);
    this.MwE = new XWalkCookieManager();
    AppMethodBeat.o(154262);
  }
  
  public final void init(Context paramContext) {}
  
  public final void sync()
  {
    AppMethodBeat.i(154263);
    if (this.MwE != null) {
      this.MwE.flushCookieStore();
    }
    AppMethodBeat.o(154263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f
 * JD-Core Version:    0.7.0.1
 */