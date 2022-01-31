package com.tencent.mm.plugin.webview.modeltools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewClipBoardHelper$ClipBoardDataWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<ClipBoardDataWrapper> CREATOR;
  int fromScene;
  int length;
  String url;
  String username;
  
  static
  {
    AppMethodBeat.i(7017);
    CREATOR = new WebViewClipBoardHelper.ClipBoardDataWrapper.1();
    AppMethodBeat.o(7017);
  }
  
  WebViewClipBoardHelper$ClipBoardDataWrapper() {}
  
  WebViewClipBoardHelper$ClipBoardDataWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(7016);
    this.url = paramParcel.readString();
    this.length = paramParcel.readInt();
    this.fromScene = paramParcel.readInt();
    this.username = paramParcel.readString();
    AppMethodBeat.o(7016);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(7015);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.length);
    paramParcel.writeInt(this.fromScene);
    paramParcel.writeString(this.username);
    AppMethodBeat.o(7015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper.ClipBoardDataWrapper
 * JD-Core Version:    0.7.0.1
 */