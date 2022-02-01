package com.tencent.mm.ui.chatting.m;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.p;
import com.tencent.mm.ui.chatting.g.d.b;
import java.util.List;

public final class a
  implements e<bo>
{
  private long HRS;
  private Cursor Rn;
  private int fAr;
  private String fzK;
  private int mCount;
  
  public a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.fzK = paramString;
    this.HRS = paramLong;
    this.fAr = paramInt2;
    this.mCount = paramInt1;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36624);
    long l = ((k)g.ab(k.class)).axd().akY(this.fzK);
    ac.d("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", new Object[] { this.fzK, Long.valueOf(this.HRS), Integer.valueOf(this.mCount), Integer.valueOf(this.fAr), Long.valueOf(l) });
    az.ayM();
    this.Rn = com.tencent.mm.model.c.awE().p(this.fzK, this.HRS, this.mCount);
    paramb.next();
    AppMethodBeat.o(36624);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36626);
    this.Rn.close();
    AppMethodBeat.o(36626);
  }
  
  public final int eZx()
  {
    return this.fAr;
  }
  
  public final void ib(List<bo> paramList)
  {
    AppMethodBeat.i(36625);
    this.Rn.moveToFirst();
    while (!this.Rn.isAfterLast())
    {
      bo localbo = new bo();
      localbo.convertFrom(this.Rn);
      paramList.add(localbo);
      this.Rn.moveToNext();
    }
    AppMethodBeat.o(36625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a
 * JD-Core Version:    0.7.0.1
 */