import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;

public class ainp
  implements View.OnClickListener
{
  public ainp(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (CameraPreviewActivity.a(this.a, (String)CameraPreviewActivity.a(this.a).get(0))) {
      return;
    }
    if (this.a.b) {
      azqs.b(this.a.app, "CliOper", "", "", "0X8004D96", "0X8004D96", 0, 0, "", "", "", "");
    }
    PhotoUtils.a(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 2, true);
    paramView.setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainp
 * JD-Core Version:    0.7.0.1
 */