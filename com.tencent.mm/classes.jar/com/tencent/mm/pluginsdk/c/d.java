package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.me;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

public abstract class d
  implements MStorage.IOnStorageChange
{
  public int JTn = 0;
  
  public final void LW()
  {
    if (this.JTn == 0)
    {
      MStorage localMStorage = dSG();
      if (localMStorage != null) {
        localMStorage.add(this);
      }
    }
    this.JTn += 1;
  }
  
  public abstract IEvent azl(String paramString);
  
  public abstract MStorage dSG();
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    paramMStorageEventData = new me();
    paramMStorageEventData.dRE.dRF = azl(paramString);
    EventCenter.instance.publish(paramMStorageEventData);
  }
  
  public final void unregister()
  {
    if (this.JTn == 0) {}
    MStorage localMStorage;
    do
    {
      do
      {
        return;
        this.JTn -= 1;
      } while (this.JTn != 0);
      localMStorage = dSG();
    } while (localMStorage == null);
    localMStorage.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.d
 * JD-Core Version:    0.7.0.1
 */