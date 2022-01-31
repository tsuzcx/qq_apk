package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.modeltools.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class g$37
  implements e.a
{
  g$37(g paramg, String paramString, i parami) {}
  
  public final void SF(String paramString)
  {
    if (!bk.pm(paramString).equals(this.rzM)) {
      return;
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("cardType", paramString);
    g.a(this.rzi, this.rzj, "scanLicence:cancel", localHashMap);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap)
  {
    if (!bk.pm(paramString).equalsIgnoreCase(this.rzM))
    {
      y.i("MicroMsg.MsgHandler", "msg.params.cardType = %s, callback type = %s, mismatch!!!", new Object[] { this.rzM, paramString });
      return;
    }
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.MsgHandler", "doScanLicence, type = %s, callback onSuccess but result is null", new Object[] { paramString });
      uv(paramString);
      return;
    }
    paramBitmap = new HashMap(2);
    paramBitmap.put("cardType", paramString);
    paramBitmap.put("cardInfo", paramJSONObject);
    g.a(this.rzi, this.rzj, "scanLicence:ok", paramBitmap);
  }
  
  public final void uv(String paramString)
  {
    if (!bk.pm(paramString).equals(this.rzM)) {
      return;
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("cardType", paramString);
    g.a(this.rzi, this.rzj, "scanLicence:fail", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.37
 * JD-Core Version:    0.7.0.1
 */