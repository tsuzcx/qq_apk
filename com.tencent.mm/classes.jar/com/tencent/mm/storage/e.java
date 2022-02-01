package com.tencent.mm.storage;

import com.tencent.mm.model.bi.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.m;

public abstract class e
{
  public static m GBO;
  protected com.tencent.mm.plugin.messenger.foundation.a.a.h GBN;
  
  public e(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh)
  {
    this.GBN = paramh;
  }
  
  protected final void a(h.b paramb)
  {
    this.GBN.a(paramb);
  }
  
  protected final void a(h.c paramc)
  {
    this.GBN.a(paramc);
  }
  
  protected boolean a(bo parambo, bi.b paramb)
  {
    return true;
  }
  
  public abstract String aME(String paramString);
  
  protected final String alA(String paramString)
  {
    return this.GBN.alA(paramString);
  }
  
  protected final void c(com.tencent.mm.storagebase.h paramh, String paramString)
  {
    this.GBN.c(paramh, paramString);
  }
  
  public final com.tencent.mm.storagebase.h getDB()
  {
    return this.GBN.getDB();
  }
  
  protected final void lu(String paramString1, String paramString2)
  {
    this.GBN.b(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.e
 * JD-Core Version:    0.7.0.1
 */