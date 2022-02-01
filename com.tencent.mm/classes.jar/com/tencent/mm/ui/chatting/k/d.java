package com.tencent.mm.ui.chatting.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

public final class d
  implements g<cc>
{
  private long aeJK;
  private long aeJL;
  private Cursor gw;
  private String lMU;
  
  public d(String paramString, long paramLong1, long paramLong2)
  {
    this.lMU = paramString;
    this.aeJK = paramLong1;
    this.aeJL = paramLong2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36650);
    long l = ((n)h.ax(n.class)).bAd().aLt(this.lMU);
    bh.bCz();
    this.gw = com.tencent.mm.model.c.bzD().J(this.lMU, Math.max(l, this.aeJK), this.aeJL);
    this.gw.moveToFirst();
    paramb.next();
    AppMethodBeat.o(36650);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36653);
    this.gw.close();
    AppMethodBeat.o(36653);
  }
  
  public final int dWF()
  {
    AppMethodBeat.i(36651);
    bh.bCz();
    int i = com.tencent.mm.model.c.bzD().aLW(this.lMU);
    AppMethodBeat.o(36651);
    return i;
  }
  
  public final void nI(List<cc> paramList)
  {
    AppMethodBeat.i(36652);
    try
    {
      this.gw.moveToFirst();
      while (!this.gw.isAfterLast())
      {
        cc localcc = new cc();
        localcc.convertFrom(this.gw);
        paramList.add(localcc);
        this.gw.moveToNext();
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
 * Qualified Name:     com.tencent.mm.ui.chatting.k.d
 * JD-Core Version:    0.7.0.1
 */