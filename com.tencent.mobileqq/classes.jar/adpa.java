import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class adpa
  implements Runnable
{
  public adpa(ReportLog paramReportLog, MobileQQ paramMobileQQ) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_MqqAppMobileQQ instanceof BaseApplicationImpl))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)localObject;
        QLog.d("ReportLog", 1, "uncaughtException QQAppInterface exit.");
        ((QQAppInterface)localObject).b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adpa
 * JD-Core Version:    0.7.0.1
 */