import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.worldcup.ARWorldCupBackConfirmDialog;
import com.tencent.mobileqq.worldcup.ARWorldCupBackConfirmDialog.IBackConfirmDialogCallBack;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;

public class alfk
  implements ARWorldCupBackConfirmDialog.IBackConfirmDialogCallBack
{
  public alfk(ARWorldCupGameLogicManager paramARWorldCupGameLogicManager) {}
  
  public void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X8009321", "0X8009321", 1, 0, "1", "", "", "");
    ARWorldCupGameLogicManager.a(this.a);
  }
  
  public void b()
  {
    ReportController.b(null, "dc00898", "", "", "0X8009322", "0X8009322", 1, 0, "1", "", "", "");
    ARWorldCupGameLogicManager.a(this.a).dismiss();
  }
  
  public void c()
  {
    ReportController.b(null, "dc00898", "", "", "0X8009323", "0X8009323", 1, 0, "1", "", "", "");
    ARWorldCupGameLogicManager.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfk
 * JD-Core Version:    0.7.0.1
 */