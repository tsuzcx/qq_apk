package com.tencent.mm.wallet_core.c;

import androidx.lifecycle.r;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends dyy, P extends c<K>>
{
  protected boolean EOP = false;
  protected r<K> YUE = new r();
  protected r<K> YUF = new r();
  protected List<a<K>> callbacks = new ArrayList();
  protected P lBK;
  
  private void a(a<K> parama, boolean paramBoolean)
  {
    dyy localdyy = eOw();
    if (localdyy != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (parama != null) {
          parama.dA(localdyy);
        }
        this.YUE.L(localdyy);
      }
      if ((i == 0) || (paramBoolean))
      {
        if ((parama != null) && (!this.callbacks.contains(parama))) {
          this.callbacks.add(parama);
        }
        iiK();
      }
      return;
    }
  }
  
  private void iiK()
  {
    Log.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", new Object[] { Boolean.valueOf(this.EOP) });
    if (this.EOP) {
      return;
    }
    this.EOP = true;
    c localc = this.lBK;
    Assert.assertNotNull("cgi must not be null", localc);
    localc.bhW().h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
  }
  
  public final void a(final a<K> parama, long paramLong)
  {
    Log.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s, %s", new Object[] { Boolean.TRUE, Long.valueOf(paramLong) });
    if (paramLong <= 0L)
    {
      a(parama, true);
      return;
    }
    h.ZvG.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163879);
        a.a(a.this, parama, this.YUH);
        AppMethodBeat.o(163879);
      }
    }, paramLong);
  }
  
  protected abstract void b(c.a<K> parama);
  
  public final void cancel()
  {
    if (this.lBK != null) {
      this.lBK.cancel();
    }
  }
  
  public final void d(P paramP)
  {
    this.lBK = paramP;
  }
  
  public abstract K eOw();
  
  public static abstract interface a<K>
  {
    public abstract void c(K paramK, int paramInt1, int paramInt2);
    
    public abstract void dA(K paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */