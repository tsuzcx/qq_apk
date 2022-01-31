package com.tencent.mm.plugin.webview.ui.tools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.a.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONArray;
import org.json.JSONObject;

final class n$15
  implements Runnable
{
  n$15(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(7727);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7727);
      return;
    }
    d locald;
    byte[] arrayOfByte;
    boolean bool2;
    Object localObject;
    if (this.vdp != null)
    {
      locald = this.vdp;
      String str = this.vdy;
      arrayOfByte = this.vdz;
      boolean bool1 = this.vdA;
      bool2 = this.vdB;
      if (!locald.ready)
      {
        ab.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
        AppMethodBeat.o(7727);
        return;
      }
      if (arrayOfByte == null) {}
      for (int i = 0;; i = arrayOfByte.length)
      {
        ab.i("MicroMsg.JsApiHandler", "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s", new Object[] { str, Boolean.valueOf(bool1), Integer.valueOf(i) });
        if (!bo.isNullOrNil(str)) {
          break;
        }
        ab.e("MicroMsg.JsApiHandler", "parameter error!!!");
        AppMethodBeat.o(7727);
        return;
      }
      localObject = new JSONObject();
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("deviceId", str);
        b.dft();
        if ((b.bH(arrayOfByte)) || ((arrayOfByte != null) && (bool2))) {
          localJSONObject.put("base64BroadcastData", Base64.encodeToString(arrayOfByte, 2));
        }
        localJSONArray.put(localJSONObject);
        ((JSONObject)localObject).put("devices", localJSONArray);
        if (!bool1) {
          break label342;
        }
        ((JSONObject)localObject).put("isCompleted", "1");
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            ab.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", new Object[] { localObject });
            locald.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
            if (!bool2) {
              b.dft().vjh = arrayOfByte;
            }
            AppMethodBeat.o(7727);
            return;
            ((JSONObject)localObject).put("isCompleted", "0");
          }
          localException2 = localException2;
          ab.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", new Object[] { localException2.getMessage() });
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ab.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[] { localException1.getMessage() });
          }
        }
      }
      localObject = i.a.a("onScanWXDeviceResult", (JSONObject)localObject, locald.voB, locald.voC);
    }
    label342:
    ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[] { this.vdp, this.vdq });
    AppMethodBeat.o(7727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.15
 * JD-Core Version:    0.7.0.1
 */