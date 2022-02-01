package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class av
{
  private static av Wqj;
  private volatile boolean Wqh;
  private boolean Wqi;
  private long Wqk;
  private SharedPreferences mPref;
  
  static
  {
    AppMethodBeat.i(117805);
    Wqj = new av();
    AppMethodBeat.o(117805);
  }
  
  public av()
  {
    AppMethodBeat.i(117804);
    this.mPref = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4, false);
    this.Wqh = this.mPref.getBoolean("isUseSysWebview", false);
    this.Wqi = false;
    if (System.currentTimeMillis() - this.Wqk >= 7200000L)
    {
      this.Wqk = System.currentTimeMillis();
      ThreadPool.post(new av.1(this), "WebSearchXWeb-getSwitch");
    }
    AppMethodBeat.o(117804);
  }
  
  public static av iqw()
  {
    return Wqj;
  }
  
  public static boolean iqx()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.av
 * JD-Core Version:    0.7.0.1
 */