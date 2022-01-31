package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class LuggageUploadMediaFileManager$9
  implements DialogInterface.OnKeyListener
{
  LuggageUploadMediaFileManager$9(Context paramContext) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      h.a(this.val$context, true, this.val$context.getString(R.l.webview_jssdk_video_uploading_tips), "", this.val$context.getString(R.l.webview_jssdk_upload_video_cancel), this.val$context.getString(R.l.webview_jssdk_upload_video_continue), new LuggageUploadMediaFileManager.9.1(this), new LuggageUploadMediaFileManager.9.2(this));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.9
 * JD-Core Version:    0.7.0.1
 */