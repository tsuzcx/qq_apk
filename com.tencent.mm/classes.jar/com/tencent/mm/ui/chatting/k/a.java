package com.tencent.mm.ui.chatting.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class a
  implements g<cc>
{
  private long aenl;
  private int eQx;
  private Cursor gw;
  private String lMU;
  private int mCount;
  
  public a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.lMU = paramString;
    this.aenl = paramLong;
    this.eQx = paramInt2;
    this.mCount = paramInt1;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(36624);
    long l = ((n)h.ax(n.class)).bAd().aLt(this.lMU);
    Log.i("MicroMsg.ChattingLoader.ChattingBizDataSource", "[ChattingBizDataSource] talker:%s bizChatId:%s,count:%s totalCount:%s createTime:%s", new Object[] { this.lMU, Long.valueOf(this.aenl), Integer.valueOf(this.mCount), Integer.valueOf(this.eQx), Long.valueOf(l) });
    bh.bCz();
    this.gw = com.tencent.mm.model.c.bzE().z(this.lMU, this.aenl, this.mCount);
    this.gw.moveToFirst();
    paramb.next();
    AppMethodBeat.o(36624);
  }
  
  public final void close()
  {
    AppMethodBeat.i(36626);
    this.gw.close();
    AppMethodBeat.o(36626);
  }
  
  public final int dWF()
  {
    return this.eQx;
  }
  
  public final void nI(List<cc> paramList)
  {
    AppMethodBeat.i(36625);
    this.gw.moveToFirst();
    while (!this.gw.isAfterLast())
    {
      cc localcc = new cc();
      localcc.convertFrom(this.gw);
      paramList.add(localcc);
      Log.i("MicroMsg.ChattingLoader.ChattingBizDataSource", "ChattingBizDataSource fillItem: %s %s %s %s", new Object[] { localcc.field_talker, localcc.jUr, Integer.valueOf(localcc.field_isSend), Integer.valueOf(localcc.getType()) });
      this.gw.moveToNext();
    }
    Collections.sort(paramList, new Comparator() {});
    AppMethodBeat.o(36625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a
 * JD-Core Version:    0.7.0.1
 */