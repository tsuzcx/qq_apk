package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  private static LinkedList<WeakReference<a>> HBN;
  
  static
  {
    AppMethodBeat.i(143472);
    HBN = new LinkedList();
    AppMethodBeat.o(143472);
  }
  
  public static void V(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(143471);
    if (HBN.size() <= 0)
    {
      ad.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(143471);
      return;
    }
    a locala = (a)((WeakReference)HBN.get(0)).get();
    if (locala == null)
    {
      ad.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(143471);
      return;
    }
    locala.onSettle(paramBoolean, paramInt);
    ad.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), locala });
    AppMethodBeat.o(143471);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(143468);
    ad.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", new Object[] { Integer.valueOf(HBN.size()), parama });
    parama = new WeakReference(parama);
    HBN.add(0, parama);
    AppMethodBeat.o(143468);
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(143469);
    int j = HBN.size();
    ad.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", new Object[] { Integer.valueOf(j), parama });
    if (parama == null)
    {
      AppMethodBeat.o(143469);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    for (;;)
    {
      if (i < HBN.size())
      {
        if (parama == ((WeakReference)HBN.get(i)).get())
        {
          HBN.remove(i);
          ad.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        if ((parama.forceRemoveNoMatchOnPath()) || (localLinkedList.size() != j)) {
          break;
        }
        ad.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        AppMethodBeat.o(143469);
        return false;
      }
      localLinkedList.add(0, Integer.valueOf(i));
      i += 1;
    }
    Iterator localIterator = localLinkedList.iterator();
    if (localIterator.hasNext())
    {
      parama = (Integer)localIterator.next();
      parama = (WeakReference)HBN.remove(parama.intValue());
      if (parama != null) {}
      for (parama = parama.get();; parama = "NULL-CALLBACK")
      {
        ad.d("MicroMsg.SwipeBackHelper", "popCallback, popup %s", new Object[] { parama });
        break;
      }
    }
    boolean bool = localLinkedList.isEmpty();
    AppMethodBeat.o(143469);
    return bool;
  }
  
  public static void bK(float paramFloat)
  {
    AppMethodBeat.i(143470);
    if (HBN.size() <= 0)
    {
      ad.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(143470);
      return;
    }
    a locala = (a)((WeakReference)HBN.get(0)).get();
    if (locala == null)
    {
      ad.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(143470);
      return;
    }
    locala.onSwipe(paramFloat);
    ad.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", new Object[] { Float.valueOf(paramFloat), locala });
    AppMethodBeat.o(143470);
  }
  
  public static abstract interface a
  {
    public abstract boolean forceRemoveNoMatchOnPath();
    
    public abstract void onSettle(boolean paramBoolean, int paramInt);
    
    public abstract void onSwipe(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */