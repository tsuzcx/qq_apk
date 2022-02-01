package com.tencent.mm.pluginsdk.event;

import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.od;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public abstract class IListenerMStorage
  extends IListener<od>
{
  protected ArrayList<String> XOi = new ArrayList(3);
  
  public IListenerMStorage()
  {
    super(f.hfK);
    this.__eventId = od.class.getName().hashCode();
  }
  
  public static void a(String paramString, IListenerMStorage paramIListenerMStorage)
  {
    if (!paramIListenerMStorage.XOi.contains(paramString)) {
      paramIListenerMStorage.XOi.add(paramString);
    }
    paramIListenerMStorage.alive();
    b.bpa(paramString);
  }
  
  public static void b(String paramString, IListenerMStorage paramIListenerMStorage)
  {
    b.bpb(paramString);
    paramIListenerMStorage.dead();
    if (paramIListenerMStorage.XOi.contains(paramString)) {
      paramIListenerMStorage.XOi.remove(paramString);
    }
  }
  
  public abstract void g(IEvent paramIEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.event.IListenerMStorage
 * JD-Core Version:    0.7.0.1
 */