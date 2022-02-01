package com.tencent.mm.ui.chatting.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class e
  implements g<cc>
{
  private a aeJM;
  private d.a aeJy;
  private int eQx;
  private Cursor gw;
  private String lMU;
  private int mCount;
  
  public e(String paramString, int paramInt1, int paramInt2, d.a parama, a parama1)
  {
    this.lMU = paramString;
    this.mCount = paramInt1;
    this.eQx = paramInt2;
    this.aeJy = parama;
    this.aeJM = parama1;
  }
  
  private void nJ(List<cc> paramList)
  {
    AppMethodBeat.i(254077);
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
      AppMethodBeat.o(254077);
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(254077);
      return;
    }
  }
  
  private List<cc> nK(List<cc> paramList)
  {
    AppMethodBeat.i(254079);
    int i = 7;
    while ((i > 0) && (this.aeJM.c((cc)paramList.get(i), (cc)paramList.get(i - 1)))) {
      i -= 1;
    }
    paramList = paramList.subList(i, paramList.size());
    AppMethodBeat.o(254079);
    return paramList;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(254085);
    long l = ((n)h.ax(n.class)).bAd().aLt(this.lMU);
    Log.d("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "[ChattingServiceNotifyDataSource] talker:%s count:%d mTotalCount:%d createTime:%d", new Object[] { this.lMU, Integer.valueOf(this.mCount), Integer.valueOf(this.eQx), Long.valueOf(l) });
    bh.bCz();
    this.gw = com.tencent.mm.model.c.bzD().J(this.lMU, this.mCount, l);
    paramb.next();
    AppMethodBeat.o(254085);
  }
  
  public final void close()
  {
    AppMethodBeat.i(254099);
    this.gw.close();
    AppMethodBeat.o(254099);
  }
  
  public final int dWF()
  {
    return this.eQx;
  }
  
  public final void nI(List<cc> paramList)
  {
    AppMethodBeat.i(254094);
    Object localObject = new ArrayList();
    nJ((List)localObject);
    boolean bool;
    if ((this.aeJy == d.a.aeHU) || (this.aeJy == d.a.aeHS))
    {
      bool = false;
      if (!bool) {
        break label322;
      }
      Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "contain flex data, load more");
      ((List)localObject).clear();
      close();
      long l = ((n)h.ax(n.class)).bAd().aLt(this.lMU);
      int i = Math.min(this.mCount + 8, this.eQx);
      Log.d("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "[ChattingServiceNotifyDataSource] talker:%s count:%d ,countForExtraMsg:%d, mTotalCount:%d createTime:%d", new Object[] { this.lMU, Integer.valueOf(this.mCount), Integer.valueOf(i), Integer.valueOf(this.eQx), Long.valueOf(l) });
      bh.bCz();
      this.gw = com.tencent.mm.model.c.bzD().J(this.lMU, i, l);
      nJ((List)localObject);
      localObject = nK((List)localObject);
    }
    label322:
    for (;;)
    {
      paramList.addAll((Collection)localObject);
      AppMethodBeat.o(254094);
      return;
      if ((this.mCount < 2) || (((List)localObject).size() < this.mCount))
      {
        Log.w("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "check if need load more data, but list is null or less than expect, except count: %d, actual count: %d", new Object[] { Integer.valueOf(this.mCount), Integer.valueOf(((List)localObject).size()) });
        bool = false;
        break;
      }
      bool = this.aeJM.c((cc)((List)localObject).get(0), (cc)((List)localObject).get(1));
      Log.i("MicroMsg.ChattingLoader.ChattingServiceNotifyDataSource", "need load more data: %b", new Object[] { Boolean.valueOf(bool) });
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean c(cc paramcc1, cc paramcc2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.e
 * JD-Core Version:    0.7.0.1
 */