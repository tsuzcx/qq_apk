package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.b.b;
import org.xwalk.core.XWalkCookieManager;

public final class e
  implements b.b
{
  XWalkCookieManager BJw;
  
  public e()
  {
    AppMethodBeat.i(85214);
    this.BJw = new XWalkCookieManager();
    AppMethodBeat.o(85214);
  }
  
  public final void init(Context paramContext) {}
  
  public final void sync()
  {
    AppMethodBeat.i(85215);
    if (this.BJw != null) {
      this.BJw.flushCookieStore();
    }
    AppMethodBeat.o(85215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e
 * JD-Core Version:    0.7.0.1
 */