package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  private static LinkedList<WeakReference<a>> AEO;
  
  static
  {
    AppMethodBeat.i(107977);
    AEO = new LinkedList();
    AppMethodBeat.o(107977);
  }
  
  public static void K(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(107976);
    if (AEO.size() <= 0)
    {
      ab.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(107976);
      return;
    }
    a locala = (a)((WeakReference)AEO.get(0)).get();
    if (locala == null)
    {
      ab.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(107976);
      return;
    }
    locala.onSettle(paramBoolean, paramInt);
    ab.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), locala });
    AppMethodBeat.o(107976);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(107973);
    ab.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", new Object[] { Integer.valueOf(AEO.size()), parama });
    parama = new WeakReference(parama);
    AEO.add(0, parama);
    AppMethodBeat.o(107973);
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(107974);
    int j = AEO.size();
    ab.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", new Object[] { Integer.valueOf(j), parama });
    if (parama == null)
    {
      AppMethodBeat.o(107974);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    for (;;)
    {
      if (i < AEO.size())
      {
        if (parama == ((WeakReference)AEO.get(i)).get())
        {
          AEO.remove(i);
          ab.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        if ((parama.forceRemoveNoMatchOnPath()) || (localLinkedList.size() != j)) {
          break;
        }
        ab.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        AppMethodBeat.o(107974);
        return false;
      }
      localLinkedList.add(0, Integer.valueOf(i));
      i += 1;
    }
    Iterator localIterator = localLinkedList.iterator();
    if (localIterator.hasNext())
    {
      parama = (Integer)localIterator.next();
      parama = (WeakReference)AEO.remove(parama.intValue());
      if (parama != null) {}
      for (parama = parama.get();; parama = "NULL-CALLBACK")
      {
        ab.d("MicroMsg.SwipeBackHelper", "popCallback, popup %s", new Object[] { parama });
        break;
      }
    }
    boolean bool = localLinkedList.isEmpty();
    AppMethodBeat.o(107974);
    return bool;
  }
  
  public static void by(float paramFloat)
  {
    AppMethodBeat.i(107975);
    if (AEO.size() <= 0)
    {
      ab.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(107975);
      return;
    }
    a locala = (a)((WeakReference)AEO.get(0)).get();
    if (locala == null)
    {
      ab.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(107975);
      return;
    }
    locala.onSwipe(paramFloat);
    ab.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", new Object[] { Float.valueOf(paramFloat), locala });
    AppMethodBeat.o(107975);
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