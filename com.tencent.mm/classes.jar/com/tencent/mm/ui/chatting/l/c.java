package com.tencent.mm.ui.chatting.l;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

public final class c
  implements e<bi>
{
  private Cursor Js;
  private int ejZ;
  private String ejr;
  private int mCount;
  
  public c(String paramString, int paramInt1, int paramInt2)
  {
    this.ejr = paramString;
    this.mCount = paramInt1;
    this.ejZ = paramInt2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(32706);
    long l = ((j)g.E(j.class)).Zc().Tb(this.ejr);
    ab.d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.ejr, Integer.valueOf(this.mCount), Integer.valueOf(this.ejZ), Long.valueOf(l) });
    aw.aaz();
    this.Js = com.tencent.mm.model.c.YC().k(this.ejr, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(32706);
  }
  
  public final void close()
  {
    AppMethodBeat.i(32708);
    this.Js.close();
    AppMethodBeat.o(32708);
  }
  
  public final int dwi()
  {
    return this.ejZ;
  }
  
  public final void fs(List<bi> paramList)
  {
    AppMethodBeat.i(32707);
    try
    {
      this.Js.moveToFirst();
      while (!this.Js.isAfterLast())
      {
        bi localbi = new bi();
        localbi.convertFrom(this.Js);
        paramList.add(localbi);
        this.Js.moveToNext();
      }
      AppMethodBeat.o(32707);
    }
    catch (Exception paramList)
    {
      ab.printErrStackTrace("MicroMsg.ChattingLoader.ChattingNormalDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(32707);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.c
 * JD-Core Version:    0.7.0.1
 */