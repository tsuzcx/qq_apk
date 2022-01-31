package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.xweb.c.b.b;

public final class e
  implements b.b
{
  CookieSyncManager BHU;
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(84806);
    this.BHU = CookieSyncManager.createInstance(paramContext);
    AppMethodBeat.o(84806);
  }
  
  public final void sync()
  {
    AppMethodBeat.i(84807);
    if (this.BHU != null) {
      this.BHU.sync();
    }
    AppMethodBeat.o(84807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.e
 * JD-Core Version:    0.7.0.1
 */