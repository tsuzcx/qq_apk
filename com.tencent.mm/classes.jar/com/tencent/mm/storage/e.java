package com.tencent.mm.storage;

import com.tencent.mm.model.bq.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.storagebase.h;

public abstract class e
{
  public static p Vcv;
  protected i Vcu;
  
  public e(i parami)
  {
    this.Vcu = parami;
  }
  
  protected final void a(i.b paramb)
  {
    this.Vcu.a(paramb);
  }
  
  protected final void a(i.c paramc)
  {
    this.Vcu.a(paramc);
  }
  
  protected boolean a(ca paramca, bq.b paramb)
  {
    return true;
  }
  
  public abstract String aEK(String paramString);
  
  protected final String aOY(String paramString)
  {
    return this.Vcu.aOY(paramString);
  }
  
  protected final void e(h paramh, String paramString)
  {
    this.Vcu.e(paramh, paramString);
  }
  
  public final h getDB()
  {
    return this.Vcu.getDB();
  }
  
  protected final void nF(String paramString1, String paramString2)
  {
    this.Vcu.d(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.e
 * JD-Core Version:    0.7.0.1
 */