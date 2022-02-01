package com.tencent.mm.wallet_core.c;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends cqk, P extends c<K>>
{
  protected MutableLiveData<K> JEx = new MutableLiveData();
  protected MutableLiveData<K> JEy = new MutableLiveData();
  protected List<a<K>> callbacks = new ArrayList();
  protected P hvz;
  protected boolean uAL = false;
  
  private void a(a<K> parama, boolean paramBoolean)
  {
    cqk localcqk = cYW();
    if (localcqk != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (parama != null) {
          parama.dl(localcqk);
        }
        this.JEx.postValue(localcqk);
      }
      if ((i == 0) || (paramBoolean))
      {
        if ((parama != null) && (!this.callbacks.contains(parama))) {
          this.callbacks.add(parama);
        }
        fAf();
      }
      return;
    }
  }
  
  private void fAf()
  {
    ac.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", new Object[] { Boolean.valueOf(this.uAL) });
    if (this.uAL) {
      return;
    }
    this.uAL = true;
    c localc = this.hvz;
    Assert.assertNotNull("cgi must not be null", localc);
    localc.aBB().h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
  }
  
  public final void a(final a<K> parama, long paramLong)
  {
    ac.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s, %s", new Object[] { Boolean.TRUE, Long.valueOf(paramLong) });
    if (paramLong <= 0L)
    {
      a(parama, true);
      return;
    }
    h.JZN.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163879);
        a.a(a.this, parama, this.JEA);
        AppMethodBeat.o(163879);
      }
    }, paramLong);
  }
  
  public final void b(P paramP)
  {
    this.hvz = paramP;
  }
  
  protected abstract void c(c.a<K> parama);
  
  protected abstract K cYW();
  
  public final void cancel()
  {
    if (this.hvz != null) {
      this.hvz.cancel();
    }
  }
  
  public static abstract interface a<K>
  {
    public abstract void dk(K paramK);
    
    public abstract void dl(K paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */