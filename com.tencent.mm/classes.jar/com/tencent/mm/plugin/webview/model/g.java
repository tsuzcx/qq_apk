package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.RWCache.Holder;
import com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class g
  implements RWCache.IRWCacheAppender<Integer, Long>
{
  public static final String[] SQL_CREATE;
  private static final IAutoDBItem.MAutoDBInfo kLR;
  public final RWCache<Integer, Long> IXB;
  private long IXC;
  public final h iFy;
  
  static
  {
    AppMethodBeat.i(78860);
    kLR = dy.ajs();
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(kLR, "JsLogBlockList") };
    AppMethodBeat.o(78860);
  }
  
  public g(h paramh)
  {
    AppMethodBeat.i(78855);
    this.iFy = paramh;
    this.IXB = new RWCache(this, com.tencent.mm.kernel.g.aAk().getLooper(), 100, 20, 300000L, 1000L);
    AppMethodBeat.o(78855);
  }
  
  public final void append(RWCache<Integer, Long> paramRWCache, RWCache.Holder<Integer, Long> paramHolder)
  {
    AppMethodBeat.i(210972);
    switch (paramHolder.funcType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210972);
      return;
      this.iFy.delete("JsLogBlockList", "logId=" + paramHolder.key, null);
      AppMethodBeat.o(210972);
      return;
      paramRWCache = new ContentValues(2);
      paramRWCache.put("logId", (Integer)paramHolder.key);
      paramRWCache.put("liftTime", (Long)paramHolder.values);
      this.iFy.replace("JsLogBlockList", "logId", paramRWCache);
    }
  }
  
  public final void gct()
  {
    AppMethodBeat.i(78856);
    this.IXB.appendAll(true);
    AppMethodBeat.o(78856);
  }
  
  public final void postAppend()
  {
    AppMethodBeat.i(78859);
    if (this.IXC > 0L) {
      this.iFy.endTransaction(this.IXC);
    }
    AppMethodBeat.o(78859);
  }
  
  public final boolean preAppend()
  {
    AppMethodBeat.i(78857);
    if (this.iFy.inTransaction())
    {
      AppMethodBeat.o(78857);
      return false;
    }
    this.IXC = this.iFy.beginTransaction(Thread.currentThread().getId());
    if (this.IXC > 0L)
    {
      AppMethodBeat.o(78857);
      return true;
    }
    AppMethodBeat.o(78857);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.g
 * JD-Core Version:    0.7.0.1
 */