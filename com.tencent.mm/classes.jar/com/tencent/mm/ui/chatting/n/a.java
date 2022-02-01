package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class a
  implements f<ca>
{
  private long PlX;
  private Cursor To;
  private int cSs;
  private String gAn;
  private int mCount;
  
  public a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.gAn = paramString;
    this.PlX = paramLong;
    this.cSs = paramInt2;
    this.mCount = paramInt1;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36624);
    long l = ((l)g.af(l.class)).aTq().aEk(this.gAn);
    Log.i("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", new Object[] { this.gAn, Long.valueOf(this.PlX), Integer.valueOf(this.mCount), Integer.valueOf(this.cSs), Long.valueOf(l) });
    bg.aVF();
    this.To = com.tencent.mm.model.c.aSR().t(this.gAn, this.PlX, this.mCount);
    paramb.next();
    AppMethodBeat.o(36624);
  }
  
  public final int cZm()
  {
    return this.cSs;
  }
  
  public final void close()
  {
    AppMethodBeat.i(36626);
    this.To.close();
    AppMethodBeat.o(36626);
  }
  
  public final void jA(List<ca> paramList)
  {
    AppMethodBeat.i(36625);
    this.To.moveToFirst();
    while (!this.To.isAfterLast())
    {
      ca localca = new ca();
      localca.convertFrom(this.To);
      paramList.add(localca);
      Log.i("MicroMsg.ChattingLoader.ChattingBizDataSource", "ChattingBizDataSource fillItem: %s %s %s %s", new Object[] { localca.field_talker, localca.fqK, Integer.valueOf(localca.field_isSend), Integer.valueOf(localca.getType()) });
      this.To.moveToNext();
    }
    AppMethodBeat.o(36625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a
 * JD-Core Version:    0.7.0.1
 */