package com.tencent.mm.ui.chatting.o;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class c
  implements g<ca>
{
  private int cUX;
  private Cursor fB;
  private String jkq;
  private int mCount;
  
  public c(String paramString, int paramInt1, int paramInt2)
  {
    this.jkq = paramString;
    this.mCount = paramInt1;
    this.cUX = paramInt2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36647);
    long l = ((n)h.ae(n.class)).bco().aOu(this.jkq);
    Log.d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.jkq, Integer.valueOf(this.mCount), Integer.valueOf(this.cUX), Long.valueOf(l) });
    bh.beI();
    this.fB = com.tencent.mm.model.c.bbO().I(this.jkq, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(36647);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36649);
    this.fB.close();
    AppMethodBeat.o(36649);
  }
  
  public final int dpe()
  {
    return this.cUX;
  }
  
  public final void ks(List<ca> paramList)
  {
    AppMethodBeat.i(36648);
    try
    {
      this.fB.moveToFirst();
      while (!this.fB.isAfterLast())
      {
        ca localca = new ca();
        localca.convertFrom(this.fB);
        paramList.add(localca);
        this.fB.moveToNext();
      }
      AppMethodBeat.o(36648);
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingNormalDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36648);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.c
 * JD-Core Version:    0.7.0.1
 */