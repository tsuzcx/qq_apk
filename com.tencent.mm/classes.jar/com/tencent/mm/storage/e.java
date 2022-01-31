package com.tencent.mm.storage;

import com.tencent.mm.model.bf.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;

public abstract class e
{
  public static l yww;
  protected com.tencent.mm.plugin.messenger.foundation.a.a.h ywv;
  
  public e(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh)
  {
    this.ywv = paramh;
  }
  
  protected final String TC(String paramString)
  {
    return this.ywv.TC(paramString);
  }
  
  protected final void a(com.tencent.mm.cg.h paramh, String paramString)
  {
    this.ywv.a(paramh, paramString);
  }
  
  protected final void a(h.b paramb)
  {
    this.ywv.a(paramb);
  }
  
  protected final void a(h.c paramc)
  {
    this.ywv.a(paramc);
  }
  
  protected boolean a(bi parambi, bf.b paramb)
  {
    return true;
  }
  
  public abstract String aqO(String paramString);
  
  public final com.tencent.mm.cg.h bPX()
  {
    return this.ywv.bPX();
  }
  
  protected final void im(String paramString1, String paramString2)
  {
    this.ywv.b(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.e
 * JD-Core Version:    0.7.0.1
 */