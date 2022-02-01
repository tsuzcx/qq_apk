package com.tencent.mm.plugin.webview.modeltools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import java.lang.ref.WeakReference;

public final class WebViewClipBoardHelper
{
  public WeakReference<WebViewUI> WOf;
  public long lastReportTime;
  
  public WebViewClipBoardHelper(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(79200);
    this.lastReportTime = 0L;
    this.WOf = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(79200);
  }
  
  public static final class ClipBoardDataWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<ClipBoardDataWrapper> CREATOR;
    public int fromScene;
    public int length;
    public String url;
    public String username;
    
    static
    {
      AppMethodBeat.i(79198);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(79198);
    }
    
    public ClipBoardDataWrapper() {}
    
    ClipBoardDataWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(79197);
      this.url = paramParcel.readString();
      this.length = paramParcel.readInt();
      this.fromScene = paramParcel.readInt();
      this.username = paramParcel.readString();
      AppMethodBeat.o(79197);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(79196);
      paramParcel.writeString(this.url);
      paramParcel.writeInt(this.length);
      paramParcel.writeInt(this.fromScene);
      paramParcel.writeString(this.username);
      AppMethodBeat.o(79196);
    }
  }
  
  @a
  public static final class a
    implements d<WebViewClipBoardHelper.ClipBoardDataWrapper, Object>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper
 * JD-Core Version:    0.7.0.1
 */