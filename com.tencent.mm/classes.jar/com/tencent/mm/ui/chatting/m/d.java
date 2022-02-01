package com.tencent.mm.ui.chatting.m;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.g.d.b;
import java.util.List;

public final class d
  implements e<bo>
{
  private long IgA;
  private long IgB;
  private Cursor Rn;
  private String fzK;
  
  public d(String paramString, long paramLong1, long paramLong2)
  {
    this.fzK = paramString;
    this.IgA = paramLong1;
    this.IgB = paramLong2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36650);
    long l = ((k)g.ab(k.class)).axd().akY(this.fzK);
    az.ayM();
    this.Rn = com.tencent.mm.model.c.awD().D(this.fzK, Math.max(l, this.IgA), this.IgB);
    paramb.next();
    AppMethodBeat.o(36650);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36653);
    this.Rn.close();
    AppMethodBeat.o(36653);
  }
  
  public final int eZx()
  {
    AppMethodBeat.i(36651);
    az.ayM();
    int i = com.tencent.mm.model.c.awD().aly(this.fzK);
    AppMethodBeat.o(36651);
    return i;
  }
  
  public final void ib(List<bo> paramList)
  {
    AppMethodBeat.i(36652);
    try
    {
      this.Rn.moveToFirst();
      while (!this.Rn.isAfterLast())
      {
        bo localbo = new bo();
        localbo.convertFrom(this.Rn);
        paramList.add(localbo);
        this.Rn.moveToNext();
      }
      AppMethodBeat.o(36652);
    }
    catch (Exception paramList)
    {
      ac.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSearchDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36652);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.d
 * JD-Core Version:    0.7.0.1
 */