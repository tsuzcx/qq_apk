package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.f.a.oa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public abstract class b
  extends IListener<oa>
{
  protected ArrayList<String> QSr = new ArrayList(3);
  
  public b()
  {
    super(0);
    this.__eventId = oa.class.getName().hashCode();
  }
  
  public static void a(String paramString, b paramb)
  {
    if (!paramb.QSr.contains(paramString)) {
      paramb.QSr.add(paramString);
    }
    EventCenter.instance.addListener(paramb);
    e.bpg(paramString);
  }
  
  public static void b(String paramString, b paramb)
  {
    e.bph(paramString);
    EventCenter.instance.removeListener(paramb);
    if (paramb.QSr.contains(paramString)) {
      paramb.QSr.remove(paramString);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, IEvent paramIEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.b
 * JD-Core Version:    0.7.0.1
 */