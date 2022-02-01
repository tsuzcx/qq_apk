package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.me;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public abstract class a
  extends IListener<me>
{
  protected ArrayList<String> JTm = new ArrayList(3);
  
  public a()
  {
    this.__eventId = me.class.getName().hashCode();
  }
  
  public static void a(String paramString, a parama)
  {
    if (!parama.JTm.contains(paramString)) {
      parama.JTm.add(paramString);
    }
    EventCenter.instance.addListener(parama);
    e.bdh(paramString);
  }
  
  public static void b(String paramString, a parama)
  {
    e.bdi(paramString);
    EventCenter.instance.removeListener(parama);
    if (parama.JTm.contains(paramString)) {
      parama.JTm.remove(paramString);
    }
  }
  
  public abstract void g(IEvent paramIEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.a
 * JD-Core Version:    0.7.0.1
 */