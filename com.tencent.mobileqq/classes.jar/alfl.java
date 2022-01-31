import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable.IWorldCupGameEndCallBack;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.worldcup.ARWorldCupBackConfirmDialog;
import com.tencent.mobileqq.worldcup.ARWorldCupBackConfirmDialog.IBackConfirmDialogCallBack;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager.RenderProxy;

public class alfl
  implements ARWorldCupBackConfirmDialog.IBackConfirmDialogCallBack
{
  public alfl(ARWorldCupGameLogicManager paramARWorldCupGameLogicManager) {}
  
  public void a()
  {
    int i = 2;
    String str;
    if (this.a.a() <= 9) {
      str = "2";
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X8009321", "0X8009321", i, 0, str, "", "", "");
      ARWorldCupGameLogicManager.a(this.a);
      return;
      str = "3";
      i = 3;
    }
  }
  
  public void b()
  {
    int i = 2;
    String str;
    if (this.a.a() <= 9) {
      str = "2";
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X8009322", "0X8009322", i, 0, str, "", "", "");
      if (ARWorldCupGameLogicManager.a(this.a) != null) {
        ARWorldCupGameLogicManager.a(this.a).h();
      }
      ARWorldCupGameLogicManager.a(this.a).dismiss();
      return;
      str = "3";
      i = 3;
    }
  }
  
  public void c()
  {
    int i = 2;
    String str;
    if (this.a.a() <= 9) {
      str = "2";
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X8009323", "0X8009323", i, 0, str, "", "", "");
      ARWorldCupGameLogicManager.a(this.a).dismiss();
      if ((this.a.a() == 13) && (this.a.a != null)) {
        this.a.a.a(13);
      }
      return;
      str = "3";
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfl
 * JD-Core Version:    0.7.0.1
 */