import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayBasePanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditBasePanel;
import com.tencent.util.ProfilePerformanceReport;

public class aepw
  extends Handler
{
  public aepw(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 101: 
    case 100: 
      do
      {
        do
        {
          return;
          this.a.a();
          ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.b;
          if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.a())) {
            localProfilePerformanceReport.b(5);
          }
        } while (paramMessage.obj == null);
        paramMessage = (NearbyPeopleCard)paramMessage.obj;
        this.a.b = true;
        NearbyPeopleProfileActivity.a(this.a, paramMessage, true, false);
        return;
      } while (NearbyPeopleProfileActivity.a(this.a) == null);
      NearbyPeopleProfileActivity.a(this.a).b();
      return;
    case 102: 
      NearbyPeopleProfileActivity.a(this.a).a(paramMessage.arg1, paramMessage.arg2);
      return;
    case 202: 
      NearbyPeopleProfileActivity.a(this.a).a(true);
      this.a.a.sendEmptyMessageDelayed(203, 1500L);
      return;
    case 203: 
      NearbyPeopleProfileActivity.a(this.a).a(false);
      return;
    case 204: 
      this.a.a(this.a.getString(2131437438));
      return;
    case 207: 
      this.a.a("正在加载...");
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aepw
 * JD-Core Version:    0.7.0.1
 */