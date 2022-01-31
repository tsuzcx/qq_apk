package com.tencent.mm.plugin.webview.luggage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.am;

class LuggageMMLocalResourceProvider$GetLocalResourceInfoTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetLocalResourceInfoTask> CREATOR = new LuggageMMLocalResourceProvider.GetLocalResourceInfoTask.1();
  String bMB;
  Runnable ghz;
  int infoType;
  String path;
  
  public final void Zu()
  {
    switch (this.infoType)
    {
    }
    for (;;)
    {
      ahI();
      return;
      this.path = am.Sp(this.bMB);
      this.path = am.Sq(this.bMB);
    }
  }
  
  public final void Zv()
  {
    if (this.ghz != null) {
      this.ghz.run();
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.bMB = paramParcel.readString();
    this.infoType = paramParcel.readInt();
    this.path = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bMB);
    paramParcel.writeInt(this.infoType);
    paramParcel.writeString(this.path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider.GetLocalResourceInfoTask
 * JD-Core Version:    0.7.0.1
 */