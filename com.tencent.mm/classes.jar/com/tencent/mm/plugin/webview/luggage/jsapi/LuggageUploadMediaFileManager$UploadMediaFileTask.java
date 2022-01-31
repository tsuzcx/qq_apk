package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public class LuggageUploadMediaFileManager$UploadMediaFileTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UploadMediaFileTask> CREATOR = new LuggageUploadMediaFileManager.UploadMediaFileTask.2();
  public String appId;
  public String bUi;
  public Runnable gfD;
  private LuggageUploadMediaFileManager.a reh;
  public String rek;
  public String rel;
  public boolean success;
  
  public LuggageUploadMediaFileManager$UploadMediaFileTask() {}
  
  private LuggageUploadMediaFileManager$UploadMediaFileTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.UploadMediaTask", "runInMainProcess");
    if (this.reh == null) {
      this.reh = new LuggageUploadMediaFileManager.a()
      {
        public final void c(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
        {
          y.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
          LuggageUploadMediaFileManager.UploadMediaFileTask.this.success = paramAnonymousBoolean;
          LuggageUploadMediaFileManager.UploadMediaFileTask.this.bUi = paramAnonymousString1;
          LuggageUploadMediaFileManager.UploadMediaFileTask.this.rel = paramAnonymousString2;
          LuggageUploadMediaFileManager.UploadMediaFileTask.a(LuggageUploadMediaFileManager.UploadMediaFileTask.this);
        }
      };
    }
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.ccL().Sl(this.rek);
    if (localWebViewJSSDKFileItem == null)
    {
      ahI();
      return;
    }
    switch (localWebViewJSSDKFileItem.bLN)
    {
    case 2: 
    case 3: 
    default: 
      LuggageUploadMediaFileManager.a(ae.getContext(), this.appId, this.rek, a.dls, false, this.reh);
      return;
    case 1: 
      LuggageUploadMediaFileManager.a(ae.getContext(), localWebViewJSSDKFileItem, this.appId, this.rek, a.dlr, false, this.reh);
      return;
    }
    LuggageUploadMediaFileManager.a(ae.getContext(), this.appId, this.rek, a.dls, false, this.reh);
  }
  
  public final void Zv()
  {
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.rek = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.bUi = paramParcel.readString();
    this.rel = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.success = bool;
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.rek);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.bUi);
    paramParcel.writeString(this.rel);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.UploadMediaFileTask
 * JD-Core Version:    0.7.0.1
 */