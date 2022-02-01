package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class e
  implements f<ca>
{
  private Cursor To;
  private int cSs;
  private String gAn;
  private int mCount;
  
  public e(String paramString, int paramInt1, int paramInt2)
  {
    this.gAn = paramString;
    this.mCount = paramInt1;
    this.cSs = paramInt2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(233507);
    long l = ((l)g.af(l.class)).aTq().aEk(this.gAn);
    Log.d("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgDataSource", "[ChattingSingleNotifyMsgDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.gAn, Integer.valueOf(this.mCount), Integer.valueOf(this.cSs), Long.valueOf(l) });
    bg.aVF();
    this.To = com.tencent.mm.model.c.getNotifyMessageRecordStorage().J(this.gAn, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(233507);
  }
  
  public final int cZm()
  {
    return this.cSs;
  }
  
  public final void close()
  {
    AppMethodBeat.i(233509);
    this.To.close();
    AppMethodBeat.o(233509);
  }
  
  public final void jA(List<ca> paramList)
  {
    AppMethodBeat.i(233508);
    try
    {
      this.To.moveToFirst();
      while (!this.To.isAfterLast())
      {
        ca localca = new ca();
        localca.convertFrom(this.To);
        paramList.add(localca);
        this.To.moveToNext();
      }
      AppMethodBeat.o(233508);
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(233508);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.e
 * JD-Core Version:    0.7.0.1
 */