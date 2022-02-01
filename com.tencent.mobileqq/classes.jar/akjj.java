import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akjj
  implements View.OnClickListener
{
  public akjj(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b) {
      bdla.b(this.a.app, "CliOper", "", "", "0X8004D94", "0X8004D94", 0, 0, "", "", "", "");
    }
    this.a.finish();
    AlbumUtil.anim(this.a, true, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjj
 * JD-Core Version:    0.7.0.1
 */