package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class a
  implements e<bu>
{
  private long JFK;
  private Cursor Tc;
  private int fTH;
  private String fTa;
  private int mCount;
  
  public a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.fTa = paramString;
    this.JFK = paramLong;
    this.fTH = paramInt2;
    this.mCount = paramInt1;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36624);
    long l = ((l)g.ab(l.class)).azS().apK(this.fTa);
    ad.d("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", new Object[] { this.fTa, Long.valueOf(this.JFK), Integer.valueOf(this.mCount), Integer.valueOf(this.fTH), Long.valueOf(l) });
    ba.aBQ();
    this.Tc = com.tencent.mm.model.c.azt().r(this.fTa, this.JFK, this.mCount);
    paramb.next();
    AppMethodBeat.o(36624);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36626);
    this.Tc.close();
    AppMethodBeat.o(36626);
  }
  
  public final int fpw()
  {
    return this.fTH;
  }
  
  public final void in(List<bu> paramList)
  {
    AppMethodBeat.i(36625);
    this.Tc.moveToFirst();
    while (!this.Tc.isAfterLast())
    {
      bu localbu = new bu();
      localbu.convertFrom(this.Tc);
      paramList.add(localbu);
      this.Tc.moveToNext();
    }
    AppMethodBeat.o(36625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a
 * JD-Core Version:    0.7.0.1
 */