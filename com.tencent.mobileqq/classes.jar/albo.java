import android.os.Bundle;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class albo
  implements EIPCResultCallback
{
  albo(bdgb parambdgb) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    SoLoadInfo localSoLoadInfo2 = SoLoadInfo.sDefault;
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null)) {}
    for (;;)
    {
      try
      {
        SoLoadInfo localSoLoadInfo1 = (SoLoadInfo)paramEIPCResult.data.getSerializable("res");
        paramEIPCResult = localSoLoadInfo1;
        if (localSoLoadInfo1 == null) {}
        QLog.e("SoLoadWidget.IPC", 1, localThrowable1, new Object[0]);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          paramEIPCResult = SoLoadInfo.sDefault;
          if (this.a != null) {
            this.a.a(paramEIPCResult);
          }
          return;
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            paramEIPCResult = localThrowable1;
            Throwable localThrowable2 = localThrowable3;
          }
        }
        localThrowable1 = localThrowable1;
        paramEIPCResult = localSoLoadInfo2;
      }
      continue;
      paramEIPCResult = localThrowable3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albo
 * JD-Core Version:    0.7.0.1
 */