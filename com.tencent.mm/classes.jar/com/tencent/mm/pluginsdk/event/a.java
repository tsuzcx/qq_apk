package com.tencent.mm.pluginsdk.event;

import com.tencent.mm.autogen.a.od;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

public abstract class a
  implements MStorage.IOnStorageChange
{
  public int XOj = 0;
  
  public abstract IEvent aFl(String paramString);
  
  public final void aoW()
  {
    if (this.XOj == 0)
    {
      MStorage localMStorage = fCc();
      if (localMStorage != null) {
        localMStorage.add(this);
      }
    }
    this.XOj += 1;
  }
  
  public abstract MStorage fCc();
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    paramMStorageEventData = new od();
    paramMStorageEventData.hQK.hQL = aFl(paramString);
    paramMStorageEventData.publish();
  }
  
  public final void unregister()
  {
    if (this.XOj == 0) {}
    MStorage localMStorage;
    do
    {
      do
      {
        return;
        this.XOj -= 1;
      } while (this.XOj != 0);
      localMStorage = fCc();
    } while (localMStorage == null);
    localMStorage.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.event.a
 * JD-Core Version:    0.7.0.1
 */