package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.al;

public abstract class a
{
  private Runnable ueT = new a.1(this);
  
  protected abstract void a(a parama);
  
  public final void b(a parama)
  {
    a(parama);
  }
  
  protected abstract void bOR();
  
  public void release()
  {
    al.ae(this.ueT);
  }
  
  public static abstract interface a
  {
    public abstract void r(Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a
 * JD-Core Version:    0.7.0.1
 */