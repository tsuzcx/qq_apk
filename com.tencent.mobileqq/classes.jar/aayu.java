import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.ipc.ArMapIPC;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class aayu
  implements EIPCResultCallback
{
  public aayu(ArMapIPC paramArMapIPC) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEIPCResult != null)
    {
      localObject1 = localObject2;
      if (paramEIPCResult.isSuccess()) {
        localObject1 = paramEIPCResult.data.getString("action");
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArMapIPC", 2, "onCallback error");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArMapIPC", 2, "onCallback action:" + (String)localObject1);
    }
    this.a.a((String)localObject1, paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayu
 * JD-Core Version:    0.7.0.1
 */