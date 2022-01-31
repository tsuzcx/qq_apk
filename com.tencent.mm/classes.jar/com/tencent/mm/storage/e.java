package com.tencent.mm.storage;

import com.tencent.mm.cf.h;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;

public abstract class e
{
  public static l umQ;
  protected g umP;
  
  public e(g paramg)
  {
    this.umP = paramg;
  }
  
  protected final String HT(String paramString)
  {
    return this.umP.HT(paramString);
  }
  
  protected final void a(h paramh, String paramString)
  {
    this.umP.a(paramh, paramString);
  }
  
  protected final void a(g.b paramb)
  {
    this.umP.a(paramb);
  }
  
  protected final void a(g.c paramc)
  {
    this.umP.a(paramc);
  }
  
  protected boolean a(bi parambi, bd.b paramb)
  {
    return true;
  }
  
  public abstract String aaD(String paramString);
  
  public final h bhV()
  {
    return this.umP.bhV();
  }
  
  protected final void gl(String paramString1, String paramString2)
  {
    this.umP.b(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.e
 * JD-Core Version:    0.7.0.1
 */