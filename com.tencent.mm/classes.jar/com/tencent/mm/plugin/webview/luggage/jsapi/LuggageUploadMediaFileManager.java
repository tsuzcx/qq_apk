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
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.ipc.c;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class LuggageUploadMediaFileManager
{
  private static ProgressDialog gtM = null;
  public com.tencent.mm.plugin.webview.luggage.g ISU;
  public String IWD;
  public boolean IWE;
  public b IWF;
  public String mAppId;
  public MMActivity qdG;
  
  final void gco()
  {
    AppMethodBeat.i(78666);
    if (this.ISU.gbC() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("close_window_confirm_dialog_switch", true);
      localBundle.putString("close_window_confirm_dialog_title_cn", this.qdG.getString(2131768586));
      localBundle.putString("close_window_confirm_dialog_title_eng", this.qdG.getString(2131768586));
      localBundle.putString("close_window_confirm_dialog_ok_cn", this.qdG.getString(2131768582));
      localBundle.putString("close_window_confirm_dialog_ok_eng", this.qdG.getString(2131768582));
      localBundle.putString("close_window_confirm_dialog_cancel_cn", this.qdG.getString(2131768583));
      localBundle.putString("close_window_confirm_dialog_cancel_eng", this.qdG.getString(2131768583));
      this.ISU.gbC().setCloseWindowConfirmInfo(localBundle);
    }
    gcp();
    AppMethodBeat.o(78666);
  }
  
  final void gcp()
  {
    AppMethodBeat.i(78667);
    if (this.IWE)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("local_id", this.IWD);
      ((Bundle)localObject).putString("app_id", this.mAppId);
      ((Bundle)localObject).putBoolean("show_progress_tips", this.IWE);
      b.a(this.qdG, (Bundle)localObject, c.class, new com.tencent.mm.plugin.webview.luggage.ipc.a()
      {
        public final void v(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(78646);
          if (paramAnonymousBundle != null)
          {
            HashMap localHashMap = new HashMap();
            String str = paramAnonymousBundle.getString("media_id");
            paramAnonymousBundle = paramAnonymousBundle.getString("media_url");
            localHashMap.put("serverId", Util.nullAsNil(str));
            localHashMap.put("mediaUrl", Util.nullAsNil(paramAnonymousBundle));
            LuggageUploadMediaFileManager.this.IWF.b(true, localHashMap);
            AppMethodBeat.o(78646);
            return;
          }
          LuggageUploadMediaFileManager.this.IWF.b(false, null);
          AppMethodBeat.o(78646);
        }
      });
      AppMethodBeat.o(78667);
      return;
    }
    Object localObject = new UploadMediaFileTask();
    ((UploadMediaFileTask)localObject).IWP = this.IWD;
    ((UploadMediaFileTask)localObject).appId = this.mAppId;
    ((UploadMediaFileTask)localObject).lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78647);
        this.IWH.bDK();
        LuggageUploadMediaFileManager.b(LuggageUploadMediaFileManager.this);
        if (this.IWH.success)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("serverId", Util.nullAsNil(this.IWH.mediaId));
          localHashMap.put("mediaUrl", Util.nullAsNil(this.IWH.IWQ));
          LuggageUploadMediaFileManager.this.IWF.b(true, localHashMap);
          AppMethodBeat.o(78647);
          return;
        }
        LuggageUploadMediaFileManager.this.IWF.b(false, null);
        AppMethodBeat.o(78647);
      }
    };
    ((UploadMediaFileTask)localObject).bDJ();
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    AppMethodBeat.o(78667);
  }
  
  public static class UploadMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<UploadMediaFileTask> CREATOR;
    private LuggageUploadMediaFileManager.a IWM;
    public String IWP;
    public String IWQ;
    public String appId;
    public Runnable lyv;
    public String mediaId;
    public boolean success;
    
    static
    {
      AppMethodBeat.i(78665);
      CREATOR = new LuggageUploadMediaFileManager.UploadMediaFileTask.2();
      AppMethodBeat.o(78665);
    }
    
    public UploadMediaFileTask() {}
    
    private UploadMediaFileTask(Parcel paramParcel)
    {
      AppMethodBeat.i(78663);
      f(paramParcel);
      AppMethodBeat.o(78663);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(78659);
      Log.i("MicroMsg.UploadMediaTask", "runInMainProcess");
      if (this.IWM == null) {
        this.IWM = new LuggageUploadMediaFileManager.a()
        {
          public final void f(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(78657);
            Log.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.success = paramAnonymousBoolean;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.mediaId = paramAnonymousString1;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.IWQ = paramAnonymousString2;
            LuggageUploadMediaFileManager.UploadMediaFileTask.a(LuggageUploadMediaFileManager.UploadMediaFileTask.this);
            AppMethodBeat.o(78657);
          }
        };
      }
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(this.IWP);
      if (localWebViewJSSDKFileItem == null)
      {
        bDU();
        AppMethodBeat.o(78659);
        return;
      }
      switch (localWebViewJSSDKFileItem.mediaType)
      {
      case 2: 
      case 3: 
      default: 
        LuggageUploadMediaFileManager.a(MMApplicationContext.getContext(), this.appId, this.IWP, com.tencent.mm.i.a.gpV, false, this.IWM);
        AppMethodBeat.o(78659);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(MMApplicationContext.getContext(), localWebViewJSSDKFileItem, this.appId, this.IWP, com.tencent.mm.i.a.gpU, false, this.IWM);
        AppMethodBeat.o(78659);
        return;
      }
      LuggageUploadMediaFileManager.a(MMApplicationContext.getContext(), this.appId, this.IWP, com.tencent.mm.i.a.gpV, false, this.IWM);
      AppMethodBeat.o(78659);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(78660);
      if (this.lyv != null) {
        this.lyv.run();
      }
      AppMethodBeat.o(78660);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(78661);
      this.IWP = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.mediaId = paramParcel.readString();
      this.IWQ = paramParcel.readString();
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
      paramParcel.writeString(this.IWP);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.mediaId);
      paramParcel.writeString(this.IWQ);
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
    public abstract void f(boolean paramBoolean, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void b(boolean paramBoolean, HashMap<String, Object> paramHashMap);
  }
  
  public static class c
    implements c
  {
    private LuggageUploadMediaFileManager.a IWM;
    private com.tencent.mm.plugin.webview.luggage.ipc.a IWN;
    
    public c()
    {
      AppMethodBeat.i(78655);
      this.IWM = new LuggageUploadMediaFileManager.a()
      {
        public final void f(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(78654);
          if (LuggageUploadMediaFileManager.c.a(LuggageUploadMediaFileManager.c.this) != null)
          {
            if (paramAnonymousBoolean)
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("media_id", paramAnonymousString1);
              localBundle.putString("media_url", paramAnonymousString2);
              LuggageUploadMediaFileManager.c.a(LuggageUploadMediaFileManager.c.this).v(localBundle);
              AppMethodBeat.o(78654);
              return;
            }
            LuggageUploadMediaFileManager.c.a(LuggageUploadMediaFileManager.c.this).v(null);
          }
          AppMethodBeat.o(78654);
        }
      };
      AppMethodBeat.o(78655);
    }
    
    public final void a(Context paramContext, Bundle paramBundle, com.tencent.mm.plugin.webview.luggage.ipc.a parama)
    {
      AppMethodBeat.i(78656);
      this.IWN = parama;
      String str1 = paramBundle.getString("local_id");
      String str2 = paramBundle.getString("app_id");
      boolean bool = paramBundle.getBoolean("show_progress_tips");
      paramBundle = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(str1);
      if (paramBundle == null)
      {
        parama.v(null);
        AppMethodBeat.o(78656);
        return;
      }
      switch (paramBundle.mediaType)
      {
      case 2: 
      case 3: 
      default: 
        LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.gpV, bool, this.IWM);
        AppMethodBeat.o(78656);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(paramContext, paramBundle, str2, str1, com.tencent.mm.i.a.gpU, bool, this.IWM);
        AppMethodBeat.o(78656);
        return;
      }
      LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.gpV, bool, this.IWM);
      AppMethodBeat.o(78656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager
 * JD-Core Version:    0.7.0.1
 */