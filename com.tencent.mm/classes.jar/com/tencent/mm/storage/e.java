package com.tencent.mm.storage;

import com.tencent.mm.model.bj.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storagebase.h;

public abstract class e
{
  public static n InI;
  protected i InH;
  
  public e(i parami)
  {
    this.InH = parami;
  }
  
  protected final void a(i.b paramb)
  {
    this.InH.a(paramb);
  }
  
  protected final void a(i.c paramc)
  {
    this.InH.a(paramc);
  }
  
  protected boolean a(bu parambu, bj.b paramb)
  {
    return true;
  }
  
  public abstract String aiu(String paramString);
  
  protected final String aqo(String paramString)
  {
    return this.InH.aqo(paramString);
  }
  
  protected final void d(h paramh, String paramString)
  {
    this.InH.d(paramh, paramString);
  }
  
  public final h getDB()
  {
    return this.InH.getDB();
  }
  
  protected final void lT(String paramString1, String paramString2)
  {
    this.InH.c(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.e
 * JD-Core Version:    0.7.0.1
 */