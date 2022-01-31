package com.tencent.mm.pluginsdk.g.a.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class i
  implements c
{
  private final ak vOj;
  public final SparseArray<List<d>> vOk;
  public final Object vOl;
  
  i(ak paramak)
  {
    AppMethodBeat.i(79574);
    this.vOj = paramak;
    this.vOk = new SparseArray();
    this.vOl = new Object();
    AppMethodBeat.o(79574);
  }
  
  private List<d> alO(String arg1)
  {
    AppMethodBeat.i(79579);
    int i = ???.hashCode();
    synchronized (this.vOl)
    {
      List localList = (List)this.vOk.get(i);
      AppMethodBeat.o(79579);
      return localList;
    }
  }
  
  public final void D(String paramString, long paramLong)
  {
    AppMethodBeat.i(79577);
    paramString = q.a.dmz().alQ(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      q.a.dmz().h(paramString);
    }
    AppMethodBeat.o(79577);
  }
  
  public final void E(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79576);
    ab.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = q.a.dmz().alQ(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      q.a.dmz().h(paramString);
    }
    AppMethodBeat.o(79576);
  }
  
  public final void a(e parame, m paramm)
  {
    AppMethodBeat.i(79575);
    ab.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = ".concat(String.valueOf(paramm)));
    switch (paramm.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79575);
      return;
      Object localObject = q.a.dmz().alQ(paramm.vMK);
      if (localObject != null)
      {
        ((s)localObject).field_status = 4;
        q.a.dmz().h((s)localObject);
      }
      localObject = alO(parame.avS());
      if (!bo.es((List)localObject))
      {
        parame = parame.dlZ();
        this.vOj.post(new i.3(this, (List)localObject, paramm, parame));
      }
      AppMethodBeat.o(79575);
      return;
      localObject = q.a.dmz().alQ(paramm.vMK);
      if (localObject != null)
      {
        ((s)localObject).field_status = 2;
        q.a.dmz().h((s)localObject);
      }
      ab.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.avS());
      localObject = alO(parame.avS());
      if (bo.es((List)localObject))
      {
        ab.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        AppMethodBeat.o(79575);
        return;
      }
      ab.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.dlZ();
      this.vOj.post(new i.2(this, (List)localObject, paramm, parame));
      AppMethodBeat.o(79575);
      return;
      localObject = q.a.dmz().alQ(paramm.vMK);
      if (localObject != null)
      {
        ((s)localObject).field_status = 3;
        q.a.dmz().h((s)localObject);
      }
      localObject = alO(parame.avS());
      if (!bo.es((List)localObject))
      {
        parame = parame.dlZ();
        this.vOj.post(new i.1(this, (List)localObject, paramm, parame));
      }
    }
  }
  
  public final void a(String paramString, k paramk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.i
 * JD-Core Version:    0.7.0.1
 */