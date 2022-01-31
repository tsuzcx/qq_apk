import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.MomentDataChangeObserver;
import java.util.Iterator;
import java.util.List;

public class afpp
  implements Runnable
{
  public afpp(NearbyMomentManager paramNearbyMomentManager, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = NearbyMomentManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager).iterator();
    while (localIterator.hasNext())
    {
      ((NearbyMomentManager.MomentDataChangeObserver)localIterator.next()).a(this.jdField_a_of_type_JavaLangString);
      NearbyMomentManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afpp
 * JD-Core Version:    0.7.0.1
 */