import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;

public class aijb
  implements View.OnClickListener
{
  public aijb(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!CameraPreviewActivity.a(this.a))
    {
      if (this.a.b) {
        azmj.b(this.a.app, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      }
      if (!this.a.b) {
        break label133;
      }
      aild.d();
    }
    for (;;)
    {
      if ((CameraPreviewActivity.a(this.a) != null) && (CameraPreviewActivity.a(this.a).size() > 0)) {
        bhnu.a((String)CameraPreviewActivity.a(this.a).get(0), true);
      }
      PhotoUtils.a(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 0, true);
      paramView.setClickable(false);
      return;
      label133:
      aild.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijb
 * JD-Core Version:    0.7.0.1
 */