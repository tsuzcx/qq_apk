package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public final class LuggageUploadMediaFileManager
{
  private static ProgressDialog fMu = null;
  public com.tencent.mm.plugin.webview.luggage.g DOl;
  public String DRH;
  public boolean DRI;
  public b DRJ;
  public String mAppId;
  public MMActivity oJq;
  
  final void ePQ()
  {
    AppMethodBeat.i(78666);
    if (this.DOl.ePe() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("close_window_confirm_dialog_switch", true);
      localBundle.putString("close_window_confirm_dialog_title_cn", this.oJq.getString(2131766115));
      localBundle.putString("close_window_confirm_dialog_title_eng", this.oJq.getString(2131766115));
      localBundle.putString("close_window_confirm_dialog_ok_cn", this.oJq.getString(2131766111));
      localBundle.putString("close_window_confirm_dialog_ok_eng", this.oJq.getString(2131766111));
      localBundle.putString("close_window_confirm_dialog_cancel_cn", this.oJq.getString(2131766112));
      localBundle.putString("close_window_confirm_dialog_cancel_eng", this.oJq.getString(2131766112));
      this.DOl.ePe().setCloseWindowConfirmInfo(localBundle);
    }
    ePR();
    AppMethodBeat.o(78666);
  }
  
  final void ePR()
  {
    AppMethodBeat.i(78667);
    if (this.DRI)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("local_id", this.DRH);
      ((Bundle)localObject).putString("app_id", this.mAppId);
      ((Bundle)localObject).putBoolean("show_progress_tips", this.DRI);
      b.a(this.oJq, (Bundle)localObject, c.class, new com.tencent.mm.plugin.webview.luggage.ipc.a()
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
            LuggageUploadMediaFileManager.this.DRJ.a(true, localHashMap);
            AppMethodBeat.o(78646);
            return;
          }
          LuggageUploadMediaFileManager.this.DRJ.a(false, null);
          AppMethodBeat.o(78646);
        }
      });
      AppMethodBeat.o(78667);
      return;
    }
    Object localObject = new UploadMediaFileTask();
    ((UploadMediaFileTask)localObject).DRT = this.DRH;
    ((UploadMediaFileTask)localObject).appId = this.mAppId;
    ((UploadMediaFileTask)localObject).krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78647);
        this.DRL.bhO();
        LuggageUploadMediaFileManager.b(LuggageUploadMediaFileManager.this);
        if (this.DRL.success)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("serverId", bt.nullAsNil(this.DRL.mediaId));
          localHashMap.put("mediaUrl", bt.nullAsNil(this.DRL.DRU));
          LuggageUploadMediaFileManager.this.DRJ.a(true, localHashMap);
          AppMethodBeat.o(78647);
          return;
        }
        LuggageUploadMediaFileManager.this.DRJ.a(false, null);
        AppMethodBeat.o(78647);
      }
    };
    ((UploadMediaFileTask)localObject).bhN();
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    AppMethodBeat.o(78667);
  }
  
  public static class UploadMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<UploadMediaFileTask> CREATOR;
    private LuggageUploadMediaFileManager.a DRQ;
    public String DRT;
    public String DRU;
    public String appId;
    public Runnable krg;
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
      e(paramParcel);
      AppMethodBeat.o(78663);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(78659);
      ad.i("MicroMsg.UploadMediaTask", "runInMainProcess");
      if (this.DRQ == null) {
        this.DRQ = new LuggageUploadMediaFileManager.a()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(78657);
            ad.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString1, paramAnonymousString2 });
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.success = paramAnonymousBoolean;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.mediaId = paramAnonymousString1;
            LuggageUploadMediaFileManager.UploadMediaFileTask.this.DRU = paramAnonymousString2;
            LuggageUploadMediaFileManager.UploadMediaFileTask.a(LuggageUploadMediaFileManager.UploadMediaFileTask.this);
            AppMethodBeat.o(78657);
          }
        };
      }
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eQU().aHu(this.DRT);
      if (localWebViewJSSDKFileItem == null)
      {
        bhX();
        AppMethodBeat.o(78659);
        return;
      }
      switch (localWebViewJSSDKFileItem.mediaType)
      {
      case 2: 
      case 3: 
      default: 
        LuggageUploadMediaFileManager.a(aj.getContext(), this.appId, this.DRT, com.tencent.mm.i.a.fIF, false, this.DRQ);
        AppMethodBeat.o(78659);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(aj.getContext(), localWebViewJSSDKFileItem, this.appId, this.DRT, com.tencent.mm.i.a.fIE, false, this.DRQ);
        AppMethodBeat.o(78659);
        return;
      }
      LuggageUploadMediaFileManager.a(aj.getContext(), this.appId, this.DRT, com.tencent.mm.i.a.fIF, false, this.DRQ);
      AppMethodBeat.o(78659);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(78660);
      if (this.krg != null) {
        this.krg.run();
      }
      AppMethodBeat.o(78660);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(78661);
      this.DRT = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.mediaId = paramParcel.readString();
      this.DRU = paramParcel.readString();
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
      paramParcel.writeString(this.DRT);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.mediaId);
      paramParcel.writeString(this.DRU);
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
    public abstract void e(boolean paramBoolean, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, HashMap<String, Object> paramHashMap);
  }
  
  public static class c
    implements c
  {
    private LuggageUploadMediaFileManager.a DRQ;
    private com.tencent.mm.plugin.webview.luggage.ipc.a DRR;
    
    public c()
    {
      AppMethodBeat.i(78655);
      this.DRQ = new LuggageUploadMediaFileManager.a()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2)
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
      this.DRR = parama;
      String str1 = paramBundle.getString("local_id");
      String str2 = paramBundle.getString("app_id");
      boolean bool = paramBundle.getBoolean("show_progress_tips");
      paramBundle = com.tencent.mm.plugin.webview.modeltools.g.eQU().aHu(str1);
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
        LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.fIF, bool, this.DRQ);
        AppMethodBeat.o(78656);
        return;
      case 1: 
        LuggageUploadMediaFileManager.a(paramContext, paramBundle, str2, str1, com.tencent.mm.i.a.fIE, bool, this.DRQ);
        AppMethodBeat.o(78656);
        return;
      }
      LuggageUploadMediaFileManager.a(paramContext, str2, str1, com.tencent.mm.i.a.fIF, bool, this.DRQ);
      AppMethodBeat.o(78656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager
 * JD-Core Version:    0.7.0.1
 */