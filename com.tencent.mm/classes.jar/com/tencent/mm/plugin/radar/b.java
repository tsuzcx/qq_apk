package com.tencent.mm.plugin.radar;

import a.d.b.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;

public final class b
  implements n
{
  private static m eUR;
  private static l eUS;
  public static final b.a nkp = new b.a((byte)0);
  
  public final void a(l paraml)
  {
    g.k(paraml, "callback");
    eUS = paraml;
  }
  
  public final void a(m paramm)
  {
    g.k(paramm, "callback");
    eUR = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b
 * JD-Core Version:    0.7.0.1
 */