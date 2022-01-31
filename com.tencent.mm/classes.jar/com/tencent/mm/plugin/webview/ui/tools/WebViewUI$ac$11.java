package com.tencent.mm.plugin.webview.ui.tools;

import android.util.Base64;
import com.tencent.mm.plugin.webview.ui.tools.a.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONArray;
import org.json.JSONObject;

final class WebViewUI$ac$11
  implements Runnable
{
  WebViewUI$ac$11(WebViewUI.ac paramac, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    if (this.rqr.rpH.rbk != null)
    {
      d locald = this.rqr.rpH.rbk;
      String str = this.rpN;
      byte[] arrayOfByte = this.rqs;
      boolean bool1 = this.rqt;
      boolean bool2 = this.rqu;
      if (!locald.ready) {
        y.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
      }
      for (;;)
      {
        return;
        if (arrayOfByte == null) {}
        for (int i = 0;; i = arrayOfByte.length)
        {
          y.i("MicroMsg.JsApiHandler", "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s", new Object[] { str, Boolean.valueOf(bool1), Integer.valueOf(i) });
          if (!bk.bl(str)) {
            break;
          }
          y.e("MicroMsg.JsApiHandler", "parameter error!!!");
          return;
        }
        Object localObject = new JSONObject();
        try
        {
          JSONArray localJSONArray = new JSONArray();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("deviceId", str);
          b.cfk();
          if ((b.bg(arrayOfByte)) || ((arrayOfByte != null) && (bool2))) {
            localJSONObject.put("base64BroadcastData", Base64.encodeToString(arrayOfByte, 2));
          }
          localJSONArray.put(localJSONObject);
          ((JSONObject)localObject).put("devices", localJSONArray);
          if (bool1)
          {
            ((JSONObject)localObject).put("isCompleted", "1");
            localObject = i.a.a("onScanWXDeviceResult", (JSONObject)localObject, locald.rxI, locald.rxJ);
          }
        }
        catch (Exception localException2)
        {
          try
          {
            for (;;)
            {
              y.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", new Object[] { localObject });
              locald.rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
              if (bool2) {
                break;
              }
              b.cfk().rtb = arrayOfByte;
              return;
              ((JSONObject)localObject).put("isCompleted", "0");
            }
            localException2 = localException2;
            y.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", new Object[] { localException2.getMessage() });
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              y.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[] { localException1.getMessage() });
            }
          }
        }
      }
    }
    y.e("MicroMsg.WebViewUI", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[] { this.rqr.rpH.rbk, this.rqr.rpH.gGo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.11
 * JD-Core Version:    0.7.0.1
 */