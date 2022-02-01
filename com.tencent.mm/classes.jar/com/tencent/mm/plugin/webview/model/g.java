package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.eq;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.RWCache.Holder;
import com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class g
  implements RWCache.IRWCacheAppender<Integer, Long>
{
  private static final IAutoDBItem.MAutoDBInfo DB_INFO;
  public static final String[] SQL_CREATE;
  public final RWCache<Integer, Long> WKE;
  private long WKF;
  public final com.tencent.mm.storagebase.h omV;
  
  static
  {
    AppMethodBeat.i(78860);
    DB_INFO = eq.aJm();
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(DB_INFO, "JsLogBlockList") };
    AppMethodBeat.o(78860);
  }
  
  public g(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(78855);
    this.omV = paramh;
    this.WKE = new RWCache(this, com.tencent.mm.kernel.h.baH().getLooper(), 100, 20, 300000L, 1000L);
    AppMethodBeat.o(78855);
  }
  
  public final void append(RWCache<Integer, Long> paramRWCache, RWCache.Holder<Integer, Long> paramHolder)
  {
    AppMethodBeat.i(298387);
    switch (paramHolder.funcType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(298387);
      return;
      this.omV.delete("JsLogBlockList", "logId=" + paramHolder.key, null);
      AppMethodBeat.o(298387);
      return;
      paramRWCache = new ContentValues(2);
      paramRWCache.put("logId", (Integer)paramHolder.key);
      paramRWCache.put("liftTime", (Long)paramHolder.values);
      this.omV.replace("JsLogBlockList", "logId", paramRWCache);
    }
  }
  
  public final void iuZ()
  {
    AppMethodBeat.i(78856);
    this.WKE.appendAll(true);
    AppMethodBeat.o(78856);
  }
  
  public final void postAppend()
  {
    AppMethodBeat.i(78859);
    if (this.WKF > 0L) {
      this.omV.endTransaction(this.WKF);
    }
    AppMethodBeat.o(78859);
  }
  
  public final boolean preAppend()
  {
    AppMethodBeat.i(78857);
    if (this.omV.inTransaction())
    {
      AppMethodBeat.o(78857);
      return false;
    }
    this.WKF = this.omV.beginTransaction(Thread.currentThread().getId());
    if (this.WKF > 0L)
    {
      AppMethodBeat.o(78857);
      return true;
    }
    AppMethodBeat.o(78857);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.g
 * JD-Core Version:    0.7.0.1
 */