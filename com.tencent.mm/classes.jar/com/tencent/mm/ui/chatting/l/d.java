package com.tencent.mm.ui.chatting.l;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

public final class d
  implements e<bi>
{
  private Cursor Js;
  private String ejr;
  private long zQg;
  private long zQh;
  
  public d(String paramString, long paramLong1, long paramLong2)
  {
    this.ejr = paramString;
    this.zQg = paramLong1;
    this.zQh = paramLong2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(32709);
    aw.aaz();
    this.Js = c.YC().A(this.ejr, this.zQg, this.zQh);
    paramb.next();
    AppMethodBeat.o(32709);
  }
  
  public final void close()
  {
    AppMethodBeat.i(32712);
    this.Js.close();
    AppMethodBeat.o(32712);
  }
  
  public final int dwi()
  {
    AppMethodBeat.i(32710);
    aw.aaz();
    int i = c.YC().TA(this.ejr);
    AppMethodBeat.o(32710);
    return i;
  }
  
  public final void fs(List<bi> paramList)
  {
    AppMethodBeat.i(32711);
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
      AppMethodBeat.o(32711);
    }
    catch (Exception paramList)
    {
      ab.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSearchDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(32711);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.d
 * JD-Core Version:    0.7.0.1
 */