package com.tencent.mm.wallet_core.model;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends esc, P extends b<K>>
{
  protected boolean KJn = false;
  protected x<K> agSA = new x();
  protected x<K> agSz = new x();
  protected List<a<K>> bPE = new ArrayList();
  protected P otu;
  
  private void a(a<K> parama, boolean paramBoolean)
  {
    esc localesc = fWT();
    if (localesc != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (parama != null) {
          parama.fR(localesc);
        }
        this.agSz.t(localesc);
      }
      if ((i == 0) || (paramBoolean))
      {
        if ((parama != null) && (!this.bPE.contains(parama))) {
          this.bPE.add(parama);
        }
        jOF();
      }
      return;
    }
  }
  
  private void jOF()
  {
    Log.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", new Object[] { Boolean.valueOf(this.KJn) });
    if (this.KJn) {
      return;
    }
    this.KJn = true;
    b localb = this.otu;
    Assert.assertNotNull("cgi must not be null", localb);
    localb.bFJ().h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
  }
  
  public final void a(final a<K> parama, long paramLong)
  {
    Log.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s, %s", new Object[] { Boolean.TRUE, Long.valueOf(paramLong) });
    if (paramLong <= 0L)
    {
      a(parama, true);
      return;
    }
    h.ahAA.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163879);
        a.a(a.this, parama, this.agSC);
        AppMethodBeat.o(163879);
      }
    }, paramLong);
  }
  
  protected abstract void b(b.a<K> parama);
  
  public final void cancel()
  {
    if (this.otu != null) {
      this.otu.cancel();
    }
  }
  
  public final void d(P paramP)
  {
    this.otu = paramP;
  }
  
  public abstract K fWT();
  
  public static abstract interface a<K>
  {
    public abstract void fR(K paramK);
    
    public abstract void i(K paramK, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.a
 * JD-Core Version:    0.7.0.1
 */