import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.RefreshView.OnRefreshListener;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class adnn
  implements RefreshView.OnRefreshListener
{
  public adnn(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment", 2, "onRefresh");
    }
    this.a.g();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
    if (localSosoLbsInfo == null) {
      localSosoLbsInfo = SosoInterface.b();
    }
    for (;;)
    {
      if (localSosoLbsInfo != null) {
        ((NearbyHandler)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3)).a((float)localSosoLbsInfo.a.b, (float)localSosoLbsInfo.a.a, 5);
      }
      this.a.jdField_a_of_type_ComTencentBizUiRefreshView.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnn
 * JD-Core Version:    0.7.0.1
 */