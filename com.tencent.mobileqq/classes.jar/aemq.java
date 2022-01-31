import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class aemq
  implements DialogInterface.OnClickListener
{
  aemq(aemp paramaemp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      QQToast.a(this.a.a.jdField_a_of_type_AndroidViewView.getContext(), 1, "网络异常，无法操作", 0).a();
      return;
    }
    ((NearbyMomentManager)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).a(this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.g, new aemr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemq
 * JD-Core Version:    0.7.0.1
 */