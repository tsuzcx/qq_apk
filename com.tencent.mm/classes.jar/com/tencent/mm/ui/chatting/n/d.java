package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class d
  implements e<bu>
{
  private long JWN;
  private long JWO;
  private Cursor Tc;
  private String fTa;
  
  public d(String paramString, long paramLong1, long paramLong2)
  {
    this.fTa = paramString;
    this.JWN = paramLong1;
    this.JWO = paramLong2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36650);
    long l = ((l)g.ab(l.class)).azS().apK(this.fTa);
    ba.aBQ();
    this.Tc = com.tencent.mm.model.c.azs().E(this.fTa, Math.max(l, this.JWN), this.JWO);
    paramb.next();
    AppMethodBeat.o(36650);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36653);
    this.Tc.close();
    AppMethodBeat.o(36653);
  }
  
  public final int fpw()
  {
    AppMethodBeat.i(36651);
    ba.aBQ();
    int i = com.tencent.mm.model.c.azs().aqm(this.fTa);
    AppMethodBeat.o(36651);
    return i;
  }
  
  public final void in(List<bu> paramList)
  {
    AppMethodBeat.i(36652);
    try
    {
      this.Tc.moveToFirst();
      while (!this.Tc.isAfterLast())
      {
        bu localbu = new bu();
        localbu.convertFrom(this.Tc);
        paramList.add(localbu);
        this.Tc.moveToNext();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.d
 * JD-Core Version:    0.7.0.1
 */