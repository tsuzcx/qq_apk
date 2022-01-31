package com.tencent.mm.ui.widget;

import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  private static LinkedList<WeakReference<a>> wkW = new LinkedList();
  
  public static void C(boolean paramBoolean, int paramInt)
  {
    if (wkW.size() <= 0)
    {
      y.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      return;
    }
    a locala = (a)((WeakReference)wkW.get(0)).get();
    if (locala == null)
    {
      y.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      return;
    }
    locala.onSettle(paramBoolean, paramInt);
    y.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), locala });
  }
  
  public static void a(a parama)
  {
    y.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", new Object[] { Integer.valueOf(wkW.size()), parama });
    parama = new WeakReference(parama);
    wkW.add(0, parama);
  }
  
  public static void aN(float paramFloat)
  {
    if (wkW.size() <= 0)
    {
      y.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      return;
    }
    a locala = (a)((WeakReference)wkW.get(0)).get();
    if (locala == null)
    {
      y.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      return;
    }
    locala.onSwipe(paramFloat);
    y.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", new Object[] { Float.valueOf(paramFloat), locala });
  }
  
  public static boolean b(a parama)
  {
    int j = wkW.size();
    y.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", new Object[] { Integer.valueOf(j), parama });
    if (parama == null) {
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    for (;;)
    {
      if (i < wkW.size())
      {
        if (parama == ((WeakReference)wkW.get(i)).get())
        {
          wkW.remove(i);
          y.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        if ((parama.forceRemoveNoMatchOnPath()) || (localLinkedList.size() != j)) {
          break;
        }
        y.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        return false;
      }
      localLinkedList.add(0, Integer.valueOf(i));
      i += 1;
    }
    Iterator localIterator = localLinkedList.iterator();
    if (localIterator.hasNext())
    {
      parama = (Integer)localIterator.next();
      parama = (WeakReference)wkW.remove(parama.intValue());
      if (parama != null) {}
      for (parama = parama.get();; parama = "NULL-CALLBACK")
      {
        y.d("MicroMsg.SwipeBackHelper", "popCallback, popup %s", new Object[] { parama });
        break;
      }
    }
    return localLinkedList.isEmpty();
  }
  
  public static abstract interface a
  {
    public abstract boolean forceRemoveNoMatchOnPath();
    
    public abstract void onSettle(boolean paramBoolean, int paramInt);
    
    public abstract void onSwipe(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */