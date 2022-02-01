package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class ap
{
  private static ap DCK;
  private SharedPreferences DCH;
  private volatile boolean DCI;
  private boolean DCJ;
  private long DCL;
  
  static
  {
    AppMethodBeat.i(117805);
    DCK = new ap();
    AppMethodBeat.o(117805);
  }
  
  public ap()
  {
    AppMethodBeat.i(117804);
    this.DCH = aw.s(aj.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4);
    this.DCI = this.DCH.getBoolean("isUseSysWebview", false);
    this.DCJ = false;
    if (System.currentTimeMillis() - this.DCL >= 7200000L)
    {
      this.DCL = System.currentTimeMillis();
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117803);
          Object localObject = a.a.gyq;
          localObject = a.wz("100387");
          if (localObject == null)
          {
            ad.i("WebSearchXWeb", "openSearchPreload item is null");
            AppMethodBeat.o(117803);
            return;
          }
          ap localap = ap.this;
          if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).foF().get("isOpen")))) {}
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
  
  public static ap eMC()
  {
    return DCK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ap
 * JD-Core Version:    0.7.0.1
 */