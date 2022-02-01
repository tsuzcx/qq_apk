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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class LuggageUploadMediaFileManager
{
  private static ProgressDialog fts = null;
  public f CkZ;
  public String Coj;
  public boolean Cok;
  public b Col;
  public String mAppId;
  public MMActivity ofX;
  
  final void eAY()
  {
    AppMethodBeat.i(78666);
    if (this.CkZ.eAo() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("close_window_confirm_dialog_switch", true);
      localBundle.putString("close_window_confirm_dialog_title_cn", this.ofX.getString(2131766115));
      localBundle.putString("close_window_confirm_dialog_title_eng", this.ofX.getString(2131766115));
      localBundle.putString("close_window_confirm_dialog_ok_cn", this.ofX.getString(2131766111));
      localBundle.putString("close_window_confirm_dialog_ok_eng", this.ofX.getString(2131766111));
      localBundle.putString("close_window_confirm_dialog_cancel_cn", this.ofX.getString(2131766112));
      localBundle.putString("close_window_confirm_dialog_cancel_eng", this.ofX.getString(2131766112));
      this.CkZ.eAo().setCloseWindowConfirmInfo(localBundle);
    }
    eAZ();
    AppMethodBeat.o(78666);
  }
  
  final void eAZ()
  {
    AppMethodBeat.i(78667);
    if (this.Cok)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("local_id", this.Coj);
      ((Bundle)localObject).putString("app_id", this.mAppId);
      ((Bundle)localObject).putBoolean("show_progress_tips", this.Cok);
      b.a(this.ofX, (Bundle)localObject, c.class, new com.tencent.mm.plugin.webview.luggage.ipc.a()
      {
        public final void q(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(78646);
          if (paramAnonymousBundle != null)
          {
            HashMap localHashMap = new HashMap();
            String str = paramAnonymousBundle.getString("media_id");
            paramAnonymousBundle = paramAnonymousBundle.getString("media_url");
            localHashMap.put("serverId", bs.nullAsNil(str));
            localHashMap.put("mediaUrl", bs.nullAsNil(paramAnonymousBundle));
            LuggageUploadMediaFileManager.this.Col.a(true, localHashMap);
            AppMethodBeat.o(78646);
            return;
          }
          LuggageUploadMediaFileManager.this.Col.a(false, null);
          AppMethodBeat.o(78646);
        }
      });
      AppMethodBeat.o(78667);
      return;
    }
    Object localObject = new UploadMediaFileTask();
    ((UploadMediaFileTask)localObject).Cov = this.Coj;
    ((UploadMediaFileTask)localObject).appId = this.mAppId;
    ((UploadMediaFileTask)localObject).jWP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78647);
        this.Con.bek();
        LuggageUploadMediaFileManager.b(LuggageUploadMediaFileManager.this);
        if (this.Con.success)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("serverId", bs.nullAsNil(this.Con.mediaId));
          localHashMap.put("mediaUrl", bs.nullAsNil(this.Con.Cow));
          LuggageUploadMediaFileManager.this.Col.a(true, localHashMap);
          AppMethodBeat.o(78647);
          return;
        }
        LuggageUploadMediaFileManager.this.Col.a(false, null);
        AppMethodBeat.o(78647);
      }
    };
    ((UploadMediaFileTask)localObject).bej();
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    AppMethodBeat.o(78667);
  }
  
  public static class UploadMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<UploadMediaFileTask> CREATOR;
    private LuggageUploadMediaFileManager.a Cos;
    public String Cov;
    public String Cow;
    public String appId;
    public Runnable jWP;
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
    
    public final void aLq()
    {
      AppMethodBeat.i(78659);
      ac.i("MicroMsg.UploadMediaTask", "runInMainProcess");
      if (this.Cos == null) {
        this.Cos = new LuggageUploadMediaFileManager.a()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(78657);
            ac.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.success = paramAnonymousBoolean;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.mediaId = paramAnonymousString1;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.Cow = paramAnonymousString2;
            LuggageUploadMediaFileManager.UploadMediaFileTask.a(LuggageUploadMediaFileManager.UploadMediaFileTask.this);
            AppMethodBeat.o(78657);
          }
        };
      }
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.eCa().aBU(this.Cov);
      if (localWebViewJSSDKFileItem == null)
      {
        bet();
        AppMethodBeat.o(78659);
        return;
      }
      switch (localWebViewJSSDKFileItem.mediaType)
      {
      case 2: 
      case 3: 
      default: 
        LuggageUploadMediaFileManager.a(ai.getContext(), this.appId, this.Cov, com.tencent.mm.i.a.fqy, false, this.Cos);
        AppMethodBeat.o(78659);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(ai.getContext(), localWebViewJSSDKFileItem, this.appId, this.Cov, com.tencent.mm.i.a.fqx, false, this.Cos);
        AppMethodBeat.o(78659);
        return;
      }
      LuggageUploadMediaFileManager.a(ai.getContext(), this.appId, this.Cov, com.tencent.mm.i.a.fqy, false, this.Cos);
      AppMethodBeat.o(78659);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(78660);
      if (this.jWP != null) {
        this.jWP.run();
      }
      AppMethodBeat.o(78660);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(78661);
      this.Cov = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.mediaId = paramParcel.readString();
      this.Cow = paramParcel.readString();
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
      paramParcel.writeString(this.Cov);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.mediaId);
      paramParcel.writeString(this.Cow);
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
    private LuggageUploadMediaFileManager.a Cos;
    private com.tencent.mm.plugin.webview.luggage.ipc.a Cot;
    
    public c()
    {
      AppMethodBeat.i(78655);
      this.Cos = new LuggageUploadMediaFileManager.a()
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
      this.Cot = parama;
      String str1 = paramBundle.getString("local_id");
      String str2 = paramBundle.getString("app_id");
      boolean bool = paramBundle.getBoolean("show_progress_tips");
      paramBundle = g.eCa().aBU(str1);
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
        LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.fqy, bool, this.Cos);
        AppMethodBeat.o(78656);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(paramContext, paramBundle, str2, str1, com.tencent.mm.i.a.fqx, bool, this.Cos);
        AppMethodBeat.o(78656);
        return;
      }
      LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.fqy, bool, this.Cos);
      AppMethodBeat.o(78656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager
 * JD-Core Version:    0.7.0.1
 */