import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class akpu
  implements View.OnClickListener
{
  public akpu(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (CameraPreviewActivity.a(this.a, (String)CameraPreviewActivity.a(this.a).get(0))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.b) {
        bdll.b(this.a.app, "CliOper", "", "", "0X8004D96", "0X8004D96", 0, 0, "", "", "", "");
      }
      PhotoUtils.a(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 2, true);
      paramView.setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpu
 * JD-Core Version:    0.7.0.1
 */