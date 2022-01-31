import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public class acow
  implements FMDialogUtil.FMDialogInterface
{
  public acow(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void a()
  {
    UniformDownloadActivity.a(this.a);
  }
  
  public void b()
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acow
 * JD-Core Version:    0.7.0.1
 */