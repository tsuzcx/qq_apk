package com.tencent.mm.plugin.webview.ui.tools;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.plugin.webview.stub.f.a;

public class WebViewStubCallbackWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewStubCallbackWrapper> CREATOR;
  public f WWL;
  public int id;
  
  static
  {
    AppMethodBeat.i(80038);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(80038);
  }
  
  private WebViewStubCallbackWrapper(IBinder paramIBinder)
  {
    AppMethodBeat.i(80037);
    this.WWL = f.a.R(paramIBinder);
    AppMethodBeat.o(80037);
  }
  
  public WebViewStubCallbackWrapper(f paramf, int paramInt)
  {
    this.WWL = paramf;
    this.id = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof WebViewStubCallbackWrapper)) {}
    while (((WebViewStubCallbackWrapper)paramObject).id != this.id) {
      return false;
    }
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(80036);
    paramParcel.writeStrongBinder(this.WWL.asBinder());
    AppMethodBeat.o(80036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */