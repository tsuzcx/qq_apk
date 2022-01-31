import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class ajeq
  implements EIPCResultCallback
{
  public ajeq(BaseActivity paramBaseActivity) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data == null) {}
    do
    {
      return;
      switch (paramEIPCResult.data.getInt("param_cmd"))
      {
      default: 
        return;
      }
    } while (paramEIPCResult.code != 0);
    paramEIPCResult = paramEIPCResult.data;
    if (QLog.isDevelopLevel())
    {
      int i = paramEIPCResult.getInt("param_proc_badge_count");
      QLog.i("MiniMsgIPCServer", 2, "doRefreshMiniBadge COUNT = " + i);
    }
    this.a.doRefreshMiniBadge(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajeq
 * JD-Core Version:    0.7.0.1
 */