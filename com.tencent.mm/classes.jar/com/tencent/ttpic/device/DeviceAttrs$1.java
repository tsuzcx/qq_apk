package com.tencent.ttpic.device;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceAttrs$1
  implements Runnable
{
  DeviceAttrs$1(DeviceAttrs paramDeviceAttrs, String paramString1, String paramString2, String paramString3, DeviceAttrs.UpdateListener paramUpdateListener) {}
  
  public void run()
  {
    boolean bool = true;
    AppMethodBeat.i(49803);
    Object localObject1 = DeviceAttrs.access$000(this.this$0).getString("xml_version", "0");
    LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] currentVer = ".concat(String.valueOf(localObject1)));
    localObject1 = DeviceUpdate.checkConfigVersion(DeviceAttrs.access$200(this.this$0), this.val$packageName, (String)localObject1, this.val$appId, this.val$appVersion);
    LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] jsonStr = ".concat(String.valueOf(localObject1)));
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(49803);
      return;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      Object localObject2 = ((JSONObject)localObject1).getString("ret");
      LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] retStr = ".concat(String.valueOf(localObject2)));
      if (((String)localObject2).equals("1"))
      {
        String str = ((JSONObject)localObject1).getString("camCoreConfUrl");
        LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] urlStr = ".concat(String.valueOf(str)));
        localObject2 = ((JSONObject)localObject1).getString("curCamCoreVersion");
        LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] verStr = ".concat(String.valueOf(localObject2)));
        Object localObject3 = DeviceAttrs.access$300(this.this$0) + "phone_attrs_config.zip";
        if (DeviceUpdate.httpDownloadFile(str, (String)localObject3))
        {
          str = DeviceUpdate.unZip((String)localObject3, DeviceAttrs.access$300(this.this$0));
          if (!TextUtils.isEmpty(str))
          {
            LogUtils.d(DeviceAttrs.access$100(), "[checkVersion] unZipfilePath = ".concat(String.valueOf(str)));
            localObject3 = DeviceAttrs.access$000(this.this$0).edit();
            ((SharedPreferences.Editor)localObject3).putString("xml_version", (String)localObject2);
            ((SharedPreferences.Editor)localObject3).apply();
            localObject2 = DeviceParser.parseCameraAttrsFile(DeviceAttrs.access$400(this.this$0), str, DeviceInstance.getInstance().getDeviceName(), DeviceAttrs.access$500(this.this$0));
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
      if (((JSONObject)localObject1).optInt("nativeJpegEnable", 1) == 1) {}
      for (;;)
      {
        ((DeviceAttrs)localObject2).serverJpegEnable = bool;
        AppMethodBeat.o(49803);
        return;
        bool = false;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      LogUtils.e(DeviceAttrs.access$100(), "checkVersion JSONException e = ".concat(String.valueOf(localJSONException)));
      AppMethodBeat.o(49803);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceAttrs.1
 * JD-Core Version:    0.7.0.1
 */