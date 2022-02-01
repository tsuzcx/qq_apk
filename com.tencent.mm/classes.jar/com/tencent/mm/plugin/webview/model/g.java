package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dg;
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
  private static final c.a iMP;
  public final bg<Integer, Long> AWS;
  private long AWT;
  public final h gPa;
  
  static
  {
    AppMethodBeat.i(78860);
    iMP = dg.So();
    SQL_CREATE = new String[] { j.getCreateSQLs(iMP, "JsLogBlockList") };
    AppMethodBeat.o(78860);
  }
  
  public g(h paramh)
  {
    AppMethodBeat.i(78855);
    this.gPa = paramh;
    this.AWS = new bg(this, com.tencent.mm.kernel.g.afE().EUN.getLooper(), 100, 20);
    AppMethodBeat.o(78855);
  }
  
  public final void a(bg.b<Integer, Long> paramb)
  {
    AppMethodBeat.i(78858);
    switch (paramb.EWD)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78858);
      return;
      this.gPa.delete("JsLogBlockList", "logId=" + paramb.aFP, null);
      AppMethodBeat.o(78858);
      return;
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("logId", (Integer)paramb.aFP);
      localContentValues.put("liftTime", (Long)paramb.values);
      this.gPa.replace("JsLogBlockList", "logId", localContentValues);
    }
  }
  
  public final boolean aBK()
  {
    AppMethodBeat.i(78857);
    if (this.gPa.inTransaction())
    {
      AppMethodBeat.o(78857);
      return false;
    }
    this.AWT = this.gPa.rb(Thread.currentThread().getId());
    if (this.AWT > 0L)
    {
      AppMethodBeat.o(78857);
      return true;
    }
    AppMethodBeat.o(78857);
    return false;
  }
  
  public final void aBL()
  {
    AppMethodBeat.i(78859);
    if (this.AWT > 0L) {
      this.gPa.mX(this.AWT);
    }
    AppMethodBeat.o(78859);
  }
  
  public final void elG()
  {
    AppMethodBeat.i(78856);
    this.AWS.uV(true);
    AppMethodBeat.o(78856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.g
 * JD-Core Version:    0.7.0.1
 */