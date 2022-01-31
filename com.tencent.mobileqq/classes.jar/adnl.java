import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class adnl
  implements Runnable
{
  public adnl(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment", 2, "start preload peak process");
    }
    Intent localIntent;
    if (this.a.getActivity() != null)
    {
      localIntent = new Intent(this.a.getActivity(), PeakService.class);
      if (VideoEnvironment.d(this.a.a)) {
        localIntent.putExtra("ServiceAction", 2);
      }
    }
    try
    {
      this.a.getActivity().startService(localIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NearbyHybridFragment", 1, "preLoadPeak startService ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnl
 * JD-Core Version:    0.7.0.1
 */