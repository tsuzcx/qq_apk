package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;

public abstract class WepkgMainProcessTask
  implements Parcelable
{
  private static final Set<Object> hwm = new HashSet();
  Messenger hwC;
  int mTaskId;
  
  public final void aBj()
  {
    hwm.add(this);
  }
  
  public final void aBk()
  {
    hwm.remove(this);
  }
  
  public abstract void ata();
  
  public void atb() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void f(Parcel paramParcel) {}
  
  public final void tU()
  {
    if (this.hwC == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = this.mTaskId;
    localMessage.setData(WepkgMainProcessService.c(this));
    try
    {
      this.hwC.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Wepkg.WepkgMainProcessTask", localException.getMessage());
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask
 * JD-Core Version:    0.7.0.1
 */