import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Arrays;

class abgn
  implements Handler.Callback
{
  abgn(abgm paramabgm) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    boolean bool1 = false;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.a.a();
      return true;
      try
      {
        paramMessage = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        boolean bool2 = bmij.a().a(paramMessage);
        boolean bool3 = NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext());
        boolean bool4 = DeviceInfoUtil.isLowEndPhoneForPreDownload();
        if (FileUtils.getAvailableInnernalMemorySize() <= 1.048576E+008F) {
          bool1 = true;
        }
        abgm.a(this.a, "SmartDeviceProxyMgr check plugin: isInstalled " + bool2 + " isWifiConnected " + bool3 + " lowPhone = " + bool4 + " lowMemory = " + bool1);
        if ((bool2) || (!bool3) || (bool4) || (bool1)) {
          continue;
        }
        bmij.a().a();
        return true;
      }
      catch (Exception paramMessage)
      {
        return true;
      }
      try
      {
        if (abgm.a(this.a) != null)
        {
          paramMessage = new Bundle();
          paramMessage.putString("notify_cmd", "getServerDeviceList");
          paramMessage = abgm.a(this.a).a(paramMessage);
          if (paramMessage != null)
          {
            paramMessage = paramMessage.getParcelableArray("devicelist");
            if (paramMessage != null)
            {
              DeviceInfo[] arrayOfDeviceInfo = new DeviceInfo[paramMessage.length];
              while (i < paramMessage.length)
              {
                arrayOfDeviceInfo[i] = ((DeviceInfo)paramMessage[i]);
                i += 1;
              }
              abgm.a(this.a, arrayOfDeviceInfo);
              if (arrayOfDeviceInfo != null)
              {
                this.a.notifyUI(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
                return true;
              }
            }
          }
        }
      }
      catch (Exception paramMessage) {}
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abgn
 * JD-Core Version:    0.7.0.1
 */