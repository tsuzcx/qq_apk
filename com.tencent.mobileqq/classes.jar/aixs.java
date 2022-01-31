import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.ContainerViewListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.fragment.TribeEffectsCameraCaptureFragment;

public class aixs
  implements ProviderContainerView.ContainerViewListener
{
  public aixs(TribeEffectsCameraCaptureFragment paramTribeEffectsCameraCaptureFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    int j = 1;
    int k = 1;
    int i = 1;
    this.a.a.setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 102: 
      if ("barindex".equals(this.a.e)) {}
      for (paramInt = i;; paramInt = 2)
      {
        ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "Clk_changeface", paramInt, 0, "", "", "", "");
        return;
      }
    case 103: 
      if ("barindex".equals(this.a.e)) {}
      for (paramInt = j;; paramInt = 2)
      {
        ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "Clk_beauty ", paramInt, 0, "", "", "", "");
        return;
      }
    }
    if ("barindex".equals(this.a.e)) {}
    for (paramInt = k;; paramInt = 2)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "Clk_filter ", paramInt, 0, "", "", "", "");
      return;
    }
  }
  
  public void y_()
  {
    this.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixs
 * JD-Core Version:    0.7.0.1
 */