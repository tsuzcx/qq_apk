import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import eipc.EIPCResult;

public class akpm
  extends VasQuickUpdateManager.CallBacker
{
  public akpm(VasApngIPCModule paramVasApngIPCModule) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 1004L) && ("libAPNG_765".equals(paramString1))) {
      if (paramInt1 != 0) {
        break label90;
      }
    }
    label90:
    for (paramString1 = EIPCResult.createResult(0, null);; paramString1 = EIPCResult.createResult(-102, null))
    {
      this.a.callbackResult(VasApngIPCModule.a(this.a), paramString1);
      if ((BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))) {
        ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(183)).b(this.a.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpm
 * JD-Core Version:    0.7.0.1
 */