package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.ipc.a;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public final class LuggageUploadMediaFileManager
{
  private static ProgressDialog eeN = null;
  public MMActivity kxD;
  public String mAppId;
  public e uSb;
  public String uUa;
  public boolean uUb;
  public LuggageUploadMediaFileManager.b uUc;
  
  final void dbD()
  {
    AppMethodBeat.i(6414);
    if (this.uSb.daV() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("close_window_confirm_dialog_switch", true);
      localBundle.putString("close_window_confirm_dialog_title_cn", this.kxD.getString(2131305881));
      localBundle.putString("close_window_confirm_dialog_title_eng", this.kxD.getString(2131305881));
      localBundle.putString("close_window_confirm_dialog_ok_cn", this.kxD.getString(2131305877));
      localBundle.putString("close_window_confirm_dialog_ok_eng", this.kxD.getString(2131305877));
      localBundle.putString("close_window_confirm_dialog_cancel_cn", this.kxD.getString(2131305878));
      localBundle.putString("close_window_confirm_dialog_cancel_eng", this.kxD.getString(2131305878));
      this.uSb.daV().setCloseWindowConfirmInfo(localBundle);
    }
    dbE();
    AppMethodBeat.o(6414);
  }
  
  final void dbE()
  {
    AppMethodBeat.i(6415);
    if (this.uUb)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("local_id", this.uUa);
      ((Bundle)localObject).putString("app_id", this.mAppId);
      ((Bundle)localObject).putBoolean("show_progress_tips", this.uUb);
      b.a(this.kxD, (Bundle)localObject, LuggageUploadMediaFileManager.c.class, new a()
      {
        public final void o(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(6394);
          if (paramAnonymousBundle != null)
          {
            HashMap localHashMap = new HashMap();
            String str = paramAnonymousBundle.getString("media_id");
            paramAnonymousBundle = paramAnonymousBundle.getString("media_url");
            localHashMap.put("serverId", bo.nullAsNil(str));
            localHashMap.put("mediaUrl", bo.nullAsNil(paramAnonymousBundle));
            LuggageUploadMediaFileManager.this.uUc.a(true, localHashMap);
            AppMethodBeat.o(6394);
            return;
          }
          LuggageUploadMediaFileManager.this.uUc.a(false, null);
          AppMethodBeat.o(6394);
        }
      });
      AppMethodBeat.o(6415);
      return;
    }
    Object localObject = new LuggageUploadMediaFileManager.UploadMediaFileTask();
    ((LuggageUploadMediaFileManager.UploadMediaFileTask)localObject).uUm = this.uUa;
    ((LuggageUploadMediaFileManager.UploadMediaFileTask)localObject).appId = this.mAppId;
    ((LuggageUploadMediaFileManager.UploadMediaFileTask)localObject).hxp = new LuggageUploadMediaFileManager.4(this, (LuggageUploadMediaFileManager.UploadMediaFileTask)localObject);
    ((LuggageUploadMediaFileManager.UploadMediaFileTask)localObject).aBj();
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    AppMethodBeat.o(6415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager
 * JD-Core Version:    0.7.0.1
 */