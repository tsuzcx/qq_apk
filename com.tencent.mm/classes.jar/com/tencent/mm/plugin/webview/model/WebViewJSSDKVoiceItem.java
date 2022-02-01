package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.s;

public class WebViewJSSDKVoiceItem
  extends WebViewJSSDKFileItem
{
  public static final Parcelable.Creator<WebViewJSSDKVoiceItem> CREATOR;
  
  static
  {
    AppMethodBeat.i(79028);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(79028);
  }
  
  public WebViewJSSDKVoiceItem()
  {
    this.mediaType = 2;
  }
  
  protected WebViewJSSDKVoiceItem(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileType()
  {
    return "voice";
  }
  
  public final WebViewJSSDKFileItem kLS()
  {
    AppMethodBeat.i(79026);
    this.qUK = s.getFullPath(this.fileName);
    this.hHB = az.bkB(this.qUK);
    AppMethodBeat.o(79026);
    return this;
  }
  
  public final String kLT()
  {
    return "speex";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79027);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(79027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKVoiceItem
 * JD-Core Version:    0.7.0.1
 */