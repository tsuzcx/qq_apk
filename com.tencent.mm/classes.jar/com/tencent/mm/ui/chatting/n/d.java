package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class d
  implements f<ca>
{
  private long PFt;
  private long PFu;
  private Cursor To;
  private String gAn;
  
  public d(String paramString, long paramLong1, long paramLong2)
  {
    this.gAn = paramString;
    this.PFt = paramLong1;
    this.PFu = paramLong2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36650);
    long l = ((l)g.af(l.class)).aTq().aEk(this.gAn);
    bg.aVF();
    this.To = com.tencent.mm.model.c.aSQ().F(this.gAn, Math.max(l, this.PFt), this.PFu);
    paramb.next();
    AppMethodBeat.o(36650);
  }
  
  public final int cZm()
  {
    AppMethodBeat.i(36651);
    bg.aVF();
    int i = com.tencent.mm.model.c.aSQ().aEM(this.gAn);
    AppMethodBeat.o(36651);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(36653);
    this.To.close();
    AppMethodBeat.o(36653);
  }
  
  public final void jA(List<ca> paramList)
  {
    AppMethodBeat.i(36652);
    try
    {
      this.To.moveToFirst();
      while (!this.To.isAfterLast())
      {
        ca localca = new ca();
        localca.convertFrom(this.To);
        paramList.add(localca);
        this.To.moveToNext();
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
 * Qualified Name:     com.tencent.mm.ui.chatting.n.d
 * JD-Core Version:    0.7.0.1
 */