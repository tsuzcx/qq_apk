package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.c.cr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bb.b;
import com.tencent.mm.sdk.platformtools.bb.c;

public final class e
  implements bb.c<Integer, Long>
{
  public static final String[] SQL_CREATE;
  private static final c.a gUb;
  public final h fnw;
  public final bb<Integer, Long> uVm;
  private long uVn;
  
  static
  {
    AppMethodBeat.i(6578);
    gUb = cr.Hm();
    SQL_CREATE = new String[] { j.getCreateSQLs(gUb, "JsLogBlockList") };
    AppMethodBeat.o(6578);
  }
  
  public e(h paramh)
  {
    AppMethodBeat.i(6573);
    this.fnw = paramh;
    this.uVm = new bb(this, g.RO().oNc.getLooper(), 100, 20);
    AppMethodBeat.o(6573);
  }
  
  public final void a(bb.b<Integer, Long> paramb)
  {
    AppMethodBeat.i(6576);
    switch (paramb.ypQ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6576);
      return;
      this.fnw.delete("JsLogBlockList", "logId=" + paramb.ypR, null);
      AppMethodBeat.o(6576);
      return;
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("logId", (Integer)paramb.ypR);
      localContentValues.put("liftTime", (Long)paramb.values);
      this.fnw.replace("JsLogBlockList", "logId", localContentValues);
    }
  }
  
  public final boolean akF()
  {
    AppMethodBeat.i(6575);
    if (this.fnw.inTransaction())
    {
      AppMethodBeat.o(6575);
      return false;
    }
    this.uVn = this.fnw.kr(Thread.currentThread().getId());
    if (this.uVn > 0L)
    {
      AppMethodBeat.o(6575);
      return true;
    }
    AppMethodBeat.o(6575);
    return false;
  }
  
  public final void akG()
  {
    AppMethodBeat.i(6577);
    if (this.uVn > 0L) {
      this.fnw.nY(this.uVn);
    }
    AppMethodBeat.o(6577);
  }
  
  public final void dbI()
  {
    AppMethodBeat.i(6574);
    this.uVm.pM(true);
    AppMethodBeat.o(6574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.e
 * JD-Core Version:    0.7.0.1
 */