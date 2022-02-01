package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class c<T extends b>
  extends com.tencent.mm.sdk.b.c<T>
  implements com.tencent.mm.al.g
{
  private static HashMap<n, b> BNL = new HashMap();
  private static HashMap<b, c<? extends b>> byu = new HashMap();
  private int BNK = 0;
  
  public static void j(b paramb)
  {
    Iterator localIterator = BNL.entrySet().iterator();
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
        com.tencent.mm.kernel.g.aeS().a(paramb);
        BNL.remove(paramb);
      }
      return;
    }
  }
  
  public abstract int UO();
  
  public abstract n a(T paramT);
  
  public abstract b a(int paramInt, n paramn, T paramT);
  
  public final void cIO()
  {
    if (this.BNK == 0) {}
    do
    {
      return;
      this.BNK -= 1;
    } while (this.BNK != 0);
    com.tencent.mm.kernel.g.aeS().b(UO(), this);
  }
  
  public final void euV()
  {
    if (this.BNK == 0) {
      com.tencent.mm.kernel.g.aeS().a(UO(), this);
    }
    this.BNK += 1;
  }
  
  public final void k(T paramT)
  {
    n localn = a(paramT);
    com.tencent.mm.kernel.g.aeS().a(localn, 0);
    BNL.put(localn, paramT);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    b localb;
    if (UO() == paramn.getType())
    {
      localb = (b)BNL.remove(paramn);
      if (localb != null) {}
    }
    else
    {
      return;
    }
    ly locally = new ly();
    locally.dra.drb = a(paramInt2, paramn, localb);
    locally.dra.errType = paramInt1;
    locally.dra.errCode = paramInt2;
    locally.dra.errMsg = paramString;
    a.ESL.l(locally);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.c
 * JD-Core Version:    0.7.0.1
 */