import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class ahgv
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  public ahgv(PtvTemplateAdapter paramPtvTemplateAdapter) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new ahgx(this, paramPtvTemplateInfo, paramInt));
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new ahgw(this, paramPtvTemplateInfo, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahgv
 * JD-Core Version:    0.7.0.1
 */