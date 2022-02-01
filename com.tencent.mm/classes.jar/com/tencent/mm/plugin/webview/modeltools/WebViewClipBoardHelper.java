package com.tencent.mm.plugin.webview.modeltools;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;

public final class WebViewClipBoardHelper
  implements ClipboardManager.OnPrimaryClipChangedListener
{
  private WeakReference<WebViewUI> CsH;
  private long lastReportTime;
  
  public WebViewClipBoardHelper(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(79200);
    this.lastReportTime = 0L;
    this.CsH = new WeakReference(paramWebViewUI);
    paramWebViewUI = (ClipboardManager)paramWebViewUI.getApplicationContext().getSystemService("clipboard");
    try
    {
      paramWebViewUI.addPrimaryClipChangedListener(this);
      AppMethodBeat.o(79200);
      return;
    }
    catch (Exception paramWebViewUI)
    {
      AppMethodBeat.o(79200);
    }
  }
  
  public final void onPrimaryClipChanged()
  {
    AppMethodBeat.i(79201);
    if (this.CsH.get() == null)
    {
      AppMethodBeat.o(79201);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.lastReportTime < 200L)
    {
      AppMethodBeat.o(79201);
      return;
    }
    this.lastReportTime = l;
    Object localObject = ((ClipboardManager)ai.getContext().getSystemService("clipboard")).getPrimaryClip();
    if (localObject == null)
    {
      AppMethodBeat.o(79201);
      return;
    }
    localObject = ((ClipData)localObject).getItemAt(0);
    if (localObject == null)
    {
      AppMethodBeat.o(79201);
      return;
    }
    ClipBoardDataWrapper localClipBoardDataWrapper = new ClipBoardDataWrapper();
    localClipBoardDataWrapper.url = ((WebViewUI)this.CsH.get()).eyJ();
    if (bs.aj(((ClipData.Item)localObject).getText()))
    {
      ac.w("MicroMsg.WebViewClipBoardHelper", "onPrimaryClipChanged text is null");
      AppMethodBeat.o(79201);
      return;
    }
    localClipBoardDataWrapper.length = ((ClipData.Item)localObject).getText().toString().getBytes(Charset.forName("UTF-8")).length;
    localClipBoardDataWrapper.fromScene = ((WebViewUI)this.CsH.get()).getIntent().getIntExtra("from_scence", 0);
    localClipBoardDataWrapper.username = ((WebViewUI)this.CsH.get()).getIntent().getStringExtra("geta8key_username");
    XIPCInvoker.a("com.tencent.mm", localClipBoardDataWrapper, a.class, null);
    AppMethodBeat.o(79201);
  }
  
  static final class ClipBoardDataWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<ClipBoardDataWrapper> CREATOR;
    int fromScene;
    int length;
    String url;
    String username;
    
    static
    {
      AppMethodBeat.i(79198);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(79198);
    }
    
    ClipBoardDataWrapper() {}
    
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
  
  static final class a
    implements b<WebViewClipBoardHelper.ClipBoardDataWrapper, Object>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper
 * JD-Core Version:    0.7.0.1
 */