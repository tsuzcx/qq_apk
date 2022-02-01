package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ds;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.b;
import com.tencent.mm.sdk.platformtools.bh.c;
import com.tencent.mm.storagebase.h;

public final class g
  implements bh.c<Integer, Long>
{
  public static final String[] SQL_CREATE;
  private static final c.a jJU;
  public final bh<Integer, Long> EkD;
  private long EkE;
  public final h hKK;
  
  static
  {
    AppMethodBeat.i(78860);
    jJU = ds.VD();
    SQL_CREATE = new String[] { j.getCreateSQLs(jJU, "JsLogBlockList") };
    AppMethodBeat.o(78860);
  }
  
  public g(h paramh)
  {
    AppMethodBeat.i(78855);
    this.hKK = paramh;
    this.EkD = new bh(this, com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), 100, 20);
    AppMethodBeat.o(78855);
  }
  
  public final void a(bh.b<Integer, Long> paramb)
  {
    AppMethodBeat.i(78858);
    switch (paramb.IzP)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78858);
      return;
      this.hKK.delete("JsLogBlockList", "logId=" + paramb.aIw, null);
      AppMethodBeat.o(78858);
      return;
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("logId", (Integer)paramb.aIw);
      localContentValues.put("liftTime", (Long)paramb.values);
      this.hKK.replace("JsLogBlockList", "logId", localContentValues);
    }
  }
  
  public final boolean aMh()
  {
    AppMethodBeat.i(78857);
    if (this.hKK.inTransaction())
    {
      AppMethodBeat.o(78857);
      return false;
    }
    this.EkE = this.hKK.yi(Thread.currentThread().getId());
    if (this.EkE > 0L)
    {
      AppMethodBeat.o(78857);
      return true;
    }
    AppMethodBeat.o(78857);
    return false;
  }
  
  public final void aMi()
  {
    AppMethodBeat.i(78859);
    if (this.EkE > 0L) {
      this.hKK.sW(this.EkE);
    }
    AppMethodBeat.o(78859);
  }
  
  public final void eTG()
  {
    AppMethodBeat.i(78856);
    this.EkD.wR(true);
    AppMethodBeat.o(78856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.g
 * JD-Core Version:    0.7.0.1
 */