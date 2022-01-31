package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class k
  extends i<g>
{
  public static final String[] dXp = { i.a(g.buS, "AppMessage") };
  
  public k(e parame)
  {
    super(parame, g.buS, "AppMessage", null);
  }
  
  public final g gZ(long paramLong)
  {
    g localg = new g();
    localg.field_msgId = paramLong;
    if (super.b(localg, new String[0])) {
      return localg;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.k
 * JD-Core Version:    0.7.0.1
 */