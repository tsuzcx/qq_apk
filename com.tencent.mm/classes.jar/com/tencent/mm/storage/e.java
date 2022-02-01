package com.tencent.mm.storage;

import com.tencent.mm.model.bi.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.m;

public abstract class e
{
  public static m Fef;
  protected com.tencent.mm.plugin.messenger.foundation.a.a.h Fee;
  
  public e(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh)
  {
    this.Fee = paramh;
  }
  
  protected final void a(h.b paramb)
  {
    this.Fee.a(paramb);
  }
  
  protected final void a(h.c paramc)
  {
    this.Fee.a(paramc);
  }
  
  protected boolean a(bl parambl, bi.b paramb)
  {
    return true;
  }
  
  public abstract String aHk(String paramString);
  
  protected final String agG(String paramString)
  {
    return this.Fee.agG(paramString);
  }
  
  protected final void c(com.tencent.mm.storagebase.h paramh, String paramString)
  {
    this.Fee.c(paramh, paramString);
  }
  
  public final com.tencent.mm.storagebase.h getDB()
  {
    return this.Fee.getDB();
  }
  
  protected final void kX(String paramString1, String paramString2)
  {
    this.Fee.b(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.e
 * JD-Core Version:    0.7.0.1
 */