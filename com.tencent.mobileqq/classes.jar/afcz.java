import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.util.ProfilePerformanceReport;

public class afcz
  implements OnDrawCompleteListener
{
  public afcz(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a()
  {
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.b;
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.a()))
    {
      if (!localProfilePerformanceReport.a(1)) {
        localProfilePerformanceReport.b(1);
      }
      if ((!localProfilePerformanceReport.a(8)) && (localProfilePerformanceReport.a(5))) {
        localProfilePerformanceReport.b(8);
      }
      if ((!localProfilePerformanceReport.a(9)) && (localProfilePerformanceReport.a(6))) {
        localProfilePerformanceReport.b(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afcz
 * JD-Core Version:    0.7.0.1
 */