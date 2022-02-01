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
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.ipc.c;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class LuggageUploadMediaFileManager
{
  private static ProgressDialog fpP = null;
  public f ASM;
  public String AVW;
  public boolean AVX;
  public b AVY;
  public String mAppId;
  public MMActivity nCW;
  
  final void elC()
  {
    AppMethodBeat.i(78666);
    if (this.ASM.ekS() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("close_window_confirm_dialog_switch", true);
      localBundle.putString("close_window_confirm_dialog_title_cn", this.nCW.getString(2131766115));
      localBundle.putString("close_window_confirm_dialog_title_eng", this.nCW.getString(2131766115));
      localBundle.putString("close_window_confirm_dialog_ok_cn", this.nCW.getString(2131766111));
      localBundle.putString("close_window_confirm_dialog_ok_eng", this.nCW.getString(2131766111));
      localBundle.putString("close_window_confirm_dialog_cancel_cn", this.nCW.getString(2131766112));
      localBundle.putString("close_window_confirm_dialog_cancel_eng", this.nCW.getString(2131766112));
      this.ASM.ekS().setCloseWindowConfirmInfo(localBundle);
    }
    elD();
    AppMethodBeat.o(78666);
  }
  
  final void elD()
  {
    AppMethodBeat.i(78667);
    if (this.AVX)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("local_id", this.AVW);
      ((Bundle)localObject).putString("app_id", this.mAppId);
      ((Bundle)localObject).putBoolean("show_progress_tips", this.AVX);
      b.a(this.nCW, (Bundle)localObject, c.class, new com.tencent.mm.plugin.webview.luggage.ipc.a()
      {
        public final void q(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(78646);
          if (paramAnonymousBundle != null)
          {
            HashMap localHashMap = new HashMap();
            String str = paramAnonymousBundle.getString("media_id");
            paramAnonymousBundle = paramAnonymousBundle.getString("media_url");
            localHashMap.put("serverId", bt.nullAsNil(str));
            localHashMap.put("mediaUrl", bt.nullAsNil(paramAnonymousBundle));
            LuggageUploadMediaFileManager.this.AVY.a(true, localHashMap);
            AppMethodBeat.o(78646);
            return;
          }
          LuggageUploadMediaFileManager.this.AVY.a(false, null);
          AppMethodBeat.o(78646);
        }
      });
      AppMethodBeat.o(78667);
      return;
    }
    Object localObject = new UploadMediaFileTask();
    ((UploadMediaFileTask)localObject).AWi = this.AVW;
    ((UploadMediaFileTask)localObject).appId = this.mAppId;
    ((UploadMediaFileTask)localObject).jwt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78647);
        this.AWa.aXn();
        LuggageUploadMediaFileManager.b(LuggageUploadMediaFileManager.this);
        if (this.AWa.success)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("serverId", bt.nullAsNil(this.AWa.mediaId));
          localHashMap.put("mediaUrl", bt.nullAsNil(this.AWa.AWj));
          LuggageUploadMediaFileManager.this.AVY.a(true, localHashMap);
          AppMethodBeat.o(78647);
          return;
        }
        LuggageUploadMediaFileManager.this.AVY.a(false, null);
        AppMethodBeat.o(78647);
      }
    };
    ((UploadMediaFileTask)localObject).aXm();
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    AppMethodBeat.o(78667);
  }
  
  public static class UploadMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<UploadMediaFileTask> CREATOR;
    private LuggageUploadMediaFileManager.a AWf;
    public String AWi;
    public String AWj;
    public String appId;
    public Runnable jwt;
    public String mediaId;
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
      e(paramParcel);
      AppMethodBeat.o(78663);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(78660);
      if (this.jwt != null) {
        this.jwt.run();
      }
      AppMethodBeat.o(78660);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(78659);
      ad.i("MicroMsg.UploadMediaTask", "runInMainProcess");
      if (this.AWf == null) {
        this.AWf = new LuggageUploadMediaFileManager.a()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(78657);
            ad.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.success = paramAnonymousBoolean;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.mediaId = paramAnonymousString1;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.AWj = paramAnonymousString2;
            LuggageUploadMediaFileManager.UploadMediaFileTask.a(LuggageUploadMediaFileManager.UploadMediaFileTask.this);
            AppMethodBeat.o(78657);
          }
        };
      }
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.emF().awC(this.AWi);
      if (localWebViewJSSDKFileItem == null)
      {
        aXw();
        AppMethodBeat.o(78659);
        return;
      }
      switch (localWebViewJSSDKFileItem.mediaType)
      {
      case 2: 
      case 3: 
      default: 
        LuggageUploadMediaFileManager.a(aj.getContext(), this.appId, this.AWi, com.tencent.mm.i.a.fne, false, this.AWf);
        AppMethodBeat.o(78659);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(aj.getContext(), localWebViewJSSDKFileItem, this.appId, this.AWi, com.tencent.mm.i.a.fnd, false, this.AWf);
        AppMethodBeat.o(78659);
        return;
      }
      LuggageUploadMediaFileManager.a(aj.getContext(), this.appId, this.AWi, com.tencent.mm.i.a.fne, false, this.AWf);
      AppMethodBeat.o(78659);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(78661);
      this.AWi = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.mediaId = paramParcel.readString();
      this.AWj = paramParcel.readString();
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
      paramParcel.writeString(this.AWi);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.mediaId);
      paramParcel.writeString(this.AWj);
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
    public abstract void d(boolean paramBoolean, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, HashMap<String, Object> paramHashMap);
  }
  
  public static class c
    implements c
  {
    private LuggageUploadMediaFileManager.a AWf;
    private com.tencent.mm.plugin.webview.luggage.ipc.a AWg;
    
    public c()
    {
      AppMethodBeat.i(78655);
      this.AWf = new LuggageUploadMediaFileManager.a()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(78654);
          if (LuggageUploadMediaFileManager.c.a(LuggageUploadMediaFileManager.c.this) != null)
          {
            if (paramAnonymousBoolean)
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("media_id", paramAnonymousString1);
              localBundle.putString("media_url", paramAnonymousString2);
              LuggageUploadMediaFileManager.c.a(LuggageUploadMediaFileManager.c.this).q(localBundle);
              AppMethodBeat.o(78654);
              return;
            }
            LuggageUploadMediaFileManager.c.a(LuggageUploadMediaFileManager.c.this).q(null);
          }
          AppMethodBeat.o(78654);
        }
      };
      AppMethodBeat.o(78655);
    }
    
    public final void a(Context paramContext, Bundle paramBundle, com.tencent.mm.plugin.webview.luggage.ipc.a parama)
    {
      AppMethodBeat.i(78656);
      this.AWg = parama;
      String str1 = paramBundle.getString("local_id");
      String str2 = paramBundle.getString("app_id");
      boolean bool = paramBundle.getBoolean("show_progress_tips");
      paramBundle = g.emF().awC(str1);
      if (paramBundle == null)
      {
        parama.q(null);
        AppMethodBeat.o(78656);
        return;
      }
      switch (paramBundle.mediaType)
      {
      case 2: 
      case 3: 
      default: 
        LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.fne, bool, this.AWf);
        AppMethodBeat.o(78656);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(paramContext, paramBundle, str2, str1, com.tencent.mm.i.a.fnd, bool, this.AWf);
        AppMethodBeat.o(78656);
        return;
      }
      LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.fne, bool, this.AWf);
      AppMethodBeat.o(78656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager
 * JD-Core Version:    0.7.0.1
 */