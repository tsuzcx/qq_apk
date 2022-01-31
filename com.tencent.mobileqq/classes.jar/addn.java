import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class addn
  implements Runnable
{
  public addn(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void run()
  {
    ((NearbyHandler)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3)).a((float)NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, (float)NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     addn
 * JD-Core Version:    0.7.0.1
 */