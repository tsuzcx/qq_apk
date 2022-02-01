package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.ipc.c;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class LuggageUploadMediaFileManager
{
  private static ProgressDialog iXX = null;
  public g PPn;
  public String PST;
  public boolean PSU;
  public b PSV;
  public String mAppId;
  public MMActivity tzD;
  
  final void gVi()
  {
    AppMethodBeat.i(78666);
    if (this.PPn.gUx() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("close_window_confirm_dialog_switch", true);
      localBundle.putString("close_window_confirm_dialog_title_cn", this.tzD.getString(c.i.webview_jssdk_video_uploading_tips));
      localBundle.putString("close_window_confirm_dialog_title_eng", this.tzD.getString(c.i.webview_jssdk_video_uploading_tips));
      localBundle.putString("close_window_confirm_dialog_ok_cn", this.tzD.getString(c.i.webview_jssdk_upload_video_cancel));
      localBundle.putString("close_window_confirm_dialog_ok_eng", this.tzD.getString(c.i.webview_jssdk_upload_video_cancel));
      localBundle.putString("close_window_confirm_dialog_cancel_cn", this.tzD.getString(c.i.webview_jssdk_upload_video_continue));
      localBundle.putString("close_window_confirm_dialog_cancel_eng", this.tzD.getString(c.i.webview_jssdk_upload_video_continue));
      this.PPn.gUx().setCloseWindowConfirmInfo(localBundle);
    }
    gVj();
    AppMethodBeat.o(78666);
  }
  
  final void gVj()
  {
    AppMethodBeat.i(78667);
    if (this.PSU)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("local_id", this.PST);
      ((Bundle)localObject).putString("app_id", this.mAppId);
      ((Bundle)localObject).putBoolean("show_progress_tips", this.PSU);
      b.a(this.tzD, (Bundle)localObject, c.class, new com.tencent.mm.plugin.webview.luggage.ipc.a()
      {
        public final void C(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(78646);
          if (paramAnonymousBundle != null)
          {
            HashMap localHashMap = new HashMap();
            String str = paramAnonymousBundle.getString("media_id");
            paramAnonymousBundle = paramAnonymousBundle.getString("media_url");
            localHashMap.put("serverId", Util.nullAsNil(str));
            localHashMap.put("mediaUrl", Util.nullAsNil(paramAnonymousBundle));
            LuggageUploadMediaFileManager.this.PSV.b(true, localHashMap);
            AppMethodBeat.o(78646);
            return;
          }
          LuggageUploadMediaFileManager.this.PSV.b(false, null);
          AppMethodBeat.o(78646);
        }
      });
      AppMethodBeat.o(78667);
      return;
    }
    Object localObject = new UploadMediaFileTask();
    ((UploadMediaFileTask)localObject).PTf = this.PST;
    ((UploadMediaFileTask)localObject).appId = this.mAppId;
    ((UploadMediaFileTask)localObject).otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78647);
        this.PSX.bPk();
        LuggageUploadMediaFileManager.b(LuggageUploadMediaFileManager.this);
        if (this.PSX.success)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("serverId", Util.nullAsNil(this.PSX.mediaId));
          localHashMap.put("mediaUrl", Util.nullAsNil(this.PSX.mediaUrl));
          LuggageUploadMediaFileManager.this.PSV.b(true, localHashMap);
          AppMethodBeat.o(78647);
          return;
        }
        LuggageUploadMediaFileManager.this.PSV.b(false, null);
        AppMethodBeat.o(78647);
      }
    };
    ((UploadMediaFileTask)localObject).bsM();
    AppMethodBeat.o(78667);
  }
  
  public static class UploadMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<UploadMediaFileTask> CREATOR;
    private LuggageUploadMediaFileManager.a PTc;
    public String PTf;
    public String appId;
    public String mediaId;
    public String mediaUrl;
    public Runnable otv;
    public boolean success;
    
    static
    {
      AppMethodBeat.i(78665);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(78665);
    }
    
    public UploadMediaFileTask() {}
    
    private UploadMediaFileTask(Parcel paramParcel)
    {
      AppMethodBeat.i(78663);
      f(paramParcel);
      AppMethodBeat.o(78663);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(78659);
      Log.i("MicroMsg.UploadMediaTask", "runInMainProcess");
      if (this.PTc == null) {
        this.PTc = new LuggageUploadMediaFileManager.a()
        {
          public final void j(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(78657);
            Log.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.success = paramAnonymousBoolean;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.mediaId = paramAnonymousString1;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.mediaUrl = paramAnonymousString2;
            LuggageUploadMediaFileManager.UploadMediaFileTask.a(LuggageUploadMediaFileManager.UploadMediaFileTask.this);
            AppMethodBeat.o(78657);
          }
        };
      }
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = f.gWt().bkI(this.PTf);
      if (localWebViewJSSDKFileItem == null)
      {
        bPt();
        AppMethodBeat.o(78659);
        return;
      }
      switch (localWebViewJSSDKFileItem.mediaType)
      {
      case 2: 
      case 3: 
      default: 
        LuggageUploadMediaFileManager.a(MMApplicationContext.getContext(), this.appId, this.PTf, com.tencent.mm.i.a.iUd, false, this.PTc);
        AppMethodBeat.o(78659);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(MMApplicationContext.getContext(), localWebViewJSSDKFileItem, this.appId, this.PTf, com.tencent.mm.i.a.iUc, false, this.PTc);
        AppMethodBeat.o(78659);
        return;
      }
      LuggageUploadMediaFileManager.a(MMApplicationContext.getContext(), this.appId, this.PTf, com.tencent.mm.i.a.iUd, false, this.PTc);
      AppMethodBeat.o(78659);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(78660);
      if (this.otv != null) {
        this.otv.run();
      }
      AppMethodBeat.o(78660);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(78661);
      this.PTf = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.mediaId = paramParcel.readString();
      this.mediaUrl = paramParcel.readString();
      if (paramParcel.readByte() == 1) {}
      for (;;)
      {
        this.success = bool;
        AppMethodBeat.o(78661);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(78662);
      paramParcel.writeString(this.PTf);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.mediaId);
      paramParcel.writeString(this.mediaUrl);
      if (this.success) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(78662);
        return;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void j(boolean paramBoolean, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void b(boolean paramBoolean, HashMap<String, Object> paramHashMap);
  }
  
  public static class c
    implements c
  {
    private LuggageUploadMediaFileManager.a PTc;
    private com.tencent.mm.plugin.webview.luggage.ipc.a PTd;
    
    public c()
    {
      AppMethodBeat.i(78655);
      this.PTc = new LuggageUploadMediaFileManager.a()
      {
        public final void j(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(78654);
          if (LuggageUploadMediaFileManager.c.a(LuggageUploadMediaFileManager.c.this) != null)
          {
            if (paramAnonymousBoolean)
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("media_id", paramAnonymousString1);
              localBundle.putString("media_url", paramAnonymousString2);
              LuggageUploadMediaFileManager.c.a(LuggageUploadMediaFileManager.c.this).C(localBundle);
              AppMethodBeat.o(78654);
              return;
            }
            LuggageUploadMediaFileManager.c.a(LuggageUploadMediaFileManager.c.this).C(null);
          }
          AppMethodBeat.o(78654);
        }
      };
      AppMethodBeat.o(78655);
    }
    
    public final void a(Context paramContext, Bundle paramBundle, com.tencent.mm.plugin.webview.luggage.ipc.a parama)
    {
      AppMethodBeat.i(78656);
      this.PTd = parama;
      String str1 = paramBundle.getString("local_id");
      String str2 = paramBundle.getString("app_id");
      boolean bool = paramBundle.getBoolean("show_progress_tips");
      paramBundle = f.gWt().bkI(str1);
      if (paramBundle == null)
      {
        parama.C(null);
        AppMethodBeat.o(78656);
        return;
      }
      switch (paramBundle.mediaType)
      {
      case 2: 
      case 3: 
      default: 
        LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.iUd, bool, this.PTc);
        AppMethodBeat.o(78656);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(paramContext, paramBundle, str2, str1, com.tencent.mm.i.a.iUc, bool, this.PTc);
        AppMethodBeat.o(78656);
        return;
      }
      LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.iUd, bool, this.PTc);
      AppMethodBeat.o(78656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager
 * JD-Core Version:    0.7.0.1
 */