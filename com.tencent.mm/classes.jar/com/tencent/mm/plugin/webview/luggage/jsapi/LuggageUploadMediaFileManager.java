package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.ipc.c;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public final class LuggageUploadMediaFileManager
{
  private static ProgressDialog dnm = null;
  public MMActivity iwz;
  public String mAppId;
  public e rcp;
  public String rdX;
  public boolean rdY;
  public LuggageUploadMediaFileManager.b rdZ;
  
  final void cbA()
  {
    if (this.rdY)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("local_id", this.rdX);
      ((Bundle)localObject).putString("app_id", this.mAppId);
      ((Bundle)localObject).putBoolean("show_progress_tips", this.rdY);
      c.a(this.iwz, (Bundle)localObject, LuggageUploadMediaFileManager.c.class, new b()
      {
        public final void g(Bundle paramAnonymousBundle)
        {
          if (paramAnonymousBundle != null)
          {
            HashMap localHashMap = new HashMap();
            String str = paramAnonymousBundle.getString("media_id");
            paramAnonymousBundle = paramAnonymousBundle.getString("media_url");
            localHashMap.put("serverId", bk.pm(str));
            localHashMap.put("mediaUrl", bk.pm(paramAnonymousBundle));
            LuggageUploadMediaFileManager.this.rdZ.a(true, localHashMap);
            return;
          }
          LuggageUploadMediaFileManager.this.rdZ.a(false, null);
        }
      });
      return;
    }
    Object localObject = new LuggageUploadMediaFileManager.UploadMediaFileTask();
    ((LuggageUploadMediaFileManager.UploadMediaFileTask)localObject).rek = this.rdX;
    ((LuggageUploadMediaFileManager.UploadMediaFileTask)localObject).appId = this.mAppId;
    ((LuggageUploadMediaFileManager.UploadMediaFileTask)localObject).gfD = new LuggageUploadMediaFileManager.4(this, (LuggageUploadMediaFileManager.UploadMediaFileTask)localObject);
    ((LuggageUploadMediaFileManager.UploadMediaFileTask)localObject).ahC();
    LuggageMainProcessService.a((MainProcessTask)localObject);
  }
  
  final void cbz()
  {
    if (this.rcp.rbE != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("close_window_confirm_dialog_switch", true);
      localBundle.putString("close_window_confirm_dialog_title_cn", this.iwz.getString(R.l.webview_jssdk_video_uploading_tips));
      localBundle.putString("close_window_confirm_dialog_title_eng", this.iwz.getString(R.l.webview_jssdk_video_uploading_tips));
      localBundle.putString("close_window_confirm_dialog_ok_cn", this.iwz.getString(R.l.webview_jssdk_upload_video_cancel));
      localBundle.putString("close_window_confirm_dialog_ok_eng", this.iwz.getString(R.l.webview_jssdk_upload_video_cancel));
      localBundle.putString("close_window_confirm_dialog_cancel_cn", this.iwz.getString(R.l.webview_jssdk_upload_video_continue));
      localBundle.putString("close_window_confirm_dialog_cancel_eng", this.iwz.getString(R.l.webview_jssdk_upload_video_continue));
      this.rcp.rbE.setCloseWindowConfirmInfo(localBundle);
    }
    cbA();
  }
  
  private static abstract interface a
  {
    public abstract void c(boolean paramBoolean, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager
 * JD-Core Version:    0.7.0.1
 */