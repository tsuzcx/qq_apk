package com.tencent.mm.storage;

import com.tencent.mm.model.bl.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storagebase.h;

public abstract class e
{
  public static n IHT;
  protected i IHS;
  
  public e(i parami)
  {
    this.IHS = parami;
  }
  
  protected final void a(i.b paramb)
  {
    this.IHS.a(paramb);
  }
  
  protected final void a(i.c paramc)
  {
    this.IHS.a(paramc);
  }
  
  protected boolean a(bv parambv, bl.b paramb)
  {
    return true;
  }
  
  public abstract String ajr(String paramString);
  
  protected final String art(String paramString)
  {
    return this.IHS.art(paramString);
  }
  
  protected final void d(h paramh, String paramString)
  {
    this.IHS.d(paramh, paramString);
  }
  
  public final h getDB()
  {
    return this.IHS.getDB();
  }
  
  protected final void ma(String paramString1, String paramString2)
  {
    this.IHS.c(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.e
 * JD-Core Version:    0.7.0.1
 */