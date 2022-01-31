package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.webview.model.d.a;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements d.a
{
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    y.i("MicroMsg.CdnProgressCallback", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    if (paramBoolean) {
      paramString2 = new JSONObject();
    }
    try
    {
      paramString2.put("localId", paramString1);
      paramString2.put("percent", paramInt2);
      paramString1 = new Bundle();
      paramString1.putString("name", "onMediaFileUploadProgress");
      paramString1.putString("data", paramString2.toString());
      ToolsProcessIPCService.a(paramString1, com.tencent.mm.plugin.webview.luggage.a.a.class);
      return;
    }
    catch (JSONException paramString1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.a
 * JD-Core Version:    0.7.0.1
 */