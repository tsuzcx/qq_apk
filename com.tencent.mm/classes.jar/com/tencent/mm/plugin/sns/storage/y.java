package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public final class y
  extends i<x>
{
  public static final String[] dXp = { i.a(x.buS, "UxCanvasInfo") };
  
  public y(e parame)
  {
    this(parame, x.buS, "UxCanvasInfo");
  }
  
  private y(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
  }
  
  public final void a(x paramx)
  {
    if ((paramx == null) || (bk.bl(paramx.field_canvasXml))) {}
    do
    {
      return;
      paramx.field_createTime = System.currentTimeMillis();
    } while (b(paramx));
    c(paramx, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.y
 * JD-Core Version:    0.7.0.1
 */