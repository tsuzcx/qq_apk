import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3.1;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3.2;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;

public class ahwe
  implements axdh
{
  ahwe(ahwb paramahwb) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    this.a.a.post(new PtvTemplateAdapter.3.2(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    this.a.a.post(new PtvTemplateAdapter.3.1(this, paramPtvTemplateInfo, paramBoolean));
    if (!paramBoolean) {
      ahub.a("", "0X80075BB", "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwe
 * JD-Core Version:    0.7.0.1
 */