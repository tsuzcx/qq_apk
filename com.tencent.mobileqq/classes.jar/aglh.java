import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;

public class aglh
  implements View.OnClickListener
{
  public aglh(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!CameraPreviewActivity.a(this.a))
    {
      if (this.a.b) {
        axqy.b(this.a.app, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      }
      if (!this.a.b) {
        break label133;
      }
      agqd.d();
    }
    for (;;)
    {
      if ((CameraPreviewActivity.a(this.a) != null) && (CameraPreviewActivity.a(this.a).size() > 0)) {
        bfna.a((String)CameraPreviewActivity.a(this.a).get(0), true);
      }
      PhotoUtils.a(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 0, true);
      paramView.setClickable(false);
      return;
      label133:
      agqd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aglh
 * JD-Core Version:    0.7.0.1
 */