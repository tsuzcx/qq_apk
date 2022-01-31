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
    AppMethodBeat.i(6735);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(6735);
  }
  
  public WebViewJSSDKVoiceItem()
  {
    this.cth = 2;
  }
  
  protected WebViewJSSDKVoiceItem(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final WebViewJSSDKFileItem dca()
  {
    AppMethodBeat.i(6733);
    this.hgj = s.getFullPath(this.fileName);
    this.ctV = ar.ahn(this.hgj);
    AppMethodBeat.o(6733);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String dyR()
  {
    return "speex";
  }
  
  public final String dzk()
  {
    return "voice";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(6734);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(6734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKVoiceItem
 * JD-Core Version:    0.7.0.1
 */