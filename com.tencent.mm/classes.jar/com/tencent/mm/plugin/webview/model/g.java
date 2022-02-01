package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.di;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.b;
import com.tencent.mm.sdk.platformtools.bf.c;
import com.tencent.mm.storagebase.h;

public final class g
  implements bf.c<Integer, Long>
{
  public static final String[] SQL_CREATE;
  private static final c.a jmW;
  public final bf<Integer, Long> Cpf;
  private long Cpg;
  public final h hpA;
  
  static
  {
    AppMethodBeat.i(78860);
    jmW = di.Th();
    SQL_CREATE = new String[] { j.getCreateSQLs(jmW, "JsLogBlockList") };
    AppMethodBeat.o(78860);
  }
  
  public g(h paramh)
  {
    AppMethodBeat.i(78855);
    this.hpA = paramh;
    this.Cpf = new bf(this, com.tencent.mm.kernel.g.agU().GrZ.getLooper(), 100, 20);
    AppMethodBeat.o(78855);
  }
  
  public final void a(bf.b<Integer, Long> paramb)
  {
    AppMethodBeat.i(78858);
    switch (paramb.GtP)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78858);
      return;
      this.hpA.delete("JsLogBlockList", "logId=" + paramb.aGF, null);
      AppMethodBeat.o(78858);
      return;
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("logId", (Integer)paramb.aGF);
      localContentValues.put("liftTime", (Long)paramb.values);
      this.hpA.replace("JsLogBlockList", "logId", localContentValues);
    }
  }
  
  public final boolean aIA()
  {
    AppMethodBeat.i(78857);
    if (this.hpA.inTransaction())
    {
      AppMethodBeat.o(78857);
      return false;
    }
    this.Cpg = this.hpA.vE(Thread.currentThread().getId());
    if (this.Cpg > 0L)
    {
      AppMethodBeat.o(78857);
      return true;
    }
    AppMethodBeat.o(78857);
    return false;
  }
  
  public final void aIB()
  {
    AppMethodBeat.i(78859);
    if (this.Cpg > 0L) {
      this.hpA.qL(this.Cpg);
    }
    AppMethodBeat.o(78859);
  }
  
  public final void eBc()
  {
    AppMethodBeat.i(78856);
    this.Cpf.vX(true);
    AppMethodBeat.o(78856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.g
 * JD-Core Version:    0.7.0.1
 */