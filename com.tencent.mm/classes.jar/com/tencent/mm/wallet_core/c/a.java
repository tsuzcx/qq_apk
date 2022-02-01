package com.tencent.mm.wallet_core.c;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends cwj, P extends com.tencent.mm.ak.a<K>>
{
  protected MutableLiveData<K> LUq = new MutableLiveData();
  protected MutableLiveData<K> LUr = new MutableLiveData();
  protected List<a<K>> callbacks = new ArrayList();
  protected P hQw;
  protected boolean vPu = false;
  
  private void a(a<K> parama, boolean paramBoolean)
  {
    cwj localcwj = dlh();
    if (localcwj != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (parama != null) {
          parama.dp(localcwj);
        }
        this.LUq.postValue(localcwj);
      }
      if ((i == 0) || (paramBoolean))
      {
        if ((parama != null) && (!this.callbacks.contains(parama))) {
          this.callbacks.add(parama);
        }
        fVL();
      }
      return;
    }
  }
  
  private void fVL()
  {
    ae.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", new Object[] { Boolean.valueOf(this.vPu) });
    if (this.vPu) {
      return;
    }
    this.vPu = true;
    com.tencent.mm.ak.a locala = this.hQw;
    Assert.assertNotNull("cgi must not be null", locala);
    locala.aET().h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
  }
  
  public final void a(final a<K> parama, long paramLong)
  {
    ae.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s, %s", new Object[] { Boolean.TRUE, Long.valueOf(paramLong) });
    if (paramLong <= 0L)
    {
      a(parama, true);
      return;
    }
    h.MqF.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163879);
        a.a(a.this, parama, this.LUt);
        AppMethodBeat.o(163879);
      }
    }, paramLong);
  }
  
  public final void b(P paramP)
  {
    this.hQw = paramP;
  }
  
  protected abstract void c(com.tencent.mm.ak.a.a<K> parama);
  
  public final void cancel()
  {
    if (this.hQw != null) {
      this.hQw.cancel();
    }
  }
  
  protected abstract K dlh();
  
  public static abstract interface a<K>
  {
    public abstract void jdMethod_do(K paramK);
    
    public abstract void dp(K paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */