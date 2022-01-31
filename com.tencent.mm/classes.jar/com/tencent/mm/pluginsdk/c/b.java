package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.h.a.kg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b
  extends c<kg>
{
  protected ArrayList<String> rSR = new ArrayList(3);
  
  public b()
  {
    super(0);
    this.udX = kg.class.getName().hashCode();
  }
  
  public static void a(String paramString, b paramb)
  {
    if (!paramb.rSR.contains(paramString)) {
      paramb.rSR.add(paramString);
    }
    a.udP.c(paramb);
    e.VF(paramString);
  }
  
  public static void b(String paramString, b paramb)
  {
    e.VG(paramString);
    a.udP.d(paramb);
    if (paramb.rSR.contains(paramString)) {
      paramb.rSR.remove(paramString);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.sdk.b.b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.b
 * JD-Core Version:    0.7.0.1
 */