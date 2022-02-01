package com.tencent.mm.ui.chatting.m;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.g.d.b;
import java.util.List;

public final class d
  implements e<bl>
{
  private long GGE;
  private long GGF;
  private Cursor Qs;
  private String fwd;
  
  public d(String paramString, long paramLong1, long paramLong2)
  {
    this.fwd = paramString;
    this.GGE = paramLong1;
    this.GGF = paramLong2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36650);
    long l = ((k)g.ab(k.class)).aqo().age(this.fwd);
    az.arV();
    this.Qs = com.tencent.mm.model.c.apO().F(this.fwd, Math.max(l, this.GGE), this.GGF);
    paramb.next();
    AppMethodBeat.o(36650);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36653);
    this.Qs.close();
    AppMethodBeat.o(36653);
  }
  
  public final int eKa()
  {
    AppMethodBeat.i(36651);
    az.arV();
    int i = com.tencent.mm.model.c.apO().agE(this.fwd);
    AppMethodBeat.o(36651);
    return i;
  }
  
  public final void hO(List<bl> paramList)
  {
    AppMethodBeat.i(36652);
    try
    {
      this.Qs.moveToFirst();
      while (!this.Qs.isAfterLast())
      {
        bl localbl = new bl();
        localbl.convertFrom(this.Qs);
        paramList.add(localbl);
        this.Qs.moveToNext();
      }
      AppMethodBeat.o(36652);
    }
    catch (Exception paramList)
    {
      ad.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSearchDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36652);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.d
 * JD-Core Version:    0.7.0.1
 */