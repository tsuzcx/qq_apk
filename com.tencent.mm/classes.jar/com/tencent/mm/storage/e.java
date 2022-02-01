package com.tencent.mm.storage;

import com.tencent.mm.model.br.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.storagebase.h;

public abstract class e
{
  public static p acDF;
  protected i acDE;
  
  public e(i parami)
  {
    this.acDE = parami;
  }
  
  protected final void a(i.b paramb)
  {
    this.acDE.a(paramb);
  }
  
  protected final void a(i.c paramc)
  {
    this.acDE.a(paramc);
  }
  
  protected boolean a(cc paramcc, br.b paramb)
  {
    return true;
  }
  
  public abstract String aAD(String paramString);
  
  protected final String aLY(String paramString)
  {
    return this.acDE.aLY(paramString);
  }
  
  protected final void e(h paramh, String paramString)
  {
    this.acDE.e(paramh, paramString);
  }
  
  public final h getDB()
  {
    return this.acDE.getDB();
  }
  
  protected final void pD(String paramString1, String paramString2)
  {
    this.acDE.d(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.e
 * JD-Core Version:    0.7.0.1
 */