package com.tencent.mm.ui.chatting.o;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class e
  implements g<ca>
{
  private d.a WZU;
  private a Xai;
  private int cUX;
  private Cursor fB;
  private String jkq;
  private int mCount;
  
  public e(String paramString, int paramInt1, int paramInt2, d.a parama, a parama1)
  {
    this.jkq = paramString;
    this.mCount = paramInt1;
    this.cUX = paramInt2;
    this.WZU = parama;
    this.Xai = parama1;
  }
  
  private void kt(List<ca> paramList)
  {
    AppMethodBeat.i(277363);
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
      AppMethodBeat.o(277363);
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(277363);
      return;
    }
  }
  
  private List<ca> ku(List<ca> paramList)
  {
    AppMethodBeat.i(277364);
    int i = 7;
    while ((i > 0) && (this.Xai.c((ca)paramList.get(i), (ca)paramList.get(i - 1)))) {
      i -= 1;
    }
    paramList = paramList.subList(i, paramList.size());
    AppMethodBeat.o(277364);
    return paramList;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(277360);
    long l = ((n)h.ae(n.class)).bco().aOu(this.jkq);
    Log.d("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "[ChattingServiceNotifyDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.jkq, Integer.valueOf(this.mCount), Integer.valueOf(this.cUX), Long.valueOf(l) });
    bh.beI();
    this.fB = com.tencent.mm.model.c.bbO().I(this.jkq, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(277360);
  }
  
  public final void close()
  {
    AppMethodBeat.i(277365);
    this.fB.close();
    AppMethodBeat.o(277365);
  }
  
  public final int dpe()
  {
    return this.cUX;
  }
  
  public final void ks(List<ca> paramList)
  {
    AppMethodBeat.i(277361);
    Object localObject = new ArrayList();
    kt((List)localObject);
    boolean bool;
    if ((this.WZU == d.a.WYu) || (this.WZU == d.a.WYs))
    {
      bool = false;
      if (!bool) {
        break label322;
      }
      Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "contain flex data, load more");
      ((List)localObject).clear();
      close();
      long l = ((n)h.ae(n.class)).bco().aOu(this.jkq);
      int i = Math.min(this.mCount + 8, this.cUX);
      Log.d("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "[ChattingServiceNotifyDataSource] talker:%s count:%d ,countForExtraMsg:%d, mTotalCount:%d createTime:%d", new Object[] { this.jkq, Integer.valueOf(this.mCount), Integer.valueOf(i), Integer.valueOf(this.cUX), Long.valueOf(l) });
      bh.beI();
      this.fB = com.tencent.mm.model.c.bbO().I(this.jkq, i, l);
      kt((List)localObject);
      localObject = ku((List)localObject);
    }
    label322:
    for (;;)
    {
      paramList.addAll((Collection)localObject);
      AppMethodBeat.o(277361);
      return;
      if ((this.mCount < 2) || (((List)localObject).size() < this.mCount))
      {
        Log.w("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "check if need load more data, but list is null or less than expect, except count: %d, actual count: %d", new Object[] { Integer.valueOf(this.mCount), Integer.valueOf(((List)localObject).size()) });
        bool = false;
        break;
      }
      bool = this.Xai.c((ca)((List)localObject).get(0), (ca)((List)localObject).get(1));
      Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "need load more data: %b", new Object[] { Boolean.valueOf(bool) });
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean c(ca paramca1, ca paramca2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.e
 * JD-Core Version:    0.7.0.1
 */