package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class au
{
  private static au PzU;
  private volatile boolean PzS;
  private boolean PzT;
  private long PzV;
  private SharedPreferences mPref;
  
  static
  {
    AppMethodBeat.i(117805);
    PzU = new au();
    AppMethodBeat.o(117805);
  }
  
  public au()
  {
    AppMethodBeat.i(117804);
    this.mPref = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4, false);
    this.PzS = this.mPref.getBoolean("isUseSysWebview", false);
    this.PzT = false;
    if (System.currentTimeMillis() - this.PzV >= 7200000L)
    {
      this.PzV = System.currentTimeMillis();
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117803);
          Object localObject = a.a.jZD;
          localObject = a.Mu("100387");
          if (localObject == null)
          {
            Log.i("WebSearchXWeb", "openSearchPreload item is null");
            AppMethodBeat.o(117803);
            return;
          }
          au localau = au.this;
          if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).hvz().get("isOpen")))) {}
          for (boolean bool = true;; bool = false)
          {
            au.a(localau, bool);
            AppMethodBeat.o(117803);
            return;
          }
        }
      }, "WebSearchXWeb-getSwitch");
    }
    AppMethodBeat.o(117804);
  }
  
  public static au gRm()
  {
    return PzU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.au
 * JD-Core Version:    0.7.0.1
 */