package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.b.b;

public final class b
  implements b.b
{
  CookieSyncManager BHh;
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(84647);
    this.BHh = CookieSyncManager.createInstance(paramContext);
    AppMethodBeat.o(84647);
  }
  
  public final void sync()
  {
    AppMethodBeat.i(84648);
    if (this.BHh != null) {
      this.BHh.sync();
    }
    AppMethodBeat.o(84648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.b
 * JD-Core Version:    0.7.0.1
 */