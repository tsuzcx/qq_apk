package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class ResultReceiver
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator() {};
  final boolean iK = false;
  a iL;
  final Handler mHandler = null;
  
  ResultReceiver(Parcel paramParcel)
  {
    this.iL = b.c(paramParcel.readStrongBinder());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle) {}
  
  public final void send(int paramInt, Bundle paramBundle)
  {
    if (this.iK) {
      if (this.mHandler != null) {
        this.mHandler.post(new e(this, paramInt, paramBundle));
      }
    }
    while (this.iL == null)
    {
      return;
      onReceiveResult(paramInt, paramBundle);
      return;
    }
    try
    {
      this.iL.send(paramInt, paramBundle);
      return;
    }
    catch (RemoteException paramBundle) {}
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (this.iL == null) {
        this.iL = new d(this);
      }
      paramParcel.writeStrongBinder(this.iL.asBinder());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * JD-Core Version:    0.7.0.1
 */