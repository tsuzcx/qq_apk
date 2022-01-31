import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class ahlm
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  public ahlm(PtvTemplateAdapter paramPtvTemplateAdapter) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new ahlo(this, paramPtvTemplateInfo, paramInt));
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new ahln(this, paramPtvTemplateInfo, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlm
 * JD-Core Version:    0.7.0.1
 */