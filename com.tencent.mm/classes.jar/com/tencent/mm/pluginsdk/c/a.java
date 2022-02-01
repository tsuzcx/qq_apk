package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.le;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a
  extends c<le>
{
  protected ArrayList<String> DfT = new ArrayList(3);
  
  public a()
  {
    this.__eventId = le.class.getName().hashCode();
  }
  
  public static void a(String paramString, a parama)
  {
    if (!parama.DfT.contains(paramString)) {
      parama.DfT.add(paramString);
    }
    com.tencent.mm.sdk.b.a.GpY.c(parama);
    e.aFP(paramString);
  }
  
  public static void b(String paramString, a parama)
  {
    e.aFQ(paramString);
    com.tencent.mm.sdk.b.a.GpY.d(parama);
    if (parama.DfT.contains(paramString)) {
      parama.DfT.remove(paramString);
    }
  }
  
  public abstract void i(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.a
 * JD-Core Version:    0.7.0.1
 */