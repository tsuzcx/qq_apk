package com.tencent.mm.wallet_core.c;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends cvp, P extends com.tencent.mm.al.a<K>>
{
  protected MutableLiveData<K> LxB = new MutableLiveData();
  protected MutableLiveData<K> LxC = new MutableLiveData();
  protected List<a<K>> callbacks = new ArrayList();
  protected P hND;
  protected boolean vDq = false;
  
  private void a(a<K> parama, boolean paramBoolean)
  {
    cvp localcvp = dii();
    if (localcvp != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (parama != null) {
          parama.jdMethod_do(localcvp);
        }
        this.LxB.postValue(localcvp);
      }
      if ((i == 0) || (paramBoolean))
      {
        if ((parama != null) && (!this.callbacks.contains(parama))) {
          this.callbacks.add(parama);
        }
        fRp();
      }
      return;
    }
  }
  
  private void fRp()
  {
    ad.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", new Object[] { Boolean.valueOf(this.vDq) });
    if (this.vDq) {
      return;
    }
    this.vDq = true;
    com.tencent.mm.al.a locala = this.hND;
    Assert.assertNotNull("cgi must not be null", locala);
    locala.aED().h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
  }
  
  public final void a(final a<K> parama, long paramLong)
  {
    ad.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s, %s", new Object[] { Boolean.TRUE, Long.valueOf(paramLong) });
    if (paramLong <= 0L)
    {
      a(parama, true);
      return;
    }
    h.LTJ.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163879);
        a.a(a.this, parama, this.LxE);
        AppMethodBeat.o(163879);
      }
    }, paramLong);
  }
  
  public final void b(P paramP)
  {
    this.hND = paramP;
  }
  
  protected abstract void c(com.tencent.mm.al.a.a<K> parama);
  
  public final void cancel()
  {
    if (this.hND != null) {
      this.hND.cancel();
    }
  }
  
  protected abstract K dii();
  
  public static abstract interface a<K>
  {
    public abstract void dn(K paramK);
    
    public abstract void jdMethod_do(K paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */