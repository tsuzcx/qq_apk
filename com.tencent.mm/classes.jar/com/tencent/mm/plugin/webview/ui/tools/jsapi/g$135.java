package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.modeltools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.util.HashMap;
import org.json.JSONObject;

final class g$135
  implements e.a
{
  g$135(g paramg, i parami) {}
  
  public final void CF(String paramString)
  {
    AppMethodBeat.i(155050);
    this.vqm.a(this.vqQ, "chooseIdCard:fail", null);
    AppMethodBeat.o(155050);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap)
  {
    AppMethodBeat.i(155048);
    if (paramBitmap == null)
    {
      this.vqm.a(this.vqQ, "chooseIdCard:fail", null);
      AppMethodBeat.o(155048);
      return;
    }
    try
    {
      paramString = com.tencent.mm.compatible.util.e.eQv + "tmpScanLicense/";
      ab.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapDir: %s", new Object[] { paramString });
      if (com.tencent.mm.vfs.e.cN(paramString)) {
        com.tencent.mm.vfs.e.O(paramString, true);
      }
      com.tencent.mm.vfs.e.um(paramString);
      com.tencent.mm.vfs.e.avN(paramString);
      paramString = paramString + System.currentTimeMillis() + ".jpg";
      ab.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapPath: %s", new Object[] { paramString });
      d.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
      paramString = WebViewJSSDKFileItem.ahf(paramString);
      com.tencent.mm.plugin.webview.modeltools.g.dcE().a(paramString);
      paramJSONObject = new HashMap();
      paramJSONObject.put("sourceType", "scan");
      paramJSONObject.put("localId", paramString.ctV);
      this.vqm.a(this.vqQ, "chooseIdCard:ok", paramJSONObject);
      AppMethodBeat.o(155048);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.MsgHandler", "save scan license error: %s", new Object[] { paramString.getMessage() });
      this.vqm.a(this.vqQ, "chooseIdCard:fail", null);
      AppMethodBeat.o(155048);
    }
  }
  
  public final void ahA(String paramString)
  {
    AppMethodBeat.i(155049);
    this.vqm.a(this.vqQ, "chooseIdCard:cancel", null);
    AppMethodBeat.o(155049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.135
 * JD-Core Version:    0.7.0.1
 */