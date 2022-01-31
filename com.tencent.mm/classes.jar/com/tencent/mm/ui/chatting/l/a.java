package com.tencent.mm.ui.chatting.l;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.o;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

public final class a
  implements e<bi>
{
  private Cursor Js;
  private int ejZ;
  private String ejr;
  private int mCount;
  private long zDF;
  
  public a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.ejr = paramString;
    this.zDF = paramLong;
    this.ejZ = paramInt2;
    this.mCount = paramInt1;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(32684);
    long l = ((j)g.E(j.class)).Zc().Tb(this.ejr);
    ab.d("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", new Object[] { this.ejr, Long.valueOf(this.zDF), Integer.valueOf(this.mCount), Integer.valueOf(this.ejZ), Long.valueOf(l) });
    aw.aaz();
    this.Js = com.tencent.mm.model.c.YD().p(this.ejr, this.zDF, this.mCount);
    paramb.next();
    AppMethodBeat.o(32684);
  }
  
  public final void close()
  {
    AppMethodBeat.i(32686);
    this.Js.close();
    AppMethodBeat.o(32686);
  }
  
  public final int dwi()
  {
    return this.ejZ;
  }
  
  public final void fs(List<bi> paramList)
  {
    AppMethodBeat.i(32685);
    this.Js.moveToFirst();
    while (!this.Js.isAfterLast())
    {
      bi localbi = new bi();
      localbi.convertFrom(this.Js);
      paramList.add(localbi);
      this.Js.moveToNext();
    }
    AppMethodBeat.o(32685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a
 * JD-Core Version:    0.7.0.1
 */