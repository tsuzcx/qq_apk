package com.tencent.mm.storage;

import com.tencent.mm.model.bp.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storagebase.h;

public abstract class e
{
  public static n NOM;
  protected i NOL;
  
  public e(i parami)
  {
    this.NOL = parami;
  }
  
  protected final void a(i.b paramb)
  {
    this.NOL.a(paramb);
  }
  
  protected final void a(i.c paramc)
  {
    this.NOL.a(paramc);
  }
  
  protected boolean a(ca paramca, bp.b paramb)
  {
    return true;
  }
  
  protected final String aEO(String paramString)
  {
    return this.NOL.aEO(paramString);
  }
  
  public abstract String avu(String paramString);
  
  protected final void e(h paramh, String paramString)
  {
    this.NOL.e(paramh, paramString);
  }
  
  public final h getDB()
  {
    return this.NOL.getDB();
  }
  
  protected final void mO(String paramString1, String paramString2)
  {
    this.NOL.c(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.e
 * JD-Core Version:    0.7.0.1
 */