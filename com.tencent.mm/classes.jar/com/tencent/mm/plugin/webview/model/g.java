package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ec;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.RWCache.Holder;
import com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class g
  implements RWCache.IRWCacheAppender<Integer, Long>
{
  public static final String[] SQL_CREATE;
  private static final IAutoDBItem.MAutoDBInfo nFK;
  public final RWCache<Integer, Long> PTS;
  private long PTT;
  public final com.tencent.mm.storagebase.h lvy;
  
  static
  {
    AppMethodBeat.i(78860);
    nFK = ec.aoY();
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(nFK, "JsLogBlockList") };
    AppMethodBeat.o(78860);
  }
  
  public g(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(78855);
    this.lvy = paramh;
    this.PTS = new RWCache(this, com.tencent.mm.kernel.h.aHJ().getLooper(), 100, 20, 300000L, 1000L);
    AppMethodBeat.o(78855);
  }
  
  public final void append(RWCache<Integer, Long> paramRWCache, RWCache.Holder<Integer, Long> paramHolder)
  {
    AppMethodBeat.i(216816);
    switch (paramHolder.funcType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216816);
      return;
      this.lvy.delete("JsLogBlockList", "logId=" + paramHolder.key, null);
      AppMethodBeat.o(216816);
      return;
      paramRWCache = new ContentValues(2);
      paramRWCache.put("logId", (Integer)paramHolder.key);
      paramRWCache.put("liftTime", (Long)paramHolder.values);
      this.lvy.replace("JsLogBlockList", "logId", paramRWCache);
    }
  }
  
  public final void gVo()
  {
    AppMethodBeat.i(78856);
    this.PTS.appendAll(true);
    AppMethodBeat.o(78856);
  }
  
  public final void postAppend()
  {
    AppMethodBeat.i(78859);
    if (this.PTT > 0L) {
      this.lvy.endTransaction(this.PTT);
    }
    AppMethodBeat.o(78859);
  }
  
  public final boolean preAppend()
  {
    AppMethodBeat.i(78857);
    if (this.lvy.inTransaction())
    {
      AppMethodBeat.o(78857);
      return false;
    }
    this.PTT = this.lvy.beginTransaction(Thread.currentThread().getId());
    if (this.PTT > 0L)
    {
      AppMethodBeat.o(78857);
      return true;
    }
    AppMethodBeat.o(78857);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.g
 * JD-Core Version:    0.7.0.1
 */