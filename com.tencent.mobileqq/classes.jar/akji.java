import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class akji
  implements View.OnClickListener
{
  public akji(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!CameraPreviewActivity.a(this.a))
    {
      if (this.a.b) {
        bdla.b(this.a.app, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      }
      if (!this.a.b) {
        break label140;
      }
      aklj.d();
    }
    for (;;)
    {
      if ((CameraPreviewActivity.a(this.a) != null) && (CameraPreviewActivity.a(this.a).size() > 0)) {
        bkxr.a((String)CameraPreviewActivity.a(this.a).get(0), true);
      }
      PhotoUtils.sendPhoto(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 0, true);
      paramView.setClickable(false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label140:
      aklj.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akji
 * JD-Core Version:    0.7.0.1
 */