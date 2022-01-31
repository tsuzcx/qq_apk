import com.tencent.mobileqq.campuscircle.CampusCircleHandler;
import com.tencent.mobileqq.campuscircle.CampusCircleManager;
import com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

public class abpo
  implements Runnable
{
  public abpo(CampusCirclePublishActivity paramCampusCirclePublishActivity) {}
  
  public void run()
  {
    boolean bool1 = true;
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.a(1, null);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.a.a((List)localObject);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleHandler.a(1);
    try
    {
      boolean bool2 = PtvFilterSoLoad.a(VideoEnvironment.a(), false);
      localObject = this.a;
      if ((VideoEnvironment.b()) && (bool2)) {}
      for (;;)
      {
        ((CampusCirclePublishActivity)localObject).c = bool1;
        if (QLog.isColorLevel()) {
          QLog.i("CampusCircle", 2, String.format(Locale.getDefault(), "initAsync hasFilterSoLib:%b isSurpportFilter:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(this.a.c) }));
        }
        return;
        bool1 = false;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpo
 * JD-Core Version:    0.7.0.1
 */