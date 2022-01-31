package com.tencent.ttpic.device;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceAttrs$1
  implements Runnable
{
  DeviceAttrs$1(DeviceAttrs paramDeviceAttrs, String paramString1, String paramString2, String paramString3, UpdateListener paramUpdateListener) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = DeviceAttrs.access$000(this.this$0).getString("xml_version", "0");
    LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] currentVer = " + (String)localObject1);
    localObject1 = NetworkUtils.checkConfigVersion(DeviceAttrs.access$200(this.this$0), this.val$packageName, (String)localObject1, this.val$appId, this.val$appVersion);
    LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] jsonStr = " + (String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        Object localObject2 = ((JSONObject)localObject1).getString("ret");
        LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] retStr = " + (String)localObject2);
        if (((String)localObject2).equals("1"))
        {
          String str = ((JSONObject)localObject1).getString("camCoreConfUrl");
          LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] urlStr = " + str);
          localObject2 = ((JSONObject)localObject1).getString("curCamCoreVersion");
          LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] verStr = " + (String)localObject2);
          Object localObject3 = DeviceAttrs.access$300(this.this$0) + "phone_attrs_config.zip";
          if (NetworkUtils.httpDownloadFile(str, (String)localObject3))
          {
            str = NetworkUtils.unZip((String)localObject3, DeviceAttrs.access$300(this.this$0));
            if (!TextUtils.isEmpty(str))
            {
              LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] unZipfilePath = " + str);
              localObject3 = DeviceAttrs.access$000(this.this$0).edit();
              ((SharedPreferences.Editor)localObject3).putString("xml_version", (String)localObject2);
              ((SharedPreferences.Editor)localObject3).apply();
              localObject2 = TemplateParser.parseCameraAttrsFile(DeviceAttrs.access$400(this.this$0), str, DeviceInstance.getInstance().getDeviceName(), DeviceAttrs.access$500(this.this$0));
              if (localObject2 != null) {
                DeviceAttrs.access$600(this.this$0, (String)localObject2);
              }
              DeviceAttrs.access$700(this.this$0);
              DeviceAttrs.access$800(this.this$0);
              if (this.val$listener != null) {
                this.val$listener.onSuccess(DeviceAttrs.access$200(this.this$0) + ", download and parse success");
              }
              localObject2 = new Intent();
              ((Intent)localObject2).setAction("action_check_online_update_finish");
              DeviceAttrs.access$400(this.this$0).sendBroadcast((Intent)localObject2);
            }
          }
        }
        localObject2 = this.this$0;
        if (((JSONObject)localObject1).optInt("nativeJpegEnable", 1) == 1)
        {
          ((DeviceAttrs)localObject2).serverJpegEnable = bool;
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        LogUtils.e(DeviceAttrs.access$100(), "checkVersion JSONException e = " + localJSONException);
        return;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceAttrs.1
 * JD-Core Version:    0.7.0.1
 */