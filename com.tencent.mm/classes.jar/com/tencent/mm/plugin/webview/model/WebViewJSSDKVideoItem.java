package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WebViewJSSDKVideoItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKVideoItem> CREATOR = new WebViewJSSDKVideoItem.1();
  public int duration;
  public int height;
  public int size;
  public int width;
  
  public WebViewJSSDKVideoItem()
  {
    this.bLN = 4;
  }
  
  protected WebViewJSSDKVideoItem(Parcel paramParcel)
  {
    super(paramParcel);
    this.bLN = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
  }
  
  public final WebViewJSSDKFileItem cbT()
  {
    this.bMB = am.So(this.fMZ);
    return this;
  }
  
  public final String cbU()
  {
    return "mp4";
  }
  
  public final String cbV()
  {
    return "video";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.bLN);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem
 * JD-Core Version:    0.7.0.1
 */