import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.process.AdProcessManagerAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

public class acnv
  implements AdProcessManagerAdapter
{
  public String getMainProcessName()
  {
    return "com.tencent.mobileqq";
  }
  
  public String getWebProcessName()
  {
    return "com.tencent.mobileqq:tool";
  }
  
  public Boolean isOnMainProcess()
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    while (BaseApplicationImpl.getApplication().getRuntime() == null) {
      return null;
    }
    return Boolean.valueOf(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface);
  }
  
  public Boolean isOnWebProcess()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = AdProcessManager.INSTANCE.getCurrentProcessName((Context)localObject);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    return Boolean.valueOf(TextUtils.equals((CharSequence)localObject, AdProcessManager.INSTANCE.getWebProcessName()));
  }
  
  public Boolean isWebProcessRunning()
  {
    Object localObject = isWebProcessRunningForPreloading();
    if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
      return Boolean.valueOf(true);
    }
    localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {}
    for (;;)
    {
      return null;
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        try
        {
          boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
          return Boolean.valueOf(bool);
        }
        catch (Throwable localThrowable)
        {
          acvc.d("GdtProcessManagerAdapter", "isWebProcessRunning", localThrowable);
        }
      }
    }
  }
  
  public Boolean isWebProcessRunningForPreloading()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
    } while ((localObject == null) || (!(localObject instanceof ToolAppRuntime)));
    return Boolean.valueOf(biqx.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnv
 * JD-Core Version:    0.7.0.1
 */