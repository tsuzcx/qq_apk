import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class aeup
  implements Runnable
{
  public aeup(SmallVideoSendFragment paramSmallVideoSendFragment, CharSequence paramCharSequence, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.getActivity() == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.getActivity().isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("PublishActivity", 2, "Activity has been destroy.");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.a.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.a = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.getActivity());
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.a.a(this.jdField_a_of_type_JavaLangCharSequence + "");
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.a.setCancelable(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.a.show();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoSendFragment.a.setOnDismissListener(new aeuq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeup
 * JD-Core Version:    0.7.0.1
 */