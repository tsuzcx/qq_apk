import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ahhu
  implements EIPCResultCallback
{
  ahhu(ahhs paramahhs) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null)) {}
    try
    {
      String str = paramEIPCResult.data.getString("key1");
      paramEIPCResult = paramEIPCResult.data.getString("key2");
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringFestivalRedpacketJsPlugin", 2, "[init] getEmergencyInfo ori prefix:" + str + ",emerUrl:" + paramEIPCResult);
      }
      if (bbft.d.matcher(str).matches()) {
        ahhs.a(this.a, str);
      }
      if (bbft.d.matcher(paramEIPCResult).matches()) {
        ahhs.b(this.a, paramEIPCResult);
      }
    }
    catch (Throwable paramEIPCResult)
    {
      for (;;)
      {
        paramEIPCResult.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketJsPlugin", 2, "[init] getEmergencyInfo final prefix:" + ahhs.a(this.a) + ",mEmerUrl:" + ahhs.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhu
 * JD-Core Version:    0.7.0.1
 */