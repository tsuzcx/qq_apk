package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.oa;
import com.tencent.mm.kernel.h;
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
  private static HashMap<q, IEvent> QSt = new HashMap();
  private static HashMap<IEvent, c<? extends IEvent>> bqq = new HashMap();
  private int QSs = 0;
  
  public static void j(IEvent paramIEvent)
  {
    Iterator localIterator = QSt.entrySet().iterator();
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
        h.aGY().a(paramIEvent);
        QSt.remove(paramIEvent);
      }
      return;
    }
  }
  
  public abstract q a(T paramT);
  
  public abstract IEvent a(int paramInt, q paramq, T paramT);
  
  public abstract int arZ();
  
  public final void eLa()
  {
    if (this.QSs == 0) {}
    do
    {
      return;
      this.QSs -= 1;
    } while (this.QSs != 0);
    h.aGY().b(arZ(), this);
  }
  
  public final void hfT()
  {
    if (this.QSs == 0) {
      h.aGY().a(arZ(), this);
    }
    this.QSs += 1;
  }
  
  public final void k(T paramT)
  {
    q localq = a(paramT);
    h.aGY().a(localq, 0);
    QSt.put(localq, paramT);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    IEvent localIEvent;
    if (arZ() == paramq.getType())
    {
      localIEvent = (IEvent)QSt.remove(paramq);
      if (localIEvent != null) {}
    }
    else
    {
      return;
    }
    oa localoa = new oa();
    localoa.fMO.fMP = a(paramInt2, paramq, localIEvent);
    localoa.fMO.errType = paramInt1;
    localoa.fMO.errCode = paramInt2;
    localoa.fMO.errMsg = paramString;
    EventCenter.instance.publish(localoa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.c
 * JD-Core Version:    0.7.0.1
 */