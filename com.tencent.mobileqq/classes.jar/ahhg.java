import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.CapturePtvTemplateRefreshListener;

public class ahhg
  implements Runnable
{
  public ahhg(CapturePtvTemplateManager paramCapturePtvTemplateManager) {}
  
  public void run()
  {
    CapturePtvTemplateManager.a(this.a);
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahhg
 * JD-Core Version:    0.7.0.1
 */