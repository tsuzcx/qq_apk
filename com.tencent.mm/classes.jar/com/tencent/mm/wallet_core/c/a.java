package com.tencent.mm.wallet_core.c;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.al.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends cld, P extends c<K>>
{
  protected MutableLiveData<K> IcV = new MutableLiveData();
  protected MutableLiveData<K> IcW = new MutableLiveData();
  protected List<a<K>> callbacks = new ArrayList();
  protected P gVa;
  protected boolean tss = false;
  
  private void a(a<K> parama, boolean paramBoolean)
  {
    cld localcld = cLq();
    if (localcld != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (parama != null) {
          parama.dj(localcld);
        }
        this.IcV.postValue(localcld);
      }
      if ((i == 0) || (paramBoolean))
      {
        if ((parama != null) && (!this.callbacks.contains(parama))) {
          this.callbacks.add(parama);
        }
        fjQ();
      }
      return;
    }
  }
  
  private void fjQ()
  {
    ad.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", new Object[] { Boolean.valueOf(this.tss) });
    if (this.tss) {
      return;
    }
    this.tss = true;
    c localc = this.gVa;
    Assert.assertNotNull("cgi must not be null", localc);
    localc.auK().h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
  }
  
  public final void a(final a<K> parama, long paramLong)
  {
    ad.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s, %s", new Object[] { Boolean.TRUE, Long.valueOf(paramLong) });
    if (paramLong <= 0L)
    {
      a(parama, true);
      return;
    }
    h.Iye.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163879);
        a.a(a.this, parama, this.IcY);
        AppMethodBeat.o(163879);
      }
    }, paramLong);
  }
  
  public final void b(P paramP)
  {
    this.gVa = paramP;
  }
  
  protected abstract void c(c.a<K> parama);
  
  protected abstract K cLq();
  
  public final void cancel()
  {
    if (this.gVa != null) {
      this.gVa.cancel();
    }
  }
  
  public static abstract interface a<K>
  {
    public abstract void di(K paramK);
    
    public abstract void dj(K paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */