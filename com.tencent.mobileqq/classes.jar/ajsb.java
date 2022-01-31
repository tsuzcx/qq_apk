import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3.1;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3.2;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;

public class ajsb
  implements azcw
{
  ajsb(ajry paramajry) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    this.a.a.post(new PtvTemplateAdapter.3.2(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    this.a.a.post(new PtvTemplateAdapter.3.1(this, paramPtvTemplateInfo, paramBoolean));
    if (!paramBoolean) {
      ajpy.a("", "0X80075BB", "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsb
 * JD-Core Version:    0.7.0.1
 */