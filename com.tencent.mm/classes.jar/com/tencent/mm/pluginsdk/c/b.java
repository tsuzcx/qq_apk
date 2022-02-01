package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.ni;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public abstract class b
  extends IListener<ni>
{
  protected ArrayList<String> JTm = new ArrayList(3);
  
  public b()
  {
    super(0);
    this.__eventId = ni.class.getName().hashCode();
  }
  
  public static void a(String paramString, b paramb)
  {
    if (!paramb.JTm.contains(paramString)) {
      paramb.JTm.add(paramString);
    }
    EventCenter.instance.addListener(paramb);
    e.bdh(paramString);
  }
  
  public static void b(String paramString, b paramb)
  {
    e.bdi(paramString);
    EventCenter.instance.removeListener(paramb);
    if (paramb.JTm.contains(paramString)) {
      paramb.JTm.remove(paramString);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, IEvent paramIEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.b
 * JD-Core Version:    0.7.0.1
 */