package com.tencent.mm.ui.chatting.m;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.p;
import com.tencent.mm.ui.chatting.g.d.b;
import java.util.List;

public final class a
  implements e<bl>
{
  private long Gsa;
  private Cursor Qs;
  private int fwK;
  private String fwd;
  private int mCount;
  
  public a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.fwd = paramString;
    this.Gsa = paramLong;
    this.fwK = paramInt2;
    this.mCount = paramInt1;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36624);
    long l = ((k)g.ab(k.class)).aqo().age(this.fwd);
    ad.d("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", new Object[] { this.fwd, Long.valueOf(this.Gsa), Integer.valueOf(this.mCount), Integer.valueOf(this.fwK), Long.valueOf(l) });
    az.arV();
    this.Qs = com.tencent.mm.model.c.apP().p(this.fwd, this.Gsa, this.mCount);
    paramb.next();
    AppMethodBeat.o(36624);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36626);
    this.Qs.close();
    AppMethodBeat.o(36626);
  }
  
  public final int eKa()
  {
    return this.fwK;
  }
  
  public final void hO(List<bl> paramList)
  {
    AppMethodBeat.i(36625);
    this.Qs.moveToFirst();
    while (!this.Qs.isAfterLast())
    {
      bl localbl = new bl();
      localbl.convertFrom(this.Qs);
      paramList.add(localbl);
      this.Qs.moveToNext();
    }
    AppMethodBeat.o(36625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a
 * JD-Core Version:    0.7.0.1
 */