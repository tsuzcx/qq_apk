package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class a
  implements e<bv>
{
  private long KaB;
  private Cursor Tc;
  private int fVN;
  private String fVg;
  private int mCount;
  
  public a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.fVg = paramString;
    this.KaB = paramLong;
    this.fVN = paramInt2;
    this.mCount = paramInt1;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36624);
    long l = ((l)g.ab(l.class)).aAi().aqP(this.fVg);
    ae.d("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", new Object[] { this.fVg, Long.valueOf(this.KaB), Integer.valueOf(this.mCount), Integer.valueOf(this.fVN), Long.valueOf(l) });
    bc.aCg();
    this.Tc = com.tencent.mm.model.c.azJ().r(this.fVg, this.KaB, this.mCount);
    paramb.next();
    AppMethodBeat.o(36624);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36626);
    this.Tc.close();
    AppMethodBeat.o(36626);
  }
  
  public final int ftv()
  {
    return this.fVN;
  }
  
  public final void ix(List<bv> paramList)
  {
    AppMethodBeat.i(36625);
    this.Tc.moveToFirst();
    while (!this.Tc.isAfterLast())
    {
      bv localbv = new bv();
      localbv.convertFrom(this.Tc);
      paramList.add(localbv);
      this.Tc.moveToNext();
    }
    AppMethodBeat.o(36625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a
 * JD-Core Version:    0.7.0.1
 */