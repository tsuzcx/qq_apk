package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class al
{
  private static al BZO;
  private SharedPreferences BZL;
  private volatile boolean BZM;
  private boolean BZN;
  private long BZP;
  
  static
  {
    AppMethodBeat.i(117805);
    BZO = new al();
    AppMethodBeat.o(117805);
  }
  
  public al()
  {
    AppMethodBeat.i(117804);
    this.BZL = av.s(ai.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4);
    this.BZM = this.BZL.getBoolean("isUseSysWebview", false);
    this.BZN = false;
    if (System.currentTimeMillis() - this.BZP >= 7200000L)
    {
      this.BZP = System.currentTimeMillis();
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117803);
          Object localObject = a.a.geG;
          localObject = a.tJ("100387");
          if (localObject == null)
          {
            ac.i("WebSearchXWeb", "openSearchPreload item is null");
            AppMethodBeat.o(117803);
            return;
          }
          al localal = al.this;
          if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).eYV().get("isOpen")))) {}
          for (boolean bool = true;; bool = false)
          {
            al.a(localal, bool);
            AppMethodBeat.o(117803);
            return;
          }
        }
      }, "WebSearchXWeb-getSwitch");
    }
    AppMethodBeat.o(117804);
  }
  
  public static al exL()
  {
    return BZO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al
 * JD-Core Version:    0.7.0.1
 */