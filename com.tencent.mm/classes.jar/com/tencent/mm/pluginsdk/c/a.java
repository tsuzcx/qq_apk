package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.kv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a
  extends c<kv>
{
  protected ArrayList<String> BNJ = new ArrayList(3);
  
  public a()
  {
    this.__eventId = kv.class.getName().hashCode();
  }
  
  public static void a(String paramString, a parama)
  {
    if (!parama.BNJ.contains(paramString)) {
      parama.BNJ.add(paramString);
    }
    com.tencent.mm.sdk.b.a.ESL.c(parama);
    e.aAx(paramString);
  }
  
  public static void b(String paramString, a parama)
  {
    e.aAy(paramString);
    com.tencent.mm.sdk.b.a.ESL.d(parama);
    if (parama.BNJ.contains(paramString)) {
      parama.BNJ.remove(paramString);
    }
  }
  
  public abstract void i(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.a
 * JD-Core Version:    0.7.0.1
 */