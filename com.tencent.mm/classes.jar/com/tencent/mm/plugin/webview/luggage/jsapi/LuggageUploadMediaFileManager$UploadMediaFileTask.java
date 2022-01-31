package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class LuggageUploadMediaFileManager$UploadMediaFileTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UploadMediaFileTask> CREATOR;
  public String appId;
  public String cBO;
  public Runnable hxp;
  public boolean success;
  private LuggageUploadMediaFileManager.a uUj;
  public String uUm;
  public String uUn;
  
  static
  {
    AppMethodBeat.i(6413);
    CREATOR = new LuggageUploadMediaFileManager.UploadMediaFileTask.2();
    AppMethodBeat.o(6413);
  }
  
  public LuggageUploadMediaFileManager$UploadMediaFileTask() {}
  
  private LuggageUploadMediaFileManager$UploadMediaFileTask(Parcel paramParcel)
  {
    AppMethodBeat.i(6411);
    f(paramParcel);
    AppMethodBeat.o(6411);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(6407);
    ab.i("MicroMsg.UploadMediaTask", "runInMainProcess");
    if (this.uUj == null) {
      this.uUj = new LuggageUploadMediaFileManager.a()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(6405);
          ab.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
          LuggageUploadMediaFileManager.UploadMediaFileTask.this.success = paramAnonymousBoolean;
          LuggageUploadMediaFileManager.UploadMediaFileTask.this.cBO = paramAnonymousString1;
          LuggageUploadMediaFileManager.UploadMediaFileTask.this.uUn = paramAnonymousString2;
          LuggageUploadMediaFileManager.UploadMediaFileTask.a(LuggageUploadMediaFileManager.UploadMediaFileTask.this);
          AppMethodBeat.o(6405);
        }
      };
    }
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.dcE().ahh(this.uUm);
    if (localWebViewJSSDKFileItem == null)
    {
      aBp();
      AppMethodBeat.o(6407);
      return;
    }
    switch (localWebViewJSSDKFileItem.cth)
    {
    case 2: 
    case 3: 
    default: 
      LuggageUploadMediaFileManager.a(ah.getContext(), this.appId, this.uUm, a.ecN, false, this.uUj);
      AppMethodBeat.o(6407);
      return;
    case 1: 
      LuggageUploadMediaFileManager.a(ah.getContext(), localWebViewJSSDKFileItem, this.appId, this.uUm, a.ecM, false, this.uUj);
      AppMethodBeat.o(6407);
      return;
    }
    LuggageUploadMediaFileManager.a(ah.getContext(), this.appId, this.uUm, a.ecN, false, this.uUj);
    AppMethodBeat.o(6407);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(6408);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(6408);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(6409);
    this.uUm = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.cBO = paramParcel.readString();
    this.uUn = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.success = bool;
      AppMethodBeat.o(6409);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(6410);
    paramParcel.writeString(this.uUm);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.cBO);
    paramParcel.writeString(this.uUn);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(6410);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.UploadMediaFileTask
 * JD-Core Version:    0.7.0.1
 */