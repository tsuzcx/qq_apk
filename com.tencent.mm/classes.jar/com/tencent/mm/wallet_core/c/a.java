package com.tencent.mm.wallet_core.c;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends dpc, P extends c<K>>
{
  protected MutableLiveData<K> Rtg = new MutableLiveData();
  protected MutableLiveData<K> Rth = new MutableLiveData();
  protected List<a<K>> callbacks = new ArrayList();
  protected P iLD;
  protected boolean zjy = false;
  
  private void a(a<K> parama, boolean paramBoolean)
  {
    dpc localdpc = efb();
    if (localdpc != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (parama != null) {
          parama.dx(localdpc);
        }
        this.Rtg.postValue(localdpc);
      }
      if ((i == 0) || (paramBoolean))
      {
        if ((parama != null) && (!this.callbacks.contains(parama))) {
          this.callbacks.add(parama);
        }
        hhi();
      }
      return;
    }
  }
  
  private void hhi()
  {
    Log.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", new Object[] { Boolean.valueOf(this.zjy) });
    if (this.zjy) {
      return;
    }
    this.zjy = true;
    c localc = this.iLD;
    Assert.assertNotNull("cgi must not be null", localc);
    localc.aYI().h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
  }
  
  public final void a(final a<K> parama, long paramLong)
  {
    Log.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s, %s", new Object[] { Boolean.TRUE, Long.valueOf(paramLong) });
    if (paramLong <= 0L)
    {
      a(parama, true);
      return;
    }
    h.RTc.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163879);
        a.a(a.this, parama, this.Rtj);
        AppMethodBeat.o(163879);
      }
    }, paramLong);
  }
  
  protected abstract void b(c.a<K> parama);
  
  public final void b(P paramP)
  {
    this.iLD = paramP;
  }
  
  public final void cancel()
  {
    if (this.iLD != null) {
      this.iLD.cancel();
    }
  }
  
  protected abstract K efb();
  
  public static abstract interface a<K>
  {
    public abstract void dw(K paramK);
    
    public abstract void dx(K paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */