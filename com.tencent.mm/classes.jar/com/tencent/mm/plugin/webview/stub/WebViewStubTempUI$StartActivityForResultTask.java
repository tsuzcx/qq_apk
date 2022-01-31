package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class WebViewStubTempUI$StartActivityForResultTask
  implements Parcelable
{
  public static final Parcelable.Creator<StartActivityForResultTask> CREATOR = new Parcelable.Creator() {};
  int bQU;
  String nQb;
  int rhg;
  String rkt;
  Intent rku;
  boolean rkv;
  
  WebViewStubTempUI$StartActivityForResultTask() {}
  
  WebViewStubTempUI$StartActivityForResultTask(Parcel paramParcel)
  {
    this.nQb = paramParcel.readString();
    this.rkt = paramParcel.readString();
    this.rku = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    this.bQU = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.rkv = bool;
      this.rhg = paramParcel.readInt();
      return;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.nQb);
    paramParcel.writeString(this.rkt);
    paramParcel.writeParcelable(this.rku, paramInt);
    paramParcel.writeInt(this.bQU);
    if (this.rkv) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.rhg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.StartActivityForResultTask
 * JD-Core Version:    0.7.0.1
 */