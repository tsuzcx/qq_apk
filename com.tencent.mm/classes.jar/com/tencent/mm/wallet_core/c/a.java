package com.tencent.mm.wallet_core.c;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.mm.cm.f;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends bvk, P extends com.tencent.mm.ai.a<K>>
{
  protected MutableLiveData<K> AWC = new MutableLiveData();
  protected MutableLiveData<K> AWD = new MutableLiveData();
  protected List<a.a<K>> callbacks = new ArrayList();
  protected P fsO;
  protected boolean oxS = false;
  
  public final void a(a.a<K> parama)
  {
    ab.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s", new Object[] { Boolean.TRUE });
    bvk localbvk = bNh();
    if (localbvk != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama.bR(localbvk);
        this.AWC.postValue(localbvk);
      }
      if (!this.callbacks.contains(parama)) {
        this.callbacks.add(parama);
      }
      ab.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", new Object[] { Boolean.valueOf(this.oxS) });
      if (!this.oxS)
      {
        this.oxS = true;
        parama = this.fsO;
        Assert.assertNotNull("cgi must not be null", parama);
        parama.adl().h(new a.2(this)).b(new a.1(this));
      }
      return;
    }
  }
  
  public final void b(P paramP)
  {
    this.fsO = paramP;
  }
  
  protected abstract K bNh();
  
  protected abstract void e(com.tencent.mm.ai.a.a<K> parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */