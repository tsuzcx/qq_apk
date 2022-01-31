package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.ipc.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.modeltools.g;

public class LuggageUploadMediaFileManager$c
  implements d
{
  private LuggageUploadMediaFileManager.a reh = new LuggageUploadMediaFileManager.c.1(this);
  private b rei;
  
  public final void a(Context paramContext, Bundle paramBundle, b paramb)
  {
    this.rei = paramb;
    String str1 = paramBundle.getString("local_id");
    String str2 = paramBundle.getString("app_id");
    boolean bool = paramBundle.getBoolean("show_progress_tips");
    paramBundle = g.ccL().Sl(str1);
    if (paramBundle == null)
    {
      paramb.g(null);
      return;
    }
    switch (paramBundle.bLN)
    {
    case 2: 
    case 3: 
    default: 
      LuggageUploadMediaFileManager.a(paramContext, str2, str1, a.dls, bool, this.reh);
      return;
    case 1: 
      LuggageUploadMediaFileManager.a(paramContext, paramBundle, str2, str1, a.dlr, bool, this.reh);
      return;
    }
    LuggageUploadMediaFileManager.a(paramContext, str2, str1, a.dls, bool, this.reh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.c
 * JD-Core Version:    0.7.0.1
 */