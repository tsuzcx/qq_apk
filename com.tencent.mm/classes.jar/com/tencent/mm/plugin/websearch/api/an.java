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

public final class an
{
  private static an AHx;
  private SharedPreferences AHu;
  private volatile boolean AHv;
  private boolean AHw;
  private long AHy;
  
  static
  {
    AppMethodBeat.i(117805);
    AHx = new an();
    AppMethodBeat.o(117805);
  }
  
  public an()
  {
    AppMethodBeat.i(117804);
    this.AHu = aw.s(aj.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4);
    this.AHv = this.AHu.getBoolean("isUseSysWebview", false);
    this.AHw = false;
    if (System.currentTimeMillis() - this.AHy >= 7200000L)
    {
      this.AHy = System.currentTimeMillis();
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117803);
          Object localObject = a.a.gaa;
          localObject = a.qu("100387");
          if (localObject == null)
          {
            ad.i("WebSearchXWeb", "openSearchPreload item is null");
            AppMethodBeat.o(117803);
            return;
          }
          an localan = an.this;
          if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).eJy().get("isOpen")))) {}
          for (boolean bool = true;; bool = false)
          {
            an.a(localan, bool);
            AppMethodBeat.o(117803);
            return;
          }
        }
      }, "WebSearchXWeb-getSwitch");
    }
    AppMethodBeat.o(117804);
  }
  
  public static an eir()
  {
    return AHx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.an
 * JD-Core Version:    0.7.0.1
 */