package com.tencent.mm.ui.chatting.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

public final class f
  implements g<cc>
{
  private long aeJK;
  private long aeJL;
  private boolean aeJN;
  private int eQx;
  private Cursor gw;
  private String lMU;
  private int mCount;
  
  public f(String paramString, int paramInt1, int paramInt2)
  {
    this.lMU = paramString;
    this.mCount = paramInt1;
    this.eQx = paramInt2;
  }
  
  public f(String paramString, long paramLong1, long paramLong2)
  {
    this.lMU = paramString;
    this.aeJK = paramLong1;
    this.aeJL = paramLong2;
    this.aeJN = true;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(254083);
    if (!this.aeJN)
    {
      Log.d("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgDataSource", "[ChattingSingleNotifyMsgDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.lMU, Integer.valueOf(this.mCount), Integer.valueOf(this.eQx), Long.valueOf(0L) });
      bh.bCz();
    }
    for (this.gw = c.getNotifyMessageRecordStorage().aH(this.lMU, this.mCount);; this.gw = c.getNotifyMessageRecordStorage().j(this.lMU, this.aeJK, this.aeJL))
    {
      paramb.next();
      AppMethodBeat.o(254083);
      return;
      Log.d("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgDataSource", "[ChattingSingleNotifyMsgDataSource for search] talker:%s mLastTopMsgCreateTime:%d mLastBottomMsgCreateTime:%d", new Object[] { this.lMU, Long.valueOf(this.aeJK), Long.valueOf(this.aeJL) });
      bh.bCz();
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(254098);
    this.gw.close();
    AppMethodBeat.o(254098);
  }
  
  public final int dWF()
  {
    return this.eQx;
  }
  
  public final void nI(List<cc> paramList)
  {
    AppMethodBeat.i(254092);
    try
    {
      this.gw.moveToFirst();
      while (!this.gw.isAfterLast())
      {
        cc localcc = new cc();
        localcc.convertFrom(this.gw);
        paramList.add(localcc);
        this.gw.moveToNext();
      }
      AppMethodBeat.o(254092);
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingSingleNotifyMsgDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(254092);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.f
 * JD-Core Version:    0.7.0.1
 */