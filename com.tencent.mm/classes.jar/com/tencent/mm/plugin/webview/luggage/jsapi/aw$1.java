package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

final class aw$1
  implements b
{
  aw$1(aw paramaw, a.a parama) {}
  
  public final void g(Bundle paramBundle)
  {
    String str = paramBundle.getString("err_msg");
    paramBundle = paramBundle.getString("data");
    if (!bk.bl(str))
    {
      this.kNj.a(str, null);
      return;
    }
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.kNj.a("", paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      this.kNj.a("", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aw.1
 * JD-Core Version:    0.7.0.1
 */