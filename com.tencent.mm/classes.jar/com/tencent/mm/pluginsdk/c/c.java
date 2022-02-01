package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class c<T extends b>
  extends com.tencent.mm.sdk.b.c<T>
  implements com.tencent.mm.ak.g
{
  private static HashMap<n, b> DfV = new HashMap();
  private static HashMap<b, c<? extends b>> bwc = new HashMap();
  private int DfU = 0;
  
  public static void j(b paramb)
  {
    Iterator localIterator = DfV.entrySet().iterator();
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
        com.tencent.mm.kernel.g.agi().a(paramb);
        DfV.remove(paramb);
      }
      return;
    }
  }
  
  public abstract int VK();
  
  public abstract n a(T paramT);
  
  public abstract b a(int paramInt, n paramn, T paramT);
  
  public final void cVZ()
  {
    if (this.DfU == 0) {}
    do
    {
      return;
      this.DfU -= 1;
    } while (this.DfU != 0);
    com.tencent.mm.kernel.g.agi().b(VK(), this);
  }
  
  public final void eKo()
  {
    if (this.DfU == 0) {
      com.tencent.mm.kernel.g.agi().a(VK(), this);
    }
    this.DfU += 1;
  }
  
  public final void k(T paramT)
  {
    n localn = a(paramT);
    com.tencent.mm.kernel.g.agi().a(localn, 0);
    DfV.put(localn, paramT);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    b localb;
    if (VK() == paramn.getType())
    {
      localb = (b)DfV.remove(paramn);
      if (localb != null) {}
    }
    else
    {
      return;
    }
    mh localmh = new mh();
    localmh.doL.doM = a(paramInt2, paramn, localb);
    localmh.doL.errType = paramInt1;
    localmh.doL.errCode = paramInt2;
    localmh.doL.errMsg = paramString;
    a.GpY.l(localmh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.c
 * JD-Core Version:    0.7.0.1
 */