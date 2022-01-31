package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.sdk.platformtools.y;

public class e
  implements d
{
  public final void a(Context paramContext, Bundle paramBundle, b paramb)
  {
    String str = paramBundle.getString("jsapi_name");
    paramBundle = paramBundle.getString("data");
    if (str == null)
    {
      y.e("MicroMsg.JsApiMMActivityTask", "jsapi is null");
      paramb.g(new Bundle());
      return;
    }
    try
    {
      ((aw)Class.forName(str).newInstance()).a(paramContext, paramBundle, new e.1(this, paramb));
      return;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.JsApiMMActivityTask", paramContext, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.e
 * JD-Core Version:    0.7.0.1
 */