package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.kg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class c<T extends b>
  extends com.tencent.mm.sdk.b.c<T>
  implements f
{
  private static HashMap<b, c<? extends b>> elp = new HashMap();
  private static HashMap<m, b> rST = new HashMap();
  private int rSS = 0;
  
  public static void k(b paramb)
  {
    Iterator localIterator = rST.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (localEntry.getValue() != paramb);
    for (paramb = (m)localEntry.getKey();; paramb = null)
    {
      if (paramb != null)
      {
        g.Dk().c(paramb);
        rST.remove(paramb);
      }
      return;
    }
  }
  
  public abstract b a(int paramInt, m paramm, T paramT);
  
  public abstract m b(T paramT);
  
  public final void bdw()
  {
    if (this.rSS == 0) {}
    do
    {
      return;
      this.rSS -= 1;
    } while (this.rSS != 0);
    g.Dk().b(xf(), this);
  }
  
  public final void ckr()
  {
    if (this.rSS == 0) {
      g.Dk().a(xf(), this);
    }
    this.rSS += 1;
  }
  
  public final void l(T paramT)
  {
    m localm = b(paramT);
    g.Dk().a(localm, 0);
    rST.put(localm, paramT);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    b localb;
    if (xf() == paramm.getType())
    {
      localb = (b)rST.remove(paramm);
      if (localb != null) {}
    }
    else
    {
      return;
    }
    kg localkg = new kg();
    localkg.bTm.bTn = a(paramInt2, paramm, localb);
    localkg.bTm.errType = paramInt1;
    localkg.bTm.errCode = paramInt2;
    localkg.bTm.aox = paramString;
    a.udP.m(localkg);
  }
  
  public abstract int xf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.c
 * JD-Core Version:    0.7.0.1
 */