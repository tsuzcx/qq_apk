package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.ln;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a
  extends c<ln>
{
  protected ArrayList<String> EJP = new ArrayList(3);
  
  public a()
  {
    this.__eventId = ln.class.getName().hashCode();
  }
  
  public static void a(String paramString, a parama)
  {
    if (!parama.EJP.contains(paramString)) {
      parama.EJP.add(paramString);
    }
    com.tencent.mm.sdk.b.a.IbL.c(parama);
    e.aLp(paramString);
  }
  
  public static void b(String paramString, a parama)
  {
    e.aLq(paramString);
    com.tencent.mm.sdk.b.a.IbL.d(parama);
    if (parama.EJP.contains(paramString)) {
      parama.EJP.remove(paramString);
    }
  }
  
  public abstract void i(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.a
 * JD-Core Version:    0.7.0.1
 */