package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ds;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bg.b;
import com.tencent.mm.sdk.platformtools.bg.c;
import com.tencent.mm.storagebase.h;

public final class g
  implements bg.c<Integer, Long>
{
  public static final String[] SQL_CREATE;
  private static final c.a jGU;
  public final bg<Integer, Long> DSD;
  private long DSE;
  public final h hHS;
  
  static
  {
    AppMethodBeat.i(78860);
    jGU = ds.Vv();
    SQL_CREATE = new String[] { j.getCreateSQLs(jGU, "JsLogBlockList") };
    AppMethodBeat.o(78860);
  }
  
  public g(h paramh)
  {
    AppMethodBeat.i(78855);
    this.hHS = paramh;
    this.DSD = new bg(this, com.tencent.mm.kernel.g.ajF().IdO.getLooper(), 100, 20);
    AppMethodBeat.o(78855);
  }
  
  public final void a(bg.b<Integer, Long> paramb)
  {
    AppMethodBeat.i(78858);
    switch (paramb.IfE)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78858);
      return;
      this.hHS.delete("JsLogBlockList", "logId=" + paramb.aIw, null);
      AppMethodBeat.o(78858);
      return;
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("logId", (Integer)paramb.aIw);
      localContentValues.put("liftTime", (Long)paramb.values);
      this.hHS.replace("JsLogBlockList", "logId", localContentValues);
    }
  }
  
  public final boolean aLK()
  {
    AppMethodBeat.i(78857);
    if (this.hHS.inTransaction())
    {
      AppMethodBeat.o(78857);
      return false;
    }
    this.DSE = this.hHS.xO(Thread.currentThread().getId());
    if (this.DSE > 0L)
    {
      AppMethodBeat.o(78857);
      return true;
    }
    AppMethodBeat.o(78857);
    return false;
  }
  
  public final void aLL()
  {
    AppMethodBeat.i(78859);
    if (this.DSE > 0L) {
      this.hHS.sJ(this.DSE);
    }
    AppMethodBeat.o(78859);
  }
  
  public final void ePU()
  {
    AppMethodBeat.i(78856);
    this.DSD.wJ(true);
    AppMethodBeat.o(78856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.g
 * JD-Core Version:    0.7.0.1
 */