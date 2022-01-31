package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.h.a.jj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a
  extends c<jj>
{
  protected ArrayList<String> rSR = new ArrayList(3);
  
  public a()
  {
    this.udX = jj.class.getName().hashCode();
  }
  
  public static void a(String paramString, a parama)
  {
    if (!parama.rSR.contains(paramString)) {
      parama.rSR.add(paramString);
    }
    com.tencent.mm.sdk.b.a.udP.c(parama);
    e.VF(paramString);
  }
  
  public static void b(String paramString, a parama)
  {
    e.VG(paramString);
    com.tencent.mm.sdk.b.a.udP.d(parama);
    if (parama.rSR.contains(paramString)) {
      parama.rSR.remove(paramString);
    }
  }
  
  public abstract void j(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.a
 * JD-Core Version:    0.7.0.1
 */