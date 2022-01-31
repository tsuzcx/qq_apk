import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.MomentDataChangeObserver;
import java.util.Iterator;
import java.util.List;

public class afky
  implements Runnable
{
  public afky(NearbyMomentManager paramNearbyMomentManager, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = NearbyMomentManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager).iterator();
    while (localIterator.hasNext())
    {
      ((NearbyMomentManager.MomentDataChangeObserver)localIterator.next()).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
      NearbyMomentManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afky
 * JD-Core Version:    0.7.0.1
 */