package com.tencent.mm.pluginsdk.event;

import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.pi;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public abstract class IListenerNetScene
  extends IListener<pi>
{
  protected ArrayList<String> XOi = new ArrayList(3);
  
  public IListenerNetScene()
  {
    super(f.hfK, 0);
    this.__eventId = pi.class.getName().hashCode();
  }
  
  public static void a(String paramString, IListenerNetScene paramIListenerNetScene)
  {
    if (!paramIListenerNetScene.XOi.contains(paramString)) {
      paramIListenerNetScene.XOi.add(paramString);
    }
    paramIListenerNetScene.alive();
    b.bpa(paramString);
  }
  
  public static void b(String paramString, IListenerNetScene paramIListenerNetScene)
  {
    b.bpb(paramString);
    paramIListenerNetScene.dead();
    if (paramIListenerNetScene.XOi.contains(paramString)) {
      paramIListenerNetScene.XOi.remove(paramString);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, IEvent paramIEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.event.IListenerNetScene
 * JD-Core Version:    0.7.0.1
 */