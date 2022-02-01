package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class ap
{
  private static ap DUI;
  private SharedPreferences DUF;
  private volatile boolean DUG;
  private boolean DUH;
  private long DUJ;
  
  static
  {
    AppMethodBeat.i(117805);
    DUI = new ap();
    AppMethodBeat.o(117805);
  }
  
  public ap()
  {
    AppMethodBeat.i(117804);
    this.DUF = ax.r(ak.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4);
    this.DUG = this.DUF.getBoolean("isUseSysWebview", false);
    this.DUH = false;
    if (System.currentTimeMillis() - this.DUJ >= 7200000L)
    {
      this.DUJ = System.currentTimeMillis();
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117803);
          Object localObject = a.a.gAX;
          localObject = a.xi("100387");
          if (localObject == null)
          {
            ae.i("WebSearchXWeb", "openSearchPreload item is null");
            AppMethodBeat.o(117803);
            return;
          }
          ap localap = ap.this;
          if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).fsy().get("isOpen")))) {}
          for (boolean bool = true;; bool = false)
          {
            ap.a(localap, bool);
            AppMethodBeat.o(117803);
            return;
          }
        }
      }, "WebSearchXWeb-getSwitch");
    }
    AppMethodBeat.o(117804);
  }
  
  public static ap eQn()
  {
    return DUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ap
 * JD-Core Version:    0.7.0.1
 */