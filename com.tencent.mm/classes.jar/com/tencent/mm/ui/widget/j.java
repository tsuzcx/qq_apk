package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<WeakReference<a>> jRe;
  
  static
  {
    AppMethodBeat.i(143472);
    jRe = new LinkedList();
    AppMethodBeat.o(143472);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(143468);
    Log.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", new Object[] { Integer.valueOf(jRe.size()), parama });
    parama = new WeakReference(parama);
    jRe.add(0, parama);
    AppMethodBeat.o(143468);
  }
  
  public static void ap(float paramFloat)
  {
    AppMethodBeat.i(143470);
    if (jRe.size() <= 0)
    {
      Log.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(143470);
      return;
    }
    a locala = (a)((WeakReference)jRe.get(0)).get();
    if (locala == null)
    {
      Log.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(143470);
      return;
    }
    locala.onSwipe(paramFloat);
    Log.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", new Object[] { Float.valueOf(paramFloat), locala });
    AppMethodBeat.o(143470);
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(143469);
    int j = jRe.size();
    Log.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", new Object[] { Integer.valueOf(j), parama });
    if (parama == null)
    {
      AppMethodBeat.o(143469);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    for (;;)
    {
      if (i < jRe.size())
      {
        if (parama == ((WeakReference)jRe.get(i)).get())
        {
          jRe.remove(i);
          Log.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        if ((parama.forceRemoveNoMatchOnPath()) || (localLinkedList.size() != j)) {
          break;
        }
        Log.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
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
      parama = (WeakReference)jRe.remove(parama.intValue());
      if (parama != null) {}
      for (parama = parama.get();; parama = "NULL-CALLBACK")
      {
        Log.d("MicroMsg.SwipeBackHelper", "popCallback, popup %s", new Object[] { parama });
        break;
      }
    }
    boolean bool = localLinkedList.isEmpty();
    AppMethodBeat.o(143469);
    return bool;
  }
  
  public static void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(143471);
    if (jRe.size() <= 0)
    {
      Log.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(143471);
      return;
    }
    a locala = (a)((WeakReference)jRe.get(0)).get();
    if (locala == null)
    {
      Log.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(143471);
      return;
    }
    locala.onSettle(paramBoolean, paramInt);
    Log.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), locala });
    AppMethodBeat.o(143471);
  }
  
  public static abstract interface a
  {
    public abstract boolean forceRemoveNoMatchOnPath();
    
    public abstract void onSettle(boolean paramBoolean, int paramInt);
    
    public abstract void onSwipe(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */