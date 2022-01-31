package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask
  implements Parcelable
{
  private static final Set<Object> geC = new HashSet();
  Messenger geD;
  String gep = Process.myPid() + hashCode();
  
  public abstract void Zu();
  
  public void Zv() {}
  
  public final void ahC()
  {
    geC.add(this);
  }
  
  public final void ahD()
  {
    geC.remove(this);
  }
  
  public final boolean ahI()
  {
    if (this.geD == null) {
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.setData(LuggageMainProcessService.a(this, false));
    try
    {
      this.geD.send(localMessage);
      return true;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MainProcessTask", localException.getMessage());
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask
 * JD-Core Version:    0.7.0.1
 */