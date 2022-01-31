package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.modeltools.e.a;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONObject;

final class g$3
  implements e.a
{
  g$3(g paramg, i parami) {}
  
  public final void SF(String paramString)
  {
    g.a(this.rzi, this.rzj, "chooseIdCard:cancel", null);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      g.a(this.rzi, this.rzj, "chooseIdCard:fail", null);
      return;
    }
    try
    {
      paramString = com.tencent.mm.compatible.util.e.dOP + "tmpScanLicense/";
      y.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapDir: %s", new Object[] { paramString });
      if (com.tencent.mm.vfs.e.bK(paramString)) {
        com.tencent.mm.vfs.e.K(paramString, true);
      }
      com.tencent.mm.vfs.e.nb(paramString);
      com.tencent.mm.vfs.e.aeW(paramString);
      paramString = paramString + System.currentTimeMillis() + ".jpg";
      y.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapPath: %s", new Object[] { paramString });
      c.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
      paramString = WebViewJSSDKFileItem.Si(paramString);
      com.tencent.mm.plugin.webview.modeltools.g.ccL().b(paramString);
      paramJSONObject = new HashMap();
      paramJSONObject.put("sourceType", "scan");
      paramJSONObject.put("localId", paramString.bMB);
      g.a(this.rzi, this.rzj, "chooseIdCard:ok", paramJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.MsgHandler", "save scan license error: %s", new Object[] { paramString.getMessage() });
      g.a(this.rzi, this.rzj, "chooseIdCard:fail", null);
    }
  }
  
  public final void uv(String paramString)
  {
    g.a(this.rzi, this.rzj, "chooseIdCard:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.3
 * JD-Core Version:    0.7.0.1
 */