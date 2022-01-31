package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.kt;
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
  private static HashMap<b, c<? extends b>> bat = new HashMap();
  private static HashMap<m, b> vJR = new HashMap();
  private int vJQ = 0;
  
  public static void j(b paramb)
  {
    Iterator localIterator = vJR.entrySet().iterator();
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
        g.Rc().a(paramb);
        vJR.remove(paramb);
      }
      return;
    }
  }
  
  public abstract int Jx();
  
  public abstract m a(T paramT);
  
  public abstract b a(int paramInt, m paramm, T paramT);
  
  public final void bKR()
  {
    if (this.vJQ == 0) {}
    do
    {
      return;
      this.vJQ -= 1;
    } while (this.vJQ != 0);
    g.Rc().b(Jx(), this);
  }
  
  public final void cjv()
  {
    if (this.vJQ == 0) {
      g.Rc().a(Jx(), this);
    }
    this.vJQ += 1;
  }
  
  public final void k(T paramT)
  {
    m localm = a(paramT);
    g.Rc().a(localm, 0);
    vJR.put(localm, paramT);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    b localb;
    if (Jx() == paramm.getType())
    {
      localb = (b)vJR.remove(paramm);
      if (localb != null) {}
    }
    else
    {
      return;
    }
    kt localkt = new kt();
    localkt.cAR.cAS = a(paramInt2, paramm, localb);
    localkt.cAR.errType = paramInt1;
    localkt.cAR.errCode = paramInt2;
    localkt.cAR.errMsg = paramString;
    a.ymk.l(localkt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.c
 * JD-Core Version:    0.7.0.1
 */