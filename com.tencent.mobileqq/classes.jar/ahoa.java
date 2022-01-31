import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class ahoa
  implements View.OnClickListener
{
  public ahoa(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = CapturePtvTemplateManager.a().a();
    if ((paramView != null) && (!TextUtils.isEmpty(paramView.advertiseWebUrl)))
    {
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramView.advertiseWebUrl);
      this.a.getActivity().startActivity(localIntent);
      CaptureReportUtil.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahoa
 * JD-Core Version:    0.7.0.1
 */