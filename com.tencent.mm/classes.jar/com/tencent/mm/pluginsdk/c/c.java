package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mr;
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
  private static HashMap<n, b> Fcp = new HashMap();
  private static HashMap<b, c<? extends b>> bGq = new HashMap();
  private int Fco = 0;
  
  public static void j(b paramb)
  {
    Iterator localIterator = Fcp.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (localEntry.getValue() != paramb);
    for (paramb = (n)localEntry.getKey();; paramb = null)
    {
      if (paramb != null)
      {
        g.ajj().a(paramb);
        Fcp.remove(paramb);
      }
      return;
    }
  }
  
  public abstract int Yl();
  
  public abstract n a(T paramT);
  
  public abstract b a(int paramInt, n paramn, T paramT);
  
  public final void dic()
  {
    if (this.Fco == 0) {}
    do
    {
      return;
      this.Fco -= 1;
    } while (this.Fco != 0);
    g.ajj().b(Yl(), this);
  }
  
  public final void fcQ()
  {
    if (this.Fco == 0) {
      g.ajj().a(Yl(), this);
    }
    this.Fco += 1;
  }
  
  public final void k(T paramT)
  {
    n localn = a(paramT);
    g.ajj().a(localn, 0);
    Fcp.put(localn, paramT);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    b localb;
    if (Yl() == paramn.getType())
    {
      localb = (b)Fcp.remove(paramn);
      if (localb != null) {}
    }
    else
    {
      return;
    }
    mr localmr = new mr();
    localmr.dBE.dBF = a(paramInt2, paramn, localb);
    localmr.dBE.errType = paramInt1;
    localmr.dBE.errCode = paramInt2;
    localmr.dBE.errMsg = paramString;
    a.IvT.l(localmr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.c
 * JD-Core Version:    0.7.0.1
 */