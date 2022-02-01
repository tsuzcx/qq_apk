package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.mq;
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
  private static HashMap<n, b> EJR = new HashMap();
  private static HashMap<b, c<? extends b>> bGq = new HashMap();
  private int EJQ = 0;
  
  public static void j(b paramb)
  {
    Iterator localIterator = EJR.entrySet().iterator();
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
        g.aiU().a(paramb);
        EJR.remove(paramb);
      }
      return;
    }
  }
  
  public abstract int Yb();
  
  public abstract n a(T paramT);
  
  public abstract b a(int paramInt, n paramn, T paramT);
  
  public final void dfk()
  {
    if (this.EJQ == 0) {}
    do
    {
      return;
      this.EJQ -= 1;
    } while (this.EJQ != 0);
    g.aiU().b(Yb(), this);
  }
  
  public final void eZc()
  {
    if (this.EJQ == 0) {
      g.aiU().a(Yb(), this);
    }
    this.EJQ += 1;
  }
  
  public final void k(T paramT)
  {
    n localn = a(paramT);
    g.aiU().a(localn, 0);
    EJR.put(localn, paramT);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    b localb;
    if (Yb() == paramn.getType())
    {
      localb = (b)EJR.remove(paramn);
      if (localb != null) {}
    }
    else
    {
      return;
    }
    mq localmq = new mq();
    localmq.dAz.dAA = a(paramInt2, paramn, localb);
    localmq.dAz.errType = paramInt1;
    localmq.dAz.errCode = paramInt2;
    localmq.dAz.errMsg = paramString;
    a.IbL.l(localmq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.c
 * JD-Core Version:    0.7.0.1
 */