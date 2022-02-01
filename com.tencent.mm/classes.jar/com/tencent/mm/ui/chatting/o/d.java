package com.tencent.mm.ui.chatting.o;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class d
  implements g<ca>
{
  private long Xag;
  private long Xah;
  private Cursor fB;
  private String jkq;
  
  public d(String paramString, long paramLong1, long paramLong2)
  {
    this.jkq = paramString;
    this.Xag = paramLong1;
    this.Xah = paramLong2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36650);
    long l = ((n)h.ae(n.class)).bco().aOu(this.jkq);
    bh.beI();
    this.fB = com.tencent.mm.model.c.bbO().E(this.jkq, Math.max(l, this.Xag), this.Xah);
    paramb.next();
    AppMethodBeat.o(36650);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36653);
    this.fB.close();
    AppMethodBeat.o(36653);
  }
  
  public final int dpe()
  {
    AppMethodBeat.i(36651);
    bh.beI();
    int i = com.tencent.mm.model.c.bbO().aOW(this.jkq);
    AppMethodBeat.o(36651);
    return i;
  }
  
  public final void ks(List<ca> paramList)
  {
    AppMethodBeat.i(36652);
    try
    {
      this.fB.moveToFirst();
      while (!this.fB.isAfterLast())
      {
        ca localca = new ca();
        localca.convertFrom(this.fB);
        paramList.add(localca);
        this.fB.moveToNext();
      }
      AppMethodBeat.o(36652);
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSearchDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36652);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.d
 * JD-Core Version:    0.7.0.1
 */