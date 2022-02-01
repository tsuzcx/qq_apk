package com.tencent.mm.ui.chatting.m;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.g.d.b;
import java.util.List;

public final class c
  implements e<bl>
{
  private Cursor Qs;
  private int fwK;
  private String fwd;
  private int mCount;
  
  public c(String paramString, int paramInt1, int paramInt2)
  {
    this.fwd = paramString;
    this.mCount = paramInt1;
    this.fwK = paramInt2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36647);
    long l = ((k)g.ab(k.class)).aqo().age(this.fwd);
    ad.d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.fwd, Integer.valueOf(this.mCount), Integer.valueOf(this.fwK), Long.valueOf(l) });
    az.arV();
    this.Qs = com.tencent.mm.model.c.apO().n(this.fwd, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(36647);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36649);
    this.Qs.close();
    AppMethodBeat.o(36649);
  }
  
  public final int eKa()
  {
    return this.fwK;
  }
  
  public final void hO(List<bl> paramList)
  {
    AppMethodBeat.i(36648);
    try
    {
      this.Qs.moveToFirst();
      while (!this.Qs.isAfterLast())
      {
        bl localbl = new bl();
        localbl.convertFrom(this.Qs);
        paramList.add(localbl);
        this.Qs.moveToNext();
      }
      AppMethodBeat.o(36648);
    }
    catch (Exception paramList)
    {
      ad.printErrStackTrace("MicroMsg.ChattingLoader.ChattingNormalDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36648);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.c
 * JD-Core Version:    0.7.0.1
 */