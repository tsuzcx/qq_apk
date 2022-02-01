package com.tencent.mm.ui.chatting.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.List;

public final class c
  implements g<cc>
{
  private int eQx;
  private Cursor gw;
  private String lMU;
  private int mCount;
  
  public c(String paramString, int paramInt1, int paramInt2)
  {
    this.lMU = paramString;
    this.mCount = paramInt1;
    this.eQx = paramInt2;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36647);
    long l = ((n)h.ax(n.class)).bAd().aLt(this.lMU);
    Log.d("MicroMsg.ChattingLoader.ChattingNormalDataSource", "[ChattingNormalDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.lMU, Integer.valueOf(this.mCount), Integer.valueOf(this.eQx), Long.valueOf(l) });
    bh.bCz();
    this.gw = com.tencent.mm.model.c.bzD().J(this.lMU, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(36647);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36649);
    this.gw.close();
    AppMethodBeat.o(36649);
  }
  
  public final int dWF()
  {
    return this.eQx;
  }
  
  public final void nI(List<cc> paramList)
  {
    AppMethodBeat.i(36648);
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
      AppMethodBeat.o(36648);
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingNormalDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36648);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.c
 * JD-Core Version:    0.7.0.1
 */