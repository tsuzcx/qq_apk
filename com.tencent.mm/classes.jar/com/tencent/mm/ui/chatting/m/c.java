package com.tencent.mm.ui.chatting.m;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.g.d.b;
import java.util.List;

public final class c
  implements e<bo>
{
  private Cursor Rn;
  private int fAr;
  private String fzK;
  private int mCount;
  
  public c(String paramString, int paramInt1, int paramInt2)
  {
    this.fzK = paramString;
    this.mCount = paramInt1;
    this.fAr = paramInt2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36647);
    long l = ((k)g.ab(k.class)).axd().akY(this.fzK);
    ac.d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.fzK, Integer.valueOf(this.mCount), Integer.valueOf(this.fAr), Long.valueOf(l) });
    az.ayM();
    this.Rn = com.tencent.mm.model.c.awD().n(this.fzK, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(36647);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36649);
    this.Rn.close();
    AppMethodBeat.o(36649);
  }
  
  public final int eZx()
  {
    return this.fAr;
  }
  
  public final void ib(List<bo> paramList)
  {
    AppMethodBeat.i(36648);
    try
    {
      this.Rn.moveToFirst();
      while (!this.Rn.isAfterLast())
      {
        bo localbo = new bo();
        localbo.convertFrom(this.Rn);
        paramList.add(localbo);
        this.Rn.moveToNext();
      }
      AppMethodBeat.o(36648);
    }
    catch (Exception paramList)
    {
      ac.printErrStackTrace("MicroMsg.ChattingLoader.ChattingNormalDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36648);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.c
 * JD-Core Version:    0.7.0.1
 */