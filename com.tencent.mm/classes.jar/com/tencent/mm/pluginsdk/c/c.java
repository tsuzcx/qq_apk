package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class c<T extends IEvent>
  extends IListener<T>
  implements i
{
  private static HashMap<q, IEvent> JTo = new HashMap();
  private static HashMap<IEvent, c<? extends IEvent>> bGH = new HashMap();
  private int JTn = 0;
  
  public static void j(IEvent paramIEvent)
  {
    Iterator localIterator = JTo.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (localEntry.getValue() != paramIEvent);
    for (paramIEvent = (q)localEntry.getKey();; paramIEvent = null)
    {
      if (paramIEvent != null)
      {
        g.azz().a(paramIEvent);
        JTo.remove(paramIEvent);
      }
      return;
    }
  }
  
  public abstract q a(T paramT);
  
  public abstract IEvent a(int paramInt, q paramq, T paramT);
  
  public abstract int alY();
  
  public final void ecc()
  {
    if (this.JTn == 0) {}
    do
    {
      return;
      this.JTn -= 1;
    } while (this.JTn != 0);
    g.azz().b(alY(), this);
  }
  
  public final void gmc()
  {
    if (this.JTn == 0) {
      g.azz().a(alY(), this);
    }
    this.JTn += 1;
  }
  
  public final void k(T paramT)
  {
    q localq = a(paramT);
    g.azz().a(localq, 0);
    JTo.put(localq, paramT);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    IEvent localIEvent;
    if (alY() == paramq.getType())
    {
      localIEvent = (IEvent)JTo.remove(paramq);
      if (localIEvent != null) {}
    }
    else
    {
      return;
    }
    ni localni = new ni();
    localni.dTt.dTu = a(paramInt2, paramq, localIEvent);
    localni.dTt.errType = paramInt1;
    localni.dTt.errCode = paramInt2;
    localni.dTt.errMsg = paramString;
    EventCenter.instance.publish(localni);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.c
 * JD-Core Version:    0.7.0.1
 */