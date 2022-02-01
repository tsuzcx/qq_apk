package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.lo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a
  extends c<lo>
{
  protected ArrayList<String> Fcn = new ArrayList(3);
  
  public a()
  {
    this.__eventId = lo.class.getName().hashCode();
  }
  
  public static void a(String paramString, a parama)
  {
    if (!parama.Fcn.contains(paramString)) {
      parama.Fcn.add(paramString);
    }
    com.tencent.mm.sdk.b.a.IvT.c(parama);
    e.aML(paramString);
  }
  
  public static void b(String paramString, a parama)
  {
    e.aMM(paramString);
    com.tencent.mm.sdk.b.a.IvT.d(parama);
    if (parama.Fcn.contains(paramString)) {
      parama.Fcn.remove(paramString);
    }
  }
  
  public abstract void i(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.a
 * JD-Core Version:    0.7.0.1
 */