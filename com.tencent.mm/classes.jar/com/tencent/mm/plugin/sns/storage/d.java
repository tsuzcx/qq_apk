package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class d
  extends i<c>
{
  public static final String[] dXp = { i.a(c.buS, "CanvasInfo") };
  
  public d(e parame)
  {
    this(parame, c.buS, "CanvasInfo");
  }
  
  private d(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
  }
  
  public final void a(c paramc)
  {
    if (paramc == null) {}
    do
    {
      return;
      paramc.field_createTime = System.currentTimeMillis();
    } while (b(paramc));
    c(paramc, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.d
 * JD-Core Version:    0.7.0.1
 */