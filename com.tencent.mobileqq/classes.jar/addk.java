import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class addk
  extends SosoInterface.OnLocationListener
{
  public addk(NearbyHybridFragment paramNearbyHybridFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString, long paramLong2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment.webloading", 2, "req location finish, errCode=" + paramInt + ", cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if ((paramInt != 0) || (paramSosoLbsInfo == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.c = 1;
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      if (NetworkUtil.g(BaseApplicationImpl.getContext())) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 1, "获取地理位置失败。", 1).a();
      }
      return;
    }
    NearbyHybridFragment.jdField_a_of_type_Long = System.currentTimeMillis();
    NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = paramSosoLbsInfo;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     addk
 * JD-Core Version:    0.7.0.1
 */