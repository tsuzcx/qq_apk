import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;

public class abvb
  implements View.OnClickListener
{
  public abvb(FlowCameraPhotoActivity paramFlowCameraPhotoActivity) {}
  
  public void onClick(View paramView)
  {
    paramView.setVisibility(8);
    if (this.a.a != null) {
      this.a.a.a(2, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvb
 * JD-Core Version:    0.7.0.1
 */