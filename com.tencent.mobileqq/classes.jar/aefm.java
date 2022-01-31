import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class aefm
  implements Runnable
{
  public aefm(int paramInt) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X80088EA", "0X80088EA", this.a, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefm
 * JD-Core Version:    0.7.0.1
 */