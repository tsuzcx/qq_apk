package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.f.a.mw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public abstract class a
  extends IListener<mw>
{
  protected ArrayList<String> QSr = new ArrayList(3);
  
  public a()
  {
    this.__eventId = mw.class.getName().hashCode();
  }
  
  public static void a(String paramString, a parama)
  {
    if (!parama.QSr.contains(paramString)) {
      parama.QSr.add(paramString);
    }
    EventCenter.instance.addListener(parama);
    e.bpg(paramString);
  }
  
  public static void b(String paramString, a parama)
  {
    e.bph(paramString);
    EventCenter.instance.removeListener(parama);
    if (parama.QSr.contains(paramString)) {
      parama.QSr.remove(paramString);
    }
  }
  
  public abstract void g(IEvent paramIEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a
 * JD-Core Version:    0.7.0.1
 */