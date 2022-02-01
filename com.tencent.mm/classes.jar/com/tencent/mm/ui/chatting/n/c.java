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

public final class c
  implements e<bv>
{
  private Cursor Tc;
  private int fVN;
  private String fVg;
  private int mCount;
  
  public c(String paramString, int paramInt1, int paramInt2)
  {
    this.fVg = paramString;
    this.mCount = paramInt1;
    this.fVN = paramInt2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36647);
    long l = ((l)g.ab(l.class)).aAi().aqP(this.fVg);
    ae.d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.fVg, Integer.valueOf(this.mCount), Integer.valueOf(this.fVN), Long.valueOf(l) });
    bc.aCg();
    this.Tc = com.tencent.mm.model.c.azI().I(this.fVg, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(36647);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36649);
    this.Tc.close();
    AppMethodBeat.o(36649);
  }
  
  public final int ftv()
  {
    return this.fVN;
  }
  
  public final void ix(List<bv> paramList)
  {
    AppMethodBeat.i(36648);
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
      AppMethodBeat.o(36648);
    }
    catch (Exception paramList)
    {
      ae.printErrStackTrace("MicroMsg.ChattingLoader.ChattingNormalDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36648);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.c
 * JD-Core Version:    0.7.0.1
 */