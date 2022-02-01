package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.f.a.mw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

public abstract class d
  implements MStorage.IOnStorageChange
{
  public int QSs = 0;
  
  public final void OO()
  {
    if (this.QSs == 0)
    {
      MStorage localMStorage = evj();
      if (localMStorage != null) {
        localMStorage.add(this);
      }
    }
    this.QSs += 1;
  }
  
  public abstract IEvent aIL(String paramString);
  
  public abstract MStorage evj();
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    paramMStorageEventData = new mw();
    paramMStorageEventData.fLd.fLe = aIL(paramString);
    EventCenter.instance.publish(paramMStorageEventData);
  }
  
  public final void unregister()
  {
    if (this.QSs == 0) {}
    MStorage localMStorage;
    do
    {
      do
      {
        return;
        this.QSs -= 1;
      } while (this.QSs != 0);
      localMStorage = evj();
    } while (localMStorage == null);
    localMStorage.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.d
 * JD-Core Version:    0.7.0.1
 */