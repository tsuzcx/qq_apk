package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class c
  implements e<bu>
{
  private Cursor Tc;
  private int fTH;
  private String fTa;
  private int mCount;
  
  public c(String paramString, int paramInt1, int paramInt2)
  {
    this.fTa = paramString;
    this.mCount = paramInt1;
    this.fTH = paramInt2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36647);
    long l = ((l)g.ab(l.class)).azS().apK(this.fTa);
    ad.d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.fTa, Integer.valueOf(this.mCount), Integer.valueOf(this.fTH), Long.valueOf(l) });
    ba.aBQ();
    this.Tc = com.tencent.mm.model.c.azs().J(this.fTa, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(36647);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36649);
    this.Tc.close();
    AppMethodBeat.o(36649);
  }
  
  public final int fpw()
  {
    return this.fTH;
  }
  
  public final void in(List<bu> paramList)
  {
    AppMethodBeat.i(36648);
    try
    {
      this.Tc.moveToFirst();
      while (!this.Tc.isAfterLast())
      {
        bu localbu = new bu();
        localbu.convertFrom(this.Tc);
        paramList.add(localbu);
        this.Tc.moveToNext();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.c
 * JD-Core Version:    0.7.0.1
 */