package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;

public abstract class WepkgMainProcessTask
  implements Parcelable
{
  private static final Set<Object> gem = new HashSet();
  Messenger geD;
  int mTaskId;
  
  public abstract void Zu();
  
  public void Zv() {}
  
  public final void ahC()
  {
    gem.add(this);
  }
  
  public final void ahD()
  {
    gem.remove(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(Parcel paramParcel) {}
  
  public final void pQ()
  {
    if (this.geD == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = this.mTaskId;
    localMessage.setData(WepkgMainProcessService.c(this));
    try
    {
      this.geD.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Wepkg.WepkgMainProcessTask", localException.getMessage());
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask
 * JD-Core Version:    0.7.0.1
 */