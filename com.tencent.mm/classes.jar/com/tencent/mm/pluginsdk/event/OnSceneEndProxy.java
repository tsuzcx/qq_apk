package com.tencent.mm.pluginsdk.event;

import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.pi;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class OnSceneEndProxy<T extends IEvent>
  extends IListener<T>
  implements com.tencent.mm.am.h
{
  private static HashMap<p, IEvent> XOk = new HashMap();
  private static HashMap<IEvent, OnSceneEndProxy<? extends IEvent>> djU = new HashMap();
  private int XOj = 0;
  
  public OnSceneEndProxy()
  {
    super(f.hfK);
  }
  
  public static void j(IEvent paramIEvent)
  {
    Iterator localIterator = XOk.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (localEntry.getValue() != paramIEvent);
    for (paramIEvent = (p)localEntry.getKey();; paramIEvent = null)
    {
      if (paramIEvent != null)
      {
        com.tencent.mm.kernel.h.aZW().a(paramIEvent);
        XOk.remove(paramIEvent);
      }
      return;
    }
  }
  
  public abstract p a(T paramT);
  
  public abstract IEvent a(int paramInt, p paramp, T paramT);
  
  public abstract int aLV();
  
  public final void fSX()
  {
    if (this.XOj == 0) {}
    do
    {
      return;
      this.XOj -= 1;
    } while (this.XOj != 0);
    com.tencent.mm.kernel.h.aZW().b(aLV(), this);
  }
  
  public final void gqq()
  {
    if (this.XOj == 0) {
      com.tencent.mm.kernel.h.aZW().a(aLV(), this);
    }
    this.XOj += 1;
  }
  
  public final void k(T paramT)
  {
    p localp = a(paramT);
    if (localp != null)
    {
      com.tencent.mm.kernel.h.aZW().a(localp, 0);
      XOk.put(localp, paramT);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    IEvent localIEvent;
    if (aLV() == paramp.getType())
    {
      localIEvent = (IEvent)XOk.remove(paramp);
      if (localIEvent != null) {}
    }
    else
    {
      return;
    }
    pi localpi = new pi();
    localpi.hSy.hSz = a(paramInt2, paramp, localIEvent);
    localpi.hSy.errType = paramInt1;
    localpi.hSy.errCode = paramInt2;
    localpi.hSy.errMsg = paramString;
    localpi.publish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.event.OnSceneEndProxy
 * JD-Core Version:    0.7.0.1
 */