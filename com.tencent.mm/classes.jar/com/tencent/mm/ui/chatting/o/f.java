package com.tencent.mm.ui.chatting.o;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.List;

public final class f
  implements g<ca>
{
  private int cUX;
  private Cursor fB;
  private String jkq;
  private int mCount;
  
  public f(String paramString, int paramInt1, int paramInt2)
  {
    this.jkq = paramString;
    this.mCount = paramInt1;
    this.cUX = paramInt2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(289684);
    Log.d("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgDataSource", "[ChattingSingleNotifyMsgDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.jkq, Integer.valueOf(this.mCount), Integer.valueOf(this.cUX), Long.valueOf(0L) });
    bh.beI();
    this.fB = c.getNotifyMessageRecordStorage().hB(this.jkq, this.mCount);
    paramb.next();
    AppMethodBeat.o(289684);
  }
  
  public final void close()
  {
    AppMethodBeat.i(289688);
    this.fB.close();
    AppMethodBeat.o(289688);
  }
  
  public final int dpe()
  {
    return this.cUX;
  }
  
  public final void ks(List<ca> paramList)
  {
    AppMethodBeat.i(289687);
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
      AppMethodBeat.o(289687);
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(289687);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.f
 * JD-Core Version:    0.7.0.1
 */