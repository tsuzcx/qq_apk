package com.tencent.mm.plugin.webview.modeltools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class WebViewClipBoardHelper$ClipBoardDataWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<ClipBoardDataWrapper> CREATOR = new WebViewClipBoardHelper.ClipBoardDataWrapper.1();
  int fromScene;
  int length;
  String url;
  String username;
  
  WebViewClipBoardHelper$ClipBoardDataWrapper() {}
  
  WebViewClipBoardHelper$ClipBoardDataWrapper(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.length = paramParcel.readInt();
    this.fromScene = paramParcel.readInt();
    this.username = paramParcel.readString();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.length);
    paramParcel.writeInt(this.fromScene);
    paramParcel.writeString(this.username);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper.ClipBoardDataWrapper
 * JD-Core Version:    0.7.0.1
 */