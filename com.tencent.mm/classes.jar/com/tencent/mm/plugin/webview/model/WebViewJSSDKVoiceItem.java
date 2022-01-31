package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelvoice.q;

public class WebViewJSSDKVoiceItem
  extends WebViewJSSDKFileItem
{
  public static final Parcelable.Creator<WebViewJSSDKVoiceItem> CREATOR = new Parcelable.Creator() {};
  
  public WebViewJSSDKVoiceItem()
  {
    this.bLN = 2;
  }
  
  protected WebViewJSSDKVoiceItem(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final WebViewJSSDKFileItem cbT()
  {
    this.fMZ = q.getFullPath(this.fileName);
    this.bMB = am.So(this.fMZ);
    return this;
  }
  
  public final String cbU()
  {
    return "speex";
  }
  
  public final String cbV()
  {
    return "voice";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKVoiceItem
 * JD-Core Version:    0.7.0.1
 */