import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class advr
  extends SosoInterface.OnLocationListener
{
  public advr(NearbyHybridFragment paramNearbyHybridFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString, long paramLong2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    StringBuilder localStringBuilder = new StringBuilder().append("req location finish, errCode=").append(paramInt).append(", timeCost=").append(l).append(", info==null?");
    boolean bool;
    if (paramSosoLbsInfo == null)
    {
      bool = true;
      QLog.d("NearbyHybridFragment.webloading", 1, bool);
      if ((paramInt == 0) && (paramSosoLbsInfo != null)) {
        break label171;
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.c = 1;
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      bool = NetworkUtil.g(BaseApplicationImpl.getContext());
      if (bool) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 1, "获取地理位置失败。", 1).a();
      }
      if (!bool) {
        break label165;
      }
    }
    label165:
    for (paramSosoLbsInfo = "0";; paramSosoLbsInfo = "1")
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", "loc_failed", 0, 0, String.valueOf(paramInt), String.valueOf(l), paramSosoLbsInfo, "");
      return;
      bool = false;
      break;
    }
    label171:
    NearbyHybridFragment.jdField_a_of_type_Long = System.currentTimeMillis();
    NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = paramSosoLbsInfo;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.e();
    ReportController.b(null, "dc00899", "grp_lbs", "", "home", "loc_succ", 0, 0, String.valueOf(paramInt), String.valueOf(l), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advr
 * JD-Core Version:    0.7.0.1
 */