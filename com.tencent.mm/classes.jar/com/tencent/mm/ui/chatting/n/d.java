package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class d
  implements e<bv>
{
  private long Kte;
  private long Ktf;
  private Cursor Tc;
  private String fVg;
  
  public d(String paramString, long paramLong1, long paramLong2)
  {
    this.fVg = paramString;
    this.Kte = paramLong1;
    this.Ktf = paramLong2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36650);
    long l = ((l)g.ab(l.class)).aAi().aqP(this.fVg);
    bc.aCg();
    this.Tc = com.tencent.mm.model.c.azI().E(this.fVg, Math.max(l, this.Kte), this.Ktf);
    paramb.next();
    AppMethodBeat.o(36650);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36653);
    this.Tc.close();
    AppMethodBeat.o(36653);
  }
  
  public final int ftv()
  {
    AppMethodBeat.i(36651);
    bc.aCg();
    int i = com.tencent.mm.model.c.azI().arr(this.fVg);
    AppMethodBeat.o(36651);
    return i;
  }
  
  public final void ix(List<bv> paramList)
  {
    AppMethodBeat.i(36652);
    try
    {
      this.Tc.moveToFirst();
      while (!this.Tc.isAfterLast())
      {
        bv localbv = new bv();
        localbv.convertFrom(this.Tc);
        paramList.add(localbv);
        this.Tc.moveToNext();
      }
      AppMethodBeat.o(36652);
    }
    catch (Exception paramList)
    {
      ae.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSearchDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36652);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.d
 * JD-Core Version:    0.7.0.1
 */