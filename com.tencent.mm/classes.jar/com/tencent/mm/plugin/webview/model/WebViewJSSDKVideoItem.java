package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebViewJSSDKVideoItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKVideoItem> CREATOR;
  public int duration;
  
  static
  {
    AppMethodBeat.i(6731);
    CREATOR = new WebViewJSSDKVideoItem.1();
    AppMethodBeat.o(6731);
  }
  
  public WebViewJSSDKVideoItem()
  {
    this.cth = 4;
  }
  
  protected WebViewJSSDKVideoItem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(6729);
    this.duration = paramParcel.readInt();
    AppMethodBeat.o(6729);
  }
  
  public final WebViewJSSDKFileItem dca()
  {
    AppMethodBeat.i(6728);
    this.ctV = ar.ahn(this.hgj);
    AppMethodBeat.o(6728);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String dyR()
  {
    return "mp4";
  }
  
  public final String dzk()
  {
    return "video";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(6730);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.duration);
    AppMethodBeat.o(6730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem
 * JD-Core Version:    0.7.0.1
 */