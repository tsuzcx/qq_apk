package com.tencent.mm.ui.chatting.o;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class a
  implements g<ca>
{
  private long WFI;
  private int cUX;
  private Cursor fB;
  private String jkq;
  private int mCount;
  
  public a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.jkq = paramString;
    this.WFI = paramLong;
    this.cUX = paramInt2;
    this.mCount = paramInt1;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36624);
    long l = ((n)h.ae(n.class)).bco().aOu(this.jkq);
    Log.i("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", new Object[] { this.jkq, Long.valueOf(this.WFI), Integer.valueOf(this.mCount), Integer.valueOf(this.cUX), Long.valueOf(l) });
    bh.beI();
    this.fB = com.tencent.mm.model.c.bbP().u(this.jkq, this.WFI, this.mCount);
    paramb.next();
    AppMethodBeat.o(36624);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36626);
    this.fB.close();
    AppMethodBeat.o(36626);
  }
  
  public final int dpe()
  {
    return this.cUX;
  }
  
  public final void ks(List<ca> paramList)
  {
    AppMethodBeat.i(36625);
    this.fB.moveToFirst();
    while (!this.fB.isAfterLast())
    {
      ca localca = new ca();
      localca.convertFrom(this.fB);
      paramList.add(localca);
      Log.i("MicroMsg.ChattingLoader.ChattingBizDataSource", "ChattingBizDataSource fillItem: %s %s %s %s", new Object[] { localca.field_talker, localca.hxy, Integer.valueOf(localca.field_isSend), Integer.valueOf(localca.getType()) });
      this.fB.moveToNext();
    }
    Collections.sort(paramList, new Comparator() {});
    AppMethodBeat.o(36625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.a
 * JD-Core Version:    0.7.0.1
 */